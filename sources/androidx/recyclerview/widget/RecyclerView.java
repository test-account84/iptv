package androidx.recyclerview.widget;

import P.L;
import P.N;
import Q.C;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RecyclerView extends ViewGroup implements P.z {
    public static final int[] D0 = {16843830};
    public static final boolean E0;
    public static final boolean F0;
    public static final boolean G0;
    public static final boolean H0;
    public static final boolean I0;
    public static final boolean J0;
    public static final Class[] K0;
    public static final Interpolator L0;
    public int A;
    public final List A0;
    public boolean B;
    public Runnable B0;
    public final AccessibilityManager C;
    public final q.b C0;
    public List D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public k I;
    public EdgeEffect J;
    public EdgeEffect K;
    public EdgeEffect L;
    public EdgeEffect M;
    public l N;
    public int O;
    public int P;
    public VelocityTracker Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public r W;
    public final x a;
    public final v c;
    public y d;
    public androidx.recyclerview.widget.a e;
    public final int e0;
    public androidx.recyclerview.widget.b f;
    public final int f0;
    public final androidx.recyclerview.widget.q g;
    public float g0;
    public boolean h;
    public float h0;
    public final Runnable i;
    public boolean i0;
    public final Rect j;
    public final C j0;
    public final Rect k;
    public androidx.recyclerview.widget.e k0;
    public final RectF l;
    public e.b l0;
    public g m;
    public final A m0;
    public o n;
    public t n0;
    public w o;
    public List o0;
    public final ArrayList p;
    public boolean p0;
    public final ArrayList q;
    public boolean q0;
    public s r;
    public l.b r0;
    public boolean s;
    public boolean s0;
    public boolean t;
    public androidx.recyclerview.widget.l t0;
    public boolean u;
    public j u0;
    public boolean v;
    public final int[] v0;
    public int w;
    public P.A w0;
    public boolean x;
    public final int[] x0;
    public boolean y;
    public final int[] y0;
    public boolean z;
    public final int[] z0;

    public static class A {
        public SparseArray b;
        public int m;
        public long n;
        public int o;
        public int p;
        public int q;
        public int a = -1;
        public int c = 0;
        public int d = 0;
        public int e = 1;
        public int f = 0;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;

        public void a(int i) {
            if ((this.e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.e));
        }

        public boolean b() {
            return this.g;
        }

        public int c() {
            return this.h ? this.c - this.d : this.f;
        }

        public int d() {
            return this.p;
        }

        public int e() {
            return this.q;
        }

        public int f() {
            return this.a;
        }

        public boolean g() {
            return this.a != -1;
        }

        public boolean h() {
            return this.h;
        }

        public void i(g gVar) {
            this.e = 1;
            this.f = gVar.n();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public boolean j() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }
    }

    public static abstract class B {
    }

    public class C implements Runnable {
        public int a;
        public int c;
        public OverScroller d;
        public Interpolator e;
        public boolean f;
        public boolean g;

        public C() {
            Interpolator interpolator = RecyclerView.L0;
            this.e = interpolator;
            this.f = false;
            this.g = false;
            this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float b = f2 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(b / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public final float b(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public void c(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.c = 0;
            this.a = 0;
            Interpolator interpolator = this.e;
            Interpolator interpolator2 = RecyclerView.L0;
            if (interpolator != interpolator2) {
                this.e = interpolator2;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.d.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        public final void d() {
            RecyclerView.this.removeCallbacks(this);
            L.k0(RecyclerView.this, this);
        }

        public void e() {
            if (this.f) {
                this.g = true;
            } else {
                d();
            }
        }

        public void f(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.L0;
            }
            if (this.e != interpolator) {
                this.e = interpolator;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.c = 0;
            this.a = 0;
            RecyclerView.this.setScrollState(2);
            this.d.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.d.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.d.abortAnimation();
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.n == null) {
                g();
                return;
            }
            this.g = false;
            this.f = true;
            recyclerView.v();
            OverScroller overScroller = this.d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.a;
                int i4 = currY - this.c;
                this.a = currX;
                this.c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.z0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.G(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.z0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.m != null) {
                    int[] iArr3 = recyclerView3.z0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.l1(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.z0;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    z zVar = recyclerView4.n.g;
                    if (zVar != null && !zVar.g() && zVar.h()) {
                        int c = RecyclerView.this.m0.c();
                        if (c == 0) {
                            zVar.r();
                        } else {
                            if (zVar.f() >= c) {
                                zVar.p(c - 1);
                            }
                            zVar.j(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.z0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.H(i2, i, i3, i4, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.z0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    recyclerView6.J(i2, i);
                }
                if (!RecyclerView.e(RecyclerView.this)) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                z zVar2 = RecyclerView.this.n.g;
                if ((zVar2 == null || !zVar2.g()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.b(i7, currVelocity);
                    }
                    if (RecyclerView.H0) {
                        RecyclerView.this.l0.b();
                    }
                } else {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView7.k0;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i2, i);
                    }
                }
            }
            z zVar3 = RecyclerView.this.n.g;
            if (zVar3 != null && zVar3.g()) {
                zVar3.j(0, 0);
            }
            this.f = false;
            if (this.g) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.y1(1);
            }
        }
    }

    public static abstract class D {
        public static final List s = Collections.emptyList();
        public final View a;
        public WeakReference b;
        public int j;
        public RecyclerView r;
        public int c = -1;
        public int d = -1;
        public long e = -1;
        public int f = -1;
        public int g = -1;
        public D h = null;
        public D i = null;
        public List k = null;
        public List l = null;
        public int m = 0;
        public v n = null;
        public boolean o = false;
        public int p = 0;
        public int q = -1;

        public D(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.a = view;
        }

        public boolean A() {
            return (this.j & 256) != 0;
        }

        public boolean B() {
            return (this.j & 2) != 0;
        }

        public boolean C() {
            return (this.j & 2) != 0;
        }

        public void D(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.a.getLayoutParams() != null) {
                this.a.getLayoutParams().d = true;
            }
        }

        public void E(RecyclerView recyclerView) {
            int i = this.q;
            if (i == -1) {
                i = L.C(this.a);
            }
            this.p = i;
            recyclerView.o1(this, 4);
        }

        public void F(RecyclerView recyclerView) {
            recyclerView.o1(this, this.p);
            this.p = 0;
        }

        public void G() {
            this.j = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            g();
            this.p = 0;
            this.q = -1;
            RecyclerView.s(this);
        }

        public void H() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        public void I(int i, int i2) {
            this.j = (i & i2) | (this.j & (~i2));
        }

        public final void J(boolean z) {
            int i;
            int i2 = this.m;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.m = i3;
            if (i3 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.j | 16;
            } else if (!z || i3 != 0) {
                return;
            } else {
                i = this.j & (-17);
            }
            this.j = i;
        }

        public void K(v vVar, boolean z) {
            this.n = vVar;
            this.o = z;
        }

        public boolean L() {
            return (this.j & 16) != 0;
        }

        public boolean M() {
            return (this.j & 128) != 0;
        }

        public void N() {
            this.n.J(this);
        }

        public boolean O() {
            return (this.j & 32) != 0;
        }

        public void d(Object obj) {
            if (obj == null) {
                e(1024);
            } else if ((1024 & this.j) == 0) {
                j();
                this.k.add(obj);
            }
        }

        public void e(int i) {
            this.j = i | this.j;
        }

        public void f() {
            this.d = -1;
            this.g = -1;
        }

        public void g() {
            List list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
        }

        public void h() {
            this.j &= -33;
        }

        public void i() {
            this.j &= -257;
        }

        public final void j() {
            if (this.k == null) {
                ArrayList arrayList = new ArrayList();
                this.k = arrayList;
                this.l = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean k() {
            return (this.j & 16) == 0 && L.T(this.a);
        }

        public void l(int i, int i2, boolean z) {
            e(8);
            D(i2, z);
            this.c = i;
        }

        public final int m() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.e0(this);
        }

        public final long n() {
            return this.e;
        }

        public final int o() {
            return this.f;
        }

        public final int p() {
            int i = this.g;
            return i == -1 ? this.c : i;
        }

        public final int q() {
            return this.d;
        }

        public List r() {
            if ((this.j & 1024) != 0) {
                return s;
            }
            List list = this.k;
            return (list == null || list.size() == 0) ? s : this.l;
        }

        public boolean s(int i) {
            return (i & this.j) != 0;
        }

        public boolean t() {
            return (this.j & 512) != 0 || w();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (z()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (w()) {
                sb.append(" invalid");
            }
            if (!v()) {
                sb.append(" unbound");
            }
            if (C()) {
                sb.append(" update");
            }
            if (y()) {
                sb.append(" removed");
            }
            if (M()) {
                sb.append(" ignored");
            }
            if (A()) {
                sb.append(" tmpDetached");
            }
            if (!x()) {
                sb.append(" not recyclable(" + this.m + ")");
            }
            if (t()) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean u() {
            return (this.a.getParent() == null || this.a.getParent() == this.r) ? false : true;
        }

        public boolean v() {
            return (this.j & 1) != 0;
        }

        public boolean w() {
            return (this.j & 4) != 0;
        }

        public final boolean x() {
            return (this.j & 16) == 0 && !L.T(this.a);
        }

        public boolean y() {
            return (this.j & 8) != 0;
        }

        public boolean z() {
            return this.n != null;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.v || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.s) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.y) {
                recyclerView2.x = true;
            } else {
                recyclerView2.v();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            l lVar = RecyclerView.this.N;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.s0 = false;
        }
    }

    public static class c implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class d implements q.b {
        public d() {
        }

        public void a(D d, l.c cVar, l.c cVar2) {
            RecyclerView.this.m(d, cVar, cVar2);
        }

        public void b(D d) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n.J1(d.a, recyclerView.c);
        }

        public void c(D d, l.c cVar, l.c cVar2) {
            RecyclerView.this.c.J(d);
            RecyclerView.this.o(d, cVar, cVar2);
        }

        public void d(D d, l.c cVar, l.c cVar2) {
            d.J(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z = recyclerView.E;
            l lVar = recyclerView.N;
            if (z) {
                if (!lVar.b(d, d, cVar, cVar2)) {
                    return;
                }
            } else if (!lVar.d(d, cVar, cVar2)) {
                return;
            }
            RecyclerView.this.Q0();
        }
    }

    public class e implements b.b {
        public e() {
        }

        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        public void addView(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.z(view);
        }

        public void b(View view) {
            D j0 = RecyclerView.j0(view);
            if (j0 != null) {
                j0.E(RecyclerView.this);
            }
        }

        public int c() {
            return RecyclerView.this.getChildCount();
        }

        public D d(View view) {
            return RecyclerView.j0(view);
        }

        public void e(int i) {
            D j0;
            View a = a(i);
            if (a != null && (j0 = RecyclerView.j0(a)) != null) {
                if (j0.A() && !j0.M()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + j0 + RecyclerView.this.Q());
                }
                j0.e(256);
            }
            RecyclerView.d(RecyclerView.this, i);
        }

        public void f() {
            int c = c();
            for (int i = 0; i < c; i++) {
                View a = a(i);
                RecyclerView.this.A(a);
                a.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        public int g(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        public void h(View view) {
            D j0 = RecyclerView.j0(view);
            if (j0 != null) {
                j0.F(RecyclerView.this);
            }
        }

        public void i(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        public void j(View view, int i, ViewGroup.LayoutParams layoutParams) {
            D j0 = RecyclerView.j0(view);
            if (j0 != null) {
                if (!j0.A() && !j0.M()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + j0 + RecyclerView.this.Q());
                }
                j0.i();
            }
            RecyclerView.c(RecyclerView.this, view, i, layoutParams);
        }
    }

    public class f implements a.a {
        public f() {
        }

        public void a(int i, int i2) {
            RecyclerView.this.G0(i, i2);
            RecyclerView.this.p0 = true;
        }

        public void b(a.b bVar) {
            i(bVar);
        }

        public void c(a.b bVar) {
            i(bVar);
        }

        public void d(int i, int i2) {
            RecyclerView.this.H0(i, i2, false);
            RecyclerView.this.p0 = true;
        }

        public void e(int i, int i2, Object obj) {
            RecyclerView.this.B1(i, i2, obj);
            RecyclerView.this.q0 = true;
        }

        public D f(int i) {
            D c0 = RecyclerView.this.c0(i, true);
            if (c0 == null || RecyclerView.this.f.n(c0.a)) {
                return null;
            }
            return c0;
        }

        public void g(int i, int i2) {
            RecyclerView.this.F0(i, i2);
            RecyclerView.this.p0 = true;
        }

        public void h(int i, int i2) {
            RecyclerView.this.H0(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.p0 = true;
            recyclerView.m0.d += i2;
        }

        public void i(a.b bVar) {
            int i = bVar.a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.n.n1(recyclerView, bVar.b, bVar.d);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.n.q1(recyclerView2, bVar.b, bVar.d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.n.s1(recyclerView3, bVar.b, bVar.d, bVar.c);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.n.p1(recyclerView4, bVar.b, bVar.d, 1);
            }
        }
    }

    public static abstract class g {
        public final h a = new h();
        public boolean c = false;

        public final void A(int i, int i2) {
            this.a.d(i, i2);
        }

        public final void B(int i) {
            this.a.f(i, 1);
        }

        public void D(RecyclerView recyclerView) {
        }

        public abstract void E(D d, int i);

        public void J(D d, int i, List list) {
            E(d, i);
        }

        public abstract D L(ViewGroup viewGroup, int i);

        public void S(RecyclerView recyclerView) {
        }

        public boolean T(D d) {
            return false;
        }

        public void W(D d) {
        }

        public void Y(D d) {
        }

        public void Z(D d) {
        }

        public void b0(i iVar) {
            this.a.registerObserver(iVar);
        }

        public void c0(boolean z) {
            if (r()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.c = z;
        }

        public void i0(i iVar) {
            this.a.unregisterObserver(iVar);
        }

        public final void k(D d, int i) {
            d.c = i;
            if (v()) {
                d.e = o(i);
            }
            d.I(1, 519);
            L.t.a("RV OnBindView");
            J(d, i, d.r());
            d.g();
            p layoutParams = d.a.getLayoutParams();
            if (layoutParams instanceof p) {
                layoutParams.d = true;
            }
            L.t.b();
        }

        public final D l(ViewGroup viewGroup, int i) {
            try {
                L.t.a("RV CreateView");
                D L = L(viewGroup, i);
                if (L.a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                L.f = i;
                return L;
            } finally {
                L.t.b();
            }
        }

        public abstract int n();

        public long o(int i) {
            return -1L;
        }

        public int p(int i) {
            return 0;
        }

        public final boolean r() {
            return this.a.a();
        }

        public final boolean v() {
            return this.c;
        }

        public final void w() {
            this.a.b();
        }

        public final void x(int i) {
            this.a.d(i, 1);
        }

        public final void z(int i, int i2) {
            this.a.c(i, i2);
        }
    }

    public static class h extends Observable {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i, i2, 1);
            }
        }

        public void d(int i, int i2) {
            e(i, i2, null);
        }

        public void e(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i, i2, obj);
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i, i2);
            }
        }
    }

    public static abstract class i {
        public abstract void a();

        public void b(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            b(i, i2);
        }

        public void d(int i, int i2, int i3) {
        }

        public void e(int i, int i2) {
        }
    }

    public interface j {
        int a(int i, int i2);
    }

    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {
        public b a = null;
        public ArrayList b = new ArrayList();
        public long c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        public interface a {
            void a();
        }

        public interface b {
            void a(D d);
        }

        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(D d) {
                return b(d, 0);
            }

            public c b(D d, int i) {
                View view = d.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        public static int e(D d) {
            int i = d.j;
            int i2 = i & 14;
            if (d.w()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i2;
            }
            int q = d.q();
            int m = d.m();
            return (q == -1 || m == -1 || q == m) ? i2 : i2 | 2048;
        }

        public abstract boolean a(D d, c cVar, c cVar2);

        public abstract boolean b(D d, D d2, c cVar, c cVar2);

        public abstract boolean c(D d, c cVar, c cVar2);

        public abstract boolean d(D d, c cVar, c cVar2);

        public abstract boolean f(D d);

        public boolean g(D d, List list) {
            return f(d);
        }

        public final void h(D d) {
            s(d);
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(d);
            }
        }

        public final void i() {
            if (this.b.size() <= 0) {
                this.b.clear();
            } else {
                d.D.a(this.b.get(0));
                throw null;
            }
        }

        public abstract void j(D d);

        public abstract void k();

        public long l() {
            return this.c;
        }

        public long m() {
            return this.f;
        }

        public long n() {
            return this.e;
        }

        public long o() {
            return this.d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean p = p();
            if (aVar != null) {
                if (p) {
                    this.b.add(aVar);
                } else {
                    aVar.a();
                }
            }
            return p;
        }

        public c r() {
            return new c();
        }

        public void s(D d) {
        }

        public c t(A a2, D d) {
            return r().a(d);
        }

        public c u(A a2, D d, int i, List list) {
            return r().a(d);
        }

        public abstract void v();

        public void w(b bVar) {
            this.a = bVar;
        }
    }

    public class m implements l.b {
        public m() {
        }

        public void a(D d) {
            d.J(true);
            if (d.h != null && d.i == null) {
                d.h = null;
            }
            d.i = null;
            if (d.L() || RecyclerView.this.Z0(d.a) || !d.A()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d.a, false);
        }
    }

    public static abstract class n {
        public void f(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, A a) {
            f(rect, view.getLayoutParams().c(), recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, A a) {
            h(canvas, recyclerView);
        }

        public void j(Canvas canvas, RecyclerView recyclerView) {
        }

        public void k(Canvas canvas, RecyclerView recyclerView, A a) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class o {
        public androidx.recyclerview.widget.b a;
        public RecyclerView b;
        public final p.b c;
        public final p.b d;
        public androidx.recyclerview.widget.p e;
        public androidx.recyclerview.widget.p f;
        public z g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        public class a implements p.b {
            public a() {
            }

            public View a(int i) {
                return o.this.g0(i);
            }

            public int b(View view) {
                return o.this.o0(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int c() {
                return o.this.o();
            }

            public int d() {
                return o.this.I0() - o.this.k();
            }

            public int e(View view) {
                return o.this.r0(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
            }
        }

        public class b implements p.b {
            public b() {
            }

            public View a(int i) {
                return o.this.g0(i);
            }

            public int b(View view) {
                return o.this.s0(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
            }

            public int c() {
                return o.this.n();
            }

            public int d() {
                return o.this.u0() - o.this.b();
            }

            public int e(View view) {
                return o.this.m0(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }

        public interface c {
            void a(int i, int i2);
        }

        public static class d {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public o() {
            a aVar = new a();
            this.c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.e = new androidx.recyclerview.widget.p(aVar);
            this.f = new androidx.recyclerview.widget.p(bVar);
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = true;
        }

        public static d C0(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A0.d.f, i, i2);
            dVar.a = obtainStyledAttributes.getInt(A0.d.g, 1);
            dVar.b = obtainStyledAttributes.getInt(A0.d.q, 1);
            dVar.c = obtainStyledAttributes.getBoolean(A0.d.p, false);
            dVar.d = obtainStyledAttributes.getBoolean(A0.d.r, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int K(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        private static boolean S0(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public static int i0(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                        i2 = 0;
                        i4 = 0;
                    } else {
                        i4 = max;
                    }
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            i2 = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = max;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public void A(View view) {
            B(view, -1);
        }

        public int A0() {
            return L.G(this.b);
        }

        public void A1(int i) {
        }

        public void B(View view, int i) {
            C(view, i, false);
        }

        public int B0(View view) {
            return view.getLayoutParams().c();
        }

        public void B1(z zVar) {
            if (this.g == zVar) {
                this.g = null;
            }
        }

        public final void C(View view, int i, boolean z) {
            D j0 = RecyclerView.j0(view);
            if (z || j0.y()) {
                this.b.g.b(j0);
            } else {
                this.b.g.p(j0);
            }
            p layoutParams = view.getLayoutParams();
            if (j0.O() || j0.z()) {
                if (j0.z()) {
                    j0.N();
                } else {
                    j0.h();
                }
                this.a.c(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.b) {
                int m = this.a.m(view);
                if (i == -1) {
                    i = this.a.g();
                }
                if (m == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.Q());
                }
                if (m != i) {
                    this.b.n.X0(m, i);
                }
            } else {
                this.a.a(view, i, false);
                layoutParams.d = true;
                z zVar = this.g;
                if (zVar != null && zVar.h()) {
                    this.g.k(view);
                }
            }
            if (layoutParams.e) {
                j0.a.invalidate();
                layoutParams.e = false;
            }
        }

        public boolean C1(int i, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return D1(recyclerView.c, recyclerView.m0, i, bundle);
        }

        public void D(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int D0(View view) {
            return view.getLayoutParams().c.right;
        }

        public boolean D1(v vVar, A a2, int i, Bundle bundle) {
            int u0;
            int I0;
            int i2;
            int i3;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                u0 = recyclerView.canScrollVertically(1) ? (u0() - n()) - b() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    I0 = (I0() - o()) - k();
                    i2 = u0;
                    i3 = I0;
                }
                i2 = u0;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                u0 = recyclerView.canScrollVertically(-1) ? -((u0() - n()) - b()) : 0;
                if (this.b.canScrollHorizontally(-1)) {
                    I0 = -((I0() - o()) - k());
                    i2 = u0;
                    i3 = I0;
                }
                i2 = u0;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.b.t1(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void E(View view, int i) {
            F(view, i, (p) view.getLayoutParams());
        }

        public int E0(v vVar, A a2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.m == null || !I()) {
                return 1;
            }
            return this.b.m.n();
        }

        public boolean E1(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return F1(recyclerView.c, recyclerView.m0, view, i, bundle);
        }

        public void F(View view, int i, p pVar) {
            D j0 = RecyclerView.j0(view);
            if (j0.y()) {
                this.b.g.b(j0);
            } else {
                this.b.g.p(j0);
            }
            this.a.c(view, i, pVar, j0.y());
        }

        public int F0(v vVar, A a2) {
            return 0;
        }

        public boolean F1(v vVar, A a2, View view, int i, Bundle bundle) {
            return false;
        }

        public void G(View view, Rect rect) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.n0(view));
            }
        }

        public int G0(View view) {
            return view.getLayoutParams().c.top;
        }

        public void G1() {
            for (int h0 = h0() - 1; h0 >= 0; h0--) {
                this.a.q(h0);
            }
        }

        public abstract boolean H();

        public void H0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = view.getLayoutParams().c;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.b.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void H1(v vVar) {
            for (int h0 = h0() - 1; h0 >= 0; h0--) {
                if (!RecyclerView.j0(g0(h0)).M()) {
                    K1(h0, vVar);
                }
            }
        }

        public abstract boolean I();

        public int I0() {
            return this.q;
        }

        public void I1(v vVar) {
            int j = vVar.j();
            for (int i = j - 1; i >= 0; i--) {
                View n = vVar.n(i);
                D j0 = RecyclerView.j0(n);
                if (!j0.M()) {
                    j0.J(false);
                    if (j0.A()) {
                        this.b.removeDetachedView(n, false);
                    }
                    l lVar = this.b.N;
                    if (lVar != null) {
                        lVar.j(j0);
                    }
                    j0.J(true);
                    vVar.y(n);
                }
            }
            vVar.e();
            if (j > 0) {
                this.b.invalidate();
            }
        }

        public boolean J(p pVar) {
            return pVar != null;
        }

        public int J0() {
            return this.o;
        }

        public void J1(View view, v vVar) {
            M1(view);
            vVar.B(view);
        }

        public boolean K0() {
            int h0 = h0();
            for (int i = 0; i < h0; i++) {
                ViewGroup.LayoutParams layoutParams = g0(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void K1(int i, v vVar) {
            View g0 = g0(i);
            N1(i);
            vVar.B(g0);
        }

        public void L(int i, int i2, A a2, c cVar) {
        }

        public boolean L0() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public boolean L1(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void M(int i, c cVar) {
        }

        public boolean M0() {
            return this.i;
        }

        public void M1(View view) {
            this.a.p(view);
        }

        public int N(A a2) {
            return 0;
        }

        public boolean N0() {
            return this.j;
        }

        public void N1(int i) {
            if (g0(i) != null) {
                this.a.q(i);
            }
        }

        public int O(A a2) {
            return 0;
        }

        public final boolean O0(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int o = o();
            int n = n();
            int I0 = I0() - k();
            int u0 = u0() - b();
            Rect rect = this.b.j;
            n0(focusedChild, rect);
            return rect.left - i < I0 && rect.right - i > o && rect.top - i2 < u0 && rect.bottom - i2 > n;
        }

        public boolean O1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return P1(recyclerView, view, rect, z, false);
        }

        public int P(A a2) {
            return 0;
        }

        public final boolean P0() {
            return this.l;
        }

        public boolean P1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] j0 = j0(view, rect);
            int i = j0[0];
            int i2 = j0[1];
            if ((z2 && !O0(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.q1(i, i2);
            }
            return true;
        }

        public int Q(A a2) {
            return 0;
        }

        public boolean Q0(v vVar, A a2) {
            return false;
        }

        public void Q1() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int R(A a2) {
            return 0;
        }

        public boolean R0() {
            return this.k;
        }

        public void R1() {
            this.h = true;
        }

        public int S(A a2) {
            return 0;
        }

        public final void S1(v vVar, int i, View view) {
            D j0 = RecyclerView.j0(view);
            if (j0.M()) {
                return;
            }
            if (j0.w() && !j0.y() && !this.b.m.v()) {
                N1(i);
                vVar.C(j0);
            } else {
                V(i);
                vVar.D(view);
                this.b.g.k(j0);
            }
        }

        public void T(v vVar) {
            for (int h0 = h0() - 1; h0 >= 0; h0--) {
                S1(vVar, h0, g0(h0));
            }
        }

        public boolean T0() {
            z zVar = this.g;
            return zVar != null && zVar.h();
        }

        public abstract int T1(int i, v vVar, A a2);

        public void U(View view, v vVar) {
            S1(vVar, this.a.m(view), view);
        }

        public boolean U0(View view, boolean z, boolean z2) {
            boolean z3 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public abstract void U1(int i);

        public void V(int i) {
            W(i, g0(i));
        }

        public void V0(View view, int i, int i2, int i3, int i4) {
            p layoutParams = view.getLayoutParams();
            Rect rect = layoutParams.c;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public abstract int V1(int i, v vVar, A a2);

        public final void W(int i, View view) {
            this.a.d(i);
        }

        public void W0(View view, int i, int i2) {
            p pVar = (p) view.getLayoutParams();
            Rect n0 = this.b.n0(view);
            int i3 = i + n0.left + n0.right;
            int i4 = i2 + n0.top + n0.bottom;
            int i0 = i0(I0(), J0(), o() + k() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) pVar).width, H());
            int i02 = i0(u0(), v0(), n() + b() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).height, I());
            if (d2(view, i0, i02, pVar)) {
                view.measure(i0, i02);
            }
        }

        public void W1(RecyclerView recyclerView) {
            Y1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void X(RecyclerView recyclerView) {
            this.i = true;
            c1(recyclerView);
        }

        public void X0(int i, int i2) {
            View g0 = g0(i);
            if (g0 != null) {
                V(i);
                E(g0, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.b.toString());
            }
        }

        public final void X1(boolean z) {
            if (z != this.l) {
                this.l = z;
                this.m = 0;
                RecyclerView recyclerView = this.b;
                if (recyclerView != null) {
                    recyclerView.c.K();
                }
            }
        }

        public void Y(RecyclerView recyclerView, v vVar) {
            this.i = false;
            e1(recyclerView, vVar);
        }

        public void Y0(int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.D0(i);
            }
        }

        public void Y1(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.o = mode;
            if (mode == 0 && !RecyclerView.F0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.p = mode2;
            if (mode2 != 0 || RecyclerView.F0) {
                return;
            }
            this.r = 0;
        }

        public View Z(View view) {
            View T;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (T = recyclerView.T(view)) == null || this.a.n(T)) {
                return null;
            }
            return T;
        }

        public void Z0(int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.E0(i);
            }
        }

        public void Z1(int i, int i2) {
            RecyclerView.f(this.b, i, i2);
        }

        public View a0(int i) {
            int h0 = h0();
            for (int i2 = 0; i2 < h0; i2++) {
                View g0 = g0(i2);
                D j0 = RecyclerView.j0(g0);
                if (j0 != null && j0.p() == i && !j0.M() && (this.b.m0.h() || !j0.y())) {
                    return g0;
                }
            }
            return null;
        }

        public void a1(g gVar, g gVar2) {
        }

        public void a2(Rect rect, int i, int i2) {
            Z1(K(i, rect.width() + o() + k(), A0()), K(i2, rect.height() + n() + b(), z0()));
        }

        public int b() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract p b0();

        public boolean b1(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
            return false;
        }

        public void b2(int i, int i2) {
            int h0 = h0();
            if (h0 == 0) {
                this.b.x(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < h0; i7++) {
                View g0 = g0(i7);
                Rect rect = this.b.j;
                n0(g0, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.b.j.set(i5, i6, i3, i4);
            a2(this.b.j, i, i2);
        }

        public int c() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return L.I(recyclerView);
            }
            return 0;
        }

        public p c0(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void c1(RecyclerView recyclerView) {
        }

        public void c2(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                height = 0;
                this.q = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.f;
                this.q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.r = height;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public p d0(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public void d1(RecyclerView recyclerView) {
        }

        public boolean d2(View view, int i, int i2, p pVar) {
            return (!view.isLayoutRequested() && this.k && S0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && S0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int e0() {
            return -1;
        }

        public void e1(RecyclerView recyclerView, v vVar) {
            d1(recyclerView);
        }

        public boolean e2() {
            return false;
        }

        public int f0(View view) {
            return view.getLayoutParams().c.bottom;
        }

        public View f1(View view, int i, v vVar, A a2) {
            return null;
        }

        public boolean f2(View view, int i, int i2, p pVar) {
            return (this.k && S0(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && S0(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View g0(int i) {
            androidx.recyclerview.widget.b bVar = this.a;
            if (bVar != null) {
                return bVar.f(i);
            }
            return null;
        }

        public void g1(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            h1(recyclerView.c, recyclerView.m0, accessibilityEvent);
        }

        public abstract void g2(RecyclerView recyclerView, A a2, int i);

        public int h0() {
            androidx.recyclerview.widget.b bVar = this.a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public void h1(v vVar, A a2, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.b.m;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.n());
            }
        }

        public void h2(z zVar) {
            z zVar2 = this.g;
            if (zVar2 != null && zVar != zVar2 && zVar2.h()) {
                this.g.r();
            }
            this.g = zVar;
            zVar.q(this.b, this);
        }

        public void i1(Q.C c2) {
            RecyclerView recyclerView = this.b;
            j1(recyclerView.c, recyclerView.m0, c2);
        }

        public void i2() {
            z zVar = this.g;
            if (zVar != null) {
                zVar.r();
            }
        }

        public final int[] j0(View view, Rect rect) {
            int o = o();
            int n = n();
            int I0 = I0() - k();
            int u0 = u0() - b();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - o;
            int min = Math.min(0, i);
            int i2 = top - n;
            int min2 = Math.min(0, i2);
            int i3 = width - I0;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - u0);
            if (x0() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            return new int[]{max, min2};
        }

        public void j1(v vVar, A a2, Q.C c2) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                c2.a(8192);
                c2.q0(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                c2.a(4096);
                c2.q0(true);
            }
            c2.Z(C.b.a(E0(vVar, a2), l0(vVar, a2), Q0(vVar, a2), F0(vVar, a2)));
        }

        public boolean j2() {
            return false;
        }

        public int k() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public boolean k0() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.h;
        }

        public void k1(View view, Q.C c2) {
            D j0 = RecyclerView.j0(view);
            if (j0 == null || j0.y() || this.a.n(j0.a)) {
                return;
            }
            RecyclerView recyclerView = this.b;
            l1(recyclerView.c, recyclerView.m0, view, c2);
        }

        public int l0(v vVar, A a2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.m == null || !H()) {
                return 1;
            }
            return this.b.m.n();
        }

        public void l1(v vVar, A a2, View view, Q.C c2) {
            c2.a0(C.c.a(I() ? B0(view) : 0, 1, H() ? B0(view) : 0, 1, false, false));
        }

        public int m0(View view) {
            return view.getBottom() + f0(view);
        }

        public View m1(View view, int i) {
            return null;
        }

        public int n() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void n0(View view, Rect rect) {
            RecyclerView.k0(view, rect);
        }

        public void n1(RecyclerView recyclerView, int i, int i2) {
        }

        public int o() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int o0(View view) {
            return view.getLeft() - y0(view);
        }

        public void o1(RecyclerView recyclerView) {
        }

        public int p0(View view) {
            Rect rect = view.getLayoutParams().c;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void p1(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int q0(View view) {
            Rect rect = view.getLayoutParams().c;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void q1(RecyclerView recyclerView, int i, int i2) {
        }

        public int r0(View view) {
            return view.getRight() + D0(view);
        }

        public void r1(RecyclerView recyclerView, int i, int i2) {
        }

        public int s0(View view) {
            return view.getTop() - G0(view);
        }

        public void s1(RecyclerView recyclerView, int i, int i2, Object obj) {
            r1(recyclerView, i, i2);
        }

        public View t0() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public abstract void t1(v vVar, A a2);

        public int u0() {
            return this.r;
        }

        public void u1(A a2) {
        }

        public int v0() {
            return this.p;
        }

        public void v1(v vVar, A a2, int i, int i2) {
            this.b.x(i, i2);
        }

        public int w() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return L.J(recyclerView);
            }
            return 0;
        }

        public int w0() {
            RecyclerView recyclerView = this.b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.n();
            }
            return 0;
        }

        public boolean w1(RecyclerView recyclerView, View view, View view2) {
            return T0() || recyclerView.y0();
        }

        public int x0() {
            return L.E(this.b);
        }

        public boolean x1(RecyclerView recyclerView, A a2, View view, View view2) {
            return w1(recyclerView, view, view2);
        }

        public void y(View view) {
            z(view, -1);
        }

        public int y0(View view) {
            return view.getLayoutParams().c.left;
        }

        public abstract void y1(Parcelable parcelable);

        public void z(View view, int i) {
            C(view, i, true);
        }

        public int z0() {
            return L.F(this.b);
        }

        public abstract Parcelable z1();
    }

    public static class p extends ViewGroup.MarginLayoutParams {
        public D a;
        public final Rect c;
        public boolean d;
        public boolean e;

        public p(int i, int i2) {
            super(i, i2);
            this.c = new Rect();
            this.d = true;
            this.e = false;
        }

        public int a() {
            return this.a.m();
        }

        public int c() {
            return this.a.p();
        }

        public boolean d() {
            return this.a.B();
        }

        public boolean e() {
            return this.a.y();
        }

        public boolean f() {
            return this.a.w();
        }

        public boolean g() {
            return this.a.C();
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = new Rect();
            this.d = true;
            this.e = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.c = new Rect();
            this.d = true;
            this.e = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.c = new Rect();
            this.d = true;
            this.e = false;
        }

        public p(p pVar) {
            super(pVar);
            this.c = new Rect();
            this.d = true;
            this.e = false;
        }
    }

    public interface q {
        void b(View view);

        void d(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i, int i2);
    }

    public interface s {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class u {
        public SparseArray a = new SparseArray();
        public int b = 0;

        public static class a {
            public final ArrayList a = new ArrayList();
            public int b = 5;
            public long c = 0;
            public long d = 0;
        }

        public void a() {
            this.b++;
        }

        public void b() {
            for (int i = 0; i < this.a.size(); i++) {
                ((a) this.a.valueAt(i)).a.clear();
            }
        }

        public void c() {
            this.b--;
        }

        public void d(int i, long j) {
            a g = g(i);
            g.d = j(g.d, j);
        }

        public void e(int i, long j) {
            a g = g(i);
            g.c = j(g.c, j);
        }

        public D f(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((D) arrayList.get(size)).u()) {
                    return (D) arrayList.remove(size);
                }
            }
            return null;
        }

        public final a g(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }

        public void h(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(D d) {
            int o = d.o();
            ArrayList arrayList = g(o).a;
            if (((a) this.a.get(o)).b <= arrayList.size()) {
                return;
            }
            d.G();
            arrayList.add(d);
        }

        public long j(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void k(int i, int i2) {
            a g = g(i);
            g.b = i2;
            ArrayList arrayList = g.a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public boolean l(int i, long j, long j2) {
            long j3 = g(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        public boolean m(int i, long j, long j2) {
            long j3 = g(i).c;
            return j3 == 0 || j + j3 < j2;
        }
    }

    public final class v {
        public final ArrayList a;
        public ArrayList b;
        public final ArrayList c;
        public final List d;
        public int e;
        public int f;
        public u g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            this.b = null;
            this.c = new ArrayList();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        public void A(int i) {
            a((D) this.c.get(i), true);
            this.c.remove(i);
        }

        public void B(View view) {
            D j0 = RecyclerView.j0(view);
            if (j0.A()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (j0.z()) {
                j0.N();
            } else if (j0.O()) {
                j0.h();
            }
            C(j0);
            if (RecyclerView.this.N == null || j0.x()) {
                return;
            }
            RecyclerView.this.N.j(j0);
        }

        public void C(D d) {
            boolean z;
            boolean z2 = true;
            if (d.z() || d.a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d.z());
                sb.append(" isAttached:");
                sb.append(d.a.getParent() != null);
                sb.append(RecyclerView.this.Q());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d.A()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d + RecyclerView.this.Q());
            }
            if (d.M()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.Q());
            }
            boolean k = d.k();
            g gVar = RecyclerView.this.m;
            if ((gVar != null && k && gVar.T(d)) || d.x()) {
                if (this.f <= 0 || d.s(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.H0 && size > 0 && !RecyclerView.this.l0.d(d.c)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.l0.d(((D) this.c.get(i)).c)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, d);
                    z = true;
                }
                if (z) {
                    r1 = z;
                    z2 = false;
                } else {
                    a(d, true);
                    r1 = z;
                }
            } else {
                z2 = false;
            }
            RecyclerView.this.g.q(d);
            if (r1 || z2 || !k) {
                return;
            }
            d.r = null;
        }

        public void D(View view) {
            ArrayList arrayList;
            D j0 = RecyclerView.j0(view);
            if (!j0.s(12) && j0.B() && !RecyclerView.this.q(j0)) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                j0.K(this, true);
                arrayList = this.b;
            } else {
                if (j0.w() && !j0.y() && !RecyclerView.this.m.v()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.Q());
                }
                j0.K(this, false);
                arrayList = this.a;
            }
            arrayList.add(j0);
        }

        public void E(u uVar) {
            u uVar2 = this.g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.g.a();
        }

        public void F(B b) {
        }

        public void G(int i) {
            this.e = i;
            K();
        }

        public final boolean H(D d, int i, int i2, long j) {
            d.r = RecyclerView.this;
            int o = d.o();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.g.l(o, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.m.k(d, i);
            this.g.d(d.o(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d);
            if (!RecyclerView.this.m0.h()) {
                return true;
            }
            d.g = i2;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01cd A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01d0  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x00f5 A[PHI: r1 r4
          0x00f5: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$D) = (r1v11 androidx.recyclerview.widget.RecyclerView$D), (r1v30 androidx.recyclerview.widget.RecyclerView$D) binds: [B:25:0x005d, B:42:0x00ad] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:25:0x005d, B:42:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.RecyclerView.D I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 524
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$D");
        }

        public void J(D d) {
            (d.o ? this.b : this.a).remove(d);
            d.n = null;
            d.o = false;
            d.h();
        }

        public void K() {
            o oVar = RecyclerView.this.n;
            this.f = this.e + (oVar != null ? oVar.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                A(size);
            }
        }

        public boolean L(D d) {
            if (d.y()) {
                return RecyclerView.this.m0.h();
            }
            int i = d.c;
            if (i >= 0 && i < RecyclerView.this.m.n()) {
                if (RecyclerView.this.m0.h() || RecyclerView.this.m.p(d.c) == d.o()) {
                    return !RecyclerView.this.m.v() || d.n() == RecyclerView.this.m.o(d.c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d + RecyclerView.this.Q());
        }

        public void M(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                D d = (D) this.c.get(size);
                if (d != null && (i3 = d.c) >= i && i3 < i4) {
                    d.e(2);
                    A(size);
                }
            }
        }

        public void a(D d, boolean z) {
            RecyclerView.s(d);
            View view = d.a;
            androidx.recyclerview.widget.l lVar = RecyclerView.this.t0;
            if (lVar != null) {
                P.a n = lVar.n();
                L.s0(view, n instanceof l.a ? ((l.a) n).n(view) : null);
            }
            if (z) {
                g(d);
            }
            d.r = null;
            i().i(d);
        }

        public final void b(D d) {
            if (RecyclerView.this.x0()) {
                View view = d.a;
                if (L.C(view) == 0) {
                    L.C0(view, 1);
                }
                androidx.recyclerview.widget.l lVar = RecyclerView.this.t0;
                if (lVar == null) {
                    return;
                }
                P.a n = lVar.n();
                if (n instanceof l.a) {
                    ((l.a) n).o(view);
                }
                L.s0(view, n);
            }
        }

        public void c() {
            this.a.clear();
            z();
        }

        public void d() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((D) this.c.get(i)).f();
            }
            int size2 = this.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((D) this.a.get(i2)).f();
            }
            ArrayList arrayList = this.b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((D) this.b.get(i3)).f();
                }
            }
        }

        public void e() {
            this.a.clear();
            ArrayList arrayList = this.b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i) {
            if (i >= 0 && i < RecyclerView.this.m0.c()) {
                return !RecyclerView.this.m0.h() ? i : RecyclerView.this.e.m(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.m0.c() + RecyclerView.this.Q());
        }

        public void g(D d) {
            w wVar = RecyclerView.this.o;
            if (wVar != null) {
                wVar.a(d);
            }
            g gVar = RecyclerView.this.m;
            if (gVar != null) {
                gVar.Z(d);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.m0 != null) {
                recyclerView.g.q(d);
            }
        }

        public D h(int i) {
            int size;
            int m;
            ArrayList arrayList = this.b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    D d = (D) this.b.get(i2);
                    if (!d.O() && d.p() == i) {
                        d.e(32);
                        return d;
                    }
                }
                if (RecyclerView.this.m.v() && (m = RecyclerView.this.e.m(i)) > 0 && m < RecyclerView.this.m.n()) {
                    long o = RecyclerView.this.m.o(m);
                    for (int i3 = 0; i3 < size; i3++) {
                        D d2 = (D) this.b.get(i3);
                        if (!d2.O() && d2.n() == o) {
                            d2.e(32);
                            return d2;
                        }
                    }
                }
            }
            return null;
        }

        public u i() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }

        public int j() {
            return this.a.size();
        }

        public List k() {
            return this.d;
        }

        public D l(long j, int i, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                D d = (D) this.a.get(size);
                if (d.n() == j && !d.O()) {
                    if (i == d.o()) {
                        d.e(32);
                        if (d.y() && !RecyclerView.this.m0.h()) {
                            d.I(2, 14);
                        }
                        return d;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(d.a, false);
                        y(d.a);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                D d2 = (D) this.c.get(size2);
                if (d2.n() == j && !d2.u()) {
                    if (i == d2.o()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return d2;
                    }
                    if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        public D m(int i, boolean z) {
            View e;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                D d = (D) this.a.get(i2);
                if (!d.O() && d.p() == i && !d.w() && (RecyclerView.this.m0.h || !d.y())) {
                    d.e(32);
                    return d;
                }
            }
            if (z || (e = RecyclerView.this.f.e(i)) == null) {
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    D d2 = (D) this.c.get(i3);
                    if (!d2.w() && d2.p() == i && !d2.u()) {
                        if (!z) {
                            this.c.remove(i3);
                        }
                        return d2;
                    }
                }
                return null;
            }
            D j0 = RecyclerView.j0(e);
            RecyclerView.this.f.s(e);
            int m = RecyclerView.this.f.m(e);
            if (m != -1) {
                RecyclerView.this.f.d(m);
                D(e);
                j0.e(8224);
                return j0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + j0 + RecyclerView.this.Q());
        }

        public View n(int i) {
            return ((D) this.a.get(i)).a;
        }

        public View o(int i) {
            return p(i, false);
        }

        public View p(int i, boolean z) {
            return I(i, z, Long.MAX_VALUE).a;
        }

        public final void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void r(D d) {
            View view = d.a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                p layoutParams = ((D) this.c.get(i)).a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.d = true;
                }
            }
        }

        public void t() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                D d = (D) this.c.get(i);
                if (d != null) {
                    d.e(6);
                    d.d(null);
                }
            }
            g gVar = RecyclerView.this.m;
            if (gVar == null || !gVar.v()) {
                z();
            }
        }

        public void u(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                D d = (D) this.c.get(i3);
                if (d != null && d.c >= i) {
                    d.D(i2, true);
                }
            }
        }

        public void v(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                D d = (D) this.c.get(i7);
                if (d != null && (i6 = d.c) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        d.D(i2 - i, false);
                    } else {
                        d.D(i3, false);
                    }
                }
            }
        }

        public void w(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                D d = (D) this.c.get(size);
                if (d != null) {
                    int i4 = d.c;
                    if (i4 >= i3) {
                        d.D(-i2, z);
                    } else if (i4 >= i) {
                        d.e(8);
                        A(size);
                    }
                }
            }
        }

        public void x(g gVar, g gVar2, boolean z) {
            c();
            i().h(gVar, gVar2, z);
        }

        public void y(View view) {
            D j0 = RecyclerView.j0(view);
            j0.n = null;
            j0.o = false;
            j0.h();
            C(j0);
        }

        public void z() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.c.clear();
            if (RecyclerView.H0) {
                RecyclerView.this.l0.b();
            }
        }
    }

    public interface w {
        void a(D d);
    }

    public class x extends i {
        public x() {
        }

        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.m0.g = true;
            recyclerView.T0(true);
            if (RecyclerView.this.e.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        public void c(int i, int i2, Object obj) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.e.r(i, i2, obj)) {
                f();
            }
        }

        public void d(int i, int i2, int i3) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.e.s(i, i2, i3)) {
                f();
            }
        }

        public void e(int i, int i2) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.e.t(i, i2)) {
                f();
            }
        }

        public void f() {
            if (RecyclerView.G0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.t && recyclerView.s) {
                    L.k0(recyclerView, recyclerView.i);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    public static class y extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public Parcelable d;

        public static class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public y[] newArray(int i) {
                return new y[i];
            }
        }

        public y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public void c(y yVar) {
            this.d = yVar.d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.d, 0);
        }

        public y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static abstract class z {
        public RecyclerView b;
        public o c;
        public boolean d;
        public boolean e;
        public View f;
        public boolean h;
        public int a = -1;
        public final a g = new a(0, 0);

        public static class a {
            public int a;
            public int b;
            public int c;
            public int d;
            public Interpolator e;
            public boolean f;
            public int g;

            public a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public boolean a() {
                return this.d >= 0;
            }

            public void b(int i) {
                this.d = i;
            }

            public void c(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.A0(i);
                    this.f = false;
                } else {
                    if (!this.f) {
                        this.g = 0;
                        return;
                    }
                    e();
                    recyclerView.j0.f(this.a, this.b, this.c, this.e);
                    int i2 = this.g + 1;
                    this.g = i2;
                    if (i2 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                }
            }

            public void d(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }

            public final void e() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
            }
        }

        public interface b {
            PointF e(int i);
        }

        public PointF a(int i) {
            Object e = e();
            if (e instanceof b) {
                return ((b) e).e(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i) {
            return this.b.n.a0(i);
        }

        public int c() {
            return this.b.n.h0();
        }

        public int d(View view) {
            return this.b.h0(view);
        }

        public o e() {
            return this.c;
        }

        public int f() {
            return this.a;
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        public void i(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void j(int i, int i2) {
            PointF a2;
            RecyclerView recyclerView = this.b;
            if (this.a == -1 || recyclerView == null) {
                r();
            }
            if (this.d && this.f == null && this.c != null && (a2 = a(this.a)) != null) {
                float f = a2.x;
                if (f != 0.0f || a2.y != 0.0f) {
                    recyclerView.l1((int) Math.signum(f), (int) Math.signum(a2.y), null);
                }
            }
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (d(view) == this.a) {
                    o(this.f, recyclerView.m0, this.g);
                    this.g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                l(i, i2, recyclerView.m0, this.g);
                boolean a3 = this.g.a();
                this.g.c(recyclerView);
                if (a3 && this.e) {
                    this.d = true;
                    recyclerView.j0.e();
                }
            }
        }

        public void k(View view) {
            if (d(view) == f()) {
                this.f = view;
            }
        }

        public abstract void l(int i, int i2, A a2, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, A a2, a aVar);

        public void p(int i) {
            this.a = i;
        }

        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.j0.g();
            if (this.h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.b = recyclerView;
            this.c = oVar;
            int i = this.a;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.m0.a = i;
            this.e = true;
            this.d = true;
            this.f = b(f());
            m();
            this.b.j0.e();
            this.h = true;
        }

        public final void r() {
            if (this.e) {
                this.e = false;
                n();
                this.b.m0.a = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.B1(this);
                this.c = null;
                this.b = null;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        E0 = false;
        F0 = i2 >= 23;
        G0 = true;
        H0 = true;
        I0 = false;
        J0 = false;
        Class cls = Integer.TYPE;
        K0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        L0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A0.a.a);
    }

    public static RecyclerView X(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView X = X(viewGroup.getChildAt(i2));
            if (X != null) {
                return X;
            }
        }
        return null;
    }

    public static /* synthetic */ void c(RecyclerView recyclerView, View view, int i2, ViewGroup.LayoutParams layoutParams) {
        recyclerView.attachViewToParent(view, i2, layoutParams);
    }

    public static /* synthetic */ void d(RecyclerView recyclerView, int i2) {
        recyclerView.detachViewFromParent(i2);
    }

    public static /* synthetic */ boolean e(RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }

    public static /* synthetic */ void f(RecyclerView recyclerView, int i2, int i3) {
        recyclerView.setMeasuredDimension(i2, i3);
    }

    private P.A getScrollingChildHelper() {
        if (this.w0 == null) {
            this.w0 = new P.A(this);
        }
        return this.w0;
    }

    public static D j0(View view) {
        if (view == null) {
            return null;
        }
        return view.getLayoutParams().a;
    }

    public static void k0(View view, Rect rect) {
        p layoutParams = view.getLayoutParams();
        Rect rect2 = layoutParams.c;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    public static void s(D d2) {
        WeakReference weakReference = d2.b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == d2.a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                d2.b = null;
                return;
            }
        }
    }

    public void A(View view) {
        D j0 = j0(view);
        J0(view);
        g gVar = this.m;
        if (gVar != null && j0 != null) {
            gVar.Y(j0);
        }
        List list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.D.get(size)).b(view);
            }
        }
    }

    public void A0(int i2) {
        if (this.n == null) {
            return;
        }
        setScrollState(2);
        this.n.U1(i2);
        awakenScrollBars();
    }

    public final void A1() {
        this.j0.g();
        o oVar = this.n;
        if (oVar != null) {
            oVar.i2();
        }
    }

    public final void B() {
        int i2 = this.A;
        this.A = 0;
        if (i2 == 0 || !x0()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        Q.b.b(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    public void B0() {
        int j2 = this.f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            this.f.i(i2).getLayoutParams().d = true;
        }
        this.c.s();
    }

    public void B1(int i2, int i3, Object obj) {
        int i4;
        int j2 = this.f.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < j2; i6++) {
            View i7 = this.f.i(i6);
            D j0 = j0(i7);
            if (j0 != null && !j0.M() && (i4 = j0.c) >= i2 && i4 < i5) {
                j0.e(2);
                j0.d(obj);
                i7.getLayoutParams().d = true;
            }
        }
        this.c.M(i2, i3);
    }

    public void C() {
        String str;
        if (this.m == null) {
            str = "No adapter attached; skipping layout";
        } else {
            if (this.n != null) {
                A a2 = this.m0;
                a2.j = false;
                if (a2.e != 1) {
                    if (!this.e.q() && this.n.I0() == getWidth() && this.n.u0() == getHeight()) {
                        this.n.W1(this);
                    }
                    F();
                    return;
                }
                D();
                this.n.W1(this);
                E();
                F();
                return;
            }
            str = "No layout manager attached; skipping layout";
        }
        Log.e("RecyclerView", str);
    }

    public void C0() {
        int j2 = this.f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            D j0 = j0(this.f.i(i2));
            if (j0 != null && !j0.M()) {
                j0.e(6);
            }
        }
        B0();
        this.c.t();
    }

    public final void D() {
        this.m0.a(1);
        R(this.m0);
        this.m0.j = false;
        v1();
        this.g.f();
        K0();
        S0();
        i1();
        A a2 = this.m0;
        a2.i = a2.k && this.q0;
        this.q0 = false;
        this.p0 = false;
        a2.h = a2.l;
        a2.f = this.m.n();
        W(this.v0);
        if (this.m0.k) {
            int g2 = this.f.g();
            for (int i2 = 0; i2 < g2; i2++) {
                D j0 = j0(this.f.f(i2));
                if (!j0.M() && (!j0.w() || this.m.v())) {
                    this.g.e(j0, this.N.u(this.m0, j0, l.e(j0), j0.r()));
                    if (this.m0.i && j0.B() && !j0.y() && !j0.M() && !j0.w()) {
                        this.g.c(f0(j0), j0);
                    }
                }
            }
        }
        if (this.m0.l) {
            j1();
            A a3 = this.m0;
            boolean z2 = a3.g;
            a3.g = false;
            this.n.t1(this.c, a3);
            this.m0.g = z2;
            for (int i3 = 0; i3 < this.f.g(); i3++) {
                D j02 = j0(this.f.f(i3));
                if (!j02.M() && !this.g.i(j02)) {
                    int e2 = l.e(j02);
                    boolean s2 = j02.s(8192);
                    if (!s2) {
                        e2 |= 4096;
                    }
                    l.c u2 = this.N.u(this.m0, j02, e2, j02.r());
                    if (s2) {
                        V0(j02, u2);
                    } else {
                        this.g.a(j02, u2);
                    }
                }
            }
        }
        t();
        L0();
        x1(false);
        this.m0.e = 2;
    }

    public void D0(int i2) {
        int g2 = this.f.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.f.f(i3).offsetLeftAndRight(i2);
        }
    }

    public final void E() {
        v1();
        K0();
        this.m0.a(6);
        this.e.j();
        this.m0.f = this.m.n();
        A a2 = this.m0;
        a2.d = 0;
        a2.h = false;
        this.n.t1(this.c, a2);
        A a3 = this.m0;
        a3.g = false;
        this.d = null;
        a3.k = a3.k && this.N != null;
        a3.e = 4;
        L0();
        x1(false);
    }

    public void E0(int i2) {
        int g2 = this.f.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.f.f(i3).offsetTopAndBottom(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F() {
        /*
            r11 = this;
            androidx.recyclerview.widget.RecyclerView$A r0 = r11.m0
            r1 = 4
            r0.a(r1)
            r11.v1()
            r11.K0()
            androidx.recyclerview.widget.RecyclerView$A r0 = r11.m0
            r1 = 1
            r0.e = r1
            boolean r0 = r0.k
            if (r0 == 0) goto L88
            androidx.recyclerview.widget.b r0 = r11.f
            int r0 = r0.g()
            int r0 = r0 - r1
        L1c:
            if (r0 < 0) goto L81
            androidx.recyclerview.widget.b r2 = r11.f
            android.view.View r2 = r2.f(r0)
            androidx.recyclerview.widget.RecyclerView$D r5 = j0(r2)
            boolean r2 = r5.M()
            if (r2 == 0) goto L2f
            goto L7e
        L2f:
            long r2 = r11.f0(r5)
            androidx.recyclerview.widget.RecyclerView$l r4 = r11.N
            androidx.recyclerview.widget.RecyclerView$A r6 = r11.m0
            androidx.recyclerview.widget.RecyclerView$l$c r4 = r4.t(r6, r5)
            androidx.recyclerview.widget.q r6 = r11.g
            androidx.recyclerview.widget.RecyclerView$D r6 = r6.g(r2)
            if (r6 == 0) goto L79
            boolean r7 = r6.M()
            if (r7 != 0) goto L79
            androidx.recyclerview.widget.q r7 = r11.g
            boolean r8 = r7.h(r6)
            androidx.recyclerview.widget.q r7 = r11.g
            boolean r9 = r7.h(r5)
            if (r8 == 0) goto L5a
            if (r6 != r5) goto L5a
            goto L79
        L5a:
            androidx.recyclerview.widget.q r7 = r11.g
            androidx.recyclerview.widget.RecyclerView$l$c r7 = r7.n(r6)
            androidx.recyclerview.widget.q r10 = r11.g
            r10.d(r5, r4)
            androidx.recyclerview.widget.q r4 = r11.g
            androidx.recyclerview.widget.RecyclerView$l$c r10 = r4.m(r5)
            if (r7 != 0) goto L71
            r11.o0(r2, r5, r6)
            goto L7e
        L71:
            r3 = r11
            r4 = r6
            r6 = r7
            r7 = r10
            r3.n(r4, r5, r6, r7, r8, r9)
            goto L7e
        L79:
            androidx.recyclerview.widget.q r2 = r11.g
            r2.d(r5, r4)
        L7e:
            int r0 = r0 + (-1)
            goto L1c
        L81:
            androidx.recyclerview.widget.q r0 = r11.g
            androidx.recyclerview.widget.q$b r2 = r11.C0
            r0.o(r2)
        L88:
            androidx.recyclerview.widget.RecyclerView$o r0 = r11.n
            androidx.recyclerview.widget.RecyclerView$v r2 = r11.c
            r0.I1(r2)
            androidx.recyclerview.widget.RecyclerView$A r0 = r11.m0
            int r2 = r0.f
            r0.c = r2
            r2 = 0
            r11.E = r2
            r11.F = r2
            r0.k = r2
            r0.l = r2
            androidx.recyclerview.widget.RecyclerView$o r0 = r11.n
            r0.h = r2
            androidx.recyclerview.widget.RecyclerView$v r0 = r11.c
            java.util.ArrayList r0 = r0.b
            if (r0 == 0) goto Lab
            r0.clear()
        Lab:
            androidx.recyclerview.widget.RecyclerView$o r0 = r11.n
            boolean r3 = r0.n
            if (r3 == 0) goto Lba
            r0.m = r2
            r0.n = r2
            androidx.recyclerview.widget.RecyclerView$v r0 = r11.c
            r0.K()
        Lba:
            androidx.recyclerview.widget.RecyclerView$o r0 = r11.n
            androidx.recyclerview.widget.RecyclerView$A r3 = r11.m0
            r0.u1(r3)
            r11.L0()
            r11.x1(r2)
            androidx.recyclerview.widget.q r0 = r11.g
            r0.f()
            int[] r0 = r11.v0
            r3 = r0[r2]
            r0 = r0[r1]
            boolean r0 = r11.y(r3, r0)
            if (r0 == 0) goto Ldb
            r11.J(r2, r2)
        Ldb:
            r11.W0()
            r11.g1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.F():void");
    }

    public void F0(int i2, int i3) {
        int j2 = this.f.j();
        for (int i4 = 0; i4 < j2; i4++) {
            D j0 = j0(this.f.i(i4));
            if (j0 != null && !j0.M() && j0.c >= i2) {
                j0.D(i3, false);
                this.m0.g = true;
            }
        }
        this.c.u(i2, i3);
        requestLayout();
    }

    public boolean G(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public void G0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int j2 = this.f.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < j2; i8++) {
            D j0 = j0(this.f.i(i8));
            if (j0 != null && (i7 = j0.c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    j0.D(i3 - i2, false);
                } else {
                    j0.D(i6, false);
                }
                this.m0.g = true;
            }
        }
        this.c.v(i2, i3);
        requestLayout();
    }

    public final void H(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void H0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int j2 = this.f.j();
        for (int i5 = 0; i5 < j2; i5++) {
            D j0 = j0(this.f.i(i5));
            if (j0 != null && !j0.M()) {
                int i6 = j0.c;
                if (i6 >= i4) {
                    j0.D(-i3, z2);
                } else if (i6 >= i2) {
                    j0.l(i2 - 1, -i3, z2);
                }
                this.m0.g = true;
            }
        }
        this.c.w(i2, i3, z2);
        requestLayout();
    }

    public void I(int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.A1(i2);
        }
        O0(i2);
        t tVar = this.n0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List list = this.o0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.o0.get(size)).a(this, i2);
            }
        }
    }

    public void I0(View view) {
    }

    public void J(int i2, int i3) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        P0(i2, i3);
        t tVar = this.n0;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List list = this.o0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.o0.get(size)).b(this, i2, i3);
            }
        }
        this.H--;
    }

    public void J0(View view) {
    }

    public void K() {
        int i2;
        for (int size = this.A0.size() - 1; size >= 0; size--) {
            D d2 = (D) this.A0.get(size);
            if (d2.a.getParent() == this && !d2.M() && (i2 = d2.q) != -1) {
                L.C0(d2.a, i2);
                d2.q = -1;
            }
        }
        this.A0.clear();
    }

    public void K0() {
        this.G++;
    }

    public final boolean L(MotionEvent motionEvent) {
        s sVar = this.r;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return V(motionEvent);
        }
        sVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.r = null;
        }
        return true;
    }

    public void L0() {
        M0(true);
    }

    public void M() {
        int measuredWidth;
        int measuredHeight;
        if (this.M != null) {
            return;
        }
        EdgeEffect a2 = this.I.a(this, 3);
        this.M = a2;
        if (this.h) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a2.setSize(measuredWidth, measuredHeight);
    }

    public void M0(boolean z2) {
        int i2 = this.G - 1;
        this.G = i2;
        if (i2 < 1) {
            this.G = 0;
            if (z2) {
                B();
                K();
            }
        }
    }

    public void N() {
        int measuredHeight;
        int measuredWidth;
        if (this.J != null) {
            return;
        }
        EdgeEffect a2 = this.I.a(this, 0);
        this.J = a2;
        if (this.h) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a2.setSize(measuredHeight, measuredWidth);
    }

    public final void N0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.U = y2;
            this.S = y2;
        }
    }

    public void O() {
        int measuredHeight;
        int measuredWidth;
        if (this.L != null) {
            return;
        }
        EdgeEffect a2 = this.I.a(this, 2);
        this.L = a2;
        if (this.h) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a2.setSize(measuredHeight, measuredWidth);
    }

    public void O0(int i2) {
    }

    public void P() {
        int measuredWidth;
        int measuredHeight;
        if (this.K != null) {
            return;
        }
        EdgeEffect a2 = this.I.a(this, 1);
        this.K = a2;
        if (this.h) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a2.setSize(measuredWidth, measuredHeight);
    }

    public void P0(int i2, int i3) {
    }

    public String Q() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    public void Q0() {
        if (this.s0 || !this.s) {
            return;
        }
        L.k0(this, this.B0);
        this.s0 = true;
    }

    public final void R(A a2) {
        if (getScrollState() != 2) {
            a2.p = 0;
            a2.q = 0;
        } else {
            OverScroller overScroller = this.j0.d;
            a2.p = overScroller.getFinalX() - overScroller.getCurrX();
            a2.q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public final boolean R0() {
        return this.N != null && this.n.j2();
    }

    public View S(float f2, float f3) {
        for (int g2 = this.f.g() - 1; g2 >= 0; g2--) {
            View f4 = this.f.f(g2);
            float translationX = f4.getTranslationX();
            float translationY = f4.getTranslationY();
            if (f2 >= f4.getLeft() + translationX && f2 <= f4.getRight() + translationX && f3 >= f4.getTop() + translationY && f3 <= f4.getBottom() + translationY) {
                return f4;
            }
        }
        return null;
    }

    public final void S0() {
        boolean z2;
        if (this.E) {
            this.e.x();
            if (this.F) {
                this.n.o1(this);
            }
        }
        if (R0()) {
            this.e.v();
        } else {
            this.e.j();
        }
        boolean z3 = this.p0 || this.q0;
        this.m0.k = this.v && this.N != null && ((z2 = this.E) || z3 || this.n.h) && (!z2 || this.m.v());
        A a2 = this.m0;
        a2.l = a2.k && z3 && !this.E && R0();
    }

    public View T(View view) {
        ViewParent parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void T0(boolean z2) {
        this.F = z2 | this.F;
        this.E = true;
        C0();
    }

    public D U(View view) {
        View T = T(view);
        if (T == null) {
            return null;
        }
        return i0(T);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void U0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.N()
            android.widget.EdgeEffect r3 = r6.J
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L1c:
            T.d.c(r3, r4, r9)
            r9 = 1
            goto L39
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L38
            r6.O()
            android.widget.EdgeEffect r3 = r6.L
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L53
            r6.P()
            android.widget.EdgeEffect r9 = r6.K
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            T.d.c(r9, r0, r7)
            goto L6f
        L53:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L6e
            r6.M()
            android.widget.EdgeEffect r9 = r6.M
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            T.d.c(r9, r3, r0)
            goto L6f
        L6e:
            r1 = r9
        L6f:
            if (r1 != 0) goto L79
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            P.L.j0(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.U0(float, float, float, float):void");
    }

    public final boolean V(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) this.q.get(i2);
            if (sVar.c(this, motionEvent) && action != 3) {
                this.r = sVar;
                return true;
            }
        }
        return false;
    }

    public void V0(D d2, l.c cVar) {
        d2.I(0, 8192);
        if (this.m0.i && d2.B() && !d2.y() && !d2.M()) {
            this.g.c(f0(d2), d2);
        }
        this.g.e(d2, cVar);
    }

    public final void W(int[] iArr) {
        int g2 = this.f.g();
        if (g2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < g2; i4++) {
            D j0 = j0(this.f.f(i4));
            if (!j0.M()) {
                int p2 = j0.p();
                if (p2 < i2) {
                    i2 = p2;
                }
                if (p2 > i3) {
                    i3 = p2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public final void W0() {
        View findViewById;
        if (!this.i0 || this.m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!J0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f.n(focusedChild)) {
                    return;
                }
            } else if (this.f.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        D a0 = (this.m0.n == -1 || !this.m.v()) ? null : a0(this.m0.n);
        if (a0 != null && !this.f.n(a0.a) && a0.a.hasFocusable()) {
            view = a0.a;
        } else if (this.f.g() > 0) {
            view = Y();
        }
        if (view != null) {
            int i2 = this.m0.o;
            if (i2 != -1 && (findViewById = view.findViewById(i2)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    public final void X0() {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.J.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            L.j0(this);
        }
    }

    public final View Y() {
        D Z;
        A a2 = this.m0;
        int i2 = a2.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int c2 = a2.c();
        for (int i3 = i2; i3 < c2; i3++) {
            D Z2 = Z(i3);
            if (Z2 == null) {
                break;
            }
            if (Z2.a.hasFocusable()) {
                return Z2.a;
            }
        }
        int min = Math.min(c2, i2);
        do {
            min--;
            if (min < 0 || (Z = Z(min)) == null) {
                return null;
            }
        } while (!Z.a.hasFocusable());
        return Z.a;
    }

    public void Y0() {
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.H1(this.c);
            this.n.I1(this.c);
        }
        this.c.c();
    }

    public D Z(int i2) {
        D d2 = null;
        if (this.E) {
            return null;
        }
        int j2 = this.f.j();
        for (int i3 = 0; i3 < j2; i3++) {
            D j0 = j0(this.f.i(i3));
            if (j0 != null && !j0.y() && e0(j0) == i2) {
                if (!this.f.n(j0.a)) {
                    return j0;
                }
                d2 = j0;
            }
        }
        return d2;
    }

    public boolean Z0(View view) {
        v1();
        boolean r2 = this.f.r(view);
        if (r2) {
            D j0 = j0(view);
            this.c.J(j0);
            this.c.C(j0);
        }
        x1(!r2);
        return r2;
    }

    public D a0(long j2) {
        g gVar = this.m;
        D d2 = null;
        if (gVar != null && gVar.v()) {
            int j3 = this.f.j();
            for (int i2 = 0; i2 < j3; i2++) {
                D j0 = j0(this.f.i(i2));
                if (j0 != null && !j0.y() && j0.n() == j2) {
                    if (!this.f.n(j0.a)) {
                        return j0;
                    }
                    d2 = j0;
                }
            }
        }
        return d2;
    }

    public void a1(n nVar) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.D("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(nVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        B0();
        requestLayout();
    }

    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        o oVar = this.n;
        if (oVar == null || !oVar.b1(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b(int i2, int i3) {
        if (i2 < 0) {
            N();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            O();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            P();
            if (this.K.isFinished()) {
                this.K.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            M();
            if (this.M.isFinished()) {
                this.M.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        L.j0(this);
    }

    public D b0(int i2) {
        return c0(i2, false);
    }

    public void b1(q qVar) {
        List list = this.D;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.recyclerview.widget.RecyclerView.D c0(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.f
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$D r3 = j0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.y()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.p()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.f
            android.view.View r4 = r3.a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c0(int, boolean):androidx.recyclerview.widget.RecyclerView$D");
    }

    public void c1(s sVar) {
        this.q.remove(sVar);
        if (this.r == sVar) {
            this.r = null;
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.n.J((p) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.H()) {
            return this.n.N(this.m0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.H()) {
            return this.n.O(this.m0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.H()) {
            return this.n.P(this.m0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.I()) {
            return this.n.Q(this.m0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.I()) {
            return this.n.R(this.m0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.I()) {
            return this.n.S(this.m0);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean d0(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.y) {
            return false;
        }
        int H = oVar.H();
        boolean I = this.n.I();
        if (H == 0 || Math.abs(i2) < this.e0) {
            i2 = 0;
        }
        if (!I || Math.abs(i3) < this.e0) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = H != 0 || I;
            dispatchNestedFling(f2, f3, z2);
            r rVar = this.W;
            if (rVar != null && rVar.a(i2, i3)) {
                return true;
            }
            if (z2) {
                if (I) {
                    H = (H == true ? 1 : 0) | 2;
                }
                w1(H, 1);
                int i4 = this.f0;
                int max = Math.max(-i4, Math.min(i2, i4));
                int i5 = this.f0;
                this.j0.c(max, Math.max(-i5, Math.min(i3, i5)));
                return true;
            }
        }
        return false;
    }

    public void d1(t tVar) {
        List list = this.o0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        float f2;
        int i2;
        super.draw(canvas);
        int size = this.p.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ((n) this.p.get(i3)).k(canvas, this, this.m0);
        }
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.L;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                f2 = (-getWidth()) + getPaddingRight();
                i2 = (-getHeight()) + getPaddingBottom();
            } else {
                f2 = -getWidth();
                i2 = -getHeight();
            }
            canvas.translate(f2, i2);
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if ((z2 || this.N == null || this.p.size() <= 0 || !this.N.p()) ? z2 : true) {
            L.j0(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public int e0(D d2) {
        if (d2.s(524) || !d2.v()) {
            return -1;
        }
        return this.e.e(d2.c);
    }

    public void e1() {
        D d2;
        int g2 = this.f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            View f2 = this.f.f(i2);
            D i0 = i0(f2);
            if (i0 != null && (d2 = i0.i) != null) {
                View view = d2.a;
                int left = f2.getLeft();
                int top = f2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public long f0(D d2) {
        return this.m.v() ? d2.n() : d2.c;
    }

    public final void f1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        p layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = layoutParams;
            if (!pVar.d) {
                Rect rect = pVar.c;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        this.n.P1(this, view, this.j, !this.v, view2 == null);
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View m1 = this.n.m1(view, i2);
        if (m1 != null) {
            return m1;
        }
        boolean z3 = (this.m == null || this.n == null || y0() || this.y) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.n.I()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (I0) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.n.H()) {
                int i4 = (this.n.x0() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (I0) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                v();
                if (T(view) == null) {
                    return null;
                }
                v1();
                this.n.f1(view, i2, this.c, this.m0);
                x1(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z3) {
                v();
                if (T(view) == null) {
                    return null;
                }
                v1();
                view2 = this.n.f1(view, i2, this.c, this.m0);
                x1(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return z0(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        f1(view2, null);
        return view;
    }

    public final void g(D d2) {
        View view = d2.a;
        boolean z2 = view.getParent() == this;
        this.c.J(i0(view));
        if (d2.A()) {
            this.f.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.f;
        if (z2) {
            bVar.k(view);
        } else {
            bVar.b(view, true);
        }
    }

    public int g0(View view) {
        D j0 = j0(view);
        if (j0 != null) {
            return j0.m();
        }
        return -1;
    }

    public final void g1() {
        A a2 = this.m0;
        a2.n = -1L;
        a2.m = -1;
        a2.o = -1;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.b0();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.c0(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.m;
    }

    public int getBaseline() {
        o oVar = this.n;
        return oVar != null ? oVar.e0() : super.getBaseline();
    }

    public int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.u0;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.h;
    }

    public androidx.recyclerview.widget.l getCompatAccessibilityDelegate() {
        return this.t0;
    }

    public k getEdgeEffectFactory() {
        return this.I;
    }

    public l getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public o getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.f0;
    }

    public int getMinFlingVelocity() {
        return this.e0;
    }

    public long getNanoTime() {
        if (H0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.i0;
    }

    public u getRecycledViewPool() {
        return this.c.i();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    public int h0(View view) {
        D j0 = j0(view);
        if (j0 != null) {
            return j0.p();
        }
        return -1;
    }

    public final void h1() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        y1(0);
        X0();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.D("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(nVar);
        } else {
            this.p.add(i2, nVar);
        }
        B0();
        requestLayout();
    }

    public D i0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return j0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final void i1() {
        View focusedChild = (this.i0 && hasFocus() && this.m != null) ? getFocusedChild() : null;
        D U = focusedChild != null ? U(focusedChild) : null;
        if (U == null) {
            g1();
            return;
        }
        this.m0.n = this.m.v() ? U.n() : -1L;
        this.m0.m = this.E ? -1 : U.y() ? U.d : U.m();
        this.m0.o = l0(U.a);
    }

    public boolean isAttachedToWindow() {
        return this.s;
    }

    public final boolean isLayoutSuppressed() {
        return this.y;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(q qVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(qVar);
    }

    public void j1() {
        int j2 = this.f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            D j0 = j0(this.f.i(i2));
            if (!j0.M()) {
                j0.H();
            }
        }
    }

    public void k(s sVar) {
        this.q.add(sVar);
    }

    public boolean k1(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        v();
        if (this.m != null) {
            int[] iArr = this.z0;
            iArr[0] = 0;
            iArr[1] = 0;
            l1(i2, i3, iArr);
            int[] iArr2 = this.z0;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.z0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        H(i5, i4, i6, i7, this.x0, 0, iArr3);
        int[] iArr4 = this.z0;
        int i10 = iArr4[0];
        int i11 = i6 - i10;
        int i12 = iArr4[1];
        int i13 = i7 - i12;
        boolean z2 = (i10 == 0 && i12 == 0) ? false : true;
        int i14 = this.T;
        int[] iArr5 = this.x0;
        int i15 = iArr5[0];
        this.T = i14 - i15;
        int i16 = this.U;
        int i17 = iArr5[1];
        this.U = i16 - i17;
        int[] iArr6 = this.y0;
        iArr6[0] = iArr6[0] + i15;
        iArr6[1] = iArr6[1] + i17;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !P.y.b(motionEvent, 8194)) {
                U0(motionEvent.getX(), i11, motionEvent.getY(), i13);
            }
            u(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            J(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i4 == 0) ? false : true;
    }

    public void l(t tVar) {
        if (this.o0 == null) {
            this.o0 = new ArrayList();
        }
        this.o0.add(tVar);
    }

    public final int l0(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    public void l1(int i2, int i3, int[] iArr) {
        v1();
        K0();
        L.t.a("RV Scroll");
        R(this.m0);
        int T1 = i2 != 0 ? this.n.T1(i2, this.c, this.m0) : 0;
        int V1 = i3 != 0 ? this.n.V1(i3, this.c, this.m0) : 0;
        L.t.b();
        e1();
        L0();
        x1(false);
        if (iArr != null) {
            iArr[0] = T1;
            iArr[1] = V1;
        }
    }

    public void m(D d2, l.c cVar, l.c cVar2) {
        d2.J(false);
        if (this.N.a(d2, cVar, cVar2)) {
            Q0();
        }
    }

    public final String m0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    public void m1(int i2) {
        if (this.y) {
            return;
        }
        z1();
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.U1(i2);
            awakenScrollBars();
        }
    }

    public final void n(D d2, D d3, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d2.J(false);
        if (z2) {
            g(d2);
        }
        if (d2 != d3) {
            if (z3) {
                g(d3);
            }
            d2.h = d3;
            g(d2);
            this.c.J(d2);
            d3.J(false);
            d3.i = d2;
        }
        if (this.N.b(d2, d3, cVar, cVar2)) {
            Q0();
        }
    }

    public Rect n0(View view) {
        p layoutParams = view.getLayoutParams();
        if (!layoutParams.d) {
            return layoutParams.c;
        }
        if (this.m0.h() && (layoutParams.d() || layoutParams.f())) {
            return layoutParams.c;
        }
        Rect rect = layoutParams.c;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.set(0, 0, 0, 0);
            ((n) this.p.get(i2)).g(this.j, view, this, this.m0);
            int i3 = rect.left;
            Rect rect2 = this.j;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.d = false;
        return rect;
    }

    public final void n1(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.i0(this.a);
            this.m.S(this);
        }
        if (!z2 || z3) {
            Y0();
        }
        this.e.x();
        g gVar3 = this.m;
        this.m = gVar;
        if (gVar != null) {
            gVar.b0(this.a);
            gVar.D(this);
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.a1(gVar3, this.m);
        }
        this.c.x(gVar3, this.m, z2);
        this.m0.g = true;
    }

    public void o(D d2, l.c cVar, l.c cVar2) {
        g(d2);
        d2.J(false);
        if (this.N.c(d2, cVar, cVar2)) {
            Q0();
        }
    }

    public final void o0(long j2, D d2, D d3) {
        int g2 = this.f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            D j0 = j0(this.f.f(i2));
            if (j0 != d2 && f0(j0) == j2) {
                g gVar = this.m;
                if (gVar == null || !gVar.v()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + j0 + " \n View Holder 2:" + d2 + Q());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + j0 + " \n View Holder 2:" + d2 + Q());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d3 + " cannot be found but it is necessary for " + d2 + Q());
    }

    public boolean o1(D d2, int i2) {
        if (!y0()) {
            L.C0(d2.a, i2);
            return true;
        }
        d2.q = i2;
        this.A0.add(d2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.G = r0
            r1 = 1
            r5.s = r1
            boolean r2 = r5.v
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.v = r1
            androidx.recyclerview.widget.RecyclerView$o r1 = r5.n
            if (r1 == 0) goto L1e
            r1.X(r5)
        L1e:
            r5.s0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.H0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.f
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.k0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.k0 = r1
            android.view.Display r1 = P.L.x(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.e r2 = r5.k0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.d = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.k0
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        z1();
        this.s = false;
        o oVar = this.n;
        if (oVar != null) {
            oVar.Y(this, this.c);
        }
        this.A0.clear();
        removeCallbacks(this.B0);
        this.g.j();
        if (!H0 || (eVar = this.k0) == null) {
            return;
        }
        eVar.j(this);
        this.k0 = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((n) this.p.get(i2)).i(canvas, this, this.m0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.n
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.y
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L79
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.n
            boolean r0 = r0.I()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.H()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = 0
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.I()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.H()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = 0
            goto L64
        L62:
            r0 = 0
            goto L3c
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L79
        L6c:
            float r2 = r5.g0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.h0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.k1(r2, r0, r6)
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        this.r = null;
        if (V(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.n;
        if (oVar == null) {
            return false;
        }
        boolean H = oVar.H();
        boolean I = this.n.I();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.U = y2;
            this.S = y2;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                y1(1);
            }
            int[] iArr = this.y0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = H;
            if (I) {
                i2 = (H ? 1 : 0) | 2;
            }
            w1(i2, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            y1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i3 = x3 - this.R;
                int i4 = y3 - this.S;
                if (H == 0 || Math.abs(i3) <= this.V) {
                    z2 = false;
                } else {
                    this.T = x3;
                    z2 = true;
                }
                if (I && Math.abs(i4) > this.V) {
                    this.U = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x4;
            this.R = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y4;
            this.S = y4;
        } else if (actionMasked == 6) {
            N0(motionEvent);
        }
        return this.O == 1;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        L.t.a("RV OnLayout");
        C();
        L.t.b();
        this.v = true;
    }

    public void onMeasure(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            x(i2, i3);
            return;
        }
        if (oVar.N0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.v1(this.c, this.m0, i2, i3);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.m == null) {
                return;
            }
            if (this.m0.e == 1) {
                D();
            }
            this.n.Y1(i2, i3);
            this.m0.j = true;
            E();
            this.n.b2(i2, i3);
            if (this.n.e2()) {
                this.n.Y1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.m0.j = true;
                E();
                this.n.b2(i2, i3);
                return;
            }
            return;
        }
        if (this.t) {
            this.n.v1(this.c, this.m0, i2, i3);
            return;
        }
        if (this.B) {
            v1();
            K0();
            S0();
            L0();
            A a2 = this.m0;
            if (a2.l) {
                a2.h = true;
            } else {
                this.e.j();
                this.m0.h = false;
            }
            this.B = false;
            x1(false);
        } else if (this.m0.l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.m;
        if (gVar != null) {
            this.m0.f = gVar.n();
        } else {
            this.m0.f = 0;
        }
        v1();
        this.n.v1(this.c, this.m0, i2, i3);
        x1(false);
        this.m0.h = false;
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (y0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.d = yVar;
        super.onRestoreInstanceState(yVar.a());
        o oVar = this.n;
        if (oVar == null || (parcelable2 = this.d.d) == null) {
            return;
        }
        oVar.y1(parcelable2);
    }

    public Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.d;
        if (yVar2 != null) {
            yVar.c(yVar2);
        } else {
            o oVar = this.n;
            yVar.d = oVar != null ? oVar.z1() : null;
        }
        return yVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        w0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dd A[PHI: r0
      0x00dd: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:42:0x00c8, B:46:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(String str) {
        if (y0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + Q());
        }
        if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + Q()));
        }
    }

    public boolean p0() {
        return this.t;
    }

    public boolean p1(AccessibilityEvent accessibilityEvent) {
        if (!y0()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? Q.b.a(accessibilityEvent) : 0;
        this.A |= a2 != 0 ? a2 : 0;
        return true;
    }

    public boolean q(D d2) {
        l lVar = this.N;
        return lVar == null || lVar.g(d2, d2.r());
    }

    public boolean q0() {
        return !this.v || this.E || this.e.p();
    }

    public void q1(int i2, int i3) {
        r1(i2, i3, null);
    }

    public final void r() {
        h1();
        setScrollState(0);
    }

    public final boolean r0() {
        int g2 = this.f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            D j0 = j0(this.f.f(i2));
            if (j0 != null && !j0.M() && j0.B()) {
                return true;
            }
        }
        return false;
    }

    public void r1(int i2, int i3, Interpolator interpolator) {
        s1(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void removeDetachedView(View view, boolean z2) {
        D j0 = j0(view);
        if (j0 != null) {
            if (j0.A()) {
                j0.i();
            } else if (!j0.M()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + j0 + Q());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.n.x1(this, this.m0, view, view2) && view2 != null) {
            f1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.O1(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.q.get(i2)).e(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    public void s0() {
        this.e = new androidx.recyclerview.widget.a(new f());
    }

    public void s1(int i2, int i3, Interpolator interpolator, int i4) {
        t1(i2, i3, interpolator, i4, false);
    }

    public void scrollBy(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        boolean H = oVar.H();
        boolean I = this.n.I();
        if (H || I) {
            if (!H) {
                i2 = 0;
            }
            if (!I) {
                i3 = 0;
            }
            k1(i2, i3, null);
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (p1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.l lVar) {
        this.t0 = lVar;
        L.s0(this, lVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        n1(gVar, false, true);
        T0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.u0) {
            return;
        }
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.h) {
            w0();
        }
        this.h = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        O.h.f(kVar);
        this.I = kVar;
        w0();
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.N;
        if (lVar2 != null) {
            lVar2.k();
            this.N.w(null);
        }
        this.N = lVar;
        if (lVar != null) {
            lVar.w(this.r0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.c.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.n) {
            return;
        }
        z1();
        if (this.n != null) {
            l lVar = this.N;
            if (lVar != null) {
                lVar.k();
            }
            this.n.H1(this.c);
            this.n.I1(this.c);
            this.c.c();
            if (this.s) {
                this.n.Y(this, this.c);
            }
            this.n.c2(null);
            this.n = null;
        } else {
            this.c.c();
        }
        this.f.o();
        this.n = oVar;
        if (oVar != null) {
            if (oVar.b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.b.Q());
            }
            oVar.c2(this);
            if (this.s) {
                this.n.X(this);
            }
        }
        this.c.K();
        requestLayout();
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition((LayoutTransition) null);
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.W = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.n0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.i0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.c.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.o = wVar;
    }

    public void setScrollState(int i2) {
        if (i2 == this.O) {
            return;
        }
        this.O = i2;
        if (i2 != 2) {
            A1();
        }
        I(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 == 0) {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else if (i2 != 1) {
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else {
            scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.V = scaledTouchSlop;
    }

    public void setViewCacheExtension(B b2) {
        this.c.F(b2);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().o(i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.y) {
            p("Do not suppressLayout in layout or scroll");
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.y = true;
                this.z = true;
                z1();
                return;
            }
            this.y = false;
            if (this.x && this.n != null && this.m != null) {
                requestLayout();
            }
            this.x = false;
        }
    }

    public void t() {
        int j2 = this.f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            D j0 = j0(this.f.i(i2));
            if (!j0.M()) {
                j0.f();
            }
        }
        this.c.d();
    }

    public final void t0() {
        if (L.D(this) == 0) {
            L.D0(this, 8);
        }
    }

    public void t1(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        if (!oVar.H()) {
            i2 = 0;
        }
        if (!this.n.I()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 != Integer.MIN_VALUE && i4 <= 0) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            w1(i5, 1);
        }
        this.j0.f(i2, i3, i4, interpolator);
    }

    public void u(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.J.onRelease();
            z2 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            L.j0(this);
        }
    }

    public final void u0() {
        this.f = new androidx.recyclerview.widget.b(new e());
    }

    public void u1(int i2) {
        if (this.y) {
            return;
        }
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.g2(this, this.m0, i2);
        }
    }

    public void v() {
        if (!this.v || this.E) {
            L.t.a("RV FullInvalidate");
            C();
            L.t.b();
            return;
        }
        if (this.e.p()) {
            if (this.e.o(4) && !this.e.o(11)) {
                L.t.a("RV PartialInvalidate");
                v1();
                K0();
                this.e.v();
                if (!this.x) {
                    if (r0()) {
                        C();
                    } else {
                        this.e.i();
                    }
                }
                x1(true);
                L0();
            } else {
                if (!this.e.p()) {
                    return;
                }
                L.t.a("RV FullInvalidate");
                C();
            }
            L.t.b();
        }
    }

    public void v0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(A0.b.a), resources.getDimensionPixelSize(A0.b.c), resources.getDimensionPixelOffset(A0.b.b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + Q());
        }
    }

    public void v1() {
        int i2 = this.w + 1;
        this.w = i2;
        if (i2 != 1 || this.y) {
            return;
        }
        this.x = false;
    }

    public final void w(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String m0 = m0(context, trim);
            try {
                Class asSubclass = Class.forName(m0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = asSubclass.getConstructor(K0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    objArr = null;
                    try {
                        constructor = asSubclass.getConstructor((Class[]) null);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + m0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + m0, e4);
            } catch (InvocationTargetException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + m0, e5);
            } catch (ClassCastException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + m0, e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + m0, e7);
            } catch (InstantiationException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + m0, e8);
            }
        }
    }

    public void w0() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public boolean w1(int i2, int i3) {
        return getScrollingChildHelper().p(i2, i3);
    }

    public void x(int i2, int i3) {
        setMeasuredDimension(o.K(i2, getPaddingLeft() + getPaddingRight(), L.G(this)), o.K(i3, getPaddingTop() + getPaddingBottom(), L.F(this)));
    }

    public boolean x0() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void x1(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.n != null && this.m != null) {
                C();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    public final boolean y(int i2, int i3) {
        W(this.v0);
        int[] iArr = this.v0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    public boolean y0() {
        return this.G > 0;
    }

    public void y1(int i2) {
        getScrollingChildHelper().r(i2);
    }

    public void z(View view) {
        D j0 = j0(view);
        I0(view);
        g gVar = this.m;
        if (gVar != null && j0 != null) {
            gVar.W(j0);
        }
        List list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.D.get(size)).d(view);
            }
        }
    }

    public final boolean z0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || T(view2) == null) {
            return false;
        }
        if (view == null || T(view) == null) {
            return true;
        }
        this.j.set(0, 0, view.getWidth(), view.getHeight());
        this.k.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.j);
        offsetDescendantRectToMyCoords(view2, this.k);
        char c2 = 65535;
        int i4 = this.n.x0() == 1 ? -1 : 1;
        Rect rect = this.j;
        int i5 = rect.left;
        Rect rect2 = this.k;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + Q());
    }

    public void z1() {
        setScrollState(0);
        A1();
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new x();
        this.c = new v();
        this.g = new androidx.recyclerview.widget.q();
        this.i = new a();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new k();
        this.N = new androidx.recyclerview.widget.c();
        this.O = 0;
        this.P = -1;
        this.g0 = Float.MIN_VALUE;
        this.h0 = Float.MIN_VALUE;
        this.i0 = true;
        this.j0 = new C();
        this.l0 = H0 ? new e.b() : null;
        this.m0 = new A();
        this.p0 = false;
        this.q0 = false;
        this.r0 = new m();
        this.s0 = false;
        this.v0 = new int[2];
        this.x0 = new int[2];
        this.y0 = new int[2];
        this.z0 = new int[2];
        this.A0 = new ArrayList();
        this.B0 = new b();
        this.C0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.g0 = N.b(viewConfiguration, context);
        this.h0 = N.d(viewConfiguration, context);
        this.e0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.w(this.r0);
        s0();
        u0();
        t0();
        if (L.C(this) == 0) {
            L.C0(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.l(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A0.d.f, i2, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            B0.c.a(this, context, A0.d.f, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(A0.d.o);
        if (obtainStyledAttributes.getInt(A0.d.i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.h = obtainStyledAttributes.getBoolean(A0.d.h, true);
        boolean z2 = obtainStyledAttributes.getBoolean(A0.d.j, false);
        this.u = z2;
        if (z2) {
            v0((StateListDrawable) obtainStyledAttributes.getDrawable(A0.d.m), obtainStyledAttributes.getDrawable(A0.d.n), (StateListDrawable) obtainStyledAttributes.getDrawable(A0.d.k), obtainStyledAttributes.getDrawable(A0.d.l));
        }
        obtainStyledAttributes.recycle();
        w(context, string, attributeSet, i2, 0);
        int[] iArr = D0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (i3 >= 29) {
            B0.c.a(this, context, iArr, attributeSet, obtainStyledAttributes2, i2, 0);
        }
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.d0(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }
}
