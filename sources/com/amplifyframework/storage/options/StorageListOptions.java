package com.amplifyframework.storage.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageListOptions extends StorageOptions {

    public static class Builder extends StorageOptions.Builder {
        @SuppressLint({"SyntheticAccessor"})
        public StorageListOptions build() {
            return new StorageListOptions(this);
        }
    }

    public StorageListOptions(Builder builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static StorageListOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(StorageListOptions storageListOptions) {
        return (Builder) ((Builder) builder().accessLevel(storageListOptions.getAccessLevel())).targetIdentityId(storageListOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageListOptions)) {
            return false;
        }
        StorageListOptions storageListOptions = (StorageListOptions) obj;
        return c.a(getAccessLevel(), storageListOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageListOptions.getTargetIdentityId());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        return "StorageListOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + '}';
    }
}
