package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetGenresPojo {

    @SerializedName("active_sub")
    @Expose
    private Boolean activeSub;

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("censored")
    @Expose
    private Integer censored;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("modified")
    @Expose
    private String modified;

    @SerializedName("number")
    @Expose
    private Integer number;

    @SerializedName("title")
    @Expose
    private String title;

    public Boolean getActiveSub() {
        return this.activeSub;
    }

    public String getAlias() {
        return this.alias;
    }

    public Integer getCensored() {
        return this.censored;
    }

    public String getId() {
        return this.id;
    }

    public String getModified() {
        return this.modified;
    }

    public Integer getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public void setActiveSub(Boolean bool) {
        this.activeSub = bool;
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

    public void setModified(String str) {
        this.modified = str;
    }

    public void setNumber(Integer num) {
        this.number = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
