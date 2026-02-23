package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class OneStreamSeriesStreamDataModel {
    public String backdrop_path;
    public String cast;
    public String categories;
    public String cover;
    public String director;
    public String episode_run_time;
    public String genre;
    public String last_modified;
    public String name;
    public String num;
    public String plot;
    public String rating;
    public String rating_5based;
    public String release_date;
    public String series_id;
    public String youtube_trailer;

    public OneStreamSeriesStreamDataModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.num = str;
        this.name = str2;
        this.series_id = str3;
        this.cover = str4;
        this.youtube_trailer = str5;
        this.genre = str6;
        this.release_date = str7;
        this.plot = str8;
        this.cast = str9;
        this.rating = str10;
        this.rating_5based = str11;
        this.director = str12;
        this.backdrop_path = str13;
        this.last_modified = str14;
        this.episode_run_time = str15;
        this.categories = str16;
    }

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public String getCast() {
        return this.cast;
    }

    public String getCategories() {
        return this.categories;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDirector() {
        return this.director;
    }

    public String getEpisode_run_time() {
        return this.episode_run_time;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getLast_modified() {
        return this.last_modified;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getPlot() {
        return this.plot;
    }

    public String getRating() {
        return this.rating;
    }

    public String getRating_5based() {
        return this.rating_5based;
    }

    public String getRelease_date() {
        return this.release_date;
    }

    public String getSeries_id() {
        return this.series_id;
    }

    public String getYoutube_trailer() {
        return this.youtube_trailer;
    }
}
