package com.nst.iptvsmarterstvbox.model.database;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DatabaseUpdatedStatusDBModel {
    private String dbCategory;
    private String dbCategoryID;
    private String dbLastUpdatedDate;
    private String dbUpadatedStatusState;
    private int idAuto;

    public DatabaseUpdatedStatusDBModel() {
    }

    public String getDbCategory() {
        return this.dbCategory;
    }

    public String getDbLastUpdatedDate() {
        return this.dbLastUpdatedDate;
    }

    public String getDbUpadatedStatusState() {
        return this.dbUpadatedStatusState;
    }

    public String getGetDbCategoryID() {
        return this.dbCategoryID;
    }

    public int getIdAuto() {
        return this.idAuto;
    }

    public void setDbCategory(String str) {
        this.dbCategory = str;
    }

    public void setDbCategoryID(String str) {
        this.dbCategoryID = str;
    }

    public void setDbLastUpdatedDate(String str) {
        this.dbLastUpdatedDate = str;
    }

    public void setDbUpadatedStatusState(String str) {
        this.dbUpadatedStatusState = str;
    }

    public void setIdAuto(int i) {
        this.idAuto = i;
    }

    public DatabaseUpdatedStatusDBModel(String str, String str2, String str3, String str4) {
        this.dbUpadatedStatusState = str;
        this.dbLastUpdatedDate = str2;
        this.dbCategory = str3;
        this.dbCategoryID = str4;
    }
}
