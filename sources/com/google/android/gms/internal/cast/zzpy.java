package com.google.android.gms.internal.cast;

import java.lang.reflect.AccessibleObject;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
import y5.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzpy extends zzqx implements b {
    static final boolean zza;
    private static final Logger zzb;
    private static final zza zzc;
    private static final Object zzd;
    private volatile zzd listeners;
    private volatile Object value;
    private volatile zzk waiters;

    abstract class zza {
        public /* synthetic */ zza(zzpx zzpxVar) {
        }

        public abstract zzd zza(zzpy zzpyVar, zzd zzdVar);

        public abstract zzk zzb(zzpy zzpyVar, zzk zzkVar);

        public abstract void zzc(zzk zzkVar, zzk zzkVar2);

        public abstract void zzd(zzk zzkVar, Thread thread);

        public abstract boolean zze(zzpy zzpyVar, zzd zzdVar, zzd zzdVar2);

        public abstract boolean zzf(zzpy zzpyVar, Object obj, Object obj2);

        public abstract boolean zzg(zzpy zzpyVar, zzk zzkVar, zzk zzkVar2);
    }

    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzpy.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        public zzb(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    final class zzc {
        static final zzc zza = new zzc(new 1("Failure occurred while trying to finish a future."));
        final Throwable zzb;

        public class 1 extends Throwable {
            public 1(String str) {
                super("Failure occurred while trying to finish a future.");
            }

            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    final class zze extends zza {
        final AtomicReferenceFieldUpdater zza;
        final AtomicReferenceFieldUpdater zzb;
        final AtomicReferenceFieldUpdater zzc;
        final AtomicReferenceFieldUpdater zzd;
        final AtomicReferenceFieldUpdater zze;

        public zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        public final zzd zza(zzpy zzpyVar, zzd zzdVar) {
            return (zzd) this.zzd.getAndSet(zzpyVar, zzdVar);
        }

        public final zzk zzb(zzpy zzpyVar, zzk zzkVar) {
            return (zzk) this.zzc.getAndSet(zzpyVar, zzkVar);
        }

        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        public final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        public final boolean zze(zzpy zzpyVar, zzd zzdVar, zzd zzdVar2) {
            return zzpz.zza(this.zzd, zzpyVar, zzdVar, zzdVar2);
        }

        public final boolean zzf(zzpy zzpyVar, Object obj, Object obj2) {
            return zzpz.zza(this.zze, zzpyVar, obj, obj2);
        }

        public final boolean zzg(zzpy zzpyVar, zzk zzkVar, zzk zzkVar2) {
            return zzpz.zza(this.zzc, zzpyVar, zzkVar, zzkVar2);
        }
    }

    final class zzf implements Runnable {
        final zzpy zza;
        final b zzb;

        public final void run() {
            throw null;
        }
    }

    final class zzg extends zza {
        private zzg() {
            super(null);
        }

        public final zzd zza(zzpy zzpyVar, zzd zzdVar) {
            zzd zzb;
            synchronized (zzpyVar) {
                try {
                    zzb = zzpy.zzb(zzpyVar);
                    if (zzb != zzdVar) {
                        zzpy.zzg(zzpyVar, zzdVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzb;
        }

        public final zzk zzb(zzpy zzpyVar, zzk zzkVar) {
            zzk zzc;
            synchronized (zzpyVar) {
                try {
                    zzc = zzpy.zzc(zzpyVar);
                    if (zzc != zzkVar) {
                        zzpy.zzi(zzpyVar, zzkVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzc;
        }

        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        public final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        public final boolean zze(zzpy zzpyVar, zzd zzdVar, zzd zzdVar2) {
            synchronized (zzpyVar) {
                try {
                    if (zzpy.zzb(zzpyVar) != zzdVar) {
                        return false;
                    }
                    zzpy.zzg(zzpyVar, zzdVar2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean zzf(zzpy zzpyVar, Object obj, Object obj2) {
            synchronized (zzpyVar) {
                try {
                    if (zzpy.zzd(zzpyVar) != obj) {
                        return false;
                    }
                    zzpy.zzh(zzpyVar, obj2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean zzg(zzpy zzpyVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzpyVar) {
                try {
                    if (zzpy.zzc(zzpyVar) != zzkVar) {
                        return false;
                    }
                    zzpy.zzi(zzpyVar, zzkVar2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ zzg(zzqa zzqaVar) {
            super(null);
        }
    }

    interface zzh extends b {
        /* synthetic */ void addListener(Runnable runnable, Executor executor);
    }

    abstract class zzi extends zzpy implements zzh {
    }

    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        public class 1 implements PrivilegedExceptionAction {
            public final /* bridge */ /* synthetic */ Object run() throws Exception {
                for (AccessibleObject accessibleObject : Unsafe.class.getDeclaredFields()) {
                    accessibleObject.setAccessible(true);
                    Object obj = accessibleObject.get((Object) null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new 1());
            }
            try {
                zzc = unsafe.objectFieldOffset(zzpy.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzpy.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzpy.class.getDeclaredField("value"));
                zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }

        private zzj() {
            super(null);
        }

        public final zzd zza(zzpy zzpyVar, zzd zzdVar) {
            zzd zzb2;
            do {
                zzb2 = zzpy.zzb(zzpyVar);
                if (zzdVar == zzb2) {
                    return zzb2;
                }
            } while (!zze(zzpyVar, zzb2, zzdVar));
            return zzb2;
        }

        public final zzk zzb(zzpy zzpyVar, zzk zzkVar) {
            zzk zzc2;
            do {
                zzc2 = zzpy.zzc(zzpyVar);
                if (zzkVar == zzc2) {
                    return zzc2;
                }
            } while (!zzg(zzpyVar, zzc2, zzkVar));
            return zzc2;
        }

        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        public final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        public final boolean zze(zzpy zzpyVar, zzd zzdVar, zzd zzdVar2) {
            return zzqb.zza(zza, zzpyVar, zzb, zzdVar, zzdVar2);
        }

        public final boolean zzf(zzpy zzpyVar, Object obj, Object obj2) {
            return zzqb.zza(zza, zzpyVar, zzd, obj, obj2);
        }

        public final boolean zzg(zzpy zzpyVar, zzk zzkVar, zzk zzkVar2) {
            return zzqb.zza(zza, zzpyVar, zzc, zzkVar, zzkVar2);
        }

        public /* synthetic */ zzj(zzqc zzqcVar) {
            super(null);
        }
    }

    final class zzk {
        static final zzk zza = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        public zzk() {
            zzpy.zza().zzd(this, Thread.currentThread());
        }

        public zzk(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzgVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zza = z;
        zzb = Logger.getLogger(zzpy.class.getName());
        try {
            zzgVar = new zzj(null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e) {
            try {
                th = null;
                th2 = e;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzpy.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzpy.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzpy.class, Object.class, "value"));
            } catch (Error | RuntimeException e2) {
                th = e2;
                th2 = e;
                zzgVar = new zzg(null);
            }
        }
        zzc = zzgVar;
        if (th != null) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzd = new Object();
    }

    public static /* bridge */ /* synthetic */ zza zza() {
        return zzc;
    }

    public static /* bridge */ /* synthetic */ zzd zzb(zzpy zzpyVar) {
        return zzpyVar.listeners;
    }

    public static /* bridge */ /* synthetic */ zzk zzc(zzpy zzpyVar) {
        return zzpyVar.waiters;
    }

    public static /* bridge */ /* synthetic */ Object zzd(zzpy zzpyVar) {
        return zzpyVar.value;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzpy zzpyVar, zzd zzdVar) {
        zzpyVar.listeners = zzdVar;
    }

    public static /* bridge */ /* synthetic */ void zzh(zzpy zzpyVar, Object obj) {
        zzpyVar.value = obj;
    }

    public static /* bridge */ /* synthetic */ void zzi(zzpy zzpyVar, zzk zzkVar) {
        zzpyVar.waiters = zzkVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzn(b bVar) {
        Throwable zzf2;
        if (bVar instanceof zzh) {
            Object obj = ((zzpy) bVar).value;
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                if (zzbVar.zzc) {
                    Throwable th = zzbVar.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            obj.getClass();
            return obj;
        }
        if ((bVar instanceof zzqx) && (zzf2 = ((zzqx) bVar).zzf()) != null) {
            return new zzc(zzf2);
        }
        boolean isCancelled = bVar.isCancelled();
        if ((!zza) && isCancelled) {
            zzb zzbVar2 = zzb.zzb;
            zzbVar2.getClass();
            return zzbVar2;
        }
        try {
            Object zzo = zzo(bVar);
            if (!isCancelled) {
                return zzo == null ? zzd : zzo;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(bVar)));
        } catch (Error e) {
            e = e;
            return new zzc(e);
        } catch (ExecutionException e2) {
            return isCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(bVar)), e2)) : new zzc(e2.getCause());
        } catch (RuntimeException e3) {
            e = e3;
            return new zzc(e);
        } catch (CancellationException e4) {
            return !isCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(bVar)), e4)) : new zzb(false, e4);
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzp(StringBuilder sb) {
        String hexString;
        String str = "]";
        try {
            Object zzo = zzo(this);
            sb.append("SUCCESS, result=[");
            if (zzo == null) {
                hexString = "null";
            } else if (zzo == this) {
                hexString = "this future";
            } else {
                sb.append(zzo.getClass().getName());
                sb.append("@");
                hexString = Integer.toHexString(System.identityHashCode(zzo));
            }
            sb.append(hexString);
            sb.append("]");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzq(java.lang.StringBuilder r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            java.lang.String r1 = "PENDING"
            r5.append(r1)
            java.lang.Object r1 = r4.value
            boolean r2 = r1 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            java.lang.String r3 = "]"
            if (r2 == 0) goto L21
            java.lang.String r2 = ", setFuture=["
            r5.append(r2)
            com.google.android.gms.internal.cast.zzpy$zzf r1 = (com.google.android.gms.internal.cast.zzpy.zzf) r1
            y5.b r1 = r1.zzb
            r4.zzr(r5, r1)
        L1d:
            r5.append(r3)
            goto L46
        L21:
            java.lang.String r1 = r4.zze()     // Catch: java.lang.StackOverflowError -> L2a java.lang.RuntimeException -> L2c
            java.lang.String r1 = com.google.android.gms.internal.cast.zzew.zza(r1)     // Catch: java.lang.StackOverflowError -> L2a java.lang.RuntimeException -> L2c
            goto L3b
        L2a:
            r1 = move-exception
            goto L2d
        L2c:
            r1 = move-exception
        L2d:
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Exception thrown from implementation: "
            java.lang.String r1 = r2.concat(r1)
        L3b:
            if (r1 == 0) goto L46
            java.lang.String r2 = ", info=["
            r5.append(r2)
            r5.append(r1)
            goto L1d
        L46:
            boolean r1 = r4.isDone()
            if (r1 == 0) goto L56
            int r1 = r5.length()
            r5.delete(r0, r1)
            r4.zzp(r5)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpy.zzq(java.lang.StringBuilder):void");
    }

    private final void zzr(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (StackOverflowError e) {
            e = e;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (RuntimeException e2) {
            e = e2;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static void zzs(zzpy zzpyVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            for (zzk zzb2 = zzc.zzb(zzpyVar, zzk.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzpyVar.zzj();
            zzd zzdVar2 = zzdVar;
            zzd zza2 = zzc.zza(zzpyVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zza2 != null) {
                zzd zzdVar4 = zza2.next;
                zza2.next = zzdVar3;
                zzdVar3 = zza2;
                zza2 = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = zzdVar3.zzb;
                runnable.getClass();
                if (runnable instanceof zzf) {
                    zzf zzfVar = (zzf) runnable;
                    zzpyVar = zzfVar.zza;
                    if (zzpyVar.value == zzfVar) {
                        if (zzc.zzf(zzpyVar, zzfVar, zzn(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    executor.getClass();
                    zzt(runnable, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzt(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            zzb.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), e);
        }
    }

    private final void zzu(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zzg(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzv(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzeu.zzc(runnable, "Runnable was null.");
        zzeu.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzt(runnable, executor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0053, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = 1
            goto Lb
        La:
            r4 = 0
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L60
            boolean r1 = com.google.android.gms.internal.cast.zzpy.zza
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.cast.zzpy$zzb r1 = new com.google.android.gms.internal.cast.zzpy$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.cast.zzpy$zzb r1 = com.google.android.gms.internal.cast.zzpy.zzb.zza
            goto L26
        L24:
            com.google.android.gms.internal.cast.zzpy$zzb r1 = com.google.android.gms.internal.cast.zzpy.zzb.zzb
        L26:
            r1.getClass()
        L29:
            r5 = 0
            r4 = r7
        L2b:
            com.google.android.gms.internal.cast.zzpy$zza r6 = com.google.android.gms.internal.cast.zzpy.zzc
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L59
            zzs(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            if (r4 == 0) goto L53
            com.google.android.gms.internal.cast.zzpy$zzf r0 = (com.google.android.gms.internal.cast.zzpy.zzf) r0
            y5.b r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzh
            if (r4 == 0) goto L55
            r4 = r0
            com.google.android.gms.internal.cast.zzpy r4 = (com.google.android.gms.internal.cast.zzpy) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4b
            r5 = 1
            goto L4c
        L4b:
            r5 = 0
        L4c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L53
            r5 = 1
            goto L2b
        L53:
            r2 = 1
            goto L60
        L55:
            r0.cancel(r8)
            goto L53
        L59:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            if (r6 != 0) goto L2b
            r2 = r5
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpy.cancel(boolean):boolean");
    }

    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzv(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzc;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzu(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzv(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        obj3.getClass();
        return zzv(obj3);
    }

    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName().startsWith("com.google.common.util.concurrent.") ? getClass().getSimpleName() : getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzp(sb);
        } else {
            zzq(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    public String zze() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public void zzj() {
    }

    public final boolean zzk(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, null, obj)) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    public final boolean zzl(Throwable th) {
        if (!zzc.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    public final boolean zzm() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        boolean z = true;
        if ((obj != null) && (!(obj instanceof zzf))) {
            return zzv(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.zza) {
                zzk zzkVar2 = new zzk();
                do {
                    zza zzaVar = zzc;
                    zzaVar.zzc(zzkVar2, zzkVar);
                    if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zzu(zzkVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                return zzv(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zzu(zzkVar2);
                    } else {
                        zzkVar = this.waiters;
                    }
                } while (zzkVar != zzk.zza);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return zzv(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                return zzv(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String zzpyVar = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String concat = str.concat(" (plus ");
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            if (convert != 0 && nanos2 <= 1000) {
                z = false;
            }
            if (convert > 0) {
                String str2 = concat + convert + " " + lowerCase;
                if (z) {
                    str2 = str2.concat(",");
                }
                concat = str2.concat(" ");
            }
            if (z) {
                concat = concat + nanos2 + " nanoseconds ";
            }
            str = concat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(str.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(str + " for " + zzpyVar);
    }
}
