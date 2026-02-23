package okhttp3.internal.platform;

import android.security.NetworkSecurityPolicy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean a(NetworkSecurityPolicy networkSecurityPolicy) {
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }
}
