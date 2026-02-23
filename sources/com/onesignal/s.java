package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class S {
    public static final S a = new S();

    public final void a(Context context) {
        kotlin.jvm.internal.l.e(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.addFlags(268435456);
        intent.putExtra("app_package", context.getPackageName());
        ApplicationInfo a2 = j.a.a(context);
        if (a2 != null) {
            intent.putExtra("app_uid", a2.uid);
        }
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        context.startActivity(intent);
    }
}
