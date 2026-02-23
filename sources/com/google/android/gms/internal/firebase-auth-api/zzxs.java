package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzxs {
    private final BigInteger zza;

    private zzxs(BigInteger bigInteger) {
        this.zza = bigInteger;
    }

    public static zzxs zza(BigInteger bigInteger, zzcs zzcsVar) {
        if (zzcsVar != null) {
            return new zzxs(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzcs zzcsVar) {
        if (zzcsVar != null) {
            return this.zza;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
