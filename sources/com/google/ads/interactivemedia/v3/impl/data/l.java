package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avx;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class l extends e {
    private int bitrate;
    private boolean disableUi;
    private boolean enableFocusSkipButton;
    private boolean enablePreloading;
    private int loadVideoTimeout;
    private avo mimeTypes;
    private double playAdsAfterTime;
    private byte set$0;
    private avx uiElements;

    public l() {
    }

    public f build() {
        if (this.set$0 == 63) {
            return new n(this.bitrate, this.mimeTypes, this.uiElements, this.enablePreloading, this.enableFocusSkipButton, this.playAdsAfterTime, this.disableUi, this.loadVideoTimeout, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" bitrate");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" enablePreloading");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" enableFocusSkipButton");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" playAdsAfterTime");
        }
        if ((this.set$0 & 16) == 0) {
            sb.append(" disableUi");
        }
        if ((this.set$0 & 32) == 0) {
            sb.append(" loadVideoTimeout");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public e setBitrate(int i) {
        this.bitrate = i;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    public e setDisableUi(boolean z) {
        this.disableUi = z;
        this.set$0 = (byte) (this.set$0 | 16);
        return this;
    }

    public e setEnableFocusSkipButton(boolean z) {
        this.enableFocusSkipButton = z;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    public e setEnablePreloading(boolean z) {
        this.enablePreloading = z;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    public e setLoadVideoTimeout(int i) {
        this.loadVideoTimeout = i;
        this.set$0 = (byte) (this.set$0 | 32);
        return this;
    }

    public e setMimeTypes(List list) {
        this.mimeTypes = list == null ? null : avo.m(list);
        return this;
    }

    public e setPlayAdsAfterTime(double d) {
        this.playAdsAfterTime = d;
        this.set$0 = (byte) (this.set$0 | 8);
        return this;
    }

    public e setUiElements(Set set) {
        this.uiElements = set == null ? null : avx.l(set);
        return this;
    }

    private l(f fVar) {
        this.bitrate = fVar.bitrate();
        this.mimeTypes = fVar.mimeTypes();
        this.uiElements = fVar.uiElements();
        this.enablePreloading = fVar.enablePreloading();
        this.enableFocusSkipButton = fVar.enableFocusSkipButton();
        this.playAdsAfterTime = fVar.playAdsAfterTime();
        this.disableUi = fVar.disableUi();
        this.loadVideoTimeout = fVar.loadVideoTimeout();
        this.set$0 = (byte) 63;
    }

    public /* synthetic */ l(f fVar, k kVar) {
        this(fVar);
    }
}
