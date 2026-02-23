package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class OneStreamLiveStreamDataModel {
    public String categories;
    public String created_at;
    public String epg_channel_id;
    public String is_adult;
    public String links;
    public String name;
    public String num;
    public String stream_icon;
    public String stream_id;
    public String stream_type;
    public String tv_archive;
    public String tv_archive_duration;
    public String tv_archive_id;

    public OneStreamLiveStreamDataModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.num = str;
        this.name = str2;
        this.stream_type = str3;
        this.stream_id = str4;
        this.stream_icon = str5;
        this.epg_channel_id = str6;
        this.created_at = str7;
        this.is_adult = str8;
        this.categories = str9;
        this.links = str10;
        this.tv_archive = str11;
        this.tv_archive_id = str12;
        this.tv_archive_duration = str13;
    }

    public String getCategories() {
        return this.categories;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getEpg_channel_id() {
        return this.epg_channel_id;
    }

    public String getIs_adult() {
        return this.is_adult;
    }

    public String getLinks() {
        return this.links;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getStream_icon() {
        return this.stream_icon;
    }

    public String getStream_id() {
        return this.stream_id;
    }

    public String getStream_type() {
        return this.stream_type;
    }

    public String getTv_archive() {
        return this.tv_archive;
    }

    public String getTv_archive_duration() {
        return this.tv_archive_duration;
    }

    public String getTv_archive_id() {
        return this.tv_archive_id;
    }

    public void setCategories(String str) {
        this.categories = str;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setEpg_channel_id(String str) {
        this.epg_channel_id = str;
    }

    public void setIs_adult(String str) {
        this.is_adult = str;
    }

    public void setLinks(String str) {
        this.links = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setStream_icon(String str) {
        this.stream_icon = str;
    }

    public void setStream_id(String str) {
        this.stream_id = str;
    }

    public void setStream_type(String str) {
        this.stream_type = str;
    }

    public void setTv_archive(String str) {
        this.tv_archive = str;
    }

    public void setTv_archive_duration(String str) {
        this.tv_archive_duration = str;
    }

    public void setTv_archive_id(String str) {
        this.tv_archive_id = str;
    }
}
