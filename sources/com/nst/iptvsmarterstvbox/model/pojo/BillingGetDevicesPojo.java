package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BillingGetDevicesPojo {

    @SerializedName("devices")
    @Expose
    private List devices = null;

    public List getDevices() {
        return this.devices;
    }

    public void setDevices(List list) {
        this.devices = list;
    }
}
