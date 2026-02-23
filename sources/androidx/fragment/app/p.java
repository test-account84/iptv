package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class p extends I {
    public static final J.b h = new a();
    public final boolean d;
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;

    public class a implements J.b {
        public /* synthetic */ I a(Class cls, m0.a aVar) {
            return K.b(this, cls, aVar);
        }

        public I b(Class cls) {
            return new p(true);
        }
    }

    public p(boolean z) {
        this.d = z;
    }

    public static p f(M m) {
        return (p) new J(m, h).a(p.class);
    }

    public void b(Fragment fragment) {
        if (this.g) {
            if (m.F0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.a.containsKey(fragment.mWho)) {
                return;
            }
            this.a.put(fragment.mWho, fragment);
            if (m.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void c(Fragment fragment) {
        if (m.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        p pVar = (p) this.b.get(fragment.mWho);
        if (pVar != null) {
            pVar.onCleared();
            this.b.remove(fragment.mWho);
        }
        M m = (M) this.c.get(fragment.mWho);
        if (m != null) {
            m.a();
            this.c.remove(fragment.mWho);
        }
    }

    public Fragment d(String str) {
        return (Fragment) this.a.get(str);
    }

    public p e(Fragment fragment) {
        p pVar = (p) this.b.get(fragment.mWho);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this.d);
        this.b.put(fragment.mWho, pVar2);
        return pVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.a.equals(pVar.a) && this.b.equals(pVar.b) && this.c.equals(pVar.c);
    }

    public Collection g() {
        return new ArrayList(this.a.values());
    }

    public M h(Fragment fragment) {
        M m = (M) this.c.get(fragment.mWho);
        if (m != null) {
            return m;
        }
        M m2 = new M();
        this.c.put(fragment.mWho, m2);
        return m2;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public boolean i() {
        return this.e;
    }

    public void j(Fragment fragment) {
        if (this.g) {
            if (m.F0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.a.remove(fragment.mWho) == null || !m.F0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public void k(boolean z) {
        this.g = z;
    }

    public boolean l(Fragment fragment) {
        if (this.a.containsKey(fragment.mWho)) {
            return this.d ? this.e : !this.f;
        }
        return true;
    }

    public void onCleared() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.e = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
