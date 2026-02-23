package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetAllcombinedashrequest {

    @SerializedName("dashboard")
    @Expose
    private Dashboard dashboard;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("rewarded")
    @Expose
    private Rewarded rewarded;

    public Dashboard getDashboard() {
        return this.dashboard;
    }

    public String getResult() {
        return this.result;
    }

    public Rewarded getRewarded() {
        return this.rewarded;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setRewarded(Rewarded rewarded) {
        this.rewarded = rewarded;
    }
}
