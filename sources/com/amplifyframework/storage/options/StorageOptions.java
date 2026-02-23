package com.amplifyframework.storage.options;

import com.amplifyframework.storage.StorageAccessLevel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
abstract class StorageOptions {
    private final StorageAccessLevel accessLevel;
    private final String targetIdentityId;

    public static abstract class Builder {
        private StorageAccessLevel accessLevel;
        private String targetIdentityId;

        public Builder accessLevel(StorageAccessLevel storageAccessLevel) {
            this.accessLevel = storageAccessLevel;
            return this;
        }

        public abstract StorageOptions build();

        public final StorageAccessLevel getAccessLevel() {
            return this.accessLevel;
        }

        public final String getTargetIdentityId() {
            return this.targetIdentityId;
        }

        public Builder targetIdentityId(String str) {
            this.targetIdentityId = str;
            return this;
        }
    }

    public StorageOptions(StorageAccessLevel storageAccessLevel, String str) {
        this.accessLevel = storageAccessLevel;
        this.targetIdentityId = str;
    }

    public StorageAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public String getTargetIdentityId() {
        return this.targetIdentityId;
    }
}
