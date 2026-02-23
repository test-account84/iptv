package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bar {
    public static final String a;
    public static final String b;

    @Deprecated
    public static final bie c;

    static {
        new baw();
        a = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new bbf();
        b = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new bbi();
        new bbc();
        new bbo();
        new bbs();
        new bbl();
        new bbv();
        c = bie.b();
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() throws GeneralSecurityException {
        bao.l(new bat());
        bfs.a();
        bao.o(new baw());
        bao.o(new bbf());
        if (bci.b()) {
            return;
        }
        bao.o(new bbc());
        bbi.h();
        bao.o(new bbl());
        bao.o(new bbo());
        bao.o(new bbs());
        bao.o(new bbv());
    }
}
