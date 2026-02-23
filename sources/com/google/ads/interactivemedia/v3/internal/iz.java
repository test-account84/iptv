package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class iz {
    public static final iz a = new iz(-1, -1, -1);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public iz(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = cq.Y(i3) ? cq.l(i3, i2) : -1;
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.b + ", channelCount=" + this.c + ", encoding=" + this.d + "]";
    }
}
