package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VPNCredentialsPojo {

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("username")
    @Expose
    private String username;

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
