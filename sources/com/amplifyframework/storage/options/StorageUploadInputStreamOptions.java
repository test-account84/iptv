package com.amplifyframework.storage.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageUploadOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageUploadInputStreamOptions extends StorageUploadOptions {

    public static class Builder extends StorageUploadOptions.Builder {
        @SuppressLint({"SyntheticAccessor"})
        public StorageUploadInputStreamOptions build() {
            return new StorageUploadInputStreamOptions(this);
        }
    }

    public StorageUploadInputStreamOptions(Builder builder) {
        super(builder);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder builder() {
        return new Builder();
    }

    public static StorageUploadInputStreamOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(StorageUploadInputStreamOptions storageUploadInputStreamOptions) {
        return (Builder) ((Builder) ((Builder) ((Builder) builder().accessLevel(storageUploadInputStreamOptions.getAccessLevel())).targetIdentityId(storageUploadInputStreamOptions.getTargetIdentityId())).contentType(storageUploadInputStreamOptions.getContentType())).metadata(storageUploadInputStreamOptions.getMetadata());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageUploadInputStreamOptions)) {
            return false;
        }
        StorageUploadInputStreamOptions storageUploadInputStreamOptions = (StorageUploadInputStreamOptions) obj;
        return c.a(getAccessLevel(), storageUploadInputStreamOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageUploadInputStreamOptions.getTargetIdentityId()) && c.a(getContentType(), storageUploadInputStreamOptions.getContentType()) && c.a(getMetadata(), storageUploadInputStreamOptions.getMetadata());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), getContentType(), getMetadata());
    }

    public String toString() {
        return "StorageUploadInputStreamOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", metadata=" + getMetadata() + '}';
    }
}
