package c3;

import O2.D1;
import O2.z0;
import U2.h;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.ext.vp9.VpxDecoder;
import com.google.android.exoplayer2.ext.vp9.VpxLibrary;
import d4.a0;
import e4.A;
import e4.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends d {
    public final int Z;
    public final int e0;
    public final int f0;
    public VpxDecoder g0;

    public a(long j, Handler handler, A a, int i) {
        this(j, handler, a, i, Runtime.getRuntime().availableProcessors(), 4, 4);
    }

    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public VpxDecoder V(z0 z0Var, CryptoConfig cryptoConfig) {
        a0.a("createVpxDecoder");
        int i = z0Var.n;
        VpxDecoder vpxDecoder = new VpxDecoder(this.Z, this.e0, i != -1 ? i : 786432, cryptoConfig, this.f0);
        this.g0 = vpxDecoder;
        a0.c();
        return vpxDecoder;
    }

    public h S(String str, z0 z0Var, z0 z0Var2) {
        return new h(str, z0Var, z0Var2, 3, 0);
    }

    public final int a(z0 z0Var) {
        return (VpxLibrary.b() && "video/x-vnd.on2.vp9".equalsIgnoreCase(z0Var.m)) ? !VpxLibrary.c(z0Var.H) ? D1.a(2) : D1.b(4, 16, 0) : D1.a(0);
    }

    public String getName() {
        return "LibvpxVideoRenderer";
    }

    public void t0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        VpxDecoder vpxDecoder = this.g0;
        if (vpxDecoder == null) {
            throw new c("Failed to render output buffer to surface: decoder is not initialized.");
        }
        vpxDecoder.z(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    public void v0(int i) {
        VpxDecoder vpxDecoder = this.g0;
        if (vpxDecoder != null) {
            vpxDecoder.A(i);
        }
    }

    public a(long j, Handler handler, A a, int i, int i2, int i3, int i4) {
        super(j, handler, a, i);
        this.f0 = i2;
        this.Z = i3;
        this.e0 = i4;
    }
}
