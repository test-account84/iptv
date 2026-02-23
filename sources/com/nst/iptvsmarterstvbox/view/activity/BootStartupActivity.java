package com.nst.iptvsmarterstvbox.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications.NotificationUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BootStartupActivity extends BroadcastReceiver {
    public SharedPreferences a;

    public void onReceive(Context context, Intent intent) {
        Log.e("onReceive", "context :-> " + context + " intent -> " + intent);
        SharedPreferences sharedPreferences = context.getSharedPreferences("auto_start", 0);
        this.a = sharedPreferences;
        if (sharedPreferences.getBoolean("auto_start", true)) {
            if (Build.VERSION.SDK_INT > 29) {
                new NotificationUtils(context).q("App Ready", "Tap to launch the app", "", new Intent(context, SplashActivity.class), (String) null, "");
            } else {
                if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                    return;
                }
                Intent intent2 = new Intent(context, SplashActivity.class);
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        }
    }
}
