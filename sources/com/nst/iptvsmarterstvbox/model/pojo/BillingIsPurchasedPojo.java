package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BillingIsPurchasedPojo {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_purchased")
    @Expose
    private Boolean isPurchased;

    public String getId() {
        return this.id;
    }

    public Boolean getIsPurchased() {
        return this.isPurchased;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsPurchased(Boolean bool) {
        this.isPurchased = bool;
    }
}
