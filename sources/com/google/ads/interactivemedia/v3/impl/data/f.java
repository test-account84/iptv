package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.internal.atf;
import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avx;

@atf(a = n.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static e builder(AdsRenderingSettings adsRenderingSettings) {
        g gVar = (g) adsRenderingSettings;
        l lVar = new l();
        lVar.setBitrate(gVar.getBitrateKbps());
        lVar.setDisableUi(gVar.getDisableUi());
        lVar.setEnablePreloading(gVar.getEnablePreloading());
        lVar.setEnableFocusSkipButton(gVar.getFocusSkipButtonWhenAvailable());
        lVar.setLoadVideoTimeout(gVar.getLoadVideoTimeout());
        lVar.setMimeTypes(gVar.getMimeTypes());
        lVar.setPlayAdsAfterTime(gVar.getPlayAdsAfterTime());
        lVar.setUiElements(gVar.getUiElements());
        return lVar;
    }

    public abstract int bitrate();

    public abstract boolean disableUi();

    public abstract boolean enableFocusSkipButton();

    public abstract boolean enablePreloading();

    public abstract int loadVideoTimeout();

    public abstract avo mimeTypes();

    public abstract double playAdsAfterTime();

    public abstract e toBuilder();

    public abstract avx uiElements();
}
