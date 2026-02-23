package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBPersonProfilePojo {

    @SerializedName("aspect_ratio")
    @Expose
    private Double aspectRatio;

    @SerializedName("file_path")
    @Expose
    private String filePath;

    @SerializedName("height")
    @Expose
    private Integer height;

    @SerializedName("iso_639_1")
    @Expose
    private Object iso6391;

    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    @SerializedName("width")
    @Expose
    private Integer width;

    public Double getAspectRatio() {
        return this.aspectRatio;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Object getIso6391() {
        return this.iso6391;
    }

    public Double getVoteAverage() {
        return this.voteAverage;
    }

    public Integer getVoteCount() {
        return this.voteCount;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setAspectRatio(Double d) {
        this.aspectRatio = d;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setHeight(Integer num) {
        this.height = num;
    }

    public void setIso6391(Object obj) {
        this.iso6391 = obj;
    }

    public void setVoteAverage(Double d) {
        this.voteAverage = d;
    }

    public void setVoteCount(Integer num) {
        this.voteCount = num;
    }

    public void setWidth(Integer num) {
        this.width = num;
    }
}
