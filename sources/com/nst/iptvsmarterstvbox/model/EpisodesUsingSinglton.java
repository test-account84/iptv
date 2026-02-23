package com.nst.iptvsmarterstvbox.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EpisodesUsingSinglton {
    private static EpisodesUsingSinglton myObj;
    private boolean RecenlyTimeSaved = true;
    private List currentSeasonEpisodeList;
    private List episodeList;
    private ArrayList seasonsList;

    private EpisodesUsingSinglton() {
    }

    public static EpisodesUsingSinglton getInstance() {
        if (myObj == null) {
            myObj = new EpisodesUsingSinglton();
        }
        return myObj;
    }

    public List getCurrentSeasonEpisodeList() {
        return this.currentSeasonEpisodeList;
    }

    public List getEpisodeList() {
        return this.episodeList;
    }

    public boolean getRecenlyTimeSaved() {
        return this.RecenlyTimeSaved;
    }

    public ArrayList getSeasonsList() {
        return this.seasonsList;
    }

    public void setCurrentSeasonEpisodeList(List list) {
        this.currentSeasonEpisodeList = list;
    }

    public void setEpisodeList(List list) {
        this.episodeList = list;
    }

    public void setRecenlyTimeSaved(boolean z) {
        this.RecenlyTimeSaved = z;
    }

    public void setSeasonsList(ArrayList arrayList) {
        this.seasonsList = arrayList;
    }
}
