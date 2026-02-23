package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardedAdListener;
import java.util.EnumSet;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface InterstitialAdApi extends FullScreenAd {
    InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig();

    InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig();

    boolean isAdLoaded();

    void loadAd(InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig);

    @Deprecated
    void loadAd(EnumSet enumSet);

    @Deprecated
    void loadAdFromBid(EnumSet enumSet, String str);

    @Deprecated
    void setAdListener(InterstitialAdListener interstitialAdListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    @Deprecated
    void setRewardedAdListener(RewardedAdListener rewardedAdListener);

    boolean show();

    boolean show(InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig);
}
