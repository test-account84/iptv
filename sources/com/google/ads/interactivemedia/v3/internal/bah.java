package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bah {
    @Deprecated
    public static final bad a(byte[] bArr) throws GeneralSecurityException {
        try {
            bhw d = bhw.d(bArr, bqb.a());
            for (bhv bhvVar : d.e()) {
                if (bhvVar.b().a() == bhq.UNKNOWN_KEYMATERIAL || bhvVar.b().a() == bhq.SYMMETRIC || bhvVar.b().a() == bhq.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return bad.a(d);
        } catch (bqw unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
