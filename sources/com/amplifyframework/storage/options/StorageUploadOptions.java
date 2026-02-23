package com.amplifyframework.storage.options;

import O.c;
import com.amplifyframework.storage.options.StorageOptions;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class StorageUploadOptions extends StorageOptions {
    private final String contentType;
    private final Map metadata;

    public static abstract class Builder extends StorageOptions.Builder {
        private String contentType;
        private Map metadata = new HashMap();

        public final Builder contentType(String str) {
            this.contentType = str;
            return this;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final Map getMetadata() {
            return Immutable.of(this.metadata);
        }

        public final Builder metadata(Map map) {
            Objects.requireNonNull(map);
            this.metadata = new HashMap(map);
            return this;
        }
    }

    public StorageUploadOptions(Builder builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
        this.contentType = builder.getContentType();
        this.metadata = builder.getMetadata();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageUploadOptions)) {
            return false;
        }
        StorageUploadOptions storageUploadOptions = (StorageUploadOptions) obj;
        return c.a(getAccessLevel(), storageUploadOptions.getAccessLevel()) && c.a(getTargetIdentityId(), storageUploadOptions.getTargetIdentityId()) && c.a(getContentType(), storageUploadOptions.getContentType()) && c.a(getMetadata(), storageUploadOptions.getMetadata());
    }

    public String getContentType() {
        return this.contentType;
    }

    public Map getMetadata() {
        return Immutable.of(this.metadata);
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), getContentType(), getMetadata());
    }

    public String toString() {
        return "StorageUploadOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", metadata=" + getMetadata() + '}';
    }
}
