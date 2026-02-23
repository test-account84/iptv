package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kw {
    public final int[] a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    private kw(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
        this.b = i;
        this.a = iArr;
        this.c = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.d = i6;
    }

    public static kw a(int[] iArr, int i) {
        return new kw(3, 1, iArr, i, -1, -1, -1);
    }

    public static kw b(int[] iArr, int i) {
        return new kw(5, 1, iArr, i, -1, -1, -1);
    }

    public static kw c(int i) {
        return new kw(5, 2, new int[0], -1, -1, -1, i);
    }

    public static kw d(int i, int[] iArr, int i2, int i3, int i4) {
        return new kw(i, 0, iArr, i2, i3, i4, -1);
    }
}
