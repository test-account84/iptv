package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerTokenPojo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerTokenCallback {

    @SerializedName("js")
    @Expose
    private StalkerTokenPojo js;

    public StalkerTokenPojo getJs() {
        return this.js;
    }

    public void setJs(StalkerTokenPojo stalkerTokenPojo) {
        this.js = stalkerTokenPojo;
    }
}
