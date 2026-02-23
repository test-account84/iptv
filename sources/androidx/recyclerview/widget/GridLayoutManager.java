package androidx.recyclerview.widget;

import Q.C;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean I;
    public int J;
    public int[] K;
    public View[] L;
    public final SparseIntArray M;
    public final SparseIntArray N;
    public c O;
    public final Rect P;
    public boolean Q;

    public static final class a extends c {
        public int e(int i, int i2) {
            return i % i2;
        }

        public int f(int i) {
            return 1;
        }
    }

    public static class b extends RecyclerView.p {
        public int f;
        public int g;

        public b(int i, int i2) {
            super(i, i2);
            this.f = -1;
            this.g = 0;
        }

        public int h() {
            return this.f;
        }

        public int k() {
            return this.g;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f = -1;
            this.g = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f = -1;
            this.g = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f = -1;
            this.g = 0;
        }
    }

    public static abstract class c {
        public final SparseIntArray a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();
        public boolean c = false;
        public boolean d = false;

        public static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int b(int i, int i2) {
            if (!this.d) {
                return d(i, i2);
            }
            int i3 = this.b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int d = d(i, i2);
            this.b.put(i, d);
            return d;
        }

        public int c(int i, int i2) {
            if (!this.c) {
                return e(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int e = e(i, i2);
            this.a.put(i, e);
            return e;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int d(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.d
                r1 = 0
                if (r0 == 0) goto L25
                android.util.SparseIntArray r0 = r6.b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L25
                android.util.SparseIntArray r2 = r6.b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L28
                int r2 = r2 + 1
            L23:
                r4 = 0
                goto L28
            L25:
                r2 = 0
                r3 = 0
                goto L23
            L28:
                int r0 = r6.f(r7)
            L2c:
                if (r3 >= r7) goto L41
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L39
                int r2 = r2 + 1
                r4 = 0
                goto L3e
            L39:
                if (r4 <= r8) goto L3e
                int r2 = r2 + 1
                r4 = r5
            L3e:
                int r3 = r3 + 1
                goto L2c
            L41:
                int r4 = r4 + r0
                if (r4 <= r8) goto L46
                int r2 = r2 + 1
            L46:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.d(int, int):int");
        }

        public abstract int e(int i, int i2);

        public abstract int f(int i);

        public void g() {
            this.b.clear();
        }

        public void h() {
            this.a.clear();
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        C3(i);
    }

    public static int[] p3(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    public final void A3(View view, int i, boolean z) {
        int i2;
        int i3;
        b layoutParams = view.getLayoutParams();
        Rect rect = layoutParams.c;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int v3 = v3(layoutParams.f, layoutParams.g);
        if (this.s == 1) {
            i3 = RecyclerView.o.i0(v3, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i2 = RecyclerView.o.i0(this.u.n(), v0(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int i0 = RecyclerView.o.i0(v3, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int i02 = RecyclerView.o.i0(this.u.n(), J0(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i2 = i0;
            i3 = i02;
        }
        B3(view, i3, i2, z);
    }

    public final void B3(View view, int i, int i2, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? f2(view, i, i2, pVar) : d2(view, i, i2, pVar)) {
            view.measure(i, i2);
        }
    }

    public void C3(int i) {
        if (i == this.J) {
            return;
        }
        this.I = true;
        if (i >= 1) {
            this.J = i;
            this.O.h();
            Q1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public final void D3() {
        int u0;
        int n;
        if (N2() == 1) {
            u0 = I0() - k();
            n = o();
        } else {
            u0 = u0() - b();
            n = n();
        }
        o3(u0 - n);
    }

    public int E0(RecyclerView.v vVar, RecyclerView.A a2) {
        if (this.s == 0) {
            return this.J;
        }
        if (a2.c() < 1) {
            return 0;
        }
        return w3(vVar, a2, a2.c() - 1) + 1;
    }

    public View F2(RecyclerView.v vVar, RecyclerView.A a2, int i, int i2, int i3) {
        r2();
        int m = this.u.m();
        int i4 = this.u.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View g0 = g0(i);
            int B0 = B0(g0);
            if (B0 >= 0 && B0 < i3 && x3(vVar, a2, B0) == 0) {
                if (g0.getLayoutParams().e()) {
                    if (view2 == null) {
                        view2 = g0;
                    }
                } else {
                    if (this.u.g(g0) < i4 && this.u.d(g0) >= m) {
                        return g0;
                    }
                    if (view == null) {
                        view = g0;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    public boolean J(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    public int O(RecyclerView.A a2) {
        return this.Q ? r3(a2) : super.O(a2);
    }

    public int P(RecyclerView.A a2) {
        return this.Q ? s3(a2) : super.P(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x0214  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Q2(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.A r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.Q2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$A, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    public int R(RecyclerView.A a2) {
        return this.Q ? r3(a2) : super.R(a2);
    }

    public int S(RecyclerView.A a2) {
        return this.Q ? s3(a2) : super.S(a2);
    }

    public void S2(RecyclerView.v vVar, RecyclerView.A a2, LinearLayoutManager.a aVar, int i) {
        super.S2(vVar, a2, aVar, i);
        D3();
        if (a2.c() > 0 && !a2.h()) {
            t3(vVar, a2, aVar, i);
        }
        u3();
    }

    public int T1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        D3();
        u3();
        return super.T1(i, vVar, a2);
    }

    public int V1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        D3();
        u3();
        return super.V1(i, vVar, a2);
    }

    public void a2(Rect rect, int i, int i2) {
        int K;
        int K2;
        if (this.K == null) {
            super.a2(rect, i, i2);
        }
        int o = o() + k();
        int n = n() + b();
        if (this.s == 1) {
            K2 = RecyclerView.o.K(i2, rect.height() + n, z0());
            int[] iArr = this.K;
            K = RecyclerView.o.K(i, iArr[iArr.length - 1] + o, A0());
        } else {
            K = RecyclerView.o.K(i, rect.width() + o, A0());
            int[] iArr2 = this.K;
            K2 = RecyclerView.o.K(i2, iArr2[iArr2.length - 1] + n, z0());
        }
        Z1(K, K2);
    }

    public RecyclerView.p b0() {
        return this.s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public RecyclerView.p c0(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.p d0(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void d3(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.d3(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View f1(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.A r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.f1(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$A):android.view.View");
    }

    public boolean j2() {
        return this.D == null && !this.I;
    }

    public int l0(RecyclerView.v vVar, RecyclerView.A a2) {
        if (this.s == 1) {
            return this.J;
        }
        if (a2.c() < 1) {
            return 0;
        }
        return w3(vVar, a2, a2.c() - 1) + 1;
    }

    public void l1(RecyclerView.v vVar, RecyclerView.A a2, View view, C c2) {
        int h;
        int k;
        boolean z;
        boolean z2;
        int i;
        int i2;
        b layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.k1(view, c2);
            return;
        }
        b bVar = layoutParams;
        int w3 = w3(vVar, a2, bVar.c());
        if (this.s == 0) {
            i2 = bVar.h();
            i = bVar.k();
            z = false;
            z2 = false;
            k = 1;
            h = w3;
        } else {
            h = bVar.h();
            k = bVar.k();
            z = false;
            z2 = false;
            i = 1;
            i2 = w3;
        }
        c2.a0(C.c.a(i2, i, h, k, z, z2));
    }

    public void l2(RecyclerView.A a2, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i = this.J;
        for (int i2 = 0; i2 < this.J && cVar.c(a2) && i > 0; i2++) {
            int i3 = cVar.d;
            cVar2.a(i3, Math.max(0, cVar.g));
            i -= this.O.f(i3);
            cVar.d += cVar.e;
        }
    }

    public final void m3(RecyclerView.v vVar, RecyclerView.A a2, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (z) {
            i3 = i;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View view = this.L[i2];
            b layoutParams = view.getLayoutParams();
            int y3 = y3(vVar, a2, B0(view));
            layoutParams.g = y3;
            layoutParams.f = i5;
            i5 += y3;
            i2 += i4;
        }
    }

    public void n1(RecyclerView recyclerView, int i, int i2) {
        this.O.h();
        this.O.g();
    }

    public final void n3() {
        int h0 = h0();
        for (int i = 0; i < h0; i++) {
            b layoutParams = g0(i).getLayoutParams();
            int c2 = layoutParams.c();
            this.M.put(c2, layoutParams.k());
            this.N.put(c2, layoutParams.h());
        }
    }

    public void o1(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    public final void o3(int i) {
        this.K = p3(this.K, this.J, i);
    }

    public void p1(RecyclerView recyclerView, int i, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    public void q1(RecyclerView recyclerView, int i, int i2) {
        this.O.h();
        this.O.g();
    }

    public final void q3() {
        this.M.clear();
        this.N.clear();
    }

    public final int r3(RecyclerView.A a2) {
        if (h0() != 0 && a2.c() != 0) {
            r2();
            boolean P2 = P2();
            View w2 = w2(!P2, true);
            View v2 = v2(!P2, true);
            if (w2 != null && v2 != null) {
                int b2 = this.O.b(B0(w2), this.J);
                int b3 = this.O.b(B0(v2), this.J);
                int max = this.x ? Math.max(0, ((this.O.b(a2.c() - 1, this.J) + 1) - Math.max(b2, b3)) - 1) : Math.max(0, Math.min(b2, b3));
                if (P2) {
                    return Math.round((max * (Math.abs(this.u.d(v2) - this.u.g(w2)) / ((this.O.b(B0(v2), this.J) - this.O.b(B0(w2), this.J)) + 1))) + (this.u.m() - this.u.g(w2)));
                }
                return max;
            }
        }
        return 0;
    }

    public void s1(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.O.h();
        this.O.g();
    }

    public final int s3(RecyclerView.A a2) {
        if (h0() != 0 && a2.c() != 0) {
            r2();
            View w2 = w2(!P2(), true);
            View v2 = v2(!P2(), true);
            if (w2 != null && v2 != null) {
                if (!P2()) {
                    return this.O.b(a2.c() - 1, this.J) + 1;
                }
                int d = this.u.d(v2) - this.u.g(w2);
                int b2 = this.O.b(B0(w2), this.J);
                return (int) ((d / ((this.O.b(B0(v2), this.J) - b2) + 1)) * (this.O.b(a2.c() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    public void t1(RecyclerView.v vVar, RecyclerView.A a2) {
        if (a2.h()) {
            n3();
        }
        super.t1(vVar, a2);
        q3();
    }

    public final void t3(RecyclerView.v vVar, RecyclerView.A a2, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int x3 = x3(vVar, a2, aVar.b);
        if (z) {
            while (x3 > 0) {
                int i2 = aVar.b;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                aVar.b = i3;
                x3 = x3(vVar, a2, i3);
            }
            return;
        }
        int c2 = a2.c() - 1;
        int i4 = aVar.b;
        while (i4 < c2) {
            int i5 = i4 + 1;
            int x32 = x3(vVar, a2, i5);
            if (x32 <= x3) {
                break;
            }
            i4 = i5;
            x3 = x32;
        }
        aVar.b = i4;
    }

    public void u1(RecyclerView.A a2) {
        super.u1(a2);
        this.I = false;
    }

    public final void u3() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    public int v3(int i, int i2) {
        if (this.s != 1 || !O2()) {
            int[] iArr = this.K;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.K;
        int i3 = this.J;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int w3(RecyclerView.v vVar, RecyclerView.A a2, int i) {
        if (!a2.h()) {
            return this.O.b(i, this.J);
        }
        int f = vVar.f(i);
        if (f != -1) {
            return this.O.b(f, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    public final int x3(RecyclerView.v vVar, RecyclerView.A a2, int i) {
        if (!a2.h()) {
            return this.O.c(i, this.J);
        }
        int i2 = this.N.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int f = vVar.f(i);
        if (f != -1) {
            return this.O.c(f, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int y3(RecyclerView.v vVar, RecyclerView.A a2, int i) {
        if (!a2.h()) {
            return this.O.f(i);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int f = vVar.f(i);
        if (f != -1) {
            return this.O.f(f);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void z3(float f, int i) {
        o3(Math.max(Math.round(f * this.J), i));
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        C3(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        C3(RecyclerView.o.C0(context, attributeSet, i, i2).b);
    }
}
