package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BillingLoginClientPojo {

    @SerializedName("devices")
    @Expose
    private List devices = null;

    @SerializedName("id")
    @Expose
    private Integer id;

    public List getDevices() {
        return this.devices;
    }

    public Integer getId() {
        return this.id;
    }

    public void setDevices(List list) {
        this.devices = list;
    }

    public void setId(Integer num) {
        this.id = num;
    }
}
