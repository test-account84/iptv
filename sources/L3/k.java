package l3;

import O2.l1;
import O2.z0;
import com.google.android.exoplayer2.extractor.g;
import d3.t;
import d3.w;
import d3.x;
import d4.G;
import d4.M;
import d4.k0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import l3.a;
import l3.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k implements d3.i, com.google.android.exoplayer2.extractor.g {
    public static final d3.o y = new j();
    public final int a;
    public final M b;
    public final M c;
    public final M d;
    public final M e;
    public final ArrayDeque f;
    public final m g;
    public final List h;
    public int i;
    public int j;
    public long k;
    public int l;
    public M m;
    public int n;
    public int o;
    public int p;
    public int q;
    public d3.k r;
    public a[] s;
    public long[][] t;
    public int u;
    public long v;
    public int w;
    public w3.b x;

    public static final class a {
        public final o a;
        public final r b;
        public final w c;
        public final x d;
        public int e;

        public a(o oVar, r rVar, w wVar) {
            this.a = oVar;
            this.b = rVar;
            this.c = wVar;
            this.d = "audio/true-hd".equals(oVar.f.m) ? new x() : null;
        }
    }

    public k() {
        this(0);
    }

    public static boolean E(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    public static boolean F(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    public static /* synthetic */ o j(o oVar) {
        return r(oVar);
    }

    public static /* synthetic */ d3.i[] k() {
        return s();
    }

    public static int l(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] m(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].b.b];
            jArr2[i] = aVarArr[i].b.f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            r rVar = aVarArr[i3].b;
            j += rVar.d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = rVar.f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    public static int p(r rVar, long j) {
        int a2 = rVar.a(j);
        return a2 == -1 ? rVar.b(j) : a2;
    }

    public static /* synthetic */ d3.i[] s() {
        return new d3.i[]{new k()};
    }

    public static long t(r rVar, long j, long j2) {
        int p = p(rVar, j);
        return p == -1 ? j2 : Math.min(rVar.c[p], j2);
    }

    public static int x(M m) {
        m.U(8);
        int l = l(m.q());
        if (l != 0) {
            return l;
        }
        m.V(4);
        while (m.a() > 0) {
            int l2 = l(m.q());
            if (l2 != 0) {
                return l2;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A(d3.j r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.k.A(d3.j):boolean");
    }

    public final boolean B(d3.j jVar, t tVar) {
        boolean z;
        long j = this.k - this.l;
        long position = jVar.getPosition() + j;
        M m = this.m;
        if (m != null) {
            jVar.m(m.e(), this.l, (int) j);
            if (this.j == 1718909296) {
                this.w = x(m);
            } else if (!this.f.isEmpty()) {
                ((a.a) this.f.peek()).e(new a.b(this.j, m));
            }
        } else {
            if (j >= 262144) {
                tVar.a = jVar.getPosition() + j;
                z = true;
                v(position);
                return (z || this.i == 2) ? false : true;
            }
            jVar.q((int) j);
        }
        z = false;
        v(position);
        if (z) {
        }
    }

    public final int C(d3.j jVar, t tVar) {
        int i;
        t tVar2;
        long position = jVar.getPosition();
        if (this.n == -1) {
            int q = q(position);
            this.n = q;
            if (q == -1) {
                return -1;
            }
        }
        a aVar = this.s[this.n];
        w wVar = aVar.c;
        int i2 = aVar.e;
        r rVar = aVar.b;
        long j = rVar.c[i2];
        int i3 = rVar.d[i2];
        x xVar = aVar.d;
        long j2 = (j - position) + this.o;
        if (j2 < 0) {
            i = 1;
            tVar2 = tVar;
        } else {
            if (j2 < 262144) {
                if (aVar.a.g == 1) {
                    j2 += 8;
                    i3 -= 8;
                }
                jVar.q((int) j2);
                o oVar = aVar.a;
                if (oVar.j == 0) {
                    if ("audio/ac4".equals(oVar.f.m)) {
                        if (this.p == 0) {
                            Q2.c.a(i3, this.d);
                            wVar.b(this.d, 7);
                            this.p += 7;
                        }
                        i3 += 7;
                    } else if (xVar != null) {
                        xVar.d(jVar);
                    }
                    while (true) {
                        int i4 = this.p;
                        if (i4 >= i3) {
                            break;
                        }
                        int a2 = wVar.a(jVar, i3 - i4, false);
                        this.o += a2;
                        this.p += a2;
                        this.q -= a2;
                    }
                } else {
                    byte[] e = this.c.e();
                    e[0] = 0;
                    e[1] = 0;
                    e[2] = 0;
                    int i5 = aVar.a.j;
                    int i6 = 4 - i5;
                    while (this.p < i3) {
                        int i7 = this.q;
                        if (i7 == 0) {
                            jVar.m(e, i6, i5);
                            this.o += i5;
                            this.c.U(0);
                            int q2 = this.c.q();
                            if (q2 < 0) {
                                throw l1.a("Invalid NAL length", null);
                            }
                            this.q = q2;
                            this.b.U(0);
                            wVar.b(this.b, 4);
                            this.p += 4;
                            i3 += i6;
                        } else {
                            int a3 = wVar.a(jVar, i7, false);
                            this.o += a3;
                            this.p += a3;
                            this.q -= a3;
                        }
                    }
                }
                int i8 = i3;
                r rVar2 = aVar.b;
                long j3 = rVar2.f[i2];
                int i9 = rVar2.g[i2];
                if (xVar != null) {
                    xVar.c(wVar, j3, i9, i8, 0, null);
                    if (i2 + 1 == aVar.b.b) {
                        xVar.a(wVar, null);
                    }
                } else {
                    wVar.f(j3, i9, i8, 0, null);
                }
                aVar.e++;
                this.n = -1;
                this.o = 0;
                this.p = 0;
                this.q = 0;
                return 0;
            }
            tVar2 = tVar;
            i = 1;
        }
        tVar2.a = j;
        return i;
    }

    public final int D(d3.j jVar, t tVar) {
        int c = this.g.c(jVar, tVar, this.h);
        if (c == 1 && tVar.a == 0) {
            n();
        }
        return c;
    }

    public final void G(a aVar, long j) {
        r rVar = aVar.b;
        int a2 = rVar.a(j);
        if (a2 == -1) {
            a2 = rVar.b(j);
        }
        aVar.e = a2;
    }

    public void a(long j, long j2) {
        this.f.clear();
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (j == 0) {
            if (this.i != 3) {
                n();
                return;
            } else {
                this.g.g();
                this.h.clear();
                return;
            }
        }
        for (a aVar : this.s) {
            G(aVar, j2);
            x xVar = aVar.d;
            if (xVar != null) {
                xVar.b();
            }
        }
    }

    public void b(d3.k kVar) {
        this.r = kVar;
    }

    public int d(d3.j jVar, t tVar) {
        while (true) {
            int i = this.i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return C(jVar, tVar);
                    }
                    if (i == 3) {
                        return D(jVar, tVar);
                    }
                    throw new IllegalStateException();
                }
                if (B(jVar, tVar)) {
                    return 1;
                }
            } else if (!A(jVar)) {
                return -1;
            }
        }
    }

    public g.a e(long j) {
        return o(j, -1);
    }

    public boolean g() {
        return true;
    }

    public boolean h(d3.j jVar) {
        return n.d(jVar, (this.a & 2) != 0);
    }

    public long i() {
        return this.v;
    }

    public final void n() {
        this.i = 0;
        this.l = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.extractor.g.a o(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            l3.k$a[] r4 = r0.s
            int r5 = r4.length
            if (r5 != 0) goto L13
            com.google.android.exoplayer2.extractor.g$a r1 = new com.google.android.exoplayer2.extractor.g$a
            d3.u r2 = d3.u.c
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.u
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            l3.r r4 = r4.b
            int r6 = p(r4, r1)
            if (r6 != r5) goto L35
            com.google.android.exoplayer2.extractor.g$a r1 = new com.google.android.exoplayer2.extractor.g$a
            d3.u r2 = d3.u.c
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f
            r12 = r11[r6]
            long[] r11 = r4.c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.b
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f
            r9 = r2[r1]
            long[] r2 = r4.c
            r1 = r2[r1]
            goto L60
        L58:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L5e:
            r1 = r9
            r9 = r7
        L60:
            if (r3 != r5) goto L80
            r3 = 0
        L63:
            l3.k$a[] r4 = r0.s
            int r5 = r4.length
            if (r3 >= r5) goto L80
            int r5 = r0.u
            if (r3 == r5) goto L7d
            r4 = r4[r3]
            l3.r r4 = r4.b
            long r5 = t(r4, r12, r14)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7c
            long r1 = t(r4, r9, r1)
        L7c:
            r14 = r5
        L7d:
            int r3 = r3 + 1
            goto L63
        L80:
            d3.u r3 = new d3.u
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8f
            com.google.android.exoplayer2.extractor.g$a r1 = new com.google.android.exoplayer2.extractor.g$a
            r1.<init>(r3)
            return r1
        L8f:
            d3.u r4 = new d3.u
            r4.<init>(r9, r1)
            com.google.android.exoplayer2.extractor.g$a r1 = new com.google.android.exoplayer2.extractor.g$a
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.k.o(long, int):com.google.android.exoplayer2.extractor.g$a");
    }

    public final int q(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.s;
            if (i3 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.e;
            r rVar = aVar.b;
            if (i4 != rVar.b) {
                long j5 = rVar.c[i4];
                long j6 = ((long[][]) k0.j(this.t))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    public final void u(d3.j jVar) {
        this.d.Q(8);
        jVar.s(this.d.e(), 0, 8);
        b.e(this.d);
        jVar.q(this.d.f());
        jVar.f();
    }

    public final void v(long j) {
        while (!this.f.isEmpty() && ((a.a) this.f.peek()).b == j) {
            a.a aVar = (a.a) this.f.pop();
            if (aVar.a == 1836019574) {
                y(aVar);
                this.f.clear();
                this.i = 2;
            } else if (!this.f.isEmpty()) {
                ((a.a) this.f.peek()).d(aVar);
            }
        }
        if (this.i != 2) {
            n();
        }
    }

    public final void w() {
        if (this.w != 2 || (this.a & 2) == 0) {
            return;
        }
        this.r.e(0, 4).d(new z0.b().Z(this.x == null ? null : new q3.a(this.x)).G());
        this.r.q();
        this.r.n(new g.b(-9223372036854775807L));
    }

    public final void y(a.a aVar) {
        q3.a aVar2;
        q3.a aVar3;
        q3.a aVar4;
        List list;
        int i;
        q3.a aVar5;
        List list2;
        int i2;
        List arrayList = new ArrayList();
        boolean z = this.w == 1;
        d3.r rVar = new d3.r();
        a.b g = aVar.g(1969517665);
        if (g != null) {
            b.i B = b.B(g);
            q3.a aVar6 = B.a;
            q3.a aVar7 = B.b;
            q3.a aVar8 = B.c;
            if (aVar6 != null) {
                rVar.c(aVar6);
            }
            aVar3 = aVar8;
            aVar2 = aVar6;
            aVar4 = aVar7;
        } else {
            aVar2 = null;
            aVar3 = null;
            aVar4 = null;
        }
        a.a f = aVar.f(1835365473);
        q3.a n = f != null ? b.n(f) : null;
        q3.a aVar9 = b.p(((a.b) d4.a.e(aVar.g(1836476516))).b).a;
        q3.a aVar10 = n;
        q3.a aVar11 = aVar2;
        List A = b.A(aVar, rVar, -9223372036854775807L, null, (this.a & 1) != 0, z, new i());
        int size = A.size();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i3 = 0;
        int i4 = -1;
        while (i3 < size) {
            r rVar2 = (r) A.get(i3);
            if (rVar2.b == 0) {
                list = A;
                i = size;
                list2 = arrayList;
                aVar5 = aVar11;
            } else {
                o oVar = rVar2.a;
                List list3 = arrayList;
                long j3 = oVar.e;
                if (j3 == j) {
                    j3 = rVar2.h;
                }
                j2 = Math.max(j2, j3);
                list = A;
                a aVar12 = new a(oVar, rVar2, this.r.e(i3, oVar.b));
                int i5 = "audio/true-hd".equals(oVar.f.m) ? rVar2.e * 16 : rVar2.e + 30;
                z0.b b = oVar.f.b();
                b.Y(i5);
                i = size;
                if (oVar.b == 2 && j3 > 0 && (i2 = rVar2.b) > 1) {
                    b.R(i2 / (j3 / 1000000.0f));
                }
                h.k(oVar.b, rVar, b);
                aVar5 = aVar11;
                h.l(oVar.b, aVar5, aVar10, b, aVar4, this.h.isEmpty() ? null : new q3.a(this.h), aVar3, aVar9);
                aVar12.c.d(b.G());
                if (oVar.b == 2 && i4 == -1) {
                    i4 = list3.size();
                }
                list2 = list3;
                list2.add(aVar12);
            }
            i3++;
            aVar11 = aVar5;
            A = list;
            size = i;
            j = -9223372036854775807L;
            arrayList = list2;
        }
        this.u = i4;
        this.v = j2;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.s = aVarArr;
        this.t = m(aVarArr);
        this.r.q();
        this.r.n(this);
    }

    public final void z(long j) {
        if (this.j == 1836086884) {
            int i = this.l;
            this.x = new w3.b(0L, j, -9223372036854775807L, j + i, this.k - i);
        }
    }

    public k(int i) {
        this.a = i;
        this.i = (i & 4) != 0 ? 3 : 0;
        this.g = new m();
        this.h = new ArrayList();
        this.e = new M(16);
        this.f = new ArrayDeque();
        this.b = new M(G.a);
        this.c = new M(4);
        this.d = new M();
        this.n = -1;
        this.r = d3.k.c0;
        this.s = new a[0];
    }

    public void release() {
    }

    public static /* synthetic */ o r(o oVar) {
        return oVar;
    }
}
