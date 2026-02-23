package com.nst.iptvsmarterstvbox.model;

import android.graphics.Bitmap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Myaudiofile {
    Bitmap bitmap;
    String du;
    long md;
    String name;
    String size;

    public Myaudiofile(String str, long j, String str2, String str3, Bitmap bitmap) {
        this.name = str;
        this.md = j;
        this.du = str3;
        this.size = str2;
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDuration() {
        return this.du;
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

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setDuration(String str) {
        this.du = str;
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
