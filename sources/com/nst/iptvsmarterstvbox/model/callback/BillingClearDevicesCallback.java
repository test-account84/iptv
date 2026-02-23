package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nst.iptvsmarterstvbox.model.pojo.BillingClearDevicesPojo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BillingClearDevicesCallback {

    @SerializedName("data")
    @Expose
    private BillingClearDevicesPojo data;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("sc")
    @Expose
    private String sc;

    public BillingClearDevicesPojo getData() {
        return this.data;
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

    public void setData(BillingClearDevicesPojo billingClearDevicesPojo) {
        this.data = billingClearDevicesPojo;
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
