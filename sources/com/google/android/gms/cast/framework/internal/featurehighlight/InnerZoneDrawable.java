package com.google.android.gms.cast.framework.internal.featurehighlight;

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
import androidx.annotation.Keep;
import com.google.android.gms.internal.cast.zzek;
import o4.o;
import o4.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class InnerZoneDrawable extends Drawable {
    public final Paint a;
    public final Paint b;
    public final Rect c;
    public final int d;
    public final int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;

    public InnerZoneDrawable(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        Paint paint2 = new Paint();
        this.b = paint2;
        this.c = new Rect();
        this.g = 1.0f;
        Resources resources = context.getResources();
        this.d = resources.getDimensionPixelSize(o.d);
        this.e = resources.getInteger(r.a);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
        paint2.setColor(-1);
    }

    public final Animator a() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0}), PropertyValuesHolder.ofFloat("pulseScale", new float[]{0.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{0.0f})});
        ofPropertyValuesHolder.setInterpolator(zzek.zza());
        return ofPropertyValuesHolder.setDuration(200L);
    }

    public final void b(Rect rect) {
        this.c.set(rect);
        this.h = this.c.exactCenterX();
        this.i = this.c.exactCenterY();
        this.f = Math.max(this.d, Math.max(this.c.width() / 2.0f, this.c.height() / 2.0f));
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        float f = this.k;
        if (f > 0.0f) {
            float f2 = this.f * this.j;
            this.b.setAlpha((int) (this.e * f));
            canvas.drawCircle(this.h, this.i, f2, this.b);
        }
        canvas.drawCircle(this.h, this.i, this.f * this.g, this.a);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setPulseAlpha(float f) {
        this.k = f;
        invalidateSelf();
    }

    @Keep
    public void setPulseScale(float f) {
        this.j = f;
        invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.g = f;
        invalidateSelf();
    }
}
