package com.facebook.ads.internal.api;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface InstreamVideoAdViewApi extends Ad {
    InstreamVideoAdView.InstreamVideoLoadConfigBuilder buildLoadAdConfig();

    void destroy();

    String getPlacementId();

    Bundle getSaveInstanceState();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(InstreamVideoAdView.InstreamVideoLoadAdConfig instreamVideoLoadAdConfig);

    @Deprecated
    void loadAdFromBid(String str);

    void setAdListener(InstreamVideoAdListener instreamVideoAdListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    void setIsAdLoaded(boolean z);

    boolean show();
}
