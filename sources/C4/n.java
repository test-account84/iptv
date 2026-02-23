package c4;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class n {
    public static long a(o oVar) {
        return oVar.a("exo_len", -1L);
    }

    public static Uri b(o oVar) {
        String b = oVar.b("exo_redir", null);
        if (b == null) {
            return null;
        }
        return Uri.parse(b);
    }
}
