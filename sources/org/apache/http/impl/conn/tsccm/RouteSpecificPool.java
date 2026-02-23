package org.apache.http.impl.conn.tsccm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RouteSpecificPool {
    protected final ConnPerRoute connPerRoute;
    protected final LinkedList freeEntries;
    private final Log log;
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue waitingThreads;

    public class 1 implements ConnPerRoute {
        public 1() {
        }

        public int getMaxForRoute(HttpRoute httpRoute) {
            return RouteSpecificPool.this.maxEntries;
        }
    }

    @Deprecated
    public RouteSpecificPool(HttpRoute httpRoute, int i) {
        this.log = LogFactory.getLog(getClass());
        this.route = httpRoute;
        this.maxEntries = i;
        this.connPerRoute = new 1();
        this.freeEntries = new LinkedList();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public BasicPoolEntry allocEntry(Object obj) {
        if (!this.freeEntries.isEmpty()) {
            LinkedList linkedList = this.freeEntries;
            ListIterator listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                BasicPoolEntry basicPoolEntry = (BasicPoolEntry) listIterator.previous();
                if (basicPoolEntry.getState() == null || LangUtils.equals(obj, basicPoolEntry.getState())) {
                    listIterator.remove();
                    return basicPoolEntry;
                }
            }
        }
        if (getCapacity() != 0 || this.freeEntries.isEmpty()) {
            return null;
        }
        BasicPoolEntry basicPoolEntry2 = (BasicPoolEntry) this.freeEntries.remove();
        basicPoolEntry2.shutdownEntry();
        try {
            basicPoolEntry2.getConnection().close();
        } catch (IOException e) {
            this.log.debug("I/O error closing connection", e);
        }
        return basicPoolEntry2;
    }

    public void createdEntry(BasicPoolEntry basicPoolEntry) {
        Args.check(this.route.equals(basicPoolEntry.getPlannedRoute()), "Entry not planned for this pool");
        this.numEntries++;
    }

    public boolean deleteEntry(BasicPoolEntry basicPoolEntry) {
        boolean remove = this.freeEntries.remove(basicPoolEntry);
        if (remove) {
            this.numEntries--;
        }
        return remove;
    }

    public void dropEntry() {
        Asserts.check(this.numEntries > 0, "There is no entry that could be dropped");
        this.numEntries--;
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry) {
        int i = this.numEntries;
        if (i < 1) {
            throw new IllegalStateException("No entry created for this pool. " + this.route);
        }
        if (i > this.freeEntries.size()) {
            this.freeEntries.add(basicPoolEntry);
            return;
        }
        throw new IllegalStateException("No entry allocated from this pool. " + this.route);
    }

    public int getCapacity() {
        return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
    }

    public final int getEntryCount() {
        return this.numEntries;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }

    public boolean hasThread() {
        return !this.waitingThreads.isEmpty();
    }

    public boolean isUnused() {
        return this.numEntries < 1 && this.waitingThreads.isEmpty();
    }

    public WaitingThread nextThread() {
        return (WaitingThread) this.waitingThreads.peek();
    }

    public void queueThread(WaitingThread waitingThread) {
        Args.notNull(waitingThread, "Waiting thread");
        this.waitingThreads.add(waitingThread);
    }

    public void removeThread(WaitingThread waitingThread) {
        if (waitingThread == null) {
            return;
        }
        this.waitingThreads.remove(waitingThread);
    }

    public RouteSpecificPool(HttpRoute httpRoute, ConnPerRoute connPerRoute) {
        this.log = LogFactory.getLog(getClass());
        this.route = httpRoute;
        this.connPerRoute = connPerRoute;
        this.maxEntries = connPerRoute.getMaxForRoute(httpRoute);
        this.freeEntries = new LinkedList();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }
}
