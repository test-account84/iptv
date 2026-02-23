package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bbc extends beb {
    public bbc() {
        super(bgm.class, new bba(azo.class));
    }

    public static /* bridge */ /* synthetic */ bdz g(int i, int i2) {
        bif g = bgn.g();
        g.ak(i);
        bif e = bgo.e();
        e.aj();
        g.al((bgo) e.aY());
        return new bdz((bgn) g.aY(), i2);
    }

    public final bea a() {
        return new bbb(this, bgn.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgm.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bgm bgmVar = (bgm) brsVar;
        bjg.b(bgmVar.a());
        bjg.a(bgmVar.e().d());
        if (bgmVar.d().a() != 12 && bgmVar.d().a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
