package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class jl extends Exception {
    public final int a;
    public final boolean b;
    public final s c;

    public jl(int i, int i2, int i3, int i4, s sVar, boolean z, Exception exc) {
        super("AudioTrack init failed " + i + " Config(" + i2 + ", " + i3 + ", " + i4 + ")" + (true != z ? "" : " (recoverable)"), exc);
        this.a = i;
        this.b = z;
        this.c = sVar;
    }
}
