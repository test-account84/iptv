package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.player.AdProgressProvider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface BaseManager extends AdProgressProvider {
    void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void addAdEventListener(AdEvent.AdEventListener adEventListener);

    void destroy();

    void focus();

    AdProgressInfo getAdProgressInfo();

    Ad getCurrentAd();

    void init();

    void init(AdsRenderingSettings adsRenderingSettings);

    @Deprecated
    boolean isCustomPlaybackUsed();

    void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void removeAdEventListener(AdEvent.AdEventListener adEventListener);
}
