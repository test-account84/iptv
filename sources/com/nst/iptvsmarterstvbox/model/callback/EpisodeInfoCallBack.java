package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EpisodeInfoCallBack {

    @SerializedName("movie_image")
    @Expose
    private String movieImage;

    public String getMovieImage() {
        return this.movieImage;
    }

    public void setMovieImage(String str) {
        this.movieImage = str;
    }
}
