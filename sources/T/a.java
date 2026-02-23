package t;

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

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a implements y5.b {
    public static final boolean e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger f = Logger.getLogger(a.class.getName());
    public static final b g;
    public static final Object h;
    public volatile Object a;
    public volatile e c;
    public volatile h d;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);

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
            this.a = (Throwable) a.d(th);
        }
    }

    public static final class e {
        public static final e d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        public e c;

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

        public boolean c(a aVar, h hVar, h hVar2) {
            return t.b.a(this.c, aVar, hVar, hVar2);
        }

        public void d(h hVar, h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        public void e(h hVar, Thread thread) {
            this.a.lazySet(hVar, thread);
        }
    }

    public static final class g extends b {
        public g() {
            super(null);
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.c != eVar) {
                        return false;
                    }
                    aVar.c = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.a != obj) {
                        return false;
                    }
                    aVar.a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.d != hVar) {
                        return false;
                    }
                    aVar.d = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d(h hVar, h hVar2) {
            hVar.b = hVar2;
        }

        public void e(h hVar, Thread thread) {
            hVar.a = thread;
        }
    }

    public static final class h {
        public static final h c = new h(false);
        public volatile Thread a;
        public volatile h b;

        public h() {
            a.g.e(this, Thread.currentThread());
        }

        public void a(h hVar) {
            a.g.d(this, hVar);
        }

        public void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        public h(boolean z) {
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        g = gVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        h = new Object();
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object j = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(j));
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(str);
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void f(a aVar) {
        aVar.o();
        aVar.b();
        e e2 = aVar.e(null);
        while (e2 != null) {
            e eVar = e2.c;
            h(e2.a, e2.b);
            e2 = eVar;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private Object i(Object obj) {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        }
        if (obj == h) {
            return null;
        }
        return obj;
    }

    public static Object j(Future future) {
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

    private void o() {
        h hVar;
        do {
            hVar = this.d;
        } while (!g.c(this, hVar, h.c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.b;
        }
    }

    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        e eVar = this.c;
        if (eVar != e.d) {
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
        h(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        Object obj = this.a;
        if (obj == null) {
            if (g.b(this, obj, e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d)) {
                if (z) {
                    l();
                }
                f(this);
                return true;
            }
        }
        return false;
    }

    public final e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.c;
        } while (!g.a(this, eVar2, e.d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.c;
            eVar4.c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    public final Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.a;
        if (obj2 != null) {
            return i(obj2);
        }
        h hVar = this.d;
        if (hVar != h.c) {
            h hVar2 = new h();
            do {
                hVar2.a(hVar);
                if (g.c(this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            p(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.a;
                    } while (!(obj != null));
                    return i(obj);
                }
                hVar = this.d;
            } while (hVar != h.c);
        }
        return i(this.a);
    }

    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    public final boolean isDone() {
        return this.a != null;
    }

    public String n() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void p(h hVar) {
        hVar.a = null;
        while (true) {
            h hVar2 = this.d;
            if (hVar2 == h.c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.b;
                if (hVar2.a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.b = hVar4;
                    if (hVar3.a == null) {
                        break;
                    }
                } else if (!g.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean q(Object obj) {
        if (obj == null) {
            obj = h;
        }
        if (!g.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean r(Throwable th) {
        if (!g.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public final String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean t() {
        Object obj = this.a;
        return (obj instanceof c) && ((c) obj).a;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (isDone()) {
                a(sb);
            } else {
                try {
                    str = n();
                } catch (RuntimeException e2) {
                    str = "Exception thrown from implementation: " + e2.getClass();
                }
                if (str == null || str.isEmpty()) {
                    str2 = isDone() ? "CANCELLED" : "PENDING";
                    a(sb);
                } else {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }

    public final Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if (obj != null) {
            return i(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.d;
            if (hVar != h.c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (g.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                p(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if (obj2 != null) {
                                return i(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        p(hVar2);
                    } else {
                        hVar = this.d;
                    }
                } while (hVar != h.c);
            }
            return i(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if (obj3 != null) {
                return i(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    public void b() {
    }

    public void l() {
    }
}
