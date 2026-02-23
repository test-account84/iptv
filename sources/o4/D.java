package O4;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d {
    public static final a.g a;
    public static final a.g b;
    public static final a.a c;
    public static final a.a d;
    public static final Scope e;
    public static final Scope f;
    public static final com.google.android.gms.common.api.a g;
    public static final com.google.android.gms.common.api.a h;

    static {
        a.g gVar = new a.g();
        a = gVar;
        a.g gVar2 = new a.g();
        b = gVar2;
        b bVar = new b();
        c = bVar;
        c cVar = new c();
        d = cVar;
        e = new Scope("profile");
        f = new Scope("email");
        g = new com.google.android.gms.common.api.a("SignIn.API", bVar, gVar);
        h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
