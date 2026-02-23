package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PanelAvailableChannelsPojo {

    @SerializedName("added")
    @Expose
    private String added;

    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    @SerializedName("container_extension")
    @Expose
    private Object containerExtension;

    @SerializedName("custom_sid")
    @Expose
    private String customSid;

    @SerializedName("direct_source")
    @Expose
    private String directSource;

    @SerializedName("epg_channel_id")
    @Expose
    private String epgChannelId;

    @SerializedName("live")
    @Expose
    private String live;
    private long movieDuration;
    private long movieElapsedTime;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("num")
    @Expose
    private Integer num;
    private String ratingFromFive;
    private String ratingFromTen;
    private String recentlyWatchedStatus;

    @SerializedName("series_no")
    @Expose
    private Object seriesNo;

    @SerializedName("stream_icon")
    @Expose
    private String streamIcon;

    @SerializedName("stream_id")
    @Expose
    private String streamId;

    @SerializedName("stream_type")
    @Expose
    private String streamType;

    @SerializedName("tv_archive")
    @Expose
    private Integer tvArchive;

    @SerializedName("tv_archive_duration")
    @Expose
    private String tvArchiveDuration;

    @SerializedName("type_name")
    @Expose
    private String typeName;
    private String url;
    private int userIdReferred;

    public String getAdded() {
        return this.added;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Object getContainerExtension() {
        return this.containerExtension;
    }

    public String getCustomSid() {
        return this.customSid;
    }

    public String getDirectSource() {
        return this.directSource;
    }

    public String getEpgChannelId() {
        return this.epgChannelId;
    }

    public String getIsRecentlyWatched() {
        return this.recentlyWatchedStatus;
    }

    public String getLive() {
        return this.live;
    }

    public long getMovieDuration() {
        return this.movieDuration;
    }

    public long getMovieElapsedTime() {
        return this.movieElapsedTime;
    }

    public String getName() {
        return this.name;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getRatingFromFive() {
        return this.ratingFromFive;
    }

    public String getRatingFromTen() {
        return this.ratingFromTen;
    }

    public Object getSeriesNo() {
        return this.seriesNo;
    }

    public String getStreamIcon() {
        return this.streamIcon;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public String getStreamType() {
        return this.streamType;
    }

    public Integer getTvArchive() {
        return this.tvArchive;
    }

    public String getTvArchiveDuration() {
        return this.tvArchiveDuration;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUserIdReferred() {
        return this.userIdReferred;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setContainerExtension(Object obj) {
        this.containerExtension = obj;
    }

    public void setCustomSid(String str) {
        this.customSid = str;
    }

    public void setDirectSource(String str) {
        this.directSource = str;
    }

    public void setEpgChannelId(String str) {
        this.epgChannelId = str;
    }

    public void setIsRecentlyWatched(String str) {
        this.recentlyWatchedStatus = str;
    }

    public void setLive(String str) {
        this.live = str;
    }

    public void setMovieDuration(long j) {
        this.movieDuration = j;
    }

    public void setMovieElapsedTime(long j) {
        this.movieElapsedTime = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setRatingFromFive(String str) {
        this.ratingFromFive = str;
    }

    public void setRatingFromTen(String str) {
        this.ratingFromTen = str;
    }

    public void setSeriesNo(Object obj) {
        this.seriesNo = obj;
    }

    public void setStreamIcon(String str) {
        this.streamIcon = str;
    }

    public void setStreamId(String str) {
        this.streamId = str;
    }

    public void setStreamType(String str) {
        this.streamType = str;
    }

    public void setTvArchive(Integer num) {
        this.tvArchive = num;
    }

    public void setTvArchiveDuration(String str) {
        this.tvArchiveDuration = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserIdReferred(int i) {
        this.userIdReferred = i;
    }
}
