package k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c0 extends W {
    public final WeakReference b;

    public c0(Context context, Resources resources) {
        super(resources);
        this.b = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable a = a(i);
        Context context = (Context) this.b.get();
        if (a != null && context != null) {
            V.h().x(context, i, a);
        }
        return a;
    }
}
