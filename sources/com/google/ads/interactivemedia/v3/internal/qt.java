package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class qt implements rf {
    private final MediaCodec a;
    private final qy b;
    private final qw c;
    private boolean d;
    private int e = 0;

    public /* synthetic */ qt(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2) {
        this.a = mediaCodec;
        this.b = new qy(handlerThread);
        this.c = new qw(mediaCodec, handlerThread2);
    }

    public static /* bridge */ /* synthetic */ String d(int i) {
        return s(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static /* bridge */ /* synthetic */ String e(int i) {
        return s(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static /* bridge */ /* synthetic */ void o(qt qtVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto) {
        qtVar.b.f(qtVar.a);
        af.o("configureCodec");
        qtVar.a.configure(mediaFormat, surface, mediaCrypto, 0);
        af.p();
        qtVar.c.d();
        af.o("startCodec");
        qtVar.a.start();
        af.p();
        qtVar.e = 1;
    }

    private static String s(int i, String str) {
        String str2;
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            str2 = "Audio";
        } else if (i == 2) {
            str2 = "Video";
        } else {
            sb.append("Unknown(");
            sb.append(i);
            str2 = ")";
        }
        sb.append(str2);
        return sb.toString();
    }

    public final int a() {
        return this.b.a();
    }

    public final int b(MediaCodec.BufferInfo bufferInfo) {
        return this.b.b(bufferInfo);
    }

    public final MediaFormat c() {
        return this.b.c();
    }

    public final ByteBuffer f(int i) {
        return this.a.getInputBuffer(i);
    }

    public final ByteBuffer g(int i) {
        return this.a.getOutputBuffer(i);
    }

    public final void h() {
        this.c.b();
        this.a.flush();
        this.b.e();
        this.a.start();
    }

    public final void i() {
        try {
            if (this.e == 1) {
                this.c.c();
                this.b.g();
            }
            this.e = 2;
            if (this.d) {
                return;
            }
            this.a.release();
            this.d = true;
        } catch (Throwable th) {
            if (!this.d) {
                this.a.release();
                this.d = true;
            }
            throw th;
        }
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
        this.c.e(i, i2, j, i3);
    }

    public final void r(int i, ec ecVar, long j) {
        this.c.f(i, ecVar, j);
    }
}
