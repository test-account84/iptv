package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ua {
    private final cj a = new cj(32);
    private tz b;
    private tz c;
    private tz d;
    private long e;
    private final wr f;

    public ua(wr wrVar) {
        this.f = wrVar;
        tz tzVar = new tz(0L);
        this.b = tzVar;
        this.c = tzVar;
        this.d = tzVar;
    }

    private final int j(int i) {
        tz tzVar = this.d;
        if (tzVar.d == null) {
            bdz f = this.f.f();
            tz tzVar2 = new tz(this.d.b);
            tzVar.d = f;
            tzVar.c = tzVar2;
        }
        return Math.min(i, (int) (this.d.b - this.e));
    }

    private static tz k(tz tzVar, long j) {
        while (j >= tzVar.b) {
            tzVar = tzVar.c;
        }
        return tzVar;
    }

    private static tz l(tz tzVar, long j, ByteBuffer byteBuffer, int i) {
        tz k = k(tzVar, j);
        while (i > 0) {
            int min = Math.min(i, (int) (k.b - j));
            byteBuffer.put((byte[]) k.d.a, k.a(j), min);
            i -= min;
            j += min;
            if (j == k.b) {
                k = k.c;
            }
        }
        return k;
    }

    private static tz m(tz tzVar, long j, byte[] bArr, int i) {
        tz k = k(tzVar, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (k.b - j));
            System.arraycopy(k.d.a, k.a(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == k.b) {
                k = k.c;
            }
        }
        return k;
    }

    private static tz n(tz tzVar, ef efVar, ub ubVar, cj cjVar) {
        tz tzVar2;
        int i;
        if (efVar.k()) {
            long j = ubVar.b;
            cjVar.B(1);
            tz m = m(tzVar, j, cjVar.H(), 1);
            long j2 = j + 1;
            byte b = cjVar.H()[0];
            boolean z = (b & 128) != 0;
            int i2 = b & Byte.MAX_VALUE;
            ec ecVar = efVar.a;
            byte[] bArr = ecVar.a;
            if (bArr == null) {
                ecVar.a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            tzVar2 = m(m, j2, ecVar.a, i2);
            long j3 = j2 + i2;
            if (z) {
                cjVar.B(2);
                tzVar2 = m(tzVar2, j3, cjVar.H(), 2);
                j3 += 2;
                i = cjVar.m();
            } else {
                i = 1;
            }
            int[] iArr = ecVar.d;
            if (iArr == null || iArr.length < i) {
                iArr = new int[i];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = ecVar.e;
            if (iArr3 == null || iArr3.length < i) {
                iArr3 = new int[i];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = i * 6;
                cjVar.B(i3);
                tzVar2 = m(tzVar2, j3, cjVar.H(), i3);
                j3 += i3;
                cjVar.F(0);
                for (int i4 = 0; i4 < i; i4++) {
                    iArr2[i4] = cjVar.m();
                    iArr4[i4] = cjVar.l();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = ubVar.a - ((int) (j3 - ubVar.b));
            }
            aad aadVar = ubVar.c;
            int i5 = cq.a;
            ecVar.c(i, iArr2, iArr4, aadVar.b, ecVar.a, aadVar.a, aadVar.c, aadVar.d);
            long j4 = ubVar.b;
            int i6 = (int) (j3 - j4);
            ubVar.b = j4 + i6;
            ubVar.a -= i6;
        } else {
            tzVar2 = tzVar;
        }
        if (!efVar.e()) {
            efVar.i(ubVar.a);
            return l(tzVar2, ubVar.b, efVar.b, ubVar.a);
        }
        cjVar.B(4);
        tz m2 = m(tzVar2, ubVar.b, cjVar.H(), 4);
        int l = cjVar.l();
        ubVar.b += 4;
        ubVar.a -= 4;
        efVar.i(l);
        tz l2 = l(m2, ubVar.b, efVar.b, l);
        ubVar.b += l;
        int i7 = ubVar.a - l;
        ubVar.a = i7;
        ByteBuffer byteBuffer = efVar.e;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            efVar.e = ByteBuffer.allocate(i7);
        } else {
            efVar.e.clear();
        }
        return l(l2, ubVar.b, efVar.e, ubVar.a);
    }

    private final void o(tz tzVar) {
        if (tzVar.d == null) {
            return;
        }
        this.f.b(tzVar);
        tzVar.b();
    }

    private final void p(int i) {
        long j = this.e + i;
        this.e = j;
        tz tzVar = this.d;
        if (j == tzVar.b) {
            this.d = tzVar.c;
        }
    }

    public final int a(k kVar, int i, boolean z) throws IOException {
        int j = j(i);
        tz tzVar = this.d;
        int a = kVar.a((byte[]) tzVar.d.a, tzVar.a(this.e), j);
        if (a != -1) {
            p(a);
            return a;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long b() {
        return this.e;
    }

    public final void c(long j) {
        tz tzVar;
        if (j != -1) {
            while (true) {
                tzVar = this.b;
                if (j < tzVar.b) {
                    break;
                }
                this.f.g(tzVar.d);
                this.b = this.b.b();
            }
            if (this.c.a < tzVar.a) {
                this.c = tzVar;
            }
        }
    }

    public final void d(long j) {
        af.u(j <= this.e);
        this.e = j;
        if (j != 0) {
            tz tzVar = this.b;
            if (j != tzVar.a) {
                while (this.e > tzVar.b) {
                    tzVar = tzVar.c;
                }
                tz tzVar2 = tzVar.c;
                af.s(tzVar2);
                o(tzVar2);
                tz tzVar3 = new tz(tzVar.b);
                tzVar.c = tzVar3;
                if (this.e == tzVar.b) {
                    tzVar = tzVar3;
                }
                this.d = tzVar;
                if (this.c == tzVar2) {
                    this.c = tzVar3;
                    return;
                }
                return;
            }
        }
        o(this.b);
        tz tzVar4 = new tz(this.e);
        this.b = tzVar4;
        this.c = tzVar4;
        this.d = tzVar4;
    }

    public final void e(ef efVar, ub ubVar) {
        n(this.c, efVar, ubVar, this.a);
    }

    public final void f(ef efVar, ub ubVar) {
        this.c = n(this.c, efVar, ubVar, this.a);
    }

    public final void g() {
        o(this.b);
        this.b.d(0L);
        tz tzVar = this.b;
        this.c = tzVar;
        this.d = tzVar;
        this.e = 0L;
        this.f.e();
    }

    public final void h() {
        this.c = this.b;
    }

    public final void i(cj cjVar, int i) {
        while (i > 0) {
            int j = j(i);
            tz tzVar = this.d;
            cjVar.A((byte[]) tzVar.d.a, tzVar.a(this.e), j);
            i -= j;
            p(j);
        }
    }
}
