package t4;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class u {
    public static boolean a(Context context) {
        return E.b.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
    }
}
