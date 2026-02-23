package O1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import j2.c;
import j2.l;
import j2.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j implements j2.h {
    public final Context a;
    public final j2.g b;
    public final l c;
    public final m d;
    public final g e;
    public final d f;

    public class a implements Runnable {
        public final /* synthetic */ j2.g a;

        public a(j2.g gVar) {
            this.a = gVar;
        }

        public void run() {
            this.a.a(j.this);
        }
    }

    public interface b {
    }

    public final class c {
        public final Z1.l a;
        public final Class b;

        public final class a {
            public final Object a;
            public final Class b;
            public final boolean c = true;

            public a(Object obj) {
                this.a = obj;
                this.b = j.a(obj);
            }

            public f a(Class cls) {
                f fVar = (f) j.m(j.this).a(new f(j.c(j.this), j.j(j.this), this.b, c.a(c.this), c.b(c.this), cls, j.k(j.this), j.l(j.this), j.m(j.this)));
                if (this.c) {
                    fVar.o(this.a);
                }
                return fVar;
            }
        }

        public c(Z1.l lVar, Class cls) {
            this.a = lVar;
            this.b = cls;
        }

        public static /* synthetic */ Z1.l a(c cVar) {
            return cVar.a;
        }

        public static /* synthetic */ Class b(c cVar) {
            return cVar.b;
        }

        public a c(Object obj) {
            return new a(obj);
        }
    }

    public class d {
        public d() {
        }

        public O1.e a(O1.e eVar) {
            j.n(j.this);
            return eVar;
        }
    }

    public static class e implements c.a {
        public final m a;

        public e(m mVar) {
            this.a = mVar;
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                this.a.d();
            }
        }
    }

    public j(Context context, j2.g gVar, l lVar) {
        this(context, gVar, lVar, new m(), new j2.d());
    }

    public static /* synthetic */ Class a(Object obj) {
        return p(obj);
    }

    public static /* synthetic */ Context c(j jVar) {
        return jVar.a;
    }

    public static /* synthetic */ g j(j jVar) {
        return jVar.e;
    }

    public static /* synthetic */ m k(j jVar) {
        return jVar.d;
    }

    public static /* synthetic */ j2.g l(j jVar) {
        return jVar.b;
    }

    public static /* synthetic */ d m(j jVar) {
        return jVar.f;
    }

    public static /* synthetic */ b n(j jVar) {
        jVar.getClass();
        return null;
    }

    public static Class p(Object obj) {
        if (obj != null) {
            return obj.getClass();
        }
        return null;
    }

    public O1.d o() {
        return r(String.class);
    }

    public void onDestroy() {
        this.d.a();
    }

    public void onStart() {
        v();
    }

    public void onStop() {
        u();
    }

    public O1.d q(String str) {
        return (O1.d) o().D(str);
    }

    public final O1.d r(Class cls) {
        Z1.l e2 = g.e(cls, this.a);
        Z1.l b2 = g.b(cls, this.a);
        if (cls == null || e2 != null || b2 != null) {
            d dVar = this.f;
            return (O1.d) dVar.a(new O1.d(cls, e2, b2, this.a, this.e, this.d, this.b, dVar));
        }
        throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
    }

    public void s() {
        this.e.h();
    }

    public void t(int i) {
        this.e.t(i);
    }

    public void u() {
        q2.h.a();
        this.d.b();
    }

    public void v() {
        q2.h.a();
        this.d.e();
    }

    public c w(Z1.l lVar, Class cls) {
        return new c(lVar, cls);
    }

    public j(Context context, j2.g gVar, l lVar, m mVar, j2.d dVar) {
        this.a = context.getApplicationContext();
        this.b = gVar;
        this.c = lVar;
        this.d = mVar;
        this.e = g.i(context);
        this.f = new d();
        j2.c a2 = dVar.a(context, new e(mVar));
        if (q2.h.h()) {
            new Handler(Looper.getMainLooper()).post(new a(gVar));
        } else {
            gVar.a(this);
        }
        gVar.a(a2);
    }
}
