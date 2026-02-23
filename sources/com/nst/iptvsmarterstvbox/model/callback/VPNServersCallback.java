package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VPNServersCallback {

    @SerializedName("sc")
    @Expose
    private String sc;

    @SerializedName("servers")
    @Expose
    private List servers = null;

    @SerializedName("status")
    @Expose
    private Boolean status;

    public String getSc() {
        return this.sc;
    }

    public List getServers() {
        return this.servers;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setSc(String str) {
        this.sc = str;
    }

    public void setServers(List list) {
        this.servers = list;
    }

    public void setStatus(Boolean bool) {
        this.status = bool;
    }
}
