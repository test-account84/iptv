package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface RewardedVideoAdListener extends AdListener {
    void onLoggingImpression(Ad ad);

    void onRewardedVideoClosed();

    void onRewardedVideoCompleted();
}
