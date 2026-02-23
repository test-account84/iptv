package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetSeriesCategoriesCallback {

    @SerializedName("js")
    @Expose
    private List js = null;

    public List getJs() {
        return this.js;
    }

    public void setJs(List list) {
        this.js = list;
    }
}
