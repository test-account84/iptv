package y5;

import com.google.ads.interactivemedia.v3.internal.F;
import j$.util.Objects;
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
import r5.m;
import r5.q;
import r5.s;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a extends z5.a implements y5.b {
    public static final boolean e;
    public static final Logger f;
    public static final b g;
    public static final Object h;
    public volatile Object a;
    public volatile e c;
    public volatile j d;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, j jVar, j jVar2);

        public abstract e d(a aVar, e eVar);

        public abstract j e(a aVar, j jVar);

        public abstract void f(j jVar, j jVar2);

        public abstract void g(j jVar, Thread thread);

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static final class c {
        public static final c c;
        public static final c d;
        public final boolean a;
        public final Throwable b;

        static {
            if (a.e) {
                d = null;
                c = null;
            } else {
                d = new c(false, null);
                c = new c(true, null);
            }
        }

        public c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.a = (Throwable) m.k(th);
        }
    }

    public static final class e {
        public static final e d = new e();
        public final Runnable a;
        public final Executor b;
        public e c;

        public e() {
            this.a = null;
            this.b = null;
        }

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public static final class f extends b {
        public final AtomicReferenceFieldUpdater a;
        public final AtomicReferenceFieldUpdater b;
        public final AtomicReferenceFieldUpdater c;
        public final AtomicReferenceFieldUpdater d;
        public final AtomicReferenceFieldUpdater e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            return t.b.a(this.d, aVar, eVar, eVar2);
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            return t.b.a(this.e, aVar, obj, obj2);
        }

        public boolean c(a aVar, j jVar, j jVar2) {
            return t.b.a(this.c, aVar, jVar, jVar2);
        }

        public e d(a aVar, e eVar) {
            return (e) this.d.getAndSet(aVar, eVar);
        }

        public j e(a aVar, j jVar) {
            return (j) this.c.getAndSet(aVar, jVar);
        }

        public void f(j jVar, j jVar2) {
            this.b.lazySet(jVar, jVar2);
        }

        public void g(j jVar, Thread thread) {
            this.a.lazySet(jVar, thread);
        }
    }

    public static final class g extends b {
        public g() {
            super(null);
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (a.d(aVar) != eVar) {
                        return false;
                    }
                    a.e(aVar, eVar2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (a.b(aVar) != obj) {
                        return false;
                    }
                    a.c(aVar, obj2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean c(a aVar, j jVar, j jVar2) {
            synchronized (aVar) {
                try {
                    if (a.f(aVar) != jVar) {
                        return false;
                    }
                    a.g(aVar, jVar2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public e d(a aVar, e eVar) {
            e d;
            synchronized (aVar) {
                try {
                    d = a.d(aVar);
                    if (d != eVar) {
                        a.e(aVar, eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return d;
        }

        public j e(a aVar, j jVar) {
            j f;
            synchronized (aVar) {
                try {
                    f = a.f(aVar);
                    if (f != jVar) {
                        a.g(aVar, jVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return f;
        }

        public void f(j jVar, j jVar2) {
            jVar.b = jVar2;
        }

        public void g(j jVar, Thread thread) {
            jVar.a = thread;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public static abstract class h extends a implements y5.b {
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        public Object get() {
            return super.get();
        }

        public final boolean isCancelled() {
            return super.isCancelled();
        }

        public final boolean isDone() {
            return super.isDone();
        }

        public final Object get(long j, TimeUnit timeUnit) {
            return super.get(j, timeUnit);
        }
    }

    public static final class i extends b {
        public static final Unsafe a;
        public static final long b;
        public static final long c;
        public static final long d;
        public static final long e;
        public static final long f;

        public class a implements PrivilegedExceptionAction {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() {
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
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                c = unsafe.objectFieldOffset(a.class.getDeclaredField("d"));
                b = unsafe.objectFieldOffset(a.class.getDeclaredField("c"));
                d = unsafe.objectFieldOffset(a.class.getDeclaredField("a"));
                e = unsafe.objectFieldOffset(j.class.getDeclaredField("a"));
                f = unsafe.objectFieldOffset(j.class.getDeclaredField("b"));
                a = unsafe;
            } catch (Exception e3) {
                s.e(e3);
                throw new RuntimeException(e3);
            }
        }

        public i() {
            super(null);
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            return F.a(a, aVar, b, eVar, eVar2);
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            return F.a(a, aVar, d, obj, obj2);
        }

        public boolean c(a aVar, j jVar, j jVar2) {
            return F.a(a, aVar, c, jVar, jVar2);
        }

        public e d(a aVar, e eVar) {
            e d2;
            do {
                d2 = a.d(aVar);
                if (eVar == d2) {
                    return d2;
                }
            } while (!a(aVar, d2, eVar));
            return d2;
        }

        public j e(a aVar, j jVar) {
            j f2;
            do {
                f2 = a.f(aVar);
                if (jVar == f2) {
                    return f2;
                }
            } while (!c(aVar, f2, jVar));
            return f2;
        }

        public void f(j jVar, j jVar2) {
            a.putObject(jVar, f, jVar2);
        }

        public void g(j jVar, Thread thread) {
            a.putObject(jVar, e, thread);
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public static final class j {
        public static final j c = new j(false);
        public volatile Thread a;
        public volatile j b;

        public j() {
            a.a().g(this, Thread.currentThread());
        }

        public void a(j jVar) {
            a.a().f(this, jVar);
        }

        public void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        public j(boolean z) {
        }
    }

    static {
        boolean z;
        b gVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        e = z;
        f = Logger.getLogger(a.class.getName());
        Throwable th = null;
        try {
            gVar = new i(null);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                gVar = new f(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, j.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            } catch (Throwable th3) {
                gVar = new g(null);
                th = th3;
            }
        }
        g = gVar;
        if (th != null) {
            Logger logger = f;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        h = new Object();
    }

    public static /* synthetic */ b a() {
        return g;
    }

    public static /* synthetic */ Object b(a aVar) {
        return aVar.a;
    }

    public static /* synthetic */ Object c(a aVar, Object obj) {
        aVar.a = obj;
        return obj;
    }

    public static /* synthetic */ e d(a aVar) {
        return aVar.c;
    }

    public static /* synthetic */ e e(a aVar, e eVar) {
        aVar.c = eVar;
        return eVar;
    }

    public static /* synthetic */ j f(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ j g(a aVar, j jVar) {
        aVar.d = jVar;
        return jVar;
    }

    public static CancellationException l(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void n(a aVar) {
        aVar.t();
        aVar.j();
        e m = aVar.m(null);
        while (m != null) {
            e eVar = m.c;
            Runnable runnable = m.a;
            Objects.requireNonNull(runnable);
            Executor executor = m.b;
            Objects.requireNonNull(executor);
            o(runnable, executor);
            m = eVar;
        }
    }

    public static void o(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.log(level, sb.toString(), e2);
        }
    }

    private static Object q(Future future) {
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

    public void addListener(Runnable runnable, Executor executor) {
        e eVar;
        m.l(runnable, "Runnable was null.");
        m.l(executor, "Executor was null.");
        if (!isDone() && (eVar = this.c) != e.d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.c = eVar;
                if (g.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.c;
                }
            } while (eVar != e.d);
        }
        o(runnable, executor);
    }

    public boolean cancel(boolean z) {
        c cVar;
        Object obj = this.a;
        if (obj == null) {
            if (e) {
                cVar = new c(z, new CancellationException("Future.cancel() was called."));
            } else {
                cVar = z ? c.c : c.d;
                Objects.requireNonNull(cVar);
            }
            if (g.b(this, obj, cVar)) {
                if (z) {
                    r();
                }
                n(this);
                return true;
            }
        }
        return false;
    }

    public Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.a;
        if (obj2 != null) {
            return p(obj2);
        }
        j jVar = this.d;
        if (jVar != j.c) {
            j jVar2 = new j();
            do {
                jVar2.a(jVar);
                if (g.c(this, jVar, jVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            u(jVar2);
                            throw new InterruptedException();
                        }
                        obj = this.a;
                    } while (!(obj != null));
                    return p(obj);
                }
                jVar = this.d;
            } while (jVar != j.c);
        }
        Object obj3 = this.a;
        Objects.requireNonNull(obj3);
        return p(obj3);
    }

    public final void h(StringBuilder sb) {
        String str = "]";
        try {
            Object q = q(this);
            sb.append("SUCCESS, result=[");
            k(sb, q);
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(str);
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
            sb.append(str);
        }
    }

    public final void i(StringBuilder sb) {
        String sb2;
        int length = sb.length();
        sb.append("PENDING");
        try {
            sb2 = q.a(s());
        } catch (StackOverflowError | RuntimeException e2) {
            String valueOf = String.valueOf(e2.getClass());
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 38);
            sb3.append("Exception thrown from implementation: ");
            sb3.append(valueOf);
            sb2 = sb3.toString();
        }
        if (sb2 != null) {
            sb.append(", info=[");
            sb.append(sb2);
            sb.append("]");
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            h(sb);
        }
    }

    public boolean isCancelled() {
        return this.a instanceof c;
    }

    public boolean isDone() {
        return this.a != null;
    }

    public final void k(StringBuilder sb, Object obj) {
        String hexString;
        if (obj == null) {
            hexString = "null";
        } else if (obj == this) {
            hexString = "this future";
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }

    public final e m(e eVar) {
        e eVar2 = eVar;
        e d2 = g.d(this, e.d);
        while (d2 != null) {
            e eVar3 = d2.c;
            d2.c = eVar2;
            eVar2 = d2;
            d2 = eVar3;
        }
        return eVar2;
    }

    public final Object p(Object obj) {
        if (obj instanceof c) {
            throw l("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        }
        return obj == h ? y5.c.a() : obj;
    }

    public String s() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    public final void t() {
        for (j e2 = g.e(this, j.c); e2 != null; e2 = e2.b) {
            e2.b();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName().startsWith("com.google.common.util.concurrent.") ? getClass().getSimpleName() : getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            h(sb);
        } else {
            i(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    public final void u(j jVar) {
        jVar.a = null;
        while (true) {
            j jVar2 = this.d;
            if (jVar2 == j.c) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.b;
                if (jVar2.a != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.b = jVar4;
                    if (jVar3.a == null) {
                        break;
                    }
                } else if (!g.c(this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    public boolean v(Object obj) {
        if (obj == null) {
            obj = h;
        }
        if (!g.b(this, null, obj)) {
            return false;
        }
        n(this);
        return true;
    }

    public boolean w(Throwable th) {
        if (!g.b(this, null, new d((Throwable) m.k(th)))) {
            return false;
        }
        n(this);
        return true;
    }

    public Object get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if (obj != null) {
            return p(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            j jVar = this.d;
            if (jVar != j.c) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (g.c(this, jVar, jVar2)) {
                        do {
                            y5.d.a(this, nanos);
                            if (Thread.interrupted()) {
                                u(jVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if (obj2 != null) {
                                return p(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        u(jVar2);
                    } else {
                        jVar = this.d;
                    }
                } while (jVar != j.c);
            }
            Object obj3 = this.a;
            Objects.requireNonNull(obj3);
            return p(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.a;
            if (obj4 != null) {
                return p(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
        String lowerCase2 = timeUnit.toString().toLowerCase(locale);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb.append("Waited ");
        sb.append(j2);
        sb.append(" ");
        sb.append(lowerCase2);
        String sb2 = sb.toString();
        if (nanos + 1000 < 0) {
            String concat = String.valueOf(sb2).concat(" (plus ");
            long j3 = -nanos;
            long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String valueOf = String.valueOf(concat);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                sb3.append(valueOf);
                sb3.append(convert);
                sb3.append(" ");
                sb3.append(lowerCase);
                String sb4 = sb3.toString();
                if (z) {
                    sb4 = String.valueOf(sb4).concat(",");
                }
                concat = String.valueOf(sb4).concat(" ");
            }
            if (z) {
                String valueOf2 = String.valueOf(concat);
                StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                sb5.append(valueOf2);
                sb5.append(nanos2);
                sb5.append(" nanoseconds ");
                concat = sb5.toString();
            }
            sb2 = String.valueOf(concat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(aVar).length());
        sb6.append(sb2);
        sb6.append(" for ");
        sb6.append(aVar);
        throw new TimeoutException(sb6.toString());
    }

    public void j() {
    }

    public void r() {
    }
}
