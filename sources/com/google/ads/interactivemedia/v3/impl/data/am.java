package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class am extends bw {
    private final bx adapterVersion;
    private final Boolean isPublisherCreated;
    private final String name;
    private final bx sdkVersion;
    private final String signals;

    public am(bx bxVar, bx bxVar2, String str, String str2, Boolean bool) {
        this.adapterVersion = bxVar;
        this.sdkVersion = bxVar2;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (str2 == null) {
            throw new NullPointerException("Null signals");
        }
        this.signals = str2;
        if (bool == null) {
            throw new NullPointerException("Null isPublisherCreated");
        }
        this.isPublisherCreated = bool;
    }

    public bx adapterVersion() {
        return this.adapterVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bw) {
            bw bwVar = (bw) obj;
            bx bxVar = this.adapterVersion;
            if (bxVar != null ? bxVar.equals(bwVar.adapterVersion()) : bwVar.adapterVersion() == null) {
                bx bxVar2 = this.sdkVersion;
                if (bxVar2 != null ? bxVar2.equals(bwVar.sdkVersion()) : bwVar.sdkVersion() == null) {
                    if (this.name.equals(bwVar.name()) && this.signals.equals(bwVar.signals()) && this.isPublisherCreated.equals(bwVar.isPublisherCreated())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        bx bxVar = this.adapterVersion;
        int hashCode = ((bxVar == null ? 0 : bxVar.hashCode()) ^ 1000003) * 1000003;
        bx bxVar2 = this.sdkVersion;
        return ((((((hashCode ^ (bxVar2 != null ? bxVar2.hashCode() : 0)) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.signals.hashCode()) * 1000003) ^ this.isPublisherCreated.hashCode();
    }

    public Boolean isPublisherCreated() {
        return this.isPublisherCreated;
    }

    public String name() {
        return this.name;
    }

    public bx sdkVersion() {
        return this.sdkVersion;
    }

    public String signals() {
        return this.signals;
    }

    public String toString() {
        return "SecureSignalsData{adapterVersion=" + String.valueOf(this.adapterVersion) + ", sdkVersion=" + String.valueOf(this.sdkVersion) + ", name=" + this.name + ", signals=" + this.signals + ", isPublisherCreated=" + this.isPublisherCreated + "}";
    }
}
