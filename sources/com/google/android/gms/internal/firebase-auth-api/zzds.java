package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class zzds {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzub.values().length];
        zzb = iArr;
        try {
            iArr[zzub.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzb[zzub.SHA224.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzb[zzub.SHA256.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzb[zzub.SHA384.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzb[zzub.SHA512.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr2 = new int[zzvs.values().length];
        zza = iArr2;
        try {
            iArr2[zzvs.TINK.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            zza[zzvs.CRUNCHY.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zza[zzvs.LEGACY.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zza[zzvs.RAW.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
