package com.google.android.material.chip;

import H.b;
import S4.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import f5.s;
import f5.w;
import i5.d;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l5.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends g implements b, Drawable.Callback, s.b {
    public static final int[] O0 = {16842910};
    public static final ShapeDrawable P0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public int A0;
    public ColorStateList B;
    public int B0;
    public float C;
    public ColorFilter C0;
    public float D;
    public PorterDuffColorFilter D0;
    public ColorStateList E;
    public ColorStateList E0;
    public float F;
    public PorterDuff.Mode F0;
    public ColorStateList G;
    public int[] G0;
    public CharSequence H;
    public boolean H0;
    public boolean I;
    public ColorStateList I0;
    public Drawable J;
    public WeakReference J0;
    public ColorStateList K;
    public TextUtils.TruncateAt K0;
    public float L;
    public boolean L0;
    public boolean M;
    public int M0;
    public boolean N;
    public boolean N0;
    public Drawable O;
    public Drawable P;
    public ColorStateList Q;
    public float R;
    public CharSequence S;
    public boolean T;
    public boolean U;
    public Drawable V;
    public ColorStateList W;
    public f X;
    public f Y;
    public float Z;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public float i0;
    public float j0;
    public float k0;
    public final Context l0;
    public final Paint m0;
    public final Paint n0;
    public final Paint.FontMetrics o0;
    public final RectF p0;
    public final PointF q0;
    public final Path r0;
    public final s s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;
    public int x0;
    public int y0;
    public boolean z0;

    public interface a {
        void a();
    }

    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.D = -1.0f;
        this.m0 = new Paint(1);
        this.o0 = new Paint.FontMetrics();
        this.p0 = new RectF();
        this.q0 = new PointF();
        this.r0 = new Path();
        this.B0 = 255;
        this.F0 = PorterDuff.Mode.SRC_IN;
        this.J0 = new WeakReference((Object) null);
        L(context);
        this.l0 = context;
        s sVar = new s(this);
        this.s0 = sVar;
        this.H = "";
        sVar.e().density = context.getResources().getDisplayMetrics().density;
        this.n0 = null;
        int[] iArr = O0;
        setState(iArr);
        i2(iArr);
        this.L0 = true;
        if (j5.b.a) {
            P0.setTint(-1);
        }
    }

    public static boolean k1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean o1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean p1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static boolean q1(d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    public static a s0(Context context, AttributeSet attributeSet, int i, int i2) {
        a aVar = new a(context, attributeSet, i, i2);
        aVar.r1(attributeSet, i, i2);
        return aVar;
    }

    public final void A0(Canvas canvas, Rect rect) {
        Paint paint = this.n0;
        if (paint != null) {
            paint.setColor(G.a.o(-16777216, 127));
            canvas.drawRect(rect, this.n0);
            if (K2() || J2()) {
                i0(rect, this.p0);
                canvas.drawRect(this.p0, this.n0);
            }
            if (this.H != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.n0);
            }
            if (L2()) {
                l0(rect, this.p0);
                canvas.drawRect(this.p0, this.n0);
            }
            this.n0.setColor(G.a.o(-65536, 127));
            k0(rect, this.p0);
            canvas.drawRect(this.p0, this.n0);
            this.n0.setColor(G.a.o(-16711936, 127));
            m0(rect, this.p0);
            canvas.drawRect(this.p0, this.n0);
        }
    }

    public void A1(int i) {
        B1(this.l0.getResources().getBoolean(i));
    }

    public void A2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.H, charSequence)) {
            return;
        }
        this.H = charSequence;
        this.s0.i(true);
        invalidateSelf();
        s1();
    }

    public final void B0(Canvas canvas, Rect rect) {
        if (this.H != null) {
            Paint.Align q0 = q0(rect, this.q0);
            o0(rect, this.p0);
            if (this.s0.d() != null) {
                this.s0.e().drawableState = getState();
                this.s0.j(this.l0);
            }
            this.s0.e().setTextAlign(q0);
            int i = 0;
            boolean z = Math.round(this.s0.f(e1().toString())) > Math.round(this.p0.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.p0);
            }
            CharSequence charSequence = this.H;
            if (z && this.K0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.s0.e(), this.p0.width(), this.K0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.q0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.s0.e());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    public void B1(boolean z) {
        if (this.U != z) {
            boolean J2 = J2();
            this.U = z;
            boolean J22 = J2();
            if (J2 != J22) {
                if (J22) {
                    h0(this.V);
                } else {
                    M2(this.V);
                }
                invalidateSelf();
                s1();
            }
        }
    }

    public void B2(d dVar) {
        this.s0.h(dVar, this.l0);
    }

    public Drawable C0() {
        return this.V;
    }

    public void C1(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    public void C2(int i) {
        B2(new d(this.l0, i));
    }

    public ColorStateList D0() {
        return this.W;
    }

    public void D1(int i) {
        C1(e.a.a(this.l0, i));
    }

    public void D2(float f) {
        if (this.h0 != f) {
            this.h0 = f;
            invalidateSelf();
            s1();
        }
    }

    public ColorStateList E0() {
        return this.B;
    }

    public void E1(float f) {
        if (this.D != f) {
            this.D = f;
            setShapeAppearanceModel(C().w(f));
        }
    }

    public void E2(int i) {
        D2(this.l0.getResources().getDimension(i));
    }

    public float F0() {
        return this.N0 ? E() : this.D;
    }

    public void F1(int i) {
        E1(this.l0.getResources().getDimension(i));
    }

    public void F2(float f) {
        if (this.g0 != f) {
            this.g0 = f;
            invalidateSelf();
            s1();
        }
    }

    public float G0() {
        return this.k0;
    }

    public void G1(float f) {
        if (this.k0 != f) {
            this.k0 = f;
            invalidateSelf();
            s1();
        }
    }

    public void G2(int i) {
        F2(this.l0.getResources().getDimension(i));
    }

    public Drawable H0() {
        Drawable drawable = this.J;
        if (drawable != null) {
            return H.a.q(drawable);
        }
        return null;
    }

    public void H1(int i) {
        G1(this.l0.getResources().getDimension(i));
    }

    public void H2(boolean z) {
        if (this.H0 != z) {
            this.H0 = z;
            N2();
            onStateChange(getState());
        }
    }

    public float I0() {
        return this.L;
    }

    public void I1(Drawable drawable) {
        Drawable H0 = H0();
        if (H0 != drawable) {
            float j0 = j0();
            this.J = drawable != null ? H.a.r(drawable).mutate() : null;
            float j02 = j0();
            M2(H0);
            if (K2()) {
                h0(this.J);
            }
            invalidateSelf();
            if (j0 != j02) {
                s1();
            }
        }
    }

    public boolean I2() {
        return this.L0;
    }

    public ColorStateList J0() {
        return this.K;
    }

    public void J1(int i) {
        I1(e.a.b(this.l0, i));
    }

    public final boolean J2() {
        return this.U && this.V != null && this.z0;
    }

    public float K0() {
        return this.C;
    }

    public void K1(float f) {
        if (this.L != f) {
            float j0 = j0();
            this.L = f;
            float j02 = j0();
            invalidateSelf();
            if (j0 != j02) {
                s1();
            }
        }
    }

    public final boolean K2() {
        return this.I && this.J != null;
    }

    public float L0() {
        return this.Z;
    }

    public void L1(int i) {
        K1(this.l0.getResources().getDimension(i));
    }

    public final boolean L2() {
        return this.N && this.O != null;
    }

    public ColorStateList M0() {
        return this.E;
    }

    public void M1(ColorStateList colorStateList) {
        this.M = true;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (K2()) {
                H.a.o(this.J, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void M2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public float N0() {
        return this.F;
    }

    public void N1(int i) {
        M1(e.a.a(this.l0, i));
    }

    public final void N2() {
        this.I0 = this.H0 ? j5.b.d(this.G) : null;
    }

    public Drawable O0() {
        Drawable drawable = this.O;
        if (drawable != null) {
            return H.a.q(drawable);
        }
        return null;
    }

    public void O1(int i) {
        P1(this.l0.getResources().getBoolean(i));
    }

    public final void O2() {
        this.P = new RippleDrawable(j5.b.d(c1()), this.O, P0);
    }

    public CharSequence P0() {
        return this.S;
    }

    public void P1(boolean z) {
        if (this.I != z) {
            boolean K2 = K2();
            this.I = z;
            boolean K22 = K2();
            if (K2 != K22) {
                if (K22) {
                    h0(this.J);
                } else {
                    M2(this.J);
                }
                invalidateSelf();
                s1();
            }
        }
    }

    public float Q0() {
        return this.j0;
    }

    public void Q1(float f) {
        if (this.C != f) {
            this.C = f;
            invalidateSelf();
            s1();
        }
    }

    public float R0() {
        return this.R;
    }

    public void R1(int i) {
        Q1(this.l0.getResources().getDimension(i));
    }

    public float S0() {
        return this.i0;
    }

    public void S1(float f) {
        if (this.Z != f) {
            this.Z = f;
            invalidateSelf();
            s1();
        }
    }

    public int[] T0() {
        return this.G0;
    }

    public void T1(int i) {
        S1(this.l0.getResources().getDimension(i));
    }

    public ColorStateList U0() {
        return this.Q;
    }

    public void U1(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            if (this.N0) {
                c0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void V0(RectF rectF) {
        m0(getBounds(), rectF);
    }

    public void V1(int i) {
        U1(e.a.a(this.l0, i));
    }

    public final float W0() {
        Drawable drawable = this.z0 ? this.V : this.J;
        float f = this.L;
        if (f <= 0.0f && drawable != null) {
            f = (float) Math.ceil(w.b(this.l0, 24));
            if (drawable.getIntrinsicHeight() <= f) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f;
    }

    public void W1(float f) {
        if (this.F != f) {
            this.F = f;
            this.m0.setStrokeWidth(f);
            if (this.N0) {
                super.d0(f);
            }
            invalidateSelf();
        }
    }

    public final float X0() {
        Drawable drawable = this.z0 ? this.V : this.J;
        float f = this.L;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    public void X1(int i) {
        W1(this.l0.getResources().getDimension(i));
    }

    public TextUtils.TruncateAt Y0() {
        return this.K0;
    }

    public final void Y1(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public f Z0() {
        return this.Y;
    }

    public void Z1(Drawable drawable) {
        Drawable O02 = O0();
        if (O02 != drawable) {
            float n0 = n0();
            this.O = drawable != null ? H.a.r(drawable).mutate() : null;
            if (j5.b.a) {
                O2();
            }
            float n02 = n0();
            M2(O02);
            if (L2()) {
                h0(this.O);
            }
            invalidateSelf();
            if (n0 != n02) {
                s1();
            }
        }
    }

    public void a() {
        s1();
        invalidateSelf();
    }

    public float a1() {
        return this.f0;
    }

    public void a2(CharSequence charSequence) {
        if (this.S != charSequence) {
            this.S = N.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float b1() {
        return this.e0;
    }

    public void b2(float f) {
        if (this.j0 != f) {
            this.j0 = f;
            invalidateSelf();
            if (L2()) {
                s1();
            }
        }
    }

    public ColorStateList c1() {
        return this.G;
    }

    public void c2(int i) {
        b2(this.l0.getResources().getDimension(i));
    }

    public f d1() {
        return this.X;
    }

    public void d2(int i) {
        Z1(e.a.b(this.l0, i));
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.B0;
        int a2 = i < 255 ? W4.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        x0(canvas, bounds);
        u0(canvas, bounds);
        if (this.N0) {
            super.draw(canvas);
        }
        w0(canvas, bounds);
        z0(canvas, bounds);
        v0(canvas, bounds);
        t0(canvas, bounds);
        if (this.L0) {
            B0(canvas, bounds);
        }
        y0(canvas, bounds);
        A0(canvas, bounds);
        if (this.B0 < 255) {
            canvas.restoreToCount(a2);
        }
    }

    public CharSequence e1() {
        return this.H;
    }

    public void e2(float f) {
        if (this.R != f) {
            this.R = f;
            invalidateSelf();
            if (L2()) {
                s1();
            }
        }
    }

    public d f1() {
        return this.s0.d();
    }

    public void f2(int i) {
        e2(this.l0.getResources().getDimension(i));
    }

    public float g1() {
        return this.h0;
    }

    public void g2(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            invalidateSelf();
            if (L2()) {
                s1();
            }
        }
    }

    public int getAlpha() {
        return this.B0;
    }

    public ColorFilter getColorFilter() {
        return this.C0;
    }

    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Z + j0() + this.g0 + this.s0.f(e1().toString()) + this.h0 + n0() + this.k0), this.M0);
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (this.N0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.D);
        } else {
            outline.setRoundRect(bounds, this.D);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public final void h0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        H.a.m(drawable, H.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.O) {
            if (drawable.isStateful()) {
                drawable.setState(T0());
            }
            H.a.o(drawable, this.Q);
            return;
        }
        Drawable drawable2 = this.J;
        if (drawable == drawable2 && this.M) {
            H.a.o(drawable2, this.K);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public float h1() {
        return this.g0;
    }

    public void h2(int i) {
        g2(this.l0.getResources().getDimension(i));
    }

    public final void i0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2() || J2()) {
            float f = this.Z + this.e0;
            float X0 = X0();
            if (H.a.f(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + X0;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - X0;
            }
            float W0 = W0();
            float exactCenterY = rect.exactCenterY() - (W0 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + W0;
        }
    }

    public final ColorFilter i1() {
        ColorFilter colorFilter = this.C0;
        return colorFilter != null ? colorFilter : this.D0;
    }

    public boolean i2(int[] iArr) {
        if (Arrays.equals(this.G0, iArr)) {
            return false;
        }
        this.G0 = iArr;
        if (L2()) {
            return t1(getState(), iArr);
        }
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        return o1(this.A) || o1(this.B) || o1(this.E) || (this.H0 && o1(this.I0)) || q1(this.s0.d()) || r0() || p1(this.J) || p1(this.V) || o1(this.E0);
    }

    public float j0() {
        if (K2() || J2()) {
            return this.e0 + X0() + this.f0;
        }
        return 0.0f;
    }

    public boolean j1() {
        return this.H0;
    }

    public void j2(ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (L2()) {
                H.a.o(this.O, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void k0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (L2()) {
            float f = this.k0 + this.j0 + this.R + this.i0 + this.h0;
            if (H.a.f(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    public void k2(int i) {
        j2(e.a.a(this.l0, i));
    }

    public final void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (L2()) {
            float f = this.k0 + this.j0;
            if (H.a.f(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.R;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.R;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.R;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public boolean l1() {
        return this.T;
    }

    public void l2(boolean z) {
        if (this.N != z) {
            boolean L2 = L2();
            this.N = z;
            boolean L22 = L2();
            if (L2 != L22) {
                if (L22) {
                    h0(this.O);
                } else {
                    M2(this.O);
                }
                invalidateSelf();
                s1();
            }
        }
    }

    public final void m0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (L2()) {
            float f = this.k0 + this.j0 + this.R + this.i0 + this.h0;
            if (H.a.f(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean m1() {
        return p1(this.O);
    }

    public void m2(a aVar) {
        this.J0 = new WeakReference(aVar);
    }

    public float n0() {
        if (L2()) {
            return this.i0 + this.R + this.j0;
        }
        return 0.0f;
    }

    public boolean n1() {
        return this.N;
    }

    public void n2(TextUtils.TruncateAt truncateAt) {
        this.K0 = truncateAt;
    }

    public final void o0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.H != null) {
            float j0 = this.Z + j0() + this.g0;
            float n0 = this.k0 + n0() + this.h0;
            if (H.a.f(this) == 0) {
                rectF.left = rect.left + j0;
                rectF.right = rect.right - n0;
            } else {
                rectF.left = rect.left + n0;
                rectF.right = rect.right - j0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void o2(f fVar) {
        this.Y = fVar;
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (K2()) {
            onLayoutDirectionChanged |= H.a.m(this.J, i);
        }
        if (J2()) {
            onLayoutDirectionChanged |= H.a.m(this.V, i);
        }
        if (L2()) {
            onLayoutDirectionChanged |= H.a.m(this.O, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (K2()) {
            onLevelChange |= this.J.setLevel(i);
        }
        if (J2()) {
            onLevelChange |= this.V.setLevel(i);
        }
        if (L2()) {
            onLevelChange |= this.O.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean onStateChange(int[] iArr) {
        if (this.N0) {
            super.onStateChange(iArr);
        }
        return t1(iArr, T0());
    }

    public final float p0() {
        this.s0.e().getFontMetrics(this.o0);
        Paint.FontMetrics fontMetrics = this.o0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public void p2(int i) {
        o2(f.c(this.l0, i));
    }

    public Paint.Align q0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.H != null) {
            float j0 = this.Z + j0() + this.g0;
            if (H.a.f(this) == 0) {
                pointF.x = rect.left + j0;
            } else {
                pointF.x = rect.right - j0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - p0();
        }
        return align;
    }

    public void q2(float f) {
        if (this.f0 != f) {
            float j0 = j0();
            this.f0 = f;
            float j02 = j0();
            invalidateSelf();
            if (j0 != j02) {
                s1();
            }
        }
    }

    public final boolean r0() {
        return this.U && this.V != null && this.T;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r1(android.util.AttributeSet r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.r1(android.util.AttributeSet, int, int):void");
    }

    public void r2(int i) {
        q2(this.l0.getResources().getDimension(i));
    }

    public void s1() {
        a aVar = (a) this.J0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void s2(float f) {
        if (this.e0 != f) {
            float j0 = j0();
            this.e0 = f;
            float j02 = j0();
            invalidateSelf();
            if (j0 != j02) {
                s1();
            }
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.B0 != i) {
            this.B0 = i;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.C0 != colorFilter) {
            this.C0 = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.E0 != colorStateList) {
            this.E0 = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.F0 != mode) {
            this.F0 = mode;
            this.D0 = b5.a.b(this, this.E0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (K2()) {
            visible |= this.J.setVisible(z, z2);
        }
        if (J2()) {
            visible |= this.V.setVisible(z, z2);
        }
        if (L2()) {
            visible |= this.O.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t0(Canvas canvas, Rect rect) {
        if (J2()) {
            i0(rect, this.p0);
            RectF rectF = this.p0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.V.setBounds(0, 0, (int) this.p0.width(), (int) this.p0.height());
            this.V.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public final boolean t1(int[] iArr, int[] iArr2) {
        boolean z;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.A;
        int l = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.t0) : 0);
        boolean z2 = true;
        if (this.t0 != l) {
            this.t0 = l;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.B;
        int l2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.u0) : 0);
        if (this.u0 != l2) {
            this.u0 = l2;
            onStateChange = true;
        }
        int g = Z4.a.g(l, l2);
        if ((this.v0 != g) | (x() == null)) {
            this.v0 = g;
            W(ColorStateList.valueOf(g));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.E;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.w0) : 0;
        if (this.w0 != colorForState) {
            this.w0 = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.I0 == null || !j5.b.e(iArr)) ? 0 : this.I0.getColorForState(iArr, this.x0);
        if (this.x0 != colorForState2) {
            this.x0 = colorForState2;
            if (this.H0) {
                onStateChange = true;
            }
        }
        int colorForState3 = (this.s0.d() == null || this.s0.d().i() == null) ? 0 : this.s0.d().i().getColorForState(iArr, this.y0);
        if (this.y0 != colorForState3) {
            this.y0 = colorForState3;
            onStateChange = true;
        }
        boolean z3 = k1(getState(), 16842912) && this.T;
        if (this.z0 == z3 || this.V == null) {
            z = false;
        } else {
            float j0 = j0();
            this.z0 = z3;
            if (j0 != j0()) {
                onStateChange = true;
                z = true;
            } else {
                onStateChange = true;
                z = false;
            }
        }
        ColorStateList colorStateList4 = this.E0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.A0) : 0;
        if (this.A0 != colorForState4) {
            this.A0 = colorForState4;
            this.D0 = b5.a.b(this, this.E0, this.F0);
        } else {
            z2 = onStateChange;
        }
        if (p1(this.J)) {
            z2 |= this.J.setState(iArr);
        }
        if (p1(this.V)) {
            z2 |= this.V.setState(iArr);
        }
        if (p1(this.O)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z2 |= this.O.setState(iArr3);
        }
        if (j5.b.a && p1(this.P)) {
            z2 |= this.P.setState(iArr2);
        }
        if (z2) {
            invalidateSelf();
        }
        if (z) {
            s1();
        }
        return z2;
    }

    public void t2(int i) {
        s2(this.l0.getResources().getDimension(i));
    }

    public final void u0(Canvas canvas, Rect rect) {
        if (this.N0) {
            return;
        }
        this.m0.setColor(this.u0);
        this.m0.setStyle(Paint.Style.FILL);
        this.m0.setColorFilter(i1());
        this.p0.set(rect);
        canvas.drawRoundRect(this.p0, F0(), F0(), this.m0);
    }

    public void u1(boolean z) {
        if (this.T != z) {
            this.T = z;
            float j0 = j0();
            if (!z && this.z0) {
                this.z0 = false;
            }
            float j02 = j0();
            invalidateSelf();
            if (j0 != j02) {
                s1();
            }
        }
    }

    public void u2(int i) {
        this.M0 = i;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v0(Canvas canvas, Rect rect) {
        if (K2()) {
            i0(rect, this.p0);
            RectF rectF = this.p0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.J.setBounds(0, 0, (int) this.p0.width(), (int) this.p0.height());
            this.J.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void v1(int i) {
        u1(this.l0.getResources().getBoolean(i));
    }

    public void v2(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            N2();
            onStateChange(getState());
        }
    }

    public final void w0(Canvas canvas, Rect rect) {
        if (this.F <= 0.0f || this.N0) {
            return;
        }
        this.m0.setColor(this.w0);
        this.m0.setStyle(Paint.Style.STROKE);
        if (!this.N0) {
            this.m0.setColorFilter(i1());
        }
        RectF rectF = this.p0;
        float f = rect.left;
        float f2 = this.F;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.D - (this.F / 2.0f);
        canvas.drawRoundRect(this.p0, f3, f3, this.m0);
    }

    public void w1(Drawable drawable) {
        if (this.V != drawable) {
            float j0 = j0();
            this.V = drawable;
            float j02 = j0();
            M2(this.V);
            h0(this.V);
            invalidateSelf();
            if (j0 != j02) {
                s1();
            }
        }
    }

    public void w2(int i) {
        v2(e.a.a(this.l0, i));
    }

    public final void x0(Canvas canvas, Rect rect) {
        if (this.N0) {
            return;
        }
        this.m0.setColor(this.t0);
        this.m0.setStyle(Paint.Style.FILL);
        this.p0.set(rect);
        canvas.drawRoundRect(this.p0, F0(), F0(), this.m0);
    }

    public void x1(int i) {
        w1(e.a.b(this.l0, i));
    }

    public void x2(boolean z) {
        this.L0 = z;
    }

    public final void y0(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (L2()) {
            l0(rect, this.p0);
            RectF rectF = this.p0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.O.setBounds(0, 0, (int) this.p0.width(), (int) this.p0.height());
            if (j5.b.a) {
                this.P.setBounds(this.O.getBounds());
                this.P.jumpToCurrentState();
                drawable = this.P;
            } else {
                drawable = this.O;
            }
            drawable.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void y1(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (r0()) {
                H.a.o(this.V, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void y2(f fVar) {
        this.X = fVar;
    }

    public final void z0(Canvas canvas, Rect rect) {
        this.m0.setColor(this.x0);
        this.m0.setStyle(Paint.Style.FILL);
        this.p0.set(rect);
        if (!this.N0) {
            canvas.drawRoundRect(this.p0, F0(), F0(), this.m0);
        } else {
            h(new RectF(rect), this.r0);
            super.p(canvas, this.m0, this.r0, u());
        }
    }

    public void z1(int i) {
        y1(e.a.a(this.l0, i));
    }

    public void z2(int i) {
        y2(f.c(this.l0, i));
    }
}
