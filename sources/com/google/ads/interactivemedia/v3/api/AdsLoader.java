package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface AdsLoader {

    public interface AdsLoadedListener {
        void onAdsManagerLoaded(AdsManagerLoadedEvent adsManagerLoadedEvent);
    }

    void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void addAdsLoadedListener(AdsLoadedListener adsLoadedListener);

    @Deprecated
    void contentComplete();

    ImaSdkSettings getSettings();

    void release();

    void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void removeAdsLoadedListener(AdsLoadedListener adsLoadedListener);

    void requestAds(AdsRequest adsRequest);

    String requestStream(StreamRequest streamRequest);
}
