package y2;

import android.animation.ValueAnimator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j extends x2.d {
    public j() {
        C(0.0f);
    }

    public ValueAnimator r() {
        Float valueOf = Float.valueOf(1.0f);
        float[] fArr = {0.0f, 0.7f, 1.0f};
        return new v2.d(this).l(fArr, Float.valueOf(0.0f), valueOf, valueOf).a(fArr, 255, 178, 0).c(1000L).h(w2.b.b(0.21f, 0.53f, 0.56f, 0.8f, fArr)).b();
    }
}
