package com.google.android.exoplayer2.ext.opus;

import U2.g;
import U2.i;
import a3.b;
import a3.c;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.a;
import d4.k0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class OpusDecoder extends i {
    public final boolean n;
    public final int o;
    public final CryptoConfig p;
    public final int q;
    public final int r;
    public final long s;
    public boolean t;
    public int u;

    public OpusDecoder(int i, int i2, int i3, List list, CryptoConfig cryptoConfig, boolean z) {
        int i4;
        super(new g[i], new SimpleDecoderOutputBuffer[i2]);
        if (!OpusLibrary.b()) {
            throw new c("Failed to load decoder native libraries");
        }
        this.p = cryptoConfig;
        if (cryptoConfig != null && !OpusLibrary.opusIsSecureDecodeSupported()) {
            throw new c("Opus decoder does not support secure decode");
        }
        int size = list.size();
        int i5 = 1;
        if (size != 1 && size != 3) {
            throw new c("Invalid initialization data size");
        }
        if (size == 3 && (((byte[]) list.get(1)).length != 8 || ((byte[]) list.get(2)).length != 8)) {
            throw new c("Invalid pre-skip or seek pre-roll");
        }
        int C = C(list);
        this.q = C;
        this.r = D(list);
        this.u = C;
        byte[] bArr = (byte[]) list.get(0);
        if (bArr.length < 19) {
            throw new c("Invalid header length");
        }
        int A = A(bArr);
        this.o = A;
        if (A > 8) {
            throw new c("Invalid channel count: " + A);
        }
        int F = F(bArr, 16);
        byte[] bArr2 = new byte[8];
        if (bArr[18] == 0) {
            if (A > 2) {
                throw new c("Invalid header, missing stream map");
            }
            int i6 = A == 2 ? 1 : 0;
            bArr2[0] = 0;
            bArr2[1] = 1;
            i4 = i6;
        } else {
            if (bArr.length < A + 21) {
                throw new c("Invalid header length");
            }
            i5 = bArr[19] & 255;
            i4 = bArr[20] & 255;
            System.arraycopy(bArr, 21, bArr2, 0, A);
        }
        long opusInit = opusInit(48000, A, i5, i4, F, bArr2);
        this.s = opusInit;
        if (opusInit == 0) {
            throw new c("Failed to initialize decoder");
        }
        u(i3);
        this.n = z;
        if (z) {
            opusSetFloatOutput();
        }
    }

    public static int A(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int B(ByteBuffer byteBuffer) {
        if (byteBuffer == null || byteBuffer.remaining() != 8) {
            return 0;
        }
        long j = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong();
        if (j < 0) {
            return 0;
        }
        return (int) ((j * 48000) / 1000000000);
    }

    public static int C(List list) {
        if (list.size() == 3) {
            return (int) ((ByteBuffer.wrap((byte[]) list.get(1)).order(ByteOrder.nativeOrder()).getLong() * 48000) / 1000000000);
        }
        byte[] bArr = (byte[]) list.get(0);
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int D(List list) {
        if (list.size() == 3) {
            return (int) ((ByteBuffer.wrap((byte[]) list.get(2)).order(ByteOrder.nativeOrder()).getLong() * 48000) / 1000000000);
        }
        return 3840;
    }

    public static /* synthetic */ void E(OpusDecoder opusDecoder, a aVar) {
        opusDecoder.r(aVar);
    }

    public static int F(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public static int G(int i, int i2, boolean z) {
        return i * i2 * (z ? 4 : 2);
    }

    private native void opusClose(long j);

    private native int opusDecode(long j, long j2, ByteBuffer byteBuffer, int i, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer);

    private native int opusGetErrorCode(long j);

    private native String opusGetErrorMessage(long j);

    private native long opusInit(int i, int i2, int i3, int i4, int i5, byte[] bArr);

    private native void opusReset(long j);

    private native int opusSecureDecode(long j, long j2, ByteBuffer byteBuffer, int i, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, int i2, CryptoConfig cryptoConfig, int i3, byte[] bArr, byte[] bArr2, int i4, int[] iArr, int[] iArr2);

    private native void opusSetFloatOutput();

    public static /* synthetic */ void v(OpusDecoder opusDecoder, a aVar) {
        E(opusDecoder, aVar);
    }

    public g g() {
        return new g(2);
    }

    public String getName() {
        return "libopus" + OpusLibrary.a();
    }

    public void release() {
        super.release();
        opusClose(this.s);
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public SimpleDecoderOutputBuffer h() {
        return new SimpleDecoderOutputBuffer(new b(this));
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public c i(Throwable th) {
        return new c("Unexpected decode error", th);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public c j(g gVar, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, boolean z) {
        OpusDecoder opusDecoder;
        g gVar2;
        int opusDecode;
        int B;
        int G;
        if (z) {
            opusReset(this.s);
            this.u = gVar.f == 0 ? this.q : this.r;
        }
        ByteBuffer byteBuffer = (ByteBuffer) k0.j(gVar.d);
        U2.c cVar = gVar.c;
        if (gVar.j()) {
            opusDecode = opusSecureDecode(this.s, gVar.f, byteBuffer, byteBuffer.limit(), simpleDecoderOutputBuffer, 48000, this.p, cVar.c, (byte[]) d4.a.e(cVar.b), (byte[]) d4.a.e(cVar.a), cVar.f, cVar.d, cVar.e);
            opusDecoder = this;
            gVar2 = gVar;
        } else {
            opusDecoder = this;
            gVar2 = gVar;
            opusDecode = opusDecode(opusDecoder.s, gVar2.f, byteBuffer, byteBuffer.limit(), simpleDecoderOutputBuffer);
        }
        if (opusDecode < 0) {
            if (opusDecode != -2) {
                return new c("Decode error: " + opusDecoder.opusGetErrorMessage(opusDecode));
            }
            String str = "Drm error: " + opusDecoder.opusGetErrorMessage(opusDecoder.s);
            return new c(str, new U2.b(opusDecoder.opusGetErrorCode(opusDecoder.s), str));
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) k0.j(simpleDecoderOutputBuffer.data);
        byteBuffer2.position(0);
        byteBuffer2.limit(opusDecode);
        if (opusDecoder.u <= 0) {
            if (!opusDecoder.t || !gVar.hasSupplementalData() || (B = B(gVar2.g)) <= 0 || opusDecode < (G = G(B, opusDecoder.o, opusDecoder.n))) {
                return null;
            }
            byteBuffer2.limit(opusDecode - G);
            return null;
        }
        int G2 = G(1, opusDecoder.o, opusDecoder.n);
        int i = opusDecoder.u;
        int i2 = i * G2;
        if (opusDecode > i2) {
            opusDecoder.u = 0;
            byteBuffer2.position(i2);
            return null;
        }
        opusDecoder.u = i - (opusDecode / G2);
        simpleDecoderOutputBuffer.addFlag(Integer.MIN_VALUE);
        byteBuffer2.position(opusDecode);
        return null;
    }

    public void z(boolean z) {
        this.t = z;
    }
}
