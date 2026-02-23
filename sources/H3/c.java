package h3;

import com.google.android.exoplayer2.extractor.g;
import d3.i;
import d3.j;
import d3.k;
import d3.o;
import d3.t;
import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements i {
    public static final o q = new b();
    public k f;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public a o;
    public f p;
    public final M a = new M(4);
    public final M b = new M(9);
    public final M c = new M(11);
    public final M d = new M();
    public final d e = new d();
    public int g = 1;

    public static /* synthetic */ i[] c() {
        return g();
    }

    private static /* synthetic */ i[] g() {
        return new i[]{new c()};
    }

    public void a(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    public void b(k kVar) {
        this.f = kVar;
    }

    public int d(j jVar, t tVar) {
        d4.a.i(this.f);
        while (true) {
            int i = this.g;
            if (i != 1) {
                if (i == 2) {
                    m(jVar);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    if (k(jVar)) {
                        return 0;
                    }
                } else if (!l(jVar)) {
                    return -1;
                }
            } else if (!j(jVar)) {
                return -1;
            }
        }
    }

    public final void e() {
        if (this.n) {
            return;
        }
        this.f.n(new g.b(-9223372036854775807L));
        this.n = true;
    }

    public final long f() {
        if (this.h) {
            return this.i + this.m;
        }
        if (this.e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.m;
    }

    public boolean h(j jVar) {
        jVar.s(this.a.e(), 0, 3);
        this.a.U(0);
        if (this.a.K() != 4607062) {
            return false;
        }
        jVar.s(this.a.e(), 0, 2);
        this.a.U(0);
        if ((this.a.N() & 250) != 0) {
            return false;
        }
        jVar.s(this.a.e(), 0, 4);
        this.a.U(0);
        int q2 = this.a.q();
        jVar.f();
        jVar.n(q2);
        jVar.s(this.a.e(), 0, 4);
        this.a.U(0);
        return this.a.q() == 0;
    }

    public final M i(j jVar) {
        if (this.l > this.d.b()) {
            M m = this.d;
            m.S(new byte[Math.max(m.b() * 2, this.l)], 0);
        } else {
            this.d.U(0);
        }
        this.d.T(this.l);
        jVar.m(this.d.e(), 0, this.l);
        return this.d;
    }

    public final boolean j(j jVar) {
        if (!jVar.h(this.b.e(), 0, 9, true)) {
            return false;
        }
        this.b.U(0);
        this.b.V(4);
        int H = this.b.H();
        boolean z = (H & 4) != 0;
        boolean z2 = (H & 1) != 0;
        if (z && this.o == null) {
            this.o = new a(this.f.e(8, 1));
        }
        if (z2 && this.p == null) {
            this.p = new f(this.f.e(9, 2));
        }
        this.f.q();
        this.j = this.b.q() - 5;
        this.g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean k(d3.j r10) {
        /*
            r9 = this;
            long r0 = r9.f()
            int r2 = r9.k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            h3.a r3 = r9.o
            if (r3 == 0) goto L23
            r9.e()
            h3.a r2 = r9.o
        L19:
            d4.M r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = 1
            goto L6d
        L23:
            r3 = 9
            if (r2 != r3) goto L31
            h3.f r3 = r9.p
            if (r3 == 0) goto L31
            r9.e()
            h3.f r2 = r9.p
            goto L19
        L31:
            r3 = 18
            if (r2 != r3) goto L66
            boolean r2 = r9.n
            if (r2 != 0) goto L66
            h3.d r2 = r9.e
            d4.M r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
            h3.d r0 = r9.e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            d3.k r2 = r9.f
            com.google.android.exoplayer2.extractor.f r3 = new com.google.android.exoplayer2.extractor.f
            h3.d r7 = r9.e
            long[] r7 = r7.e()
            h3.d r8 = r9.e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.n(r3)
            r9.n = r6
            goto L21
        L66:
            int r0 = r9.l
            r10.q(r0)
            r10 = 0
            r0 = 0
        L6d:
            boolean r1 = r9.h
            if (r1 != 0) goto L87
            if (r10 == 0) goto L87
            r9.h = r6
            h3.d r10 = r9.e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L83
            long r1 = r9.m
            long r1 = -r1
            goto L85
        L83:
            r1 = 0
        L85:
            r9.i = r1
        L87:
            r10 = 4
            r9.j = r10
            r10 = 2
            r9.g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.c.k(d3.j):boolean");
    }

    public final boolean l(j jVar) {
        if (!jVar.h(this.c.e(), 0, 11, true)) {
            return false;
        }
        this.c.U(0);
        this.k = this.c.H();
        this.l = this.c.K();
        this.m = this.c.K();
        this.m = ((this.c.H() << 24) | this.m) * 1000;
        this.c.V(3);
        this.g = 4;
        return true;
    }

    public final void m(j jVar) {
        jVar.q(this.j);
        this.j = 0;
        this.g = 3;
    }

    public void release() {
    }
}
