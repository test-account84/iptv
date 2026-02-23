package com.amazonaws.services.s3.model;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EncryptedPutObjectRequest extends PutObjectRequest implements MaterialsDescriptionProvider, Serializable {
    private Map materialsDescription;

    public EncryptedPutObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
    }

    public Map getMaterialsDescription() {
        return this.materialsDescription;
    }

    public void setMaterialsDescription(Map map) {
        this.materialsDescription = map == null ? null : Collections.unmodifiableMap(new HashMap(map));
    }

    public EncryptedPutObjectRequest withMaterialsDescription(Map map) {
        setMaterialsDescription(map);
        return this;
    }

    public EncryptedPutObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, inputStream, objectMetadata);
    }

    public EncryptedPutObjectRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public EncryptedPutObjectRequest clone() {
        EncryptedPutObjectRequest encryptedPutObjectRequest = new EncryptedPutObjectRequest(getBucketName(), getKey(), getFile());
        super.copyPutObjectBaseTo(encryptedPutObjectRequest);
        Map materialsDescription = getMaterialsDescription();
        encryptedPutObjectRequest.withMaterialsDescription(materialsDescription == null ? null : new HashMap(materialsDescription));
        return encryptedPutObjectRequest;
    }
}
