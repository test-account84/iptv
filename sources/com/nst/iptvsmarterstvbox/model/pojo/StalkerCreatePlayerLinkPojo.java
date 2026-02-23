package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerCreatePlayerLinkPojo {

    @SerializedName("cmd")
    @Expose
    private String cmd;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("load")
    @Expose
    private String load;

    @SerializedName("subtitles")
    @Expose
    private List subtitles = null;

    public String getCmd() {
        return this.cmd;
    }

    public String getError() {
        return this.error;
    }

    public String getId() {
        return this.id;
    }

    public String getLoad() {
        return this.load;
    }

    public List getSubtitles() {
        return this.subtitles;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLoad(String str) {
        this.load = str;
    }

    public void setSubtitles(List list) {
        this.subtitles = list;
    }
}
