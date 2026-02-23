package B3;

import B3.e;
import B3.z;
import O2.A0;
import O2.H1;
import O2.z0;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements z, z.a {
    public final z a;
    public z.a c;
    public a[] d = new a[0];
    public long e;
    public long f;
    public long g;
    public e.b h;

    public final class a implements Y {
        public final Y a;
        public boolean c;

        public a(Y y) {
            this.a = y;
        }

        public void a() {
            this.a.a();
        }

        public void b() {
            this.c = false;
        }

        public boolean e() {
            return !d.this.o() && this.a.e();
        }

        public int n(long j) {
            if (d.this.o()) {
                return -3;
            }
            return this.a.n(j);
        }

        public int q(A0 a0, U2.g gVar, int i) {
            if (d.this.o()) {
                return -3;
            }
            if (this.c) {
                gVar.setFlags(4);
                return -4;
            }
            int q = this.a.q(a0, gVar, i);
            if (q == -5) {
                z0 z0Var = (z0) d4.a.e(a0.b);
                int i2 = z0Var.C;
                if (i2 != 0 || z0Var.D != 0) {
                    d dVar = d.this;
                    if (dVar.f != 0) {
                        i2 = 0;
                    }
                    a0.b = z0Var.b().P(i2).Q(dVar.g == Long.MIN_VALUE ? z0Var.D : 0).G();
                }
                return -5;
            }
            d dVar2 = d.this;
            long j = dVar2.g;
            if (j == Long.MIN_VALUE || ((q != -4 || gVar.f < j) && !(q == -3 && dVar2.g() == Long.MIN_VALUE && !gVar.e))) {
                return q;
            }
            gVar.clear();
            gVar.setFlags(4);
            this.c = true;
            return -4;
        }
    }

    public d(z zVar, boolean z, long j, long j2) {
        this.a = zVar;
        this.e = z ? j : -9223372036854775807L;
        this.f = j;
        this.g = j2;
    }

    public static boolean t(long j, Z3.s[] sVarArr) {
        if (j != 0) {
            for (Z3.s sVar : sVarArr) {
                if (sVar != null) {
                    z0 p = sVar.p();
                    if (!d4.F.a(p.m, p.j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final H1 a(long j, H1 h1) {
        long s = d4.k0.s(h1.a, 0L, j - this.f);
        long j2 = h1.b;
        long j3 = this.g;
        long s2 = d4.k0.s(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (s == h1.a && s2 == h1.b) ? h1 : new H1(s, s2);
    }

    public boolean b() {
        return this.a.b();
    }

    public long c() {
        long c = this.a.c();
        if (c != Long.MIN_VALUE) {
            long j = this.g;
            if (j == Long.MIN_VALUE || c < j) {
                return c;
            }
        }
        return Long.MIN_VALUE;
    }

    public long d(long j, H1 h1) {
        long j2 = this.f;
        if (j == j2) {
            return j2;
        }
        return this.a.d(j, a(j, h1));
    }

    public void e(z zVar) {
        if (this.h != null) {
            return;
        }
        ((z.a) d4.a.e(this.c)).e(this);
    }

    public boolean f(long j) {
        return this.a.f(j);
    }

    public long g() {
        long g = this.a.g();
        if (g != Long.MIN_VALUE) {
            long j = this.g;
            if (j == Long.MIN_VALUE || g < j) {
                return g;
            }
        }
        return Long.MIN_VALUE;
    }

    public void h(long j) {
        this.a.h(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long i(Z3.s[] r13, boolean[] r14, B3.Y[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            B3.d$a[] r2 = new B3.d.a[r2]
            r0.d = r2
            int r2 = r1.length
            B3.Y[] r9 = new B3.Y[r2]
            r10 = 0
            r2 = 0
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L21
            B3.d$a[] r3 = r0.d
            r4 = r1[r2]
            B3.d$a r4 = (B3.d.a) r4
            r3[r2] = r4
            if (r4 == 0) goto L1c
            B3.Y r11 = r4.a
        L1c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L21:
            B3.z r2 = r0.a
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.i(r3, r4, r5, r6, r7)
            boolean r4 = r12.o()
            if (r4 == 0) goto L43
            long r4 = r0.f
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L43
            r6 = r13
            boolean r4 = t(r4, r13)
            if (r4 == 0) goto L43
            r4 = r2
            goto L48
        L43:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            r0.e = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L63
            long r4 = r0.f
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L61
            long r4 = r0.g
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L63
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L61
            goto L63
        L61:
            r4 = 0
            goto L64
        L63:
            r4 = 1
        L64:
            d4.a.g(r4)
        L67:
            int r4 = r1.length
            if (r10 >= r4) goto L8d
            r4 = r9[r10]
            if (r4 != 0) goto L73
            B3.d$a[] r4 = r0.d
            r4[r10] = r11
            goto L84
        L73:
            B3.d$a[] r5 = r0.d
            r6 = r5[r10]
            if (r6 == 0) goto L7d
            B3.Y r6 = r6.a
            if (r6 == r4) goto L84
        L7d:
            B3.d$a r6 = new B3.d$a
            r6.<init>(r4)
            r5[r10] = r6
        L84:
            B3.d$a[] r4 = r0.d
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L67
        L8d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.d.i(Z3.s[], boolean[], B3.Y[], boolean[], long):long");
    }

    public /* synthetic */ List k(List list) {
        return y.a(this, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long l(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.e = r0
            B3.d$a[] r0 = r6.d
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.b()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            B3.z r0 = r6.a
            long r0 = r0.l(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L34
            long r7 = r6.f
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L35
            long r7 = r6.g
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L35
        L34:
            r2 = 1
        L35:
            d4.a.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.d.l(long):long");
    }

    public long m() {
        if (o()) {
            long j = this.e;
            this.e = -9223372036854775807L;
            long m = m();
            return m != -9223372036854775807L ? m : j;
        }
        long m2 = this.a.m();
        if (m2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        d4.a.g(m2 >= this.f);
        long j2 = this.g;
        d4.a.g(j2 == Long.MIN_VALUE || m2 <= j2);
        return m2;
    }

    public boolean o() {
        return this.e != -9223372036854775807L;
    }

    public void p() {
        e.b bVar = this.h;
        if (bVar != null) {
            throw bVar;
        }
        this.a.p();
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void j(z zVar) {
        ((z.a) d4.a.e(this.c)).j(this);
    }

    public void r(e.b bVar) {
        this.h = bVar;
    }

    public void s(z.a aVar, long j) {
        this.c = aVar;
        this.a.s(this, j);
    }

    public i0 u() {
        return this.a.u();
    }

    public void v(long j, boolean z) {
        this.a.v(j, z);
    }

    public void w(long j, long j2) {
        this.f = j;
        this.g = j2;
    }
}
