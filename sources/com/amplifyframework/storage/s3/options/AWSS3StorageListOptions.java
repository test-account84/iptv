package com.amplifyframework.storage.s3.options;

import O.c;
import com.amplifyframework.storage.options.StorageListOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageListOptions extends StorageListOptions {
    private AWSS3StorageListOptions(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AWSS3StorageListOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(AWSS3StorageListOptions aWSS3StorageListOptions) {
        return (Builder) ((Builder) builder().accessLevel(aWSS3StorageListOptions.getAccessLevel())).targetIdentityId(aWSS3StorageListOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSS3StorageListOptions)) {
            return false;
        }
        AWSS3StorageListOptions aWSS3StorageListOptions = (AWSS3StorageListOptions) obj;
        return c.a(getAccessLevel(), aWSS3StorageListOptions.getAccessLevel()) && c.a(getTargetIdentityId(), aWSS3StorageListOptions.getTargetIdentityId());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        return "AWSS3StorageListOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + '}';
    }

    public static final class Builder extends StorageListOptions.Builder {
        public AWSS3StorageListOptions build() {
            return new AWSS3StorageListOptions(this, null);
        }
    }

    public /* synthetic */ AWSS3StorageListOptions(Builder builder, 1 r2) {
        this(builder);
    }
}
