package m0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {
    public final Map a = new LinkedHashMap();

    public static final class a extends a {
        public static final a b = new a();

        public Object a(b bVar) {
            l.e(bVar, "key");
            return null;
        }
    }

    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.a;
    }
}
