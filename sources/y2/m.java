package y2;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m extends x2.g {

    public class a extends x2.b {
        public a() {
            C(0.0f);
        }

        public ValueAnimator r() {
            Float valueOf = Float.valueOf(0.0f);
            float[] fArr = {0.0f, 0.4f, 0.8f, 1.0f};
            return new v2.d(this).l(fArr, valueOf, Float.valueOf(1.0f), valueOf, valueOf).c(1400L).d(fArr).b();
        }
    }

    public void N(x2.f... fVarArr) {
        super.N(fVarArr);
        fVarArr[1].t(160);
        fVarArr[2].t(320);
    }

    public x2.f[] O() {
        return new x2.f[]{new a(), new a(), new a()};
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = a2.width() / 8;
        int centerY = a2.centerY() - width;
        int centerY2 = a2.centerY() + width;
        for (int i = 0; i < L(); i++) {
            int width2 = ((a2.width() * i) / 3) + a2.left;
            K(i).v(width2, centerY, (width * 2) + width2, centerY2);
        }
    }
}
