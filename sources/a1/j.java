package a1;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {
    public static final String a = Q0.k.f("ProcessUtils");

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return i.a();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, j.class.getClassLoader()).getDeclaredMethod("currentProcessName", (Class[]) null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, (Object[]) null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            Q0.k.c().a(a, "Unable to check ActivityThread for processName", th);
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static boolean b(Context context, androidx.work.a aVar) {
        return TextUtils.equals(a(context), !TextUtils.isEmpty(aVar.c()) ? aVar.c() : context.getApplicationInfo().processName);
    }
}
