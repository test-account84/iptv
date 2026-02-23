package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aw extends cf {
    private final float volume;

    private aw(float f) {
        this.volume = f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof cf) && Float.floatToIntBits(this.volume) == Float.floatToIntBits(((cf) obj).volume());
    }

    public int hashCode() {
        return Float.floatToIntBits(this.volume) ^ 1000003;
    }

    public String toString() {
        return "VolumeUpdateData{volume=" + this.volume + "}";
    }

    public float volume() {
        return this.volume;
    }

    public /* synthetic */ aw(float f, av avVar) {
        this(f);
    }
}
