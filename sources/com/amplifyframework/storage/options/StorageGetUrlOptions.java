package com.amplifyframework.storage.options;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageGetUrlOptions extends StorageOptions {
    private final int expires;

    public static class Builder extends StorageOptions.Builder {
        private int expires;

        @SuppressLint({"SyntheticAccessor"})
        public StorageGetUrlOptions build() {
            return new StorageGetUrlOptions(this);
        }

        public final Builder expires(int i) {
            this.expires = i;
            return this;
        }

        public final int getExpires() {
            return this.expires;
        }
    }

    public StorageGetUrlOptions(Builder builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
        this.expires = builder.getExpires();
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder builder() {
        return new Builder();
    }

    public static StorageGetUrlOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(StorageGetUrlOptions storageGetUrlOptions) {
        return ((Builder) ((Builder) builder().accessLevel(storageGetUrlOptions.getAccessLevel())).targetIdentityId(storageGetUrlOptions.getTargetIdentityId())).expires(storageGetUrlOptions.getExpires());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageGetUrlOptions)) {
            return false;
        }
        StorageGetUrlOptions storageGetUrlOptions = (StorageGetUrlOptions) obj;
        return c.a(getAccessLevel(), storageGetUrlOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageGetUrlOptions.getTargetIdentityId()) && c.a(Integer.valueOf(getExpires()), Integer.valueOf(storageGetUrlOptions.getExpires()));
    }

    public int getExpires() {
        return this.expires;
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), Integer.valueOf(getExpires()));
    }

    public String toString() {
        return "StorageGetUrlOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", expires=" + getExpires() + '}';
    }
}
