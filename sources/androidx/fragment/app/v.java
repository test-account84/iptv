package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class v {
    public final ArrayList a = new ArrayList();
    public final HashMap b = new HashMap();
    public p c;

    public void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton((Object) null));
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public void d(int i) {
        for (t tVar : this.b.values()) {
            if (tVar != null) {
                tVar.u(i);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (t tVar : this.b.values()) {
                printWriter.print(str);
                if (tVar != null) {
                    Fragment k = tVar.k();
                    printWriter.println(k);
                    k.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    public Fragment f(String str) {
        t tVar = (t) this.b.get(str);
        if (tVar != null) {
            return tVar.k();
        }
        return null;
    }

    public Fragment g(int i) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.a.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (t tVar : this.b.values()) {
            if (tVar != null) {
                Fragment k = tVar.k();
                if (k.mFragmentId == i) {
                    return k;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (t tVar : this.b.values()) {
            if (tVar != null) {
                Fragment k = tVar.k();
                if (str.equals(k.mTag)) {
                    return k;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (t tVar : this.b.values()) {
            if (tVar != null && (findFragmentByWho = tVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.a.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = (Fragment) this.a.get(i);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.b.values()) {
            if (tVar != null) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.b.values()) {
            arrayList.add(tVar != null ? tVar.k() : null);
        }
        return arrayList;
    }

    public t m(String str) {
        return (t) this.b.get(str);
    }

    public List n() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public p o() {
        return this.c;
    }

    public void p(t tVar) {
        Fragment k = tVar.k();
        if (c(k.mWho)) {
            return;
        }
        this.b.put(k.mWho, tVar);
        if (k.mRetainInstanceChangedWhileDetached) {
            if (k.mRetainInstance) {
                this.c.b(k);
            } else {
                this.c.j(k);
            }
            k.mRetainInstanceChangedWhileDetached = false;
        }
        if (m.F0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k);
        }
    }

    public void q(t tVar) {
        Fragment k = tVar.k();
        if (k.mRetainInstance) {
            this.c.j(k);
        }
        if (((t) this.b.put(k.mWho, (Object) null)) != null && m.F0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k);
        }
    }

    public void r() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            t tVar = (t) this.b.get(((Fragment) it.next()).mWho);
            if (tVar != null) {
                tVar.m();
            }
        }
        for (t tVar2 : this.b.values()) {
            if (tVar2 != null) {
                tVar2.m();
                Fragment k = tVar2.k();
                if (k.mRemoving && !k.isInBackStack()) {
                    q(tVar2);
                }
            }
        }
    }

    public void s(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void t() {
        this.b.clear();
    }

    public void u(List list) {
        this.a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment f = f(str);
                if (f == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (m.F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f);
                }
                a(f);
            }
        }
    }

    public ArrayList v() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (t tVar : this.b.values()) {
            if (tVar != null) {
                Fragment k = tVar.k();
                s s = tVar.s();
                arrayList.add(s);
                if (m.F0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k + ": " + s.n);
                }
            }
        }
        return arrayList;
    }

    public ArrayList w() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.a.size());
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.mWho);
                    if (m.F0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x(p pVar) {
        this.c = pVar;
    }
}
