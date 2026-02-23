package com.nst.iptvsmarterstvbox.model;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MoviesUsingSinglton {
    private static MoviesUsingSinglton myObj;
    private List MoviesList;

    private MoviesUsingSinglton() {
    }

    public static MoviesUsingSinglton getInstance() {
        if (myObj == null) {
            myObj = new MoviesUsingSinglton();
        }
        return myObj;
    }

    public List getMoviesList() {
        return this.MoviesList;
    }

    public void setMoviesList(List list) {
        this.MoviesList = list;
    }
}
