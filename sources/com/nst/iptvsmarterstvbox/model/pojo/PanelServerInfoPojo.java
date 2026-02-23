package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PanelServerInfoPojo {

    @SerializedName("port")
    @Expose
    private String port;

    @SerializedName("url")
    @Expose
    private String url;

    public String getPort() {
        return this.port;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPort(String str) {
        this.port = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
