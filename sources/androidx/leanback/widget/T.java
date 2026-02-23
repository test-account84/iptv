package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.E;
import androidx.leanback.widget.y;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class t extends RecyclerView.g implements f {
    public y d;
    public e e;
    public F f;
    public g g;
    public b h;
    public ArrayList i = new ArrayList();
    public y.b j = new a();

    public class a extends y.b {
        public a() {
        }

        public void a() {
            t.this.w();
        }
    }

    public static class b {
        public abstract void a(E e, int i);

        public abstract void b(d dVar);

        public abstract void c(d dVar);

        public void d(d dVar, List list) {
            c(dVar);
        }

        public abstract void e(d dVar);

        public abstract void f(d dVar);

        public abstract void g(d dVar);
    }

    public final class c implements View.OnFocusChangeListener {
        public View.OnFocusChangeListener a;

        public c() {
        }

        public void onFocusChange(View view, boolean z) {
            if (t.this.e != null) {
                view = (View) view.getParent();
            }
            g gVar = t.this.g;
            if (gVar != null) {
                gVar.a(view, z);
            }
            View.OnFocusChangeListener onFocusChangeListener = this.a;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z);
            }
        }
    }

    public class d extends RecyclerView.D implements androidx.leanback.widget.e {
        public final E t;
        public final E.a u;
        public final c v;
        public Object w;
        public Object x;

        public d(E e, View view, E.a aVar) {
            super(view);
            this.v = t.this.new c();
            this.t = e;
            this.u = aVar;
        }

        public final Object P() {
            return this.x;
        }

        public final E Q() {
            return this.t;
        }

        public final E.a R() {
            return this.u;
        }

        public void S(Object obj) {
            this.x = obj;
        }

        public Object c(Class cls) {
            return this.u.c(cls);
        }
    }

    public static abstract class e {
        public abstract View a(View view);

        public abstract void b(View view, View view2);
    }

    public void A0(ArrayList arrayList) {
        this.i = arrayList;
    }

    public void B0(e eVar) {
        this.e = eVar;
    }

    public final void E(RecyclerView.D d2, int i) {
        d dVar = (d) d2;
        Object a2 = this.d.a(i);
        dVar.w = a2;
        dVar.t.b(dVar.u, a2);
        n0(dVar);
        b bVar = this.h;
        if (bVar != null) {
            bVar.c(dVar);
        }
    }

    public final void J(RecyclerView.D d2, int i, List list) {
        d dVar = (d) d2;
        Object a2 = this.d.a(i);
        dVar.w = a2;
        dVar.t.d(dVar.u, a2, list);
        n0(dVar);
        b bVar = this.h;
        if (bVar != null) {
            bVar.d(dVar, list);
        }
    }

    public final RecyclerView.D L(ViewGroup viewGroup, int i) {
        E.a e2;
        View view;
        E e3 = (E) this.i.get(i);
        e eVar = this.e;
        if (eVar != null) {
            view = eVar.a(viewGroup);
            e2 = e3.e(viewGroup);
            this.e.b(view, e2.a);
        } else {
            e2 = e3.e(viewGroup);
            view = e2.a;
        }
        d dVar = new d(e3, view, e2);
        p0(dVar);
        b bVar = this.h;
        if (bVar != null) {
            bVar.e(dVar);
        }
        View view2 = dVar.u.a;
        if (view2 != null) {
            dVar.v.a = view2.getOnFocusChangeListener();
            view2.setOnFocusChangeListener(dVar.v);
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.b(view);
        }
        return dVar;
    }

    public final boolean T(RecyclerView.D d2) {
        Z(d2);
        return false;
    }

    public final void W(RecyclerView.D d2) {
        d dVar = (d) d2;
        m0(dVar);
        b bVar = this.h;
        if (bVar != null) {
            bVar.b(dVar);
        }
        dVar.t.g(dVar.u);
    }

    public final void Y(RecyclerView.D d2) {
        d dVar = (d) d2;
        dVar.t.h(dVar.u);
        q0(dVar);
        b bVar = this.h;
        if (bVar != null) {
            bVar.f(dVar);
        }
    }

    public final void Z(RecyclerView.D d2) {
        d dVar = (d) d2;
        dVar.t.f(dVar.u);
        r0(dVar);
        b bVar = this.h;
        if (bVar != null) {
            bVar.g(dVar);
        }
        dVar.w = null;
    }

    public androidx.leanback.widget.e g(int i) {
        return (androidx.leanback.widget.e) this.i.get(i);
    }

    public void j0() {
        s0(null);
    }

    public ArrayList k0() {
        return this.i;
    }

    public void l0(E e2, int i) {
    }

    public void m0(d dVar) {
    }

    public int n() {
        y yVar = this.d;
        if (yVar != null) {
            return yVar.i();
        }
        return 0;
    }

    public void n0(d dVar) {
    }

    public long o(int i) {
        return this.d.b(i);
    }

    public int p(int i) {
        F f = this.f;
        if (f == null) {
            f = this.d.c();
        }
        E a2 = f.a(this.d.a(i));
        int indexOf = this.i.indexOf(a2);
        if (indexOf < 0) {
            this.i.add(a2);
            indexOf = this.i.indexOf(a2);
            l0(a2, indexOf);
            b bVar = this.h;
            if (bVar != null) {
                bVar.a(a2, indexOf);
            }
        }
        return indexOf;
    }

    public void p0(d dVar) {
    }

    public void q0(d dVar) {
    }

    public void r0(d dVar) {
    }

    public void s0(y yVar) {
        y yVar2 = this.d;
        if (yVar == yVar2) {
            return;
        }
        if (yVar2 != null) {
            yVar2.j(this.j);
        }
        this.d = yVar;
        if (yVar == null) {
            w();
            return;
        }
        yVar.g(this.j);
        if (v() != this.d.d()) {
            c0(this.d.d());
        }
        w();
    }

    public void t0(b bVar) {
        this.h = bVar;
    }

    public void x0(g gVar) {
        this.g = gVar;
    }

    public void z0(F f) {
        this.f = f;
        w();
    }
}
