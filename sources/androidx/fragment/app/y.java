package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class y extends z {

    public class a extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public a(Rect rect) {
            this.a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.a;
        }
    }

    public class b implements Transition.TransitionListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrayList c;

        public b(View view, ArrayList arrayList) {
            this.a = view;
            this.c = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.a.setVisibility(8);
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((View) this.c.get(i)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    public class c implements Transition.TransitionListener {
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

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.a;
            if (obj != null) {
                y.this.q(obj, this.c, null);
            }
            Object obj2 = this.d;
            if (obj2 != null) {
                y.this.q(obj2, this.e, null);
            }
            Object obj3 = this.f;
            if (obj3 != null) {
                y.this.q(obj3, this.g, null);
            }
        }
    }

    public class d implements Transition.TransitionListener {
        public final /* synthetic */ Runnable a;

        public d(Runnable runnable) {
            this.a = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.a.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public class e extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public e(Rect rect) {
            this.a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.a;
        }
    }

    public static boolean C(Transition transition) {
        return (z.l(transition.getTargetIds()) && z.l(transition.getTargetNames()) && z.l(transition.getTargetTypes())) ? false : true;
    }

    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            q(transitionSet, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void b(Object obj, ArrayList arrayList) {
        TransitionSet transitionSet = (Transition) obj;
        if (transitionSet == null) {
            return;
        }
        int i = 0;
        if (transitionSet instanceof TransitionSet) {
            TransitionSet transitionSet2 = transitionSet;
            int transitionCount = transitionSet2.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet2.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (C(transitionSet) || !z.l(transitionSet.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transitionSet.addTarget((View) arrayList.get(i));
            i++;
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    public Object g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = (Transition) obj;
        TransitionSet transitionSet2 = (Transition) obj2;
        Transition transition = (Transition) obj3;
        if (transitionSet != null && transitionSet2 != null) {
            transitionSet = new TransitionSet().addTransition(transitionSet).addTransition(transitionSet2).setOrdering(1);
        } else if (transitionSet == null) {
            transitionSet = transitionSet2 != null ? transitionSet2 : null;
        }
        if (transition == null) {
            return transitionSet;
        }
        TransitionSet transitionSet3 = new TransitionSet();
        if (transitionSet != null) {
            transitionSet3.addTransition(transitionSet);
        }
        transitionSet3.addTransition(transition);
        return transitionSet3;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List targets;
        TransitionSet transitionSet = (Transition) obj;
        int i = 0;
        if (transitionSet instanceof TransitionSet) {
            TransitionSet transitionSet2 = transitionSet;
            int transitionCount = transitionSet2.getTransitionCount();
            while (i < transitionCount) {
                q(transitionSet2.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (C(transitionSet) || (targets = transitionSet.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transitionSet.addTarget((View) arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transitionSet.removeTarget((View) arrayList.get(size2));
        }
    }

    public void r(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    public void w(Fragment fragment, Object obj, L.e eVar, Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    public void z(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            z.d(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
