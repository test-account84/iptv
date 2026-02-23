package K0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class y implements z {
    public final ViewOverlay a;

    public y(View view) {
        this.a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
