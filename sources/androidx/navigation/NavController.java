package androidx.navigation;

import D.P;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.M;
import androidx.lifecycle.j;
import androidx.navigation.k;
import androidx.navigation.p;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class NavController {
    public final Context a;
    public Activity b;
    public o c;
    public l d;
    public Bundle e;
    public Parcelable[] f;
    public boolean g;
    public androidx.lifecycle.p i;
    public g j;
    public final Deque h = new ArrayDeque();
    public t k = new t();
    public final CopyOnWriteArrayList l = new CopyOnWriteArrayList();
    public final androidx.lifecycle.o m = new 1();
    public final androidx.activity.h n = new a(false);
    public boolean o = true;

    public class 1 implements androidx.lifecycle.n {
        public 1() {
        }

        public void b(androidx.lifecycle.p pVar, j.b bVar) {
            NavController navController = NavController.this;
            if (navController.d != null) {
                Iterator it = navController.h.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).e(bVar);
                }
            }
        }
    }

    public class a extends androidx.activity.h {
        public a(boolean z) {
            super(z);
        }

        public void b() {
            NavController.this.u();
        }
    }

    public interface b {
        void a(NavController navController, k kVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.b = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        t tVar = this.k;
        tVar.a(new m(tVar));
        this.k.a(new androidx.navigation.a(this.a));
    }

    public void A(int i) {
        B(i, null);
    }

    public void B(int i, Bundle bundle) {
        C(k().c(i), bundle);
    }

    public void C(l lVar, Bundle bundle) {
        l lVar2 = this.d;
        if (lVar2 != null) {
            w(lVar2.i(), true);
        }
        this.d = lVar;
        t(bundle);
    }

    public void D(androidx.lifecycle.p pVar) {
        if (pVar == this.i) {
            return;
        }
        this.i = pVar;
        pVar.getLifecycle().a(this.m);
    }

    public void E(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.i == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.n.d();
        onBackPressedDispatcher.b(this.i, this.n);
    }

    public void F(M m) {
        if (this.j == g.c(m)) {
            return;
        }
        if (!this.h.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.j = g.c(m);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void G() {
        /*
            r3 = this;
            androidx.activity.h r0 = r3.n
            boolean r1 = r3.o
            if (r1 == 0) goto Le
            int r1 = r3.i()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.f(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.G():void");
    }

    public void a(b bVar) {
        if (!this.h.isEmpty()) {
            e eVar = (e) this.h.peekLast();
            bVar.a(this, eVar.b(), eVar.a());
        }
        this.l.add(bVar);
    }

    public final boolean b() {
        k kVar;
        while (!this.h.isEmpty() && (((e) this.h.peekLast()).b() instanceof l) && w(((e) this.h.peekLast()).b().i(), true)) {
        }
        if (this.h.isEmpty()) {
            return false;
        }
        k b2 = ((e) this.h.peekLast()).b();
        if (b2 instanceof androidx.navigation.b) {
            Iterator descendingIterator = this.h.descendingIterator();
            while (descendingIterator.hasNext()) {
                kVar = ((e) descendingIterator.next()).b();
                if (!(kVar instanceof l) && !(kVar instanceof androidx.navigation.b)) {
                    break;
                }
            }
            kVar = null;
        } else {
            kVar = null;
        }
        HashMap hashMap = new HashMap();
        Iterator descendingIterator2 = this.h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            e eVar = (e) descendingIterator2.next();
            j.c c = eVar.c();
            k b3 = eVar.b();
            if (b2 != null && b3.i() == b2.i()) {
                j.c cVar = j.c.RESUMED;
                if (c != cVar) {
                    hashMap.put(eVar, cVar);
                }
                b2 = b2.n();
            } else if (kVar == null || b3.i() != kVar.i()) {
                eVar.h(j.c.CREATED);
            } else {
                if (c == j.c.RESUMED) {
                    eVar.h(j.c.STARTED);
                } else {
                    j.c cVar2 = j.c.STARTED;
                    if (c != cVar2) {
                        hashMap.put(eVar, cVar2);
                    }
                }
                kVar = kVar.n();
            }
        }
        for (e eVar2 : this.h) {
            j.c cVar3 = (j.c) hashMap.get(eVar2);
            if (cVar3 != null) {
                eVar2.h(cVar3);
            } else {
                eVar2.i();
            }
        }
        e eVar3 = (e) this.h.peekLast();
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, eVar3.b(), eVar3.a());
        }
        return true;
    }

    public void c(boolean z) {
        this.o = z;
        G();
    }

    public k d(int i) {
        l lVar = this.d;
        if (lVar == null) {
            return null;
        }
        if (lVar.i() == i) {
            return this.d;
        }
        l b2 = this.h.isEmpty() ? this.d : ((e) this.h.getLast()).b();
        return (b2 instanceof l ? b2 : b2.n()).A(i);
    }

    public final String e(int[] iArr) {
        l lVar;
        l lVar2 = this.d;
        int i = 0;
        while (true) {
            k kVar = null;
            if (i >= iArr.length) {
                return null;
            }
            int i2 = iArr[i];
            if (i != 0) {
                kVar = lVar2.A(i2);
            } else if (this.d.i() == i2) {
                kVar = this.d;
            }
            if (kVar == null) {
                return k.h(this.a, i2);
            }
            if (i != iArr.length - 1) {
                while (true) {
                    lVar = (l) kVar;
                    if (!(lVar.A(lVar.E()) instanceof l)) {
                        break;
                    }
                    kVar = lVar.A(lVar.E());
                }
                lVar2 = lVar;
            }
            i++;
        }
    }

    public Context f() {
        return this.a;
    }

    public e g() {
        if (this.h.isEmpty()) {
            return null;
        }
        return (e) this.h.getLast();
    }

    public k h() {
        e g = g();
        if (g != null) {
            return g.b();
        }
        return null;
    }

    public final int i() {
        Iterator it = this.h.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!(((e) it.next()).b() instanceof l)) {
                i++;
            }
        }
        return i;
    }

    public l j() {
        l lVar = this.d;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public o k() {
        if (this.c == null) {
            this.c = new o(this.a, this.k);
        }
        return this.c;
    }

    public t l() {
        return this.k;
    }

    public boolean m(Intent intent) {
        k.a o;
        l lVar;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (o = this.d.o(new j(intent))) != null) {
            k b2 = o.b();
            int[] d = b2.d();
            bundle.putAll(b2.c(o.h()));
            intArray = d;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String e = e(intArray);
        if (e != null) {
            Log.i("NavController", "Could not find destination " + e + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i = 268435456 & flags;
        if (i != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            P.e(this.a).b(intent).n();
            Activity activity = this.b;
            if (activity != null) {
                activity.finish();
                this.b.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i != 0) {
            if (!this.h.isEmpty()) {
                w(this.d.i(), true);
            }
            int i2 = 0;
            while (i2 < intArray.length) {
                int i3 = i2 + 1;
                int i4 = intArray[i2];
                k d2 = d(i4);
                if (d2 == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + k.h(this.a, i4) + " cannot be found from the current destination " + h());
                }
                r(d2, bundle, new p.a().b(0).c(0).a(), null);
                i2 = i3;
            }
            return true;
        }
        l lVar2 = this.d;
        int i5 = 0;
        while (i5 < intArray.length) {
            int i6 = intArray[i5];
            k A = i5 == 0 ? this.d : lVar2.A(i6);
            if (A == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + k.h(this.a, i6) + " cannot be found in graph " + lVar2);
            }
            if (i5 != intArray.length - 1) {
                while (true) {
                    lVar = (l) A;
                    if (!(lVar.A(lVar.E()) instanceof l)) {
                        break;
                    }
                    A = lVar.A(lVar.E());
                }
                lVar2 = lVar;
            } else {
                r(A, A.c(bundle), new p.a().g(this.d.i(), true).b(0).c(0).a(), null);
            }
            i5++;
        }
        this.g = true;
        return true;
    }

    public void n(int i) {
        o(i, null);
    }

    public void o(int i, Bundle bundle) {
        p(i, bundle, null);
    }

    public void p(int i, Bundle bundle, p pVar) {
        q(i, bundle, pVar, null);
    }

    public void q(int i, Bundle bundle, p pVar, s.a aVar) {
        int i2;
        k b2 = this.h.isEmpty() ? this.d : ((e) this.h.getLast()).b();
        if (b2 == null) {
            throw new IllegalStateException("no current navigation node");
        }
        c e = b2.e(i);
        Bundle bundle2 = null;
        if (e != null) {
            if (pVar == null) {
                pVar = e.c();
            }
            i2 = e.b();
            Bundle a2 = e.a();
            if (a2 != null) {
                bundle2 = new Bundle();
                bundle2.putAll(a2);
            }
        } else {
            i2 = i;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putAll(bundle);
        }
        if (i2 == 0 && pVar != null && pVar.e() != -1) {
            v(pVar.e(), pVar.f());
            return;
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        k d = d(i2);
        if (d != null) {
            r(d, bundle2, pVar, aVar);
            return;
        }
        String h = k.h(this.a, i2);
        if (e == null) {
            throw new IllegalArgumentException("Navigation action/destination " + h + " cannot be found from the current destination " + b2);
        }
        throw new IllegalArgumentException("Navigation destination " + h + " referenced from action " + k.h(this.a, i) + " cannot be found from the current destination " + b2);
    }

    public final void r(k kVar, Bundle bundle, p pVar, s.a aVar) {
        boolean z = false;
        boolean w = (pVar == null || pVar.e() == -1) ? false : w(pVar.e(), pVar.f());
        s e = this.k.e(kVar.l());
        Bundle c = kVar.c(bundle);
        k b2 = e.b(kVar, c, pVar, aVar);
        if (b2 != null) {
            if (!(b2 instanceof androidx.navigation.b)) {
                while (!this.h.isEmpty() && (((e) this.h.peekLast()).b() instanceof androidx.navigation.b) && w(((e) this.h.peekLast()).b().i(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (kVar instanceof l) {
                k kVar2 = b2;
                while (true) {
                    l n = kVar2.n();
                    if (n != null) {
                        arrayDeque.addFirst(new e(this.a, n, c, this.i, this.j));
                        if (!this.h.isEmpty() && ((e) this.h.getLast()).b() == n) {
                            w(n.i(), true);
                        }
                    }
                    if (n == null || n == kVar) {
                        break;
                    } else {
                        kVar2 = n;
                    }
                }
            }
            k b3 = arrayDeque.isEmpty() ? b2 : ((e) arrayDeque.getFirst()).b();
            while (b3 != null && d(b3.i()) == null) {
                b3 = b3.n();
                if (b3 != null) {
                    arrayDeque.addFirst(new e(this.a, b3, c, this.i, this.j));
                }
            }
            k b4 = arrayDeque.isEmpty() ? b2 : ((e) arrayDeque.getLast()).b();
            while (!this.h.isEmpty() && (((e) this.h.getLast()).b() instanceof l) && ((l) ((e) this.h.getLast()).b()).B(b4.i(), false) == null && w(((e) this.h.getLast()).b().i(), true)) {
            }
            this.h.addAll(arrayDeque);
            if (this.h.isEmpty() || ((e) this.h.getFirst()).b() != this.d) {
                this.h.addFirst(new e(this.a, this.d, c, this.i, this.j));
            }
            this.h.add(new e(this.a, b2, b2.c(c), this.i, this.j));
        } else if (pVar != null && pVar.g()) {
            e eVar = (e) this.h.peekLast();
            if (eVar != null) {
                eVar.f(c);
            }
            z = true;
        }
        G();
        if (w || b2 != null || z) {
            b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.navigation.k] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.navigation.k] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.navigation.k, androidx.navigation.l] */
    public boolean s() {
        int i;
        if (i() != 1) {
            return u();
        }
        ?? h = h();
        do {
            i = h.i();
            h = h.n();
            if (h == 0) {
                return false;
            }
        } while (h.E() == i);
        Bundle bundle = new Bundle();
        Activity activity = this.b;
        if (activity != null && activity.getIntent() != null && this.b.getIntent().getData() != null) {
            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", this.b.getIntent());
            k.a o = this.d.o(new j(this.b.getIntent()));
            if (o != null) {
                bundle.putAll(o.b().c(o.h()));
            }
        }
        new i(this).d(h.i()).c(bundle).a().n();
        Activity activity2 = this.b;
        if (activity2 != null) {
            activity2.finish();
        }
        return true;
    }

    public final void t(Bundle bundle) {
        Activity activity;
        ArrayList stringArrayList;
        Bundle bundle2 = this.e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator it = stringArrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                s e = this.k.e(str);
                Bundle bundle3 = this.e.getBundle(str);
                if (bundle3 != null) {
                    e.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                f fVar = (f) parcelable;
                k d = d(fVar.c());
                if (d == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + k.h(this.a, fVar.c()) + " cannot be found from the current destination " + h());
                }
                Bundle a2 = fVar.a();
                if (a2 != null) {
                    a2.setClassLoader(this.a.getClassLoader());
                }
                this.h.add(new e(this.a, d, a2, this.i, this.j, fVar.e(), fVar.d()));
            }
            G();
            this.f = null;
        }
        if (this.d == null || !this.h.isEmpty()) {
            b();
        } else if (this.g || (activity = this.b) == null || !m(activity.getIntent())) {
            r(this.d, bundle, null, null);
        }
    }

    public boolean u() {
        if (this.h.isEmpty()) {
            return false;
        }
        return v(h().i(), true);
    }

    public boolean v(int i, boolean z) {
        return w(i, z) && b();
    }

    public boolean w(int i, boolean z) {
        boolean z2 = false;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator descendingIterator = this.h.descendingIterator();
        while (descendingIterator.hasNext()) {
            k b2 = ((e) descendingIterator.next()).b();
            s e = this.k.e(b2.l());
            if (z || b2.i() != i) {
                arrayList.add(e);
            }
            if (b2.i() == i) {
                Iterator it = arrayList.iterator();
                while (it.hasNext() && ((s) it.next()).e()) {
                    e eVar = (e) this.h.removeLast();
                    if (eVar.getLifecycle().b().isAtLeast(j.c.CREATED)) {
                        eVar.h(j.c.DESTROYED);
                    }
                    g gVar = this.j;
                    if (gVar != null) {
                        gVar.b(eVar.g);
                    }
                    z2 = true;
                }
                G();
                return z2;
            }
        }
        Log.i("NavController", "Ignoring popBackStack to destination " + k.h(this.a, i) + " as it was not found on the current back stack");
        return false;
    }

    public void x(b bVar) {
        this.l.remove(bVar);
    }

    public void y(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.a.getClassLoader());
        this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle z() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.k.f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle d = ((s) entry.getValue()).d();
            if (d != null) {
                arrayList.add(str);
                bundle2.putBundle(str, d);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!this.h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.h.size()];
            Iterator it = this.h.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new f((e) it.next());
                i++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle;
    }
}
