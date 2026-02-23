package n3;

import O2.z0;
import d4.M;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r implements m {
    public d3.w b;
    public boolean c;
    public int e;
    public int f;
    public final M a = new M(10);
    public long d = -9223372036854775807L;

    public void b(M m) {
        d4.a.i(this.b);
        if (this.c) {
            int a = m.a();
            int i = this.f;
            if (i < 10) {
                int min = Math.min(a, 10 - i);
                System.arraycopy(m.e(), m.f(), this.a.e(), this.f, min);
                if (this.f + min == 10) {
                    this.a.U(0);
                    if (73 != this.a.H() || 68 != this.a.H() || 51 != this.a.H()) {
                        d4.B.j("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.V(3);
                        this.e = this.a.G() + 10;
                    }
                }
            }
            int min2 = Math.min(a, this.e - this.f);
            this.b.b(m, min2);
            this.f += min2;
        }
    }

    public void c() {
        this.c = false;
        this.d = -9223372036854775807L;
    }

    public void d() {
        int i;
        d4.a.i(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.b.f(j, 1, i, 0, null);
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
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        d3.w e = kVar.e(dVar.c(), 5);
        this.b = e;
        e.d(new z0.b().U(dVar.b()).g0("application/id3").G());
    }
}
