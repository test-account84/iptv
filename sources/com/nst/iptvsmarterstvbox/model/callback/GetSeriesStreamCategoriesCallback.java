package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetSeriesStreamCategoriesCallback {

    @SerializedName("category_id")
    @Expose
    public String categoryId;

    @SerializedName("category_name")
    @Expose
    public String categoryName;
    private int id;
    private Integer userID;

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userID;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setUserID(Integer num) {
        this.userID = num;
    }
}
