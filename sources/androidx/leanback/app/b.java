package androidx.leanback.app;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.leanback.widget.E;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.M;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.c;
import androidx.leanback.widget.d;
import androidx.leanback.widget.t;
import androidx.leanback.widget.v;
import androidx.recyclerview.widget.RecyclerView;
import g0.f;
import g0.g;
import g0.h;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends androidx.leanback.app.a {
    public t.d j;
    public int k;
    public boolean m;
    public boolean p;
    public d q;
    public c r;
    public int s;
    public RecyclerView.u u;
    public ArrayList v;
    public t.b w;
    public boolean l = true;
    public int n = Integer.MIN_VALUE;
    public boolean o = true;
    public Interpolator t = new DecelerateInterpolator(2.0f);
    public final t.b x = new a();

    public class a extends t.b {
        public a() {
        }

        public void a(E e, int i) {
            t.b bVar = b.this.w;
            if (bVar != null) {
                bVar.a(e, i);
            }
        }

        public void b(t.d dVar) {
            b.k0(dVar, b.this.l);
            M m = (M) dVar.Q();
            M.b m2 = m.m(dVar.R());
            m.B(m2, b.this.o);
            m.k(m2, b.this.p);
            t.b bVar = b.this.w;
            if (bVar != null) {
                bVar.b(dVar);
            }
        }

        public void c(t.d dVar) {
            t.b bVar = b.this.w;
            if (bVar != null) {
                bVar.c(dVar);
            }
        }

        public void e(t.d dVar) {
            VerticalGridView E = b.this.E();
            if (E != null) {
                E.setClipChildren(false);
            }
            b.this.m0(dVar);
            b bVar = b.this;
            bVar.m = true;
            dVar.S(bVar.new b(dVar));
            b.l0(dVar, false, true);
            t.b bVar2 = b.this.w;
            if (bVar2 != null) {
                bVar2.e(dVar);
            }
            M.b m = ((M) dVar.Q()).m(dVar.R());
            m.l(b.this.q);
            m.k(b.this.r);
        }

        public void f(t.d dVar) {
            t.d dVar2 = b.this.j;
            if (dVar2 == dVar) {
                b.l0(dVar2, false, true);
                b.this.j = null;
            }
            t.b bVar = b.this.w;
            if (bVar != null) {
                bVar.f(dVar);
            }
        }

        public void g(t.d dVar) {
            b.l0(dVar, false, true);
            t.b bVar = b.this.w;
            if (bVar != null) {
                bVar.g(dVar);
            }
        }
    }

    public final class b implements TimeAnimator.TimeListener {
        public final M a;
        public final E.a b;
        public final TimeAnimator c;
        public int d;
        public Interpolator e;
        public float f;
        public float g;

        public b(t.d dVar) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.c = timeAnimator;
            this.a = (M) dVar.Q();
            this.b = dVar.R();
            timeAnimator.setTimeListener(this);
        }

        public void a(boolean z, boolean z2) {
            this.c.end();
            float f = z ? 1.0f : 0.0f;
            if (z2) {
                this.a.E(this.b, f);
                return;
            }
            if (this.a.o(this.b) != f) {
                b bVar = b.this;
                this.d = bVar.s;
                this.e = bVar.t;
                float o = this.a.o(this.b);
                this.f = o;
                this.g = f - o;
                this.c.start();
            }
        }

        public void b(long j, long j2) {
            float f;
            int i = this.d;
            if (j >= i) {
                this.c.end();
                f = 1.0f;
            } else {
                f = (float) (j / i);
            }
            Interpolator interpolator = this.e;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            this.a.E(this.b, this.f + (f * this.g));
        }

        public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
            if (this.c.isRunning()) {
                b(j, j2);
            }
        }
    }

    public static M.b Z(t.d dVar) {
        if (dVar == null) {
            return null;
        }
        return ((M) dVar.Q()).m(dVar.R());
    }

    public static void k0(t.d dVar, boolean z) {
        ((M) dVar.Q()).C(dVar.R(), z);
    }

    public static void l0(t.d dVar, boolean z, boolean z2) {
        ((b) dVar.P()).a(z, z2);
        ((M) dVar.Q()).D(dVar.R(), z);
    }

    public int B() {
        return h.i;
    }

    public /* bridge */ /* synthetic */ int D() {
        return super.D();
    }

    public void J(RecyclerView recyclerView, RecyclerView.D d, int i, int i2) {
        t.d dVar = this.j;
        if (dVar == d && this.k == i2) {
            return;
        }
        this.k = i2;
        if (dVar != null) {
            l0(dVar, false, false);
        }
        t.d dVar2 = (t.d) d;
        this.j = dVar2;
        if (dVar2 != null) {
            l0(dVar2, true, false);
        }
    }

    public boolean L() {
        boolean L = super.L();
        if (L) {
            Y(true);
        }
        return L;
    }

    public /* bridge */ /* synthetic */ void T(int i) {
        super.T(i);
    }

    public /* bridge */ /* synthetic */ void W(int i, boolean z) {
        super.W(i, z);
    }

    public void X() {
        super.X();
        this.j = null;
        this.m = false;
        t A = A();
        if (A != null) {
            A.t0(this.x);
        }
    }

    public final void Y(boolean z) {
        this.p = z;
        VerticalGridView E = E();
        if (E != null) {
            int childCount = E.getChildCount();
            for (int i = 0; i < childCount; i++) {
                t.d dVar = (t.d) E.i0(E.getChildAt(i));
                M m = (M) dVar.Q();
                m.k(m.m(dVar.R()), z);
            }
        }
    }

    public void b0(int i) {
        if (i == Integer.MIN_VALUE) {
            return;
        }
        this.n = i;
        VerticalGridView E = E();
        if (E != null) {
            E.setItemAlignmentOffset(0);
            E.setItemAlignmentOffsetPercent(-1.0f);
            E.setItemAlignmentOffsetWithPadding(true);
            E.setWindowAlignmentOffset(this.n);
            E.setWindowAlignmentOffsetPercent(-1.0f);
            E.setWindowAlignment(0);
        }
    }

    public void c0(boolean z) {
        this.l = z;
        VerticalGridView E = E();
        if (E != null) {
            int childCount = E.getChildCount();
            for (int i = 0; i < childCount; i++) {
                k0((t.d) E.i0(E.getChildAt(i)), this.l);
            }
        }
    }

    public void i0(c cVar) {
        this.r = cVar;
        if (this.m) {
            throw new IllegalStateException("Item clicked listener must be set before views are created");
        }
    }

    public void j0(d dVar) {
        this.q = dVar;
        VerticalGridView E = E();
        if (E != null) {
            int childCount = E.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Z((t.d) E.i0(E.getChildAt(i))).l(this.q);
            }
        }
    }

    public void m0(t.d dVar) {
        M.b m = ((M) dVar.Q()).m(dVar.R());
        if (m instanceof v.d) {
            v.d dVar2 = (v.d) m;
            HorizontalGridView o = dVar2.o();
            RecyclerView.u uVar = this.u;
            if (uVar == null) {
                this.u = o.getRecycledViewPool();
            } else {
                o.setRecycledViewPool(uVar);
            }
            t n = dVar2.n();
            ArrayList arrayList = this.v;
            if (arrayList == null) {
                this.v = n.k0();
            } else {
                n.A0(arrayList);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = getResources().getInteger(g.a);
    }

    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        this.m = false;
        super.onDestroyView();
    }

    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        E().setItemAlignmentViewId(f.x);
        E().setSaveChildrenPolicy(2);
        b0(this.n);
        this.u = null;
        this.v = null;
    }

    public VerticalGridView x(View view) {
        return view.findViewById(f.d);
    }
}
