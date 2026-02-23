package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bad {
    private final bhw a;
    private final bfx b = bfx.a;

    private bad(bhw bhwVar) {
        this.a = bhwVar;
    }

    public static final bad a(bhw bhwVar) throws GeneralSecurityException {
        if (bhwVar == null || bhwVar.a() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new bad(bhwVar);
    }

    public final Object b(Class cls) throws GeneralSecurityException {
        Class d = bao.d(cls);
        if (d == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
        }
        baq.b(this.a);
        bai baiVar = new bai(d);
        baiVar.d(this.b);
        for (bhv bhvVar : this.a.e()) {
            if (bhvVar.f() == bhs.b) {
                Object e = bao.e(bhvVar.b(), d);
                if (bhvVar.a() == this.a.b()) {
                    baiVar.b(e, bhvVar);
                } else {
                    baiVar.c(e, bhvVar);
                }
            }
        }
        return bao.i(baiVar.a(), cls);
    }

    public final String toString() {
        return baq.a(this.a).toString();
    }
}
