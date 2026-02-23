package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements g {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public final long f;

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    public int a(long j) {
        return k0.i(this.e, j, true, true);
    }

    public g.a e(long j) {
        int a = a(j);
        u uVar = new u(this.e[a], this.c[a]);
        if (uVar.a >= j || a == this.a - 1) {
            return new g.a(uVar);
        }
        int i = a + 1;
        return new g.a(uVar, new u(this.e[i], this.c[i]));
    }

    public boolean g() {
        return true;
    }

    public long i() {
        return this.f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
