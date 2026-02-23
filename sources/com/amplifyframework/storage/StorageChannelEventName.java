package com.amplifyframework.storage;

import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum StorageChannelEventName {
    UPLOAD_ERROR("upload_error"),
    UPLOAD_STATE("upload_state"),
    DOWNLOAD_ERROR("download_error"),
    DOWNLOAD_STATE("download_state");

    private final String hubEventName;

    StorageChannelEventName(String str) {
        Objects.requireNonNull(str);
        this.hubEventName = str;
    }

    public static StorageChannelEventName fromString(String str) {
        for (StorageChannelEventName storageChannelEventName : values()) {
            if (storageChannelEventName.toString().equals(str)) {
                return storageChannelEventName;
            }
        }
        throw new IllegalArgumentException("Storage category does not publish any Hub event with name = " + str);
    }

    public String toString() {
        return this.hubEventName;
    }
}
