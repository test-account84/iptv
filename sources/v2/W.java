package V2;

import B3.C;
import android.os.Handler;
import d4.k0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface w {

    public static class a {
        public final int a;
        public final C.b b;
        public final CopyOnWriteArrayList c;

        public static final class a {
            public Handler a;
            public w b;

            public a(Handler handler, w wVar) {
                this.a = handler;
                this.b = wVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public static /* synthetic */ void a(a aVar, w wVar) {
            aVar.n(wVar);
        }

        public static /* synthetic */ void b(a aVar, w wVar) {
            aVar.o(wVar);
        }

        public static /* synthetic */ void c(a aVar, w wVar) {
            aVar.p(wVar);
        }

        public static /* synthetic */ void d(a aVar, w wVar, int i) {
            aVar.q(wVar, i);
        }

        public static /* synthetic */ void e(a aVar, w wVar, Exception exc) {
            aVar.r(wVar, exc);
        }

        public static /* synthetic */ void f(a aVar, w wVar) {
            aVar.s(wVar);
        }

        public void g(Handler handler, w wVar) {
            d4.a.e(handler);
            d4.a.e(wVar);
            this.c.add(new a(handler, wVar));
        }

        public void h() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k0.Y0(aVar.a, new v(this, aVar.b));
            }
        }

        public void i() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k0.Y0(aVar.a, new t(this, aVar.b));
            }
        }

        public void j() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k0.Y0(aVar.a, new u(this, aVar.b));
            }
        }

        public void k(int i) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k0.Y0(aVar.a, new s(this, aVar.b, i));
            }
        }

        public void l(Exception exc) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k0.Y0(aVar.a, new q(this, aVar.b, exc));
            }
        }

        public void m() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k0.Y0(aVar.a, new r(this, aVar.b));
            }
        }

        public final /* synthetic */ void n(w wVar) {
            wVar.T(this.a, this.b);
        }

        public final /* synthetic */ void o(w wVar) {
            wVar.G(this.a, this.b);
        }

        public final /* synthetic */ void p(w wVar) {
            wVar.C(this.a, this.b);
        }

        public final /* synthetic */ void q(w wVar, int i) {
            wVar.K(this.a, this.b);
            wVar.N(this.a, this.b, i);
        }

        public final /* synthetic */ void r(w wVar, Exception exc) {
            wVar.Q(this.a, this.b, exc);
        }

        public final /* synthetic */ void s(w wVar) {
            wVar.c0(this.a, this.b);
        }

        public void t(w wVar) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.b == wVar) {
                    this.c.remove(aVar);
                }
            }
        }

        public a u(int i, C.b bVar) {
            return new a(this.c, i, bVar);
        }

        public a(CopyOnWriteArrayList copyOnWriteArrayList, int i, C.b bVar) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.b = bVar;
        }
    }

    void C(int i, C.b bVar);

    void G(int i, C.b bVar);

    void K(int i, C.b bVar);

    void N(int i, C.b bVar, int i2);

    void Q(int i, C.b bVar, Exception exc);

    void T(int i, C.b bVar);

    void c0(int i, C.b bVar);
}
