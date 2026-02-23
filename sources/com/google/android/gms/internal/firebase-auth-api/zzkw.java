package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class zzkw {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;
    static final /* synthetic */ int[] zzc;

    static {
        int[] iArr = new int[zztk.values().length];
        zzc = iArr;
        try {
            iArr[zztk.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzc[zztk.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzc[zztk.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[zzty.values().length];
        zzb = iArr2;
        try {
            iArr2[zzty.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzb[zzty.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzb[zzty.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr3 = new int[zzub.values().length];
        zza = iArr3;
        try {
            iArr3[zzub.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zza[zzub.SHA224.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zza[zzub.SHA256.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            zza[zzub.SHA384.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            zza[zzub.SHA512.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
