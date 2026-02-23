package a3;

import O2.z0;
import Q2.B;
import Q2.I;
import Q2.m;
import Q2.z;
import android.os.Handler;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.ext.opus.OpusDecoder;
import com.google.android.exoplayer2.ext.opus.OpusLibrary;
import d4.a0;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends I {
    public a() {
        this((Handler) null, (z) null, new m[0]);
    }

    public String getName() {
        return "LibopusAudioRenderer";
    }

    public int l0(z0 z0Var) {
        boolean c = OpusLibrary.c(z0Var.H);
        if (!OpusLibrary.b() || !"audio/opus".equalsIgnoreCase(z0Var.m)) {
            return 0;
        }
        if (k0(k0.i0(2, z0Var.z, z0Var.A))) {
            return !c ? 2 : 4;
        }
        return 1;
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final OpusDecoder U(z0 z0Var, CryptoConfig cryptoConfig) {
        a0.a("createOpusDecoder");
        boolean z = Z(k0.i0(4, z0Var.z, z0Var.A)) == 2;
        int i = z0Var.n;
        OpusDecoder opusDecoder = new OpusDecoder(16, 16, i != -1 ? i : 5760, z0Var.o, cryptoConfig, z);
        opusDecoder.z(o0());
        a0.c();
        return opusDecoder;
    }

    public boolean o0() {
        return false;
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public final z0 Y(OpusDecoder opusDecoder) {
        return k0.i0(opusDecoder.n ? 4 : 2, opusDecoder.o, 48000);
    }

    public a(Handler handler, z zVar, B b) {
        super(handler, zVar, b);
    }

    public a(Handler handler, z zVar, m... mVarArr) {
        super(handler, zVar, mVarArr);
    }
}
