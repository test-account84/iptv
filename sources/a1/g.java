package a1;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {
    public static final String a = Q0.k.f("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Q0.k.c().a(a, String.format("%s %s", new Object[]{cls.getName(), z ? "enabled" : "disabled"}), new Throwable[0]);
        } catch (Exception e) {
            Q0.k.c().a(a, String.format("%s could not be %s", new Object[]{cls.getName(), z ? "enabled" : "disabled"}), e);
        }
    }
}
