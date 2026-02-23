package com.google.android.recaptcha.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjh extends zzjf {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzjg) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzjg) obj).zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzgo zzgoVar = (zzgo) obj;
        zzjg zzjgVar = zzgoVar.zzc;
        if (zzjgVar != zzjg.zzc()) {
            return zzjgVar;
        }
        zzjg zzf = zzjg.zzf();
        zzgoVar.zzc = zzf;
        return zzf;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzgo) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzjg.zzc().equals(obj2)) {
            return obj;
        }
        zzjg zzjgVar = (zzjg) obj2;
        if (zzjg.zzc().equals(obj)) {
            return zzjg.zze((zzjg) obj, zzjgVar);
        }
        ((zzjg) obj).zzd(zzjgVar);
        return obj;
    }

    public final /* synthetic */ Object zzf() {
        return zzjg.zzf();
    }

    public final /* synthetic */ Object zzg(Object obj) {
        ((zzjg) obj).zzh();
        return obj;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i, int i2) {
        ((zzjg) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    public final /* bridge */ /* synthetic */ void zzi(Object obj, int i, long j) {
        ((zzjg) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, int i, Object obj2) {
        ((zzjg) obj).zzj((i << 3) | 3, obj2);
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i, zzez zzezVar) {
        ((zzjg) obj).zzj((i << 3) | 2, zzezVar);
    }

    public final /* bridge */ /* synthetic */ void zzl(Object obj, int i, long j) {
        ((zzjg) obj).zzj(i << 3, Long.valueOf(j));
    }

    public final void zzm(Object obj) {
        ((zzgo) obj).zzc.zzh();
    }

    public final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzgo) obj).zzc = (zzjg) obj2;
    }

    public final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzgo) obj).zzc = (zzjg) obj2;
    }

    public final /* synthetic */ void zzp(Object obj, zzjx zzjxVar) throws IOException {
        ((zzjg) obj).zzk(zzjxVar);
    }

    public final /* synthetic */ void zzq(Object obj, zzjx zzjxVar) throws IOException {
        ((zzjg) obj).zzl(zzjxVar);
    }

    public final boolean zzs(zzik zzikVar) {
        return false;
    }
}
