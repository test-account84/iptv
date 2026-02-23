package K0;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class x {
    public static boolean a = true;

    public static v a(ViewGroup viewGroup) {
        return new u(viewGroup);
    }

    public static void b(ViewGroup viewGroup, boolean z) {
        if (a) {
            try {
                w.a(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }

    public static void c(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            w.a(viewGroup, z);
        } else {
            b(viewGroup, z);
        }
    }
}
