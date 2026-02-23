package i3;

import O2.z0;
import com.google.android.exoplayer2.extractor.g;
import d3.i;
import d3.j;
import d3.k;
import d3.t;
import d4.M;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements i {
    public k b;
    public int c;
    public int d;
    public int e;
    public w3.b g;
    public j h;
    public c i;
    public l3.k j;
    public final M a = new M(6);
    public long f = -1;

    public static w3.b f(String str, long j) {
        b a;
        if (j == -1 || (a = e.a(str)) == null) {
            return null;
        }
        return a.a(j);
    }

    public void a(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            ((l3.k) d4.a.e(this.j)).a(j, j2);
        }
    }

    public void b(k kVar) {
        this.b = kVar;
    }

    public final void c(j jVar) {
        this.a.Q(2);
        jVar.s(this.a.e(), 0, 2);
        jVar.n(this.a.N() - 2);
    }

    public int d(j jVar, t tVar) {
        int i = this.c;
        if (i == 0) {
            j(jVar);
            return 0;
        }
        if (i == 1) {
            l(jVar);
            return 0;
        }
        if (i == 2) {
            k(jVar);
            return 0;
        }
        if (i == 4) {
            long position = jVar.getPosition();
            long j = this.f;
            if (position != j) {
                tVar.a = j;
                return 1;
            }
            m(jVar);
            return 0;
        }
        if (i != 5) {
            if (i == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.i == null || jVar != this.h) {
            this.h = jVar;
            this.i = new c(jVar, this.f);
        }
        int d = ((l3.k) d4.a.e(this.j)).d(this.i, tVar);
        if (d == 1) {
            tVar.a += this.f;
        }
        return d;
    }

    public final void e() {
        g(new a.b[0]);
        ((k) d4.a.e(this.b)).q();
        this.b.n(new g.b(-9223372036854775807L));
        this.c = 6;
    }

    public final void g(a.b... bVarArr) {
        ((k) d4.a.e(this.b)).e(1024, 4).d(new z0.b().M("image/jpeg").Z(new q3.a(bVarArr)).G());
    }

    public boolean h(j jVar) {
        if (i(jVar) != 65496) {
            return false;
        }
        int i = i(jVar);
        this.d = i;
        if (i == 65504) {
            c(jVar);
            this.d = i(jVar);
        }
        if (this.d != 65505) {
            return false;
        }
        jVar.n(2);
        this.a.Q(6);
        jVar.s(this.a.e(), 0, 6);
        return this.a.J() == 1165519206 && this.a.N() == 0;
    }

    public final int i(j jVar) {
        this.a.Q(2);
        jVar.s(this.a.e(), 0, 2);
        return this.a.N();
    }

    public final void j(j jVar) {
        int i;
        this.a.Q(2);
        jVar.m(this.a.e(), 0, 2);
        int N = this.a.N();
        this.d = N;
        if (N == 65498) {
            if (this.f == -1) {
                e();
                return;
            }
            i = 4;
        } else if ((N >= 65488 && N <= 65497) || N == 65281) {
            return;
        } else {
            i = 1;
        }
        this.c = i;
    }

    public final void k(j jVar) {
        String B;
        if (this.d == 65505) {
            M m = new M(this.e);
            jVar.m(m.e(), 0, this.e);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(m.B()) && (B = m.B()) != null) {
                w3.b f = f(B, jVar.getLength());
                this.g = f;
                if (f != null) {
                    this.f = f.e;
                }
            }
        } else {
            jVar.q(this.e);
        }
        this.c = 0;
    }

    public final void l(j jVar) {
        this.a.Q(2);
        jVar.m(this.a.e(), 0, 2);
        this.e = this.a.N() - 2;
        this.c = 2;
    }

    public final void m(j jVar) {
        if (jVar.d(this.a.e(), 0, 1, true)) {
            jVar.f();
            if (this.j == null) {
                this.j = new l3.k();
            }
            c cVar = new c(jVar, this.f);
            this.i = cVar;
            if (this.j.h(cVar)) {
                this.j.b(new d(this.f, (k) d4.a.e(this.b)));
                n();
                return;
            }
        }
        e();
    }

    public final void n() {
        g((a.b) d4.a.e(this.g));
        this.c = 5;
    }

    public void release() {
        l3.k kVar = this.j;
        if (kVar != null) {
            kVar.release();
        }
    }
}
