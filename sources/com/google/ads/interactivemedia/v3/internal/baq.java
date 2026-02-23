package com.google.ads.interactivemedia.v3.internal;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class baq {
    static {
        Charset.forName("UTF-8");
    }

    public static bhy a(bhw bhwVar) {
        bif d = bhy.d();
        d.l(bhwVar.b());
        for (bhv bhvVar : bhwVar.e()) {
            bif f = bhx.f();
            f.i(bhvVar.b().e());
            f.j(bhvVar.f());
            f.h(bhvVar.d());
            f.g(bhvVar.a());
            d.k((bhx) f.aY());
        }
        return (bhy) d.aY();
    }

    public static void b(bhw bhwVar) throws GeneralSecurityException {
        int b = bhwVar.b();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (bhv bhvVar : bhwVar.e()) {
            if (bhvVar.f() == bhs.b) {
                if (!bhvVar.e()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(bhvVar.a())}));
                }
                if (bhvVar.d() == bid.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(bhvVar.a())}));
                }
                if (bhvVar.f() == bhs.a) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(bhvVar.a())}));
                }
                if (bhvVar.a() == b) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= bhvVar.b().a() == bhq.ASYMMETRIC_PUBLIC;
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
