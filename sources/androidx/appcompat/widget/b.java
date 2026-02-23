package androidx.appcompat.widget;

import P.L;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import c.j;
import k.d0;
import k.m0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b extends ViewGroup {
    public boolean a;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public boolean i;
    public int[] j;
    public int[] k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public int p;

    public static class a extends LinearLayout.LayoutParams {
        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private void l(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View s = s(i3);
            if (s.getVisibility() != 8) {
                a layoutParams = s.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = s.getMeasuredHeight();
                    measureChildWithMargins(s, makeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void g(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean b = m0.b(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View s = s(i2);
            if (s != null && s.getVisibility() != 8 && t(i2)) {
                a layoutParams = s.getLayoutParams();
                j(canvas, b ? s.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (s.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.m);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 != null) {
                a layoutParams2 = s2.getLayoutParams();
                if (b) {
                    left = s2.getLeft();
                    i = ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    right = (left - i) - this.m;
                } else {
                    right = s2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (b) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                i = getPaddingRight();
                right = (left - i) - this.m;
            }
            j(canvas, right);
        }
    }

    public int getBaseline() {
        int i;
        if (this.c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.c;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.c == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i3 = this.d;
        if (this.e == 1 && (i = this.f & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.g) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.g;
            }
        }
        return i3 + ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.c;
    }

    public Drawable getDividerDrawable() {
        return this.l;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getDividerWidth() {
        return this.m;
    }

    public int getGravity() {
        return this.f;
    }

    public int getOrientation() {
        return this.e;
    }

    public int getShowDividers() {
        return this.o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.h;
    }

    public void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View s = s(i);
            if (s != null && s.getVisibility() != 8 && t(i)) {
                i(canvas, (s.getTop() - ((LinearLayout.LayoutParams) s.getLayoutParams()).topMargin) - this.n);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            i(canvas, s2 == null ? (getHeight() - getPaddingBottom()) - this.n : s2.getBottom() + ((LinearLayout.LayoutParams) s2.getLayoutParams()).bottomMargin);
        }
    }

    public void i(Canvas canvas, int i) {
        this.l.setBounds(getPaddingLeft() + this.p, i, (getWidth() - getPaddingRight()) - this.p, this.n + i);
        this.l.draw(canvas);
    }

    public void j(Canvas canvas, int i) {
        this.l.setBounds(i, getPaddingTop() + this.p, this.m + i, (getHeight() - getPaddingBottom()) - this.p);
        this.l.draw(canvas);
    }

    public final void k(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View s = s(i3);
            if (s.getVisibility() != 8) {
                a layoutParams = s.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = s.getMeasuredWidth();
                    measureChildWithMargins(s, i2, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i = this.e;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public void onDraw(Canvas canvas) {
        if (this.l == null) {
            return;
        }
        if (this.e == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.e == 1) {
            v(i, i2, i3, i4);
        } else {
            u(i, i2, i3, i4);
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.e == 1) {
            z(i, i2);
        } else {
            x(i, i2);
        }
    }

    public int p(View view, int i) {
        return 0;
    }

    public int q(View view) {
        return 0;
    }

    public int r(View view) {
        return 0;
    }

    public View s(int i) {
        return getChildAt(i);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.l) {
            return;
        }
        this.l = drawable;
        if (drawable != null) {
            this.m = drawable.getIntrinsicWidth();
            this.n = drawable.getIntrinsicHeight();
        } else {
            this.m = 0;
            this.n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.p = i;
    }

    public void setGravity(int i) {
        if (this.f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.f;
        if ((8388615 & i3) != i2) {
            this.f = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.i = z;
    }

    public void setOrientation(int i) {
        if (this.e != i) {
            this.e = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.o) {
            requestLayout();
        }
        this.o = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.f;
        if ((i3 & 112) != i2) {
            this.f = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.h = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean t(int i) {
        if (i == 0) {
            return (this.o & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.o & 4) != 0;
        }
        if ((this.o & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void u(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void v(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.g
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.g
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = 0
        L49:
            if (r12 >= r10) goto Lc8
            android.view.View r13 = r6.s(r12)
            r14 = 1
            if (r13 != 0) goto L5a
            int r1 = r6.y(r12)
            int r0 = r0 + r1
        L57:
            r1 = 1
            goto Lc6
        L5a:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L57
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.b$a r5 = (androidx.appcompat.widget.b.a) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L76
            r1 = r11
        L76:
            int r2 = P.L.E(r17)
            int r1 = P.p.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L90
            r2 = 5
            if (r1 == r2) goto L8a
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L88:
            r2 = r1
            goto L99
        L8a:
            int r1 = r8 - r4
        L8c:
            int r2 = r5.rightMargin
            int r1 = r1 - r2
            goto L88
        L90:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            goto L8c
        L99:
            boolean r1 = r6.t(r12)
            if (r1 == 0) goto La2
            int r1 = r6.n
            int r0 = r0 + r1
        La2:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.q(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.r(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.p(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            goto L57
        Lc6:
            int r12 = r12 + r1
            goto L49
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.v(int, int, int, int):void");
    }

    public void w(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x03ad A[PHI: r3
      0x03ad: PHI (r3v31 int) = (r3v27 int), (r3v32 int) binds: [B:214:0x03be, B:179:0x03aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.x(int, int):void");
    }

    public int y(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x02d3 A[PHI: r10
      0x02d3: PHI (r10v21 int) = (r10v19 int), (r10v22 int) binds: [B:168:0x02e4, B:149:0x02d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.z(int, int):void");
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.c = -1;
        this.d = 0;
        this.f = 8388659;
        d0 v = d0.v(context, attributeSet, j.i1, i, 0);
        L.q0(this, context, j.i1, attributeSet, v.r(), i, 0);
        int k = v.k(j.k1, -1);
        if (k >= 0) {
            setOrientation(k);
        }
        int k2 = v.k(j.j1, -1);
        if (k2 >= 0) {
            setGravity(k2);
        }
        boolean a2 = v.a(j.l1, true);
        if (!a2) {
            setBaselineAligned(a2);
        }
        this.h = v.i(j.n1, -1.0f);
        this.c = v.k(j.m1, -1);
        this.i = v.a(j.q1, false);
        setDividerDrawable(v.g(j.o1));
        this.o = v.k(j.r1, 0);
        this.p = v.f(j.p1, 0);
        v.w();
    }
}
