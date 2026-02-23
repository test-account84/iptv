package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class jo extends Exception {
    public final int a;
    public final boolean b;
    public final s c;

    public jo(int i, s sVar, boolean z) {
        super("AudioTrack write failed: " + i);
        this.b = z;
        this.a = i;
        this.c = sVar;
    }
}
