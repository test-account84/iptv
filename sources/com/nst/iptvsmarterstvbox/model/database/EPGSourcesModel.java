package com.nst.iptvsmarterstvbox.model.database;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EPGSourcesModel {
    private int auto_id;
    private String default_source;
    private String epgurl;
    private String name;
    private String source_type;
    private String user_id;

    public String getDefault_source() {
        return this.default_source;
    }

    public String getEpgurl() {
        return this.epgurl;
    }

    public int getIdAuto() {
        return this.auto_id;
    }

    public String getName() {
        return this.name;
    }

    public String getSource_type() {
        return this.source_type;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setDefault_source(String str) {
        this.default_source = str;
    }

    public void setEpgurl(String str) {
        this.epgurl = str;
    }

    public void setIdAuto(int i) {
        this.auto_id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSource_type(String str) {
        this.source_type = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }
}
