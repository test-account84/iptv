package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.b;
import k.m0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ActionMenuView extends androidx.appcompat.widget.b implements e.b, j {
    public int A;
    public e B;
    public androidx.appcompat.view.menu.e q;
    public Context r;
    public int s;
    public boolean t;
    public androidx.appcompat.widget.a u;
    public i.a v;
    public e.a w;
    public boolean x;
    public int y;
    public int z;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements i.a {
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
        }

        public boolean c(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends b.a {
        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }
    }

    public class d implements e.a {
        public d() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.B;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.w;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int L(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r0 = (androidx.appcompat.widget.ActionMenuView.c) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.r()
            if (r9 == 0) goto L28
            r9 = 1
            goto L29
        L28:
            r9 = 0
        L29:
            if (r7 <= 0) goto L4d
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4d
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L46
            int r4 = r4 + 1
        L46:
            if (r9 == 0) goto L4b
            if (r4 >= r3) goto L4b
            goto L4e
        L4b:
            r3 = r4
            goto L4e
        L4d:
            r3 = 0
        L4e:
            boolean r7 = r0.a
            if (r7 != 0) goto L55
            if (r9 == 0) goto L55
            r1 = 1
        L55:
            r0.d = r1
            r0.b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.L(android.view.View, int, int, int, int):int");
    }

    public void B() {
        androidx.appcompat.widget.a aVar = this.u;
        if (aVar != null) {
            aVar.y();
        }
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c n(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c o(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c F() {
        c m = m();
        m.a = true;
        return m;
    }

    public boolean G(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        a childAt = getChildAt(i - 1);
        a childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = childAt.a();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | childAt2.b();
    }

    public boolean H() {
        androidx.appcompat.widget.a aVar = this.u;
        return aVar != null && aVar.B();
    }

    public boolean I() {
        androidx.appcompat.widget.a aVar = this.u;
        return aVar != null && aVar.D();
    }

    public boolean J() {
        androidx.appcompat.widget.a aVar = this.u;
        return aVar != null && aVar.E();
    }

    public boolean K() {
        return this.t;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    public final void M(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i7 = size - paddingLeft;
        int i8 = this.z;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = i8 + (i10 / i9);
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        boolean z4 = false;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        long j = 0;
        while (i13 < childCount) {
            ActionMenuItemView childAt = getChildAt(i13);
            int i17 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i18 = i14 + 1;
                if (z5) {
                    int i19 = this.A;
                    i6 = i18;
                    r14 = 0;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    i6 = i18;
                    r14 = 0;
                }
                c layoutParams = childAt.getLayoutParams();
                layoutParams.f = r14;
                layoutParams.c = r14;
                layoutParams.b = r14;
                layoutParams.d = r14;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = r14;
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = r14;
                layoutParams.e = z5 && childAt.r();
                int L = L(childAt, i11, layoutParams.a ? 1 : i9, childMeasureSpec, paddingTop);
                i15 = Math.max(i15, L);
                if (layoutParams.d) {
                    i16++;
                }
                if (layoutParams.a) {
                    z4 = true;
                }
                i9 -= L;
                i12 = Math.max(i12, childAt.getMeasuredHeight());
                if (L == 1) {
                    j |= 1 << i13;
                    i12 = i12;
                }
                i14 = i6;
            }
            i13++;
            size2 = i17;
        }
        int i20 = size2;
        boolean z6 = z4 && i14 == 2;
        boolean z7 = false;
        while (i16 > 0 && i9 > 0) {
            int i21 = 0;
            int i22 = 0;
            int i23 = Integer.MAX_VALUE;
            long j2 = 0;
            while (i22 < childCount) {
                boolean z8 = z7;
                c layoutParams2 = getChildAt(i22).getLayoutParams();
                int i24 = i12;
                if (layoutParams2.d) {
                    int i25 = layoutParams2.b;
                    if (i25 < i23) {
                        j2 = 1 << i22;
                        i23 = i25;
                        i21 = 1;
                    } else if (i25 == i23) {
                        i21++;
                        j2 |= 1 << i22;
                    }
                }
                i22++;
                i12 = i24;
                z7 = z8;
            }
            z = z7;
            i5 = i12;
            j |= j2;
            if (i21 > i9) {
                i3 = mode;
                i4 = i7;
                break;
            }
            int i26 = i23 + 1;
            int i27 = 0;
            while (i27 < childCount) {
                View childAt2 = getChildAt(i27);
                c layoutParams3 = childAt2.getLayoutParams();
                int i28 = i7;
                int i29 = mode;
                long j3 = 1 << i27;
                if ((j2 & j3) == 0) {
                    if (layoutParams3.b == i26) {
                        j |= j3;
                    }
                    z3 = z6;
                } else {
                    if (z6 && layoutParams3.e && i9 == 1) {
                        int i30 = this.A;
                        z3 = z6;
                        childAt2.setPadding(i30 + i11, 0, i30, 0);
                    } else {
                        z3 = z6;
                    }
                    layoutParams3.b++;
                    layoutParams3.f = true;
                    i9--;
                }
                i27++;
                mode = i29;
                i7 = i28;
                z6 = z3;
            }
            i12 = i5;
            z7 = true;
        }
        i3 = mode;
        i4 = i7;
        z = z7;
        i5 = i12;
        boolean z9 = !z4 && i14 == 1;
        if (i9 <= 0 || j == 0 || (i9 >= i14 - 1 && !z9 && i15 <= 1)) {
            z2 = z;
        } else {
            float bitCount = Long.bitCount(j);
            if (!z9) {
                if ((j & 1) != 0 && !getChildAt(0).getLayoutParams().e) {
                    bitCount -= 0.5f;
                }
                int i31 = childCount - 1;
                if ((j & (1 << i31)) != 0 && !getChildAt(i31).getLayoutParams().e) {
                    bitCount -= 0.5f;
                }
            }
            int i32 = bitCount > 0.0f ? (int) ((i9 * i11) / bitCount) : 0;
            z2 = z;
            for (int i33 = 0; i33 < childCount; i33++) {
                if ((j & (1 << i33)) != 0) {
                    View childAt3 = getChildAt(i33);
                    c layoutParams4 = childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.c = i32;
                        layoutParams4.f = true;
                        if (i33 == 0 && !layoutParams4.e) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = (-i32) / 2;
                        }
                    } else if (layoutParams4.a) {
                        layoutParams4.c = i32;
                        layoutParams4.f = true;
                        ((LinearLayout.LayoutParams) layoutParams4).rightMargin = (-i32) / 2;
                    } else {
                        if (i33 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = i32 / 2;
                        }
                        if (i33 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams4).rightMargin = i32 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i34 = 0; i34 < childCount; i34++) {
                View childAt4 = getChildAt(i34);
                c layoutParams5 = childAt4.getLayoutParams();
                if (layoutParams5.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.b * i11) + layoutParams5.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i5 : i20);
    }

    public androidx.appcompat.view.menu.e N() {
        return this.q;
    }

    public void O(i.a aVar, e.a aVar2) {
        this.v = aVar;
        this.w = aVar2;
    }

    public boolean P() {
        androidx.appcompat.widget.a aVar = this.u;
        return aVar != null && aVar.K();
    }

    public void a(androidx.appcompat.view.menu.e eVar) {
        this.q = eVar;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean d(g gVar) {
        return this.q.L(gVar, 0);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.q = eVar;
            eVar.R(new d());
            androidx.appcompat.widget.a aVar = new androidx.appcompat.widget.a(context);
            this.u = aVar;
            aVar.J(true);
            androidx.appcompat.widget.a aVar2 = this.u;
            i.a aVar3 = this.v;
            if (aVar3 == null) {
                aVar3 = new b();
            }
            aVar2.d(aVar3);
            this.q.c(this.u, this.r);
            this.u.H(this);
        }
        return this.q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.u.A();
    }

    public int getPopupTheme() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.a aVar = this.u;
        if (aVar != null) {
            aVar.f(false);
            if (this.u.E()) {
                this.u.B();
                this.u.K();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i5;
        if (!this.x) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean b2 = m0.b(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                c layoutParams = childAt.getLayoutParams();
                if (layoutParams.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b2) {
                        i5 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = i5 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        i5 = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(i5, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    G(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (b2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                c layoutParams2 = childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.a) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            c layoutParams3 = childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.a) {
                int i19 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft = i19 + measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + max;
            }
        }
    }

    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.e eVar;
        boolean z = this.x;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.x = z2;
        if (z != z2) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.x && (eVar = this.q) != null && size != this.y) {
            this.y = size;
            eVar.K(true);
        }
        int childCount = getChildCount();
        if (this.x && childCount > 0) {
            M(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c layoutParams = getChildAt(i3).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.u.G(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.u.I(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.t = z;
    }

    public void setPopupTheme(int i) {
        if (this.s != i) {
            this.s = i;
            if (i == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.a aVar) {
        this.u = aVar;
        aVar.H(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f);
        this.A = (int) (f * 4.0f);
        this.r = context;
        this.s = 0;
    }
}
