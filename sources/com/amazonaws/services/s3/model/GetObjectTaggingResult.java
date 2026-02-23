package com.amazonaws.services.s3.model;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetObjectTaggingResult {
    private List tagSet;
    private String versionId;

    public GetObjectTaggingResult(List list) {
        this.tagSet = list;
    }

    public List getTagSet() {
        return this.tagSet;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setTagSet(List list) {
        this.tagSet = list;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public GetObjectTaggingResult withTagSet(List list) {
        setTagSet(list);
        return this;
    }

    public GetObjectTaggingResult withVersionId(String str) {
        setVersionId(str);
        return this;
    }
}
