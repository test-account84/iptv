package com.google.android.gms.internal.location;

import J4.x;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzar extends x {
    private final k zza;

    public zzar(k kVar) {
        this.zza = kVar;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    public final void zzd(LocationResult locationResult) {
        this.zza.c(new zzap(this, locationResult));
    }

    public final void zze(LocationAvailability locationAvailability) {
        this.zza.c(new zzaq(this, locationAvailability));
    }
}
