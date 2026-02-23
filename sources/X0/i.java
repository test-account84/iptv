package X0;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i {
    public static i e;
    public a a;
    public b b;
    public g c;
    public h d;

    public i(Context context, c1.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = new a(applicationContext, aVar);
        this.b = new b(applicationContext, aVar);
        this.c = new g(applicationContext, aVar);
        this.d = new h(applicationContext, aVar);
    }

    public static synchronized i c(Context context, c1.a aVar) {
        i iVar;
        synchronized (i.class) {
            try {
                if (e == null) {
                    e = new i(context, aVar);
                }
                iVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public a a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public g d() {
        return this.c;
    }

    public h e() {
        return this.d;
    }
}
