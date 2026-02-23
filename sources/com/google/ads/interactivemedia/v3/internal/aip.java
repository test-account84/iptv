package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class aip {
    public static aip create(int i, String str) {
        return new aiy(i, str);
    }

    public abstract int appVersion();

    public abstract String packageName();
}
