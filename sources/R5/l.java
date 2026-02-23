package r5;

import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class l {
    public static final Logger a = Logger.getLogger(l.class.getName());
    public static final k b = b();

    public static final class b implements k {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static String a(String str) {
        if (d(str)) {
            return null;
        }
        return str;
    }

    public static k b() {
        return new b(null);
    }

    public static String c(String str) {
        return str == null ? "" : str;
    }

    public static boolean d(String str) {
        return str == null || str.isEmpty();
    }
}
