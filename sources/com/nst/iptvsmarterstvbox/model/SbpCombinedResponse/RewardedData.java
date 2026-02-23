package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RewardedData {

    @SerializedName("custom_recc")
    @Expose
    private String customRecc;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("images")
    @Expose
    private List images;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("pages")
    @Expose
    private String pages;

    @SerializedName("position")
    @Expose
    private String position;

    @SerializedName("redirect_link")
    @Expose
    private String redirectLink;

    @SerializedName("schedule_type")
    @Expose
    private String scheduleType;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("type")
    @Expose
    private String type;

    public String getCustomRecc() {
        return this.customRecc;
    }

    public String getId() {
        return this.id;
    }

    public List getImages() {
        return this.images;
    }

    public String getNumber() {
        return this.number;
    }

    public String getPages() {
        return this.pages;
    }

    public String getPosition() {
        return this.position;
    }

    public String getRedirectLink() {
        return this.redirectLink;
    }

    public String getScheduleType() {
        return this.scheduleType;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setCustomRecc(String str) {
        this.customRecc = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImages(List list) {
        this.images = list;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setPages(String str) {
        this.pages = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setRedirectLink(String str) {
        this.redirectLink = str;
    }

    public void setScheduleType(String str) {
        this.scheduleType = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
