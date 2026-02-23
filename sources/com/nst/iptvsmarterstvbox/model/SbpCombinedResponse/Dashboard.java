package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Dashboard {

    @SerializedName("add_status")
    @Expose
    private String addStatus;

    @SerializedName("data")
    @Expose
    private List data;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("timeinterval")
    @Expose
    private String timeinterval;

    @SerializedName("totalrecords")
    @Expose
    private Integer totalrecords;

    public String getAddStatus() {
        return this.addStatus;
    }

    public List getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTimeinterval() {
        return this.timeinterval;
    }

    public Integer getTotalrecords() {
        return this.totalrecords;
    }

    public void setAddStatus(String str) {
        this.addStatus = str;
    }

    public void setData(List list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setTimeinterval(String str) {
        this.timeinterval = str;
    }

    public void setTotalrecords(Integer num) {
        this.totalrecords = num;
    }
}
