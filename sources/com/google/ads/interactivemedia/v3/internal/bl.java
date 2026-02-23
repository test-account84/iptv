package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bl {
    public static final bl a = new bl(0, 0, 0, 1.0f);
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public bl(int i, int i2, int i3, float f) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bl) {
            bl blVar = (bl) obj;
            if (this.b == blVar.b && this.c == blVar.c && this.d == blVar.d && this.e == blVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.b + 217) * 31) + this.c) * 31) + this.d) * 31) + Float.floatToRawIntBits(this.e);
    }
}
