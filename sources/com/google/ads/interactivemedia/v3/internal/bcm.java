package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bcm {
    public static final String a;

    static {
        new bcl();
        a = "type.googleapis.com/google.crypto.tink.AesSivKey";
        int i = bie.a;
        try {
            bao.l(new bco());
            if (bci.b()) {
                return;
            }
            bao.o(new bcl());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
