package com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications;

import android.view.View;
import android.view.WindowManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {
    public final /* synthetic */ NotificationUtils a;
    public final /* synthetic */ WindowManager c;

    public /* synthetic */ e(NotificationUtils notificationUtils, WindowManager windowManager) {
        this.a = notificationUtils;
        this.c = windowManager;
    }

    public final void onClick(View view) {
        NotificationUtils.b(this.a, this.c, view);
    }
}
