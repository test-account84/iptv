package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bbl extends beb {
    public bbl() {
        super(bgv.class, new bbj(azo.class));
    }

    public final bea a() {
        return new bbk(this, bgw.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgv.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bgv bgvVar = (bgv) brsVar;
        bjg.b(bgvVar.a());
        if (bgvVar.d().d() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
