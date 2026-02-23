package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class o extends RecyclerView.r {
    public RecyclerView a;
    public Scroller b;
    public final RecyclerView.t c = new a();

    public class a extends RecyclerView.t {
        public boolean a = false;

        public a() {
        }

        public void a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0 && this.a) {
                this.a = false;
                o.this.k();
            }
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.a = true;
        }
    }

    public boolean a(int i, int i2) {
        RecyclerView.o layoutManager = this.a.getLayoutManager();
        if (layoutManager == null || this.a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && j(layoutManager, i, i2);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            i();
            this.b = new Scroller(this.a.getContext(), new DecelerateInterpolator());
            k();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public RecyclerView.z d(RecyclerView.o oVar) {
        return e(oVar);
    }

    public abstract h e(RecyclerView.o oVar);

    public final void f() {
        this.a.d1(this.c);
        this.a.setOnFlingListener(null);
    }

    public abstract View g(RecyclerView.o oVar);

    public abstract int h(RecyclerView.o oVar, int i, int i2);

    public final void i() {
        if (this.a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.a.l(this.c);
        this.a.setOnFlingListener(this);
    }

    public final boolean j(RecyclerView.o oVar, int i, int i2) {
        RecyclerView.z d;
        int h;
        if (!(oVar instanceof RecyclerView.z.b) || (d = d(oVar)) == null || (h = h(oVar, i, i2)) == -1) {
            return false;
        }
        d.p(h);
        oVar.h2(d);
        return true;
    }

    public void k() {
        RecyclerView.o layoutManager;
        View g;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (g = g(layoutManager)) == null) {
            return;
        }
        int[] c = c(layoutManager, g);
        int i = c[0];
        if (i == 0 && c[1] == 0) {
            return;
        }
        this.a.q1(i, c[1]);
    }
}
