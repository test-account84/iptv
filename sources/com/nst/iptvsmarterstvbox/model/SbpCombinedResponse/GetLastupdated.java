package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetLastupdated {

    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;

    @SerializedName("nextrequest")
    @Expose
    private String nextrequest;

    @SerializedName("result")
    @Expose
    private String result;

    public String getLastupdate() {
        return this.lastupdate;
    }

    public String getNextrequest() {
        return this.nextrequest;
    }

    public String getResult() {
        return this.result;
    }

    public void setLastupdate(String str) {
        this.lastupdate = str;
    }

    public void setNextrequest(String str) {
        this.nextrequest = str;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
