package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.aip;
import com.google.ads.interactivemedia.v3.internal.ait;
import com.google.ads.interactivemedia.v3.internal.aiu;
import com.google.ads.interactivemedia.v3.internal.aiv;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface be {
    be adTagParameters(Map map);

    be adTagUrl(String str);

    be adsResponse(String str);

    be apiKey(String str);

    be assetKey(String str);

    be authToken(String str);

    bf build();

    be companionSlots(Map map);

    be consentSettings(ba baVar);

    be contentDuration(Float f);

    be contentKeywords(List list);

    be contentSourceId(String str);

    be contentTitle(String str);

    be contentUrl(String str);

    be customAssetKey(String str);

    be enableNonce(Boolean bool);

    be env(String str);

    be extraParameters(Map map);

    be format(String str);

    be identifierInfo(bg bgVar);

    be isTv(Boolean bool);

    be linearAdSlotHeight(Integer num);

    be linearAdSlotWidth(Integer num);

    be liveStreamEventId(String str);

    be liveStreamPrefetchSeconds(Float f);

    be marketAppInfo(aip aipVar);

    be msParameter(String str);

    be network(String str);

    be networkCode(String str);

    be oAuthToken(String str);

    be omidAdSessionsOnStartedOnly(Boolean bool);

    be platformSignals(Map map);

    be projectNumber(String str);

    be region(String str);

    be secureSignals(List list);

    be settings(ImaSdkSettings imaSdkSettings);

    be streamActivityMonitorId(String str);

    be supportsExternalNavigation(Boolean bool);

    be supportsIconClickFallback(Boolean bool);

    be supportsNativeNetworking(Boolean bool);

    be supportsResizing(Boolean bool);

    be useQAStreamBaseUrl(Boolean bool);

    be usesCustomVideoPlayback(Boolean bool);

    be vastLoadTimeout(Float f);

    be videoContinuousPlay(aiu aiuVar);

    be videoEnvironment(cd cdVar);

    be videoId(String str);

    be videoPlayActivation(ait aitVar);

    be videoPlayMuted(aiv aivVar);
}
