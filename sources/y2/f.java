package y2;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends x2.g {
    public boolean H = false;

    public class a extends x2.c {
        public a() {
            setAlpha(0);
            A(-180);
        }

        public ValueAnimator r() {
            float[] fArr = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            return new v2.d(this).a(fArr, 0, 0, 255, 255, 0, 0).j(fArr, -180, -180, 0, 0, 0, 0).k(fArr, 0, 0, 0, 0, 180, 180).c(2400L).h(new LinearInterpolator()).b();
        }
    }

    public void J(Canvas canvas) {
        Rect a2 = a(getBounds());
        for (int i = 0; i < L(); i++) {
            int save = canvas.save();
            canvas.rotate((i * 90) + 45, a2.centerX(), a2.centerY());
            K(i).draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public x2.f[] O() {
        a[] aVarArr = new a[4];
        for (int i = 0; i < 4; i++) {
            a aVar = new a();
            aVarArr[i] = aVar;
            aVar.t(Build.VERSION.SDK_INT >= 24 ? i * 300 : (i * 300) - 1200);
        }
        return aVarArr;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int min = Math.min(a2.width(), a2.height());
        if (this.H) {
            min = (int) Math.sqrt((min * min) / 2);
            int width = (a2.width() - min) / 2;
            int height = (a2.height() - min) / 2;
            a2 = new Rect(a2.left + width, a2.top + height, a2.right - width, a2.bottom - height);
        }
        int i = min / 2;
        int i2 = a2.left + i + 1;
        int i3 = a2.top + i + 1;
        for (int i4 = 0; i4 < L(); i4++) {
            x2.f K = K(i4);
            K.v(a2.left, a2.top, i2, i3);
            K.x(K.d().right);
            K.y(K.d().bottom);
        }
    }
}
