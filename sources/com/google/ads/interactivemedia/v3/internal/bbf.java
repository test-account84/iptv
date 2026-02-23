package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bbf extends beb {
    public bbf() {
        super(bgp.class, new bbd(azo.class));
    }

    public static /* bridge */ /* synthetic */ bdz g(int i, int i2) {
        bif e = bgq.e();
        e.ag(i);
        return new bdz((bgq) e.aY(), i2);
    }

    public final bea a() {
        return new bbe(this, bgq.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgp.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bgp bgpVar = (bgp) brsVar;
        bjg.b(bgpVar.a());
        bjg.a(bgpVar.d().d());
    }

    public final int f() {
        return bch.b;
    }
}
