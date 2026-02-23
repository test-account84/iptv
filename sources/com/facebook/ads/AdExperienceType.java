package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum AdExperienceType {
    AD_EXPERIENCE_TYPE_REWARDED("ad_experience_config_rewarded"),
    AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL("ad_experience_config_rewarded_interstitial"),
    AD_EXPERIENCE_TYPE_INTERSTITIAL("ad_experience_config_interstitial");

    private String adExperienceType;

    AdExperienceType(String str) {
        this.adExperienceType = str;
    }

    public String getAdExperienceType() {
        return this.adExperienceType;
    }
}
