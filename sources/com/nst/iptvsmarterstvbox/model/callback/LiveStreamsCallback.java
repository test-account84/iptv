package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveStreamsCallback implements Serializable {
    public String activeEpg = "";

    @SerializedName("added")
    @Expose
    private String added;

    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("custom_sid")
    @Expose
    private String customSid;

    @SerializedName("direct_source")
    @Expose
    private String directSource;

    @SerializedName("epg_channel_id")
    @Expose
    private String epgChannelId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("num")
    @Expose
    private Integer num;

    @SerializedName("stream_icon")
    @Expose
    private String streamIcon;

    @SerializedName("stream_id")
    @Expose
    private Integer streamId;

    @SerializedName("stream_type")
    @Expose
    private String streamType;

    @SerializedName("tv_archive")
    @Expose
    private Integer tvArchive;

    @SerializedName("tv_archive_duration")
    @Expose
    private Integer tvArchiveDuration;

    public String getActiveEpg() {
        return this.activeEpg;
    }

    public String getAdded() {
        return this.added;
    }

    public String getCategoryId() {
        return this.categoryId;
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

    public String getName() {
        return this.name;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getOriginalStreamType() {
        return "live";
    }

    public String getStreamIcon() {
        return this.streamIcon;
    }

    public Integer getStreamId() {
        return this.streamId;
    }

    public String getStreamType() {
        return this.streamType;
    }

    public Integer getTvArchive() {
        return this.tvArchive;
    }

    public Integer getTvArchiveDuration() {
        return this.tvArchiveDuration;
    }

    public void setActiveEpg(String str) {
        this.activeEpg = str;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
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

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setStreamIcon(String str) {
        this.streamIcon = str;
    }

    public void setStreamId(Integer num) {
        this.streamId = num;
    }

    public void setStreamType(String str) {
        this.streamType = str;
    }

    public void setTvArchive(Integer num) {
        this.tvArchive = num;
    }

    public void setTvArchiveDuration(Integer num) {
        this.tvArchiveDuration = num;
    }
}
