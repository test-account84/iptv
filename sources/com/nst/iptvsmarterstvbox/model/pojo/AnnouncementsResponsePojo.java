package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnnouncementsResponsePojo {

    @SerializedName("CreateDate")
    @Expose
    private String createDate;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("Title")
    @Expose
    private String title;

    public String getCreateDate() {
        return this.createDate;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
