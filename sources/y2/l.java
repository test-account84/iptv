package y2;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l extends x2.c {
    public void onBoundsChange(Rect rect) {
        w(a(rect));
    }

    public ValueAnimator r() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        return new v2.d(this).j(fArr, 0, -180, -180).k(fArr, 0, 0, -180).c(1200L).d(fArr).b();
    }
}
