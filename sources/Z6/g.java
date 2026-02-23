package Z6;

import Y6.v;
import Y6.x;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g {
    public static final String n = "g";
    public k a;
    public j b;
    public h c;
    public Handler d;
    public m e;
    public Handler h;
    public boolean f = false;
    public boolean g = true;
    public i i = new i();
    public Runnable j = new a();
    public Runnable k = new b();
    public Runnable l = new c();
    public Runnable m = new d();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Log.d(g.d(), "Opening camera");
                g.e(g.this).l();
            } catch (Exception e) {
                g.f(g.this, e);
                Log.e(g.d(), "Failed to open camera", e);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                Log.d(g.d(), "Configuring camera");
                g.e(g.this).e();
                if (g.g(g.this) != null) {
                    g.g(g.this).obtainMessage(B6.k.j, g.h(g.this)).sendToTarget();
                }
            } catch (Exception e) {
                g.f(g.this, e);
                Log.e(g.d(), "Failed to configure camera", e);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                Log.d(g.d(), "Starting preview");
                g.e(g.this).s(g.i(g.this));
                g.e(g.this).u();
            } catch (Exception e) {
                g.f(g.this, e);
                Log.e(g.d(), "Failed to start preview", e);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            try {
                Log.d(g.d(), "Closing camera");
                g.e(g.this).v();
                g.e(g.this).d();
            } catch (Exception e) {
                Log.e(g.d(), "Failed to close camera", e);
            }
            g.j(g.this, true);
            g.g(g.this).sendEmptyMessage(B6.k.c);
            g.k(g.this).b();
        }
    }

    public g(Context context) {
        x.a();
        this.a = k.d();
        h hVar = new h(context);
        this.c = hVar;
        hVar.o(this.i);
        this.h = new Handler();
    }

    public static /* synthetic */ void a(g gVar, boolean z) {
        gVar.s(z);
    }

    public static /* synthetic */ void b(g gVar, p pVar) {
        gVar.q(pVar);
    }

    public static /* synthetic */ void c(g gVar, p pVar) {
        gVar.r(pVar);
    }

    public static /* synthetic */ String d() {
        return n;
    }

    public static /* synthetic */ h e(g gVar) {
        return gVar.c;
    }

    public static /* synthetic */ void f(g gVar, Exception exc) {
        gVar.t(exc);
    }

    public static /* synthetic */ Handler g(g gVar) {
        return gVar.d;
    }

    public static /* synthetic */ v h(g gVar) {
        return gVar.o();
    }

    public static /* synthetic */ j i(g gVar) {
        return gVar.b;
    }

    public static /* synthetic */ boolean j(g gVar, boolean z) {
        gVar.g = z;
        return z;
    }

    public static /* synthetic */ k k(g gVar) {
        return gVar.a;
    }

    public void A(boolean z) {
        x.a();
        if (this.f) {
            this.a.c(new e(this, z));
        }
    }

    public void B() {
        x.a();
        C();
        this.a.c(this.l);
    }

    public final void C() {
        if (!this.f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public void l() {
        x.a();
        if (this.f) {
            this.a.c(this.m);
        } else {
            this.g = true;
        }
        this.f = false;
    }

    public void m() {
        x.a();
        C();
        this.a.c(this.k);
    }

    public m n() {
        return this.e;
    }

    public final v o() {
        return this.c.h();
    }

    public boolean p() {
        return this.g;
    }

    public final /* synthetic */ void q(p pVar) {
        this.c.m(pVar);
    }

    public final /* synthetic */ void r(p pVar) {
        if (this.f) {
            this.a.c(new f(this, pVar));
        } else {
            Log.d(n, "Camera is closed, not requesting preview");
        }
    }

    public final /* synthetic */ void s(boolean z) {
        this.c.t(z);
    }

    public final void t(Exception exc) {
        Handler handler = this.d;
        if (handler != null) {
            handler.obtainMessage(B6.k.d, exc).sendToTarget();
        }
    }

    public void u() {
        x.a();
        this.f = true;
        this.g = false;
        this.a.e(this.j);
    }

    public void v(p pVar) {
        this.h.post(new Z6.d(this, pVar));
    }

    public void w(i iVar) {
        if (this.f) {
            return;
        }
        this.i = iVar;
        this.c.o(iVar);
    }

    public void x(m mVar) {
        this.e = mVar;
        this.c.q(mVar);
    }

    public void y(Handler handler) {
        this.d = handler;
    }

    public void z(j jVar) {
        this.b = jVar;
    }
}
