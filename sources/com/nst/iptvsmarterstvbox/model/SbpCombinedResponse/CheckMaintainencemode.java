package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CheckMaintainencemode {

    @SerializedName("footercontent")
    @Expose
    private String footercontent;

    @SerializedName("maintenancemode")
    @Expose
    private String maintenancemode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private String result;

    public String getFootercontent() {
        return this.footercontent;
    }

    public String getMaintenancemode() {
        return this.maintenancemode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResult() {
        return this.result;
    }

    public void setFootercontent(String str) {
        this.footercontent = str;
    }

    public void setMaintenancemode(String str) {
        this.maintenancemode = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
