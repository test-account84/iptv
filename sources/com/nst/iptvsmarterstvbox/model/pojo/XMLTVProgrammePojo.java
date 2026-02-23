package com.nst.iptvsmarterstvbox.model.pojo;

import java.io.Serializable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "programme", strict = false)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class XMLTVProgrammePojo implements Serializable {
    private static XMLTVProgrammePojo instance;

    @Text(required = false)
    @Path("category")
    private String category;

    @Attribute(name = "channel", required = false)
    private String channel;

    @Text(required = false)
    @Path("country")
    private String country;

    @Text(required = false)
    @Path("date")
    private String date;

    @Text(required = false)
    @Path("desc")
    private String desc;
    private String endTimeStamp;

    @Text(required = false)
    @Path("episode-num")
    private String episode_num;

    @Text(required = false)
    @Path("icon")
    private String icon;

    @Attribute(name = "start", required = false)
    private String start;
    private String startTimeStamp;

    @Attribute(name = "stop", required = false)
    private String stop;

    @Text(required = false)
    @Path("sub-title")
    private String sub_title;

    @Text(required = false)
    @Path("title")
    private String title;
    private String liveChannelName = "";
    private String liveChannelLogo = "";
    private String liveStreamID = "";
    private String liveNum = "";
    private String liveCategoryId = "";
    private String url = "";
    private String sourceRef = "";

    public static XMLTVProgrammePojo getInstance() {
        if (instance == null) {
            instance = new XMLTVProgrammePojo();
        }
        return instance;
    }

    public String getCategory() {
        return this.category;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDate() {
        return this.date;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public String getEpisodeNum() {
        return this.episode_num;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLiveCategoryId() {
        return this.liveCategoryId;
    }

    public String getLiveLogo() {
        return this.liveChannelLogo;
    }

    public String getLiveName() {
        return this.liveChannelName;
    }

    public String getLiveNum() {
        return this.liveNum;
    }

    public String getLiveStreamID() {
        return this.liveStreamID;
    }

    public String getSourceRef() {
        return this.sourceRef;
    }

    public String getStart() {
        return this.start;
    }

    public String getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public String getStop() {
        return this.stop;
    }

    public String getSub_title() {
        return this.sub_title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setEndTimeStamp(String str) {
        this.endTimeStamp = str;
    }

    public void setEpisodeNum(String str) {
        this.episode_num = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setLiveCategoryId(String str) {
        this.liveCategoryId = str;
    }

    public void setLiveLogo(String str) {
        this.liveChannelLogo = str;
    }

    public void setLiveName(String str) {
        this.liveChannelName = str;
    }

    public void setLiveNum(String str) {
        this.liveNum = str;
    }

    public void setLiveStreamID(String str) {
        this.liveStreamID = str;
    }

    public void setSourceRef(String str) {
        this.sourceRef = str;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public void setStartTimeStamp(String str) {
        this.startTimeStamp = str;
    }

    public void setStop(String str) {
        this.stop = str;
    }

    public void setSub_title(String str) {
        this.sub_title = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "ClassPojo [stop = " + this.stop + ",  title = " + this.title + ", category = " + this.category + ", episode-num = " + this.episode_num + ", date = " + this.date + ", country = " + this.country + ", icon = " + this.icon + ", sub-title = " + this.sub_title + ",desc = " + this.desc + ", start = " + this.start + ", channel = " + this.channel + "]";
    }
}
