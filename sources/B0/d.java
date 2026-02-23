package b0;

import java.util.Map;
import kotlin.jvm.internal.l;
import l8.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {

    public static final class a {
        public final String a;

        public a(String str) {
            l.e(str, "name");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return l.a(this.a, ((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a;
        }
    }

    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final b0.a c() {
        return new b0.a(B.n(a()), false);
    }

    public final d d() {
        return new b0.a(B.n(a()), true);
    }
}
