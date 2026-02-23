package com.amplifyframework.storage.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageRemoveOptions extends StorageOptions {

    public static class Builder extends StorageOptions.Builder {
        @SuppressLint({"SyntheticAccessor"})
        public StorageRemoveOptions build() {
            return new StorageRemoveOptions(this);
        }
    }

    public StorageRemoveOptions(Builder builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static StorageRemoveOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(StorageRemoveOptions storageRemoveOptions) {
        return (Builder) ((Builder) builder().accessLevel(storageRemoveOptions.getAccessLevel())).targetIdentityId(storageRemoveOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageRemoveOptions)) {
            return false;
        }
        StorageRemoveOptions storageRemoveOptions = (StorageRemoveOptions) obj;
        return c.a(getAccessLevel(), storageRemoveOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageRemoveOptions.getTargetIdentityId());
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        return "StorageRemoveOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + '}';
    }
}
