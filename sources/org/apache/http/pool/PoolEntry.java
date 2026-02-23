package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class PoolEntry {
    private final Object conn;
    private final long created;
    private long expiry;
    private final String id;
    private final Object route;
    private volatile Object state;
    private long updated;
    private final long validityDeadline;

    public PoolEntry(String str, Object obj, Object obj2) {
        this(str, obj, obj2, 0L, TimeUnit.MILLISECONDS);
    }

    public abstract void close();

    public Object getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public String getId() {
        return this.id;
    }

    public Object getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long j) {
        return j >= this.expiry;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public String toString() {
        return "[id:" + this.id + "][route:" + this.route + "][state:" + this.state + "]";
    }

    public synchronized void updateExpiry(long j, TimeUnit timeUnit) {
        try {
            Args.notNull(timeUnit, "Time unit");
            long currentTimeMillis = System.currentTimeMillis();
            this.updated = currentTimeMillis;
            this.expiry = Math.min(j > 0 ? currentTimeMillis + timeUnit.toMillis(j) : Long.MAX_VALUE, this.validityDeadline);
        } catch (Throwable th) {
            throw th;
        }
    }

    public PoolEntry(String str, Object obj, Object obj2, long j, TimeUnit timeUnit) {
        Args.notNull(obj, "Route");
        Args.notNull(obj2, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.id = str;
        this.route = obj;
        this.conn = obj2;
        long currentTimeMillis = System.currentTimeMillis();
        this.created = currentTimeMillis;
        this.updated = currentTimeMillis;
        long j2 = Long.MAX_VALUE;
        if (j > 0) {
            long millis = currentTimeMillis + timeUnit.toMillis(j);
            if (millis > 0) {
                j2 = millis;
            }
        }
        this.validityDeadline = j2;
        this.expiry = this.validityDeadline;
    }
}
