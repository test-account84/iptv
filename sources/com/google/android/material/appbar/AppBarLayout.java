package com.google.android.material.appbar;

import P.E;
import P.L;
import P.X;
import P.z;
import Q.C;
import Q.F;
import R4.k;
import R4.l;
import T4.f;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.D;
import f5.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l5.g;
import l5.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int u = k.e;
    public int a;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public X h;
    public List i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public WeakReference o;
    public ValueAnimator p;
    public final List q;
    public int[] r;
    public Drawable s;
    public Behavior t;

    public static class BaseBehavior extends T4.b {
        public int k;
        public int l;
        public ValueAnimator m;
        public e n;
        public WeakReference o;
        public boolean p;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ CoordinatorLayout a;
            public final /* synthetic */ AppBarLayout c;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.c = appBarLayout;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.a, this.c, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public class b extends P.a {
            public b() {
            }

            public void g(View view, C c) {
                super.g(view, c);
                c.q0(BaseBehavior.R(BaseBehavior.this));
                c.X(ScrollView.class.getName());
            }
        }

        public class c implements F {
            public final /* synthetic */ CoordinatorLayout a;
            public final /* synthetic */ AppBarLayout b;
            public final /* synthetic */ View c;
            public final /* synthetic */ int d;

            public c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
                this.c = view;
                this.d = i;
            }

            public boolean a(View view, F.a aVar) {
                BaseBehavior.this.q(this.a, this.b, this.c, 0, this.d, new int[]{0, 0}, 1);
                return true;
            }
        }

        public class d implements F {
            public final /* synthetic */ AppBarLayout a;
            public final /* synthetic */ boolean b;

            public d(AppBarLayout appBarLayout, boolean z) {
                this.a = appBarLayout;
                this.b = z;
            }

            public boolean a(View view, F.a aVar) {
                this.a.setExpanded(this.b);
                return true;
            }
        }

        public static class e extends V.a {
            public static final Parcelable.Creator CREATOR = new a();
            public boolean d;
            public boolean e;
            public int f;
            public float g;
            public boolean h;

            public class a implements Parcelable.ClassLoaderCreator {
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public e createFromParcel(Parcel parcel) {
                    return new e(parcel, null);
                }

                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new e(parcel, classLoader);
                }

                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public e[] newArray(int i) {
                    return new e[i];
                }
            }

            public e(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.d = parcel.readByte() != 0;
                this.e = parcel.readByte() != 0;
                this.f = parcel.readInt();
                this.g = parcel.readFloat();
                this.h = parcel.readByte() != 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f);
                parcel.writeFloat(this.g);
                parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
            }

            public e(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public BaseBehavior() {
        }

        public static /* synthetic */ boolean R(BaseBehavior baseBehavior) {
            return baseBehavior.p;
        }

        public static /* synthetic */ int S(BaseBehavior baseBehavior) {
            return baseBehavior.k;
        }

        public static boolean a0(int i, int i2) {
            return (i & i2) == i2;
        }

        public static View d0(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        public int M() {
            return E() + this.k;
        }

        public final boolean T(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            boolean z = false;
            if (M() != (-appBarLayout.getTotalScrollRange())) {
                U(coordinatorLayout, appBarLayout, C.a.q, false);
                z = true;
            }
            if (M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    U(coordinatorLayout, appBarLayout, C.a.r, true);
                    return true;
                }
                int i = -appBarLayout.getDownNestedPreScrollRange();
                if (i != 0) {
                    L.o0(coordinatorLayout, C.a.r, (CharSequence) null, new c(coordinatorLayout, appBarLayout, view, i));
                    return true;
                }
            }
            return z;
        }

        public final void U(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, C.a aVar, boolean z) {
            L.o0(coordinatorLayout, aVar, (CharSequence) null, new d(appBarLayout, z));
        }

        public final void V(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(M() - i);
            float abs2 = Math.abs(f);
            W(coordinatorLayout, appBarLayout, i, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        public final void W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            int M = M();
            if (M == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(S4.a.e);
                this.m.addUpdateListener(new a(coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i2, 600));
            this.m.setIntValues(new int[]{M, i});
            this.m.start();
        }

        public final int X(int i, int i2, int i3) {
            return i < (i2 + i3) / 2 ? i2 : i3;
        }

        /* renamed from: Y, reason: merged with bridge method [inline-methods] */
        public boolean H(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.o;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public final boolean Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            return appBarLayout.j() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        }

        public final boolean b0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (appBarLayout.getChildAt(i).getLayoutParams().a != 0) {
                    return true;
                }
            }
            return false;
        }

        public final View c0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof z) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final int e0(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e layoutParams = childAt.getLayoutParams();
                if (a0(layoutParams.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        public final View f0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt.getLayoutParams().f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: g0, reason: merged with bridge method [inline-methods] */
        public int K(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* renamed from: h0, reason: merged with bridge method [inline-methods] */
        public int L(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        public final int i0(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i3);
                e layoutParams = childAt.getLayoutParams();
                Interpolator d2 = layoutParams.d();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (d2 != null) {
                    int c2 = layoutParams.c();
                    if ((c2 & 1) != 0) {
                        i2 = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((c2 & 2) != 0) {
                            i2 -= L.F(childAt);
                        }
                    }
                    if (L.B(childAt)) {
                        i2 -= appBarLayout.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * d2.getInterpolation((abs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            w0(coordinatorLayout, appBarLayout);
            if (appBarLayout.l()) {
                appBarLayout.s(appBarLayout.v(c0(coordinatorLayout)));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r8, com.google.android.material.appbar.AppBarLayout r9, int r10) {
            /*
                r7 = this;
                boolean r10 = super.l(r8, r9, r10)
                int r0 = r9.getPendingAction()
                com.google.android.material.appbar.AppBarLayout$BaseBehavior$e r1 = r7.n
                r2 = 0
                if (r1 == 0) goto L56
                r3 = r0 & 8
                if (r3 != 0) goto L56
                boolean r0 = r1.d
                if (r0 == 0) goto L1e
                int r0 = r9.getTotalScrollRange()
                int r0 = -r0
            L1a:
                r7.P(r8, r9, r0)
                goto L78
            L1e:
                boolean r0 = r1.e
                if (r0 == 0) goto L26
            L22:
                r7.P(r8, r9, r2)
                goto L78
            L26:
                int r0 = r1.f
                android.view.View r0 = r9.getChildAt(r0)
                int r1 = r0.getBottom()
                int r1 = -r1
                com.google.android.material.appbar.AppBarLayout$BaseBehavior$e r3 = r7.n
                boolean r3 = r3.h
                if (r3 == 0) goto L42
                int r0 = P.L.F(r0)
                int r3 = r9.getTopInset()
                int r0 = r0 + r3
            L40:
                int r1 = r1 + r0
                goto L52
            L42:
                int r0 = r0.getHeight()
                float r0 = (float) r0
                com.google.android.material.appbar.AppBarLayout$BaseBehavior$e r3 = r7.n
                float r3 = r3.g
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                goto L40
            L52:
                r7.P(r8, r9, r1)
                goto L78
            L56:
                if (r0 == 0) goto L78
                r1 = r0 & 4
                r3 = 1
                if (r1 == 0) goto L5f
                r1 = 1
                goto L60
            L5f:
                r1 = 0
            L60:
                r4 = r0 & 2
                r5 = 0
                if (r4 == 0) goto L70
                int r0 = r9.getUpNestedPreScrollRange()
                int r0 = -r0
                if (r1 == 0) goto L1a
                r7.V(r8, r9, r0, r5)
                goto L78
            L70:
                r0 = r0 & r3
                if (r0 == 0) goto L78
                if (r1 == 0) goto L22
                r7.V(r8, r9, r2, r5)
            L78:
                r9.o()
                r0 = 0
                r7.n = r0
                int r0 = r7.E()
                int r1 = r9.getTotalScrollRange()
                int r1 = -r1
                int r0 = J.a.b(r0, r1, r2)
                r7.G(r0)
                int r4 = r7.E()
                r5 = 0
                r6 = 1
                r1 = r7
                r2 = r8
                r3 = r9
                r1.y0(r2, r3, r4, r5, r6)
                int r0 = r7.E()
                r9.m(r0)
                r7.x0(r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int):boolean");
        }

        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) appBarLayout.getLayoutParams()).height != -2) {
                return super.m(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.K(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -appBarLayout.getTotalScrollRange();
                    i4 = i6;
                    i5 = appBarLayout.getDownNestedPreScrollRange() + i6;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = O(coordinatorLayout, appBarLayout, i2, i4, i5);
                }
            }
            if (appBarLayout.l()) {
                appBarLayout.s(appBarLayout.v(view));
            }
        }

        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = O(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                x0(coordinatorLayout, appBarLayout);
            }
        }

        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof e) {
                s0((e) parcelable, true);
                super.x(coordinatorLayout, appBarLayout, this.n.a());
            } else {
                super.x(coordinatorLayout, appBarLayout, parcelable);
                this.n = null;
            }
        }

        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable y = super.y(coordinatorLayout, appBarLayout);
            e t0 = t0(y, appBarLayout);
            return t0 == null ? y : t0;
        }

        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (appBarLayout.l() || Z(coordinatorLayout, appBarLayout, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.o = null;
            this.l = i2;
            return z;
        }

        /* renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (this.l == 0 || i == 1) {
                w0(coordinatorLayout, appBarLayout);
                if (appBarLayout.l()) {
                    appBarLayout.s(appBarLayout.v(view));
                }
            }
            this.o = new WeakReference(view);
        }

        public void s0(e eVar, boolean z) {
            if (this.n == null || z) {
                this.n = eVar;
            }
        }

        public e t0(Parcelable parcelable, AppBarLayout appBarLayout) {
            int E = E();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = V.a.c;
                    }
                    e eVar = new e(parcelable);
                    boolean z = E == 0;
                    eVar.e = z;
                    eVar.d = !z && (-E) >= appBarLayout.getTotalScrollRange();
                    eVar.f = i;
                    eVar.h = bottom == L.F(childAt) + appBarLayout.getTopInset();
                    eVar.g = bottom / childAt.getHeight();
                    return eVar;
                }
            }
            return null;
        }

        /* renamed from: u0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int M = M();
            int i4 = 0;
            if (i2 == 0 || M < i2 || M > i3) {
                this.k = 0;
            } else {
                int b2 = J.a.b(i, i2, i3);
                if (M != b2) {
                    int i0 = appBarLayout.h() ? i0(appBarLayout, b2) : b2;
                    boolean G = G(i0);
                    int i5 = M - b2;
                    this.k = b2 - i0;
                    if (G) {
                        while (i4 < appBarLayout.getChildCount()) {
                            e layoutParams = appBarLayout.getChildAt(i4).getLayoutParams();
                            c b3 = layoutParams.b();
                            if (b3 != null && (layoutParams.c() & 1) != 0) {
                                b3.a(appBarLayout, appBarLayout.getChildAt(i4), E());
                            }
                            i4++;
                        }
                    }
                    if (!G && appBarLayout.h()) {
                        coordinatorLayout.f(appBarLayout);
                    }
                    appBarLayout.m(E());
                    y0(coordinatorLayout, appBarLayout, b2, b2 < M ? -1 : 1, false);
                    i4 = i5;
                }
            }
            x0(coordinatorLayout, appBarLayout);
            return i4;
        }

        public final boolean v0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List t = coordinatorLayout.t(appBarLayout);
            int size = t.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.c f = ((View) t.get(i)).getLayoutParams().f();
                if (f instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f).K() != 0;
                }
            }
            return false;
        }

        public final void w0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int M = M() - topInset;
            int e0 = e0(appBarLayout, M);
            if (e0 >= 0) {
                View childAt = appBarLayout.getChildAt(e0);
                e layoutParams = childAt.getLayoutParams();
                int c2 = layoutParams.c();
                if ((c2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (e0 == 0 && L.B(appBarLayout) && L.B(childAt)) {
                        i -= appBarLayout.getTopInset();
                    }
                    if (a0(c2, 2)) {
                        i2 += L.F(childAt);
                    } else if (a0(c2, 5)) {
                        int F = L.F(childAt) + i2;
                        if (M < F) {
                            i = F;
                        } else {
                            i2 = F;
                        }
                    }
                    if (a0(c2, 32)) {
                        i += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i2 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    V(coordinatorLayout, appBarLayout, J.a.b(X(M, i2, i) + topInset, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void x0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View f0;
            L.m0(coordinatorLayout, C.a.q.b());
            L.m0(coordinatorLayout, C.a.r.b());
            if (appBarLayout.getTotalScrollRange() == 0 || (f0 = f0(coordinatorLayout)) == null || !b0(appBarLayout)) {
                return;
            }
            if (!L.Q(coordinatorLayout)) {
                L.s0(coordinatorLayout, new b());
            }
            this.p = T(coordinatorLayout, appBarLayout, f0);
        }

        public final void y0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View d0 = d0(appBarLayout, i);
            boolean z2 = false;
            if (d0 != null) {
                int c2 = d0.getLayoutParams().c();
                if ((c2 & 1) != 0) {
                    int F = L.F(d0);
                    if (i2 <= 0 || (c2 & 12) == 0 ? !((c2 & 2) == 0 || (-i) < (d0.getBottom() - F) - appBarLayout.getTopInset()) : (-i) >= (d0.getBottom() - F) - appBarLayout.getTopInset()) {
                        z2 = true;
                    }
                }
            }
            if (appBarLayout.l()) {
                z2 = appBarLayout.v(c0(coordinatorLayout));
            }
            boolean s = appBarLayout.s(z2);
            if (z || (s && v0(coordinatorLayout, appBarLayout))) {
                appBarLayout.jumpDrawablesToCurrentState();
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class Behavior extends BaseBehavior {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        public /* bridge */ /* synthetic */ boolean G(int i) {
            return super.G(i);
        }

        public /* bridge */ /* synthetic */ boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ boolean k0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.l(coordinatorLayout, appBarLayout, i);
        }

        public /* bridge */ /* synthetic */ boolean l0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.m(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ void m0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.q(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ void n0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        public /* bridge */ /* synthetic */ void o0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable p0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean q0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        public /* bridge */ /* synthetic */ void r0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.C(coordinatorLayout, appBarLayout, view, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends T4.c {
        public ScrollingViewBehavior() {
        }

        public static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f = appBarLayout.getLayoutParams().f();
            if (f instanceof BaseBehavior) {
                return ((BaseBehavior) f).M();
            }
            return 0;
        }

        public float J(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (R / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        public int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AppBarLayout appBarLayout = (View) list.get(i);
                if (appBarLayout instanceof AppBarLayout) {
                    return appBarLayout;
                }
            }
            return null;
        }

        public final void S(View view, View view2) {
            CoordinatorLayout.c f = view2.getLayoutParams().f();
            if (f instanceof BaseBehavior) {
                L.d0(view, (((view2.getBottom() - view.getTop()) + BaseBehavior.S((BaseBehavior) f)) + M()) - I(view2));
            }
        }

        public final void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.l()) {
                    appBarLayout.s(appBarLayout.v(view));
                }
            }
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                L.m0(coordinatorLayout, C.a.q.b());
                L.m0(coordinatorLayout, C.a.r.b());
                L.s0(coordinatorLayout, (P.a) null);
            }
        }

        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.l(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.m(coordinatorLayout, view, i, i2, i3, i4);
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout H = H(coordinatorLayout.s(view));
            if (H != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    H.p(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.C4);
            O(obtainStyledAttributes.getDimensionPixelSize(l.D4, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public class a implements E {
        public a() {
        }

        public X a(View view, X x) {
            return AppBarLayout.this.n(x);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ g a;

        public b(g gVar) {
            this.a = gVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.V(floatValue);
            if (AppBarLayout.a(AppBarLayout.this) instanceof g) {
                ((g) AppBarLayout.a(AppBarLayout.this)).V(floatValue);
            }
            Iterator it = AppBarLayout.b(AppBarLayout.this).iterator();
            if (it.hasNext()) {
                D.a(it.next());
                this.a.z();
                throw null;
            }
        }
    }

    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f);
    }

    public static class d extends c {
        public final Rect a = new Rect();
        public final Rect b = new Rect();

        public static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        public void a(AppBarLayout appBarLayout, View view, float f) {
            b(this.a, appBarLayout, view);
            float abs = this.a.top - Math.abs(f);
            if (abs > 0.0f) {
                L.z0(view, (Rect) null);
                view.setTranslationY(0.0f);
                return;
            }
            float a = 1.0f - J.a.a(Math.abs(abs / this.a.height()), 0.0f, 1.0f);
            float height = (-abs) - ((this.a.height() * 0.3f) * (1.0f - (a * a)));
            view.setTranslationY(height);
            view.getDrawingRect(this.b);
            this.b.offset(0, (int) (-height));
            L.z0(view, this.b);
        }
    }

    public static class e extends LinearLayout.LayoutParams {
        public int a;
        public c b;
        public Interpolator c;

        public e(int i, int i2) {
            super(i, i2);
            this.a = 1;
        }

        public final c a(int i) {
            if (i != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }

        public Interpolator d() {
            return this.c;
        }

        public boolean e() {
            int i = this.a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public void f(c cVar) {
            this.b = cVar;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.u);
            this.a = obtainStyledAttributes.getInt(l.w, 0);
            f(a(obtainStyledAttributes.getInt(l.v, 0)));
            if (obtainStyledAttributes.hasValue(l.x)) {
                this.c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(l.x, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.a);
    }

    public static /* synthetic */ Drawable a(AppBarLayout appBarLayout) {
        return appBarLayout.s;
    }

    public static /* synthetic */ List b(AppBarLayout appBarLayout) {
        return appBarLayout.q;
    }

    public final void c() {
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public final View d(View view) {
        int i;
        if (this.o == null && (i = this.n) != -1) {
            View findViewById = view != null ? view.findViewById(i) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = getParent().findViewById(this.n);
            }
            if (findViewById != null) {
                this.o = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (u()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.a);
            this.s.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.s;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new e((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.t = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int F;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            e layoutParams = childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 5) != 5) {
                if (i3 > 0) {
                    break;
                }
            } else {
                int i5 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i4 & 8) != 0) {
                    F = L.F(childAt);
                } else if ((i4 & 2) != 0) {
                    F = measuredHeight - L.F(childAt);
                } else {
                    i = i5 + measuredHeight;
                    if (childCount == 0 && L.B(childAt)) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                    i3 += i;
                }
                i = i5 + F;
                if (childCount == 0) {
                    i = Math.min(i, measuredHeight - getTopInset());
                }
                i3 += i;
            }
        }
        int max = Math.max(0, i3);
        this.d = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            e layoutParams = childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= L.F(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int F = L.F(this);
        if (F == 0) {
            int childCount = getChildCount();
            F = childCount >= 1 ? L.F(getChildAt(childCount - 1)) : 0;
            if (F == 0) {
                return getHeight() / 3;
            }
        }
        return (F * 2) + topInset;
    }

    public int getPendingAction() {
        return this.g;
    }

    public Drawable getStatusBarForeground() {
        return this.s;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        X x = this.h;
        if (x != null) {
            return x.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            e layoutParams = childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i2 == 0 && L.B(childAt)) {
                i3 -= getTopInset();
            }
            if ((i4 & 2) != 0) {
                i3 -= L.F(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.c = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean h() {
        return this.f;
    }

    public final boolean i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getLayoutParams().e()) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        return getTotalScrollRange() != 0;
    }

    public final void k() {
        Behavior behavior = this.t;
        BaseBehavior.e t0 = (behavior == null || this.c == -1 || this.g != 0) ? null : behavior.t0(V.a.c, this);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        if (t0 != null) {
            this.t.s0(t0, false);
        }
    }

    public boolean l() {
        return this.m;
    }

    public void m(int i) {
        this.a = i;
        if (!willNotDraw()) {
            L.j0(this);
        }
        List list = this.i;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                D.a(this.i.get(i2));
            }
        }
    }

    public X n(X x) {
        X x2 = L.B(this) ? x : null;
        if (!O.c.a(this.h, x2)) {
            this.h = x2;
            y();
            requestLayout();
        }
        return x;
    }

    public void o() {
        this.g = 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.r == null) {
            this.r = new int[4];
        }
        int[] iArr = this.r;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.k;
        int i2 = R4.b.E;
        if (!z) {
            i2 = -i2;
        }
        iArr[0] = i2;
        iArr[1] = (z && this.l) ? R4.b.F : -R4.b.F;
        int i3 = R4.b.D;
        if (!z) {
            i3 = -i3;
        }
        iArr[2] = i3;
        iArr[3] = (z && this.l) ? R4.b.C : -R4.b.C;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (L.B(this) && w()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                L.d0(getChildAt(childCount), topInset);
            }
        }
        k();
        this.f = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (getChildAt(i5).getLayoutParams().d() != null) {
                this.f = true;
                break;
            }
            i5++;
        }
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.j) {
            return;
        }
        if (!this.m && !i()) {
            z2 = false;
        }
        r(z2);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && L.B(this) && w()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = J.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        k();
    }

    public void p(boolean z, boolean z2) {
        q(z, z2, true);
    }

    public final void q(boolean z, boolean z2, boolean z3) {
        this.g = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    public final boolean r(boolean z) {
        if (this.k == z) {
            return false;
        }
        this.k = z;
        refreshDrawableState();
        return true;
    }

    public boolean s(boolean z) {
        return t(z, !this.j);
    }

    public void setElevation(float f) {
        super.setElevation(f);
        h.d(this, f);
    }

    public void setExpanded(boolean z) {
        p(z, L.W(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.m = z;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.n = i;
        c();
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.j = z;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.s;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.s = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.s.setState(getDrawableState());
                }
                H.a.m(this.s, L.E(this));
                this.s.setVisible(getVisibility() == 0, false);
                this.s.setCallback(this);
            }
            y();
            L.j0(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(e.a.b(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        f.b(this, f);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean t(boolean z, boolean z2) {
        if (!z2 || this.l == z) {
            return false;
        }
        this.l = z;
        refreshDrawableState();
        if (!this.m || !(getBackground() instanceof g)) {
            return true;
        }
        x((g) getBackground(), z);
        return true;
    }

    public final boolean u() {
        return this.s != null && getTopInset() > 0;
    }

    public boolean v(View view) {
        View d2 = d(view);
        if (d2 != null) {
            view = d2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s;
    }

    public final boolean w() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || L.B(childAt)) ? false : true;
    }

    public final void x(g gVar, boolean z) {
        float dimension = getResources().getDimension(R4.d.a);
        float f = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, dimension});
        this.p = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R4.g.a));
        this.p.setInterpolator(S4.a.a);
        this.p.addUpdateListener(new b(gVar));
        this.p.start();
    }

    public final void y() {
        setWillNotDraw(!u());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = u;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.g = 0;
        this.q = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i3 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            f.a(this);
        }
        f.c(this, attributeSet, i, i2);
        TypedArray h = u.h(context2, attributeSet, l.k, i, i2, new int[0]);
        L.w0(this, h.getDrawable(l.l));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable background = getBackground();
            g gVar = new g();
            gVar.W(ColorStateList.valueOf(background.getColor()));
            gVar.L(context2);
            L.w0(this, gVar);
        }
        if (h.hasValue(l.p)) {
            q(h.getBoolean(l.p, false), false, false);
        }
        if (h.hasValue(l.o)) {
            f.b(this, h.getDimensionPixelSize(l.o, 0));
        }
        if (i3 >= 26) {
            if (h.hasValue(l.n)) {
                T4.a.a(this, h.getBoolean(l.n, false));
            }
            if (h.hasValue(l.m)) {
                setTouchscreenBlocksFocus(h.getBoolean(l.m, false));
            }
        }
        this.m = h.getBoolean(l.q, false);
        this.n = h.getResourceId(l.r, -1);
        setStatusBarForeground(h.getDrawable(l.s));
        h.recycle();
        L.E0(this, new a());
    }
}
