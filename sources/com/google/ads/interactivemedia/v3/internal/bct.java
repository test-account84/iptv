package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bct extends beb {
    public bct() {
        super(bhc.class, new bcs(azt.class));
    }

    public final bhq b() {
        return bhq.ASYMMETRIC_PUBLIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bhc.e(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bhc bhcVar = (bhc) brsVar;
        bjg.b(bhcVar.a());
        bda.a(bhcVar.b());
    }
}
