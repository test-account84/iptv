package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveStreamCategoriesCallback {

    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    private Integer userID;

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getParentId() {
        return this.parentId;
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

    public void setParentId(Integer num) {
        this.parentId = num;
    }

    public void setUserID(Integer num) {
        this.userID = num;
    }
}
