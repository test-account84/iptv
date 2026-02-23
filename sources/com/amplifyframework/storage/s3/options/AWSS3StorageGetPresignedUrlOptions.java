package com.amplifyframework.storage.s3.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageGetUrlOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageGetPresignedUrlOptions extends StorageGetUrlOptions {
    private AWSS3StorageGetPresignedUrlOptions(Builder builder) {
        super(builder);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder builder() {
        return new Builder();
    }

    public static AWSS3StorageGetPresignedUrlOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(AWSS3StorageGetPresignedUrlOptions aWSS3StorageGetPresignedUrlOptions) {
        return (Builder) ((Builder) ((Builder) builder().accessLevel(aWSS3StorageGetPresignedUrlOptions.getAccessLevel())).targetIdentityId(aWSS3StorageGetPresignedUrlOptions.getTargetIdentityId())).expires(aWSS3StorageGetPresignedUrlOptions.getExpires());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSS3StorageGetPresignedUrlOptions)) {
            return false;
        }
        AWSS3StorageGetPresignedUrlOptions aWSS3StorageGetPresignedUrlOptions = (AWSS3StorageGetPresignedUrlOptions) obj;
        return c.a(getAccessLevel(), aWSS3StorageGetPresignedUrlOptions.getAccessLevel()) && c.a(getTargetIdentityId(), aWSS3StorageGetPresignedUrlOptions.getTargetIdentityId()) && c.a(Integer.valueOf(getExpires()), Integer.valueOf(aWSS3StorageGetPresignedUrlOptions.getExpires()));
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), Integer.valueOf(getExpires()));
    }

    public String toString() {
        return "AWSS3StorageGetPresignedUrlOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", expires=" + getExpires() + '}';
    }

    public static final class Builder extends StorageGetUrlOptions.Builder {
        public AWSS3StorageGetPresignedUrlOptions build() {
            return new AWSS3StorageGetPresignedUrlOptions(this, null);
        }
    }

    public /* synthetic */ AWSS3StorageGetPresignedUrlOptions(Builder builder, 1 r2) {
        this(builder);
    }
}
