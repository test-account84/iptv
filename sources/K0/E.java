package K0;

import K0.l;
import L.e;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends androidx.fragment.app.z {

    public class a extends l.e {
        public final /* synthetic */ Rect a;

        public a(Rect rect) {
            this.a = rect;
        }
    }

    public class c extends m {
        public final /* synthetic */ Object a;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ ArrayList e;
        public final /* synthetic */ Object f;
        public final /* synthetic */ ArrayList g;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.c = arrayList;
            this.d = obj2;
            this.e = arrayList2;
            this.f = obj3;
            this.g = arrayList3;
        }

        public void a(l lVar) {
            Object obj = this.a;
            if (obj != null) {
                e.this.q(obj, this.c, null);
            }
            Object obj2 = this.d;
            if (obj2 != null) {
                e.this.q(obj2, this.e, null);
            }
            Object obj3 = this.f;
            if (obj3 != null) {
                e.this.q(obj3, this.g, null);
            }
        }

        public void c(l lVar) {
            lVar.Q(this);
        }
    }

    public class d implements e.b {
        public final /* synthetic */ l a;

        public d(l lVar) {
            this.a = lVar;
        }

        public void a() {
            this.a.cancel();
        }
    }

    public class f extends l.e {
        public final /* synthetic */ Rect a;

        public f(Rect rect) {
            this.a = rect;
        }
    }

    public static boolean C(l lVar) {
        return (androidx.fragment.app.z.l(lVar.A()) && androidx.fragment.app.z.l(lVar.B()) && androidx.fragment.app.z.l(lVar.C())) ? false : true;
    }

    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.D().clear();
            pVar.D().addAll(arrayList2);
            q(pVar, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.f0((l) obj);
        return pVar;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).c(view);
        }
    }

    public void b(Object obj, ArrayList arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int i0 = pVar.i0();
            while (i < i0) {
                b(pVar.h0(i), arrayList);
                i++;
            }
            return;
        }
        if (C(lVar) || !androidx.fragment.app.z.l(lVar.D())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            lVar.c((View) arrayList.get(i));
            i++;
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        n.b(viewGroup, (l) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof l;
    }

    public Object g(Object obj) {
        if (obj != null) {
            return ((l) obj).m();
        }
        return null;
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        l lVar3 = (l) obj3;
        if (lVar != null && lVar2 != null) {
            lVar = new p().f0(lVar).f0(lVar2).n0(1);
        } else if (lVar == null) {
            lVar = lVar2 != null ? lVar2 : null;
        }
        if (lVar3 == null) {
            return lVar;
        }
        p pVar = new p();
        if (lVar != null) {
            pVar.f0(lVar);
        }
        pVar.f0(lVar3);
        return pVar;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.f0((l) obj);
        }
        if (obj2 != null) {
            pVar.f0((l) obj2);
        }
        if (obj3 != null) {
            pVar.f0((l) obj3);
        }
        return pVar;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((l) obj).R(view);
        }
    }

    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        l lVar = (l) obj;
        int i = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int i0 = pVar.i0();
            while (i < i0) {
                q(pVar.h0(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (C(lVar)) {
            return;
        }
        List D = lVar.D();
        if (D.size() == arrayList.size() && D.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                lVar.c((View) arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                lVar.R((View) arrayList.get(size2));
            }
        }
    }

    public void r(Object obj, View view, ArrayList arrayList) {
        ((l) obj).b(new b(view, arrayList));
    }

    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((l) obj).b(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).W(new f(rect));
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).W(new a(rect));
        }
    }

    public void w(Fragment fragment, Object obj, L.e eVar, Runnable runnable) {
        l lVar = (l) obj;
        eVar.d(new d(lVar));
        lVar.b(new e(runnable));
    }

    public void z(Object obj, View view, ArrayList arrayList) {
        p pVar = (p) obj;
        List D = pVar.D();
        D.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.z.d(D, (View) arrayList.get(i));
        }
        D.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }

    public class b implements l.f {
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrayList c;

        public b(View view, ArrayList arrayList) {
            this.a = view;
            this.c = arrayList;
        }

        public void a(l lVar) {
            lVar.Q(this);
            lVar.b(this);
        }

        public void c(l lVar) {
            lVar.Q(this);
            this.a.setVisibility(8);
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((View) this.c.get(i)).setVisibility(0);
            }
        }

        public void b(l lVar) {
        }

        public void d(l lVar) {
        }

        public void e(l lVar) {
        }
    }

    public class e implements l.f {
        public final /* synthetic */ Runnable a;

        public e(Runnable runnable) {
            this.a = runnable;
        }

        public void c(l lVar) {
            this.a.run();
        }

        public void a(l lVar) {
        }

        public void b(l lVar) {
        }

        public void d(l lVar) {
        }

        public void e(l lVar) {
        }
    }
}
