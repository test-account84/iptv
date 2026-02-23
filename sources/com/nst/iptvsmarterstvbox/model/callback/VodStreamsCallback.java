package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VodStreamsCallback {

    @SerializedName("added")
    @Expose
    private String added;

    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("container_extension")
    @Expose
    private String containerExtension;

    @SerializedName("custom_sid")
    @Expose
    private String customSid;

    @SerializedName("direct_source")
    @Expose
    private String directSource;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("num")
    @Expose
    private Integer num;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("rating_5based")
    @Expose
    private Double rating5based;

    @SerializedName("series_no")
    @Expose
    private Object seriesNo;

    @SerializedName("stream_icon")
    @Expose
    private String streamIcon;

    @SerializedName("stream_id")
    @Expose
    private Integer streamId;

    @SerializedName("stream_type")
    @Expose
    private String streamType;

    public String getAdded() {
        return this.added;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getContainerExtension() {
        return this.containerExtension;
    }

    public String getCustomSid() {
        return this.customSid;
    }

    public String getDirectSource() {
        return this.directSource;
    }

    public String getName() {
        return this.name;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getOriginalStreamType() {
        return "movie";
    }

    public String getRating() {
        return this.rating;
    }

    public Double getRating5based() {
        return this.rating5based;
    }

    public Object getSeriesNo() {
        return this.seriesNo;
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

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setContainerExtension(String str) {
        this.containerExtension = str;
    }

    public void setCustomSid(String str) {
        this.customSid = str;
    }

    public void setDirectSource(String str) {
        this.directSource = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public void setRating5based(Double d) {
        this.rating5based = d;
    }

    public void setSeriesNo(Object obj) {
        this.seriesNo = obj;
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
}
