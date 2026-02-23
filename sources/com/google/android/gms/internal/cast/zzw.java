package com.google.android.gms.internal.cast;

import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzw extends L.a {
    final /* synthetic */ zzy zza;

    public zzw(zzy zzyVar) {
        this.zza = zzyVar;
    }

    public final void onRouteAdded(L l, L.h hVar) {
        zzy.zzc(this.zza);
    }

    public final void onRouteChanged(L l, L.h hVar) {
        zzy.zzc(this.zza);
    }

    public final void onRouteRemoved(L l, L.h hVar) {
        zzy.zzc(this.zza);
    }

    public final void onRouteSelected(L l, L.h hVar, int i) {
        zzy.zzb(this.zza, hVar);
        this.zza.dismiss();
    }
}
