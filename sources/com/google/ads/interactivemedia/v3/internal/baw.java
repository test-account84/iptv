package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class baw extends beb {
    public baw() {
        super(bgh.class, new bau(azo.class));
    }

    public static /* bridge */ /* synthetic */ bdz g(int i, int i2, int i3, int i4) {
        bif h = bgk.h();
        bif e = bgl.e();
        e.ap();
        h.ar((bgl) e.aY());
        h.aq(i);
        bgk bgkVar = (bgk) h.aY();
        bif h2 = bhh.h();
        bif g = bhi.g();
        g.D(i3);
        g.C(i2);
        h2.F((bhi) g.aY());
        h2.E(32);
        bhh bhhVar = (bhh) h2.aY();
        bif g2 = bgi.g();
        g2.av(bgkVar);
        g2.aw(bhhVar);
        return new bdz((bgi) g2.aY(), i4);
    }

    public final bea a() {
        return new bav(this, bgi.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgh.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bgh bghVar = (bgh) brsVar;
        bjg.b(bghVar.a());
        new baz().h(bghVar.d());
        new bfi();
        bfi.h(bghVar.e());
    }

    public final int f() {
        return bch.b;
    }
}
