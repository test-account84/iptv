package com.amplifyframework.storage.s3.request;

import com.amplifyframework.storage.StorageAccessLevel;
import com.amplifyframework.storage.s3.ServerSideEncryption;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageUploadRequest {
    private final StorageAccessLevel accessLevel;
    private final String contentType;
    private final String key;
    private final Object local;
    private final Map metadata;
    private final ServerSideEncryption serverSideEncryption;
    private final String targetIdentityId;

    public AWSS3StorageUploadRequest(String str, Object obj, StorageAccessLevel storageAccessLevel, String str2, String str3, ServerSideEncryption serverSideEncryption, Map map) {
        this.key = str;
        this.local = obj;
        this.accessLevel = storageAccessLevel;
        this.targetIdentityId = str2;
        this.contentType = str3;
        this.serverSideEncryption = serverSideEncryption;
        HashMap hashMap = new HashMap();
        this.metadata = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public StorageAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getKey() {
        return this.key;
    }

    public Object getLocal() {
        return this.local;
    }

    public Map getMetadata() {
        return this.metadata;
    }

    public ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getTargetIdentityId() {
        return this.targetIdentityId;
    }
}
