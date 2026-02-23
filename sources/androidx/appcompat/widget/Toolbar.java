package androidx.appcompat.widget;

import P.L;
import P.p;
import P.s;
import P.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.k;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import c.j;
import d.a;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.H;
import k.X;
import k.d0;
import k.e0;
import k.f0;
import k.g0;
import k.m0;
import k.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList E;
    public final ArrayList F;
    public final int[] G;
    public final v H;
    public ArrayList I;
    public h J;
    public final ActionMenuView.e K;
    public androidx.appcompat.widget.d L;
    public androidx.appcompat.widget.a M;
    public f N;
    public i.a O;
    public e.a P;
    public boolean Q;
    public OnBackInvokedCallback R;
    public OnBackInvokedDispatcher S;
    public boolean T;
    public final Runnable U;
    public ActionMenuView a;
    public TextView c;
    public TextView d;
    public ImageButton e;
    public ImageView f;
    public Drawable g;
    public CharSequence h;
    public ImageButton i;
    public View j;
    public Context k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public X u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    public class a implements ActionMenuView.e {
        public a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.H.j(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.J;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Toolbar.this.Q();
        }
    }

    public class c implements e.a {
        public c() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.P;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.a.J()) {
                Toolbar.this.H.k(eVar);
            }
            e.a aVar = Toolbar.this.P;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new k(runnable);
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class f implements androidx.appcompat.view.menu.i {
        public androidx.appcompat.view.menu.e a;
        public androidx.appcompat.view.menu.g c;

        public f() {
        }

        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
        }

        public boolean c(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            Toolbar parent = Toolbar.this.i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    parent.removeView(toolbar.i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.i);
            }
            Toolbar.this.j = gVar.getActionView();
            this.c = gVar;
            Toolbar parent2 = Toolbar.this.j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    parent2.removeView(toolbar3.j);
                }
                g generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.a = (toolbar4.o & 112) | 8388611;
                generateDefaultLayoutParams.b = 2;
                toolbar4.j.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.j);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            gVar.r(true);
            i.c cVar = Toolbar.this.j;
            if (cVar instanceof i.c) {
                cVar.b();
            }
            Toolbar.this.R();
            return true;
        }

        public boolean e(l lVar) {
            return false;
        }

        public void f(boolean z) {
            if (this.c != null) {
                androidx.appcompat.view.menu.e eVar = this.a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.c) {
                            return;
                        }
                    }
                }
                h(this.a, this.c);
            }
        }

        public boolean g() {
            return false;
        }

        public boolean h(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            i.c cVar = Toolbar.this.j;
            if (cVar instanceof i.c) {
                cVar.f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.j = null;
            toolbar3.a();
            this.c = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.R();
            return true;
        }

        public void i(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.a;
            if (eVar2 != null && (gVar = this.c) != null) {
                eVar2.f(gVar);
            }
            this.a = eVar;
        }
    }

    public static class g extends a.a {
        public int b;

        public g(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public g(g gVar) {
            super(gVar);
            this.b = 0;
            this.b = gVar.b;
        }

        public g(a.a aVar) {
            super(aVar);
            this.b = 0;
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class i extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public int d;
        public boolean e;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i) {
                return new i[i];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readInt();
            this.e = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.R);
    }

    private ArrayList getCurrentMenuItems() {
        ArrayList arrayList = new ArrayList();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new i.g(getContext());
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.J();
    }

    public final int C(View view, int i2, int[] iArr, int i3) {
        g layoutParams = view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int q = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q, max + measuredWidth, view.getMeasuredHeight() + q);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    public final int D(View view, int i2, int[] iArr, int i3) {
        g layoutParams = view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int q = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q, max, view.getMeasuredHeight() + q);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    public final int E(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        int i6 = layoutParams.leftMargin - iArr[0];
        int i7 = layoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, layoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void F(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i3, layoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void G() {
        Menu menu = getMenu();
        ArrayList currentMenuItems = getCurrentMenuItems();
        this.H.h(menu, getMenuInflater());
        ArrayList currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.I = currentMenuItems2;
    }

    public final void H() {
        removeCallbacks(this.U);
        post(this.U);
    }

    public void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            ActionMenuView childAt = getChildAt(childCount);
            if (childAt.getLayoutParams().b != 2 && childAt != this.a) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void J(int i2, int i3) {
        h();
        this.u.g(i2, i3);
    }

    public void K(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.a aVar) {
        if (eVar == null && this.a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e N = this.a.N();
        if (N == eVar) {
            return;
        }
        if (N != null) {
            N.O(this.M);
            N.O(this.N);
        }
        if (this.N == null) {
            this.N = new f();
        }
        aVar.G(true);
        if (eVar != null) {
            eVar.c(aVar, this.k);
            eVar.c(this.N, this.k);
        } else {
            aVar.i(this.k, null);
            this.N.i(this.k, null);
            aVar.f(true);
            this.N.f(true);
        }
        this.a.setPopupTheme(this.l);
        this.a.setPresenter(aVar);
        this.M = aVar;
        R();
    }

    public void L(i.a aVar, e.a aVar2) {
        this.O = aVar;
        this.P = aVar2;
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void M(Context context, int i2) {
        this.n = i2;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void N(Context context, int i2) {
        this.m = i2;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public final boolean O() {
        if (!this.Q) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.P();
    }

    public void R() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a2 = e.a(this);
            boolean z = v() && a2 != null && L.V(this) && this.T;
            if (z && this.S == null) {
                if (this.R == null) {
                    this.R = e.b(new e0(this));
                }
                e.c(a2, this.R);
            } else {
                if (z || (onBackInvokedDispatcher = this.S) == null) {
                    return;
                }
                e.d(onBackInvokedDispatcher, this.R);
                a2 = null;
            }
            this.S = a2;
        }
    }

    public void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView((View) this.F.get(size));
        }
        this.F.clear();
    }

    public final void b(List list, int i2) {
        boolean z = L.E(this) == 1;
        int childCount = getChildCount();
        int b2 = p.b(i2, L.E(this));
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                g layoutParams = childAt.getLayoutParams();
                if (layoutParams.b == 0 && P(childAt) && p(layoutParams.a) == b2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            g layoutParams2 = childAt2.getLayoutParams();
            if (layoutParams2.b == 0 && P(childAt2) && p(layoutParams2.a) == b2) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        generateDefaultLayoutParams.b = 1;
        if (!z || this.j == null) {
            addView(view, generateDefaultLayoutParams);
        } else {
            view.setLayoutParams(generateDefaultLayoutParams);
            this.F.add(view);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.a) != null && actionMenuView.K();
    }

    public void e() {
        f fVar = this.N;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.c;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    public void g() {
        if (this.i == null) {
            n nVar = new n(getContext(), null, c.a.Q);
            this.i = nVar;
            nVar.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            g generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = (this.o & 112) | 8388611;
            generateDefaultLayoutParams.b = 2;
            this.i.setLayoutParams(generateDefaultLayoutParams);
            this.i.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        X x = this.u;
        if (x != null) {
            return x.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        X x = this.u;
        if (x != null) {
            return x.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        X x = this.u;
        if (x != null) {
            return x.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        X x = this.u;
        if (x != null) {
            return x.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e N;
        ActionMenuView actionMenuView = this.a;
        return (actionMenuView == null || (N = actionMenuView.N()) == null || !N.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.w, 0));
    }

    public int getCurrentContentInsetLeft() {
        return L.E(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return L.E(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.a.getMenu();
    }

    public View getNavButtonView() {
        return this.e;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.a getOuterActionMenuPresenter() {
        return this.M;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.k;
    }

    public int getPopupTheme() {
        return this.l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.d;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public final TextView getTitleTextView() {
        return this.c;
    }

    public H getWrapper() {
        if (this.L == null) {
            this.L = new androidx.appcompat.widget.d(this, true);
        }
        return this.L;
    }

    public final void h() {
        if (this.u == null) {
            this.u = new X();
        }
    }

    public final void i() {
        if (this.f == null) {
            this.f = new AppCompatImageView(getContext());
        }
    }

    public final void j() {
        k();
        if (this.a.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.a.getMenu();
            if (this.N == null) {
                this.N = new f();
            }
            this.a.setExpandedActionViewsExclusive(true);
            eVar.c(this.N, this.k);
            R();
        }
    }

    public final void k() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.a.setOnMenuItemClickListener(this.K);
            this.a.O(this.O, new c());
            g generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = (this.o & 112) | 8388613;
            this.a.setLayoutParams(generateDefaultLayoutParams);
            c(this.a, false);
        }
    }

    public final void l() {
        if (this.e == null) {
            this.e = new n(getContext(), null, c.a.Q);
            g generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = (this.o & 112) | 8388611;
            this.e.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof a.a ? new g((a.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
        R();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0297 A[LOOP:0: B:46:0x0295->B:47:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02b9 A[LOOP:1: B:50:0x02b7->B:51:0x02b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02f2 A[LOOP:2: B:59:0x02f0->B:60:0x02f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 775
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        boolean b2 = m0.b(this);
        int i11 = !b2 ? 1 : 0;
        if (P(this.e)) {
            F(this.e, i2, 0, i3, 0, this.p);
            i4 = this.e.getMeasuredWidth() + s(this.e);
            i5 = Math.max(0, this.e.getMeasuredHeight() + t(this.e));
            i6 = View.combineMeasuredStates(0, this.e.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (P(this.i)) {
            F(this.i, i2, 0, i3, 0, this.p);
            i4 = this.i.getMeasuredWidth() + s(this.i);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + t(this.i));
            i6 = View.combineMeasuredStates(i6, this.i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i4);
        iArr[b2 ? 1 : 0] = Math.max(0, currentContentInsetStart - i4);
        if (P(this.a)) {
            F(this.a, i2, max, i3, 0, this.p);
            i7 = this.a.getMeasuredWidth() + s(this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + t(this.a));
            i6 = View.combineMeasuredStates(i6, this.a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[i11] = Math.max(0, currentContentInsetEnd - i7);
        if (P(this.j)) {
            max2 += E(this.j, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.j.getMeasuredHeight() + t(this.j));
            i6 = View.combineMeasuredStates(i6, this.j.getMeasuredState());
        }
        if (P(this.f)) {
            max2 += E(this.f, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f.getMeasuredHeight() + t(this.f));
            i6 = View.combineMeasuredStates(i6, this.f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getLayoutParams().b == 0 && P(childAt)) {
                max2 += E(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + t(childAt));
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
            }
        }
        int i13 = this.s + this.t;
        int i14 = this.q + this.r;
        if (P(this.c)) {
            E(this.c, i2, max2 + i14, i3, i13, iArr);
            int measuredWidth = this.c.getMeasuredWidth() + s(this.c);
            i10 = this.c.getMeasuredHeight() + t(this.c);
            i8 = View.combineMeasuredStates(i6, this.c.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i8 = i6;
            i9 = 0;
            i10 = 0;
        }
        if (P(this.d)) {
            i9 = Math.max(i9, E(this.d, i2, max2 + i14, i3, i10 + i13, iArr));
            i10 += this.d.getMeasuredHeight() + t(this.d);
            i8 = View.combineMeasuredStates(i8, this.d.getMeasuredState());
        }
        int max3 = Math.max(i5, i10);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i9 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & i8), O() ? 0 : View.resolveSizeAndState(Math.max(max3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i8 << 16));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        ActionMenuView actionMenuView = this.a;
        androidx.appcompat.view.menu.e N = actionMenuView != null ? actionMenuView.N() : null;
        int i2 = iVar.d;
        if (i2 != 0 && this.N != null && N != null && (findItem = N.findItem(i2)) != null) {
            findItem.expandActionView();
        }
        if (iVar.e) {
            H();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        this.u.f(i2 == 1);
    }

    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.N;
        if (fVar != null && (gVar = fVar.c) != null) {
            iVar.d = gVar.getItemId();
        }
        iVar.e = B();
        return iVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public final int p(int i2) {
        int E = L.E(this);
        int b2 = p.b(i2, E) & 7;
        return (b2 == 1 || b2 == 3 || b2 == 5) ? b2 : E == 1 ? 5 : 3;
    }

    public final int q(View view, int i2) {
        g layoutParams = view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int r = r(layoutParams.a);
        if (r == 48) {
            return getPaddingTop() - i3;
        }
        if (r == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    public final int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.x & 112;
    }

    public final int s(View view) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        return s.b(layoutParams) + s.a(layoutParams);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.T != z) {
            this.T = z;
            R();
        }
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(e.a.b(getContext(), i2));
    }

    public void setCollapsible(boolean z) {
        this.Q = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.w) {
            this.w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(e.a.b(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(e.a.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.J = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.l != i2) {
            this.l = i2;
            if (i2 == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public final int t(View view) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        return layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final int u(List list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = (View) list.get(i4);
            g layoutParams = view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i2;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i2 = max3;
        }
        return i5;
    }

    public boolean v() {
        f fVar = this.N;
        return (fVar == null || fVar.c == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public void y() {
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        G();
    }

    public final boolean z(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new v(new f0(this));
        this.I = new ArrayList();
        this.K = new a();
        this.U = new b();
        d0 v = d0.v(getContext(), attributeSet, j.n3, i2, 0);
        L.q0(this, context, j.n3, attributeSet, v.r(), i2, 0);
        this.m = v.n(j.P3, 0);
        this.n = v.n(j.G3, 0);
        this.x = v.l(j.o3, this.x);
        this.o = v.l(j.p3, 48);
        int e2 = v.e(j.J3, 0);
        e2 = v.s(j.O3) ? v.e(j.O3, e2) : e2;
        this.t = e2;
        this.s = e2;
        this.r = e2;
        this.q = e2;
        int e3 = v.e(j.M3, -1);
        if (e3 >= 0) {
            this.q = e3;
        }
        int e4 = v.e(j.L3, -1);
        if (e4 >= 0) {
            this.r = e4;
        }
        int e5 = v.e(j.N3, -1);
        if (e5 >= 0) {
            this.s = e5;
        }
        int e6 = v.e(j.K3, -1);
        if (e6 >= 0) {
            this.t = e6;
        }
        this.p = v.f(j.A3, -1);
        int e7 = v.e(j.w3, Integer.MIN_VALUE);
        int e8 = v.e(j.s3, Integer.MIN_VALUE);
        int f2 = v.f(j.u3, 0);
        int f3 = v.f(j.v3, 0);
        h();
        this.u.e(f2, f3);
        if (e7 != Integer.MIN_VALUE || e8 != Integer.MIN_VALUE) {
            this.u.g(e7, e8);
        }
        this.v = v.e(j.x3, Integer.MIN_VALUE);
        this.w = v.e(j.t3, Integer.MIN_VALUE);
        this.g = v.g(j.r3);
        this.h = v.p(j.q3);
        CharSequence p = v.p(j.I3);
        if (!TextUtils.isEmpty(p)) {
            setTitle(p);
        }
        CharSequence p2 = v.p(j.F3);
        if (!TextUtils.isEmpty(p2)) {
            setSubtitle(p2);
        }
        this.k = getContext();
        setPopupTheme(v.n(j.E3, 0));
        Drawable g2 = v.g(j.D3);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence p3 = v.p(j.C3);
        if (!TextUtils.isEmpty(p3)) {
            setNavigationContentDescription(p3);
        }
        Drawable g3 = v.g(j.y3);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence p4 = v.p(j.z3);
        if (!TextUtils.isEmpty(p4)) {
            setLogoDescription(p4);
        }
        if (v.s(j.Q3)) {
            setTitleTextColor(v.c(j.Q3));
        }
        if (v.s(j.H3)) {
            setSubtitleTextColor(v.c(j.H3));
        }
        if (v.s(j.B3)) {
            x(v.n(j.B3, 0));
        }
        v.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.i.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.g);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f)) {
                c(this.f, true);
            }
        } else {
            ImageView imageView = this.f;
            if (imageView != null && z(imageView)) {
                removeView(this.f);
                this.F.remove(this.f);
            }
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            g0.a(this.e, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.e)) {
                c(this.e, true);
            }
        } else {
            ImageButton imageButton = this.e;
            if (imageButton != null && z(imageButton)) {
                removeView(this.e);
                this.F.remove(this.e);
            }
        }
        ImageButton imageButton2 = this.e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.d;
            if (textView != null && z(textView)) {
                removeView(this.d);
                this.F.remove(this.d);
            }
        } else {
            if (this.d == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.d = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.d.setTextColor(colorStateList);
                }
            }
            if (!z(this.d)) {
                c(this.d, true);
            }
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.c;
            if (textView != null && z(textView)) {
                removeView(this.c);
                this.F.remove(this.c);
            }
        } else {
            if (this.c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!z(this.c)) {
                c(this.c, true);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
