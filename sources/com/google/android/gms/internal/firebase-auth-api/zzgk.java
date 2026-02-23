package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzgk extends zzdb {
    private final String zza;

    private zzgk(String str) {
        this.zza = str;
    }

    public static zzgk zza(String str) throws GeneralSecurityException {
        return new zzgk(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgk) {
            return ((zzgk) obj).zza.equals(this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgk.class, this.zza});
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ")";
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zza() {
        return false;
    }
}
