package com.google.ads.interactivemedia.v3.impl.data;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.internal.aie;
import com.google.ads.interactivemedia.v3.internal.aip;
import com.google.ads.interactivemedia.v3.internal.ait;
import com.google.ads.interactivemedia.v3.internal.aiu;
import com.google.ads.interactivemedia.v3.internal.aiv;
import com.google.ads.interactivemedia.v3.internal.aiw;
import com.google.ads.interactivemedia.v3.internal.ajb;
import com.google.ads.interactivemedia.v3.internal.akr;
import com.google.ads.interactivemedia.v3.internal.ald;
import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avq;
import com.google.ads.interactivemedia.v3.internal.avs;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bf {
    public static be builder() {
        return new x();
    }

    public static bf create(AdsRequest adsRequest, String str, ba baVar, List list, Map map, String str2, cd cdVar, ImaSdkSettings imaSdkSettings, aip aipVar, boolean z, bg bgVar, AdDisplayContainer adDisplayContainer) {
        String adTagUrl = adsRequest.getAdTagUrl();
        String adsResponse = adsRequest.getAdsResponse();
        Map extraParameters = adsRequest.getExtraParameters();
        aiw aiwVar = (aiw) adsRequest;
        ait a = aiwVar.a();
        aiv c = aiwVar.c();
        aiu b = aiwVar.b();
        Float d = aiwVar.d();
        List i = aiwVar.i();
        String g = aiwVar.g();
        String h = aiwVar.h();
        Float f = aiwVar.f();
        Float e = aiwVar.e();
        Map companionSlots = getCompanionSlots((aie) adDisplayContainer);
        ViewGroup adContainer = adDisplayContainer.getAdContainer();
        be builder = builder();
        builder.adTagUrl(adTagUrl);
        builder.adsResponse(adsResponse);
        builder.companionSlots(companionSlots);
        builder.consentSettings(baVar);
        builder.contentDuration(d);
        builder.contentKeywords(i);
        builder.contentTitle(g);
        builder.contentUrl(h);
        builder.env(str);
        builder.secureSignals(list);
        builder.extraParameters(extraParameters);
        builder.identifierInfo(bgVar);
        Boolean valueOf = Boolean.valueOf(z);
        builder.isTv(valueOf);
        builder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        builder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        builder.liveStreamPrefetchSeconds(e);
        builder.marketAppInfo(aipVar);
        builder.network(str2);
        builder.videoEnvironment(cdVar);
        builder.omidAdSessionsOnStartedOnly(Boolean.TRUE);
        builder.platformSignals(map);
        builder.settings(imaSdkSettings);
        builder.supportsExternalNavigation(Boolean.valueOf(!z));
        builder.supportsIconClickFallback(valueOf);
        builder.supportsNativeNetworking(Boolean.valueOf(supportsNativeNetworkRequests()));
        builder.supportsResizing(Boolean.valueOf(adDisplayContainer.getPlayer() instanceof ResizablePlayer));
        builder.usesCustomVideoPlayback(Boolean.valueOf(!(adDisplayContainer.getPlayer() instanceof ald)));
        builder.vastLoadTimeout(f);
        builder.videoContinuousPlay(b);
        builder.videoPlayActivation(a);
        builder.videoPlayMuted(c);
        return builder.build();
    }

    public static bf createFromStreamRequest(StreamRequest streamRequest, String str, ba baVar, List list, Map map, String str2, cd cdVar, ImaSdkSettings imaSdkSettings, aip aipVar, boolean z, String str3, bg bgVar, StreamDisplayContainer streamDisplayContainer) {
        Map companionSlots = getCompanionSlots((akr) streamDisplayContainer);
        ViewGroup adContainer = streamDisplayContainer.getAdContainer();
        String str4 = streamRequest.getFormat() == StreamRequest.StreamFormat.DASH ? "dash" : "hls";
        be builder = builder();
        builder.adTagParameters(streamRequest.getAdTagParameters());
        builder.apiKey(streamRequest.getApiKey());
        builder.assetKey(streamRequest.getAssetKey());
        builder.authToken(streamRequest.getAuthToken());
        builder.companionSlots(companionSlots);
        builder.consentSettings(baVar);
        builder.contentSourceId(streamRequest.getContentSourceId());
        builder.contentUrl(streamRequest.getContentUrl());
        builder.customAssetKey(streamRequest.getCustomAssetKey());
        builder.enableNonce(Boolean.valueOf(streamRequest.getEnableNonce()));
        builder.env(str);
        builder.secureSignals(list);
        builder.format(str4);
        builder.identifierInfo(bgVar);
        Boolean valueOf = Boolean.valueOf(z);
        builder.isTv(valueOf);
        builder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        builder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        builder.liveStreamEventId(streamRequest.getLiveStreamEventId());
        builder.marketAppInfo(aipVar);
        builder.msParameter(str3);
        builder.network(str2);
        builder.videoEnvironment(cdVar);
        builder.networkCode(streamRequest.getNetworkCode());
        builder.oAuthToken(streamRequest.getOAuthToken());
        builder.omidAdSessionsOnStartedOnly(Boolean.TRUE);
        builder.platformSignals(map);
        builder.projectNumber(streamRequest.getProjectNumber());
        builder.region(streamRequest.getRegion());
        builder.settings(imaSdkSettings);
        builder.streamActivityMonitorId(streamRequest.getStreamActivityMonitorId());
        builder.supportsExternalNavigation(Boolean.valueOf(!z));
        builder.supportsIconClickFallback(valueOf);
        builder.supportsNativeNetworking(Boolean.valueOf(supportsNativeNetworkRequests()));
        builder.supportsResizing(Boolean.valueOf(streamDisplayContainer.getVideoStreamPlayer() instanceof ResizablePlayer));
        builder.useQAStreamBaseUrl(streamRequest.getUseQAStreamBaseUrl());
        builder.videoId(streamRequest.getVideoId());
        return builder.build();
    }

    private static Map getCompanionSlots(ajb ajbVar) {
        Map a = ajbVar.a();
        if (a == null || a.isEmpty()) {
            return null;
        }
        avq avqVar = new avq();
        for (String str : a.keySet()) {
            CompanionAdSlot companionAdSlot = (CompanionAdSlot) a.get(str);
            avqVar.a(str, companionAdSlot.getWidth() + "x" + companionAdSlot.getHeight());
        }
        return avqVar.b();
    }

    private static boolean supportsNativeNetworkRequests() {
        return true;
    }

    public abstract avs adTagParameters();

    public abstract String adTagUrl();

    public abstract String adsResponse();

    public abstract String apiKey();

    public abstract String assetKey();

    public abstract String authToken();

    public abstract avs companionSlots();

    public abstract ba consentSettings();

    public abstract Float contentDuration();

    public abstract avo contentKeywords();

    public abstract String contentSourceId();

    public abstract String contentTitle();

    public abstract String contentUrl();

    public abstract String customAssetKey();

    public abstract Boolean enableNonce();

    public abstract String env();

    public abstract avs extraParameters();

    public abstract String format();

    public abstract bg identifierInfo();

    public abstract Boolean isTv();

    public abstract Integer linearAdSlotHeight();

    public abstract Integer linearAdSlotWidth();

    public abstract String liveStreamEventId();

    public abstract Float liveStreamPrefetchSeconds();

    public abstract aip marketAppInfo();

    public abstract String msParameter();

    public abstract String network();

    public abstract String networkCode();

    public abstract String oAuthToken();

    public abstract Boolean omidAdSessionsOnStartedOnly();

    public abstract avs platformSignals();

    public abstract String projectNumber();

    public abstract String region();

    public abstract avo secureSignals();

    public abstract ImaSdkSettings settings();

    public abstract String streamActivityMonitorId();

    public abstract Boolean supportsExternalNavigation();

    public abstract Boolean supportsIconClickFallback();

    public abstract Boolean supportsNativeNetworking();

    public abstract Boolean supportsResizing();

    public abstract Boolean useQAStreamBaseUrl();

    public abstract Boolean usesCustomVideoPlayback();

    public abstract Float vastLoadTimeout();

    public abstract aiu videoContinuousPlay();

    public abstract cd videoEnvironment();

    public abstract String videoId();

    public abstract ait videoPlayActivation();

    public abstract aiv videoPlayMuted();
}
