package com.nst.iptvsmarterstvbox.model;

import L7.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VPNSingleton {
    private static VPNSingleton myObj;
    private a serverListModel;

    private VPNSingleton() {
    }

    public static VPNSingleton getInstance() {
        if (myObj == null) {
            myObj = new VPNSingleton();
        }
        return myObj;
    }

    public a getProfileData() {
        return this.serverListModel;
    }

    public void setProfileData(a aVar) {
        this.serverListModel = aVar;
    }
}
