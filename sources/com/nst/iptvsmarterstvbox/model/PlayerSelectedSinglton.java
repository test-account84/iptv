package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PlayerSelectedSinglton {
    private static PlayerSelectedSinglton myObj;
    private String playerType;

    private PlayerSelectedSinglton() {
    }

    public static PlayerSelectedSinglton getInstance() {
        if (myObj == null) {
            myObj = new PlayerSelectedSinglton();
        }
        return myObj;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public void setPlayerType(String str) {
        this.playerType = str;
    }
}
