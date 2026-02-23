package K0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n {
    public static l a = new b();
    public static ThreadLocal b = new ThreadLocal();
    public static ArrayList c = new ArrayList();

    public static void a(ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(ViewGroup viewGroup, l lVar) {
        if (c.contains(viewGroup) || !P.L.W(viewGroup)) {
            return;
        }
        c.add(viewGroup);
        if (lVar == null) {
            lVar = a;
        }
        l clone = lVar.clone();
        e(viewGroup, clone);
        k.b(viewGroup, null);
        d(viewGroup, clone);
    }

    public static s.a c() {
        s.a aVar;
        WeakReference weakReference = (WeakReference) b.get();
        if (weakReference != null && (aVar = (s.a) weakReference.get()) != null) {
            return aVar;
        }
        s.a aVar2 = new s.a();
        b.set(new WeakReference(aVar2));
        return aVar2;
    }

    public static void d(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void e(ViewGroup viewGroup, l lVar) {
        ArrayList arrayList = (ArrayList) c().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((l) it.next()).O(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.k(viewGroup, true);
        }
        k.a(viewGroup);
    }

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public l a;
        public ViewGroup c;

        public class a extends m {
            public final /* synthetic */ s.a a;

            public a(s.a aVar) {
                this.a = aVar;
            }

            public void c(l lVar) {
                ((ArrayList) this.a.get(a.this.c)).remove(lVar);
                lVar.Q(this);
            }
        }

        public a(l lVar, ViewGroup viewGroup) {
            this.a = lVar;
            this.c = viewGroup;
        }

        public final void a() {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!n.c.remove(this.c)) {
                return true;
            }
            s.a c = n.c();
            ArrayList arrayList = (ArrayList) c.get(this.c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                c.put(this.c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.a);
            this.a.b(new a(c));
            this.a.k(this.c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).S(this.c);
                }
            }
            this.a.P(this.c);
            return true;
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            n.c.remove(this.c);
            ArrayList arrayList = (ArrayList) n.c().get(this.c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).S(this.c);
                }
            }
            this.a.l(true);
        }

        public void onViewAttachedToWindow(View view) {
        }
    }
}
