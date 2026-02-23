package n3;

import O2.z0;
import Q2.Z;
import d4.M;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k implements m {
    public final String b;
    public String c;
    public d3.w d;
    public int f;
    public int g;
    public long h;
    public z0 i;
    public int j;
    public final M a = new M(new byte[18]);
    public int e = 0;
    public long k = -9223372036854775807L;

    public k(String str) {
        this.b = str;
    }

    private boolean a(M m, byte[] bArr, int i) {
        int min = Math.min(m.a(), i - this.f);
        m.l(bArr, this.f, min);
        int i2 = this.f + min;
        this.f = i2;
        return i2 == i;
    }

    private void g() {
        byte[] e = this.a.e();
        if (this.i == null) {
            z0 g = Z.g(e, this.c, this.b, null);
            this.i = g;
            this.d.d(g);
        }
        this.j = Z.a(e);
        this.h = (int) ((Z.f(e) * 1000000) / this.i.A);
    }

    private boolean h(M m) {
        while (m.a() > 0) {
            int i = this.g << 8;
            this.g = i;
            int H = i | m.H();
            this.g = H;
            if (Z.d(H)) {
                byte[] e = this.a.e();
                int i2 = this.g;
                e[0] = (byte) ((i2 >> 24) & 255);
                e[1] = (byte) ((i2 >> 16) & 255);
                e[2] = (byte) ((i2 >> 8) & 255);
                e[3] = (byte) (i2 & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    public void b(M m) {
        d4.a.i(this.d);
        while (m.a() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(m.a(), this.j - this.f);
                    this.d.b(m, min);
                    int i2 = this.f + min;
                    this.f = i2;
                    int i3 = this.j;
                    if (i2 == i3) {
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.f(j, 1, i3, 0, null);
                            this.k += this.h;
                        }
                        this.e = 0;
                    }
                } else if (a(m, this.a.e(), 18)) {
                    g();
                    this.a.U(0);
                    this.d.b(this.a, 18);
                    this.e = 2;
                }
            } else if (h(m)) {
                this.e = 1;
            }
        }
    }

    public void c() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.c = dVar.b();
        this.d = kVar.e(dVar.c(), 1);
    }

    public void d() {
    }
}
