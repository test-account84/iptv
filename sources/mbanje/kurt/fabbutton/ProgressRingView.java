package mbanje.kurt.fabbutton;

import M8.e;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import mbanje.kurt.fabbutton.CircleImageView;
import mbanje.kurt.fabbutton.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ProgressRingView extends View implements a.g {
    public String a;
    public Paint c;
    public int d;
    public RectF e;
    public float f;
    public int g;
    public float h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public float m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float t;
    public ValueAnimator u;
    public ValueAnimator v;
    public AnimatorSet w;
    public CircleImageView.b x;

    public class a extends AnimatorListenerAdapter {
        public boolean a = false;

        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            ProgressRingView.this.c();
        }
    }

    public ProgressRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = ProgressRingView.class.getSimpleName();
        this.d = 0;
        this.f = 0.14f;
        this.h = 0.14f;
        this.r = -16777216;
        b(attributeSet, 0);
    }

    public void a(float f, float f2, float f3, float f4) {
        CircleImageView.b bVar;
        if (f != -1.0f) {
            this.m = f;
        }
        if (f2 != -1.0f) {
            this.n = f2;
        }
        if (f3 != -1.0f) {
            this.s = f3;
        }
        if (f4 != -1.0f) {
            this.t = f4;
            if (Math.round(f4) != 100 || (bVar = this.x) == null) {
                return;
            }
            bVar.a();
        }
    }

    public void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.a, i, 0);
        this.k = obtainStyledAttributes.getFloat(e.d, 0.0f);
        this.r = obtainStyledAttributes.getColor(e.n, this.r);
        this.l = obtainStyledAttributes.getFloat(e.c, 100.0f);
        this.i = obtainStyledAttributes.getBoolean(e.e, false);
        this.j = obtainStyledAttributes.getBoolean(e.k, true);
        this.q = obtainStyledAttributes.getInteger(e.f, 4000);
        this.h = obtainStyledAttributes.getFloat(e.o, this.h);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setColor(this.r);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeCap(Paint.Cap.BUTT);
        if (this.j) {
            e();
        }
    }

    public void c() {
        int i = 0;
        f(false);
        boolean z = this.i;
        this.s = -90.0f;
        if (!z) {
            ValueAnimator c = mbanje.kurt.fabbutton.a.c(this, -90.0f, 270.0f, this);
            this.u = c;
            c.start();
            this.t = 0.0f;
            ValueAnimator b = mbanje.kurt.fabbutton.a.b(this, 0.0f, this.k, this);
            this.v = b;
            b.start();
            return;
        }
        this.m = 15.0f;
        this.w = new AnimatorSet();
        Animator animator = null;
        while (i < 4) {
            Animator a2 = mbanje.kurt.fabbutton.a.a(this, i, this.q, this);
            AnimatorSet.Builder play = this.w.play(a2);
            if (animator != null) {
                play.after(animator);
            }
            i++;
            animator = a2;
        }
        this.w.addListener(new a());
        this.w.start();
    }

    public void d(int i, boolean z) {
        if (z) {
            i = Math.round(this.g * this.h);
        }
        this.o = i;
        int i2 = this.o;
        this.p = i2 / 2;
        this.c.setStrokeWidth(i2);
        g();
    }

    public void e() {
        c();
    }

    public void f(boolean z) {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.u.cancel();
        }
        ValueAnimator valueAnimator2 = this.v;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.v.cancel();
        }
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.w.cancel();
        }
        if (z) {
            d(0, false);
        } else {
            d(0, true);
        }
        invalidate();
    }

    public final void g() {
        int i = this.p;
        int i2 = this.d;
        this.e = new RectF(i, i, i2 - i, i2 - i);
    }

    public void onDraw(Canvas canvas) {
        float f = ((isInEditMode() ? this.k : this.t) / this.l) * 360.0f;
        if (this.i) {
            canvas.drawArc(this.e, this.s + this.n, this.m, false, this.c);
        } else {
            canvas.drawArc(this.e, this.s, f, false, this.c);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int min = Math.min(i, i2);
        this.d = min;
        this.g = min / 2;
        d(-1, true);
    }

    public void setAnimDuration(int i) {
        this.q = i;
    }

    public void setAutostartanim(boolean z) {
        this.j = z;
    }

    public void setFabViewListener(CircleImageView.b bVar) {
        this.x = bVar;
    }

    public void setIndeterminate(boolean z) {
        this.i = z;
    }

    public void setMaxProgress(float f) {
        this.l = f;
    }

    public void setProgress(float f) {
        this.k = f;
        if (!this.i) {
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.v.cancel();
            }
            ValueAnimator b = mbanje.kurt.fabbutton.a.b(this, this.t, f, this);
            this.v = b;
            b.start();
        }
        invalidate();
    }

    public void setProgressColor(int i) {
        this.r = i;
        this.c.setColor(i);
    }

    public void setRingWidthRatio(float f) {
        this.h = f;
    }
}
