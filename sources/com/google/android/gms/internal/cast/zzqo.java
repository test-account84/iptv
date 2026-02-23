package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzqo extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzqn(null);
    private static final Runnable zzb = new zzqn(null);

    private final void zzg(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzql zzqlVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzql)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzqlVar = (zzql) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzqlVar);
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

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !zzf();
            if (z) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(currentThread, zza)) {
                            zzg(currentThread);
                        }
                        zzc(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(currentThread, zza)) {
                            zzg(currentThread);
                        }
                        zzd(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzg(currentThread);
            }
            if (z) {
                zzd(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Thread thread = (Runnable) get();
        if (thread == zza) {
            str = "running=[DONE]";
        } else if (thread instanceof zzql) {
            str = "running=[INTERRUPTED]";
        } else if (thread instanceof Thread) {
            str = "running=[RUNNING ON " + thread.getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + zzb();
    }

    public abstract Object zza() throws Exception;

    public abstract String zzb();

    public abstract void zzc(Throwable th);

    public abstract void zzd(Object obj);

    public final void zze() {
        Thread thread = (Runnable) get();
        if (thread instanceof Thread) {
            zzql zzqlVar = new zzql(this, null);
            zzql.zza(zzqlVar, Thread.currentThread());
            if (compareAndSet(thread, zzqlVar)) {
                try {
                    Thread thread2 = thread;
                    thread2.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread2);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                    throw th;
                }
            }
        }
    }

    public abstract boolean zzf();
}
