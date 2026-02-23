package com.amazonaws.auth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum SignatureVersion {
    V1("1"),
    V2("2");

    private String value;

    SignatureVersion(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
