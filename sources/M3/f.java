package m3;

import O2.l1;
import d3.l;
import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    public final M k = new M(255);

    public boolean a(d3.j jVar, boolean z) {
        b();
        this.k.Q(27);
        if (!l.b(jVar, this.k.e(), 0, 27, z) || this.k.J() != 1332176723) {
            return false;
        }
        int H = this.k.H();
        this.a = H;
        if (H != 0) {
            if (z) {
                return false;
            }
            throw l1.e("unsupported bit stream revision");
        }
        this.b = this.k.H();
        this.c = this.k.v();
        this.d = this.k.x();
        this.e = this.k.x();
        this.f = this.k.x();
        int H2 = this.k.H();
        this.g = H2;
        this.h = H2 + 27;
        this.k.Q(H2);
        if (!l.b(jVar, this.k.e(), 0, this.g, z)) {
            return false;
        }
        for (int i = 0; i < this.g; i++) {
            this.j[i] = this.k.H();
            this.i += this.j[i];
        }
        return true;
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean c(d3.j jVar) {
        return d(jVar, -1L);
    }

    public boolean d(d3.j jVar, long j) {
        d4.a.a(jVar.getPosition() == jVar.k());
        this.k.Q(4);
        while (true) {
            if ((j == -1 || jVar.getPosition() + 4 < j) && l.b(jVar, this.k.e(), 0, 4, true)) {
                this.k.U(0);
                if (this.k.J() == 1332176723) {
                    jVar.f();
                    return true;
                }
                jVar.q(1);
            }
        }
        do {
            if (j != -1 && jVar.getPosition() >= j) {
                break;
            }
        } while (jVar.b(1) != -1);
        return false;
    }
}
