package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ObjectTagging implements Serializable {
    private List tagSet;

    public ObjectTagging(List list) {
        this.tagSet = list;
    }

    private ObjectTagging withTagSet(List list) {
        this.tagSet = list;
        return this;
    }

    public List getTagSet() {
        return this.tagSet;
    }

    public void setTagSet(List list) {
        this.tagSet = list;
    }
}
