package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.j;
import com.google.android.flexbox.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FlexboxLayoutManager extends RecyclerView.o implements g4.a, RecyclerView.z.b {
    public static final Rect S = new Rect();
    public final com.google.android.flexbox.a A;
    public RecyclerView.v B;
    public RecyclerView.A C;
    public d D;
    public b E;
    public j F;
    public j G;
    public e H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public SparseArray N;
    public final Context O;
    public View P;
    public int Q;
    public a.a R;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public List z;

    public class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;
        public boolean g;

        public b() {
            this.d = 0;
        }

        public static /* synthetic */ int a(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ int b(b bVar, int i) {
            bVar.a = i;
            return i;
        }

        public static /* synthetic */ int c(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ int d(b bVar, int i) {
            bVar.b = i;
            return i;
        }

        public static /* synthetic */ void e(b bVar) {
            bVar.r();
        }

        public static /* synthetic */ int f(b bVar) {
            return bVar.c;
        }

        public static /* synthetic */ int g(b bVar, int i) {
            bVar.c = i;
            return i;
        }

        public static /* synthetic */ boolean h(b bVar, boolean z) {
            bVar.g = z;
            return z;
        }

        public static /* synthetic */ void i(b bVar, View view) {
            bVar.s(view);
        }

        public static /* synthetic */ int j(b bVar) {
            return bVar.d;
        }

        public static /* synthetic */ int k(b bVar, int i) {
            bVar.d = i;
            return i;
        }

        public static /* synthetic */ int l(b bVar, int i) {
            int i2 = bVar.d + i;
            bVar.d = i2;
            return i2;
        }

        public static /* synthetic */ boolean m(b bVar) {
            return bVar.f;
        }

        public static /* synthetic */ boolean n(b bVar, boolean z) {
            bVar.f = z;
            return z;
        }

        public static /* synthetic */ void o(b bVar) {
            bVar.t();
        }

        public static /* synthetic */ boolean p(b bVar) {
            return bVar.e;
        }

        public static /* synthetic */ boolean q(b bVar, boolean z) {
            bVar.e = z;
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void r() {
            /*
                r2 = this;
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                boolean r0 = r0.x()
                if (r0 != 0) goto L33
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                boolean r0 = com.google.android.flexbox.FlexboxLayoutManager.m2(r0)
                if (r0 == 0) goto L33
                boolean r0 = r2.e
                if (r0 == 0) goto L1f
            L14:
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                androidx.recyclerview.widget.j r0 = com.google.android.flexbox.FlexboxLayoutManager.n2(r0)
                int r0 = r0.i()
                goto L30
            L1f:
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                int r0 = r0.I0()
                com.google.android.flexbox.FlexboxLayoutManager r1 = com.google.android.flexbox.FlexboxLayoutManager.this
                androidx.recyclerview.widget.j r1 = com.google.android.flexbox.FlexboxLayoutManager.n2(r1)
                int r1 = r1.m()
                int r0 = r0 - r1
            L30:
                r2.c = r0
                goto L43
            L33:
                boolean r0 = r2.e
                if (r0 == 0) goto L38
                goto L14
            L38:
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                androidx.recyclerview.widget.j r0 = com.google.android.flexbox.FlexboxLayoutManager.n2(r0)
                int r0 = r0.m()
                goto L30
            L43:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.b.r():void");
        }

        public final void s(View view) {
            int g;
            int d;
            j o2 = FlexboxLayoutManager.k2(FlexboxLayoutManager.this) == 0 ? FlexboxLayoutManager.o2(FlexboxLayoutManager.this) : FlexboxLayoutManager.n2(FlexboxLayoutManager.this);
            if (FlexboxLayoutManager.this.x() || !FlexboxLayoutManager.m2(FlexboxLayoutManager.this)) {
                if (this.e) {
                    d = o2.d(view);
                    this.c = d + o2.o();
                } else {
                    g = o2.g(view);
                    this.c = g;
                }
            } else if (this.e) {
                d = o2.g(view);
                this.c = d + o2.o();
            } else {
                g = o2.d(view);
                this.c = g;
            }
            this.a = FlexboxLayoutManager.this.B0(view);
            this.g = false;
            int[] iArr = FlexboxLayoutManager.p2(FlexboxLayoutManager.this).c;
            int i = this.a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.b = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.q2(FlexboxLayoutManager.this).size() > this.b) {
                this.a = ((g4.c) FlexboxLayoutManager.q2(FlexboxLayoutManager.this).get(this.b)).o;
            }
        }

        public final void t() {
            this.a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            boolean z = false;
            this.f = false;
            this.g = false;
            if (!FlexboxLayoutManager.this.x() ? !(FlexboxLayoutManager.k2(FlexboxLayoutManager.this) != 0 ? FlexboxLayoutManager.k2(FlexboxLayoutManager.this) != 2 : FlexboxLayoutManager.l2(FlexboxLayoutManager.this) != 3) : !(FlexboxLayoutManager.k2(FlexboxLayoutManager.this) != 0 ? FlexboxLayoutManager.k2(FlexboxLayoutManager.this) != 2 : FlexboxLayoutManager.l2(FlexboxLayoutManager.this) != 1)) {
                z = true;
            }
            this.e = z;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.e + ", mValid=" + this.f + ", mAssignedFromSavedState=" + this.g + '}';
        }

        public /* synthetic */ b(FlexboxLayoutManager flexboxLayoutManager, a aVar) {
            this();
        }
    }

    public static class c extends RecyclerView.p implements g4.b {
        public static final Parcelable.Creator CREATOR = new a();
        public float f;
        public float g;
        public int h;
        public float i;
        public int j;
        public int k;
        public int l;
        public int m;
        public boolean n;

        public class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(int i, int i2) {
            super(i, i2);
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = -1;
            this.i = -1.0f;
            this.l = 16777215;
            this.m = 16777215;
        }

        public int D() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        public int E() {
            return this.k;
        }

        public int F() {
            return this.m;
        }

        public int describeContents() {
            return 0;
        }

        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        public int i() {
            return this.h;
        }

        public float j() {
            return this.g;
        }

        public int l() {
            return this.j;
        }

        public int n() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        public void o(int i) {
            this.k = i;
        }

        public float p() {
            return this.f;
        }

        public float q() {
            return this.i;
        }

        public boolean s() {
            return this.n;
        }

        public void setMinWidth(int i) {
            this.j = i;
        }

        public int u() {
            return this.l;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.f);
            parcel.writeFloat(this.g);
            parcel.writeInt(this.h);
            parcel.writeFloat(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m);
            parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public int y() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        public int z() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = -1;
            this.i = -1.0f;
            this.l = 16777215;
            this.m = 16777215;
        }

        public c(Parcel parcel) {
            super(-2, -2);
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = -1;
            this.i = -1.0f;
            this.l = 16777215;
            this.m = 16777215;
            this.f = parcel.readFloat();
            this.g = parcel.readFloat();
            this.h = parcel.readInt();
            this.i = parcel.readFloat();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readInt();
            this.n = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public static class d {
        public int a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean j;

        public d() {
            this.h = 1;
            this.i = 1;
        }

        public static /* synthetic */ int A(d dVar, int i) {
            dVar.g = i;
            return i;
        }

        public static /* synthetic */ boolean B(d dVar) {
            return dVar.j;
        }

        public static /* synthetic */ boolean C(d dVar, boolean z) {
            dVar.j = z;
            return z;
        }

        public static /* synthetic */ int a(d dVar) {
            return dVar.e;
        }

        public static /* synthetic */ int b(d dVar, int i) {
            dVar.e = i;
            return i;
        }

        public static /* synthetic */ int c(d dVar, int i) {
            int i2 = dVar.e + i;
            dVar.e = i2;
            return i2;
        }

        public static /* synthetic */ int d(d dVar, int i) {
            int i2 = dVar.e - i;
            dVar.e = i2;
            return i2;
        }

        public static /* synthetic */ boolean e(d dVar) {
            return dVar.b;
        }

        public static /* synthetic */ boolean f(d dVar, boolean z) {
            dVar.b = z;
            return z;
        }

        public static /* synthetic */ int g(d dVar) {
            return dVar.a;
        }

        public static /* synthetic */ int h(d dVar, int i) {
            dVar.a = i;
            return i;
        }

        public static /* synthetic */ int i(d dVar, int i) {
            int i2 = dVar.a - i;
            dVar.a = i2;
            return i2;
        }

        public static /* synthetic */ int j(d dVar) {
            return dVar.c;
        }

        public static /* synthetic */ int k(d dVar, int i) {
            dVar.c = i;
            return i;
        }

        public static /* synthetic */ int l(d dVar) {
            int i = dVar.c;
            dVar.c = i + 1;
            return i;
        }

        public static /* synthetic */ int m(d dVar) {
            int i = dVar.c;
            dVar.c = i - 1;
            return i;
        }

        public static /* synthetic */ int n(d dVar, int i) {
            int i2 = dVar.c + i;
            dVar.c = i2;
            return i2;
        }

        public static /* synthetic */ int o(d dVar) {
            return dVar.f;
        }

        public static /* synthetic */ int p(d dVar, int i) {
            dVar.f = i;
            return i;
        }

        public static /* synthetic */ int q(d dVar, int i) {
            int i2 = dVar.f + i;
            dVar.f = i2;
            return i2;
        }

        public static /* synthetic */ boolean r(d dVar, RecyclerView.A a, List list) {
            return dVar.D(a, list);
        }

        public static /* synthetic */ int s(d dVar) {
            return dVar.d;
        }

        public static /* synthetic */ int t(d dVar, int i) {
            dVar.d = i;
            return i;
        }

        public static /* synthetic */ int u(d dVar, int i) {
            int i2 = dVar.d + i;
            dVar.d = i2;
            return i2;
        }

        public static /* synthetic */ int v(d dVar, int i) {
            int i2 = dVar.d - i;
            dVar.d = i2;
            return i2;
        }

        public static /* synthetic */ int w(d dVar) {
            return dVar.i;
        }

        public static /* synthetic */ int x(d dVar, int i) {
            dVar.i = i;
            return i;
        }

        public static /* synthetic */ int y(d dVar) {
            return dVar.h;
        }

        public static /* synthetic */ int z(d dVar, int i) {
            dVar.h = i;
            return i;
        }

        public final boolean D(RecyclerView.A a, List list) {
            int i;
            int i2 = this.d;
            return i2 >= 0 && i2 < a.c() && (i = this.c) >= 0 && i < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.c + ", mPosition=" + this.d + ", mOffset=" + this.e + ", mScrollingOffset=" + this.f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public int c;

        public class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, (a) null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        public static /* synthetic */ int a(e eVar) {
            return eVar.a;
        }

        public static /* synthetic */ int c(e eVar, int i) {
            eVar.a = i;
            return i;
        }

        public static /* synthetic */ int d(e eVar) {
            return eVar.c;
        }

        public static /* synthetic */ int e(e eVar, int i) {
            eVar.c = i;
            return i;
        }

        public static /* synthetic */ void f(e eVar) {
            eVar.k();
        }

        public static /* synthetic */ boolean g(e eVar, int i) {
            return eVar.h(i);
        }

        public int describeContents() {
            return 0;
        }

        public final boolean h(int i) {
            int i2 = this.a;
            return i2 >= 0 && i2 < i;
        }

        public final void k() {
            this.a = -1;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.a + ", mAnchorOffset=" + this.c + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.c);
        }

        public e(Parcel parcel) {
            this.a = parcel.readInt();
            this.c = parcel.readInt();
        }

        public /* synthetic */ e(Parcel parcel, a aVar) {
            this(parcel);
        }

        public e(e eVar) {
            this.a = eVar.a;
            this.c = eVar.c;
        }

        public /* synthetic */ e(e eVar, a aVar) {
            this(eVar);
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public static boolean S0(int i, int i2, int i3) {
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

    private boolean d2(View view, int i, int i2, RecyclerView.p pVar) {
        return (!view.isLayoutRequested() && R0() && S0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && S0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
    }

    public static /* synthetic */ int k2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.t;
    }

    public static /* synthetic */ int l2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.s;
    }

    public static /* synthetic */ boolean m2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.x;
    }

    public static /* synthetic */ j n2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.F;
    }

    public static /* synthetic */ j o2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.G;
    }

    public static /* synthetic */ com.google.android.flexbox.a p2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.A;
    }

    public static /* synthetic */ List q2(FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.z;
    }

    private void x2() {
        if (this.D == null) {
            this.D = new d(null);
        }
    }

    public final View A2(int i) {
        View H2 = H2(0, h0(), i);
        if (H2 == null) {
            return null;
        }
        int i2 = this.A.c[B0(H2)];
        if (i2 == -1) {
            return null;
        }
        return B2(H2, (g4.c) this.z.get(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View B2(android.view.View r6, g4.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.x()
            int r7 = r7.h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.g0(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.x
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.j r3 = r5.F
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.j r4 = r5.F
            int r4 = r4.d(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.j r3 = r5.F
            int r3 = r3.g(r6)
            androidx.recyclerview.widget.j r4 = r5.F
            int r4 = r4.g(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.B2(android.view.View, g4.c):android.view.View");
    }

    public int C2() {
        View G2 = G2(0, h0(), false);
        if (G2 == null) {
            return -1;
        }
        return B0(G2);
    }

    public final View D2(int i) {
        View H2 = H2(h0() - 1, -1, i);
        if (H2 == null) {
            return null;
        }
        return E2(H2, (g4.c) this.z.get(this.A.c[B0(H2)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View E2(android.view.View r6, g4.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.x()
            int r1 = r5.h0()
            int r1 = r1 + (-2)
            int r2 = r5.h0()
            int r7 = r7.h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.g0(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.x
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.j r3 = r5.F
            int r3 = r3.g(r6)
            androidx.recyclerview.widget.j r4 = r5.F
            int r4 = r4.g(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.j r3 = r5.F
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.j r4 = r5.F
            int r4 = r4.d(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.E2(android.view.View, g4.c):android.view.View");
    }

    public int F2() {
        View G2 = G2(h0() - 1, -1, false);
        if (G2 == null) {
            return -1;
        }
        return B0(G2);
    }

    public final View G2(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View g0 = g0(i);
            if (S2(g0, z)) {
                return g0;
            }
            i += i3;
        }
        return null;
    }

    public boolean H() {
        if (this.t == 0) {
            return x();
        }
        if (x()) {
            int I0 = I0();
            View view = this.P;
            if (I0 <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    public final View H2(int i, int i2, int i3) {
        int B0;
        y2();
        x2();
        int m = this.F.m();
        int i4 = this.F.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View g0 = g0(i);
            if (g0 != null && (B0 = B0(g0)) >= 0 && B0 < i3) {
                if (g0.getLayoutParams().e()) {
                    if (view2 == null) {
                        view2 = g0;
                    }
                } else {
                    if (this.F.g(g0) >= m && this.F.d(g0) <= i4) {
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

    public boolean I() {
        if (this.t == 0) {
            return !x();
        }
        if (x()) {
            return true;
        }
        int u0 = u0();
        View view = this.P;
        return u0 > (view != null ? view.getHeight() : 0);
    }

    public final int I2(int i, RecyclerView.v vVar, RecyclerView.A a2, boolean z) {
        int i2;
        int i3;
        if (x() || !this.x) {
            int i4 = this.F.i() - i;
            if (i4 <= 0) {
                return 0;
            }
            i2 = -Q2(-i4, vVar, a2);
        } else {
            int m = i - this.F.m();
            if (m <= 0) {
                return 0;
            }
            i2 = Q2(m, vVar, a2);
        }
        int i5 = i + i2;
        if (!z || (i3 = this.F.i() - i5) <= 0) {
            return i2;
        }
        this.F.r(i3);
        return i3 + i2;
    }

    public boolean J(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public final int J2(int i, RecyclerView.v vVar, RecyclerView.A a2, boolean z) {
        int i2;
        int m;
        if (x() || !this.x) {
            int m2 = i - this.F.m();
            if (m2 <= 0) {
                return 0;
            }
            i2 = -Q2(m2, vVar, a2);
        } else {
            int i3 = this.F.i() - i;
            if (i3 <= 0) {
                return 0;
            }
            i2 = Q2(-i3, vVar, a2);
        }
        int i4 = i + i2;
        if (!z || (m = i4 - this.F.m()) <= 0) {
            return i2;
        }
        this.F.r(-m);
        return i2 - m;
    }

    public final int K2(View view) {
        return m0(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public final View L2() {
        return g0(0);
    }

    public final int M2(View view) {
        return o0(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int N(RecyclerView.A a2) {
        return u2(a2);
    }

    public boolean N0() {
        return true;
    }

    public final int N2(View view) {
        return r0(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
    }

    public int O(RecyclerView.A a2) {
        return v2(a2);
    }

    public final int O2(View view) {
        return s0(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public int P(RecyclerView.A a2) {
        return w2(a2);
    }

    public View P2(int i) {
        View view = (View) this.N.get(i);
        return view != null ? view : this.B.o(i);
    }

    public int Q(RecyclerView.A a2) {
        return u2(a2);
    }

    public final int Q2(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (h0() == 0 || i == 0) {
            return 0;
        }
        y2();
        int i2 = 1;
        d.C(this.D, true);
        boolean z = !x() && this.x;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        l3(i2, abs);
        int o = d.o(this.D) + z2(vVar, a2, this.D);
        if (o < 0) {
            return 0;
        }
        if (z) {
            if (abs > o) {
                i = (-i2) * o;
            }
        } else if (abs > o) {
            i = i2 * o;
        }
        this.F.r(-i);
        d.A(this.D, i);
        return i;
    }

    public int R(RecyclerView.A a2) {
        return v2(a2);
    }

    public final int R2(int i) {
        int j;
        if (h0() == 0 || i == 0) {
            return 0;
        }
        y2();
        boolean x = x();
        View view = this.P;
        int width = x ? view.getWidth() : view.getHeight();
        int I0 = x ? I0() : u0();
        if (x0() == 1) {
            int abs = Math.abs(i);
            if (i < 0) {
                j = Math.min((I0 + b.j(this.E)) - width, abs);
                return -j;
            }
            if (b.j(this.E) + i <= 0) {
                return i;
            }
        } else {
            if (i > 0) {
                return Math.min((I0 - b.j(this.E)) - width, i);
            }
            if (b.j(this.E) + i >= 0) {
                return i;
            }
        }
        j = b.j(this.E);
        return -j;
    }

    public int S(RecyclerView.A a2) {
        return w2(a2);
    }

    public final boolean S2(View view, boolean z) {
        int o = o();
        int n = n();
        int I0 = I0() - k();
        int u0 = u0() - b();
        int M2 = M2(view);
        int O2 = O2(view);
        int N2 = N2(view);
        int K2 = K2(view);
        return z ? (o <= M2 && I0 >= N2) && (n <= O2 && u0 >= K2) : (M2 >= I0 || N2 >= o) && (O2 >= u0 || K2 >= n);
    }

    public int T1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (!x() || this.t == 0) {
            int Q2 = Q2(i, vVar, a2);
            this.N.clear();
            return Q2;
        }
        int R2 = R2(i);
        b.l(this.E, R2);
        this.G.r(-R2);
        return R2;
    }

    public final int T2(g4.c cVar, d dVar) {
        return x() ? U2(cVar, dVar) : V2(cVar, dVar);
    }

    public void U1(int i) {
        this.I = i;
        this.J = Integer.MIN_VALUE;
        e eVar = this.H;
        if (eVar != null) {
            e.f(eVar);
        }
        Q1();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int U2(g4.c r22, com.google.android.flexbox.FlexboxLayoutManager.d r23) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.U2(g4.c, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    public int V1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (x() || (this.t == 0 && !x())) {
            int Q2 = Q2(i, vVar, a2);
            this.N.clear();
            return Q2;
        }
        int R2 = R2(i);
        b.l(this.E, R2);
        this.G.r(-R2);
        return R2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int V2(g4.c r26, com.google.android.flexbox.FlexboxLayoutManager.d r27) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.V2(g4.c, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    public final void W2(RecyclerView.v vVar, d dVar) {
        if (d.B(dVar)) {
            if (d.w(dVar) == -1) {
                Y2(vVar, dVar);
            } else {
                Z2(vVar, dVar);
            }
        }
    }

    public final void X2(RecyclerView.v vVar, int i, int i2) {
        while (i2 >= i) {
            K1(i2, vVar);
            i2--;
        }
    }

    public final void Y2(RecyclerView.v vVar, d dVar) {
        int h0;
        int i;
        View g0;
        int i2;
        if (d.o(dVar) < 0 || (h0 = h0()) == 0 || (g0 = g0(h0 - 1)) == null || (i2 = this.A.c[B0(g0)]) == -1) {
            return;
        }
        g4.c cVar = (g4.c) this.z.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            View g02 = g0(i3);
            if (g02 != null) {
                if (!r2(g02, d.o(dVar))) {
                    break;
                }
                if (cVar.o != B0(g02)) {
                    continue;
                } else if (i2 <= 0) {
                    h0 = i3;
                    break;
                } else {
                    i2 += d.w(dVar);
                    cVar = (g4.c) this.z.get(i2);
                    h0 = i3;
                }
            }
            i3--;
        }
        X2(vVar, h0, i);
    }

    public final void Z2(RecyclerView.v vVar, d dVar) {
        int h0;
        View g0;
        if (d.o(dVar) < 0 || (h0 = h0()) == 0 || (g0 = g0(0)) == null) {
            return;
        }
        int i = this.A.c[B0(g0)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        g4.c cVar = (g4.c) this.z.get(i);
        int i3 = 0;
        while (true) {
            if (i3 >= h0) {
                break;
            }
            View g02 = g0(i3);
            if (g02 != null) {
                if (!s2(g02, d.o(dVar))) {
                    break;
                }
                if (cVar.p != B0(g02)) {
                    continue;
                } else if (i >= this.z.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += d.w(dVar);
                    cVar = (g4.c) this.z.get(i);
                    i2 = i3;
                }
            }
            i3++;
        }
        X2(vVar, 0, i2);
    }

    public void a1(RecyclerView.g gVar, RecyclerView.g gVar2) {
        G1();
    }

    public final void a3() {
        int v0 = x() ? v0() : J0();
        d.f(this.D, v0 == 0 || v0 == Integer.MIN_VALUE);
    }

    public RecyclerView.p b0() {
        return new c(-2, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b3() {
        /*
            r6 = this;
            int r0 = r6.x0()
            int r1 = r6.s
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L43
            if (r1 == r4) goto L36
            if (r1 == r2) goto L27
            r5 = 3
            if (r1 == r5) goto L17
            r6.x = r3
        L14:
            r6.y = r3
            goto L4f
        L17:
            if (r0 != r4) goto L1a
            r3 = 1
        L1a:
            r6.x = r3
            int r0 = r6.t
            if (r0 != r2) goto L24
            r0 = r3 ^ 1
            r6.x = r0
        L24:
            r6.y = r4
            goto L4f
        L27:
            if (r0 != r4) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            r6.x = r0
            int r1 = r6.t
            if (r1 != r2) goto L14
            r0 = r0 ^ r4
            r6.x = r0
            goto L14
        L36:
            if (r0 == r4) goto L3a
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            r6.x = r0
            int r0 = r6.t
            if (r0 != r2) goto L14
        L41:
            r3 = 1
            goto L14
        L43:
            if (r0 != r4) goto L47
            r0 = 1
            goto L48
        L47:
            r0 = 0
        L48:
            r6.x = r0
            int r0 = r6.t
            if (r0 != r2) goto L14
            goto L41
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.b3():void");
    }

    public RecyclerView.p c0(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public void c1(RecyclerView recyclerView) {
        super.c1(recyclerView);
        this.P = recyclerView.getParent();
    }

    public void c3(int i) {
        int i2 = this.v;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                G1();
                t2();
            }
            this.v = i;
            Q1();
        }
    }

    public int d() {
        return this.C.c();
    }

    public void d3(int i) {
        if (this.s != i) {
            G1();
            this.s = i;
            this.F = null;
            this.G = null;
            t2();
            Q1();
        }
    }

    public PointF e(int i) {
        View g0;
        if (h0() == 0 || (g0 = g0(0)) == null) {
            return null;
        }
        int i2 = i < B0(g0) ? -1 : 1;
        return x() ? new PointF(0.0f, i2) : new PointF(i2, 0.0f);
    }

    public void e1(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.e1(recyclerView, vVar);
        if (this.M) {
            H1(vVar);
            vVar.c();
        }
    }

    public void e3(int i) {
        if (i == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i2 = this.t;
        if (i2 != i) {
            if (i2 == 0 || i == 0) {
                G1();
                t2();
            }
            this.t = i;
            this.F = null;
            this.G = null;
            Q1();
        }
    }

    public int f() {
        return this.s;
    }

    public void f3(int i) {
        if (this.u != i) {
            this.u = i;
            Q1();
        }
    }

    public int g() {
        return this.w;
    }

    public void g2(RecyclerView recyclerView, RecyclerView.A a2, int i) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i);
        h2(hVar);
    }

    public final boolean g3(RecyclerView.A a2, b bVar) {
        if (h0() == 0) {
            return false;
        }
        View D2 = b.p(bVar) ? D2(a2.c()) : A2(a2.c());
        if (D2 == null) {
            return false;
        }
        b.i(bVar, D2);
        if (a2.h() || !j2()) {
            return true;
        }
        if (this.F.g(D2) < this.F.i() && this.F.d(D2) >= this.F.m()) {
            return true;
        }
        b.g(bVar, b.p(bVar) ? this.F.i() : this.F.m());
        return true;
    }

    public int h() {
        if (this.z.size() == 0) {
            return 0;
        }
        int size = this.z.size();
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, ((g4.c) this.z.get(i2)).e);
        }
        return i;
    }

    public final boolean h3(RecyclerView.A a2, b bVar, e eVar) {
        int i;
        View g0;
        if (!a2.h() && (i = this.I) != -1) {
            if (i >= 0 && i < a2.c()) {
                b.b(bVar, this.I);
                b.d(bVar, this.A.c[b.a(bVar)]);
                e eVar2 = this.H;
                if (eVar2 != null && e.g(eVar2, a2.c())) {
                    b.g(bVar, this.F.m() + e.d(eVar));
                    b.h(bVar, true);
                    b.d(bVar, -1);
                    return true;
                }
                if (this.J != Integer.MIN_VALUE) {
                    b.g(bVar, (x() || !this.x) ? this.F.m() + this.J : this.J - this.F.j());
                    return true;
                }
                View a0 = a0(this.I);
                if (a0 == null) {
                    if (h0() > 0 && (g0 = g0(0)) != null) {
                        b.q(bVar, this.I < B0(g0));
                    }
                    b.e(bVar);
                } else {
                    if (this.F.e(a0) > this.F.n()) {
                        b.e(bVar);
                        return true;
                    }
                    if (this.F.g(a0) - this.F.m() < 0) {
                        b.g(bVar, this.F.m());
                        b.q(bVar, false);
                        return true;
                    }
                    if (this.F.i() - this.F.d(a0) < 0) {
                        b.g(bVar, this.F.i());
                        b.q(bVar, true);
                        return true;
                    }
                    b.g(bVar, b.p(bVar) ? this.F.d(a0) + this.F.o() : this.F.g(a0));
                }
                return true;
            }
            this.I = -1;
            this.J = Integer.MIN_VALUE;
        }
        return false;
    }

    public int i(int i, int i2, int i3) {
        return RecyclerView.o.i0(I0(), J0(), i2, i3, H());
    }

    public final void i3(RecyclerView.A a2, b bVar) {
        if (h3(a2, bVar, this.H) || g3(a2, bVar)) {
            return;
        }
        b.e(bVar);
        b.b(bVar, 0);
        b.d(bVar, 0);
    }

    public final void j3(int i) {
        if (i >= F2()) {
            return;
        }
        int h0 = h0();
        this.A.m(h0);
        this.A.n(h0);
        this.A.l(h0);
        if (i >= this.A.c.length) {
            return;
        }
        this.Q = i;
        View L2 = L2();
        if (L2 == null) {
            return;
        }
        this.I = B0(L2);
        this.J = (x() || !this.x) ? this.F.g(L2) - this.F.m() : this.F.d(L2) + this.F.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0046 A[PHI: r5
      0x0046: PHI (r5v3 boolean) = (r5v1 boolean), (r5v12 boolean) binds: [B:49:0x005b, B:8:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k3(int r12) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.k3(int):void");
    }

    public List l() {
        return this.z;
    }

    public final void l3(int i, int i2) {
        d.x(this.D, i);
        boolean x = x();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(I0(), J0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(u0(), v0());
        boolean z = !x && this.x;
        if (i == 1) {
            View g0 = g0(h0() - 1);
            if (g0 == null) {
                return;
            }
            d.b(this.D, this.F.d(g0));
            int B0 = B0(g0);
            View E2 = E2(g0, (g4.c) this.z.get(this.A.c[B0]));
            d.z(this.D, 1);
            d dVar = this.D;
            d.t(dVar, B0 + d.y(dVar));
            if (this.A.c.length <= d.s(this.D)) {
                d.k(this.D, -1);
            } else {
                d dVar2 = this.D;
                d.k(dVar2, this.A.c[d.s(dVar2)]);
            }
            if (z) {
                d.b(this.D, this.F.g(E2));
                d.p(this.D, (-this.F.g(E2)) + this.F.m());
                d dVar3 = this.D;
                d.p(dVar3, Math.max(d.o(dVar3), 0));
            } else {
                d.b(this.D, this.F.d(E2));
                d.p(this.D, this.F.d(E2) - this.F.i());
            }
            if ((d.j(this.D) == -1 || d.j(this.D) > this.z.size() - 1) && d.s(this.D) <= d()) {
                int o = i2 - d.o(this.D);
                this.R.a();
                if (o > 0) {
                    com.google.android.flexbox.a aVar = this.A;
                    a.a aVar2 = this.R;
                    int s = d.s(this.D);
                    List list = this.z;
                    if (x) {
                        aVar.c(aVar2, makeMeasureSpec, makeMeasureSpec2, o, s, list);
                    } else {
                        aVar.e(aVar2, makeMeasureSpec, makeMeasureSpec2, o, s, list);
                    }
                    this.A.j(makeMeasureSpec, makeMeasureSpec2, d.s(this.D));
                    this.A.P(d.s(this.D));
                }
            }
        } else {
            View g02 = g0(0);
            if (g02 == null) {
                return;
            }
            d.b(this.D, this.F.g(g02));
            int B02 = B0(g02);
            View B2 = B2(g02, (g4.c) this.z.get(this.A.c[B02]));
            d.z(this.D, 1);
            int i3 = this.A.c[B02];
            if (i3 == -1) {
                i3 = 0;
            }
            if (i3 > 0) {
                d.t(this.D, B02 - ((g4.c) this.z.get(i3 - 1)).b());
            } else {
                d.t(this.D, -1);
            }
            d.k(this.D, i3 > 0 ? i3 - 1 : 0);
            d dVar4 = this.D;
            j jVar = this.F;
            if (z) {
                d.b(dVar4, jVar.d(B2));
                d.p(this.D, this.F.d(B2) - this.F.i());
                d dVar5 = this.D;
                d.p(dVar5, Math.max(d.o(dVar5), 0));
            } else {
                d.b(dVar4, jVar.g(B2));
                d.p(this.D, (-this.F.g(B2)) + this.F.m());
            }
        }
        d dVar6 = this.D;
        d.h(dVar6, i2 - d.o(dVar6));
    }

    public int m(int i, int i2, int i3) {
        return RecyclerView.o.i0(u0(), v0(), i2, i3, I());
    }

    public final void m3(b bVar, boolean z, boolean z2) {
        d dVar;
        int i;
        int f;
        if (z2) {
            a3();
        } else {
            d.f(this.D, false);
        }
        if (x() || !this.x) {
            dVar = this.D;
            i = this.F.i();
            f = b.f(bVar);
        } else {
            dVar = this.D;
            i = b.f(bVar);
            f = k();
        }
        d.h(dVar, i - f);
        d.t(this.D, b.a(bVar));
        d.z(this.D, 1);
        d.x(this.D, 1);
        d.b(this.D, b.f(bVar));
        d.p(this.D, Integer.MIN_VALUE);
        d.k(this.D, b.c(bVar));
        if (!z || this.z.size() <= 1 || b.c(bVar) < 0 || b.c(bVar) >= this.z.size() - 1) {
            return;
        }
        g4.c cVar = (g4.c) this.z.get(b.c(bVar));
        d.l(this.D);
        d.u(this.D, cVar.b());
    }

    public void n1(RecyclerView recyclerView, int i, int i2) {
        super.n1(recyclerView, i, i2);
        j3(i);
    }

    public final void n3(b bVar, boolean z, boolean z2) {
        d dVar;
        int f;
        if (z2) {
            a3();
        } else {
            d.f(this.D, false);
        }
        if (x() || !this.x) {
            dVar = this.D;
            f = b.f(bVar);
        } else {
            dVar = this.D;
            f = this.P.getWidth() - b.f(bVar);
        }
        d.h(dVar, f - this.F.m());
        d.t(this.D, b.a(bVar));
        d.z(this.D, 1);
        d.x(this.D, -1);
        d.b(this.D, b.f(bVar));
        d.p(this.D, Integer.MIN_VALUE);
        d.k(this.D, b.c(bVar));
        if (!z || b.c(bVar) <= 0 || this.z.size() <= b.c(bVar)) {
            return;
        }
        g4.c cVar = (g4.c) this.z.get(b.c(bVar));
        d.m(this.D);
        d.v(this.D, cVar.b());
    }

    public int p(View view) {
        int y0;
        int D0;
        if (x()) {
            y0 = G0(view);
            D0 = f0(view);
        } else {
            y0 = y0(view);
            D0 = D0(view);
        }
        return y0 + D0;
    }

    public void p1(RecyclerView recyclerView, int i, int i2, int i3) {
        super.p1(recyclerView, i, i2, i3);
        j3(Math.min(i, i2));
    }

    public void q(View view, int i, int i2, g4.c cVar) {
        int G0;
        int f0;
        G(view, S);
        if (x()) {
            G0 = y0(view);
            f0 = D0(view);
        } else {
            G0 = G0(view);
            f0 = f0(view);
        }
        int i3 = G0 + f0;
        cVar.e += i3;
        cVar.f += i3;
    }

    public void q1(RecyclerView recyclerView, int i, int i2) {
        super.q1(recyclerView, i, i2);
        j3(i);
    }

    public int r() {
        return this.t;
    }

    public void r1(RecyclerView recyclerView, int i, int i2) {
        super.r1(recyclerView, i, i2);
        j3(i);
    }

    public final boolean r2(View view, int i) {
        return (x() || !this.x) ? this.F.g(view) >= this.F.h() - i : this.F.d(view) <= i;
    }

    public View s(int i) {
        return P2(i);
    }

    public void s1(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.s1(recyclerView, i, i2, obj);
        j3(i);
    }

    public final boolean s2(View view, int i) {
        return (x() || !this.x) ? this.F.d(view) <= i : this.F.h() - this.F.g(view) <= i;
    }

    public int t() {
        return this.v;
    }

    public void t1(RecyclerView.v vVar, RecyclerView.A a2) {
        int a3;
        int a4;
        this.B = vVar;
        this.C = a2;
        int c2 = a2.c();
        if (c2 == 0 && a2.h()) {
            return;
        }
        b3();
        y2();
        x2();
        this.A.m(c2);
        this.A.n(c2);
        this.A.l(c2);
        d.C(this.D, false);
        e eVar = this.H;
        if (eVar != null && e.g(eVar, c2)) {
            this.I = e.a(this.H);
        }
        if (!b.m(this.E) || this.I != -1 || this.H != null) {
            b.o(this.E);
            i3(a2, this.E);
            b.n(this.E, true);
        }
        T(vVar);
        if (b.p(this.E)) {
            n3(this.E, false, true);
        } else {
            m3(this.E, false, true);
        }
        k3(c2);
        z2(vVar, a2, this.D);
        if (b.p(this.E)) {
            a4 = d.a(this.D);
            m3(this.E, true, false);
            z2(vVar, a2, this.D);
            a3 = d.a(this.D);
        } else {
            a3 = d.a(this.D);
            n3(this.E, true, false);
            z2(vVar, a2, this.D);
            a4 = d.a(this.D);
        }
        if (h0() > 0) {
            if (b.p(this.E)) {
                J2(a4 + I2(a3, vVar, a2, true), vVar, a2, false);
            } else {
                I2(a3 + J2(a4, vVar, a2, true), vVar, a2, false);
            }
        }
    }

    public final void t2() {
        this.z.clear();
        b.o(this.E);
        b.k(this.E, 0);
    }

    public void u(int i, View view) {
        this.N.put(i, view);
    }

    public void u1(RecyclerView.A a2) {
        super.u1(a2);
        this.H = null;
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.Q = -1;
        b.o(this.E);
        this.N.clear();
    }

    public final int u2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        int c2 = a2.c();
        y2();
        View A2 = A2(c2);
        View D2 = D2(c2);
        if (a2.c() == 0 || A2 == null || D2 == null) {
            return 0;
        }
        return Math.min(this.F.n(), this.F.d(D2) - this.F.g(A2));
    }

    public int v(View view, int i, int i2) {
        int G0;
        int f0;
        if (x()) {
            G0 = y0(view);
            f0 = D0(view);
        } else {
            G0 = G0(view);
            f0 = f0(view);
        }
        return G0 + f0;
    }

    public final int v2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        int c2 = a2.c();
        View A2 = A2(c2);
        View D2 = D2(c2);
        if (a2.c() != 0 && A2 != null && D2 != null) {
            int B0 = B0(A2);
            int B02 = B0(D2);
            int abs = Math.abs(this.F.d(D2) - this.F.g(A2));
            int i = this.A.c[B0];
            if (i != 0 && i != -1) {
                return Math.round((i * (abs / ((r4[B02] - i) + 1))) + (this.F.m() - this.F.g(A2)));
            }
        }
        return 0;
    }

    public final int w2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        int c2 = a2.c();
        View A2 = A2(c2);
        View D2 = D2(c2);
        if (a2.c() == 0 || A2 == null || D2 == null) {
            return 0;
        }
        int C2 = C2();
        return (int) ((Math.abs(this.F.d(D2) - this.F.g(A2)) / ((F2() - C2) + 1)) * a2.c());
    }

    public boolean x() {
        int i = this.s;
        return i == 0 || i == 1;
    }

    public void y1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.H = (e) parcelable;
            Q1();
        }
    }

    public final void y2() {
        j a2;
        if (this.F != null) {
            return;
        }
        if (!x() ? this.t == 0 : this.t != 0) {
            this.F = j.a(this);
            a2 = j.c(this);
        } else {
            this.F = j.c(this);
            a2 = j.a(this);
        }
        this.G = a2;
    }

    public Parcelable z1() {
        if (this.H != null) {
            return new e(this.H, (a) null);
        }
        e eVar = new e();
        if (h0() > 0) {
            View L2 = L2();
            e.c(eVar, B0(L2));
            e.e(eVar, this.F.g(L2) - this.F.m());
        } else {
            e.f(eVar);
        }
        return eVar;
    }

    public final int z2(RecyclerView.v vVar, RecyclerView.A a2, d dVar) {
        if (d.o(dVar) != Integer.MIN_VALUE) {
            if (d.g(dVar) < 0) {
                d.q(dVar, d.g(dVar));
            }
            W2(vVar, dVar);
        }
        int g = d.g(dVar);
        int g2 = d.g(dVar);
        boolean x = x();
        int i = 0;
        while (true) {
            if ((g2 > 0 || d.e(this.D)) && d.r(dVar, a2, this.z)) {
                g4.c cVar = (g4.c) this.z.get(d.j(dVar));
                d.t(dVar, cVar.o);
                i += T2(cVar, dVar);
                if (x || !this.x) {
                    d.c(dVar, cVar.a() * d.w(dVar));
                } else {
                    d.d(dVar, cVar.a() * d.w(dVar));
                }
                g2 -= cVar.a();
            }
        }
        d.i(dVar, i);
        if (d.o(dVar) != Integer.MIN_VALUE) {
            d.q(dVar, i);
            if (d.g(dVar) < 0) {
                d.q(dVar, d.g(dVar));
            }
            W2(vVar, dVar);
        }
        return g - d.g(dVar);
    }

    public FlexboxLayoutManager(Context context, int i, int i2) {
        this.w = -1;
        this.z = new ArrayList();
        this.A = new com.google.android.flexbox.a(this);
        this.E = new b(this, null);
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new SparseArray();
        this.Q = -1;
        this.R = new a.a();
        d3(i);
        e3(i2);
        c3(4);
        this.O = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        int i3;
        this.w = -1;
        this.z = new ArrayList();
        this.A = new com.google.android.flexbox.a(this);
        this.E = new b(this, null);
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new SparseArray();
        this.Q = -1;
        this.R = new a.a();
        RecyclerView.o.d C0 = RecyclerView.o.C0(context, attributeSet, i, i2);
        int i4 = C0.a;
        if (i4 != 0) {
            if (i4 == 1) {
                i3 = C0.c ? 3 : 2;
                d3(i3);
            }
        } else if (C0.c) {
            d3(1);
        } else {
            i3 = 0;
            d3(i3);
        }
        e3(1);
        c3(4);
        this.O = context;
    }

    public void a(g4.c cVar) {
    }
}
