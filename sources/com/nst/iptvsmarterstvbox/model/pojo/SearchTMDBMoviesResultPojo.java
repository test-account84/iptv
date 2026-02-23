package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SearchTMDBMoviesResultPojo {

    @SerializedName("adult")
    @Expose
    private Boolean adult;

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("genre_ids")
    @Expose
    private List genreIds = null;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("popularity")
    @Expose
    private Double popularity;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("video")
    @Expose
    private Boolean video;

    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    public Boolean getAdult() {
        return this.adult;
    }

    public String getBackdropPath() {
        return this.backdropPath;
    }

    public List getGenreIds() {
        return this.genreIds;
    }

    public Integer getId() {
        return this.id;
    }

    public String getOriginalLanguage() {
        return this.originalLanguage;
    }

    public String getOriginalTitle() {
        return this.originalTitle;
    }

    public String getOverview() {
        return this.overview;
    }

    public Double getPopularity() {
        return this.popularity;
    }

    public String getPosterPath() {
        return this.posterPath;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getVideo() {
        return this.video;
    }

    public Double getVoteAverage() {
        return this.voteAverage;
    }

    public Integer getVoteCount() {
        return this.voteCount;
    }

    public void setAdult(Boolean bool) {
        this.adult = bool;
    }

    public void setBackdropPath(String str) {
        this.backdropPath = str;
    }

    public void setGenreIds(List list) {
        this.genreIds = list;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setOriginalLanguage(String str) {
        this.originalLanguage = str;
    }

    public void setOriginalTitle(String str) {
        this.originalTitle = str;
    }

    public void setOverview(String str) {
        this.overview = str;
    }

    public void setPopularity(Double d) {
        this.popularity = d;
    }

    public void setPosterPath(String str) {
        this.posterPath = str;
    }

    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(Boolean bool) {
        this.video = bool;
    }

    public void setVoteAverage(Double d) {
        this.voteAverage = d;
    }

    public void setVoteCount(Integer num) {
        this.voteCount = num;
    }
}
