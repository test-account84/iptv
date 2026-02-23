package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class k {
    public static Drawable a(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return j.a(view);
        }
        return null;
    }

    public static void b(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            i.a(view, drawable);
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
