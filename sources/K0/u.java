package K0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class u implements v {
    public final ViewGroupOverlay a;

    public u(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    public void c(View view) {
        this.a.add(view);
    }

    public void d(View view) {
        this.a.remove(view);
    }
}
