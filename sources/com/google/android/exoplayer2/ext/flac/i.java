package com.google.android.exoplayer2.ext.flac;

import O2.z0;
import Q2.B;
import Q2.I;
import Q2.m;
import Q2.z;
import android.os.Handler;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import d4.a0;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i extends I {
    public i() {
        this((Handler) null, (z) null, new m[0]);
    }

    public static z0 p0(FlacStreamMetadata flacStreamMetadata) {
        return k0.i0(k0.h0(flacStreamMetadata.bitsPerSample), flacStreamMetadata.channels, flacStreamMetadata.sampleRate);
    }

    public String getName() {
        return "LibflacAudioRenderer";
    }

    public int l0(z0 z0Var) {
        if (!h.isAvailable() || !"audio/flac".equalsIgnoreCase(z0Var.m)) {
            return 0;
        }
        if (k0(z0Var.o.isEmpty() ? k0.i0(2, z0Var.z, z0Var.A) : p0(new FlacStreamMetadata((byte[]) z0Var.o.get(0), 8)))) {
            return z0Var.H != 0 ? 2 : 4;
        }
        return 1;
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d U(z0 z0Var, CryptoConfig cryptoConfig) {
        a0.a("createFlacDecoder");
        d dVar = new d(16, 16, z0Var.n, z0Var.o);
        a0.c();
        return dVar;
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public z0 Y(d dVar) {
        return p0(dVar.z());
    }

    public i(Handler handler, z zVar, B b) {
        super(handler, zVar, b);
    }

    public i(Handler handler, z zVar, m... mVarArr) {
        super(handler, zVar, mVarArr);
    }
}
