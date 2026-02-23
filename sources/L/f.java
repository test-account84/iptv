package L;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {

    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    public static i a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? i.i(a.a(configuration)) : i.a(configuration.locale);
    }
}
