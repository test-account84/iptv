package a1;

import android.app.ActivityManager;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ List a(ActivityManager activityManager, String str, int i, int i2) {
        return activityManager.getHistoricalProcessExitReasons(str, i, i2);
    }
}
