package androidx.appcompat.widget;

import P.L;
import T.j;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.e;
import c.h;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import k.A;
import k.M;
import k.Z;
import k.d0;
import k.l;
import k.m0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final Property T = new a(Float.class, "thumbPos");
    public static final int[] U = {16842912};
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public final TextPaint J;
    public ColorStateList K;
    public Layout L;
    public Layout M;
    public TransformationMethod N;
    public ObjectAnimator O;
    public final A P;
    public l Q;
    public c R;
    public final Rect S;
    public Drawable a;
    public ColorStateList c;
    public PorterDuff.Mode d;
    public boolean e;
    public boolean f;
    public Drawable g;
    public ColorStateList h;
    public PorterDuff.Mode i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public CharSequence p;
    public CharSequence q;
    public CharSequence r;
    public CharSequence s;
    public boolean t;
    public int u;
    public int v;
    public float w;
    public float x;
    public VelocityTracker y;
    public int z;

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.A);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    }

    public static class b {
        public static void a(ObjectAnimator objectAnimator, boolean z) {
            objectAnimator.setAutoCancel(z);
        }
    }

    public static class c extends e.e {
        public final Reference a;

        public c(SwitchCompat switchCompat) {
            this.a = new WeakReference(switchCompat);
        }

        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.O);
    }

    public static float f(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private l getEmojiTextViewHelper() {
        if (this.Q == null) {
            this.Q = new l(this);
        }
        return this.Q;
    }

    private boolean getTargetCheckedState() {
        return this.A > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((m0.b(this) ? 1.0f - this.A : this.A) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.S;
        drawable.getPadding(rect);
        Drawable drawable2 = this.a;
        Rect d = drawable2 != null ? M.d(drawable2) : M.c;
        return ((((this.B - this.D) - rect.left) - rect.right) - d.left) - d.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.r = charSequence;
        this.s = g(charSequence);
        this.M = null;
        if (this.t) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.p = charSequence;
        this.q = g(charSequence);
        this.L = null;
        if (this.t) {
            p();
        }
    }

    public final void a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, T, new float[]{z ? 1.0f : 0.0f});
        this.O = ofFloat;
        ofFloat.setDuration(250L);
        b.a(this.O, true);
        this.O.start();
    }

    public final void b() {
        Drawable drawable = this.a;
        if (drawable != null) {
            if (this.e || this.f) {
                Drawable mutate = H.a.r(drawable).mutate();
                this.a = mutate;
                if (this.e) {
                    H.a.o(mutate, this.c);
                }
                if (this.f) {
                    H.a.p(this.a, this.d);
                }
                if (this.a.isStateful()) {
                    this.a.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.g;
        if (drawable != null) {
            if (this.j || this.k) {
                Drawable mutate = H.a.r(drawable).mutate();
                this.g = mutate;
                if (this.j) {
                    H.a.o(mutate, this.h);
                }
                if (this.k) {
                    H.a.p(this.g, this.i);
                }
                if (this.g.isStateful()) {
                    this.g.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        Rect rect = this.S;
        int i3 = this.E;
        int i4 = this.F;
        int i5 = this.G;
        int i6 = this.H;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.a;
        Rect d = drawable != null ? M.d(drawable) : M.c;
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (d != null) {
                int i8 = d.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = d.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = d.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = d.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.g.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.g.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbOffset - rect.left;
            int i16 = thumbOffset + this.D + rect.right;
            this.a.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                H.a.l(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.k(drawable, f, f2);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            H.a.k(drawable2, f, f2);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final CharSequence g(CharSequence charSequence) {
        TransformationMethod f = getEmojiTextViewHelper().f(this.N);
        return f != null ? f.getTransformation(charSequence, this) : charSequence;
    }

    public int getCompoundPaddingLeft() {
        if (!m0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (m0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.q(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.t;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.r;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    public final float getThumbPosition() {
        return this.A;
    }

    public int getThumbTextPadding() {
        return this.l;
    }

    public ColorStateList getThumbTintList() {
        return this.c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.d;
    }

    public Drawable getTrackDrawable() {
        return this.g;
    }

    public ColorStateList getTrackTintList() {
        return this.h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.i;
    }

    public final boolean h(float f, float f2) {
        if (this.a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.a.getPadding(this.S);
        int i = this.F;
        int i2 = this.v;
        int i3 = i - i2;
        int i4 = (this.E + thumbOffset) - i2;
        int i5 = this.D + i4;
        Rect rect = this.S;
        return f > ((float) i4) && f < ((float) (((i5 + rect.left) + rect.right) + i2)) && f2 > ((float) i3) && f2 < ((float) (this.H + i2));
    }

    public final Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.J, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void j() {
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        requestLayout();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.O.end();
        this.O = null;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            String str = this.r;
            if (str == null) {
                str = getResources().getString(h.b);
            }
            L.J0(this, str);
        }
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            String str = this.p;
            if (str == null) {
                str = getResources().getString(h.c);
            }
            L.J0(this, str);
        }
    }

    public void m(Context context, int i) {
        d0 t = d0.t(context, i, c.j.a3);
        ColorStateList c2 = t.c(c.j.e3);
        if (c2 == null) {
            c2 = getTextColors();
        }
        this.K = c2;
        int f = t.f(c.j.b3, 0);
        if (f != 0) {
            float f2 = f;
            if (f2 != this.J.getTextSize()) {
                this.J.setTextSize(f2);
                requestLayout();
            }
        }
        o(t.k(c.j.c3, -1), t.k(c.j.d3, -1));
        this.N = t.a(c.j.l3, false) ? new h.a(getContext()) : null;
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        t.w();
    }

    public void n(Typeface typeface, int i) {
        if (i <= 0) {
            this.J.setFakeBoldText(false);
            this.J.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(defaultFromStyle);
            int i2 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i;
            this.J.setFakeBoldText((i2 & 1) != 0);
            this.J.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void o(int i, int i2) {
        n(i != 1 ? i != 2 ? i != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i2);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, U);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.S;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.F;
        int i2 = this.H;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.a;
        if (drawable != null) {
            if (!this.o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d = M.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d.left;
                rect.right -= d.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.L : this.M;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.K;
            if (colorStateList != null) {
                this.J.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.J.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.p : this.r;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onLayout(z, i, i2, i3, i4);
        int i10 = 0;
        if (this.a != null) {
            Rect rect = this.S;
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d = M.d(this.a);
            i5 = Math.max(0, d.left - rect.left);
            i10 = Math.max(0, d.right - rect.right);
        } else {
            i5 = 0;
        }
        if (m0.b(this)) {
            i6 = getPaddingLeft() + i5;
            width = ((this.B + i6) - i5) - i10;
        } else {
            width = (getWidth() - getPaddingRight()) - i10;
            i6 = (width - this.B) + i5 + i10;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i7 = this.C;
            i8 = paddingTop - (i7 / 2);
        } else {
            if (gravity == 80) {
                i9 = getHeight() - getPaddingBottom();
                i8 = i9 - this.C;
                this.E = i6;
                this.F = i8;
                this.H = i9;
                this.G = width;
            }
            i8 = getPaddingTop();
            i7 = this.C;
        }
        i9 = i7 + i8;
        this.E = i6;
        this.F = i8;
        this.H = i9;
        this.G = width;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.t) {
            if (this.L == null) {
                this.L = i(this.q);
            }
            if (this.M == null) {
                this.M = i(this.s);
            }
        }
        Rect rect = this.S;
        Drawable drawable = this.a;
        int i5 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i3 = (this.a.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.a.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.D = Math.max(this.t ? Math.max(this.L.getWidth(), this.M.getWidth()) + (this.l * 2) : 0, i3);
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i5 = this.g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Drawable drawable3 = this.a;
        if (drawable3 != null) {
            Rect d = M.d(drawable3);
            i6 = Math.max(i6, d.left);
            i7 = Math.max(i7, d.right);
        }
        int max = this.I ? Math.max(this.m, (this.D * 2) + i6 + i7) : this.m;
        int max2 = Math.max(i5, i4);
        this.B = max;
        this.C = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.y
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.u
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.w
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = k.m0.b(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.A
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.A
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.w = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.w
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.v
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.x
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.v
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.u = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.w = r0
            r6.x = r3
            return r1
        L8b:
            int r0 = r6.u
            if (r0 != r2) goto L96
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.u = r0
            android.view.VelocityTracker r0 = r6.y
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb9
            r6.u = r1
            r6.w = r0
            r6.x = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (this.R == null && this.Q.b() && e.h()) {
            e b2 = e.b();
            int d = b2.d();
            if (d == 3 || d == 0) {
                c cVar = new c(this);
                this.R = cVar;
                b2.s(cVar);
            }
        }
    }

    public final void q(MotionEvent motionEvent) {
        this.u = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.y.computeCurrentVelocity(1000);
            float xVelocity = this.y.getXVelocity();
            if (Math.abs(xVelocity) <= this.z) {
                z = getTargetCheckedState();
            } else if (!m0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        e(motionEvent);
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && L.W(this)) {
            a(isChecked);
        } else {
            d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.I = z;
        invalidate();
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.t != z) {
            this.t = z;
            requestLayout();
            if (z) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.m = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.n = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.J.getTypeface() == null || this.J.getTypeface().equals(typeface)) && (this.J.getTypeface() != null || typeface == null)) {
            return;
        }
        this.J.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.A = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(e.a.b(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.l = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        this.e = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.d = mode;
        this.f = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(e.a.b(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        this.j = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.i = mode;
        this.k = true;
        c();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.a || drawable == this.g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.y = VelocityTracker.obtain();
        this.I = true;
        this.S = new Rect();
        Z.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.J = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        d0 v = d0.v(context, attributeSet, c.j.L2, i, 0);
        L.q0(this, context, c.j.L2, attributeSet, v.r(), i, 0);
        Drawable g = v.g(c.j.O2);
        this.a = g;
        if (g != null) {
            g.setCallback(this);
        }
        Drawable g2 = v.g(c.j.X2);
        this.g = g2;
        if (g2 != null) {
            g2.setCallback(this);
        }
        setTextOnInternal(v.p(c.j.M2));
        setTextOffInternal(v.p(c.j.N2));
        this.t = v.a(c.j.P2, true);
        this.l = v.f(c.j.U2, 0);
        this.m = v.f(c.j.R2, 0);
        this.n = v.f(c.j.S2, 0);
        this.o = v.a(c.j.Q2, false);
        ColorStateList c2 = v.c(c.j.V2);
        if (c2 != null) {
            this.c = c2;
            this.e = true;
        }
        PorterDuff.Mode e = M.e(v.k(c.j.W2, -1), null);
        if (this.d != e) {
            this.d = e;
            this.f = true;
        }
        if (this.e || this.f) {
            b();
        }
        ColorStateList c3 = v.c(c.j.Y2);
        if (c3 != null) {
            this.h = c3;
            this.j = true;
        }
        PorterDuff.Mode e2 = M.e(v.k(c.j.Z2, -1), null);
        if (this.i != e2) {
            this.i = e2;
            this.k = true;
        }
        if (this.j || this.k) {
            c();
        }
        int n = v.n(c.j.T2, 0);
        if (n != 0) {
            m(context, n);
        }
        A a2 = new A(this);
        this.P = a2;
        a2.m(attributeSet, i);
        v.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
