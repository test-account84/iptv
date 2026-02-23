package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class rg extends ed {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rg(Throwable th, rh rhVar) {
        super("Decoder failed: ".concat(String.valueOf(rhVar == null ? null : rhVar.a)), th);
        String str = null;
        if (cq.a >= 21 && (th instanceof MediaCodec.CodecException)) {
            str = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.a = str;
    }
}
