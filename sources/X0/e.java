package x0;

import K0.n;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.k;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends a {
    public final WeakReference f;

    public e(Toolbar toolbar, b bVar) {
        super(toolbar.getContext(), bVar);
        this.f = new WeakReference(toolbar);
    }

    public void a(NavController navController, k kVar, Bundle bundle) {
        if (((Toolbar) this.f.get()) == null) {
            navController.x(this);
        } else {
            super.a(navController, kVar, bundle);
        }
    }

    public void c(Drawable drawable, int i) {
        Toolbar toolbar = (Toolbar) this.f.get();
        if (toolbar != null) {
            boolean z = drawable == null && toolbar.getNavigationIcon() != null;
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i);
            if (z) {
                n.a(toolbar);
            }
        }
    }

    public void d(CharSequence charSequence) {
        ((Toolbar) this.f.get()).setTitle(charSequence);
    }
}
