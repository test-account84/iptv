package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class bec {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[bhq.values().length];
        b = iArr;
        try {
            iArr[bhq.SYMMETRIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[bhq.ASYMMETRIC_PRIVATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[bid.values().length];
        a = iArr2;
        try {
            iArr2[bid.TINK.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[bid.LEGACY.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[bid.RAW.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[bid.CRUNCHY.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
