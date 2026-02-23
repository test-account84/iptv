package y2;

import android.animation.ValueAnimator;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends x2.a {

    public class a extends x2.b {
        public a() {
            setAlpha(0);
        }

        public ValueAnimator r() {
            float[] fArr = {0.0f, 0.39f, 0.4f, 1.0f};
            return new v2.d(this).a(fArr, 0, 0, 255, 0).c(1200L).d(fArr).b();
        }
    }

    public x2.f[] O() {
        a[] aVarArr = new a[12];
        for (int i = 0; i < 12; i++) {
            a aVar = new a();
            aVarArr[i] = aVar;
            aVar.t(Build.VERSION.SDK_INT >= 24 ? i * 100 : (i * 100) - 1200);
        }
        return aVarArr;
    }
}
