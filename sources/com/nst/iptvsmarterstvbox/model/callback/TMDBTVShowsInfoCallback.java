package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBTVShowsInfoCallback {

    @SerializedName("created_by")
    @Expose
    private List createdBy = null;

    @SerializedName("genres")
    @Expose
    private List genres = null;

    public List getCreatedBy() {
        return this.createdBy;
    }

    public List getGenres() {
        return this.genres;
    }

    public void setCreatedBy(List list) {
        this.createdBy = list;
    }

    public void setGenres(List list) {
        this.genres = list;
    }
}
