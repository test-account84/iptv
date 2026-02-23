package androidx.viewpager.widget;

import P.E;
import P.L;
import P.X;
import Q.C;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ViewPager extends ViewGroup {
    public static final int[] k0 = {16842931};
    public static final Comparator l0 = new a();
    public static final Interpolator m0 = new b();
    public static final m n0 = new m();
    public boolean A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;
    public VelocityTracker J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public List V;
    public j W;
    public int a;
    public final ArrayList c;
    public final f d;
    public final Rect e;
    public j e0;
    public N0.a f;
    public List f0;
    public int g;
    public int g0;
    public int h;
    public ArrayList h0;
    public Parcelable i;
    public final Runnable i0;
    public ClassLoader j;
    public int j0;
    public Scroller k;
    public boolean l;
    public k m;
    public int n;
    public Drawable o;
    public int p;
    public int q;
    public float r;
    public float s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

    public static class a implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.b - fVar2.b;
        }
    }

    public static class b implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.D();
        }
    }

    public class d implements E {
        public final Rect a = new Rect();

        public d() {
        }

        public X a(View view, X x) {
            X e0 = L.e0(view, x);
            if (e0.n()) {
                return e0;
            }
            Rect rect = this.a;
            rect.left = e0.i();
            rect.top = e0.k();
            rect.right = e0.j();
            rect.bottom = e0.h();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                X i2 = L.i(ViewPager.this.getChildAt(i), e0);
                rect.left = Math.min(i2.i(), rect.left);
                rect.top = Math.min(i2.k(), rect.top);
                rect.right = Math.min(i2.j(), rect.right);
                rect.bottom = Math.min(i2.h(), rect.bottom);
            }
            return e0.o(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    public static class f {
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;
    }

    public static class g extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        public float c;
        public boolean d;
        public int e;
        public int f;

        public g() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.k0);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public class h extends P.a {
        public h() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            N0.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.f) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.c());
            accessibilityEvent.setFromIndex(ViewPager.this.g);
            accessibilityEvent.setToIndex(ViewPager.this.g);
        }

        public void g(View view, C c) {
            super.g(view, c);
            c.X(ViewPager.class.getName());
            c.q0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                c.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                c.a(8192);
            }
        }

        public boolean j(View view, int i, Bundle bundle) {
            ViewPager viewPager;
            int i2;
            if (super.j(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i2 = viewPager.g - 1;
            } else {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i2 = viewPager.g + 1;
            }
            viewPager.setCurrentItem(i2);
            return true;
        }

        public final boolean n() {
            N0.a aVar = ViewPager.this.f;
            return aVar != null && aVar.c() > 1;
        }
    }

    public interface i {
        void a(ViewPager viewPager, N0.a aVar, N0.a aVar2);
    }

    public interface j {
        void a(int i, float f, int i2);

        void b(int i);

        void c(int i);
    }

    public class k extends DataSetObserver {
        public k() {
        }

        public void onChanged() {
            ViewPager.this.h();
        }

        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    public static class l extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public int d;
        public Parcelable e;
        public ClassLoader f;

        public static class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new l(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i) {
                return new l[i];
            }
        }

        public l(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.d = parcel.readInt();
            this.e = parcel.readParcelable(classLoader);
            this.f = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.d + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d);
            parcel.writeParcelable(this.e, i);
        }

        public l(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class m implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.a;
            return z != gVar2.a ? z ? 1 : -1 : gVar.e - gVar2.e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        this.d = new f();
        this.e = new Rect();
        this.h = -1;
        this.i = null;
        this.j = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.y = 1;
        this.I = -1;
        this.R = true;
        this.S = false;
        this.i0 = new c();
        this.j0 = 0;
        u();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.w != z) {
            this.w = z;
        }
    }

    public static boolean v(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    public boolean A() {
        N0.a aVar = this.f;
        if (aVar == null || this.g >= aVar.c() - 1) {
            return false;
        }
        M(this.g + 1, true);
        return true;
    }

    public final boolean B(int i2) {
        if (this.c.size() == 0) {
            if (this.R) {
                return false;
            }
            this.T = false;
            x(0, 0.0f, 0);
            if (this.T) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f s = s();
        int clientWidth = getClientWidth();
        int i3 = this.n;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = s.b;
        float f3 = ((i2 / f2) - s.e) / (s.d + (i3 / f2));
        this.T = false;
        x(i5, f3, (int) (i4 * f3));
        if (this.T) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean C(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.E - f2;
        this.E = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.r * clientWidth;
        float f5 = this.s * clientWidth;
        boolean z3 = false;
        f fVar = (f) this.c.get(0);
        ArrayList arrayList = this.c;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.b != 0) {
            f4 = fVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.b != this.f.c() - 1) {
            f5 = fVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.P.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.Q.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.E += scrollX - i2;
        scrollTo(i2, getScrollY());
        B(i2);
        return z3;
    }

    public void D() {
        E(this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2 A[PHI: r7 r10 r15
      0x00c2: PHI (r7v9 int) = (r7v5 int), (r7v4 int), (r7v10 int) binds: [B:113:0x00e7, B:111:0x00d9, B:49:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c2: PHI (r10v12 int) = (r10v1 int), (r10v8 int), (r10v13 int) binds: [B:113:0x00e7, B:111:0x00d9, B:49:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c2: PHI (r15v10 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:113:0x00e7, B:111:0x00d9, B:49:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cb A[PHI: r7 r10 r15
      0x00cb: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v10 int) binds: [B:113:0x00e7, B:111:0x00d9, B:49:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v13 int) binds: [B:113:0x00e7, B:111:0x00d9, B:49:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:113:0x00e7, B:111:0x00d9, B:49:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(int r18) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.E(int):void");
    }

    public final void F(int i2, int i3, int i4, int i5) {
        int min;
        if (i3 <= 0 || this.c.isEmpty()) {
            f t = t(this.g);
            min = (int) ((t != null ? Math.min(t.e, this.s) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (min == getScrollX()) {
                return;
            } else {
                g(false);
            }
        } else if (!this.k.isFinished()) {
            this.k.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4));
        }
        scrollTo(min, getScrollY());
    }

    public final void G() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public void H(i iVar) {
        List list = this.f0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void I(j jVar) {
        List list = this.V;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public final void J(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final boolean K() {
        this.I = -1;
        n();
        this.P.onRelease();
        this.Q.onRelease();
        return this.P.isFinished() || this.Q.isFinished();
    }

    public final void L(int i2, boolean z, int i3, boolean z2) {
        f t = t(i2);
        int clientWidth = t != null ? (int) (getClientWidth() * Math.max(this.r, Math.min(t.e, this.s))) : 0;
        if (z) {
            P(clientWidth, 0, i3);
            if (z2) {
                k(i2);
                return;
            }
            return;
        }
        if (z2) {
            k(i2);
        }
        g(false);
        scrollTo(clientWidth, 0);
        B(clientWidth);
    }

    public void M(int i2, boolean z) {
        this.x = false;
        N(i2, z, false);
    }

    public void N(int i2, boolean z, boolean z2) {
        O(i2, z, z2, 0);
    }

    public void O(int i2, boolean z, boolean z2, int i3) {
        N0.a aVar = this.f;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.g == i2 && this.c.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f.c()) {
            i2 = this.f.c() - 1;
        }
        int i4 = this.y;
        int i5 = this.g;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.c.size(); i6++) {
                ((f) this.c.get(i6)).c = true;
            }
        }
        boolean z3 = this.g != i2;
        if (!this.R) {
            E(i2);
            L(i2, z, i3, z3);
        } else {
            this.g = i2;
            if (z3) {
                k(i2);
            }
            requestLayout();
        }
    }

    public void P(int i2, int i3, int i4) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.k;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.l ? this.k.getCurrX() : this.k.getStartX();
            this.k.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            g(false);
            D();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float m2 = f3 + (m(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(m2 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.f.f(this.g)) + this.n)) + 1.0f) * 100.0f), 600);
        this.l = false;
        this.k.startScroll(i5, scrollY, i6, i7, min);
        L.j0(this);
    }

    public final void Q() {
        if (this.g0 != 0) {
            ArrayList arrayList = this.h0;
            if (arrayList == null) {
                this.h0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.h0.add(getChildAt(i2));
            }
            Collections.sort(this.h0, n0);
        }
    }

    public f a(int i2, int i3) {
        f fVar = new f();
        fVar.b = i2;
        fVar.a = this.f.g(this, i2);
        fVar.d = this.f.f(i2);
        if (i3 < 0 || i3 >= this.c.size()) {
            this.c.add(fVar);
        } else {
            this.c.add(i3, fVar);
        }
        return fVar;
    }

    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        f r;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        f r;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean v = gVar.a | v(view);
        gVar.a = v;
        if (!this.v) {
            super.addView(view, i2, layoutParams);
        } else {
            if (v) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.f0 == null) {
            this.f0 = new ArrayList();
        }
        this.f0.add(iVar);
    }

    public void c(j jVar) {
        if (this.V == null) {
            this.V = new ArrayList();
        }
        this.V.add(jVar);
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.r)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.s));
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.l = true;
        if (this.k.isFinished() || !this.k.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.k.getCurrX();
        int currY = this.k.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!B(currX)) {
                this.k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        L.j0(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto La6
            if (r1 == r0) goto La6
            if (r5 != r3) goto L8f
            android.graphics.Rect r2 = r4.e
            android.graphics.Rect r2 = r4.p(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.e
            android.graphics.Rect r3 = r4.p(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8a
            if (r2 < r3) goto L8a
            goto Lb9
        L8a:
            boolean r0 = r1.requestFocus()
            goto Lbd
        L8f:
            if (r5 != r2) goto Lb2
            android.graphics.Rect r2 = r4.e
            android.graphics.Rect r2 = r4.p(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.e
            android.graphics.Rect r3 = r4.p(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8a
            if (r2 > r3) goto L8a
            goto Lb4
        La6:
            if (r5 == r3) goto Lb9
            r0 = 1
            if (r5 != r0) goto Lac
            goto Lb9
        Lac:
            if (r5 == r2) goto Lb4
            r0 = 2
            if (r5 != r0) goto Lb2
            goto Lb4
        Lb2:
            r0 = 0
            goto Lbd
        Lb4:
            boolean r0 = r4.A()
            goto Lbd
        Lb9:
            boolean r0 = r4.z()
        Lbd:
            if (r0 == 0) goto Lc6
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Lc6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || o(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f r;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        N0.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f) != null && aVar.c() > 1)) {
            if (!this.P.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.r * width);
                this.P.setSize(height, width);
                z = this.P.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.Q.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.s + 1.0f)) * width2);
                this.Q.setSize(height2, width2);
                z |= this.Q.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.P.finish();
            this.Q.finish();
        }
        if (z) {
            L.j0(this);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int c2 = this.f.c();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.n / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.b;
            int i6 = fVar.b;
            if (i5 < i6) {
                float f3 = fVar2.e + fVar2.d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= fVar.b && i8 < this.c.size()) {
                    while (true) {
                        fVar4 = (f) this.c.get(i8);
                        if (i7 <= fVar4.b || i8 >= this.c.size() - 1) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                    while (i7 < fVar4.b) {
                        f3 += this.f.f(i7) + f2;
                        i7++;
                    }
                    fVar4.e = f3;
                    f3 += fVar4.d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.c.size() - 1;
                float f4 = fVar2.e;
                while (true) {
                    i5--;
                    if (i5 < fVar.b || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = (f) this.c.get(size);
                        if (i5 >= fVar3.b || size <= 0) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    while (i5 > fVar3.b) {
                        f4 -= this.f.f(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.d + f2;
                    fVar3.e = f4;
                }
            }
        }
        int size2 = this.c.size();
        float f5 = fVar.e;
        int i9 = fVar.b;
        int i10 = i9 - 1;
        this.r = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = c2 - 1;
        this.s = i9 == i11 ? (fVar.d + f5) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            f fVar5 = (f) this.c.get(i12);
            while (true) {
                i4 = fVar5.b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.f.f(i10) + f2;
                i10--;
            }
            f5 -= fVar5.d + f2;
            fVar5.e = f5;
            if (i4 == 0) {
                this.r = f5;
            }
            i12--;
            i10--;
        }
        float f6 = fVar.e + fVar.d + f2;
        int i13 = fVar.b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            f fVar6 = (f) this.c.get(i14);
            while (true) {
                i3 = fVar6.b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.f.f(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.s = (fVar6.d + f6) - 1.0f;
            }
            fVar6.e = f6;
            f6 += fVar6.d + f2;
            i14++;
            i13++;
        }
        this.S = false;
    }

    public boolean f(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && f(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    public final void g(boolean z) {
        boolean z2 = this.j0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.k.isFinished()) {
                this.k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.k.getCurrX();
                int currY = this.k.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        B(currX);
                    }
                }
            }
        }
        this.x = false;
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            f fVar = (f) this.c.get(i2);
            if (fVar.c) {
                fVar.c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                L.k0(this, this.i0);
            } else {
                this.i0.run();
            }
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public N0.a getAdapter() {
        return this.f;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        if (this.g0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) ((View) this.h0.get(i3)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.g;
    }

    public int getOffscreenPageLimit() {
        return this.y;
    }

    public int getPageMargin() {
        return this.n;
    }

    public void h() {
        int c2 = this.f.c();
        this.a = c2;
        boolean z = this.c.size() < (this.y * 2) + 1 && this.c.size() < c2;
        int i2 = this.g;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.c.size()) {
            f fVar = (f) this.c.get(i3);
            int d2 = this.f.d(fVar.a);
            if (d2 != -1) {
                if (d2 == -2) {
                    this.c.remove(i3);
                    i3--;
                    if (!z2) {
                        this.f.n(this);
                        z2 = true;
                    }
                    this.f.a(this, fVar.b, fVar.a);
                    int i4 = this.g;
                    if (i4 == fVar.b) {
                        i2 = Math.max(0, Math.min(i4, c2 - 1));
                    }
                } else {
                    int i5 = fVar.b;
                    if (i5 != d2) {
                        if (i5 == this.g) {
                            i2 = d2;
                        }
                        fVar.b = d2;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.f.b(this);
        }
        Collections.sort(this.c, l0);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                g gVar = (g) getChildAt(i6).getLayoutParams();
                if (!gVar.a) {
                    gVar.c = 0.0f;
                }
            }
            N(i2, false, true);
            requestLayout();
        }
    }

    public final int i(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.M || Math.abs(i3) <= this.K) {
            i2 += (int) (f2 + (i2 >= this.g ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.c.size() <= 0) {
            return i2;
        }
        return Math.max(((f) this.c.get(0)).b, Math.min(i2, ((f) this.c.get(r4.size() - 1)).b));
    }

    public final void j(int i2, float f2, int i3) {
        j jVar = this.W;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = (j) this.V.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    public final void k(int i2) {
        j jVar = this.W;
        if (jVar != null) {
            jVar.c(i2);
        }
        List list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.V.get(i3);
                if (jVar2 != null) {
                    jVar2.c(i2);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.c(i2);
        }
    }

    public final void l(int i2) {
        j jVar = this.W;
        if (jVar != null) {
            jVar.b(i2);
        }
        List list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.V.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    public float m(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public final void n() {
        this.z = false;
        this.A = false;
        VelocityTracker velocityTracker = this.J;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.J = null;
        }
    }

    public boolean o(KeyEvent keyEvent) {
        int i2;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return A();
                    }
                    i2 = 66;
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return z();
                }
                i2 = 17;
            }
            return d(i2);
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.i0);
        Scroller scroller = this.k;
        if (scroller != null && !scroller.isFinished()) {
            this.k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.n <= 0 || this.o == null || this.c.size() <= 0 || this.f == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.n / width;
        int i3 = 0;
        f fVar = (f) this.c.get(0);
        float f5 = fVar.e;
        int size = this.c.size();
        int i4 = fVar.b;
        int i5 = ((f) this.c.get(size - 1)).b;
        while (i4 < i5) {
            while (true) {
                i2 = fVar.b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                fVar = (f) this.c.get(i3);
            }
            if (i4 == i2) {
                float f6 = fVar.e;
                float f7 = fVar.d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float f8 = this.f.f(i4);
                f2 = (f5 + f8) * width;
                f5 += f8 + f4;
            }
            if (this.n + f2 > scrollX) {
                f3 = f4;
                this.o.setBounds(Math.round(f2), this.p, Math.round(this.n + f2), this.q);
                this.o.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i4++;
            f4 = f3;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            K();
            return false;
        }
        if (action != 0) {
            if (this.z) {
                return true;
            }
            if (this.A) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.G = x;
            this.E = x;
            float y = motionEvent.getY();
            this.H = y;
            this.F = y;
            this.I = motionEvent.getPointerId(0);
            this.A = false;
            this.l = true;
            this.k.computeScrollOffset();
            if (this.j0 != 2 || Math.abs(this.k.getFinalX() - this.k.getCurrX()) <= this.N) {
                g(false);
                this.z = false;
            } else {
                this.k.abortAnimation();
                this.x = false;
                D();
                this.z = true;
                J(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.I;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(findPointerIndex);
                float f2 = x2 - this.E;
                float abs = Math.abs(f2);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.H);
                if (f2 != 0.0f && !w(this.E, f2) && f(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.E = x2;
                    this.F = y2;
                    this.A = true;
                    return false;
                }
                int i3 = this.D;
                if (abs > i3 && abs * 0.5f > abs2) {
                    this.z = true;
                    J(true);
                    setScrollState(1);
                    float f3 = this.G;
                    float f4 = this.D;
                    this.E = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.F = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i3) {
                    this.A = true;
                }
                if (this.z && C(x2)) {
                    L.j0(this);
                }
            }
        } else if (action == 6) {
            y(motionEvent);
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        return this.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f r;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.a());
        N0.a aVar = this.f;
        if (aVar != null) {
            aVar.j(lVar.e, lVar.f);
            N(lVar.d, false, true);
        } else {
            this.h = lVar.d;
            this.i = lVar.e;
            this.j = lVar.f;
        }
    }

    public Parcelable onSaveInstanceState() {
        l lVar = new l(super.onSaveInstanceState());
        lVar.d = this.g;
        N0.a aVar = this.f;
        if (aVar != null) {
            lVar.e = aVar.k();
        }
        return lVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.n;
            F(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final Rect p(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        int bottom = view.getBottom();
        while (true) {
            rect.bottom = bottom;
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                break;
            }
            view = (ViewGroup) parent;
            rect.left += view.getLeft();
            rect.right += view.getRight();
            rect.top += view.getTop();
            bottom = rect.bottom + view.getBottom();
        }
        return rect;
    }

    public f q(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return r(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public f r(View view) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            f fVar = (f) this.c.get(i2);
            if (this.f.h(view, fVar.a)) {
                return fVar;
            }
        }
        return null;
    }

    public void removeView(View view) {
        if (this.v) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final f s() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.n / clientWidth : 0.0f;
        f fVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        while (i4 < this.c.size()) {
            f fVar2 = (f) this.c.get(i4);
            if (!z && fVar2.b != (i2 = i3 + 1)) {
                fVar2 = this.d;
                fVar2.e = f2 + f4 + f3;
                fVar2.b = i2;
                fVar2.d = this.f.f(i2);
                i4--;
            }
            f fVar3 = fVar2;
            f2 = fVar3.e;
            float f5 = fVar3.d + f2 + f3;
            if (!z && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i4 == this.c.size() - 1) {
                return fVar3;
            }
            int i5 = fVar3.b;
            float f6 = fVar3.d;
            i4++;
            z = false;
            i3 = i5;
            f4 = f6;
            fVar = fVar3;
        }
        return fVar;
    }

    public void setAdapter(N0.a aVar) {
        N0.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.m(null);
            this.f.n(this);
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                f fVar = (f) this.c.get(i2);
                this.f.a(this, fVar.b, fVar.a);
            }
            this.f.b(this);
            this.c.clear();
            G();
            this.g = 0;
            scrollTo(0, 0);
        }
        N0.a aVar3 = this.f;
        this.f = aVar;
        this.a = 0;
        if (aVar != null) {
            if (this.m == null) {
                this.m = new k();
            }
            this.f.m(this.m);
            this.x = false;
            boolean z = this.R;
            this.R = true;
            this.a = this.f.c();
            if (this.h >= 0) {
                this.f.j(this.i, this.j);
                N(this.h, false, true);
                this.h = -1;
                this.i = null;
                this.j = null;
            } else if (z) {
                requestLayout();
            } else {
                D();
            }
        }
        List list = this.f0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((i) this.f0.get(i3)).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.x = false;
        N(i2, !this.R, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.y) {
            this.y = i2;
            D();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.W = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.n;
        this.n = i2;
        int width = getWidth();
        F(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(E.b.getDrawable(getContext(), i2));
    }

    public void setScrollState(int i2) {
        if (this.j0 == i2) {
            return;
        }
        this.j0 = i2;
        l(i2);
    }

    public f t(int i2) {
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            f fVar = (f) this.c.get(i3);
            if (fVar.b == i2) {
                return fVar;
            }
        }
        return null;
    }

    public void u() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.k = new Scroller(context, m0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.D = viewConfiguration.getScaledPagingTouchSlop();
        this.K = (int) (400.0f * f2);
        this.L = viewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(context);
        this.Q = new EdgeEffect(context);
        this.M = (int) (25.0f * f2);
        this.N = (int) (2.0f * f2);
        this.B = (int) (f2 * 16.0f);
        L.s0(this, new h());
        if (L.C(this) == 0) {
            L.C0(this, 1);
        }
        L.E0(this, new d());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    public final boolean w(float f2, float f3) {
        return (f2 < ((float) this.C) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.C)) && f3 < 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.U
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r8 = (androidx.viewpager.widget.ViewPager.g) r8
            boolean r9 = r8.a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.j(r12, r13, r14)
            r11.T = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.x(int, float, int):void");
    }

    public final void y(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.E = motionEvent.getX(i2);
            this.I = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean z() {
        int i2 = this.g;
        if (i2 <= 0) {
            return false;
        }
        M(i2 - 1, true);
        return true;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }
}
