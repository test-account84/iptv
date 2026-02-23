package com.nst.iptvsmarterstvbox.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerLiveFavIdsSingleton {
    private static StalkerLiveFavIdsSingleton myObj;
    private List favIdsList = new ArrayList();

    private StalkerLiveFavIdsSingleton() {
    }

    public static StalkerLiveFavIdsSingleton getInstance() {
        if (myObj == null) {
            myObj = new StalkerLiveFavIdsSingleton();
        }
        return myObj;
    }

    public List getFavIdsList() {
        List list = this.favIdsList;
        return list != null ? list : new ArrayList();
    }

    public void setFavIdsList(List list) {
        this.favIdsList = list;
    }
}
