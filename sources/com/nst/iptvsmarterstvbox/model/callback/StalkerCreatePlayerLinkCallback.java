package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerCreatePlayerLinkPojo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerCreatePlayerLinkCallback {

    @SerializedName("js")
    @Expose
    private StalkerCreatePlayerLinkPojo js;

    public StalkerCreatePlayerLinkPojo getJs() {
        return this.js;
    }

    public void setJs(StalkerCreatePlayerLinkPojo stalkerCreatePlayerLinkPojo) {
        this.js = stalkerCreatePlayerLinkPojo;
    }
}
