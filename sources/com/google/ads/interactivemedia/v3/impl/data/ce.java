package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ce {
    public abstract cf build();

    public abstract ce volume(float f);

    public ce volumePercentage(int i) {
        return volume(i / 100.0f);
    }
}
