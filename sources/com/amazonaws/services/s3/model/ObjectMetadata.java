package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.util.DateUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ObjectMetadata implements ServerSideEncryptionResult, S3RequesterChargedResult, ObjectExpirationResult, ObjectRestoreResult, Cloneable, Serializable {
    public static final String AES_256_SERVER_SIDE_ENCRYPTION = SSEAlgorithm.AES256.getAlgorithm();
    public static final String KMS_SERVER_SIDE_ENCRYPTION = SSEAlgorithm.KMS.getAlgorithm();
    private Date expirationTime;
    private String expirationTimeRuleId;
    private Date httpExpiresDate;
    private Map metadata;
    private Boolean ongoingRestore;
    private Date restoreExpirationTime;
    private Map userMetadata;

    public ObjectMetadata() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.userMetadata = new TreeMap(comparator);
        this.metadata = new TreeMap(comparator);
    }

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    public ObjectMetadata clone() {
        return new ObjectMetadata(this);
    }

    public String getCacheControl() {
        return (String) this.metadata.get("Cache-Control");
    }

    public String getContentDisposition() {
        return (String) this.metadata.get("Content-Disposition");
    }

    public String getContentEncoding() {
        return (String) this.metadata.get("Content-Encoding");
    }

    public String getContentLanguage() {
        return (String) this.metadata.get("Content-Language");
    }

    public long getContentLength() {
        Long l = (Long) this.metadata.get("Content-Length");
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String getContentMD5() {
        return (String) this.metadata.get("Content-MD5");
    }

    public Long[] getContentRange() {
        String str = (String) this.metadata.get("Content-Range");
        if (str == null) {
            return null;
        }
        String[] split = str.split("[ -/]+");
        try {
            return new Long[]{Long.valueOf(Long.parseLong(split[1])), Long.valueOf(Long.parseLong(split[2]))};
        } catch (NumberFormatException e) {
            throw new AmazonClientException("Unable to parse content range. Header 'Content-Range' has corrupted data" + e.getMessage(), e);
        }
    }

    public String getContentType() {
        return (String) this.metadata.get("Content-Type");
    }

    public String getETag() {
        return (String) this.metadata.get("ETag");
    }

    public Date getExpirationTime() {
        return DateUtils.cloneDate(this.expirationTime);
    }

    public String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public Date getHttpExpiresDate() {
        return DateUtils.cloneDate(this.httpExpiresDate);
    }

    public long getInstanceLength() {
        int lastIndexOf;
        String str = (String) this.metadata.get("Content-Range");
        return (str == null || (lastIndexOf = str.lastIndexOf("/")) < 0) ? getContentLength() : Long.parseLong(str.substring(lastIndexOf + 1));
    }

    public Date getLastModified() {
        return DateUtils.cloneDate((Date) this.metadata.get("Last-Modified"));
    }

    public Boolean getOngoingRestore() {
        return this.ongoingRestore;
    }

    public Integer getPartCount() {
        return (Integer) this.metadata.get("x-amz-mp-parts-count");
    }

    public Map getRawMetadata() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(this.metadata);
        return Collections.unmodifiableMap(treeMap);
    }

    public Object getRawMetadataValue(String str) {
        return this.metadata.get(str);
    }

    public String getReplicationStatus() {
        return (String) this.metadata.get("x-amz-replication-status");
    }

    public Date getRestoreExpirationTime() {
        return DateUtils.cloneDate(this.restoreExpirationTime);
    }

    public String getSSEAlgorithm() {
        return (String) this.metadata.get("x-amz-server-side-encryption");
    }

    public String getSSEAwsKmsKeyId() {
        return (String) this.metadata.get("x-amz-server-side-encryption-aws-kms-key-id");
    }

    public String getSSECustomerAlgorithm() {
        return (String) this.metadata.get("x-amz-server-side-encryption-customer-algorithm");
    }

    public String getSSECustomerKeyMd5() {
        return (String) this.metadata.get("x-amz-server-side-encryption-customer-key-MD5");
    }

    @Deprecated
    public String getServerSideEncryption() {
        return (String) this.metadata.get("x-amz-server-side-encryption");
    }

    public String getStorageClass() {
        Object obj = this.metadata.get("x-amz-storage-class");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getUserMetaDataOf(String str) {
        Map map = this.userMetadata;
        if (map == null) {
            return null;
        }
        return (String) map.get(str);
    }

    public Map getUserMetadata() {
        return this.userMetadata;
    }

    public String getVersionId() {
        return (String) this.metadata.get("x-amz-version-id");
    }

    public boolean isRequesterCharged() {
        return this.metadata.get("x-amz-request-charged") != null;
    }

    public void setCacheControl(String str) {
        this.metadata.put("Cache-Control", str);
    }

    public void setContentDisposition(String str) {
        this.metadata.put("Content-Disposition", str);
    }

    public void setContentEncoding(String str) {
        this.metadata.put("Content-Encoding", str);
    }

    public void setContentLanguage(String str) {
        this.metadata.put("Content-Language", str);
    }

    public void setContentLength(long j) {
        this.metadata.put("Content-Length", Long.valueOf(j));
    }

    public void setContentMD5(String str) {
        if (str == null) {
            this.metadata.remove("Content-MD5");
        } else {
            this.metadata.put("Content-MD5", str);
        }
    }

    public void setContentType(String str) {
        this.metadata.put("Content-Type", str);
    }

    public void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public void setExpirationTimeRuleId(String str) {
        this.expirationTimeRuleId = str;
    }

    public void setHeader(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void setHttpExpiresDate(Date date) {
        this.httpExpiresDate = date;
    }

    public void setLastModified(Date date) {
        this.metadata.put("Last-Modified", date);
    }

    public void setOngoingRestore(boolean z) {
        this.ongoingRestore = Boolean.valueOf(z);
    }

    public void setRequesterCharged(boolean z) {
        if (z) {
            this.metadata.put("x-amz-request-charged", "requester");
        }
    }

    public void setRestoreExpirationTime(Date date) {
        this.restoreExpirationTime = date;
    }

    public void setSSEAlgorithm(String str) {
        this.metadata.put("x-amz-server-side-encryption", str);
    }

    public void setSSECustomerAlgorithm(String str) {
        this.metadata.put("x-amz-server-side-encryption-customer-algorithm", str);
    }

    public void setSSECustomerKeyMd5(String str) {
        this.metadata.put("x-amz-server-side-encryption-customer-key-MD5", str);
    }

    @Deprecated
    public void setServerSideEncryption(String str) {
        this.metadata.put("x-amz-server-side-encryption", str);
    }

    public void setStorageClass(StorageClass storageClass) {
        this.metadata.put("x-amz-storage-class", storageClass);
    }

    public void setUserMetadata(Map map) {
        this.userMetadata = map;
    }

    private ObjectMetadata(ObjectMetadata objectMetadata) {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.userMetadata = new TreeMap(comparator);
        this.metadata = new TreeMap(comparator);
        this.userMetadata = objectMetadata.userMetadata == null ? null : new TreeMap(objectMetadata.userMetadata);
        this.metadata = objectMetadata.metadata != null ? new TreeMap(objectMetadata.metadata) : null;
        this.expirationTime = DateUtils.cloneDate(objectMetadata.expirationTime);
        this.expirationTimeRuleId = objectMetadata.expirationTimeRuleId;
        this.httpExpiresDate = DateUtils.cloneDate(objectMetadata.httpExpiresDate);
        this.ongoingRestore = objectMetadata.ongoingRestore;
        this.restoreExpirationTime = DateUtils.cloneDate(objectMetadata.restoreExpirationTime);
    }
}
