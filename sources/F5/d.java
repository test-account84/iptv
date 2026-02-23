package f5;

import P.W;
import P.w0;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d {
    public static void a(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = num == null || num.intValue() == 0;
        boolean z3 = num2 == null || num2.intValue() == 0;
        if (z2 || z3) {
            int b = Z4.a.b(window.getContext(), 16842801, -16777216);
            if (z2) {
                num = Integer.valueOf(b);
            }
            if (z3) {
                num2 = Integer.valueOf(b);
            }
        }
        W.b(window, !z);
        int c = c(window.getContext(), z);
        int b2 = b(window.getContext(), z);
        window.setStatusBarColor(c);
        window.setNavigationBarColor(b2);
        boolean d = d(c, Z4.a.f(num.intValue()));
        boolean d2 = d(b2, Z4.a.f(num2.intValue()));
        w0 a = W.a(window, window.getDecorView());
        if (a != null) {
            a.b(d);
            a.a(d2);
        }
    }

    public static int b(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 27) {
            return G.a.o(Z4.a.b(context, 16843858, -16777216), 128);
        }
        if (z) {
            return 0;
        }
        return Z4.a.b(context, 16843858, -16777216);
    }

    public static int c(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 23) {
            return G.a.o(Z4.a.b(context, 16843857, -16777216), 128);
        }
        if (z) {
            return 0;
        }
        return Z4.a.b(context, 16843857, -16777216);
    }

    public static boolean d(int i, boolean z) {
        return Z4.a.f(i) || (i == 0 && z);
    }
}
