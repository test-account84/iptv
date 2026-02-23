package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBCastsPojo {

    @SerializedName("cast_id")
    @Expose
    private Integer castId;

    @SerializedName("character")
    @Expose
    private String character;

    @SerializedName("credit_id")
    @Expose
    private String creditId;

    @SerializedName("gender")
    @Expose
    private Integer gender;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("order")
    @Expose
    private Integer order;

    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    public Integer getCastId() {
        return this.castId;
    }

    public String getCharacter() {
        return this.character;
    }

    public String getCreditId() {
        return this.creditId;
    }

    public Integer getGender() {
        return this.gender;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getProfilePath() {
        return this.profilePath;
    }

    public void setCastId(Integer num) {
        this.castId = num;
    }

    public void setCharacter(String str) {
        this.character = str;
    }

    public void setCreditId(String str) {
        this.creditId = str;
    }

    public void setGender(Integer num) {
        this.gender = num;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrder(Integer num) {
        this.order = num;
    }

    public void setProfilePath(String str) {
        this.profilePath = str;
    }
}
