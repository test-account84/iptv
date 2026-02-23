package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetSeasonsEpisodeCallback {

    @SerializedName("episodes")
    @Expose
    public GetEpisodesPojo episodes;

    @SerializedName("seasons")
    @Expose
    public List seasons = null;

    public GetEpisodesPojo getEpisodes() {
        return this.episodes;
    }

    public List getSeasons() {
        return this.seasons;
    }

    public void setEpisodes(GetEpisodesPojo getEpisodesPojo) {
        this.episodes = getEpisodesPojo;
    }

    public void setSeasons(List list) {
        this.seasons = list;
    }
}
