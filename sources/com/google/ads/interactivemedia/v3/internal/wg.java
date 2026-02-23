package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class wg {
    private final int a;
    private final int[] b;
    private final um[] c;
    private final int[] d;
    private final int[][][] e;
    private final um f;

    public wg(int[] iArr, um[] umVarArr, int[] iArr2, int[][][] iArr3, um umVar) {
        this.b = iArr;
        this.c = umVarArr;
        this.e = iArr3;
        this.d = iArr2;
        this.f = umVar;
        this.a = iArr.length;
    }

    public final int a() {
        return this.a;
    }

    public final int b(int i) {
        return this.b[i];
    }

    public final int c(int i, int i2, int i3) {
        return fz.f(this.e[i][i2][i3]);
    }

    public final um d(int i) {
        return this.c[i];
    }

    public final um e() {
        return this.f;
    }

    public final int f(int i, int i2) {
        int i3 = this.c[i].b(i2).a;
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if (c(i, i2, i6) == 4) {
                iArr[i5] = i6;
                i5++;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, i5);
        int i7 = 16;
        String str = null;
        boolean z = false;
        int i8 = 0;
        while (i4 < copyOf.length) {
            String str2 = this.c[i].b(i2).b(copyOf[i4]).l;
            int i9 = i8 + 1;
            if (i8 != 0) {
                z |= !cq.V(str, str2);
            } else {
                str = str2;
            }
            i7 = Math.min(i7, this.e[i][i2][i4] & 24);
            i4++;
            i8 = i9;
        }
        return z ? Math.min(i7, this.d[i]) : i7;
    }
}
