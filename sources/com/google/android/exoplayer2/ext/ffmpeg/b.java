package com.google.android.exoplayer2.ext.ffmpeg;

import O2.z0;
import Q2.B;
import Q2.I;
import Q2.X;
import Q2.m;
import Q2.z;
import android.os.Handler;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import d4.F;
import d4.a0;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends I {
    public b() {
        this((Handler) null, (z) null, new m[0]);
    }

    public String getName() {
        return "FfmpegAudioRenderer";
    }

    public int l0(z0 z0Var) {
        String str = (String) d4.a.e(z0Var.m);
        if (!FfmpegLibrary.d() || !F.o(str)) {
            return 0;
        }
        if (!FfmpegLibrary.e(str)) {
            return 1;
        }
        if (q0(z0Var, 2) || q0(z0Var, 4)) {
            return z0Var.H != 0 ? 2 : 4;
        }
        return 1;
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public FfmpegAudioDecoder U(z0 z0Var, CryptoConfig cryptoConfig) {
        a0.a("createFfmpegAudioDecoder");
        int i = z0Var.n;
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(z0Var, 16, 16, i != -1 ? i : 5760, p0(z0Var));
        a0.c();
        return ffmpegAudioDecoder;
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public z0 Y(FfmpegAudioDecoder ffmpegAudioDecoder) {
        d4.a.e(ffmpegAudioDecoder);
        return new z0.b().g0("audio/raw").J(ffmpegAudioDecoder.A()).h0(ffmpegAudioDecoder.D()).a0(ffmpegAudioDecoder.B()).G();
    }

    public final boolean p0(z0 z0Var) {
        if (!q0(z0Var, 2)) {
            return true;
        }
        if (Z(k0.i0(4, z0Var.z, z0Var.A)) != 2) {
            return false;
        }
        return !"audio/ac3".equals(z0Var.m);
    }

    public final boolean q0(z0 z0Var, int i) {
        return k0(k0.i0(i, z0Var.z, z0Var.A));
    }

    public int t() {
        return 8;
    }

    public b(Handler handler, z zVar, B b) {
        super(handler, zVar, b);
    }

    public b(Handler handler, z zVar, m... mVarArr) {
        this(handler, zVar, new X.f().j(mVarArr).g());
    }
}
