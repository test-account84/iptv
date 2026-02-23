package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awx extends awy implements Serializable {
    static final awx a = new awx();
    private static final long serialVersionUID = 0;

    private awx() {
    }

    private Object readResolve() {
        return a;
    }

    public final awy a() {
        return axh.a;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        atp.k(comparable);
        atp.k(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
