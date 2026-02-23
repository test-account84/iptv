package n3;

import O2.z0;
import d4.M;
import d4.Z;
import d4.k0;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v implements B {
    public z0 a;
    public Z b;
    public d3.w c;

    public v(String str) {
        this.a = new z0.b().g0(str).G();
    }

    public void a(Z z, d3.k kVar, I.d dVar) {
        this.b = z;
        dVar.a();
        d3.w e = kVar.e(dVar.c(), 5);
        this.c = e;
        e.d(this.a);
    }

    public void b(M m) {
        c();
        long d = this.b.d();
        long e = this.b.e();
        if (d == -9223372036854775807L || e == -9223372036854775807L) {
            return;
        }
        z0 z0Var = this.a;
        if (e != z0Var.q) {
            z0 G = z0Var.b().k0(e).G();
            this.a = G;
            this.c.d(G);
        }
        int a = m.a();
        this.c.b(m, a);
        this.c.f(d, 1, a, 0, null);
    }

    public final void c() {
        d4.a.i(this.b);
        k0.j(this.c);
    }
}
