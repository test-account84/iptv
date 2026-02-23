package com.nst.iptvsmarterstvbox.model.callback.storage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Data {

    @SerializedName("mode")
    @Expose
    private String mode;

    @SerializedName("modename")
    @Expose
    private String modename;

    public String getMode() {
        return this.mode;
    }

    public String getModename() {
        return this.modename;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setModename(String str) {
        this.modename = str;
    }
}
