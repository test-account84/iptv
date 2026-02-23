package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Comparator;
import m7.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetEpisdoeDetailsCallback implements Serializable {
    public static Comparator episodeComparator = new 1();

    @SerializedName("added")
    @Expose
    public String added;
    private String categoryId;
    private String cmd;

    @SerializedName("container_extension")
    @Expose
    public String containerExtension;

    @SerializedName("custom_sid")
    @Expose
    public String customSid;
    private String desc;

    @SerializedName("direct_source")
    @Expose
    public String directSource;
    private String duration;
    private String duration_sec;
    private String elapsed_time;
    public Integer episodeNumber;
    private int episode_watched_percentage;

    @SerializedName("id")
    @Expose
    public String id;
    public String image;

    @SerializedName("info")
    @Expose
    private EpisodeInfoCallBack infoCallBack;
    private String links;
    private String movieImage;
    private String rating;
    private String recentlyWatchedStatus;

    @SerializedName("season")
    @Expose
    public Integer seasonNumber;
    private String seriesCover = "";
    private String seriesId;
    private String series_name;
    private String series_num;
    private String setMainSeriesImg;

    @SerializedName("title")
    @Expose
    public String title;
    private String tmdb_id;

    public class 1 implements Comparator {
        public int compare(GetEpisdoeDetailsCallback getEpisdoeDetailsCallback, GetEpisdoeDetailsCallback getEpisdoeDetailsCallback2) {
            if (a.T == a.U) {
                return getEpisdoeDetailsCallback.getTitle().toUpperCase().compareTo(getEpisdoeDetailsCallback2.getTitle().toUpperCase());
            }
            if (a.T == a.V) {
                return getEpisdoeDetailsCallback2.getTitle().toUpperCase().compareTo(getEpisdoeDetailsCallback.getTitle().toUpperCase());
            }
            if (a.T != a.W) {
                return 0;
            }
            return getEpisdoeDetailsCallback2.getAdded().toUpperCase().compareTo(getEpisdoeDetailsCallback.getAdded().toUpperCase());
        }
    }

    public static Comparator getEpisodeComparator() {
        return episodeComparator;
    }

    private EpisodeInfoCallBack getInfoCallBack() {
        return this.infoCallBack;
    }

    public static void setEpisodeComparator(Comparator comparator) {
        episodeComparator = comparator;
    }

    private void setInfoCallBack(EpisodeInfoCallBack episodeInfoCallBack) {
        this.infoCallBack = episodeInfoCallBack;
    }

    public String getAdded() {
        return this.added;
    }

    public String getCMD() {
        return this.cmd;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getContainerExtension() {
        return this.containerExtension;
    }

    public String getCustomSid() {
        return this.customSid;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDirectSource() {
        return this.directSource;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getDurationSec() {
        return this.duration_sec;
    }

    public String getDuration_sec() {
        return this.duration_sec;
    }

    public String getElapsed_time() {
        return this.elapsed_time;
    }

    public Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    public int getEpisode_watched_percentage() {
        return this.episode_watched_percentage;
    }

    public String getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getIsRecentlyWatched() {
        return this.recentlyWatchedStatus;
    }

    public String getLinks() {
        return this.links;
    }

    public String getMainSeriesImg() {
        return this.setMainSeriesImg;
    }

    public String getMovieImage() {
        return this.movieImage;
    }

    public String getRating() {
        return this.rating;
    }

    public String getRecentlyWatchedStatus() {
        return this.recentlyWatchedStatus;
    }

    public Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    public String getSeriesCover() {
        return this.seriesCover;
    }

    public String getSeriesId() {
        return this.seriesId;
    }

    public String getSeriesName() {
        return this.series_name;
    }

    public String getSeriesNum() {
        return this.series_num;
    }

    public String getSeries_name() {
        return this.series_name;
    }

    public String getSeries_num() {
        return this.series_num;
    }

    public String getSetMainSeriesImg() {
        return this.setMainSeriesImg;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTmdb_id() {
        return this.tmdb_id;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCMD(String str) {
        this.cmd = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setContainerExtension(String str) {
        this.containerExtension = str;
    }

    public void setCustomSid(String str) {
        this.customSid = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDirectSource(String str) {
        this.directSource = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setDurationSec(String str) {
        this.duration_sec = str;
    }

    public void setDuration_sec(String str) {
        this.duration_sec = str;
    }

    public void setElapsed_time(String str) {
        this.elapsed_time = str;
    }

    public void setEpisodeNum(Integer num) {
        this.episodeNumber = num;
    }

    public void setEpisodeNumber(Integer num) {
        this.episodeNumber = num;
    }

    public void setEpisode_watched_percentage(int i) {
        this.episode_watched_percentage = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setIsRecentlyWatched(String str) {
        this.recentlyWatchedStatus = str;
    }

    public void setLinks(String str) {
        this.links = str;
    }

    public void setMainSeriesImg(String str) {
        this.setMainSeriesImg = str;
    }

    public void setMovieImage(String str) {
        this.movieImage = str;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public void setRecentlyWatchedStatus(String str) {
        this.recentlyWatchedStatus = str;
    }

    public void setSeasonNumber(Integer num) {
        this.seasonNumber = num;
    }

    public void setSeriesCover(String str) {
        this.seriesCover = str;
    }

    public void setSeriesId(String str) {
        this.seriesId = str;
    }

    public void setSeriesName(String str) {
        this.series_name = str;
    }

    public void setSeriesNum(String str) {
        this.series_num = str;
    }

    public void setSeries_name(String str) {
        this.series_name = str;
    }

    public void setSeries_num(String str) {
        this.series_num = str;
    }

    public void setSetMainSeriesImg(String str) {
        this.setMainSeriesImg = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTmdb_id(String str) {
        this.tmdb_id = str;
    }
}
