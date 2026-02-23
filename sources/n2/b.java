package n2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import n2.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements c {
    public final c a;
    public final int b;

    public b(c cVar, int i) {
        this.a = cVar;
        this.b = i;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, c.a aVar) {
        Drawable c = aVar.c();
        if (c == null) {
            this.a.a(drawable, aVar);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{c, drawable});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.b);
        aVar.a(transitionDrawable);
        return true;
    }
}
