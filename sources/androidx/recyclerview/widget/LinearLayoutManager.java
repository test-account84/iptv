package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements f.h, RecyclerView.z.b {
    public int A;
    public int B;
    public boolean C;
    public d D;
    public final a E;
    public final b F;
    public int G;
    public int[] H;
    public int s;
    public c t;
    public j u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static class a {
        public j a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        public a() {
            e();
        }

        public void a() {
            this.c = this.d ? this.a.i() : this.a.m();
        }

        public void b(View view, int i) {
            this.c = this.d ? this.a.d(view) + this.a.o() : this.a.g(view);
            this.b = i;
        }

        public void c(View view, int i) {
            int o = this.a.o();
            if (o >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int i2 = (this.a.i() - o) - this.a.d(view);
                this.c = this.a.i() - i2;
                if (i2 > 0) {
                    int e = this.c - this.a.e(view);
                    int m = this.a.m();
                    int min = e - (m + Math.min(this.a.g(view) - m, 0));
                    if (min < 0) {
                        this.c += Math.min(i2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g = this.a.g(view);
            int m2 = g - this.a.m();
            this.c = g;
            if (m2 > 0) {
                int i3 = (this.a.i() - Math.min(0, (this.a.i() - o) - this.a.d(view))) - (g + this.a.e(view));
                if (i3 < 0) {
                    this.c -= Math.min(m2, -i3);
                }
            }
        }

        public boolean d(View view, RecyclerView.A a) {
            RecyclerView.p layoutParams = view.getLayoutParams();
            return !layoutParams.e() && layoutParams.c() >= 0 && layoutParams.c() < a.c();
        }

        public void e() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    public static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        public void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    public static class c {
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int k;
        public boolean m;
        public boolean a = true;
        public int h = 0;
        public int i = 0;
        public boolean j = false;
        public List l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f = f(view);
            this.d = f == null ? -1 : f.getLayoutParams().c();
        }

        public boolean c(RecyclerView.A a) {
            int i = this.d;
            return i >= 0 && i < a.c();
        }

        public View d(RecyclerView.v vVar) {
            if (this.l != null) {
                return e();
            }
            View o = vVar.o(this.d);
            this.d += this.e;
            return o;
        }

        public final View e() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = ((RecyclerView.D) this.l.get(i)).a;
                RecyclerView.p layoutParams = view.getLayoutParams();
                if (!layoutParams.e() && this.d == layoutParams.c()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int c;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((RecyclerView.D) this.l.get(i2)).a;
                RecyclerView.p layoutParams = view3.getLayoutParams();
                if (view3 != view && !layoutParams.e() && (c = (layoutParams.c() - this.d) * this.e) >= 0 && c < i) {
                    view2 = view3;
                    if (c == 0) {
                        break;
                    }
                    i = c;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public int c;
        public boolean d;

        public static class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        public boolean a() {
            return this.a >= 0;
        }

        public void c() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.a = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.a = dVar.a;
            this.c = dVar.c;
            this.d = dVar.d;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int I2(int i, RecyclerView.v vVar, RecyclerView.A a2, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -Z2(-i3, vVar, a2);
        int i5 = i + i4;
        if (!z || (i2 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i2);
        return i2 + i4;
    }

    private int J2(int i, RecyclerView.v vVar, RecyclerView.A a2, boolean z) {
        int m;
        int m2 = i - this.u.m();
        if (m2 <= 0) {
            return 0;
        }
        int i2 = -Z2(m2, vVar, a2);
        int i3 = i + i2;
        if (!z || (m = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-m);
        return i2 - m;
    }

    private View L2() {
        return g0(this.x ? h0() - 1 : 0);
    }

    private void U2(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                K1(i, vVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                K1(i3, vVar);
            }
        }
    }

    private int m2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        r2();
        return m.a(a2, this.u, w2(!this.z, true), v2(!this.z, true), this, this.z);
    }

    private int n2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        r2();
        return m.b(a2, this.u, w2(!this.z, true), v2(!this.z, true), this, this.z, this.x);
    }

    private int o2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        r2();
        return m.c(a2, this.u, w2(!this.z, true), v2(!this.z, true), this, this.z);
    }

    public int A2() {
        View C2 = C2(h0() - 1, -1, false, true);
        if (C2 == null) {
            return -1;
        }
        return B0(C2);
    }

    public View B2(int i, int i2) {
        int i3;
        int i4;
        r2();
        if (i2 <= i && i2 >= i) {
            return g0(i);
        }
        if (this.u.g(g0(i)) < this.u.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.s == 0 ? this.e : this.f).a(i, i2, i3, i4);
    }

    public View C2(int i, int i2, boolean z, boolean z2) {
        r2();
        return (this.s == 0 ? this.e : this.f).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    public void D(String str) {
        if (this.D == null) {
            super.D(str);
        }
    }

    public final View D2() {
        return this.x ? t2() : y2();
    }

    public final View E2() {
        return this.x ? y2() : t2();
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
            if (B0 >= 0 && B0 < i3) {
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

    public final View G2(RecyclerView.v vVar, RecyclerView.A a2) {
        return this.x ? u2(vVar, a2) : z2(vVar, a2);
    }

    public boolean H() {
        return this.s == 0;
    }

    public final View H2(RecyclerView.v vVar, RecyclerView.A a2) {
        return this.x ? z2(vVar, a2) : u2(vVar, a2);
    }

    public boolean I() {
        return this.s == 1;
    }

    public final View K2() {
        return g0(this.x ? 0 : h0() - 1);
    }

    public void L(int i, int i2, RecyclerView.A a2, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (h0() == 0 || i == 0) {
            return;
        }
        r2();
        h3(i > 0 ? 1 : -1, Math.abs(i), true, a2);
        l2(a2, this.t, cVar);
    }

    public void M(int i, RecyclerView.o.c cVar) {
        boolean z;
        int i2;
        d dVar = this.D;
        if (dVar == null || !dVar.a()) {
            Y2();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z = dVar2.d;
            i2 = dVar2.a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    public int M2(RecyclerView.A a2) {
        if (a2.g()) {
            return this.u.n();
        }
        return 0;
    }

    public int N(RecyclerView.A a2) {
        return m2(a2);
    }

    public boolean N0() {
        return true;
    }

    public int N2() {
        return this.s;
    }

    public int O(RecyclerView.A a2) {
        return n2(a2);
    }

    public boolean O2() {
        return x0() == 1;
    }

    public int P(RecyclerView.A a2) {
        return o2(a2);
    }

    public boolean P2() {
        return this.z;
    }

    public int Q(RecyclerView.A a2) {
        return m2(a2);
    }

    public void Q2(RecyclerView.v vVar, RecyclerView.A a2, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View d2 = cVar.d(vVar);
        if (d2 == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.p layoutParams = d2.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f == -1)) {
                A(d2);
            } else {
                B(d2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                y(d2);
            } else {
                z(d2, 0);
            }
        }
        W0(d2, 0, 0);
        bVar.a = this.u.e(d2);
        if (this.s == 1) {
            if (O2()) {
                f = I0() - k();
                i4 = f - this.u.f(d2);
            } else {
                i4 = o();
                f = this.u.f(d2) + i4;
            }
            int i5 = cVar.f;
            int i6 = cVar.b;
            if (i5 == -1) {
                i3 = i6;
                i2 = f;
                i = i6 - bVar.a;
            } else {
                i = i6;
                i2 = f;
                i3 = bVar.a + i6;
            }
        } else {
            int n = n();
            int f2 = this.u.f(d2) + n;
            int i7 = cVar.f;
            int i8 = cVar.b;
            if (i7 == -1) {
                i2 = i8;
                i = n;
                i3 = f2;
                i4 = i8 - bVar.a;
            } else {
                i = n;
                i2 = bVar.a + i8;
                i3 = f2;
                i4 = i8;
            }
        }
        V0(d2, i4, i, i2, i3);
        if (layoutParams.e() || layoutParams.d()) {
            bVar.c = true;
        }
        bVar.d = d2.hasFocusable();
    }

    public int R(RecyclerView.A a2) {
        return n2(a2);
    }

    public final void R2(RecyclerView.v vVar, RecyclerView.A a2, int i, int i2) {
        if (!a2.j() || h0() == 0 || a2.h() || !j2()) {
            return;
        }
        List k = vVar.k();
        int size = k.size();
        int B0 = B0(g0(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.D d2 = (RecyclerView.D) k.get(i5);
            if (!d2.y()) {
                if ((d2.p() < B0) != this.x) {
                    i3 += this.u.e(d2.a);
                } else {
                    i4 += this.u.e(d2.a);
                }
            }
        }
        this.t.l = k;
        if (i3 > 0) {
            k3(B0(L2()), i);
            c cVar = this.t;
            cVar.h = i3;
            cVar.c = 0;
            cVar.a();
            s2(vVar, this.t, a2, false);
        }
        if (i4 > 0) {
            i3(B0(K2()), i2);
            c cVar2 = this.t;
            cVar2.h = i4;
            cVar2.c = 0;
            cVar2.a();
            s2(vVar, this.t, a2, false);
        }
        this.t.l = null;
    }

    public int S(RecyclerView.A a2) {
        return o2(a2);
    }

    public void S2(RecyclerView.v vVar, RecyclerView.A a2, a aVar, int i) {
    }

    public int T1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (this.s == 1) {
            return 0;
        }
        return Z2(i, vVar, a2);
    }

    public final void T2(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            V2(vVar, i, i2);
        } else {
            W2(vVar, i, i2);
        }
    }

    public void U1(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.c();
        }
        Q1();
    }

    public int V1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (this.s == 0) {
            return 0;
        }
        return Z2(i, vVar, a2);
    }

    public final void V2(RecyclerView.v vVar, int i, int i2) {
        int h0 = h0();
        if (i < 0) {
            return;
        }
        int h = (this.u.h() - i) + i2;
        if (this.x) {
            for (int i3 = 0; i3 < h0; i3++) {
                View g0 = g0(i3);
                if (this.u.g(g0) < h || this.u.q(g0) < h) {
                    U2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = h0 - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View g02 = g0(i5);
            if (this.u.g(g02) < h || this.u.q(g02) < h) {
                U2(vVar, i4, i5);
                return;
            }
        }
    }

    public final void W2(RecyclerView.v vVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int h0 = h0();
        if (!this.x) {
            for (int i4 = 0; i4 < h0; i4++) {
                View g0 = g0(i4);
                if (this.u.d(g0) > i3 || this.u.p(g0) > i3) {
                    U2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = h0 - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View g02 = g0(i6);
            if (this.u.d(g02) > i3 || this.u.p(g02) > i3) {
                U2(vVar, i5, i6);
                return;
            }
        }
    }

    public boolean X2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }

    public final void Y2() {
        this.x = (this.s == 1 || !O2()) ? this.w : !this.w;
    }

    public int Z2(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (h0() == 0 || i == 0) {
            return 0;
        }
        r2();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        h3(i2, abs, true, a2);
        c cVar = this.t;
        int s2 = cVar.g + s2(vVar, cVar, a2, false);
        if (s2 < 0) {
            return 0;
        }
        if (abs > s2) {
            i = i2 * s2;
        }
        this.u.r(-i);
        this.t.k = i;
        return i;
    }

    public View a0(int i) {
        int h0 = h0();
        if (h0 == 0) {
            return null;
        }
        int B0 = i - B0(g0(0));
        if (B0 >= 0 && B0 < h0) {
            View g0 = g0(B0);
            if (B0(g0) == i) {
                return g0;
            }
        }
        return super.a0(i);
    }

    public void a3(int i, int i2) {
        this.A = i;
        this.B = i2;
        d dVar = this.D;
        if (dVar != null) {
            dVar.c();
        }
        Q1();
    }

    public RecyclerView.p b0() {
        return new RecyclerView.p(-2, -2);
    }

    public void b3(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        D(null);
        if (i != this.s || this.u == null) {
            j b2 = j.b(this, i);
            this.u = b2;
            this.E.a = b2;
            this.s = i;
            Q1();
        }
    }

    public void c3(boolean z) {
        D(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        Q1();
    }

    public void d3(boolean z) {
        D(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        Q1();
    }

    public PointF e(int i) {
        if (h0() == 0) {
            return null;
        }
        int i2 = (i < B0(g0(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public void e1(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.e1(recyclerView, vVar);
        if (this.C) {
            H1(vVar);
            vVar.c();
        }
    }

    public boolean e2() {
        return (v0() == 1073741824 || J0() == 1073741824 || !K0()) ? false : true;
    }

    public final boolean e3(RecyclerView.v vVar, RecyclerView.A a2, a aVar) {
        if (h0() == 0) {
            return false;
        }
        View t0 = t0();
        if (t0 != null && aVar.d(t0, a2)) {
            aVar.c(t0, B0(t0));
            return true;
        }
        if (this.v != this.y) {
            return false;
        }
        View G2 = aVar.d ? G2(vVar, a2) : H2(vVar, a2);
        if (G2 == null) {
            return false;
        }
        aVar.b(G2, B0(G2));
        if (!a2.h() && j2() && (this.u.g(G2) >= this.u.i() || this.u.d(G2) < this.u.m())) {
            aVar.c = aVar.d ? this.u.i() : this.u.m();
        }
        return true;
    }

    public View f1(View view, int i, RecyclerView.v vVar, RecyclerView.A a2) {
        int p2;
        Y2();
        if (h0() == 0 || (p2 = p2(i)) == Integer.MIN_VALUE) {
            return null;
        }
        r2();
        h3(p2, (int) (this.u.n() * 0.33333334f), false, a2);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.a = false;
        s2(vVar, cVar, a2, true);
        View E2 = p2 == -1 ? E2() : D2();
        View L2 = p2 == -1 ? L2() : K2();
        if (!L2.hasFocusable()) {
            return E2;
        }
        if (E2 == null) {
            return null;
        }
        return L2;
    }

    public final boolean f3(RecyclerView.A a2, a aVar) {
        int i;
        if (!a2.h() && (i = this.A) != -1) {
            if (i >= 0 && i < a2.c()) {
                aVar.b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.a()) {
                    boolean z = this.D.d;
                    aVar.d = z;
                    aVar.c = z ? this.u.i() - this.D.c : this.u.m() + this.D.c;
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.x;
                    aVar.d = z2;
                    aVar.c = z2 ? this.u.i() - this.B : this.u.m() + this.B;
                    return true;
                }
                View a0 = a0(this.A);
                if (a0 == null) {
                    if (h0() > 0) {
                        aVar.d = (this.A < B0(g0(0))) == this.x;
                    }
                    aVar.a();
                } else {
                    if (this.u.e(a0) > this.u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.u.g(a0) - this.u.m() < 0) {
                        aVar.c = this.u.m();
                        aVar.d = false;
                        return true;
                    }
                    if (this.u.i() - this.u.d(a0) < 0) {
                        aVar.c = this.u.i();
                        aVar.d = true;
                        return true;
                    }
                    aVar.c = aVar.d ? this.u.d(a0) + this.u.o() : this.u.g(a0);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    public void g1(AccessibilityEvent accessibilityEvent) {
        super.g1(accessibilityEvent);
        if (h0() > 0) {
            accessibilityEvent.setFromIndex(x2());
            accessibilityEvent.setToIndex(A2());
        }
    }

    public void g2(RecyclerView recyclerView, RecyclerView.A a2, int i) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i);
        h2(hVar);
    }

    public final void g3(RecyclerView.v vVar, RecyclerView.A a2, a aVar) {
        if (f3(a2, aVar) || e3(vVar, a2, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.y ? a2.c() - 1 : 0;
    }

    public final void h3(int i, int i2, boolean z, RecyclerView.A a2) {
        int m;
        this.t.m = X2();
        this.t.f = i;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        k2(a2, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        boolean z2 = i == 1;
        c cVar = this.t;
        int i3 = z2 ? max2 : max;
        cVar.h = i3;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        if (z2) {
            cVar.h = i3 + this.u.j();
            View K2 = K2();
            c cVar2 = this.t;
            cVar2.e = this.x ? -1 : 1;
            int B0 = B0(K2);
            c cVar3 = this.t;
            cVar2.d = B0 + cVar3.e;
            cVar3.b = this.u.d(K2);
            m = this.u.d(K2) - this.u.i();
        } else {
            View L2 = L2();
            this.t.h += this.u.m();
            c cVar4 = this.t;
            cVar4.e = this.x ? 1 : -1;
            int B02 = B0(L2);
            c cVar5 = this.t;
            cVar4.d = B02 + cVar5.e;
            cVar5.b = this.u.g(L2);
            m = (-this.u.g(L2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - m;
        }
        cVar6.g = m;
    }

    public final void i3(int i, int i2) {
        this.t.c = this.u.i() - i2;
        c cVar = this.t;
        cVar.e = this.x ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    public void j(View view, View view2, int i, int i2) {
        int g;
        D("Cannot drop a view during a scroll or layout calculation");
        r2();
        Y2();
        int B0 = B0(view);
        int B02 = B0(view2);
        char c2 = B0 < B02 ? (char) 1 : (char) 65535;
        if (this.x) {
            if (c2 == 1) {
                a3(B02, this.u.i() - (this.u.g(view2) + this.u.e(view)));
                return;
            }
            g = this.u.i() - this.u.d(view2);
        } else {
            if (c2 != 65535) {
                a3(B02, this.u.d(view2) - this.u.e(view));
                return;
            }
            g = this.u.g(view2);
        }
        a3(B02, g);
    }

    public boolean j2() {
        return this.D == null && this.v == this.y;
    }

    public final void j3(a aVar) {
        i3(aVar.b, aVar.c);
    }

    public void k2(RecyclerView.A a2, int[] iArr) {
        int i;
        int M2 = M2(a2);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = M2;
            M2 = 0;
        }
        iArr[0] = M2;
        iArr[1] = i;
    }

    public final void k3(int i, int i2) {
        this.t.c = i2 - this.u.m();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    public void l2(RecyclerView.A a2, c cVar, RecyclerView.o.c cVar2) {
        int i = cVar.d;
        if (i < 0 || i >= a2.c()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.g));
    }

    public final void l3(a aVar) {
        k3(aVar.b, aVar.c);
    }

    public int p2(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && O2()) ? -1 : 1 : (this.s != 1 && O2()) ? 1 : -1;
    }

    public c q2() {
        return new c();
    }

    public void r2() {
        if (this.t == null) {
            this.t = q2();
        }
    }

    public int s2(RecyclerView.v vVar, c cVar, RecyclerView.A a2, boolean z) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            T2(vVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(a2)) {
                break;
            }
            bVar.a();
            Q2(vVar, a2, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || cVar.l != null || !a2.h()) {
                    int i4 = cVar.c;
                    int i5 = bVar.a;
                    cVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.a;
                    cVar.g = i7;
                    int i8 = cVar.c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    T2(vVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    public void t1(RecyclerView.v vVar, RecyclerView.A a2) {
        int i;
        int i2;
        int i3;
        int i4;
        int I2;
        int i5;
        View a0;
        int g;
        int i6;
        int i7 = -1;
        if (!(this.D == null && this.A == -1) && a2.c() == 0) {
            H1(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            this.A = this.D.a;
        }
        r2();
        this.t.a = false;
        Y2();
        View t0 = t0();
        a aVar = this.E;
        if (!aVar.e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.d = this.x ^ this.y;
            g3(vVar, a2, aVar2);
            this.E.e = true;
        } else if (t0 != null && (this.u.g(t0) >= this.u.i() || this.u.d(t0) <= this.u.m())) {
            this.E.c(t0, B0(t0));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        k2(a2, iArr);
        int max = Math.max(0, this.H[0]) + this.u.m();
        int max2 = Math.max(0, this.H[1]) + this.u.j();
        if (a2.h() && (i5 = this.A) != -1 && this.B != Integer.MIN_VALUE && (a0 = a0(i5)) != null) {
            if (this.x) {
                i6 = this.u.i() - this.u.d(a0);
                g = this.B;
            } else {
                g = this.u.g(a0) - this.u.m();
                i6 = this.B;
            }
            int i8 = i6 - g;
            if (i8 > 0) {
                max += i8;
            } else {
                max2 -= i8;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.d ? !this.x : this.x) {
            i7 = 1;
        }
        S2(vVar, a2, aVar3, i7);
        T(vVar);
        this.t.m = X2();
        this.t.j = a2.h();
        this.t.i = 0;
        a aVar4 = this.E;
        if (aVar4.d) {
            l3(aVar4);
            c cVar2 = this.t;
            cVar2.h = max;
            s2(vVar, cVar2, a2, false);
            c cVar3 = this.t;
            i2 = cVar3.b;
            int i9 = cVar3.d;
            int i10 = cVar3.c;
            if (i10 > 0) {
                max2 += i10;
            }
            j3(this.E);
            c cVar4 = this.t;
            cVar4.h = max2;
            cVar4.d += cVar4.e;
            s2(vVar, cVar4, a2, false);
            c cVar5 = this.t;
            i = cVar5.b;
            int i11 = cVar5.c;
            if (i11 > 0) {
                k3(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                s2(vVar, cVar6, a2, false);
                i2 = this.t.b;
            }
        } else {
            j3(aVar4);
            c cVar7 = this.t;
            cVar7.h = max2;
            s2(vVar, cVar7, a2, false);
            c cVar8 = this.t;
            i = cVar8.b;
            int i12 = cVar8.d;
            int i13 = cVar8.c;
            if (i13 > 0) {
                max += i13;
            }
            l3(this.E);
            c cVar9 = this.t;
            cVar9.h = max;
            cVar9.d += cVar9.e;
            s2(vVar, cVar9, a2, false);
            c cVar10 = this.t;
            i2 = cVar10.b;
            int i14 = cVar10.c;
            if (i14 > 0) {
                i3(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                s2(vVar, cVar11, a2, false);
                i = this.t.b;
            }
        }
        if (h0() > 0) {
            if (this.x ^ this.y) {
                int I22 = I2(i, vVar, a2, true);
                i3 = i2 + I22;
                i4 = i + I22;
                I2 = J2(i3, vVar, a2, false);
            } else {
                int J2 = J2(i2, vVar, a2, true);
                i3 = i2 + J2;
                i4 = i + J2;
                I2 = I2(i4, vVar, a2, false);
            }
            i2 = i3 + I2;
            i = i4 + I2;
        }
        R2(vVar, a2, i2, i);
        if (a2.h()) {
            this.E.e();
        } else {
            this.u.s();
        }
        this.v = this.y;
    }

    public final View t2() {
        return B2(0, h0());
    }

    public void u1(RecyclerView.A a2) {
        super.u1(a2);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    public final View u2(RecyclerView.v vVar, RecyclerView.A a2) {
        return F2(vVar, a2, 0, h0(), a2.c());
    }

    public View v2(boolean z, boolean z2) {
        int h0;
        int i;
        if (this.x) {
            h0 = 0;
            i = h0();
        } else {
            h0 = h0() - 1;
            i = -1;
        }
        return C2(h0, i, z, z2);
    }

    public View w2(boolean z, boolean z2) {
        int i;
        int h0;
        if (this.x) {
            i = h0() - 1;
            h0 = -1;
        } else {
            i = 0;
            h0 = h0();
        }
        return C2(i, h0, z, z2);
    }

    public int x2() {
        View C2 = C2(0, h0(), false, true);
        if (C2 == null) {
            return -1;
        }
        return B0(C2);
    }

    public void y1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            Q1();
        }
    }

    public final View y2() {
        return B2(h0() - 1, -1);
    }

    public Parcelable z1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (h0() > 0) {
            r2();
            boolean z = this.v ^ this.x;
            dVar.d = z;
            if (z) {
                View K2 = K2();
                dVar.c = this.u.i() - this.u.d(K2);
                dVar.a = B0(K2);
            } else {
                View L2 = L2();
                dVar.a = B0(L2);
                dVar.c = this.u.g(L2) - this.u.m();
            }
        } else {
            dVar.c();
        }
        return dVar;
    }

    public final View z2(RecyclerView.v vVar, RecyclerView.A a2) {
        return F2(vVar, a2, h0() - 1, -1, a2.c());
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        b3(i);
        c3(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d C0 = RecyclerView.o.C0(context, attributeSet, i, i2);
        b3(C0.a);
        c3(C0.c);
        d3(C0.d);
    }
}
