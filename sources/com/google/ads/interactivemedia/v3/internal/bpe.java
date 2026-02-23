package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bpe extends bpg {
    private final Iterable f;
    private final Iterator g;
    private ByteBuffer h;
    private int i;
    private int j;
    private int l;
    private long n;
    private long o;
    private long p;
    private long q;
    private int k = Integer.MAX_VALUE;
    private int m = 0;

    public /* synthetic */ bpe(Iterable iterable, int i) {
        this.i = i;
        this.f = iterable;
        this.g = iterable.iterator();
        if (i != 0) {
            M();
            return;
        }
        this.h = bqu.c;
        this.n = 0L;
        this.o = 0L;
        this.q = 0L;
        this.p = 0L;
    }

    private final int I() {
        return (int) (((this.i - this.m) - this.n) + this.o);
    }

    private final long J() {
        return this.q - this.n;
    }

    private final void K() throws bqw {
        if (!this.g.hasNext()) {
            throw bqw.i();
        }
        M();
    }

    private final void L() {
        int i = this.i + this.j;
        this.i = i;
        int i2 = this.k;
        if (i <= i2) {
            this.j = 0;
            return;
        }
        int i3 = i - i2;
        this.j = i3;
        this.i = i - i3;
    }

    private final void M() {
        ByteBuffer byteBuffer = (ByteBuffer) this.g.next();
        this.h = byteBuffer;
        this.m += (int) (this.n - this.o);
        long position = byteBuffer.position();
        this.n = position;
        this.o = position;
        this.q = this.h.limit();
        long e = btf.e(this.h);
        this.p = e;
        this.n += e;
        this.o += e;
        this.q += e;
    }

    private final void N(byte[] bArr, int i) throws IOException {
        if (i > I()) {
            if (i > 0) {
                throw bqw.i();
            }
            return;
        }
        int i2 = i;
        while (i2 > 0) {
            if (J() == 0) {
                K();
            }
            int min = Math.min(i2, (int) J());
            long j = min;
            btf.p(this.n, bArr, i - i2, j);
            i2 -= min;
            this.n += j;
        }
    }

    public final void A(int i) {
        this.k = i;
        L();
    }

    public final void B(int i) throws IOException {
        if (i < 0 || i > ((this.i - this.m) - this.n) + this.o) {
            if (i >= 0) {
                throw bqw.i();
            }
            throw bqw.f();
        }
        while (i > 0) {
            if (J() == 0) {
                K();
            }
            int min = Math.min(i, (int) J());
            i -= min;
            this.n += min;
        }
    }

    public final boolean C() throws IOException {
        return (((long) this.m) + this.n) - this.o == ((long) this.i);
    }

    public final boolean D() throws IOException {
        return r() != 0;
    }

    public final boolean E(int i) throws IOException {
        int m;
        int b = btm.b(i);
        if (b == 0) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (a() >= 0) {
                    return true;
                }
            }
            throw bqw.e();
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
        if (J() == 0) {
            K();
        }
        long j = this.n;
        this.n = 1 + j;
        return btf.a(j);
    }

    public final double b() throws IOException {
        return Double.longBitsToDouble(q());
    }

    public final float c() throws IOException {
        return Float.intBitsToFloat(i());
    }

    public final int d() {
        return (int) ((this.m + this.n) - this.o);
    }

    public final int e(int i) throws bqw {
        if (i < 0) {
            throw bqw.f();
        }
        int d = i + d();
        int i2 = this.k;
        if (d > i2) {
            throw bqw.i();
        }
        this.k = d;
        L();
        return i2;
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
        if (J() < 4) {
            return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
        }
        long j = this.n;
        this.n = 4 + j;
        return ((btf.a(j + 3) & 255) << 24) | (btf.a(j) & 255) | ((btf.a(1 + j) & 255) << 8) | ((btf.a(2 + j) & 255) << 16);
    }

    public final int j() throws IOException {
        int i;
        long j = this.n;
        if (this.q != j) {
            long j2 = j + 1;
            byte a = btf.a(j);
            if (a >= 0) {
                this.n++;
                return a;
            }
            if (this.q - this.n >= 10) {
                long j3 = 2 + j;
                int a2 = (btf.a(j2) << 7) ^ a;
                if (a2 < 0) {
                    i = a2 ^ (-128);
                } else {
                    long j4 = 3 + j;
                    int a3 = (btf.a(j3) << 14) ^ a2;
                    if (a3 >= 0) {
                        i = a3 ^ 16256;
                    } else {
                        long j5 = 4 + j;
                        int a4 = a3 ^ (btf.a(j4) << 21);
                        if (a4 < 0) {
                            i = (-2080896) ^ a4;
                        } else {
                            j4 = 5 + j;
                            byte a5 = btf.a(j5);
                            int i2 = (a4 ^ (a5 << 28)) ^ 266354560;
                            if (a5 < 0) {
                                j5 = 6 + j;
                                if (btf.a(j4) < 0) {
                                    j4 = 7 + j;
                                    if (btf.a(j5) < 0) {
                                        j5 = 8 + j;
                                        if (btf.a(j4) < 0) {
                                            j4 = 9 + j;
                                            if (btf.a(j5) < 0) {
                                                long j6 = j + 10;
                                                if (btf.a(j4) >= 0) {
                                                    i = i2;
                                                    j3 = j6;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i2;
                            }
                            i = i2;
                        }
                        j3 = j5;
                    }
                    j3 = j4;
                }
                this.n = j3;
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
            this.l = 0;
            return 0;
        }
        int j = j();
        this.l = j;
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
        if (J() < 8) {
            return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
        }
        this.n = 8 + this.n;
        return ((btf.a(r0 + 7) & 255) << 56) | ((btf.a(2 + r0) & 255) << 16) | (btf.a(r0) & 255) | ((btf.a(1 + r0) & 255) << 8) | ((btf.a(3 + r0) & 255) << 24) | ((btf.a(4 + r0) & 255) << 32) | ((btf.a(5 + r0) & 255) << 40) | ((btf.a(6 + r0) & 255) << 48);
    }

    public final long r() throws IOException {
        long j;
        long j2;
        long j3 = this.n;
        if (this.q != j3) {
            long j4 = j3 + 1;
            byte a = btf.a(j3);
            if (a >= 0) {
                this.n++;
                return a;
            }
            if (this.q - this.n >= 10) {
                long j5 = 2 + j3;
                int a2 = (btf.a(j4) << 7) ^ a;
                if (a2 < 0) {
                    j = a2 ^ (-128);
                } else {
                    long j6 = 3 + j3;
                    int a3 = (btf.a(j5) << 14) ^ a2;
                    if (a3 >= 0) {
                        j = a3 ^ 16256;
                    } else {
                        long j7 = 4 + j3;
                        int a4 = a3 ^ (btf.a(j6) << 21);
                        if (a4 < 0) {
                            j = (-2080896) ^ a4;
                            j5 = j7;
                        } else {
                            j6 = 5 + j3;
                            long a5 = (btf.a(j7) << 28) ^ a4;
                            if (a5 >= 0) {
                                j = 266354560 ^ a5;
                            } else {
                                long j8 = 6 + j3;
                                long a6 = a5 ^ (btf.a(j6) << 35);
                                if (a6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    long j9 = 7 + j3;
                                    long a7 = a6 ^ (btf.a(j8) << 42);
                                    if (a7 >= 0) {
                                        j = 4363953127296L ^ a7;
                                    } else {
                                        j8 = 8 + j3;
                                        a6 = a7 ^ (btf.a(j9) << 49);
                                        if (a6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j9 = 9 + j3;
                                            long a8 = (a6 ^ (btf.a(j8) << 56)) ^ 71499008037633920L;
                                            if (a8 < 0) {
                                                long j10 = j3 + 10;
                                                if (btf.a(j9) >= 0) {
                                                    j = a8;
                                                    j5 = j10;
                                                }
                                            } else {
                                                j = a8;
                                            }
                                        }
                                    }
                                    j5 = j9;
                                }
                                j = j2 ^ a6;
                                j5 = j8;
                            }
                        }
                    }
                    j5 = j6;
                }
                this.n = j5;
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
        if (j > 0) {
            long j2 = j;
            long j3 = this.q;
            long j4 = this.n;
            if (j2 <= j3 - j4) {
                byte[] bArr = new byte[j];
                btf.p(j4, bArr, 0L, j2);
                this.n += j2;
                return bpb.x(bArr);
            }
        }
        if (j > 0 && j <= I()) {
            byte[] bArr2 = new byte[j];
            N(bArr2, j);
            return bpb.x(bArr2);
        }
        if (j == 0) {
            return bpb.b;
        }
        if (j < 0) {
            throw bqw.f();
        }
        throw bqw.i();
    }

    public final String x() throws IOException {
        int j = j();
        if (j > 0) {
            long j2 = j;
            long j3 = this.q;
            long j4 = this.n;
            if (j2 <= j3 - j4) {
                byte[] bArr = new byte[j];
                btf.p(j4, bArr, 0L, j2);
                String str = new String(bArr, bqu.a);
                this.n += j2;
                return str;
            }
        }
        if (j > 0 && j <= I()) {
            byte[] bArr2 = new byte[j];
            N(bArr2, j);
            return new String(bArr2, bqu.a);
        }
        if (j == 0) {
            return "";
        }
        if (j < 0) {
            throw bqw.f();
        }
        throw bqw.i();
    }

    public final String y() throws IOException {
        int j = j();
        if (j > 0) {
            long j2 = j;
            long j3 = this.q;
            long j4 = this.n;
            if (j2 <= j3 - j4) {
                String g = btj.g(this.h, (int) (j4 - this.o), j);
                this.n += j2;
                return g;
            }
        }
        if (j >= 0 && j <= I()) {
            byte[] bArr = new byte[j];
            N(bArr, j);
            return btj.h(bArr, 0, j);
        }
        if (j == 0) {
            return "";
        }
        if (j <= 0) {
            throw bqw.f();
        }
        throw bqw.i();
    }

    public final void z(int i) throws bqw {
        if (this.l != i) {
            throw bqw.b();
        }
    }
}
