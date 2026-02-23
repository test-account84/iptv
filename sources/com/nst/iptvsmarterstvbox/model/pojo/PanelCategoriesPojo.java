package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PanelCategoriesPojo {

    @SerializedName("movie")
    @Expose
    private ArrayList movie = null;

    @SerializedName("live")
    @Expose
    private ArrayList live = null;

    public ArrayList getLive() {
        return this.live;
    }

    public ArrayList getMovie() {
        return this.movie;
    }

    public void setLive(ArrayList arrayList) {
        this.live = arrayList;
    }

    public void setMovie(ArrayList arrayList) {
        this.movie = arrayList;
    }
}
