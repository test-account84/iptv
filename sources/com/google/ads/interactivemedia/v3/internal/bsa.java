package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsa {
    private static final bsa a = new bsa();
    private final ConcurrentMap c = new ConcurrentHashMap();
    private final bsj b = new brl();

    private bsa() {
    }

    public static bsa a() {
        return a;
    }

    public final bsi b(Class cls) {
        bqu.j(cls, "messageType");
        bsi bsiVar = (bsi) this.c.get(cls);
        if (bsiVar == null) {
            bsiVar = this.b.a(cls);
            bqu.j(cls, "messageType");
            bqu.j(bsiVar, "schema");
            bsi bsiVar2 = (bsi) this.c.putIfAbsent(cls, bsiVar);
            if (bsiVar2 != null) {
                return bsiVar2;
            }
        }
        return bsiVar;
    }

    public final bsi c(Object obj) {
        return b(obj.getClass());
    }
}
