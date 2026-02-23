package n3;

import O2.l1;
import O2.z0;
import Q2.a;
import d4.L;
import d4.M;
import java.util.Collections;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s implements m {
    public final String a;
    public final M b;
    public final L c;
    public d3.w d;
    public String e;
    public z0 f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;
    public long s;
    public int t;
    public String u;

    public s(String str) {
        this.a = str;
        M m = new M(1024);
        this.b = m;
        this.c = new L(m.e());
        this.k = -9223372036854775807L;
    }

    public static long a(L l) {
        return l.h((l.h(2) + 1) * 8);
    }

    public void b(M m) {
        d4.a.i(this.d);
        while (m.a() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int H = m.H();
                    if ((H & 224) == 224) {
                        this.j = H;
                        this.g = 2;
                    } else if (H != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int H2 = ((this.j & (-225)) << 8) | m.H();
                    this.i = H2;
                    if (H2 > this.b.e().length) {
                        m(this.i);
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(m.a(), this.i - this.h);
                    m.l(this.c.a, this.h, min);
                    int i2 = this.h + min;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.c.p(0);
                        g(this.c);
                        this.g = 0;
                    }
                }
            } else if (m.H() == 86) {
                this.g = 1;
            }
        }
    }

    public void c() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.d = kVar.e(dVar.c(), 1);
        this.e = dVar.b();
    }

    public final void g(L l) {
        if (!l.g()) {
            this.l = true;
            l(l);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw l1.a(null, null);
        }
        if (this.n != 0) {
            throw l1.a(null, null);
        }
        k(l, j(l));
        if (this.p) {
            l.r((int) this.q);
        }
    }

    public final int h(L l) {
        int b = l.b();
        a.b e = Q2.a.e(l, true);
        this.u = e.c;
        this.r = e.a;
        this.t = e.b;
        return b - l.b();
    }

    public final void i(L l) {
        int i;
        int h = l.h(3);
        this.o = h;
        if (h == 0) {
            i = 8;
        } else {
            if (h != 1) {
                if (h == 3 || h == 4 || h == 5) {
                    l.r(6);
                    return;
                } else {
                    if (h != 6 && h != 7) {
                        throw new IllegalStateException();
                    }
                    l.r(1);
                    return;
                }
            }
            i = 9;
        }
        l.r(i);
    }

    public final int j(L l) {
        int h;
        if (this.o != 0) {
            throw l1.a(null, null);
        }
        int i = 0;
        do {
            h = l.h(8);
            i += h;
        } while (h == 255);
        return i;
    }

    public final void k(L l, int i) {
        int e = l.e();
        if ((e & 7) == 0) {
            this.b.U(e >> 3);
        } else {
            l.i(this.b.e(), 0, i * 8);
            this.b.U(0);
        }
        this.d.b(this.b, i);
        long j = this.k;
        if (j != -9223372036854775807L) {
            this.d.f(j, 1, i, 0, null);
            this.k += this.s;
        }
    }

    public final void l(L l) {
        boolean g;
        int h = l.h(1);
        int h2 = h == 1 ? l.h(1) : 0;
        this.m = h2;
        if (h2 != 0) {
            throw l1.a(null, null);
        }
        if (h == 1) {
            a(l);
        }
        if (!l.g()) {
            throw l1.a(null, null);
        }
        this.n = l.h(6);
        int h3 = l.h(4);
        int h4 = l.h(3);
        if (h3 != 0 || h4 != 0) {
            throw l1.a(null, null);
        }
        if (h == 0) {
            int e = l.e();
            int h5 = h(l);
            l.p(e);
            byte[] bArr = new byte[(h5 + 7) / 8];
            l.i(bArr, 0, h5);
            z0 G = new z0.b().U(this.e).g0("audio/mp4a-latm").K(this.u).J(this.t).h0(this.r).V(Collections.singletonList(bArr)).X(this.a).G();
            if (!G.equals(this.f)) {
                this.f = G;
                this.s = 1024000000 / G.A;
                this.d.d(G);
            }
        } else {
            l.r(((int) a(l)) - h(l));
        }
        i(l);
        boolean g2 = l.g();
        this.p = g2;
        this.q = 0L;
        if (g2) {
            if (h == 1) {
                this.q = a(l);
            } else {
                do {
                    g = l.g();
                    this.q = (this.q << 8) + l.h(8);
                } while (g);
            }
        }
        if (l.g()) {
            l.r(8);
        }
    }

    public final void m(int i) {
        this.b.Q(i);
        this.c.n(this.b.e());
    }

    public void d() {
    }
}
