package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class s extends ba {
    private final String addtlConsent;
    private final String gdprApplies;
    private final String tcString;
    private final String uspString;

    public s(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new NullPointerException("Null gdprApplies");
        }
        this.gdprApplies = str;
        if (str2 == null) {
            throw new NullPointerException("Null tcString");
        }
        this.tcString = str2;
        if (str3 == null) {
            throw new NullPointerException("Null addtlConsent");
        }
        this.addtlConsent = str3;
        if (str4 == null) {
            throw new NullPointerException("Null uspString");
        }
        this.uspString = str4;
    }

    public String addtlConsent() {
        return this.addtlConsent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ba) {
            ba baVar = (ba) obj;
            if (this.gdprApplies.equals(baVar.gdprApplies()) && this.tcString.equals(baVar.tcString()) && this.addtlConsent.equals(baVar.addtlConsent()) && this.uspString.equals(baVar.uspString())) {
                return true;
            }
        }
        return false;
    }

    public String gdprApplies() {
        return this.gdprApplies;
    }

    public int hashCode() {
        return ((((((this.gdprApplies.hashCode() ^ 1000003) * 1000003) ^ this.tcString.hashCode()) * 1000003) ^ this.addtlConsent.hashCode()) * 1000003) ^ this.uspString.hashCode();
    }

    public String tcString() {
        return this.tcString;
    }

    public String toString() {
        return "ConsentSettings{gdprApplies=" + this.gdprApplies + ", tcString=" + this.tcString + ", addtlConsent=" + this.addtlConsent + ", uspString=" + this.uspString + "}";
    }

    public String uspString() {
        return this.uspString;
    }
}
