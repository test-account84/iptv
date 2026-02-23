package kotlinx.coroutines.scheduling;

import G8.P;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import k8.q;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class a implements Executor, Closeable {

    @NotNull
    private volatile /* synthetic */ int _isTerminated;
    public final int a;
    public final int c;

    @NotNull
    volatile /* synthetic */ long controlState;
    public final long d;
    public final String e;
    public final kotlinx.coroutines.scheduling.d f;
    public final kotlinx.coroutines.scheduling.d g;
    public final w h;

    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;
    public static final a i = new a(null);
    public static final y m = new y("NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    public final class c extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        public final o a;
        public d c;
        public long d;
        public long e;
        public int f;
        public boolean g;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;

        @NotNull
        volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.a = new o();
            this.c = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.m;
            this.f = z8.c.a.c();
        }

        public static final /* synthetic */ a a(c cVar) {
            return a.this;
        }

        public final void b(int i2) {
            if (i2 == 0) {
                return;
            }
            a.k.addAndGet(a.this, -2097152L);
            if (this.c != d.TERMINATED) {
                this.c = d.DORMANT;
            }
        }

        public final void c(int i2) {
            if (i2 != 0 && s(d.BLOCKING)) {
                a.this.p();
            }
        }

        public final void d(h hVar) {
            int b = hVar.c.b();
            i(b);
            c(b);
            a.this.m(hVar);
            b(b);
        }

        public final h e(boolean z) {
            h m;
            h m2;
            if (z) {
                boolean z2 = k(a.this.a * 2) == 0;
                if (z2 && (m2 = m()) != null) {
                    return m2;
                }
                h h = this.a.h();
                if (h != null) {
                    return h;
                }
                if (!z2 && (m = m()) != null) {
                    return m;
                }
            } else {
                h m3 = m();
                if (m3 != null) {
                    return m3;
                }
            }
            return t(false);
        }

        public final h f(boolean z) {
            h hVar;
            if (q()) {
                return e(z);
            }
            if (!z || (hVar = this.a.h()) == null) {
                hVar = (h) a.this.g.d();
            }
            return hVar == null ? t(true) : hVar;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final void i(int i2) {
            this.d = 0L;
            if (this.c == d.PARKING) {
                this.c = d.BLOCKING;
            }
        }

        public final boolean j() {
            return this.nextParkedWorker != a.m;
        }

        public final int k(int i2) {
            int i3 = this.f;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void l() {
            if (this.d == 0) {
                this.d = System.nanoTime() + a.this.d;
            }
            LockSupport.parkNanos(a.this.d);
            if (System.nanoTime() - this.d >= 0) {
                this.d = 0L;
                u();
            }
        }

        public final h m() {
            kotlinx.coroutines.scheduling.d dVar;
            if (k(2) == 0) {
                h hVar = (h) a.this.f.d();
                if (hVar != null) {
                    return hVar;
                }
                dVar = a.this.g;
            } else {
                h hVar2 = (h) a.this.g.d();
                if (hVar2 != null) {
                    return hVar2;
                }
                dVar = a.this.f;
            }
            return (h) dVar.d();
        }

        public final void n() {
            loop0: while (true) {
                boolean z = false;
                while (!a.this.isTerminated() && this.c != d.TERMINATED) {
                    h f = f(this.g);
                    if (f != null) {
                        this.e = 0L;
                        d(f);
                    } else {
                        this.g = false;
                        if (this.e == 0) {
                            r();
                        } else if (z) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.e);
                            this.e = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        public final void o(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.e);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            long j;
            if (this.c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            do {
                j = aVar.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!a.k.compareAndSet(aVar, j, j - 4398046511104L));
            this.c = d.CPU_ACQUIRED;
            return true;
        }

        public final void r() {
            if (!j()) {
                a.this.k(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.c != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.c;
            boolean z = dVar2 == d.CPU_ACQUIRED;
            if (z) {
                a.k.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.c = dVar;
            }
            return z;
        }

        public final h t(boolean z) {
            int i2 = (int) (a.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int k = k(i2);
            a aVar = a.this;
            long j = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                k++;
                if (k > i2) {
                    k = 1;
                }
                c cVar = (c) aVar.h.b(k);
                if (cVar != null && cVar != this) {
                    o oVar = this.a;
                    o oVar2 = cVar.a;
                    long k2 = z ? oVar.k(oVar2) : oVar.l(oVar2);
                    if (k2 == -1) {
                        return this.a.h();
                    }
                    if (k2 > 0) {
                        j = Math.min(j, k2);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.e = j;
            return null;
        }

        public final void u() {
            a aVar = a.this;
            synchronized (aVar.h) {
                try {
                    if (aVar.isTerminated()) {
                        return;
                    }
                    if (((int) (aVar.controlState & 2097151)) <= aVar.a) {
                        return;
                    }
                    if (i.compareAndSet(this, -1, 1)) {
                        int i2 = this.indexInArray;
                        o(0);
                        aVar.l(this, i2, 0);
                        int andDecrement = (int) (a.k.getAndDecrement(aVar) & 2097151);
                        if (andDecrement != i2) {
                            Object b = aVar.h.b(andDecrement);
                            kotlin.jvm.internal.l.b(b);
                            c cVar = (c) b;
                            aVar.h.c(i2, cVar);
                            cVar.o(i2);
                            aVar.l(cVar, andDecrement, i2);
                        }
                        aVar.h.c(andDecrement, null);
                        q qVar = q.a;
                        this.c = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(a aVar, int i2) {
            this();
            o(i2);
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i2, int i3, long j2, String str) {
        this.a = i2;
        this.c = i3;
        this.d = j2;
        this.e = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f = new kotlinx.coroutines.scheduling.d();
        this.g = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.h = new w(i2 + 1);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void h(a aVar, Runnable runnable, i iVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iVar = l.f;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        aVar.g(runnable, iVar, z);
    }

    public static /* synthetic */ boolean s(a aVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = aVar.controlState;
        }
        return aVar.r(j2);
    }

    public final boolean a(h hVar) {
        return (hVar.c.b() == 1 ? this.g : this.f).a(hVar);
    }

    public final int c() {
        synchronized (this.h) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int c2 = B8.h.c(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (c2 >= this.a) {
                return 0;
            }
            if (i2 >= this.c) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 <= 0 || this.h.b(i3) != null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i3);
            this.h.c(i3, cVar);
            if (i3 != ((int) (2097151 & k.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return c2 + 1;
        }
    }

    public void close() {
        n(10000L);
    }

    public final h d(Runnable runnable, i iVar) {
        long a2 = l.e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a2, iVar);
        }
        h hVar = (h) runnable;
        hVar.a = a2;
        hVar.c = iVar;
        return hVar;
    }

    public final c e() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !kotlin.jvm.internal.l.a(c.a(cVar), this)) {
            return null;
        }
        return cVar;
    }

    public void execute(Runnable runnable) {
        h(this, runnable, null, false, 6, null);
    }

    public final void g(Runnable runnable, i iVar, boolean z) {
        G8.c.a();
        h d2 = d(runnable, iVar);
        c e = e();
        h q = q(e, d2, z);
        if (q != null && !a(q)) {
            throw new RejectedExecutionException(this.e + " was terminated");
        }
        boolean z2 = z && e != null;
        if (d2.c.b() != 0) {
            o(z2);
        } else {
            if (z2) {
                return;
            }
            p();
        }
    }

    public final int i(c cVar) {
        int g;
        do {
            Object h = cVar.h();
            if (h == m) {
                return -1;
            }
            if (h == null) {
                return 0;
            }
            cVar = (c) h;
            g = cVar.g();
        } while (g == 0);
        return g;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final c j() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            c cVar = (c) this.h.b((int) (2097151 & j2));
            if (cVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int i2 = i(cVar);
            if (i2 >= 0 && j.compareAndSet(this, j2, i2 | j3)) {
                cVar.p(m);
                return cVar;
            }
        }
    }

    public final boolean k(c cVar) {
        long j2;
        int g;
        if (cVar.h() != m) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            g = cVar.g();
            cVar.p(this.h.b((int) (2097151 & j2)));
        } while (!j.compareAndSet(this, j2, ((2097152 + j2) & (-2097152)) | g));
        return true;
    }

    public final void l(c cVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                i4 = i3 == 0 ? i(cVar) : i3;
            }
            if (i4 >= 0 && j.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    public final void m(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(long r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.a.l
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.a$c r0 = r7.e()
            kotlinx.coroutines.internal.w r1 = r7.h
            monitor-enter(r1)
            long r3 = r7.controlState     // Catch: java.lang.Throwable -> L7b
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r4 = (int) r3
            monitor-exit(r1)
            if (r2 > r4) goto L43
            r1 = 1
        L1d:
            kotlinx.coroutines.internal.w r3 = r7.h
            java.lang.Object r3 = r3.b(r1)
            kotlin.jvm.internal.l.b(r3)
            kotlinx.coroutines.scheduling.a$c r3 = (kotlinx.coroutines.scheduling.a.c) r3
            if (r3 == r0) goto L3e
        L2a:
            boolean r5 = r3.isAlive()
            if (r5 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r3)
            r3.join(r8)
            goto L2a
        L37:
            kotlinx.coroutines.scheduling.o r3 = r3.a
            kotlinx.coroutines.scheduling.d r5 = r7.g
            r3.g(r5)
        L3e:
            if (r1 == r4) goto L43
            int r1 = r1 + 1
            goto L1d
        L43:
            kotlinx.coroutines.scheduling.d r8 = r7.g
            r8.b()
            kotlinx.coroutines.scheduling.d r8 = r7.f
            r8.b()
        L4d:
            if (r0 == 0) goto L55
            kotlinx.coroutines.scheduling.h r8 = r0.f(r2)
            if (r8 != 0) goto L77
        L55:
            kotlinx.coroutines.scheduling.d r8 = r7.f
            java.lang.Object r8 = r8.d()
            kotlinx.coroutines.scheduling.h r8 = (kotlinx.coroutines.scheduling.h) r8
            if (r8 != 0) goto L77
            kotlinx.coroutines.scheduling.d r8 = r7.g
            java.lang.Object r8 = r8.d()
            kotlinx.coroutines.scheduling.h r8 = (kotlinx.coroutines.scheduling.h) r8
            if (r8 != 0) goto L77
            if (r0 == 0) goto L70
            kotlinx.coroutines.scheduling.a$d r8 = kotlinx.coroutines.scheduling.a.d.TERMINATED
            r0.s(r8)
        L70:
            r8 = 0
            r7.parkedWorkersStack = r8
            r7.controlState = r8
            return
        L77:
            r7.m(r8)
            goto L4d
        L7b:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.a.n(long):void");
    }

    public final void o(boolean z) {
        long addAndGet = k.addAndGet(this, 2097152L);
        if (z || t() || r(addAndGet)) {
            return;
        }
        t();
    }

    public final void p() {
        if (t() || s(this, 0L, 1, null)) {
            return;
        }
        t();
    }

    public final h q(c cVar, h hVar, boolean z) {
        if (cVar == null || cVar.c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.c.b() == 0 && cVar.c == d.BLOCKING) {
            return hVar;
        }
        cVar.g = true;
        return cVar.a.a(hVar, z);
    }

    public final boolean r(long j2) {
        if (B8.h.c(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.a) {
            int c2 = c();
            if (c2 == 1 && this.a > 1) {
                c();
            }
            if (c2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean t() {
        c j2;
        do {
            j2 = j();
            if (j2 == null) {
                return false;
            }
        } while (!c.i.compareAndSet(j2, -1, 0));
        LockSupport.unpark(j2);
        return true;
    }

    public String toString() {
        StringBuilder sb;
        char c2;
        ArrayList arrayList = new ArrayList();
        int a2 = this.h.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < a2; i7++) {
            c cVar = (c) this.h.b(i7);
            if (cVar != null) {
                int f = cVar.a.f();
                int i8 = b.a[cVar.c.ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        i3++;
                        sb = new StringBuilder();
                        sb.append(f);
                        c2 = 'b';
                    } else if (i8 == 3) {
                        i2++;
                        sb = new StringBuilder();
                        sb.append(f);
                        c2 = 'c';
                    } else if (i8 == 4) {
                        i5++;
                        if (f > 0) {
                            sb = new StringBuilder();
                            sb.append(f);
                            c2 = 'd';
                        }
                    } else if (i8 == 5) {
                        i6++;
                    }
                    sb.append(c2);
                    arrayList.add(sb.toString());
                } else {
                    i4++;
                }
            }
        }
        long j2 = this.controlState;
        return this.e + '@' + P.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.c + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f.c() + ", global blocking queue size = " + this.g.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
