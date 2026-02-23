package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avt implements Serializable {
    private static final long serialVersionUID = 0;
    final avs a;

    public avt(avs avsVar) {
        this.a = avsVar;
    }

    public Object readResolve() {
        return this.a.entrySet();
    }
}
