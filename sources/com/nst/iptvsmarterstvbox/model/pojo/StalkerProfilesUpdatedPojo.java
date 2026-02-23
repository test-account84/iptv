package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerProfilesUpdatedPojo {

    @SerializedName("anec")
    @Expose
    private String anec;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("vclub")
    @Expose
    private String vclub;

    public String getAnec() {
        return this.anec;
    }

    public String getId() {
        return this.id;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVclub() {
        return this.vclub;
    }

    public void setAnec(String str) {
        this.anec = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVclub(String str) {
        this.vclub = str;
    }
}
