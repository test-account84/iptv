package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetAppStoragePrefences {

    @SerializedName("data")
    @Expose
    private StoragePrefData data;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private String result;

    public StoragePrefData getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResult() {
        return this.result;
    }

    public void setData(StoragePrefData storagePrefData) {
        this.data = storagePrefData;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
