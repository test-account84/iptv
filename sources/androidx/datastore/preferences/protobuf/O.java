package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o {
    public static boolean b = true;
    public static volatile o d;
    public final Map a = Collections.emptyMap();
    public static final Class c = c();
    public static final o e = new o(true);

    public static final class a {
        public final Object a;
        public final int b;

        public a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    public o(boolean z) {
    }

    public static o b() {
        o oVar = d;
        if (oVar == null) {
            synchronized (o.class) {
                try {
                    oVar = d;
                    if (oVar == null) {
                        oVar = b ? n.a() : e;
                        d = oVar;
                    }
                } finally {
                }
            }
        }
        return oVar;
    }

    public static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public w.c a(O o, int i) {
        d.D.a(this.a.get(new a(o, i)));
        return null;
    }
}
