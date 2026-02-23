package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class au {
    public static final au a = new au(1.0f, 1.0f);
    public final float b;
    public final float c;
    private final int d;

    public au(float f, float f2) {
        af.u(f > 0.0f);
        af.u(f2 > 0.0f);
        this.b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public final long a(long j) {
        return j * this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && au.class == obj.getClass()) {
            au auVar = (au) obj;
            if (this.b == auVar.b && this.c == auVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + 527) * 31) + Float.floatToRawIntBits(this.c);
    }

    public final String toString() {
        return cq.H("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.b), Float.valueOf(this.c));
    }
}
