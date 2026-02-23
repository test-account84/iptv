package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abr implements zh {
    private static final byte[] a;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final UUID e;
    private static final Map f;
    private abq A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private long H;
    private ce I;
    private ce J;
    private boolean K;
    private boolean L;
    private int M;
    private long N;
    private long O;
    private int P;
    private int Q;
    private int[] R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private long X;
    private int Y;
    private int Z;
    private int aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private int ae;
    private byte af;
    private boolean ag;
    private zk ah;
    private final abn g;
    private final abt h;
    private final SparseArray i;
    private final boolean j;
    private final cj k;
    private final cj l;
    private final cj m;
    private final cj n;
    private final cj o;
    private final cj p;
    private final cj q;
    private final cj r;
    private final cj s;
    private final cj t;
    private ByteBuffer u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    static {
        abo aboVar = abo.a;
        a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        b = cq.ad("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        d = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        e = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f = Collections.unmodifiableMap(hashMap);
    }

    public abr() {
        this(0);
    }

    private static int[] A(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    public static /* bridge */ /* synthetic */ Map g() {
        return f;
    }

    public static /* bridge */ /* synthetic */ UUID h() {
        return e;
    }

    public static /* bridge */ /* synthetic */ byte[] n() {
        return b;
    }

    private final int o() {
        int i = this.Z;
        x();
        return i;
    }

    private final int p(zi ziVar, abq abqVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(abqVar.b)) {
            y(ziVar, a, i);
        } else if ("S_TEXT/ASS".equals(abqVar.b)) {
            y(ziVar, c, i);
        } else {
            if (!"S_TEXT/WEBVTT".equals(abqVar.b)) {
                aae aaeVar = abqVar.V;
                if (!this.ab) {
                    if (abqVar.g) {
                        this.U &= -1073741825;
                        if (!this.ac) {
                            ziVar.g(this.m.H(), 0, 1);
                            this.Y++;
                            if ((this.m.H()[0] & 128) == 128) {
                                throw as.a("Extension bit is set in signal byte", null);
                            }
                            this.af = this.m.H()[0];
                            this.ac = true;
                        }
                        byte b2 = this.af;
                        if ((b2 & 1) == 1) {
                            int i3 = b2 & 2;
                            this.U |= 1073741824;
                            if (!this.ag) {
                                ziVar.g(this.r.H(), 0, 8);
                                this.Y += 8;
                                this.ag = true;
                                this.m.H()[0] = (byte) ((i3 != 2 ? 0 : 128) | 8);
                                this.m.F(0);
                                aaeVar.i(this.m, 1);
                                this.Z++;
                                this.r.F(0);
                                aaeVar.i(this.r, 8);
                                this.Z += 8;
                            }
                            if (i3 == 2) {
                                if (!this.ad) {
                                    ziVar.g(this.m.H(), 0, 1);
                                    this.Y++;
                                    this.m.F(0);
                                    this.ae = this.m.i();
                                    this.ad = true;
                                }
                                int i4 = this.ae * 4;
                                this.m.B(i4);
                                ziVar.g(this.m.H(), 0, i4);
                                this.Y += i4;
                                int i5 = (this.ae >> 1) + 1;
                                int i6 = (i5 * 6) + 2;
                                ByteBuffer byteBuffer = this.u;
                                if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                    this.u = ByteBuffer.allocate(i6);
                                }
                                this.u.position(0);
                                this.u.putShort((short) i5);
                                int i7 = 0;
                                int i8 = 0;
                                while (true) {
                                    i2 = this.ae;
                                    if (i7 >= i2) {
                                        break;
                                    }
                                    int l = this.m.l();
                                    if (i7 % 2 == 0) {
                                        this.u.putShort((short) (l - i8));
                                    } else {
                                        this.u.putInt(l - i8);
                                    }
                                    i7++;
                                    i8 = l;
                                }
                                int i9 = (i - this.Y) - i8;
                                if ((i2 & 1) == 1) {
                                    this.u.putInt(i9);
                                } else {
                                    this.u.putShort((short) i9);
                                    this.u.putInt(0);
                                }
                                this.s.D(this.u.array(), i6);
                                aaeVar.i(this.s, i6);
                                this.Z += i6;
                            }
                        }
                    } else {
                        byte[] bArr = abqVar.h;
                        if (bArr != null) {
                            this.p.D(bArr, bArr.length);
                        }
                    }
                    if (!"A_OPUS".equals(abqVar.b) ? abqVar.f > 0 : z) {
                        this.U |= 268435456;
                        this.t.B(0);
                        int d2 = (this.p.d() + i) - this.Y;
                        this.m.B(4);
                        this.m.H()[0] = (byte) ((d2 >> 24) & 255);
                        this.m.H()[1] = (byte) ((d2 >> 16) & 255);
                        this.m.H()[2] = (byte) ((d2 >> 8) & 255);
                        this.m.H()[3] = (byte) (d2 & 255);
                        aaeVar.i(this.m, 4);
                        this.Z += 4;
                    }
                    this.ab = true;
                }
                int d3 = i + this.p.d();
                if (!"V_MPEG4/ISO/AVC".equals(abqVar.b) && !"V_MPEGH/ISO/HEVC".equals(abqVar.b)) {
                    if (abqVar.S != null) {
                        af.w(this.p.d() == 0);
                        abqVar.S.d(ziVar);
                    }
                    while (true) {
                        int i10 = this.Y;
                        if (i10 >= d3) {
                            break;
                        }
                        int q = q(ziVar, aaeVar, d3 - i10);
                        this.Y += q;
                        this.Z += q;
                    }
                } else {
                    byte[] H = this.l.H();
                    H[0] = 0;
                    H[1] = 0;
                    H[2] = 0;
                    int i11 = abqVar.W;
                    int i12 = 4 - i11;
                    while (this.Y < d3) {
                        int i13 = this.aa;
                        if (i13 == 0) {
                            int min = Math.min(i11, this.p.a());
                            ziVar.g(H, i12 + min, i11 - min);
                            if (min > 0) {
                                this.p.A(H, i12, min);
                            }
                            this.Y += i11;
                            this.l.F(0);
                            this.aa = this.l.l();
                            this.k.F(0);
                            aaeVar.e(this.k, 4);
                            this.Z += 4;
                        } else {
                            int q2 = q(ziVar, aaeVar, i13);
                            this.Y += q2;
                            this.Z += q2;
                            this.aa -= q2;
                        }
                    }
                }
                if ("A_VORBIS".equals(abqVar.b)) {
                    this.n.F(0);
                    aaeVar.e(this.n, 4);
                    this.Z += 4;
                }
                return o();
            }
            y(ziVar, d, i);
        }
        return o();
    }

    private final int q(zi ziVar, aae aaeVar, int i) throws IOException {
        int a2 = this.p.a();
        if (a2 <= 0) {
            return aaeVar.a(ziVar, i, false);
        }
        int min = Math.min(i, a2);
        aaeVar.e(this.p, min);
        return min;
    }

    private final long r(long j) throws as {
        long j2 = this.x;
        if (j2 != -9223372036854775807L) {
            return cq.w(j, j2, 1000L);
        }
        throw as.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private final void s(int i) throws as {
        if (this.I == null || this.J == null) {
            throw as.a("Element " + i + " must be in a Cues", null);
        }
    }

    private final void t(int i) throws as {
        if (this.A != null) {
            return;
        }
        throw as.a("Element " + i + " must be in a TrackEntry", null);
    }

    private final void u() {
        af.t(this.ah);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00de A[EDGE_INSN: B:51:0x00de->B:50:0x00de BREAK  A[LOOP:0: B:43:0x00c3->B:47:0x00db], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void v(com.google.ads.interactivemedia.v3.internal.abq r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.abr.v(com.google.ads.interactivemedia.v3.internal.abq, long, int, int, int):void");
    }

    private final void w(zi ziVar, int i) throws IOException {
        if (this.m.d() >= i) {
            return;
        }
        if (this.m.b() < i) {
            cj cjVar = this.m;
            int b2 = cjVar.b();
            cjVar.y(Math.max(b2 + b2, i));
        }
        ziVar.g(this.m.H(), this.m.d(), i - this.m.d());
        this.m.E(i);
    }

    private final void x() {
        this.Y = 0;
        this.Z = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.ae = 0;
        this.af = (byte) 0;
        this.ag = false;
        this.p.B(0);
    }

    private final void y(zi ziVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.q.b() < i2) {
            this.q.C(Arrays.copyOf(bArr, i2 + i));
        } else {
            System.arraycopy(bArr, 0, this.q.H(), 0, length);
        }
        ziVar.g(this.q.H(), length, i);
        this.q.F(0);
        this.q.E(i2);
    }

    private static byte[] z(long j, String str, long j2) {
        af.u(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        return cq.ad(String.format(Locale.US, str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))}));
    }

    public final boolean C(zi ziVar) throws IOException {
        return new abs().a(ziVar);
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        this.L = false;
        while (!this.L) {
            if (!this.g.c(ziVar)) {
                for (int i = 0; i < this.i.size(); i++) {
                    abq abqVar = (abq) this.i.valueAt(i);
                    abq.d(abqVar);
                    aaf aafVar = abqVar.S;
                    if (aafVar != null) {
                        aafVar.a(abqVar.V, abqVar.i);
                    }
                }
                return -1;
            }
            long d2 = ziVar.d();
            if (this.E) {
                this.G = d2;
                zyVar.a = this.F;
                this.E = false;
                return 1;
            }
            if (this.B) {
                long j = this.G;
                if (j != -1) {
                    zyVar.a = j;
                    this.G = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    public final void b(zk zkVar) {
        this.ah = zkVar;
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        this.H = -9223372036854775807L;
        this.M = 0;
        this.g.b();
        this.h.e();
        x();
        for (int i = 0; i < this.i.size(); i++) {
            aaf aafVar = ((abq) this.i.valueAt(i)).S;
            if (aafVar != null) {
                aafVar.b();
            }
        }
    }

    public final abq f(int i) throws as {
        t(i);
        return this.A;
    }

    public final void i(int i, int i2, zi ziVar) throws IOException {
        long j;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        Throwable th = null;
        int i9 = 1;
        int i10 = 0;
        if (i8 != 161 && i8 != 163) {
            if (i8 == 165) {
                if (this.M != 2) {
                    return;
                }
                abq abqVar = (abq) this.i.get(this.S);
                if (this.V != 4 || !"V_VP9".equals(abqVar.b)) {
                    ziVar.i(i2);
                    return;
                } else {
                    this.t.B(i2);
                    ziVar.g(this.t.H(), 0, i2);
                    return;
                }
            }
            if (i8 == 16877) {
                abq f2 = f(i);
                if (abq.a(f2) != 1685485123 && abq.a(f2) != 1685480259) {
                    ziVar.i(i2);
                    return;
                }
                byte[] bArr = new byte[i2];
                f2.M = bArr;
                ziVar.g(bArr, 0, i2);
                return;
            }
            if (i8 == 16981) {
                t(i);
                byte[] bArr2 = new byte[i2];
                this.A.h = bArr2;
                ziVar.g(bArr2, 0, i2);
                return;
            }
            if (i8 == 18402) {
                byte[] bArr3 = new byte[i2];
                ziVar.g(bArr3, 0, i2);
                f(i).i = new aad(1, bArr3, 0, 0);
                return;
            }
            if (i8 == 21419) {
                Arrays.fill(this.o.H(), (byte) 0);
                ziVar.g(this.o.H(), 4 - i2, i2);
                this.o.F(0);
                this.C = (int) this.o.p();
                return;
            }
            if (i8 == 25506) {
                t(i);
                byte[] bArr4 = new byte[i2];
                this.A.j = bArr4;
                ziVar.g(bArr4, 0, i2);
                return;
            }
            if (i8 != 30322) {
                throw as.a("Unexpected id: " + i8, null);
            }
            t(i);
            byte[] bArr5 = new byte[i2];
            this.A.u = bArr5;
            ziVar.g(bArr5, 0, i2);
            return;
        }
        if (this.M == 0) {
            this.S = (int) this.h.d(ziVar, false, true, 8);
            this.T = this.h.a();
            this.O = -9223372036854775807L;
            this.M = 1;
            this.m.B(0);
        }
        abq abqVar2 = (abq) this.i.get(this.S);
        if (abqVar2 == null) {
            ziVar.i(i2 - this.T);
            this.M = 0;
            return;
        }
        abq.d(abqVar2);
        if (this.M == 1) {
            w(ziVar, 3);
            int i11 = (this.m.H()[2] & 6) >> 1;
            byte b2 = 255;
            if (i11 == 0) {
                this.Q = 1;
                int[] A = A(this.R, 1);
                this.R = A;
                A[0] = (i2 - this.T) - 3;
            } else {
                w(ziVar, 4);
                int i12 = (this.m.H()[3] & 255) + 1;
                this.Q = i12;
                int[] A2 = A(this.R, i12);
                this.R = A2;
                if (i11 == 2) {
                    int i13 = this.T;
                    int i14 = this.Q;
                    Arrays.fill(A2, 0, i14, ((i2 - i13) - 4) / i14);
                } else {
                    if (i11 != 1) {
                        if (i11 != 3) {
                            throw as.a("Unexpected lacing value: 2", null);
                        }
                        int i15 = 0;
                        int i16 = 4;
                        int i17 = 0;
                        while (true) {
                            int i18 = this.Q - 1;
                            if (i15 >= i18) {
                                this.R[i18] = ((i2 - this.T) - i16) - i17;
                                break;
                            }
                            this.R[i15] = i10;
                            int i19 = i16 + 1;
                            w(ziVar, i19);
                            if (this.m.H()[i16] == 0) {
                                throw as.a("No valid varint length mask found", th);
                            }
                            int i20 = 0;
                            while (true) {
                                if (i20 >= 8) {
                                    j = 0;
                                    i3 = i19;
                                    break;
                                }
                                int i21 = i9 << (7 - i20);
                                if ((this.m.H()[i16] & i21) != 0) {
                                    int i22 = i19 + i20;
                                    w(ziVar, i22);
                                    int i23 = i16 + 1;
                                    j = this.m.H()[i16] & b2 & (~i21);
                                    while (i23 < i22) {
                                        j = (j << 8) | (this.m.H()[i23] & b2);
                                        i23++;
                                        i22 = i22;
                                        b2 = 255;
                                    }
                                    i3 = i22;
                                    if (i15 > 0) {
                                        j -= (1 << ((i20 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i20++;
                                    i9 = 1;
                                    b2 = 255;
                                }
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int i24 = (int) j;
                            int[] iArr = this.R;
                            if (i15 != 0) {
                                i24 += iArr[i15 - 1];
                            }
                            iArr[i15] = i24;
                            i17 += i24;
                            i15++;
                            i16 = i3;
                            th = null;
                            i9 = 1;
                            i10 = 0;
                            b2 = 255;
                        }
                        throw as.a("EBML lacing sample size out of range.", null);
                    }
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 4;
                    while (true) {
                        i4 = this.Q - 1;
                        if (i25 >= i4) {
                            break;
                        }
                        this.R[i25] = 0;
                        while (true) {
                            i5 = i27 + 1;
                            w(ziVar, i5);
                            int i28 = this.m.H()[i27] & 255;
                            int[] iArr2 = this.R;
                            i6 = iArr2[i25] + i28;
                            iArr2[i25] = i6;
                            if (i28 != 255) {
                                break;
                            } else {
                                i27 = i5;
                            }
                        }
                        i26 += i6;
                        i25++;
                        i27 = i5;
                    }
                    this.R[i4] = ((i2 - this.T) - i27) - i26;
                }
            }
            this.N = this.H + r((this.m.H()[0] << 8) | (this.m.H()[1] & 255));
            if (abqVar2.d == 2) {
                i7 = 1;
                this.U = i7;
                this.M = 2;
                this.P = 0;
            } else {
                if (i8 == 163) {
                    if ((this.m.H()[2] & 128) == 128) {
                        i8 = 163;
                        i7 = 1;
                        this.U = i7;
                        this.M = 2;
                        this.P = 0;
                    } else {
                        i8 = 163;
                    }
                }
                i7 = 0;
                this.U = i7;
                this.M = 2;
                this.P = 0;
            }
        }
        if (i8 == 163) {
            while (true) {
                int i29 = this.P;
                if (i29 >= this.Q) {
                    this.M = 0;
                    return;
                }
                v(abqVar2, ((this.P * abqVar2.e) / 1000) + this.N, this.U, p(ziVar, abqVar2, this.R[i29], false), 0);
                this.P++;
            }
        } else {
            while (true) {
                int i30 = this.P;
                if (i30 >= this.Q) {
                    return;
                }
                int[] iArr3 = this.R;
                iArr3[i30] = p(ziVar, abqVar2, iArr3[i30], true);
                this.P++;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:193:0x030a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(int r21) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.abr.j(int):void");
    }

    public final void k(int i, double d2) throws as {
        if (i == 181) {
            f(i).P = (int) d2;
            return;
        }
        if (i == 17545) {
            this.y = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                f(i).C = (float) d2;
                break;
            case 21970:
                f(i).D = (float) d2;
                break;
            case 21971:
                f(i).E = (float) d2;
                break;
            case 21972:
                f(i).F = (float) d2;
                break;
            case 21973:
                f(i).G = (float) d2;
                break;
            case 21974:
                f(i).H = (float) d2;
                break;
            case 21975:
                f(i).I = (float) d2;
                break;
            case 21976:
                f(i).J = (float) d2;
                break;
            case 21977:
                f(i).K = (float) d2;
                break;
            case 21978:
                f(i).L = (float) d2;
                break;
            default:
                switch (i) {
                    case 30323:
                        f(i).r = (float) d2;
                        break;
                    case 30324:
                        f(i).s = (float) d2;
                        break;
                    case 30325:
                        f(i).t = (float) d2;
                        break;
                }
        }
    }

    public final void l(int i, long j) throws as {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw as.a("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw as.a("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                f(i).d = (int) j;
                return;
            case 136:
                f(i).U = j == 1;
                return;
            case 155:
                this.O = r(j);
                return;
            case 159:
                f(i).N = (int) j;
                return;
            case 176:
                f(i).l = (int) j;
                return;
            case 179:
                s(i);
                this.I.c(r(j));
                return;
            case 186:
                f(i).m = (int) j;
                return;
            case 215:
                f(i).c = (int) j;
                return;
            case 231:
                this.H = r(j);
                return;
            case 238:
                this.V = (int) j;
                return;
            case 241:
                if (this.K) {
                    return;
                }
                s(i);
                this.J.c(j);
                this.K = true;
                return;
            case 251:
                this.W = true;
                return;
            case 16871:
                abq.b(f(i), (int) j);
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw as.a("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw as.a("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw as.a("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw as.a("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw as.a("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.D = j + this.w;
                return;
            case 21432:
                t(i);
                int i2 = (int) j;
                if (i2 == 0) {
                    this.A.v = 0;
                    return;
                }
                if (i2 == 1) {
                    this.A.v = 2;
                    return;
                } else if (i2 == 3) {
                    this.A.v = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.A.v = 3;
                    return;
                }
            case 21680:
                f(i).n = (int) j;
                return;
            case 21682:
                f(i).p = (int) j;
                return;
            case 21690:
                f(i).o = (int) j;
                return;
            case 21930:
                f(i).T = j == 1;
                return;
            case 21998:
                f(i).f = (int) j;
                return;
            case 22186:
                f(i).Q = j;
                return;
            case 22203:
                f(i).R = j;
                return;
            case 25188:
                f(i).O = (int) j;
                return;
            case 30114:
                this.X = j;
                return;
            case 30321:
                t(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.A.q = 0;
                    return;
                }
                if (i3 == 1) {
                    this.A.q = 1;
                    return;
                } else if (i3 == 2) {
                    this.A.q = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.A.q = 3;
                    return;
                }
            case 2352003:
                f(i).e = (int) j;
                return;
            case 2807729:
                this.x = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        t(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.A.z = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.A.z = 1;
                            return;
                        }
                    case 21946:
                        t(i);
                        int b2 = j.b((int) j);
                        if (b2 != -1) {
                            this.A.y = b2;
                            return;
                        }
                        return;
                    case 21947:
                        t(i);
                        abq abqVar = this.A;
                        abqVar.w = true;
                        int a2 = j.a((int) j);
                        if (a2 != -1) {
                            abqVar.x = a2;
                            return;
                        }
                        return;
                    case 21948:
                        f(i).A = (int) j;
                        return;
                    case 21949:
                        f(i).B = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public final void m(int i, long j, long j2) throws as {
        u();
        if (i == 160) {
            this.W = false;
            this.X = 0L;
            return;
        }
        if (i == 174) {
            this.A = new abq();
            return;
        }
        if (i == 187) {
            this.K = false;
            return;
        }
        if (i == 19899) {
            this.C = -1;
            this.D = -1L;
            return;
        }
        if (i == 20533) {
            f(i).g = true;
            return;
        }
        if (i == 21968) {
            f(i).w = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.w;
            if (j3 != -1 && j3 != j) {
                throw as.a("Multiple Segment elements not supported", null);
            }
            this.w = j;
            this.v = j2;
            return;
        }
        if (i == 475249515) {
            this.I = new ce();
            this.J = new ce();
        } else if (i == 524531317 && !this.B) {
            if (this.j && this.F != -1) {
                this.E = true;
            } else {
                this.ah.x(new aaa(this.z));
                this.B = true;
            }
        }
    }

    public abr(int i) {
        abl ablVar = new abl();
        this.w = -1L;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.z = -9223372036854775807L;
        this.F = -1L;
        this.G = -1L;
        this.H = -9223372036854775807L;
        this.g = ablVar;
        ablVar.a(new abp(this));
        this.j = 1 == (i ^ 1);
        this.h = new abt();
        this.i = new SparseArray();
        this.m = new cj(4);
        this.n = new cj(ByteBuffer.allocate(4).putInt(-1).array());
        this.o = new cj(4);
        this.k = new cj(zw.a);
        this.l = new cj(4);
        this.p = new cj();
        this.q = new cj();
        this.r = new cj(8);
        this.s = new cj();
        this.t = new cj();
        this.R = new int[1];
    }
}
