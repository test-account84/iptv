package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bdo extends bep {
    public bdo() {
        super(bho.class, new bdm(azs.class));
    }

    public static /* bridge */ /* synthetic */ bdz g(int i, int i2, int i3, int i4) {
        bif j = bhn.j();
        j.A(i);
        j.z(i2);
        j.y(i3);
        bhn bhnVar = (bhn) j.aY();
        bif e = bhm.e();
        e.B(bhnVar);
        return new bdz((bhm) e.aY(), i4);
    }

    public final bea a() {
        return new bdn(bhm.class);
    }

    public final bhq b() {
        return bhq.ASYMMETRIC_PRIVATE;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bho.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bho bhoVar = (bho) brsVar;
        if (bhoVar.e().A()) {
            throw new GeneralSecurityException("Private key is empty.");
        }
        if (!bhoVar.h()) {
            throw new GeneralSecurityException("Missing public key.");
        }
        bjg.b(bhoVar.a());
        bdr.a(bhoVar.d().b());
    }
}
