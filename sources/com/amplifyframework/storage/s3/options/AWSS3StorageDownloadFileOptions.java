package com.amplifyframework.storage.s3.options;

import O.c;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageDownloadFileOptions extends StorageDownloadFileOptions {
    private AWSS3StorageDownloadFileOptions(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AWSS3StorageDownloadFileOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(AWSS3StorageDownloadFileOptions aWSS3StorageDownloadFileOptions) {
        return (Builder) ((Builder) builder().accessLevel(aWSS3StorageDownloadFileOptions.getAccessLevel())).targetIdentityId(aWSS3StorageDownloadFileOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSS3StorageDownloadFileOptions)) {
            return false;
        }
        AWSS3StorageDownloadFileOptions aWSS3StorageDownloadFileOptions = (AWSS3StorageDownloadFileOptions) obj;
        return c.a(getAccessLevel(), aWSS3StorageDownloadFileOptions.getAccessLevel()) && c.a(getTargetIdentityId(), aWSS3StorageDownloadFileOptions.getTargetIdentityId());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        return "AWSS3StorageDownloadFileOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + '}';
    }

    public static final class Builder extends StorageDownloadFileOptions.Builder {
        public AWSS3StorageDownloadFileOptions build() {
            return new AWSS3StorageDownloadFileOptions(this, null);
        }
    }

    public /* synthetic */ AWSS3StorageDownloadFileOptions(Builder builder, 1 r2) {
        this(builder);
    }
}
