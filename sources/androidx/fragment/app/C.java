package androidx.fragment.app;

import L.e;
import P.H;
import P.L;
import P.O;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.C;
import androidx.fragment.app.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends C {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C.e.c.values().length];
            a = iArr;
            try {
                iArr[C.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[C.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[C.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ C.e c;

        public b(List list, C.e eVar) {
            this.a = list;
            this.c = eVar;
        }

        public void run() {
            if (this.a.contains(this.c)) {
                this.a.remove(this.c);
                c.this.s(this.c);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ C.e e;
        public final /* synthetic */ k f;

        public c(ViewGroup viewGroup, View view, boolean z, C.e eVar, k kVar) {
            this.a = viewGroup;
            this.c = view;
            this.d = z;
            this.e = eVar;
            this.f = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.c);
            if (this.d) {
                this.e.e().applyState(this.c);
            }
            this.f.a();
        }
    }

    public class d implements e.b {
        public final /* synthetic */ Animator a;

        public d(Animator animator) {
            this.a = animator;
        }

        public void a() {
            this.a.end();
        }
    }

    public class e implements Animation.AnimationListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ k c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                e eVar = e.this;
                eVar.a.endViewTransition(eVar.b);
                e.this.c.a();
            }
        }

        public e(ViewGroup viewGroup, View view, k kVar) {
            this.a = viewGroup;
            this.b = view;
            this.c = kVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class f implements e.b {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ k c;

        public f(View view, ViewGroup viewGroup, k kVar) {
            this.a = view;
            this.b = viewGroup;
            this.c = kVar;
        }

        public void a() {
            this.a.clearAnimation();
            this.b.endViewTransition(this.a);
            this.c.a();
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ C.e a;
        public final /* synthetic */ C.e c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ s.a e;

        public g(C.e eVar, C.e eVar2, boolean z, s.a aVar) {
            this.a = eVar;
            this.c = eVar2;
            this.d = z;
            this.e = aVar;
        }

        public void run() {
            x.f(this.a.f(), this.c.f(), this.d, this.e, false);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ z a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Rect d;

        public h(z zVar, View view, Rect rect) {
            this.a = zVar;
            this.c = view;
            this.d = rect;
        }

        public void run() {
            this.a.k(this.c, this.d);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ ArrayList a;

        public i(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void run() {
            x.A(this.a, 4);
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ m a;

        public j(m mVar) {
            this.a = mVar;
        }

        public void run() {
            this.a.a();
        }
    }

    public static class k extends l {
        public boolean c;
        public boolean d;
        public f.d e;

        public k(C.e eVar, L.e eVar2, boolean z) {
            super(eVar, eVar2);
            this.d = false;
            this.c = z;
        }

        public f.d e(Context context) {
            if (this.d) {
                return this.e;
            }
            f.d c = androidx.fragment.app.f.c(context, b().f(), b().e() == C.e.c.VISIBLE, this.c);
            this.e = c;
            this.d = true;
            return c;
        }
    }

    public static class l {
        public final C.e a;
        public final L.e b;

        public l(C.e eVar, L.e eVar2) {
            this.a = eVar;
            this.b = eVar2;
        }

        public void a() {
            this.a.d(this.b);
        }

        public C.e b() {
            return this.a;
        }

        public L.e c() {
            return this.b;
        }

        public boolean d() {
            C.e.c cVar;
            C.e.c from = C.e.c.from(this.a.f().mView);
            C.e.c e = this.a.e();
            return from == e || !(from == (cVar = C.e.c.VISIBLE) || e == cVar);
        }
    }

    public static class m extends l {
        public final Object c;
        public final boolean d;
        public final Object e;

        public m(C.e eVar, L.e eVar2, boolean z, boolean z2) {
            boolean z3;
            Object obj;
            super(eVar, eVar2);
            if (eVar.e() == C.e.c.VISIBLE) {
                Fragment f = eVar.f();
                this.c = z ? f.getReenterTransition() : f.getEnterTransition();
                Fragment f2 = eVar.f();
                z3 = z ? f2.getAllowReturnTransitionOverlap() : f2.getAllowEnterTransitionOverlap();
            } else {
                Fragment f3 = eVar.f();
                this.c = z ? f3.getReturnTransition() : f3.getExitTransition();
                z3 = true;
            }
            this.d = z3;
            if (z2) {
                Fragment f4 = eVar.f();
                obj = z ? f4.getSharedElementReturnTransition() : f4.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.e = obj;
        }

        public z e() {
            z f = f(this.c);
            z f2 = f(this.e);
            if (f == null || f2 == null || f == f2) {
                return f != null ? f : f2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.c + " which uses a different Transition  type than its shared element transition " + this.e);
        }

        public final z f(Object obj) {
            if (obj == null) {
                return null;
            }
            z zVar = x.b;
            if (zVar != null && zVar.e(obj)) {
                return zVar;
            }
            z zVar2 = x.c;
            if (zVar2 != null && zVar2.e(obj)) {
                return zVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        public Object g() {
            return this.e;
        }

        public Object h() {
            return this.c;
        }

        public boolean i() {
            return this.e != null;
        }

        public boolean j() {
            return this.d;
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(java.util.List r11, boolean r12) {
        /*
            r10 = this;
            java.util.Iterator r0 = r11.iterator()
            r1 = 0
            r6 = r1
            r7 = r6
        L7:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L44
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.C$e r1 = (androidx.fragment.app.C.e) r1
            androidx.fragment.app.Fragment r3 = r1.f()
            android.view.View r3 = r3.mView
            androidx.fragment.app.C$e$c r3 = androidx.fragment.app.C.e.c.from(r3)
            int[] r4 = androidx.fragment.app.c.a.a
            androidx.fragment.app.C$e$c r5 = r1.e()
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 == r2) goto L3c
            r2 = 2
            if (r4 == r2) goto L3c
            r2 = 3
            if (r4 == r2) goto L3c
            r2 = 4
            if (r4 == r2) goto L36
            goto L7
        L36:
            androidx.fragment.app.C$e$c r2 = androidx.fragment.app.C.e.c.VISIBLE
            if (r3 == r2) goto L7
            r7 = r1
            goto L7
        L3c:
            androidx.fragment.app.C$e$c r2 = androidx.fragment.app.C.e.c.VISIBLE
            if (r3 != r2) goto L7
            if (r6 != 0) goto L7
            r6 = r1
            goto L7
        L44:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r11)
            java.util.Iterator r11 = r11.iterator()
        L57:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L96
            java.lang.Object r4 = r11.next()
            androidx.fragment.app.C$e r4 = (androidx.fragment.app.C.e) r4
            L.e r5 = new L.e
            r5.<init>()
            r4.j(r5)
            androidx.fragment.app.c$k r8 = new androidx.fragment.app.c$k
            r8.<init>(r4, r5, r12)
            r0.add(r8)
            L.e r5 = new L.e
            r5.<init>()
            r4.j(r5)
            androidx.fragment.app.c$m r8 = new androidx.fragment.app.c$m
            r9 = 0
            if (r12 == 0) goto L84
            if (r4 != r6) goto L87
        L82:
            r9 = 1
            goto L87
        L84:
            if (r4 != r7) goto L87
            goto L82
        L87:
            r8.<init>(r4, r5, r12, r9)
            r3.add(r8)
            androidx.fragment.app.c$b r5 = new androidx.fragment.app.c$b
            r5.<init>(r1, r4)
            r4.a(r5)
            goto L57
        L96:
            r2 = r10
            r4 = r1
            r5 = r12
            java.util.Map r11 = r2.x(r3, r4, r5, r6, r7)
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r12 = r11.containsValue(r12)
            r10.w(r0, r1, r12, r11)
            java.util.Iterator r11 = r1.iterator()
        Laa:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Lba
            java.lang.Object r12 = r11.next()
            androidx.fragment.app.C$e r12 = (androidx.fragment.app.C.e) r12
            r10.s(r12)
            goto Laa
        Lba:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c.f(java.util.List, boolean):void");
    }

    public void s(C.e eVar) {
        eVar.e().applyState(eVar.f().mView);
    }

    public void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (O.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    public void u(Map map, View view) {
        String M = L.M(view);
        if (M != null) {
            map.put(M, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    public void v(s.a aVar, Collection collection) {
        Iterator it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(L.M((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }

    public final void w(List list, List list2, boolean z, Map map) {
        StringBuilder sb;
        String str;
        f.d e2;
        ViewGroup m2 = m();
        Context context = m2.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.d() || (e2 = kVar.e(context)) == null) {
                kVar.a();
            } else {
                Animator animator = e2.b;
                if (animator == null) {
                    arrayList.add(kVar);
                } else {
                    C.e b2 = kVar.b();
                    Fragment f2 = b2.f();
                    if (Boolean.TRUE.equals(map.get(b2))) {
                        if (androidx.fragment.app.m.F0(2)) {
                            Log.v("FragmentManager", "Ignoring Animator set on " + f2 + " as this Fragment was involved in a Transition.");
                        }
                        kVar.a();
                    } else {
                        boolean z3 = b2.e() == C.e.c.GONE;
                        if (z3) {
                            list2.remove(b2);
                        }
                        View view = f2.mView;
                        m2.startViewTransition(view);
                        animator.addListener(new c(m2, view, z3, b2, kVar));
                        animator.setTarget(view);
                        animator.start();
                        kVar.c().d(new d(animator));
                        z2 = true;
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar2 = (k) it2.next();
            C.e b3 = kVar2.b();
            Fragment f3 = b3.f();
            if (z) {
                if (androidx.fragment.app.m.F0(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f3);
                    str = " as Animations cannot run alongside Transitions.";
                    sb.append(str);
                    Log.v("FragmentManager", sb.toString());
                }
                kVar2.a();
            } else if (z2) {
                if (androidx.fragment.app.m.F0(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f3);
                    str = " as Animations cannot run alongside Animators.";
                    sb.append(str);
                    Log.v("FragmentManager", sb.toString());
                }
                kVar2.a();
            } else {
                View view2 = f3.mView;
                Animation animation = (Animation) O.h.f(((f.d) O.h.f(kVar2.e(context))).a);
                if (b3.e() != C.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    m2.startViewTransition(view2);
                    f.e eVar = new f.e(animation, m2, view2);
                    eVar.setAnimationListener(new e(m2, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().d(new f(view2, m2, kVar2));
            }
        }
    }

    public final Map x(List list, List list2, boolean z, C.e eVar, C.e eVar2) {
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        C.e eVar3;
        C.e eVar4;
        View view2;
        Object n;
        s.a aVar;
        ArrayList arrayList3;
        C.e eVar5;
        ArrayList arrayList4;
        Rect rect;
        View view3;
        z zVar;
        C.e eVar6;
        View view4;
        boolean z2 = z;
        C.e eVar7 = eVar;
        C.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        z zVar2 = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                z e2 = mVar.e();
                if (zVar2 == null) {
                    zVar2 = e2;
                } else if (e2 != null && zVar2 != e2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (zVar2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                hashMap.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        s.a aVar2 = new s.a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z3 = false;
        while (it3.hasNext()) {
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                eVar5 = eVar7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                zVar = zVar2;
                eVar6 = eVar8;
                view6 = view6;
            } else {
                Object B = zVar2.B(zVar2.g(mVar3.g()));
                Collection sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view7 = view6;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList7;
                }
                Collection sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                Fragment f2 = eVar.f();
                if (z2) {
                    f2.getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                } else {
                    f2.getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                }
                int i3 = 0;
                for (int size = sharedElementSourceNames.size(); i3 < size; size = size) {
                    aVar2.put((String) sharedElementSourceNames.get(i3), (String) sharedElementTargetNames2.get(i3));
                    i3++;
                }
                s.a aVar3 = new s.a();
                u(aVar3, eVar.f().mView);
                aVar3.q(sharedElementSourceNames);
                aVar2.q(aVar3.keySet());
                s.a aVar4 = new s.a();
                u(aVar4, eVar2.f().mView);
                aVar4.q(sharedElementTargetNames2);
                aVar4.q(aVar2.values());
                x.x(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList6;
                    eVar5 = eVar7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    zVar = zVar2;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar8;
                } else {
                    x.f(eVar2.f(), eVar.f(), z2, aVar3, true);
                    aVar = aVar2;
                    ArrayList arrayList8 = arrayList6;
                    H.a(m(), new g(eVar2, eVar, z, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view7;
                    } else {
                        view6 = (View) aVar3.get((String) sharedElementSourceNames.get(0));
                        zVar2.v(B, view6);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(aVar4.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = (View) aVar4.get((String) sharedElementTargetNames2.get(0))) != null) {
                        H.a(m(), new h(zVar2, view4, rect2));
                        z3 = true;
                    }
                    zVar2.z(B, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    zVar = zVar2;
                    zVar2.t(B, null, null, null, null, B, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    hashMap.put(eVar5, bool);
                    eVar6 = eVar2;
                    hashMap.put(eVar6, bool);
                    obj3 = B;
                }
            }
            eVar7 = eVar5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            eVar8 = eVar6;
            aVar2 = aVar;
            z2 = z;
            arrayList6 = arrayList3;
            zVar2 = zVar;
        }
        View view8 = view6;
        s.a aVar5 = aVar2;
        ArrayList arrayList9 = arrayList6;
        C.e eVar9 = eVar7;
        ArrayList arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view9 = view5;
        z zVar3 = zVar2;
        C.e eVar10 = eVar8;
        ArrayList arrayList11 = new ArrayList();
        Iterator it4 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it4.hasNext()) {
            m mVar4 = (m) it4.next();
            if (mVar4.d()) {
                hashMap.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object g2 = zVar3.g(mVar4.h());
                C.e b2 = mVar4.b();
                boolean z4 = obj3 != null && (b2 == eVar9 || b2 == eVar10);
                if (g2 == null) {
                    if (!z4) {
                        hashMap.put(b2, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view9;
                    n = obj4;
                    eVar3 = eVar10;
                    view2 = view8;
                } else {
                    ArrayList arrayList12 = new ArrayList();
                    Object obj6 = obj4;
                    t(arrayList12, b2.f().mView);
                    if (z4) {
                        if (b2 == eVar9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        zVar3.a(g2, view9);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view9;
                        eVar4 = b2;
                        obj2 = obj5;
                        eVar3 = eVar10;
                        obj = obj6;
                    } else {
                        zVar3.b(g2, arrayList12);
                        view = view9;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        eVar3 = eVar10;
                        zVar3.t(g2, g2, arrayList12, null, null, null, null);
                        if (b2.e() == C.e.c.GONE) {
                            eVar4 = b2;
                            list2.remove(eVar4);
                            ArrayList arrayList13 = new ArrayList(arrayList12);
                            arrayList13.remove(eVar4.f().mView);
                            zVar3.r(g2, eVar4.f().mView, arrayList13);
                            H.a(m(), new i(arrayList12));
                        } else {
                            eVar4 = b2;
                        }
                    }
                    if (eVar4.e() == C.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z3) {
                            zVar3.u(g2, rect3);
                        }
                        view2 = view8;
                    } else {
                        view2 = view8;
                        zVar3.v(g2, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        obj5 = zVar3.n(obj2, g2, null);
                        n = obj;
                    } else {
                        n = zVar3.n(obj, g2, null);
                        obj5 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = n;
                view8 = view2;
                view9 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList arrayList14 = arrayList9;
        ArrayList arrayList15 = arrayList10;
        C.e eVar11 = eVar10;
        Object m2 = zVar3.m(obj5, obj4, obj3);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            m mVar5 = (m) it5.next();
            if (!mVar5.d()) {
                Object h2 = mVar5.h();
                C.e b3 = mVar5.b();
                boolean z5 = obj3 != null && (b3 == eVar9 || b3 == eVar11);
                if (h2 != null || z5) {
                    if (L.W(m())) {
                        zVar3.w(mVar5.b().f(), m2, mVar5.c(), new j(mVar5));
                    } else {
                        if (androidx.fragment.app.m.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b3);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!L.W(m())) {
            return hashMap;
        }
        x.A(arrayList11, 4);
        ArrayList o = zVar3.o(arrayList14);
        zVar3.c(m(), m2);
        zVar3.y(m(), arrayList15, arrayList14, o, aVar5);
        x.A(arrayList11, 0);
        zVar3.A(obj3, arrayList15, arrayList14);
        return hashMap;
    }
}
