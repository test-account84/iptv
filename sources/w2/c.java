package W2;

import O2.w0;
import d4.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {
    public static final x a;

    public class a extends x {
        public a(String... strArr) {
            super(strArr);
        }

        public void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        w0.a("goog.exo.gav1");
        a = new a("gav1JNI");
    }

    public static boolean a() {
        return a.a();
    }
}
