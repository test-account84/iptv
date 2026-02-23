package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetSeriesStreamCallback {

    @SerializedName("backdrop_path")
    @Expose
    public transient ArrayList backdropPath = null;

    @SerializedName("cast")
    @Expose
    public String cast;

    @SerializedName("category_id")
    @Expose
    public String categoryId;

    @SerializedName("cover")
    @Expose
    public String cover;

    @SerializedName("director")
    @Expose
    public String director;

    @SerializedName("genre")
    @Expose
    public String genre;

    @SerializedName("last_modified")
    @Expose
    public String lastModified;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("num")
    @Expose
    public Integer num;

    @SerializedName("plot")
    @Expose
    public String plot;

    @SerializedName("rating")
    @Expose
    public String rating;

    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;

    @SerializedName("series_id")
    @Expose
    public Integer seriesId;

    @SerializedName("stream_type")
    @Expose
    public Object streamType;

    @SerializedName("youtube_trailer")
    @Expose
    public String youtubTrailer;

    public ArrayList getBackdropPath() {
        return this.backdropPath;
    }

    public String getCast() {
        return this.cast;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDirector() {
        return this.director;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public String getName() {
        return this.name;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getPlot() {
        return this.plot;
    }

    public String getRating() {
        return this.rating;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public Integer getSeriesId() {
        return this.seriesId;
    }

    public Object getStreamType() {
        return this.streamType;
    }

    public String getYoutubTrailer() {
        return this.youtubTrailer;
    }

    public void setBackdropPath(ArrayList arrayList) {
        this.backdropPath = arrayList;
    }

    public void setCast(String str) {
        this.cast = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setDirector(String str) {
        this.director = str;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setLastModified(String str) {
        this.lastModified = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPlot(String str) {
        this.plot = str;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public void setSeriesId(Integer num) {
        this.seriesId = num;
    }

    public void setStreamType(Object obj) {
        this.streamType = obj;
    }

    public void setYoutubTrailer(String str) {
        this.youtubTrailer = str;
    }
}
