package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetEpisodesPojo {

    @SerializedName("1")
    @Expose
    public List episodeDetailList = null;

    public List getEpisodeDetailList() {
        return this.episodeDetailList;
    }

    public void setEpisodeDetailList(List list) {
        this.episodeDetailList = list;
    }
}
