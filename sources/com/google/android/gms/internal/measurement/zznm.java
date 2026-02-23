package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zznm extends zznk {
    public final /* synthetic */ int zza(Object obj) {
        return ((zznl) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zznl) obj).zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzlb zzlbVar = (zzlb) obj;
        zznl zznlVar = zzlbVar.zzc;
        if (zznlVar != zznl.zzc()) {
            return zznlVar;
        }
        zznl zzf = zznl.zzf();
        zzlbVar.zzc = zzf;
        return zzf;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzlb) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zznl.zzc().equals(obj2)) {
            return obj;
        }
        zznl zznlVar = (zznl) obj2;
        if (zznl.zzc().equals(obj)) {
            return zznl.zze((zznl) obj, zznlVar);
        }
        ((zznl) obj).zzd(zznlVar);
        return obj;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zznl) obj).zzj(i << 3, Long.valueOf(j));
    }

    public final void zzg(Object obj) {
        ((zzlb) obj).zzc.zzh();
    }

    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzlb) obj).zzc = (zznl) obj2;
    }

    public final /* synthetic */ void zzi(Object obj, zzoc zzocVar) throws IOException {
        ((zznl) obj).zzk(zzocVar);
    }
}
