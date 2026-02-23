package com.amplifyframework.storage.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageUploadOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageUploadFileOptions extends StorageUploadOptions {

    public static class Builder extends StorageUploadOptions.Builder {
        @SuppressLint({"SyntheticAccessor"})
        public StorageUploadFileOptions build() {
            return new StorageUploadFileOptions(this);
        }
    }

    public StorageUploadFileOptions(Builder builder) {
        super(builder);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder builder() {
        return new Builder();
    }

    public static StorageUploadFileOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(StorageUploadFileOptions storageUploadFileOptions) {
        return (Builder) ((Builder) ((Builder) ((Builder) builder().accessLevel(storageUploadFileOptions.getAccessLevel())).targetIdentityId(storageUploadFileOptions.getTargetIdentityId())).contentType(storageUploadFileOptions.getContentType())).metadata(storageUploadFileOptions.getMetadata());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageUploadFileOptions)) {
            return false;
        }
        StorageUploadFileOptions storageUploadFileOptions = (StorageUploadFileOptions) obj;
        return c.a(getAccessLevel(), storageUploadFileOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageUploadFileOptions.getTargetIdentityId()) && c.a(getContentType(), storageUploadFileOptions.getContentType()) && c.a(getMetadata(), storageUploadFileOptions.getMetadata());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), getContentType(), getMetadata());
    }

    public String toString() {
        return "StorageUploadFileOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", metadata=" + getMetadata() + '}';
    }
}
