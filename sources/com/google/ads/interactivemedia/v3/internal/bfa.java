package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfa extends beb {
    public bfa() {
        super(bge.class, new bey(bag.class));
    }

    public static /* bridge */ /* synthetic */ void g(bgg bggVar) {
        m(bggVar);
    }

    public static /* bridge */ /* synthetic */ void h(int i) {
        n(i);
    }

    private static void m(bgg bggVar) throws GeneralSecurityException {
        if (bggVar.a() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (bggVar.a() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    private static void n(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final bea a() {
        return new bez(bgf.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bge.c(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        bge bgeVar = (bge) brsVar;
        bjg.b(bgeVar.a());
        n(bgeVar.e().d());
        m(bgeVar.d());
    }
}
