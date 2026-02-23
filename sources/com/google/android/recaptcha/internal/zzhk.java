package com.google.android.recaptcha.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhk extends zzhm {
    private zzhk() {
        super(null);
    }

    public final List zza(Object obj, long j) {
        zzgv zzgvVar = (zzgv) zzjp.zzf(obj, j);
        if (zzgvVar.zzc()) {
            return zzgvVar;
        }
        int size = zzgvVar.size();
        zzgv zzd = zzgvVar.zzd(size == 0 ? 10 : size + size);
        zzjp.zzs(obj, j, zzd);
        return zzd;
    }

    public final void zzb(Object obj, long j) {
        ((zzgv) zzjp.zzf(obj, j)).zzb();
    }

    public final void zzc(Object obj, Object obj2, long j) {
        zzgv zzgvVar = (zzgv) zzjp.zzf(obj, j);
        zzgv zzgvVar2 = (zzgv) zzjp.zzf(obj2, j);
        int size = zzgvVar.size();
        int size2 = zzgvVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgvVar.zzc()) {
                zzgvVar = zzgvVar.zzd(size2 + size);
            }
            zzgvVar.addAll(zzgvVar2);
        }
        if (size > 0) {
            zzgvVar2 = zzgvVar;
        }
        zzjp.zzs(obj, j, zzgvVar2);
    }

    public /* synthetic */ zzhk(zzhj zzhjVar) {
        super(null);
    }
}
