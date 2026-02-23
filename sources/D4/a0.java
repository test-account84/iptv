package d4;

import android.os.Trace;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a0 {
    public static void a(String str) {
        if (k0.a >= 18) {
            b(str);
        }
    }

    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (k0.a >= 18) {
            d();
        }
    }

    public static void d() {
        Trace.endSection();
    }
}
