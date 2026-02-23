package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SeekBar extends View {
    public final RectF a;
    public final RectF c;
    public final RectF d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public static abstract class a {
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new RectF();
        this.c = new RectF();
        this.d = new RectF();
        Paint paint = new Paint(1);
        this.e = paint;
        Paint paint2 = new Paint(1);
        this.f = paint2;
        Paint paint3 = new Paint(1);
        this.g = paint3;
        Paint paint4 = new Paint(1);
        this.h = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(-65536);
        paint4.setColor(-1);
        this.n = context.getResources().getDimensionPixelSize(g0.c.p);
        this.o = context.getResources().getDimensionPixelSize(g0.c.n);
        this.m = context.getResources().getDimensionPixelSize(g0.c.o);
    }

    public final void a() {
        int i = isFocused() ? this.o : this.n;
        int width = getWidth();
        int height = getHeight();
        int i2 = (height - i) / 2;
        RectF rectF = this.d;
        int i3 = this.n;
        float f = i2;
        float f2 = height - i2;
        rectF.set(i3 / 2, f, width - (i3 / 2), f2);
        int i4 = isFocused() ? this.m : this.n / 2;
        float f3 = width - (i4 * 2);
        float f4 = (this.i / this.k) * f3;
        RectF rectF2 = this.a;
        int i5 = this.n;
        rectF2.set(i5 / 2, f, (i5 / 2) + f4, f2);
        this.c.set(this.a.right, f, (this.n / 2) + ((this.j / this.k) * f3), f2);
        this.l = i4 + ((int) f4);
        invalidate();
    }

    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.k;
    }

    public int getProgress() {
        return this.i;
    }

    public int getSecondProgress() {
        return this.j;
    }

    public int getSecondaryProgressColor() {
        return this.e.getColor();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = isFocused() ? this.m : this.n / 2;
        canvas.drawRoundRect(this.d, f, f, this.g);
        RectF rectF = this.c;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f, f, this.e);
        }
        canvas.drawRoundRect(this.a, f, f, this.f);
        canvas.drawCircle(this.l, getHeight() / 2, f, this.h);
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        a();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return super.performAccessibilityAction(i, bundle);
    }

    public void setAccessibilitySeekListener(a aVar) {
    }

    public void setActiveBarHeight(int i) {
        this.o = i;
        a();
    }

    public void setActiveRadius(int i) {
        this.m = i;
        a();
    }

    public void setBarHeight(int i) {
        this.n = i;
        a();
    }

    public void setMax(int i) {
        this.k = i;
        a();
    }

    public void setProgress(int i) {
        int i2 = this.k;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.i = i;
        a();
    }

    public void setProgressColor(int i) {
        this.f.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.k;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.j = i;
        a();
    }

    public void setSecondaryProgressColor(int i) {
        this.e.setColor(i);
    }
}
