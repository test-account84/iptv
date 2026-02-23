package l5;

import android.graphics.drawable.Drawable;
import android.view.View;
import f5.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h {
    public static d a(int i) {
        return i != 0 ? i != 1 ? b() : new e() : new j();
    }

    public static d b() {
        return new j();
    }

    public static f c() {
        return new f();
    }

    public static void d(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).V(f);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.N()) {
            gVar.Z(w.d(view));
        }
    }
}
