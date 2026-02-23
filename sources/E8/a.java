package e8;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends d8.a {
    public float[] i = {1.0f, 1.0f, 1.0f};

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.n(a.this)[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.h();
        }
    }

    public static /* synthetic */ float[] n(a aVar) {
        return aVar.i;
    }

    public void b(Canvas canvas, Paint paint) {
        float min = (Math.min(e(), d()) - 8.0f) / 6.0f;
        float f = 2.0f * min;
        float e = (e() / 2) - (f + 4.0f);
        float d = d() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = i;
            canvas.translate((f * f2) + e + (f2 * 4.0f), d);
            float f3 = this.i[i];
            canvas.scale(f3, f3);
            canvas.drawCircle(0.0f, 0.0f, min, paint);
            canvas.restore();
        }
    }

    public ArrayList g() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {120, 240, 360};
        for (int i = 0; i < 3; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.3f, 1.0f});
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i]);
            a(ofFloat, new a(i));
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
