package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awe implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator a;
    final Object[] b;

    public awe(Comparator comparator, Object[] objArr) {
        this.a = comparator;
        this.b = objArr;
    }

    public Object readResolve() {
        awd awdVar = new awd(this.a);
        awdVar.i(this.b);
        return awdVar.h();
    }
}
