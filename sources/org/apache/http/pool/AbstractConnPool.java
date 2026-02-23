package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class AbstractConnPool implements ConnPool, ConnPoolControl {
    private final LinkedList available;
    private final Condition condition;
    private final ConnFactory connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set leased;
    private final Lock lock;
    private final Map maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList pending;
    private final Map routeToPool;
    private volatile int validateAfterInactivity;

    public class 1 extends RouteSpecificPool {
        final /* synthetic */ Object val$route;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(Object obj, Object obj2) {
            super(obj);
            this.val$route = obj2;
        }

        public PoolEntry createEntry(Object obj) {
            return AbstractConnPool.this.createEntry(this.val$route, obj);
        }
    }

    public class 3 implements PoolEntryCallback {
        final /* synthetic */ long val$deadline;

        public 3(long j) {
            this.val$deadline = j;
        }

        public void process(PoolEntry poolEntry) {
            if (poolEntry.getUpdated() <= this.val$deadline) {
                poolEntry.close();
            }
        }
    }

    public class 4 implements PoolEntryCallback {
        final /* synthetic */ long val$now;

        public 4(long j) {
            this.val$now = j;
        }

        public void process(PoolEntry poolEntry) {
            if (poolEntry.isExpired(this.val$now)) {
                poolEntry.close();
            }
        }
    }

    public AbstractConnPool(ConnFactory connFactory, int i, int i2) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i, "Max per route value");
        this.maxTotal = Args.positive(i2, "Max total value");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
        this.maxPerRoute = new HashMap();
    }

    public static /* synthetic */ Lock access$000(AbstractConnPool abstractConnPool) {
        return abstractConnPool.lock;
    }

    public static /* synthetic */ Condition access$100(AbstractConnPool abstractConnPool) {
        return abstractConnPool.condition;
    }

    public static /* synthetic */ PoolEntry access$200(AbstractConnPool abstractConnPool, Object obj, Object obj2, long j, TimeUnit timeUnit, Future future) throws IOException, InterruptedException, TimeoutException {
        return abstractConnPool.getPoolEntryBlocking(obj, obj2, j, timeUnit, future);
    }

    public static /* synthetic */ int access$300(AbstractConnPool abstractConnPool) {
        return abstractConnPool.validateAfterInactivity;
    }

    private int getMax(Object obj) {
        Integer num = (Integer) this.maxPerRoute.get(obj);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    private RouteSpecificPool getPool(Object obj) {
        RouteSpecificPool routeSpecificPool = (RouteSpecificPool) this.routeToPool.get(obj);
        if (routeSpecificPool != null) {
            return routeSpecificPool;
        }
        1 r0 = new 1(obj, obj);
        this.routeToPool.put(obj, r0);
        return r0;
    }

    private PoolEntry getPoolEntryBlocking(Object obj, Object obj2, long j, TimeUnit timeUnit, Future future) throws IOException, InterruptedException, TimeoutException {
        PoolEntry free;
        Date date = j > 0 ? new Date(System.currentTimeMillis() + timeUnit.toMillis(j)) : null;
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(obj);
            while (true) {
                boolean z = true;
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                while (true) {
                    free = pool.getFree(obj2);
                    if (free == null) {
                        break;
                    }
                    if (free.isExpired(System.currentTimeMillis())) {
                        free.close();
                    }
                    if (!free.isClosed()) {
                        break;
                    }
                    this.available.remove(free);
                    pool.free(free, false);
                }
                if (free != null) {
                    this.available.remove(free);
                    this.leased.add(free);
                    onReuse(free);
                    this.lock.unlock();
                    return free;
                }
                int max = getMax(obj);
                int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                if (max2 > 0) {
                    for (int i = 0; i < max2; i++) {
                        PoolEntry lastUsed = pool.getLastUsed();
                        if (lastUsed == null) {
                            break;
                        }
                        lastUsed.close();
                        this.available.remove(lastUsed);
                        pool.remove(lastUsed);
                    }
                }
                if (pool.getAllocatedCount() < max) {
                    int max3 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if (max3 > 0) {
                        if (this.available.size() > max3 - 1 && !this.available.isEmpty()) {
                            PoolEntry poolEntry = (PoolEntry) this.available.removeLast();
                            poolEntry.close();
                            getPool(poolEntry.getRoute()).remove(poolEntry);
                        }
                        PoolEntry add = pool.add(this.connFactory.create(obj));
                        this.leased.add(add);
                        this.lock.unlock();
                        return add;
                    }
                }
                try {
                    if (future.isCancelled()) {
                        throw new InterruptedException("Operation interrupted");
                    }
                    pool.queue(future);
                    this.pending.add(future);
                    if (date != null) {
                        z = this.condition.awaitUntil(date);
                    } else {
                        this.condition.await();
                    }
                    if (future.isCancelled()) {
                        throw new InterruptedException("Operation interrupted");
                    }
                    pool.unqueue(future);
                    this.pending.remove(future);
                    if (!z && date != null && date.getTime() <= System.currentTimeMillis()) {
                        throw new TimeoutException("Timeout waiting for connection");
                    }
                } finally {
                    pool.unqueue(future);
                    this.pending.remove(future);
                }
            }
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    private void purgePoolMap() {
        Iterator it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool routeSpecificPool = (RouteSpecificPool) ((Map.Entry) it.next()).getValue();
            if (routeSpecificPool.getPendingCount() + routeSpecificPool.getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeExpired() {
        enumAvailable(new 4(System.currentTimeMillis()));
    }

    public void closeIdle(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        if (millis < 0) {
            millis = 0;
        }
        enumAvailable(new 3(System.currentTimeMillis() - millis));
    }

    public abstract PoolEntry createEntry(Object obj, Object obj2);

    public void enumAvailable(PoolEntryCallback poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator it = this.available.iterator();
            while (it.hasNext()) {
                PoolEntry poolEntry = (PoolEntry) it.next();
                poolEntryCallback.process(poolEntry);
                if (poolEntry.isClosed()) {
                    getPool(poolEntry.getRoute()).remove(poolEntry);
                    it.remove();
                }
            }
            purgePoolMap();
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void enumLeased(PoolEntryCallback poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator it = this.leased.iterator();
            while (it.hasNext()) {
                poolEntryCallback.process((PoolEntry) it.next());
            }
        } finally {
            this.lock.unlock();
        }
    }

    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    public int getMaxPerRoute(Object obj) {
        Args.notNull(obj, "Route");
        this.lock.lock();
        try {
            return getMax(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    public Set getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    public PoolStats getStats(Object obj) {
        Args.notNull(obj, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(obj);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(obj));
        } finally {
            this.lock.unlock();
        }
    }

    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public Future lease(Object obj, Object obj2) {
        return lease(obj, obj2, null);
    }

    public void onLease(PoolEntry poolEntry) {
    }

    public void onRelease(PoolEntry poolEntry) {
    }

    public void onReuse(PoolEntry poolEntry) {
    }

    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    public void setMaxPerRoute(Object obj, int i) {
        Args.notNull(obj, "Route");
        this.lock.lock();
        try {
            if (i > -1) {
                this.maxPerRoute.put(obj, Integer.valueOf(i));
            } else {
                this.maxPerRoute.remove(obj);
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void setMaxTotal(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    public void setValidateAfterInactivity(int i) {
        this.validateAfterInactivity = i;
    }

    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator it = this.available.iterator();
            while (it.hasNext()) {
                ((PoolEntry) it.next()).close();
            }
            Iterator it2 = this.leased.iterator();
            while (it2.hasNext()) {
                ((PoolEntry) it2.next()).close();
            }
            Iterator it3 = this.routeToPool.values().iterator();
            while (it3.hasNext()) {
                ((RouteSpecificPool) it3.next()).shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public String toString() {
        return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
    }

    public boolean validate(PoolEntry poolEntry) {
        return true;
    }

    public class 2 implements Future {
        private final AtomicBoolean cancelled = new AtomicBoolean(false);
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final AtomicReference entryRef = new AtomicReference((Object) null);
        final /* synthetic */ FutureCallback val$callback;
        final /* synthetic */ Object val$route;
        final /* synthetic */ Object val$state;

        public 2(FutureCallback futureCallback, Object obj, Object obj2) {
            this.val$callback = futureCallback;
            this.val$route = obj;
            this.val$state = obj2;
        }

        public boolean cancel(boolean z) {
            if (!this.cancelled.compareAndSet(false, true)) {
                return false;
            }
            this.done.set(true);
            AbstractConnPool.access$000(AbstractConnPool.this).lock();
            try {
                AbstractConnPool.access$100(AbstractConnPool.this).signalAll();
                AbstractConnPool.access$000(AbstractConnPool.this).unlock();
                FutureCallback futureCallback = this.val$callback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
                return true;
            } catch (Throwable th) {
                AbstractConnPool.access$000(AbstractConnPool.this).unlock();
                throw th;
            }
        }

        public boolean isCancelled() {
            return this.cancelled.get();
        }

        public boolean isDone() {
            return this.done.get();
        }

        public PoolEntry get() throws InterruptedException, ExecutionException {
            try {
                return get(0L, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                throw new ExecutionException(e);
            }
        }

        public PoolEntry get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            PoolEntry access$200;
            PoolEntry poolEntry = (PoolEntry) this.entryRef.get();
            if (poolEntry != null) {
                return poolEntry;
            }
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            access$200 = AbstractConnPool.access$200(AbstractConnPool.this, this.val$route, this.val$state, j, timeUnit, this);
                            if (AbstractConnPool.access$300(AbstractConnPool.this) <= 0 || access$200.getUpdated() + AbstractConnPool.access$300(AbstractConnPool.this) > System.currentTimeMillis() || AbstractConnPool.this.validate(access$200)) {
                                break;
                            }
                            access$200.close();
                            AbstractConnPool.this.release(access$200, false);
                        } catch (IOException e) {
                            this.done.set(true);
                            FutureCallback futureCallback = this.val$callback;
                            if (futureCallback != null) {
                                futureCallback.failed(e);
                            }
                            throw new ExecutionException(e);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.entryRef.set(access$200);
                this.done.set(true);
                AbstractConnPool.this.onLease(access$200);
                FutureCallback futureCallback2 = this.val$callback;
                if (futureCallback2 != null) {
                    futureCallback2.completed(access$200);
                }
            }
            return access$200;
        }
    }

    public Future lease(Object obj, Object obj2, FutureCallback futureCallback) {
        Args.notNull(obj, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return new 2(futureCallback, obj, obj2);
    }

    public void release(PoolEntry poolEntry, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(poolEntry)) {
                RouteSpecificPool pool = getPool(poolEntry.getRoute());
                pool.free(poolEntry, z);
                if (!z || this.isShutDown) {
                    poolEntry.close();
                } else {
                    this.available.addFirst(poolEntry);
                }
                onRelease(poolEntry);
                Future nextPending = pool.nextPending();
                if (nextPending != null) {
                    this.pending.remove(nextPending);
                } else {
                    nextPending = (Future) this.pending.poll();
                }
                if (nextPending != null) {
                    this.condition.signalAll();
                }
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }
}
