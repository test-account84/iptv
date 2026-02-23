package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SearchTMDBTVShowsResultPojo {

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @SerializedName("original_name")
    @Expose
    private String originalName;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("popularity")
    @Expose
    private Double popularity;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    @SerializedName("genre_ids")
    @Expose
    private List genreIds = null;

    @SerializedName("origin_country")
    @Expose
    private List originCountry = null;

    public String getBackdropPath() {
        return this.backdropPath;
    }

    public String getFirstAirDate() {
        return this.firstAirDate;
    }

    public List getGenreIds() {
        return this.genreIds;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List getOriginCountry() {
        return this.originCountry;
    }

    public String getOriginalLanguage() {
        return this.originalLanguage;
    }

    public String getOriginalName() {
        return this.originalName;
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

    public Double getVoteAverage() {
        return this.voteAverage;
    }

    public Integer getVoteCount() {
        return this.voteCount;
    }

    public void setBackdropPath(String str) {
        this.backdropPath = str;
    }

    public void setFirstAirDate(String str) {
        this.firstAirDate = str;
    }

    public void setGenreIds(List list) {
        this.genreIds = list;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOriginCountry(List list) {
        this.originCountry = list;
    }

    public void setOriginalLanguage(String str) {
        this.originalLanguage = str;
    }

    public void setOriginalName(String str) {
        this.originalName = str;
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

    public void setVoteAverage(Double d) {
        this.voteAverage = d;
    }

    public void setVoteCount(Integer num) {
        this.voteCount = num;
    }
}
