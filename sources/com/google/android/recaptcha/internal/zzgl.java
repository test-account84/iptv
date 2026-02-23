package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzgl implements zzgd {
    final int zza;
    final zzjv zzb;

    public zzgl(zzgr zzgrVar, int i, zzjv zzjvVar, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzjvVar;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzgl) obj).zza;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzhx zzb(zzhx zzhxVar, zzhy zzhyVar) {
        ((zzgi) zzhxVar).zzg((zzgo) zzhyVar);
        return zzhxVar;
    }

    public final zzid zzc(zzid zzidVar, zzid zzidVar2) {
        throw new UnsupportedOperationException();
    }

    public final zzjv zzd() {
        return this.zzb;
    }

    public final zzjw zze() {
        return this.zzb.zza();
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg() {
        return false;
    }
}
