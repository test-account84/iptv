package n4;

import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class G0 {
    public String a = "com.google.android.gms.cast.CATEGORY_CAST";
    public String b;
    public Collection c;

    public /* synthetic */ G0(F0 f0) {
    }

    public static /* synthetic */ G0 a(G0 g0, String str) {
        g0.b = str;
        return g0;
    }

    public static /* synthetic */ G0 b(G0 g0, Collection collection) {
        g0.c = collection;
        return g0;
    }

    public static /* bridge */ /* synthetic */ I0 c(G0 g0) {
        return new I0(g0.a, g0.b, g0.c, false, true, null);
    }
}
