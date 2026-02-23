package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ban {
    public static oq a(String str) throws GeneralSecurityException {
        oq oqVar = (oq) bao.j().get(str);
        if (oqVar != null) {
            return oqVar;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
