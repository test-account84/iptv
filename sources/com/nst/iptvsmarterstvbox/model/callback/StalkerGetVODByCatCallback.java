package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetVODByCatPojo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetVODByCatCallback {

    @SerializedName("js")
    @Expose
    private StalkerGetVODByCatPojo js;

    public StalkerGetVODByCatPojo getJs() {
        return this.js;
    }

    public void setJs(StalkerGetVODByCatPojo stalkerGetVODByCatPojo) {
        this.js = stalkerGetVODByCatPojo;
    }
}
