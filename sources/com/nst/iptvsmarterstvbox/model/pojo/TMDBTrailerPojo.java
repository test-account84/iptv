package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBTrailerPojo {

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("type")
    @Expose
    private String type;

    public String getKey() {
        return this.key;
    }

    public String getType() {
        return this.type;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
