package com.nst.iptvsmarterstvbox.model.pojo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveDataModel {
    public String category_id;
    public String category_name;
    public String parent_id;

    public LiveDataModel(String str, String str2, String str3) {
        this.category_id = str;
        this.category_name = str2;
        this.parent_id = str3;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setCategory_id(String str) {
        this.category_id = str;
    }

    public void setCategory_name(String str) {
        this.category_name = str;
    }

    public void setParent_id(String str) {
        this.parent_id = str;
    }
}
