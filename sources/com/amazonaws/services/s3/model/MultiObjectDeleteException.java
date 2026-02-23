package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiObjectDeleteException extends AmazonS3Exception {
    private static final long serialVersionUID = -2004213552302446866L;
    private final List deletedObjects;
    private final List errors;

    public static class DeleteError {
        private String code;
        private String key;
        private String message;
        private String versionId;

        public String getCode() {
            return this.code;
        }

        public String getKey() {
            return this.key;
        }

        public String getMessage() {
            return this.message;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setVersionId(String str) {
            this.versionId = str;
        }
    }

    public MultiObjectDeleteException(Collection collection, Collection collection2) {
        super("One or more objects could not be deleted");
        ArrayList arrayList = new ArrayList();
        this.errors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.deletedObjects = arrayList2;
        arrayList2.addAll(collection2);
        arrayList.addAll(collection);
    }

    public List getDeletedObjects() {
        return this.deletedObjects;
    }

    public String getErrorCode() {
        return super.getErrorCode();
    }

    public List getErrors() {
        return this.errors;
    }
}
