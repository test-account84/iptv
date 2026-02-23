package y2;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends x2.g {

    public class b extends x2.c {
        public b() {
        }

        public ValueAnimator r() {
            Float valueOf = Float.valueOf(1.0f);
            float[] fArr = {0.0f, 0.35f, 0.7f, 1.0f};
            return new v2.d(this).l(fArr, valueOf, Float.valueOf(0.0f), valueOf, valueOf).c(1300L).d(fArr).b();
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public x2.f[] O() {
        int[] iArr = {200, 300, 400, 100, 200, 300, 0, 100, 200};
        b[] bVarArr = new b[9];
        for (int i = 0; i < 9; i++) {
            b bVar = new b(this, null);
            bVarArr[i] = bVar;
            bVar.t(iArr[i]);
        }
        return bVarArr;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = (int) (a2.width() * 0.33f);
        int height = (int) (a2.height() * 0.33f);
        for (int i = 0; i < L(); i++) {
            int i2 = a2.left + ((i % 3) * width);
            int i3 = a2.top + ((i / 3) * height);
            K(i).v(i2, i3, i2 + width, i3 + height);
        }
    }
}
