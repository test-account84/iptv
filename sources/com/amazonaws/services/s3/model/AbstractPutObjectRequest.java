package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AbstractPutObjectRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, SSEAwsKeyManagementParamsProvider, S3DataSource, Serializable {
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedAcl;
    private File file;
    private transient InputStream inputStream;
    private String key;
    private ObjectMetadata metadata;
    private String redirectLocation;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private SSECustomerKey sseCustomerKey;
    private String storageClass;
    private ObjectTagging tagging;

    public AbstractPutObjectRequest(String str, String str2, File file) {
        this.bucketName = str;
        this.key = str2;
        this.file = file;
    }

    public final AbstractPutObjectRequest copyPutObjectBaseTo(AbstractPutObjectRequest abstractPutObjectRequest) {
        copyBaseTo(abstractPutObjectRequest);
        ObjectMetadata metadata = getMetadata();
        return abstractPutObjectRequest.withAccessControlList(getAccessControlList()).withCannedAcl(getCannedAcl()).withInputStream(getInputStream()).withMetadata(metadata == null ? null : metadata.clone()).withRedirectLocation(getRedirectLocation()).withStorageClass(getStorageClass()).withSSEAwsKeyManagementParams(getSSEAwsKeyManagementParams()).withSSECustomerKey(getSSECustomerKey());
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public File getFile() {
        return this.file;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    @Deprecated
    public ProgressListener getProgressListener() {
        com.amazonaws.event.ProgressListener generalProgressListener = getGeneralProgressListener();
        if (generalProgressListener instanceof LegacyS3ProgressListener) {
            return ((LegacyS3ProgressListener) generalProgressListener).unwrap();
        }
        return null;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public SSEAwsKeyManagementParams getSSEAwsKeyManagementParams() {
        return this.sseAwsKeyManagementParams;
    }

    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public ObjectTagging getTagging() {
        return this.tagging;
    }

    public void setAccessControlList(AccessControlList accessControlList) {
        this.accessControlList = accessControlList;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCannedAcl(CannedAccessControlList cannedAccessControlList) {
        this.cannedAcl = cannedAccessControlList;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    @Deprecated
    public void setProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public void setSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null && this.sseCustomerKey != null) {
            throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
        }
        this.sseAwsKeyManagementParams = sSEAwsKeyManagementParams;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey != null && this.sseAwsKeyManagementParams != null) {
            throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
        }
        this.sseCustomerKey = sSECustomerKey;
    }

    public void setStorageClass(StorageClass storageClass) {
        this.storageClass = storageClass.toString();
    }

    public void setTagging(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    public AbstractPutObjectRequest withAccessControlList(AccessControlList accessControlList) {
        setAccessControlList(accessControlList);
        return this;
    }

    public AbstractPutObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public AbstractPutObjectRequest withCannedAcl(CannedAccessControlList cannedAccessControlList) {
        setCannedAcl(cannedAccessControlList);
        return this;
    }

    public AbstractPutObjectRequest withFile(File file) {
        setFile(file);
        return this;
    }

    public AbstractPutObjectRequest withInputStream(InputStream inputStream) {
        setInputStream(inputStream);
        return this;
    }

    public AbstractPutObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public AbstractPutObjectRequest withMetadata(ObjectMetadata objectMetadata) {
        setMetadata(objectMetadata);
        return this;
    }

    @Deprecated
    public AbstractPutObjectRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public AbstractPutObjectRequest withRedirectLocation(String str) {
        this.redirectLocation = str;
        return this;
    }

    public AbstractPutObjectRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        setSSEAwsKeyManagementParams(sSEAwsKeyManagementParams);
        return this;
    }

    public AbstractPutObjectRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public AbstractPutObjectRequest withStorageClass(StorageClass storageClass) {
        setStorageClass(storageClass);
        return this;
    }

    public AbstractPutObjectRequest withTagging(ObjectTagging objectTagging) {
        setTagging(objectTagging);
        return this;
    }

    public AbstractPutObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        this.bucketName = str;
        this.key = str2;
        this.inputStream = inputStream;
        this.metadata = objectMetadata;
    }

    public AbstractPutObjectRequest clone() {
        return (AbstractPutObjectRequest) super.clone();
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public AbstractPutObjectRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public AbstractPutObjectRequest(String str, String str2, String str3) {
        this.bucketName = str;
        this.key = str2;
        this.redirectLocation = str3;
    }
}
