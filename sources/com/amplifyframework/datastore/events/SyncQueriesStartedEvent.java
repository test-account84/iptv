package com.amplifyframework.datastore.events;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SyncQueriesStartedEvent {
    private final String[] models;

    public SyncQueriesStartedEvent(String[] strArr) {
        this.models = (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SyncQueriesStartedEvent.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.models, ((SyncQueriesStartedEvent) obj).models);
    }

    public String[] getModels() {
        return this.models;
    }

    public int hashCode() {
        return Arrays.hashCode(this.models);
    }

    public String toString() {
        return "SyncQueriesStartedEvent{models=" + Arrays.toString(this.models) + '}';
    }
}
