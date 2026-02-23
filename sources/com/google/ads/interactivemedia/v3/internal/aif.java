package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aif implements AdErrorEvent {
    private final AdError a;
    private final Object b;

    public aif(AdError adError) {
        this.a = adError;
        this.b = null;
    }

    public final AdError getError() {
        return this.a;
    }

    public final Object getUserRequestContext() {
        return this.b;
    }

    public aif(AdError adError, Object obj) {
        this.a = adError;
        this.b = obj;
    }
}
