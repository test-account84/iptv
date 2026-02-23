package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqt implements zzcp {
    private static final zzqt zza = new zzqt();
    private static final zzod zzb = zzod.zza(zzqs.zza, zznd.class, zzce.class);

    public static void zzc() throws GeneralSecurityException {
        zzct.zza(zza);
        zznr.zza().zza(zzb);
    }

    public final Class zza() {
        return zzce.class;
    }

    public final Class zzb() {
        return zzce.class;
    }

    public final /* synthetic */ Object zza(zzcg zzcgVar) throws GeneralSecurityException {
        Iterator it = zzcgVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzcl zzclVar : (List) it.next()) {
                if (zzclVar.zzb() instanceof zzqr) {
                    zzqr zzqrVar = (zzqr) zzclVar.zzb();
                    zzxt zza2 = zzxt.zza(zzclVar.zzh());
                    if (!zza2.equals(zzqrVar.zzb())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + String.valueOf(zzqrVar.zza()) + " has wrong output prefix (" + String.valueOf(zzqrVar.zzb()) + ") instead of (" + String.valueOf(zza2) + ")");
                    }
                }
            }
        }
        return new zzqv(zzcgVar, null);
    }
}
