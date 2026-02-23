package l3;

import O2.l1;
import O2.z0;
import V2.m;
import android.util.Pair;
import android.util.SparseArray;
import d3.t;
import d3.w;
import d4.B;
import d4.G;
import d4.M;
import d4.Z;
import d4.k0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import l3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g implements d3.i {
    public static final d3.o I = new e();
    public static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final z0 K = new z0.b().g0("application/x-emsg").G();
    public int A;
    public int B;
    public int C;
    public boolean D;
    public d3.k E;
    public w[] F;
    public w[] G;
    public boolean H;
    public final int a;
    public final o b;
    public final List c;
    public final SparseArray d;
    public final M e;
    public final M f;
    public final M g;
    public final byte[] h;
    public final M i;
    public final Z j;
    public final s3.c k;
    public final M l;
    public final ArrayDeque m;
    public final ArrayDeque n;
    public final w o;
    public int p;
    public int q;
    public long r;
    public int s;
    public M t;
    public long u;
    public int v;
    public long w;
    public long x;
    public long y;
    public b z;

    public static final class a {
        public final long a;
        public final boolean b;
        public final int c;

        public a(long j, boolean z, int i) {
            this.a = j;
            this.b = z;
            this.c = i;
        }
    }

    public static final class b {
        public final w a;
        public r d;
        public c e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean l;
        public final q b = new q();
        public final M c = new M();
        public final M j = new M(1);
        public final M k = new M();

        public b(w wVar, r rVar, c cVar) {
            this.a = wVar;
            this.d = rVar;
            this.e = cVar;
            j(rVar, cVar);
        }

        public static /* synthetic */ boolean a(b bVar) {
            return bVar.l;
        }

        public static /* synthetic */ boolean b(b bVar, boolean z) {
            bVar.l = z;
            return z;
        }

        public int c() {
            int i = !this.l ? this.d.g[this.f] : this.b.k[this.f] ? 1 : 0;
            return g() != null ? i | 1073741824 : i;
        }

        public long d() {
            return !this.l ? this.d.c[this.f] : this.b.g[this.h];
        }

        public long e() {
            return !this.l ? this.d.f[this.f] : this.b.c(this.f);
        }

        public int f() {
            return !this.l ? this.d.d[this.f] : this.b.i[this.f];
        }

        public p g() {
            if (!this.l) {
                return null;
            }
            int i = ((c) k0.j(this.b.a)).a;
            p pVar = this.b.n;
            if (pVar == null) {
                pVar = this.d.a.a(i);
            }
            if (pVar == null || !pVar.a) {
                return null;
            }
            return pVar;
        }

        public boolean h() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.b.h;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int i(int i, int i2) {
            M m;
            p g = g();
            if (g == null) {
                return 0;
            }
            int i3 = g.d;
            if (i3 != 0) {
                m = this.b.o;
            } else {
                byte[] bArr = (byte[]) k0.j(g.e);
                this.k.S(bArr, bArr.length);
                M m2 = this.k;
                i3 = bArr.length;
                m = m2;
            }
            boolean g2 = this.b.g(this.f);
            boolean z = g2 || i2 != 0;
            this.j.e()[0] = (byte) ((z ? 128 : 0) | i3);
            this.j.U(0);
            this.a.c(this.j, 1, 1);
            this.a.c(m, i3, 1);
            if (!z) {
                return i3 + 1;
            }
            if (!g2) {
                this.c.Q(8);
                byte[] e = this.c.e();
                e[0] = 0;
                e[1] = 1;
                e[2] = (byte) ((i2 >> 8) & 255);
                e[3] = (byte) (i2 & 255);
                e[4] = (byte) ((i >> 24) & 255);
                e[5] = (byte) ((i >> 16) & 255);
                e[6] = (byte) ((i >> 8) & 255);
                e[7] = (byte) (i & 255);
                this.a.c(this.c, 8, 1);
                return i3 + 9;
            }
            M m3 = this.b.o;
            int N = m3.N();
            m3.V(-2);
            int i4 = (N * 6) + 2;
            if (i2 != 0) {
                this.c.Q(i4);
                byte[] e2 = this.c.e();
                m3.l(e2, 0, i4);
                int i5 = (((e2[2] & 255) << 8) | (e2[3] & 255)) + i2;
                e2[2] = (byte) ((i5 >> 8) & 255);
                e2[3] = (byte) (i5 & 255);
                m3 = this.c;
            }
            this.a.c(m3, i4, 1);
            return i3 + 1 + i4;
        }

        public void j(r rVar, c cVar) {
            this.d = rVar;
            this.e = cVar;
            this.a.d(rVar.a.f);
            k();
        }

        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }

        public void l(long j) {
            int i = this.f;
            while (true) {
                q qVar = this.b;
                if (i >= qVar.f || qVar.c(i) > j) {
                    return;
                }
                if (this.b.k[i]) {
                    this.i = i;
                }
                i++;
            }
        }

        public void m() {
            p g = g();
            if (g == null) {
                return;
            }
            M m = this.b.o;
            int i = g.d;
            if (i != 0) {
                m.V(i);
            }
            if (this.b.g(this.f)) {
                m.V(m.N() * 6);
            }
        }

        public void n(V2.m mVar) {
            p a = this.d.a.a(((c) k0.j(this.b.a)).a);
            this.a.d(this.d.a.f.b().O(mVar.d(a != null ? a.b : null)).G());
        }
    }

    public g() {
        this(0);
    }

    public static void A(M m, q qVar) {
        z(m, 0, qVar);
    }

    public static Pair B(M m, long j) {
        long M;
        long M2;
        m.U(8);
        int c = l3.a.c(m.q());
        m.V(4);
        long J2 = m.J();
        if (c == 0) {
            M = m.J();
            M2 = m.J();
        } else {
            M = m.M();
            M2 = m.M();
        }
        long j2 = M;
        long j3 = j + M2;
        long c1 = k0.c1(j2, 1000000L, J2);
        m.V(2);
        int N = m.N();
        int[] iArr = new int[N];
        long[] jArr = new long[N];
        long[] jArr2 = new long[N];
        long[] jArr3 = new long[N];
        long j4 = j2;
        long j5 = c1;
        int i = 0;
        while (i < N) {
            int q = m.q();
            if ((q & Integer.MIN_VALUE) != 0) {
                throw l1.a("Unhandled indirect reference", null);
            }
            long J3 = m.J();
            iArr[i] = q & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j5;
            long j6 = j4 + J3;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = N;
            long c12 = k0.c1(j6, 1000000L, J2);
            jArr4[i] = c12 - jArr5[i];
            m.V(4);
            j3 += r1[i];
            i++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            N = i2;
            j4 = j6;
            j5 = c12;
        }
        return Pair.create(Long.valueOf(c1), new com.google.android.exoplayer2.extractor.b(iArr, jArr, jArr2, jArr3));
    }

    public static long C(M m) {
        m.U(8);
        return l3.a.c(m.q()) == 1 ? m.M() : m.J();
    }

    public static b D(M m, SparseArray sparseArray, boolean z) {
        m.U(8);
        int b2 = l3.a.b(m.q());
        b bVar = (b) (z ? sparseArray.valueAt(0) : sparseArray.get(m.q()));
        if (bVar == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long M = m.M();
            q qVar = bVar.b;
            qVar.c = M;
            qVar.d = M;
        }
        c cVar = bVar.e;
        bVar.b.a = new c((b2 & 2) != 0 ? m.q() - 1 : cVar.a, (b2 & 8) != 0 ? m.q() : cVar.b, (b2 & 16) != 0 ? m.q() : cVar.c, (b2 & 32) != 0 ? m.q() : cVar.d);
        return bVar;
    }

    public static void E(a.a aVar, SparseArray sparseArray, boolean z, int i, byte[] bArr) {
        b D = D(((a.b) d4.a.e(aVar.g(1952868452))).b, sparseArray, z);
        if (D == null) {
            return;
        }
        q qVar = D.b;
        long j = qVar.q;
        boolean z2 = qVar.r;
        D.k();
        b.b(D, true);
        a.b g = aVar.g(1952867444);
        if (g == null || (i & 2) != 0) {
            qVar.q = j;
            qVar.r = z2;
        } else {
            qVar.q = C(g.b);
            qVar.r = true;
        }
        H(aVar, D, i);
        p a2 = D.d.a.a(((c) d4.a.e(qVar.a)).a);
        a.b g2 = aVar.g(1935763834);
        if (g2 != null) {
            x((p) d4.a.e(a2), g2.b, qVar);
        }
        a.b g3 = aVar.g(1935763823);
        if (g3 != null) {
            w(g3.b, qVar);
        }
        a.b g4 = aVar.g(1936027235);
        if (g4 != null) {
            A(g4.b, qVar);
        }
        y(aVar, a2 != null ? a2.b : null, qVar);
        int size = aVar.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = (a.b) aVar.c.get(i2);
            if (bVar.a == 1970628964) {
                I(bVar.b, qVar, bArr);
            }
        }
    }

    public static Pair F(M m) {
        m.U(12);
        return Pair.create(Integer.valueOf(m.q()), new c(m.q() - 1, m.q(), m.q(), m.q()));
    }

    public static int G(b bVar, int i, int i2, M m, int i3) {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        int i6;
        b bVar2 = bVar;
        m.U(8);
        int b2 = l3.a.b(m.q());
        o oVar = bVar2.d.a;
        q qVar = bVar2.b;
        c cVar = (c) k0.j(qVar.a);
        qVar.h[i] = m.L();
        long[] jArr = qVar.g;
        long j = qVar.c;
        jArr[i] = j;
        if ((b2 & 1) != 0) {
            jArr[i] = j + m.q();
        }
        boolean z6 = (b2 & 4) != 0;
        int i7 = cVar.d;
        if (z6) {
            i7 = m.q();
        }
        boolean z7 = (b2 & 256) != 0;
        boolean z8 = (b2 & 512) != 0;
        boolean z9 = (b2 & 1024) != 0;
        boolean z10 = (b2 & 2048) != 0;
        long j2 = l(oVar) ? ((long[]) k0.j(oVar.i))[0] : 0L;
        int[] iArr = qVar.i;
        long[] jArr2 = qVar.j;
        boolean[] zArr = qVar.k;
        int i8 = i7;
        boolean z11 = oVar.b == 2 && (i2 & 1) != 0;
        int i9 = i3 + qVar.h[i];
        boolean z12 = z11;
        long j3 = oVar.c;
        long j4 = qVar.q;
        int i10 = i3;
        while (i10 < i9) {
            int e = e(z7 ? m.q() : cVar.b);
            if (z8) {
                i4 = m.q();
                z = z7;
            } else {
                z = z7;
                i4 = cVar.c;
            }
            int e2 = e(i4);
            if (z9) {
                z2 = z6;
                i5 = m.q();
            } else if (i10 == 0 && z6) {
                z2 = z6;
                i5 = i8;
            } else {
                z2 = z6;
                i5 = cVar.d;
            }
            if (z10) {
                z3 = z10;
                z4 = z8;
                z5 = z9;
                i6 = m.q();
            } else {
                z3 = z10;
                z4 = z8;
                z5 = z9;
                i6 = 0;
            }
            long c1 = k0.c1((i6 + j4) - j2, 1000000L, j3);
            jArr2[i10] = c1;
            if (!qVar.r) {
                jArr2[i10] = c1 + bVar2.d.h;
            }
            iArr[i10] = e2;
            zArr[i10] = ((i5 >> 16) & 1) == 0 && (!z12 || i10 == 0);
            j4 += e;
            i10++;
            bVar2 = bVar;
            z7 = z;
            z6 = z2;
            z10 = z3;
            z8 = z4;
            z9 = z5;
        }
        qVar.q = j4;
        return i9;
    }

    public static void H(a.a aVar, b bVar, int i) {
        List list = aVar.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            a.b bVar2 = (a.b) list.get(i4);
            if (bVar2.a == 1953658222) {
                M m = bVar2.b;
                m.U(12);
                int L = m.L();
                if (L > 0) {
                    i3 += L;
                    i2++;
                }
            }
        }
        bVar.h = 0;
        bVar.g = 0;
        bVar.f = 0;
        bVar.b.e(i2, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar3 = (a.b) list.get(i7);
            if (bVar3.a == 1953658222) {
                i6 = G(bVar, i5, i, bVar3.b, i6);
                i5++;
            }
        }
    }

    public static void I(M m, q qVar, byte[] bArr) {
        m.U(8);
        m.l(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            z(m, 16, qVar);
        }
    }

    private void J(long j) {
        while (!this.m.isEmpty() && ((a.a) this.m.peek()).b == j) {
            o((a.a) this.m.pop());
        }
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean K(d3.j r12) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.g.K(d3.j):boolean");
    }

    private static boolean O(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    private static boolean P(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    public static /* synthetic */ d3.i[] c() {
        return m();
    }

    public static int e(int i) {
        if (i >= 0) {
            return i;
        }
        throw l1.a("Unexpected negative value: " + i, null);
    }

    private void f() {
        this.p = 0;
        this.s = 0;
    }

    public static V2.m i(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            a.b bVar = (a.b) list.get(i);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] e = bVar.b.e();
                UUID f = l.f(e);
                if (f == null) {
                    B.j("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new m.b(f, "video/mp4", e));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new V2.m((List) arrayList);
    }

    public static b j(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b bVar2 = (b) sparseArray.valueAt(i);
            if ((b.a(bVar2) || bVar2.f != bVar2.d.b) && (!b.a(bVar2) || bVar2.h != bVar2.b.e)) {
                long d = bVar2.d();
                if (d < j) {
                    bVar = bVar2;
                    j = d;
                }
            }
        }
        return bVar;
    }

    public static boolean l(o oVar) {
        long[] jArr;
        long[] jArr2 = oVar.h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = oVar.i) == null) {
            return false;
        }
        long j = jArr2[0];
        return j == 0 || k0.c1(j + jArr[0], 1000000L, oVar.d) >= oVar.e;
    }

    private static /* synthetic */ d3.i[] m() {
        return new d3.i[]{new g()};
    }

    public static long u(M m) {
        m.U(8);
        return l3.a.c(m.q()) == 0 ? m.J() : m.M();
    }

    public static void v(a.a aVar, SparseArray sparseArray, boolean z, int i, byte[] bArr) {
        int size = aVar.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.a aVar2 = (a.a) aVar.d.get(i2);
            if (aVar2.a == 1953653094) {
                E(aVar2, sparseArray, z, i, bArr);
            }
        }
    }

    public static void w(M m, q qVar) {
        m.U(8);
        int q = m.q();
        if ((l3.a.b(q) & 1) == 1) {
            m.V(8);
        }
        int L = m.L();
        if (L == 1) {
            qVar.d += l3.a.c(q) == 0 ? m.J() : m.M();
        } else {
            throw l1.a("Unexpected saio entry count: " + L, null);
        }
    }

    public static void x(p pVar, M m, q qVar) {
        int i;
        int i2 = pVar.d;
        m.U(8);
        if ((l3.a.b(m.q()) & 1) == 1) {
            m.V(8);
        }
        int H = m.H();
        int L = m.L();
        if (L > qVar.f) {
            throw l1.a("Saiz sample count " + L + " is greater than fragment sample count" + qVar.f, null);
        }
        if (H == 0) {
            boolean[] zArr = qVar.m;
            i = 0;
            for (int i3 = 0; i3 < L; i3++) {
                int H2 = m.H();
                i += H2;
                zArr[i3] = H2 > i2;
            }
        } else {
            i = H * L;
            Arrays.fill(qVar.m, 0, L, H > i2);
        }
        Arrays.fill(qVar.m, L, qVar.f, false);
        if (i > 0) {
            qVar.d(i);
        }
    }

    public static void y(a.a aVar, String str, q qVar) {
        byte[] bArr = null;
        M m = null;
        M m2 = null;
        for (int i = 0; i < aVar.c.size(); i++) {
            a.b bVar = (a.b) aVar.c.get(i);
            M m3 = bVar.b;
            int i2 = bVar.a;
            if (i2 == 1935828848) {
                m3.U(12);
                if (m3.q() == 1936025959) {
                    m = m3;
                }
            } else if (i2 == 1936158820) {
                m3.U(12);
                if (m3.q() == 1936025959) {
                    m2 = m3;
                }
            }
        }
        if (m == null || m2 == null) {
            return;
        }
        m.U(8);
        int c = l3.a.c(m.q());
        m.V(4);
        if (c == 1) {
            m.V(4);
        }
        if (m.q() != 1) {
            throw l1.e("Entry count in sbgp != 1 (unsupported).");
        }
        m2.U(8);
        int c2 = l3.a.c(m2.q());
        m2.V(4);
        if (c2 == 1) {
            if (m2.J() == 0) {
                throw l1.e("Variable length description in sgpd found (unsupported)");
            }
        } else if (c2 >= 2) {
            m2.V(4);
        }
        if (m2.J() != 1) {
            throw l1.e("Entry count in sgpd != 1 (unsupported).");
        }
        m2.V(1);
        int H = m2.H();
        int i3 = (H & 240) >> 4;
        int i4 = H & 15;
        boolean z = m2.H() == 1;
        if (z) {
            int H2 = m2.H();
            byte[] bArr2 = new byte[16];
            m2.l(bArr2, 0, 16);
            if (H2 == 0) {
                int H3 = m2.H();
                bArr = new byte[H3];
                m2.l(bArr, 0, H3);
            }
            qVar.l = true;
            qVar.n = new p(z, str, H2, bArr2, i3, i4, bArr);
        }
    }

    public static void z(M m, int i, q qVar) {
        m.U(i + 8);
        int b2 = l3.a.b(m.q());
        if ((b2 & 1) != 0) {
            throw l1.e("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int L = m.L();
        if (L == 0) {
            Arrays.fill(qVar.m, 0, qVar.f, false);
            return;
        }
        if (L == qVar.f) {
            Arrays.fill(qVar.m, 0, L, z);
            qVar.d(m.a());
            qVar.b(m);
        } else {
            throw l1.a("Senc sample count " + L + " is different from fragment sample count" + qVar.f, null);
        }
    }

    public final void L(d3.j jVar) {
        int i = ((int) this.r) - this.s;
        M m = this.t;
        if (m != null) {
            jVar.m(m.e(), 8, i);
            q(new a.b(this.q, m), jVar.getPosition());
        } else {
            jVar.q(i);
        }
        J(jVar.getPosition());
    }

    public final void M(d3.j jVar) {
        int size = this.d.size();
        long j = Long.MAX_VALUE;
        b bVar = null;
        for (int i = 0; i < size; i++) {
            q qVar = ((b) this.d.valueAt(i)).b;
            if (qVar.p) {
                long j2 = qVar.d;
                if (j2 < j) {
                    bVar = (b) this.d.valueAt(i);
                    j = j2;
                }
            }
        }
        if (bVar == null) {
            this.p = 3;
            return;
        }
        int position = (int) (j - jVar.getPosition());
        if (position < 0) {
            throw l1.a("Offset to encryption data was negative.", null);
        }
        jVar.q(position);
        bVar.b.a(jVar);
    }

    public final boolean N(d3.j jVar) {
        int a2;
        int i;
        b bVar = this.z;
        Throwable th = null;
        if (bVar == null) {
            bVar = j(this.d);
            if (bVar == null) {
                int position = (int) (this.u - jVar.getPosition());
                if (position < 0) {
                    throw l1.a("Offset to end of mdat was negative.", null);
                }
                jVar.q(position);
                f();
                return false;
            }
            int d = (int) (bVar.d() - jVar.getPosition());
            if (d < 0) {
                B.j("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d = 0;
            }
            jVar.q(d);
            this.z = bVar;
        }
        int i2 = 4;
        int i3 = 1;
        if (this.p == 3) {
            int f = bVar.f();
            this.A = f;
            if (bVar.f < bVar.i) {
                jVar.q(f);
                bVar.m();
                if (!bVar.h()) {
                    this.z = null;
                }
                this.p = 3;
                return true;
            }
            if (bVar.d.a.g == 1) {
                this.A = f - 8;
                jVar.q(8);
            }
            if ("audio/ac4".equals(bVar.d.a.f.m)) {
                this.B = bVar.i(this.A, 7);
                Q2.c.a(this.A, this.i);
                bVar.a.b(this.i, 7);
                i = this.B + 7;
            } else {
                i = bVar.i(this.A, 0);
            }
            this.B = i;
            this.A += this.B;
            this.p = 4;
            this.C = 0;
        }
        o oVar = bVar.d.a;
        w wVar = bVar.a;
        long e = bVar.e();
        Z z = this.j;
        if (z != null) {
            e = z.a(e);
        }
        long j = e;
        if (oVar.j == 0) {
            while (true) {
                int i4 = this.B;
                int i5 = this.A;
                if (i4 >= i5) {
                    break;
                }
                this.B += wVar.a(jVar, i5 - i4, false);
            }
        } else {
            byte[] e2 = this.f.e();
            e2[0] = 0;
            e2[1] = 0;
            e2[2] = 0;
            int i6 = oVar.j;
            int i7 = i6 + 1;
            int i8 = 4 - i6;
            while (this.B < this.A) {
                int i9 = this.C;
                if (i9 == 0) {
                    jVar.m(e2, i8, i7);
                    this.f.U(0);
                    int q = this.f.q();
                    if (q < i3) {
                        throw l1.a("Invalid NAL length", th);
                    }
                    this.C = q - 1;
                    this.e.U(0);
                    wVar.b(this.e, i2);
                    wVar.b(this.f, i3);
                    this.D = this.G.length > 0 && G.g(oVar.f.m, e2[i2]);
                    this.B += 5;
                    this.A += i8;
                } else {
                    if (this.D) {
                        this.g.Q(i9);
                        jVar.m(this.g.e(), 0, this.C);
                        wVar.b(this.g, this.C);
                        a2 = this.C;
                        int q2 = G.q(this.g.e(), this.g.g());
                        this.g.U("video/hevc".equals(oVar.f.m) ? 1 : 0);
                        this.g.T(q2);
                        d3.b.a(j, this.g, this.G);
                    } else {
                        a2 = wVar.a(jVar, i9, false);
                    }
                    this.B += a2;
                    this.C -= a2;
                    th = null;
                    i2 = 4;
                    i3 = 1;
                }
            }
        }
        int c = bVar.c();
        p g = bVar.g();
        wVar.f(j, c, this.A, 0, g != null ? g.c : null);
        t(j);
        if (!bVar.h()) {
            this.z = null;
        }
        this.p = 3;
        return true;
    }

    public void a(long j, long j2) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            ((b) this.d.valueAt(i)).k();
        }
        this.n.clear();
        this.v = 0;
        this.w = j2;
        this.m.clear();
        f();
    }

    public void b(d3.k kVar) {
        this.E = kVar;
        f();
        k();
        o oVar = this.b;
        if (oVar != null) {
            this.d.put(0, new b(kVar.e(0, oVar.b), new r(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.q();
        }
    }

    public int d(d3.j jVar, t tVar) {
        while (true) {
            int i = this.p;
            if (i != 0) {
                if (i == 1) {
                    L(jVar);
                } else if (i == 2) {
                    M(jVar);
                } else if (N(jVar)) {
                    return 0;
                }
            } else if (!K(jVar)) {
                return -1;
            }
        }
    }

    public final c g(SparseArray sparseArray, int i) {
        return (c) (sparseArray.size() == 1 ? sparseArray.valueAt(0) : d4.a.e((c) sparseArray.get(i)));
    }

    public boolean h(d3.j jVar) {
        return n.b(jVar);
    }

    public final void k() {
        int i;
        w[] wVarArr = new w[2];
        this.F = wVarArr;
        w wVar = this.o;
        int i2 = 0;
        if (wVar != null) {
            wVarArr[0] = wVar;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.a & 4) != 0) {
            wVarArr[i] = this.E.e(100, 5);
            i3 = 101;
            i++;
        }
        w[] wVarArr2 = (w[]) k0.U0(this.F, i);
        this.F = wVarArr2;
        for (w wVar2 : wVarArr2) {
            wVar2.d(K);
        }
        this.G = new w[this.c.size()];
        while (i2 < this.G.length) {
            w e = this.E.e(i3, 3);
            e.d((z0) this.c.get(i2));
            this.G[i2] = e;
            i2++;
            i3++;
        }
    }

    public final void o(a.a aVar) {
        int i = aVar.a;
        if (i == 1836019574) {
            s(aVar);
        } else if (i == 1836019558) {
            r(aVar);
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            ((a.a) this.m.peek()).d(aVar);
        }
    }

    public final void p(M m) {
        long c1;
        String str;
        long c12;
        String str2;
        long J2;
        long j;
        ArrayDeque arrayDeque;
        a aVar;
        if (this.F.length == 0) {
            return;
        }
        m.U(8);
        int c = l3.a.c(m.q());
        if (c == 0) {
            String str3 = (String) d4.a.e(m.B());
            String str4 = (String) d4.a.e(m.B());
            long J3 = m.J();
            c1 = k0.c1(m.J(), 1000000L, J3);
            long j2 = this.y;
            long j3 = j2 != -9223372036854775807L ? j2 + c1 : -9223372036854775807L;
            str = str3;
            c12 = k0.c1(m.J(), 1000L, J3);
            str2 = str4;
            J2 = m.J();
            j = j3;
        } else {
            if (c != 1) {
                B.j("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + c);
                return;
            }
            long J4 = m.J();
            j = k0.c1(m.M(), 1000000L, J4);
            long c13 = k0.c1(m.J(), 1000L, J4);
            long J5 = m.J();
            str = (String) d4.a.e(m.B());
            c12 = c13;
            J2 = J5;
            str2 = (String) d4.a.e(m.B());
            c1 = -9223372036854775807L;
        }
        byte[] bArr = new byte[m.a()];
        m.l(bArr, 0, m.a());
        M m2 = new M(this.k.a(new s3.a(str, str2, c12, J2, bArr)));
        int a2 = m2.a();
        for (w wVar : this.F) {
            m2.U(0);
            wVar.b(m2, a2);
        }
        if (j == -9223372036854775807L) {
            this.n.addLast(new a(c1, true, a2));
        } else {
            if (this.n.isEmpty()) {
                Z z = this.j;
                if (z == null || z.f()) {
                    Z z2 = this.j;
                    if (z2 != null) {
                        j = z2.a(j);
                    }
                    for (w wVar2 : this.F) {
                        wVar2.f(j, 1, a2, 0, null);
                    }
                    return;
                }
                arrayDeque = this.n;
                aVar = new a(j, false, a2);
            } else {
                arrayDeque = this.n;
                aVar = new a(j, false, a2);
            }
            arrayDeque.addLast(aVar);
        }
        this.v += a2;
    }

    public final void q(a.b bVar, long j) {
        if (!this.m.isEmpty()) {
            ((a.a) this.m.peek()).e(bVar);
            return;
        }
        int i = bVar.a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                p(bVar.b);
            }
        } else {
            Pair B = B(bVar.b, j);
            this.y = ((Long) B.first).longValue();
            this.E.n((com.google.android.exoplayer2.extractor.g) B.second);
            this.H = true;
        }
    }

    public final void r(a.a aVar) {
        v(aVar, this.d, this.b != null, this.a, this.h);
        V2.m i = i(aVar.c);
        if (i != null) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((b) this.d.valueAt(i2)).n(i);
            }
        }
        if (this.w != -9223372036854775807L) {
            int size2 = this.d.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((b) this.d.valueAt(i3)).l(this.w);
            }
            this.w = -9223372036854775807L;
        }
    }

    public final void s(a.a aVar) {
        int i = 0;
        d4.a.h(this.b == null, "Unexpected moov box.");
        V2.m i2 = i(aVar.c);
        a.a aVar2 = (a.a) d4.a.e(aVar.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = aVar2.c.size();
        long j = -9223372036854775807L;
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = (a.b) aVar2.c.get(i3);
            int i4 = bVar.a;
            if (i4 == 1953654136) {
                Pair F = F(bVar.b);
                sparseArray.put(((Integer) F.first).intValue(), (c) F.second);
            } else if (i4 == 1835362404) {
                j = u(bVar.b);
            }
        }
        List A = l3.b.A(aVar, new d3.r(), j, i2, (this.a & 16) != 0, false, new f(this));
        int size2 = A.size();
        if (this.d.size() != 0) {
            d4.a.g(this.d.size() == size2);
            while (i < size2) {
                r rVar = (r) A.get(i);
                o oVar = rVar.a;
                ((b) this.d.get(oVar.a)).j(rVar, g(sparseArray, oVar.a));
                i++;
            }
            return;
        }
        while (i < size2) {
            r rVar2 = (r) A.get(i);
            o oVar2 = rVar2.a;
            this.d.put(oVar2.a, new b(this.E.e(i, oVar2.b), rVar2, g(sparseArray, oVar2.a)));
            this.x = Math.max(this.x, oVar2.e);
            i++;
        }
        this.E.q();
    }

    public final void t(long j) {
        while (!this.n.isEmpty()) {
            a aVar = (a) this.n.removeFirst();
            this.v -= aVar.c;
            long j2 = aVar.a;
            if (aVar.b) {
                j2 += j;
            }
            Z z = this.j;
            if (z != null) {
                j2 = z.a(j2);
            }
            for (w wVar : this.F) {
                wVar.f(j2, 1, aVar.c, this.v, null);
            }
        }
    }

    public g(int i) {
        this(i, null);
    }

    public g(int i, Z z) {
        this(i, z, null, Collections.emptyList());
    }

    public g(int i, Z z, o oVar) {
        this(i, z, oVar, Collections.emptyList());
    }

    public g(int i, Z z, o oVar, List list) {
        this(i, z, oVar, list, null);
    }

    public g(int i, Z z, o oVar, List list, w wVar) {
        this.a = i;
        this.j = z;
        this.b = oVar;
        this.c = Collections.unmodifiableList(list);
        this.o = wVar;
        this.k = new s3.c();
        this.l = new M(16);
        this.e = new M(G.a);
        this.f = new M(5);
        this.g = new M();
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.i = new M(bArr);
        this.m = new ArrayDeque();
        this.n = new ArrayDeque();
        this.d = new SparseArray();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = d3.k.c0;
        this.F = new w[0];
        this.G = new w[0];
    }

    public void release() {
    }

    public o n(o oVar) {
        return oVar;
    }
}
