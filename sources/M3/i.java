package m3;

import O2.z0;
import com.google.android.exoplayer2.extractor.g;
import d3.k;
import d3.t;
import d3.w;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class i {
    public w b;
    public k c;
    public g d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public long k;
    public boolean l;
    public boolean m;
    public final e a = new e();
    public b j = new b();

    public static class b {
        public z0 a;
        public g b;
    }

    public static final class c implements g {
        public c() {
        }

        public long a(d3.j jVar) {
            return -1L;
        }

        public com.google.android.exoplayer2.extractor.g b() {
            return new g.b(-9223372036854775807L);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public void c(long j) {
        }
    }

    public final void a() {
        d4.a.i(this.b);
        k0.j(this.c);
    }

    public long b(long j) {
        return (j * 1000000) / this.i;
    }

    public long c(long j) {
        return (this.i * j) / 1000000;
    }

    public void d(k kVar, w wVar) {
        this.c = kVar;
        this.b = wVar;
        l(true);
    }

    public void e(long j) {
        this.g = j;
    }

    public abstract long f(M m);

    public final int g(d3.j jVar, t tVar) {
        a();
        int i = this.h;
        if (i == 0) {
            return j(jVar);
        }
        if (i == 1) {
            jVar.q((int) this.f);
            this.h = 2;
            return 0;
        }
        if (i == 2) {
            k0.j(this.d);
            return k(jVar, tVar);
        }
        if (i == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public final boolean h(d3.j jVar) {
        while (this.a.d(jVar)) {
            this.k = jVar.getPosition() - this.f;
            if (!i(this.a.c(), this.f, this.j)) {
                return true;
            }
            this.f = jVar.getPosition();
        }
        this.h = 3;
        return false;
    }

    public abstract boolean i(M m, long j, b bVar);

    public final int j(d3.j jVar) {
        if (!h(jVar)) {
            return -1;
        }
        z0 z0Var = this.j.a;
        this.i = z0Var.A;
        if (!this.m) {
            this.b.d(z0Var);
            this.m = true;
        }
        g gVar = this.j.b;
        if (gVar != null) {
            this.d = gVar;
        } else if (jVar.getLength() == -1) {
            gVar = new c(null);
            this.d = gVar;
        } else {
            f b2 = this.a.b();
            this.d = new m3.a(this, this.f, jVar.getLength(), b2.h + b2.i, b2.c, (b2.b & 4) != 0);
        }
        this.h = 2;
        this.a.f();
        return 0;
    }

    public final int k(d3.j jVar, t tVar) {
        long a2 = this.d.a(jVar);
        if (a2 >= 0) {
            tVar.a = a2;
            return 1;
        }
        if (a2 < -1) {
            e(-(a2 + 2));
        }
        if (!this.l) {
            this.c.n((com.google.android.exoplayer2.extractor.g) d4.a.i(this.d.b()));
            this.l = true;
        }
        if (this.k <= 0 && !this.a.d(jVar)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        M c2 = this.a.c();
        long f = f(c2);
        if (f >= 0) {
            long j = this.g;
            if (j + f >= this.e) {
                long b2 = b(j);
                this.b.b(c2, c2.g());
                this.b.f(b2, 1, c2.g(), 0, null);
                this.e = -1L;
            }
        }
        this.g += f;
        return 0;
    }

    public void l(boolean z) {
        int i;
        if (z) {
            this.j = new b();
            this.f = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.h = i;
        this.e = -1L;
        this.g = 0L;
    }

    public final void m(long j, long j2) {
        this.a.e();
        if (j == 0) {
            l(!this.l);
        } else if (this.h != 0) {
            this.e = c(j2);
            ((g) k0.j(this.d)).c(this.e);
            this.h = 2;
        }
    }
}
