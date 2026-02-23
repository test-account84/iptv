package androidx.appcompat.widget;

import P.B;
import P.C;
import P.D;
import P.L;
import P.X;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.i;
import c.f;
import k.G;
import k.H;

@SuppressLint({"UnknownNullness"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements G, B, C {
    public static final int[] G = {c.a.b, 16842841};
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final D F;
    public int a;
    public int c;
    public ContentFrameLayout d;
    public ActionBarContainer e;
    public H f;
    public Drawable g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final Rect o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect s;
    public final Rect t;
    public final Rect u;
    public X v;
    public X w;
    public X x;
    public X y;
    public d z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.e.animate().translationY(-ActionBarOverlayLayout.this.e.getHeight()).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
        void a();

        void b(int i);

        void c();

        void d(boolean z);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i, int i2) {
            super(i, i2);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        X x = X.b;
        this.v = x;
        this.w = x;
        this.x = x;
        this.y = x;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        v(context);
        this.F = new D(this);
    }

    public final void A() {
        u();
        this.D.run();
    }

    public final boolean B(float f) {
        this.A.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.A.getFinalY() > this.e.getHeight();
    }

    public boolean a() {
        z();
        return this.f.a();
    }

    public boolean b() {
        z();
        return this.f.b();
    }

    public boolean c() {
        z();
        return this.f.c();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void d(Menu menu, i.a aVar) {
        z();
        this.f.d(menu, aVar);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g == null || this.h) {
            return;
        }
        int bottom = this.e.getVisibility() == 0 ? (int) (this.e.getBottom() + this.e.getTranslationY() + 0.5f) : 0;
        this.g.setBounds(0, bottom, getWidth(), this.g.getIntrinsicHeight() + bottom);
        this.g.draw(canvas);
    }

    public boolean e() {
        z();
        return this.f.e();
    }

    public void f() {
        z();
        this.f.f();
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public boolean g() {
        z();
        return this.f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f.getTitle();
    }

    public void h(int i) {
        z();
        if (i == 2) {
            this.f.p();
        } else if (i == 5) {
            this.f.y();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public void i(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    public void j(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    public void k(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public void l() {
        z();
        this.f.r();
    }

    public void m(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        n(view, i, i2, i3, i4, i5);
    }

    public void n(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public boolean o(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        X v = X.v(windowInsets, this);
        boolean q = q(this.e, new Rect(v.i(), v.k(), v.j(), v.h()), true, true, false, true);
        L.h(this, v, this.o);
        Rect rect = this.o;
        X l = v.l(rect.left, rect.top, rect.right, rect.bottom);
        this.v = l;
        boolean z = true;
        if (!this.w.equals(l)) {
            this.w = this.v;
            q = true;
        }
        if (this.p.equals(this.o)) {
            z = q;
        } else {
            this.p.set(this.o);
        }
        if (z) {
            requestLayout();
        }
        return v.a().c().b().t();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        L.p0(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e layoutParams = childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int measuredHeight;
        X a2;
        z();
        measureChildWithMargins(this.e, i, 0, i2, 0);
        e layoutParams = this.e.getLayoutParams();
        int max = Math.max(0, this.e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.e.getMeasuredState());
        boolean z = (L.O(this) & 256) != 0;
        if (z) {
            measuredHeight = this.a;
            if (this.j && this.e.getTabContainer() != null) {
                measuredHeight += this.a;
            }
        } else {
            measuredHeight = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        X x = this.v;
        this.x = x;
        if (this.i || z) {
            a2 = new X.b(this.x).c(G.b.b(x.i(), this.x.k() + measuredHeight, this.x.j(), this.x.h())).a();
        } else {
            Rect rect = this.q;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            a2 = x.l(0, measuredHeight, 0, 0);
        }
        this.x = a2;
        q(this.d, this.q, true, true, true, true);
        if (!this.y.equals(this.x)) {
            X x2 = this.x;
            this.y = x2;
            L.i(this.d, x2);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        e layoutParams2 = this.d.getLayoutParams();
        int max3 = Math.max(max, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.k || !z) {
            return false;
        }
        if (B(f2)) {
            p();
        } else {
            A();
        }
        this.l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.m + i2;
        this.m = i5;
        setActionBarHideOffset(i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.F.b(view, view2, i);
        this.m = getActionBarHideOffset();
        u();
        d dVar = this.z;
        if (dVar != null) {
            dVar.f();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        z();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        d dVar = this.z;
        if (dVar != null) {
            dVar.d(!z2);
            if (z || !z2) {
                this.z.a();
            } else {
                this.z.e();
            }
        }
        if ((i2 & 256) == 0 || this.z == null) {
            return;
        }
        L.p0(this);
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        d dVar = this.z;
        if (dVar != null) {
            dVar.b(i);
        }
    }

    public final void p() {
        u();
        this.E.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i) {
        u();
        this.e.setTranslationY(-Math.max(0, Math.min(i, this.e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.z = dVar;
        if (getWindowToken() != null) {
            this.z.b(this.c);
            int i = this.n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                L.p0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (z) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        z();
        this.f.setIcon(i);
    }

    public void setLogo(int i) {
        z();
        this.f.t(i);
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        this.h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final H t(View view) {
        if (view instanceof H) {
            return (H) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void u() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.h = context.getApplicationInfo().targetSdkVersion < 19;
        this.A = new OverScroller(context);
    }

    public boolean w() {
        return this.i;
    }

    public final void x() {
        u();
        postDelayed(this.E, 600L);
    }

    public final void y() {
        u();
        postDelayed(this.D, 600L);
    }

    public void z() {
        if (this.d == null) {
            this.d = findViewById(f.b);
            this.e = findViewById(f.c);
            this.f = t(findViewById(f.a));
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f.setIcon(drawable);
    }
}
