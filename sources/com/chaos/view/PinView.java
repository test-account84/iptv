package com.chaos.view;

import F.h;
import P.L;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import k.j;
import r2.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PinView extends j {
    public static final InputFilter[] K = new InputFilter[0];
    public static final int[] L = {16842913};
    public c A;
    public boolean B;
    public boolean C;
    public float D;
    public int E;
    public int F;
    public int G;
    public Drawable H;
    public boolean I;
    public String J;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final Paint n;
    public final TextPaint o;
    public ColorStateList p;
    public int q;
    public int r;
    public final Rect s;
    public final RectF t;
    public final RectF u;
    public final Path v;
    public final PointF w;
    public ValueAnimator x;
    public boolean y;
    public boolean z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PinView.e(PinView.this).setTextSize(PinView.this.getTextSize() * floatValue);
            PinView.e(PinView.this).setAlpha((int) (255.0f * floatValue));
            PinView.this.postInvalidate();
        }
    }

    public class b extends d {
        public b() {
            super(null);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            menu.removeItem(16908355);
            return true;
        }
    }

    public class c implements Runnable {
        public boolean a;

        public c() {
        }

        public static /* synthetic */ void a(c cVar) {
            cVar.b();
        }

        public final void b() {
            if (this.a) {
                return;
            }
            PinView.this.removeCallbacks(this);
            this.a = true;
        }

        public void c() {
            this.a = false;
        }

        public void run() {
            if (this.a) {
                return;
            }
            PinView.this.removeCallbacks(this);
            if (PinView.f(PinView.this)) {
                PinView.h(PinView.this, !PinView.g(r0));
                PinView.this.postDelayed(this, 500L);
            }
        }

        public /* synthetic */ c(PinView pinView, a aVar) {
            this();
        }
    }

    public static class d implements ActionMode.Callback {
        public d() {
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public PinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, r2.c.a);
    }

    public static /* synthetic */ TextPaint e(PinView pinView) {
        return pinView.o;
    }

    public static /* synthetic */ boolean f(PinView pinView) {
        return pinView.C();
    }

    public static /* synthetic */ boolean g(PinView pinView) {
        return pinView.C;
    }

    public static /* synthetic */ void h(PinView pinView, boolean z) {
        pinView.w(z);
    }

    private void setMaxLength(int i) {
        if (i >= 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        } else {
            setFilters(K);
        }
    }

    public static boolean x(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    public final void A() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.c();
            y();
        }
    }

    public final void B() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        this.x = ofFloat;
        ofFloat.setDuration(150L);
        this.x.setInterpolator(new DecelerateInterpolator());
        this.x.addUpdateListener(new a());
    }

    public final boolean C() {
        return isCursorVisible() && isFocused();
    }

    public final void D() {
        c cVar = this.A;
        if (cVar != null) {
            c.a(cVar);
            w(false);
        }
    }

    public final void E() {
        RectF rectF = this.t;
        float abs = rectF.left + (Math.abs(rectF.width()) / 2.0f);
        RectF rectF2 = this.t;
        this.w.set(abs, rectF2.top + (Math.abs(rectF2.height()) / 2.0f));
    }

    public final void F() {
        ColorStateList colorStateList = this.p;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(getDrawableState(), 0) : getCurrentTextColor();
        if (colorForState != this.q) {
            this.q = colorForState;
            invalidate();
        }
    }

    public final void G() {
        float k = k(2.0f) * 2;
        this.D = ((float) this.k) - getTextSize() > k ? getTextSize() + k : getTextSize();
    }

    public final void H(int i) {
        float f = this.r / 2.0f;
        int scrollX = getScrollX() + L.J(this);
        int i2 = this.m;
        int i3 = this.j;
        float f2 = scrollX + ((i2 + i3) * i) + f;
        if (i2 == 0 && i > 0) {
            f2 -= this.r * i;
        }
        float scrollY = getScrollY() + getPaddingTop() + f;
        this.t.set(f2, scrollY, (i3 + f2) - this.r, (this.k + scrollY) - this.r);
    }

    public final void I() {
        this.n.setColor(this.q);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(this.r);
        getPaint().setColor(getCurrentTextColor());
    }

    public final void J(int i) {
        boolean z;
        boolean z2;
        if (this.m != 0) {
            z = true;
        } else {
            boolean z3 = i == 0 && i != this.i - 1;
            if (i != this.i - 1 || i == 0) {
                z = z3;
                z2 = false;
                RectF rectF = this.t;
                int i2 = this.l;
                K(rectF, i2, i2, z, z2);
            }
            z = z3;
        }
        z2 = true;
        RectF rectF2 = this.t;
        int i22 = this.l;
        K(rectF2, i22, i22, z, z2);
    }

    public final void K(RectF rectF, float f, float f2, boolean z, boolean z2) {
        L(rectF, f, f2, z, z2, z2, z);
    }

    public final void L(RectF rectF, float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.v.reset();
        float f3 = rectF.left;
        float f4 = rectF.top;
        float f5 = (rectF.right - f3) - (f * 2.0f);
        float f6 = (rectF.bottom - f4) - (2.0f * f2);
        this.v.moveTo(f3, f4 + f2);
        if (z) {
            float f7 = -f2;
            this.v.rQuadTo(0.0f, f7, f, f7);
        } else {
            this.v.rLineTo(0.0f, -f2);
            this.v.rLineTo(f, 0.0f);
        }
        this.v.rLineTo(f5, 0.0f);
        Path path = this.v;
        if (z2) {
            path.rQuadTo(f, 0.0f, f, f2);
        } else {
            path.rLineTo(f, 0.0f);
            this.v.rLineTo(0.0f, f2);
        }
        this.v.rLineTo(0.0f, f6);
        Path path2 = this.v;
        if (z3) {
            path2.rQuadTo(0.0f, f2, -f, f2);
        } else {
            path2.rLineTo(0.0f, f2);
            this.v.rLineTo(-f, 0.0f);
        }
        this.v.rLineTo(-f5, 0.0f);
        Path path3 = this.v;
        float f8 = -f;
        if (z4) {
            path3.rQuadTo(f8, 0.0f, f8, -f2);
        } else {
            path3.rLineTo(f8, 0.0f);
            this.v.rLineTo(0.0f, -f2);
        }
        this.v.rLineTo(0.0f, -f6);
        this.v.close();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.p;
        if (colorStateList == null || colorStateList.isStateful()) {
            F();
        }
    }

    public int getCurrentLineColor() {
        return this.q;
    }

    public int getCursorColor() {
        return this.F;
    }

    public int getCursorWidth() {
        return this.E;
    }

    public MovementMethod getDefaultMovementMethod() {
        return r2.a.a();
    }

    public int getItemCount() {
        return this.i;
    }

    public int getItemHeight() {
        return this.k;
    }

    public int getItemRadius() {
        return this.l;
    }

    public int getItemSpacing() {
        return this.m;
    }

    public int getItemWidth() {
        return this.j;
    }

    public ColorStateList getLineColors() {
        return this.p;
    }

    public int getLineWidth() {
        return this.r;
    }

    public final void i() {
        int i = this.h;
        if (i == 1) {
            if (this.l > this.r / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i == 0) {
            if (this.l > this.j / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    public boolean isCursorVisible() {
        return this.B;
    }

    public boolean isSuggestionsEnabled() {
        return false;
    }

    public final void j() {
        setCustomSelectionActionModeCallback(new d(null));
        if (Build.VERSION.SDK_INT >= 26) {
            r2.b.a(this, new b());
        }
    }

    public final int k(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void l(Canvas canvas, int i) {
        Paint v = v(i);
        PointF pointF = this.w;
        canvas.drawCircle(pointF.x, pointF.y, v.getTextSize() / 2.0f, v);
    }

    public final void m(Canvas canvas) {
        if (this.C) {
            PointF pointF = this.w;
            float f = pointF.x;
            float f2 = pointF.y - (this.D / 2.0f);
            int color = this.n.getColor();
            float strokeWidth = this.n.getStrokeWidth();
            this.n.setColor(this.F);
            this.n.setStrokeWidth(this.E);
            canvas.drawLine(f, f2, f, f2 + this.D, this.n);
            this.n.setColor(color);
            this.n.setStrokeWidth(strokeWidth);
        }
    }

    public final void n(Canvas canvas, int i) {
        Paint v = v(i);
        v.setColor(getCurrentHintTextColor());
        t(canvas, v, getHint(), i);
    }

    public final void o(Canvas canvas, boolean z) {
        if (this.H == null) {
            return;
        }
        float f = this.r / 2.0f;
        this.H.setBounds(Math.round(this.t.left - f), Math.round(this.t.top - f), Math.round(this.t.right + f), Math.round(this.t.bottom + f));
        this.H.setState(z ? L : getDrawableState());
        this.H.draw(canvas);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D();
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        I();
        r(canvas);
        canvas.restore();
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            z();
            y();
        }
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.k;
        if (mode != 1073741824) {
            int i4 = this.i;
            size = L.J(this) + ((i4 - 1) * this.m) + (i4 * this.j) + L.I(this);
            if (this.m == 0) {
                size -= (this.i - 1) * this.r;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingBottom() + i3 + getPaddingTop();
        }
        setMeasuredDimension(size, size2);
    }

    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (i == 0) {
            D();
        } else {
            if (i != 1) {
                return;
            }
            A();
        }
    }

    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (i2 != getText().length()) {
            z();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ValueAnimator valueAnimator;
        if (i != charSequence.length()) {
            z();
        }
        y();
        if (this.y && i3 - i2 > 0 && (valueAnimator = this.x) != null) {
            valueAnimator.end();
            this.x.start();
        }
        TransformationMethod transformationMethod = getTransformationMethod();
        this.J = transformationMethod == null ? getText().toString() : transformationMethod.getTransformation(getText(), this).toString();
    }

    public final void p(Canvas canvas, int i) {
        if (!this.I || i >= getText().length()) {
            canvas.drawPath(this.v, this.n);
        }
    }

    public final void q(Canvas canvas, int i) {
        boolean z;
        boolean z2;
        int i2;
        if (!this.I || i >= getText().length()) {
            if (this.m == 0 && (i2 = this.i) > 1) {
                if (i != 0) {
                    z = false;
                    if (i == i2 - 1) {
                    }
                    this.n.setStyle(Paint.Style.FILL);
                    this.n.setStrokeWidth(this.r / 10.0f);
                    float f = this.r / 2.0f;
                    RectF rectF = this.u;
                    RectF rectF2 = this.t;
                    float f2 = rectF2.left - f;
                    float f3 = rectF2.bottom;
                    rectF.set(f2, f3 - f, rectF2.right + f, f3 + f);
                    RectF rectF3 = this.u;
                    int i3 = this.l;
                    K(rectF3, i3, i3, z, z2);
                    canvas.drawPath(this.v, this.n);
                }
                z = true;
                z2 = false;
                this.n.setStyle(Paint.Style.FILL);
                this.n.setStrokeWidth(this.r / 10.0f);
                float f4 = this.r / 2.0f;
                RectF rectF4 = this.u;
                RectF rectF22 = this.t;
                float f22 = rectF22.left - f4;
                float f32 = rectF22.bottom;
                rectF4.set(f22, f32 - f4, rectF22.right + f4, f32 + f4);
                RectF rectF32 = this.u;
                int i32 = this.l;
                K(rectF32, i32, i32, z, z2);
                canvas.drawPath(this.v, this.n);
            }
            z = true;
            z2 = true;
            this.n.setStyle(Paint.Style.FILL);
            this.n.setStrokeWidth(this.r / 10.0f);
            float f42 = this.r / 2.0f;
            RectF rectF42 = this.u;
            RectF rectF222 = this.t;
            float f222 = rectF222.left - f42;
            float f322 = rectF222.bottom;
            rectF42.set(f222, f322 - f42, rectF222.right + f42, f322 + f42);
            RectF rectF322 = this.u;
            int i322 = this.l;
            K(rectF322, i322, i322, z, z2);
            canvas.drawPath(this.v, this.n);
        }
    }

    public final void r(Canvas canvas) {
        int length = getText().length();
        int i = 0;
        while (i < this.i) {
            boolean z = isFocused() && length == i;
            this.n.setColor(z ? u(L) : this.q);
            H(i);
            E();
            canvas.save();
            if (this.h == 0) {
                J(i);
                canvas.clipPath(this.v);
            }
            o(canvas, z);
            canvas.restore();
            if (z) {
                m(canvas);
            }
            int i2 = this.h;
            if (i2 == 0) {
                p(canvas, i);
            } else if (i2 == 1) {
                q(canvas, i);
            }
            if (this.J.length() > i) {
                if (getTransformationMethod() == null && this.z) {
                    l(canvas, i);
                } else {
                    s(canvas, i);
                }
            } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.i) {
                n(canvas, i);
            }
            i++;
        }
        if (isFocused() && getText().length() != this.i && this.h == 0) {
            int length2 = getText().length();
            H(length2);
            E();
            J(length2);
            this.n.setColor(u(L));
            p(canvas, length2);
        }
    }

    public final void s(Canvas canvas, int i) {
        t(canvas, v(i), this.J, i);
    }

    public void setAnimationEnable(boolean z) {
        this.y = z;
    }

    public void setCursorColor(int i) {
        this.F = i;
        if (isCursorVisible()) {
            w(true);
        }
    }

    public void setCursorVisible(boolean z) {
        if (this.B != z) {
            this.B = z;
            w(z);
            y();
        }
    }

    public void setCursorWidth(int i) {
        this.E = i;
        if (isCursorVisible()) {
            w(true);
        }
    }

    public void setHideLineWhenFilled(boolean z) {
        this.I = z;
    }

    public void setInputType(int i) {
        super.setInputType(i);
        this.z = x(getInputType());
    }

    public void setItemBackground(Drawable drawable) {
        this.G = 0;
        this.H = drawable;
        invalidate();
    }

    public void setItemBackgroundColor(int i) {
        Drawable drawable = this.H;
        if (!(drawable instanceof ColorDrawable)) {
            setItemBackground(new ColorDrawable(i));
        } else {
            drawable.mutate().setColor(i);
            this.G = 0;
        }
    }

    public void setItemBackgroundResources(int i) {
        if (i == 0 || this.G == i) {
            Drawable f = h.f(getResources(), i, getContext().getTheme());
            this.H = f;
            setItemBackground(f);
            this.G = i;
        }
    }

    public void setItemCount(int i) {
        this.i = i;
        setMaxLength(i);
        requestLayout();
    }

    public void setItemHeight(int i) {
        this.k = i;
        G();
        requestLayout();
    }

    public void setItemRadius(int i) {
        this.l = i;
        i();
        requestLayout();
    }

    public void setItemSpacing(int i) {
        this.m = i;
        requestLayout();
    }

    public void setItemWidth(int i) {
        this.j = i;
        i();
        requestLayout();
    }

    public void setLineColor(int i) {
        this.p = ColorStateList.valueOf(i);
        F();
    }

    public void setLineWidth(int i) {
        this.r = i;
        i();
        requestLayout();
    }

    public void setPasswordHidden(boolean z) {
        this.z = z;
        requestLayout();
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        G();
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.o;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    public final void t(Canvas canvas, Paint paint, CharSequence charSequence, int i) {
        int i2 = i + 1;
        paint.getTextBounds(charSequence.toString(), i, i2, this.s);
        PointF pointF = this.w;
        float f = pointF.x;
        float f2 = pointF.y;
        float abs = f - (Math.abs(this.s.width()) / 2.0f);
        Rect rect = this.s;
        canvas.drawText(charSequence, i, i2, abs - rect.left, (f2 + (Math.abs(rect.height()) / 2.0f)) - this.s.bottom, paint);
    }

    public final int u(int... iArr) {
        ColorStateList colorStateList = this.p;
        return colorStateList != null ? colorStateList.getColorForState(iArr, this.q) : this.q;
    }

    public final Paint v(int i) {
        if (!this.y || i != getText().length() - 1) {
            return getPaint();
        }
        this.o.setColor(getPaint().getColor());
        return this.o;
    }

    public final void w(boolean z) {
        if (this.C != z) {
            this.C = z;
            invalidate();
        }
    }

    public final void y() {
        if (!C()) {
            c cVar = this.A;
            if (cVar != null) {
                removeCallbacks(cVar);
                return;
            }
            return;
        }
        if (this.A == null) {
            this.A = new c(this, null);
        }
        removeCallbacks(this.A);
        this.C = false;
        postDelayed(this.A, 500L);
    }

    public final void z() {
        setSelection(getText().length());
    }

    public PinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TextPaint textPaint = new TextPaint();
        this.o = textPaint;
        this.q = -16777216;
        this.s = new Rect();
        this.t = new RectF();
        this.u = new RectF();
        this.v = new Path();
        this.w = new PointF();
        this.y = false;
        Resources resources = getResources();
        Paint paint = new Paint(1);
        this.n = paint;
        paint.setStyle(Paint.Style.STROKE);
        textPaint.set(getPaint());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.D, i, 0);
        this.h = obtainStyledAttributes.getInt(e.Q, 0);
        this.i = obtainStyledAttributes.getInt(e.J, 4);
        this.k = (int) obtainStyledAttributes.getDimension(e.K, resources.getDimensionPixelSize(r2.d.c));
        this.j = (int) obtainStyledAttributes.getDimension(e.N, resources.getDimensionPixelSize(r2.d.c));
        this.m = obtainStyledAttributes.getDimensionPixelSize(e.M, resources.getDimensionPixelSize(r2.d.d));
        this.l = (int) obtainStyledAttributes.getDimension(e.L, 0.0f);
        this.r = (int) obtainStyledAttributes.getDimension(e.P, resources.getDimensionPixelSize(r2.d.b));
        this.p = obtainStyledAttributes.getColorStateList(e.O);
        this.B = obtainStyledAttributes.getBoolean(e.F, true);
        this.F = obtainStyledAttributes.getColor(e.G, getCurrentTextColor());
        this.E = obtainStyledAttributes.getDimensionPixelSize(e.H, resources.getDimensionPixelSize(r2.d.a));
        this.H = obtainStyledAttributes.getDrawable(e.E);
        this.I = obtainStyledAttributes.getBoolean(e.I, false);
        obtainStyledAttributes.recycle();
        ColorStateList colorStateList = this.p;
        if (colorStateList != null) {
            this.q = colorStateList.getDefaultColor();
        }
        G();
        i();
        setMaxLength(this.i);
        paint.setStrokeWidth(this.r);
        B();
        setTransformationMethod((TransformationMethod) null);
        j();
        this.z = x(getInputType());
    }

    public void setLineColor(ColorStateList colorStateList) {
        colorStateList.getClass();
        this.p = colorStateList;
        F();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        G();
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }
}
