package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfs {

    @Deprecated
    public static final bie a;

    static {
        new bfi();
        a = bie.b();
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() throws GeneralSecurityException {
        bao.l(new bfv());
        bao.o(new bfi());
        bfr.a();
        if (bci.b()) {
            return;
        }
        bao.o(new bfa());
        bfd.a();
    }
}
