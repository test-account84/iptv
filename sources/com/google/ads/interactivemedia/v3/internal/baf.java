package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class baf {
    private static final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public static bae a(String str) throws GeneralSecurityException {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            bae baeVar = (bae) it.next();
            if (baeVar.a()) {
                return baeVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
