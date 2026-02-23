package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class azc extends AtomicReference implements Runnable {
    private static final Runnable a = new azb(null, 0);
    private static final Runnable b = new azb(null, 0);

    private final void c(Thread thread) {
        Runnable runnable = (Runnable) get();
        aza azaVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof aza)) {
                if (runnable != b) {
                    break;
                }
            } else {
                azaVar = (aza) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(azaVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    public abstract Object a() throws Exception;

    public abstract String b();

    public abstract void d(Throwable th);

    public abstract void e(Object obj);

    public abstract boolean g();

    public final void h() {
        Thread thread = (Runnable) get();
        if (thread instanceof Thread) {
            aza azaVar = new aza(this);
            aza.a(azaVar, Thread.currentThread());
            if (compareAndSet(thread, azaVar)) {
                try {
                    Thread thread2 = thread;
                    thread2.interrupt();
                    if (((Runnable) getAndSet(a)) == b) {
                        LockSupport.unpark(thread2);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(a)) == b) {
                        LockSupport.unpark(thread);
                    }
                    throw th;
                }
            }
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !g();
            if (z) {
                try {
                    obj = a();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(currentThread, a)) {
                            c(currentThread);
                        }
                        d(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(currentThread, a)) {
                            c(currentThread);
                        }
                        e(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(currentThread, a)) {
                c(currentThread);
            }
            if (z) {
                e(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Thread thread = (Runnable) get();
        if (thread == a) {
            str = "running=[DONE]";
        } else if (thread instanceof aza) {
            str = "running=[INTERRUPTED]";
        } else if (thread instanceof Thread) {
            str = "running=[RUNNING ON " + thread.getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + b();
    }
}
