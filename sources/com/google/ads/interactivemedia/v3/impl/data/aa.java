package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aa extends bg {
    private final String appSetId;
    private final int appSetIdScope;
    private final String deviceId;
    private final String idType;
    private final boolean isLimitedAdTracking;

    public aa(String str, String str2, boolean z, String str3, int i) {
        if (str == null) {
            throw new NullPointerException("Null deviceId");
        }
        this.deviceId = str;
        if (str2 == null) {
            throw new NullPointerException("Null idType");
        }
        this.idType = str2;
        this.isLimitedAdTracking = z;
        if (str3 == null) {
            throw new NullPointerException("Null appSetId");
        }
        this.appSetId = str3;
        this.appSetIdScope = i;
    }

    public String appSetId() {
        return this.appSetId;
    }

    public int appSetIdScope() {
        return this.appSetIdScope;
    }

    public String deviceId() {
        return this.deviceId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bg) {
            bg bgVar = (bg) obj;
            if (this.deviceId.equals(bgVar.deviceId()) && this.idType.equals(bgVar.idType()) && this.isLimitedAdTracking == bgVar.isLimitedAdTracking() && this.appSetId.equals(bgVar.appSetId()) && this.appSetIdScope == bgVar.appSetIdScope()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.deviceId.hashCode() ^ 1000003) * 1000003) ^ this.idType.hashCode()) * 1000003) ^ (true != this.isLimitedAdTracking ? 1237 : 1231)) * 1000003) ^ this.appSetId.hashCode()) * 1000003) ^ this.appSetIdScope;
    }

    public String idType() {
        return this.idType;
    }

    public boolean isLimitedAdTracking() {
        return this.isLimitedAdTracking;
    }

    public String toString() {
        return "IdentifierInfo{deviceId=" + this.deviceId + ", idType=" + this.idType + ", isLimitedAdTracking=" + this.isLimitedAdTracking + ", appSetId=" + this.appSetId + ", appSetIdScope=" + this.appSetIdScope + "}";
    }
}
