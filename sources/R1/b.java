package R1;

import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public int a;
    public int b;
    public byte[] c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int i;
    public int p;
    public int q;
    public int r;
    public int v;
    public int h = 12;
    public int j = 4096;
    public int[] k = new int[5003];
    public int[] l = new int[5003];
    public int m = 5003;
    public int n = 0;
    public boolean o = false;
    public int s = 0;
    public int t = 0;
    public int[] u = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    public byte[] w = new byte[256];

    public b(int i, int i2, byte[] bArr, int i3) {
        this.a = i;
        this.b = i2;
        this.c = bArr;
        this.d = Math.max(2, i3);
    }

    public final int a(int i) {
        return (1 << i) - 1;
    }

    public void b(byte b, OutputStream outputStream) {
        byte[] bArr = this.w;
        int i = this.v;
        int i2 = i + 1;
        this.v = i2;
        bArr[i] = b;
        if (i2 >= 254) {
            g(outputStream);
        }
    }

    public void c(OutputStream outputStream) {
        d(this.m);
        int i = this.q;
        this.n = i + 2;
        this.o = true;
        i(i, outputStream);
    }

    public void d(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = -1;
        }
    }

    public void e(int i, OutputStream outputStream) {
        int i2;
        this.p = i;
        int i3 = 0;
        this.o = false;
        this.g = i;
        this.i = a(i);
        int i4 = 1 << (i - 1);
        this.q = i4;
        this.r = i4 + 1;
        this.n = i4 + 2;
        this.v = 0;
        int h = h();
        for (int i5 = this.m; i5 < 65536; i5 *= 2) {
            i3++;
        }
        int i6 = 8 - i3;
        int i7 = this.m;
        d(i7);
        i(this.q, outputStream);
        while (true) {
            int h2 = h();
            if (h2 == -1) {
                i(h, outputStream);
                i(this.r, outputStream);
                return;
            }
            int i8 = (h2 << this.h) + h;
            int i9 = (h2 << i6) ^ h;
            int i10 = this.k[i9];
            if (i10 == i8) {
                h = this.l[i9];
            } else {
                if (i10 >= 0) {
                    int i11 = i7 - i9;
                    if (i9 == 0) {
                        i11 = 1;
                    }
                    do {
                        i9 -= i11;
                        if (i9 < 0) {
                            i9 += i7;
                        }
                        i2 = this.k[i9];
                        if (i2 == i8) {
                            h = this.l[i9];
                            break;
                        }
                    } while (i2 >= 0);
                }
                i(h, outputStream);
                int i12 = this.n;
                if (i12 < this.j) {
                    int[] iArr = this.l;
                    this.n = i12 + 1;
                    iArr[i9] = i12;
                    this.k[i9] = i8;
                } else {
                    c(outputStream);
                }
                h = h2;
            }
        }
    }

    public void f(OutputStream outputStream) {
        outputStream.write(this.d);
        this.e = this.a * this.b;
        this.f = 0;
        e(this.d + 1, outputStream);
        outputStream.write(0);
    }

    public void g(OutputStream outputStream) {
        int i = this.v;
        if (i > 0) {
            outputStream.write(i);
            outputStream.write(this.w, 0, this.v);
            this.v = 0;
        }
    }

    public final int h() {
        int i = this.e;
        if (i == 0) {
            return -1;
        }
        this.e = i - 1;
        byte[] bArr = this.c;
        int i2 = this.f;
        this.f = i2 + 1;
        return bArr[i2] & 255;
    }

    public void i(int i, OutputStream outputStream) {
        int i2 = this.s;
        int[] iArr = this.u;
        int i3 = this.t;
        int i4 = i2 & iArr[i3];
        this.s = i4;
        if (i3 > 0) {
            this.s = i4 | (i << i3);
        } else {
            this.s = i;
        }
        this.t = i3 + this.g;
        while (this.t >= 8) {
            b((byte) (this.s & 255), outputStream);
            this.s >>= 8;
            this.t -= 8;
        }
        if (this.n > this.i || this.o) {
            if (this.o) {
                int i5 = this.p;
                this.g = i5;
                this.i = a(i5);
                this.o = false;
            } else {
                int i6 = this.g + 1;
                this.g = i6;
                this.i = i6 == this.h ? this.j : a(i6);
            }
        }
        if (i == this.r) {
            while (this.t > 0) {
                b((byte) (this.s & 255), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            g(outputStream);
        }
    }
}
