package com.amplifyframework.datastore.events;

import O.c;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.hub.HubEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ModelSyncedEvent implements HubEvent.Data {
    private final int added;
    private final int deleted;
    private final boolean isDeltaSync;
    private final boolean isFullSync;
    private final String model;
    private final int updated;

    public ModelSyncedEvent(String str, boolean z, int i, int i2, int i3) {
        this.added = i;
        this.updated = i2;
        this.deleted = i3;
        this.model = str;
        this.isFullSync = z;
        this.isDeltaSync = !z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelSyncedEvent.class != obj.getClass()) {
            return false;
        }
        ModelSyncedEvent modelSyncedEvent = (ModelSyncedEvent) obj;
        if (c.a(this.model, modelSyncedEvent.model) && c.a(Boolean.valueOf(this.isFullSync), Boolean.valueOf(modelSyncedEvent.isFullSync)) && c.a(Boolean.valueOf(this.isDeltaSync), Boolean.valueOf(modelSyncedEvent.isDeltaSync)) && c.a(Integer.valueOf(this.added), Integer.valueOf(modelSyncedEvent.added)) && c.a(Integer.valueOf(this.updated), Integer.valueOf(modelSyncedEvent.updated))) {
            return c.a(Integer.valueOf(this.deleted), Integer.valueOf(modelSyncedEvent.deleted));
        }
        return false;
    }

    public int getAdded() {
        return this.added;
    }

    public int getDeleted() {
        return this.deleted;
    }

    public String getModel() {
        return this.model;
    }

    public int getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        String str = this.model;
        return ((((((((((str != null ? str.hashCode() : 0) * 31) + Boolean.valueOf(this.isFullSync).hashCode()) * 31) + Boolean.valueOf(this.isDeltaSync).hashCode()) * 31) + this.added) * 31) + this.updated) * 31) + this.deleted;
    }

    public boolean isDeltaSync() {
        return this.isDeltaSync;
    }

    public boolean isFullSync() {
        return this.isFullSync;
    }

    public HubEvent toHubEvent() {
        return HubEvent.create(DataStoreChannelEventName.MODEL_SYNCED, this);
    }

    public String toString() {
        return "ModelSyncedEvent{model=" + this.model + ", isFullSync=" + this.isFullSync + ", isDeltaSync=" + this.isDeltaSync + ", added=" + this.added + ", updated=" + this.updated + ", deleted=" + this.deleted + '}';
    }
}
