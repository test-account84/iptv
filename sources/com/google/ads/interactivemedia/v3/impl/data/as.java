package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class as extends bz {
    private final long currentTime;
    private final long duration;
    private final String timeUnit;

    public as(long j, long j2, String str) {
        this.currentTime = j;
        this.duration = j2;
        if (str == null) {
            throw new NullPointerException("Null timeUnit");
        }
        this.timeUnit = str;
    }

    public long currentTime() {
        return this.currentTime;
    }

    public long duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bz) {
            bz bzVar = (bz) obj;
            if (this.currentTime == bzVar.currentTime() && this.duration == bzVar.duration() && this.timeUnit.equals(bzVar.timeUnit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.currentTime;
        long j2 = this.duration;
        return this.timeUnit.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String timeUnit() {
        return this.timeUnit;
    }

    public String toString() {
        return "TimeUpdateData{currentTime=" + this.currentTime + ", duration=" + this.duration + ", timeUnit=" + this.timeUnit + "}";
    }
}
