package androidx.recyclerview.widget;

import L.t;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements Runnable {
    public static final ThreadLocal f = new ThreadLocal();
    public static Comparator g = new a();
    public long c;
    public long d;
    public ArrayList a = new ArrayList();
    public ArrayList e = new ArrayList();

    public static class a implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.d;
            if ((recyclerView == null) != (cVar2.d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i = cVar2.b - cVar.b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.c - cVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    public static class b implements RecyclerView.o.c {
        public int a;
        public int b;
        public int[] c;
        public int d;

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d;
            int i4 = i3 * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i3 * 4];
                this.c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.c;
            iArr4[i4] = i;
            iArr4[i4 + 1] = i2;
            this.d++;
        }

        public void b() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.n;
            if (recyclerView.m == null || oVar == null || !oVar.P0()) {
                return;
            }
            if (z) {
                if (!recyclerView.e.p()) {
                    oVar.M(recyclerView.m.n(), this);
                }
            } else if (!recyclerView.q0()) {
                oVar.L(this.a, this.b, recyclerView.m0, this);
            }
            int i = this.d;
            if (i > oVar.m) {
                oVar.m = i;
                oVar.n = z;
                recyclerView.c.K();
            }
        }

        public boolean d(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static class c {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i) {
        int j = recyclerView.f.j();
        for (int i2 = 0; i2 < j; i2++) {
            RecyclerView.D j0 = RecyclerView.j0(recyclerView.f.i(i2));
            if (j0.c == i && !j0.w()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.l0.c(recyclerView, false);
                i += recyclerView.l0.d;
            }
        }
        this.e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = (RecyclerView) this.a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.l0;
                int abs = Math.abs(bVar.a) + Math.abs(bVar.b);
                for (int i5 = 0; i5 < bVar.d * 2; i5 += 2) {
                    if (i3 >= this.e.size()) {
                        cVar = new c();
                        this.e.add(cVar);
                    } else {
                        cVar = (c) this.e.get(i3);
                    }
                    int[] iArr = bVar.c;
                    int i6 = iArr[i5 + 1];
                    cVar.a = i6 <= abs;
                    cVar.b = abs;
                    cVar.c = i6;
                    cVar.d = recyclerView2;
                    cVar.e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.e, g);
    }

    public final void c(c cVar, long j) {
        RecyclerView.D i = i(cVar.d, cVar.e, cVar.a ? Long.MAX_VALUE : j);
        if (i == null || i.b == null || !i.v() || i.w()) {
            return;
        }
        h((RecyclerView) i.b.get(), j);
    }

    public final void d(long j) {
        for (int i = 0; i < this.e.size(); i++) {
            c cVar = (c) this.e.get(i);
            if (cVar.d == null) {
                return;
            }
            c(cVar, j);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.l0.e(i, i2);
    }

    public void g(long j) {
        b();
        d(j);
    }

    public final void h(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.E && recyclerView.f.j() != 0) {
            recyclerView.Y0();
        }
        b bVar = recyclerView.l0;
        bVar.c(recyclerView, true);
        if (bVar.d != 0) {
            try {
                t.a("RV Nested Prefetch");
                recyclerView.m0.i(recyclerView.m);
                for (int i = 0; i < bVar.d * 2; i += 2) {
                    i(recyclerView, bVar.c[i], j);
                }
            } finally {
                t.b();
            }
        }
    }

    public final RecyclerView.D i(RecyclerView recyclerView, int i, long j) {
        if (e(recyclerView, i)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.c;
        try {
            recyclerView.K0();
            RecyclerView.D I = vVar.I(i, false, j);
            if (I != null) {
                if (!I.v() || I.w()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.a);
                }
            }
            recyclerView.M0(false);
            return I;
        } catch (Throwable th) {
            recyclerView.M0(false);
            throw th;
        }
    }

    public void j(RecyclerView recyclerView) {
        this.a.remove(recyclerView);
    }

    public void run() {
        try {
            t.a("RV Prefetch");
            if (!this.a.isEmpty()) {
                int size = this.a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                    this.c = 0L;
                    t.b();
                }
            }
        } finally {
            this.c = 0L;
            t.b();
        }
    }
}
