package com.nst.iptvsmarterstvbox.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SeriesAllCategoriesSingleton {
    private static SeriesAllCategoriesSingleton myObj;
    private List continueWatchingList;
    private ArrayList seriesCategoriesList;
    private ArrayList seriesFavList;
    private ArrayList seriesList;

    private SeriesAllCategoriesSingleton() {
    }

    public static SeriesAllCategoriesSingleton getInstance() {
        if (myObj == null) {
            myObj = new SeriesAllCategoriesSingleton();
        }
        return myObj;
    }

    public List getContinueWatchingList() {
        return this.continueWatchingList;
    }

    public ArrayList getSeriesCategoriesList() {
        return this.seriesCategoriesList;
    }

    public ArrayList getSeriesFavList() {
        return this.seriesFavList;
    }

    public ArrayList getSeriesList() {
        return this.seriesList;
    }

    public void setContinueWatchingList(List list) {
        this.continueWatchingList = list;
    }

    public void setSeriesCategoriesList(ArrayList arrayList) {
        this.seriesCategoriesList = arrayList;
    }

    public void setSeriesFavList(ArrayList arrayList) {
        this.seriesFavList = arrayList;
    }

    public void setSeriesList(ArrayList arrayList) {
        this.seriesList = arrayList;
    }
}
