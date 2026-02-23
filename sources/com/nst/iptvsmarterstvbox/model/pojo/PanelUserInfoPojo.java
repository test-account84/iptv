package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PanelUserInfoPojo {

    @SerializedName("active_cons")
    @Expose
    private String activeCons;

    @SerializedName("allowed_output_formats")
    @Expose
    private List allowedOutputFormats = null;

    @SerializedName("auth")
    @Expose
    private Integer auth;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("exp_date")
    @Expose
    private Object expDate;

    @SerializedName("is_trial")
    @Expose
    private String isTrial;

    @SerializedName("max_connections")
    @Expose
    private String maxConnections;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("username")
    @Expose
    private String username;

    public String getActiveCons() {
        return this.activeCons;
    }

    public List getAllowedOutputFormats() {
        return this.allowedOutputFormats;
    }

    public Integer getAuth() {
        return this.auth;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public Object getExpDate() {
        return this.expDate;
    }

    public String getIsTrial() {
        return this.isTrial;
    }

    public String getMaxConnections() {
        return this.maxConnections;
    }

    public String getPassword() {
        return this.password;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUsername() {
        return this.username;
    }

    public void setActiveCons(String str) {
        this.activeCons = str;
    }

    public void setAllowedOutputFormats(List list) {
        this.allowedOutputFormats = list;
    }

    public void setAuth(Integer num) {
        this.auth = num;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setExpDate(Object obj) {
        this.expDate = obj;
    }

    public void setIsTrial(String str) {
        this.isTrial = str;
    }

    public void setMaxConnections(String str) {
        this.maxConnections = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
