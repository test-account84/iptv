package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PutObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {
    private String contentMd5;
    private String eTag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private boolean isRequesterCharged;
    private ObjectMetadata metadata;
    private String versionId;

    public String getContentMd5() {
        return this.contentMd5;
    }

    public String getETag() {
        return this.eTag;
    }

    public Date getExpirationTime() {
        return this.expirationTime;
    }

    public String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public void setExpirationTimeRuleId(String str) {
        this.expirationTimeRuleId = str;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
