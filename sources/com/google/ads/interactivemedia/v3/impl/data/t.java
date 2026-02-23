package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class t extends bb {
    private final double end;
    private final boolean played;
    private final double start;

    public t(double d, double d2, boolean z) {
        this.start = d;
        this.end = d2;
        this.played = z;
    }

    public double end() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bb) {
            bb bbVar = (bb) obj;
            if (Double.doubleToLongBits(this.start) == Double.doubleToLongBits(bbVar.start()) && Double.doubleToLongBits(this.end) == Double.doubleToLongBits(bbVar.end()) && this.played == bbVar.played()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (true != this.played ? 1237 : 1231) ^ ((((((int) ((Double.doubleToLongBits(this.start) >>> 32) ^ Double.doubleToLongBits(this.start))) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.end) >>> 32) ^ Double.doubleToLongBits(this.end)))) * 1000003);
    }

    public boolean played() {
        return this.played;
    }

    public double start() {
        return this.start;
    }

    public String toString() {
        return "CuePointData{start=" + this.start + ", end=" + this.end + ", played=" + this.played + "}";
    }
}
