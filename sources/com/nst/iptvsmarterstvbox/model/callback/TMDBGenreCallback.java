package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBGenreCallback {

    @SerializedName("genres")
    @Expose
    private List genres = null;

    @SerializedName("runtime")
    @Expose
    private Object runtime;

    public List getGenres() {
        return this.genres;
    }

    public Object getRuntime() {
        return this.runtime;
    }

    public void setGenres(List list) {
        this.genres = list;
    }

    public void setRuntime(Object obj) {
        this.runtime = obj;
    }
}
