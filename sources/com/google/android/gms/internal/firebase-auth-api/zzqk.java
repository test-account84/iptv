package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqk extends zzoh {
    public zzqk(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzuc zzucVar = (zzuc) zzaknVar;
        zzub zzb = zzucVar.zze().zzb();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzucVar.zzf().zzg(), "HMAC");
        int zza = zzucVar.zze().zza();
        int i = zzqm.zza[zzb.ordinal()];
        if (i == 1) {
            return new zzxm(new zzxk("HMACSHA1", secretKeySpec), zza);
        }
        if (i == 2) {
            return new zzxm(new zzxk("HMACSHA224", secretKeySpec), zza);
        }
        if (i == 3) {
            return new zzxm(new zzxk("HMACSHA256", secretKeySpec), zza);
        }
        if (i == 4) {
            return new zzxm(new zzxk("HMACSHA384", secretKeySpec), zza);
        }
        if (i == 5) {
            return new zzxm(new zzxk("HMACSHA512", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
