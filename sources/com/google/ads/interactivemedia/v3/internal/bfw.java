package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfw {
    private HashMap a = new HashMap();

    public final bfx a() {
        if (this.a == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        bfx bfxVar = new bfx(Collections.unmodifiableMap(this.a));
        this.a = null;
        return bfxVar;
    }
}
