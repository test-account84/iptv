package com.amazonaws;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum Protocol {
    HTTP("http"),
    HTTPS("https");

    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    public String toString() {
        return this.protocol;
    }
}
