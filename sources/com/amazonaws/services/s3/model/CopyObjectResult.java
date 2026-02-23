package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CopyObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult, Serializable {
    private String etag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private boolean isRequesterCharged;
    private Date lastModifiedDate;
    private String versionId;

    public String getETag() {
        return this.etag;
    }

    public Date getExpirationTime() {
        return this.expirationTime;
    }

    public String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setETag(String str) {
        this.etag = str;
    }

    public void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public void setExpirationTimeRuleId(String str) {
        this.expirationTimeRuleId = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
