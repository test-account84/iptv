package com.google.ads.interactivemedia.v3.internal;

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

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class axz extends azm implements azd {
    static final boolean a;
    private static final Logger aX;
    private static final a aY;
    private static final Object d;
    private volatile d listeners;
    private volatile Object value;
    private volatile k waiters;

    abstract class a {
        public abstract d a(axz axzVar, d dVar);

        public abstract k b(axz axzVar, k kVar);

        public abstract void c(k kVar, k kVar2);

        public abstract void d(k kVar, Thread thread);

        public abstract boolean e(axz axzVar, d dVar, d dVar2);

        public abstract boolean f(axz axzVar, Object obj, Object obj2);

        public abstract boolean g(axz axzVar, k kVar, k kVar2);
    }

    final class b {
        static final b a;
        static final b b;
        final boolean c;
        final Throwable d;

        static {
            if (axz.a) {
                b = null;
                a = null;
            } else {
                b = new b(false, null);
                a = new b(true, null);
            }
        }

        public b(boolean z, Throwable th) {
            this.c = z;
            this.d = th;
        }
    }

    final class c {
        static final c a = new c(new 1());
        final Throwable b;

        public class 1 extends Throwable {
            public 1() {
                super("Failure occurred while trying to finish a future.");
            }

            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public c(Throwable th) {
            atp.k(th);
            this.b = th;
        }
    }

    final class d {
        static final d a = new d();
        final Runnable b;
        final Executor c;
        d next;

        public d() {
            this.b = null;
            this.c = null;
        }

        public d(Runnable runnable, Executor executor) {
            this.b = runnable;
            this.c = executor;
        }
    }

    final class e extends a {
        final AtomicReferenceFieldUpdater a;
        final AtomicReferenceFieldUpdater b;
        final AtomicReferenceFieldUpdater c;
        final AtomicReferenceFieldUpdater d;
        final AtomicReferenceFieldUpdater e;

        public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        public final d a(axz axzVar, d dVar) {
            return (d) this.d.getAndSet(axzVar, dVar);
        }

        public final k b(axz axzVar, k kVar) {
            return (k) this.c.getAndSet(axzVar, kVar);
        }

        public final void c(k kVar, k kVar2) {
            this.b.lazySet(kVar, kVar2);
        }

        public final void d(k kVar, Thread thread) {
            this.a.lazySet(kVar, thread);
        }

        public final boolean e(axz axzVar, d dVar, d dVar2) {
            return aya.a(this.d, axzVar, dVar, dVar2);
        }

        public final boolean f(axz axzVar, Object obj, Object obj2) {
            return aya.a(this.e, axzVar, obj, obj2);
        }

        public final boolean g(axz axzVar, k kVar, k kVar2) {
            return aya.a(this.c, axzVar, kVar, kVar2);
        }
    }

    final class f implements Runnable {
        final axz a;
        final azd b;

        public final void run() {
            throw null;
        }
    }

    final class g extends a {
        private g() {
        }

        public final d a(axz axzVar, d dVar) {
            d b;
            synchronized (axzVar) {
                try {
                    b = axz.b(axzVar);
                    if (b != dVar) {
                        axz.m(axzVar, dVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return b;
        }

        public final k b(axz axzVar, k kVar) {
            k c;
            synchronized (axzVar) {
                try {
                    c = axz.c(axzVar);
                    if (c != kVar) {
                        axz.n(axzVar, kVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c;
        }

        public final void c(k kVar, k kVar2) {
            kVar.next = kVar2;
        }

        public final void d(k kVar, Thread thread) {
            kVar.thread = thread;
        }

        public final boolean e(axz axzVar, d dVar, d dVar2) {
            synchronized (axzVar) {
                try {
                    if (axz.b(axzVar) != dVar) {
                        return false;
                    }
                    axz.m(axzVar, dVar2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean f(axz axzVar, Object obj, Object obj2) {
            synchronized (axzVar) {
                try {
                    if (axz.d(axzVar) != obj) {
                        return false;
                    }
                    axz.l(axzVar, obj2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean g(axz axzVar, k kVar, k kVar2) {
            synchronized (axzVar) {
                try {
                    if (axz.c(axzVar) != kVar) {
                        return false;
                    }
                    axz.n(axzVar, kVar2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ g(byte[] bArr) {
        }
    }

    interface h extends azd {
    }

    abstract class i extends axz implements h {
    }

    final class j extends a {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        public class 1 implements PrivilegedExceptionAction {
            public static final Unsafe a() throws Exception {
                for (AccessibleObject accessibleObject : Unsafe.class.getDeclaredFields()) {
                    accessibleObject.setAccessible(true);
                    Object obj = accessibleObject.get((Object) null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }

            public final /* bridge */ /* synthetic */ Object run() throws Exception {
                return a();
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new 1());
            }
            try {
                c = unsafe.objectFieldOffset(axz.class.getDeclaredField("waiters"));
                b = unsafe.objectFieldOffset(axz.class.getDeclaredField("listeners"));
                d = unsafe.objectFieldOffset(axz.class.getDeclaredField("value"));
                e = unsafe.objectFieldOffset(k.class.getDeclaredField("thread"));
                f = unsafe.objectFieldOffset(k.class.getDeclaredField("next"));
                a = unsafe;
            } catch (RuntimeException e3) {
                throw e3;
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException(e4);
            }
        }

        private j() {
        }

        public final d a(axz axzVar, d dVar) {
            d b2;
            do {
                b2 = axz.b(axzVar);
                if (dVar == b2) {
                    return b2;
                }
            } while (!e(axzVar, b2, dVar));
            return b2;
        }

        public final k b(axz axzVar, k kVar) {
            k c2;
            do {
                c2 = axz.c(axzVar);
                if (kVar == c2) {
                    return c2;
                }
            } while (!g(axzVar, c2, kVar));
            return c2;
        }

        public final void c(k kVar, k kVar2) {
            a.putObject(kVar, f, kVar2);
        }

        public final void d(k kVar, Thread thread) {
            a.putObject(kVar, e, thread);
        }

        public final boolean e(axz axzVar, d dVar, d dVar2) {
            return ayb.a(a, axzVar, b, dVar, dVar2);
        }

        public final boolean f(axz axzVar, Object obj, Object obj2) {
            return ayb.a(a, axzVar, d, obj, obj2);
        }

        public final boolean g(axz axzVar, k kVar, k kVar2) {
            return ayb.a(a, axzVar, c, kVar, kVar2);
        }

        public /* synthetic */ j(byte[] bArr) {
        }
    }

    final class k {
        static final k a = new k(null);
        volatile k next;
        volatile Thread thread;

        public k() {
            axz.a().d(this, Thread.currentThread());
        }

        public final void a(k kVar) {
            axz.a().c(this, kVar);
        }

        public k(byte[] bArr) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        a gVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        a = z;
        aX = Logger.getLogger(axz.class.getName());
        try {
            gVar = new j(null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e2) {
            try {
                th = null;
                th2 = e2;
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "next"), AtomicReferenceFieldUpdater.newUpdater(axz.class, k.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(axz.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(axz.class, Object.class, "value"));
            } catch (Error | RuntimeException e3) {
                th = e3;
                th2 = e2;
                gVar = new g(null);
            }
        }
        aY = gVar;
        if (th != null) {
            Logger logger = aX;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        d = new Object();
    }

    public static /* synthetic */ a a() {
        return aY;
    }

    public static /* synthetic */ d b(axz axzVar) {
        return axzVar.listeners;
    }

    public static /* synthetic */ k c(axz axzVar) {
        return axzVar.waiters;
    }

    public static /* synthetic */ Object d(axz axzVar) {
        return axzVar.value;
    }

    public static /* synthetic */ void l(axz axzVar, Object obj) {
        axzVar.value = obj;
    }

    public static /* synthetic */ void m(axz axzVar, d dVar) {
        axzVar.listeners = dVar;
    }

    public static /* synthetic */ void n(axz axzVar, k kVar) {
        axzVar.waiters = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object p(azd azdVar) {
        Throwable f2;
        if (azdVar instanceof h) {
            Object obj = ((axz) azdVar).value;
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.c) {
                    Throwable th = bVar.d;
                    obj = th != null ? new b(false, th) : b.b;
                }
            }
            obj.getClass();
            return obj;
        }
        if ((azdVar instanceof azm) && (f2 = ((azm) azdVar).f()) != null) {
            return new c(f2);
        }
        boolean isCancelled = azdVar.isCancelled();
        if ((!a) && isCancelled) {
            b bVar2 = b.b;
            bVar2.getClass();
            return bVar2;
        }
        try {
            Object q = q(azdVar);
            if (!isCancelled) {
                return q == null ? d : q;
            }
            return new b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + azdVar));
        } catch (CancellationException e2) {
            if (isCancelled) {
                return new b(false, e2);
            }
            azdVar.toString();
            return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(azdVar)), e2));
        } catch (Error e3) {
            e = e3;
            return new c(e);
        } catch (RuntimeException e4) {
            e = e4;
            return new c(e);
        } catch (ExecutionException e5) {
            if (!isCancelled) {
                return new c(e5.getCause());
            }
            azdVar.toString();
            return new b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(azdVar)), e5));
        }
    }

    private static Object q(Future future) throws ExecutionException {
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

    private final void r(StringBuilder sb) {
        String hexString;
        String str = "]";
        try {
            Object q = q(this);
            sb.append("SUCCESS, result=[");
            if (q == null) {
                hexString = "null";
            } else if (q == this) {
                hexString = "this future";
            } else {
                sb.append(q.getClass().getName());
                sb.append("@");
                hexString = Integer.toHexString(System.identityHashCode(q));
            }
            sb.append(hexString);
            sb.append("]");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void s(java.lang.StringBuilder r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            java.lang.String r1 = "PENDING"
            r5.append(r1)
            java.lang.Object r1 = r4.value
            boolean r2 = r1 instanceof com.google.ads.interactivemedia.v3.internal.axz.f
            java.lang.String r3 = "]"
            if (r2 == 0) goto L21
            java.lang.String r2 = ", setFuture=["
            r5.append(r2)
            com.google.ads.interactivemedia.v3.internal.axz$f r1 = (com.google.ads.interactivemedia.v3.internal.axz.f) r1
            com.google.ads.interactivemedia.v3.internal.azd r1 = r1.b
            r4.t(r5, r1)
        L1d:
            r5.append(r3)
            goto L49
        L21:
            java.lang.String r1 = r4.e()     // Catch: java.lang.StackOverflowError -> L2a java.lang.RuntimeException -> L2c
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.atp.a(r1)     // Catch: java.lang.StackOverflowError -> L2a java.lang.RuntimeException -> L2c
            goto L3e
        L2a:
            r1 = move-exception
            goto L2d
        L2c:
            r1 = move-exception
        L2d:
            java.lang.Class r1 = r1.getClass()
            r1.toString()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Exception thrown from implementation: "
            java.lang.String r1 = r2.concat(r1)
        L3e:
            if (r1 == 0) goto L49
            java.lang.String r2 = ", info=["
            r5.append(r2)
            r5.append(r1)
            goto L1d
        L49:
            boolean r1 = r4.isDone()
            if (r1 == 0) goto L59
            int r1 = r5.length()
            r5.delete(r0, r1)
            r4.r(r5)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.axz.s(java.lang.StringBuilder):void");
    }

    private final void t(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (StackOverflowError e2) {
            e = e2;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (RuntimeException e3) {
            e = e3;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static void u(axz axzVar) {
        d dVar = null;
        while (true) {
            for (k b2 = aY.b(axzVar, k.a); b2 != null; b2 = b2.next) {
                Thread thread = b2.thread;
                if (thread != null) {
                    b2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            axzVar.h();
            d dVar2 = dVar;
            d a2 = aY.a(axzVar, d.a);
            d dVar3 = dVar2;
            while (a2 != null) {
                d dVar4 = a2.next;
                a2.next = dVar3;
                dVar3 = a2;
                a2 = dVar4;
            }
            while (dVar3 != null) {
                dVar = dVar3.next;
                Runnable runnable = dVar3.b;
                runnable.getClass();
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    axzVar = fVar.a;
                    if (axzVar.value == fVar) {
                        if (aY.f(axzVar, fVar, p(fVar.b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = dVar3.c;
                    executor.getClass();
                    v(runnable, executor);
                }
                dVar3 = dVar;
            }
            return;
        }
    }

    private static void v(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            aX.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private final void w(k kVar) {
        kVar.thread = null;
        while (true) {
            k kVar2 = this.waiters;
            if (kVar2 != k.a) {
                k kVar3 = null;
                while (kVar2 != null) {
                    k kVar4 = kVar2.next;
                    if (kVar2.thread != null) {
                        kVar3 = kVar2;
                    } else if (kVar3 != null) {
                        kVar3.next = kVar4;
                        if (kVar3.thread == null) {
                            break;
                        }
                    } else if (!aY.g(this, kVar2, kVar4)) {
                        break;
                    }
                    kVar2 = kVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object x(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th = ((b) obj).d;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).b);
        }
        if (obj == d) {
            return null;
        }
        return obj;
    }

    public final boolean cancel(boolean z) {
        b bVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (a) {
            bVar = new b(z, new CancellationException("Future.cancel() was called."));
        } else {
            bVar = z ? b.a : b.b;
            bVar.getClass();
        }
        boolean z2 = false;
        axz axzVar = this;
        while (true) {
            if (aY.f(axzVar, obj, bVar)) {
                if (z) {
                    axzVar.i();
                }
                u(axzVar);
                if (!(obj instanceof f)) {
                    break;
                }
                azd azdVar = ((f) obj).b;
                if (!(azdVar instanceof h)) {
                    azdVar.cancel(z);
                    break;
                }
                axzVar = (axz) azdVar;
                obj = axzVar.value;
                if (!(obj == null) && !(obj instanceof f)) {
                    break;
                }
                z2 = true;
            } else {
                obj = axzVar.value;
                if (!(obj instanceof f)) {
                    return z2;
                }
            }
        }
        return true;
    }

    public String e() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final Throwable f() {
        if (!(this instanceof h)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof c) {
            return ((c) obj).b;
        }
        return null;
    }

    public final void g(Runnable runnable, Executor executor) {
        d dVar;
        atp.l(runnable, "Runnable was null.");
        atp.l(executor, "Executor was null.");
        if (!isDone() && (dVar = this.listeners) != d.a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.next = dVar;
                if (aY.e(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.a);
        }
        v(runnable, executor);
    }

    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof f))) {
            return x(obj2);
        }
        k kVar = this.waiters;
        if (kVar != k.a) {
            k kVar2 = new k();
            do {
                kVar2.a(kVar);
                if (aY.g(this, kVar, kVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            w(kVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return x(obj);
                }
                kVar = this.waiters;
            } while (kVar != k.a);
        }
        Object obj3 = this.value;
        obj3.getClass();
        return x(obj3);
    }

    public void h() {
    }

    public void i() {
    }

    public final boolean isCancelled() {
        return this.value instanceof b;
    }

    public final boolean isDone() {
        return (!(r0 instanceof f)) & (this.value != null);
    }

    public boolean j(Object obj) {
        if (obj == null) {
            obj = d;
        }
        if (!aY.f(this, null, obj)) {
            return false;
        }
        u(this);
        return true;
    }

    public final boolean k() {
        Object obj = this.value;
        return (obj instanceof b) && ((b) obj).c;
    }

    public final void o(Throwable th) {
        atp.k(th);
        if (aY.f(this, null, new c(th))) {
            u(this);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName().startsWith("com.google.common.util.concurrent.") ? getClass().getSimpleName() : getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            r(sb);
        } else {
            s(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        boolean z = true;
        if ((obj != null) && (!(obj instanceof f))) {
            return x(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            k kVar = this.waiters;
            if (kVar != k.a) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (aY.g(this, kVar, kVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                w(kVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return x(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        w(kVar2);
                    } else {
                        kVar = this.waiters;
                    }
                } while (kVar != k.a);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return x(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof f))) {
                return x(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String axzVar = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String concat = str.concat(" (plus ");
            long j3 = -nanos;
            long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(convert);
            if (convert != 0 && nanos2 <= 1000) {
                z = false;
            }
            if (convert > 0) {
                String str2 = concat + convert + " " + lowerCase;
                if (z) {
                    str2 = str2.concat(",");
                }
                concat = String.valueOf(str2).concat(" ");
            }
            if (z) {
                concat = concat + nanos2 + " nanoseconds ";
            }
            str = String.valueOf(concat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(str).concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(str + " for " + axzVar);
    }
}
