package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveDataModel {
    private boolean isChange;
    private int type;
    private int mPosition = -1;
    private String mStreamId = "";
    private String mCatId = "";
    private boolean mStatus = false;

    public String getCatId() {
        return this.mCatId;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getStreamId() {
        return this.mStreamId;
    }

    public int getType() {
        return this.type;
    }

    public boolean isChange() {
        return this.isChange;
    }

    public boolean isStatus() {
        return this.mStatus;
    }

    public void setCatId(String str) {
        this.mCatId = str;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStatus(boolean z) {
        this.mStatus = z;
    }

    public void setStreamId(String str) {
        this.mStreamId = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUpdateForChange(boolean z) {
        this.isChange = z;
    }
}
