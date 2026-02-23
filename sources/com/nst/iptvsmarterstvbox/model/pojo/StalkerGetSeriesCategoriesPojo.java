package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetSeriesCategoriesPojo {

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("censored")
    @Expose
    private Integer censored;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    public String getAlias() {
        return this.alias;
    }

    public Integer getCensored() {
        return this.censored;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setCensored(Integer num) {
        this.censored = num;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
