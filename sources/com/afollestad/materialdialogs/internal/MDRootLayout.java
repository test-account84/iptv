package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import d1.e;
import d1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MDRootLayout extends ViewGroup {
    public final MDButton[] a;
    public int c;
    public View d;
    public View e;
    public boolean f;
    public boolean g;
    public f h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public d1.a p;
    public int q;
    public Paint r;
    public ViewTreeObserver.OnScrollChangedListener s;
    public ViewTreeObserver.OnScrollChangedListener t;
    public int u;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public a(View view, boolean z, boolean z2) {
            this.a = view;
            this.c = z;
            this.d = z2;
        }

        public boolean onPreDraw() {
            if (this.a.getMeasuredHeight() == 0) {
                return true;
            }
            if (MDRootLayout.a(this.a)) {
                MDRootLayout.d(MDRootLayout.this, this.a, this.c, this.d);
            } else {
                if (this.c) {
                    MDRootLayout.b(MDRootLayout.this, false);
                }
                if (this.d) {
                    MDRootLayout.c(MDRootLayout.this, false);
                }
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public class b extends RecyclerView.t {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public b(ViewGroup viewGroup, boolean z, boolean z2) {
            this.a = viewGroup;
            this.b = z;
            this.c = z2;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            super.b(recyclerView, i, i2);
            View[] e = MDRootLayout.e(MDRootLayout.this);
            int length = e.length;
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    View view = e[i3];
                    if (view != null && view.getVisibility() != 8) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            MDRootLayout.f(MDRootLayout.this, this.a, this.b, this.c, z);
            MDRootLayout.this.invalidate();
        }
    }

    public class c implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public c(ViewGroup viewGroup, boolean z, boolean z2) {
            this.a = viewGroup;
            this.c = z;
            this.d = z2;
        }

        public void onScrollChanged() {
            View[] e = MDRootLayout.e(MDRootLayout.this);
            int length = e.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < length) {
                    View view = e[i];
                    if (view != null && view.getVisibility() != 8) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            WebView webView = this.a;
            if (webView instanceof WebView) {
                MDRootLayout.g(MDRootLayout.this, webView, this.c, this.d, z);
            } else {
                MDRootLayout.f(MDRootLayout.this, webView, this.c, this.d, z);
            }
            MDRootLayout.this.invalidate();
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d1.a.values().length];
            a = iArr;
            try {
                iArr[d1.a.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d1.a.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new MDButton[3];
        this.f = false;
        this.g = false;
        this.h = f.ADAPTIVE;
        this.i = false;
        this.j = true;
        this.p = d1.a.START;
        o(context, attributeSet, 0);
    }

    public static /* synthetic */ boolean a(WebView webView) {
        return l(webView);
    }

    public static /* synthetic */ boolean b(MDRootLayout mDRootLayout, boolean z) {
        mDRootLayout.f = z;
        return z;
    }

    public static /* synthetic */ boolean c(MDRootLayout mDRootLayout, boolean z) {
        mDRootLayout.g = z;
        return z;
    }

    public static /* synthetic */ void d(MDRootLayout mDRootLayout, ViewGroup viewGroup, boolean z, boolean z2) {
        mDRootLayout.h(viewGroup, z, z2);
    }

    public static /* synthetic */ MDButton[] e(MDRootLayout mDRootLayout) {
        return mDRootLayout.a;
    }

    public static /* synthetic */ void f(MDRootLayout mDRootLayout, ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        mDRootLayout.p(viewGroup, z, z2, z3);
    }

    public static /* synthetic */ void g(MDRootLayout mDRootLayout, WebView webView, boolean z, boolean z2, boolean z3) {
        mDRootLayout.q(webView, z, z2, z3);
    }

    public static boolean i(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        return !(adapterView.getFirstVisiblePosition() == 0) || !(adapterView.getLastVisiblePosition() == adapterView.getCount() - 1) || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom();
    }

    public static boolean j(RecyclerView recyclerView) {
        return (recyclerView == null || recyclerView.getLayoutManager() == null || !recyclerView.getLayoutManager().I()) ? false : true;
    }

    public static boolean k(ScrollView scrollView) {
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        return (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight();
    }

    public static boolean l(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    public static View m(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    public static View n(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }

    public static boolean s(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        if (z && (view instanceof MDButton)) {
            return ((MDButton) view).getText().toString().trim().length() > 0;
        }
        return z;
    }

    public final void h(ViewGroup viewGroup, boolean z, boolean z2) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        if ((z2 || this.s != null) && !(z2 && this.t == null)) {
            return;
        }
        if (viewGroup instanceof RecyclerView) {
            b bVar = new b(viewGroup, z, z2);
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            recyclerView.l(bVar);
            bVar.b(recyclerView, 0, 0);
            return;
        }
        c cVar = new c(viewGroup, z, z2);
        if (z2) {
            this.t = cVar;
            viewTreeObserver = viewGroup.getViewTreeObserver();
            onScrollChangedListener = this.t;
        } else {
            this.s = cVar;
            viewTreeObserver = viewGroup.getViewTreeObserver();
            onScrollChangedListener = this.s;
        }
        viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
        cVar.onScrollChanged();
    }

    public final void o(Context context, AttributeSet attributeSet, int i) {
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.u, i, 0);
        this.k = obtainStyledAttributes.getBoolean(e.v, true);
        obtainStyledAttributes.recycle();
        this.m = resources.getDimensionPixelSize(d1.c.g);
        this.n = resources.getDimensionPixelSize(d1.c.a);
        this.q = resources.getDimensionPixelSize(d1.c.c);
        this.o = resources.getDimensionPixelSize(d1.c.b);
        this.r = new Paint();
        this.u = resources.getDimensionPixelSize(d1.c.e);
        this.r.setColor(e1.a.a(context, d1.b.a));
        setWillNotDraw(false);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.e;
        if (view != null) {
            if (this.f) {
                canvas.drawRect(0.0f, r0 - this.u, getMeasuredWidth(), view.getTop(), this.r);
            }
            if (this.g) {
                canvas.drawRect(0.0f, this.e.getBottom(), getMeasuredWidth(), r0 + this.u, this.r);
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            MDButton childAt = getChildAt(i);
            if (childAt.getId() == d1.d.d) {
                this.d = childAt;
            } else if (childAt.getId() == d1.d.b) {
                this.a[0] = childAt;
            } else if (childAt.getId() == d1.d.a) {
                this.a[1] = childAt;
            } else if (childAt.getId() == d1.d.c) {
                this.a[2] = childAt;
            } else {
                this.e = childAt;
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View view;
        int i7;
        int i8;
        int i9;
        int measuredWidth;
        int measuredWidth2;
        int i10;
        if (s(this.d)) {
            int measuredHeight = this.d.getMeasuredHeight() + i2;
            this.d.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (!this.l && this.j) {
            i2 += this.m;
        }
        if (s(this.e)) {
            View view2 = this.e;
            view2.layout(i, i2, i3, view2.getMeasuredHeight() + i2);
        }
        if (this.i) {
            int i11 = i4 - this.n;
            for (View view3 : this.a) {
                if (s(view3)) {
                    view3.layout(i, i11 - view3.getMeasuredHeight(), i3, i11);
                    i11 -= view3.getMeasuredHeight();
                }
            }
        } else {
            if (this.j) {
                i4 -= this.n;
            }
            int i12 = i4 - this.o;
            int i13 = this.q;
            if (s(this.a[2])) {
                if (this.p == d1.a.END) {
                    measuredWidth2 = i + i13;
                    i10 = this.a[2].getMeasuredWidth() + measuredWidth2;
                    i5 = -1;
                } else {
                    int i14 = i3 - i13;
                    measuredWidth2 = i14 - this.a[2].getMeasuredWidth();
                    i10 = i14;
                    i5 = measuredWidth2;
                }
                this.a[2].layout(measuredWidth2, i12, i10, i4);
                i13 += this.a[2].getMeasuredWidth();
            } else {
                i5 = -1;
            }
            if (s(this.a[1])) {
                d1.a aVar = this.p;
                if (aVar == d1.a.END) {
                    i9 = i13 + i;
                    measuredWidth = this.a[1].getMeasuredWidth() + i9;
                } else if (aVar == d1.a.START) {
                    measuredWidth = i3 - i13;
                    i9 = measuredWidth - this.a[1].getMeasuredWidth();
                } else {
                    i9 = this.q + i;
                    measuredWidth = this.a[1].getMeasuredWidth() + i9;
                    i6 = measuredWidth;
                    this.a[1].layout(i9, i12, measuredWidth, i4);
                }
                i6 = -1;
                this.a[1].layout(i9, i12, measuredWidth, i4);
            } else {
                i6 = -1;
            }
            if (s(this.a[0])) {
                d1.a aVar2 = this.p;
                if (aVar2 == d1.a.END) {
                    i7 = i3 - this.q;
                    i8 = i7 - this.a[0].getMeasuredWidth();
                } else if (aVar2 == d1.a.START) {
                    i8 = i + this.q;
                    i7 = this.a[0].getMeasuredWidth() + i8;
                } else {
                    if (i6 != -1 || i5 == -1) {
                        if (i5 == -1 && i6 != -1) {
                            view = this.a[0];
                        } else if (i5 == -1) {
                            i6 = ((i3 - i) / 2) - (this.a[0].getMeasuredWidth() / 2);
                            view = this.a[0];
                        }
                        i5 = i6 + view.getMeasuredWidth();
                    } else {
                        i6 = i5 - this.a[0].getMeasuredWidth();
                    }
                    i7 = i5;
                    i8 = i6;
                }
                this.a[0].layout(i8, i12, i7, i4);
            }
        }
        t(this.e, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    public final void p(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        if (z && viewGroup.getChildCount() > 0) {
            View view = this.d;
            this.f = (view == null || view.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (!z2 || viewGroup.getChildCount() <= 0) {
            return;
        }
        this.g = z3 && (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() < viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom();
    }

    public final void q(WebView webView, boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        if (z) {
            View view = this.d;
            this.f = (view == null || view.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            if (z3 && (webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom() < webView.getContentHeight() * webView.getScale()) {
                z4 = true;
            }
            this.g = z4;
        }
    }

    public final void r() {
        d1.a aVar;
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            int i = d.a[this.p.ordinal()];
            if (i == 1) {
                aVar = d1.a.END;
            } else if (i != 2) {
                return;
            } else {
                aVar = d1.a.START;
            }
            this.p = aVar;
        }
    }

    public void setButtonGravity(d1.a aVar) {
        this.p = aVar;
        r();
    }

    public void setButtonStackedGravity(d1.a aVar) {
        for (MDButton mDButton : this.a) {
            if (mDButton != null) {
                mDButton.setStackedGravity(aVar);
            }
        }
    }

    public void setDividerColor(int i) {
        this.r.setColor(i);
        invalidate();
    }

    public void setMaxHeight(int i) {
        this.c = i;
    }

    public void setStackingBehavior(f fVar) {
        this.h = fVar;
        invalidate();
    }

    public final void t(View view, boolean z, boolean z2) {
        ScrollView scrollView;
        if (view == null) {
            return;
        }
        if (view instanceof ScrollView) {
            scrollView = (ScrollView) view;
            if (!k(scrollView)) {
                if (z) {
                    this.f = false;
                }
                if (!z2) {
                    return;
                }
                this.g = false;
                return;
            }
            h(scrollView, z, z2);
        }
        if (view instanceof AdapterView) {
            scrollView = (AdapterView) view;
            if (!i(scrollView)) {
                if (z) {
                    this.f = false;
                }
                if (!z2) {
                    return;
                }
                this.g = false;
                return;
            }
        } else {
            if (view instanceof WebView) {
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, z, z2));
                return;
            }
            if (!(view instanceof RecyclerView)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    View n = n(viewGroup);
                    t(n, z, z2);
                    View m = m(viewGroup);
                    if (m != n) {
                        t(m, false, true);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean j = j((RecyclerView) view);
            if (z) {
                this.f = j;
            }
            if (z2) {
                this.g = j;
            }
            if (!j) {
                return;
            } else {
                scrollView = (ViewGroup) view;
            }
        }
        h(scrollView, z, z2);
    }
}
