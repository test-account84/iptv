package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznh {
    public static final zzrr zza = new zznj(null);

    public static zzrq zza(zzcg zzcgVar) {
        zzbv zzbvVar;
        zzrt zzrtVar = new zzrt();
        zzrtVar.zza(zzcgVar.zzb());
        Iterator it = zzcgVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzcl zzclVar : (List) it.next()) {
                int i = zznk.zza[zzclVar.zzc().ordinal()];
                if (i == 1) {
                    zzbvVar = zzbv.zza;
                } else if (i == 2) {
                    zzbvVar = zzbv.zzb;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzbvVar = zzbv.zzc;
                }
                int zza2 = zzclVar.zza();
                String zzg = zzclVar.zzg();
                if (zzg.startsWith("type.googleapis.com/google.crypto.")) {
                    zzg = zzg.substring(34);
                }
                zzrtVar.zza(zzbvVar, zza2, zzg, zzclVar.zzd().name());
            }
        }
        if (zzcgVar.zza() != null) {
            zzrtVar.zza(zzcgVar.zza().zza());
        }
        try {
            return zzrtVar.zza();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
