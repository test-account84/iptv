package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avw implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;

    public avw(Object[] objArr) {
        this.a = objArr;
    }

    public Object readResolve() {
        return avx.m(this.a);
    }
}
