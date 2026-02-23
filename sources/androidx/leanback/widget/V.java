package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.E;
import androidx.leanback.widget.L;
import androidx.leanback.widget.M;
import androidx.leanback.widget.Q;
import androidx.leanback.widget.b;
import androidx.leanback.widget.t;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class v extends M {
    public static int r;
    public static int s;
    public static int t;
    public int e;
    public int f;
    public int g;
    public F h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public HashMap o;
    public Q p;
    public t.e q;

    public class a implements A {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        public void a(ViewGroup viewGroup, View view, int i, long j) {
            v.this.W(this.a, view, true);
        }
    }

    public class b implements b.e {
        public final /* synthetic */ d a;

        public b(d dVar) {
            this.a = dVar;
        }

        public boolean a(KeyEvent keyEvent) {
            return this.a.e() != null && this.a.e().onKey(this.a.a, keyEvent.getKeyCode(), keyEvent);
        }
    }

    public class c extends t {
        public d k;

        public class a implements View.OnClickListener {
            public final /* synthetic */ t.d a;

            public a(t.d dVar) {
                this.a = dVar;
            }

            public void onClick(View view) {
                t.d dVar = (t.d) c.this.k.p.i0(this.a.a);
                if (c.this.k.b() != null) {
                    androidx.leanback.widget.c b = c.this.k.b();
                    E.a aVar = this.a.u;
                    Object obj = dVar.w;
                    d dVar2 = c.this.k;
                    dVar2.getClass();
                    b.a(aVar, obj, dVar2, null);
                }
            }
        }

        public c(d dVar) {
            this.k = dVar;
        }

        public void l0(E e, int i) {
            this.k.o().getRecycledViewPool().k(i, v.this.L(e));
        }

        public void m0(t.d dVar) {
            v.this.H(this.k, dVar.a);
            this.k.m(dVar.a);
        }

        public void n0(t.d dVar) {
            if (this.k.b() != null) {
                dVar.u.a.setOnClickListener(new a(dVar));
            }
        }

        public void p0(t.d dVar) {
            ViewGroup viewGroup = dVar.a;
            if (viewGroup instanceof ViewGroup) {
                androidx.leanback.transition.a.a(viewGroup, true);
            }
            Q q = v.this.p;
            if (q != null) {
                q.f(dVar.a);
            }
        }

        public void r0(t.d dVar) {
            if (this.k.b() != null) {
                dVar.u.a.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public static class d extends M.b {
        public final v o;
        public final HorizontalGridView p;
        public t q;
        public final o r;
        public final int s;
        public final int t;
        public final int u;
        public final int v;

        public d(View view, HorizontalGridView horizontalGridView, v vVar) {
            super(view);
            this.r = new o();
            this.p = horizontalGridView;
            this.o = vVar;
            this.s = horizontalGridView.getPaddingTop();
            this.t = horizontalGridView.getPaddingBottom();
            this.u = horizontalGridView.getPaddingLeft();
            this.v = horizontalGridView.getPaddingRight();
        }

        public final t n() {
            return this.q;
        }

        public final HorizontalGridView o() {
            return this.p;
        }
    }

    public v() {
        this(2);
    }

    public static void P(Context context) {
        if (r == 0) {
            r = context.getResources().getDimensionPixelSize(g0.c.c);
            s = context.getResources().getDimensionPixelSize(g0.c.b);
            t = context.getResources().getDimensionPixelSize(g0.c.a);
        }
    }

    public void A(M.b bVar) {
        d dVar = (d) bVar;
        dVar.p.setAdapter(null);
        dVar.q.j0();
        super.A(bVar);
    }

    public void B(M.b bVar, boolean z) {
        super.B(bVar, z);
        ((d) bVar).p.setChildrenVisibility(z ? 0 : 4);
    }

    public void H(d dVar, View view) {
        Q q = this.p;
        if (q == null || !q.d()) {
            return;
        }
        this.p.j(view, dVar.k.b().getColor());
    }

    public final boolean I() {
        return this.m;
    }

    public Q.b J() {
        return Q.b.d;
    }

    public int K() {
        int i = this.g;
        return i != 0 ? i : this.f;
    }

    public int L(E e) {
        if (this.o.containsKey(e)) {
            return ((Integer) this.o.get(e)).intValue();
        }
        return 24;
    }

    public int M() {
        return this.f;
    }

    public final boolean N() {
        return this.k;
    }

    public final int O(d dVar) {
        L.a a2 = dVar.a();
        if (a2 != null) {
            return l() != null ? l().j(a2) : a2.a.getPaddingBottom();
        }
        return 0;
    }

    public boolean Q() {
        return true;
    }

    public boolean R() {
        return Q.q();
    }

    public boolean S(Context context) {
        return !i0.a.c(context).d();
    }

    public boolean T(Context context) {
        return !i0.a.c(context).f();
    }

    public final boolean U() {
        return Q() && n();
    }

    public final boolean V() {
        return R() && N();
    }

    public void W(d dVar, View view, boolean z) {
        if (view == null) {
            if (this.h != null) {
                dVar.r.j();
            }
            if (!z || dVar.d() == null) {
                return;
            }
            dVar.d().a(null, null, dVar, null);
            return;
        }
        if (dVar.g) {
            t.d dVar2 = (t.d) dVar.p.i0(view);
            if (this.h != null) {
                dVar.r.k(dVar.p, view, dVar2.w);
            }
            if (!z || dVar.d() == null) {
                return;
            }
            dVar.d().a(dVar2.u, dVar2.w, dVar, null);
        }
    }

    public final void X(d dVar) {
        int i;
        int i2;
        if (dVar.h()) {
            i2 = (dVar.i() ? s : dVar.s) - O(dVar);
            i = this.h == null ? t : dVar.t;
        } else if (dVar.i()) {
            i = r;
            i2 = i - dVar.t;
        } else {
            i = dVar.t;
            i2 = 0;
        }
        dVar.o().setPadding(dVar.u, i2, dVar.v, i);
    }

    public final void Y(w wVar) {
        HorizontalGridView gridView = wVar.getGridView();
        if (this.l < 0) {
            TypedArray obtainStyledAttributes = gridView.getContext().obtainStyledAttributes(g0.l.k);
            this.l = (int) obtainStyledAttributes.getDimension(g0.l.l, 0.0f);
            obtainStyledAttributes.recycle();
        }
        gridView.setFadingLeftEdgeLength(this.l);
    }

    public final void Z(d dVar) {
        if (!dVar.h || !dVar.g) {
            if (this.h != null) {
                dVar.r.j();
            }
        } else {
            F f = this.h;
            if (f != null) {
                dVar.r.c((ViewGroup) dVar.a, f);
            }
            HorizontalGridView horizontalGridView = dVar.p;
            t.d dVar2 = (t.d) horizontalGridView.b0(horizontalGridView.getSelectedPosition());
            W(dVar, dVar2 == null ? null : dVar2.a, false);
        }
    }

    public M.b i(ViewGroup viewGroup) {
        P(viewGroup.getContext());
        w wVar = new w(viewGroup.getContext());
        Y(wVar);
        if (this.f != 0) {
            wVar.getGridView().setRowHeight(this.f);
        }
        return new d(wVar, wVar.getGridView(), this);
    }

    public void j(M.b bVar, boolean z) {
        d dVar = (d) bVar;
        HorizontalGridView horizontalGridView = dVar.p;
        t.d dVar2 = (t.d) horizontalGridView.b0(horizontalGridView.getSelectedPosition());
        if (dVar2 == null) {
            super.j(bVar, z);
            return;
        }
        if (!z || bVar.d() == null) {
            return;
        }
        androidx.leanback.widget.d d2 = bVar.d();
        E.a R = dVar2.R();
        Object obj = dVar2.w;
        dVar.f();
        d2.a(R, obj, dVar, null);
    }

    public void k(M.b bVar, boolean z) {
        d dVar = (d) bVar;
        dVar.p.setScrollEnabled(!z);
        dVar.p.setAnimateChildLayout(!z);
    }

    public void p(M.b bVar) {
        super.p(bVar);
        d dVar = (d) bVar;
        Context context = bVar.a.getContext();
        if (this.p == null) {
            Q a2 = new Q.a().c(U()).e(V()).d(S(context) && I()).g(T(context)).b(this.n).f(J()).a(context);
            this.p = a2;
            if (a2.e()) {
                this.q = new u(this.p);
            }
        }
        c cVar = new c(dVar);
        dVar.q = cVar;
        cVar.B0(this.q);
        this.p.g(dVar.p);
        h.c(dVar.q, this.i, this.j);
        dVar.p.setFocusDrawingOrderEnabled(this.p.c() != 3);
        dVar.p.setOnChildSelectedListener(new a(dVar));
        dVar.p.setOnUnhandledKeyListener(new b(dVar));
        dVar.p.setNumRows(this.e);
    }

    public final boolean r() {
        return false;
    }

    public void u(M.b bVar, Object obj) {
        super.u(bVar, obj);
        d.D.a(obj);
        t tVar = ((d) bVar).q;
        throw null;
    }

    public void x(M.b bVar, boolean z) {
        super.x(bVar, z);
        d dVar = (d) bVar;
        if (M() != K()) {
            dVar.o().setRowHeight(z ? K() : M());
        }
        X(dVar);
        Z(dVar);
    }

    public void y(M.b bVar, boolean z) {
        super.y(bVar, z);
        d dVar = (d) bVar;
        X(dVar);
        Z(dVar);
    }

    public void z(M.b bVar) {
        super.z(bVar);
        d dVar = (d) bVar;
        int childCount = dVar.p.getChildCount();
        for (int i = 0; i < childCount; i++) {
            H(dVar, dVar.p.getChildAt(i));
        }
    }

    public v(int i) {
        this(i, false);
    }

    public v(int i, boolean z) {
        this.e = 1;
        this.k = true;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = new HashMap();
        if (!h.b(i)) {
            throw new IllegalArgumentException("Unhandled zoom factor");
        }
        this.i = i;
        this.j = z;
    }
}
