package y2;

import android.animation.ValueAnimator;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends x2.g {

    public class a extends x2.b {
        public a() {
            setAlpha(153);
            C(0.0f);
        }

        public ValueAnimator r() {
            Float valueOf = Float.valueOf(0.0f);
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new v2.d(this).l(fArr, valueOf, Float.valueOf(1.0f), valueOf).c(2000L).d(fArr).b();
        }
    }

    public void N(x2.f... fVarArr) {
        x2.f fVar;
        int i;
        super.N(fVarArr);
        if (Build.VERSION.SDK_INT >= 24) {
            fVar = fVarArr[1];
            i = 1000;
        } else {
            fVar = fVarArr[1];
            i = -1000;
        }
        fVar.t(i);
    }

    public x2.f[] O() {
        return new x2.f[]{new a(), new a()};
    }
}
