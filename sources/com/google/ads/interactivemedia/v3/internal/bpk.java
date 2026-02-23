package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpk extends bpd {
    private static final Logger b = Logger.getLogger(bpk.class.getName());
    private static final boolean c = btf.B();
    bpl a;
    private final byte[] d;
    private final int e;
    private int f;

    private bpk() {
    }

    @Deprecated
    public static int A(int i, brs brsVar, bsi bsiVar) {
        int Q = Q(i);
        return Q + Q + ((bon) brsVar).at(bsiVar);
    }

    @Deprecated
    public static int B(brs brsVar) {
        return brsVar.ax();
    }

    public static int C(int i, int i2) {
        return Q(i) + D(i2);
    }

    public static int D(int i) {
        if (i >= 0) {
            return S(i);
        }
        return 10;
    }

    public static int E(int i, long j) {
        return Q(i) + U(j);
    }

    public static int F(int i, brc brcVar) {
        return Q(i) + G(brcVar);
    }

    public static int G(brc brcVar) {
        return H(brcVar.a());
    }

    public static int H(int i) {
        return S(i) + i;
    }

    public static int I(brs brsVar) {
        return H(brsVar.ax());
    }

    public static int J(brs brsVar, bsi bsiVar) {
        return H(((bon) brsVar).at(bsiVar));
    }

    public static int K(int i, int i2) {
        return Q(i) + L(i2);
    }

    public static int L(int i) {
        return S(V(i));
    }

    public static int M(int i, long j) {
        return Q(i) + N(j);
    }

    public static int N(long j) {
        return U(W(j));
    }

    public static int O(int i, String str) {
        return Q(i) + P(str);
    }

    public static int P(String str) {
        int length;
        try {
            length = btj.e(str);
        } catch (bti unused) {
            length = str.getBytes(bqu.a).length;
        }
        return H(length);
    }

    public static int Q(int i) {
        return S(btm.c(i, 0));
    }

    public static int R(int i, int i2) {
        return Q(i) + S(i2);
    }

    public static int S(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int T(int i, long j) {
        return Q(i) + U(j);
    }

    public static int U(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int V(int i) {
        return (i >> 31) ^ (i + i);
    }

    public static long W(long j) {
        return (j >> 63) ^ (j + j);
    }

    public static bpk X(byte[] bArr) {
        return new bpk(bArr, bArr.length);
    }

    public static int aC(int i) {
        return Q(i) + 1;
    }

    public static int aD(int i) {
        return Q(i) + 8;
    }

    public static int aE(int i) {
        return Q(i) + 4;
    }

    public static int aF(int i) {
        return Q(i) + 8;
    }

    public static int aG(int i) {
        return Q(i) + 4;
    }

    public static int aH(int i) {
        return Q(i) + 4;
    }

    public static int aI(int i) {
        return Q(i) + 8;
    }

    public static /* bridge */ /* synthetic */ boolean af() {
        return c;
    }

    public static int w(byte[] bArr) {
        return H(bArr.length);
    }

    public static int x(int i, bpb bpbVar) {
        return Q(i) + y(bpbVar);
    }

    public static int y(bpb bpbVar) {
        return H(bpbVar.d());
    }

    public static int z(int i, int i2) {
        return Q(i) + D(i2);
    }

    public final void Y() {
        if (ag() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void Z(String str, bti btiVar) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", btiVar);
        byte[] bytes = str.getBytes(bqu.a);
        try {
            int length = bytes.length;
            az(length);
            ar(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new bpj(e);
        }
    }

    public final void aA(int i, long j) throws IOException {
        ax(i, 0);
        aB(j);
    }

    public final void aB(long j) throws IOException {
        if (af() && ag() >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                btf.r(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = 1 + i2;
            btf.r(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new bpj(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e);
            }
        }
        byte[] bArr4 = this.d;
        int i4 = this.f;
        this.f = i4 + 1;
        bArr4[i4] = (byte) j;
    }

    public final void aa(int i, double d) throws IOException {
        an(i, Double.doubleToRawLongBits(d));
    }

    public final void ab(int i, float f) throws IOException {
        al(i, Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void ac(brs brsVar) throws IOException {
        brsVar.br(this);
    }

    public final void ad(int i, int i2) throws IOException {
        ay(i, V(i2));
    }

    public final void ae(int i, long j) throws IOException {
        aA(i, W(j));
    }

    public final int ag() {
        return this.e - this.f;
    }

    public final void ah(byte b2) throws IOException {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b2;
        } catch (IndexOutOfBoundsException e) {
            throw new bpj(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e);
        }
    }

    public final void ai(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.d, this.f, i2);
            this.f += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new bpj(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)}), e);
        }
    }

    public final void aj(int i, boolean z) throws IOException {
        ax(i, 0);
        ah(z ? (byte) 1 : (byte) 0);
    }

    public final void ak(int i, bpb bpbVar) throws IOException {
        ax(i, 2);
        az(bpbVar.d());
        bpbVar.p(this);
    }

    public final void al(int i, int i2) throws IOException {
        ax(i, 5);
        am(i2);
    }

    public final void am(int i) throws IOException {
        try {
            byte[] bArr = this.d;
            int i2 = this.f;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.f = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new bpj(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e);
        }
    }

    public final void an(int i, long j) throws IOException {
        ax(i, 1);
        ao(j);
    }

    public final void ao(long j) throws IOException {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            bArr[i] = (byte) (((int) j) & 255);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.f = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new bpj(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e);
        }
    }

    public final void ap(int i, int i2) throws IOException {
        ax(i, 0);
        aq(i2);
    }

    public final void aq(int i) throws IOException {
        if (i >= 0) {
            az(i);
        } else {
            aB(i);
        }
    }

    public final void ar(byte[] bArr, int i, int i2) throws IOException {
        ai(bArr, 0, i2);
    }

    public final void as(int i, brs brsVar, bsi bsiVar) throws IOException {
        ax(i, 2);
        az(((bon) brsVar).at(bsiVar));
        bsiVar.j(brsVar, this.a);
    }

    public final void at(int i, brs brsVar) throws IOException {
        ax(1, 3);
        ay(2, i);
        ax(3, 2);
        az(brsVar.ax());
        brsVar.br(this);
        ax(1, 4);
    }

    public final void au(int i, bpb bpbVar) throws IOException {
        ax(1, 3);
        ay(2, i);
        ak(3, bpbVar);
        ax(1, 4);
    }

    public final void av(int i, String str) throws IOException {
        ax(i, 2);
        aw(str);
    }

    public final void aw(String str) throws IOException {
        int i = this.f;
        try {
            int S = S(str.length() * 3);
            int S2 = S(str.length());
            if (S2 != S) {
                az(btj.e(str));
                this.f = btj.d(str, this.d, this.f, ag());
                return;
            }
            int i2 = i + S2;
            this.f = i2;
            int d = btj.d(str, this.d, i2, ag());
            this.f = i;
            az((d - i) - S2);
            this.f = d;
        } catch (IndexOutOfBoundsException e) {
            throw new bpj(e);
        } catch (bti e2) {
            this.f = i;
            Z(str, e2);
        }
    }

    public final void ax(int i, int i2) throws IOException {
        az(btm.c(i, i2));
    }

    public final void ay(int i, int i2) throws IOException {
        ax(i, 0);
        az(i2);
    }

    public final void az(int i) throws IOException {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new bpj(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e);
            }
        }
        byte[] bArr2 = this.d;
        int i3 = this.f;
        this.f = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    public /* synthetic */ bpk(byte[] bArr) {
    }

    public bpk(byte[] bArr, int i) {
        this(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i)}));
        }
        this.d = bArr;
        this.f = 0;
        this.e = i;
    }
}
