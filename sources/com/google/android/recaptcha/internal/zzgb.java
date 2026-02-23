package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzgb extends zzga {
    public final int zza(Map.Entry entry) {
        return ((zzgl) entry.getKey()).zza;
    }

    public final zzge zzb(Object obj) {
        return ((zzgk) obj).zzb;
    }

    public final zzge zzc(Object obj) {
        return ((zzgk) obj).zzi();
    }

    public final Object zzd(zzfz zzfzVar, zzhy zzhyVar, int i) {
        return zzfzVar.zza(zzhyVar, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zze(java.lang.Object r2, com.google.android.recaptcha.internal.zzik r3, java.lang.Object r4, com.google.android.recaptcha.internal.zzfz r5, com.google.android.recaptcha.internal.zzge r6, java.lang.Object r7, com.google.android.recaptcha.internal.zzjf r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgb.zze(java.lang.Object, com.google.android.recaptcha.internal.zzik, java.lang.Object, com.google.android.recaptcha.internal.zzfz, com.google.android.recaptcha.internal.zzge, java.lang.Object, com.google.android.recaptcha.internal.zzjf):java.lang.Object");
    }

    public final void zzf(Object obj) {
        ((zzgk) obj).zzb.zzg();
    }

    public final void zzg(zzik zzikVar, Object obj, zzfz zzfzVar, zzge zzgeVar) throws IOException {
        throw null;
    }

    public final void zzh(zzez zzezVar, Object obj, zzfz zzfzVar, zzge zzgeVar) throws IOException {
        throw null;
    }

    public final void zzi(zzjx zzjxVar, Map.Entry entry) throws IOException {
        zzgl zzglVar = (zzgl) entry.getKey();
        zzjv zzjvVar = zzjv.zza;
        switch (zzglVar.zzb.ordinal()) {
            case 0:
                zzjxVar.zzf(zzglVar.zza, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                zzjxVar.zzo(zzglVar.zza, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                zzjxVar.zzt(zzglVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                zzjxVar.zzK(zzglVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzjxVar.zzr(zzglVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                zzjxVar.zzm(zzglVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                zzjxVar.zzk(zzglVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                zzjxVar.zzb(zzglVar.zza, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                zzjxVar.zzG(zzglVar.zza, (String) entry.getValue());
                break;
            case 9:
                zzjxVar.zzq(zzglVar.zza, entry.getValue(), zzih.zza().zzb(entry.getValue().getClass()));
                break;
            case 10:
                zzjxVar.zzv(zzglVar.zza, entry.getValue(), zzih.zza().zzb(entry.getValue().getClass()));
                break;
            case 11:
                zzjxVar.zzd(zzglVar.zza, (zzez) entry.getValue());
                break;
            case 12:
                zzjxVar.zzI(zzglVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzjxVar.zzr(zzglVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                zzjxVar.zzx(zzglVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzjxVar.zzz(zzglVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                zzjxVar.zzB(zzglVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                zzjxVar.zzD(zzglVar.zza, ((Long) entry.getValue()).longValue());
                break;
        }
    }

    public final boolean zzj(zzhy zzhyVar) {
        return zzhyVar instanceof zzgk;
    }
}
