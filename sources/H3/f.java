package h3;

import O2.z0;
import d3.w;
import d4.G;
import d4.M;
import h3.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends e {
    public final M b;
    public final M c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    public f(w wVar) {
        super(wVar);
        this.b = new M(G.a);
        this.c = new M(4);
    }

    public boolean b(M m) {
        int H = m.H();
        int i = (H >> 4) & 15;
        int i2 = H & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        throw new e.a("Video format not supported: " + i2);
    }

    public boolean c(M m, long j) {
        int H = m.H();
        long r = j + (m.r() * 1000);
        if (H == 0 && !this.e) {
            M m2 = new M(new byte[m.a()]);
            m.l(m2.e(), 0, m.a());
            e4.a b = e4.a.b(m2);
            this.d = b.b;
            this.a.d(new z0.b().g0("video/avc").K(b.i).n0(b.c).S(b.d).c0(b.h).V(b.a).G());
            this.e = true;
            return false;
        }
        if (H != 1 || !this.e) {
            return false;
        }
        int i = this.g == 1 ? 1 : 0;
        if (!this.f && i == 0) {
            return false;
        }
        byte[] e = this.c.e();
        e[0] = 0;
        e[1] = 0;
        e[2] = 0;
        int i2 = 4 - this.d;
        int i3 = 0;
        while (m.a() > 0) {
            m.l(this.c.e(), i2, this.d);
            this.c.U(0);
            int L = this.c.L();
            this.b.U(0);
            this.a.b(this.b, 4);
            this.a.b(m, L);
            i3 = i3 + 4 + L;
        }
        this.a.f(r, i, i3, 0, null);
        this.f = true;
        return true;
    }
}
