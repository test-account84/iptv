package r5;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o {

    public static class b implements n, Serializable {
        public final List a;

        public b(List list) {
            this.a = list;
        }

        public boolean apply(Object obj) {
            for (int i = 0; i < this.a.size(); i++) {
                if (!((n) this.a.get(i)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + 306654252;
        }

        public String toString() {
            return o.a("and", this.a);
        }

        public /* synthetic */ b(List list, a aVar) {
            this(list);
        }
    }

    public static /* synthetic */ String a(String str, Iterable iterable) {
        return d(str, iterable);
    }

    public static n b(n nVar, n nVar2) {
        return new b(c((n) m.k(nVar), (n) m.k(nVar2)), null);
    }

    public static List c(n nVar, n nVar2) {
        return Arrays.asList(new n[]{nVar, nVar2});
    }

    public static String d(String str, Iterable iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
