package q1;

import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements Runnable {
    public final k1.e a;
    public final int c;
    public final k1.a d;

    public class a implements Runnable {
        public final /* synthetic */ k1.a a;
        public final /* synthetic */ m1.a c;

        public a(k1.a aVar, m1.a aVar2) {
            this.a = aVar;
            this.c = aVar2;
        }

        public void run() {
            this.a.g(this.c);
            this.a.m();
        }
    }

    public d(k1.a aVar) {
        this.d = aVar;
        this.c = aVar.C();
        this.a = aVar.y();
    }

    public final void a(k1.a aVar, m1.a aVar2) {
        l1.b.b().a().a().execute(new a(aVar, aVar2));
    }

    public final void b() {
        try {
            Response d = c.d(this.d);
            if (d == null) {
                a(this.d, s1.c.d(new m1.a()));
            } else if (d.code() >= 400) {
                a(this.d, s1.c.f(new m1.a(d), this.d, d.code()));
            } else {
                this.d.N();
            }
        } catch (Exception e) {
            a(this.d, s1.c.d(new m1.a((Throwable) e)));
        }
    }

    public final void c() {
        k1.a aVar;
        m1.a f;
        Response response = null;
        try {
            try {
                response = c.e(this.d);
            } catch (Exception e) {
                a(this.d, s1.c.d(new m1.a((Throwable) e)));
            }
            if (response != null) {
                if (this.d.B() == k1.f.OK_HTTP_RESPONSE) {
                    this.d.i(response);
                } else if (response.code() >= 400) {
                    aVar = this.d;
                    f = s1.c.f(new m1.a(response), this.d, response.code());
                } else {
                    k1.b H = this.d.H(response);
                    if (H.d()) {
                        H.e(response);
                        this.d.j(H);
                        return;
                    }
                    a(this.d, H.b());
                }
            }
            aVar = this.d;
            f = s1.c.d(new m1.a());
            a(aVar, f);
        } finally {
            s1.b.a(null, this.d);
        }
    }

    public final void d() {
        k1.a aVar;
        m1.a f;
        Response response = null;
        try {
            try {
                response = c.f(this.d);
            } catch (Exception e) {
                a(this.d, s1.c.d(new m1.a((Throwable) e)));
            }
            if (response != null) {
                if (this.d.B() == k1.f.OK_HTTP_RESPONSE) {
                    this.d.i(response);
                } else if (response.code() >= 400) {
                    aVar = this.d;
                    f = s1.c.f(new m1.a(response), this.d, response.code());
                } else {
                    k1.b H = this.d.H(response);
                    if (H.d()) {
                        H.e(response);
                        this.d.j(H);
                        return;
                    }
                    a(this.d, H.b());
                }
            }
            aVar = this.d;
            f = s1.c.d(new m1.a());
            a(aVar, f);
        } finally {
            s1.b.a(null, this.d);
        }
    }

    public k1.e e() {
        return this.a;
    }

    public void run() {
        this.d.K(true);
        int A = this.d.A();
        if (A == 0) {
            c();
        } else if (A == 1) {
            b();
        } else if (A == 2) {
            d();
        }
        this.d.K(false);
    }
}
