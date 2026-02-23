package com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ NotificationUtils a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ d(NotificationUtils notificationUtils, String str, String str2, String str3, String str4) {
        this.a = notificationUtils;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public final void run() {
        NotificationUtils.c(this.a, this.c, this.d, this.e, this.f);
    }
}
