package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VPNServerPojo {

    @SerializedName("credentials")
    @Expose
    private VPNCredentialsPojo credentials;

    @SerializedName("flag")
    @Expose
    private String flag;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("ovpnfile")
    @Expose
    private String ovpnfile;

    @SerializedName("servername")
    @Expose
    private String servername;

    @SerializedName("servieid")
    @Expose
    private String servieid;

    public VPNCredentialsPojo getCredentials() {
        return this.credentials;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getId() {
        return this.id;
    }

    public String getOvpnfile() {
        return this.ovpnfile;
    }

    public String getServername() {
        return this.servername;
    }

    public String getServieid() {
        return this.servieid;
    }

    public void setCredentials(VPNCredentialsPojo vPNCredentialsPojo) {
        this.credentials = vPNCredentialsPojo;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOvpnfile(String str) {
        this.ovpnfile = str;
    }

    public void setServername(String str) {
        this.servername = str;
    }

    public void setServieid(String str) {
        this.servieid = str;
    }
}
