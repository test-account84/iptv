package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bcu {

    @Deprecated
    public static final bie a;

    static {
        new bct();
        new bcr();
        a = bie.b();
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() throws GeneralSecurityException {
        bao.l(new bcw());
        bao.l(new bcz());
        bar.a();
        if (bci.b()) {
            return;
        }
        bao.n(new bcr(), new bct());
        bao.n(new bdo(), new bdq());
    }
}
