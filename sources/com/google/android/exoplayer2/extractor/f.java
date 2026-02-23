package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements g {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final boolean d;

    public f(long[] jArr, long[] jArr2, long j) {
        d4.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    public g.a e(long j) {
        if (!this.d) {
            return new g.a(u.c);
        }
        int i = k0.i(this.b, j, true, true);
        u uVar = new u(this.b[i], this.a[i]);
        if (uVar.a == j || i == this.b.length - 1) {
            return new g.a(uVar);
        }
        int i2 = i + 1;
        return new g.a(uVar, new u(this.b[i2], this.a[i2]));
    }

    public boolean g() {
        return this.d;
    }

    public long i() {
        return this.c;
    }
}
