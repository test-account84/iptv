package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ae extends br {
    private final String content;
    private final String contentType;
    private final int errorCode;
    private final String id;

    public ae(String str, String str2, String str3, int i) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.id = str;
        if (str2 == null) {
            throw new NullPointerException("Null content");
        }
        this.content = str2;
        if (str3 == null) {
            throw new NullPointerException("Null contentType");
        }
        this.contentType = str3;
        this.errorCode = i;
    }

    public String content() {
        return this.content;
    }

    public String contentType() {
        return this.contentType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof br) {
            br brVar = (br) obj;
            if (this.id.equals(brVar.id()) && this.content.equals(brVar.content()) && this.contentType.equals(brVar.contentType()) && this.errorCode == brVar.errorCode()) {
                return true;
            }
        }
        return false;
    }

    public int errorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        return ((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.contentType.hashCode()) * 1000003) ^ this.errorCode;
    }

    public String id() {
        return this.id;
    }

    public String toString() {
        return "NetworkResponseData{id=" + this.id + ", content=" + this.content + ", contentType=" + this.contentType + ", errorCode=" + this.errorCode + "}";
    }
}
