package androidx.fragment.app;

import P.H;
import P.L;
import P.O;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class z {

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ ArrayList e;
        public final /* synthetic */ ArrayList f;

        public a(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.a = i;
            this.c = arrayList;
            this.d = arrayList2;
            this.e = arrayList3;
            this.f = arrayList4;
        }

        public void run() {
            for (int i = 0; i < this.a; i++) {
                L.K0((View) this.c.get(i), (String) this.d.get(i));
                L.K0((View) this.e.get(i), (String) this.f.get(i));
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ Map c;

        public b(ArrayList arrayList, Map map) {
            this.a = arrayList;
            this.c = map;
        }

        public void run() {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.a.get(i);
                String M = L.M(view);
                if (M != null) {
                    L.K0(view, z.i(this.c, M));
                }
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ Map c;

        public c(ArrayList arrayList, Map map) {
            this.a = arrayList;
            this.c = map;
        }

        public void run() {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.a.get(i);
                L.K0(view, (String) this.c.get(L.M(view)));
            }
        }
    }

    public static void d(List list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (L.M(view) != null) {
            list.add(view);
        }
        for (int i = size; i < list.size(); i++) {
            ViewGroup viewGroup = (View) list.get(i);
            if (viewGroup instanceof ViewGroup) {
                ViewGroup viewGroup2 = viewGroup;
                int childCount = viewGroup2.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup2.getChildAt(i2);
                    if (!h(list, childAt, size) && L.M(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean h(List list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static String i(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public void f(ArrayList arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                view = (ViewGroup) view;
                if (!O.a(view)) {
                    int childCount = view.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        f(arrayList, view.getChildAt(i));
                    }
                    return;
                }
            }
            arrayList.add(view);
        }
    }

    public abstract Object g(Object obj);

    public void j(Map map, View view) {
        if (view.getVisibility() == 0) {
            String M = L.M(view);
            if (M != null) {
                map.put(M, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    j(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public void k(View view, Rect rect) {
        if (L.V(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    public ArrayList o(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(L.M(view));
            L.K0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract void r(Object obj, View view, ArrayList arrayList);

    public void s(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        H.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public abstract void w(Fragment fragment, Object obj, L.e eVar, Runnable runnable);

    public void x(View view, ArrayList arrayList, Map map) {
        H.a(view, new b(arrayList, map));
    }

    public void y(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String M = L.M(view2);
            arrayList4.add(M);
            if (M != null) {
                L.K0(view2, null);
                String str = (String) map.get(M);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        L.K0((View) arrayList2.get(i2), M);
                        break;
                    }
                    i2++;
                }
            }
        }
        H.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList arrayList);
}
