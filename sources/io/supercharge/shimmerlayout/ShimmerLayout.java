package io.supercharge.shimmerlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import s2.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ShimmerLayout extends FrameLayout {
    public int a;
    public Rect c;
    public Paint d;
    public ValueAnimator e;
    public Bitmap f;
    public Bitmap g;
    public Canvas h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public ViewTreeObserver.OnPreDrawListener q;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ShimmerLayout.this.n();
            return true;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int c;

        public b(int i, int i2) {
            this.a = i;
            this.c = i2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerLayout.b(ShimmerLayout.this, this.a + ((Integer) valueAnimator.getAnimatedValue()).intValue());
            if (ShimmerLayout.a(ShimmerLayout.this) + this.c >= 0) {
                ShimmerLayout.this.invalidate();
            }
        }
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ int a(ShimmerLayout shimmerLayout) {
        return shimmerLayout.a;
    }

    public static /* synthetic */ int b(ShimmerLayout shimmerLayout, int i) {
        shimmerLayout.a = i;
        return i;
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = {0.0f, 0.5f - (r1 / 2.0f), (r1 / 2.0f) + 0.5f, 1.0f};
        float f = this.p;
        return fArr;
    }

    private Bitmap getMaskBitmap() {
        if (this.g == null) {
            this.g = e(this.c.width(), getHeight());
        }
        return this.g;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.c == null) {
            this.c = c();
        }
        int width = getWidth();
        int i = getWidth() > this.c.width() ? -width : -this.c.width();
        int width2 = this.c.width();
        int i2 = width - i;
        ValueAnimator ofInt = this.i ? ValueAnimator.ofInt(new int[]{i2, 0}) : ValueAnimator.ofInt(new int[]{0, i2});
        this.e = ofInt;
        ofInt.setDuration(this.l);
        this.e.setRepeatCount(-1);
        this.e.addUpdateListener(new b(i, width2));
        return this.e;
    }

    public final Rect c() {
        return new Rect(0, 0, d(), getHeight());
    }

    public final int d() {
        return (int) ((((getWidth() / 2) * this.o) / Math.cos(Math.toRadians(Math.abs(this.n)))) + (getHeight() * Math.tan(Math.toRadians(Math.abs(this.n)))));
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.j || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            g(canvas);
        }
    }

    public final Bitmap e(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    public final void f() {
        if (this.d != null) {
            return;
        }
        int j = j(this.m);
        float width = (getWidth() / 2) * this.o;
        float height = this.n >= 0 ? getHeight() : 0.0f;
        float cos = ((float) Math.cos(Math.toRadians(this.n))) * width;
        float sin = height + (((float) Math.sin(Math.toRadians(this.n))) * width);
        int i = this.m;
        int[] iArr = {j, i, i, j};
        float[] gradientColorDistribution = getGradientColorDistribution();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        ComposeShader composeShader = new ComposeShader(new LinearGradient(0.0f, height, cos, sin, iArr, gradientColorDistribution, tileMode), new BitmapShader(this.f, tileMode, tileMode), PorterDuff.Mode.DST_IN);
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setFilterBitmap(true);
        this.d.setShader(composeShader);
    }

    public final void g(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.f = maskBitmap;
        if (maskBitmap == null) {
            return;
        }
        if (this.h == null) {
            this.h = new Canvas(this.f);
        }
        this.h.drawColor(0, PorterDuff.Mode.CLEAR);
        this.h.save();
        this.h.translate(-this.a, 0.0f);
        super.dispatchDraw(this.h);
        this.h.restore();
        h(canvas);
        this.f = null;
    }

    public final void h(Canvas canvas) {
        f();
        canvas.save();
        canvas.translate(this.a, 0.0f);
        Rect rect = this.c;
        canvas.drawRect(rect.left, 0.0f, rect.width(), this.c.height(), this.d);
        canvas.restore();
    }

    public final int i(int i) {
        return Build.VERSION.SDK_INT >= 23 ? e.a(getContext(), i) : getResources().getColor(i);
    }

    public final int j(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    public final void k() {
        this.h = null;
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
            this.g = null;
        }
    }

    public final void l() {
        if (this.j) {
            m();
            n();
        }
    }

    public final void m() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.e.removeAllUpdateListeners();
        }
        this.e = null;
        this.d = null;
        this.j = false;
        k();
    }

    public void n() {
        if (this.j) {
            return;
        }
        if (getWidth() == 0) {
            this.q = new a();
            getViewTreeObserver().addOnPreDrawListener(this.q);
        } else {
            getShimmerAnimation().start();
            this.j = true;
        }
    }

    public void o() {
        if (this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        m();
    }

    public void onDetachedFromWindow() {
        m();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z) {
        this.i = z;
        l();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.p = f;
        l();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.o = f;
        l();
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", new Object[]{(byte) -45, (byte) 45}));
        }
        this.n = i;
        l();
    }

    public void setShimmerAnimationDuration(int i) {
        this.l = i;
        l();
    }

    public void setShimmerColor(int i) {
        this.m = i;
        l();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            o();
        } else if (this.k) {
            n();
        }
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i8.b.a, 0, 0);
        try {
            this.n = obtainStyledAttributes.getInteger(i8.b.b, 20);
            this.l = obtainStyledAttributes.getInteger(i8.b.c, 1500);
            this.m = obtainStyledAttributes.getColor(i8.b.e, i(i8.a.a));
            this.k = obtainStyledAttributes.getBoolean(i8.b.d, false);
            this.o = obtainStyledAttributes.getFloat(i8.b.g, 0.5f);
            this.p = obtainStyledAttributes.getFloat(i8.b.f, 0.1f);
            this.i = obtainStyledAttributes.getBoolean(i8.b.h, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.o);
            setGradientCenterColorWidth(this.p);
            setShimmerAngle(this.n);
            if (this.k && getVisibility() == 0) {
                n();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
