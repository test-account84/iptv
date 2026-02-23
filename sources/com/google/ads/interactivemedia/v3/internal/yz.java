package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yz implements aab {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public yz(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length <= 0) {
            this.f = 0L;
        } else {
            int i = length - 1;
            this.f = jArr2[i] + jArr3[i];
        }
    }

    public final int a(long j) {
        return cq.aq(this.e, j, true);
    }

    public final long e() {
        return this.f;
    }

    public final zz g(long j) {
        int a = a(j);
        aac aacVar = new aac(this.e[a], this.c[a]);
        if (aacVar.b >= j || a == this.a - 1) {
            return new zz(aacVar, aacVar);
        }
        int i = a + 1;
        return new zz(aacVar, new aac(this.e[i], this.c[i]));
    }

    public final boolean h() {
        return true;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
