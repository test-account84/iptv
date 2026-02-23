package K0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l implements Cloneable {
    public static final int[] G = {2, 1, 3, 4};
    public static final g H = new a();
    public static ThreadLocal I = new ThreadLocal();
    public e D;
    public s.a E;
    public ArrayList u;
    public ArrayList v;
    public String a = getClass().getName();
    public long c = -1;
    public long d = -1;
    public TimeInterpolator e = null;
    public ArrayList f = new ArrayList();
    public ArrayList g = new ArrayList();
    public ArrayList h = null;
    public ArrayList i = null;
    public ArrayList j = null;
    public ArrayList k = null;
    public ArrayList l = null;
    public ArrayList m = null;
    public ArrayList n = null;
    public ArrayList o = null;
    public ArrayList p = null;
    public t q = new t();
    public t r = new t();
    public p s = null;
    public int[] t = G;
    public boolean w = false;
    public ArrayList x = new ArrayList();
    public int y = 0;
    public boolean z = false;
    public boolean A = false;
    public ArrayList B = null;
    public ArrayList C = new ArrayList();
    public g F = H;

    public class a extends g {
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ s.a a;

        public b(s.a aVar) {
            this.a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            l.this.x.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            l.this.x.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            l.this.p();
            animator.removeListener(this);
        }
    }

    public static class d {
        public View a;
        public String b;
        public s c;
        public P d;
        public l e;

        public d(View view, String str, l lVar, P p, s sVar) {
            this.a = view;
            this.b = str;
            this.c = sVar;
            this.d = p;
            this.e = lVar;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    public static boolean I(s sVar, s sVar2, String str) {
        Object obj = sVar.a.get(str);
        Object obj2 = sVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void e(t tVar, View view, s sVar) {
        tVar.a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.b.indexOfKey(id) >= 0) {
                tVar.b.put(id, (Object) null);
            } else {
                tVar.b.put(id, view);
            }
        }
        String M = P.L.M(view);
        if (M != null) {
            if (tVar.d.containsKey(M)) {
                tVar.d.put(M, null);
            } else {
                tVar.d.put(M, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView parent = view.getParent();
            if (parent.getAdapter().hasStableIds()) {
                long itemIdAtPosition = parent.getItemIdAtPosition(parent.getPositionForView(view));
                if (tVar.c.i(itemIdAtPosition) < 0) {
                    P.L.B0(view, true);
                    tVar.c.k(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.c.g(itemIdAtPosition);
                if (view2 != null) {
                    P.L.B0(view2, false);
                    tVar.c.k(itemIdAtPosition, null);
                }
            }
        }
    }

    public static s.a y() {
        s.a aVar = (s.a) I.get();
        if (aVar != null) {
            return aVar;
        }
        s.a aVar2 = new s.a();
        I.set(aVar2);
        return aVar2;
    }

    public List A() {
        return this.f;
    }

    public List B() {
        return this.h;
    }

    public List C() {
        return this.i;
    }

    public List D() {
        return this.g;
    }

    public String[] E() {
        return null;
    }

    public s F(View view, boolean z) {
        p pVar = this.s;
        if (pVar != null) {
            return pVar.F(view, z);
        }
        return (s) (z ? this.q : this.r).a.get(view);
    }

    public boolean G(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] E = E();
        if (E == null) {
            Iterator it = sVar.a.keySet().iterator();
            while (it.hasNext()) {
                if (I(sVar, sVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : E) {
            if (!I(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean H(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.l.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.m != null && P.L.M(view) != null && this.m.contains(P.L.M(view))) {
            return false;
        }
        if ((this.f.size() == 0 && this.g.size() == 0 && (((arrayList = this.i) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) || this.f.contains(Integer.valueOf(id)) || this.g.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.h;
        if (arrayList6 != null && arrayList6.contains(P.L.M(view))) {
            return true;
        }
        if (this.i != null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (((Class) this.i.get(i2)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void J(s.a aVar, s.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) sparseArray.valueAt(i);
            if (view2 != null && H(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i))) != null && H(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void K(s.a aVar, s.a aVar2) {
        s sVar;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.j(size);
            if (view != null && H(view) && (sVar = (s) aVar2.remove(view)) != null && H(sVar.b)) {
                this.u.add((s) aVar.m(size));
                this.v.add(sVar);
            }
        }
    }

    public final void L(s.a aVar, s.a aVar2, s.f fVar, s.f fVar2) {
        View view;
        int n = fVar.n();
        for (int i = 0; i < n; i++) {
            View view2 = (View) fVar.o(i);
            if (view2 != null && H(view2) && (view = (View) fVar2.g(fVar.j(i))) != null && H(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void M(s.a aVar, s.a aVar2, s.a aVar3, s.a aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) aVar3.o(i);
            if (view2 != null && H(view2) && (view = (View) aVar4.get(aVar3.j(i))) != null && H(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void N(t tVar, t tVar2) {
        s.a aVar = new s.a(tVar.a);
        s.a aVar2 = new s.a(tVar2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.t;
            if (i >= iArr.length) {
                d(aVar, aVar2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                K(aVar, aVar2);
            } else if (i2 == 2) {
                M(aVar, aVar2, tVar.d, tVar2.d);
            } else if (i2 == 3) {
                J(aVar, aVar2, tVar.b, tVar2.b);
            } else if (i2 == 4) {
                L(aVar, aVar2, tVar.c, tVar2.c);
            }
            i++;
        }
    }

    public void O(View view) {
        if (this.A) {
            return;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            K0.a.b((Animator) this.x.get(size));
        }
        ArrayList arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((f) arrayList2.get(i)).b(this);
            }
        }
        this.z = true;
    }

    public void P(ViewGroup viewGroup) {
        d dVar;
        this.u = new ArrayList();
        this.v = new ArrayList();
        N(this.q, this.r);
        s.a y = y();
        int size = y.size();
        P d2 = A.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) y.j(i);
            if (animator != null && (dVar = (d) y.get(animator)) != null && dVar.a != null && d2.equals(dVar.d)) {
                s sVar = dVar.c;
                View view = dVar.a;
                s F = F(view, true);
                s u = u(view, true);
                if (F == null && u == null) {
                    u = (s) this.r.a.get(view);
                }
                if ((F != null || u != null) && dVar.e.G(sVar, u)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        y.remove(animator);
                    }
                }
            }
        }
        o(viewGroup, this.q, this.r, this.u, this.v);
        U();
    }

    public l Q(f fVar) {
        ArrayList arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public l R(View view) {
        this.g.remove(view);
        return this;
    }

    public void S(View view) {
        if (this.z) {
            if (!this.A) {
                for (int size = this.x.size() - 1; size >= 0; size--) {
                    K0.a.c((Animator) this.x.get(size));
                }
                ArrayList arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i = 0; i < size2; i++) {
                        ((f) arrayList2.get(i)).e(this);
                    }
                }
            }
            this.z = false;
        }
    }

    public final void T(Animator animator, s.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            f(animator);
        }
    }

    public void U() {
        b0();
        s.a y = y();
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (y.containsKey(animator)) {
                b0();
                T(animator, y);
            }
        }
        this.C.clear();
        p();
    }

    public l V(long j) {
        this.d = j;
        return this;
    }

    public void W(e eVar) {
        this.D = eVar;
    }

    public l X(TimeInterpolator timeInterpolator) {
        this.e = timeInterpolator;
        return this;
    }

    public void Y(g gVar) {
        if (gVar == null) {
            gVar = H;
        }
        this.F = gVar;
    }

    public l a0(long j) {
        this.c = j;
        return this;
    }

    public l b(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.add(fVar);
        return this;
    }

    public void b0() {
        if (this.y == 0) {
            ArrayList arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).a(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public l c(View view) {
        this.g.add(view);
        return this;
    }

    public String c0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.d != -1) {
            str2 = str2 + "dur(" + this.d + ") ";
        }
        if (this.c != -1) {
            str2 = str2 + "dly(" + this.c + ") ";
        }
        if (this.e != null) {
            str2 = str2 + "interp(" + this.e + ") ";
        }
        if (this.f.size() <= 0 && this.g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f.size() > 0) {
            for (int i = 0; i < this.f.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f.get(i);
            }
        }
        if (this.g.size() > 0) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.g.get(i2);
            }
        }
        return str3 + ")";
    }

    public void cancel() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ((Animator) this.x.get(size)).cancel();
        }
        ArrayList arrayList = this.B;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.B.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((f) arrayList2.get(i)).d(this);
        }
    }

    public final void d(s.a aVar, s.a aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            s sVar = (s) aVar.o(i);
            if (H(sVar.b)) {
                this.u.add(sVar);
                this.v.add((Object) null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            s sVar2 = (s) aVar2.o(i2);
            if (H(sVar2.b)) {
                this.v.add(sVar2);
                this.u.add((Object) null);
            }
        }
    }

    public void f(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (z() >= 0) {
            animator.setStartDelay(z() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void g(s sVar);

    public final void h(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (((Class) this.l.get(i)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.c.add(this);
                    i(sVar);
                    e(z ? this.q : this.r, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (((Class) this.p.get(i2)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                h(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void j(s sVar);

    public void k(ViewGroup viewGroup, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        s.a aVar;
        l(z);
        if ((this.f.size() > 0 || this.g.size() > 0) && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.i) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.f.size(); i++) {
                View findViewById = viewGroup.findViewById(((Integer) this.f.get(i)).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.c.add(this);
                    i(sVar);
                    e(z ? this.q : this.r, findViewById, sVar);
                }
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                View view = (View) this.g.get(i2);
                s sVar2 = new s(view);
                if (z) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.c.add(this);
                i(sVar2);
                e(z ? this.q : this.r, view, sVar2);
            }
        } else {
            h(viewGroup, z);
        }
        if (z || (aVar = this.E) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.q.d.remove((String) this.E.j(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.q.d.put((String) this.E.o(i4), view2);
            }
        }
    }

    public void l(boolean z) {
        t tVar;
        if (z) {
            this.q.a.clear();
            this.q.b.clear();
            tVar = this.q;
        } else {
            this.r.a.clear();
            this.r.b.clear();
            tVar = this.r;
        }
        tVar.c.d();
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.C = new ArrayList();
            lVar.q = new t();
            lVar.r = new t();
            lVar.u = null;
            lVar.v = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        s sVar;
        int i;
        Animator animator2;
        s sVar2;
        s.a y = y();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            s sVar3 = (s) arrayList.get(i2);
            s sVar4 = (s) arrayList2.get(i2);
            if (sVar3 != null && !sVar3.c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.c.contains(this)) {
                sVar4 = null;
            }
            if ((sVar3 != null || sVar4 != null) && (sVar3 == null || sVar4 == null || G(sVar3, sVar4))) {
                Animator n = n(viewGroup, sVar3, sVar4);
                if (n != null) {
                    if (sVar4 != null) {
                        View view2 = sVar4.b;
                        String[] E = E();
                        if (E != null && E.length > 0) {
                            sVar2 = new s(view2);
                            s sVar5 = (s) tVar2.a.get(view2);
                            if (sVar5 != null) {
                                int i3 = 0;
                                while (i3 < E.length) {
                                    Map map = sVar2.a;
                                    Animator animator3 = n;
                                    String str = E[i3];
                                    map.put(str, sVar5.a.get(str));
                                    i3++;
                                    n = animator3;
                                    E = E;
                                }
                            }
                            Animator animator4 = n;
                            int size2 = y.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) y.get((Animator) y.j(i4));
                                if (dVar.c != null && dVar.a == view2 && dVar.b.equals(v()) && dVar.c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i4++;
                            }
                        } else {
                            animator2 = n;
                            sVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        view = sVar3.b;
                        animator = n;
                        sVar = null;
                    }
                    if (animator != null) {
                        i = size;
                        y.put(animator, new d(view, v(), this, A.d(viewGroup), sVar));
                        this.C.add(animator);
                    }
                    i2++;
                    size = i;
                }
                i = size;
                i2++;
                size = i;
            }
            i = size;
            i2++;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator5 = (Animator) this.C.get(sparseIntArray.keyAt(i5));
                animator5.setStartDelay((sparseIntArray.valueAt(i5) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    public void p() {
        int i = this.y - 1;
        this.y = i;
        if (i == 0) {
            ArrayList arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.q.c.n(); i3++) {
                View view = (View) this.q.c.o(i3);
                if (view != null) {
                    P.L.B0(view, false);
                }
            }
            for (int i4 = 0; i4 < this.r.c.n(); i4++) {
                View view2 = (View) this.r.c.o(i4);
                if (view2 != null) {
                    P.L.B0(view2, false);
                }
            }
            this.A = true;
        }
    }

    public long q() {
        return this.d;
    }

    public e s() {
        return this.D;
    }

    public TimeInterpolator t() {
        return this.e;
    }

    public String toString() {
        return c0("");
    }

    public s u(View view, boolean z) {
        p pVar = this.s;
        if (pVar != null) {
            return pVar.u(view, z);
        }
        ArrayList arrayList = z ? this.u : this.v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            s sVar = (s) arrayList.get(i);
            if (sVar == null) {
                return null;
            }
            if (sVar.b == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return (s) (z ? this.v : this.u).get(i);
        }
        return null;
    }

    public String v() {
        return this.a;
    }

    public g w() {
        return this.F;
    }

    public o x() {
        return null;
    }

    public long z() {
        return this.c;
    }

    public void Z(o oVar) {
    }

    public void i(s sVar) {
    }
}
