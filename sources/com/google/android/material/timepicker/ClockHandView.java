package com.google.android.material.timepicker;

import P.L;
import R4.k;
import R4.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class ClockHandView extends View {
    public ValueAnimator a;
    public boolean c;
    public float d;
    public float e;
    public boolean f;
    public int g;
    public final List h;
    public final int i;
    public final float j;
    public final Paint k;
    public final RectF l;
    public final int m;
    public float n;
    public boolean o;
    public double p;
    public int q;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.a(ClockHandView.this, ((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.w);
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, float f, boolean z) {
        clockHandView.m(f, z);
    }

    public void b(c cVar) {
        this.h.add(cVar);
    }

    public final void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float cos = (this.q * ((float) Math.cos(this.p))) + width;
        float f = height;
        float sin = (this.q * ((float) Math.sin(this.p))) + f;
        this.k.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.i, this.k);
        double sin2 = Math.sin(this.p);
        double cos2 = Math.cos(this.p);
        this.k.setStrokeWidth(this.m);
        canvas.drawLine(width, f, r1 + ((int) (cos2 * r6)), height + ((int) (r6 * sin2)), this.k);
        canvas.drawCircle(width, f, this.j, this.k);
    }

    public RectF d() {
        return this.l;
    }

    public final int e(float f, float f2) {
        int degrees = (int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)));
        int i = degrees + 90;
        return i < 0 ? degrees + 450 : i;
    }

    public float f() {
        return this.n;
    }

    public int g() {
        return this.i;
    }

    public final Pair h(float f) {
        float f2 = f();
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (f2 < 180.0f && f > 180.0f) {
                f2 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f2), Float.valueOf(f));
    }

    public final boolean i(float f, float f2, boolean z, boolean z2, boolean z3) {
        float e = e(f, f2);
        boolean z4 = false;
        boolean z5 = f() != e;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.c) {
            z4 = true;
        }
        l(e, z4);
        return true;
    }

    public void j(int i) {
        this.q = i;
        invalidate();
    }

    public void k(float f) {
        l(f, false);
    }

    public void l(float f, boolean z) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            m(f, false);
            return;
        }
        Pair h = h(f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((Float) h.first).floatValue(), ((Float) h.second).floatValue()});
        this.a = ofFloat;
        ofFloat.setDuration(200L);
        this.a.addUpdateListener(new a());
        this.a.addListener(new b());
        this.a.start();
    }

    public final void m(float f, boolean z) {
        float f2 = f % 360.0f;
        this.n = f2;
        this.p = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.q * ((float) Math.cos(this.p)));
        float sin = height + (this.q * ((float) Math.sin(this.p)));
        RectF rectF = this.l;
        int i = this.i;
        rectF.set(width - i, sin - i, width + i, sin + i);
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(f2, z);
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        k(f());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.d = x;
            this.e = y;
            this.f = true;
            this.o = false;
            z = false;
            z2 = true;
        } else {
            if (actionMasked == 1 || actionMasked == 2) {
                int i = (int) (x - this.d);
                int i2 = (int) (y - this.e);
                this.f = (i * i) + (i2 * i2) > this.g;
                z = this.o;
                z3 = actionMasked == 1;
                z2 = false;
                this.o |= i(x, y, z, z2, z3);
                return true;
            }
            z = false;
            z2 = false;
        }
        z3 = false;
        this.o |= i(x, y, z, z2, z3);
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new ArrayList();
        Paint paint = new Paint();
        this.k = paint;
        this.l = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.t1, i, k.u);
        this.q = obtainStyledAttributes.getDimensionPixelSize(l.v1, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(l.w1, 0);
        this.m = getResources().getDimensionPixelSize(R4.d.m);
        this.j = r6.getDimensionPixelSize(R4.d.k);
        int color = obtainStyledAttributes.getColor(l.u1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        L.C0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
