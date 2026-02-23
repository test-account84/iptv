package androidx.navigation;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class r {
    public static NavController a(Activity activity, int i) {
        NavController c = c(D.b.i(activity, i));
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    public static NavController b(View view) {
        NavController c = c(view);
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static NavController c(View view) {
        while (view != null) {
            NavController d = d(view);
            if (d != null) {
                return d;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static NavController d(View view) {
        Object tag = view.getTag(u.a);
        if (tag instanceof WeakReference) {
            tag = ((WeakReference) tag).get();
        } else if (!(tag instanceof NavController)) {
            return null;
        }
        return (NavController) tag;
    }

    public static void e(View view, NavController navController) {
        view.setTag(u.a, navController);
    }
}
