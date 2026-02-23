package n3;

import O2.z0;
import Q2.a;
import d4.L;
import d4.M;
import d4.k0;
import java.util.Arrays;
import java.util.Collections;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements m {
    public static final byte[] v = {73, 68, 51};
    public final boolean a;
    public final L b;
    public final M c;
    public final String d;
    public String e;
    public d3.w f;
    public d3.w g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;
    public long s;
    public d3.w t;
    public long u;

    public i(boolean z) {
        this(z, null);
    }

    private boolean i(M m, byte[] bArr, int i) {
        int min = Math.min(m.a(), i - this.i);
        m.l(bArr, this.i, min);
        int i2 = this.i + min;
        this.i = i2;
        return i2 == i;
    }

    public static boolean m(int i) {
        return (i & 65526) == 65520;
    }

    public final void a() {
        d4.a.e(this.f);
        k0.j(this.t);
        k0.j(this.g);
    }

    public void b(M m) {
        a();
        while (m.a() > 0) {
            int i = this.h;
            if (i == 0) {
                j(m);
            } else if (i == 1) {
                g(m);
            } else if (i != 2) {
                if (i == 3) {
                    if (i(m, this.b.a, this.k ? 7 : 5)) {
                        n();
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    p(m);
                }
            } else if (i(m, this.c.e(), 10)) {
                o();
            }
        }
    }

    public void c() {
        this.s = -9223372036854775807L;
        q();
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.s = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.e = dVar.b();
        d3.w e = kVar.e(dVar.c(), 1);
        this.f = e;
        this.t = e;
        if (!this.a) {
            this.g = new d3.h();
            return;
        }
        dVar.a();
        d3.w e2 = kVar.e(dVar.c(), 5);
        this.g = e2;
        e2.d(new z0.b().U(dVar.b()).g0("application/id3").G());
    }

    public final void g(M m) {
        if (m.a() == 0) {
            return;
        }
        this.b.a[0] = m.e()[m.f()];
        this.b.p(2);
        int h = this.b.h(4);
        int i = this.n;
        if (i != -1 && h != i) {
            q();
            return;
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = h;
        }
        t();
    }

    public final boolean h(M m, int i) {
        m.U(i + 1);
        if (!w(m, this.b.a, 1)) {
            return false;
        }
        this.b.p(4);
        int h = this.b.h(1);
        int i2 = this.m;
        if (i2 != -1 && h != i2) {
            return false;
        }
        if (this.n != -1) {
            if (!w(m, this.b.a, 1)) {
                return true;
            }
            this.b.p(2);
            if (this.b.h(4) != this.n) {
                return false;
            }
            m.U(i + 2);
        }
        if (!w(m, this.b.a, 4)) {
            return true;
        }
        this.b.p(14);
        int h2 = this.b.h(13);
        if (h2 < 7) {
            return false;
        }
        byte[] e = m.e();
        int g = m.g();
        int i3 = i + h2;
        if (i3 >= g) {
            return true;
        }
        byte b = e[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == g) {
                return true;
            }
            return l((byte) -1, e[i4]) && ((e[i4] & 8) >> 3) == h;
        }
        if (b != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == g) {
            return true;
        }
        if (e[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == g || e[i6] == 51;
    }

    public final void j(M m) {
        int i;
        byte[] e = m.e();
        int f = m.f();
        int g = m.g();
        while (f < g) {
            int i2 = f + 1;
            byte b = e[f];
            int i3 = b & 255;
            if (this.j == 512 && l((byte) -1, (byte) i3) && (this.l || h(m, f - 1))) {
                this.o = (b & 8) >> 3;
                this.k = (b & 1) == 0;
                if (this.l) {
                    t();
                } else {
                    r();
                }
                m.U(i2);
                return;
            }
            int i4 = this.j;
            int i5 = i3 | i4;
            if (i5 != 329) {
                if (i5 == 511) {
                    this.j = 512;
                } else if (i5 == 836) {
                    i = 1024;
                } else if (i5 == 1075) {
                    u();
                    m.U(i2);
                    return;
                } else if (i4 != 256) {
                    this.j = 256;
                }
                f = i2;
            } else {
                i = 768;
            }
            this.j = i;
            f = i2;
        }
        m.U(f);
    }

    public long k() {
        return this.q;
    }

    public final boolean l(byte b, byte b2) {
        return m(((b & 255) << 8) | (b2 & 255));
    }

    public final void n() {
        this.b.p(0);
        if (this.p) {
            this.b.r(10);
        } else {
            int i = 2;
            int h = this.b.h(2) + 1;
            if (h != 2) {
                d4.B.j("AdtsReader", "Detected audio object type: " + h + ", but assuming AAC LC.");
            } else {
                i = h;
            }
            this.b.r(5);
            byte[] b = Q2.a.b(i, this.n, this.b.h(3));
            a.b f = Q2.a.f(b);
            z0 G = new z0.b().U(this.e).g0("audio/mp4a-latm").K(f.c).J(f.b).h0(f.a).V(Collections.singletonList(b)).X(this.d).G();
            this.q = 1024000000 / G.A;
            this.f.d(G);
            this.p = true;
        }
        this.b.r(4);
        int h2 = this.b.h(13);
        int i2 = h2 - 7;
        if (this.k) {
            i2 = h2 - 9;
        }
        v(this.f, this.q, 0, i2);
    }

    public final void o() {
        this.g.b(this.c, 10);
        this.c.U(6);
        v(this.g, 0L, 10, this.c.G() + 10);
    }

    public final void p(M m) {
        int min = Math.min(m.a(), this.r - this.i);
        this.t.b(m, min);
        int i = this.i + min;
        this.i = i;
        int i2 = this.r;
        if (i == i2) {
            long j = this.s;
            if (j != -9223372036854775807L) {
                this.t.f(j, 1, i2, 0, null);
                this.s += this.u;
            }
            s();
        }
    }

    public final void q() {
        this.l = false;
        s();
    }

    public final void r() {
        this.h = 1;
        this.i = 0;
    }

    public final void s() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    public final void t() {
        this.h = 3;
        this.i = 0;
    }

    public final void u() {
        this.h = 2;
        this.i = v.length;
        this.r = 0;
        this.c.U(0);
    }

    public final void v(d3.w wVar, long j, int i, int i2) {
        this.h = 4;
        this.i = i;
        this.t = wVar;
        this.u = j;
        this.r = i2;
    }

    public final boolean w(M m, byte[] bArr, int i) {
        if (m.a() < i) {
            return false;
        }
        m.l(bArr, 0, i);
        return true;
    }

    public i(boolean z, String str) {
        this.b = new L(new byte[7]);
        this.c = new M(Arrays.copyOf(v, 10));
        s();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.a = z;
        this.d = str;
    }

    public void d() {
    }
}
