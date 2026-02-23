package com.google.android.gms.cast.framework.internal.featurehighlight;

import C4.m;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.google.android.gms.internal.cast.zzek;
import com.google.android.gms.internal.cast.zzel;
import o4.n;
import o4.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class OuterHighlightDrawable extends Drawable {
    public final int a;
    public final int b;
    public final int c;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Paint f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public int m;

    public OuterHighlightDrawable(Context context) {
        int color;
        Paint paint = new Paint();
        this.f = paint;
        this.h = 1.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 244;
        if (m.f()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843827, typedValue, true);
            color = G.a.o(typedValue.data, 244);
        } else {
            color = context.getResources().getColor(n.a);
        }
        paint.setColor(color);
        this.m = paint.getAlpha();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        this.a = resources.getDimensionPixelSize(o.b);
        this.b = resources.getDimensionPixelSize(o.a);
        this.c = resources.getDimensionPixelSize(o.e);
    }

    public static final float h(float f, float f2, Rect rect) {
        float f3 = rect.left;
        float f4 = rect.top;
        float f5 = rect.right;
        float f6 = rect.bottom;
        float zza = zzel.zza(f, f2, f3, f4);
        float zza2 = zzel.zza(f, f2, f5, f4);
        float zza3 = zzel.zza(f, f2, f5, f6);
        float zza4 = zzel.zza(f, f2, f3, f6);
        if (zza <= zza2 || zza <= zza3 || zza <= zza4) {
            zza = (zza2 <= zza3 || zza2 <= zza4) ? zza3 <= zza4 ? zza4 : zza3 : zza2;
        }
        return (float) Math.ceil(zza);
    }

    public final float a() {
        return this.i;
    }

    public final float b() {
        return this.j;
    }

    public final int c() {
        return this.f.getColor();
    }

    public final Animator d(float f, float f2) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("translationX", new float[]{f, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{f2, 0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, this.m})});
        ofPropertyValuesHolder.setInterpolator(zzek.zzc());
        return ofPropertyValuesHolder.setDuration(350L);
    }

    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.i + this.k, this.j + this.l, this.g * this.h, this.f);
    }

    public final void e(int i) {
        this.f.setColor(i);
        this.m = this.f.getAlpha();
        invalidateSelf();
    }

    public final void f(Rect rect, Rect rect2) {
        this.d.set(rect);
        this.e.set(rect2);
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(exactCenterY - bounds.top, bounds.bottom - exactCenterY) < this.a) {
            this.i = exactCenterX;
        } else {
            this.i = exactCenterX <= bounds.exactCenterX() ? rect2.exactCenterX() + this.b : rect2.exactCenterX() - this.b;
            exactCenterY = rect2.exactCenterY();
        }
        this.j = exactCenterY;
        this.g = this.c + Math.max(h(this.i, exactCenterY, rect), h(this.i, this.j, rect2));
        invalidateSelf();
    }

    public final boolean g(float f, float f2) {
        return zzel.zza(f, f2, this.i, this.j) < this.g;
    }

    public final int getAlpha() {
        return this.f.getAlpha();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i) {
        this.f.setAlpha(i);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.h = f;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f) {
        this.k = f;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f) {
        this.l = f;
        invalidateSelf();
    }
}
