package Z6;

import Y6.v;
import android.graphics.Rect;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class n extends q {
    public static final String b = "n";

    public float c(v vVar, v vVar2) {
        if (vVar.a <= 0 || vVar.c <= 0) {
            return 0.0f;
        }
        v d = vVar.d(vVar2);
        float f = (d.a * 1.0f) / vVar.a;
        if (f > 1.0f) {
            f = (float) Math.pow(1.0f / f, 1.1d);
        }
        float f2 = ((vVar2.a * 1.0f) / d.a) * ((vVar2.c * 1.0f) / d.c);
        return f * (((1.0f / f2) / f2) / f2);
    }

    public Rect d(v vVar, v vVar2) {
        v d = vVar.d(vVar2);
        Log.i(b, "Preview: " + vVar + "; Scaled: " + d + "; Want: " + vVar2);
        int i = (d.a - vVar2.a) / 2;
        int i2 = (d.c - vVar2.c) / 2;
        return new Rect(-i, -i2, d.a - i, d.c - i2);
    }
}
