package com.google.android.gms.internal.location;

import J4.B;
import android.location.Location;
import com.google.android.gms.common.api.internal.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzau extends B {
    private final k zza;

    public zzau(k kVar) {
        this.zza = kVar;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    public final synchronized void zzd(Location location) {
        this.zza.c(new zzat(this, location));
    }
}
