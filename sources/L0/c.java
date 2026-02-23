package L0;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static Interpolator a(Context context, int i) {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
