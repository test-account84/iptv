package m7;

import android.app.ActivityManager;
import android.content.ComponentName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class m {
    public static /* bridge */ /* synthetic */ ComponentName a(ActivityManager.RunningTaskInfo runningTaskInfo) {
        return runningTaskInfo.topActivity;
    }
}
