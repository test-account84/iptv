package com.nst.iptvsmarterstvbox.model.database;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PasswordStatusDBModel {
    private int idPaswordStaus;
    private String passwordStatus;
    private String passwordStatusCategoryId;
    private String passwordStatusUserDetail;
    private int userID;

    public PasswordStatusDBModel() {
    }

    public int getIdPaswordStaus() {
        return this.idPaswordStaus;
    }

    public String getPasswordStatus() {
        return this.passwordStatus;
    }

    public String getPasswordStatusCategoryId() {
        return this.passwordStatusCategoryId;
    }

    public String getPasswordStatusUserDetail() {
        return this.passwordStatusUserDetail;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setIdPaswordStaus(int i) {
        this.idPaswordStaus = i;
    }

    public void setPasswordStatus(String str) {
        this.passwordStatus = str;
    }

    public void setPasswordStatusCategoryId(String str) {
        this.passwordStatusCategoryId = str;
    }

    public void setPasswordStatusUserDetail(String str) {
        this.passwordStatusUserDetail = str;
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public PasswordStatusDBModel(String str, String str2, String str3) {
        this.passwordStatusCategoryId = str;
        this.passwordStatusUserDetail = str2;
        this.passwordStatus = str3;
    }
}
