package y2;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o extends x2.g {

    public class a extends x2.c {
        public a() {
            E(0.4f);
        }

        public ValueAnimator r() {
            Float valueOf = Float.valueOf(0.4f);
            float[] fArr = {0.0f, 0.2f, 0.4f, 1.0f};
            return new v2.d(this).m(fArr, valueOf, Float.valueOf(1.0f), valueOf, valueOf).c(1200L).d(fArr).b();
        }
    }

    public x2.f[] O() {
        a[] aVarArr = new a[5];
        for (int i = 0; i < 5; i++) {
            a aVar = new a();
            aVarArr[i] = aVar;
            aVar.t(Build.VERSION.SDK_INT >= 24 ? (i * 100) + 600 : (i * 100) - 1200);
        }
        return aVarArr;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = a2.width() / L();
        int width2 = ((a2.width() / 5) * 3) / 5;
        for (int i = 0; i < L(); i++) {
            x2.f K = K(i);
            int i2 = a2.left + (i * width) + (width / 5);
            K.v(i2, a2.top, i2 + width2, a2.bottom);
        }
    }
}
