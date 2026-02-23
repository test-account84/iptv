package O2;

import B3.C;
import B3.a0;
import O2.L1;
import O2.Q1;
import O2.b;
import O2.i;
import O2.k1;
import O2.t1;
import O2.u;
import O2.v0;
import O2.x1;
import O2.y;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import f4.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j0 extends j implements y {
    public final i A;
    public final L1 B;
    public final W1 C;
    public final X1 D;
    public final long E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public H1 L;
    public B3.a0 M;
    public boolean N;
    public t1.b O;
    public R0 P;
    public R0 Q;
    public z0 R;
    public z0 S;
    public AudioTrack T;
    public Object U;
    public Surface V;
    public SurfaceHolder W;
    public f4.l X;
    public boolean Y;
    public TextureView Z;
    public int a0;
    public final Z3.D b;
    public int b0;
    public final t1.b c;
    public d4.S c0;
    public final d4.h d;
    public U2.e d0;
    public final Context e;
    public U2.e e0;
    public final t1 f;
    public int f0;
    public final C1[] g;
    public Q2.e g0;
    public final Z3.C h;
    public float h0;
    public final d4.w i;
    public boolean i0;
    public final v0.f j;
    public P3.f j0;
    public final v0 k;
    public boolean k0;
    public final d4.A l;
    public boolean l0;
    public final CopyOnWriteArraySet m;
    public boolean m0;
    public final Q1.b n;
    public boolean n0;
    public final List o;
    public u o0;
    public final boolean p;
    public e4.C p0;
    public final C.a q;
    public R0 q0;
    public final P2.a r;
    public q1 r0;
    public final Looper s;
    public int s0;
    public final b4.f t;
    public int t0;
    public final long u;
    public long u0;
    public final long v;
    public final d4.e w;
    public final c x;
    public final d y;
    public final O2.b z;

    public static final class b {
        public static P2.v0 a(Context context, j0 j0Var, boolean z) {
            P2.t0 w0 = P2.t0.w0(context);
            if (w0 == null) {
                d4.B.j("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new P2.v0(com.google.ads.interactivemedia.v3.internal.X.a());
            }
            if (z) {
                j0Var.W(w0);
            }
            return new P2.v0(w0.D0());
        }
    }

    public final class c implements e4.A, Q2.z, P3.q, q3.f, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, l.b, i.b, b.b, L1.b, y.a {
        public c() {
        }

        public static /* synthetic */ void I(List list, t1.d dVar) {
            Q(list, dVar);
        }

        public static /* synthetic */ void J(q3.a aVar, t1.d dVar) {
            T(aVar, dVar);
        }

        public static /* synthetic */ void K(u uVar, t1.d dVar) {
            V(uVar, dVar);
        }

        public static /* synthetic */ void L(P3.f fVar, t1.d dVar) {
            R(fVar, dVar);
        }

        public static /* synthetic */ void M(boolean z, t1.d dVar) {
            U(z, dVar);
        }

        public static /* synthetic */ void N(int i, boolean z, t1.d dVar) {
            W(i, z, dVar);
        }

        public static /* synthetic */ void O(c cVar, t1.d dVar) {
            cVar.S(dVar);
        }

        public static /* synthetic */ void P(e4.C c, t1.d dVar) {
            X(c, dVar);
        }

        public static /* synthetic */ void Q(List list, t1.d dVar) {
            dVar.k(list);
        }

        public static /* synthetic */ void R(P3.f fVar, t1.d dVar) {
            dVar.u(fVar);
        }

        public static /* synthetic */ void T(q3.a aVar, t1.d dVar) {
            dVar.e(aVar);
        }

        public static /* synthetic */ void U(boolean z, t1.d dVar) {
            dVar.a(z);
        }

        public static /* synthetic */ void V(u uVar, t1.d dVar) {
            dVar.a0(uVar);
        }

        public static /* synthetic */ void W(int i, boolean z, t1.d dVar) {
            dVar.M(i, z);
        }

        public static /* synthetic */ void X(e4.C c, t1.d dVar) {
            dVar.j(c);
        }

        public void A(Surface surface) {
            j0.g1(j0.this, surface);
        }

        public void B(int i, boolean z) {
            j0.v1(j0.this).l(30, new o0(i, z));
        }

        public /* synthetic */ void C(z0 z0Var) {
            Q2.o.f(this, z0Var);
        }

        public /* synthetic */ void D(boolean z) {
            x.a(this, z);
        }

        public void E(boolean z) {
            j0.q1(j0.this);
        }

        public void F(float f) {
            j0.j1(j0.this);
        }

        public void G(int i) {
            boolean E = j0.this.E();
            j0.l1(j0.this, E, i, j0.k1(E, i));
        }

        public /* synthetic */ void H(z0 z0Var) {
            e4.p.i(this, z0Var);
        }

        public final /* synthetic */ void S(t1.d dVar) {
            dVar.i0(j0.d1(j0.this));
        }

        public void a(boolean z) {
            if (j0.X0(j0.this) == z) {
                return;
            }
            j0.Y0(j0.this, z);
            j0.v1(j0.this).l(23, new s0(z));
        }

        public void b(Exception exc) {
            j0.s1(j0.this).b(exc);
        }

        public void c(String str) {
            j0.s1(j0.this).c(str);
        }

        public void d(String str, long j, long j2) {
            j0.s1(j0.this).d(str, j, j2);
        }

        public void e(q3.a aVar) {
            j0 j0Var = j0.this;
            j0.b1(j0Var, j0.a1(j0Var).b().L(aVar).H());
            R0 c1 = j0.c1(j0.this);
            if (!c1.equals(j0.d1(j0.this))) {
                j0.e1(j0.this, c1);
                j0.v1(j0.this).i(14, new m0(this));
            }
            j0.v1(j0.this).i(28, new n0(aVar));
            j0.v1(j0.this).f();
        }

        public void f(String str) {
            j0.s1(j0.this).f(str);
        }

        public void g(String str, long j, long j2) {
            j0.s1(j0.this).g(str, j, j2);
        }

        public void h(U2.e eVar) {
            j0.s1(j0.this).h(eVar);
            j0.t1(j0.this, null);
            j0.r1(j0.this, null);
        }

        public void i(U2.e eVar) {
            j0.x1(j0.this, eVar);
            j0.s1(j0.this).i(eVar);
        }

        public void j(e4.C c) {
            j0.u1(j0.this, c);
            j0.v1(j0.this).l(25, new r0(c));
        }

        public void k(List list) {
            j0.v1(j0.this).l(27, new k0(list));
        }

        public void l(long j) {
            j0.s1(j0.this).l(j);
        }

        public void m(Exception exc) {
            j0.s1(j0.this).m(exc);
        }

        public void n(U2.e eVar) {
            j0.s1(j0.this).n(eVar);
            j0.W0(j0.this, null);
            j0.x1(j0.this, null);
        }

        public void o(int i) {
            u n1 = j0.n1(j0.m1(j0.this));
            if (n1.equals(j0.o1(j0.this))) {
                return;
            }
            j0.p1(j0.this, n1);
            j0.v1(j0.this).l(29, new p0(n1));
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            j0.i1(j0.this, surfaceTexture);
            j0.h1(j0.this, i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            j0.g1(j0.this, null);
            j0.h1(j0.this, 0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            j0.h1(j0.this, i, i2);
        }

        public void p(U2.e eVar) {
            j0.r1(j0.this, eVar);
            j0.s1(j0.this).p(eVar);
        }

        public void q(z0 z0Var, U2.h hVar) {
            j0.t1(j0.this, z0Var);
            j0.s1(j0.this).q(z0Var, hVar);
        }

        public void r(z0 z0Var, U2.h hVar) {
            j0.W0(j0.this, z0Var);
            j0.s1(j0.this).r(z0Var, hVar);
        }

        public void s(int i, long j) {
            j0.s1(j0.this).s(i, j);
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            j0.h1(j0.this, i2, i3);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (j0.f1(j0.this)) {
                j0.g1(j0.this, surfaceHolder.getSurface());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (j0.f1(j0.this)) {
                j0.g1(j0.this, null);
            }
            j0.h1(j0.this, 0, 0);
        }

        public void t() {
            j0.l1(j0.this, false, -1, 3);
        }

        public void u(P3.f fVar) {
            j0.Z0(j0.this, fVar);
            j0.v1(j0.this).l(27, new l0(fVar));
        }

        public void v(Object obj, long j) {
            j0.s1(j0.this).v(obj, j);
            if (j0.w1(j0.this) == obj) {
                j0.v1(j0.this).l(26, new q0());
            }
        }

        public void w(Exception exc) {
            j0.s1(j0.this).w(exc);
        }

        public void x(int i, long j, long j2) {
            j0.s1(j0.this).x(i, j, j2);
        }

        public void y(long j, int i) {
            j0.s1(j0.this).y(j, i);
        }

        public void z(Surface surface) {
            j0.g1(j0.this, null);
        }

        public /* synthetic */ c(j0 j0Var, a aVar) {
            this();
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public static final class d implements e4.m, f4.a, x1.b {
        public e4.m a;
        public f4.a c;
        public e4.m d;
        public f4.a e;

        public d() {
        }

        public void a(long j, long j2, z0 z0Var, MediaFormat mediaFormat) {
            e4.m mVar = this.d;
            if (mVar != null) {
                mVar.a(j, j2, z0Var, mediaFormat);
            }
            e4.m mVar2 = this.a;
            if (mVar2 != null) {
                mVar2.a(j, j2, z0Var, mediaFormat);
            }
        }

        public void b(long j, float[] fArr) {
            f4.a aVar = this.e;
            if (aVar != null) {
                aVar.b(j, fArr);
            }
            f4.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b(j, fArr);
            }
        }

        public void c() {
            f4.a aVar = this.e;
            if (aVar != null) {
                aVar.c();
            }
            f4.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.c();
            }
        }

        public void n(int i, Object obj) {
            f4.a cameraMotionListener;
            if (i == 7) {
                this.a = (e4.m) obj;
                return;
            }
            if (i == 8) {
                this.c = (f4.a) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            f4.l lVar = (f4.l) obj;
            if (lVar == null) {
                cameraMotionListener = null;
                this.d = null;
            } else {
                this.d = lVar.getVideoFrameMetadataListener();
                cameraMotionListener = lVar.getCameraMotionListener();
            }
            this.e = cameraMotionListener;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static final class e implements W0 {
        public final Object a;
        public Q1 b;

        public e(Object obj, Q1 q1) {
            this.a = obj;
            this.b = q1;
        }

        public static /* synthetic */ Q1 c(e eVar, Q1 q1) {
            eVar.b = q1;
            return q1;
        }

        public Object a() {
            return this.a;
        }

        public Q1 b() {
            return this.b;
        }
    }

    static {
        w0.a("goog.exo.exoplayer");
    }

    public j0(y.b bVar, t1 t1Var) {
        d4.h hVar = new d4.h();
        this.d = hVar;
        try {
            d4.B.g("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.19.0] [" + d4.k0.e + "]");
            Context applicationContext = bVar.a.getApplicationContext();
            this.e = applicationContext;
            P2.a aVar = (P2.a) bVar.i.apply(bVar.b);
            this.r = aVar;
            this.g0 = bVar.k;
            this.a0 = bVar.q;
            this.b0 = bVar.r;
            this.i0 = bVar.o;
            this.E = bVar.y;
            c cVar = new c(this, null);
            this.x = cVar;
            d dVar = new d(null);
            this.y = dVar;
            Handler handler = new Handler(bVar.j);
            C1[] a2 = ((G1) bVar.d.get()).a(handler, cVar, cVar, cVar, cVar);
            this.g = a2;
            d4.a.g(a2.length > 0);
            Z3.C c2 = (Z3.C) bVar.f.get();
            this.h = c2;
            this.q = (C.a) bVar.e.get();
            b4.f fVar = (b4.f) bVar.h.get();
            this.t = fVar;
            this.p = bVar.s;
            this.L = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.N = bVar.z;
            Looper looper = bVar.j;
            this.s = looper;
            d4.e eVar = bVar.b;
            this.w = eVar;
            t1 t1Var2 = t1Var == null ? this : t1Var;
            this.f = t1Var2;
            this.l = new d4.A(looper, eVar, new T(this));
            this.m = new CopyOnWriteArraySet();
            this.o = new ArrayList();
            this.M = new a0.a(0);
            Z3.D d2 = new Z3.D(new F1[a2.length], new Z3.s[a2.length], V1.c, null);
            this.b = d2;
            this.n = new Q1.b();
            t1.b e2 = new t1.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 24, 27, 28, 32).d(29, c2.h()).d(23, bVar.p).d(25, bVar.p).d(33, bVar.p).d(26, bVar.p).d(34, bVar.p).e();
            this.c = e2;
            this.O = new t1.b.a().b(e2).a(4).a(10).e();
            this.i = eVar.c(looper, null);
            U u = new U(this);
            this.j = u;
            this.r0 = q1.k(d2);
            aVar.k0(t1Var2, looper);
            int i = d4.k0.a;
            v0 v0Var = new v0(a2, c2, d2, (F0) bVar.g.get(), fVar, this.F, this.G, aVar, this.L, bVar.w, bVar.x, this.N, looper, eVar, u, i < 31 ? new P2.v0() : b.a(applicationContext, this, bVar.A), bVar.B);
            this.k = v0Var;
            this.h0 = 1.0f;
            this.F = 0;
            R0 r0 = R0.J;
            this.P = r0;
            this.Q = r0;
            this.q0 = r0;
            this.s0 = -1;
            this.f0 = i < 21 ? V1(0) : d4.k0.G(applicationContext);
            this.j0 = P3.f.d;
            this.k0 = true;
            B(aVar);
            fVar.g(new Handler(looper), aVar);
            y1(cVar);
            long j = bVar.c;
            if (j > 0) {
                v0Var.w(j);
            }
            O2.b bVar2 = new O2.b(bVar.a, handler, cVar);
            this.z = bVar2;
            bVar2.b(bVar.n);
            i iVar = new i(bVar.a, handler, cVar);
            this.A = iVar;
            iVar.m(bVar.l ? this.g0 : null);
            if (bVar.p) {
                L1 l1 = new L1(bVar.a, handler, cVar);
                this.B = l1;
                l1.h(d4.k0.l0(this.g0.d));
            } else {
                this.B = null;
            }
            W1 w1 = new W1(bVar.a);
            this.C = w1;
            w1.a(bVar.m != 0);
            X1 x1 = new X1(bVar.a);
            this.D = x1;
            x1.a(bVar.m == 2);
            this.o0 = F1(this.B);
            this.p0 = e4.C.f;
            this.c0 = d4.S.c;
            c2.l(this.g0);
            A2(1, 10, Integer.valueOf(this.f0));
            A2(2, 10, Integer.valueOf(this.f0));
            A2(1, 3, this.g0);
            A2(2, 4, Integer.valueOf(this.a0));
            A2(2, 5, Integer.valueOf(this.b0));
            A2(1, 9, Boolean.valueOf(this.i0));
            A2(2, 7, dVar);
            A2(6, 8, dVar);
            hVar.f();
        } catch (Throwable th) {
            this.d.f();
            throw th;
        }
    }

    public static /* synthetic */ void A0(q1 q1Var, t1.d dVar) {
        j2(q1Var, dVar);
    }

    public static /* synthetic */ void B0(q1 q1Var, t1.d dVar) {
        k2(q1Var, dVar);
    }

    public static /* synthetic */ void C0(q1 q1Var, t1.d dVar) {
        l2(q1Var, dVar);
    }

    public static /* synthetic */ void D0(j0 j0Var, t1.d dVar) {
        j0Var.f2(dVar);
    }

    public static /* synthetic */ void E0(q1 q1Var, int i, t1.d dVar) {
        q2(q1Var, i, dVar);
    }

    public static /* synthetic */ void F0(Q2.e eVar, t1.d dVar) {
        b2(eVar, dVar);
    }

    public static u F1(L1 l1) {
        return new u.b(0).g(l1 != null ? l1.d() : 0).f(l1 != null ? l1.c() : 0).e();
    }

    public static /* synthetic */ void G0(j0 j0Var, v0.e eVar) {
        j0Var.Z1(eVar);
    }

    public static /* synthetic */ void H0(q1 q1Var, t1.d dVar) {
        p2(q1Var, dVar);
    }

    public static /* synthetic */ void I0(q1 q1Var, int i, t1.d dVar) {
        g2(q1Var, i, dVar);
    }

    public static /* synthetic */ void J0(q1 q1Var, t1.d dVar) {
        r2(q1Var, dVar);
    }

    public static /* synthetic */ void K0(int i, t1.e eVar, t1.e eVar2, t1.d dVar) {
        h2(i, eVar, eVar2, dVar);
    }

    public static /* synthetic */ void L0(j0 j0Var, t1.d dVar, d4.s sVar) {
        j0Var.X1(dVar, sVar);
    }

    public static /* synthetic */ void M0(j0 j0Var, v0.e eVar) {
        j0Var.Y1(eVar);
    }

    public static /* synthetic */ void N0(t1.d dVar) {
        a2(dVar);
    }

    public static /* synthetic */ void O0(H0 h0, int i, t1.d dVar) {
        i2(h0, i, dVar);
    }

    public static /* synthetic */ void P0(q1 q1Var, t1.d dVar) {
        t2(q1Var, dVar);
    }

    public static int P1(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public static /* synthetic */ void Q0(q1 q1Var, t1.d dVar) {
        s2(q1Var, dVar);
    }

    public static /* synthetic */ void R0(q1 q1Var, t1.d dVar) {
        n2(q1Var, dVar);
    }

    public static /* synthetic */ void S0(Z3.z zVar, t1.d dVar) {
        e2(zVar, dVar);
    }

    public static /* synthetic */ void T0(q1 q1Var, t1.d dVar) {
        o2(q1Var, dVar);
    }

    public static long T1(q1 q1Var) {
        Q1.d dVar = new Q1.d();
        Q1.b bVar = new Q1.b();
        q1Var.a.m(q1Var.b.a, bVar);
        return q1Var.c == -9223372036854775807L ? q1Var.a.s(bVar.d, dVar).e() : bVar.t() + q1Var.c;
    }

    public static /* synthetic */ void U0(int i, t1.d dVar) {
        c2(i, dVar);
    }

    public static /* synthetic */ void V0(boolean z, t1.d dVar) {
        d2(z, dVar);
    }

    public static /* synthetic */ z0 W0(j0 j0Var, z0 z0Var) {
        j0Var.S = z0Var;
        return z0Var;
    }

    public static /* synthetic */ void W1(int i, int i2, t1.d dVar) {
        dVar.U(i, i2);
    }

    public static /* synthetic */ boolean X0(j0 j0Var) {
        return j0Var.i0;
    }

    public static /* synthetic */ boolean Y0(j0 j0Var, boolean z) {
        j0Var.i0 = z;
        return z;
    }

    public static /* synthetic */ P3.f Z0(j0 j0Var, P3.f fVar) {
        j0Var.j0 = fVar;
        return fVar;
    }

    public static /* synthetic */ R0 a1(j0 j0Var) {
        return j0Var.q0;
    }

    public static /* synthetic */ void a2(t1.d dVar) {
        dVar.l0(w.l(new x0(1), 1003));
    }

    public static /* synthetic */ R0 b1(j0 j0Var, R0 r0) {
        j0Var.q0 = r0;
        return r0;
    }

    public static /* synthetic */ void b2(Q2.e eVar, t1.d dVar) {
        dVar.A(eVar);
    }

    public static /* synthetic */ R0 c1(j0 j0Var) {
        return j0Var.C1();
    }

    public static /* synthetic */ void c2(int i, t1.d dVar) {
        dVar.onRepeatModeChanged(i);
    }

    public static /* synthetic */ R0 d1(j0 j0Var) {
        return j0Var.P;
    }

    public static /* synthetic */ void d2(boolean z, t1.d dVar) {
        dVar.J(z);
    }

    public static /* synthetic */ R0 e1(j0 j0Var, R0 r0) {
        j0Var.P = r0;
        return r0;
    }

    public static /* synthetic */ void e2(Z3.z zVar, t1.d dVar) {
        dVar.Y(zVar);
    }

    public static /* synthetic */ boolean f1(j0 j0Var) {
        return j0Var.Y;
    }

    public static /* synthetic */ void g1(j0 j0Var, Object obj) {
        j0Var.G2(obj);
    }

    public static /* synthetic */ void g2(q1 q1Var, int i, t1.d dVar) {
        dVar.V(q1Var.a, i);
    }

    public static /* synthetic */ void h1(j0 j0Var, int i, int i2) {
        j0Var.w2(i, i2);
    }

    public static /* synthetic */ void h2(int i, t1.e eVar, t1.e eVar2, t1.d dVar) {
        dVar.b0(i);
        dVar.S(eVar, eVar2, i);
    }

    public static /* synthetic */ void i1(j0 j0Var, SurfaceTexture surfaceTexture) {
        j0Var.F2(surfaceTexture);
    }

    public static /* synthetic */ void i2(H0 h0, int i, t1.d dVar) {
        dVar.h0(h0, i);
    }

    public static /* synthetic */ void j1(j0 j0Var) {
        j0Var.B2();
    }

    public static /* synthetic */ void j2(q1 q1Var, t1.d dVar) {
        dVar.W(q1Var.f);
    }

    public static /* synthetic */ int k1(boolean z, int i) {
        return P1(z, i);
    }

    public static /* synthetic */ void k2(q1 q1Var, t1.d dVar) {
        dVar.l0(q1Var.f);
    }

    public static /* synthetic */ void l1(j0 j0Var, boolean z, int i, int i2) {
        j0Var.K2(z, i, i2);
    }

    public static /* synthetic */ void l2(q1 q1Var, t1.d dVar) {
        dVar.f0(q1Var.i.d);
    }

    public static /* synthetic */ L1 m1(j0 j0Var) {
        return j0Var.B;
    }

    public static /* synthetic */ void m2(R0 r0, t1.d dVar) {
        dVar.i0(r0);
    }

    public static /* synthetic */ u n1(L1 l1) {
        return F1(l1);
    }

    public static /* synthetic */ void n2(q1 q1Var, t1.d dVar) {
        dVar.B(q1Var.g);
        dVar.d0(q1Var.g);
    }

    public static /* synthetic */ u o1(j0 j0Var) {
        return j0Var.o0;
    }

    public static /* synthetic */ void o2(q1 q1Var, t1.d dVar) {
        dVar.g0(q1Var.l, q1Var.e);
    }

    public static /* synthetic */ u p1(j0 j0Var, u uVar) {
        j0Var.o0 = uVar;
        return uVar;
    }

    public static /* synthetic */ void p2(q1 q1Var, t1.d dVar) {
        dVar.E(q1Var.e);
    }

    public static /* synthetic */ void q1(j0 j0Var) {
        j0Var.N2();
    }

    public static /* synthetic */ void q2(q1 q1Var, int i, t1.d dVar) {
        dVar.j0(q1Var.l, i);
    }

    public static /* synthetic */ U2.e r1(j0 j0Var, U2.e eVar) {
        j0Var.d0 = eVar;
        return eVar;
    }

    public static /* synthetic */ void r2(q1 q1Var, t1.d dVar) {
        dVar.z(q1Var.m);
    }

    public static /* synthetic */ P2.a s1(j0 j0Var) {
        return j0Var.r;
    }

    public static /* synthetic */ void s2(q1 q1Var, t1.d dVar) {
        dVar.n0(q1Var.n());
    }

    public static /* synthetic */ z0 t1(j0 j0Var, z0 z0Var) {
        j0Var.R = z0Var;
        return z0Var;
    }

    public static /* synthetic */ void t2(q1 q1Var, t1.d dVar) {
        dVar.t(q1Var.n);
    }

    public static /* synthetic */ e4.C u1(j0 j0Var, e4.C c2) {
        j0Var.p0 = c2;
        return c2;
    }

    public static /* synthetic */ d4.A v1(j0 j0Var) {
        return j0Var.l;
    }

    public static /* synthetic */ Object w1(j0 j0Var) {
        return j0Var.U;
    }

    public static /* synthetic */ U2.e x1(j0 j0Var, U2.e eVar) {
        j0Var.e0 = eVar;
        return eVar;
    }

    public static /* synthetic */ void y0(int i, int i2, t1.d dVar) {
        W1(i, i2, dVar);
    }

    public static /* synthetic */ void z0(R0 r0, t1.d dVar) {
        m2(r0, dVar);
    }

    public void A(TextureView textureView) {
        O2();
        if (textureView == null) {
            D1();
            return;
        }
        z2();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            d4.B.j("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            G2(null);
            w2(0, 0);
        } else {
            F2(surfaceTexture);
            w2(textureView.getWidth(), textureView.getHeight());
        }
    }

    public void A1(int i, List list) {
        O2();
        d4.a.a(i >= 0);
        int min = Math.min(i, this.o.size());
        if (this.o.isEmpty()) {
            C2(list, this.s0 == -1);
        } else {
            L2(B1(this.r0, min, list), 0, 1, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void A2(int i, int i2, Object obj) {
        for (C1 c1 : this.g) {
            if (c1.getTrackType() == i) {
                I1(c1).n(i2).m(obj).l();
            }
        }
    }

    public void B(t1.d dVar) {
        this.l.c((t1.d) d4.a.e(dVar));
    }

    public final q1 B1(q1 q1Var, int i, List list) {
        Q1 q1 = q1Var.a;
        this.H++;
        List z1 = z1(i, list);
        Q1 G1 = G1();
        q1 u2 = u2(q1Var, G1, O1(q1, G1, N1(q1Var), L1(q1Var)));
        this.k.l(i, z1, this.M);
        return u2;
    }

    public final void B2() {
        A2(1, 2, Float.valueOf(this.h0 * this.A.g()));
    }

    public final R0 C1() {
        Q1 w = w();
        if (w.v()) {
            return this.q0;
        }
        return this.q0.b().J(w.s(X(), this.a).d.f).H();
    }

    public void C2(List list, boolean z) {
        O2();
        D2(list, -1, -9223372036854775807L, z);
    }

    public t1.b D() {
        O2();
        return this.O;
    }

    public void D1() {
        O2();
        z2();
        G2(null);
        w2(0, 0);
    }

    public final void D2(List list, int i, long j, boolean z) {
        int i2;
        long j2;
        int N1 = N1(this.r0);
        long currentPosition = getCurrentPosition();
        this.H++;
        if (!this.o.isEmpty()) {
            y2(0, this.o.size());
        }
        List z1 = z1(0, list);
        Q1 G1 = G1();
        if (!G1.v() && i >= G1.u()) {
            throw new D0(G1, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            i2 = G1.e(this.G);
        } else if (i == -1) {
            i2 = N1;
            j2 = currentPosition;
        } else {
            i2 = i;
            j2 = j;
        }
        q1 u2 = u2(this.r0, G1, v2(G1, i2, j2));
        int i3 = u2.e;
        if (i2 != -1 && i3 != 1) {
            i3 = (G1.v() || i2 >= G1.u()) ? 4 : 2;
        }
        q1 h = u2.h(i3);
        this.k.Q0(z1, i2, d4.k0.P0(j2), this.M);
        L2(h, 0, 1, (this.r0.b.a.equals(h.b.a) || this.r0.a.v()) ? false : true, 4, M1(h), -1, false);
    }

    public boolean E() {
        O2();
        return this.r0.l;
    }

    public void E1(SurfaceHolder surfaceHolder) {
        O2();
        if (surfaceHolder == null || surfaceHolder != this.W) {
            return;
        }
        D1();
    }

    public final void E2(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            w2(0, 0);
        } else {
            Rect surfaceFrame = this.W.getSurfaceFrame();
            w2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public void F(boolean z) {
        O2();
        if (this.G != z) {
            this.G = z;
            this.k.a1(z);
            this.l.i(9, new Y(z));
            J2();
            this.l.f();
        }
    }

    public final void F2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        G2(surface);
        this.V = surface;
    }

    public final Q1 G1() {
        return new y1(this.o, this.M);
    }

    public final void G2(Object obj) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (C1 c1 : this.g) {
            if (c1.getTrackType() == 2) {
                arrayList.add(I1(c1).n(1).m(obj).l());
            }
        }
        Object obj2 = this.U;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((x1) it.next()).a(this.E);
                }
            } catch (TimeoutException unused) {
                z = true;
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z) {
            I2(w.l(new x0(3), 1003));
        }
    }

    public long H() {
        O2();
        return 3000L;
    }

    public final List H1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.q.b((H0) list.get(i)));
        }
        return arrayList;
    }

    public void H2(SurfaceHolder surfaceHolder) {
        O2();
        if (surfaceHolder == null) {
            D1();
            return;
        }
        z2();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            G2(null);
            w2(0, 0);
        } else {
            G2(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            w2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final x1 I1(x1.b bVar) {
        int N1 = N1(this.r0);
        v0 v0Var = this.k;
        return new x1(v0Var, bVar, this.r0.a, N1 == -1 ? 0 : N1, this.w, v0Var.D());
    }

    public final void I2(w wVar) {
        q1 q1Var = this.r0;
        q1 c2 = q1Var.c(q1Var.b);
        c2.p = c2.r;
        c2.q = 0L;
        q1 h = c2.h(1);
        if (wVar != null) {
            h = h.f(wVar);
        }
        this.H++;
        this.k.k1();
        L2(h, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public int J() {
        O2();
        if (this.r0.a.v()) {
            return this.t0;
        }
        q1 q1Var = this.r0;
        return q1Var.a.f(q1Var.b.a);
    }

    public final Pair J1(q1 q1Var, q1 q1Var2, boolean z, int i, boolean z2, boolean z3) {
        Q1 q1 = q1Var2.a;
        Q1 q12 = q1Var.a;
        if (q12.v() && q1.v()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (q12.v() != q1.v()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (q1.s(q1.m(q1Var2.b.a, this.n).d, this.a).a.equals(q12.s(q12.m(q1Var.b.a, this.n).d, this.a).a)) {
            return (z && i == 0 && q1Var2.b.d < q1Var.b.d) ? new Pair(Boolean.TRUE, 0) : (z && i == 1 && z3) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i2));
    }

    public final void J2() {
        t1.b bVar = this.O;
        t1.b J = d4.k0.J(this.f, this.c);
        this.O = J;
        if (J.equals(bVar)) {
            return;
        }
        this.l.i(13, new a0(this));
    }

    public void K(TextureView textureView) {
        O2();
        if (textureView == null || textureView != this.Z) {
            return;
        }
        D1();
    }

    public boolean K1() {
        O2();
        return this.r0.o;
    }

    public final void K2(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        q1 q1Var = this.r0;
        if (q1Var.l == z2 && q1Var.m == i3) {
            return;
        }
        this.H++;
        if (q1Var.o) {
            q1Var = q1Var.a();
        }
        q1 e2 = q1Var.e(z2, i3);
        this.k.T0(z2, i3);
        L2(e2, 0, i2, false, 5, -9223372036854775807L, -1, false);
    }

    public e4.C L() {
        O2();
        return this.p0;
    }

    public final long L1(q1 q1Var) {
        if (!q1Var.b.b()) {
            return d4.k0.x1(M1(q1Var));
        }
        q1Var.a.m(q1Var.b.a, this.n);
        return q1Var.c == -9223372036854775807L ? q1Var.a.s(N1(q1Var), this.a).d() : this.n.s() + d4.k0.x1(q1Var.c);
    }

    public final void L2(q1 q1Var, int i, int i2, boolean z, int i3, long j, int i4, boolean z2) {
        q1 q1Var2 = this.r0;
        this.r0 = q1Var;
        boolean z3 = !q1Var2.a.equals(q1Var.a);
        Pair J1 = J1(q1Var, q1Var2, z, i3, z3, z2);
        boolean booleanValue = ((Boolean) J1.first).booleanValue();
        int intValue = ((Integer) J1.second).intValue();
        R0 r0 = this.P;
        if (booleanValue) {
            r3 = q1Var.a.v() ? null : q1Var.a.s(q1Var.a.m(q1Var.b.a, this.n).d, this.a).d;
            this.q0 = R0.J;
        }
        if (booleanValue || !q1Var2.j.equals(q1Var.j)) {
            this.q0 = this.q0.b().K(q1Var.j).H();
            r0 = C1();
        }
        boolean z4 = !r0.equals(this.P);
        this.P = r0;
        boolean z5 = q1Var2.l != q1Var.l;
        boolean z6 = q1Var2.e != q1Var.e;
        if (z6 || z5) {
            N2();
        }
        boolean z7 = q1Var2.g;
        boolean z8 = q1Var.g;
        boolean z9 = z7 != z8;
        if (z9) {
            M2(z8);
        }
        if (z3) {
            this.l.i(0, new K(q1Var, i));
        }
        if (z) {
            this.l.i(11, new e0(i3, S1(i3, q1Var2, i4), R1(j)));
        }
        if (booleanValue) {
            this.l.i(1, new f0(r3, intValue));
        }
        if (q1Var2.f != q1Var.f) {
            this.l.i(10, new g0(q1Var));
            if (q1Var.f != null) {
                this.l.i(10, new h0(q1Var));
            }
        }
        Z3.D d2 = q1Var2.i;
        Z3.D d3 = q1Var.i;
        if (d2 != d3) {
            this.h.i(d3.e);
            this.l.i(2, new i0(q1Var));
        }
        if (z4) {
            this.l.i(14, new L(this.P));
        }
        if (z9) {
            this.l.i(3, new M(q1Var));
        }
        if (z6 || z5) {
            this.l.i(-1, new N(q1Var));
        }
        if (z6) {
            this.l.i(4, new O(q1Var));
        }
        if (z5) {
            this.l.i(5, new W(q1Var, i2));
        }
        if (q1Var2.m != q1Var.m) {
            this.l.i(6, new b0(q1Var));
        }
        if (q1Var2.n() != q1Var.n()) {
            this.l.i(7, new c0(q1Var));
        }
        if (!q1Var2.n.equals(q1Var.n)) {
            this.l.i(12, new d0(q1Var));
        }
        J2();
        this.l.f();
        if (q1Var2.o != q1Var.o) {
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((y.a) it.next()).E(q1Var.o);
            }
        }
    }

    public final long M1(q1 q1Var) {
        if (q1Var.a.v()) {
            return d4.k0.P0(this.u0);
        }
        long m = q1Var.o ? q1Var.m() : q1Var.r;
        return q1Var.b.b() ? m : x2(q1Var.a, q1Var.b, m);
    }

    public int N() {
        O2();
        if (d()) {
            return this.r0.b.c;
        }
        return -1;
    }

    public final int N1(q1 q1Var) {
        return q1Var.a.v() ? this.s0 : q1Var.a.m(q1Var.b.a, this.n).d;
    }

    public final void N2() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.C.b(E() && !K1());
                this.D.b(E());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    public void O(Q2.e eVar, boolean z) {
        O2();
        if (this.n0) {
            return;
        }
        if (!d4.k0.c(this.g0, eVar)) {
            this.g0 = eVar;
            A2(1, 3, eVar);
            L1 l1 = this.B;
            if (l1 != null) {
                l1.h(d4.k0.l0(eVar.d));
            }
            this.l.i(20, new P(eVar));
        }
        this.A.m(z ? eVar : null);
        this.h.l(eVar);
        boolean E = E();
        int p = this.A.p(E, getPlaybackState());
        K2(E, p, P1(E, p));
        this.l.f();
    }

    public final Pair O1(Q1 q1, Q1 q12, int i, long j) {
        if (q1.v() || q12.v()) {
            boolean z = !q1.v() && q12.v();
            return v2(q12, z ? -1 : i, z ? -9223372036854775807L : j);
        }
        Pair o = q1.o(this.a, this.n, i, d4.k0.P0(j));
        Object obj = ((Pair) d4.k0.j(o)).first;
        if (q12.f(obj) != -1) {
            return o;
        }
        Object B0 = v0.B0(this.a, this.n, this.F, this.G, obj, q1, q12);
        if (B0 == null) {
            return v2(q12, -1, -9223372036854775807L);
        }
        q12.m(B0, this.n);
        int i2 = this.n.d;
        return v2(q12, i2, q12.s(i2, this.a).d());
    }

    public final void O2() {
        this.d.c();
        if (Thread.currentThread() != x().getThread()) {
            String D = d4.k0.D("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), x().getThread().getName());
            if (this.k0) {
                throw new IllegalStateException(D);
            }
            d4.B.k("ExoPlayerImpl", D, this.l0 ? null : new IllegalStateException());
            this.l0 = true;
        }
    }

    public long P() {
        O2();
        return this.v;
    }

    public U2.e Q() {
        O2();
        return this.d0;
    }

    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public w n() {
        O2();
        return this.r0.f;
    }

    public long R() {
        O2();
        return L1(this.r0);
    }

    public final t1.e R1(long j) {
        Object obj;
        H0 h0;
        Object obj2;
        int i;
        int X = X();
        if (this.r0.a.v()) {
            obj = null;
            h0 = null;
            obj2 = null;
            i = -1;
        } else {
            q1 q1Var = this.r0;
            Object obj3 = q1Var.b.a;
            q1Var.a.m(obj3, this.n);
            i = this.r0.a.f(obj3);
            obj2 = obj3;
            obj = this.r0.a.s(X, this.a).a;
            h0 = this.a.d;
        }
        long x1 = d4.k0.x1(j);
        long x12 = this.r0.b.b() ? d4.k0.x1(T1(this.r0)) : x1;
        C.b bVar = this.r0.b;
        return new t1.e(obj, X, h0, obj2, i, x1, x12, bVar.b, bVar.c);
    }

    public z0 S() {
        O2();
        return this.S;
    }

    public final t1.e S1(int i, q1 q1Var, int i2) {
        int i3;
        Object obj;
        H0 h0;
        Object obj2;
        int i4;
        long j;
        long j2;
        Q1.b bVar = new Q1.b();
        if (q1Var.a.v()) {
            i3 = i2;
            obj = null;
            h0 = null;
            obj2 = null;
            i4 = -1;
        } else {
            Object obj3 = q1Var.b.a;
            q1Var.a.m(obj3, bVar);
            int i5 = bVar.d;
            int f = q1Var.a.f(obj3);
            Object obj4 = q1Var.a.s(i5, this.a).a;
            h0 = this.a.d;
            obj2 = obj3;
            i4 = f;
            obj = obj4;
            i3 = i5;
        }
        boolean b2 = q1Var.b.b();
        if (i == 0) {
            if (b2) {
                C.b bVar2 = q1Var.b;
                j = bVar.e(bVar2.b, bVar2.c);
                j2 = T1(q1Var);
            } else {
                j = q1Var.b.e != -1 ? T1(this.r0) : bVar.f + bVar.e;
                j2 = j;
            }
        } else if (b2) {
            j = q1Var.r;
            j2 = T1(q1Var);
        } else {
            j = bVar.f + q1Var.r;
            j2 = j;
        }
        long x1 = d4.k0.x1(j);
        long x12 = d4.k0.x1(j2);
        C.b bVar3 = q1Var.b;
        return new t1.e(obj, i3, h0, obj2, i4, x1, x12, bVar3.b, bVar3.c);
    }

    public void T(int i, List list) {
        O2();
        A1(i, H1(list));
    }

    public long U() {
        O2();
        if (!d()) {
            return a0();
        }
        q1 q1Var = this.r0;
        return q1Var.k.equals(q1Var.b) ? d4.k0.x1(this.r0.p) : getDuration();
    }

    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public final void Y1(v0.e eVar) {
        long j;
        boolean z;
        long j2;
        int i = this.H - eVar.c;
        this.H = i;
        boolean z2 = true;
        if (eVar.d) {
            this.I = eVar.e;
            this.J = true;
        }
        if (eVar.f) {
            this.K = eVar.g;
        }
        if (i == 0) {
            Q1 q1 = eVar.b.a;
            if (!this.r0.a.v() && q1.v()) {
                this.s0 = -1;
                this.u0 = 0L;
                this.t0 = 0;
            }
            if (!q1.v()) {
                List K = ((y1) q1).K();
                d4.a.g(K.size() == this.o.size());
                for (int i2 = 0; i2 < K.size(); i2++) {
                    e.c((e) this.o.get(i2), (Q1) K.get(i2));
                }
            }
            if (this.J) {
                if (eVar.b.b.equals(this.r0.b) && eVar.b.d == this.r0.r) {
                    z2 = false;
                }
                if (z2) {
                    if (q1.v() || eVar.b.b.b()) {
                        j2 = eVar.b.d;
                    } else {
                        q1 q1Var = eVar.b;
                        j2 = x2(q1, q1Var.b, q1Var.d);
                    }
                    j = j2;
                } else {
                    j = -9223372036854775807L;
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.J = false;
            L2(eVar.b, 1, this.K, z, this.I, j, -1, false);
        }
    }

    public final int V1(int i) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.T.getAudioSessionId();
    }

    public void W(P2.c cVar) {
        this.r.X((P2.c) d4.a.e(cVar));
    }

    public int X() {
        O2();
        int N1 = N1(this.r0);
        if (N1 == -1) {
            return 0;
        }
        return N1;
    }

    public final /* synthetic */ void X1(t1.d dVar, d4.s sVar) {
        dVar.m0(this.f, new t1.c(sVar));
    }

    public void Y(SurfaceView surfaceView) {
        O2();
        E1(surfaceView == null ? null : surfaceView.getHolder());
    }

    public boolean Z() {
        O2();
        return this.G;
    }

    public final /* synthetic */ void Z1(v0.e eVar) {
        this.i.i(new Z(this, eVar));
    }

    public z0 a() {
        O2();
        return this.R;
    }

    public long a0() {
        O2();
        if (this.r0.a.v()) {
            return this.u0;
        }
        q1 q1Var = this.r0;
        if (q1Var.k.d != q1Var.b.d) {
            return q1Var.a.s(X(), this.a).f();
        }
        long j = q1Var.p;
        if (this.r0.k.b()) {
            q1 q1Var2 = this.r0;
            Q1.b m = q1Var2.a.m(q1Var2.k.a, this.n);
            long j2 = m.j(this.r0.k.b);
            j = j2 == Long.MIN_VALUE ? m.e : j2;
        }
        q1 q1Var3 = this.r0;
        return d4.k0.x1(x2(q1Var3.a, q1Var3.k, j));
    }

    public void b(s1 s1Var) {
        O2();
        if (s1Var == null) {
            s1Var = s1.e;
        }
        if (this.r0.n.equals(s1Var)) {
            return;
        }
        q1 g = this.r0.g(s1Var);
        this.H++;
        this.k.V0(s1Var);
        L2(g, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public s1 c() {
        O2();
        return this.r0.n;
    }

    public U2.e c0() {
        O2();
        return this.e0;
    }

    public boolean d() {
        O2();
        return this.r0.b.b();
    }

    public long e() {
        O2();
        return d4.k0.x1(this.r0.q);
    }

    public R0 e0() {
        O2();
        return this.P;
    }

    public long f0() {
        O2();
        return this.u;
    }

    public final /* synthetic */ void f2(t1.d dVar) {
        dVar.O(this.O);
    }

    public long getCurrentPosition() {
        O2();
        return d4.k0.x1(M1(this.r0));
    }

    public long getDuration() {
        O2();
        if (!d()) {
            return I();
        }
        q1 q1Var = this.r0;
        C.b bVar = q1Var.b;
        q1Var.a.m(bVar.a, this.n);
        return d4.k0.x1(this.n.e(bVar.b, bVar.c));
    }

    public int getPlaybackState() {
        O2();
        return this.r0.e;
    }

    public int getRepeatMode() {
        O2();
        return this.F;
    }

    public float getVolume() {
        O2();
        return this.h0;
    }

    public void h(List list, boolean z) {
        O2();
        C2(H1(list), z);
    }

    public void i(Z3.z zVar) {
        O2();
        if (!this.h.h() || zVar.equals(this.h.c())) {
            return;
        }
        this.h.m(zVar);
        this.l.l(19, new S(zVar));
    }

    public void j(SurfaceView surfaceView) {
        O2();
        if (surfaceView instanceof e4.l) {
            z2();
            G2(surfaceView);
        } else {
            if (!(surfaceView instanceof f4.l)) {
                H2(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            z2();
            this.X = (f4.l) surfaceView;
            I1(this.y).n(10000).m(this.X).l();
            this.X.d(this.x);
            G2(this.X.getVideoSurface());
        }
        E2(surfaceView.getHolder());
    }

    public void l(t1.d dVar) {
        O2();
        this.l.k((t1.d) d4.a.e(dVar));
    }

    public void o(boolean z) {
        O2();
        int p = this.A.p(z, getPlaybackState());
        K2(z, p, P1(z, p));
    }

    public V1 p() {
        O2();
        return this.r0.i.d;
    }

    public void prepare() {
        O2();
        boolean E = E();
        int p = this.A.p(E, 2);
        K2(E, p, P1(E, p));
        q1 q1Var = this.r0;
        if (q1Var.e != 1) {
            return;
        }
        q1 f = q1Var.f(null);
        q1 h = f.h(f.a.v() ? 4 : 2);
        this.H++;
        this.k.k0();
        L2(h, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public void q0(int i, long j, int i2, boolean z) {
        O2();
        d4.a.a(i >= 0);
        this.r.H();
        Q1 q1 = this.r0.a;
        if (q1.v() || i < q1.u()) {
            this.H++;
            if (d()) {
                d4.B.j("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                v0.e eVar = new v0.e(this.r0);
                eVar.b(1);
                this.j.a(eVar);
                return;
            }
            q1 q1Var = this.r0;
            int i3 = q1Var.e;
            if (i3 == 3 || (i3 == 4 && !q1.v())) {
                q1Var = this.r0.h(2);
            }
            int X = X();
            q1 u2 = u2(q1Var, q1, v2(q1, i, j));
            this.k.D0(q1, i, d4.k0.P0(j));
            L2(u2, 0, 1, true, 1, M1(u2), X, z);
        }
    }

    public P3.f r() {
        O2();
        return this.j0;
    }

    public void release() {
        AudioTrack audioTrack;
        d4.B.g("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.19.0] [" + d4.k0.e + "] [" + w0.b() + "]");
        O2();
        if (d4.k0.a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.z.b(false);
        L1 l1 = this.B;
        if (l1 != null) {
            l1.g();
        }
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.k.m0()) {
            this.l.l(10, new Q());
        }
        this.l.j();
        this.i.e(null);
        this.t.h(this.r);
        q1 q1Var = this.r0;
        if (q1Var.o) {
            this.r0 = q1Var.a();
        }
        q1 h = this.r0.h(1);
        this.r0 = h;
        q1 c2 = h.c(h.b);
        this.r0 = c2;
        c2.p = c2.r;
        this.r0.q = 0L;
        this.r.release();
        this.h.j();
        z2();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.m0) {
            d.D.a(d4.a.e(null));
            throw null;
        }
        this.j0 = P3.f.d;
        this.n0 = true;
    }

    public int s() {
        O2();
        if (d()) {
            return this.r0.b.b;
        }
        return -1;
    }

    public void setRepeatMode(int i) {
        O2();
        if (this.F != i) {
            this.F = i;
            this.k.X0(i);
            this.l.i(8, new V(i));
            J2();
            this.l.f();
        }
    }

    public final q1 u2(q1 q1Var, Q1 q1, Pair pair) {
        long j;
        d4.a.a(q1.v() || pair != null);
        Q1 q12 = q1Var.a;
        long L1 = L1(q1Var);
        q1 j2 = q1Var.j(q1);
        if (q1.v()) {
            C.b l = q1.l();
            long P0 = d4.k0.P0(this.u0);
            q1 c2 = j2.d(l, P0, P0, P0, 0L, B3.i0.e, this.b, s5.y.z()).c(l);
            c2.p = c2.r;
            return c2;
        }
        Object obj = j2.b.a;
        boolean z = !obj.equals(((Pair) d4.k0.j(pair)).first);
        C.b bVar = z ? new C.b(pair.first) : j2.b;
        long longValue = ((Long) pair.second).longValue();
        long P02 = d4.k0.P0(L1);
        if (!q12.v()) {
            P02 -= q12.m(obj, this.n).t();
        }
        if (z || longValue < P02) {
            d4.a.g(!bVar.b());
            q1 c3 = j2.d(bVar, longValue, longValue, longValue, 0L, z ? B3.i0.e : j2.h, z ? this.b : j2.i, z ? s5.y.z() : j2.j).c(bVar);
            c3.p = longValue;
            return c3;
        }
        if (longValue == P02) {
            int f = q1.f(j2.k.a);
            if (f == -1 || q1.k(f, this.n).d != q1.m(bVar.a, this.n).d) {
                q1.m(bVar.a, this.n);
                j = bVar.b() ? this.n.e(bVar.b, bVar.c) : this.n.e;
                j2 = j2.d(bVar, j2.r, j2.r, j2.d, j - j2.r, j2.h, j2.i, j2.j).c(bVar);
            }
            return j2;
        }
        d4.a.g(!bVar.b());
        long max = Math.max(0L, j2.q - (longValue - P02));
        j = j2.p;
        if (j2.k.equals(j2.b)) {
            j = longValue + max;
        }
        j2 = j2.d(bVar, longValue, longValue, longValue, max, j2.h, j2.i, j2.j);
        j2.p = j;
        return j2;
    }

    public int v() {
        O2();
        return this.r0.m;
    }

    public final Pair v2(Q1 q1, int i, long j) {
        if (q1.v()) {
            this.s0 = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.u0 = j;
            this.t0 = 0;
            return null;
        }
        if (i == -1 || i >= q1.u()) {
            i = q1.e(this.G);
            j = q1.s(i, this.a).d();
        }
        return q1.o(this.a, this.n, i, d4.k0.P0(j));
    }

    public Q1 w() {
        O2();
        return this.r0.a;
    }

    public final void w2(int i, int i2) {
        if (i == this.c0.b() && i2 == this.c0.a()) {
            return;
        }
        this.c0 = new d4.S(i, i2);
        this.l.l(24, new X(i, i2));
        A2(2, 14, new d4.S(i, i2));
    }

    public Looper x() {
        return this.s;
    }

    public final long x2(Q1 q1, C.b bVar, long j) {
        q1.m(bVar.a, this.n);
        return j + this.n.t();
    }

    public Z3.z y() {
        O2();
        return this.h.c();
    }

    public void y1(y.a aVar) {
        this.m.add(aVar);
    }

    public final void y2(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.o.remove(i3);
        }
        this.M = this.M.a(i, i2);
    }

    public final List z1(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            k1.c cVar = new k1.c((B3.C) list.get(i2), this.p);
            arrayList.add(cVar);
            this.o.add(i2 + i, new e(cVar.b, cVar.a.J0()));
        }
        this.M = this.M.g(i, arrayList.size());
        return arrayList;
    }

    public final void z2() {
        if (this.X != null) {
            I1(this.y).n(10000).m(null).l();
            this.X.i(this.x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.x) {
                d4.B.j("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.x);
            this.W = null;
        }
    }

    public final void M2(boolean z) {
    }
}
