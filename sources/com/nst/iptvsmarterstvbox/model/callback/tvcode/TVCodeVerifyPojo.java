package com.nst.iptvsmarterstvbox.model.callback.tvcode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TVCodeVerifyPojo {

    @SerializedName("anyname")
    @Expose
    private String anyname;

    @SerializedName("billingId")
    @Expose
    private String billingId;

    @SerializedName("billingPass")
    @Expose
    private String billingPass;

    @SerializedName("billingUser")
    @Expose
    private String billingUser;

    @SerializedName("dns")
    @Expose
    private String dns;

    @SerializedName("m3ulink")
    @Expose
    private String m3ulink;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("username")
    @Expose
    private String username;

    public String getAnyName() {
        return this.anyname;
    }

    public String getBillingId() {
        return this.billingId;
    }

    public String getBillingPass() {
        return this.billingPass;
    }

    public String getBillingUser() {
        return this.billingUser;
    }

    public String getDns() {
        return this.dns;
    }

    public String getM3ulink() {
        return this.m3ulink;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAnyname(String str) {
        this.anyname = str;
    }

    public void setBillingId(String str) {
        this.billingId = str;
    }

    public void setBillingPass(String str) {
        this.billingPass = str;
    }

    public void setBillingUser(String str) {
        this.billingUser = str;
    }

    public void setDns(String str) {
        this.dns = str;
    }

    public void setM3ulink(String str) {
        this.m3ulink = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
