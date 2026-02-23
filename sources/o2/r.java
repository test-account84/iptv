package O2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r implements d4.D {
    public final d4.U a;
    public final a c;
    public C1 d;
    public d4.D e;
    public boolean f = true;
    public boolean g;

    public interface a {
        void t(s1 s1Var);
    }

    public r(a aVar, d4.e eVar) {
        this.c = aVar;
        this.a = new d4.U(eVar);
    }

    public void a(C1 c1) {
        if (c1 == this.d) {
            this.e = null;
            this.d = null;
            this.f = true;
        }
    }

    public void b(s1 s1Var) {
        d4.D d = this.e;
        if (d != null) {
            d.b(s1Var);
            s1Var = this.e.c();
        }
        this.a.b(s1Var);
    }

    public s1 c() {
        d4.D d = this.e;
        return d != null ? d.c() : this.a.c();
    }

    public void d(C1 c1) {
        d4.D d;
        d4.D x = c1.x();
        if (x == null || x == (d = this.e)) {
            return;
        }
        if (d != null) {
            throw w.k(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.e = x;
        this.d = c1;
        x.b(this.a.c());
    }

    public void e(long j) {
        this.a.a(j);
    }

    public final boolean f(boolean z) {
        C1 c1 = this.d;
        return c1 == null || c1.d() || (!this.d.e() && (z || this.d.h()));
    }

    public void g() {
        this.g = true;
        this.a.d();
    }

    public void h() {
        this.g = false;
        this.a.e();
    }

    public long i(boolean z) {
        j(z);
        return r();
    }

    public final void j(boolean z) {
        if (f(z)) {
            this.f = true;
            if (this.g) {
                this.a.d();
                return;
            }
            return;
        }
        d4.D d = (d4.D) d4.a.e(this.e);
        long r = d.r();
        if (this.f) {
            if (r < this.a.r()) {
                this.a.e();
                return;
            } else {
                this.f = false;
                if (this.g) {
                    this.a.d();
                }
            }
        }
        this.a.a(r);
        s1 c = d.c();
        if (c.equals(this.a.c())) {
            return;
        }
        this.a.b(c);
        this.c.t(c);
    }

    public long r() {
        return this.f ? this.a.r() : ((d4.D) d4.a.e(this.e)).r();
    }
}
