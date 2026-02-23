package G8;

import G8.V;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class i0 extends j0 implements V {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(i0.class, Object.class, "_queue");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(i0.class, Object.class, "_delayed");

    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @NotNull
    private volatile /* synthetic */ Object _delayed = null;

    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;

    public static final class a extends b {
        public final Runnable d;

        public a(long j, Runnable runnable) {
            super(j);
            this.d = runnable;
        }

        public void run() {
            this.d.run();
        }

        public String toString() {
            return super.toString() + this.d;
        }
    }

    public static abstract class b implements Runnable, Comparable, d0, kotlinx.coroutines.internal.E {

        @Nullable
        private volatile Object _heap;
        public long a;
        public int c = -1;

        public b(long j) {
            this.a = j;
        }

        public void a(kotlinx.coroutines.internal.D d) {
            if (this._heap == l0.b()) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = d;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j = this.a - bVar.a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:10:0x000d, B:17:0x0023, B:18:0x003b, B:20:0x0044, B:21:0x0046, B:26:0x0028, B:29:0x0032), top: B:9:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized int d(long r8, G8.i0.c r10, G8.i0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch: java.lang.Throwable -> L1d
                kotlinx.coroutines.internal.y r1 = G8.l0.b()     // Catch: java.lang.Throwable -> L1d
                if (r0 != r1) goto Lc
                monitor-exit(r7)
                r8 = 2
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L1d
                kotlinx.coroutines.internal.E r0 = r10.b()     // Catch: java.lang.Throwable -> L26
                G8.i0$b r0 = (G8.i0.b) r0     // Catch: java.lang.Throwable -> L26
                boolean r11 = G8.i0.u0(r11)     // Catch: java.lang.Throwable -> L26
                if (r11 == 0) goto L1f
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1d
                monitor-exit(r7)
                r8 = 1
                return r8
            L1d:
                r8 = move-exception
                goto L4f
            L1f:
                r1 = 0
                if (r0 != 0) goto L28
            L23:
                r10.b = r8     // Catch: java.lang.Throwable -> L26
                goto L3b
            L26:
                r8 = move-exception
                goto L4d
            L28:
                long r3 = r0.a     // Catch: java.lang.Throwable -> L26
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L31
                goto L32
            L31:
                r8 = r3
            L32:
                long r3 = r10.b     // Catch: java.lang.Throwable -> L26
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L3b
                goto L23
            L3b:
                long r8 = r7.a     // Catch: java.lang.Throwable -> L26
                long r3 = r10.b     // Catch: java.lang.Throwable -> L26
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L46
                r7.a = r3     // Catch: java.lang.Throwable -> L26
            L46:
                r10.a(r7)     // Catch: java.lang.Throwable -> L26
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1d
                monitor-exit(r7)
                r8 = 0
                return r8
            L4d:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1d
                throw r8     // Catch: java.lang.Throwable -> L1d
            L4f:
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: G8.i0.b.d(long, G8.i0$c, G8.i0):int");
        }

        public final synchronized void dispose() {
            try {
                Object obj = this._heap;
                if (obj == l0.b()) {
                    return;
                }
                c cVar = obj instanceof c ? (c) obj : null;
                if (cVar != null) {
                    cVar.g(this);
                }
                this._heap = l0.b();
            } catch (Throwable th) {
                throw th;
            }
        }

        public final boolean e(long j) {
            return j - this.a >= 0;
        }

        public int getIndex() {
            return this.c;
        }

        public kotlinx.coroutines.internal.D h() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.D) {
                return (kotlinx.coroutines.internal.D) obj;
            }
            return null;
        }

        public void i(int i) {
            this.c = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    public static final class c extends kotlinx.coroutines.internal.D {
        public long b;

        public c(long j) {
            this.b = j;
        }
    }

    public static final /* synthetic */ boolean u0(i0 i0Var) {
        return i0Var.z0();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private final boolean z0() {
        return this._isCompleted;
    }

    public boolean A0() {
        if (!n0()) {
            return false;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.o) {
                return ((kotlinx.coroutines.internal.o) obj).g();
            }
            if (obj != l0.a()) {
                return false;
            }
        }
        return true;
    }

    public final void B0() {
        b bVar;
        G8.c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) this._delayed;
            if (cVar == null || (bVar = (b) cVar.i()) == null) {
                return;
            } else {
                s0(nanoTime, bVar);
            }
        }
    }

    public final void C0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void D0(long j, b bVar) {
        int E0 = E0(j, bVar);
        if (E0 == 0) {
            if (H0(bVar)) {
                t0();
            }
        } else if (E0 == 1) {
            s0(j, bVar);
        } else if (E0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int E0(long j, b bVar) {
        if (z0()) {
            return 1;
        }
        c cVar = (c) this._delayed;
        if (cVar == null) {
            t.b.a(h, this, (Object) null, new c(j));
            Object obj = this._delayed;
            kotlin.jvm.internal.l.b(obj);
            cVar = (c) obj;
        }
        return bVar.d(j, cVar, this);
    }

    public final d0 F0(long j, Runnable runnable) {
        long c2 = l0.c(j);
        if (c2 >= 4611686018427387903L) {
            return K0.a;
        }
        G8.c.a();
        long nanoTime = System.nanoTime();
        a aVar = new a(c2 + nanoTime, runnable);
        D0(nanoTime, aVar);
        return aVar;
    }

    public final void G0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    public final boolean H0(b bVar) {
        c cVar = (c) this._delayed;
        return (cVar != null ? (b) cVar.e() : null) == bVar;
    }

    public final void c0(o8.g gVar, Runnable runnable) {
        x0(runnable);
    }

    public long j0() {
        b bVar;
        if (super.j0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.o)) {
                return obj == l0.a() ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.o) obj).g()) {
                return 0L;
            }
        }
        c cVar = (c) this._delayed;
        if (cVar == null || (bVar = (b) cVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j = bVar.a;
        G8.c.a();
        return B8.h.d(j - System.nanoTime(), 0L);
    }

    public long o0() {
        kotlinx.coroutines.internal.E e;
        if (p0()) {
            return 0L;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.d()) {
            G8.c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (cVar) {
                    try {
                        kotlinx.coroutines.internal.E b2 = cVar.b();
                        e = null;
                        if (b2 != null) {
                            b bVar = (b) b2;
                            if (bVar.e(nanoTime) ? y0(bVar) : false) {
                                e = cVar.h(0);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((b) e) != null);
        }
        Runnable w0 = w0();
        if (w0 == null) {
            return j0();
        }
        w0.run();
        return 0L;
    }

    public void shutdown() {
        U0.a.c();
        G0(true);
        v0();
        while (o0() <= 0) {
        }
        B0();
    }

    public d0 t(long j, Runnable runnable, o8.g gVar) {
        return V.a.a(this, j, runnable, gVar);
    }

    public final void v0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (t.b.a(g, this, (Object) null, l0.a())) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.o) {
                ((kotlinx.coroutines.internal.o) obj).d();
                return;
            } else {
                if (obj == l0.a()) {
                    return;
                }
                kotlinx.coroutines.internal.o oVar = new kotlinx.coroutines.internal.o(8, true);
                oVar.a((Runnable) obj);
                if (t.b.a(g, this, obj, oVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable w0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.o) {
                kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) obj;
                Object j = oVar.j();
                if (j != kotlinx.coroutines.internal.o.h) {
                    return (Runnable) j;
                }
                t.b.a(g, this, obj, oVar.i());
            } else {
                if (obj == l0.a()) {
                    return null;
                }
                if (t.b.a(g, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void x0(Runnable runnable) {
        if (y0(runnable)) {
            t0();
        } else {
            Q.i.x0(runnable);
        }
    }

    public final boolean y0(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (z0()) {
                return false;
            }
            if (obj == null) {
                if (t.b.a(g, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.o) {
                kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) obj;
                int a2 = oVar.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    t.b.a(g, this, obj, oVar.i());
                } else if (a2 == 2) {
                    return false;
                }
            } else {
                if (obj == l0.a()) {
                    return false;
                }
                kotlinx.coroutines.internal.o oVar2 = new kotlinx.coroutines.internal.o(8, true);
                oVar2.a((Runnable) obj);
                oVar2.a(runnable);
                if (t.b.a(g, this, obj, oVar2)) {
                    return true;
                }
            }
        }
    }
}
