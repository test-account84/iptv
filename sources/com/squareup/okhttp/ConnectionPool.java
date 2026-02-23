package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final ConnectionPool systemDefault;
    private Runnable cleanupRunnable;
    private final Deque connections;
    private final Executor executor;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            while (true) {
                long cleanup = ConnectionPool.this.cleanup(System.nanoTime());
                if (cleanup == -1) {
                    return;
                }
                if (cleanup > 0) {
                    long j = cleanup / 1000000;
                    long j2 = cleanup - (1000000 * j);
                    synchronized (ConnectionPool.this) {
                        try {
                            ConnectionPool.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    static {
        ConnectionPool connectionPool;
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000L;
        if (property == null || Boolean.parseBoolean(property)) {
            connectionPool = property3 != null ? new ConnectionPool(Integer.parseInt(property3), parseLong) : new ConnectionPool(5, parseLong);
        } else {
            connectionPool = new ConnectionPool(0, parseLong);
        }
        systemDefault = connectionPool;
    }

    public ConnectionPool(int i, long j) {
        this(i, j, TimeUnit.MILLISECONDS);
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            if (((Reference) list.get(i)).get() != null) {
                i++;
            } else {
                Internal.logger.warning("A connection to " + realConnection.getRoute().getAddress().url() + " was leaked. Did you forget to close a response body?");
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long cleanup(long j) {
        synchronized (this) {
            try {
                int i = 0;
                long j2 = Long.MIN_VALUE;
                RealConnection realConnection = null;
                int i2 = 0;
                for (RealConnection realConnection2 : this.connections) {
                    if (pruneAndGetAllocationCount(realConnection2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - realConnection2.idleAtNanos;
                        if (j3 > j2) {
                            realConnection = realConnection2;
                            j2 = j3;
                        }
                    }
                }
                long j4 = this.keepAliveDurationNs;
                if (j2 < j4 && i <= this.maxIdleConnections) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    return -1L;
                }
                this.connections.remove(realConnection);
                Util.closeQuietly(realConnection.getSocket());
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.connections.iterator();
                while (it.hasNext()) {
                    RealConnection realConnection = (RealConnection) it.next();
                    if (realConnection.allocations.isEmpty()) {
                        realConnection.noNewStreams = true;
                        arrayList.add(realConnection);
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Util.closeQuietly(((RealConnection) it2.next()).getSocket());
        }
    }

    public RealConnection get(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.size() < realConnection.allocationLimit() && address.equals(realConnection.getRoute().address) && !realConnection.noNewStreams) {
                streamAllocation.acquire(realConnection);
                return realConnection;
            }
        }
        return null;
    }

    public synchronized int getConnectionCount() {
        return this.connections.size();
    }

    public synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    public synchronized int getIdleConnectionCount() {
        int i;
        Iterator it = this.connections.iterator();
        i = 0;
        while (it.hasNext()) {
            if (((RealConnection) it.next()).allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public synchronized int getMultiplexedConnectionCount() {
        int i;
        Iterator it = this.connections.iterator();
        i = 0;
        while (it.hasNext()) {
            if (((RealConnection) it.next()).isMultiplexed()) {
                i++;
            }
        }
        return i;
    }

    @Deprecated
    public synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    public void put(RealConnection realConnection) {
        if (this.connections.isEmpty()) {
            this.executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    public void setCleanupRunnableForTest(Runnable runnable) {
        this.cleanupRunnable = runnable;
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.executor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
        this.cleanupRunnable = new 1();
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }
}
