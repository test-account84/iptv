package b1;

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
    public volatile i d;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);

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

        public boolean c(a aVar, i iVar, i iVar2) {
            return t.b.a(this.c, aVar, iVar, iVar2);
        }

        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        public void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    public static final class g implements Runnable {
        public final a a;
        public final y5.b c;

        public g(a aVar, y5.b bVar) {
            this.a = aVar;
            this.c = bVar;
        }

        public void run() {
            if (this.a.a != this) {
                return;
            }
            if (a.g.b(this.a, this, a.j(this.c))) {
                a.f(this.a);
            }
        }
    }

    public static final class h extends b {
        public h() {
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

        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.d != iVar) {
                        return false;
                    }
                    aVar.d = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        public void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    public static final class i {
        public static final i c = new i(false);
        public volatile Thread a;
        public volatile i b;

        public i() {
            a.g.e(this, Thread.currentThread());
        }

        public void a(i iVar) {
            a.g.d(this, iVar);
        }

        public void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        public i(boolean z) {
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        g = hVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        h = new Object();
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object k = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(k));
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
        e eVar = null;
        while (true) {
            aVar.n();
            aVar.b();
            e e2 = aVar.e(eVar);
            while (e2 != null) {
                eVar = e2.c;
                Runnable runnable = e2.a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.a;
                    if (aVar.a == gVar) {
                        if (g.b(aVar, gVar, j(gVar.c))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, e2.b);
                }
                e2 = eVar;
            }
            return;
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

    public static Object j(y5.b bVar) {
        if (bVar instanceof a) {
            Object obj = ((a) bVar).a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.a ? cVar.b != null ? new c(false, cVar.b) : c.d : obj;
        }
        boolean isCancelled = bVar.isCancelled();
        if ((!e) && isCancelled) {
            return c.d;
        }
        try {
            Object k = k(bVar);
            return k == null ? h : k;
        } catch (ExecutionException e2) {
            return new d(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(false, e3);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + bVar, e3));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    private static Object k(Future future) {
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

    private void n() {
        i iVar;
        do {
            iVar = this.d;
        } while (!g.c(this, iVar, i.c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.b;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
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
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d;
        boolean z2 = false;
        a aVar = this;
        while (true) {
            if (g.b(aVar, obj, cVar)) {
                if (z) {
                    aVar.l();
                }
                f(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                y5.b bVar = ((g) obj).c;
                if (!(bVar instanceof a)) {
                    bVar.cancel(z);
                    return true;
                }
                aVar = (a) bVar;
                obj = aVar.a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = aVar.a;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
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
        if ((obj2 != null) && (!(obj2 instanceof g))) {
            return i(obj2);
        }
        i iVar = this.d;
        if (iVar != i.c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (g.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            o(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.a;
                    } while (!((obj != null) & (!(obj instanceof g))));
                    return i(obj);
                }
                iVar = this.d;
            } while (iVar != i.c);
        }
        return i(this.a);
    }

    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    public final boolean isDone() {
        return (!(r0 instanceof g)) & (this.a != null);
    }

    public String m() {
        Object obj = this.a;
        if (obj instanceof g) {
            return "setFuture=[" + s(((g) obj).c) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void o(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.d;
            if (iVar2 == i.c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.b;
                if (iVar2.a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.b = iVar4;
                    if (iVar3.a == null) {
                        break;
                    }
                } else if (!g.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    public boolean p(Object obj) {
        if (obj == null) {
            obj = h;
        }
        if (!g.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean q(Throwable th) {
        if (!g.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean r(y5.b bVar) {
        d dVar;
        d(bVar);
        Object obj = this.a;
        if (obj == null) {
            if (bVar.isDone()) {
                if (!g.b(this, null, j(bVar))) {
                    return false;
                }
                f(this);
                return true;
            }
            g gVar = new g(this, bVar);
            if (g.b(this, null, gVar)) {
                try {
                    bVar.addListener(gVar, b1.b.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.b;
                    }
                    g.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.a;
        }
        if (obj instanceof c) {
            bVar.cancel(((c) obj).a);
        }
        return false;
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
                    str = m();
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
        if ((obj != null) && (!(obj instanceof g))) {
            return i(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.d;
            if (iVar != i.c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (g.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return i(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(iVar2);
                    } else {
                        iVar = this.d;
                    }
                } while (iVar != i.c);
            }
            return i(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
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
