package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k extends o {
    public j d;
    public j e;

    public class a extends h {
        public a(Context context) {
            super(context);
        }

        public void o(View view, RecyclerView.A a, RecyclerView.z.a aVar) {
            k kVar = k.this;
            int[] c = kVar.c(kVar.a.getLayoutManager(), view);
            int i = c[0];
            int i2 = c[1];
            int w = w(Math.max(Math.abs(i), Math.abs(i2)));
            if (w > 0) {
                aVar.d(i, i2, w, this.j);
            }
        }

        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        public int x(int i) {
            return Math.min(100, super.x(i));
        }
    }

    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.H()) {
            iArr[0] = l(oVar, view, n(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.I()) {
            iArr[1] = l(oVar, view, p(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public h e(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new a(this.a.getContext());
        }
        return null;
    }

    public View g(RecyclerView.o oVar) {
        j n;
        if (oVar.I()) {
            n = p(oVar);
        } else {
            if (!oVar.H()) {
                return null;
            }
            n = n(oVar);
        }
        return m(oVar, n);
    }

    public int h(RecyclerView.o oVar, int i, int i2) {
        j o;
        int w0 = oVar.w0();
        if (w0 == 0 || (o = o(oVar)) == null) {
            return -1;
        }
        int h0 = oVar.h0();
        View view = null;
        View view2 = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < h0; i5++) {
            View g0 = oVar.g0(i5);
            if (g0 != null) {
                int l = l(oVar, g0, o);
                if (l <= 0 && l > i3) {
                    view2 = g0;
                    i3 = l;
                }
                if (l >= 0 && l < i4) {
                    view = g0;
                    i4 = l;
                }
            }
        }
        boolean q = q(oVar, i, i2);
        if (q && view != null) {
            return oVar.B0(view);
        }
        if (!q && view2 != null) {
            return oVar.B0(view2);
        }
        if (q) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int B0 = oVar.B0(view) + (r(oVar) == q ? -1 : 1);
        if (B0 < 0 || B0 >= w0) {
            return -1;
        }
        return B0;
    }

    public final int l(RecyclerView.o oVar, View view, j jVar) {
        return (jVar.g(view) + (jVar.e(view) / 2)) - (jVar.m() + (jVar.n() / 2));
    }

    public final View m(RecyclerView.o oVar, j jVar) {
        int h0 = oVar.h0();
        View view = null;
        if (h0 == 0) {
            return null;
        }
        int m = jVar.m() + (jVar.n() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < h0; i2++) {
            View g0 = oVar.g0(i2);
            int abs = Math.abs((jVar.g(g0) + (jVar.e(g0) / 2)) - m);
            if (abs < i) {
                view = g0;
                i = abs;
            }
        }
        return view;
    }

    public final j n(RecyclerView.o oVar) {
        j jVar = this.e;
        if (jVar == null || jVar.a != oVar) {
            this.e = j.a(oVar);
        }
        return this.e;
    }

    public final j o(RecyclerView.o oVar) {
        if (oVar.I()) {
            return p(oVar);
        }
        if (oVar.H()) {
            return n(oVar);
        }
        return null;
    }

    public final j p(RecyclerView.o oVar) {
        j jVar = this.d;
        if (jVar == null || jVar.a != oVar) {
            this.d = j.c(oVar);
        }
        return this.d;
    }

    public final boolean q(RecyclerView.o oVar, int i, int i2) {
        return oVar.H() ? i > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r(RecyclerView.o oVar) {
        PointF e;
        int w0 = oVar.w0();
        if (!(oVar instanceof RecyclerView.z.b) || (e = ((RecyclerView.z.b) oVar).e(w0 - 1)) == null) {
            return false;
        }
        return e.x < 0.0f || e.y < 0.0f;
    }
}
