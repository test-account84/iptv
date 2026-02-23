package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VodInfoPojo {

    @SerializedName("backdrop_path")
    @Expose
    private List backdropPath = null;

    @SerializedName("cast")
    @Expose
    private String cast;

    @SerializedName("director")
    @Expose
    private String director;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("duration_secs")
    @Expose
    private Integer duration_secs;

    @SerializedName("genre")
    @Expose
    private String genre;

    @SerializedName("imdb_id")
    @Expose
    private String imdbId;

    @SerializedName("movie_image")
    @Expose
    private String movieImage;

    @SerializedName("plot")
    @Expose
    private String plot;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("releasedate")
    @Expose
    private String releasedate;

    @SerializedName("tmdb_id")
    @Expose
    private String tmdb_id;

    @SerializedName("youtube_trailer")
    @Expose
    private String youTubeTrailer;

    public List getBackdropPath() {
        return this.backdropPath;
    }

    public String getCast() {
        return this.cast;
    }

    public String getDirector() {
        return this.director;
    }

    public String getDuration() {
        return this.duration;
    }

    public Integer getDurationSec() {
        return this.duration_secs;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getImdbId() {
        return this.imdbId;
    }

    public String getMovieImage() {
        return this.movieImage;
    }

    public String getPlot() {
        return this.plot;
    }

    public String getRating() {
        return this.rating;
    }

    public String getReleasedate() {
        return this.releasedate;
    }

    public String getTmdb_id() {
        return this.tmdb_id;
    }

    public String getYouTubeTrailer() {
        return this.youTubeTrailer;
    }

    public void setBackdropPath(List list) {
        this.backdropPath = list;
    }

    public void setCast(String str) {
        this.cast = str;
    }

    public void setDirector(String str) {
        this.director = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setDurationSec(Integer num) {
        this.duration_secs = num;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setImdbId(String str) {
        this.imdbId = str;
    }

    public void setMovieImage(String str) {
        this.movieImage = str;
    }

    public void setPlot(String str) {
        this.plot = str;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public void setReleasedate(String str) {
        this.releasedate = str;
    }

    public void setTmdb_id(String str) {
        this.tmdb_id = str;
    }

    public void setYouTubeTrailer(String str) {
        this.youTubeTrailer = str;
    }
}
