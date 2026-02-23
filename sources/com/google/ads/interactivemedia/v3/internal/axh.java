package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axh extends awy implements Serializable {
    static final axh a = new axh();
    private static final long serialVersionUID = 0;

    private axh() {
    }

    private Object readResolve() {
        return a;
    }

    public final awy a() {
        return awx.a;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        atp.k(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
