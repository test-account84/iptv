package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.EnumSet;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InterstitialAd implements FullScreenAd {
    private final InterstitialAdApi mInterstitialAdApi;

    @Keep
    public interface InterstitialAdLoadConfigBuilder extends Ad.LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener);

        InterstitialAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet enumSet);

        InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener);
    }

    @Keep
    public interface InterstitialAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialShowAdConfig build();
    }

    @Keep
    public interface InterstitialLoadAdConfig extends Ad.LoadAdConfig {
    }

    @Keep
    public interface InterstitialShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    @Benchmark
    public InterstitialAd(Context context, String str) {
        this.mInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createInterstitialAd(context, str, this);
    }

    public void destroy() {
        this.mInterstitialAdApi.destroy();
    }

    public String getPlacementId() {
        return this.mInterstitialAdApi.getPlacementId();
    }

    public boolean isAdInvalidated() {
        return this.mInterstitialAdApi.isAdInvalidated();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mInterstitialAdApi.isAdLoaded();
    }

    public void loadAd() {
        this.mInterstitialAdApi.loadAd();
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mInterstitialAdApi.loadAdFromBid(str);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Deprecated
    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.mInterstitialAdApi.setAdListener(interstitialAdListener);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mInterstitialAdApi.setExtraHints(extraHints);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Deprecated
    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.mInterstitialAdApi.setRewardedAdListener(rewardedAdListener);
    }

    @Benchmark
    public boolean show() {
        return this.mInterstitialAdApi.show();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mInterstitialAdApi.buildLoadAdConfig();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mInterstitialAdApi.buildShowAdConfig();
    }

    public void loadAd(InterstitialLoadAdConfig interstitialLoadAdConfig) {
        this.mInterstitialAdApi.loadAd(interstitialLoadAdConfig);
    }

    @Benchmark
    @Deprecated
    public void loadAdFromBid(EnumSet enumSet, String str) {
        this.mInterstitialAdApi.loadAdFromBid(enumSet, str);
    }

    @Benchmark
    public boolean show(InterstitialShowAdConfig interstitialShowAdConfig) {
        return this.mInterstitialAdApi.show(interstitialShowAdConfig);
    }

    @Benchmark
    @Deprecated
    public void loadAd(EnumSet enumSet) {
        this.mInterstitialAdApi.loadAd(enumSet);
    }
}
