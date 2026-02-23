package n3;

import O2.z0;
import d4.M;
import java.util.Collections;
import java.util.List;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l implements m {
    public final List a;
    public final d3.w[] b;
    public boolean c;
    public int d;
    public int e;
    public long f = -9223372036854775807L;

    public l(List list) {
        this.a = list;
        this.b = new d3.w[list.size()];
    }

    public final boolean a(M m, int i) {
        if (m.a() == 0) {
            return false;
        }
        if (m.H() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    public void b(M m) {
        if (this.c) {
            if (this.d != 2 || a(m, 32)) {
                if (this.d != 1 || a(m, 0)) {
                    int f = m.f();
                    int a = m.a();
                    for (d3.w wVar : this.b) {
                        m.U(f);
                        wVar.b(m, a);
                    }
                    this.e += a;
                }
            }
        }
    }

    public void c() {
        this.c = false;
        this.f = -9223372036854775807L;
    }

    public void d() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (d3.w wVar : this.b) {
                    wVar.f(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    public void e(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }

    public void f(d3.k kVar, I.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            I.a aVar = (I.a) this.a.get(i);
            dVar.a();
            d3.w e = kVar.e(dVar.c(), 3);
            e.d(new z0.b().U(dVar.b()).g0("application/dvbsubs").V(Collections.singletonList(aVar.c)).X(aVar.a).G());
            this.b[i] = e;
        }
    }
}
