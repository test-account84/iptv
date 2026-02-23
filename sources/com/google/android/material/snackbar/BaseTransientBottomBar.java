package com.google.android.material.snackbar;

import P.L;
import R4.d;
import R4.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import f5.w;
import i5.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class BaseTransientBottomBar {

    public static class Behavior extends SwipeDismissBehavior {
        public final a j = new a(this);

        public boolean E(View view) {
            return this.j.a(view);
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.j.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    public static class a {
        public a(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.K(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.L(0);
        }

        public boolean a(View view) {
            return view instanceof b;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.C(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.b().e(null);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.b().f(null);
            }
        }
    }

    public static class b extends FrameLayout {
        public static final View.OnTouchListener k = new a();
        public int a;
        public final float c;
        public final float d;
        public final int e;
        public final int f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public boolean j;

        public class a implements View.OnTouchListener {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(p5.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.T4);
            if (obtainStyledAttributes.hasValue(l.a5)) {
                L.A0(this, obtainStyledAttributes.getDimensionPixelSize(l.a5, 0));
            }
            this.a = obtainStyledAttributes.getInt(l.W4, 0);
            this.c = obtainStyledAttributes.getFloat(l.X4, 1.0f);
            setBackgroundTintList(c.a(context2, obtainStyledAttributes, l.Y4));
            setBackgroundTintMode(w.f(obtainStyledAttributes.getInt(l.Z4, -1), PorterDuff.Mode.SRC_IN));
            this.d = obtainStyledAttributes.getFloat(l.V4, 1.0f);
            this.e = obtainStyledAttributes.getDimensionPixelSize(l.U4, -1);
            this.f = obtainStyledAttributes.getDimensionPixelSize(l.b5, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(k);
            setFocusable(true);
            if (getBackground() == null) {
                L.w0(this, a());
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        }

        public final Drawable a() {
            float dimension = getResources().getDimension(d.V);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(Z4.a.i(this, R4.b.m, R4.b.j, getBackgroundOverlayColorAlpha()));
            if (this.g == null) {
                return H.a.r(gradientDrawable);
            }
            Drawable r = H.a.r(gradientDrawable);
            H.a.o(r, this.g);
            return r;
        }

        public final void b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.d;
        }

        public int getAnimationMode() {
            return this.a;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.c;
        }

        public int getMaxInlineActionWidth() {
            return this.f;
        }

        public int getMaxWidth() {
            return this.e;
        }

        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            L.p0(this);
        }

        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.e > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = this.e;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        public void setAnimationMode(int i) {
            this.a = i;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.g != null) {
                drawable = H.a.r(drawable.mutate());
                H.a.o(drawable, this.g);
                H.a.p(drawable, this.h);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.g = colorStateList;
            if (getBackground() != null) {
                Drawable r = H.a.r(getBackground().mutate());
                H.a.o(r, colorStateList);
                H.a.p(r, this.h);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.h = mode;
            if (getBackground() != null) {
                Drawable r = H.a.r(getBackground().mutate());
                H.a.p(r, mode);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.j || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            b((ViewGroup.MarginLayoutParams) layoutParams);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : k);
            super.setOnClickListener(onClickListener);
        }
    }
}
