package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bfg extends beo {
    public bfg(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object a(brs brsVar) throws GeneralSecurityException {
        bhg bhgVar = (bhg) brsVar;
        int e = bhgVar.e().e();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bhgVar.f().B(), "HMAC");
        int a = bhgVar.e().a();
        int i = e - 2;
        int i2 = bhf.a;
        if (e == 0) {
            throw null;
        }
        if (i == 1) {
            return new bjd(new bjc("HMACSHA1", secretKeySpec), a);
        }
        if (i == 2) {
            return new bjd(new bjc("HMACSHA384", secretKeySpec), a);
        }
        if (i == 3) {
            return new bjd(new bjc("HMACSHA256", secretKeySpec), a);
        }
        if (i == 4) {
            return new bjd(new bjc("HMACSHA512", secretKeySpec), a);
        }
        if (i == 5) {
            return new bjd(new bjc("HMACSHA224", secretKeySpec), a);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
