package n3;

import O2.z0;
import Q2.b0;
import d4.M;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t implements m {
    public final M a;
    public final b0.a b;
    public final String c;
    public d3.w d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public t() {
        this(null);
    }

    public final void a(M m) {
        byte[] e = m.e();
        int g = m.g();
        for (int f = m.f(); f < g; f++) {
            byte b = e[f];
            boolean z = (b & 255) == 255;
            boolean z2 = this.i && (b & 224) == 224;
            this.i = z;
            if (z2) {
                m.U(f + 1);
                this.i = false;
                this.a.e()[1] = e[f];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        m.U(g);
    }

    public void b(M m) {
        d4.a.i(this.d);
        while (m.a() > 0) {
            int i = this.f;
            if (i == 0) {
                a(m);
            } else if (i == 1) {
                h(m);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                g(m);
            }
        }
    }

    public void c() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.d = kVar.e(dVar.c(), 1);
    }

    public final void g(M m) {
        int min = Math.min(m.a(), this.k - this.g);
        this.d.b(m, min);
        int i = this.g + min;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        long j = this.l;
        if (j != -9223372036854775807L) {
            this.d.f(j, 1, i2, 0, null);
            this.l += this.j;
        }
        this.g = 0;
        this.f = 0;
    }

    public final void h(M m) {
        int min = Math.min(m.a(), 4 - this.g);
        m.l(this.a.e(), this.g, min);
        int i = this.g + min;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.a.U(0);
        if (!this.b.a(this.a.q())) {
            this.g = 0;
            this.f = 1;
            return;
        }
        this.k = this.b.c;
        if (!this.h) {
            this.j = (r8.g * 1000000) / r8.d;
            this.d.d(new z0.b().U(this.e).g0(this.b.b).Y(4096).J(this.b.e).h0(this.b.d).X(this.c).G());
            this.h = true;
        }
        this.a.U(0);
        this.d.b(this.a, 4);
        this.f = 2;
    }

    public t(String str) {
        this.f = 0;
        M m = new M(4);
        this.a = m;
        m.e()[0] = -1;
        this.b = new b0.a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    public void d() {
    }
}
