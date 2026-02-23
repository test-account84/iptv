package W2;

import O2.D1;
import O2.z0;
import U2.h;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.ext.av1.Gav1Decoder;
import d4.a0;
import d4.k0;
import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d extends e4.d {
    public static final int h0 = ((k0.l(1280, 64) * k0.l(720, 64)) * 6144) / 2;
    public final int Z;
    public final int e0;
    public final int f0;
    public Gav1Decoder g0;

    public d(long j, Handler handler, A a, int i) {
        this(j, handler, a, i, 0, 4, 4);
    }

    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public final Gav1Decoder V(z0 z0Var, CryptoConfig cryptoConfig) {
        a0.a("createGav1Decoder");
        int i = z0Var.n;
        if (i == -1) {
            i = h0;
        }
        Gav1Decoder gav1Decoder = new Gav1Decoder(this.Z, this.e0, i, this.f0);
        this.g0 = gav1Decoder;
        a0.c();
        return gav1Decoder;
    }

    public h S(String str, z0 z0Var, z0 z0Var2) {
        return new h(str, z0Var, z0Var2, 3, 0);
    }

    public final int a(z0 z0Var) {
        return ("video/av01".equalsIgnoreCase(z0Var.m) && c.a()) ? z0Var.H != 0 ? D1.a(2) : D1.b(4, 16, 0) : D1.a(0);
    }

    public String getName() {
        return "Libgav1VideoRenderer";
    }

    public void t0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        Gav1Decoder gav1Decoder = this.g0;
        if (gav1Decoder == null) {
            throw new b("Failed to render output buffer to surface: decoder is not initialized.");
        }
        gav1Decoder.z(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    public void v0(int i) {
        Gav1Decoder gav1Decoder = this.g0;
        if (gav1Decoder != null) {
            gav1Decoder.A(i);
        }
    }

    public d(long j, Handler handler, A a, int i, int i2, int i3, int i4) {
        super(j, handler, a, i);
        this.f0 = i2;
        this.Z = i3;
        this.e0 = i4;
    }
}
