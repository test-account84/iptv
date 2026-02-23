package com.amplifyframework.core.category;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum CategoryType {
    ANALYTICS("analytics"),
    API("api"),
    AUTH("auth"),
    DATASTORE("dataStore"),
    HUB("hub"),
    LOGGING("logging"),
    PREDICTIONS("predictions"),
    STORAGE("storage"),
    GEO("geo");

    private final String configurationKey;

    CategoryType(String str) {
        this.configurationKey = str;
    }

    public String getConfigurationKey() {
        return this.configurationKey;
    }

    public String toString() {
        return this.configurationKey;
    }
}
