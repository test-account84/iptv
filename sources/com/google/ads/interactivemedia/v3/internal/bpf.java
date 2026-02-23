package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bpf extends bpg {
    private final InputStream f;
    private final byte[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m = Integer.MAX_VALUE;

    public /* synthetic */ bpf(InputStream inputStream) {
        bqu.j(inputStream, "input");
        this.f = inputStream;
        this.g = new byte[4096];
        this.h = 0;
        this.j = 0;
        this.l = 0;
    }

    private static int I(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (bqw e) {
            e.j();
            throw e;
        }
    }

    private final List J(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.f.read(bArr, i2, min - i2);
                if (read == -1) {
                    throw bqw.i();
                }
                this.l += read;
                i2 += read;
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void K() {
        int i = this.h + this.i;
        this.h = i;
        int i2 = this.l + i;
        int i3 = this.m;
        if (i2 <= i3) {
            this.i = 0;
            return;
        }
        int i4 = i2 - i3;
        this.i = i4;
        this.h = i - i4;
    }

    private final void L(int i) throws IOException {
        if (M(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.l) - this.j) {
            throw bqw.i();
        }
        throw bqw.h();
    }

    private final boolean M(int i) throws IOException {
        int i2 = this.j;
        int i3 = this.h;
        if (i2 + i <= i3) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        int i4 = this.l;
        if (i > (Integer.MAX_VALUE - i4) - i2 || i4 + i2 + i > this.m) {
            return false;
        }
        if (i2 > 0) {
            if (i3 > i2) {
                byte[] bArr = this.g;
                System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
            }
            i4 = this.l + i2;
            this.l = i4;
            i3 = this.h - i2;
            this.h = i3;
            this.j = 0;
        }
        int I = I(this.f, this.g, i3, Math.min(4096 - i3, (Integer.MAX_VALUE - i4) - i3));
        if (I == 0 || I < -1 || I > 4096) {
            throw new IllegalStateException(String.valueOf(this.f.getClass()) + "#read(byte[]) returned invalid result: " + I + "\nThe InputStream implementation is buggy.");
        }
        if (I <= 0) {
            return false;
        }
        this.h += I;
        K();
        if (this.h >= i) {
            return true;
        }
        return M(i);
    }

    private final byte[] N(int i) throws IOException {
        if (i == 0) {
            return bqu.b;
        }
        if (i < 0) {
            throw bqw.f();
        }
        int i2 = this.l;
        int i3 = this.j;
        int i4 = i2 + i3 + i;
        if ((-2147483647) + i4 > 0) {
            throw bqw.h();
        }
        int i5 = this.m;
        if (i4 > i5) {
            B((i5 - i2) - i3);
            throw bqw.i();
        }
        int i6 = this.h - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.f.available()) {
                    return null;
                }
            } catch (bqw e) {
                e.j();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.g, this.j, bArr, 0, i6);
        this.l += this.h;
        this.j = 0;
        this.h = 0;
        while (i6 < i) {
            int I = I(this.f, bArr, i6, i - i6);
            if (I == -1) {
                throw bqw.i();
            }
            this.l += I;
            i6 += I;
        }
        return bArr;
    }

    private final byte[] O(int i) throws IOException {
        byte[] N = N(i);
        if (N != null) {
            return N;
        }
        int i2 = this.j;
        int i3 = this.h;
        int i4 = i3 - i2;
        this.l += i3;
        this.j = 0;
        this.h = 0;
        List<byte[]> J = J(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.g, i2, bArr, 0, i4);
        for (byte[] bArr2 : J) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    public final void A(int i) {
        this.m = i;
        K();
    }

    public final void B(int i) throws IOException {
        int i2 = this.h;
        int i3 = this.j;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.j = i3 + i;
            return;
        }
        if (i < 0) {
            throw bqw.f();
        }
        int i5 = this.l;
        int i6 = i5 + i3;
        int i7 = this.m;
        if (i6 + i > i7) {
            B((i7 - i5) - i3);
            throw bqw.i();
        }
        this.l = i6;
        this.h = 0;
        this.j = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long skip = this.f.skip(j);
                    if (skip < 0 || skip > j) {
                        throw new IllegalStateException(String.valueOf(this.f.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                    if (skip == 0) {
                        break;
                    } else {
                        i4 += (int) skip;
                    }
                } catch (bqw e) {
                    e.j();
                    throw e;
                }
            } catch (Throwable th) {
                this.l += i4;
                K();
                throw th;
            }
        }
        this.l += i4;
        K();
        if (i4 >= i) {
            return;
        }
        int i8 = this.h;
        int i9 = i8 - this.j;
        this.j = i8;
        while (true) {
            L(1);
            int i10 = i - i9;
            int i11 = this.h;
            if (i10 <= i11) {
                this.j = i10;
                return;
            } else {
                i9 += i11;
                this.j = i11;
            }
        }
    }

    public final boolean C() throws IOException {
        return this.j == this.h && !M(1);
    }

    public final boolean D() throws IOException {
        return r() != 0;
    }

    public final boolean E(int i) throws IOException {
        int m;
        int b = btm.b(i);
        int i2 = 0;
        if (b == 0) {
            if (this.h - this.j < 10) {
                while (i2 < 10) {
                    if (a() < 0) {
                        i2++;
                    }
                }
                throw bqw.e();
            }
            while (i2 < 10) {
                byte[] bArr = this.g;
                int i3 = this.j;
                this.j = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                }
            }
            throw bqw.e();
            return true;
        }
        if (b == 1) {
            B(8);
            return true;
        }
        if (b == 2) {
            B(j());
            return true;
        }
        if (b != 3) {
            if (b == 4) {
                return false;
            }
            if (b != 5) {
                throw bqw.a();
            }
            B(4);
            return true;
        }
        do {
            m = m();
            if (m == 0) {
                break;
            }
        } while (E(m));
        z(btm.c(btm.a(i), 4));
        return true;
    }

    public final byte a() throws IOException {
        if (this.j == this.h) {
            L(1);
        }
        byte[] bArr = this.g;
        int i = this.j;
        this.j = i + 1;
        return bArr[i];
    }

    public final double b() throws IOException {
        return Double.longBitsToDouble(q());
    }

    public final float c() throws IOException {
        return Float.intBitsToFloat(i());
    }

    public final int d() {
        return this.l + this.j;
    }

    public final int e(int i) throws bqw {
        if (i < 0) {
            throw bqw.f();
        }
        int i2 = i + this.l + this.j;
        int i3 = this.m;
        if (i2 > i3) {
            throw bqw.i();
        }
        this.m = i2;
        K();
        return i3;
    }

    public final int f() throws IOException {
        return j();
    }

    public final int g() throws IOException {
        return i();
    }

    public final int h() throws IOException {
        return j();
    }

    public final int i() throws IOException {
        int i = this.j;
        if (this.h - i < 4) {
            L(4);
            i = this.j;
        }
        byte[] bArr = this.g;
        this.j = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final int j() throws IOException {
        int i;
        int i2 = this.j;
        int i3 = this.h;
        if (i3 != i2) {
            byte[] bArr = this.g;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.j = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.j = i5;
                return i;
            }
        }
        return (int) s();
    }

    public final int k() throws IOException {
        return i();
    }

    public final int l() throws IOException {
        return bpg.F(j());
    }

    public final int m() throws IOException {
        if (C()) {
            this.k = 0;
            return 0;
        }
        int j = j();
        this.k = j;
        if (btm.a(j) != 0) {
            return j;
        }
        throw bqw.c();
    }

    public final int n() throws IOException {
        return j();
    }

    public final long o() throws IOException {
        return q();
    }

    public final long p() throws IOException {
        return r();
    }

    public final long q() throws IOException {
        int i = this.j;
        if (this.h - i < 8) {
            L(8);
            i = this.j;
        }
        byte[] bArr = this.g;
        this.j = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final long r() throws IOException {
        long j;
        long j2;
        int i = this.j;
        int i2 = this.h;
        if (i2 != i) {
            byte[] bArr = this.g;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.j = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j3 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j3;
                        } else {
                            i6 = i + 5;
                            long j4 = i9 ^ (bArr[i8] << 28);
                            if (j4 >= 0) {
                                j = j4 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j5 = (bArr[i6] << 35) ^ j4;
                                if (j5 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j6 = j5 ^ (bArr[i4] << 42);
                                    if (j6 >= 0) {
                                        j = j6 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j5 = j6 ^ (bArr[i10] << 49);
                                        if (j5 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            long j7 = (j5 ^ (bArr[i4] << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i4 = i + 10;
                                                if (bArr[i10] >= 0) {
                                                    j = j7;
                                                }
                                            } else {
                                                j = j7;
                                            }
                                        }
                                    }
                                    i4 = i10;
                                }
                                j = j5 ^ j2;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.j = i4;
                return j;
            }
        }
        return s();
    }

    public final long s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((a() & 128) == 0) {
                return j;
            }
        }
        throw bqw.e();
    }

    public final long t() throws IOException {
        return q();
    }

    public final long u() throws IOException {
        return bpg.G(r());
    }

    public final long v() throws IOException {
        return r();
    }

    public final bpb w() throws IOException {
        int j = j();
        int i = this.h;
        int i2 = this.j;
        if (j <= i - i2 && j > 0) {
            bpb u = bpb.u(this.g, i2, j);
            this.j += j;
            return u;
        }
        if (j == 0) {
            return bpb.b;
        }
        byte[] N = N(j);
        if (N != null) {
            return bpb.t(N);
        }
        int i3 = this.j;
        int i4 = this.h;
        int i5 = i4 - i3;
        this.l += i4;
        this.j = 0;
        this.h = 0;
        List<byte[]> J = J(j - i5);
        byte[] bArr = new byte[j];
        System.arraycopy(this.g, i3, bArr, 0, i5);
        for (byte[] bArr2 : J) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return bpb.x(bArr);
    }

    public final String x() throws IOException {
        int j = j();
        if (j > 0) {
            int i = this.h;
            int i2 = this.j;
            if (j <= i - i2) {
                String str = new String(this.g, i2, j, bqu.a);
                this.j += j;
                return str;
            }
        }
        if (j == 0) {
            return "";
        }
        if (j > this.h) {
            return new String(O(j), bqu.a);
        }
        L(j);
        String str2 = new String(this.g, this.j, j, bqu.a);
        this.j += j;
        return str2;
    }

    public final String y() throws IOException {
        byte[] O;
        int j = j();
        int i = this.j;
        int i2 = this.h;
        if (j <= i2 - i && j > 0) {
            O = this.g;
            this.j = i + j;
        } else {
            if (j == 0) {
                return "";
            }
            i = 0;
            if (j <= i2) {
                L(j);
                O = this.g;
                this.j = j;
            } else {
                O = O(j);
            }
        }
        return btj.h(O, i, j);
    }

    public final void z(int i) throws bqw {
        if (this.k != i) {
            throw bqw.b();
        }
    }
}
