package androidx.leanback.widget;

import Q.C;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.c0;
import androidx.leanback.widget.l;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class m extends RecyclerView.o {
    public static final Rect j0 = new Rect();
    public static int[] k0 = new int[2];
    public int[] A;
    public RecyclerView.v B;
    public d H;
    public f I;
    public int K;
    public int M;
    public int N;
    public int O;
    public int[] P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int W;
    public l Y;
    public int c0;
    public int d0;
    public androidx.leanback.widget.f g0;
    public final androidx.leanback.widget.b t;
    public RecyclerView.A w;
    public int x;
    public int y;
    public int s = 10;
    public int u = 0;
    public androidx.recyclerview.widget.j v = androidx.recyclerview.widget.j.a(this);
    public final SparseIntArray z = new SparseIntArray();
    public int C = 221696;
    public A D = null;
    public ArrayList E = null;
    public int F = -1;
    public int G = 0;
    public int J = 0;
    public int V = 8388659;
    public int X = 1;
    public int Z = 0;
    public final c0 a0 = new c0();
    public final q b0 = new q();
    public int[] e0 = new int[2];
    public final b0 f0 = new b0();
    public final Runnable h0 = new a();
    public l.b i0 = new b();
    public int L = -1;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            m.this.Q1();
        }
    }

    public class b implements l.b {
        public b() {
        }

        public int a() {
            return m.this.x;
        }

        public int b(int i) {
            m mVar = m.this;
            View a0 = mVar.a0(i - mVar.x);
            m mVar2 = m.this;
            return (mVar2.C & 262144) != 0 ? mVar2.g3(a0) : mVar2.h3(a0);
        }

        public void c(Object obj, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            f fVar;
            View view = (View) obj;
            if (i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE) {
                i4 = !m.this.Y.u() ? m.this.a0.a().g() : m.this.a0.a().i() - m.this.a0.a().f();
            }
            if (!m.this.Y.u()) {
                i6 = i2 + i4;
                i5 = i4;
            } else {
                i5 = i4 - i2;
                i6 = i4;
            }
            int R2 = m.this.R2(i3) + m.this.a0.c().g();
            m mVar = m.this;
            int i7 = R2 - mVar.M;
            mVar.f0.g(view, i);
            m.this.y3(i3, view, i5, i6, i7);
            if (!m.this.w.h()) {
                m.this.K4();
            }
            m mVar2 = m.this;
            if ((mVar2.C & 3) != 1 && (fVar = mVar2.I) != null) {
                fVar.E();
            }
            m.this.getClass();
        }

        public int d(int i) {
            m mVar = m.this;
            return mVar.i3(mVar.a0(i - mVar.x));
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007d A[PHI: r9
          0x007d: PHI (r9v7 androidx.leanback.widget.m) = (r9v6 androidx.leanback.widget.m), (r9v3 androidx.leanback.widget.m), (r9v3 androidx.leanback.widget.m) binds: [B:36:0x00a0, B:29:0x008f, B:19:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int e(int r6, boolean r7, java.lang.Object[] r8, boolean r9) {
            /*
                r5 = this;
                androidx.leanback.widget.m r0 = androidx.leanback.widget.m.this
                int r1 = r0.x
                int r1 = r6 - r1
                android.view.View r0 = r0.f3(r1)
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                androidx.leanback.widget.m$e r1 = (androidx.leanback.widget.m.e) r1
                androidx.leanback.widget.m r2 = androidx.leanback.widget.m.this
                androidx.leanback.widget.b r2 = r2.t
                androidx.recyclerview.widget.RecyclerView$D r2 = r2.i0(r0)
                androidx.leanback.widget.m r3 = androidx.leanback.widget.m.this
                java.lang.Class<androidx.leanback.widget.r> r4 = androidx.leanback.widget.r.class
                java.lang.Object r2 = r3.F2(r2, r4)
                d.D.a(r2)
                r2 = 0
                r1.K(r2)
                boolean r1 = r1.e()
                r2 = 0
                if (r1 != 0) goto Lb2
                if (r9 == 0) goto L3e
                if (r7 == 0) goto L38
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                r7.y(r0)
                goto L4b
            L38:
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                r7.z(r0, r2)
                goto L4b
            L3e:
                if (r7 == 0) goto L46
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                r7.A(r0)
                goto L4b
            L46:
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                r7.B(r0, r2)
            L4b:
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                int r7 = r7.L
                r9 = -1
                if (r7 == r9) goto L55
                r0.setVisibility(r7)
            L55:
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                androidx.leanback.widget.m$f r7 = r7.I
                if (r7 == 0) goto L5e
                r7.F()
            L5e:
                androidx.leanback.widget.m r7 = androidx.leanback.widget.m.this
                android.view.View r9 = r0.findFocus()
                int r7 = r7.X2(r0, r9)
                androidx.leanback.widget.m r9 = androidx.leanback.widget.m.this
                int r1 = r9.C
                r3 = r1 & 3
                r4 = 1
                if (r3 == r4) goto L81
                int r1 = r9.F
                if (r6 != r1) goto Lad
                int r6 = r9.G
                if (r7 != r6) goto Lad
                androidx.leanback.widget.m$f r6 = r9.I
                if (r6 != 0) goto Lad
            L7d:
                r9.o2()
                goto Lad
            L81:
                r3 = r1 & 4
                if (r3 != 0) goto Lad
                r3 = r1 & 16
                if (r3 != 0) goto L92
                int r3 = r9.F
                if (r6 != r3) goto L92
                int r3 = r9.G
                if (r7 != r3) goto L92
                goto L7d
            L92:
                r1 = r1 & 16
                if (r1 == 0) goto Lad
                int r9 = r9.F
                if (r6 < r9) goto Lad
                boolean r9 = r0.hasFocusable()
                if (r9 == 0) goto Lad
                androidx.leanback.widget.m r9 = androidx.leanback.widget.m.this
                r9.F = r6
                r9.G = r7
                int r6 = r9.C
                r6 = r6 & (-17)
                r9.C = r6
                goto L7d
            Lad:
                androidx.leanback.widget.m r6 = androidx.leanback.widget.m.this
                r6.B3(r0)
            Lb2:
                r8[r2] = r0
                androidx.leanback.widget.m r6 = androidx.leanback.widget.m.this
                int r7 = r6.u
                if (r7 != 0) goto Lbf
                int r6 = r6.D2(r0)
                goto Lc3
            Lbf:
                int r6 = r6.C2(r0)
            Lc3:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.b.e(int, boolean, java.lang.Object[], boolean):int");
        }

        public int getCount() {
            return m.this.w.c() + m.this.x;
        }

        public void removeItem(int i) {
            m mVar = m.this;
            View a0 = mVar.a0(i - mVar.x);
            m mVar2 = m.this;
            if ((mVar2.C & 3) == 1) {
                mVar2.U(a0, mVar2.B);
            } else {
                mVar2.J1(a0, mVar2.B);
            }
        }
    }

    public class c extends d {
        public c() {
            super();
        }

        public PointF a(int i) {
            if (c() == 0) {
                return null;
            }
            m mVar = m.this;
            int B0 = mVar.B0(mVar.g0(0));
            m mVar2 = m.this;
            int i2 = ((mVar2.C & 262144) == 0 ? i >= B0 : i <= B0) ? 1 : -1;
            return mVar2.u == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
        }
    }

    public abstract class d extends androidx.recyclerview.widget.h {
        public boolean q;

        public d() {
            super(m.this.t.getContext());
        }

        public void D() {
            View b = b(f());
            if (b == null) {
                if (f() >= 0) {
                    m.this.T3(f(), 0, false, 0);
                    return;
                }
                return;
            }
            if (m.this.F != f()) {
                m.this.F = f();
            }
            if (m.this.L0()) {
                m.this.C |= 32;
                b.requestFocus();
                m.this.C &= -33;
            }
            m.this.o2();
            m.this.p2();
        }

        public void n() {
            super.n();
            if (!this.q) {
                D();
            }
            m mVar = m.this;
            if (mVar.H == this) {
                mVar.H = null;
            }
            if (mVar.I == this) {
                mVar.I = null;
            }
        }

        public void o(View view, RecyclerView.A a, RecyclerView.z.a aVar) {
            int i;
            int i2;
            if (m.this.S2(view, null, m.k0)) {
                if (m.this.u == 0) {
                    int[] iArr = m.k0;
                    i2 = iArr[0];
                    i = iArr[1];
                } else {
                    int[] iArr2 = m.k0;
                    int i3 = iArr2[1];
                    i = iArr2[0];
                    i2 = i3;
                }
                aVar.d(i2, i, w((int) Math.sqrt((i2 * i2) + (i * i))), this.j);
            }
        }

        public int x(int i) {
            int x = super.x(i);
            if (m.this.a0.a().i() <= 0) {
                return x;
            }
            float i2 = (30.0f / m.this.a0.a().i()) * i;
            return ((float) x) < i2 ? (int) i2 : x;
        }
    }

    public static final class e extends RecyclerView.p {
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int[] l;

        public e(int i, int i2) {
            super(i, i2);
        }

        public int A() {
            return this.h;
        }

        public int C(View view) {
            return view.getTop() + this.g;
        }

        public int G() {
            return this.g;
        }

        public int H(View view) {
            return (view.getWidth() - this.f) - this.h;
        }

        public void I(int i) {
            this.j = i;
        }

        public void J(int i) {
            this.k = i;
        }

        public void K(r rVar) {
        }

        public void L(int i, int i2, int i3, int i4) {
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
        }

        public int[] h() {
            return this.l;
        }

        public int k() {
            return this.j;
        }

        public int m() {
            return this.k;
        }

        public r r() {
            return null;
        }

        public int t(View view) {
            return (view.getHeight() - this.g) - this.i;
        }

        public int v(View view) {
            return view.getLeft() + this.f;
        }

        public int w() {
            return this.f;
        }

        public int x(View view) {
            return view.getRight() - this.h;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public e(e eVar) {
            super((RecyclerView.p) eVar);
        }

        public e(RecyclerView.p pVar) {
            super(pVar);
        }
    }

    public final class f extends d {
        public final boolean s;
        public int t;

        public f(int i, boolean z) {
            super();
            this.t = i;
            this.s = z;
            p(-2);
        }

        public void C(RecyclerView.z.a aVar) {
            if (this.t == 0) {
                return;
            }
            super.C(aVar);
        }

        public void D() {
            super.D();
            this.t = 0;
            View b = b(f());
            if (b != null) {
                m.this.W3(b, true);
            }
        }

        public void E() {
            int i;
            if (this.s && (i = this.t) != 0) {
                this.t = m.this.M3(true, i);
            }
            int i2 = this.t;
            if (i2 == 0 || ((i2 > 0 && m.this.r3()) || (this.t < 0 && m.this.q3()))) {
                p(m.this.F);
                r();
            }
        }

        public void F() {
            int i;
            int i2;
            View b;
            if (this.s || (i = this.t) == 0) {
                return;
            }
            if (i > 0) {
                m mVar = m.this;
                i2 = mVar.F + mVar.W;
            } else {
                m mVar2 = m.this;
                i2 = mVar2.F - mVar2.W;
            }
            View view = null;
            while (this.t != 0 && (b = b(i2)) != null) {
                if (m.this.m2(b)) {
                    m mVar3 = m.this;
                    mVar3.F = i2;
                    mVar3.G = 0;
                    int i3 = this.t;
                    this.t = i3 > 0 ? i3 - 1 : i3 + 1;
                    view = b;
                }
                i2 = this.t > 0 ? i2 + m.this.W : i2 - m.this.W;
            }
            if (view == null || !m.this.L0()) {
                return;
            }
            m.this.C |= 32;
            view.requestFocus();
            m.this.C &= -33;
        }

        public void G() {
            int i = this.t;
            if (i > (-m.this.s)) {
                this.t = i - 1;
            }
        }

        public void H() {
            int i = this.t;
            if (i < m.this.s) {
                this.t = i + 1;
            }
        }

        public PointF a(int i) {
            int i2 = this.t;
            if (i2 == 0) {
                return null;
            }
            m mVar = m.this;
            int i3 = ((mVar.C & 262144) == 0 ? i2 >= 0 : i2 <= 0) ? 1 : -1;
            return mVar.u == 0 ? new PointF(i3, 0.0f) : new PointF(0.0f, i3);
        }
    }

    public static final class g implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public Bundle c;

        public static class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i) {
                return new g[i];
            }
        }

        public g() {
            this.c = Bundle.EMPTY;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeBundle(this.c);
        }

        public g(Parcel parcel) {
            this.c = Bundle.EMPTY;
            this.a = parcel.readInt();
            this.c = parcel.readBundle(m.class.getClassLoader());
        }
    }

    public m(androidx.leanback.widget.b bVar) {
        this.t = bVar;
        X1(false);
    }

    public final boolean A2(View view, View view2, int[] iArr) {
        int P2 = P2(view);
        if (view2 != null) {
            P2 = z2(P2, view, view2);
        }
        int T2 = T2(view);
        int i = P2 + this.K;
        if (i == 0 && T2 == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        iArr[0] = i;
        iArr[1] = T2;
        return true;
    }

    public final void A3() {
        this.B = null;
        this.w = null;
        this.x = 0;
        this.y = 0;
    }

    public void A4(int i) {
        this.a0.a().z(i);
    }

    public int B2(RecyclerView recyclerView, int i, int i2) {
        int indexOfChild;
        View a0 = a0(this.F);
        return (a0 != null && i2 >= (indexOfChild = recyclerView.indexOfChild(a0))) ? i2 < i + (-1) ? ((indexOfChild + i) - 1) - i2 : indexOfChild : i2;
    }

    public void B3(View view) {
        int childMeasureSpec;
        int i;
        e layoutParams = view.getLayoutParams();
        Rect rect = j0;
        G(view, rect);
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.left + rect.right;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.top + rect.bottom;
        int makeMeasureSpec = this.N == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(this.O, 1073741824);
        if (this.u == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            i = ViewGroup.getChildMeasureSpec(makeMeasureSpec, i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        } else {
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(makeMeasureSpec, i2, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            i = childMeasureSpec2;
        }
        view.measure(childMeasureSpec, i);
    }

    public void B4(float f2) {
        this.a0.a().A(f2);
    }

    public int C2(View view) {
        e layoutParams = view.getLayoutParams();
        return p0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    public final void C3(int i, int i2, int i3, int[] iArr) {
        View o = this.B.o(i);
        if (o != null) {
            e layoutParams = o.getLayoutParams();
            Rect rect = j0;
            G(o, rect);
            o.measure(ViewGroup.getChildMeasureSpec(i2, o() + k() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.left + rect.right, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i3, n() + b() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.top + rect.bottom, ((ViewGroup.MarginLayoutParams) layoutParams).height));
            iArr[0] = D2(o);
            iArr[1] = C2(o);
            this.B.B(o);
        }
    }

    public void C4() {
        d dVar = this.H;
        if (dVar != null) {
            dVar.q = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean D1(androidx.recyclerview.widget.RecyclerView.v r5, androidx.recyclerview.widget.RecyclerView.A r6, int r7, android.os.Bundle r8) {
        /*
            r4 = this;
            boolean r8 = r4.w3()
            r0 = 1
            if (r8 != 0) goto L8
            return r0
        L8:
            r4.P3(r5, r6)
            int r5 = r4.C
            r6 = 262144(0x40000, float:3.67342E-40)
            r5 = r5 & r6
            r6 = 0
            if (r5 == 0) goto L15
            r5 = 1
            goto L16
        L15:
            r5 = 0
        L16:
            int r8 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 8192(0x2000, float:1.14794E-41)
            r3 = 4096(0x1000, float:5.74E-42)
            if (r8 < r1) goto L4f
            int r8 = r4.u
            if (r8 != 0) goto L3a
            Q.C$a r8 = Q.C.a.D
            int r8 = r8.b()
            if (r7 != r8) goto L2f
            if (r5 == 0) goto L42
            goto L4d
        L2f:
            Q.C$a r8 = Q.C.a.F
            int r8 = r8.b()
            if (r7 != r8) goto L4f
            if (r5 == 0) goto L4d
            goto L42
        L3a:
            Q.C$a r5 = Q.C.a.C
            int r5 = r5.b()
            if (r7 != r5) goto L45
        L42:
            r7 = 8192(0x2000, float:1.14794E-41)
            goto L4f
        L45:
            Q.C$a r5 = Q.C.a.E
            int r5 = r5.b()
            if (r7 != r5) goto L4f
        L4d:
            r7 = 4096(0x1000, float:5.74E-42)
        L4f:
            if (r7 == r3) goto L5c
            if (r7 == r2) goto L54
            goto L62
        L54:
            r4.K3(r6)
            r5 = -1
            r4.M3(r6, r5)
            goto L62
        L5c:
            r4.K3(r0)
            r4.M3(r6, r0)
        L62:
            r4.A3()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.D1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$A, int, android.os.Bundle):boolean");
    }

    public int D2(View view) {
        e layoutParams = view.getLayoutParams();
        return q0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    public final void D3(int i) {
        int h0 = h0();
        int i2 = 0;
        if (this.u == 1) {
            while (i2 < h0) {
                g0(i2).offsetTopAndBottom(i);
                i2++;
            }
        } else {
            while (i2 < h0) {
                g0(i2).offsetLeftAndRight(i);
                i2++;
            }
        }
    }

    public int D4(int i) {
        c cVar = new c();
        cVar.p(i);
        h2(cVar);
        return cVar.f();
    }

    public int E0(RecyclerView.v vVar, RecyclerView.A a2) {
        l lVar;
        return (this.u != 0 || (lVar = this.Y) == null) ? super.E0(vVar, a2) : lVar.r();
    }

    public int E2() {
        return this.d0;
    }

    public final void E3(int i) {
        int h0 = h0();
        int i2 = 0;
        if (this.u == 0) {
            while (i2 < h0) {
                g0(i2).offsetTopAndBottom(i);
                i2++;
            }
        } else {
            while (i2 < h0) {
                g0(i2).offsetLeftAndRight(i);
                i2++;
            }
        }
    }

    public final void E4() {
        int h0 = h0();
        for (int i = 0; i < h0; i++) {
            F4(g0(i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object F2(RecyclerView.D d2, Class cls) {
        androidx.leanback.widget.f fVar;
        androidx.leanback.widget.e g2;
        Object c2 = d2 instanceof androidx.leanback.widget.e ? ((androidx.leanback.widget.e) d2).c(cls) : null;
        return (c2 != null || (fVar = this.g0) == null || (g2 = fVar.g(d2.o())) == null) ? c2 : g2.c(cls);
    }

    public void F3(RecyclerView.D d2) {
        int m = d2.m();
        if (m != -1) {
            this.f0.j(d2.a, m);
        }
    }

    public final void F4(View view) {
        e layoutParams = view.getLayoutParams();
        layoutParams.r();
        layoutParams.I(this.b0.c.i(view));
        layoutParams.J(this.b0.b.i(view));
    }

    public int G2() {
        return this.Z;
    }

    public void G3(boolean z, int i, Rect rect) {
        if (!z) {
            return;
        }
        int i2 = this.F;
        while (true) {
            View a0 = a0(i2);
            if (a0 == null) {
                return;
            }
            if (a0.getVisibility() == 0 && a0.hasFocusable()) {
                a0.requestFocus();
                return;
            }
            i2++;
        }
    }

    public void G4() {
        int i = 0;
        if (h0() > 0) {
            i = this.Y.m() - g0(0).getLayoutParams().c();
        }
        this.x = i;
    }

    public boolean H() {
        return this.u == 0 || this.W > 1;
    }

    public void H1(RecyclerView.v vVar) {
        for (int h0 = h0() - 1; h0 >= 0; h0--) {
            K1(h0, vVar);
        }
    }

    public int H2() {
        return this.R;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void H3(int r6) {
        /*
            r5 = this;
            int r0 = r5.u
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Ld
            if (r6 != r2) goto Lb
            r0 = 262144(0x40000, float:3.67342E-40)
            goto L11
        Lb:
            r0 = 0
            goto L11
        Ld:
            if (r6 != r2) goto Lb
            r0 = 524288(0x80000, float:7.34684E-40)
        L11:
            int r3 = r5.C
            r4 = 786432(0xc0000, float:1.102026E-39)
            r4 = r4 & r3
            if (r4 != r0) goto L19
            return
        L19:
            r4 = -786433(0xfffffffffff3ffff, float:NaN)
            r3 = r3 & r4
            r0 = r0 | r3
            r0 = r0 | 256(0x100, float:3.59E-43)
            r5.C = r0
            androidx.leanback.widget.c0 r0 = r5.a0
            androidx.leanback.widget.c0$a r0 = r0.c
            if (r6 != r2) goto L29
            r1 = 1
        L29:
            r0.w(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.H3(int):void");
    }

    public void H4() {
        l.a q;
        this.z.clear();
        int h0 = h0();
        for (int i = 0; i < h0; i++) {
            int q2 = this.t.i0(g0(i)).q();
            if (q2 >= 0 && (q = this.Y.q(q2)) != null) {
                this.z.put(q2, q.a);
            }
        }
    }

    public boolean I() {
        return this.u == 1 || this.W > 1;
    }

    public int I2() {
        return this.b0.a().a();
    }

    public final boolean I3() {
        return this.Y.v();
    }

    public final void I4() {
        int i = (this.C & (-1025)) | (L3(false) ? 1024 : 0);
        this.C = i;
        if ((i & 1024) != 0) {
            w2();
        }
    }

    public float J2() {
        return this.b0.a().b();
    }

    public final void J3() {
        this.Y.w((this.C & 262144) != 0 ? this.c0 + this.d0 + this.y : (-this.d0) - this.y);
    }

    public final void J4() {
        this.a0.c.x(I0());
        this.a0.b.x(u0());
        this.a0.c.t(o(), k());
        this.a0.b.t(n(), b());
        this.c0 = this.a0.a().i();
    }

    public int K2() {
        return this.b0.a().c();
    }

    public final void K3(boolean z) {
        if (z) {
            if (r3()) {
                return;
            }
        } else if (q3()) {
            return;
        }
        f fVar = this.I;
        if (fVar == null) {
            this.t.z1();
            f fVar2 = new f(z ? 1 : -1, this.W > 1);
            this.J = 0;
            h2(fVar2);
            return;
        }
        if (z) {
            fVar.H();
        } else {
            fVar.G();
        }
    }

    public void K4() {
        int m;
        int p;
        int c2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.w.c() == 0) {
            return;
        }
        if ((this.C & 262144) == 0) {
            m = this.Y.p();
            i = this.w.c() - 1;
            p = this.Y.m();
            c2 = 0;
        } else {
            m = this.Y.m();
            p = this.Y.p();
            c2 = this.w.c() - 1;
            i = 0;
        }
        if (m < 0 || p < 0) {
            return;
        }
        boolean z = m == i;
        boolean z2 = p == c2;
        if (z || !this.a0.a().o() || z2 || !this.a0.a().p()) {
            if (z) {
                i2 = this.Y.j(true, k0);
                View a0 = a0(k0[1]);
                i3 = b3(a0);
                int[] h = a0.getLayoutParams().h();
                if (h != null && h.length > 0) {
                    i3 += h[h.length - 1] - h[0];
                }
            } else {
                i2 = Integer.MAX_VALUE;
                i3 = Integer.MAX_VALUE;
            }
            if (z2) {
                i4 = this.Y.l(false, k0);
                i5 = b3(a0(k0[1]));
            } else {
                i4 = Integer.MIN_VALUE;
                i5 = Integer.MIN_VALUE;
            }
            this.a0.a().B(i4, i2, i5, i3);
        }
    }

    public void L(int i, int i2, RecyclerView.A a2, RecyclerView.o.c cVar) {
        try {
            P3(null, a2);
            if (this.u != 0) {
                i = i2;
            }
            if (h0() != 0 && i != 0) {
                this.Y.f(i < 0 ? -this.d0 : this.c0 + this.d0, i, cVar);
                A3();
            }
        } finally {
            A3();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int L2(int r10) {
        /*
            r9 = this;
            int r0 = r9.u
            r1 = 130(0x82, float:1.82E-43)
            r2 = 66
            r3 = 33
            r4 = 2
            r5 = 0
            r6 = 3
            r7 = 1
            r8 = 17
            if (r0 != 0) goto L30
            r0 = 262144(0x40000, float:3.67342E-40)
            if (r10 == r8) goto L28
            if (r10 == r3) goto L2e
            if (r10 == r2) goto L1f
            if (r10 == r1) goto L1d
            r4 = 17
            goto L2e
        L1d:
            r4 = 3
            goto L2e
        L1f:
            int r10 = r9.C
            r10 = r10 & r0
            if (r10 != 0) goto L26
        L24:
            r4 = 1
            goto L2e
        L26:
            r4 = 0
            goto L2e
        L28:
            int r10 = r9.C
            r10 = r10 & r0
            if (r10 != 0) goto L24
            goto L26
        L2e:
            r5 = r4
            goto L4d
        L30:
            if (r0 != r7) goto L4b
            r0 = 524288(0x80000, float:7.34684E-40)
            if (r10 == r8) goto L45
            if (r10 == r3) goto L4d
            if (r10 == r2) goto L3f
            if (r10 == r1) goto L3d
            goto L4b
        L3d:
            r5 = 1
            goto L4d
        L3f:
            int r10 = r9.C
            r10 = r10 & r0
            if (r10 != 0) goto L2e
            goto L1d
        L45:
            int r10 = r9.C
            r10 = r10 & r0
            if (r10 != 0) goto L1d
            goto L2e
        L4b:
            r5 = 17
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.L2(int):int");
    }

    public final boolean L3(boolean z) {
        if (this.O != 0 || this.P == null) {
            return false;
        }
        l lVar = this.Y;
        s.d[] n = lVar == null ? null : lVar.n();
        boolean z2 = false;
        int i = -1;
        for (int i2 = 0; i2 < this.W; i2++) {
            s.d dVar = n == null ? null : n[i2];
            int g2 = dVar == null ? 0 : dVar.g();
            int i3 = -1;
            for (int i4 = 0; i4 < g2; i4 += 2) {
                int d2 = dVar.d(i4 + 1);
                for (int d3 = dVar.d(i4); d3 <= d2; d3++) {
                    View a0 = a0(d3 - this.x);
                    if (a0 != null) {
                        if (z) {
                            B3(a0);
                        }
                        int C2 = this.u == 0 ? C2(a0) : D2(a0);
                        if (C2 > i3) {
                            i3 = C2;
                        }
                    }
                }
            }
            int c2 = this.w.c();
            if (!this.t.p0() && z && i3 < 0 && c2 > 0) {
                if (i < 0) {
                    int i5 = this.F;
                    if (i5 < 0) {
                        i5 = 0;
                    } else if (i5 >= c2) {
                        i5 = c2 - 1;
                    }
                    if (h0() > 0) {
                        int p = this.t.i0(g0(0)).p();
                        int p2 = this.t.i0(g0(h0() - 1)).p();
                        if (i5 >= p && i5 <= p2) {
                            i5 = i5 - p <= p2 - i5 ? p - 1 : p2 + 1;
                            if (i5 < 0 && p2 < c2 - 1) {
                                i5 = p2 + 1;
                            } else if (i5 >= c2 && p > 0) {
                                i5 = p - 1;
                            }
                        }
                    }
                    if (i5 >= 0 && i5 < c2) {
                        C3(i5, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0), this.e0);
                        i = this.u == 0 ? this.e0[1] : this.e0[0];
                    }
                }
                if (i >= 0) {
                    i3 = i;
                }
            }
            if (i3 < 0) {
                i3 = 0;
            }
            int[] iArr = this.P;
            if (iArr[i2] != i3) {
                iArr[i2] = i3;
                z2 = true;
            }
        }
        return z2;
    }

    public final void L4() {
        c0.a c2 = this.a0.c();
        int g2 = c2.g() - this.M;
        int V2 = V2() + g2;
        c2.B(g2, V2, g2, V2);
    }

    public void M(int i, RecyclerView.o.c cVar) {
        int i2 = this.t.S0;
        if (i == 0 || i2 == 0) {
            return;
        }
        int max = Math.max(0, Math.min(this.F - ((i2 - 1) / 2), i - i2));
        for (int i3 = max; i3 < i && i3 < max + i2; i3++) {
            cVar.a(i3, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean M2(android.view.View r13, int[] r14) {
        /*
            r12 = this;
            int r0 = r12.y2(r13)
            int r1 = r12.h3(r13)
            int r2 = r12.g3(r13)
            androidx.leanback.widget.c0 r3 = r12.a0
            androidx.leanback.widget.c0$a r3 = r3.a()
            int r3 = r3.g()
            androidx.leanback.widget.c0 r4 = r12.a0
            androidx.leanback.widget.c0$a r4 = r4.a()
            int r4 = r4.c()
            androidx.leanback.widget.l r5 = r12.Y
            int r5 = r5.s(r0)
            r6 = 1
            r7 = 0
            r8 = 2
            r9 = 0
            if (r1 >= r3) goto L6f
            int r1 = r12.Z
            if (r1 != r8) goto L6c
            r1 = r13
        L31:
            boolean r10 = r12.I3()
            if (r10 == 0) goto L69
            androidx.leanback.widget.l r1 = r12.Y
            int r10 = r1.m()
            s.d[] r1 = r1.o(r10, r0)
            r1 = r1[r5]
            int r10 = r1.d(r7)
            android.view.View r10 = r12.a0(r10)
            int r11 = r12.h3(r10)
            int r11 = r2 - r11
            if (r11 <= r4) goto L67
            int r0 = r1.g()
            if (r0 <= r8) goto L64
            int r0 = r1.d(r8)
            android.view.View r0 = r12.a0(r0)
            r2 = r9
            r9 = r0
            goto La5
        L64:
            r2 = r9
            r9 = r10
            goto La5
        L67:
            r1 = r10
            goto L31
        L69:
            r2 = r9
            r9 = r1
            goto La5
        L6c:
            r2 = r9
        L6d:
            r9 = r13
            goto La5
        L6f:
            int r10 = r4 + r3
            if (r2 <= r10) goto La4
            int r2 = r12.Z
            if (r2 != r8) goto La2
        L77:
            androidx.leanback.widget.l r2 = r12.Y
            int r8 = r2.p()
            s.d[] r2 = r2.o(r0, r8)
            r2 = r2[r5]
            int r8 = r2.g()
            int r8 = r8 - r6
            int r2 = r2.d(r8)
            android.view.View r2 = r12.a0(r2)
            int r8 = r12.g3(r2)
            int r8 = r8 - r1
            if (r8 <= r4) goto L99
            r2 = r9
            goto L9f
        L99:
            boolean r8 = r12.k2()
            if (r8 != 0) goto L77
        L9f:
            if (r2 == 0) goto L6d
            goto La5
        La2:
            r2 = r13
            goto La5
        La4:
            r2 = r9
        La5:
            if (r9 == 0) goto Lad
            int r0 = r12.h3(r9)
        Lab:
            int r0 = r0 - r3
            goto Lb6
        Lad:
            if (r2 == 0) goto Lb5
            int r0 = r12.g3(r2)
            int r3 = r3 + r4
            goto Lab
        Lb5:
            r0 = 0
        Lb6:
            if (r9 == 0) goto Lba
            r13 = r9
            goto Lbd
        Lba:
            if (r2 == 0) goto Lbd
            r13 = r2
        Lbd:
            int r13 = r12.T2(r13)
            if (r0 != 0) goto Lc7
            if (r13 == 0) goto Lc6
            goto Lc7
        Lc6:
            return r7
        Lc7:
            r14[r7] = r0
            r14[r6] = r13
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.M2(android.view.View, int[]):boolean");
    }

    public int M3(boolean z, int i) {
        l lVar = this.Y;
        if (lVar == null) {
            return i;
        }
        int i2 = this.F;
        int s = i2 != -1 ? lVar.s(i2) : -1;
        int h0 = h0();
        View view = null;
        for (int i3 = 0; i3 < h0 && i != 0; i3++) {
            int i4 = i > 0 ? i3 : (h0 - 1) - i3;
            View g0 = g0(i4);
            if (m2(g0)) {
                int x2 = x2(i4);
                int s2 = this.Y.s(x2);
                if (s == -1) {
                    i2 = x2;
                    view = g0;
                    s = s2;
                } else if (s2 == s && ((i > 0 && x2 > i2) || (i < 0 && x2 < i2))) {
                    i = i > 0 ? i - 1 : i + 1;
                    i2 = x2;
                    view = g0;
                }
            }
        }
        if (view != null) {
            if (z) {
                if (L0()) {
                    this.C |= 32;
                    view.requestFocus();
                    this.C &= -33;
                }
                this.F = i2;
                this.G = 0;
            } else {
                W3(view, true);
            }
        }
        return i;
    }

    public final int N2(View view) {
        return view.getLayoutParams().v(view);
    }

    public final void N3() {
        int i = this.C;
        if ((65600 & i) == 65536) {
            this.Y.y(this.F, (i & 262144) != 0 ? -this.d0 : this.c0 + this.d0);
        }
    }

    public boolean O1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        return false;
    }

    public final int O2(View view) {
        return view.getLayoutParams().x(view);
    }

    public final void O3() {
        int i = this.C;
        if ((65600 & i) == 65536) {
            this.Y.z(this.F, (i & 262144) != 0 ? this.c0 + this.d0 : -this.d0);
        }
    }

    public final int P2(View view) {
        return this.a0.a().h(b3(view));
    }

    public final void P3(RecyclerView.v vVar, RecyclerView.A a2) {
        if (this.B != null || this.w != null) {
            Log.e("GridLayoutManager", "Recycler information was not released, bug!");
        }
        this.B = vVar;
        this.w = a2;
        this.x = 0;
        this.y = 0;
    }

    public final int Q2(int i) {
        int i2 = this.O;
        if (i2 != 0) {
            return i2;
        }
        int[] iArr = this.P;
        if (iArr == null) {
            return 0;
        }
        return iArr[i];
    }

    public final int Q3(int i) {
        int e2;
        int i2 = this.C;
        if ((i2 & 64) == 0 && (i2 & 3) != 1 && (i <= 0 ? !(i >= 0 || this.a0.a().p() || i >= (e2 = this.a0.a().e())) : !(this.a0.a().o() || i <= (e2 = this.a0.a().d())))) {
            i = e2;
        }
        if (i == 0) {
            return 0;
        }
        D3(-i);
        if ((this.C & 3) == 1) {
            K4();
            return i;
        }
        int h0 = h0();
        if ((this.C & 262144) == 0 ? i >= 0 : i <= 0) {
            l2();
        } else {
            J3();
        }
        boolean z = h0() > h0;
        int h02 = h0();
        if ((262144 & this.C) == 0 ? i >= 0 : i <= 0) {
            O3();
        } else {
            N3();
        }
        if (z | (h0() < h02)) {
            I4();
        }
        this.t.invalidate();
        K4();
        return i;
    }

    public int R2(int i) {
        int i2 = 0;
        if ((this.C & 524288) != 0) {
            for (int i3 = this.W - 1; i3 > i; i3--) {
                i2 += Q2(i3) + this.U;
            }
            return i2;
        }
        int i4 = 0;
        while (i2 < i) {
            i4 += Q2(i2) + this.U;
            i2++;
        }
        return i4;
    }

    public final int R3(int i) {
        if (i == 0) {
            return 0;
        }
        E3(-i);
        this.M += i;
        L4();
        this.t.invalidate();
        return i;
    }

    public boolean S2(View view, View view2, int[] iArr) {
        int i = this.Z;
        return (i == 1 || i == 2) ? M2(view, iArr) : A2(view, view2, iArr);
    }

    public final void S3(int i, int i2, boolean z) {
        if ((this.C & 3) == 1) {
            Q3(i);
            R3(i2);
            return;
        }
        if (this.u != 0) {
            i2 = i;
            i = i2;
        }
        if (z) {
            this.t.q1(i, i2);
        } else {
            this.t.scrollBy(i, i2);
            p2();
        }
    }

    public int T1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if ((this.C & 512) == 0 || !s3()) {
            return 0;
        }
        P3(vVar, a2);
        this.C = (this.C & (-4)) | 2;
        int Q3 = this.u == 0 ? Q3(i) : R3(i);
        A3();
        this.C &= -4;
        return Q3;
    }

    public final int T2(View view) {
        return this.a0.c().h(c3(view));
    }

    public void T3(int i, int i2, boolean z, int i3) {
        this.K = i3;
        View a0 = a0(i);
        boolean z2 = !T0();
        if (!z2 || this.t.isLayoutRequested() || a0 == null || y2(a0) != i) {
            int i4 = this.C;
            if ((i4 & 512) == 0 || (i4 & 64) != 0) {
                this.F = i;
                this.G = i2;
                this.J = Integer.MIN_VALUE;
                return;
            }
            if (z && !this.t.isLayoutRequested()) {
                this.F = i;
                this.G = i2;
                this.J = Integer.MIN_VALUE;
                if (!s3()) {
                    Log.w(Z2(), "setSelectionSmooth should not be called before first layout pass");
                    return;
                }
                int D4 = D4(i);
                if (D4 != this.F) {
                    this.F = D4;
                    this.G = 0;
                    return;
                }
                return;
            }
            if (!z2) {
                C4();
                this.t.z1();
            }
            if (this.t.isLayoutRequested() || a0 == null || y2(a0) != i) {
                this.F = i;
                this.G = i2;
                this.J = Integer.MIN_VALUE;
                this.C |= 256;
                Q1();
                return;
            }
        }
        this.C |= 32;
        W3(a0, z);
        this.C &= -33;
    }

    public void U1(int i) {
        v4(i, 0, false, 0);
    }

    public int U2() {
        return this.F;
    }

    public final void U3(View view, View view2, boolean z) {
        V3(view, view2, z, 0, 0);
    }

    public int V1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if ((this.C & 512) == 0 || !s3()) {
            return 0;
        }
        this.C = (this.C & (-4)) | 2;
        P3(vVar, a2);
        int Q3 = this.u == 1 ? Q3(i) : R3(i);
        A3();
        this.C &= -4;
        return Q3;
    }

    public final int V2() {
        int i = (this.C & 524288) != 0 ? 0 : this.W - 1;
        return R2(i) + Q2(i);
    }

    public final void V3(View view, View view2, boolean z, int i, int i2) {
        if ((this.C & 64) != 0) {
            return;
        }
        int y2 = y2(view);
        int X2 = X2(view, view2);
        if (y2 != this.F || X2 != this.G) {
            this.F = y2;
            this.G = X2;
            this.J = 0;
            if ((this.C & 3) != 1) {
                o2();
            }
            if (this.t.E1()) {
                this.t.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && this.t.hasFocus()) {
            view.requestFocus();
        }
        if ((this.C & 131072) == 0 && z) {
            return;
        }
        if (!S2(view, view2, k0) && i == 0 && i2 == 0) {
            return;
        }
        int[] iArr = k0;
        S3(iArr[0] + i, iArr[1] + i2, z);
    }

    public int W2() {
        int i;
        int left;
        int right;
        if (this.u == 1) {
            i = -u0();
            if (h0() <= 0 || (left = g0(0).getTop()) >= 0) {
                return i;
            }
        } else {
            if ((this.C & 262144) != 0) {
                int I0 = I0();
                return (h0() <= 0 || (right = g0(0).getRight()) <= I0) ? I0 : right;
            }
            i = -I0();
            if (h0() <= 0 || (left = g0(0).getLeft()) >= 0) {
                return i;
            }
        }
        return i + left;
    }

    public void W3(View view, boolean z) {
        U3(view, view == null ? null : view.findFocus(), z);
    }

    public int X2(View view, View view2) {
        if (view != null && view2 != null) {
            view.getLayoutParams().r();
        }
        return 0;
    }

    public void X3(View view, boolean z, int i, int i2) {
        V3(view, view == null ? null : view.findFocus(), z, i, i2);
    }

    public int Y2() {
        return this.G;
    }

    public void Y3(int i) {
        this.L = i;
        if (i != -1) {
            int h0 = h0();
            for (int i2 = 0; i2 < h0; i2++) {
                g0(i2).setVisibility(this.L);
            }
        }
    }

    public String Z2() {
        return "GridLayoutManager:" + this.t.getId();
    }

    public void Z3(int i) {
        int i2 = this.d0;
        if (i2 == i) {
            return;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
        this.d0 = i;
        Q1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a1(RecyclerView.g gVar, RecyclerView.g gVar2) {
        if (gVar != null) {
            n2();
            this.F = -1;
            this.J = 0;
            this.f0.b();
        }
        this.g0 = gVar2 instanceof androidx.leanback.widget.f ? (androidx.leanback.widget.f) gVar2 : null;
        super.a1(gVar, gVar2);
    }

    public int a3() {
        return this.S;
    }

    public void a4(boolean z, boolean z2) {
        this.C = (z ? 2048 : 0) | (this.C & (-6145)) | (z2 ? 4096 : 0);
    }

    public RecyclerView.p b0() {
        return new e(-2, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b1(androidx.recyclerview.widget.RecyclerView r18, java.util.ArrayList r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.b1(androidx.recyclerview.widget.RecyclerView, java.util.ArrayList, int, int):boolean");
    }

    public final int b3(View view) {
        return this.u == 0 ? d3(view) : e3(view);
    }

    public void b4(boolean z, boolean z2) {
        this.C = (z ? 8192 : 0) | (this.C & (-24577)) | (z2 ? 16384 : 0);
    }

    public RecyclerView.p c0(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public final int c3(View view) {
        return this.u == 0 ? e3(view) : d3(view);
    }

    public void c4(int i) {
        this.Z = i;
    }

    public RecyclerView.p d0(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof RecyclerView.p ? new e((RecyclerView.p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int d3(View view) {
        e layoutParams = view.getLayoutParams();
        return layoutParams.v(view) + layoutParams.k();
    }

    public void d4(boolean z) {
        this.C = (z ? 32768 : 0) | (this.C & (-32769));
    }

    public final int e3(View view) {
        e layoutParams = view.getLayoutParams();
        return layoutParams.C(view) + layoutParams.m();
    }

    public void e4(int i) {
        this.V = i;
    }

    public View f3(int i) {
        return this.B.o(i);
    }

    public void f4(int i) {
        int i2 = this.u;
        this.R = i;
        if (i2 == 0) {
            this.T = i;
        } else {
            this.U = i;
        }
    }

    public void g2(RecyclerView recyclerView, RecyclerView.A a2, int i) {
        v4(i, 0, true, 0);
    }

    public int g3(View view) {
        return this.v.d(view);
    }

    public void g4(int i) {
        this.b0.a().e(i);
        E4();
    }

    public void h2(RecyclerView.z zVar) {
        C4();
        super.h2(zVar);
        if (zVar.h() && (zVar instanceof d)) {
            d dVar = (d) zVar;
            this.H = dVar;
            if (dVar instanceof f) {
                this.I = (f) dVar;
                return;
            }
        } else {
            this.H = null;
        }
        this.I = null;
    }

    public int h3(View view) {
        return this.v.g(view);
    }

    public void h4(float f2) {
        this.b0.a().f(f2);
        E4();
    }

    public int i3(View view) {
        Rect rect = j0;
        n0(view, rect);
        return this.u == 0 ? rect.width() : rect.height();
    }

    public void i4(boolean z) {
        this.b0.a().g(z);
        E4();
    }

    public void j1(RecyclerView.v vVar, RecyclerView.A a2, Q.C c2) {
        P3(vVar, a2);
        int c3 = a2.c();
        boolean z = (this.C & 262144) != 0;
        if (c3 > 1 && !v3(0)) {
            if (Build.VERSION.SDK_INT >= 23) {
                c2.b(this.u == 0 ? z ? C.a.F : C.a.D : C.a.C);
            } else {
                c2.a(8192);
            }
            c2.q0(true);
        }
        if (c3 > 1 && !v3(c3 - 1)) {
            if (Build.VERSION.SDK_INT >= 23) {
                c2.b(this.u == 0 ? z ? C.a.D : C.a.F : C.a.E);
            } else {
                c2.a(4096);
            }
            c2.q0(true);
        }
        c2.Z(C.b.a(E0(vVar, a2), l0(vVar, a2), Q0(vVar, a2), F0(vVar, a2)));
        A3();
    }

    public boolean j2() {
        return true;
    }

    public void j3(View view, int[] iArr) {
        if (this.u == 0) {
            iArr[0] = P2(view);
            iArr[1] = T2(view);
        } else {
            iArr[1] = P2(view);
            iArr[0] = T2(view);
        }
    }

    public void j4(int i) {
        this.b0.a().h(i);
        E4();
    }

    public final boolean k2() {
        return this.Y.a();
    }

    public int k3() {
        return this.a0.a().j();
    }

    public void k4(int i) {
        this.R = i;
        this.S = i;
        this.U = i;
        this.T = i;
    }

    public int l0(RecyclerView.v vVar, RecyclerView.A a2) {
        l lVar;
        return (this.u != 1 || (lVar = this.Y) == null) ? super.l0(vVar, a2) : lVar.r();
    }

    public void l1(RecyclerView.v vVar, RecyclerView.A a2, View view, Q.C c2) {
        int i;
        e layoutParams = view.getLayoutParams();
        if (this.Y == null || !(layoutParams instanceof e)) {
            return;
        }
        int a3 = layoutParams.a();
        int s = a3 >= 0 ? this.Y.s(a3) : -1;
        if (s < 0) {
            return;
        }
        int r = a3 / this.Y.r();
        if (this.u == 0) {
            i = s;
            s = r;
        } else {
            i = r;
        }
        c2.a0(C.c.a(i, 1, s, 1, false, false));
    }

    public final void l2() {
        this.Y.b((this.C & 262144) != 0 ? (-this.d0) - this.y : this.c0 + this.d0 + this.y);
    }

    public int l3() {
        return this.a0.a().k();
    }

    public void l4(boolean z) {
        int i = this.C;
        if (((i & 512) != 0) != z) {
            this.C = (i & (-513)) | (z ? 512 : 0);
            Q1();
        }
    }

    public int m0(View view) {
        return super.m0(view) - view.getLayoutParams().i;
    }

    public View m1(View view, int i) {
        View view2;
        View view3;
        if ((this.C & 32768) != 0) {
            return view;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (i == 2 || i == 1) {
            if (I()) {
                view2 = focusFinder.findNextFocus(this.t, view, i == 2 ? 130 : 33);
            } else {
                view2 = null;
            }
            if (H()) {
                view3 = focusFinder.findNextFocus(this.t, view, (x0() == 1) ^ (i == 2) ? 66 : 17);
            } else {
                view3 = view2;
            }
        } else {
            view3 = focusFinder.findNextFocus(this.t, view, i);
        }
        if (view3 != null) {
            return view3;
        }
        if (this.t.getDescendantFocusability() == 393216) {
            return this.t.getParent().focusSearch(view, i);
        }
        int L2 = L2(i);
        boolean z = this.t.getScrollState() != 0;
        if (L2 == 1) {
            if (z || (this.C & 4096) == 0) {
                view3 = view;
            }
            if ((this.C & 131072) != 0 && !r3()) {
                K3(true);
                view3 = view;
            }
        } else if (L2 == 0) {
            if (z || (this.C & 2048) == 0) {
                view3 = view;
            }
            if ((this.C & 131072) != 0 && !q3()) {
                K3(false);
                view3 = view;
            }
        } else if (L2 == 3) {
        }
        if (view3 != null) {
            return view3;
        }
        View focusSearch = this.t.getParent().focusSearch(view, i);
        return focusSearch != null ? focusSearch : view != null ? view : this.t;
    }

    public boolean m2(View view) {
        return view.getVisibility() == 0 && (!L0() || view.hasFocusable());
    }

    public float m3() {
        return this.a0.a().l();
    }

    public void m4(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.X = i;
    }

    public void n0(View view, Rect rect) {
        super.n0(view, rect);
        e layoutParams = view.getLayoutParams();
        rect.left += layoutParams.f;
        rect.top += layoutParams.g;
        rect.right -= layoutParams.h;
        rect.bottom -= layoutParams.i;
    }

    public void n1(RecyclerView recyclerView, int i, int i2) {
        l lVar;
        int i3;
        if (this.F != -1 && (lVar = this.Y) != null && lVar.m() >= 0 && (i3 = this.J) != Integer.MIN_VALUE && i <= this.F + i3) {
            this.J = i3 + i2;
        }
        this.f0.b();
    }

    public final void n2() {
        this.Y = null;
        this.P = null;
        this.C &= -1025;
    }

    public boolean n3(RecyclerView recyclerView, int i, Rect rect) {
        int i2 = this.Z;
        return (i2 == 1 || i2 == 2) ? p3(recyclerView, i, rect) : o3(recyclerView, i, rect);
    }

    public void n4(z zVar) {
    }

    public int o0(View view) {
        return super.o0(view) + view.getLayoutParams().f;
    }

    public void o1(RecyclerView recyclerView) {
        this.J = 0;
        this.f0.b();
    }

    public void o2() {
        if (this.D != null || t3()) {
            int i = this.F;
            View a0 = i == -1 ? null : a0(i);
            if (a0 != null) {
                RecyclerView.D i0 = this.t.i0(a0);
                A a2 = this.D;
                if (a2 != null) {
                    a2.a(this.t, a0, this.F, i0 == null ? -1L : i0.n());
                }
                t2(this.t, i0, this.F, this.G);
            } else {
                A a3 = this.D;
                if (a3 != null) {
                    a3.a(this.t, null, -1, -1L);
                }
                t2(this.t, null, -1, 0);
            }
            if ((this.C & 3) == 1 || this.t.isLayoutRequested()) {
                return;
            }
            int h0 = h0();
            for (int i2 = 0; i2 < h0; i2++) {
                if (g0(i2).isLayoutRequested()) {
                    w2();
                    return;
                }
            }
        }
    }

    public final boolean o3(RecyclerView recyclerView, int i, Rect rect) {
        View a0 = a0(this.F);
        if (a0 != null) {
            return a0.requestFocus(i, rect);
        }
        return false;
    }

    public void o4(A a2) {
        this.D = a2;
    }

    public void p1(RecyclerView recyclerView, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = this.F;
        if (i6 != -1 && (i4 = this.J) != Integer.MIN_VALUE) {
            int i7 = i6 + i4;
            if (i <= i7 && i7 < i + i3) {
                i5 = i4 + (i2 - i);
            } else if (i < i7 && i2 > i7 - i3) {
                i5 = i4 - i3;
            } else if (i > i7 && i2 < i7) {
                i5 = i4 + i3;
            }
            this.J = i5;
        }
        this.f0.b();
    }

    public void p2() {
        if (t3()) {
            int i = this.F;
            View a0 = i == -1 ? null : a0(i);
            if (a0 != null) {
                u2(this.t, this.t.i0(a0), this.F, this.G);
                return;
            }
            A a2 = this.D;
            if (a2 != null) {
                a2.a(this.t, null, -1, -1L);
            }
            u2(this.t, null, -1, 0);
        }
    }

    public final boolean p3(RecyclerView recyclerView, int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        int h0 = h0();
        if ((i & 2) != 0) {
            i3 = h0;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = h0 - 1;
            i3 = -1;
            i4 = -1;
        }
        int g2 = this.a0.a().g();
        int c2 = this.a0.a().c() + g2;
        while (i2 != i3) {
            View g0 = g0(i2);
            if (g0.getVisibility() == 0 && h3(g0) >= g2 && g3(g0) <= c2 && g0.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    public void p4(B b2) {
        if (b2 == null) {
            this.E = null;
            return;
        }
        ArrayList arrayList = this.E;
        if (arrayList == null) {
            this.E = new ArrayList();
        } else {
            arrayList.clear();
        }
        this.E.add(b2);
    }

    public void q1(RecyclerView recyclerView, int i, int i2) {
        l lVar;
        int i3;
        int i4;
        int i5;
        if (this.F != -1 && (lVar = this.Y) != null && lVar.m() >= 0 && (i3 = this.J) != Integer.MIN_VALUE && i <= (i5 = (i4 = this.F) + i3)) {
            if (i + i2 > i5) {
                this.F = i4 + i3 + (i - i5);
                this.J = Integer.MIN_VALUE;
            } else {
                this.J = i3 - i2;
            }
        }
        this.f0.b();
    }

    public final void q2() {
        l.a q;
        int h0 = h0();
        int m = this.Y.m();
        this.C &= -9;
        int i = 0;
        while (i < h0) {
            View g0 = g0(i);
            if (m == y2(g0) && (q = this.Y.q(m)) != null) {
                int R2 = (R2(q.a) + this.a0.c().g()) - this.M;
                int h3 = h3(g0);
                int i3 = i3(g0);
                if (g0.getLayoutParams().g()) {
                    this.C |= 8;
                    U(g0, this.B);
                    g0 = f3(m);
                    B(g0, i);
                }
                View view = g0;
                B3(view);
                int D2 = this.u == 0 ? D2(view) : C2(view);
                y3(q.a, view, h3, h3 + D2, R2);
                if (i3 == D2) {
                    i++;
                    m++;
                }
            }
            int p = this.Y.p();
            for (int i2 = h0 - 1; i2 >= i; i2--) {
                U(g0(i2), this.B);
            }
            this.Y.t(m);
            if ((this.C & 65536) != 0) {
                l2();
                int i4 = this.F;
                if (i4 >= 0 && i4 <= p) {
                    while (this.Y.p() < this.F) {
                        this.Y.a();
                    }
                }
            } else {
                while (this.Y.a() && this.Y.p() < p) {
                }
            }
            K4();
            L4();
        }
        K4();
        L4();
    }

    public boolean q3() {
        return w0() == 0 || this.t.Z(0) != null;
    }

    public void q4(int i) {
        if (i == 0 || i == 1) {
            this.u = i;
            this.v = androidx.recyclerview.widget.j.b(this, i);
            this.a0.d(i);
            this.b0.b(i);
            this.C |= 256;
        }
    }

    public int r0(View view) {
        return super.r0(view) - view.getLayoutParams().h;
    }

    public void r1(RecyclerView recyclerView, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            this.f0.h(i);
            i++;
        }
    }

    public void r2() {
        List k = this.B.k();
        int size = k.size();
        if (size == 0) {
            return;
        }
        int[] iArr = this.A;
        if (iArr == null || size > iArr.length) {
            int length = iArr == null ? 16 : iArr.length;
            while (length < size) {
                length <<= 1;
            }
            this.A = new int[length];
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int m = ((RecyclerView.D) k.get(i2)).m();
            if (m >= 0) {
                this.A[i] = m;
                i++;
            }
        }
        if (i > 0) {
            Arrays.sort(this.A, 0, i);
            this.Y.h(this.A, i, this.z);
        }
        this.z.clear();
    }

    public boolean r3() {
        int w0 = w0();
        return w0 == 0 || this.t.Z(w0 - 1) != null;
    }

    public void r4(boolean z) {
        int i = this.C;
        if (((i & 65536) != 0) != z) {
            this.C = (i & (-65537)) | (z ? 65536 : 0);
            if (z) {
                Q1();
            }
        }
    }

    public int s0(View view) {
        return super.s0(view) + view.getLayoutParams().g;
    }

    public final int s2(View view) {
        View Z;
        androidx.leanback.widget.b bVar = this.t;
        if (bVar == null || view == bVar || (Z = Z(view)) == null) {
            return -1;
        }
        int h0 = h0();
        for (int i = 0; i < h0; i++) {
            if (g0(i) == Z) {
                return i;
            }
        }
        return -1;
    }

    public boolean s3() {
        return this.Y != null;
    }

    public void s4(int i) {
        if (i >= 0 || i == -2) {
            this.N = i;
            return;
        }
        throw new IllegalArgumentException("Invalid row height: " + i);
    }

    public void t1(RecyclerView.v vVar, RecyclerView.A a2) {
        int d2;
        int e2;
        int i;
        int i2;
        int i3;
        if (this.W != 0 && a2.c() >= 0) {
            if ((this.C & 64) != 0 && h0() > 0) {
                this.C |= 128;
                return;
            }
            int i4 = this.C;
            if ((i4 & 512) == 0) {
                n2();
                H1(vVar);
                return;
            }
            this.C = (i4 & (-4)) | 1;
            P3(vVar, a2);
            int i5 = Integer.MIN_VALUE;
            if (a2.h()) {
                G4();
                int h0 = h0();
                if (this.Y != null && h0 > 0) {
                    int q = this.t.i0(g0(0)).q();
                    int q2 = this.t.i0(g0(h0 - 1)).q();
                    int i6 = Integer.MAX_VALUE;
                    while (r2 < h0) {
                        View g0 = g0(r2);
                        e layoutParams = g0.getLayoutParams();
                        int g02 = this.t.g0(g0);
                        if (layoutParams.d() || layoutParams.e() || g0.isLayoutRequested() || ((!g0.hasFocus() && this.F == layoutParams.a()) || ((g0.hasFocus() && this.F != layoutParams.a()) || g02 < q || g02 > q2))) {
                            i6 = Math.min(i6, h3(g0));
                            i5 = Math.max(i5, g3(g0));
                        }
                        r2++;
                    }
                    if (i5 > i6) {
                        this.y = i5 - i6;
                    }
                    l2();
                    J3();
                }
                this.C &= -4;
                A3();
                return;
            }
            if (a2.j()) {
                H4();
            }
            boolean z = !T0() && this.Z == 0;
            int i7 = this.F;
            if (i7 != -1 && (i3 = this.J) != Integer.MIN_VALUE) {
                this.F = i7 + i3;
                this.G = 0;
            }
            this.J = 0;
            View a0 = a0(this.F);
            int i8 = this.F;
            int i9 = this.G;
            boolean hasFocus = this.t.hasFocus();
            l lVar = this.Y;
            int m = lVar != null ? lVar.m() : -1;
            l lVar2 = this.Y;
            int p = lVar2 != null ? lVar2.p() : -1;
            if (this.u == 0) {
                e2 = a2.d();
                d2 = a2.e();
            } else {
                d2 = a2.d();
                e2 = a2.e();
            }
            if (z3()) {
                this.C |= 4;
                this.Y.G(this.F);
                q2();
            } else {
                int i10 = this.C;
                this.C = i10 & (-5);
                this.C = (hasFocus ? 16 : 0) | (i10 & (-21));
                if (z && (m < 0 || (i = this.F) > p || i < m)) {
                    m = this.F;
                    p = m;
                }
                this.Y.G(m);
                if (p != -1) {
                    while (k2() && a0(p) == null) {
                    }
                }
            }
            while (true) {
                K4();
                int m2 = this.Y.m();
                int p2 = this.Y.p();
                v2(hasFocus, z, -e2, -d2);
                l2();
                J3();
                if (this.Y.m() == m2 && this.Y.p() == p2) {
                    break;
                }
            }
            O3();
            N3();
            if (a2.j()) {
                r2();
            }
            int i11 = this.C;
            if ((i11 & 1024) != 0) {
                this.C = i11 & (-1025);
            } else {
                I4();
            }
            if (((this.C & 4) != 0 && ((i2 = this.F) != i8 || this.G != i9 || a0(i2) != a0 || (this.C & 8) != 0)) || (this.C & 20) == 16) {
                o2();
            }
            p2();
            if ((this.C & 64) != 0) {
                Q3(W2());
            }
            this.C &= -4;
            A3();
        }
    }

    public void t2(RecyclerView recyclerView, RecyclerView.D d2, int i, int i2) {
        ArrayList arrayList = this.E;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((B) this.E.get(size)).a(recyclerView, d2, i, i2);
        }
    }

    public boolean t3() {
        ArrayList arrayList = this.E;
        return arrayList != null && arrayList.size() > 0;
    }

    public void t4(boolean z) {
        int i;
        int i2 = this.C;
        if (((i2 & 131072) != 0) != z) {
            int i3 = (i2 & (-131073)) | (z ? 131072 : 0);
            this.C = i3;
            if ((i3 & 131072) == 0 || this.Z != 0 || (i = this.F) == -1) {
                return;
            }
            T3(i, this.G, true, this.K);
        }
    }

    public void u1(RecyclerView.A a2) {
    }

    public void u2(RecyclerView recyclerView, RecyclerView.D d2, int i, int i2) {
        ArrayList arrayList = this.E;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((B) this.E.get(size)).b(recyclerView, d2, i, i2);
        }
    }

    public final void u3() {
        this.a0.b();
        this.a0.c.x(I0());
        this.a0.b.x(u0());
        this.a0.c.t(o(), k());
        this.a0.b.t(n(), b());
        this.c0 = this.a0.a().i();
        this.M = 0;
    }

    public void u4(int i, int i2) {
        v4(i, 0, false, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void v1(androidx.recyclerview.widget.RecyclerView.v r7, androidx.recyclerview.widget.RecyclerView.A r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.v1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$A, int, int):void");
    }

    public final void v2(boolean z, boolean z2, int i, int i2) {
        View a0 = a0(this.F);
        if (a0 != null && z2) {
            X3(a0, false, i, i2);
        }
        if (a0 != null && z && !a0.hasFocus()) {
            a0.requestFocus();
            return;
        }
        if (z || this.t.hasFocus()) {
            return;
        }
        if (a0 != null && a0.hasFocusable()) {
            this.t.focusableViewAvailable(a0);
            break;
        }
        int h0 = h0();
        for (int i3 = 0; i3 < h0; i3++) {
            a0 = g0(i3);
            if (a0 != null && a0.hasFocusable()) {
                this.t.focusableViewAvailable(a0);
                break;
            }
        }
        if (z2 && a0 != null && a0.hasFocus()) {
            X3(a0, false, i, i2);
        }
    }

    public boolean v3(int i) {
        RecyclerView.D Z = this.t.Z(i);
        return Z != null && Z.a.getLeft() >= 0 && Z.a.getRight() <= this.t.getWidth() && Z.a.getTop() >= 0 && Z.a.getBottom() <= this.t.getHeight();
    }

    public void v4(int i, int i2, boolean z, int i3) {
        if ((this.F == i || i == -1) && i2 == this.G && i3 == this.K) {
            return;
        }
        T3(i, i2, z, i3);
    }

    public boolean w1(RecyclerView recyclerView, View view, View view2) {
        if ((this.C & 32768) == 0 && y2(view) != -1 && (this.C & 35) == 0) {
            U3(view, view2, true);
        }
        return true;
    }

    public final void w2() {
        P.L.k0(this.t, this.h0);
    }

    public boolean w3() {
        return (this.C & 131072) != 0;
    }

    public void w4(int i) {
        v4(i, 0, true, 0);
    }

    public final int x2(int i) {
        return y2(g0(i));
    }

    public boolean x3() {
        return (this.C & 64) != 0;
    }

    public void x4(int i, int i2, int i3) {
        v4(i, i2, false, i3);
    }

    public void y1(Parcelable parcelable) {
        if (parcelable instanceof g) {
            g gVar = (g) parcelable;
            this.F = gVar.a;
            this.J = 0;
            this.f0.f(gVar.c);
            this.C |= 256;
            Q1();
        }
    }

    public final int y2(View view) {
        e layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.e()) {
            return -1;
        }
        return layoutParams.a();
    }

    public void y3(int i, View view, int i2, int i3, int i4) {
        int Q2;
        int C2 = this.u == 0 ? C2(view) : D2(view);
        int i5 = this.O;
        if (i5 > 0) {
            C2 = Math.min(C2, i5);
        }
        int i6 = this.V;
        int i7 = i6 & 112;
        int absoluteGravity = (this.C & 786432) != 0 ? Gravity.getAbsoluteGravity(i6 & 8388615, 1) : i6 & 7;
        int i8 = this.u;
        if ((i8 != 0 || i7 != 48) && (i8 != 1 || absoluteGravity != 3)) {
            if ((i8 == 0 && i7 == 80) || (i8 == 1 && absoluteGravity == 5)) {
                Q2 = Q2(i) - C2;
            } else if ((i8 == 0 && i7 == 16) || (i8 == 1 && absoluteGravity == 1)) {
                Q2 = (Q2(i) - C2) / 2;
            }
            i4 += Q2;
        }
        int i9 = C2 + i4;
        if (this.u != 0) {
            int i10 = i4;
            i4 = i2;
            i2 = i10;
            i9 = i3;
            i3 = i9;
        }
        e layoutParams = view.getLayoutParams();
        V0(view, i2, i4, i3, i9);
        Rect rect = j0;
        super.n0(view, rect);
        layoutParams.L(i2 - rect.left, i4 - rect.top, rect.right - i3, rect.bottom - i9);
        F4(view);
    }

    public void y4(int i) {
        int i2 = this.u;
        this.S = i;
        if (i2 == 1) {
            this.T = i;
        } else {
            this.U = i;
        }
    }

    public Parcelable z1() {
        g gVar = new g();
        gVar.a = U2();
        Bundle i = this.f0.i();
        int h0 = h0();
        for (int i2 = 0; i2 < h0; i2++) {
            View g0 = g0(i2);
            int y2 = y2(g0);
            if (y2 != -1) {
                i = this.f0.k(i, g0, y2);
            }
        }
        gVar.c = i;
        return gVar;
    }

    public final int z2(int i, View view, View view2) {
        int X2 = X2(view, view2);
        if (X2 == 0) {
            return i;
        }
        e layoutParams = view.getLayoutParams();
        return i + (layoutParams.h()[X2] - layoutParams.h()[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean z3() {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$A r0 = r5.w
            int r0 = r0.c()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L10
            r5.F = r1
        Ld:
            r5.G = r3
            goto L1f
        L10:
            int r4 = r5.F
            if (r4 < r0) goto L18
            int r0 = r0 - r2
            r5.F = r0
            goto Ld
        L18:
            if (r4 != r1) goto L1f
            if (r0 <= 0) goto L1f
            r5.F = r3
            goto Ld
        L1f:
            androidx.recyclerview.widget.RecyclerView$A r0 = r5.w
            boolean r0 = r0.b()
            if (r0 != 0) goto L4f
            androidx.leanback.widget.l r0 = r5.Y
            if (r0 == 0) goto L4f
            int r0 = r0.m()
            if (r0 < 0) goto L4f
            int r0 = r5.C
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L4f
            androidx.leanback.widget.l r0 = r5.Y
            int r0 = r0.r()
            int r1 = r5.W
            if (r0 != r1) goto L4f
            r5.J4()
            r5.L4()
            androidx.leanback.widget.l r0 = r5.Y
            int r1 = r5.T
            r0.F(r1)
            return r2
        L4f:
            int r0 = r5.C
            r0 = r0 & (-257(0xfffffffffffffeff, float:NaN))
            r5.C = r0
            androidx.leanback.widget.l r0 = r5.Y
            r1 = 262144(0x40000, float:3.67342E-40)
            if (r0 == 0) goto L73
            int r4 = r5.W
            int r0 = r0.r()
            if (r4 != r0) goto L73
            int r0 = r5.C
            r0 = r0 & r1
            if (r0 == 0) goto L6a
            r0 = 1
            goto L6b
        L6a:
            r0 = 0
        L6b:
            androidx.leanback.widget.l r4 = r5.Y
            boolean r4 = r4.u()
            if (r0 == r4) goto L8c
        L73:
            int r0 = r5.W
            androidx.leanback.widget.l r0 = androidx.leanback.widget.l.g(r0)
            r5.Y = r0
            androidx.leanback.widget.l$b r4 = r5.i0
            r0.D(r4)
            androidx.leanback.widget.l r0 = r5.Y
            int r4 = r5.C
            r1 = r1 & r4
            if (r1 == 0) goto L88
            goto L89
        L88:
            r2 = 0
        L89:
            r0.E(r2)
        L8c:
            r5.u3()
            r5.L4()
            androidx.leanback.widget.l r0 = r5.Y
            int r1 = r5.T
            r0.F(r1)
            androidx.recyclerview.widget.RecyclerView$v r0 = r5.B
            r5.T(r0)
            androidx.leanback.widget.l r0 = r5.Y
            r0.A()
            androidx.leanback.widget.c0 r0 = r5.a0
            androidx.leanback.widget.c0$a r0 = r0.a()
            r0.n()
            androidx.leanback.widget.c0 r0 = r5.a0
            androidx.leanback.widget.c0$a r0 = r0.a()
            r0.m()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m.z3():boolean");
    }

    public void z4(int i) {
        this.a0.a().y(i);
    }
}
