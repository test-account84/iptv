package com.onesignal;

import android.app.Notification;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class P1 {
    public static /* bridge */ /* synthetic */ Notification.Builder a(Context context, Notification notification) {
        return Notification.Builder.recoverBuilder(context, notification);
    }
}
