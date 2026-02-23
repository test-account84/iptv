package com.google.android.gms.internal.cast;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Map;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzm {
    private static final b zza = new b("ApplicationAnalyticsUtils");
    private static final String zzb = "21.3.0";
    private final String zzc;
    private final Map zzd;
    private final Map zze;

    public zzm(Bundle bundle, String str) {
        this.zzc = str;
        this.zzd = zzag.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR");
        this.zze = zzag.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON");
    }

    private final zzmp zzh(zzl zzlVar) {
        long j;
        zzmp zzc = zzmq.zzc();
        zzc.zzl(zzlVar.zzd);
        int i = zzlVar.zze;
        zzlVar.zze = i + 1;
        zzc.zzi(i);
        String str = zzlVar.zzc;
        if (str != null) {
            zzc.zzj(str);
        }
        String str2 = zzlVar.zzh;
        if (str2 != null) {
            zzc.zzh(str2);
        }
        zzmf zza2 = zzmg.zza();
        zza2.zzb(zzb);
        zza2.zza(this.zzc);
        zzc.zzb((zzmg) zza2.zzp());
        zzmh zza3 = zzmi.zza();
        if (zzlVar.zzb != null) {
            zznb zza4 = zznc.zza();
            zza4.zza(zzlVar.zzb);
            zza3.zza((zznc) zza4.zzp());
        }
        zza3.zzf(false);
        String str3 = zzlVar.zzf;
        if (str3 != null) {
            try {
                String replace = str3.replace("-", "");
                j = new BigInteger(replace.substring(0, Math.min(16, replace.length())), 16).longValue();
            } catch (NumberFormatException e) {
                zza.g(e, "receiverSessionId %s is not valid for hash", str3);
                j = 0;
            }
            zza3.zzh(j);
        }
        zza3.zzb(zzlVar.zzg);
        zza3.zzd(zzlVar.zzi);
        zza3.zze(zzlVar.zzj);
        zzc.zzd(zza3);
        return zzc;
    }

    private static void zzi(zzmp zzmpVar, boolean z) {
        zzmh zzc = zzmi.zzc(zzmpVar.zza());
        zzc.zzf(z);
        zzmpVar.zzd(zzc);
    }

    public final zzmq zza(zzl zzlVar) {
        return (zzmq) zzh(zzlVar).zzp();
    }

    public final zzmq zzb(zzl zzlVar, boolean z) {
        zzmp zzh = zzh(zzlVar);
        zzi(zzh, z);
        return (zzmq) zzh.zzp();
    }

    public final zzmq zzc(zzl zzlVar) {
        zzmp zzh = zzh(zzlVar);
        zzmh zzc = zzmi.zzc(zzh.zza());
        zzc.zzg(10);
        zzh.zze((zzmi) zzc.zzp());
        zzi(zzh, true);
        return (zzmq) zzh.zzp();
    }

    public final zzmq zzd(zzl zzlVar) {
        zzmp zzh = zzh(zzlVar);
        if (zzlVar.zzk == 1) {
            zzmh zzc = zzmi.zzc(zzh.zza());
            zzc.zzg(17);
            zzh.zze((zzmi) zzc.zzp());
        }
        return (zzmq) zzh.zzp();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @org.checkerframework.dataflow.qual.Pure
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.cast.zzmq zze(com.google.android.gms.internal.cast.zzl r4, int r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.cast.zzmp r4 = r3.zzh(r4)
            com.google.android.gms.internal.cast.zzmi r0 = r4.zza()
            com.google.android.gms.internal.cast.zzmh r0 = com.google.android.gms.internal.cast.zzmi.zzc(r0)
            java.util.Map r1 = r3.zze
            if (r1 == 0) goto L2e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L1b
            goto L2e
        L1b:
            java.util.Map r1 = r3.zze
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r1 = com.google.android.gms.common.internal.r.m(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L30
        L2e:
            int r1 = r5 + 10000
        L30:
            r0.zzg(r1)
            java.util.Map r1 = r3.zzd
            if (r1 == 0) goto L55
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L42
            goto L55
        L42:
            java.util.Map r5 = r3.zzd
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r5 = com.google.android.gms.common.internal.r.m(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L57
        L55:
            int r5 = r5 + 10000
        L57:
            r0.zzc(r5)
            com.google.android.gms.internal.cast.zzsh r5 = r0.zzp()
            com.google.android.gms.internal.cast.zzmi r5 = (com.google.android.gms.internal.cast.zzmi) r5
            r4.zze(r5)
            com.google.android.gms.internal.cast.zzsh r4 = r4.zzp()
            com.google.android.gms.internal.cast.zzmq r4 = (com.google.android.gms.internal.cast.zzmq) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzm.zze(com.google.android.gms.internal.cast.zzl, int):com.google.android.gms.internal.cast.zzmq");
    }

    public final zzmq zzf(zzl zzlVar, int i, int i2) {
        zzmp zzh = zzh(zzlVar);
        zzmh zzc = zzmi.zzc(zzh.zza());
        zzc.zzj(i);
        zzc.zzi(i2);
        zzh.zze((zzmi) zzc.zzp());
        return (zzmq) zzh.zzp();
    }

    public final zzmq zzg(zzl zzlVar, int i) {
        zzmp zzh = zzh(zzlVar);
        zzmh zzc = zzmi.zzc(zzh.zza());
        zzc.zzj(i);
        zzh.zze((zzmi) zzc.zzp());
        return (zzmq) zzh.zzp();
    }
}
