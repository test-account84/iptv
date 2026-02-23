package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBCrewPojo {

    @SerializedName("credit_id")
    @Expose
    private String creditId;

    @SerializedName("department")
    @Expose
    private String department;

    @SerializedName("gender")
    @Expose
    private Integer gender;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("job")
    @Expose
    private String job;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    public String getCreditId() {
        return this.creditId;
    }

    public String getDepartment() {
        return this.department;
    }

    public Integer getGender() {
        return this.gender;
    }

    public Integer getId() {
        return this.id;
    }

    public String getJob() {
        return this.job;
    }

    public String getName() {
        return this.name;
    }

    public String getProfilePath() {
        return this.profilePath;
    }

    public void setCreditId(String str) {
        this.creditId = str;
    }

    public void setDepartment(String str) {
        this.department = str;
    }

    public void setGender(Integer num) {
        this.gender = num;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setJob(String str) {
        this.job = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProfilePath(String str) {
        this.profilePath = str;
    }
}
