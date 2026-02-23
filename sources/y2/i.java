package y2;

import android.animation.ValueAnimator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i extends x2.b {
    public i() {
        C(0.0f);
    }

    public ValueAnimator r() {
        float[] fArr = {0.0f, 1.0f};
        return new v2.d(this).l(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f)).a(fArr, 255, 0).c(1000L).d(fArr).b();
    }
}
