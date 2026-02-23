package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class rj extends Exception {
    public final String a;
    public final boolean b;
    public final rh c;
    public final String d;

    /* JADX WARN: Illegal instructions before constructor call */
    public rj(s sVar, Throwable th, boolean z, int i) {
        String valueOf = String.valueOf(sVar);
        this("Decoder init failed: [" + i + "], " + valueOf, th, sVar.l, z, null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i));
    }

    public static /* bridge */ /* synthetic */ rj a(rj rjVar, rj rjVar2) {
        return new rj(rjVar.getMessage(), rjVar.getCause(), rjVar.a, rjVar.b, rjVar.c, rjVar.d);
    }

    public rj(s sVar, Throwable th, boolean z, rh rhVar) {
        this("Decoder init failed: " + rhVar.a + ", " + String.valueOf(sVar), th, sVar.l, z, rhVar, (cq.a < 21 || !(th instanceof MediaCodec.CodecException)) ? null : ((MediaCodec.CodecException) th).getDiagnosticInfo());
    }

    private rj(String str, Throwable th, String str2, boolean z, rh rhVar, String str3) {
        super(str, th);
        this.a = str2;
        this.b = z;
        this.c = rhVar;
        this.d = str3;
    }
}
