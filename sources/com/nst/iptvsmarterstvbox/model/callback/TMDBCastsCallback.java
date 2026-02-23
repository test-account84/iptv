package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBCastsCallback {

    @SerializedName("cast")
    @Expose
    private List cast = null;

    @SerializedName("crew")
    @Expose
    private List crew = null;

    @SerializedName("id")
    @Expose
    private Integer id;

    public List getCast() {
        return this.cast;
    }

    public List getCrew() {
        return this.crew;
    }

    public Integer getId() {
        return this.id;
    }

    public void setCast(List list) {
        this.cast = list;
    }

    public void setCrew(List list) {
        this.crew = list;
    }

    public void setId(Integer num) {
        this.id = num;
    }
}
