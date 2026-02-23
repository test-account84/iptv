package com.google.android.exoplayer2.ext.av1;

import U2.g;
import U2.i;
import W2.a;
import W2.b;
import W2.c;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import d4.k0;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Gav1Decoder extends i {
    public final long n;
    public volatile int o;

    public Gav1Decoder(int i, int i2, int i3, int i4) {
        super(new g[i], new VideoDecoderOutputBuffer[i2]);
        if (!c.a()) {
            throw new b("Failed to load decoder native library.");
        }
        if (i4 == 0 && (i4 = gav1GetThreads()) <= 0) {
            i4 = Runtime.getRuntime().availableProcessors();
        }
        long gav1Init = gav1Init(i4);
        this.n = gav1Init;
        if (gav1Init != 0 && gav1CheckError(gav1Init) != 0) {
            u(i3);
            return;
        }
        throw new b("Failed to initialize decoder. Error: " + gav1GetErrorMessage(gav1Init));
    }

    private native int gav1CheckError(long j);

    private native void gav1Close(long j);

    private native int gav1Decode(long j, ByteBuffer byteBuffer, int i);

    private native String gav1GetErrorMessage(long j);

    private native int gav1GetFrame(long j, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z);

    private native int gav1GetThreads();

    private native long gav1Init(int i);

    private native void gav1ReleaseFrame(long j, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native int gav1RenderFrame(long j, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    public void A(int i) {
        this.o = i;
    }

    public g g() {
        return new g(2);
    }

    public String getName() {
        return "libgav1";
    }

    public void release() {
        super.release();
        gav1Close(this.n);
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public VideoDecoderOutputBuffer h() {
        return new VideoDecoderOutputBuffer(new a(this));
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public b i(Throwable th) {
        return new b("Unexpected decode error", th);
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public b j(g gVar, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z) {
        ByteBuffer byteBuffer = (ByteBuffer) k0.j(gVar.d);
        if (gav1Decode(this.n, byteBuffer, byteBuffer.limit()) == 0) {
            return new b("gav1Decode error: " + gav1GetErrorMessage(this.n));
        }
        boolean isDecodeOnly = gVar.isDecodeOnly();
        if (!isDecodeOnly) {
            videoDecoderOutputBuffer.init(gVar.f, this.o, null);
        }
        int gav1GetFrame = gav1GetFrame(this.n, videoDecoderOutputBuffer, isDecodeOnly);
        if (gav1GetFrame == 0) {
            return new b("gav1GetFrame error: " + gav1GetErrorMessage(this.n));
        }
        if (gav1GetFrame == 2) {
            videoDecoderOutputBuffer.addFlag(Integer.MIN_VALUE);
        }
        if (!isDecodeOnly) {
            videoDecoderOutputBuffer.format = gVar.a;
        }
        return null;
    }

    public void y(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        if (videoDecoderOutputBuffer.mode == 1 && !videoDecoderOutputBuffer.isDecodeOnly()) {
            gav1ReleaseFrame(this.n, videoDecoderOutputBuffer);
        }
        super.r(videoDecoderOutputBuffer);
    }

    public void z(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new b("Invalid output mode.");
        }
        if (gav1RenderFrame(this.n, surface, videoDecoderOutputBuffer) != 0) {
            return;
        }
        throw new b("Buffer render error: " + gav1GetErrorMessage(this.n));
    }
}
