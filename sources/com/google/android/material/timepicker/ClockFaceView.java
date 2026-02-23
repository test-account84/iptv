package com.google.android.material.timepicker;

import P.L;
import Q.C;
import R4.f;
import R4.h;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class ClockFaceView extends c implements ClockHandView.c {
    public final ClockHandView B;
    public final Rect C;
    public final RectF D;
    public final SparseArray E;
    public final P.a F;
    public final int[] G;
    public final float[] H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public String[] M;
    public float N;
    public final ColorStateList O;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.v(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.z(ClockFaceView.this).g()) - ClockFaceView.A(ClockFaceView.this));
            return true;
        }
    }

    public class b extends P.a {
        public b() {
        }

        public void g(View view, C c) {
            super.g(view, c);
            int intValue = ((Integer) view.getTag(f.n)).intValue();
            if (intValue > 0) {
                c.v0((View) ClockFaceView.B(ClockFaceView.this).get(intValue - 1));
            }
            c.a0(C.c.a(0, 1, intValue, 1, false, view.isSelected()));
            c.Y(true);
            c.b(C.a.i);
        }

        public boolean j(View view, int i, Bundle bundle) {
            if (i != 16) {
                return super.j(view, i, bundle);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            float x = view.getX() + (view.getWidth() / 2.0f);
            float height = (view.getHeight() / 2.0f) + view.getY();
            ClockFaceView.z(ClockFaceView.this).onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, x, height, 0));
            ClockFaceView.z(ClockFaceView.this).onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, x, height, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.w);
    }

    public static /* synthetic */ int A(ClockFaceView clockFaceView) {
        return clockFaceView.I;
    }

    public static /* synthetic */ SparseArray B(ClockFaceView clockFaceView) {
        return clockFaceView.E;
    }

    public static float E(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static /* synthetic */ ClockHandView z(ClockFaceView clockFaceView) {
        return clockFaceView.B;
    }

    public final void C() {
        RectF d = this.B.d();
        for (int i = 0; i < this.E.size(); i++) {
            TextView textView = (TextView) this.E.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.C);
                offsetDescendantRectToMyCoords(textView, this.C);
                textView.setSelected(d.contains(this.C.centerX(), this.C.centerY()));
                textView.getPaint().setShader(D(d, this.C, textView));
                textView.invalidate();
            }
        }
    }

    public final RadialGradient D(RectF rectF, Rect rect, TextView textView) {
        this.D.set(rect);
        this.D.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (RectF.intersects(rectF, this.D)) {
            return new RadialGradient(rectF.centerX() - this.D.left, rectF.centerY() - this.D.top, rectF.width() * 0.5f, this.G, this.H, Shader.TileMode.CLAMP);
        }
        return null;
    }

    public void F(String[] strArr, int i) {
        this.M = strArr;
        G(i);
    }

    public final void G(int i) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.E.size();
        for (int i2 = 0; i2 < Math.max(this.M.length, size); i2++) {
            TextView textView = (TextView) this.E.get(i2);
            if (i2 >= this.M.length) {
                removeView(textView);
                this.E.remove(i2);
            } else {
                if (textView == null) {
                    textView = from.inflate(h.f, this, false);
                    this.E.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.M[i2]);
                textView.setTag(f.n, Integer.valueOf(i2));
                L.s0(textView, this.F);
                textView.setTextColor(this.O);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, new Object[]{this.M[i2]}));
                }
            }
        }
    }

    public void a(float f, boolean z) {
        if (Math.abs(this.N - f) > 0.001f) {
            this.N = f;
            C();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super/*android.view.ViewGroup*/.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C.y0(accessibilityNodeInfo).Z(C.b.a(1, this.M.length, false, 1));
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C();
    }

    public void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int E = (int) (this.L / E(this.J / displayMetrics.heightPixels, this.K / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(E, 1073741824);
        setMeasuredDimension(E, E);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void v(int i) {
        if (i != u()) {
            super.v(i);
            this.B.j(u());
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.C = new Rect();
        this.D = new RectF();
        this.E = new SparseArray();
        this.H = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.q1, i, k.u);
        Resources resources = getResources();
        ColorStateList a2 = i5.c.a(context, obtainStyledAttributes, l.s1);
        this.O = a2;
        LayoutInflater.from(context).inflate(h.g, this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(f.i);
        this.B = clockHandView;
        this.I = resources.getDimensionPixelSize(R4.d.l);
        int colorForState = a2.getColorForState(new int[]{16842913}, a2.getDefaultColor());
        this.G = new int[]{colorForState, colorForState, a2.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = e.a.a(context, R4.c.f).getDefaultColor();
        ColorStateList a3 = i5.c.a(context, obtainStyledAttributes, l.r1);
        setBackgroundColor(a3 != null ? a3.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.F = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        F(strArr, 0);
        this.J = resources.getDimensionPixelSize(R4.d.y);
        this.K = resources.getDimensionPixelSize(R4.d.z);
        this.L = resources.getDimensionPixelSize(R4.d.n);
    }
}
