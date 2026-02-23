package n3;

import O2.z0;
import Q2.c;
import d4.L;
import d4.M;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements m {
    public final L a;
    public final M b;
    public final String c;
    public String d;
    public d3.w e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public z0 k;
    public int l;
    public long m;

    public f() {
        this(null);
    }

    private boolean a(M m, byte[] bArr, int i) {
        int min = Math.min(m.a(), i - this.g);
        m.l(bArr, this.g, min);
        int i2 = this.g + min;
        this.g = i2;
        return i2 == i;
    }

    private void g() {
        this.a.p(0);
        c.b d = Q2.c.d(this.a);
        z0 z0Var = this.k;
        if (z0Var == null || d.c != z0Var.z || d.b != z0Var.A || !"audio/ac4".equals(z0Var.m)) {
            z0 G = new z0.b().U(this.d).g0("audio/ac4").J(d.c).h0(d.b).X(this.c).G();
            this.k = G;
            this.e.d(G);
        }
        this.l = d.d;
        this.j = (d.e * 1000000) / this.k.A;
    }

    private boolean h(M m) {
        int H;
        while (true) {
            if (m.a() <= 0) {
                return false;
            }
            if (this.h) {
                H = m.H();
                this.h = H == 172;
                if (H == 64 || H == 65) {
                    break;
                }
            } else {
                this.h = m.H() == 172;
            }
        }
        this.i = H == 65;
        return true;
    }

    public void b(M m) {
        d4.a.i(this.e);
        while (m.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(m.a(), this.l - this.g);
                        this.e.b(m, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.l;
                        if (i2 == i3) {
                            long j = this.m;
                            if (j != -9223372036854775807L) {
                                this.e.f(j, 1, i3, 0, null);
                                this.m += this.j;
                            }
                            this.f = 0;
                        }
                    }
                } else if (a(m, this.b.e(), 16)) {
                    g();
                    this.b.U(0);
                    this.e.b(this.b, 16);
                    this.f = 2;
                }
            } else if (h(m)) {
                this.f = 1;
                this.b.e()[0] = -84;
                this.b.e()[1] = (byte) (this.i ? 65 : 64);
                this.g = 2;
            }
        }
    }

    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = kVar.e(dVar.c(), 1);
    }

    public f(String str) {
        L l = new L(new byte[16]);
        this.a = l;
        this.b = new M(l.a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
        this.c = str;
    }

    public void d() {
    }
}
