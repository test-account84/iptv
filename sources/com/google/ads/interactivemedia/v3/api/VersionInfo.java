package com.google.ads.interactivemedia.v3.api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class VersionInfo {
    private final int a;
    private final int b;
    private final int c;

    public VersionInfo(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public int getMajorVersion() {
        return this.a;
    }

    public int getMicroVersion() {
        return this.c;
    }

    public int getMinorVersion() {
        return this.b;
    }

    public String toString() {
        return this.a + "." + this.b + "." + this.c;
    }
}
