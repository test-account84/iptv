package androidx.fragment.app;

import P.H;
import P.L;
import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class x {
    public static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final z b = new y();
    public static final z c = w();

    public class a implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ L.e d;

        public a(g gVar, Fragment fragment, L.e eVar) {
            this.a = gVar;
            this.c = fragment;
            this.d = eVar;
        }

        public void run() {
            this.a.b(this.c, this.d);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void run() {
            x.A(this.a, 4);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ L.e d;

        public c(g gVar, Fragment fragment, L.e eVar) {
            this.a = gVar;
            this.c = fragment;
            this.d = eVar;
        }

        public void run() {
            this.a.b(this.c, this.d);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ z c;
        public final /* synthetic */ View d;
        public final /* synthetic */ Fragment e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ Object i;

        public d(Object obj, z zVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.a = obj;
            this.c = zVar;
            this.d = view;
            this.e = fragment;
            this.f = arrayList;
            this.g = arrayList2;
            this.h = arrayList3;
            this.i = obj2;
        }

        public void run() {
            Object obj = this.a;
            if (obj != null) {
                this.c.p(obj, this.d);
                this.g.addAll(x.k(this.c, this.a, this.e, this.f, this.d));
            }
            if (this.h != null) {
                if (this.i != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.d);
                    this.c.q(this.i, this.h, arrayList);
                }
                this.h.clear();
                this.h.add(this.d);
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ s.a e;
        public final /* synthetic */ View f;
        public final /* synthetic */ z g;
        public final /* synthetic */ Rect h;

        public e(Fragment fragment, Fragment fragment2, boolean z, s.a aVar, View view, z zVar, Rect rect) {
            this.a = fragment;
            this.c = fragment2;
            this.d = z;
            this.e = aVar;
            this.f = view;
            this.g = zVar;
            this.h = rect;
        }

        public void run() {
            x.f(this.a, this.c, this.d, this.e, false);
            View view = this.f;
            if (view != null) {
                this.g.k(view, this.h);
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ z a;
        public final /* synthetic */ s.a c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ h e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ View g;
        public final /* synthetic */ Fragment h;
        public final /* synthetic */ Fragment i;
        public final /* synthetic */ boolean j;
        public final /* synthetic */ ArrayList k;
        public final /* synthetic */ Object l;
        public final /* synthetic */ Rect m;

        public f(z zVar, s.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.a = zVar;
            this.c = aVar;
            this.d = obj;
            this.e = hVar;
            this.f = arrayList;
            this.g = view;
            this.h = fragment;
            this.i = fragment2;
            this.j = z;
            this.k = arrayList2;
            this.l = obj2;
            this.m = rect;
        }

        public void run() {
            s.a h = x.h(this.a, this.c, this.d, this.e);
            if (h != null) {
                this.f.addAll(h.values());
                this.f.add(this.g);
            }
            x.f(this.h, this.i, this.j, h, false);
            Object obj = this.d;
            if (obj != null) {
                this.a.A(obj, this.k, this.f);
                View s = x.s(h, this.e, this.l, this.j);
                if (s != null) {
                    this.a.k(s, this.m);
                }
            }
        }
    }

    public interface g {
        void a(Fragment fragment, L.e eVar);

        void b(Fragment fragment, L.e eVar);
    }

    public static class h {
        public Fragment a;
        public boolean b;
        public androidx.fragment.app.a c;
        public Fragment d;
        public boolean e;
        public androidx.fragment.app.a f;
    }

    public static void A(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }

    public static void B(Context context, androidx.fragment.app.g gVar, ArrayList arrayList, ArrayList arrayList2, int i, int i2, boolean z, g gVar2) {
        ViewGroup c2;
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                s.a d2 = d(keyAt, arrayList, arrayList2, i, i2);
                h hVar = (h) sparseArray.valueAt(i4);
                if (gVar.d() && (c2 = gVar.c(keyAt)) != null) {
                    if (z) {
                        o(c2, hVar, view, d2, gVar2);
                    } else {
                        n(c2, hVar, view, d2, gVar2);
                    }
                }
            }
        }
    }

    public static void a(ArrayList arrayList, s.a aVar, Collection collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.o(size);
            if (collection.contains(L.M(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(androidx.fragment.app.a r8, androidx.fragment.app.w.a r9, android.util.SparseArray r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.x.b(androidx.fragment.app.a, androidx.fragment.app.w$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray sparseArray, boolean z) {
        int size = aVar.c.size();
        for (int i = 0; i < size; i++) {
            b(aVar, (w.a) aVar.c.get(i), sparseArray, false, z);
        }
    }

    public static s.a d(int i, ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        s.a aVar = new s.a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i4);
            if (aVar2.F(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                ArrayList arrayList5 = aVar2.p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.p;
                        arrayList4 = aVar2.q;
                    } else {
                        ArrayList arrayList6 = aVar2.p;
                        arrayList3 = aVar2.q;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray sparseArray, boolean z) {
        if (aVar.t.n0().d()) {
            for (int size = aVar.c.size() - 1; size >= 0; size--) {
                b(aVar, (w.a) aVar.c.get(size), sparseArray, true, z);
            }
        }
    }

    public static void f(Fragment fragment, Fragment fragment2, boolean z, s.a aVar, boolean z2) {
        if (z) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static boolean g(z zVar, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static s.a h(z zVar, s.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        Fragment fragment = hVar.a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        s.a aVar2 = new s.a();
        zVar.j(aVar2, view);
        androidx.fragment.app.a aVar3 = hVar.c;
        if (hVar.b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.p;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.q;
        }
        if (arrayList != null) {
            aVar2.q(arrayList);
            aVar2.q(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    public static s.a i(z zVar, s.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.d;
        s.a aVar2 = new s.a();
        zVar.j(aVar2, fragment.requireView());
        androidx.fragment.app.a aVar3 = hVar.f;
        if (hVar.e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.q;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.p;
        }
        if (arrayList != null) {
            aVar2.q(arrayList);
        }
        aVar.q(aVar2.keySet());
        return aVar2;
    }

    public static z j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        z zVar = b;
        if (zVar != null && g(zVar, arrayList)) {
            return zVar;
        }
        z zVar2 = c;
        if (zVar2 != null && g(zVar2, arrayList)) {
            return zVar2;
        }
        if (zVar == null && zVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList k(z zVar, Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            zVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        zVar.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object l(z zVar, ViewGroup viewGroup, View view, s.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object t;
        s.a aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t = null;
        } else {
            t = t(zVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        s.a i = i(zVar, aVar2, t, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i.values());
            obj3 = t;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i, true);
        if (obj3 != null) {
            rect = new Rect();
            zVar.z(obj3, view, arrayList);
            z(zVar, obj3, obj2, i, hVar.e, hVar.f);
            if (obj != null) {
                zVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        H.a(viewGroup, new f(zVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    public static Object m(z zVar, ViewGroup viewGroup, View view, s.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.b;
        Object t = aVar.isEmpty() ? null : t(zVar, fragment, fragment2, z);
        s.a i = i(zVar, aVar, t, hVar);
        s.a h2 = h(zVar, aVar, t, hVar);
        if (aVar.isEmpty()) {
            if (i != null) {
                i.clear();
            }
            if (h2 != null) {
                h2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i, aVar.keySet());
            a(arrayList2, h2, aVar.values());
            obj3 = t;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i, true);
        if (obj3 != null) {
            arrayList2.add(view);
            zVar.z(obj3, view, arrayList);
            z(zVar, obj3, obj2, i, hVar.e, hVar.f);
            Rect rect2 = new Rect();
            View s = s(h2, hVar, obj, z);
            if (s != null) {
                zVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s;
        } else {
            view2 = null;
            rect = null;
        }
        H.a(viewGroup, new e(fragment, fragment2, z, h2, view2, zVar, rect));
        return obj3;
    }

    public static void n(ViewGroup viewGroup, h hVar, View view, s.a aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.d;
        z j = j(fragment2, fragment);
        if (j == null) {
            return;
        }
        boolean z = hVar.b;
        boolean z2 = hVar.e;
        Object q = q(j, fragment, z);
        Object r = r(j, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object l = l(j, viewGroup, view, aVar, hVar, arrayList, arrayList2, q, r);
        if (q == null && l == null) {
            obj = r;
            if (obj == null) {
                return;
            }
        } else {
            obj = r;
        }
        ArrayList k = k(j, obj, fragment2, arrayList, view);
        if (k == null || k.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        j.a(q, view);
        Object u = u(j, q, obj2, l, fragment, hVar.b);
        if (fragment2 != null && k != null && (k.size() > 0 || arrayList.size() > 0)) {
            L.e eVar = new L.e();
            gVar.a(fragment2, eVar);
            j.w(fragment2, u, eVar, new c(gVar, fragment2, eVar));
        }
        if (u != null) {
            ArrayList arrayList3 = new ArrayList();
            j.t(u, q, arrayList3, obj2, k, l, arrayList2);
            y(j, viewGroup, fragment, view, arrayList2, q, arrayList3, obj2, k);
            j.x(viewGroup, arrayList2, aVar);
            j.c(viewGroup, u);
            j.s(viewGroup, arrayList2, aVar);
        }
    }

    public static void o(ViewGroup viewGroup, h hVar, View view, s.a aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.d;
        z j = j(fragment2, fragment);
        if (j == null) {
            return;
        }
        boolean z = hVar.b;
        boolean z2 = hVar.e;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object q = q(j, fragment, z);
        Object r = r(j, fragment2, z2);
        Object m = m(j, viewGroup, view, aVar, hVar, arrayList2, arrayList, q, r);
        if (q == null && m == null) {
            obj = r;
            if (obj == null) {
                return;
            }
        } else {
            obj = r;
        }
        ArrayList k = k(j, obj, fragment2, arrayList2, view);
        ArrayList k2 = k(j, q, fragment, arrayList, view);
        A(k2, 4);
        Object u = u(j, q, obj, m, fragment, z);
        if (fragment2 != null && k != null && (k.size() > 0 || arrayList2.size() > 0)) {
            L.e eVar = new L.e();
            gVar.a(fragment2, eVar);
            j.w(fragment2, u, eVar, new a(gVar, fragment2, eVar));
        }
        if (u != null) {
            v(j, obj, fragment2, k);
            ArrayList o = j.o(arrayList);
            j.t(u, q, k2, obj, k, m, arrayList);
            j.c(viewGroup, u);
            j.y(viewGroup, arrayList2, arrayList, o, aVar);
            A(k2, 0);
            j.A(m, arrayList2, arrayList);
        }
    }

    public static h p(h hVar, SparseArray sparseArray, int i) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i, hVar2);
        return hVar2;
    }

    public static Object q(z zVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return zVar.g(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    public static Object r(z zVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return zVar.g(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    public static View s(s.a aVar, h hVar, Object obj, boolean z) {
        ArrayList arrayList;
        androidx.fragment.app.a aVar2 = hVar.c;
        if (obj == null || aVar == null || (arrayList = aVar2.p) == null || arrayList.isEmpty()) {
            return null;
        }
        return (View) aVar.get((String) (z ? aVar2.p : aVar2.q).get(0));
    }

    public static Object t(z zVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return zVar.B(zVar.g(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    public static Object u(z zVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? zVar.n(obj2, obj, obj3) : zVar.m(obj2, obj, obj3);
    }

    public static void v(z zVar, Object obj, Fragment fragment, ArrayList arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            zVar.r(obj, fragment.getView(), arrayList);
            H.a(fragment.mContainer, new b(arrayList));
        }
    }

    public static z w() {
        try {
            return (z) K0.e.class.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void x(s.a aVar, s.a aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.o(size))) {
                aVar.m(size);
            }
        }
    }

    public static void y(z zVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        H.a(viewGroup, new d(obj, zVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    public static void z(z zVar, Object obj, Object obj2, s.a aVar, boolean z, androidx.fragment.app.a aVar2) {
        ArrayList arrayList = aVar2.p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = (View) aVar.get((String) (z ? aVar2.q : aVar2.p).get(0));
        zVar.v(obj, view);
        if (obj2 != null) {
            zVar.v(obj2, view);
        }
    }
}
