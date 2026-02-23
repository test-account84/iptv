package com.google.android.exoplayer2.source.dash;

import D3.e;
import D3.g;
import D3.k;
import D3.m;
import D3.n;
import D3.p;
import E3.f;
import F3.i;
import F3.j;
import O2.H1;
import O2.z0;
import P2.v0;
import Z3.s;
import android.os.SystemClock;
import b4.C;
import b4.F;
import b4.H;
import b4.S;
import b4.h;
import b4.o;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import d4.k0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import s5.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {
    public final H a;
    public final E3.b b;
    public final int[] c;
    public final int d;
    public final o e;
    public final long f;
    public final int g;
    public final d.c h;
    public final b[] i;
    public s j;
    public F3.c k;
    public int l;
    public IOException m;
    public boolean n;

    public static final class a implements a.a {
        public final o.a a;
        public final int b;
        public final g.a c;

        public a(g.a aVar, o.a aVar2, int i) {
            this.c = aVar;
            this.a = aVar2;
            this.b = i;
        }

        public com.google.android.exoplayer2.source.dash.a a(H h, F3.c cVar, E3.b bVar, int i, int[] iArr, s sVar, int i2, long j, boolean z, List list, d.c cVar2, S s, v0 v0Var, h hVar) {
            o a = this.a.a();
            if (s != null) {
                a.g(s);
            }
            return new c(this.c, h, cVar, bVar, i, iArr, sVar, i2, a, j, this.b, z, list, cVar2, v0Var, hVar);
        }

        public a(o.a aVar) {
            this(aVar, 1);
        }

        public a(o.a aVar, int i) {
            this(e.k, aVar, i);
        }
    }

    public static final class b {
        public final g a;
        public final j b;
        public final F3.b c;
        public final f d;
        public final long e;
        public final long f;

        public b(long j, j jVar, F3.b bVar, g gVar, long j2, f fVar) {
            this.e = j;
            this.b = jVar;
            this.c = bVar;
            this.f = j2;
            this.a = gVar;
            this.d = fVar;
        }

        public static /* synthetic */ long a(b bVar) {
            return bVar.e;
        }

        public b b(long j, j jVar) {
            long h;
            f b = this.b.b();
            f b2 = jVar.b();
            if (b == null) {
                return new b(j, jVar, this.c, this.a, this.f, b);
            }
            if (!b.j()) {
                return new b(j, jVar, this.c, this.a, this.f, b2);
            }
            long i = b.i(j);
            if (i == 0) {
                return new b(j, jVar, this.c, this.a, this.f, b2);
            }
            long k = b.k();
            long c = b.c(k);
            long j2 = i + k;
            long j3 = j2 - 1;
            long c2 = b.c(j3) + b.d(j3, j);
            long k2 = b2.k();
            long c3 = b2.c(k2);
            long j4 = this.f;
            if (c2 == c3) {
                h = j4 + (j2 - k2);
            } else {
                if (c2 < c3) {
                    throw new B3.b();
                }
                if (c3 < c) {
                    h = j4 - (b2.h(c, j) - k);
                } else {
                    j2 = b.h(c3, j);
                    h = j4 + (j2 - k2);
                }
            }
            return new b(j, jVar, this.c, this.a, h, b2);
        }

        public b c(f fVar) {
            return new b(this.e, this.b, this.c, this.a, this.f, fVar);
        }

        public b d(F3.b bVar) {
            return new b(this.e, this.b, bVar, this.a, this.f, this.d);
        }

        public long e(long j) {
            return this.d.e(this.e, j) + this.f;
        }

        public long f() {
            return this.d.k() + this.f;
        }

        public long g(long j) {
            return (e(j) + this.d.l(this.e, j)) - 1;
        }

        public long h() {
            return this.d.i(this.e);
        }

        public long i(long j) {
            return k(j) + this.d.d(j - this.f, this.e);
        }

        public long j(long j) {
            return this.d.h(j, this.e) + this.f;
        }

        public long k(long j) {
            return this.d.c(j - this.f);
        }

        public i l(long j) {
            return this.d.g(j - this.f);
        }

        public boolean m(long j, long j2) {
            return this.d.j() || j2 == -9223372036854775807L || i(j) <= j2;
        }
    }

    public static final class c extends D3.b {
        public final b e;
        public final long f;

        public c(b bVar, long j, long j2, long j3) {
            super(j, j2);
            this.e = bVar;
            this.f = j3;
        }

        public long a() {
            c();
            return this.e.k(d());
        }

        public long b() {
            c();
            return this.e.i(d());
        }
    }

    public c(g.a aVar, H h, F3.c cVar, E3.b bVar, int i, int[] iArr, s sVar, int i2, o oVar, long j, int i3, boolean z, List list, d.c cVar2, v0 v0Var, h hVar) {
        this.a = h;
        this.k = cVar;
        this.b = bVar;
        this.c = iArr;
        this.j = sVar;
        this.d = i2;
        this.e = oVar;
        this.l = i;
        this.f = j;
        this.g = i3;
        this.h = cVar2;
        long g = cVar.g(i);
        ArrayList n = n();
        this.i = new b[sVar.length()];
        int i4 = 0;
        while (i4 < this.i.length) {
            j jVar = (j) n.get(sVar.d(i4));
            F3.b j2 = bVar.j(jVar.c);
            int i5 = i4;
            this.i[i5] = new b(g, jVar, j2 == null ? (F3.b) jVar.c.get(0) : j2, aVar.a(i2, jVar.b, z, list, cVar2, v0Var), 0L, jVar.b());
            i4 = i5 + 1;
        }
    }

    public void a() {
        IOException iOException = this.m;
        if (iOException != null) {
            throw iOException;
        }
        this.a.a();
    }

    public void b(s sVar) {
        this.j = sVar;
    }

    public void c(D3.f fVar) {
        com.google.android.exoplayer2.extractor.b b2;
        if (fVar instanceof m) {
            int l = this.j.l(((m) fVar).e);
            b bVar = this.i[l];
            if (bVar.d == null && (b2 = bVar.a.b()) != null) {
                this.i[l] = bVar.c(new E3.h(b2, bVar.b.d));
            }
        }
        d.c cVar = this.h;
        if (cVar != null) {
            cVar.i(fVar);
        }
    }

    public long d(long j, H1 h1) {
        for (b bVar : this.i) {
            if (bVar.d != null) {
                long h = bVar.h();
                if (h != 0) {
                    long j2 = bVar.j(j);
                    long k = bVar.k(j2);
                    return h1.a(j, k, (k >= j || (h != -1 && j2 >= (bVar.f() + h) - 1)) ? k : bVar.k(j2 + 1));
                }
            }
        }
        return j;
    }

    public boolean e(long j, D3.f fVar, List list) {
        if (this.m != null) {
            return false;
        }
        return this.j.j(j, fVar, list);
    }

    public boolean g(D3.f fVar, boolean z, F.c cVar, F f) {
        F.b a2;
        if (!z) {
            return false;
        }
        d.c cVar2 = this.h;
        if (cVar2 != null && cVar2.j(fVar)) {
            return true;
        }
        if (!this.k.d && (fVar instanceof n)) {
            IOException iOException = cVar.c;
            if ((iOException instanceof C.e) && ((C.e) iOException).e == 404) {
                b bVar = this.i[this.j.l(fVar.e)];
                long h = bVar.h();
                if (h != -1 && h != 0) {
                    if (((n) fVar).g() > (bVar.f() + h) - 1) {
                        this.n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.i[this.j.l(fVar.e)];
        F3.b j = this.b.j(bVar2.b.c);
        if (j != null && !bVar2.c.equals(j)) {
            return true;
        }
        F.a k = k(this.j, bVar2.b.c);
        if ((!k.a(2) && !k.a(1)) || (a2 = f.a(k, cVar)) == null || !k.a(a2.a)) {
            return false;
        }
        int i = a2.a;
        if (i == 2) {
            s sVar = this.j;
            return sVar.e(sVar.l(fVar.e), a2.b);
        }
        if (i != 1) {
            return false;
        }
        this.b.e(bVar2.c, a2.b);
        return true;
    }

    public void h(long j, long j2, List list, D3.h hVar) {
        int i;
        int i2;
        D3.o[] oVarArr;
        long j3;
        long j4;
        if (this.m != null) {
            return;
        }
        long j5 = j2 - j;
        long P0 = k0.P0(this.k.a) + k0.P0(this.k.d(this.l).b) + j2;
        d.c cVar = this.h;
        if (cVar == null || !cVar.h(P0)) {
            long P02 = k0.P0(k0.g0(this.f));
            long m = m(P02);
            n nVar = list.isEmpty() ? null : (n) list.get(list.size() - 1);
            int length = this.j.length();
            D3.o[] oVarArr2 = new D3.o[length];
            int i3 = 0;
            while (i3 < length) {
                b bVar = this.i[i3];
                if (bVar.d == null) {
                    oVarArr2[i3] = D3.o.a;
                    i = i3;
                    i2 = length;
                    oVarArr = oVarArr2;
                    j3 = j5;
                    j4 = P02;
                } else {
                    long e = bVar.e(P02);
                    long g = bVar.g(P02);
                    i = i3;
                    i2 = length;
                    oVarArr = oVarArr2;
                    j3 = j5;
                    j4 = P02;
                    long o = o(bVar, nVar, j2, e, g);
                    if (o < e) {
                        oVarArr[i] = D3.o.a;
                    } else {
                        oVarArr[i] = new c(r(i), o, g, m);
                    }
                }
                i3 = i + 1;
                P02 = j4;
                length = i2;
                oVarArr2 = oVarArr;
                j5 = j3;
            }
            long j6 = j5;
            long j7 = P02;
            this.j.r(j, j6, l(j7, j), list, oVarArr2);
            b r = r(this.j.b());
            g gVar = r.a;
            if (gVar != null) {
                j jVar = r.b;
                i n = gVar.c() == null ? jVar.n() : null;
                i m2 = r.d == null ? jVar.m() : null;
                if (n != null || m2 != null) {
                    hVar.a = p(r, this.e, this.j.p(), this.j.q(), this.j.g(), n, m2);
                    return;
                }
            }
            long a2 = b.a(r);
            boolean z = a2 != -9223372036854775807L;
            if (r.h() == 0) {
                hVar.b = z;
                return;
            }
            long e2 = r.e(j7);
            long g2 = r.g(j7);
            long o2 = o(r, nVar, j2, e2, g2);
            if (o2 < e2) {
                this.m = new B3.b();
                return;
            }
            if (o2 > g2 || (this.n && o2 >= g2)) {
                hVar.b = z;
                return;
            }
            if (z && r.k(o2) >= a2) {
                hVar.b = true;
                return;
            }
            int min = (int) Math.min(this.g, (g2 - o2) + 1);
            if (a2 != -9223372036854775807L) {
                while (min > 1 && r.k((min + o2) - 1) >= a2) {
                    min--;
                }
            }
            hVar.a = q(r, this.e, this.d, this.j.p(), this.j.q(), this.j.g(), o2, min, list.isEmpty() ? j2 : -9223372036854775807L, m, null);
        }
    }

    public void i(F3.c cVar, int i) {
        try {
            this.k = cVar;
            this.l = i;
            long g = cVar.g(i);
            ArrayList n = n();
            for (int i2 = 0; i2 < this.i.length; i2++) {
                j jVar = (j) n.get(this.j.d(i2));
                b[] bVarArr = this.i;
                bVarArr[i2] = bVarArr[i2].b(g, jVar);
            }
        } catch (B3.b e) {
            this.m = e;
        }
    }

    public int j(long j, List list) {
        return (this.m != null || this.j.length() < 2) ? list.size() : this.j.n(j, list);
    }

    public final F.a k(s sVar, List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (sVar.a(i2, elapsedRealtime)) {
                i++;
            }
        }
        int f = E3.b.f(list);
        return new F.a(f, f - this.b.g(list), length, i);
    }

    public final long l(long j, long j2) {
        if (!this.k.d || this.i[0].h() == 0) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(m(j), this.i[0].i(this.i[0].g(j))) - j2);
    }

    public final long m(long j) {
        F3.c cVar = this.k;
        long j2 = cVar.a;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - k0.P0(j2 + cVar.d(this.l).b);
    }

    public final ArrayList n() {
        List list = this.k.d(this.l).c;
        ArrayList arrayList = new ArrayList();
        for (int i : this.c) {
            arrayList.addAll(((F3.a) list.get(i)).c);
        }
        return arrayList;
    }

    public final long o(b bVar, n nVar, long j, long j2, long j3) {
        return nVar != null ? nVar.g() : k0.s(bVar.j(j), j2, j3);
    }

    public D3.f p(b bVar, o oVar, z0 z0Var, int i, Object obj, i iVar, i iVar2) {
        i iVar3 = iVar;
        j jVar = bVar.b;
        if (iVar3 != null) {
            i a2 = iVar3.a(iVar2, bVar.c.a);
            if (a2 != null) {
                iVar3 = a2;
            }
        } else {
            iVar3 = iVar2;
        }
        return new m(oVar, E3.g.a(jVar, bVar.c.a, iVar3, 0), z0Var, i, obj, bVar.a);
    }

    public D3.f q(b bVar, o oVar, int i, z0 z0Var, int i2, Object obj, long j, int i3, long j2, long j3, b4.i iVar) {
        j jVar = bVar.b;
        long k = bVar.k(j);
        i l = bVar.l(j);
        A k2 = A.k();
        if (bVar.a == null) {
            return new p(oVar, E3.g.a(jVar, bVar.c.a, l, bVar.m(j, j3) ? 0 : 8).a().e(k2).a(), z0Var, i2, obj, k, bVar.i(j), j, i, z0Var);
        }
        int i4 = 1;
        int i5 = 1;
        while (i4 < i3) {
            i a2 = l.a(bVar.l(i4 + j), bVar.c.a);
            if (a2 == null) {
                break;
            }
            i5++;
            i4++;
            l = a2;
        }
        long j4 = (i5 + j) - 1;
        long i6 = bVar.i(j4);
        long a3 = b.a(bVar);
        return new k(oVar, E3.g.a(jVar, bVar.c.a, l, bVar.m(j4, j3) ? 0 : 8).a().e(k2).a(), z0Var, i2, obj, k, i6, j2, (a3 == -9223372036854775807L || a3 > i6) ? -9223372036854775807L : a3, j, i5, -jVar.d, bVar.a);
    }

    public final b r(int i) {
        b bVar = this.i[i];
        F3.b j = this.b.j(bVar.b.c);
        if (j == null || j.equals(bVar.c)) {
            return bVar;
        }
        b d = bVar.d(j);
        this.i[i] = d;
        return d;
    }

    public void release() {
        for (b bVar : this.i) {
            g gVar = bVar.a;
            if (gVar != null) {
                gVar.release();
            }
        }
    }
}
