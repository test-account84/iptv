package G;

import android.graphics.Matrix;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static final Matrix a(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        return matrix;
    }

    public static final Matrix b(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f, f2);
        return matrix;
    }
}
