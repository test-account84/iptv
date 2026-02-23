package com.nst.iptvsmarterstvbox.model.callback.tvcode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MobileCodeActiveCallBack {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("sc")
    @Expose
    private String sc;

    public String getMessage() {
        return this.message;
    }

    public String getResult() {
        return this.result;
    }

    public String getSc() {
        return this.sc;
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
}
