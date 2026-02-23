package com.nytimes.android.external.cache;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a implements j {
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
        public final boolean a;
        public final Throwable b;

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
            this.a = (Throwable) o.a(th);
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

    public static final class g extends b {
        public g() {
            super(null);
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (a.f(aVar) != eVar) {
                        return false;
                    }
                    a.g(aVar, eVar2);
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

        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (a.d(aVar) != iVar) {
                        return false;
                    }
                    a.e(aVar, iVar2);
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

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public static abstract class h extends a {
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        public final Object get() {
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

    public static final class i {
        public static final i c = new i(false);
        public volatile Thread a;
        public volatile i b;

        public i() {
            a.a().e(this, Thread.currentThread());
        }

        public void a(i iVar) {
            a.a().d(this, iVar);
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
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
        } catch (Throwable th) {
            Logger logger = f;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!");
            logger.log(level, "SafeAtomicHelper is broken!", th);
            gVar = new g(null);
        }
        g = gVar;
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

    public static /* synthetic */ i d(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ i e(a aVar, i iVar) {
        aVar.d = iVar;
        return iVar;
    }

    public static /* synthetic */ e f(a aVar) {
        return aVar.c;
    }

    public static /* synthetic */ e g(a aVar, e eVar) {
        aVar.c = eVar;
        return eVar;
    }

    public static final CancellationException h(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        o.b(runnable, "Runnable was null.");
        o.b(executor, "Executor was null.");
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
        m(runnable, executor);
    }

    public boolean cancel(boolean z) {
        Object obj = this.a;
        if (obj == null) {
            if (g.b(this, obj, new c(z, e ? p() : null))) {
                if (z) {
                    o();
                }
                k();
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
            return n(obj2);
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
                            q(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.a;
                    } while (!(obj != null));
                    return n(obj);
                }
                iVar = this.d;
            } while (iVar != i.c);
        }
        return n(this.a);
    }

    public final e i() {
        e eVar;
        do {
            eVar = this.c;
        } while (!g.a(this, eVar, e.d));
        return eVar;
    }

    public boolean isCancelled() {
        return this.a instanceof c;
    }

    public boolean isDone() {
        return this.a != null;
    }

    public final i j() {
        i iVar;
        do {
            iVar = this.d;
        } while (!g.c(this, iVar, i.c));
        return iVar;
    }

    public final void k() {
        for (i j = j(); j != null; j = j.b) {
            j.b();
        }
        e i2 = i();
        e eVar = null;
        while (i2 != null) {
            e eVar2 = i2.c;
            i2.c = eVar;
            eVar = i2;
            i2 = eVar2;
        }
        while (eVar != null) {
            m(eVar.a, eVar.b);
            eVar = eVar.c;
        }
        l();
    }

    public void l() {
    }

    public final Object n(Object obj) {
        if (obj instanceof c) {
            throw h("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        }
        if (obj == h) {
            return null;
        }
        return obj;
    }

    public void o() {
    }

    public final Throwable p() {
        return new CancellationException("Future.cancel() was called.");
    }

    public final void q(i iVar) {
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

    public boolean r(Object obj) {
        if (obj == null) {
            obj = h;
        }
        if (!g.b(this, null, obj)) {
            return false;
        }
        k();
        return true;
    }

    public boolean s(Throwable th) {
        if (!g.b(this, null, new d((Throwable) o.a(th)))) {
            return false;
        }
        k();
        return true;
    }

    public Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if (obj != null) {
            return n(obj);
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
                                q(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if (obj2 != null) {
                                return n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        q(iVar2);
                    } else {
                        iVar = this.d;
                    }
                } while (iVar != i.c);
            }
            return n(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if (obj3 != null) {
                return n(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        throw new TimeoutException();
    }
}
