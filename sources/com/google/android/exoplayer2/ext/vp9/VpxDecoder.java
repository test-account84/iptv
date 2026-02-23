package com.google.android.exoplayer2.ext.vp9;

import U2.g;
import U2.i;
import android.view.Surface;
import c3.b;
import c3.c;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import d4.a;
import d4.k0;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class VpxDecoder extends i {
    public final CryptoConfig n;
    public final long o;
    public ByteBuffer p;
    public volatile int q;

    public VpxDecoder(int i, int i2, int i3, CryptoConfig cryptoConfig, int i4) {
        super(new g[i], new VideoDecoderOutputBuffer[i2]);
        if (!VpxLibrary.b()) {
            throw new c("Failed to load decoder native libraries.");
        }
        this.n = cryptoConfig;
        if (cryptoConfig != null && !VpxLibrary.vpxIsSecureDecodeSupported()) {
            throw new c("Vpx decoder does not support secure decode.");
        }
        long vpxInit = vpxInit(false, false, i4);
        this.o = vpxInit;
        if (vpxInit == 0) {
            throw new c("Failed to initialize decoder");
        }
        u(i3);
    }

    private native long vpxClose(long j);

    private native long vpxDecode(long j, ByteBuffer byteBuffer, int i);

    private native int vpxGetErrorCode(long j);

    private native String vpxGetErrorMessage(long j);

    private native int vpxGetFrame(long j, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native long vpxInit(boolean z, boolean z2, int i);

    private native int vpxReleaseFrame(long j, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native int vpxRenderFrame(long j, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native long vpxSecureDecode(long j, ByteBuffer byteBuffer, int i, CryptoConfig cryptoConfig, int i2, byte[] bArr, byte[] bArr2, int i3, int[] iArr, int[] iArr2);

    public void A(int i) {
        this.q = i;
    }

    public g g() {
        return new g(2);
    }

    public String getName() {
        return "libvpx" + VpxLibrary.a();
    }

    public void release() {
        super.release();
        this.p = null;
        vpxClose(this.o);
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public VideoDecoderOutputBuffer h() {
        return new VideoDecoderOutputBuffer(new b(this));
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public c i(Throwable th) {
        return new c("Unexpected decode error", th);
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public c j(g gVar, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z) {
        ByteBuffer byteBuffer;
        int remaining;
        ByteBuffer byteBuffer2;
        if (z && (byteBuffer2 = this.p) != null) {
            byteBuffer2.clear();
        }
        ByteBuffer byteBuffer3 = (ByteBuffer) k0.j(gVar.d);
        int limit = byteBuffer3.limit();
        U2.c cVar = gVar.c;
        long vpxSecureDecode = gVar.j() ? vpxSecureDecode(this.o, byteBuffer3, limit, this.n, cVar.c, (byte[]) a.e(cVar.b), (byte[]) a.e(cVar.a), cVar.f, cVar.d, cVar.e) : vpxDecode(this.o, byteBuffer3, limit);
        if (vpxSecureDecode != 0) {
            if (vpxSecureDecode != -2) {
                return new c("Decode error: " + vpxGetErrorMessage(this.o));
            }
            String str = "Drm error: " + vpxGetErrorMessage(this.o);
            return new c(str, new U2.b(vpxGetErrorCode(this.o), str));
        }
        if (gVar.hasSupplementalData() && (remaining = (byteBuffer = (ByteBuffer) a.e(gVar.g)).remaining()) > 0) {
            ByteBuffer byteBuffer4 = this.p;
            if (byteBuffer4 == null || byteBuffer4.capacity() < remaining) {
                this.p = ByteBuffer.allocate(remaining);
            } else {
                this.p.clear();
            }
            this.p.put(byteBuffer);
            this.p.flip();
        }
        if (gVar.isDecodeOnly()) {
            return null;
        }
        videoDecoderOutputBuffer.init(gVar.f, this.q, this.p);
        int vpxGetFrame = vpxGetFrame(this.o, videoDecoderOutputBuffer);
        if (vpxGetFrame == 1) {
            videoDecoderOutputBuffer.addFlag(Integer.MIN_VALUE);
        } else if (vpxGetFrame == -1) {
            return new c("Buffer initialization failed.");
        }
        videoDecoderOutputBuffer.format = gVar.a;
        return null;
    }

    public void y(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        if (this.q == 1 && !videoDecoderOutputBuffer.isDecodeOnly()) {
            vpxReleaseFrame(this.o, videoDecoderOutputBuffer);
        }
        super.r(videoDecoderOutputBuffer);
    }

    public void z(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        if (vpxRenderFrame(this.o, surface, videoDecoderOutputBuffer) == -1) {
            throw new c("Buffer render failed.");
        }
    }
}
