package X0;

import android.net.ConnectivityManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class f {
    public static /* bridge */ /* synthetic */ void a(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
