package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AdListener {
    @Benchmark
    void onAdClicked(Ad ad);

    @Benchmark
    void onAdLoaded(Ad ad);

    @Benchmark
    void onError(Ad ad, AdError adError);

    @Benchmark
    void onLoggingImpression(Ad ad);
}
