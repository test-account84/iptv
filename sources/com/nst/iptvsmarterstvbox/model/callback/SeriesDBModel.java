package com.nst.iptvsmarterstvbox.model.callback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SeriesDBModel {
    private String OneStreamseriesID;
    private String backdrop;
    private String cast;
    private String categoryId;
    private String cmd;
    private String cover;
    private String description;
    private String director;
    private String durationMin;
    private Integer fav;
    private String genre;
    private int idAuto;
    private String last_modified;
    private String loginType;
    private String name;
    private String num;
    private String plot;
    private String rating;
    private String releaseDate;
    private String seasons;
    private int seriesID;
    private String streamType;
    private String timestamp;
    private String url;
    private String youTubeTrailer;

    public SeriesDBModel() {
    }

    public String getBackdrop() {
        return this.backdrop;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getDurationMin() {
        return this.durationMin;
    }

    public int getFav() {
        return this.fav.intValue();
    }

    public int getIdAuto() {
        return this.idAuto;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getOneStreamseriesID() {
        return this.OneStreamseriesID;
    }

    public String getSeasons() {
        return this.seasons;
    }

    public String getStreamType() {
        return this.streamType;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUrl() {
        return this.url;
    }

    public String getYouTubeTrailer() {
        return this.youTubeTrailer;
    }

    public String getcast() {
        return this.cast;
    }

    public String getcover() {
        return this.cover;
    }

    public String getdirector() {
        return this.director;
    }

    public String getgenre() {
        return this.genre;
    }

    public String getlast_modified() {
        return this.last_modified;
    }

    public String getplot() {
        return this.plot;
    }

    public String getrating() {
        return this.rating;
    }

    public String getreleaseDate() {
        return this.releaseDate;
    }

    public int getseriesID() {
        return this.seriesID;
    }

    public void setBackdrop(String str) {
        this.backdrop = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setDurationMin(String str) {
        this.durationMin = str;
    }

    public void setFav(Integer num) {
        this.fav = num;
    }

    public void setIdAuto(int i) {
        this.idAuto = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setOneStreamseriesID(String str) {
        this.OneStreamseriesID = str;
    }

    public void setSeasons(String str) {
        this.seasons = str;
    }

    public void setStreamType(String str) {
        this.streamType = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setYouTubeTrailer(String str) {
        this.youTubeTrailer = str;
    }

    public void setcast(String str) {
        this.cast = str;
    }

    public void setcover(String str) {
        this.cover = str;
    }

    public void setdirector(String str) {
        this.director = str;
    }

    public void setgenre(String str) {
        this.genre = str;
    }

    public void setlast_modified(String str) {
        this.last_modified = str;
    }

    public void setloginType(String str) {
        this.loginType = str;
    }

    public void setplot(String str) {
        this.plot = str;
    }

    public void setrating(String str) {
        this.rating = str;
    }

    public void setreleaseDate(String str) {
        this.releaseDate = str;
    }

    public void setseriesID(int i) {
        this.seriesID = i;
    }

    public SeriesDBModel(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.num = str;
        this.name = str2;
        this.streamType = str3;
        this.seriesID = i;
        this.OneStreamseriesID = str4;
        this.cover = str5;
        this.plot = str6;
        this.categoryId = str7;
        this.cast = str8;
        this.director = str9;
        this.genre = str10;
        this.releaseDate = str11;
        this.last_modified = str12;
        this.rating = str13;
        this.youTubeTrailer = str14;
    }
}
