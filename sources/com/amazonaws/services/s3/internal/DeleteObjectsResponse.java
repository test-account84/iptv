package com.amazonaws.services.s3.internal;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteObjectsResponse implements S3RequesterChargedResult {
    private List deletedObjects;
    private List errors;
    private boolean isRequesterCharged;

    public DeleteObjectsResponse() {
        this(new ArrayList(), new ArrayList());
    }

    public List getDeletedObjects() {
        return this.deletedObjects;
    }

    public List getErrors() {
        return this.errors;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setDeletedObjects(List list) {
        this.deletedObjects = list;
    }

    public void setErrors(List list) {
        this.errors = list;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }

    public DeleteObjectsResponse(List list, List list2) {
        this.deletedObjects = list;
        this.errors = list2;
    }
}
