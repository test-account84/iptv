package r;

import android.graphics.drawable.Drawable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e extends Drawable {
    public static final double a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f, float f2, boolean z) {
        return z ? (float) (f + ((1.0d - a) * f2)) : f;
    }

    public static float b(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        return z ? (float) (f3 + ((1.0d - a) * f2)) : f3;
    }
}
