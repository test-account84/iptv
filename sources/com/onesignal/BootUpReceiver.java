package com.onesignal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BootUpReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        OSNotificationRestoreWorkManager.c(context, true);
    }
}
