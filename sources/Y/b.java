package y;

import java.util.ArrayList;
import x.d;
import x.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public final ArrayList a = new ArrayList();
    public a b = new a();
    public x.f c;

    public static class a {
        public e.b a;
        public e.b b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public boolean j;
    }

    public interface b {
        void a();

        void b(x.e eVar, a aVar);
    }

    public b(x.f fVar) {
        this.c = fVar;
    }

    public final boolean a(b bVar, x.e eVar, boolean z) {
        this.b.a = eVar.w();
        this.b.b = eVar.K();
        this.b.c = eVar.N();
        this.b.d = eVar.t();
        a aVar = this.b;
        aVar.i = false;
        aVar.j = z;
        e.b bVar2 = aVar.a;
        e.b bVar3 = e.b.MATCH_CONSTRAINT;
        boolean z2 = bVar2 == bVar3;
        boolean z3 = aVar.b == bVar3;
        boolean z4 = z2 && eVar.Q > 0.0f;
        boolean z5 = z3 && eVar.Q > 0.0f;
        if (z4 && eVar.n[0] == 4) {
            aVar.a = e.b.FIXED;
        }
        if (z5 && eVar.n[1] == 4) {
            aVar.b = e.b.FIXED;
        }
        bVar.b(eVar, aVar);
        eVar.A0(this.b.e);
        eVar.e0(this.b.f);
        eVar.d0(this.b.h);
        eVar.Y(this.b.g);
        a aVar2 = this.b;
        aVar2.j = false;
        return aVar2.i;
    }

    public final void b(x.f fVar) {
        int size = fVar.w0.size();
        b Q0 = fVar.Q0();
        for (int i = 0; i < size; i++) {
            x.e eVar = (x.e) fVar.w0.get(i);
            if (!(eVar instanceof x.g) && (!eVar.e.e.j || !eVar.f.e.j)) {
                e.b q = eVar.q(0);
                e.b q2 = eVar.q(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (q != bVar || eVar.l == 1 || q2 != bVar || eVar.m == 1) {
                    a(Q0, eVar, false);
                }
            }
        }
        Q0.a();
    }

    public final void c(x.f fVar, String str, int i, int i2) {
        int C = fVar.C();
        int B = fVar.B();
        fVar.q0(0);
        fVar.p0(0);
        fVar.A0(i);
        fVar.e0(i2);
        fVar.q0(C);
        fVar.p0(B);
        this.c.G0();
    }

    public long d(x.f fVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        int i10;
        boolean z2;
        boolean z3;
        int i11;
        int i12;
        int i13;
        b bVar;
        int i14;
        b Q0 = fVar.Q0();
        int size = fVar.w0.size();
        int N = fVar.N();
        int t = fVar.t();
        boolean b2 = x.j.b(i, 128);
        boolean z4 = b2 || x.j.b(i, 64);
        if (z4) {
            for (int i15 = 0; i15 < size; i15++) {
                x.e eVar = (x.e) fVar.w0.get(i15);
                e.b w = eVar.w();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                boolean z5 = (w == bVar2) && (eVar.K() == bVar2) && eVar.r() > 0.0f;
                if ((eVar.T() && z5) || ((eVar.V() && z5) || eVar.T() || eVar.V())) {
                    z4 = false;
                    break;
                }
            }
        }
        if (z4) {
            int i16 = w.d.q;
        }
        if (z4 && ((i4 == 1073741824 && i6 == 1073741824) || b2)) {
            int min = Math.min(fVar.A(), i5);
            int min2 = Math.min(fVar.z(), i7);
            if (i4 == 1073741824 && fVar.N() != min) {
                fVar.A0(min);
                fVar.S0();
            }
            if (i6 == 1073741824 && fVar.t() != min2) {
                fVar.e0(min2);
                fVar.S0();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                z = fVar.N0(b2);
                i10 = 2;
            } else {
                z = fVar.O0(b2);
                if (i4 == 1073741824) {
                    z &= fVar.P0(b2, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    z &= fVar.P0(b2, 1);
                    i10++;
                }
            }
            if (z) {
                fVar.E0(i4 == 1073741824, i6 == 1073741824);
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (z && i10 == 2) {
            return 0L;
        }
        if (size > 0) {
            b(fVar);
        }
        int R0 = fVar.R0();
        int size2 = this.a.size();
        if (size > 0) {
            c(fVar, "First pass", N, t);
        }
        if (size2 > 0) {
            e.b w2 = fVar.w();
            e.b bVar3 = e.b.WRAP_CONTENT;
            boolean z6 = w2 == bVar3;
            boolean z7 = fVar.K() == bVar3;
            int max = Math.max(fVar.N(), this.c.C());
            int max2 = Math.max(fVar.t(), this.c.B());
            for (int i17 = 0; i17 < size2; i17++) {
            }
            int i18 = 0;
            boolean z8 = false;
            for (int i19 = 2; i18 < i19; i19 = 2) {
                int i20 = 0;
                while (i20 < size2) {
                    x.e eVar2 = (x.e) this.a.get(i20);
                    if ((eVar2 instanceof x.h) || (eVar2 instanceof x.g)) {
                        i11 = size2;
                    } else {
                        i11 = size2;
                        if (eVar2.M() != 8 && (!eVar2.e.e.j || !eVar2.f.e.j)) {
                            int N2 = eVar2.N();
                            int t2 = eVar2.t();
                            i12 = R0;
                            int l = eVar2.l();
                            i13 = i18;
                            boolean a2 = z8 | a(Q0, eVar2, true);
                            int N3 = eVar2.N();
                            bVar = Q0;
                            int t3 = eVar2.t();
                            if (N3 != N2) {
                                eVar2.A0(N3);
                                if (z6 && eVar2.G() > max) {
                                    max = Math.max(max, eVar2.G() + eVar2.k(d.b.RIGHT).b());
                                }
                                a2 = true;
                            }
                            if (t3 != t2) {
                                eVar2.e0(t3);
                                if (z7 && eVar2.n() > max2) {
                                    max2 = Math.max(max2, eVar2.n() + eVar2.k(d.b.BOTTOM).b());
                                }
                                a2 = true;
                            }
                            if (!eVar2.Q() || l == eVar2.l()) {
                                z8 = a2;
                            } else {
                                i14 = 1;
                                z8 = true;
                                i20 += i14;
                                size2 = i11;
                                R0 = i12;
                                i18 = i13;
                                Q0 = bVar;
                            }
                        }
                        i14 = 1;
                        i20 += i14;
                        size2 = i11;
                        R0 = i12;
                        i18 = i13;
                        Q0 = bVar;
                    }
                    i12 = R0;
                    bVar = Q0;
                    i13 = i18;
                    i14 = 1;
                    i20 += i14;
                    size2 = i11;
                    R0 = i12;
                    i18 = i13;
                    Q0 = bVar;
                }
                int i21 = R0;
                int i22 = size2;
                b bVar4 = Q0;
                int i23 = i18;
                if (z8) {
                    c(fVar, "intermediate pass", N, t);
                    z8 = false;
                }
                i18 = i23 + 1;
                size2 = i22;
                R0 = i21;
                Q0 = bVar4;
            }
            int i24 = R0;
            if (z8) {
                c(fVar, "2nd pass", N, t);
                if (fVar.N() < max) {
                    fVar.A0(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (fVar.t() < max2) {
                    fVar.e0(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    c(fVar, "3rd pass", N, t);
                }
            }
            R0 = i24;
        }
        fVar.b1(R0);
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(x.f r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = r6.a
            r0.clear()
            java.util.ArrayList r0 = r7.w0
            int r0 = r0.size()
            r1 = 0
        Lc:
            if (r1 >= r0) goto L3a
            java.util.ArrayList r2 = r7.w0
            java.lang.Object r2 = r2.get(r1)
            x.e r2 = (x.e) r2
            x.e$b r3 = r2.w()
            x.e$b r4 = x.e.b.MATCH_CONSTRAINT
            if (r3 == r4) goto L32
            x.e$b r3 = r2.w()
            x.e$b r5 = x.e.b.MATCH_PARENT
            if (r3 == r5) goto L32
            x.e$b r3 = r2.K()
            if (r3 == r4) goto L32
            x.e$b r3 = r2.K()
            if (r3 != r5) goto L37
        L32:
            java.util.ArrayList r3 = r6.a
            r3.add(r2)
        L37:
            int r1 = r1 + 1
            goto Lc
        L3a:
            r7.S0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y.b.e(x.f):void");
    }
}
