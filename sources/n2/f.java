package n2;

import android.view.View;
import android.view.animation.Animation;
import n2.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements c {
    public final a a;

    public interface a {
        Animation build();
    }

    public f(a aVar) {
        this.a = aVar;
    }

    public boolean a(Object obj, c.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.a.build());
        return false;
    }
}
