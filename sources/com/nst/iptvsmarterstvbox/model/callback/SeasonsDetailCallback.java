package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SeasonsDetailCallback {

    @SerializedName("air_date")
    @Expose
    public String airDate;

    @SerializedName("cover")
    @Expose
    public String cover;

    @SerializedName("cover_big")
    @Expose
    public String coverBig;

    @SerializedName("episode_count")
    @Expose
    public Integer episodeCount;

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("season_number")
    @Expose
    public Integer seasonNumber;

    public String getAirDate() {
        return this.airDate;
    }

    public String getCover() {
        return this.cover;
    }

    public String getCoverBig() {
        return this.coverBig;
    }

    public Integer getEpisodeCount() {
        return this.episodeCount;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOverview() {
        return this.overview;
    }

    public Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    public void setAirDate(String str) {
        this.airDate = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setCoverBig(String str) {
        this.coverBig = str;
    }

    public void setEpisodeCount(Integer num) {
        this.episodeCount = num;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOverview(String str) {
        this.overview = str;
    }

    public void setSeasonNumber(Integer num) {
        this.seasonNumber = num;
    }
}
