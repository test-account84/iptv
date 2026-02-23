package y2;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class n extends x2.g {

    public class a extends x2.c {
        public int I;

        public a(int i) {
            this.I = i;
        }

        public ValueAnimator r() {
            float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            v2.d i = new v2.d(this).i(fArr, 0, -90, -179, -180, -270, -360);
            Float valueOf = Float.valueOf(0.0f);
            Float valueOf2 = Float.valueOf(0.75f);
            v2.d p = i.o(fArr, valueOf, valueOf2, valueOf2, valueOf2, valueOf, valueOf).p(fArr, valueOf, valueOf, valueOf2, valueOf2, valueOf2, valueOf);
            Float valueOf3 = Float.valueOf(1.0f);
            Float valueOf4 = Float.valueOf(0.5f);
            v2.d d = p.l(fArr, valueOf3, valueOf4, valueOf3, valueOf3, valueOf4, valueOf3).c(1800L).d(fArr);
            if (Build.VERSION.SDK_INT >= 24) {
                d.n(this.I);
            }
            return d.b();
        }
    }

    public void N(x2.f... fVarArr) {
        super.N(fVarArr);
        if (Build.VERSION.SDK_INT < 24) {
            fVarArr[1].t(-900);
        }
    }

    public x2.f[] O() {
        return new x2.f[]{new a(0), new a(3)};
    }

    public void onBoundsChange(Rect rect) {
        Rect a2 = a(rect);
        super.onBoundsChange(a2);
        for (int i = 0; i < L(); i++) {
            x2.f K = K(i);
            int i2 = a2.left;
            K.v(i2, a2.top, (a2.width() / 4) + i2, a2.top + (a2.height() / 4));
        }
    }
}
