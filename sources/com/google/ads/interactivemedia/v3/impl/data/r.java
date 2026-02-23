package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class r extends CompanionData {
    private final String clickThroughUrl;
    private final String size;
    private final String src;
    private final az type;

    public r(String str, String str2, String str3, az azVar) {
        if (str == null) {
            throw new NullPointerException("Null size");
        }
        this.size = str;
        if (str2 == null) {
            throw new NullPointerException("Null src");
        }
        this.src = str2;
        if (str3 == null) {
            throw new NullPointerException("Null clickThroughUrl");
        }
        this.clickThroughUrl = str3;
        if (azVar == null) {
            throw new NullPointerException("Null type");
        }
        this.type = azVar;
    }

    public String clickThroughUrl() {
        return this.clickThroughUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompanionData) {
            CompanionData companionData = (CompanionData) obj;
            if (this.size.equals(companionData.size()) && this.src.equals(companionData.src()) && this.clickThroughUrl.equals(companionData.clickThroughUrl()) && this.type.equals(companionData.type())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.src.hashCode()) * 1000003) ^ this.clickThroughUrl.hashCode()) * 1000003) ^ this.type.hashCode();
    }

    public String size() {
        return this.size;
    }

    public String src() {
        return this.src;
    }

    public az type() {
        return this.type;
    }
}
