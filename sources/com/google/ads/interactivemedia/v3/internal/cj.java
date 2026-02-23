package com.google.ads.interactivemedia.v3.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cj {
    private byte[] a;
    private int b;
    private int c;

    public cj() {
        this.a = cq.f;
    }

    public final void A(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final void B(int i) {
        D(b() < i ? new byte[i] : this.a, i);
    }

    public final void C(byte[] bArr) {
        D(bArr, bArr.length);
    }

    public final void D(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final void E(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.a.length) {
            z = true;
        }
        af.u(z);
        this.c = i;
    }

    public final void F(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.c) {
            z = true;
        }
        af.u(z);
        this.b = i;
    }

    public final void G(int i) {
        F(this.b + i);
    }

    public final byte[] H() {
        return this.a;
    }

    public final int a() {
        return this.c - this.b;
    }

    public final int b() {
        return this.a.length;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        this.b = i + 4;
        return (bArr[i + 3] & 255) | ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
    }

    public final int f() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        this.b = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
    }

    public final int g() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        this.b = i + 2;
        return ((bArr[i + 1] & 255) << 8) | (b & 255);
    }

    public final int h() {
        return (i() << 21) | (i() << 14) | (i() << 7) | i();
    }

    public final int i() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final int j() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        this.b = i + 4;
        return (b2 & 255) | ((b & 255) << 8);
    }

    public final int k() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        this.b = i + 3;
        return (bArr[i + 2] & 255) | ((b & 255) << 16) | ((b2 & 255) << 8);
    }

    public final int l() {
        int e = e();
        if (e >= 0) {
            return e;
        }
        throw new IllegalStateException("Top bit not zero: " + e);
    }

    public final int m() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        this.b = i + 2;
        return (bArr[i + 1] & 255) | ((b & 255) << 8);
    }

    public final long n() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        int i2 = i + 3;
        byte b3 = bArr[i + 2];
        this.b = i + 4;
        return ((b2 & 255) << 8) | (b & 255) | ((b3 & 255) << 16) | ((bArr[i2] & 255) << 24);
    }

    public final long o() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = bArr[i + 4];
        byte b6 = bArr[i + 5];
        int i2 = i + 7;
        byte b7 = bArr[i + 6];
        this.b = i + 8;
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (bArr[i2] & 255);
    }

    public final long p() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        int i2 = i + 3;
        byte b3 = bArr[i + 2];
        this.b = i + 4;
        return ((b2 & 255) << 16) | ((b & 255) << 24) | ((b3 & 255) << 8) | (bArr[i2] & 255);
    }

    public final long q() {
        long o = o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public final String r() {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && !cq.Z(this.a[i])) {
            i++;
        }
        int i2 = this.b;
        if (i - i2 >= 3) {
            byte[] bArr = this.a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                i2 += 3;
                this.b = i2;
            }
        }
        String J = cq.J(this.a, i2, i - i2);
        this.b = i;
        int i3 = this.c;
        if (i == i3) {
            return J;
        }
        byte[] bArr2 = this.a;
        if (bArr2[i] == 13) {
            i++;
            this.b = i;
            if (i == i3) {
                return J;
            }
        }
        if (bArr2[i] == 10) {
            this.b = i + 1;
        }
        return J;
    }

    public final String s() {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != 0) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        String J = cq.J(bArr, i2, i - i2);
        this.b = i;
        if (i >= this.c) {
            return J;
        }
        this.b = i + 1;
        return J;
    }

    public final String t(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String J = cq.J(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return J;
    }

    public final String u(int i) {
        return v(i, ath.b);
    }

    public final String v(int i, Charset charset) {
        byte[] bArr = this.a;
        int i2 = this.b;
        String str = new String(bArr, i2, i, charset);
        this.b = i2 + i;
        return str;
    }

    public final short w() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        this.b = i + 2;
        return (short) (((bArr[i + 1] & 255) << 8) | (b & 255));
    }

    public final short x() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b = bArr[i];
        this.b = i + 2;
        return (short) ((bArr[i + 1] & 255) | ((b & 255) << 8));
    }

    public final void y(int i) {
        if (i > b()) {
            this.a = Arrays.copyOf(this.a, i);
        }
    }

    public final void z(ci ciVar, int i) {
        A(ciVar.a, 0, i);
        ciVar.g(0);
    }

    public cj(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public cj(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public cj(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }
}
