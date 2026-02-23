package com.google.android.gms.internal.cast;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdb extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzdc zza;

    public zzdb(zzdc zzdcVar) {
        this.zza = zzdcVar;
    }

    public final void onAvailable(Network network) {
    }

    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        zzdc.zzc(this.zza, network, linkProperties);
    }

    public final void onLost(Network network) {
        zzdc.zze(this.zza, network);
    }

    public final void onUnavailable() {
        zzdc.zzd(this.zza);
    }
}
