package androidx.recyclerview.widget;

import Q.C;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public BitSet B;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public int[] O;
    public f[] t;
    public j u;
    public j v;
    public int w;
    public int x;
    public final g y;
    public int s = -1;
    public boolean z = false;
    public boolean A = false;
    public int C = -1;
    public int D = Integer.MIN_VALUE;
    public d E = new d();
    public int F = 2;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public final Runnable P = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.q2();
        }
    }

    public class b {
        public int a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            c();
        }

        public void a() {
            this.b = this.c ? StaggeredGridLayoutManager.this.u.i() : StaggeredGridLayoutManager.this.u.m();
        }

        public void b(int i) {
            this.b = this.c ? StaggeredGridLayoutManager.this.u.i() - i : StaggeredGridLayoutManager.this.u.m() + i;
        }

        public void c() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = fVarArr[i].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {
        public f f;
        public boolean g;

        public c(int i, int i2) {
            super(i, i2);
        }

        public final int h() {
            f fVar = this.f;
            if (fVar == null) {
                return -1;
            }
            return fVar.e;
        }

        public boolean k() {
            return this.g;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public static class d {
        public int[] a;
        public List b;

        public static class a implements Parcelable {
            public static final Parcelable.Creator CREATOR = new a();
            public int a;
            public int c;
            public int[] d;
            public boolean e;

            public static class a implements Parcelable.Creator {
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            public a() {
            }

            public int a(int i) {
                int[] iArr = this.d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.c + ", mHasUnwantedGapAfter=" + this.e + ", mGapPerSpan=" + Arrays.toString(this.d) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.c);
                parcel.writeInt(this.e ? 1 : 0);
                int[] iArr = this.d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.d);
                }
            }

            public a(Parcel parcel) {
                this.a = parcel.readInt();
                this.c = parcel.readInt();
                this.e = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.d = iArr;
                    parcel.readIntArray(iArr);
                }
            }
        }

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = (a) this.b.get(i);
                if (aVar2.a == aVar.a) {
                    this.b.remove(i);
                }
                if (aVar2.a >= aVar.a) {
                    this.b.add(i, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        public void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        public void c(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[o(i)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i) {
            List list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return h(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) this.b.get(i4);
                int i5 = aVar.a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.c == i3 || (z && aVar.e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public int g(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        public int h(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int i2 = i(i);
            if (i2 == -1) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.a.length;
            }
            int i3 = i2 + 1;
            Arrays.fill(this.a, i, i3, -1);
            return i3;
        }

        public final int i(int i) {
            if (this.b == null) {
                return -1;
            }
            a f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (((a) this.b.get(i2)).a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = (a) this.b.get(i2);
            this.b.remove(i2);
            return aVar.a;
        }

        public void j(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            l(i, i2);
        }

        public void k(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m(i, i2);
        }

        public final void l(int i, int i2) {
            List list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                int i3 = aVar.a;
                if (i3 >= i) {
                    aVar.a = i3 + i2;
                }
            }
        }

        public final void m(int i, int i2) {
            List list = this.b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                int i4 = aVar.a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.b.remove(size);
                    } else {
                        aVar.a = i4 - i2;
                    }
                }
            }
        }

        public void n(int i, f fVar) {
            c(i);
            this.a[i] = fVar.e;
        }

        public int o(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public int c;
        public int d;
        public int[] e;
        public int f;
        public int[] g;
        public List h;
        public boolean i;
        public boolean j;
        public boolean k;

        public static class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        public void a() {
            this.e = null;
            this.d = 0;
            this.a = -1;
            this.c = -1;
        }

        public void c() {
            this.e = null;
            this.d = 0;
            this.f = 0;
            this.g = null;
            this.h = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            if (this.d > 0) {
                parcel.writeIntArray(this.e);
            }
            parcel.writeInt(this.f);
            if (this.f > 0) {
                parcel.writeIntArray(this.g);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeList(this.h);
        }

        public e(Parcel parcel) {
            this.a = parcel.readInt();
            this.c = parcel.readInt();
            int readInt = parcel.readInt();
            this.d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1;
            this.h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.d = eVar.d;
            this.a = eVar.a;
            this.c = eVar.c;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.h = eVar.h;
        }
    }

    public class f {
        public ArrayList a = new ArrayList();
        public int b = Integer.MIN_VALUE;
        public int c = Integer.MIN_VALUE;
        public int d = 0;
        public final int e;

        public f(int i) {
            this.e = i;
        }

        public void a(View view) {
            c n = n(view);
            n.f = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (n.e() || n.d()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        public void b(boolean z, int i) {
            int l = z ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (l == Integer.MIN_VALUE) {
                return;
            }
            if (!z || l >= StaggeredGridLayoutManager.this.u.i()) {
                if (z || l <= StaggeredGridLayoutManager.this.u.m()) {
                    if (i != Integer.MIN_VALUE) {
                        l += i;
                    }
                    this.c = l;
                    this.b = l;
                }
            }
        }

        public void c() {
            d.a f;
            ArrayList arrayList = this.a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c n = n(view);
            this.c = StaggeredGridLayoutManager.this.u.d(view);
            if (n.g && (f = StaggeredGridLayoutManager.this.E.f(n.c())) != null && f.c == 1) {
                this.c += f.a(this.e);
            }
        }

        public void d() {
            d.a f;
            View view = (View) this.a.get(0);
            c n = n(view);
            this.b = StaggeredGridLayoutManager.this.u.g(view);
            if (n.g && (f = StaggeredGridLayoutManager.this.E.f(n.c())) != null && f.c == -1) {
                this.b -= f.a(this.e);
            }
        }

        public void e() {
            this.a.clear();
            q();
            this.d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.z ? i(this.a.size() - 1, -1, true) : i(0, this.a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.z ? i(0, this.a.size(), true) : i(this.a.size() - 1, -1, true);
        }

        public int h(int i, int i2, boolean z, boolean z2, boolean z3) {
            int m = StaggeredGridLayoutManager.this.u.m();
            int i3 = StaggeredGridLayoutManager.this.u.i();
            int i4 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.a.get(i);
                int g = StaggeredGridLayoutManager.this.u.g(view);
                int d = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? g >= i3 : g > i3;
                if (!z3 ? d > m : d >= m) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (!z2 && g >= m && d <= i3) {
                        }
                        return StaggeredGridLayoutManager.this.B0(view);
                    }
                    if (g >= m && d <= i3) {
                        return StaggeredGridLayoutManager.this.B0(view);
                    }
                }
                i += i4;
            }
            return -1;
        }

        public int i(int i, int i2, boolean z) {
            return h(i, i2, false, false, z);
        }

        public int j() {
            return this.d;
        }

        public int k() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        public int l(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        public View m(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.B0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.B0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = (View) this.a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.B0(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.B0(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public c n(View view) {
            return view.getLayoutParams();
        }

        public int o() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.b;
        }

        public int p(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            d();
            return this.b;
        }

        public void q() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        public void r(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        public void s() {
            int size = this.a.size();
            View view = (View) this.a.remove(size - 1);
            c n = n(view);
            n.f = null;
            if (n.e() || n.d()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(view);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public void t() {
            View view = (View) this.a.remove(0);
            c n = n(view);
            n.f = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (n.e() || n.d()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(view);
            }
            this.b = Integer.MIN_VALUE;
        }

        public void u(View view) {
            c n = n(view);
            n.f = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (n.e() || n.d()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        public void v(int i) {
            this.b = i;
            this.c = i;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.o.d C0 = RecyclerView.o.C0(context, attributeSet, i, i2);
        f3(C0.a);
        h3(C0.b);
        g3(C0.c);
        this.y = new g();
        y2();
    }

    private void S2(View view, int i, int i2, boolean z) {
        G(view, this.K);
        c layoutParams = view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int p3 = p3(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int p32 = p3(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z ? f2(view, p3, p32, layoutParams) : d2(view, p3, p32, layoutParams)) {
            view.measure(p3, p32);
        }
    }

    private void c3() {
        this.A = (this.w == 1 || !R2()) ? this.z : !this.z;
    }

    private int s2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        return m.a(a2, this.u, C2(!this.N), B2(!this.N), this, this.N);
    }

    private int t2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        return m.b(a2, this.u, C2(!this.N), B2(!this.N), this, this.N, this.A);
    }

    private int u2(RecyclerView.A a2) {
        if (h0() == 0) {
            return 0;
        }
        return m.c(a2, this.u, C2(!this.N), B2(!this.N), this, this.N);
    }

    private int v2(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && R2()) ? -1 : 1 : (this.w != 1 && R2()) ? 1 : -1;
    }

    public void A1(int i) {
        if (i == 0) {
            q2();
        }
    }

    public final int A2(int i) {
        int h0 = h0();
        for (int i2 = 0; i2 < h0; i2++) {
            int B0 = B0(g0(i2));
            if (B0 >= 0 && B0 < i) {
                return B0;
            }
        }
        return 0;
    }

    public View B2(boolean z) {
        int m = this.u.m();
        int i = this.u.i();
        View view = null;
        for (int h0 = h0() - 1; h0 >= 0; h0--) {
            View g0 = g0(h0);
            int g = this.u.g(g0);
            int d2 = this.u.d(g0);
            if (d2 > m && g < i) {
                if (d2 <= i || !z) {
                    return g0;
                }
                if (view == null) {
                    view = g0;
                }
            }
        }
        return view;
    }

    public View C2(boolean z) {
        int m = this.u.m();
        int i = this.u.i();
        int h0 = h0();
        View view = null;
        for (int i2 = 0; i2 < h0; i2++) {
            View g0 = g0(i2);
            int g = this.u.g(g0);
            if (this.u.d(g0) > m && g < i) {
                if (g >= m || !z) {
                    return g0;
                }
                if (view == null) {
                    view = g0;
                }
            }
        }
        return view;
    }

    public void D(String str) {
        if (this.I == null) {
            super.D(str);
        }
    }

    public int D2() {
        View B2 = this.A ? B2(true) : C2(true);
        if (B2 == null) {
            return -1;
        }
        return B0(B2);
    }

    public int E0(RecyclerView.v vVar, RecyclerView.A a2) {
        return this.w == 0 ? this.s : super.E0(vVar, a2);
    }

    public final int E2(int i) {
        for (int h0 = h0() - 1; h0 >= 0; h0--) {
            int B0 = B0(g0(h0));
            if (B0 >= 0 && B0 < i) {
                return B0;
            }
        }
        return 0;
    }

    public final void F2(RecyclerView.v vVar, RecyclerView.A a2, boolean z) {
        int i;
        int J2 = J2(Integer.MIN_VALUE);
        if (J2 != Integer.MIN_VALUE && (i = this.u.i() - J2) > 0) {
            int i2 = i - (-d3(-i, vVar, a2));
            if (!z || i2 <= 0) {
                return;
            }
            this.u.r(i2);
        }
    }

    public final void G2(RecyclerView.v vVar, RecyclerView.A a2, boolean z) {
        int m;
        int M2 = M2(Integer.MAX_VALUE);
        if (M2 != Integer.MAX_VALUE && (m = M2 - this.u.m()) > 0) {
            int d3 = m - d3(m, vVar, a2);
            if (!z || d3 <= 0) {
                return;
            }
            this.u.r(-d3);
        }
    }

    public boolean H() {
        return this.w == 0;
    }

    public int H2() {
        if (h0() == 0) {
            return 0;
        }
        return B0(g0(0));
    }

    public boolean I() {
        return this.w == 1;
    }

    public int I2() {
        int h0 = h0();
        if (h0 == 0) {
            return 0;
        }
        return B0(g0(h0 - 1));
    }

    public boolean J(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public final int J2(int i) {
        int l = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int l2 = this.t[i2].l(i);
            if (l2 > l) {
                l = l2;
            }
        }
        return l;
    }

    public final int K2(int i) {
        int p = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int p2 = this.t[i2].p(i);
            if (p2 > p) {
                p = p2;
            }
        }
        return p;
    }

    public void L(int i, int i2, RecyclerView.A a2, RecyclerView.o.c cVar) {
        int l;
        int i3;
        if (this.w != 0) {
            i = i2;
        }
        if (h0() == 0 || i == 0) {
            return;
        }
        W2(i, a2);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.s; i5++) {
            g gVar = this.y;
            if (gVar.d == -1) {
                l = gVar.f;
                i3 = this.t[i5].p(l);
            } else {
                l = this.t[i5].l(gVar.g);
                i3 = this.y.g;
            }
            int i6 = l - i3;
            if (i6 >= 0) {
                this.O[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.O, 0, i4);
        for (int i7 = 0; i7 < i4 && this.y.a(a2); i7++) {
            cVar.a(this.y.c, this.O[i7]);
            g gVar2 = this.y;
            gVar2.c += gVar2.d;
        }
    }

    public final int L2(int i) {
        int l = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int l2 = this.t[i2].l(i);
            if (l2 < l) {
                l = l2;
            }
        }
        return l;
    }

    public final int M2(int i) {
        int p = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int p2 = this.t[i2].p(i);
            if (p2 < p) {
                p = p2;
            }
        }
        return p;
    }

    public int N(RecyclerView.A a2) {
        return s2(a2);
    }

    public boolean N0() {
        return this.F != 0;
    }

    public final f N2(g gVar) {
        int i;
        int i2;
        int i3;
        if (V2(gVar.e)) {
            i2 = this.s - 1;
            i = -1;
            i3 = -1;
        } else {
            i = this.s;
            i2 = 0;
            i3 = 1;
        }
        f fVar = null;
        if (gVar.e == 1) {
            int m = this.u.m();
            int i4 = Integer.MAX_VALUE;
            while (i2 != i) {
                f fVar2 = this.t[i2];
                int l = fVar2.l(m);
                if (l < i4) {
                    fVar = fVar2;
                    i4 = l;
                }
                i2 += i3;
            }
            return fVar;
        }
        int i5 = this.u.i();
        int i6 = Integer.MIN_VALUE;
        while (i2 != i) {
            f fVar3 = this.t[i2];
            int p = fVar3.p(i5);
            if (p > i6) {
                fVar = fVar3;
                i6 = p;
            }
            i2 += i3;
        }
        return fVar;
    }

    public int O(RecyclerView.A a2) {
        return t2(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void O2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.I2()
            goto Ld
        L9:
            int r0 = r6.H2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.A
            if (r7 == 0) goto L4e
            int r7 = r6.H2()
            goto L52
        L4e:
            int r7 = r6.I2()
        L52:
            if (r3 > r7) goto L57
            r6.Q1()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.O2(int, int, int):void");
    }

    public int P(RecyclerView.A a2) {
        return u2(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View P2() {
        /*
            r12 = this;
            int r0 = r12.h0()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.w
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.R2()
            if (r3 == 0) goto L21
            r3 = 1
            goto L22
        L21:
            r3 = -1
        L22:
            boolean r7 = r12.A
            if (r7 == 0) goto L28
            r0 = -1
            goto L29
        L28:
            r1 = 0
        L29:
            if (r1 >= r0) goto L2c
            r6 = 1
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.g0(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f
            boolean r9 = r12.r2(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f
            int r9 = r9.e
            r2.clear(r9)
        L52:
            boolean r9 = r8.g
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.g0(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.j r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.j r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.j r10 = r12.u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.j r11 = r12.u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = 1
            goto L9a
        L99:
            r8 = 0
        L9a:
            if (r3 >= 0) goto L9e
            r9 = 1
            goto L9f
        L9e:
            r9 = 0
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P2():android.view.View");
    }

    public int Q(RecyclerView.A a2) {
        return s2(a2);
    }

    public void Q2() {
        this.E.b();
        Q1();
    }

    public int R(RecyclerView.A a2) {
        return t2(a2);
    }

    public boolean R2() {
        return x0() == 1;
    }

    public int S(RecyclerView.A a2) {
        return u2(a2);
    }

    public int T1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        return d3(i, vVar, a2);
    }

    public final void T2(View view, c cVar, boolean z) {
        int i0;
        int i02;
        if (cVar.g) {
            if (this.w != 1) {
                S2(view, RecyclerView.o.i0(I0(), J0(), o() + k(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z);
                return;
            }
            i0 = this.J;
        } else {
            if (this.w != 1) {
                i0 = RecyclerView.o.i0(I0(), J0(), o() + k(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                i02 = RecyclerView.o.i0(this.x, v0(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
                S2(view, i0, i02, z);
            }
            i0 = RecyclerView.o.i0(this.x, J0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        }
        i02 = RecyclerView.o.i0(u0(), v0(), n() + b(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        S2(view, i0, i02, z);
    }

    public void U1(int i) {
        e eVar = this.I;
        if (eVar != null && eVar.a != i) {
            eVar.a();
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        Q1();
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void U2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.A r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$A, boolean):void");
    }

    public int V1(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        return d3(i, vVar, a2);
    }

    public final boolean V2(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == R2();
    }

    public void W2(int i, RecyclerView.A a2) {
        int H2;
        int i2;
        if (i > 0) {
            H2 = I2();
            i2 = 1;
        } else {
            H2 = H2();
            i2 = -1;
        }
        this.y.a = true;
        m3(H2, a2);
        e3(i2);
        g gVar = this.y;
        gVar.c = H2 + gVar.d;
        gVar.b = Math.abs(i);
    }

    public final void X2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].u(view);
        }
    }

    public void Y0(int i) {
        super.Y0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r4.e == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Y2(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.g r4) {
        /*
            r2 = this;
            boolean r0 = r4.a
            if (r0 == 0) goto L4d
            boolean r0 = r4.i
            if (r0 == 0) goto L9
            goto L4d
        L9:
            int r0 = r4.b
            r1 = -1
            if (r0 != 0) goto L1e
            int r0 = r4.e
            if (r0 != r1) goto L18
        L12:
            int r4 = r4.g
        L14:
            r2.Z2(r3, r4)
            goto L4d
        L18:
            int r4 = r4.f
        L1a:
            r2.a3(r3, r4)
            goto L4d
        L1e:
            int r0 = r4.e
            if (r0 != r1) goto L37
            int r0 = r4.f
            int r1 = r2.K2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L2c
            goto L12
        L2c:
            int r1 = r4.g
            int r4 = r4.b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L14
        L37:
            int r0 = r4.g
            int r0 = r2.L2(r0)
            int r1 = r4.g
            int r0 = r0 - r1
            if (r0 >= 0) goto L43
            goto L18
        L43:
            int r1 = r4.f
            int r4 = r4.b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L1a
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Y2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.g):void");
    }

    public void Z0(int i) {
        super.Z0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    public final void Z2(RecyclerView.v vVar, int i) {
        for (int h0 = h0() - 1; h0 >= 0; h0--) {
            View g0 = g0(h0);
            if (this.u.g(g0) < i || this.u.q(g0) < i) {
                return;
            }
            c layoutParams = g0.getLayoutParams();
            if (layoutParams.g) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].s();
                }
            } else if (layoutParams.f.a.size() == 1) {
                return;
            } else {
                layoutParams.f.s();
            }
            J1(g0, vVar);
        }
    }

    public void a2(Rect rect, int i, int i2) {
        int K;
        int K2;
        int o = o() + k();
        int n = n() + b();
        if (this.w == 1) {
            K2 = RecyclerView.o.K(i2, rect.height() + n, z0());
            K = RecyclerView.o.K(i, (this.x * this.s) + o, A0());
        } else {
            K = RecyclerView.o.K(i, rect.width() + o, A0());
            K2 = RecyclerView.o.K(i2, (this.x * this.s) + n, z0());
        }
        Z1(K, K2);
    }

    public final void a3(RecyclerView.v vVar, int i) {
        while (h0() > 0) {
            View g0 = g0(0);
            if (this.u.d(g0) > i || this.u.p(g0) > i) {
                return;
            }
            c layoutParams = g0.getLayoutParams();
            if (layoutParams.g) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].t();
                }
            } else if (layoutParams.f.a.size() == 1) {
                return;
            } else {
                layoutParams.f.t();
            }
            J1(g0, vVar);
        }
    }

    public RecyclerView.p b0() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public final void b3() {
        if (this.v.k() == 1073741824) {
            return;
        }
        int h0 = h0();
        float f2 = 0.0f;
        for (int i = 0; i < h0; i++) {
            View g0 = g0(i);
            float e2 = this.v.e(g0);
            if (e2 >= f2) {
                if (g0.getLayoutParams().k()) {
                    e2 = (e2 * 1.0f) / this.s;
                }
                f2 = Math.max(f2, e2);
            }
        }
        int i2 = this.x;
        int round = Math.round(f2 * this.s);
        if (this.v.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.v.n());
        }
        n3(round);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < h0; i3++) {
            View g02 = g0(i3);
            c layoutParams = g02.getLayoutParams();
            if (!layoutParams.g) {
                if (R2() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = layoutParams.f.e;
                    g02.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.f.e;
                    int i7 = this.w;
                    int i8 = (this.x * i6) - (i6 * i2);
                    if (i7 == 1) {
                        g02.offsetLeftAndRight(i8);
                    } else {
                        g02.offsetTopAndBottom(i8);
                    }
                }
            }
        }
    }

    public RecyclerView.p c0(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public RecyclerView.p d0(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public int d3(int i, RecyclerView.v vVar, RecyclerView.A a2) {
        if (h0() == 0 || i == 0) {
            return 0;
        }
        W2(i, a2);
        int z2 = z2(vVar, this.y, a2);
        if (this.y.b >= z2) {
            i = i < 0 ? -z2 : z2;
        }
        this.u.r(-i);
        this.G = this.A;
        g gVar = this.y;
        gVar.b = 0;
        Y2(vVar, gVar);
        return i;
    }

    public PointF e(int i) {
        int p2 = p2(i);
        PointF pointF = new PointF();
        if (p2 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = p2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = p2;
        }
        return pointF;
    }

    public void e1(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.e1(recyclerView, vVar);
        L1(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
        recyclerView.requestLayout();
    }

    public final void e3(int i) {
        g gVar = this.y;
        gVar.e = i;
        gVar.d = this.A != (i == -1) ? -1 : 1;
    }

    public View f1(View view, int i, RecyclerView.v vVar, RecyclerView.A a2) {
        View Z;
        View m;
        if (h0() == 0 || (Z = Z(view)) == null) {
            return null;
        }
        c3();
        int v2 = v2(i);
        if (v2 == Integer.MIN_VALUE) {
            return null;
        }
        c layoutParams = Z.getLayoutParams();
        boolean z = layoutParams.g;
        f fVar = layoutParams.f;
        int I2 = v2 == 1 ? I2() : H2();
        m3(I2, a2);
        e3(v2);
        g gVar = this.y;
        gVar.c = gVar.d + I2;
        gVar.b = (int) (this.u.n() * 0.33333334f);
        g gVar2 = this.y;
        gVar2.h = true;
        gVar2.a = false;
        z2(vVar, gVar2, a2);
        this.G = this.A;
        if (!z && (m = fVar.m(I2, v2)) != null && m != Z) {
            return m;
        }
        if (V2(v2)) {
            for (int i2 = this.s - 1; i2 >= 0; i2--) {
                View m2 = this.t[i2].m(I2, v2);
                if (m2 != null && m2 != Z) {
                    return m2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.s; i3++) {
                View m3 = this.t[i3].m(I2, v2);
                if (m3 != null && m3 != Z) {
                    return m3;
                }
            }
        }
        boolean z2 = (this.z ^ true) == (v2 == -1);
        if (!z) {
            View a0 = a0(z2 ? fVar.f() : fVar.g());
            if (a0 != null && a0 != Z) {
                return a0;
            }
        }
        if (V2(v2)) {
            for (int i4 = this.s - 1; i4 >= 0; i4--) {
                if (i4 != fVar.e) {
                    f[] fVarArr = this.t;
                    View a02 = a0(z2 ? fVarArr[i4].f() : fVarArr[i4].g());
                    if (a02 != null && a02 != Z) {
                        return a02;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.s; i5++) {
                f[] fVarArr2 = this.t;
                View a03 = a0(z2 ? fVarArr2[i5].f() : fVarArr2[i5].g());
                if (a03 != null && a03 != Z) {
                    return a03;
                }
            }
        }
        return null;
    }

    public void f3(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        D(null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        j jVar = this.u;
        this.u = this.v;
        this.v = jVar;
        Q1();
    }

    public void g1(AccessibilityEvent accessibilityEvent) {
        super.g1(accessibilityEvent);
        if (h0() > 0) {
            View C2 = C2(false);
            View B2 = B2(false);
            if (C2 == null || B2 == null) {
                return;
            }
            int B0 = B0(C2);
            int B02 = B0(B2);
            if (B0 < B02) {
                accessibilityEvent.setFromIndex(B0);
                accessibilityEvent.setToIndex(B02);
            } else {
                accessibilityEvent.setFromIndex(B02);
                accessibilityEvent.setToIndex(B0);
            }
        }
    }

    public void g2(RecyclerView recyclerView, RecyclerView.A a2, int i) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i);
        h2(hVar);
    }

    public void g3(boolean z) {
        D(null);
        e eVar = this.I;
        if (eVar != null && eVar.i != z) {
            eVar.i = z;
        }
        this.z = z;
        Q1();
    }

    public void h3(int i) {
        D(null);
        if (i != this.s) {
            Q2();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new f(i2);
            }
            Q1();
        }
    }

    public final void i3(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].a.isEmpty()) {
                o3(this.t[i3], i, i2);
            }
        }
    }

    public boolean j2() {
        return this.I == null;
    }

    public final boolean j3(RecyclerView.A a2, b bVar) {
        boolean z = this.G;
        int c2 = a2.c();
        bVar.a = z ? E2(c2) : A2(c2);
        bVar.b = Integer.MIN_VALUE;
        return true;
    }

    public final void k2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    public boolean k3(RecyclerView.A a2, b bVar) {
        int i;
        int m;
        int g;
        if (!a2.h() && (i = this.C) != -1) {
            if (i >= 0 && i < a2.c()) {
                e eVar = this.I;
                if (eVar == null || eVar.a == -1 || eVar.d < 1) {
                    View a0 = a0(this.C);
                    if (a0 != null) {
                        bVar.a = this.A ? I2() : H2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.c) {
                                m = this.u.i() - this.D;
                                g = this.u.d(a0);
                            } else {
                                m = this.u.m() + this.D;
                                g = this.u.g(a0);
                            }
                            bVar.b = m - g;
                            return true;
                        }
                        if (this.u.e(a0) > this.u.n()) {
                            bVar.b = bVar.c ? this.u.i() : this.u.m();
                            return true;
                        }
                        int g2 = this.u.g(a0) - this.u.m();
                        if (g2 < 0) {
                            bVar.b = -g2;
                            return true;
                        }
                        int i2 = this.u.i() - this.u.d(a0);
                        if (i2 < 0) {
                            bVar.b = i2;
                            return true;
                        }
                        bVar.b = Integer.MIN_VALUE;
                    } else {
                        int i3 = this.C;
                        bVar.a = i3;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.c = p2(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i4);
                        }
                        bVar.d = true;
                    }
                } else {
                    bVar.b = Integer.MIN_VALUE;
                    bVar.a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    public int l0(RecyclerView.v vVar, RecyclerView.A a2) {
        return this.w == 1 ? this.s : super.l0(vVar, a2);
    }

    public void l1(RecyclerView.v vVar, RecyclerView.A a2, View view, C c2) {
        int h;
        int i;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        c layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.k1(view, c2);
            return;
        }
        c cVar = layoutParams;
        if (this.w == 0) {
            i2 = cVar.h();
            i3 = cVar.g ? this.s : 1;
            z = false;
            z2 = false;
            h = -1;
            i = -1;
        } else {
            h = cVar.h();
            i = cVar.g ? this.s : 1;
            z = false;
            z2 = false;
            i2 = -1;
            i3 = -1;
        }
        c2.a0(C.c.a(i2, i3, h, i, z, z2));
    }

    public final void l2(b bVar) {
        boolean z;
        e eVar = this.I;
        int i = eVar.d;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].e();
                    e eVar2 = this.I;
                    int i3 = eVar2.e[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += eVar2.j ? this.u.i() : this.u.m();
                    }
                    this.t[i2].v(i3);
                }
            } else {
                eVar.c();
                e eVar3 = this.I;
                eVar3.a = eVar3.c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.k;
        g3(eVar4.i);
        c3();
        e eVar5 = this.I;
        int i4 = eVar5.a;
        if (i4 != -1) {
            this.C = i4;
            z = eVar5.j;
        } else {
            z = this.A;
        }
        bVar.c = z;
        if (eVar5.f > 1) {
            d dVar = this.E;
            dVar.a = eVar5.g;
            dVar.b = eVar5.h;
        }
    }

    public void l3(RecyclerView.A a2, b bVar) {
        if (k3(a2, bVar) || j3(a2, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    public boolean m2() {
        int l = this.t[0].l(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].l(Integer.MIN_VALUE) != l) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3(int r5, androidx.recyclerview.widget.RecyclerView.A r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.g r0 = r4.y
            r1 = 0
            r0.b = r1
            r0.c = r5
            boolean r0 = r4.T0()
            r2 = 1
            if (r0 == 0) goto L2f
            int r6 = r6.f()
            r0 = -1
            if (r6 == r0) goto L2f
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L26
            androidx.recyclerview.widget.j r5 = r4.u
            int r5 = r5.n()
        L24:
            r6 = 0
            goto L31
        L26:
            androidx.recyclerview.widget.j r5 = r4.u
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L31
        L2f:
            r5 = 0
            goto L24
        L31:
            boolean r0 = r4.k0()
            if (r0 == 0) goto L4e
            androidx.recyclerview.widget.g r0 = r4.y
            androidx.recyclerview.widget.j r3 = r4.u
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.g r6 = r4.y
            androidx.recyclerview.widget.j r0 = r4.u
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.g = r0
            goto L5e
        L4e:
            androidx.recyclerview.widget.g r0 = r4.y
            androidx.recyclerview.widget.j r3 = r4.u
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.g r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L5e:
            androidx.recyclerview.widget.g r5 = r4.y
            r5.h = r1
            r5.a = r2
            androidx.recyclerview.widget.j r6 = r4.u
            int r6 = r6.k()
            if (r6 != 0) goto L75
            androidx.recyclerview.widget.j r6 = r4.u
            int r6 = r6.h()
            if (r6 != 0) goto L75
            r1 = 1
        L75:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m3(int, androidx.recyclerview.widget.RecyclerView$A):void");
    }

    public void n1(RecyclerView recyclerView, int i, int i2) {
        O2(i, i2, 1);
    }

    public boolean n2() {
        int p = this.t[0].p(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].p(Integer.MIN_VALUE) != p) {
                return false;
            }
        }
        return true;
    }

    public void n3(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.k());
    }

    public void o1(RecyclerView recyclerView) {
        this.E.b();
        Q1();
    }

    public final void o2(View view, c cVar, g gVar) {
        if (gVar.e == 1) {
            if (cVar.g) {
                k2(view);
                return;
            } else {
                cVar.f.a(view);
                return;
            }
        }
        if (cVar.g) {
            X2(view);
        } else {
            cVar.f.u(view);
        }
    }

    public final void o3(f fVar, int i, int i2) {
        int j = fVar.j();
        if (i == -1) {
            if (fVar.o() + j > i2) {
                return;
            }
        } else if (fVar.k() - j < i2) {
            return;
        }
        this.B.set(fVar.e, false);
    }

    public void p1(RecyclerView recyclerView, int i, int i2, int i3) {
        O2(i, i2, 8);
    }

    public final int p2(int i) {
        if (h0() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < H2()) != this.A ? -1 : 1;
    }

    public final int p3(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    public void q1(RecyclerView recyclerView, int i, int i2) {
        O2(i, i2, 2);
    }

    public boolean q2() {
        int H2;
        int I2;
        if (h0() == 0 || this.F == 0 || !M0()) {
            return false;
        }
        if (this.A) {
            H2 = I2();
            I2 = H2();
        } else {
            H2 = H2();
            I2 = I2();
        }
        if (H2 == 0 && P2() != null) {
            this.E.b();
        } else {
            if (!this.M) {
                return false;
            }
            int i = this.A ? -1 : 1;
            int i2 = I2 + 1;
            d.a e2 = this.E.e(H2, i2, i, true);
            if (e2 == null) {
                this.M = false;
                this.E.d(i2);
                return false;
            }
            d.a e3 = this.E.e(H2, e2.a, i * (-1), true);
            if (e3 == null) {
                this.E.d(e2.a);
            } else {
                this.E.d(e3.a + 1);
            }
        }
        R1();
        Q1();
        return true;
    }

    public final boolean r2(f fVar) {
        if (this.A) {
            if (fVar.k() < this.u.i()) {
                ArrayList arrayList = fVar.a;
                return !fVar.n((View) arrayList.get(arrayList.size() - 1)).g;
            }
        } else if (fVar.o() > this.u.m()) {
            return !fVar.n((View) fVar.a.get(0)).g;
        }
        return false;
    }

    public void s1(RecyclerView recyclerView, int i, int i2, Object obj) {
        O2(i, i2, 4);
    }

    public void t1(RecyclerView.v vVar, RecyclerView.A a2) {
        U2(vVar, a2, true);
    }

    public void u1(RecyclerView.A a2) {
        super.u1(a2);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public final d.a w2(int i) {
        d.a aVar = new d.a();
        aVar.d = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.d[i2] = i - this.t[i2].l(i);
        }
        return aVar;
    }

    public final d.a x2(int i) {
        d.a aVar = new d.a();
        aVar.d = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.d[i2] = this.t[i2].p(i) - i;
        }
        return aVar;
    }

    public void y1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            Q1();
        }
    }

    public final void y2() {
        this.u = j.b(this, this.w);
        this.v = j.b(this, 1 - this.w);
    }

    public Parcelable z1() {
        int p;
        int m;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.i = this.z;
        eVar.j = this.G;
        eVar.k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar.f = 0;
        } else {
            eVar.g = iArr;
            eVar.f = iArr.length;
            eVar.h = dVar.b;
        }
        if (h0() > 0) {
            eVar.a = this.G ? I2() : H2();
            eVar.c = D2();
            int i = this.s;
            eVar.d = i;
            eVar.e = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    p = this.t[i2].l(Integer.MIN_VALUE);
                    if (p != Integer.MIN_VALUE) {
                        m = this.u.i();
                        p -= m;
                    }
                } else {
                    p = this.t[i2].p(Integer.MIN_VALUE);
                    if (p != Integer.MIN_VALUE) {
                        m = this.u.m();
                        p -= m;
                    }
                }
                eVar.e[i2] = p;
            }
        } else {
            eVar.a = -1;
            eVar.c = -1;
            eVar.d = 0;
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int z2(RecyclerView.v vVar, g gVar, RecyclerView.A a2) {
        int i;
        f fVar;
        int e2;
        int i2;
        int i3;
        int e3;
        RecyclerView.o oVar;
        View view;
        int i4;
        int i5;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i = gVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i = gVar.e == 1 ? gVar.g + gVar.b : gVar.f - gVar.b;
        }
        i3(gVar.e, i);
        int i6 = this.A ? this.u.i() : this.u.m();
        boolean z = false;
        while (gVar.a(a2) && (this.y.i || !this.B.isEmpty())) {
            View b2 = gVar.b(vVar);
            c layoutParams = b2.getLayoutParams();
            int c2 = layoutParams.c();
            int g = this.E.g(c2);
            boolean z2 = g == -1;
            if (z2) {
                fVar = layoutParams.g ? this.t[r9] : N2(gVar);
                this.E.n(c2, fVar);
            } else {
                fVar = this.t[g];
            }
            f fVar2 = fVar;
            layoutParams.f = fVar2;
            if (gVar.e == 1) {
                A(b2);
            } else {
                B(b2, r9);
            }
            T2(b2, layoutParams, r9);
            if (gVar.e == 1) {
                int J2 = layoutParams.g ? J2(i6) : fVar2.l(i6);
                int e4 = this.u.e(b2) + J2;
                if (z2 && layoutParams.g) {
                    d.a w2 = w2(J2);
                    w2.c = -1;
                    w2.a = c2;
                    this.E.a(w2);
                }
                i2 = e4;
                e2 = J2;
            } else {
                int M2 = layoutParams.g ? M2(i6) : fVar2.p(i6);
                e2 = M2 - this.u.e(b2);
                if (z2 && layoutParams.g) {
                    d.a x2 = x2(M2);
                    x2.c = 1;
                    x2.a = c2;
                    this.E.a(x2);
                }
                i2 = M2;
            }
            if (layoutParams.g && gVar.d == -1) {
                if (z2) {
                    this.M = true;
                } else {
                    if (!(gVar.e == 1 ? m2() : n2())) {
                        d.a f2 = this.E.f(c2);
                        if (f2 != null) {
                            f2.e = true;
                        }
                        this.M = true;
                    }
                }
            }
            o2(b2, layoutParams, gVar);
            if (R2() && this.w == 1) {
                int i7 = layoutParams.g ? this.v.i() : this.v.i() - (((this.s - 1) - fVar2.e) * this.x);
                e3 = i7;
                i3 = i7 - this.v.e(b2);
            } else {
                int m = layoutParams.g ? this.v.m() : (fVar2.e * this.x) + this.v.m();
                i3 = m;
                e3 = this.v.e(b2) + m;
            }
            if (this.w == 1) {
                oVar = this;
                view = b2;
                i4 = i3;
                i3 = e2;
                i5 = e3;
            } else {
                oVar = this;
                view = b2;
                i4 = e2;
                i5 = i2;
                i2 = e3;
            }
            oVar.V0(view, i4, i3, i5, i2);
            if (layoutParams.g) {
                i3(this.y.e, i);
            } else {
                o3(fVar2, this.y.e, i);
            }
            Y2(vVar, this.y);
            if (this.y.h && b2.hasFocusable()) {
                if (layoutParams.g) {
                    this.B.clear();
                } else {
                    this.B.set(fVar2.e, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            Y2(vVar, this.y);
        }
        int m2 = this.y.e == -1 ? this.u.m() - M2(this.u.m()) : J2(this.u.i()) - this.u.i();
        if (m2 > 0) {
            return Math.min(gVar.b, m2);
        }
        return 0;
    }
}
