package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnnouncementsData {

    @SerializedName("created_on")
    @Expose
    private String createdOn;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("seen")
    @Expose
    private Integer seen;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("updated_on")
    @Expose
    private String updatedOn;

    @SerializedName("whmcs_serviceid")
    @Expose
    private String whmcsServiceid;

    @SerializedName("whmcs_userid")
    @Expose
    private String whmcsUserid;

    public String getCreatedOn() {
        return this.createdOn;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getSeen() {
        return this.seen;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUpdatedOn() {
        return this.updatedOn;
    }

    public String getWhmcsServiceid() {
        return this.whmcsServiceid;
    }

    public String getWhmcsUserid() {
        return this.whmcsUserid;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSeen(Integer num) {
        this.seen = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUpdatedOn(String str) {
        this.updatedOn = str;
    }

    public void setWhmcsServiceid(String str) {
        this.whmcsServiceid = str;
    }

    public void setWhmcsUserid(String str) {
        this.whmcsUserid = str;
    }
}
