package com.nst.iptvsmarterstvbox.model;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveStreamsDBModel extends ArrayList {
    private String added;
    private String cast;
    private String categoryId;
    private String categoryName;
    private String cmd;
    private String contaiinerExtension;
    private String customSid;
    private String description;
    private String directSource;
    private String director;
    private String durationMin;
    private String epgChannelId;
    private String epgDesc;
    private Long epgEndDate;
    private int epgPercentage;
    private Long epgStartDate;
    private String epgTitle;
    private Integer fav;
    private String genre;
    private int idAuto;
    private String links;
    private String live;
    private long movieDuraton;
    private long movieElapsedTime;
    private String name;
    private String num;
    private String programName;
    private String ratingFromFive;
    private String ratingFromTen;
    private String recentlyWatchedStatus;
    private String seriesNo;
    private String streamIcon;
    private String streamId;
    private String streamIdOneStream;
    private String streamNameWithNameFilter;
    private String streamType;
    private String timestamp;
    private String tvArchive;
    private String tvArchiveDuration;
    private String typeName;
    private String url;
    private String urlCheck;
    private int userIdReffered;
    private String year;

    public LiveStreamsDBModel() {
    }

    private String normalizeString(String str) {
        return Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("").toLowerCase();
    }

    public String getAdded() {
        return this.added;
    }

    public String getCast() {
        return this.cast;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getContaiinerExtension() {
        return this.contaiinerExtension;
    }

    public String getCustomSid() {
        return this.customSid;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDirectSource() {
        return this.directSource;
    }

    public String getDirector() {
        return this.director;
    }

    public String getDurationMin() {
        return this.durationMin;
    }

    public String getEpgChannelId() {
        return this.epgChannelId;
    }

    public String getEpgDesc() {
        return this.epgDesc;
    }

    public Long getEpgEndDate() {
        return this.epgEndDate;
    }

    public int getEpgPercentage() {
        return this.epgPercentage;
    }

    public Long getEpgStartDate() {
        return this.epgStartDate;
    }

    public String getEpgTitle() {
        return this.epgTitle;
    }

    public int getFav() {
        Integer num = this.fav;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getIdAuto() {
        return this.idAuto;
    }

    public String getIsRecentlyWatched() {
        return this.recentlyWatchedStatus;
    }

    public String getLinks() {
        return this.links;
    }

    public String getLive() {
        return this.live;
    }

    public String getLiveStreamNameFilter() {
        return this.streamNameWithNameFilter;
    }

    public long getMovieDuraton() {
        return this.movieDuraton;
    }

    public long getMovieElapsedTime() {
        return this.movieElapsedTime;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getProgramName() {
        return this.programName;
    }

    public String getRatingFromFive() {
        return this.ratingFromFive;
    }

    public String getRatingFromTen() {
        return this.ratingFromTen;
    }

    public String getSeriesNo() {
        return this.seriesNo;
    }

    public String getStreamIcon() {
        return this.streamIcon;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public String getStreamIdOneStream() {
        return this.streamIdOneStream;
    }

    public String getStreamType() {
        return this.streamType;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getTvArchive() {
        return this.tvArchive;
    }

    public String getTvArchiveDuration() {
        return this.tvArchiveDuration;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUserIdReffered() {
        return this.userIdReffered;
    }

    public String getYear() {
        return this.year;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCast(String str) {
        this.cast = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setContaiinerExtension(String str) {
        this.contaiinerExtension = str;
    }

    public void setCustomSid(String str) {
        this.customSid = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDirectSource(String str) {
        this.directSource = str;
    }

    public void setDirector(String str) {
        this.director = str;
    }

    public void setDurationMin(String str) {
        this.durationMin = str;
    }

    public void setEpgChannelId(String str) {
        this.epgChannelId = str;
    }

    public void setEpgDesc(String str) {
        this.epgDesc = str;
    }

    public void setEpgEndDate(Long l) {
        this.epgEndDate = l;
    }

    public void setEpgPercentage(int i) {
        this.epgPercentage = i;
    }

    public void setEpgStartDate(Long l) {
        this.epgStartDate = l;
    }

    public void setEpgTitle(String str) {
        this.epgTitle = str;
    }

    public void setFav(Integer num) {
        this.fav = num;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setIdAuto(int i) {
        this.idAuto = i;
    }

    public void setIsRecentlyWatched(String str) {
        this.recentlyWatchedStatus = str;
    }

    public void setLinks(String str) {
        this.links = str;
    }

    public void setLive(String str) {
        this.live = str;
    }

    public void setMovieDuraton(long j) {
        this.movieDuraton = j;
    }

    public void setMovieElapsedTime(long j) {
        this.movieElapsedTime = j;
    }

    public void setName(String str) {
        this.name = str;
        setStreamNameWithNameFilter(str);
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setProgramName(String str) {
        this.programName = str;
    }

    public void setRatingFromFive(String str) {
        this.ratingFromFive = str;
    }

    public void setRatingFromTen(String str) {
        this.ratingFromTen = str;
    }

    public void setSeriesNo(String str) {
        this.seriesNo = str;
    }

    public void setStreamIcon(String str) {
        this.streamIcon = str;
    }

    public void setStreamId(String str) {
        this.streamId = str;
    }

    public void setStreamIdOneStream(String str) {
        this.streamIdOneStream = str;
    }

    public void setStreamNameWithNameFilter(String str) {
        this.streamNameWithNameFilter = normalizeString(str);
    }

    public void setStreamType(String str) {
        this.streamType = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTvArchive(String str) {
        this.tvArchive = str;
    }

    public void setTvArchiveDuration(String str) {
        this.tvArchiveDuration = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserIdReffered(int i) {
        this.userIdReffered = i;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public LiveStreamsDBModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, Long l, Long l2, String str18, String str19, int i2, long j, long j2, String str20) {
        this.num = str;
        this.name = str2;
        this.streamType = str3;
        this.streamId = str4;
        this.streamIcon = str5;
        this.epgChannelId = str6;
        this.added = str7;
        this.categoryId = str8;
        this.customSid = str9;
        this.tvArchive = str10;
        this.directSource = str11;
        this.tvArchiveDuration = str12;
        this.typeName = str13;
        this.categoryName = str14;
        this.seriesNo = str15;
        this.live = str16;
        this.contaiinerExtension = str17;
        this.epgPercentage = i;
        this.epgStartDate = l;
        this.epgEndDate = l2;
        this.epgTitle = str18;
        this.epgDesc = str19;
        this.userIdReffered = i2;
        this.movieElapsedTime = j;
        this.movieDuraton = j2;
        this.streamIdOneStream = str20;
    }
}
