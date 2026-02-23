package com.nst.iptvsmarterstvbox.model;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VodAllCategoriesSingleton {
    private static VodAllCategoriesSingleton myObj;
    private ArrayList continueWatchingList;
    private ArrayList liveCategoriesList;
    private ArrayList liveFavList;
    private ArrayList liveList;
    private String moviesPoster = "";
    private ArrayList radioFavList;
    private ArrayList vodCategoriesList;
    private ArrayList vodFavList;
    private ArrayList vodList;

    private VodAllCategoriesSingleton() {
    }

    public static VodAllCategoriesSingleton getInstance() {
        if (myObj == null) {
            myObj = new VodAllCategoriesSingleton();
        }
        return myObj;
    }

    public ArrayList getContinueWatchingList() {
        return this.continueWatchingList;
    }

    public ArrayList getLiveCategoriesList() {
        return this.liveCategoriesList;
    }

    public ArrayList getLiveFavList() {
        return this.liveFavList;
    }

    public ArrayList getLiveList() {
        return this.liveList;
    }

    public String getMoviesPoster() {
        return this.moviesPoster;
    }

    public ArrayList getRadioFavList() {
        return this.radioFavList;
    }

    public ArrayList getVodCategoriesList() {
        return this.vodCategoriesList;
    }

    public ArrayList getVodFavList() {
        return this.vodFavList;
    }

    public ArrayList getvodList() {
        return this.vodList;
    }

    public void setContinueWatchingList(ArrayList arrayList) {
        this.continueWatchingList = arrayList;
    }

    public void setLiveCategoriesList(ArrayList arrayList) {
        this.liveCategoriesList = arrayList;
    }

    public void setLiveFavList(ArrayList arrayList) {
        this.liveFavList = arrayList;
    }

    public void setLiveList(ArrayList arrayList) {
        this.liveList = arrayList;
    }

    public void setMoviesPoster(String str) {
        this.moviesPoster = str;
    }

    public void setRadioFavList(ArrayList arrayList) {
        this.radioFavList = arrayList;
    }

    public void setVodCategoriesList(ArrayList arrayList) {
        this.vodCategoriesList = arrayList;
    }

    public void setVodFavList(ArrayList arrayList) {
        this.vodFavList = arrayList;
    }

    public void setVodList(ArrayList arrayList) {
        this.vodList = arrayList;
    }
}
