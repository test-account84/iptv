package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FavouriteM3UModel {
    private String categoryID;
    private int id;
    private String name;
    private String timestamp;
    private String url;
    private int userID;

    public FavouriteM3UModel() {
    }

    public String getCategoryID() {
        return this.categoryID;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setCategoryID(String str) {
        this.categoryID = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public FavouriteM3UModel(String str, int i, String str2, String str3) {
        this.url = str;
        this.userID = i;
        this.name = str2;
        this.categoryID = str3;
    }
}
