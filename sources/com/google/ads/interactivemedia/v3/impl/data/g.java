package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.internal.bur;
import com.google.ads.interactivemedia.v3.internal.but;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements AdsRenderingSettings {
    private boolean enablePreloading;
    private Set uiElements;
    private int bitrate = -1;
    private List mimeTypes = null;
    private boolean enableFocusSkipButton = true;
    private double playAdsAfterTime = -1.0d;
    private boolean disableUi = false;
    private boolean enableCustomTabs = false;
    private int loadVideoTimeout = -1;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, new String[0]);
    }

    public int getBitrateKbps() {
        return this.bitrate;
    }

    public boolean getDisableUi() {
        return this.disableUi;
    }

    public boolean getEnableCustomTabs() {
        return this.enableCustomTabs;
    }

    public boolean getEnablePreloading() {
        return this.enablePreloading;
    }

    public boolean getFocusSkipButtonWhenAvailable() {
        return this.enableFocusSkipButton;
    }

    public int getLoadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    public List getMimeTypes() {
        return this.mimeTypes;
    }

    public double getPlayAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    public Set getUiElements() {
        return this.uiElements;
    }

    public int hashCode() {
        return but.a(this, new String[0]);
    }

    public void setBitrateKbps(int i) {
        this.bitrate = i;
    }

    public void setDisableUi(boolean z) {
        this.disableUi = z;
    }

    public void setEnableCustomTabs(boolean z) {
        this.enableCustomTabs = z;
    }

    public void setEnablePreloading(boolean z) {
        this.enablePreloading = z;
    }

    public void setFocusSkipButtonWhenAvailable(boolean z) {
        this.enableFocusSkipButton = z;
    }

    public void setLoadVideoTimeout(int i) {
        this.loadVideoTimeout = i;
    }

    public void setMimeTypes(List list) {
        this.mimeTypes = list;
    }

    public void setPlayAdsAfterTime(double d) {
        this.playAdsAfterTime = d;
    }

    public void setUiElements(Set set) {
        this.uiElements = set;
    }
}
