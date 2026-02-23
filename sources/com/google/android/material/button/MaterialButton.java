package com.google.android.material.button;

import P.L;
import R4.k;
import R4.l;
import T.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import d.D;
import f5.u;
import f5.w;
import i5.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k.e;
import l5.h;
import l5.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MaterialButton extends e implements Checkable, n {
    public static final int[] r = {16842911};
    public static final int[] s = {16842912};
    public static final int t = k.m;
    public final V4.a e;
    public final LinkedHashSet f;
    public a g;
    public PorterDuff.Mode h;
    public ColorStateList i;
    public Drawable j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public int q;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public static class b extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public boolean d;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            c(parcel);
        }

        public final void c(Parcel parcel) {
            this.d = parcel.readInt() == 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.t);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public boolean a() {
        V4.a aVar = this.e;
        return aVar != null && aVar.p();
    }

    public final boolean b() {
        int i = this.q;
        return i == 3 || i == 4;
    }

    public final boolean c() {
        int i = this.q;
        return i == 1 || i == 2;
    }

    public final boolean d() {
        int i = this.q;
        return i == 16 || i == 32;
    }

    public final boolean e() {
        return L.E(this) == 1;
    }

    public final boolean f() {
        V4.a aVar = this.e;
        return (aVar == null || aVar.o()) ? false : true;
    }

    public final void g() {
        if (c()) {
            j.j(this, this.j, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (b()) {
            j.j(this, (Drawable) null, (Drawable) null, this.j, (Drawable) null);
        } else if (d()) {
            j.j(this, (Drawable) null, this.j, (Drawable) null, (Drawable) null);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.e.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.j;
    }

    public int getIconGravity() {
        return this.q;
    }

    public int getIconPadding() {
        return this.n;
    }

    public int getIconSize() {
        return this.k;
    }

    public ColorStateList getIconTint() {
        return this.i;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.h;
    }

    public int getInsetBottom() {
        return this.e.c();
    }

    public int getInsetTop() {
        return this.e.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.e.h();
        }
        return null;
    }

    public l5.k getShapeAppearanceModel() {
        if (f()) {
            return this.e.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.e.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.e.k();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.e.l() : super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.e.m() : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z) {
        Drawable drawable = this.j;
        if (drawable != null) {
            Drawable mutate = H.a.r(drawable).mutate();
            this.j = mutate;
            H.a.o(mutate, this.i);
            PorterDuff.Mode mode = this.h;
            if (mode != null) {
                H.a.p(this.j, mode);
            }
            int i = this.k;
            if (i == 0) {
                i = this.j.getIntrinsicWidth();
            }
            int i2 = this.k;
            if (i2 == 0) {
                i2 = this.j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.j;
            int i3 = this.l;
            int i4 = this.m;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
            this.j.setVisible(true, z);
        }
        if (z) {
            g();
            return;
        }
        Drawable[] a2 = j.a(this);
        Drawable drawable3 = a2[0];
        Drawable drawable4 = a2[1];
        Drawable drawable5 = a2[2];
        if ((!c() || drawable3 == this.j) && ((!b() || drawable5 == this.j) && (!d() || drawable4 == this.j))) {
            return;
        }
        g();
    }

    public final void i(int i, int i2) {
        if (this.j == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.l = 0;
                if (this.q == 16) {
                    this.m = 0;
                    h(false);
                    return;
                }
                int i3 = this.k;
                if (i3 == 0) {
                    i3 = this.j.getIntrinsicHeight();
                }
                int textHeight = (((((i2 - getTextHeight()) - getPaddingTop()) - i3) - this.n) - getPaddingBottom()) / 2;
                if (this.m != textHeight) {
                    this.m = textHeight;
                    h(false);
                }
                return;
            }
            return;
        }
        this.m = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i4 = this.q;
        if (i4 == 1 || i4 == 3 || ((i4 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i4 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.l = 0;
            h(false);
            return;
        }
        int i5 = this.k;
        if (i5 == 0) {
            i5 = this.j.getIntrinsicWidth();
        }
        int textWidth = ((((i - getTextWidth()) - L.I(this)) - i5) - this.n) - L.J(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textWidth /= 2;
        }
        if (e() != (this.q == 4)) {
            textWidth = -textWidth;
        }
        if (this.l != textWidth) {
            this.l = textWidth;
            h(false);
        }
    }

    public boolean isChecked() {
        return this.o;
    }

    public void onAttachedToWindow() {
        super/*android.widget.Button*/.onAttachedToWindow();
        if (f()) {
            h.f(this, this.e.f());
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super/*android.widget.Button*/.onCreateDrawableState(i + 2);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, r);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, s);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        V4.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.e) != null) {
            aVar.H(i4 - i2, i3 - i);
        }
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super/*android.widget.Button*/.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super/*android.widget.Button*/.onRestoreInstanceState(bVar.a());
        setChecked(bVar.d);
    }

    public Parcelable onSaveInstanceState() {
        b bVar = new b(super/*android.widget.Button*/.onSaveInstanceState());
        bVar.d = this.o;
        return bVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super/*android.widget.Button*/.performClick();
    }

    public void refreshDrawableState() {
        super/*android.widget.Button*/.refreshDrawableState();
        if (this.j != null) {
            if (this.j.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i) {
        if (f()) {
            this.e.r(i);
        } else {
            super/*android.widget.Button*/.setBackgroundColor(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (f()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            } else {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.e.s();
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (f()) {
            this.e.t(z);
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.o != z) {
            this.o = z;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                getParent().m(this, this.o);
            }
            if (this.p) {
                return;
            }
            this.p = true;
            Iterator it = this.f.iterator();
            if (it.hasNext()) {
                D.a(it.next());
                throw null;
            }
            this.p = false;
        }
    }

    public void setCornerRadius(int i) {
        if (f()) {
            this.e.u(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setElevation(float f) {
        super/*android.widget.Button*/.setElevation(f);
        if (f()) {
            this.e.f().V(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.j != drawable) {
            this.j = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.q != i) {
            this.q = i;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.n != i) {
            this.n = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.k != i) {
            this.k = i;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.h != mode) {
            this.h = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(e.a.a(getContext(), i));
    }

    public void setInsetBottom(int i) {
        this.e.v(i);
    }

    public void setInsetTop(int i) {
        this.e.w(i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(a aVar) {
        this.g = aVar;
    }

    public void setPressed(boolean z) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this, z);
        }
        super/*android.widget.Button*/.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.e.x(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (f()) {
            setRippleColor(e.a.a(getContext(), i));
        }
    }

    public void setShapeAppearanceModel(l5.k kVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.e.y(kVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (f()) {
            this.e.z(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.e.A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (f()) {
            setStrokeColor(e.a.a(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (f()) {
            this.e.B(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.e.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.e.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public void setTextAlignment(int i) {
        super/*android.widget.Button*/.setTextAlignment(i);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void toggle() {
        setChecked(!this.o);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        int i2 = t;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        this.f = new LinkedHashSet();
        this.o = false;
        this.p = false;
        Context context2 = getContext();
        TypedArray h = u.h(context2, attributeSet, l.L2, i, i2, new int[0]);
        this.n = h.getDimensionPixelSize(l.Y2, 0);
        this.h = w.f(h.getInt(l.b3, -1), PorterDuff.Mode.SRC_IN);
        this.i = c.a(getContext(), h, l.a3);
        this.j = c.d(getContext(), h, l.W2);
        this.q = h.getInteger(l.X2, 1);
        this.k = h.getDimensionPixelSize(l.Z2, 0);
        V4.a aVar = new V4.a(this, l5.k.e(context2, attributeSet, i, i2).m());
        this.e = aVar;
        aVar.q(h);
        h.recycle();
        setCompoundDrawablePadding(this.n);
        h(this.j != null);
    }
}
