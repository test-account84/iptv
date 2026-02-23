package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class au extends ce {
    private byte set$0;
    private float volume;

    public cf build() {
        if (this.set$0 == 1) {
            return new aw(this.volume, null);
        }
        throw new IllegalStateException("Missing required properties: volume");
    }

    public ce volume(float f) {
        this.volume = f;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }
}
