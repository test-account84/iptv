package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class zzlu {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzwo.values().length];
        zza = iArr;
        try {
            iArr[zzwo.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzwo.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzwo.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
