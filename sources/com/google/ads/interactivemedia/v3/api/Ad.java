package com.google.ads.interactivemedia.v3.api;

import com.google.android.gms.common.internal.Hide;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface Ad {
    String getAdId();

    AdPodInfo getAdPodInfo();

    String getAdSystem();

    String[] getAdWrapperCreativeIds();

    String[] getAdWrapperIds();

    String[] getAdWrapperSystems();

    String getAdvertiserName();

    List getCompanionAds();

    String getContentType();

    String getCreativeAdId();

    String getCreativeId();

    String getDealId();

    String getDescription();

    double getDuration();

    int getHeight();

    double getSkipTimeOffset();

    String getSurveyUrl();

    String getTitle();

    String getTraffickingParameters();

    Set getUiElements();

    @Deprecated
    String getUniversalAdIdRegistry();

    @Deprecated
    String getUniversalAdIdValue();

    UniversalAdId[] getUniversalAdIds();

    int getVastMediaBitrate();

    int getVastMediaHeight();

    int getVastMediaWidth();

    int getWidth();

    boolean isLinear();

    boolean isSkippable();

    @Hide
    boolean isUiDisabled();
}
