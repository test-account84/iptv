package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bdq extends beb {
    public bdq() {
        super(bhp.class, new bdp(azt.class));
    }

    public final bhq b() {
        return bhq.ASYMMETRIC_PUBLIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bhp.e(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bhp bhpVar = (bhp) brsVar;
        bjg.b(bhpVar.a());
        if (!bhpVar.j()) {
            throw new GeneralSecurityException("Missing HPKE key params.");
        }
        bdr.a(bhpVar.b());
    }
}
