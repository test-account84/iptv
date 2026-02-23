package org.apache.http.impl.client;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.util.Args;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class IdleConnectionEvictor {
    private final HttpClientConnectionManager connectionManager;
    private volatile Exception exception;
    private final long maxIdleTimeMs;
    private final long sleepTimeMs;
    private final Thread thread;
    private final ThreadFactory threadFactory;

    public class 1 implements Runnable {
        final /* synthetic */ HttpClientConnectionManager val$connectionManager;

        public 1(HttpClientConnectionManager httpClientConnectionManager) {
            this.val$connectionManager = httpClientConnectionManager;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(IdleConnectionEvictor.access$000(IdleConnectionEvictor.this));
                    this.val$connectionManager.closeExpiredConnections();
                    if (IdleConnectionEvictor.access$100(IdleConnectionEvictor.this) > 0) {
                        this.val$connectionManager.closeIdleConnections(IdleConnectionEvictor.access$100(IdleConnectionEvictor.this), TimeUnit.MILLISECONDS);
                    }
                } catch (Exception e) {
                    IdleConnectionEvictor.access$202(IdleConnectionEvictor.this, e);
                    return;
                }
            }
        }
    }

    public static class DefaultThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Connection evictor");
            thread.setDaemon(true);
            return thread;
        }
    }

    public IdleConnectionEvictor(HttpClientConnectionManager httpClientConnectionManager, long j, TimeUnit timeUnit) {
        this(httpClientConnectionManager, null, j > 0 ? j : 5L, timeUnit != null ? timeUnit : TimeUnit.SECONDS, j, timeUnit);
    }

    public static /* synthetic */ long access$000(IdleConnectionEvictor idleConnectionEvictor) {
        return idleConnectionEvictor.sleepTimeMs;
    }

    public static /* synthetic */ long access$100(IdleConnectionEvictor idleConnectionEvictor) {
        return idleConnectionEvictor.maxIdleTimeMs;
    }

    public static /* synthetic */ Exception access$202(IdleConnectionEvictor idleConnectionEvictor, Exception exc) {
        idleConnectionEvictor.exception = exc;
        return exc;
    }

    public void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        Thread thread = this.thread;
        if (timeUnit == null) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        thread.join(timeUnit.toMillis(j));
    }

    public boolean isRunning() {
        return this.thread.isAlive();
    }

    public void shutdown() {
        this.thread.interrupt();
    }

    public void start() {
        this.thread.start();
    }

    public IdleConnectionEvictor(HttpClientConnectionManager httpClientConnectionManager, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        this(httpClientConnectionManager, null, j, timeUnit, j2, timeUnit2);
    }

    public IdleConnectionEvictor(HttpClientConnectionManager httpClientConnectionManager, ThreadFactory threadFactory, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        this.connectionManager = (HttpClientConnectionManager) Args.notNull(httpClientConnectionManager, "Connection manager");
        threadFactory = threadFactory == null ? new DefaultThreadFactory() : threadFactory;
        this.threadFactory = threadFactory;
        this.sleepTimeMs = timeUnit != null ? timeUnit.toMillis(j) : j;
        this.maxIdleTimeMs = timeUnit2 != null ? timeUnit2.toMillis(j2) : j2;
        this.thread = threadFactory.newThread(new 1(httpClientConnectionManager));
    }
}
