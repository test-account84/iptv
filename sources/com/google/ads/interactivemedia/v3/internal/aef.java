package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aef {
    public byte[] a;
    public int b;
    private final int c;
    private boolean d;
    private boolean e;

    public aef(int i) {
        this.c = i;
        byte[] bArr = new byte[131];
        this.a = bArr;
        bArr[2] = 1;
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.a;
            int length = bArr2.length;
            int i4 = this.b + i3;
            if (length < i4) {
                this.a = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.a, this.b, i3);
            this.b += i3;
        }
    }

    public final void b() {
        this.d = false;
        this.e = false;
    }

    public final void c(int i) {
        af.w(!this.d);
        boolean z = i == this.c;
        this.d = z;
        if (z) {
            this.b = 3;
            this.e = false;
        }
    }

    public final boolean d(int i) {
        if (!this.d) {
            return false;
        }
        this.b -= i;
        this.d = false;
        this.e = true;
        return true;
    }

    public final boolean e() {
        return this.e;
    }
}
