package com.nst.iptvsmarterstvbox.model.database;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PasswordDBModel {
    private int id;
    private String userDetail;
    private int userId;
    private String userPassword;

    public PasswordDBModel() {
    }

    public int getId() {
        return this.id;
    }

    public String getUserDetail() {
        return this.userDetail;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setUserDetail(String str) {
        this.userDetail = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserPassword(String str) {
        this.userPassword = str;
    }

    public PasswordDBModel(String str, String str2) {
        this.userDetail = str;
        this.userPassword = str2;
    }
}
