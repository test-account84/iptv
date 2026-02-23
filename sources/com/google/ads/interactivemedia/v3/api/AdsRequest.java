package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.android.gms.common.internal.Hide;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface AdsRequest {
    String getAdTagUrl();

    @Hide
    String getAdsResponse();

    ContentProgressProvider getContentProgressProvider();

    String getExtraParameter(String str);

    Map getExtraParameters();

    @Hide
    SecureSignals getSecureSignals();

    Object getUserRequestContext();

    void setAdTagUrl(String str);

    void setAdWillAutoPlay(boolean z);

    void setAdWillPlayMuted(boolean z);

    void setAdsResponse(String str);

    void setContentDuration(float f);

    void setContentKeywords(List list);

    void setContentProgressProvider(ContentProgressProvider contentProgressProvider);

    void setContentTitle(String str);

    void setContentUrl(String str);

    void setContinuousPlayback(boolean z);

    void setExtraParameter(String str, String str2);

    void setLiveStreamPrefetchSeconds(float f);

    @Hide
    void setSecureSignals(SecureSignals secureSignals);

    void setUserRequestContext(Object obj);

    void setVastLoadTimeout(float f);
}
