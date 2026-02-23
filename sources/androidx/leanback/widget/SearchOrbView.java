package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    public View.OnClickListener a;
    public View c;
    public View d;
    public ImageView e;
    public Drawable f;
    public c g;
    public final float h;
    public final int i;
    public final int j;
    public final float k;
    public final float l;
    public ValueAnimator m;
    public boolean n;
    public boolean o;
    public final ArgbEvaluator p;
    public final ValueAnimator.AnimatorUpdateListener q;
    public ValueAnimator r;
    public final ValueAnimator.AnimatorUpdateListener s;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SearchOrbView.this.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SearchOrbView.this.setSearchOrbZ(valueAnimator.getAnimatedFraction());
        }
    }

    public static class c {
        public int a;
        public int b;
        public int c;

        public c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2 == i ? a(i) : i2;
            this.c = i3;
        }

        public static int a(int i) {
            return Color.argb((int) ((Color.alpha(i) * 0.85f) + 38.25f), (int) ((Color.red(i) * 0.85f) + 38.25f), (int) ((Color.green(i) * 0.85f) + 38.25f), (int) ((Color.blue(i) * 0.85f) + 38.25f));
        }
    }

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g0.a.c);
    }

    public void a(boolean z) {
        float f = z ? this.h : 1.0f;
        this.c.animate().scaleX(f).scaleY(f).setDuration(this.j).start();
        d(z, this.j);
        b(z);
    }

    public void b(boolean z) {
        this.n = z;
        e();
    }

    public void c(float f) {
        this.d.setScaleX(f);
        this.d.setScaleY(f);
    }

    public final void d(boolean z, int i) {
        if (this.r == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.r = ofFloat;
            ofFloat.addUpdateListener(this.s);
        }
        if (z) {
            this.r.start();
        } else {
            this.r.reverse();
        }
        this.r.setDuration(i);
    }

    public final void e() {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.m = null;
        }
        if (this.n && this.o) {
            ValueAnimator ofObject = ValueAnimator.ofObject(this.p, new Object[]{Integer.valueOf(this.g.a), Integer.valueOf(this.g.b), Integer.valueOf(this.g.a)});
            this.m = ofObject;
            ofObject.setRepeatCount(-1);
            this.m.setDuration(this.i * 2);
            this.m.addUpdateListener(this.q);
            this.m.start();
        }
    }

    public float getFocusedZoom() {
        return this.h;
    }

    public int getLayoutResourceId() {
        return g0.h.k;
    }

    public int getOrbColor() {
        return this.g.a;
    }

    public c getOrbColors() {
        return this.g;
    }

    public Drawable getOrbIcon() {
        return this.f;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o = true;
        e();
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void onDetachedFromWindow() {
        this.o = false;
        e();
        super.onDetachedFromWindow();
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        a(z);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    public void setOrbColor(int i) {
        setOrbColors(new c(i, i, 0));
    }

    public void setOrbColors(c cVar) {
        this.g = cVar;
        this.e.setColorFilter(cVar.c);
        if (this.m == null) {
            setOrbViewColor(this.g.a);
        } else {
            b(true);
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.f = drawable;
        this.e.setImageDrawable(drawable);
    }

    public void setOrbViewColor(int i) {
        if (this.d.getBackground() instanceof GradientDrawable) {
            this.d.getBackground().setColor(i);
        }
    }

    public void setSearchOrbZ(float f) {
        View view = this.d;
        float f2 = this.k;
        P.L.O0(view, f2 + (f * (this.l - f2)));
    }

    public SearchOrbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new ArgbEvaluator();
        this.q = new a();
        this.s = new b();
        Resources resources = context.getResources();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), this, true);
        this.c = inflate;
        this.d = inflate.findViewById(g0.f.A);
        this.e = this.c.findViewById(g0.f.j);
        this.h = context.getResources().getFraction(g0.e.g, 1, 1);
        this.i = context.getResources().getInteger(g0.g.d);
        this.j = context.getResources().getInteger(g0.g.e);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(g0.c.v);
        this.l = dimensionPixelSize;
        this.k = context.getResources().getDimensionPixelSize(g0.c.w);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.l.Z, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(g0.l.c0);
        setOrbIcon(drawable == null ? resources.getDrawable(g0.d.a) : drawable);
        int color = obtainStyledAttributes.getColor(g0.l.b0, resources.getColor(g0.b.a));
        setOrbColors(new c(color, obtainStyledAttributes.getColor(g0.l.a0, color), obtainStyledAttributes.getColor(g0.l.d0, 0)));
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        P.L.O0(this.e, dimensionPixelSize);
    }
}
