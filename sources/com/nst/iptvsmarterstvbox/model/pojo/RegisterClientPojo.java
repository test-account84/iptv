package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RegisterClientPojo {

    @SerializedName("devicename")
    @Expose
    private String devicename;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("mac")
    @Expose
    private String mac;

    public String getDevicename() {
        return this.devicename;
    }

    public Integer getId() {
        return this.id;
    }

    public String getMac() {
        return this.mac;
    }

    public void setDevicename(String str) {
        this.devicename = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setMac(String str) {
        this.mac = str;
    }
}
