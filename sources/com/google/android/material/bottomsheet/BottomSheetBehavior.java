package com.google.android.material.bottomsheet;

import P.L;
import Q.C;
import Q.F;
import R4.j;
import R4.k;
import R4.l;
import W.d;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.D;
import f5.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class BottomSheetBehavior extends CoordinatorLayout.c {
    public static final int d0 = k.f;
    public ValueAnimator A;
    public int B;
    public int C;
    public int D;
    public float E;
    public int F;
    public float G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;
    public W.d M;
    public boolean N;
    public int O;
    public boolean P;
    public int Q;
    public int R;
    public int S;
    public WeakReference T;
    public WeakReference U;
    public final ArrayList V;
    public VelocityTracker W;
    public int X;
    public int Y;
    public boolean Z;
    public int a;
    public Map a0;
    public boolean b;
    public int b0;
    public boolean c;
    public final d.c c0;
    public float d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public l5.g i;
    public ColorStateList j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public l5.k x;
    public boolean y;
    public final g z;

    public class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int c;

        public a(View view, int i) {
            this.a = view;
            this.c = i;
        }

        public void run() {
            BottomSheetBehavior.E(BottomSheetBehavior.this, this.a, this.c, false);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.M(BottomSheetBehavior.this) != null) {
                BottomSheetBehavior.M(BottomSheetBehavior.this).X(floatValue);
            }
        }
    }

    public class c implements w.d {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public P.X a(android.view.View r11, P.X r12, f5.w.e r13) {
            /*
                r10 = this;
                int r0 = P.X.m.c()
                G.b r0 = r12.f(r0)
                int r1 = P.X.m.b()
                G.b r1 = r12.f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.b
                com.google.android.material.bottomsheet.BottomSheetBehavior.N(r2, r3)
                boolean r2 = f5.w.e(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.O(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.h()
                com.google.android.material.bottomsheet.BottomSheetBehavior.Q(r3, r6)
                int r3 = r13.d
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.P(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.R(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.c
                goto L50
            L4e:
                int r4 = r13.a
            L50:
                int r6 = r0.a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.S(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.a
                goto L62
            L60:
                int r13 = r13.c
            L62:
                int r2 = r0.c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.T(r2)
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = 1
                goto L81
            L80:
                r2 = 0
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.U(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                r2 = 1
            L92:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.F(r8)
                if (r8 == 0) goto La3
                int r8 = r13.topMargin
                int r0 = r0.b
                if (r8 == r0) goto La3
                r13.topMargin = r0
                goto La4
            La3:
                r7 = r2
            La4:
                if (r7 == 0) goto La9
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.d
                com.google.android.material.bottomsheet.BottomSheetBehavior.G(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.O(r11)
                if (r11 != 0) goto Lc7
                boolean r11 = r10.a
                if (r11 == 0) goto Lcc
            Lc7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.H(r11, r6)
            Lcc:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.a(android.view.View, P.X, f5.w$e):P.X");
        }
    }

    public class d extends d.c {
        public long a;

        public d() {
        }

        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        public int b(View view, int i, int i2) {
            int f0 = BottomSheetBehavior.this.f0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return J.a.b(i, f0, bottomSheetBehavior.H ? bottomSheetBehavior.S : bottomSheetBehavior.F);
        }

        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.H ? bottomSheetBehavior.S : bottomSheetBehavior.F;
        }

        public void j(int i) {
            if (i == 1 && BottomSheetBehavior.I(BottomSheetBehavior.this)) {
                BottomSheetBehavior.this.C0(1);
            }
        }

        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.c0(i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.K;
            if (i2 == 1 || bottomSheetBehavior.Z) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.X == i) {
                WeakReference weakReference = bottomSheetBehavior.U;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.a = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.T;
            return weakReference2 != null && weakReference2.get() == view;
        }

        public final boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.S + bottomSheetBehavior.f0()) / 2;
        }
    }

    public class e implements F {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        public boolean a(View view, F.a aVar) {
            BottomSheetBehavior.this.B0(this.a);
            return true;
        }
    }

    public static class f extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public final int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, (ClassLoader) null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i) {
                return new f[i];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt() == 1;
            this.g = parcel.readInt() == 1;
            this.h = parcel.readInt() == 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
            parcel.writeInt(this.h ? 1 : 0);
        }

        public f(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.d = bottomSheetBehavior.K;
            this.e = BottomSheetBehavior.K(bottomSheetBehavior);
            this.f = BottomSheetBehavior.J(bottomSheetBehavior);
            this.g = bottomSheetBehavior.H;
            this.h = BottomSheetBehavior.L(bottomSheetBehavior);
        }
    }

    public class g {
        public int a;
        public boolean b;
        public final Runnable c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                g.a(g.this, false);
                W.d dVar = BottomSheetBehavior.this.M;
                if (dVar != null && dVar.k(true)) {
                    g gVar = g.this;
                    gVar.c(g.b(gVar));
                    return;
                }
                g gVar2 = g.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.K == 2) {
                    bottomSheetBehavior.C0(g.b(gVar2));
                }
            }
        }

        public g() {
            this.c = new a();
        }

        public static /* synthetic */ boolean a(g gVar, boolean z) {
            gVar.b = z;
            return z;
        }

        public static /* synthetic */ int b(g gVar) {
            return gVar.a;
        }

        public void c(int i) {
            WeakReference weakReference = BottomSheetBehavior.this.T;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a = i;
            if (this.b) {
                return;
            }
            L.k0((View) BottomSheetBehavior.this.T.get(), this.c);
            this.b = true;
        }

        public /* synthetic */ g(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.c = false;
        this.k = -1;
        this.l = -1;
        this.z = new g(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.V = new ArrayList();
        this.b0 = -1;
        this.c0 = new d();
    }

    public static /* synthetic */ void E(BottomSheetBehavior bottomSheetBehavior, View view, int i, boolean z) {
        bottomSheetBehavior.J0(view, i, z);
    }

    public static /* synthetic */ boolean F(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.u;
    }

    public static /* synthetic */ int G(BottomSheetBehavior bottomSheetBehavior, int i) {
        bottomSheetBehavior.m = i;
        return i;
    }

    public static /* synthetic */ void H(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        bottomSheetBehavior.N0(z);
    }

    public static /* synthetic */ boolean I(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.J;
    }

    public static /* synthetic */ boolean J(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.b;
    }

    public static /* synthetic */ int K(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.e;
    }

    public static /* synthetic */ boolean L(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.I;
    }

    public static /* synthetic */ l5.g M(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.i;
    }

    public static /* synthetic */ int N(BottomSheetBehavior bottomSheetBehavior, int i) {
        bottomSheetBehavior.w = i;
        return i;
    }

    public static /* synthetic */ boolean O(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.o;
    }

    public static /* synthetic */ int P(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.v;
    }

    public static /* synthetic */ int Q(BottomSheetBehavior bottomSheetBehavior, int i) {
        bottomSheetBehavior.v = i;
        return i;
    }

    public static /* synthetic */ boolean R(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.p;
    }

    public static /* synthetic */ boolean S(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.q;
    }

    public static /* synthetic */ boolean T(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.s;
    }

    public static /* synthetic */ boolean U(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.t;
    }

    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.O = 0;
        this.P = false;
        return (i & 2) != 0;
    }

    public void A0(boolean z) {
        this.I = z;
    }

    public void B0(int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.H && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.b && g0(i) <= this.C) ? 3 : i;
        WeakReference weakReference = this.T;
        if (weakReference == null || weakReference.get() == null) {
            C0(i);
        } else {
            View view = (View) this.T.get();
            o0(view, new a(view, i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.f0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.C0(r0)
            return
        Lf:
            boolean r3 = r2.k0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference r3 = r2.U
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.P
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.O
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.D
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.H
            if (r3 == 0) goto L49
            float r3 = r2.h0()
            boolean r3 = r2.G0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.O
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.b
            if (r1 == 0) goto L68
            int r5 = r2.C
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.D
            if (r3 >= r1) goto L7e
            int r1 = r2.F
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.H0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.b
            if (r3 == 0) goto L94
        L92:
            r0 = 4
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.D
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = 6
        Laa:
            r3 = 0
            r2.J0(r4, r0, r3)
            r2.P = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public void C0(int i) {
        if (this.K == i) {
            return;
        }
        this.K = i;
        if (i == 4 || i == 3 || i == 6 || (this.H && i == 5)) {
            this.L = i;
        }
        WeakReference weakReference = this.T;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            M0(true);
        } else if (i == 6 || i == 5 || i == 4) {
            M0(false);
        }
        L0(i);
        if (this.V.size() <= 0) {
            K0();
        } else {
            D.a(this.V.get(0));
            throw null;
        }
    }

    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.K == 1 && actionMasked == 0) {
            return true;
        }
        if (F0()) {
            this.M.z(motionEvent);
        }
        if (actionMasked == 0) {
            m0();
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        if (F0() && actionMasked == 2 && !this.N && Math.abs(this.Y - motionEvent.getY()) > this.M.u()) {
            this.M.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.N;
    }

    public final void D0(View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || i0() || this.f) ? false : true;
        if (this.o || this.p || this.q || this.s || this.t || this.u || z) {
            w.a(view, new c(z));
        }
    }

    public boolean E0(long j, float f2) {
        return false;
    }

    public final boolean F0() {
        return this.M != null && (this.J || this.K == 1);
    }

    public boolean G0(View view, float f2) {
        if (this.I) {
            return true;
        }
        if (view.getTop() < this.F) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.F)) / ((float) Y()) > 0.5f;
    }

    public boolean H0() {
        return false;
    }

    public boolean I0() {
        return true;
    }

    public final void J0(View view, int i, boolean z) {
        int g0 = g0(i);
        W.d dVar = this.M;
        if (dVar == null || (!z ? dVar.H(view, view.getLeft(), g0) : dVar.F(view.getLeft(), g0))) {
            C0(i);
            return;
        }
        C0(2);
        L0(i);
        this.z.c(i);
    }

    public final void K0() {
        View view;
        int i;
        C.a aVar;
        WeakReference weakReference = this.T;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        L.m0(view, 524288);
        L.m0(view, 262144);
        L.m0(view, 1048576);
        int i2 = this.b0;
        if (i2 != -1) {
            L.m0(view, i2);
        }
        if (!this.b && this.K != 6) {
            this.b0 = V(view, j.a, 6);
        }
        if (this.H && this.K != 5) {
            l0(view, C.a.y, 5);
        }
        int i3 = this.K;
        if (i3 == 3) {
            i = this.b ? 4 : 6;
            aVar = C.a.x;
        } else {
            if (i3 != 4) {
                if (i3 != 6) {
                    return;
                }
                l0(view, C.a.x, 4);
                l0(view, C.a.w, 3);
                return;
            }
            i = this.b ? 3 : 6;
            aVar = C.a.w;
        }
        l0(view, aVar, i);
    }

    public final void L0(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.y != z) {
            this.y = z;
            if (this.i == null || (valueAnimator = this.A) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.A.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.A.setFloatValues(new float[]{1.0f - f2, f2});
            this.A.start();
        }
    }

    public final void M0(boolean z) {
        Map map;
        int intValue;
        WeakReference weakReference = this.T;
        if (weakReference == null) {
            return;
        }
        CoordinatorLayout parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.a0 != null) {
                    return;
                } else {
                    this.a0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.T.get()) {
                    if (z) {
                        this.a0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.c) {
                            intValue = 4;
                            L.C0(childAt, intValue);
                        }
                    } else if (this.c && (map = this.a0) != null && map.containsKey(childAt)) {
                        intValue = ((Integer) this.a0.get(childAt)).intValue();
                        L.C0(childAt, intValue);
                    }
                }
            }
            if (!z) {
                this.a0 = null;
            } else if (this.c) {
                ((View) this.T.get()).sendAccessibilityEvent(8);
            }
        }
    }

    public final void N0(boolean z) {
        View view;
        if (this.T != null) {
            W();
            if (this.K != 4 || (view = (View) this.T.get()) == null) {
                return;
            }
            if (z) {
                B0(4);
            } else {
                view.requestLayout();
            }
        }
    }

    public final int V(View view, int i, int i2) {
        return L.c(view, view.getResources().getString(i), Z(i2));
    }

    public final void W() {
        int Y = Y();
        if (this.b) {
            this.F = Math.max(this.S - Y, this.C);
        } else {
            this.F = this.S - Y;
        }
    }

    public final void X() {
        this.D = (int) (this.S * (1.0f - this.E));
    }

    public final int Y() {
        int i;
        return this.f ? Math.min(Math.max(this.g, this.S - ((this.R * 9) / 16)), this.Q) + this.v : (this.n || this.o || (i = this.m) <= 0) ? this.e + this.v : Math.max(this.e, i + this.h);
    }

    public final F Z(int i) {
        return new e(i);
    }

    public final void a0(Context context) {
        if (this.x == null) {
            return;
        }
        l5.g gVar = new l5.g(this.x);
        this.i = gVar;
        gVar.L(context);
        ColorStateList colorStateList = this.j;
        if (colorStateList != null) {
            this.i.W(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842801, typedValue, true);
        this.i.setTint(typedValue.data);
    }

    public final void b0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.A = ofFloat;
        ofFloat.setDuration(500L);
        this.A.addUpdateListener(new b());
    }

    public void c0(int i) {
        if (((View) this.T.get()) == null || this.V.isEmpty()) {
            return;
        }
        int i2 = this.F;
        if (i <= i2 && i2 != f0()) {
            f0();
        }
        if (this.V.size() <= 0) {
            return;
        }
        D.a(this.V.get(0));
        throw null;
    }

    public View d0(View view) {
        if (L.X(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View d02 = d0(viewGroup.getChildAt(i));
            if (d02 != null) {
                return d02;
            }
        }
        return null;
    }

    public final int e0(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    public int f0() {
        if (this.b) {
            return this.C;
        }
        return Math.max(this.B, this.r ? 0 : this.w);
    }

    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.T = null;
        this.M = null;
    }

    public final int g0(int i) {
        if (i == 3) {
            return f0();
        }
        if (i == 4) {
            return this.F;
        }
        if (i == 5) {
            return this.S;
        }
        if (i == 6) {
            return this.D;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i);
    }

    public final float h0() {
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.d);
        return this.W.getYVelocity(this.X);
    }

    public boolean i0() {
        return this.n;
    }

    public void j() {
        super.j();
        this.T = null;
        this.M = null;
    }

    public final boolean j0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && L.V(view);
    }

    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        W.d dVar;
        if (!view.isShown() || !this.J) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m0();
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.Y = (int) motionEvent.getY();
            if (this.K != 2) {
                WeakReference weakReference = this.U;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.C(view2, x, this.Y)) {
                    this.X = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.Z = true;
                }
            }
            this.N = this.X == -1 && !coordinatorLayout.C(view, x, this.Y);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Z = false;
            this.X = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (!this.N && (dVar = this.M) != null && dVar.G(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.U;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.N || this.K == 1 || coordinatorLayout.C(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || Math.abs(((float) this.Y) - motionEvent.getY()) <= ((float) this.M.u())) ? false : true;
    }

    public boolean k0() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r7, android.view.View r8, int r9) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public final void l0(View view, C.a aVar, int i) {
        L.o0(view, aVar, (CharSequence) null, Z(i));
    }

    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams();
        view.measure(e0(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i2, this.k, layoutParams.width), e0(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i4, this.l, layoutParams.height));
        return true;
    }

    public final void m0() {
        this.X = -1;
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.W = null;
        }
    }

    public final void n0(f fVar) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.e = fVar.e;
        }
        if (i == -1 || (i & 2) == 2) {
            this.b = fVar.f;
        }
        if (i == -1 || (i & 4) == 4) {
            this.H = fVar.g;
        }
        if (i == -1 || (i & 8) == 8) {
            this.I = fVar.h;
        }
    }

    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        WeakReference weakReference;
        if (k0() && (weakReference = this.U) != null && view2 == weakReference.get()) {
            return this.K != 3 || super.o(coordinatorLayout, view, view2, f2, f3);
        }
        return false;
    }

    public final void o0(View view, Runnable runnable) {
        if (j0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void p0(boolean z) {
        this.J = z;
    }

    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.U;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!k0() || view2 == view3) {
            int top = view.getTop();
            int i5 = top - i2;
            if (i2 > 0) {
                if (i5 < f0()) {
                    int f0 = top - f0();
                    iArr[1] = f0;
                    L.d0(view, -f0);
                    i4 = 3;
                    C0(i4);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i2;
                    L.d0(view, -i2);
                    C0(1);
                }
            } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
                int i6 = this.F;
                if (i5 > i6 && !this.H) {
                    int i7 = top - i6;
                    iArr[1] = i7;
                    L.d0(view, -i7);
                    i4 = 4;
                    C0(i4);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i2;
                    L.d0(view, -i2);
                    C0(1);
                }
            }
            c0(view.getTop());
            this.O = i2;
            this.P = true;
        }
    }

    public void q0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.B = i;
    }

    public void r0(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (this.T != null) {
            W();
        }
        C0((this.b && this.K == 6) ? 3 : this.K);
        K0();
    }

    public void s0(boolean z) {
        this.n = z;
    }

    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public void t0(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.E = f2;
        if (this.T != null) {
            X();
        }
    }

    public void u0(boolean z) {
        if (this.H != z) {
            this.H = z;
            if (!z && this.K == 5) {
                B0(4);
            }
            K0();
        }
    }

    public void v0(int i) {
        this.l = i;
    }

    public void w0(int i) {
        this.k = i;
    }

    public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.x(coordinatorLayout, view, fVar.a());
        n0(fVar);
        int i = fVar.d;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.K = i;
        this.L = i;
    }

    public void x0(int i) {
        y0(i, false);
    }

    public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
        return new f(super.y(coordinatorLayout, view), this);
    }

    public final void y0(int i, boolean z) {
        if (i == -1) {
            if (this.f) {
                return;
            } else {
                this.f = true;
            }
        } else {
            if (!this.f && this.e == i) {
                return;
            }
            this.f = false;
            this.e = Math.max(0, i);
        }
        N0(z);
    }

    public void z0(int i) {
        this.a = i;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.a = 0;
        this.b = true;
        this.c = false;
        this.k = -1;
        this.l = -1;
        this.z = new g(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.V = new ArrayList();
        this.b0 = -1;
        this.c0 = new d();
        this.h = context.getResources().getDimensionPixelSize(R4.d.T);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.T);
        if (obtainStyledAttributes.hasValue(l.X)) {
            this.j = i5.c.a(context, obtainStyledAttributes, l.X);
        }
        if (obtainStyledAttributes.hasValue(l.o0)) {
            this.x = l5.k.e(context, attributeSet, R4.b.d, d0).m();
        }
        a0(context);
        b0();
        this.G = obtainStyledAttributes.getDimension(l.W, -1.0f);
        if (obtainStyledAttributes.hasValue(l.U)) {
            w0(obtainStyledAttributes.getDimensionPixelSize(l.U, -1));
        }
        if (obtainStyledAttributes.hasValue(l.V)) {
            v0(obtainStyledAttributes.getDimensionPixelSize(l.V, -1));
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(l.d0);
        x0((peekValue == null || (i = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(l.d0, -1) : i);
        u0(obtainStyledAttributes.getBoolean(l.c0, false));
        s0(obtainStyledAttributes.getBoolean(l.g0, false));
        r0(obtainStyledAttributes.getBoolean(l.a0, true));
        A0(obtainStyledAttributes.getBoolean(l.f0, false));
        p0(obtainStyledAttributes.getBoolean(l.Y, true));
        z0(obtainStyledAttributes.getInt(l.e0, 0));
        t0(obtainStyledAttributes.getFloat(l.b0, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(l.Z);
        q0((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(l.Z, 0) : peekValue2.data);
        this.o = obtainStyledAttributes.getBoolean(l.k0, false);
        this.p = obtainStyledAttributes.getBoolean(l.l0, false);
        this.q = obtainStyledAttributes.getBoolean(l.m0, false);
        this.r = obtainStyledAttributes.getBoolean(l.n0, true);
        this.s = obtainStyledAttributes.getBoolean(l.h0, false);
        this.t = obtainStyledAttributes.getBoolean(l.i0, false);
        this.u = obtainStyledAttributes.getBoolean(l.j0, false);
        obtainStyledAttributes.recycle();
        this.d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
