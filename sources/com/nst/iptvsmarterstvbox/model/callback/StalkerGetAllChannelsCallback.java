package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetAllChannelsPojo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetAllChannelsCallback {

    @SerializedName("js")
    @Expose
    private StalkerGetAllChannelsPojo js;

    public StalkerGetAllChannelsPojo getJs() {
        return this.js;
    }

    public void setJs(StalkerGetAllChannelsPojo stalkerGetAllChannelsPojo) {
        this.js = stalkerGetAllChannelsPojo;
    }
}
