package s6;

import I5.r;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h {

    public interface a {
        String a(Object obj);
    }

    public static /* synthetic */ f a(String str, a aVar, I5.e eVar) {
        return d(str, aVar, eVar);
    }

    public static I5.c b(String str, String str2) {
        return I5.c.l(f.a(str, str2), f.class);
    }

    public static I5.c c(String str, a aVar) {
        return I5.c.m(f.class).b(r.k(Context.class)).f(new g(str, aVar)).d();
    }

    public static /* synthetic */ f d(String str, a aVar, I5.e eVar) {
        return f.a(str, aVar.a((Context) eVar.a(Context.class)));
    }
}
