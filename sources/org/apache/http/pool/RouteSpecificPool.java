package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class RouteSpecificPool {
    private final Object route;
    private final Set leased = new HashSet();
    private final LinkedList available = new LinkedList();
    private final LinkedList pending = new LinkedList();

    public RouteSpecificPool(Object obj) {
        this.route = obj;
    }

    public PoolEntry add(Object obj) {
        PoolEntry createEntry = createEntry(obj);
        this.leased.add(createEntry);
        return createEntry;
    }

    public abstract PoolEntry createEntry(Object obj);

    public void free(PoolEntry poolEntry, boolean z) {
        Args.notNull(poolEntry, "Pool entry");
        Asserts.check(this.leased.remove(poolEntry), "Entry %s has not been leased from this pool", poolEntry);
        if (z) {
            this.available.addFirst(poolEntry);
        }
    }

    public int getAllocatedCount() {
        return this.available.size() + this.leased.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public PoolEntry getFree(Object obj) {
        if (this.available.isEmpty()) {
            return null;
        }
        if (obj != null) {
            Iterator it = this.available.iterator();
            while (it.hasNext()) {
                PoolEntry poolEntry = (PoolEntry) it.next();
                if (obj.equals(poolEntry.getState())) {
                    it.remove();
                    this.leased.add(poolEntry);
                    return poolEntry;
                }
            }
        }
        Iterator it2 = this.available.iterator();
        while (it2.hasNext()) {
            PoolEntry poolEntry2 = (PoolEntry) it2.next();
            if (poolEntry2.getState() == null) {
                it2.remove();
                this.leased.add(poolEntry2);
                return poolEntry2;
            }
        }
        return null;
    }

    public PoolEntry getLastUsed() {
        if (this.available.isEmpty()) {
            return null;
        }
        return (PoolEntry) this.available.getLast();
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final Object getRoute() {
        return this.route;
    }

    public Future nextPending() {
        return (Future) this.pending.poll();
    }

    public void queue(Future future) {
        if (future == null) {
            return;
        }
        this.pending.add(future);
    }

    public boolean remove(PoolEntry poolEntry) {
        Args.notNull(poolEntry, "Pool entry");
        return this.available.remove(poolEntry) || this.leased.remove(poolEntry);
    }

    public void shutdown() {
        Iterator it = this.pending.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.pending.clear();
        Iterator it2 = this.available.iterator();
        while (it2.hasNext()) {
            ((PoolEntry) it2.next()).close();
        }
        this.available.clear();
        Iterator it3 = this.leased.iterator();
        while (it3.hasNext()) {
            ((PoolEntry) it3.next()).close();
        }
        this.leased.clear();
    }

    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }

    public void unqueue(Future future) {
        if (future == null) {
            return;
        }
        this.pending.remove(future);
    }
}
