package androidx.coordinatorlayout.widget;

import P.B;
import P.C;
import P.D;
import P.E;
import P.L;
import P.X;
import P.p;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CoordinatorLayout extends ViewGroup implements B, C {
    public static final String v;
    public static final Class[] w;
    public static final ThreadLocal x;
    public static final Comparator y;
    public static final O.e z;
    public final List a;
    public final B.b c;
    public final List d;
    public final List e;
    public Paint f;
    public final int[] g;
    public final int[] h;
    public boolean i;
    public boolean j;
    public int[] k;
    public View l;
    public View m;
    public g n;
    public boolean o;
    public X p;
    public boolean q;
    public Drawable r;
    public ViewGroup.OnHierarchyChangeListener s;
    public E t;
    public final D u;

    public class a implements E {
        public a() {
        }

        public X a(View view, X x) {
            return CoordinatorLayout.this.X(x);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c {
        public c() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                return z(coordinatorLayout, view, view2, view3, i);
            }
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            if (i == 0) {
                B(coordinatorLayout, view, view2);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2, boolean z) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                p(coordinatorLayout, view, view2, i, i2, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                r(coordinatorLayout, view, view2, i, i2, i3, i4);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            s(coordinatorLayout, view, view2, i, i2, i3, i4, i5);
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                u(coordinatorLayout, view, view2, view3, i);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public X f(CoordinatorLayout coordinatorLayout, View view, X x) {
            return x;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.I(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {
        public c a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;
        public Object r;

        public f(int i, int i2) {
            super(i, i2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public boolean a() {
            return this.k == null && this.f != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.l || s(view2, L.E(coordinatorLayout)) || ((cVar = this.a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        public boolean c() {
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.k;
        }

        public int e() {
            return this.f;
        }

        public c f() {
            return this.a;
        }

        public boolean g() {
            return this.p;
        }

        public Rect h() {
            return this.q;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.a;
            boolean a = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.m = a;
            return a;
        }

        public boolean j(int i) {
            if (i == 0) {
                return this.n;
            }
            if (i != 1) {
                return false;
            }
            return this.o;
        }

        public void k() {
            this.p = false;
        }

        public void l(int i) {
            r(i, false);
        }

        public void m() {
            this.m = false;
        }

        public final void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f);
            this.k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.l = findViewById;
                    return;
                }
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            }
            this.l = null;
            this.k = null;
        }

        public void o(c cVar) {
            c cVar2 = this.a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.a = cVar;
                this.r = null;
                this.b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        public void p(boolean z) {
            this.p = z;
        }

        public void q(Rect rect) {
            this.q.set(rect);
        }

        public void r(int i, boolean z) {
            if (i == 0) {
                this.n = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.o = z;
            }
        }

        public final boolean s(View view, int i) {
            int b = p.b(view.getLayoutParams().g, i);
            return b != 0 && (p.b(this.h, i) & b) == b;
        }

        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.l = view2;
            return true;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A.c.e);
            this.c = obtainStyledAttributes.getInteger(A.c.f, 0);
            this.f = obtainStyledAttributes.getResourceId(A.c.g, -1);
            this.d = obtainStyledAttributes.getInteger(A.c.h, 0);
            this.e = obtainStyledAttributes.getInteger(A.c.l, -1);
            this.g = obtainStyledAttributes.getInt(A.c.k, 0);
            this.h = obtainStyledAttributes.getInt(A.c.j, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(A.c.i);
            this.b = hasValue;
            if (hasValue) {
                this.a = CoordinatorLayout.L(context, attributeSet, obtainStyledAttributes.getString(A.c.i));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(f fVar) {
            super(fVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.I(0);
            return true;
        }
    }

    public static class h extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public SparseArray d;

        public static class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.d = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.d.append(iArr[i], readParcelableArray[i]);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray sparseArray = this.d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.d.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.d.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class i implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float P = L.P(view);
            float P2 = L.P(view2);
            if (P > P2) {
                return -1;
            }
            return P < P2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        v = r0 != null ? r0.getName() : null;
        y = new i();
        w = new Class[]{Context.class, AttributeSet.class};
        x = new ThreadLocal();
        z = new O.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A.a.a);
    }

    public static c L(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = x;
            HashMap hashMap = (Map) threadLocal.get();
            if (hashMap == null) {
                hashMap = new HashMap();
                threadLocal.set(hashMap);
            }
            Constructor constructor = (Constructor) hashMap.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(w);
                constructor.setAccessible(true);
                hashMap.put(str, constructor);
            }
            return (c) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    public static void P(Rect rect) {
        rect.setEmpty();
        z.a(rect);
    }

    public static int S(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    public static int T(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    public static int U(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    public static Rect a() {
        Rect rect = (Rect) z.b();
        return rect == null ? new Rect() : rect;
    }

    private static int c(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public final void A(List list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator comparator = y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean B(View view) {
        return this.c.j(view);
    }

    public boolean C(View view, int i2, int i3) {
        Rect a2 = a();
        u(view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            P(a2);
        }
    }

    public final void D(View view, int i2) {
        f layoutParams = view.getLayoutParams();
        Rect a2 = a();
        a2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (this.p != null && L.B(this) && !L.B(view)) {
            a2.left += this.p.i();
            a2.top += this.p.k();
            a2.right -= this.p.j();
            a2.bottom -= this.p.h();
        }
        Rect a3 = a();
        p.a(T(layoutParams.c), view.getMeasuredWidth(), view.getMeasuredHeight(), a2, a3, i2);
        view.layout(a3.left, a3.top, a3.right, a3.bottom);
        P(a2);
        P(a3);
    }

    public final void E(View view, View view2, int i2) {
        Rect a2 = a();
        Rect a3 = a();
        try {
            u(view2, a2);
            v(view, i2, a2, a3);
            view.layout(a3.left, a3.top, a3.right, a3.bottom);
        } finally {
            P(a2);
            P(a3);
        }
    }

    public final void F(View view, int i2, int i3) {
        f layoutParams = view.getLayoutParams();
        int b2 = p.b(U(layoutParams.c), i3);
        int i4 = b2 & 7;
        int i5 = b2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int x2 = x(i2) - measuredWidth;
        if (i4 == 1) {
            x2 += measuredWidth / 2;
        } else if (i4 == 5) {
            x2 += measuredWidth;
        }
        int i6 = i5 != 16 ? i5 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(x2, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    public final void G(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (L.W(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f layoutParams = view.getLayoutParams();
            c f2 = layoutParams.f();
            Rect a2 = a();
            Rect a3 = a();
            a3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f2 == null || !f2.b(this, view, a2)) {
                a2.set(a3);
            } else if (!a3.contains(a2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a2.toShortString() + " | Bounds:" + a3.toShortString());
            }
            P(a3);
            if (a2.isEmpty()) {
                P(a2);
                return;
            }
            int b2 = p.b(layoutParams.h, i2);
            boolean z4 = true;
            if ((b2 & 48) != 48 || (i7 = (a2.top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - layoutParams.j) >= (i8 = rect.top)) {
                z2 = false;
            } else {
                W(view, i8 - i7);
                z2 = true;
            }
            if ((b2 & 80) == 80 && (height = ((getHeight() - a2.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + layoutParams.j) < (i6 = rect.bottom)) {
                W(view, height - i6);
                z2 = true;
            }
            if (!z2) {
                W(view, 0);
            }
            if ((b2 & 3) != 3 || (i4 = (a2.left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - layoutParams.i) >= (i5 = rect.left)) {
                z3 = false;
            } else {
                V(view, i5 - i4);
                z3 = true;
            }
            if ((b2 & 5) != 5 || (width = ((getWidth() - a2.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + layoutParams.i) >= (i3 = rect.right)) {
                z4 = z3;
            } else {
                V(view, width - i3);
            }
            if (!z4) {
                V(view, 0);
            }
            P(a2);
        }
    }

    public void H(View view, int i2) {
        c f2;
        f fVar = (f) view.getLayoutParams();
        if (fVar.k != null) {
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            u(fVar.k, a2);
            r(view, false, a3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            w(view, i2, a2, a4, fVar, measuredWidth, measuredHeight);
            boolean z2 = (a4.left == a3.left && a4.top == a3.top) ? false : true;
            d(fVar, a4, measuredWidth, measuredHeight);
            int i3 = a4.left - a3.left;
            int i4 = a4.top - a3.top;
            if (i3 != 0) {
                L.c0(view, i3);
            }
            if (i4 != 0) {
                L.d0(view, i4);
            }
            if (z2 && (f2 = fVar.f()) != null) {
                f2.h(this, view, fVar.k);
            }
            P(a2);
            P(a3);
            P(a4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void I(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.I(int):void");
    }

    public void J(View view, int i2) {
        f layoutParams = view.getLayoutParams();
        if (layoutParams.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = layoutParams.k;
        if (view2 != null) {
            E(view, view2, i2);
            return;
        }
        int i3 = layoutParams.e;
        if (i3 >= 0) {
            F(view, i3, i2);
        } else {
            D(view, i2);
        }
    }

    public void K(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public final boolean M(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.d;
        A(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) list.get(i3);
            f layoutParams = view.getLayoutParams();
            c f2 = layoutParams.f();
            if (!(z2 || z3) || actionMasked == 0) {
                if (!z2 && f2 != null) {
                    if (i2 == 0) {
                        z2 = f2.k(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z2 = f2.D(this, view, motionEvent);
                    }
                    if (z2) {
                        this.l = view;
                    }
                }
                boolean c2 = layoutParams.c();
                boolean i4 = layoutParams.i(this, view);
                z3 = i4 && !c2;
                if (i4 && !z3) {
                    break;
                }
            } else if (f2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    f2.k(this, view, motionEvent2);
                } else if (i2 == 1) {
                    f2.D(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z2;
    }

    public final void N() {
        this.a.clear();
        this.c.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f z2 = z(childAt);
            z2.d(this, childAt);
            this.c.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (z2.b(this, childAt, childAt2)) {
                        if (!this.c.d(childAt2)) {
                            this.c.b(childAt2);
                        }
                        this.c.a(childAt2, childAt);
                    }
                }
            }
        }
        this.a.addAll(this.c.i());
        Collections.reverse(this.a);
    }

    public void O(View view, Rect rect) {
        view.getLayoutParams().q(rect);
    }

    public void Q() {
        if (this.j && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        this.o = false;
    }

    public final void R(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c f2 = childAt.getLayoutParams().f();
            if (f2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    f2.k(this, childAt, obtain);
                } else {
                    f2.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getLayoutParams().m();
        }
        this.l = null;
        this.i = false;
    }

    public final void V(View view, int i2) {
        f layoutParams = view.getLayoutParams();
        int i3 = layoutParams.i;
        if (i3 != i2) {
            L.c0(view, i2 - i3);
            layoutParams.i = i2;
        }
    }

    public final void W(View view, int i2) {
        f layoutParams = view.getLayoutParams();
        int i3 = layoutParams.j;
        if (i3 != i2) {
            L.d0(view, i2 - i3);
            layoutParams.j = i2;
        }
    }

    public final X X(X x2) {
        if (O.c.a(this.p, x2)) {
            return x2;
        }
        this.p = x2;
        boolean z2 = false;
        boolean z3 = x2 != null && x2.k() > 0;
        this.q = z3;
        if (!z3 && getBackground() == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        X e2 = e(x2);
        requestLayout();
        return e2;
    }

    public final void Y() {
        if (!L.B(this)) {
            L.E0(this, null);
            return;
        }
        if (this.t == null) {
            this.t = new a();
        }
        L.E0(this, this.t);
        setSystemUiVisibility(1280);
    }

    public void b() {
        if (this.j) {
            if (this.n == null) {
                this.n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        this.o = true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final void d(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        f layoutParams = view.getLayoutParams();
        c cVar = layoutParams.a;
        if (cVar != null) {
            float d2 = cVar.d(this, view);
            if (d2 > 0.0f) {
                if (this.f == null) {
                    this.f = new Paint();
                }
                this.f.setColor(layoutParams.a.c(this, view));
                this.f.setAlpha(c(Math.round(d2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final X e(X x2) {
        c f2;
        if (x2.n()) {
            return x2;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (L.B(childAt) && (f2 = childAt.getLayoutParams().f()) != null) {
                x2 = f2.f(this, childAt, x2);
                if (x2.n()) {
                    break;
                }
            }
        }
        return x2;
    }

    public void f(View view) {
        List g2 = this.c.g(view);
        if (g2 == null || g2.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < g2.size(); i2++) {
            View view2 = (View) g2.get(i2);
            c f2 = view2.getLayoutParams().f();
            if (f2 != null) {
                f2.h(this, view2, view);
            }
        }
    }

    public boolean g(View view, View view2) {
        boolean z2 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect a2 = a();
        r(view, view.getParent() != this, a2);
        Rect a3 = a();
        r(view2, view2.getParent() != this, a3);
        try {
            if (a2.left <= a3.right && a2.top <= a3.bottom && a2.right >= a3.left) {
                if (a2.bottom >= a3.top) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            P(a2);
            P(a3);
        }
    }

    public final List getDependencySortedChildren() {
        N();
        return Collections.unmodifiableList(this.a);
    }

    public final X getLastWindowInsets() {
        return this.p;
    }

    public int getNestedScrollAxes() {
        return this.u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.r;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void h() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            if (B(getChildAt(i2))) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (z2 != this.o) {
            if (z2) {
                b();
            } else {
                Q();
            }
        }
    }

    public void i(View view, View view2, int i2, int i3) {
        c f2;
        this.u.c(view, view2, i2, i3);
        this.m = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f layoutParams = childAt.getLayoutParams();
            if (layoutParams.j(i3) && (f2 = layoutParams.f()) != null) {
                f2.v(this, childAt, view, view2, i2, i3);
            }
        }
    }

    public void j(View view, int i2) {
        this.u.d(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f layoutParams = childAt.getLayoutParams();
            if (layoutParams.j(i2)) {
                c f2 = layoutParams.f();
                if (f2 != null) {
                    f2.C(this, childAt, view, i2);
                }
                layoutParams.l(i2);
                layoutParams.k();
            }
        }
        this.m = null;
    }

    public void k(View view, int i2, int i3, int[] iArr, int i4) {
        c f2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                if (layoutParams.j(i4) && (f2 = layoutParams.f()) != null) {
                    int[] iArr2 = this.g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f2.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.g;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.g;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            I(1);
        }
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c f2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                if (layoutParams.j(i6) && (f2 = layoutParams.f()) != null) {
                    int[] iArr2 = this.g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f2.t(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.g;
                    i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                    i8 = i5 > 0 ? Math.max(i8, this.g[1]) : Math.min(i8, this.g[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (z2) {
            I(1);
        }
    }

    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, 0, this.h);
    }

    public boolean o(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                c f2 = layoutParams.f();
                if (f2 != null) {
                    boolean A = f2.A(this, childAt, view, view2, i2, i3);
                    z2 |= A;
                    layoutParams.r(i3, A);
                } else {
                    layoutParams.r(i3, false);
                }
            }
        }
        return z2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R(false);
        if (this.o) {
            if (this.n == null) {
                this.n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        if (this.p == null && L.B(this)) {
            L.p0(this);
        }
        this.j = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R(false);
        if (this.o && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        View view = this.m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.j = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.q || this.r == null) {
            return;
        }
        X x2 = this.p;
        int k = x2 != null ? x2.k() : 0;
        if (k > 0) {
            this.r.setBounds(0, 0, getWidth(), k);
            this.r.draw(canvas);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            R(true);
        }
        boolean M = M(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            R(true);
        }
        return M;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c f2;
        int E = L.E(this);
        int size = this.a.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) this.a.get(i6);
            if (view.getVisibility() != 8 && ((f2 = view.getLayoutParams().f()) == null || !f2.l(this, view, E))) {
                J(view, E);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c f4;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                if (layoutParams.j(0) && (f4 = layoutParams.f()) != null) {
                    z3 |= f4.n(this, childAt, view, f2, f3, z2);
                }
            }
        }
        if (z3) {
            I(1);
        }
        return z3;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        c f4;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                if (layoutParams.j(0) && (f4 = layoutParams.f()) != null) {
                    z2 |= f4.o(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        k(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        n(view, i2, i3, i4, i5, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        i(view, view2, i2, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        SparseArray sparseArray = hVar.d;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c f2 = z(childAt).f();
            if (id != -1 && f2 != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                f2.x(this, childAt, parcelable2);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable y2;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c f2 = childAt.getLayoutParams().f();
            if (id != -1 && f2 != null && (y2 = f2.y(this, childAt)) != null) {
                sparseArray.append(id, y2);
            }
        }
        hVar.d = sparseArray;
        return hVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        j(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:20:0x0024, B:4:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.M(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.l
            boolean r6 = r6.D(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.l
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.R(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public void r(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            u(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c f2 = view.getLayoutParams().f();
        if (f2 == null || !f2.w(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.i) {
            return;
        }
        R(false);
        this.i = true;
    }

    public List s(View view) {
        List h2 = this.c.h(view);
        this.e.clear();
        if (h2 != null) {
            this.e.addAll(h2);
        }
        return this.e;
    }

    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        Y();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.r = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                H.a.m(this.r, L.E(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            L.j0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? E.b.getDrawable(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.r;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.r.setVisible(z2, false);
    }

    public List t(View view) {
        List g2 = this.c.g(view);
        this.e.clear();
        if (g2 != null) {
            this.e.addAll(g2);
        }
        return this.e;
    }

    public void u(View view, Rect rect) {
        B.c.a(this, view, rect);
    }

    public void v(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        w(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public final void w(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int b2 = p.b(S(fVar.c), i2);
        int b3 = p.b(T(fVar.d), i2);
        int i5 = b2 & 7;
        int i6 = b2 & 112;
        int i7 = b3 & 7;
        int i8 = b3 & 112;
        int width = i7 != 1 ? i7 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i8 != 16 ? i8 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i5 == 1) {
            width -= i3 / 2;
        } else if (i5 != 5) {
            width -= i3;
        }
        if (i6 == 16) {
            height -= i4 / 2;
        } else if (i6 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    public final int x(int i2) {
        StringBuilder sb;
        int[] iArr = this.k;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
        } else {
            if (i2 >= 0 && i2 < iArr.length) {
                return iArr[i2];
            }
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i2);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    public void y(View view, Rect rect) {
        rect.set(view.getLayoutParams().h());
    }

    public f z(View view) {
        f layoutParams = view.getLayoutParams();
        if (!layoutParams.b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.o(behavior);
            } else {
                d dVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        layoutParams.o((c) dVar.value().getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
            }
            layoutParams.b = true;
        }
        return layoutParams;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList();
        this.c = new B.b();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.g = new int[2];
        this.h = new int[2];
        this.u = new D(this);
        int[] iArr = A.c.b;
        TypedArray obtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, A.b.a) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = A.c.b;
            if (i2 == 0) {
                B.a.a(this, context, iArr2, attributeSet, obtainStyledAttributes, 0, A.b.a);
            } else {
                B.a.a(this, context, iArr2, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(A.c.c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.k = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.k.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.k[i3] = (int) (r12[i3] * f2);
            }
        }
        this.r = obtainStyledAttributes.getDrawable(A.c.d);
        obtainStyledAttributes.recycle();
        Y();
        super.setOnHierarchyChangeListener(new e());
        if (L.C(this) == 0) {
            L.C0(this, 1);
        }
    }
}
