package com.onesignal;

import android.app.NotificationManager;
import android.service.notification.StatusBarNotification;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class N1 {
    public static /* bridge */ /* synthetic */ StatusBarNotification[] a(NotificationManager notificationManager) {
        return notificationManager.getActiveNotifications();
    }
}
