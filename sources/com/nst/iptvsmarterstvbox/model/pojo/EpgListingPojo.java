package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EpgListingPojo {

    @SerializedName("channel_id")
    @Expose
    private String channelId;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("end")
    @Expose
    private String end;

    @SerializedName("epg_id")
    @Expose
    private String epgId;

    @SerializedName("has_archive")
    @Expose
    private Integer hasArchive;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("now_playing")
    @Expose
    private Integer nowPlaying;

    @SerializedName("start")
    @Expose
    private String start;

    @SerializedName("start_timestamp")
    @Expose
    private String startTimestamp;

    @SerializedName("stop_timestamp")
    @Expose
    private String stopTimestamp;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("url")
    @Expose
    private String url;

    public EpgListingPojo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, Integer num2, String str11) {
        this.id = str;
        this.epgId = str2;
        this.title = str3;
        this.lang = str4;
        this.start = str5;
        this.end = str6;
        this.description = str7;
        this.channelId = str8;
        this.startTimestamp = str9;
        this.stopTimestamp = str10;
        this.nowPlaying = num;
        this.hasArchive = num2;
        this.url = str11;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEnd() {
        return this.end;
    }

    public String getEpgId() {
        return this.epgId;
    }

    public Integer getHasArchive() {
        return this.hasArchive;
    }

    public String getId() {
        return this.id;
    }

    public String getLang() {
        return this.lang;
    }

    public Integer getNowPlaying() {
        return this.nowPlaying;
    }

    public String getStart() {
        return this.start;
    }

    public String getStartTimestamp() {
        return this.startTimestamp;
    }

    public String getStopTimestamp() {
        return this.stopTimestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public void setEpgId(String str) {
        this.epgId = str;
    }

    public void setHasArchive(Integer num) {
        this.hasArchive = num;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setNowPlaying(Integer num) {
        this.nowPlaying = num;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public void setStartTimestamp(String str) {
        this.startTimestamp = str;
    }

    public void setStopTimestamp(String str) {
        this.stopTimestamp = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
