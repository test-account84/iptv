package com.amplifyframework.storage.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageDownloadFileOptions extends StorageOptions {

    public static class Builder extends StorageOptions.Builder {
        @SuppressLint({"SyntheticAccessor"})
        public StorageDownloadFileOptions build() {
            return new StorageDownloadFileOptions(this);
        }
    }

    public StorageDownloadFileOptions(Builder builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static StorageDownloadFileOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(StorageDownloadFileOptions storageDownloadFileOptions) {
        return (Builder) ((Builder) builder().accessLevel(storageDownloadFileOptions.getAccessLevel())).targetIdentityId(storageDownloadFileOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageDownloadFileOptions)) {
            return false;
        }
        StorageDownloadFileOptions storageDownloadFileOptions = (StorageDownloadFileOptions) obj;
        return c.a(getAccessLevel(), storageDownloadFileOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageDownloadFileOptions.getTargetIdentityId());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        return "StorageDownloadFileOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + '}';
    }
}
