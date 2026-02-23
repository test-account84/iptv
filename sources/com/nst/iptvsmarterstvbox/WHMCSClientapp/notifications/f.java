package com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications;

import android.view.View;
import android.view.WindowManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ NotificationUtils a;
    public final /* synthetic */ WindowManager c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ f(NotificationUtils notificationUtils, WindowManager windowManager, String str, String str2, String str3, String str4) {
        this.a = notificationUtils;
        this.c = windowManager;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public final void onClick(View view) {
        NotificationUtils.a(this.a, this.c, this.d, this.e, this.f, this.g, view);
    }
}
