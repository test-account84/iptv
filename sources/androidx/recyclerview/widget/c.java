package androidx.recyclerview.widget;

import P.L;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends n {
    public static TimeInterpolator s;
    public ArrayList h = new ArrayList();
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public ArrayList k = new ArrayList();
    public ArrayList l = new ArrayList();
    public ArrayList m = new ArrayList();
    public ArrayList n = new ArrayList();
    public ArrayList o = new ArrayList();
    public ArrayList p = new ArrayList();
    public ArrayList q = new ArrayList();
    public ArrayList r = new ArrayList();

    public class a implements Runnable {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.U(jVar.a, jVar.b, jVar.c, jVar.d, jVar.e);
            }
            this.a.clear();
            c.this.m.remove(this.a);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                c.this.T((i) it.next());
            }
            this.a.clear();
            c.this.n.remove(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ArrayList a;

        public c(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                c.this.S((RecyclerView.D) it.next());
            }
            this.a.clear();
            c.this.l.remove(this.a);
        }
    }

    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.D a;
        public final /* synthetic */ ViewPropertyAnimator c;
        public final /* synthetic */ View d;

        public d(RecyclerView.D d, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = d;
            this.c = viewPropertyAnimator;
            this.d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.c.setListener((Animator.AnimatorListener) null);
            this.d.setAlpha(1.0f);
            c.this.H(this.a);
            c.this.q.remove(this.a);
            c.this.X();
        }

        public void onAnimationStart(Animator animator) {
            c.this.I(this.a);
        }
    }

    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.D a;
        public final /* synthetic */ View c;
        public final /* synthetic */ ViewPropertyAnimator d;

        public e(RecyclerView.D d, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = d;
            this.c = view;
            this.d = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.c.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.d.setListener((Animator.AnimatorListener) null);
            c.this.B(this.a);
            c.this.o.remove(this.a);
            c.this.X();
        }

        public void onAnimationStart(Animator animator) {
            c.this.C(this.a);
        }
    }

    public class f extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.D a;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ int e;
        public final /* synthetic */ ViewPropertyAnimator f;

        public f(RecyclerView.D d, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = d;
            this.c = i;
            this.d = view;
            this.e = i2;
            this.f = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.c != 0) {
                this.d.setTranslationX(0.0f);
            }
            if (this.e != 0) {
                this.d.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f.setListener((Animator.AnimatorListener) null);
            c.this.F(this.a);
            c.this.p.remove(this.a);
            c.this.X();
        }

        public void onAnimationStart(Animator animator) {
            c.this.G(this.a);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ViewPropertyAnimator c;
        public final /* synthetic */ View d;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.c = viewPropertyAnimator;
            this.d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.c.setListener((Animator.AnimatorListener) null);
            this.d.setAlpha(1.0f);
            this.d.setTranslationX(0.0f);
            this.d.setTranslationY(0.0f);
            c.this.D(this.a.a, true);
            c.this.r.remove(this.a.a);
            c.this.X();
        }

        public void onAnimationStart(Animator animator) {
            c.this.E(this.a.a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ViewPropertyAnimator c;
        public final /* synthetic */ View d;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.c = viewPropertyAnimator;
            this.d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.c.setListener((Animator.AnimatorListener) null);
            this.d.setAlpha(1.0f);
            this.d.setTranslationX(0.0f);
            this.d.setTranslationY(0.0f);
            c.this.D(this.a.b, false);
            c.this.r.remove(this.a.b);
            c.this.X();
        }

        public void onAnimationStart(Animator animator) {
            c.this.E(this.a.b, false);
        }
    }

    public static class i {
        public RecyclerView.D a;
        public RecyclerView.D b;
        public int c;
        public int d;
        public int e;
        public int f;

        public i(RecyclerView.D d, RecyclerView.D d2) {
            this.a = d;
            this.b = d2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }

        public i(RecyclerView.D d, RecyclerView.D d2, int i, int i2, int i3, int i4) {
            this(d, d2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }
    }

    public static class j {
        public RecyclerView.D a;
        public int b;
        public int c;
        public int d;
        public int e;

        public j(RecyclerView.D d, int i, int i2, int i3, int i4) {
            this.a = d;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public boolean A(RecyclerView.D d2) {
        b0(d2);
        this.h.add(d2);
        return true;
    }

    public void S(RecyclerView.D d2) {
        View view = d2.a;
        ViewPropertyAnimator animate = view.animate();
        this.o.add(d2);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d2, view, animate)).start();
    }

    public void T(i iVar) {
        RecyclerView.D d2 = iVar.a;
        View view = d2 == null ? null : d2.a;
        RecyclerView.D d3 = iVar.b;
        View view2 = d3 != null ? d3.a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.r.add(iVar.a);
            duration.translationX(iVar.e - iVar.c);
            duration.translationY(iVar.f - iVar.d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.r.add(iVar.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    public void U(RecyclerView.D d2, int i2, int i3, int i4, int i5) {
        View view = d2.a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.p.add(d2);
        animate.setDuration(n()).setListener(new f(d2, i6, view, i7, animate)).start();
    }

    public final void V(RecyclerView.D d2) {
        View view = d2.a;
        ViewPropertyAnimator animate = view.animate();
        this.q.add(d2);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(d2, animate, view)).start();
    }

    public void W(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.D) list.get(size)).a.animate().cancel();
        }
    }

    public void X() {
        if (p()) {
            return;
        }
        i();
    }

    public final void Y(List list, RecyclerView.D d2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (a0(iVar, d2) && iVar.a == null && iVar.b == null) {
                list.remove(iVar);
            }
        }
    }

    public final void Z(i iVar) {
        RecyclerView.D d2 = iVar.a;
        if (d2 != null) {
            a0(iVar, d2);
        }
        RecyclerView.D d3 = iVar.b;
        if (d3 != null) {
            a0(iVar, d3);
        }
    }

    public final boolean a0(i iVar, RecyclerView.D d2) {
        boolean z = false;
        if (iVar.b == d2) {
            iVar.b = null;
        } else {
            if (iVar.a != d2) {
                return false;
            }
            iVar.a = null;
            z = true;
        }
        d2.a.setAlpha(1.0f);
        d2.a.setTranslationX(0.0f);
        d2.a.setTranslationY(0.0f);
        D(d2, z);
        return true;
    }

    public final void b0(RecyclerView.D d2) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d2.a.animate().setInterpolator(s);
        j(d2);
    }

    public boolean g(RecyclerView.D d2, List list) {
        return !list.isEmpty() || super.g(d2, list);
    }

    public void j(RecyclerView.D d2) {
        View view = d2.a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.j.get(size)).a == d2) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(d2);
                this.j.remove(size);
            }
        }
        Y(this.k, d2);
        if (this.h.remove(d2)) {
            view.setAlpha(1.0f);
            H(d2);
        }
        if (this.i.remove(d2)) {
            view.setAlpha(1.0f);
            B(d2);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.n.get(size2);
            Y(arrayList, d2);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).a == d2) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(d2);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.l.get(size5);
            if (arrayList3.remove(d2)) {
                view.setAlpha(1.0f);
                B(d2);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(d2);
        this.o.remove(d2);
        this.r.remove(d2);
        this.p.remove(d2);
        X();
    }

    public void k() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.j.get(size);
            View view = jVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(jVar.a);
            this.j.remove(size);
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            H((RecyclerView.D) this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.D d2 = (RecyclerView.D) this.i.get(size3);
            d2.a.setAlpha(1.0f);
            B(d2);
            this.i.remove(size3);
        }
        for (int size4 = this.k.size() - 1; size4 >= 0; size4--) {
            Z((i) this.k.get(size4));
        }
        this.k.clear();
        if (p()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(jVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.D d3 = (RecyclerView.D) arrayList2.get(size8);
                    d3.a.setAlpha(1.0f);
                    B(d3);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Z((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            W(this.q);
            W(this.p);
            W(this.o);
            W(this.r);
            i();
        }
    }

    public boolean p() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public void v() {
        boolean z = !this.h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                V((RecyclerView.D) it.next());
            }
            this.h.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    L.l0(((j) arrayList.get(0)).a.a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    L.l0(((i) arrayList2.get(0)).a.a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.i);
                this.l.add(arrayList3);
                this.i.clear();
                c cVar = new c(arrayList3);
                if (z || z2 || z3) {
                    L.l0(((RecyclerView.D) arrayList3.get(0)).a, cVar, (z ? o() : 0L) + Math.max(z2 ? n() : 0L, z3 ? m() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    public boolean x(RecyclerView.D d2) {
        b0(d2);
        d2.a.setAlpha(0.0f);
        this.i.add(d2);
        return true;
    }

    public boolean y(RecyclerView.D d2, RecyclerView.D d3, int i2, int i3, int i4, int i5) {
        if (d2 == d3) {
            return z(d2, i2, i3, i4, i5);
        }
        float translationX = d2.a.getTranslationX();
        float translationY = d2.a.getTranslationY();
        float alpha = d2.a.getAlpha();
        b0(d2);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        d2.a.setTranslationX(translationX);
        d2.a.setTranslationY(translationY);
        d2.a.setAlpha(alpha);
        if (d3 != null) {
            b0(d3);
            d3.a.setTranslationX(-i6);
            d3.a.setTranslationY(-i7);
            d3.a.setAlpha(0.0f);
        }
        this.k.add(new i(d2, d3, i2, i3, i4, i5));
        return true;
    }

    public boolean z(RecyclerView.D d2, int i2, int i3, int i4, int i5) {
        View view = d2.a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) d2.a.getTranslationY());
        b0(d2);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            F(d2);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.j.add(new j(d2, translationX, translationY, i4, i5));
        return true;
    }
}
