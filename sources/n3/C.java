package n3;

import O2.z0;
import Q2.b;
import d4.L;
import d4.M;
import d4.k0;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements m {
    public final L a;
    public final M b;
    public final String c;
    public String d;
    public d3.w e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public z0 j;
    public int k;
    public long l;

    public c() {
        this(null);
    }

    public final boolean a(M m, byte[] bArr, int i) {
        int min = Math.min(m.a(), i - this.g);
        m.l(bArr, this.g, min);
        int i2 = this.g + min;
        this.g = i2;
        return i2 == i;
    }

    public void b(M m) {
        d4.a.i(this.e);
        while (m.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(m.a(), this.k - this.g);
                        this.e.b(m, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            long j = this.l;
                            if (j != -9223372036854775807L) {
                                this.e.f(j, 1, i3, 0, null);
                                this.l += this.i;
                            }
                            this.f = 0;
                        }
                    }
                } else if (a(m, this.b.e(), 128)) {
                    g();
                    this.b.U(0);
                    this.e.b(this.b, 128);
                    this.f = 2;
                }
            } else if (h(m)) {
                this.f = 1;
                this.b.e()[0] = 11;
                this.b.e()[1] = 119;
                this.g = 2;
            }
        }
    }

    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = kVar.e(dVar.c(), 1);
    }

    public final void g() {
        this.a.p(0);
        b.b f = Q2.b.f(this.a);
        z0 z0Var = this.j;
        if (z0Var == null || f.d != z0Var.z || f.c != z0Var.A || !k0.c(f.a, z0Var.m)) {
            z0.b b0 = new z0.b().U(this.d).g0(f.a).J(f.d).h0(f.c).X(this.c).b0(f.g);
            if ("audio/ac3".equals(f.a)) {
                b0.I(f.g);
            }
            z0 G = b0.G();
            this.j = G;
            this.e.d(G);
        }
        this.k = f.e;
        this.i = (f.f * 1000000) / this.j.A;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(d4.M r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6.a()
            r1 = 0
            if (r0 <= 0) goto L26
            boolean r0 = r5.h
            r2 = 11
            r3 = 1
            if (r0 != 0) goto L18
            int r0 = r6.H()
            if (r0 != r2) goto L15
        L14:
            r1 = 1
        L15:
            r5.h = r1
            goto L0
        L18:
            int r0 = r6.H()
            r4 = 119(0x77, float:1.67E-43)
            if (r0 != r4) goto L23
            r5.h = r1
            return r3
        L23:
            if (r0 != r2) goto L15
            goto L14
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.c.h(d4.M):boolean");
    }

    public c(String str) {
        L l = new L(new byte[128]);
        this.a = l;
        this.b = new M(l.a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = str;
    }

    public void d() {
    }
}
