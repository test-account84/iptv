package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zx {
    private byte[] a;
    private int b;
    private int c;
    private int d;

    public zx(byte[] bArr, int i, int i2) {
        d(bArr, i, i2);
    }

    private final int j() {
        int i = 0;
        while (!i()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? a(i) : 0);
    }

    private final void k() {
        int i;
        int i2 = this.c;
        boolean z = false;
        if (i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0))) {
            z = true;
        }
        af.w(z);
    }

    private final boolean l(int i) {
        if (i < 2 || i >= this.b) {
            return false;
        }
        byte[] bArr = this.a;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i + (-1)] == 0;
    }

    public final int a(int i) {
        int i2;
        this.d += i;
        int i3 = 0;
        while (true) {
            i2 = this.d;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.d = i4;
            byte[] bArr = this.a;
            int i5 = this.c;
            i3 |= (bArr[i5] & 255) << i4;
            if (true != l(i5 + 1)) {
                r3 = 1;
            }
            this.c = i5 + r3;
        }
        byte[] bArr2 = this.a;
        int i6 = this.c;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.d = 0;
            this.c = i6 + (true != l(i6 + 1) ? 1 : 2);
        }
        k();
        return i7;
    }

    public final int b() {
        int j = j();
        return (j % 2 == 0 ? -1 : 1) * ((j + 1) / 2);
    }

    public final int c() {
        return j();
    }

    public final void d(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i2;
        this.d = 0;
        k();
    }

    public final void e() {
        int i = this.d + 1;
        this.d = i;
        if (i == 8) {
            this.d = 0;
            int i2 = this.c;
            this.c = i2 + (true == l(i2 + 1) ? 2 : 1);
        }
        k();
    }

    public final void f(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.c) {
                k();
                return;
            } else if (l(i2)) {
                this.c++;
                i2 += 2;
            }
        }
    }

    public final boolean g(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.b) {
                break;
            }
            if (l(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public final boolean h() {
        int i = this.c;
        int i2 = this.d;
        int i3 = 0;
        while (this.c < this.b && !i()) {
            i3++;
        }
        int i4 = this.c;
        int i5 = this.b;
        this.c = i;
        this.d = i2;
        return i4 != i5 && g((i3 + i3) + 1);
    }

    public final boolean i() {
        boolean z = (this.a[this.c] & (128 >> this.d)) != 0;
        e();
        return z;
    }
}
