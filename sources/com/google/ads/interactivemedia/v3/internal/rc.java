package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class rc {
    private int a = 0;
    private int b = -1;
    private int c = 0;
    private int[] d = new int[16];
    private int e;

    public rc() {
        this.e = r0.length - 1;
    }

    public final int a() {
        int i = this.c;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.d;
        int i2 = this.a;
        int i3 = iArr[i2];
        this.a = (i2 + 1) & this.e;
        this.c = i - 1;
        return i3;
    }

    public final void b(int i) {
        int i2 = this.c;
        int[] iArr = this.d;
        int length = iArr.length;
        if (i2 == length) {
            int i3 = length + length;
            if (i3 < 0) {
                throw new IllegalStateException();
            }
            int[] iArr2 = new int[i3];
            int i4 = this.a;
            int i5 = length - i4;
            System.arraycopy(iArr, i4, iArr2, 0, i5);
            System.arraycopy(this.d, 0, iArr2, i5, i4);
            this.a = 0;
            this.b = this.c - 1;
            this.d = iArr2;
            this.e = iArr2.length - 1;
            iArr = iArr2;
        }
        int i6 = (this.b + 1) & this.e;
        this.b = i6;
        iArr[i6] = i;
        this.c++;
    }

    public final void c() {
        this.a = 0;
        this.b = -1;
        this.c = 0;
    }

    public final boolean d() {
        return this.c == 0;
    }
}
