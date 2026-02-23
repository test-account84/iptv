package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.aip;
import com.google.ads.interactivemedia.v3.internal.ait;
import com.google.ads.interactivemedia.v3.internal.aiu;
import com.google.ads.interactivemedia.v3.internal.aiv;
import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avs;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class x implements be {
    private avs adTagParameters;
    private String adTagUrl;
    private String adsResponse;
    private String apiKey;
    private String assetKey;
    private String authToken;
    private avs companionSlots;
    private ba consentSettings;
    private Float contentDuration;
    private avo contentKeywords;
    private String contentSourceId;
    private String contentTitle;
    private String contentUrl;
    private String customAssetKey;
    private Boolean enableNonce;
    private String env;
    private avs extraParameters;
    private String format;
    private bg identifierInfo;
    private Boolean isTv;
    private Integer linearAdSlotHeight;
    private Integer linearAdSlotWidth;
    private String liveStreamEventId;
    private Float liveStreamPrefetchSeconds;
    private aip marketAppInfo;
    private String msParameter;
    private String network;
    private String networkCode;
    private String oAuthToken;
    private Boolean omidAdSessionsOnStartedOnly;
    private avs platformSignals;
    private String projectNumber;
    private String region;
    private avo secureSignals;
    private ImaSdkSettings settings;
    private String streamActivityMonitorId;
    private Boolean supportsExternalNavigation;
    private Boolean supportsIconClickFallback;
    private Boolean supportsNativeNetworking;
    private Boolean supportsResizing;
    private Boolean useQAStreamBaseUrl;
    private Boolean usesCustomVideoPlayback;
    private Float vastLoadTimeout;
    private aiu videoContinuousPlay;
    private cd videoEnvironment;
    private String videoId;
    private ait videoPlayActivation;
    private aiv videoPlayMuted;

    public be adTagParameters(Map map) {
        this.adTagParameters = map == null ? null : avs.c(map);
        return this;
    }

    public be adTagUrl(String str) {
        this.adTagUrl = str;
        return this;
    }

    public be adsResponse(String str) {
        this.adsResponse = str;
        return this;
    }

    public be apiKey(String str) {
        this.apiKey = str;
        return this;
    }

    public be assetKey(String str) {
        this.assetKey = str;
        return this;
    }

    public be authToken(String str) {
        this.authToken = str;
        return this;
    }

    public bf build() {
        return new z(this.adTagUrl, this.adTagParameters, this.adsResponse, this.apiKey, this.assetKey, this.authToken, this.companionSlots, this.contentDuration, this.contentKeywords, this.contentTitle, this.contentUrl, this.contentSourceId, this.consentSettings, this.customAssetKey, this.enableNonce, this.env, this.secureSignals, this.extraParameters, this.format, this.identifierInfo, this.isTv, this.linearAdSlotWidth, this.linearAdSlotHeight, this.liveStreamEventId, this.liveStreamPrefetchSeconds, this.marketAppInfo, this.msParameter, this.network, this.videoEnvironment, this.networkCode, this.oAuthToken, this.omidAdSessionsOnStartedOnly, this.platformSignals, this.projectNumber, this.region, this.settings, this.supportsExternalNavigation, this.supportsIconClickFallback, this.supportsNativeNetworking, this.streamActivityMonitorId, this.supportsResizing, this.useQAStreamBaseUrl, this.usesCustomVideoPlayback, this.vastLoadTimeout, this.videoId, this.videoPlayActivation, this.videoContinuousPlay, this.videoPlayMuted, null);
    }

    public be companionSlots(Map map) {
        this.companionSlots = map == null ? null : avs.c(map);
        return this;
    }

    public be consentSettings(ba baVar) {
        this.consentSettings = baVar;
        return this;
    }

    public be contentDuration(Float f) {
        this.contentDuration = f;
        return this;
    }

    public be contentKeywords(List list) {
        this.contentKeywords = list == null ? null : avo.m(list);
        return this;
    }

    public be contentSourceId(String str) {
        this.contentSourceId = str;
        return this;
    }

    public be contentTitle(String str) {
        this.contentTitle = str;
        return this;
    }

    public be contentUrl(String str) {
        this.contentUrl = str;
        return this;
    }

    public be customAssetKey(String str) {
        this.customAssetKey = str;
        return this;
    }

    public be enableNonce(Boolean bool) {
        this.enableNonce = bool;
        return this;
    }

    public be env(String str) {
        this.env = str;
        return this;
    }

    public be extraParameters(Map map) {
        this.extraParameters = map == null ? null : avs.c(map);
        return this;
    }

    public be format(String str) {
        this.format = str;
        return this;
    }

    public be identifierInfo(bg bgVar) {
        this.identifierInfo = bgVar;
        return this;
    }

    public be isTv(Boolean bool) {
        this.isTv = bool;
        return this;
    }

    public be linearAdSlotHeight(Integer num) {
        this.linearAdSlotHeight = num;
        return this;
    }

    public be linearAdSlotWidth(Integer num) {
        this.linearAdSlotWidth = num;
        return this;
    }

    public be liveStreamEventId(String str) {
        this.liveStreamEventId = str;
        return this;
    }

    public be liveStreamPrefetchSeconds(Float f) {
        this.liveStreamPrefetchSeconds = f;
        return this;
    }

    public be marketAppInfo(aip aipVar) {
        this.marketAppInfo = aipVar;
        return this;
    }

    public be msParameter(String str) {
        this.msParameter = str;
        return this;
    }

    public be network(String str) {
        this.network = str;
        return this;
    }

    public be networkCode(String str) {
        this.networkCode = str;
        return this;
    }

    public be oAuthToken(String str) {
        this.oAuthToken = str;
        return this;
    }

    public be omidAdSessionsOnStartedOnly(Boolean bool) {
        this.omidAdSessionsOnStartedOnly = bool;
        return this;
    }

    public be platformSignals(Map map) {
        this.platformSignals = map == null ? null : avs.c(map);
        return this;
    }

    public be projectNumber(String str) {
        this.projectNumber = str;
        return this;
    }

    public be region(String str) {
        this.region = str;
        return this;
    }

    public be secureSignals(List list) {
        this.secureSignals = list == null ? null : avo.m(list);
        return this;
    }

    public be settings(ImaSdkSettings imaSdkSettings) {
        this.settings = imaSdkSettings;
        return this;
    }

    public be streamActivityMonitorId(String str) {
        this.streamActivityMonitorId = str;
        return this;
    }

    public be supportsExternalNavigation(Boolean bool) {
        this.supportsExternalNavigation = bool;
        return this;
    }

    public be supportsIconClickFallback(Boolean bool) {
        this.supportsIconClickFallback = bool;
        return this;
    }

    public be supportsNativeNetworking(Boolean bool) {
        this.supportsNativeNetworking = bool;
        return this;
    }

    public be supportsResizing(Boolean bool) {
        this.supportsResizing = bool;
        return this;
    }

    public be useQAStreamBaseUrl(Boolean bool) {
        this.useQAStreamBaseUrl = bool;
        return this;
    }

    public be usesCustomVideoPlayback(Boolean bool) {
        this.usesCustomVideoPlayback = bool;
        return this;
    }

    public be vastLoadTimeout(Float f) {
        this.vastLoadTimeout = f;
        return this;
    }

    public be videoContinuousPlay(aiu aiuVar) {
        this.videoContinuousPlay = aiuVar;
        return this;
    }

    public be videoEnvironment(cd cdVar) {
        this.videoEnvironment = cdVar;
        return this;
    }

    public be videoId(String str) {
        this.videoId = str;
        return this;
    }

    public be videoPlayActivation(ait aitVar) {
        this.videoPlayActivation = aitVar;
        return this;
    }

    public be videoPlayMuted(aiv aivVar) {
        this.videoPlayMuted = aivVar;
        return this;
    }
}
