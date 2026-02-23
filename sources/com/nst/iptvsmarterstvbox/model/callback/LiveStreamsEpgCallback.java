package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveStreamsEpgCallback implements Serializable {

    @SerializedName("epg_listings")
    @Expose
    private List epgListingPojos = null;

    public List getEpgListingPojos() {
        return this.epgListingPojos;
    }

    public void setEpgListingPojos(List list) {
        this.epgListingPojos = list;
    }
}
