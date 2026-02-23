package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avx;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class n extends f {
    private final int bitrate;
    private final boolean disableUi;
    private final boolean enableFocusSkipButton;
    private final boolean enablePreloading;
    private final int loadVideoTimeout;
    private final avo mimeTypes;
    private final double playAdsAfterTime;
    private final avx uiElements;

    private n(int i, avo avoVar, avx avxVar, boolean z, boolean z2, double d, boolean z3, int i2) {
        this.bitrate = i;
        this.mimeTypes = avoVar;
        this.uiElements = avxVar;
        this.enablePreloading = z;
        this.enableFocusSkipButton = z2;
        this.playAdsAfterTime = d;
        this.disableUi = z3;
        this.loadVideoTimeout = i2;
    }

    public int bitrate() {
        return this.bitrate;
    }

    public boolean disableUi() {
        return this.disableUi;
    }

    public boolean enableFocusSkipButton() {
        return this.enableFocusSkipButton;
    }

    public boolean enablePreloading() {
        return this.enablePreloading;
    }

    public boolean equals(Object obj) {
        avo avoVar;
        avx avxVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.bitrate == fVar.bitrate() && ((avoVar = this.mimeTypes) != null ? avoVar.equals(fVar.mimeTypes()) : fVar.mimeTypes() == null) && ((avxVar = this.uiElements) != null ? avxVar.equals(fVar.uiElements()) : fVar.uiElements() == null) && this.enablePreloading == fVar.enablePreloading() && this.enableFocusSkipButton == fVar.enableFocusSkipButton() && Double.doubleToLongBits(this.playAdsAfterTime) == Double.doubleToLongBits(fVar.playAdsAfterTime()) && this.disableUi == fVar.disableUi() && this.loadVideoTimeout == fVar.loadVideoTimeout()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.bitrate ^ 1000003) * 1000003;
        avo avoVar = this.mimeTypes;
        int hashCode = (i ^ (avoVar == null ? 0 : avoVar.hashCode())) * 1000003;
        avx avxVar = this.uiElements;
        return ((((((((((hashCode ^ (avxVar != null ? avxVar.hashCode() : 0)) * 1000003) ^ (true != this.enablePreloading ? 1237 : 1231)) * 1000003) ^ (true != this.enableFocusSkipButton ? 1237 : 1231)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.playAdsAfterTime) >>> 32) ^ Double.doubleToLongBits(this.playAdsAfterTime)))) * 1000003) ^ (true != this.disableUi ? 1237 : 1231)) * 1000003) ^ this.loadVideoTimeout;
    }

    public int loadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    public avo mimeTypes() {
        return this.mimeTypes;
    }

    public double playAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    public e toBuilder() {
        return new l(this, null);
    }

    public String toString() {
        return "AdsRenderingSettingsData{bitrate=" + this.bitrate + ", mimeTypes=" + String.valueOf(this.mimeTypes) + ", uiElements=" + String.valueOf(this.uiElements) + ", enablePreloading=" + this.enablePreloading + ", enableFocusSkipButton=" + this.enableFocusSkipButton + ", playAdsAfterTime=" + this.playAdsAfterTime + ", disableUi=" + this.disableUi + ", loadVideoTimeout=" + this.loadVideoTimeout + "}";
    }

    public avx uiElements() {
        return this.uiElements;
    }

    public /* synthetic */ n(int i, avo avoVar, avx avxVar, boolean z, boolean z2, double d, boolean z3, int i2, m mVar) {
        this(i, avoVar, avxVar, z, z2, d, z3, i2);
    }
}
