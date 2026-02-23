package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ac extends bo {
    private final String message;
    private final String name;

    public ac(String str, String str2) {
        this.name = str;
        this.message = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bo) {
            bo boVar = (bo) obj;
            String str = this.name;
            if (str != null ? str.equals(boVar.name()) : boVar.name() == null) {
                String str2 = this.message;
                String message = boVar.message();
                if (str2 != null ? str2.equals(message) : message == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.message;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String message() {
        return this.message;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return "LoggableException{name=" + this.name + ", message=" + this.message + "}";
    }
}
