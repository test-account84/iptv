package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bfv implements bam {
    private static final byte[] a;

    static {
        Logger.getLogger(bfv.class.getName());
        a = new byte[]{0};
    }

    public static /* bridge */ /* synthetic */ byte[] d() {
        return a;
    }

    public final Class a() {
        return bag.class;
    }

    public final Class b() {
        return bag.class;
    }

    public final /* bridge */ /* synthetic */ Object c(bal balVar) throws GeneralSecurityException {
        Iterator it = balVar.d().iterator();
        while (it.hasNext()) {
            for (baj bajVar : (List) it.next()) {
                if (bajVar.b() instanceof bft) {
                    bft bftVar = (bft) bajVar.b();
                    bjj b = bjj.b(bajVar.e());
                    if (!b.equals(bftVar.b())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + String.valueOf(bftVar.c()) + " has wrong output prefix (" + bftVar.b().toString() + ") instead of (" + b.toString() + ")");
                    }
                }
            }
        }
        return new bfu(balVar);
    }
}
