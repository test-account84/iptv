package com.google.android.material.floatingactionbutton;

import O.h;
import P.L;
import R4.d;
import R4.k;
import R4.l;
import S4.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import f5.c;
import f5.u;
import f5.w;
import f5.x;
import java.util.List;
import k.i;
import k.o;
import l5.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FloatingActionButton extends x implements d5.a, n, CoordinatorLayout.b {
    public static final int s = k.g;
    public ColorStateList c;
    public PorterDuff.Mode d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public ColorStateList g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public final Rect n;
    public final Rect o;
    public final o p;
    public final d5.b q;
    public com.google.android.material.floatingactionbutton.a r;

    public static class BaseBehavior extends CoordinatorLayout.c {
        public Rect a;
        public boolean b;

        public BaseBehavior() {
            this.b = true;
        }

        private static boolean F(View view) {
            CoordinatorLayout.f layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return layoutParams.f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.n;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f layoutParams = floatingActionButton.getLayoutParams();
            int i = 0;
            int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i = -rect.top;
            }
            if (i != 0) {
                L.d0(floatingActionButton, i);
            }
            if (i2 != 0) {
                L.c0(floatingActionButton, i2);
            }
        }

        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List s = coordinatorLayout.s(floatingActionButton);
            int size = s.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) s.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.J(floatingActionButton, i);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        public final boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.b && floatingActionButton.getLayoutParams().e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.h(null, false);
                return true;
            }
            floatingActionButton.l(null, false);
            return true;
        }

        public final boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.h(null, false);
                return true;
            }
            floatingActionButton.l(null, false);
            return true;
        }

        public void g(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.e2);
            this.b = obtainStyledAttributes.getBoolean(l.f2, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean E(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean I(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.l(coordinatorLayout, floatingActionButton, i);
        }

        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.f fVar) {
            super.g(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class a {
    }

    public class b implements k5.b {
        public b() {
        }

        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.n.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + FloatingActionButton.c(floatingActionButton), i2 + FloatingActionButton.c(FloatingActionButton.this), i3 + FloatingActionButton.c(FloatingActionButton.this), i4 + FloatingActionButton.c(FloatingActionButton.this));
        }

        public void b(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.d(FloatingActionButton.this, drawable);
            }
        }

        public boolean c() {
            return FloatingActionButton.this.m;
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.r);
    }

    public static /* synthetic */ int c(FloatingActionButton floatingActionButton) {
        return floatingActionButton.k;
    }

    public static /* synthetic */ void d(FloatingActionButton floatingActionButton, Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.r == null) {
            this.r = e();
        }
        return this.r;
    }

    public static int k(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public boolean a() {
        return this.q.c();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().A(getDrawableState());
    }

    public final com.google.android.material.floatingactionbutton.a e() {
        return new e5.b(this, new b());
    }

    public boolean f(Rect rect) {
        if (!L.W(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        i(rect);
        return true;
    }

    public final int g(int i) {
        int i2 = this.j;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return resources.getDimensionPixelSize(i != 1 ? d.d : d.c);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? g(1) : g(0);
    }

    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    public CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().j();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().m();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().p();
    }

    public Drawable getContentBackground() {
        return getImpl().i();
    }

    public int getCustomSize() {
        return this.j;
    }

    public int getExpandedComponentIdHint() {
        return this.q.b();
    }

    public f getHideMotionSpec() {
        return getImpl().l();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public l5.k getShapeAppearanceModel() {
        return (l5.k) h.f(getImpl().q());
    }

    public f getShowMotionSpec() {
        return getImpl().r();
    }

    public int getSize() {
        return this.i;
    }

    public int getSizeDimension() {
        return g(this.i);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    public boolean getUseCompatPadding() {
        return this.m;
    }

    public void h(a aVar, boolean z) {
        getImpl().s(m(aVar), z);
    }

    public final void i(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.n;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void j() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.e;
        if (colorStateList == null) {
            H.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(i.e(colorForState, mode));
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().w();
    }

    public void l(a aVar, boolean z) {
        getImpl().Y(m(aVar), z);
    }

    public final a.k m(a aVar) {
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().x();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().z();
    }

    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.k = (sizeDimension - this.l) / 2;
        getImpl().b0();
        int min = Math.min(k(sizeDimension, i), k(sizeDimension, i2));
        Rect rect = this.n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof m5.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m5.a aVar = (m5.a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        this.q.d((Bundle) h.f(aVar.d.get("expandableWidgetHelper")));
    }

    public Parcelable onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        m5.a aVar = new m5.a(onSaveInstanceState);
        aVar.d.put("expandableWidgetHelper", this.q.e());
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && f(this.o) && !this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            getImpl().H(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            getImpl().I(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().J(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().M(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().Q(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.j) {
            this.j = i;
            requestLayout();
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().c0(f);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().k()) {
            getImpl().K(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.q.f(i);
    }

    public void setHideMotionSpec(f fVar) {
        getImpl().L(fVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(f.c(getContext(), i));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().a0();
            if (this.e != null) {
                j();
            }
        }
    }

    public void setImageResource(int i) {
        this.p.i(i);
        j();
    }

    public void setMaxImageSize(int i) {
        this.l = i;
        getImpl().O(i);
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().E();
    }

    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().E();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().S(z);
    }

    public void setShapeAppearanceModel(l5.k kVar) {
        getImpl().T(kVar);
    }

    public void setShowMotionSpec(f fVar) {
        getImpl().U(fVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(f.c(getContext(), i));
    }

    public void setSize(int i) {
        this.j = 0;
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            j();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            j();
        }
    }

    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().F();
    }

    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().F();
    }

    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().F();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.m != z) {
            this.m = z;
            getImpl().y();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        int i2 = s;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        this.n = new Rect();
        this.o = new Rect();
        Context context2 = getContext();
        TypedArray h = u.h(context2, attributeSet, l.O1, i, i2, new int[0]);
        this.c = i5.c.a(context2, h, l.Q1);
        this.d = w.f(h.getInt(l.R1, -1), null);
        this.g = i5.c.a(context2, h, l.b2);
        this.i = h.getInt(l.W1, -1);
        this.j = h.getDimensionPixelSize(l.V1, 0);
        this.h = h.getDimensionPixelSize(l.S1, 0);
        float dimension = h.getDimension(l.T1, 0.0f);
        float dimension2 = h.getDimension(l.Y1, 0.0f);
        float dimension3 = h.getDimension(l.a2, 0.0f);
        this.m = h.getBoolean(l.d2, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.S);
        setMaxImageSize(h.getDimensionPixelSize(l.Z1, 0));
        f b2 = f.b(context2, h, l.c2);
        f b3 = f.b(context2, h, l.X1);
        l5.k m = l5.k.g(context2, attributeSet, i, i2, l5.k.m).m();
        boolean z = h.getBoolean(l.U1, false);
        setEnabled(h.getBoolean(l.P1, true));
        h.recycle();
        o oVar = new o(this);
        this.p = oVar;
        oVar.g(attributeSet, i);
        this.q = new d5.b(this);
        getImpl().T(m);
        getImpl().t(this.c, this.d, this.g, this.h);
        getImpl().P(dimensionPixelSize);
        getImpl().J(dimension);
        getImpl().M(dimension2);
        getImpl().Q(dimension3);
        getImpl().U(b2);
        getImpl().L(b3);
        getImpl().K(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            getImpl().R(this.g);
        }
    }
}
