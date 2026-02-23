package com.google.android.exoplayer2.ext.ffmpeg;

import O2.z0;
import U2.g;
import U2.i;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import d4.M;
import d4.k0;
import java.nio.ByteBuffer;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class FfmpegAudioDecoder extends i {
    public final String n;
    public final byte[] o;
    public final int p;
    public final int q;
    public long r;
    public boolean s;
    public volatile int t;
    public volatile int u;

    public FfmpegAudioDecoder(z0 z0Var, int i, int i2, int i3, boolean z) {
        super(new g[i], new SimpleDecoderOutputBuffer[i2]);
        if (!FfmpegLibrary.d()) {
            throw new Y2.a("Failed to load decoder native libraries.");
        }
        d4.a.e(z0Var.m);
        String str = (String) d4.a.e(FfmpegLibrary.a(z0Var.m));
        this.n = str;
        byte[] C = C(z0Var.m, z0Var.o);
        this.o = C;
        this.p = z ? 4 : 2;
        this.q = z ? 131072 : 65536;
        long ffmpegInitialize = ffmpegInitialize(str, C, z, z0Var.A, z0Var.z);
        this.r = ffmpegInitialize;
        if (ffmpegInitialize == 0) {
            throw new Y2.a("Initialization failed.");
        }
        u(i3);
    }

    public static byte[] C(String str, List list) {
        str.hashCode();
        switch (str) {
            case "audio/vorbis":
                return E(list);
            case "audio/mp4a-latm":
            case "audio/opus":
                return (byte[]) list.get(0);
            case "audio/alac":
                return z(list);
            default:
                return null;
        }
    }

    public static byte[] E(List list) {
        byte[] bArr = (byte[]) list.get(0);
        byte[] bArr2 = (byte[]) list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & 255);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }

    public static /* synthetic */ void F(FfmpegAudioDecoder ffmpegAudioDecoder, com.google.android.exoplayer2.decoder.a aVar) {
        ffmpegAudioDecoder.r(aVar);
    }

    private native int ffmpegDecode(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2);

    private native int ffmpegGetChannelCount(long j);

    private native int ffmpegGetSampleRate(long j);

    private native long ffmpegInitialize(String str, byte[] bArr, boolean z, int i, int i2);

    private native void ffmpegRelease(long j);

    private native long ffmpegReset(long j, byte[] bArr);

    public static /* synthetic */ void v(FfmpegAudioDecoder ffmpegAudioDecoder, com.google.android.exoplayer2.decoder.a aVar) {
        F(ffmpegAudioDecoder, aVar);
    }

    public static byte[] z(List list) {
        byte[] bArr = (byte[]) list.get(0);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1634492771);
        allocate.putInt(0);
        allocate.put(bArr, 0, bArr.length);
        return allocate.array();
    }

    public int A() {
        return this.t;
    }

    public int B() {
        return this.p;
    }

    public int D() {
        return this.u;
    }

    public g g() {
        return new g(2, FfmpegLibrary.b());
    }

    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.n;
    }

    public void release() {
        super.release();
        ffmpegRelease(this.r);
        this.r = 0L;
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public SimpleDecoderOutputBuffer h() {
        return new SimpleDecoderOutputBuffer(new a(this));
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Y2.a i(Throwable th) {
        return new Y2.a("Unexpected decode error", th);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Y2.a j(g gVar, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, boolean z) {
        if (z) {
            long ffmpegReset = ffmpegReset(this.r, this.o);
            this.r = ffmpegReset;
            if (ffmpegReset == 0) {
                return new Y2.a("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) k0.j(gVar.d);
        int limit = byteBuffer.limit();
        ByteBuffer init = simpleDecoderOutputBuffer.init(gVar.f, this.q);
        int ffmpegDecode = ffmpegDecode(this.r, byteBuffer, limit, init, this.q);
        if (ffmpegDecode == -2) {
            return new Y2.a("Error decoding (see logcat).");
        }
        if (ffmpegDecode == -1) {
            simpleDecoderOutputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (ffmpegDecode == 0) {
            simpleDecoderOutputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (!this.s) {
            this.t = ffmpegGetChannelCount(this.r);
            this.u = ffmpegGetSampleRate(this.r);
            if (this.u == 0 && "alac".equals(this.n)) {
                d4.a.e(this.o);
                M m = new M(this.o);
                m.U(this.o.length - 4);
                this.u = m.L();
            }
            this.s = true;
        }
        init.position(0);
        init.limit(ffmpegDecode);
        return null;
    }
}
