package k1;

import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public final Object a;
    public final m1.a b;
    public Response c;

    public b(Object obj) {
        this.a = obj;
        this.b = null;
    }

    public static b a(m1.a aVar) {
        return new b(aVar);
    }

    public static b f(Object obj) {
        return new b(obj);
    }

    public m1.a b() {
        return this.b;
    }

    public Object c() {
        return this.a;
    }

    public boolean d() {
        return this.b == null;
    }

    public void e(Response response) {
        this.c = response;
    }

    public b(m1.a aVar) {
        this.a = null;
        this.b = aVar;
    }
}
