package com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnnouncementsSBPSingleton {
    public static AnnouncementsSBPSingleton b;
    public List a;

    private AnnouncementsSBPSingleton() {
    }

    public static AnnouncementsSBPSingleton b() {
        if (b == null) {
            b = new AnnouncementsSBPSingleton();
        }
        return b;
    }

    public List a() {
        return this.a;
    }

    public void c(List list) {
        this.a = list;
    }
}
