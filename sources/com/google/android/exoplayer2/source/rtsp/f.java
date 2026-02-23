package com.google.android.exoplayer2.source.rtsp;

import B3.X;
import B3.Y;
import B3.g0;
import B3.i0;
import B3.z;
import K3.n;
import K3.o;
import K3.x;
import O2.A0;
import O2.H1;
import O2.z0;
import Z3.s;
import android.net.Uri;
import android.os.Handler;
import b4.G;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.d;
import com.google.android.exoplayer2.source.rtsp.g;
import d3.w;
import d4.k0;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements z {
    public final b4.b a;
    public final Handler c = k0.x();
    public final b d;
    public final com.google.android.exoplayer2.source.rtsp.d e;
    public final List f;
    public final List g;
    public final c h;
    public final a.a i;
    public z.a j;
    public y k;
    public IOException l;
    public RtspMediaSource.c m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;

    public final class b implements d3.k, G.b, X.d, d.f, d.e {
        public b() {
        }

        public static /* synthetic */ void g(f fVar) {
            i(fVar);
        }

        public static /* synthetic */ void h(f fVar) {
            k(fVar);
        }

        public static /* synthetic */ void i(f fVar) {
            f.E(fVar);
        }

        public static /* synthetic */ void k(f fVar) {
            f.E(fVar);
        }

        public void a(long j, y yVar) {
            ArrayList arrayList = new ArrayList(yVar.size());
            for (int i = 0; i < yVar.size(); i++) {
                arrayList.add((String) d4.a.e(((x) yVar.get(i)).c.getPath()));
            }
            for (int i2 = 0; i2 < f.w(f.this).size(); i2++) {
                if (!arrayList.contains(((d) f.w(f.this).get(i2)).c().getPath())) {
                    f.x(f.this).a();
                    if (f.y(f.this)) {
                        f.z(f.this, true);
                        f.q(f.this, -9223372036854775807L);
                        f.B(f.this, -9223372036854775807L);
                        f.t(f.this, -9223372036854775807L);
                    }
                }
            }
            for (int i3 = 0; i3 < yVar.size(); i3++) {
                x xVar = (x) yVar.get(i3);
                com.google.android.exoplayer2.source.rtsp.b C = f.C(f.this, xVar.c);
                if (C != null) {
                    C.h(xVar.a);
                    C.g(xVar.b);
                    if (f.y(f.this) && f.o(f.this) == f.A(f.this)) {
                        C.f(j, xVar.a);
                    }
                }
            }
            if (!f.y(f.this)) {
                if (f.r(f.this) == -9223372036854775807L || !f.L(f.this)) {
                    return;
                }
                f fVar = f.this;
                fVar.l(f.r(fVar));
                f.t(f.this, -9223372036854775807L);
                return;
            }
            long o = f.o(f.this);
            long A = f.A(f.this);
            f.q(f.this, -9223372036854775807L);
            f fVar2 = f.this;
            if (o == A) {
                f.B(fVar2, -9223372036854775807L);
            } else {
                fVar2.l(f.A(fVar2));
            }
        }

        public void b(String str, Throwable th) {
            f.a(f.this, th == null ? new IOException(str) : new IOException(str, th));
        }

        public void c(RtspMediaSource.c cVar) {
            if (!(cVar instanceof RtspMediaSource.d) || f.L(f.this)) {
                f.n(f.this, cVar);
            } else {
                f.N(f.this);
            }
        }

        public void d() {
            long j;
            long r;
            long o = f.o(f.this);
            f fVar = f.this;
            if (o != -9223372036854775807L) {
                r = f.o(fVar);
            } else {
                if (f.r(fVar) == -9223372036854775807L) {
                    j = 0;
                    f.O(f.this).u0(j);
                }
                r = f.r(f.this);
            }
            j = k0.x1(r);
            f.O(f.this).u0(j);
        }

        public w e(int i, int i2) {
            return e.b((e) d4.a.e((e) f.J(f.this).get(i)));
        }

        public void f(K3.w wVar, y yVar) {
            for (int i = 0; i < yVar.size(); i++) {
                o oVar = (o) yVar.get(i);
                f fVar = f.this;
                e eVar = fVar.new e(oVar, i, f.D(fVar));
                f.J(f.this).add(eVar);
                eVar.k();
            }
            f.x(f.this).b(wVar);
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void t(com.google.android.exoplayer2.source.rtsp.b bVar, long j, long j2, boolean z) {
        }

        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void W(com.google.android.exoplayer2.source.rtsp.b bVar, long j, long j2) {
            if (f.this.g() == 0) {
                if (f.L(f.this)) {
                    return;
                }
                f.N(f.this);
                return;
            }
            int i = 0;
            while (true) {
                if (i >= f.J(f.this).size()) {
                    break;
                }
                e eVar = (e) f.J(f.this).get(i);
                if (d.b(eVar.a) == bVar) {
                    eVar.c();
                    break;
                }
                i++;
            }
            f.O(f.this).s0();
        }

        public void n(com.google.android.exoplayer2.extractor.g gVar) {
        }

        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public G.c j(com.google.android.exoplayer2.source.rtsp.b bVar, long j, long j2, IOException iOException, int i) {
            if (!f.P(f.this)) {
                f.a(f.this, iOException);
            } else if (!(iOException.getCause() instanceof BindException)) {
                f.n(f.this, new RtspMediaSource.c(bVar.c.b.toString(), iOException));
            } else if (f.e(f.this) < 3) {
                return G.d;
            }
            return G.f;
        }

        public void q() {
            f.K(f.this).post(new K3.l(f.this));
        }

        public void r(z0 z0Var) {
            f.K(f.this).post(new K3.m(f.this));
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this();
        }
    }

    public interface c {
        void a();

        void b(K3.w wVar);
    }

    public final class d {
        public final o a;
        public final com.google.android.exoplayer2.source.rtsp.b b;
        public String c;

        public d(o oVar, int i, a.a aVar) {
            this.a = oVar;
            this.b = new com.google.android.exoplayer2.source.rtsp.b(i, oVar, new n(this), f.G(f.this), aVar);
        }

        public static /* synthetic */ void a(d dVar, String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
            dVar.f(str, aVar);
        }

        public static /* synthetic */ com.google.android.exoplayer2.source.rtsp.b b(d dVar) {
            return dVar.b;
        }

        public Uri c() {
            return this.b.c.b;
        }

        public String d() {
            d4.a.i(this.c);
            return this.c;
        }

        public boolean e() {
            return this.c != null;
        }

        public final /* synthetic */ void f(String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
            this.c = str;
            g.b l = aVar.l();
            if (l != null) {
                f.O(f.this).n0(aVar.getLocalPort(), l);
                f.M(f.this, true);
            }
            f.I(f.this);
        }
    }

    public final class e {
        public final d a;
        public final G b;
        public final X c;
        public boolean d;
        public boolean e;

        public e(o oVar, int i, a.a aVar) {
            this.a = f.this.new d(oVar, i, aVar);
            this.b = new G("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i);
            X l = X.l(f.F(f.this));
            this.c = l;
            l.d0(f.G(f.this));
        }

        public static /* synthetic */ boolean a(e eVar) {
            return eVar.d;
        }

        public static /* synthetic */ X b(e eVar) {
            return eVar.c;
        }

        public void c() {
            if (this.d) {
                return;
            }
            d.b(this.a).c();
            this.d = true;
            f.H(f.this);
        }

        public long d() {
            return this.c.z();
        }

        public boolean e() {
            return this.c.K(this.d);
        }

        public int f(A0 a0, U2.g gVar, int i) {
            return this.c.S(a0, gVar, i, this.d);
        }

        public void g() {
            if (this.e) {
                return;
            }
            this.b.l();
            this.c.T();
            this.e = true;
        }

        public void h() {
            d4.a.g(this.d);
            this.d = false;
            f.H(f.this);
            k();
        }

        public void i(long j) {
            if (this.d) {
                return;
            }
            d.b(this.a).e();
            this.c.V();
            this.c.b0(j);
        }

        public int j(long j) {
            int E = this.c.E(j, this.d);
            this.c.e0(E);
            return E;
        }

        public void k() {
            this.b.n(d.b(this.a), f.G(f.this), 0);
        }
    }

    public final class f implements Y {
        public final int a;

        public f(int i) {
            this.a = i;
        }

        public void a() {
            if (f.j(f.this) != null) {
                throw f.j(f.this);
            }
        }

        public boolean e() {
            return f.this.T(this.a);
        }

        public int n(long j) {
            return f.this.b0(this.a, j);
        }

        public int q(A0 a0, U2.g gVar, int i) {
            return f.this.X(this.a, a0, gVar, i);
        }
    }

    public f(b4.b bVar, a.a aVar, Uri uri, c cVar, String str, SocketFactory socketFactory, boolean z) {
        this.a = bVar;
        this.i = aVar;
        this.h = cVar;
        b bVar2 = new b(this, null);
        this.d = bVar2;
        this.e = new com.google.android.exoplayer2.source.rtsp.d(bVar2, bVar2, str, uri, socketFactory, z);
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.o = -9223372036854775807L;
        this.n = -9223372036854775807L;
        this.p = -9223372036854775807L;
    }

    public static /* synthetic */ long A(f fVar) {
        return fVar.n;
    }

    public static /* synthetic */ long B(f fVar, long j) {
        fVar.n = j;
        return j;
    }

    public static /* synthetic */ com.google.android.exoplayer2.source.rtsp.b C(f fVar, Uri uri) {
        return fVar.R(uri);
    }

    public static /* synthetic */ a.a D(f fVar) {
        return fVar.i;
    }

    public static /* synthetic */ void E(f fVar) {
        fVar.V();
    }

    public static /* synthetic */ b4.b F(f fVar) {
        return fVar.a;
    }

    public static /* synthetic */ b G(f fVar) {
        return fVar.d;
    }

    public static /* synthetic */ void H(f fVar) {
        fVar.d0();
    }

    public static /* synthetic */ void I(f fVar) {
        fVar.W();
    }

    public static /* synthetic */ List J(f fVar) {
        return fVar.f;
    }

    public static /* synthetic */ Handler K(f fVar) {
        return fVar.c;
    }

    public static /* synthetic */ boolean L(f fVar) {
        return fVar.w;
    }

    public static /* synthetic */ boolean M(f fVar, boolean z) {
        fVar.w = z;
        return z;
    }

    public static /* synthetic */ void N(f fVar) {
        fVar.Z();
    }

    public static /* synthetic */ com.google.android.exoplayer2.source.rtsp.d O(f fVar) {
        return fVar.e;
    }

    public static /* synthetic */ boolean P(f fVar) {
        return fVar.t;
    }

    public static y Q(y yVar) {
        y.a aVar = new y.a();
        for (int i = 0; i < yVar.size(); i++) {
            aVar.a(new g0(Integer.toString(i), (z0) d4.a.e(e.b((e) yVar.get(i)).F())));
        }
        return aVar.k();
    }

    private void V() {
        if (this.s || this.t) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (e.b((e) this.f.get(i)).F() == null) {
                return;
            }
        }
        this.t = true;
        this.k = Q(y.r(this.f));
        ((z.a) d4.a.e(this.j)).e(this);
    }

    public static /* synthetic */ IOException a(f fVar, IOException iOException) {
        fVar.l = iOException;
        return iOException;
    }

    private boolean c0() {
        return this.r;
    }

    public static /* synthetic */ int e(f fVar) {
        int i = fVar.v;
        fVar.v = i + 1;
        return i;
    }

    public static /* synthetic */ RtspMediaSource.c j(f fVar) {
        return fVar.m;
    }

    public static /* synthetic */ RtspMediaSource.c n(f fVar, RtspMediaSource.c cVar) {
        fVar.m = cVar;
        return cVar;
    }

    public static /* synthetic */ long o(f fVar) {
        return fVar.o;
    }

    public static /* synthetic */ long q(f fVar, long j) {
        fVar.o = j;
        return j;
    }

    public static /* synthetic */ long r(f fVar) {
        return fVar.p;
    }

    public static /* synthetic */ long t(f fVar, long j) {
        fVar.p = j;
        return j;
    }

    public static /* synthetic */ List w(f fVar) {
        return fVar.g;
    }

    public static /* synthetic */ c x(f fVar) {
        return fVar.h;
    }

    public static /* synthetic */ boolean y(f fVar) {
        return fVar.U();
    }

    public static /* synthetic */ boolean z(f fVar, boolean z) {
        fVar.r = z;
        return z;
    }

    public final com.google.android.exoplayer2.source.rtsp.b R(Uri uri) {
        for (int i = 0; i < this.f.size(); i++) {
            if (!e.a((e) this.f.get(i))) {
                d dVar = ((e) this.f.get(i)).a;
                if (dVar.c().equals(uri)) {
                    return d.b(dVar);
                }
            }
        }
        return null;
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public y k(List list) {
        return y.z();
    }

    public boolean T(int i) {
        return !c0() && ((e) this.f.get(i)).e();
    }

    public final boolean U() {
        return this.o != -9223372036854775807L;
    }

    public final void W() {
        boolean z = true;
        for (int i = 0; i < this.g.size(); i++) {
            z &= ((d) this.g.get(i)).e();
        }
        if (z && this.u) {
            this.e.r0(this.g);
        }
    }

    public int X(int i, A0 a0, U2.g gVar, int i2) {
        if (c0()) {
            return -3;
        }
        return ((e) this.f.get(i)).f(a0, gVar, i2);
    }

    public void Y() {
        for (int i = 0; i < this.f.size(); i++) {
            ((e) this.f.get(i)).g();
        }
        k0.o(this.e);
        this.s = true;
    }

    public final void Z() {
        this.w = true;
        this.e.o0();
        a.a b2 = this.i.b();
        if (b2 == null) {
            this.m = new RtspMediaSource.c("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f.size());
        ArrayList arrayList2 = new ArrayList(this.g.size());
        for (int i = 0; i < this.f.size(); i++) {
            e eVar = (e) this.f.get(i);
            if (e.a(eVar)) {
                arrayList.add(eVar);
            } else {
                e eVar2 = new e(eVar.a.a, i, b2);
                arrayList.add(eVar2);
                eVar2.k();
                if (this.g.contains(eVar.a)) {
                    arrayList2.add(eVar2.a);
                }
            }
        }
        y r = y.r(this.f);
        this.f.clear();
        this.f.addAll(arrayList);
        this.g.clear();
        this.g.addAll(arrayList2);
        for (int i2 = 0; i2 < r.size(); i2++) {
            ((e) r.get(i2)).c();
        }
    }

    public final boolean a0(long j) {
        for (int i = 0; i < this.f.size(); i++) {
            if (!e.b((e) this.f.get(i)).Z(j, false)) {
                return false;
            }
        }
        return true;
    }

    public boolean b() {
        return !this.q;
    }

    public int b0(int i, long j) {
        if (c0()) {
            return -3;
        }
        return ((e) this.f.get(i)).j(j);
    }

    public long c() {
        return g();
    }

    public final void d0() {
        this.q = true;
        for (int i = 0; i < this.f.size(); i++) {
            this.q &= e.a((e) this.f.get(i));
        }
    }

    public boolean f(long j) {
        return b();
    }

    public long g() {
        if (this.q || this.f.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j = this.n;
        if (j != -9223372036854775807L) {
            return j;
        }
        boolean z = true;
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < this.f.size(); i++) {
            e eVar = (e) this.f.get(i);
            if (!e.a(eVar)) {
                j2 = Math.min(j2, eVar.d());
                z = false;
            }
        }
        if (z || j2 == Long.MIN_VALUE) {
            return 0L;
        }
        return j2;
    }

    public void h(long j) {
    }

    public long i(s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
        for (int i = 0; i < sVarArr.length; i++) {
            if (yArr[i] != null && (sVarArr[i] == null || !zArr[i])) {
                yArr[i] = null;
            }
        }
        this.g.clear();
        for (int i2 = 0; i2 < sVarArr.length; i2++) {
            s sVar = sVarArr[i2];
            if (sVar != null) {
                g0 k = sVar.k();
                int indexOf = ((y) d4.a.e(this.k)).indexOf(k);
                this.g.add(((e) d4.a.e((e) this.f.get(indexOf))).a);
                if (this.k.contains(k) && yArr[i2] == null) {
                    yArr[i2] = new f(indexOf);
                    zArr2[i2] = true;
                }
            }
        }
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            e eVar = (e) this.f.get(i3);
            if (!this.g.contains(eVar.a)) {
                eVar.c();
            }
        }
        this.u = true;
        if (j != 0) {
            this.n = j;
            this.o = j;
            this.p = j;
        }
        W();
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long l(long r6) {
        /*
            r5 = this;
            long r0 = r5.g()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L11
            boolean r0 = r5.w
            if (r0 != 0) goto L11
            r5.p = r6
            return r6
        L11:
            r0 = 0
            r5.v(r6, r0)
            r5.n = r6
            boolean r1 = r5.U()
            if (r1 == 0) goto L38
            com.google.android.exoplayer2.source.rtsp.d r0 = r5.e
            int r0 = r0.l0()
            r1 = 1
            if (r0 == r1) goto L37
            r1 = 2
            if (r0 != r1) goto L31
            r5.o = r6
            com.google.android.exoplayer2.source.rtsp.d r0 = r5.e
            r0.p0(r6)
            return r6
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L37:
            return r6
        L38:
            boolean r1 = r5.a0(r6)
            if (r1 == 0) goto L3f
            return r6
        L3f:
            r5.o = r6
            boolean r1 = r5.q
            if (r1 == 0) goto L6a
            r1 = 0
        L46:
            java.util.List r2 = r5.f
            int r2 = r2.size()
            if (r1 >= r2) goto L5c
            java.util.List r2 = r5.f
            java.lang.Object r2 = r2.get(r1)
            com.google.android.exoplayer2.source.rtsp.f$e r2 = (com.google.android.exoplayer2.source.rtsp.f.e) r2
            r2.h()
            int r1 = r1 + 1
            goto L46
        L5c:
            boolean r1 = r5.w
            if (r1 == 0) goto L6a
            com.google.android.exoplayer2.source.rtsp.d r1 = r5.e
            long r2 = d4.k0.x1(r6)
            r1.u0(r2)
            goto L6f
        L6a:
            com.google.android.exoplayer2.source.rtsp.d r1 = r5.e
            r1.p0(r6)
        L6f:
            java.util.List r1 = r5.f
            int r1 = r1.size()
            if (r0 >= r1) goto L85
            java.util.List r1 = r5.f
            java.lang.Object r1 = r1.get(r0)
            com.google.android.exoplayer2.source.rtsp.f$e r1 = (com.google.android.exoplayer2.source.rtsp.f.e) r1
            r1.i(r6)
            int r0 = r0 + 1
            goto L6f
        L85:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.f.l(long):long");
    }

    public long m() {
        if (!this.r) {
            return -9223372036854775807L;
        }
        this.r = false;
        return 0L;
    }

    public void p() {
        IOException iOException = this.l;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void s(z.a aVar, long j) {
        this.j = aVar;
        try {
            this.e.t0();
        } catch (IOException e2) {
            this.l = e2;
            k0.o(this.e);
        }
    }

    public i0 u() {
        d4.a.g(this.t);
        return new i0((g0[]) ((y) d4.a.e(this.k)).toArray(new g0[0]));
    }

    public void v(long j, boolean z) {
        if (U()) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            e eVar = (e) this.f.get(i);
            if (!e.a(eVar)) {
                e.b(eVar).q(j, z, true);
            }
        }
    }

    public long d(long j, H1 h1) {
        return j;
    }
}
