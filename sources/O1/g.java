package O1;

import Z1.l;
import Z1.m;
import a2.a;
import a2.b;
import a2.c;
import a2.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import b2.a;
import b2.b;
import b2.c;
import b2.d;
import b2.e;
import b2.f;
import b2.g;
import d.D;
import d2.n;
import d2.p;
import j2.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g {
    public static volatile g o = null;
    public static boolean p = true;
    public final Z1.c a;
    public final U1.c b;
    public final V1.b c;
    public final W1.h d;
    public final S1.a e;
    public final o2.f f = new o2.f();
    public final i2.d g;
    public final l2.c h;
    public final d2.e i;
    public final h2.f j;
    public final d2.i k;
    public final h2.f l;
    public final Handler m;
    public final Y1.a n;

    public g(U1.c cVar, W1.h hVar, V1.b bVar, Context context, S1.a aVar) {
        i2.d dVar = new i2.d();
        this.g = dVar;
        this.b = cVar;
        this.c = bVar;
        this.d = hVar;
        this.e = aVar;
        this.a = new Z1.c(context);
        this.m = new Handler(Looper.getMainLooper());
        this.n = new Y1.a(hVar, bVar, aVar);
        l2.c cVar2 = new l2.c();
        this.h = cVar2;
        p pVar = new p(bVar, aVar);
        cVar2.b(InputStream.class, Bitmap.class, pVar);
        d2.g gVar = new d2.g(bVar, aVar);
        cVar2.b(ParcelFileDescriptor.class, Bitmap.class, gVar);
        n nVar = new n(pVar, gVar);
        cVar2.b(Z1.g.class, Bitmap.class, nVar);
        g2.c cVar3 = new g2.c(context, bVar);
        cVar2.b(InputStream.class, g2.b.class, cVar3);
        cVar2.b(Z1.g.class, h2.a.class, new h2.g(nVar, cVar3, bVar));
        cVar2.b(InputStream.class, File.class, new f2.d());
        s(File.class, ParcelFileDescriptor.class, new a.a());
        s(File.class, InputStream.class, new c.a());
        Class cls = Integer.TYPE;
        s(cls, ParcelFileDescriptor.class, new b.a());
        s(cls, InputStream.class, new d.a());
        s(Integer.class, ParcelFileDescriptor.class, new b.a());
        s(Integer.class, InputStream.class, new d.a());
        s(String.class, ParcelFileDescriptor.class, new c.a());
        s(String.class, InputStream.class, new e.a());
        s(Uri.class, ParcelFileDescriptor.class, new d.a());
        s(Uri.class, InputStream.class, new f.a());
        s(URL.class, InputStream.class, new g.a());
        s(Z1.d.class, InputStream.class, new a.a());
        s(byte[].class, InputStream.class, new b.a());
        dVar.b(Bitmap.class, d2.j.class, new i2.b(context.getResources(), bVar));
        dVar.b(h2.a.class, e2.b.class, new i2.a(new i2.b(context.getResources(), bVar)));
        d2.e eVar = new d2.e(bVar);
        this.i = eVar;
        this.j = new h2.f(bVar, eVar);
        d2.i iVar = new d2.i(bVar);
        this.k = iVar;
        this.l = new h2.f(bVar, iVar);
    }

    public static l b(Class cls, Context context) {
        return d(cls, ParcelFileDescriptor.class, context);
    }

    public static l d(Class cls, Class cls2, Context context) {
        if (cls != null) {
            return i(context).q().a(cls, cls2);
        }
        if (!Log.isLoggable("Glide", 3)) {
            return null;
        }
        Log.d("Glide", "Unable to load null model, setting placeholder only");
        return null;
    }

    public static l e(Class cls, Context context) {
        return d(cls, InputStream.class, context);
    }

    public static void g(o2.j jVar) {
        q2.h.a();
        m2.b e = jVar.e();
        if (e != null) {
            e.clear();
            jVar.h(null);
        }
    }

    public static g i(Context context) {
        if (o == null) {
            synchronized (g.class) {
                try {
                    if (o == null) {
                        Context applicationContext = context.getApplicationContext();
                        h hVar = new h(applicationContext);
                        List r = r(applicationContext);
                        Iterator it = r.iterator();
                        if (it.hasNext()) {
                            D.a(it.next());
                            throw null;
                        }
                        o = hVar.a();
                        Iterator it2 = r.iterator();
                        if (it2.hasNext()) {
                            D.a(it2.next());
                            throw null;
                        }
                    }
                } finally {
                }
            }
        }
        return o;
    }

    public static List r(Context context) {
        return p ? new k2.b(context).a() : Collections.emptyList();
    }

    public static j u(Context context) {
        return k.f().d(context);
    }

    public static j v(androidx.fragment.app.e eVar) {
        return k.f().e(eVar);
    }

    public l2.b a(Class cls, Class cls2) {
        return this.h.a(cls, cls2);
    }

    public o2.j c(ImageView imageView, Class cls) {
        return this.f.a(imageView, cls);
    }

    public i2.c f(Class cls, Class cls2) {
        return this.g.a(cls, cls2);
    }

    public void h() {
        q2.h.a();
        this.d.c();
        this.c.c();
    }

    public d2.e j() {
        return this.i;
    }

    public d2.i k() {
        return this.k;
    }

    public V1.b l() {
        return this.c;
    }

    public S1.a m() {
        return this.e;
    }

    public h2.f n() {
        return this.j;
    }

    public h2.f o() {
        return this.l;
    }

    public U1.c p() {
        return this.b;
    }

    public final Z1.c q() {
        return this.a;
    }

    public void s(Class cls, Class cls2, m mVar) {
        m f = this.a.f(cls, cls2, mVar);
        if (f != null) {
            f.a();
        }
    }

    public void t(int i) {
        q2.h.a();
        this.d.b(i);
        this.c.b(i);
    }
}
