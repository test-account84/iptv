package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aiy extends aip {
    private final int appVersion;
    private final String packageName;

    public aiy(int i, String str) {
        this.appVersion = i;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.packageName = str;
    }

    public int appVersion() {
        return this.appVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aip) {
            aip aipVar = (aip) obj;
            if (this.appVersion == aipVar.appVersion() && this.packageName.equals(aipVar.packageName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.appVersion ^ 1000003) * 1000003) ^ this.packageName.hashCode();
    }

    public String packageName() {
        return this.packageName;
    }

    public String toString() {
        return "MarketAppInfo{appVersion=" + this.appVersion + ", packageName=" + this.packageName + "}";
    }
}
