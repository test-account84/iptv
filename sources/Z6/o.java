package Z6;

import Y6.v;
import android.graphics.Rect;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o extends q {
    public static float e(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    public float c(v vVar, v vVar2) {
        int i = vVar.a;
        if (i <= 0 || vVar.c <= 0) {
            return 0.0f;
        }
        float e = (1.0f / e((i * 1.0f) / vVar2.a)) / e((vVar.c * 1.0f) / vVar2.c);
        float e2 = e(((vVar.a * 1.0f) / vVar.c) / ((vVar2.a * 1.0f) / vVar2.c));
        return e * (((1.0f / e2) / e2) / e2);
    }

    public Rect d(v vVar, v vVar2) {
        return new Rect(0, 0, vVar2.a, vVar2.c);
    }
}
