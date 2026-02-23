package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdProgressInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aij implements AdProgressInfo {
    private final double a;
    private final double b;
    private final int c;
    private final int d;
    private final double e;
    private final double f;

    public aij(double d, double d2, int i, int i2, double d3, double d4) {
        this.a = d;
        this.b = d2;
        this.c = i;
        this.d = i2;
        this.e = d3;
        this.f = d4;
    }

    public final double getAdBreakDuration() {
        return this.e;
    }

    public final double getAdPeriodDuration() {
        return this.f;
    }

    public final int getAdPosition() {
        return this.c;
    }

    public final double getCurrentTime() {
        return this.a;
    }

    public final double getDuration() {
        return this.b;
    }

    public final int getTotalAds() {
        return this.d;
    }
}
