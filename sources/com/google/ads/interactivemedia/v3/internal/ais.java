package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.StreamManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ais implements AdsManagerLoadedEvent {
    private final AdsManager a;
    private final StreamManager b;
    private final Object c;

    public ais(AdsManager adsManager, Object obj) {
        this.a = adsManager;
        this.b = null;
        this.c = obj;
    }

    public final AdsManager getAdsManager() {
        return this.a;
    }

    public final StreamManager getStreamManager() {
        return this.b;
    }

    public final Object getUserRequestContext() {
        return this.c;
    }

    public ais(StreamManager streamManager, Object obj) {
        this.a = null;
        this.b = streamManager;
        this.c = obj;
    }
}
