package com.nst.iptvsmarterstvbox.model;

import androidx.lifecycle.I;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DataBaseViewModel extends I {
    private final u dataMovies = new u();

    public LiveData getDataForMovies() {
        return this.dataMovies;
    }

    public void updateData(LiveDataModel liveDataModel) {
        this.dataMovies.o(liveDataModel);
    }
}
