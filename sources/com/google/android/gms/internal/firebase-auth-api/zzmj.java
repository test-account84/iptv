package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzmj {
    static final zzmj zza;
    BigInteger zzb;
    BigInteger zzc;
    BigInteger zzd;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        zza = new zzmj(bigInteger, bigInteger, BigInteger.ZERO);
    }

    public zzmj(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zzb = bigInteger;
        this.zzc = bigInteger2;
        this.zzd = bigInteger3;
    }

    public final boolean zza() {
        return this.zzd.equals(BigInteger.ZERO);
    }
}
