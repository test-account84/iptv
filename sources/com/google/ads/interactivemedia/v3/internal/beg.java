package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class beg {
    public static final bfy a = new bef(null);

    public static bgc a(bal balVar) {
        bac bacVar;
        bga bgaVar = new bga();
        bgaVar.b(balVar.b());
        Iterator it = balVar.d().iterator();
        while (it.hasNext()) {
            for (baj bajVar : (List) it.next()) {
                int f = bajVar.f();
                int i = f - 2;
                int i2 = bhs.a;
                if (f == 0) {
                    throw null;
                }
                if (i == 1) {
                    bacVar = bac.a;
                } else if (i == 2) {
                    bacVar = bac.b;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    bacVar = bac.c;
                }
                bgaVar.d(bacVar, bajVar.a(), bajVar.g());
            }
        }
        if (balVar.a() != null) {
            bgaVar.c(balVar.a().a());
        }
        try {
            return bgaVar.a();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
