package d4;

import android.security.NetworkSecurityPolicy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class f0 {
    public static /* bridge */ /* synthetic */ boolean a(NetworkSecurityPolicy networkSecurityPolicy, String str) {
        return networkSecurityPolicy.isCleartextTrafficPermitted(str);
    }
}
