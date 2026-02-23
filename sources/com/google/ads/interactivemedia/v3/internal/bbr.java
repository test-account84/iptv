package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bbr extends bea {
    final /* synthetic */ bbs a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbr(bbs bbsVar, Class cls) {
        super(cls);
        this.a = bbsVar;
    }

    public final /* bridge */ /* synthetic */ brs a(brs brsVar) throws GeneralSecurityException {
        bif g = bib.g();
        g.c((bic) brsVar);
        g.d();
        return (bib) g.aY();
    }

    public final /* bridge */ /* synthetic */ brs b(bpb bpbVar) throws bqw {
        return bic.d(bpbVar, bqb.a());
    }

    public final /* bridge */ /* synthetic */ void d(brs brsVar) throws GeneralSecurityException {
        bic bicVar = (bic) brsVar;
        if (bicVar.e().isEmpty() || !bicVar.f()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
