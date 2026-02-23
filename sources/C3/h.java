package C3;

import B3.C;
import B3.J;
import B3.u;
import B3.v;
import B3.z;
import C3.b;
import C3.e;
import O2.H0;
import O2.Q1;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import b4.S;
import b4.s;
import d4.k0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends B3.g {
    public static final C.b y = new C.b(new Object());
    public final C l;
    public final H0.f m;
    public final C.a n;
    public final e o;
    public final a4.b p;
    public final s q;
    public final Object r;
    public d u;
    public Q1 v;
    public C3.b w;
    public final Handler s = new Handler(Looper.getMainLooper());
    public final Q1.b t = new Q1.b();
    public b[][] x = new b[0][];

    public static final class a extends IOException {
        public final int a;

        public a(int i, Exception exc) {
            super(exc);
            this.a = i;
        }

        public static a a(Exception exc) {
            return new a(0, exc);
        }

        public static a b(Exception exc, int i) {
            return new a(1, new IOException("Failed to load ad group " + i, exc));
        }

        public static a c(Exception exc) {
            return new a(2, exc);
        }

        public static a d(RuntimeException runtimeException) {
            return new a(3, runtimeException);
        }
    }

    public final class b {
        public final C.b a;
        public final List b = new ArrayList();
        public Uri c;
        public C d;
        public Q1 e;

        public b(C.b bVar) {
            this.a = bVar;
        }

        public z a(C.b bVar, b4.b bVar2, long j) {
            v vVar = new v(bVar, bVar2, j);
            this.b.add(vVar);
            C c = this.d;
            if (c != null) {
                vVar.y(c);
                vVar.z(h.this.new c((Uri) d4.a.e(this.c)));
            }
            Q1 q1 = this.e;
            if (q1 != null) {
                vVar.a(new C.b(q1.r(0), bVar.d));
            }
            return vVar;
        }

        public long b() {
            Q1 q1 = this.e;
            if (q1 == null) {
                return -9223372036854775807L;
            }
            return q1.k(0, h.E0(h.this)).p();
        }

        public void c(Q1 q1) {
            d4.a.a(q1.n() == 1);
            if (this.e == null) {
                Object r = q1.r(0);
                for (int i = 0; i < this.b.size(); i++) {
                    v vVar = (v) this.b.get(i);
                    vVar.a(new C.b(r, vVar.a.d));
                }
            }
            this.e = q1;
        }

        public boolean d() {
            return this.d != null;
        }

        public void e(C c, Uri uri) {
            this.d = c;
            this.c = uri;
            for (int i = 0; i < this.b.size(); i++) {
                v vVar = (v) this.b.get(i);
                vVar.y(c);
                vVar.z(h.this.new c(uri));
            }
            h.D0(h.this, this.a, c);
        }

        public boolean f() {
            return this.b.isEmpty();
        }

        public void g() {
            if (d()) {
                h.F0(h.this, this.a);
            }
        }

        public void h(v vVar) {
            this.b.remove(vVar);
            vVar.x();
        }
    }

    public final class c implements v.a {
        public final Uri a;

        public c(Uri uri) {
            this.a = uri;
        }

        public static /* synthetic */ void c(c cVar, C.b bVar) {
            cVar.e(bVar);
        }

        public static /* synthetic */ void d(c cVar, C.b bVar, IOException iOException) {
            cVar.f(bVar, iOException);
        }

        public void a(C.b bVar) {
            h.A0(h.this).post(new j(this, bVar));
        }

        public void b(C.b bVar, IOException iOException) {
            h.B0(h.this, bVar).w(new u(u.a(), new s(this.a), SystemClock.elapsedRealtime()), 6, a.a(iOException), true);
            h.A0(h.this).post(new i(this, bVar, iOException));
        }

        public final /* synthetic */ void e(C.b bVar) {
            h.C0(h.this).a(h.this, bVar.b, bVar.c);
        }

        public final /* synthetic */ void f(C.b bVar, IOException iOException) {
            h.C0(h.this).b(h.this, bVar.b, bVar.c, iOException);
        }
    }

    public final class d implements e.a {
        public final Handler a = k0.x();
        public volatile boolean b;

        public d() {
        }

        public static /* synthetic */ void e(d dVar, C3.b bVar) {
            dVar.f(bVar);
        }

        public void a(C3.b bVar) {
            if (this.b) {
                return;
            }
            this.a.post(new k(this, bVar));
        }

        public void b(a aVar, s sVar) {
            if (this.b) {
                return;
            }
            h.y0(h.this, null).w(new u(u.a(), sVar, SystemClock.elapsedRealtime()), 6, aVar, true);
        }

        public /* synthetic */ void c() {
            C3.d.a(this);
        }

        public /* synthetic */ void d() {
            C3.d.b(this);
        }

        public final /* synthetic */ void f(C3.b bVar) {
            if (this.b) {
                return;
            }
            h.z0(h.this, bVar);
        }

        public void g() {
            this.b = true;
            this.a.removeCallbacksAndMessages((Object) null);
        }
    }

    public h(C c2, s sVar, Object obj, C.a aVar, e eVar, a4.b bVar) {
        this.l = c2;
        this.m = ((H0.h) d4.a.e(c2.e().c)).d;
        this.n = aVar;
        this.o = eVar;
        this.p = bVar;
        this.q = sVar;
        this.r = obj;
        eVar.c(aVar.c());
    }

    public static /* synthetic */ Handler A0(h hVar) {
        return hVar.s;
    }

    public static /* synthetic */ J.a B0(h hVar, C.b bVar) {
        return hVar.f0(bVar);
    }

    public static /* synthetic */ e C0(h hVar) {
        return hVar.o;
    }

    public static /* synthetic */ void D0(h hVar, Object obj, C c2) {
        hVar.u0(obj, c2);
    }

    public static /* synthetic */ Q1.b E0(h hVar) {
        return hVar.t;
    }

    public static /* synthetic */ void F0(h hVar, Object obj) {
        hVar.v0(obj);
    }

    public static /* synthetic */ void w0(h hVar, d dVar) {
        hVar.J0(dVar);
    }

    public static /* synthetic */ void x0(h hVar, d dVar) {
        hVar.I0(dVar);
    }

    public static /* synthetic */ J.a y0(h hVar, C.b bVar) {
        return hVar.f0(bVar);
    }

    public static /* synthetic */ void z0(h hVar, C3.b bVar) {
        hVar.M0(bVar);
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        if (((C3.b) d4.a.e(this.w)).c <= 0 || !bVar.b()) {
            v vVar = new v(bVar, bVar2, j);
            vVar.y(this.l);
            vVar.a(bVar);
            return vVar;
        }
        int i = bVar.b;
        int i2 = bVar.c;
        b[][] bVarArr = this.x;
        b[] bVarArr2 = bVarArr[i];
        if (bVarArr2.length <= i2) {
            bVarArr[i] = (b[]) Arrays.copyOf(bVarArr2, i2 + 1);
        }
        b bVar3 = this.x[i][i2];
        if (bVar3 == null) {
            bVar3 = new b(bVar);
            this.x[i][i2] = bVar3;
            K0();
        }
        return bVar3.a(bVar, bVar2, j);
    }

    public final long[][] G0() {
        long[][] jArr = new long[this.x.length][];
        int i = 0;
        while (true) {
            b[][] bVarArr = this.x;
            if (i >= bVarArr.length) {
                return jArr;
            }
            jArr[i] = new long[bVarArr[i].length];
            int i2 = 0;
            while (true) {
                b[] bVarArr2 = this.x[i];
                if (i2 < bVarArr2.length) {
                    b bVar = bVarArr2[i2];
                    jArr[i][i2] = bVar == null ? -9223372036854775807L : bVar.b();
                    i2++;
                }
            }
            i++;
        }
    }

    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public C.b p0(C.b bVar, C.b bVar2) {
        return bVar.b() ? bVar : bVar2;
    }

    public final /* synthetic */ void I0(d dVar) {
        this.o.e(this, this.q, this.r, this.p, dVar);
    }

    public final /* synthetic */ void J0(d dVar) {
        this.o.d(this, dVar);
    }

    public final void K0() {
        Uri uri;
        C3.b bVar = this.w;
        if (bVar == null) {
            return;
        }
        for (int i = 0; i < this.x.length; i++) {
            int i2 = 0;
            while (true) {
                b[] bVarArr = this.x[i];
                if (i2 < bVarArr.length) {
                    b bVar2 = bVarArr[i2];
                    b.b e = bVar.e(i);
                    if (bVar2 != null && !bVar2.d()) {
                        Uri[] uriArr = e.e;
                        if (i2 < uriArr.length && (uri = uriArr[i2]) != null) {
                            H0.c m = new H0.c().m(uri);
                            H0.f fVar = this.m;
                            if (fVar != null) {
                                m.e(fVar);
                            }
                            bVar2.e(this.n.b(m.a()), uri);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public final void L0() {
        Q1 q1 = this.v;
        C3.b bVar = this.w;
        if (bVar == null || q1 == null) {
            return;
        }
        if (bVar.c == 0) {
            m0(q1);
        } else {
            this.w = bVar.n(G0());
            m0(new o(q1, this.w));
        }
    }

    public final void M0(C3.b bVar) {
        C3.b bVar2 = this.w;
        if (bVar2 == null) {
            b[][] bVarArr = new b[bVar.c][];
            this.x = bVarArr;
            Arrays.fill(bVarArr, new b[0]);
        } else {
            d4.a.g(bVar.c == bVar2.c);
        }
        this.w = bVar;
        K0();
        L0();
    }

    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void t0(C.b bVar, C c2, Q1 q1) {
        if (bVar.b()) {
            ((b) d4.a.e(this.x[bVar.b][bVar.c])).c(q1);
        } else {
            d4.a.a(q1.n() == 1);
            this.v = q1;
        }
        L0();
    }

    public void Y(z zVar) {
        v vVar = (v) zVar;
        C.b bVar = vVar.a;
        if (!bVar.b()) {
            vVar.x();
            return;
        }
        b bVar2 = (b) d4.a.e(this.x[bVar.b][bVar.c]);
        bVar2.h(vVar);
        if (bVar2.f()) {
            bVar2.g();
            this.x[bVar.b][bVar.c] = null;
        }
    }

    public H0 e() {
        return this.l.e();
    }

    public void l0(S s) {
        super.l0(s);
        d dVar = new d();
        this.u = dVar;
        u0(y, this.l);
        this.s.post(new f(this, dVar));
    }

    public void n0() {
        super.n0();
        d dVar = (d) d4.a.e(this.u);
        this.u = null;
        dVar.g();
        this.v = null;
        this.w = null;
        this.x = new b[0][];
        this.s.post(new g(this, dVar));
    }
}
