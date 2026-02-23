package n3;

import O2.z0;
import android.util.SparseArray;
import d4.G;
import d4.M;
import d4.N;
import d4.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p implements m {
    public final D a;
    public final boolean b;
    public final boolean c;
    public long g;
    public String i;
    public d3.w j;
    public b k;
    public boolean l;
    public boolean n;
    public final boolean[] h = new boolean[3];
    public final u d = new u(7, 128);
    public final u e = new u(8, 128);
    public final u f = new u(6, 128);
    public long m = -9223372036854775807L;
    public final M o = new M();

    public static final class b {
        public final d3.w a;
        public final boolean b;
        public final boolean c;
        public final N f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public boolean o;
        public long p;
        public long q;
        public boolean r;
        public final SparseArray d = new SparseArray();
        public final SparseArray e = new SparseArray();
        public a m = new a(null);
        public a n = new a(null);

        public static final class a {
            public boolean a;
            public boolean b;
            public G.c c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a() {
            }

            public static /* synthetic */ boolean a(a aVar, a aVar2) {
                return aVar.c(aVar2);
            }

            public void b() {
                this.b = false;
                this.a = false;
            }

            public final boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.a) {
                    return false;
                }
                if (!aVar.a) {
                    return true;
                }
                G.c cVar = (G.c) d4.a.i(this.c);
                G.c cVar2 = (G.c) d4.a.i(aVar.c);
                return (this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && (!this.i || !aVar.i || this.j == aVar.j) && (((i = this.d) == (i2 = aVar.d) || (i != 0 && i2 != 0)) && (((i3 = cVar.l) != 0 || cVar2.l != 0 || (this.m == aVar.m && this.n == aVar.n)) && ((i3 != 1 || cVar2.l != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.k) == aVar.k && (!z || this.l == aVar.l))))) ? false : true;
            }

            public boolean d() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }

            public void e(G.c cVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = cVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.a = true;
                this.b = true;
            }

            public void f(int i) {
                this.e = i;
                this.b = true;
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public b(d3.w wVar, boolean z, boolean z2) {
            this.a = wVar;
            this.b = z;
            this.c = z2;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new N(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 410
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: n3.p.b.a(byte[], int, int):void");
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.i == 9 || (this.c && a.a(this.n, this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.b) {
                z2 = this.n.d();
            }
            boolean z4 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.r = z5;
            return z5;
        }

        public boolean c() {
            return this.c;
        }

        public final void d(int i) {
            long j = this.q;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.r;
            this.a.f(j, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        public void e(G.b bVar) {
            this.e.append(bVar.a, bVar);
        }

        public void f(G.c cVar) {
            this.d.append(cVar.d, cVar);
        }

        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.h = 0;
            this.k = true;
        }
    }

    public p(D d, boolean z, boolean z2) {
        this.a = d;
        this.b = z;
        this.c = z2;
    }

    private void a() {
        d4.a.i(this.j);
        k0.j(this.k);
    }

    public void b(M m) {
        a();
        int f = m.f();
        int g = m.g();
        byte[] e = m.e();
        this.g += m.a();
        this.j.b(m, m.a());
        while (true) {
            int c = d4.G.c(e, f, g, this.h);
            if (c == g) {
                h(e, f, g);
                return;
            }
            int f2 = d4.G.f(e, c);
            int i = c - f;
            if (i > 0) {
                h(e, f, c);
            }
            int i2 = g - c;
            long j = this.g - i2;
            g(j, i2, i < 0 ? -i : 0, this.m);
            i(j, f2, this.m);
            f = c + 3;
        }
    }

    public void c() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        d4.G.a(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.i = dVar.b();
        d3.w e = kVar.e(dVar.c(), 2);
        this.j = e;
        this.k = new b(e, this.b, this.c);
        this.a.b(kVar, dVar);
    }

    public final void g(long j, int i, int i2, long j2) {
        u uVar;
        if (!this.l || this.k.c()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.c()) {
                    u uVar2 = this.d;
                    this.k.f(d4.G.l(uVar2.d, 3, uVar2.e));
                    uVar = this.d;
                } else if (this.e.c()) {
                    u uVar3 = this.e;
                    this.k.e(d4.G.j(uVar3.d, 3, uVar3.e));
                    uVar = this.e;
                }
            } else if (this.d.c() && this.e.c()) {
                List arrayList = new ArrayList();
                u uVar4 = this.d;
                arrayList.add(Arrays.copyOf(uVar4.d, uVar4.e));
                u uVar5 = this.e;
                arrayList.add(Arrays.copyOf(uVar5.d, uVar5.e));
                u uVar6 = this.d;
                G.c l = d4.G.l(uVar6.d, 3, uVar6.e);
                u uVar7 = this.e;
                G.b j3 = d4.G.j(uVar7.d, 3, uVar7.e);
                this.j.d(new z0.b().U(this.i).g0("video/avc").K(d4.f.a(l.a, l.b, l.c)).n0(l.f).S(l.g).c0(l.h).V(arrayList).G());
                this.l = true;
                this.k.f(l);
                this.k.e(j3);
                this.d.d();
                uVar = this.e;
            }
            uVar.d();
        }
        if (this.f.b(i2)) {
            u uVar8 = this.f;
            this.o.S(this.f.d, d4.G.q(uVar8.d, uVar8.e));
            this.o.U(4);
            this.a.a(j2, this.o);
        }
        if (this.k.b(j, i, this.l, this.n)) {
            this.n = false;
        }
    }

    public final void h(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.c()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    public final void i(long j, int i, long j2) {
        if (!this.l || this.k.c()) {
            this.d.e(i);
            this.e.e(i);
        }
        this.f.e(i);
        this.k.h(j, i, j2);
    }

    public void d() {
    }
}
