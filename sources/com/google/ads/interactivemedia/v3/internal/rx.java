package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class rx implements rf {
    private final MediaCodec a;
    private ByteBuffer[] b;
    private ByteBuffer[] c;

    public /* synthetic */ rx(MediaCodec mediaCodec) {
        this.a = mediaCodec;
        if (cq.a < 21) {
            this.b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }

    public final int a() {
        return this.a.dequeueInputBuffer(0L);
    }

    public final int b(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3) {
                if (cq.a < 21) {
                    this.c = this.a.getOutputBuffers();
                }
                dequeueOutputBuffer = -3;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final MediaFormat c() {
        return this.a.getOutputFormat();
    }

    public final ByteBuffer f(int i) {
        return cq.a >= 21 ? this.a.getInputBuffer(i) : ((ByteBuffer[]) cq.G(this.b))[i];
    }

    public final ByteBuffer g(int i) {
        return cq.a >= 21 ? this.a.getOutputBuffer(i) : ((ByteBuffer[]) cq.G(this.c))[i];
    }

    public final void h() {
        this.a.flush();
    }

    public final void i() {
        this.b = null;
        this.c = null;
        this.a.release();
    }

    public final void j(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    public final void k(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    public final void l(Surface surface) {
        A1.a(this.a, surface);
    }

    public final void m(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    public final void n(int i) {
        this.a.setVideoScalingMode(i);
    }

    public final void p() {
    }

    public final void q(int i, int i2, long j, int i3) {
        this.a.queueInputBuffer(i, 0, i2, j, i3);
    }

    public final void r(int i, ec ecVar, long j) {
        this.a.queueSecureInputBuffer(i, 0, ecVar.a(), j, 0);
    }
}
