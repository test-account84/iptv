package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k8.q;
import kotlin.jvm.internal.l;
import l8.s;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;

    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque readyAsyncCalls;
    private final ArrayDeque runningAsyncCalls;
    private final ArrayDeque runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
            if (l.a(asyncCall.getHost(), str)) {
                return asyncCall;
            }
        }
        Iterator it2 = this.readyAsyncCalls.iterator();
        while (it2.hasNext()) {
            RealCall.AsyncCall asyncCall2 = (RealCall.AsyncCall) it2.next();
            if (l.a(asyncCall2.getHost(), str)) {
                return asyncCall2;
            }
        }
        return null;
    }

    private final void finished(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.idleCallback;
            q qVar = q.a;
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean promoteAndExecute() {
        int i;
        boolean z;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.readyAsyncCalls.iterator();
                l.d(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    }
                    if (asyncCall.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        asyncCall.getCallsPerHost().incrementAndGet();
                        l.d(asyncCall, "asyncCall");
                        arrayList.add(asyncCall);
                        this.runningAsyncCalls.add(asyncCall);
                    }
                }
                z = runningCallsCount() > 0;
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
        }
        return z;
    }

    @NotNull
    public final ExecutorService -deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        try {
            Iterator it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                ((RealCall.AsyncCall) it.next()).getCall().cancel();
            }
            Iterator it2 = this.runningAsyncCalls.iterator();
            while (it2.hasNext()) {
                ((RealCall.AsyncCall) it2.next()).getCall().cancel();
            }
            Iterator it3 = this.runningSyncCalls.iterator();
            while (it3.hasNext()) {
                ((RealCall) it3.next()).cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall call) {
        RealCall.AsyncCall findExistingCallWithHost;
        l.e(call, "call");
        synchronized (this) {
            try {
                this.readyAsyncCalls.add(call);
                if (!call.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(call.getHost())) != null) {
                    call.reuseCallsPerHostFrom(findExistingCallWithHost);
                }
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(@NotNull RealCall call) {
        l.e(call, "call");
        this.runningSyncCalls.add(call);
    }

    @NotNull
    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        try {
            if (this.executorServiceOrNull == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory(Util.okHttpName + " Dispatcher", false));
            }
            executorService = this.executorServiceOrNull;
            l.b(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall call) {
        l.e(call, "call");
        call.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, call);
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @NotNull
    public final synchronized List queuedCalls() {
        List unmodifiableList;
        try {
            ArrayDeque arrayDeque = this.readyAsyncCalls;
            ArrayList arrayList = new ArrayList(l8.l.o(arrayDeque, 10));
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
            l.d(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    @NotNull
    public final synchronized List runningCalls() {
        List unmodifiableList;
        try {
            ArrayDeque arrayDeque = this.runningSyncCalls;
            ArrayDeque arrayDeque2 = this.runningAsyncCalls;
            ArrayList arrayList = new ArrayList(l8.l.o(arrayDeque2, 10));
            Iterator it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            unmodifiableList = Collections.unmodifiableList(s.D(arrayDeque, arrayList));
            l.d(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i) {
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + i).toString());
        }
        synchronized (this) {
            this.maxRequests = i;
            q qVar = q.a;
        }
        promoteAndExecute();
    }

    public final void setMaxRequestsPerHost(int i) {
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + i).toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = i;
            q qVar = q.a;
        }
        promoteAndExecute();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(@NotNull ExecutorService executorService) {
        this();
        l.e(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }

    public final void finished$okhttp(@NotNull RealCall call) {
        l.e(call, "call");
        finished(this.runningSyncCalls, call);
    }
}
