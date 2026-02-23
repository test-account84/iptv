package androidx.navigation;

import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends I {
    public static final J.b b = new a();
    public final HashMap a = new HashMap();

    public class a implements J.b {
        public /* synthetic */ I a(Class cls, m0.a aVar) {
            return K.b(this, cls, aVar);
        }

        public I b(Class cls) {
            return new g();
        }
    }

    public static g c(M m) {
        return (g) new J(m, b).a(g.class);
    }

    public void b(UUID uuid) {
        M m = (M) this.a.remove(uuid);
        if (m != null) {
            m.a();
        }
    }

    public M d(UUID uuid) {
        M m = (M) this.a.get(uuid);
        if (m != null) {
            return m;
        }
        M m2 = new M();
        this.a.put(uuid, m2);
        return m2;
    }

    public void onCleared() {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((M) it.next()).a();
        }
        this.a.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
