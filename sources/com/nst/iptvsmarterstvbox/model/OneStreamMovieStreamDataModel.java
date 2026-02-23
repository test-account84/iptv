package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class OneStreamMovieStreamDataModel {
    public String added;
    public String categories;
    public String is_adult;
    public String links;
    public String name;
    public String num;
    public String rating;
    public String rating_5based;
    public String stream_icon;
    public String stream_id;
    public String stream_type;

    public OneStreamMovieStreamDataModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.num = str;
        this.name = str2;
        this.stream_type = str3;
        this.stream_id = str4;
        this.stream_icon = str5;
        this.rating = str6;
        this.rating_5based = str7;
        this.added = str8;
        this.is_adult = str9;
        this.categories = str10;
        this.links = str11;
    }

    public String getAdded() {
        return this.added;
    }

    public String getCategories() {
        return this.categories;
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

    public String getRating() {
        return this.rating;
    }

    public String getRating_5based() {
        return this.rating_5based;
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

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCategories(String str) {
        this.categories = str;
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

    public void setRating(String str) {
        this.rating = str;
    }

    public void setRating_5based(String str) {
        this.rating_5based = str;
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
}
