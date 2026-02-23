package i5;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || g.a(configuration) == Integer.MAX_VALUE || g.a(configuration) == 0) {
            return null;
        }
        return i.a(typeface, J.a.b(h.a(typeface) + g.a(configuration), 1, 1000), typeface.isItalic());
    }
}
