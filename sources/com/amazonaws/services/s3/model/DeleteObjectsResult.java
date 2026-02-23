package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteObjectsResult implements Serializable, S3RequesterChargedResult {
    private final List deletedObjects;
    private boolean isRequesterCharged;

    public static class DeletedObject implements Serializable {
        private boolean deleteMarker;
        private String deleteMarkerVersionId;
        private String key;
        private String versionId;

        public String getDeleteMarkerVersionId() {
            return this.deleteMarkerVersionId;
        }

        public String getKey() {
            return this.key;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public boolean isDeleteMarker() {
            return this.deleteMarker;
        }

        public void setDeleteMarker(boolean z) {
            this.deleteMarker = z;
        }

        public void setDeleteMarkerVersionId(String str) {
            this.deleteMarkerVersionId = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setVersionId(String str) {
            this.versionId = str;
        }
    }

    public DeleteObjectsResult(List list) {
        this(list, false);
    }

    public List getDeletedObjects() {
        return this.deletedObjects;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }

    public DeleteObjectsResult(List list, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.deletedObjects = arrayList;
        arrayList.addAll(list);
        setRequesterCharged(z);
    }
}
