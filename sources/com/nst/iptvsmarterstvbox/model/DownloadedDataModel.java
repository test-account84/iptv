package com.nst.iptvsmarterstvbox.model;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DownloadedDataModel extends ArrayList {
    private int idAuto;
    private long movieCurrentPosition;
    private String movieDuration;
    private String movieExtension;
    private String movieImage;
    private String movieName;
    private String movieNum;
    private int moviePercentage;
    private String movieState;
    private String movieStreamID;
    private String movieType;
    private String movieURL;

    public DownloadedDataModel() {
    }

    public int getIdAuto() {
        return this.idAuto;
    }

    public long getMovieCurrentPosition() {
        return this.movieCurrentPosition;
    }

    public String getMovieDuration() {
        return this.movieDuration;
    }

    public String getMovieExtension() {
        return this.movieExtension;
    }

    public String getMovieImage() {
        return this.movieImage;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getMovieNum() {
        return this.movieNum;
    }

    public int getMoviePercentage() {
        return this.moviePercentage;
    }

    public String getMovieState() {
        return this.movieState;
    }

    public String getMovieStreamID() {
        return this.movieStreamID;
    }

    public String getMovieType() {
        return this.movieType;
    }

    public String getMovieURL() {
        return this.movieURL;
    }

    public void setIdAuto(int i) {
        this.idAuto = i;
    }

    public void setMovieCurrentPosition(long j) {
        this.movieCurrentPosition = j;
    }

    public void setMovieDuration(String str) {
        this.movieDuration = str;
    }

    public void setMovieExtension(String str) {
        this.movieExtension = str;
    }

    public void setMovieImage(String str) {
        this.movieImage = str;
    }

    public void setMovieName(String str) {
        this.movieName = str;
    }

    public void setMovieNum(String str) {
        this.movieNum = str;
    }

    public void setMoviePercentage(int i) {
        this.moviePercentage = i;
    }

    public void setMovieState(String str) {
        this.movieState = str;
    }

    public void setMovieStreamID(String str) {
        this.movieStreamID = str;
    }

    public void setMovieType(String str) {
        this.movieType = str;
    }

    public void setMovieURL(String str) {
        this.movieURL = str;
    }

    public DownloadedDataModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this.movieName = str;
        this.movieExtension = str2;
        this.movieStreamID = str3;
        this.movieDuration = str4;
        this.movieNum = str5;
        this.movieImage = str6;
        this.movieURL = str7;
        this.movieState = str8;
        this.moviePercentage = i;
    }
}
