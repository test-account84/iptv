package H3;

import H3.f;
import J3.f;
import O2.z0;
import P2.v0;
import android.net.Uri;
import b4.s;
import d4.M;
import d4.Z;
import d4.b0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import q3.a;
import s5.A;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends D3.n {
    public static final AtomicInteger O = new AtomicInteger();
    public final M A;
    public final boolean B;
    public final boolean C;
    public final v0 D;
    public final long E;
    public k F;
    public q G;
    public int H;
    public boolean I;
    public volatile boolean J;
    public boolean K;
    public y L;
    public boolean M;
    public boolean N;
    public final int l;
    public final int m;
    public final Uri n;
    public final boolean o;
    public final int p;
    public final b4.o q;
    public final b4.s r;
    public final k s;
    public final boolean t;
    public final boolean u;
    public final Z v;
    public final h w;
    public final List x;
    public final V2.m y;
    public final v3.h z;

    public j(h hVar, b4.o oVar, b4.s sVar, z0 z0Var, boolean z, b4.o oVar2, b4.s sVar2, boolean z2, Uri uri, List list, int i, Object obj, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, Z z6, long j4, V2.m mVar, k kVar, v3.h hVar2, M m, boolean z7, v0 v0Var) {
        super(oVar, sVar, z0Var, i, obj, j, j2, j3);
        this.B = z;
        this.p = i2;
        this.N = z3;
        this.m = i3;
        this.r = sVar2;
        this.q = oVar2;
        this.I = sVar2 != null;
        this.C = z2;
        this.n = uri;
        this.t = z5;
        this.v = z6;
        this.E = j4;
        this.u = z4;
        this.w = hVar;
        this.x = list;
        this.y = mVar;
        this.s = kVar;
        this.z = hVar2;
        this.A = m;
        this.o = z7;
        this.D = v0Var;
        this.L = y.z();
        this.l = O.getAndIncrement();
    }

    public static b4.o i(b4.o oVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return oVar;
        }
        d4.a.e(bArr2);
        return new a(oVar, bArr, bArr2);
    }

    public static j j(h hVar, b4.o oVar, z0 z0Var, long j, J3.f fVar, f.e eVar, Uri uri, List list, int i, Object obj, boolean z, t tVar, long j2, j jVar, byte[] bArr, byte[] bArr2, boolean z2, v0 v0Var, b4.i iVar) {
        b4.s sVar;
        b4.o oVar2;
        boolean z3;
        v3.h hVar2;
        M m;
        k kVar;
        f.e eVar2 = eVar.a;
        b4.s a = new s.b().i(b0.e(fVar.a, eVar2.a)).h(eVar2.j).g(eVar2.k).b(eVar.d ? 8 : 0).e(A.k()).a();
        boolean z4 = bArr != null;
        b4.o i2 = i(oVar, bArr, z4 ? l((String) d4.a.e(eVar2.i)) : null);
        f.d dVar = eVar2.c;
        if (dVar != null) {
            boolean z5 = bArr2 != null;
            byte[] l = z5 ? l((String) d4.a.e(dVar.i)) : null;
            b4.s sVar2 = new b4.s(b0.e(fVar.a, dVar.a), dVar.j, dVar.k);
            z3 = z5;
            oVar2 = i(oVar, bArr2, l);
            sVar = sVar2;
        } else {
            sVar = null;
            oVar2 = null;
            z3 = false;
        }
        long j3 = j + eVar2.f;
        long j4 = j3 + eVar2.d;
        int i3 = fVar.j + eVar2.e;
        if (jVar != null) {
            b4.s sVar3 = jVar.r;
            boolean z6 = sVar == sVar3 || (sVar != null && sVar3 != null && sVar.a.equals(sVar3.a) && sVar.g == jVar.r.g);
            boolean z7 = uri.equals(jVar.n) && jVar.K;
            v3.h hVar3 = jVar.z;
            M m2 = jVar.A;
            kVar = (z6 && z7 && !jVar.M && jVar.m == i3) ? jVar.F : null;
            hVar2 = hVar3;
            m = m2;
        } else {
            hVar2 = new v3.h();
            m = new M(10);
            kVar = null;
        }
        return new j(hVar, i2, a, z0Var, z4, oVar2, sVar, z3, uri, list, i, obj, j3, j4, eVar.b, eVar.c, !eVar.d, i3, eVar2.l, z, tVar.a(i3), j2, eVar2.g, kVar, hVar2, m, z2, v0Var);
    }

    public static byte[] l(String str) {
        if (r5.b.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean p(f.e eVar, J3.f fVar) {
        f.e eVar2 = eVar.a;
        return eVar2 instanceof f.b ? ((f.b) eVar2).m || (eVar.c == 0 && fVar.c) : fVar.c;
    }

    public static boolean w(j jVar, Uri uri, J3.f fVar, f.e eVar, long j) {
        if (jVar == null) {
            return false;
        }
        if (uri.equals(jVar.n) && jVar.K) {
            return false;
        }
        return !p(eVar, fVar) || j + eVar.a.f < jVar.i;
    }

    public void a() {
        k kVar;
        d4.a.e(this.G);
        if (this.F == null && (kVar = this.s) != null && kVar.d()) {
            this.F = this.s;
            this.I = false;
        }
        s();
        if (this.J) {
            return;
        }
        if (!this.u) {
            r();
        }
        this.K = !this.J;
    }

    public void c() {
        this.J = true;
    }

    public boolean h() {
        return this.K;
    }

    public final void k(b4.o oVar, b4.s sVar, boolean z, boolean z2) {
        b4.s e;
        long position;
        long j;
        if (z) {
            r0 = this.H != 0;
            e = sVar;
        } else {
            e = sVar.e(this.H);
        }
        try {
            d3.c u = u(oVar, e, z2);
            if (r0) {
                u.q(this.H);
            }
            while (!this.J && this.F.a(u)) {
                try {
                    try {
                    } catch (EOFException e2) {
                        if ((this.e.f & 16384) == 0) {
                            throw e2;
                        }
                        this.F.c();
                        position = u.getPosition();
                        j = sVar.g;
                    }
                } catch (Throwable th) {
                    this.H = (int) (u.getPosition() - sVar.g);
                    throw th;
                }
            }
            position = u.getPosition();
            j = sVar.g;
            this.H = (int) (position - j);
        } finally {
            b4.r.a(oVar);
        }
    }

    public int m(int i) {
        d4.a.g(!this.o);
        if (i >= this.L.size()) {
            return 0;
        }
        return ((Integer) this.L.get(i)).intValue();
    }

    public void n(q qVar, y yVar) {
        this.G = qVar;
        this.L = yVar;
    }

    public void o() {
        this.M = true;
    }

    public boolean q() {
        return this.N;
    }

    public final void r() {
        k(this.j, this.c, this.B, true);
    }

    public final void s() {
        if (this.I) {
            d4.a.e(this.q);
            d4.a.e(this.r);
            k(this.q, this.r, this.C, false);
            this.H = 0;
            this.I = false;
        }
    }

    public final long t(d3.j jVar) {
        jVar.f();
        try {
            this.A.Q(10);
            jVar.s(this.A.e(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.A.K() != 4801587) {
            return -9223372036854775807L;
        }
        this.A.V(3);
        int G = this.A.G();
        int i = G + 10;
        if (i > this.A.b()) {
            byte[] e = this.A.e();
            this.A.Q(i);
            System.arraycopy(e, 0, this.A.e(), 0, 10);
        }
        jVar.s(this.A.e(), 10, G);
        q3.a e2 = this.z.e(this.A.e(), G);
        if (e2 == null) {
            return -9223372036854775807L;
        }
        int f = e2.f();
        for (int i2 = 0; i2 < f; i2++) {
            a.b e3 = e2.e(i2);
            if (e3 instanceof v3.l) {
                v3.l lVar = (v3.l) e3;
                if ("com.apple.streaming.transportStreamTimestamp".equals(lVar.c)) {
                    System.arraycopy(lVar.d, 0, this.A.e(), 0, 8);
                    this.A.U(0);
                    this.A.T(8);
                    return this.A.A() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final d3.c u(b4.o oVar, b4.s sVar, boolean z) {
        q qVar;
        long j;
        long a = oVar.a(sVar);
        if (z) {
            try {
                this.v.i(this.t, this.h, this.E);
            } catch (TimeoutException e) {
                throw new IOException(e);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        d3.c cVar = new d3.c(oVar, sVar.g, a);
        if (this.F == null) {
            long t = t(cVar);
            cVar.f();
            k kVar = this.s;
            k f = kVar != null ? kVar.f() : this.w.a(sVar.a, this.e, this.x, this.v, oVar.e(), cVar, this.D);
            this.F = f;
            if (f.e()) {
                qVar = this.G;
                j = t != -9223372036854775807L ? this.v.b(t) : this.h;
            } else {
                qVar = this.G;
                j = 0;
            }
            qVar.p0(j);
            this.G.b0();
            this.F.b(this.G);
        }
        this.G.m0(this.y);
        return cVar;
    }

    public void v() {
        this.N = true;
    }
}
