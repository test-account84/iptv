package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.VisibleForTesting;
import n4.s;
import o4.A;

@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzj extends A {
    final /* synthetic */ zzk zza;

    public zzj(zzk zzkVar) {
        this.zza = zzkVar;
    }

    public final void onTransferFailed(int i, int i2) {
        zzk.zzf().a("onTransferFailed with type = %d and reason = %d", Integer.valueOf(i), Integer.valueOf(i2));
        zzk.zzl(this.zza);
        zzk zzkVar = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zzf(zzk.zzd(zzkVar), i, i2), 232);
        zzk.zzj(this.zza, false);
    }

    public final void onTransferred(int i, s sVar) {
        zzk.zzf().a("onTransferred with type = %d", Integer.valueOf(i));
        zzk.zzl(this.zza);
        zzk zzkVar = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zzg(zzk.zzd(zzkVar), i), 231);
        zzk.zzj(this.zza, false);
        zzk.zzh(this.zza, null);
    }

    public final void onTransferring(int i) {
        zzk.zzf().a("onTransferring with type = %d", Integer.valueOf(i));
        zzk.zzj(this.zza, true);
        zzk.zzl(this.zza);
        zzk zzkVar = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zzg(zzk.zzd(zzkVar), i), 230);
    }
}
