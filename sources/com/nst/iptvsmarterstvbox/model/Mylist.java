package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Mylist {
    String du;
    String extension;
    int fh;
    int fw;
    long md;
    String name;
    String size;

    public Mylist(String str, long j, String str2, int i, int i2, String str3, String str4) {
        this.name = str;
        this.md = j;
        this.du = str3;
        this.size = str2;
        this.fw = i;
        this.fh = i2;
        this.extension = str4;
    }

    public String getDuration() {
        return this.du;
    }

    public String getExtension() {
        return this.extension;
    }

    public int getFrame_height() {
        return this.fh;
    }

    public int getFrmae_width() {
        return this.fw;
    }

    public long getModified_date() {
        return this.md;
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    public void setDuration(String str) {
        this.du = str;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setFrame_height(int i) {
        this.fh = i;
    }

    public void setFrmae_width(int i) {
        this.fw = i;
    }

    public void setModified_date(long j) {
        this.md = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(String str) {
        this.size = str;
    }
}
