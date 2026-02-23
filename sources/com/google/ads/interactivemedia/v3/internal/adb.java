package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adb {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final s f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final adc[] k;

    public adb(int i, int i2, long j, long j2, long j3, s sVar, int i3, adc[] adcVarArr, int i4, long[] jArr, long[] jArr2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = sVar;
        this.g = i3;
        this.k = adcVarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public final adc a(int i) {
        adc[] adcVarArr = this.k;
        if (adcVarArr == null) {
            return null;
        }
        return adcVarArr[i];
    }
}
