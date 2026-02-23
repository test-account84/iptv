package com.google.android.gms.internal.location;

import J4.j;
import android.location.Location;
import com.google.android.gms.common.api.internal.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzat implements k.b {
    final /* synthetic */ Location zza;

    public zzat(zzau zzauVar, Location location) {
        this.zza = location;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((j) obj).a(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
