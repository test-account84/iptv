package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzea extends zzef {
    final /* synthetic */ zzeb zza;

    public zzea(zzeb zzebVar) {
        this.zza = zzebVar;
    }

    public final void zza(long j) {
        zzeb zzebVar = this.zza;
        zzeb.zzc(zzebVar, zzeb.zzb(zzebVar) + 1);
        zzeb zzebVar2 = this.zza;
        if (zzebVar2.zza(zzebVar2.zza) || this.zza.zza.isStarted()) {
            return;
        }
        zzeb zzebVar3 = this.zza;
        if (zzeb.zze(zzebVar3)) {
            return;
        }
        zzebVar3.zza.start();
    }
}
