package com.google.android.material.chip;

import P.L;
import Q.C;
import R4.j;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.chip.a;
import f5.h;
import f5.u;
import f5.w;
import i5.f;
import java.util.List;
import l5.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class Chip extends AppCompatCheckBox implements a.a, n, h {
    public com.google.android.material.chip.a f;
    public InsetDrawable g;
    public RippleDrawable h;
    public View.OnClickListener i;
    public CompoundButton.OnCheckedChangeListener j;
    public h.a k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public CharSequence s;
    public final d t;
    public boolean u;
    public final Rect v;
    public final RectF w;
    public final f x;
    public static final int y = k.o;
    public static final Rect z = new Rect();
    public static final int[] A = {16842913};
    public static final int[] B = {16842911};

    public class a extends f {
        public a() {
        }

        public void a(int i) {
        }

        public void b(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(Chip.b(chip).I2() ? Chip.b(Chip.this).e1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (Chip.c(Chip.this) != null) {
                Chip.c(Chip.this).a(Chip.this, z);
            }
            if (Chip.d(Chip.this) != null) {
                Chip.d(Chip.this).onCheckedChanged(compoundButton, z);
            }
        }
    }

    public class c extends ViewOutlineProvider {
        public c() {
        }

        public void getOutline(View view, Outline outline) {
            if (Chip.b(Chip.this) != null) {
                Chip.b(Chip.this).getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public class d extends W.a {
        public d(Chip chip) {
            super(chip);
        }

        public int B(float f, float f2) {
            return (Chip.e(Chip.this) && Chip.f(Chip.this).contains(f, f2)) ? 1 : 0;
        }

        public void C(List list) {
            list.add(0);
            if (Chip.e(Chip.this) && Chip.this.t() && Chip.g(Chip.this) != null) {
                list.add(1);
            }
        }

        public boolean J(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i == 0) {
                return Chip.this.performClick();
            }
            if (i == 1) {
                return Chip.this.u();
            }
            return false;
        }

        public void M(C c) {
            c.V(Chip.this.s());
            c.Y(Chip.this.isClickable());
            c.X(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                c.u0(text);
            } else {
                c.b0(text);
            }
        }

        public void N(int i, C c) {
            if (i != 1) {
                c.b0("");
                c.T(Chip.j());
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                String text = Chip.this.getText();
                closeIconContentDescription = Chip.this.getContext().getString(j.j, new Object[]{TextUtils.isEmpty(text) ? "" : text}).trim();
            }
            c.b0(closeIconContentDescription);
            c.T(Chip.i(Chip.this));
            c.b(C.a.i);
            c.c0(Chip.this.isEnabled());
        }

        public void O(int i, boolean z) {
            if (i == 1) {
                Chip.h(Chip.this, z);
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.g);
    }

    public static /* synthetic */ com.google.android.material.chip.a b(Chip chip) {
        return chip.f;
    }

    public static /* synthetic */ h.a c(Chip chip) {
        return chip.k;
    }

    public static /* synthetic */ CompoundButton.OnCheckedChangeListener d(Chip chip) {
        return chip.j;
    }

    public static /* synthetic */ boolean e(Chip chip) {
        return chip.o();
    }

    public static /* synthetic */ RectF f(Chip chip) {
        return chip.getCloseIconTouchBounds();
    }

    public static /* synthetic */ View.OnClickListener g(Chip chip) {
        return chip.i;
    }

    private RectF getCloseIconTouchBounds() {
        this.w.setEmpty();
        if (o() && this.i != null) {
            this.f.V0(this.w);
        }
        return this.w;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.v.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.v;
    }

    private i5.d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public static /* synthetic */ boolean h(Chip chip, boolean z2) {
        chip.o = z2;
        return z2;
    }

    public static /* synthetic */ Rect i(Chip chip) {
        return chip.getCloseIconTouchBoundsInt();
    }

    public static /* synthetic */ Rect j() {
        return z;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.n != z2) {
            this.n = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.m != z2) {
            this.m = z2;
            refreshDrawableState();
        }
    }

    public final void A() {
        this.h = new RippleDrawable(j5.b.d(this.f.c1()), getBackgroundDrawable(), (Drawable) null);
        this.f.H2(false);
        L.w0(this, this.h);
        B();
    }

    public final void B() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f) == null) {
            return;
        }
        int G0 = (int) (aVar.G0() + this.f.g1() + this.f.n0());
        int L0 = (int) (this.f.L0() + this.f.h1() + this.f.j0());
        if (this.g != null) {
            Rect rect = new Rect();
            this.g.getPadding(rect);
            L0 += rect.left;
            G0 += rect.right;
        }
        L.F0(this, L0, getPaddingTop(), G0, getPaddingBottom());
    }

    public final void C() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        i5.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.x);
        }
    }

    public final void D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    public void a() {
        m(this.r);
        requestLayout();
        invalidateOutline();
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.u ? super/*android.widget.CheckBox*/.dispatchHoverEvent(motionEvent) : this.t.v(motionEvent) || super/*android.widget.CheckBox*/.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.u) {
            return super/*android.widget.CheckBox*/.dispatchKeyEvent(keyEvent);
        }
        if (!this.t.w(keyEvent) || this.t.A() == Integer.MIN_VALUE) {
            return super/*android.widget.CheckBox*/.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f;
        if ((aVar == null || !aVar.m1()) ? false : this.f.i2(l())) {
            invalidate();
        }
    }

    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        if (!s()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ChipGroup parent = getParent();
        return ((parent instanceof ChipGroup) && parent.h()) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.g;
        return insetDrawable == null ? this.f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.C0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.D0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.E0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return Math.max(0.0f, aVar.F0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.G0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.H0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.I0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.J0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.L0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.M0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.N0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.P0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.S0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.U0();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.u && (this.t.A() == 1 || this.t.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super/*android.widget.CheckBox*/.getFocusedRect(rect);
        }
    }

    public S4.f getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.Z0();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.a1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.b1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.c1();
        }
        return null;
    }

    public l5.k getShapeAppearanceModel() {
        return this.f.C();
    }

    public S4.f getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.d1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.g1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            return aVar.h1();
        }
        return 0.0f;
    }

    public final void k(com.google.android.material.chip.a aVar) {
        aVar.m2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final int[] l() {
        ?? isEnabled = isEnabled();
        int i = isEnabled;
        if (this.o) {
            i = isEnabled + 1;
        }
        int i2 = i;
        if (this.n) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (this.m) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (isChecked()) {
            i4 = i3 + 1;
        }
        int[] iArr = new int[i4];
        int i5 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i5 = 1;
        }
        if (this.o) {
            iArr[i5] = 16842908;
            i5++;
        }
        if (this.n) {
            iArr[i5] = 16843623;
            i5++;
        }
        if (this.m) {
            iArr[i5] = 16842919;
            i5++;
        }
        if (isChecked()) {
            iArr[i5] = 16842913;
        }
        return iArr;
    }

    public boolean m(int i) {
        this.r = i;
        if (!w()) {
            if (this.g != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int max = Math.max(0, i - this.f.getIntrinsicHeight());
        int max2 = Math.max(0, i - this.f.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.g != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int i2 = max2 > 0 ? max2 / 2 : 0;
        int i3 = max > 0 ? max / 2 : 0;
        if (this.g != null) {
            Rect rect = new Rect();
            this.g.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                z();
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        r(i2, i3, i2, i3);
        z();
        return true;
    }

    public final void n() {
        if (getBackgroundDrawable() == this.g && this.f.getCallback() == null) {
            this.f.setCallback(this.g);
        }
    }

    public final boolean o() {
        com.google.android.material.chip.a aVar = this.f;
        return (aVar == null || aVar.O0() == null) ? false : true;
    }

    public void onAttachedToWindow() {
        super/*android.widget.CheckBox*/.onAttachedToWindow();
        l5.h.f(this, this.f);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super/*android.widget.CheckBox*/.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, A);
        }
        if (s()) {
            View.mergeDrawableStates(onCreateDrawableState, B);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z2, int i, Rect rect) {
        super/*android.widget.CheckBox*/.onFocusChanged(z2, i, rect);
        if (this.u) {
            this.t.I(z2, i, rect);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super/*android.widget.CheckBox*/.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super/*android.widget.CheckBox*/.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super/*android.widget.CheckBox*/.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(s());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup parent = getParent();
            C.y0(accessibilityNodeInfo).a0(C.c.a(parent.b(this), 1, parent.c() ? parent.g(this) : -1, 1, false, isChecked()));
        }
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return Y4.a.a(getContext(), 1002);
        }
        return null;
    }

    public void onRtlPropertiesChanged(int i) {
        super/*android.widget.CheckBox*/.onRtlPropertiesChanged(i);
        if (this.q != i) {
            this.q = i;
            B();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L35
            goto L40
        L21:
            boolean r0 = r5.m
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = 1
            goto L41
        L2c:
            boolean r0 = r5.m
            if (r0 == 0) goto L35
            r5.u()
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            r5.setCloseIconPressed(r3)
            goto L41
        L3a:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
            goto L2a
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super/*android.widget.CheckBox*/.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            r2 = 0
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(Context context, AttributeSet attributeSet, int i) {
        TypedArray h = u.h(context, attributeSet, l.r0, i, y, new int[0]);
        this.p = h.getBoolean(l.Y0, false);
        this.r = (int) Math.ceil(h.getDimension(l.M0, (float) Math.ceil(w.b(getContext(), 48))));
        h.recycle();
    }

    public final void q() {
        setOutlineProvider(new c());
    }

    public final void r(int i, int i2, int i3, int i4) {
        this.g = new InsetDrawable(this.f, i, i2, i3, i4);
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f;
        return aVar != null && aVar.l1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.s = charSequence;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super/*android.widget.CheckBox*/.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.u1(z2);
        }
    }

    public void setCheckableResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.v1(i);
        }
    }

    public void setChecked(boolean z2) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar == null) {
            this.l = z2;
        } else if (aVar.l1()) {
            super/*android.widget.CheckBox*/.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.w1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.x1(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.y1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.z1(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.A1(i);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.C1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.D1(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.E1(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.F1(i);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f;
        if (aVar2 != aVar) {
            x(aVar2);
            this.f = aVar;
            aVar.x2(false);
            k(this.f);
            m(this.r);
        }
    }

    public void setChipEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.G1(f);
        }
    }

    public void setChipEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.H1(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.I1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.J1(i);
        }
    }

    public void setChipIconSize(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.K1(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.L1(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.M1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.N1(i);
        }
    }

    public void setChipIconVisible(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.O1(i);
        }
    }

    public void setChipMinHeight(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.Q1(f);
        }
    }

    public void setChipMinHeightResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.R1(i);
        }
    }

    public void setChipStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.S1(f);
        }
    }

    public void setChipStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.T1(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.U1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.V1(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.W1(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.X1(i);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.Z1(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.a2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.b2(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.c2(i);
        }
    }

    public void setCloseIconResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.d2(i);
        }
        y();
    }

    public void setCloseIconSize(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.e2(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.f2(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.g2(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.h2(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.j2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.k2(i);
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super/*android.widget.CheckBox*/.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super/*android.widget.CheckBox*/.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    public void setElevation(float f) {
        super/*android.widget.CheckBox*/.setElevation(f);
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.V(f);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super/*android.widget.CheckBox*/.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.n2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.p = z2;
        m(this.r);
    }

    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super/*android.widget.CheckBox*/.setGravity(i);
        }
    }

    public void setHideMotionSpec(S4.f fVar) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.o2(fVar);
        }
    }

    public void setHideMotionSpecResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.p2(i);
        }
    }

    public void setIconEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.q2(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.r2(i);
        }
    }

    public void setIconStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.s2(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.t2(i);
        }
    }

    public void setInternalOnCheckedChangeListener(h.a aVar) {
        this.k = aVar;
    }

    public void setLayoutDirection(int i) {
        if (this.f == null) {
            return;
        }
        super/*android.widget.CheckBox*/.setLayoutDirection(i);
    }

    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super/*android.widget.CheckBox*/.setLines(i);
    }

    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super/*android.widget.CheckBox*/.setMaxLines(i);
    }

    public void setMaxWidth(int i) {
        super/*android.widget.CheckBox*/.setMaxWidth(i);
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.u2(i);
        }
    }

    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super/*android.widget.CheckBox*/.setMinLines(i);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
        y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.v2(colorStateList);
        }
        if (this.f.j1()) {
            return;
        }
        A();
    }

    public void setRippleColorResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.w2(i);
            if (this.f.j1()) {
                return;
            }
            A();
        }
    }

    public void setShapeAppearanceModel(l5.k kVar) {
        this.f.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(S4.f fVar) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.y2(fVar);
        }
    }

    public void setShowMotionSpecResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.z2(i);
        }
    }

    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super/*android.widget.CheckBox*/.setSingleLine(z2);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super/*android.widget.CheckBox*/.setText(aVar.I2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.A2(charSequence);
        }
    }

    public void setTextAppearance(int i) {
        super/*android.widget.CheckBox*/.setTextAppearance(i);
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.C2(i);
        }
        C();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.D2(f);
        }
    }

    public void setTextEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.E2(i);
        }
    }

    public void setTextStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.F2(f);
        }
    }

    public void setTextStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.G2(i);
        }
    }

    public boolean t() {
        com.google.android.material.chip.a aVar = this.f;
        return aVar != null && aVar.n1();
    }

    public boolean u() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        if (this.u) {
            this.t.U(1, 1);
        }
        return z2;
    }

    public final void v() {
        if (this.g != null) {
            this.g = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    public boolean w() {
        return this.p;
    }

    public final void x(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.m2(null);
        }
    }

    public final void y() {
        boolean z2;
        if (o() && t() && this.i != null) {
            L.s0(this, this.t);
            z2 = true;
        } else {
            L.s0(this, (P.a) null);
            z2 = false;
        }
        this.u = z2;
    }

    public final void z() {
        if (j5.b.a) {
            A();
            return;
        }
        this.f.H2(true);
        L.w0(this, getBackgroundDrawable());
        B();
        n();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i) {
        int i2 = y;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        this.v = new Rect();
        this.w = new RectF();
        this.x = new a();
        Context context2 = getContext();
        D(attributeSet);
        com.google.android.material.chip.a s0 = com.google.android.material.chip.a.s0(context2, attributeSet, i, i2);
        p(context2, attributeSet, i);
        setChipDrawable(s0);
        s0.V(L.y(this));
        TypedArray h = u.h(context2, attributeSet, l.r0, i, i2, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(i5.c.a(context2, h, l.u0));
        }
        boolean hasValue = h.hasValue(l.d1);
        h.recycle();
        this.t = new d(this);
        y();
        if (!hasValue) {
            q();
        }
        setChecked(this.l);
        setText(s0.e1());
        setEllipsize(s0.Y0());
        C();
        if (!this.f.I2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        B();
        if (w()) {
            setMinHeight(this.r);
        }
        this.q = L.E(this);
        super/*android.widget.CheckBox*/.setOnCheckedChangeListener(new b());
    }

    public void setCheckedIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.B1(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.P1(z2);
        }
    }

    public void setCloseIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.l2(z2);
        }
        y();
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super/*android.widget.CheckBox*/.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super/*android.widget.CheckBox*/.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setTextAppearance(Context context, int i) {
        super/*android.widget.CheckBox*/.setTextAppearance(context, i);
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.C2(i);
        }
        C();
    }

    public void setTextAppearance(i5.d dVar) {
        com.google.android.material.chip.a aVar = this.f;
        if (aVar != null) {
            aVar.B2(dVar);
        }
        C();
    }
}
