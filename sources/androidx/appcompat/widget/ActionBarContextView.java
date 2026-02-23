package androidx.appcompat.widget;

import P.L;
import P.S;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.f;
import c.g;
import c.j;
import k.d0;
import k.m0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ActionBarContextView extends k.a {
    public CharSequence j;
    public CharSequence k;
    public View l;
    public View m;
    public View n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public int r;
    public int s;
    public boolean t;
    public int u;

    public class a implements View.OnClickListener {
        public final /* synthetic */ i.b a;

        public a(i.b bVar) {
            this.a = bVar;
        }

        public void onClick(View view) {
            this.a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public /* bridge */ /* synthetic */ S f(int i, long j) {
        return super.f(i, j);
    }

    public void g() {
        if (this.l == null) {
            k();
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.k;
    }

    public CharSequence getTitle() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(i.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.l
            if (r0 != 0) goto L19
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.u
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.l = r0
        L15:
            r3.addView(r0)
            goto L22
        L19:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L22
            android.view.View r0 = r3.l
            goto L15
        L22:
            android.view.View r0 = r3.l
            int r1 = c.f.i
            android.view.View r0 = r0.findViewById(r1)
            r3.m = r0
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.e r4 = (androidx.appcompat.view.menu.e) r4
            androidx.appcompat.widget.a r0 = r3.e
            if (r0 == 0) goto L41
            r0.y()
        L41:
            androidx.appcompat.widget.a r0 = new androidx.appcompat.widget.a
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.e = r0
            r1 = 1
            r0.J(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.a r1 = r3.e
            android.content.Context r2 = r3.c
            r4.c(r1, r2)
            androidx.appcompat.widget.a r4 = r3.e
            androidx.appcompat.view.menu.j r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.d = r4
            r1 = 0
            P.L.w0(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.d
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(i.b):void");
    }

    public final void i() {
        if (this.o == null) {
            LayoutInflater.from(getContext()).inflate(g.a, this);
            LinearLayout childAt = getChildAt(getChildCount() - 1);
            this.o = childAt;
            this.p = childAt.findViewById(f.e);
            this.q = this.o.findViewById(f.d);
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
            if (this.s != 0) {
                this.q.setTextAppearance(getContext(), this.s);
            }
        }
        this.p.setText(this.j);
        this.q.setText(this.k);
        boolean z = !TextUtils.isEmpty(this.j);
        boolean z2 = !TextUtils.isEmpty(this.k);
        this.q.setVisibility(z2 ? 0 : 8);
        this.o.setVisibility((z || z2) ? 0 : 8);
        if (this.o.getParent() == null) {
            addView(this.o);
        }
    }

    public boolean j() {
        return this.t;
    }

    public void k() {
        removeAllViews();
        this.n = null;
        this.d = null;
        this.e = null;
        View view = this.m;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean l() {
        androidx.appcompat.widget.a aVar = this.e;
        if (aVar != null) {
            return aVar.K();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.a aVar = this.e;
        if (aVar != null) {
            aVar.B();
            this.e.C();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean b = m0.b(this);
        int paddingRight = b ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams layoutParams = this.l.getLayoutParams();
            int i5 = b ? layoutParams.rightMargin : layoutParams.leftMargin;
            int i6 = b ? layoutParams.leftMargin : layoutParams.rightMargin;
            int d = k.a.d(paddingRight, i5, b);
            paddingRight = k.a.d(d + e(this.l, d, paddingTop, paddingTop2, b), i6, b);
        }
        int i7 = paddingRight;
        LinearLayout linearLayout = this.o;
        if (linearLayout != null && this.n == null && linearLayout.getVisibility() != 8) {
            i7 += e(this.o, i7, paddingTop, paddingTop2, b);
        }
        int i8 = i7;
        View view2 = this.n;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, b);
        }
        int paddingLeft = b ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b);
        }
    }

    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.f;
        if (i3 <= 0) {
            i3 = View.MeasureSpec.getSize(i2);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = i3 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        View view = this.l;
        if (view != null) {
            int c = c(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams layoutParams = this.l.getLayoutParams();
            paddingLeft = c - (layoutParams.leftMargin + layoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.d, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.o;
        if (linearLayout != null && this.n == null) {
            if (this.t) {
                this.o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.o.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.o.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.n;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            int i5 = layoutParams2.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams2.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                i4 = Math.min(i7, i4);
            }
            this.n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i4, i8));
        }
        if (this.f > 0) {
            setMeasuredDimension(size, i3);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.f = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.n;
        if (view2 != null) {
            removeView(view2);
        }
        this.n = view;
        if (view != null && (linearLayout = this.o) != null) {
            removeView(linearLayout);
            this.o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.j = charSequence;
        i();
        L.v0(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.t) {
            requestLayout();
        }
        this.t = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.g);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d0 v = d0.v(context, attributeSet, j.y, i, 0);
        L.w0(this, v.g(j.z));
        this.r = v.n(j.D, 0);
        this.s = v.n(j.C, 0);
        this.f = v.m(j.B, 0);
        this.u = v.n(j.A, g.d);
        v.w();
    }
}
