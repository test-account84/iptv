package com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdvertisementListSingleton {
    public static final AdvertisementListSingleton b = new AdvertisementListSingleton();
    public List a = new ArrayList();

    public static AdvertisementListSingleton b() {
        return b;
    }

    public List a() {
        return this.a;
    }
}
