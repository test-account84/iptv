package H3;

import B3.Y;
import O2.A0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m implements Y {
    public final int a;
    public final q c;
    public int d = -1;

    public m(q qVar, int i) {
        this.c = qVar;
        this.a = i;
    }

    public void a() {
        int i = this.d;
        if (i == -2) {
            throw new s(this.c.u().b(this.a).c(0).m);
        }
        if (i == -1) {
            this.c.V();
        } else if (i != -3) {
            this.c.X(i);
        }
    }

    public void b() {
        d4.a.a(this.d == -1);
        this.d = this.c.y(this.a);
    }

    public final boolean c() {
        int i = this.d;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public void d() {
        if (this.d != -1) {
            this.c.r0(this.a);
            this.d = -1;
        }
    }

    public boolean e() {
        return this.d == -3 || (c() && this.c.R(this.d));
    }

    public int n(long j) {
        if (c()) {
            return this.c.q0(this.d, j);
        }
        return 0;
    }

    public int q(A0 a0, U2.g gVar, int i) {
        if (this.d == -3) {
            gVar.addFlag(4);
            return -4;
        }
        if (c()) {
            return this.c.g0(this.d, a0, gVar, i);
        }
        return -3;
    }
}
