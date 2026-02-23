package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.aip;
import com.google.ads.interactivemedia.v3.internal.ait;
import com.google.ads.interactivemedia.v3.internal.aiu;
import com.google.ads.interactivemedia.v3.internal.aiv;
import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avs;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class z extends bf {
    private final avs adTagParameters;
    private final String adTagUrl;
    private final String adsResponse;
    private final String apiKey;
    private final String assetKey;
    private final String authToken;
    private final avs companionSlots;
    private final ba consentSettings;
    private final Float contentDuration;
    private final avo contentKeywords;
    private final String contentSourceId;
    private final String contentTitle;
    private final String contentUrl;
    private final String customAssetKey;
    private final Boolean enableNonce;
    private final String env;
    private final avs extraParameters;
    private final String format;
    private final bg identifierInfo;
    private final Boolean isTv;
    private final Integer linearAdSlotHeight;
    private final Integer linearAdSlotWidth;
    private final String liveStreamEventId;
    private final Float liveStreamPrefetchSeconds;
    private final aip marketAppInfo;
    private final String msParameter;
    private final String network;
    private final String networkCode;
    private final String oAuthToken;
    private final Boolean omidAdSessionsOnStartedOnly;
    private final avs platformSignals;
    private final String projectNumber;
    private final String region;
    private final avo secureSignals;
    private final ImaSdkSettings settings;
    private final String streamActivityMonitorId;
    private final Boolean supportsExternalNavigation;
    private final Boolean supportsIconClickFallback;
    private final Boolean supportsNativeNetworking;
    private final Boolean supportsResizing;
    private final Boolean useQAStreamBaseUrl;
    private final Boolean usesCustomVideoPlayback;
    private final Float vastLoadTimeout;
    private final aiu videoContinuousPlay;
    private final cd videoEnvironment;
    private final String videoId;
    private final ait videoPlayActivation;
    private final aiv videoPlayMuted;

    private z(String str, avs avsVar, String str2, String str3, String str4, String str5, avs avsVar2, Float f, avo avoVar, String str6, String str7, String str8, ba baVar, String str9, Boolean bool, String str10, avo avoVar2, avs avsVar3, String str11, bg bgVar, Boolean bool2, Integer num, Integer num2, String str12, Float f2, aip aipVar, String str13, String str14, cd cdVar, String str15, String str16, Boolean bool3, avs avsVar4, String str17, String str18, ImaSdkSettings imaSdkSettings, Boolean bool4, Boolean bool5, Boolean bool6, String str19, Boolean bool7, Boolean bool8, Boolean bool9, Float f3, String str20, ait aitVar, aiu aiuVar, aiv aivVar) {
        this.adTagUrl = str;
        this.adTagParameters = avsVar;
        this.adsResponse = str2;
        this.apiKey = str3;
        this.assetKey = str4;
        this.authToken = str5;
        this.companionSlots = avsVar2;
        this.contentDuration = f;
        this.contentKeywords = avoVar;
        this.contentTitle = str6;
        this.contentUrl = str7;
        this.contentSourceId = str8;
        this.consentSettings = baVar;
        this.customAssetKey = str9;
        this.enableNonce = bool;
        this.env = str10;
        this.secureSignals = avoVar2;
        this.extraParameters = avsVar3;
        this.format = str11;
        this.identifierInfo = bgVar;
        this.isTv = bool2;
        this.linearAdSlotWidth = num;
        this.linearAdSlotHeight = num2;
        this.liveStreamEventId = str12;
        this.liveStreamPrefetchSeconds = f2;
        this.marketAppInfo = aipVar;
        this.msParameter = str13;
        this.network = str14;
        this.videoEnvironment = cdVar;
        this.networkCode = str15;
        this.oAuthToken = str16;
        this.omidAdSessionsOnStartedOnly = bool3;
        this.platformSignals = avsVar4;
        this.projectNumber = str17;
        this.region = str18;
        this.settings = imaSdkSettings;
        this.supportsExternalNavigation = bool4;
        this.supportsIconClickFallback = bool5;
        this.supportsNativeNetworking = bool6;
        this.streamActivityMonitorId = str19;
        this.supportsResizing = bool7;
        this.useQAStreamBaseUrl = bool8;
        this.usesCustomVideoPlayback = bool9;
        this.vastLoadTimeout = f3;
        this.videoId = str20;
        this.videoPlayActivation = aitVar;
        this.videoContinuousPlay = aiuVar;
        this.videoPlayMuted = aivVar;
    }

    public avs adTagParameters() {
        return this.adTagParameters;
    }

    public String adTagUrl() {
        return this.adTagUrl;
    }

    public String adsResponse() {
        return this.adsResponse;
    }

    public String apiKey() {
        return this.apiKey;
    }

    public String assetKey() {
        return this.assetKey;
    }

    public String authToken() {
        return this.authToken;
    }

    public avs companionSlots() {
        return this.companionSlots;
    }

    public ba consentSettings() {
        return this.consentSettings;
    }

    public Float contentDuration() {
        return this.contentDuration;
    }

    public avo contentKeywords() {
        return this.contentKeywords;
    }

    public String contentSourceId() {
        return this.contentSourceId;
    }

    public String contentTitle() {
        return this.contentTitle;
    }

    public String contentUrl() {
        return this.contentUrl;
    }

    public String customAssetKey() {
        return this.customAssetKey;
    }

    public Boolean enableNonce() {
        return this.enableNonce;
    }

    public String env() {
        return this.env;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bf) {
            bf bfVar = (bf) obj;
            String str = this.adTagUrl;
            if (str != null ? str.equals(bfVar.adTagUrl()) : bfVar.adTagUrl() == null) {
                avs avsVar = this.adTagParameters;
                if (avsVar != null ? avsVar.equals(bfVar.adTagParameters()) : bfVar.adTagParameters() == null) {
                    String str2 = this.adsResponse;
                    if (str2 != null ? str2.equals(bfVar.adsResponse()) : bfVar.adsResponse() == null) {
                        String str3 = this.apiKey;
                        if (str3 != null ? str3.equals(bfVar.apiKey()) : bfVar.apiKey() == null) {
                            String str4 = this.assetKey;
                            if (str4 != null ? str4.equals(bfVar.assetKey()) : bfVar.assetKey() == null) {
                                String str5 = this.authToken;
                                if (str5 != null ? str5.equals(bfVar.authToken()) : bfVar.authToken() == null) {
                                    avs avsVar2 = this.companionSlots;
                                    if (avsVar2 != null ? avsVar2.equals(bfVar.companionSlots()) : bfVar.companionSlots() == null) {
                                        Float f = this.contentDuration;
                                        if (f != null ? f.equals(bfVar.contentDuration()) : bfVar.contentDuration() == null) {
                                            avo avoVar = this.contentKeywords;
                                            if (avoVar != null ? avoVar.equals(bfVar.contentKeywords()) : bfVar.contentKeywords() == null) {
                                                String str6 = this.contentTitle;
                                                if (str6 != null ? str6.equals(bfVar.contentTitle()) : bfVar.contentTitle() == null) {
                                                    String str7 = this.contentUrl;
                                                    if (str7 != null ? str7.equals(bfVar.contentUrl()) : bfVar.contentUrl() == null) {
                                                        String str8 = this.contentSourceId;
                                                        if (str8 != null ? str8.equals(bfVar.contentSourceId()) : bfVar.contentSourceId() == null) {
                                                            ba baVar = this.consentSettings;
                                                            if (baVar != null ? baVar.equals(bfVar.consentSettings()) : bfVar.consentSettings() == null) {
                                                                String str9 = this.customAssetKey;
                                                                if (str9 != null ? str9.equals(bfVar.customAssetKey()) : bfVar.customAssetKey() == null) {
                                                                    Boolean bool = this.enableNonce;
                                                                    if (bool != null ? bool.equals(bfVar.enableNonce()) : bfVar.enableNonce() == null) {
                                                                        String str10 = this.env;
                                                                        if (str10 != null ? str10.equals(bfVar.env()) : bfVar.env() == null) {
                                                                            avo avoVar2 = this.secureSignals;
                                                                            if (avoVar2 != null ? avoVar2.equals(bfVar.secureSignals()) : bfVar.secureSignals() == null) {
                                                                                avs avsVar3 = this.extraParameters;
                                                                                if (avsVar3 != null ? avsVar3.equals(bfVar.extraParameters()) : bfVar.extraParameters() == null) {
                                                                                    String str11 = this.format;
                                                                                    if (str11 != null ? str11.equals(bfVar.format()) : bfVar.format() == null) {
                                                                                        bg bgVar = this.identifierInfo;
                                                                                        if (bgVar != null ? bgVar.equals(bfVar.identifierInfo()) : bfVar.identifierInfo() == null) {
                                                                                            Boolean bool2 = this.isTv;
                                                                                            if (bool2 != null ? bool2.equals(bfVar.isTv()) : bfVar.isTv() == null) {
                                                                                                Integer num = this.linearAdSlotWidth;
                                                                                                if (num != null ? num.equals(bfVar.linearAdSlotWidth()) : bfVar.linearAdSlotWidth() == null) {
                                                                                                    Integer num2 = this.linearAdSlotHeight;
                                                                                                    if (num2 != null ? num2.equals(bfVar.linearAdSlotHeight()) : bfVar.linearAdSlotHeight() == null) {
                                                                                                        String str12 = this.liveStreamEventId;
                                                                                                        if (str12 != null ? str12.equals(bfVar.liveStreamEventId()) : bfVar.liveStreamEventId() == null) {
                                                                                                            Float f2 = this.liveStreamPrefetchSeconds;
                                                                                                            if (f2 != null ? f2.equals(bfVar.liveStreamPrefetchSeconds()) : bfVar.liveStreamPrefetchSeconds() == null) {
                                                                                                                aip aipVar = this.marketAppInfo;
                                                                                                                if (aipVar != null ? aipVar.equals(bfVar.marketAppInfo()) : bfVar.marketAppInfo() == null) {
                                                                                                                    String str13 = this.msParameter;
                                                                                                                    if (str13 != null ? str13.equals(bfVar.msParameter()) : bfVar.msParameter() == null) {
                                                                                                                        String str14 = this.network;
                                                                                                                        if (str14 != null ? str14.equals(bfVar.network()) : bfVar.network() == null) {
                                                                                                                            cd cdVar = this.videoEnvironment;
                                                                                                                            if (cdVar != null ? cdVar.equals(bfVar.videoEnvironment()) : bfVar.videoEnvironment() == null) {
                                                                                                                                String str15 = this.networkCode;
                                                                                                                                if (str15 != null ? str15.equals(bfVar.networkCode()) : bfVar.networkCode() == null) {
                                                                                                                                    String str16 = this.oAuthToken;
                                                                                                                                    if (str16 != null ? str16.equals(bfVar.oAuthToken()) : bfVar.oAuthToken() == null) {
                                                                                                                                        Boolean bool3 = this.omidAdSessionsOnStartedOnly;
                                                                                                                                        if (bool3 != null ? bool3.equals(bfVar.omidAdSessionsOnStartedOnly()) : bfVar.omidAdSessionsOnStartedOnly() == null) {
                                                                                                                                            avs avsVar4 = this.platformSignals;
                                                                                                                                            if (avsVar4 != null ? avsVar4.equals(bfVar.platformSignals()) : bfVar.platformSignals() == null) {
                                                                                                                                                String str17 = this.projectNumber;
                                                                                                                                                if (str17 != null ? str17.equals(bfVar.projectNumber()) : bfVar.projectNumber() == null) {
                                                                                                                                                    String str18 = this.region;
                                                                                                                                                    if (str18 != null ? str18.equals(bfVar.region()) : bfVar.region() == null) {
                                                                                                                                                        ImaSdkSettings imaSdkSettings = this.settings;
                                                                                                                                                        if (imaSdkSettings != null ? imaSdkSettings.equals(bfVar.settings()) : bfVar.settings() == null) {
                                                                                                                                                            Boolean bool4 = this.supportsExternalNavigation;
                                                                                                                                                            if (bool4 != null ? bool4.equals(bfVar.supportsExternalNavigation()) : bfVar.supportsExternalNavigation() == null) {
                                                                                                                                                                Boolean bool5 = this.supportsIconClickFallback;
                                                                                                                                                                if (bool5 != null ? bool5.equals(bfVar.supportsIconClickFallback()) : bfVar.supportsIconClickFallback() == null) {
                                                                                                                                                                    Boolean bool6 = this.supportsNativeNetworking;
                                                                                                                                                                    if (bool6 != null ? bool6.equals(bfVar.supportsNativeNetworking()) : bfVar.supportsNativeNetworking() == null) {
                                                                                                                                                                        String str19 = this.streamActivityMonitorId;
                                                                                                                                                                        if (str19 != null ? str19.equals(bfVar.streamActivityMonitorId()) : bfVar.streamActivityMonitorId() == null) {
                                                                                                                                                                            Boolean bool7 = this.supportsResizing;
                                                                                                                                                                            if (bool7 != null ? bool7.equals(bfVar.supportsResizing()) : bfVar.supportsResizing() == null) {
                                                                                                                                                                                Boolean bool8 = this.useQAStreamBaseUrl;
                                                                                                                                                                                if (bool8 != null ? bool8.equals(bfVar.useQAStreamBaseUrl()) : bfVar.useQAStreamBaseUrl() == null) {
                                                                                                                                                                                    Boolean bool9 = this.usesCustomVideoPlayback;
                                                                                                                                                                                    if (bool9 != null ? bool9.equals(bfVar.usesCustomVideoPlayback()) : bfVar.usesCustomVideoPlayback() == null) {
                                                                                                                                                                                        Float f3 = this.vastLoadTimeout;
                                                                                                                                                                                        if (f3 != null ? f3.equals(bfVar.vastLoadTimeout()) : bfVar.vastLoadTimeout() == null) {
                                                                                                                                                                                            String str20 = this.videoId;
                                                                                                                                                                                            if (str20 != null ? str20.equals(bfVar.videoId()) : bfVar.videoId() == null) {
                                                                                                                                                                                                ait aitVar = this.videoPlayActivation;
                                                                                                                                                                                                if (aitVar != null ? aitVar.equals(bfVar.videoPlayActivation()) : bfVar.videoPlayActivation() == null) {
                                                                                                                                                                                                    aiu aiuVar = this.videoContinuousPlay;
                                                                                                                                                                                                    if (aiuVar != null ? aiuVar.equals(bfVar.videoContinuousPlay()) : bfVar.videoContinuousPlay() == null) {
                                                                                                                                                                                                        aiv aivVar = this.videoPlayMuted;
                                                                                                                                                                                                        aiv videoPlayMuted = bfVar.videoPlayMuted();
                                                                                                                                                                                                        if (aivVar != null ? aivVar.equals(videoPlayMuted) : videoPlayMuted == null) {
                                                                                                                                                                                                            return true;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public avs extraParameters() {
        return this.extraParameters;
    }

    public String format() {
        return this.format;
    }

    public int hashCode() {
        String str = this.adTagUrl;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        avs avsVar = this.adTagParameters;
        int hashCode2 = (hashCode ^ (avsVar == null ? 0 : avsVar.hashCode())) * 1000003;
        String str2 = this.adsResponse;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.apiKey;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.assetKey;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.authToken;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        avs avsVar2 = this.companionSlots;
        int hashCode7 = (hashCode6 ^ (avsVar2 == null ? 0 : avsVar2.hashCode())) * 1000003;
        Float f = this.contentDuration;
        int hashCode8 = (hashCode7 ^ (f == null ? 0 : f.hashCode())) * 1000003;
        avo avoVar = this.contentKeywords;
        int hashCode9 = (hashCode8 ^ (avoVar == null ? 0 : avoVar.hashCode())) * 1000003;
        String str6 = this.contentTitle;
        int hashCode10 = (hashCode9 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.contentUrl;
        int hashCode11 = (hashCode10 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.contentSourceId;
        int hashCode12 = (hashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        ba baVar = this.consentSettings;
        int hashCode13 = (hashCode12 ^ (baVar == null ? 0 : baVar.hashCode())) * 1000003;
        String str9 = this.customAssetKey;
        int hashCode14 = (hashCode13 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Boolean bool = this.enableNonce;
        int hashCode15 = (hashCode14 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str10 = this.env;
        int hashCode16 = (hashCode15 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        avo avoVar2 = this.secureSignals;
        int hashCode17 = (hashCode16 ^ (avoVar2 == null ? 0 : avoVar2.hashCode())) * 1000003;
        avs avsVar3 = this.extraParameters;
        int hashCode18 = (hashCode17 ^ (avsVar3 == null ? 0 : avsVar3.hashCode())) * 1000003;
        String str11 = this.format;
        int hashCode19 = (hashCode18 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        bg bgVar = this.identifierInfo;
        int hashCode20 = (hashCode19 ^ (bgVar == null ? 0 : bgVar.hashCode())) * 1000003;
        Boolean bool2 = this.isTv;
        int hashCode21 = (hashCode20 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Integer num = this.linearAdSlotWidth;
        int hashCode22 = (hashCode21 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.linearAdSlotHeight;
        int hashCode23 = (hashCode22 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str12 = this.liveStreamEventId;
        int hashCode24 = (hashCode23 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        Float f2 = this.liveStreamPrefetchSeconds;
        int hashCode25 = (hashCode24 ^ (f2 == null ? 0 : f2.hashCode())) * 1000003;
        aip aipVar = this.marketAppInfo;
        int hashCode26 = (hashCode25 ^ (aipVar == null ? 0 : aipVar.hashCode())) * 1000003;
        String str13 = this.msParameter;
        int hashCode27 = (hashCode26 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.network;
        int hashCode28 = (hashCode27 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        cd cdVar = this.videoEnvironment;
        int hashCode29 = (hashCode28 ^ (cdVar == null ? 0 : cdVar.hashCode())) * 1000003;
        String str15 = this.networkCode;
        int hashCode30 = (hashCode29 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.oAuthToken;
        int hashCode31 = (hashCode30 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        Boolean bool3 = this.omidAdSessionsOnStartedOnly;
        int hashCode32 = (hashCode31 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        avs avsVar4 = this.platformSignals;
        int hashCode33 = (hashCode32 ^ (avsVar4 == null ? 0 : avsVar4.hashCode())) * 1000003;
        String str17 = this.projectNumber;
        int hashCode34 = (hashCode33 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.region;
        int hashCode35 = (hashCode34 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        ImaSdkSettings imaSdkSettings = this.settings;
        int hashCode36 = (hashCode35 ^ (imaSdkSettings == null ? 0 : imaSdkSettings.hashCode())) * 1000003;
        Boolean bool4 = this.supportsExternalNavigation;
        int hashCode37 = (hashCode36 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        Boolean bool5 = this.supportsIconClickFallback;
        int hashCode38 = (hashCode37 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        Boolean bool6 = this.supportsNativeNetworking;
        int hashCode39 = (hashCode38 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        String str19 = this.streamActivityMonitorId;
        int hashCode40 = (hashCode39 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        Boolean bool7 = this.supportsResizing;
        int hashCode41 = (hashCode40 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
        Boolean bool8 = this.useQAStreamBaseUrl;
        int hashCode42 = (hashCode41 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
        Boolean bool9 = this.usesCustomVideoPlayback;
        int hashCode43 = (hashCode42 ^ (bool9 == null ? 0 : bool9.hashCode())) * 1000003;
        Float f3 = this.vastLoadTimeout;
        int hashCode44 = (hashCode43 ^ (f3 == null ? 0 : f3.hashCode())) * 1000003;
        String str20 = this.videoId;
        int hashCode45 = (hashCode44 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        ait aitVar = this.videoPlayActivation;
        int hashCode46 = (hashCode45 ^ (aitVar == null ? 0 : aitVar.hashCode())) * 1000003;
        aiu aiuVar = this.videoContinuousPlay;
        int hashCode47 = (hashCode46 ^ (aiuVar == null ? 0 : aiuVar.hashCode())) * 1000003;
        aiv aivVar = this.videoPlayMuted;
        return hashCode47 ^ (aivVar != null ? aivVar.hashCode() : 0);
    }

    public bg identifierInfo() {
        return this.identifierInfo;
    }

    public Boolean isTv() {
        return this.isTv;
    }

    public Integer linearAdSlotHeight() {
        return this.linearAdSlotHeight;
    }

    public Integer linearAdSlotWidth() {
        return this.linearAdSlotWidth;
    }

    public String liveStreamEventId() {
        return this.liveStreamEventId;
    }

    public Float liveStreamPrefetchSeconds() {
        return this.liveStreamPrefetchSeconds;
    }

    public aip marketAppInfo() {
        return this.marketAppInfo;
    }

    public String msParameter() {
        return this.msParameter;
    }

    public String network() {
        return this.network;
    }

    public String networkCode() {
        return this.networkCode;
    }

    public String oAuthToken() {
        return this.oAuthToken;
    }

    public Boolean omidAdSessionsOnStartedOnly() {
        return this.omidAdSessionsOnStartedOnly;
    }

    public avs platformSignals() {
        return this.platformSignals;
    }

    public String projectNumber() {
        return this.projectNumber;
    }

    public String region() {
        return this.region;
    }

    public avo secureSignals() {
        return this.secureSignals;
    }

    public ImaSdkSettings settings() {
        return this.settings;
    }

    public String streamActivityMonitorId() {
        return this.streamActivityMonitorId;
    }

    public Boolean supportsExternalNavigation() {
        return this.supportsExternalNavigation;
    }

    public Boolean supportsIconClickFallback() {
        return this.supportsIconClickFallback;
    }

    public Boolean supportsNativeNetworking() {
        return this.supportsNativeNetworking;
    }

    public Boolean supportsResizing() {
        return this.supportsResizing;
    }

    public String toString() {
        return "GsonAdsRequest{adTagUrl=" + this.adTagUrl + ", adTagParameters=" + String.valueOf(this.adTagParameters) + ", adsResponse=" + this.adsResponse + ", apiKey=" + this.apiKey + ", assetKey=" + this.assetKey + ", authToken=" + this.authToken + ", companionSlots=" + String.valueOf(this.companionSlots) + ", contentDuration=" + this.contentDuration + ", contentKeywords=" + String.valueOf(this.contentKeywords) + ", contentTitle=" + this.contentTitle + ", contentUrl=" + this.contentUrl + ", contentSourceId=" + this.contentSourceId + ", consentSettings=" + String.valueOf(this.consentSettings) + ", customAssetKey=" + this.customAssetKey + ", enableNonce=" + this.enableNonce + ", env=" + this.env + ", secureSignals=" + String.valueOf(this.secureSignals) + ", extraParameters=" + String.valueOf(this.extraParameters) + ", format=" + this.format + ", identifierInfo=" + String.valueOf(this.identifierInfo) + ", isTv=" + this.isTv + ", linearAdSlotWidth=" + this.linearAdSlotWidth + ", linearAdSlotHeight=" + this.linearAdSlotHeight + ", liveStreamEventId=" + this.liveStreamEventId + ", liveStreamPrefetchSeconds=" + this.liveStreamPrefetchSeconds + ", marketAppInfo=" + String.valueOf(this.marketAppInfo) + ", msParameter=" + this.msParameter + ", network=" + this.network + ", videoEnvironment=" + String.valueOf(this.videoEnvironment) + ", networkCode=" + this.networkCode + ", oAuthToken=" + this.oAuthToken + ", omidAdSessionsOnStartedOnly=" + this.omidAdSessionsOnStartedOnly + ", platformSignals=" + String.valueOf(this.platformSignals) + ", projectNumber=" + this.projectNumber + ", region=" + this.region + ", settings=" + String.valueOf(this.settings) + ", supportsExternalNavigation=" + this.supportsExternalNavigation + ", supportsIconClickFallback=" + this.supportsIconClickFallback + ", supportsNativeNetworking=" + this.supportsNativeNetworking + ", streamActivityMonitorId=" + this.streamActivityMonitorId + ", supportsResizing=" + this.supportsResizing + ", useQAStreamBaseUrl=" + this.useQAStreamBaseUrl + ", usesCustomVideoPlayback=" + this.usesCustomVideoPlayback + ", vastLoadTimeout=" + this.vastLoadTimeout + ", videoId=" + this.videoId + ", videoPlayActivation=" + String.valueOf(this.videoPlayActivation) + ", videoContinuousPlay=" + String.valueOf(this.videoContinuousPlay) + ", videoPlayMuted=" + String.valueOf(this.videoPlayMuted) + "}";
    }

    public Boolean useQAStreamBaseUrl() {
        return this.useQAStreamBaseUrl;
    }

    public Boolean usesCustomVideoPlayback() {
        return this.usesCustomVideoPlayback;
    }

    public Float vastLoadTimeout() {
        return this.vastLoadTimeout;
    }

    public aiu videoContinuousPlay() {
        return this.videoContinuousPlay;
    }

    public cd videoEnvironment() {
        return this.videoEnvironment;
    }

    public String videoId() {
        return this.videoId;
    }

    public ait videoPlayActivation() {
        return this.videoPlayActivation;
    }

    public aiv videoPlayMuted() {
        return this.videoPlayMuted;
    }

    public /* synthetic */ z(String str, avs avsVar, String str2, String str3, String str4, String str5, avs avsVar2, Float f, avo avoVar, String str6, String str7, String str8, ba baVar, String str9, Boolean bool, String str10, avo avoVar2, avs avsVar3, String str11, bg bgVar, Boolean bool2, Integer num, Integer num2, String str12, Float f2, aip aipVar, String str13, String str14, cd cdVar, String str15, String str16, Boolean bool3, avs avsVar4, String str17, String str18, ImaSdkSettings imaSdkSettings, Boolean bool4, Boolean bool5, Boolean bool6, String str19, Boolean bool7, Boolean bool8, Boolean bool9, Float f3, String str20, ait aitVar, aiu aiuVar, aiv aivVar, y yVar) {
        this(str, avsVar, str2, str3, str4, str5, avsVar2, f, avoVar, str6, str7, str8, baVar, str9, bool, str10, avoVar2, avsVar3, str11, bgVar, bool2, num, num2, str12, f2, aipVar, str13, str14, cdVar, str15, str16, bool3, avsVar4, str17, str18, imaSdkSettings, bool4, bool5, bool6, str19, bool7, bool8, bool9, f3, str20, aitVar, aiuVar, aivVar);
    }
}
