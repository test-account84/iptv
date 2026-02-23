package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class tx {
    private final cx a;
    private nu b;
    private int c;
    private xv d;
    private ws e;

    public tx(cx cxVar, xv xvVar, byte[] bArr, byte[] bArr2) {
        nk nkVar = new nk();
        ws wsVar = new ws();
        this.a = cxVar;
        this.d = xvVar;
        this.b = nkVar;
        this.e = wsVar;
        this.c = 1048576;
    }

    public final ty a(ai aiVar) {
        af.s(aiVar.b);
        Object obj = aiVar.b.h;
        return new ty(aiVar, this.a, this.d, this.b.a(aiVar), this.e, this.c, null, null, null);
    }
}
