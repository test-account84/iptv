package com.onesignal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class UpgradeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT == 24) {
            return;
        }
        OSNotificationRestoreWorkManager.c(context, true);
    }
}
