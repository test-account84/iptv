package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetOvpnzip {

    @SerializedName("access")
    @Expose
    private Map access;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("sc")
    @Expose
    private String sc;

    @SerializedName("vpnstatus")
    @Expose
    private String vpnstatus;

    public Map getAccess() {
        return this.access;
    }

    public String getLink() {
        return this.link;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResult() {
        return this.result;
    }

    public String getSc() {
        return this.sc;
    }

    public String getVpnstatus() {
        return this.vpnstatus;
    }

    public void setAccess(Map map) {
        this.access = map;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setSc(String str) {
        this.sc = str;
    }

    public void setVpnstatus(String str) {
        this.vpnstatus = str;
    }
}
