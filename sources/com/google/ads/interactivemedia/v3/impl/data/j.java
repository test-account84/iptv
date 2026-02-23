package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class j extends b {
    private final String appState;
    private final String eventId;
    private final long nativeTime;
    private final ay nativeViewBounds;
    private final boolean nativeViewHidden;
    private final ay nativeViewVisibleBounds;
    private final double nativeVolume;
    private final String queryId;

    private j(String str, String str2, String str3, long j, double d, boolean z, ay ayVar, ay ayVar2) {
        this.queryId = str;
        this.eventId = str2;
        this.appState = str3;
        this.nativeTime = j;
        this.nativeVolume = d;
        this.nativeViewHidden = z;
        this.nativeViewBounds = ayVar;
        this.nativeViewVisibleBounds = ayVar2;
    }

    public String appState() {
        return this.appState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.queryId.equals(bVar.queryId()) && this.eventId.equals(bVar.eventId()) && this.appState.equals(bVar.appState()) && this.nativeTime == bVar.nativeTime() && Double.doubleToLongBits(this.nativeVolume) == Double.doubleToLongBits(bVar.nativeVolume()) && this.nativeViewHidden == bVar.nativeViewHidden() && this.nativeViewBounds.equals(bVar.nativeViewBounds()) && this.nativeViewVisibleBounds.equals(bVar.nativeViewVisibleBounds())) {
                return true;
            }
        }
        return false;
    }

    public String eventId() {
        return this.eventId;
    }

    public int hashCode() {
        int hashCode = this.queryId.hashCode();
        int hashCode2 = this.eventId.hashCode();
        int hashCode3 = this.appState.hashCode();
        long j = this.nativeTime;
        return ((((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.nativeVolume) >>> 32) ^ Double.doubleToLongBits(this.nativeVolume)))) * 1000003) ^ (true != this.nativeViewHidden ? 1237 : 1231)) * 1000003) ^ this.nativeViewBounds.hashCode()) * 1000003) ^ this.nativeViewVisibleBounds.hashCode();
    }

    public long nativeTime() {
        return this.nativeTime;
    }

    public ay nativeViewBounds() {
        return this.nativeViewBounds;
    }

    public boolean nativeViewHidden() {
        return this.nativeViewHidden;
    }

    public ay nativeViewVisibleBounds() {
        return this.nativeViewVisibleBounds;
    }

    public double nativeVolume() {
        return this.nativeVolume;
    }

    public String queryId() {
        return this.queryId;
    }

    public String toString() {
        return "ActivityMonitorData{queryId=" + this.queryId + ", eventId=" + this.eventId + ", appState=" + this.appState + ", nativeTime=" + this.nativeTime + ", nativeVolume=" + this.nativeVolume + ", nativeViewHidden=" + this.nativeViewHidden + ", nativeViewBounds=" + String.valueOf(this.nativeViewBounds) + ", nativeViewVisibleBounds=" + String.valueOf(this.nativeViewVisibleBounds) + "}";
    }

    public /* synthetic */ j(String str, String str2, String str3, long j, double d, boolean z, ay ayVar, ay ayVar2, i iVar) {
        this(str, str2, str3, j, d, z, ayVar, ayVar2);
    }
}
