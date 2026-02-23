package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TMDBTrailerCallback {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("results")
    @Expose
    private List results = null;

    public Integer getId() {
        return this.id;
    }

    public List getResults() {
        return this.results;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setResults(List list) {
        this.results = list;
    }
}
