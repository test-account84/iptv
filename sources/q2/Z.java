package Q2;

import O2.z0;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface z {

    public static final class a {
        public final Handler a;
        public final z b;

        public a(Handler handler, z zVar) {
            this.a = zVar != null ? (Handler) d4.a.e(handler) : null;
            this.b = zVar;
        }

        public static /* synthetic */ void a(a aVar, long j) {
            aVar.y(j);
        }

        public static /* synthetic */ void b(a aVar, Exception exc) {
            aVar.r(exc);
        }

        public static /* synthetic */ void c(a aVar, String str) {
            aVar.u(str);
        }

        public static /* synthetic */ void d(a aVar, z0 z0Var, U2.h hVar) {
            aVar.x(z0Var, hVar);
        }

        public static /* synthetic */ void e(a aVar, U2.e eVar) {
            aVar.w(eVar);
        }

        public static /* synthetic */ void f(a aVar, int i, long j, long j2) {
            aVar.A(i, j, j2);
        }

        public static /* synthetic */ void g(a aVar, boolean z) {
            aVar.z(z);
        }

        public static /* synthetic */ void h(a aVar, Exception exc) {
            aVar.s(exc);
        }

        public static /* synthetic */ void i(a aVar, U2.e eVar) {
            aVar.v(eVar);
        }

        public static /* synthetic */ void j(a aVar, String str, long j, long j2) {
            aVar.t(str, j, j2);
        }

        public final /* synthetic */ void A(int i, long j, long j2) {
            ((z) d4.k0.j(this.b)).x(i, j, j2);
        }

        public void B(long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new s(this, j));
            }
        }

        public void C(boolean z) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new y(this, z));
            }
        }

        public void D(int i, long j, long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new x(this, i, j, j2));
            }
        }

        public void k(Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new r(this, exc));
            }
        }

        public void l(Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new w(this, exc));
            }
        }

        public void m(String str, long j, long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new q(this, str, j, j2));
            }
        }

        public void n(String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new p(this, str));
            }
        }

        public void o(U2.e eVar) {
            eVar.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new u(this, eVar));
            }
        }

        public void p(U2.e eVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new t(this, eVar));
            }
        }

        public void q(z0 z0Var, U2.h hVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new v(this, z0Var, hVar));
            }
        }

        public final /* synthetic */ void r(Exception exc) {
            ((z) d4.k0.j(this.b)).w(exc);
        }

        public final /* synthetic */ void s(Exception exc) {
            ((z) d4.k0.j(this.b)).b(exc);
        }

        public final /* synthetic */ void t(String str, long j, long j2) {
            ((z) d4.k0.j(this.b)).g(str, j, j2);
        }

        public final /* synthetic */ void u(String str) {
            ((z) d4.k0.j(this.b)).f(str);
        }

        public final /* synthetic */ void v(U2.e eVar) {
            eVar.c();
            ((z) d4.k0.j(this.b)).n(eVar);
        }

        public final /* synthetic */ void w(U2.e eVar) {
            ((z) d4.k0.j(this.b)).i(eVar);
        }

        public final /* synthetic */ void x(z0 z0Var, U2.h hVar) {
            ((z) d4.k0.j(this.b)).C(z0Var);
            ((z) d4.k0.j(this.b)).r(z0Var, hVar);
        }

        public final /* synthetic */ void y(long j) {
            ((z) d4.k0.j(this.b)).l(j);
        }

        public final /* synthetic */ void z(boolean z) {
            ((z) d4.k0.j(this.b)).a(z);
        }
    }

    void C(z0 z0Var);

    void a(boolean z);

    void b(Exception exc);

    void f(String str);

    void g(String str, long j, long j2);

    void i(U2.e eVar);

    void l(long j);

    void n(U2.e eVar);

    void r(z0 z0Var, U2.h hVar);

    void w(Exception exc);

    void x(int i, long j, long j2);
}
