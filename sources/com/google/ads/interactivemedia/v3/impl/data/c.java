package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.UniversalAdId;
import com.google.ads.interactivemedia.v3.internal.bur;
import com.google.ads.interactivemedia.v3.internal.bus;
import com.google.ads.interactivemedia.v3.internal.but;
import com.google.ads.interactivemedia.v3.internal.buu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements Ad {
    private String adId;
    private String adSystem;

    @bus
    @buu
    private String[] adWrapperCreativeIds;

    @bus
    @buu
    private String[] adWrapperIds;

    @bus
    @buu
    private String[] adWrapperSystems;
    private String advertiserName;
    private String clickThroughUrl;

    @bus
    @buu
    private List companions;
    private String contentType;
    private String creativeAdId;
    private String creativeId;
    private String dealId;
    private String description;
    private boolean disableUi;
    private double duration;
    private int height;
    private String surveyUrl;
    private String title;
    private String traffickingParameters;

    @bus
    @buu
    private Set uiElements;
    private String universalAdIdRegistry;
    private String universalAdIdValue;

    @bus
    @buu
    private cc[] universalAdIds;
    private int vastMediaBitrate;
    private int vastMediaHeight;
    private int vastMediaWidth;
    private int width;
    private boolean linear = false;
    private boolean skippable = false;
    private double skipTimeOffset = -1.0d;

    @bus
    @buu
    private d adPodInfo = new d();

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, "vastMediaBitrate", "vastMediaHeight", "vastMediaWidth");
    }

    public String getAdId() {
        return this.adId;
    }

    public AdPodInfo getAdPodInfo() {
        return this.adPodInfo;
    }

    public String getAdSystem() {
        return this.adSystem;
    }

    public String[] getAdWrapperCreativeIds() {
        return this.adWrapperCreativeIds;
    }

    public String[] getAdWrapperIds() {
        return this.adWrapperIds;
    }

    public String[] getAdWrapperSystems() {
        return this.adWrapperSystems;
    }

    public String getAdvertiserName() {
        return this.advertiserName;
    }

    public String getClickThruUrl() {
        return this.clickThroughUrl;
    }

    public List getCompanionAds() {
        ArrayList arrayList = new ArrayList();
        List list = this.companions;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getCreativeAdId() {
        return this.creativeAdId;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getDealId() {
        return this.dealId;
    }

    public String getDescription() {
        return this.description;
    }

    public double getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public double getSkipTimeOffset() {
        return this.skipTimeOffset;
    }

    public String getSurveyUrl() {
        return this.surveyUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTraffickingParameters() {
        return this.traffickingParameters;
    }

    public Set getUiElements() {
        return this.uiElements;
    }

    public String getUniversalAdIdRegistry() {
        return this.universalAdIdRegistry;
    }

    public String getUniversalAdIdValue() {
        return this.universalAdIdValue;
    }

    public UniversalAdId[] getUniversalAdIds() {
        return this.universalAdIds;
    }

    public int getVastMediaBitrate() {
        return this.vastMediaBitrate;
    }

    public int getVastMediaHeight() {
        return this.vastMediaHeight;
    }

    public int getVastMediaWidth() {
        return this.vastMediaWidth;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return but.a(this, new String[0]);
    }

    public boolean isLinear() {
        return this.linear;
    }

    public boolean isSkippable() {
        return this.skippable;
    }

    public boolean isUiDisabled() {
        return this.disableUi;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdPodInfo(d dVar) {
        this.adPodInfo = dVar;
    }

    public void setAdSystem(String str) {
        this.adSystem = str;
    }

    public void setAdWrapperCreativeIds(String[] strArr) {
        this.adWrapperCreativeIds = strArr;
    }

    public void setAdWrapperIds(String[] strArr) {
        this.adWrapperIds = strArr;
    }

    public void setAdWrapperSystems(String[] strArr) {
        this.adWrapperSystems = strArr;
    }

    public void setAdvertiserName(String str) {
        this.advertiserName = str;
    }

    public void setClickThruUrl(String str) {
        this.clickThroughUrl = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setCreativeAdId(String str) {
        this.creativeAdId = str;
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setDealId(String str) {
        this.dealId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDuration(double d) {
        this.duration = d;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLinear(boolean z) {
        this.linear = z;
    }

    public void setSkipTimeOffset(double d) {
        this.skipTimeOffset = d;
    }

    public void setSkippable(boolean z) {
        this.skippable = z;
    }

    public void setSurveyUrl(String str) {
        this.surveyUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTraffickingParameters(String str) {
        this.traffickingParameters = str;
    }

    public void setUiDisabled(boolean z) {
        this.disableUi = z;
    }

    public void setUiElements(Set set) {
        this.uiElements = set;
    }

    public void setUniversalAdIdRegistry(String str) {
        this.universalAdIdRegistry = str;
    }

    public void setUniversalAdIdValue(String str) {
        this.universalAdIdValue = str;
    }

    public void setUniversalAdIds(cc[] ccVarArr) {
        this.universalAdIds = ccVarArr;
    }

    public void setVastMediaBitrate(int i) {
        this.vastMediaBitrate = i;
    }

    public void setVastMediaHeight(int i) {
        this.vastMediaHeight = i;
    }

    public void setVastMediaWidth(int i) {
        this.vastMediaWidth = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        return "Ad [adId=" + this.adId + ", creativeId=" + this.creativeId + ", creativeAdId=" + this.creativeAdId + ", universalAdIdValue=" + this.universalAdIdValue + ", universalAdIdRegistry=" + this.universalAdIdRegistry + ", title=" + this.title + ", description=" + this.description + ", contentType=" + this.contentType + ", adWrapperIds=" + Arrays.toString(this.adWrapperIds) + ", adWrapperSystems=" + Arrays.toString(this.adWrapperSystems) + ", adWrapperCreativeIds=" + Arrays.toString(this.adWrapperCreativeIds) + ", adSystem=" + this.adSystem + ", advertiserName=" + this.advertiserName + ", surveyUrl=" + this.surveyUrl + ", dealId=" + this.dealId + ", linear=" + this.linear + ", skippable=" + this.skippable + ", width=" + this.width + ", height=" + this.height + ", vastMediaHeight=" + this.vastMediaHeight + ", vastMediaWidth=" + this.vastMediaWidth + ", vastMediaBitrate=" + this.vastMediaBitrate + ", traffickingParameters=" + this.traffickingParameters + ", clickThroughUrl=" + this.clickThroughUrl + ", duration=" + this.duration + ", adPodInfo=" + String.valueOf(this.adPodInfo) + ", uiElements=" + String.valueOf(this.uiElements) + ", disableUi=" + this.disableUi + ", skipTimeOffset=" + this.skipTimeOffset + "]";
    }
}
