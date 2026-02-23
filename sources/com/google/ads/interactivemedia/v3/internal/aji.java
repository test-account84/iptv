package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.CuePoint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aji implements CuePoint {
    private final double a;
    private final double b;
    private final boolean c;

    public aji(double d, double d2, boolean z) {
        this.a = d;
        this.b = d2;
        this.c = z;
    }

    public final double getEndTime() {
        return this.b;
    }

    public final long getEndTimeMs() {
        return (long) Math.floor(this.b * 1000.0d);
    }

    public final double getStartTime() {
        return this.a;
    }

    public final long getStartTimeMs() {
        return (long) Math.floor(this.a * 1000.0d);
    }

    public final boolean isPlayed() {
        return this.c;
    }
}
