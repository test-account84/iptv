package androidx.work.impl.background.systemalarm;

import Q0.k;
import R0.j;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = k.f("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        k.c().a(a, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (Build.VERSION.SDK_INT < 23) {
            context.startService(a.e(context));
            return;
        }
        try {
            j.m(context).v(goAsync());
        } catch (IllegalStateException e) {
            k.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
