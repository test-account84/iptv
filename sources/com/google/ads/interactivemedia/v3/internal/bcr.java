package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bcr extends bep {
    private static final byte[] a = new byte[0];

    public bcr() {
        super(bhb.class, new bcp(azs.class));
    }

    public static /* bridge */ /* synthetic */ byte[] g() {
        return a;
    }

    public static /* bridge */ /* synthetic */ bdz h(int i, int i2, int i3, oq oqVar, byte[] bArr, int i4) {
        bif e = bgz.e();
        bif j = bhd.j();
        j.K(i);
        j.L(i2);
        j.J(bpb.t(bArr));
        bhd bhdVar = (bhd) j.aY();
        bif j2 = bht.j();
        j2.n(oqVar.e());
        j2.o(bpb.t(oqVar.f()));
        int g = oqVar.g() - 1;
        j2.m(g != 0 ? g != 1 ? g != 2 ? bid.CRUNCHY : bid.RAW : bid.LEGACY : bid.TINK);
        bht bhtVar = (bht) j2.aY();
        bif e2 = bgy.e();
        e2.X(bhtVar);
        bgy bgyVar = (bgy) e2.aY();
        bif j3 = bha.j();
        j3.U(bhdVar);
        j3.T(bgyVar);
        j3.V(i3);
        e.W((bha) j3.aY());
        return new bdz((bgz) e.aY(), i4);
    }

    public final bea a() {
        return new bcq(this, bgz.class);
    }

    public final bhq b() {
        return bhq.ASYMMETRIC_PRIVATE;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bhb.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bhb bhbVar = (bhb) brsVar;
        if (bhbVar.e().A()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        bjg.b(bhbVar.a());
        bda.a(bhbVar.d().b());
    }
}
