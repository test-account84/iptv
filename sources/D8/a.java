package d8;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a extends Drawable implements Animatable {
    public static final Rect h = new Rect();
    public ArrayList c;
    public boolean f;
    public Paint g;
    public HashMap a = new HashMap();
    public int d = 255;
    public Rect e = h;

    public a() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(-1);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
    }

    public void a(ValueAnimator valueAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.a.put(valueAnimator, animatorUpdateListener);
    }

    public abstract void b(Canvas canvas, Paint paint);

    public final void c() {
        if (this.f) {
            return;
        }
        this.c = g();
        this.f = true;
    }

    public int d() {
        return this.e.height();
    }

    public void draw(Canvas canvas) {
        b(canvas, this.g);
    }

    public int e() {
        return this.e.width();
    }

    public final boolean f() {
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            return ((ValueAnimator) it.next()).isStarted();
        }
        return false;
    }

    public abstract ArrayList g();

    public int getAlpha() {
        return this.d;
    }

    public int getOpacity() {
        return -1;
    }

    public void h() {
        invalidateSelf();
    }

    public void i(int i) {
        this.g.setColor(i);
    }

    public boolean isRunning() {
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            return ((ValueAnimator) it.next()).isRunning();
        }
        return false;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.e = new Rect(i, i2, i3, i4);
    }

    public void k(Rect rect) {
        j(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void l() {
        for (int i = 0; i < this.c.size(); i++) {
            ValueAnimator valueAnimator = (ValueAnimator) this.c.get(i);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = (ValueAnimator.AnimatorUpdateListener) this.a.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
    }

    public final void m() {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                if (valueAnimator != null && valueAnimator.isStarted()) {
                    valueAnimator.removeAllUpdateListeners();
                    valueAnimator.end();
                }
            }
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        k(rect);
    }

    public void setAlpha(int i) {
        this.d = i;
    }

    public void start() {
        c();
        if (this.c == null || f()) {
            return;
        }
        l();
        invalidateSelf();
    }

    public void stop() {
        m();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
