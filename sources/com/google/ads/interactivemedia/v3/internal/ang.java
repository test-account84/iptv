package com.google.ads.interactivemedia.v3.internal;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ang extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ anh a;

    public ang(anh anhVar) {
        this.a = anhVar;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (anh.class) {
            anh.d(this.a, networkCapabilities);
        }
    }

    public final void onLost(Network network) {
        synchronized (anh.class) {
            anh.d(this.a, null);
        }
    }
}
