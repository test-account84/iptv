package com.amplifyframework.hub;

import j$.util.Objects;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class HubEvent {
    private final Object data;
    private final String name;
    private final UUID uuid = UUID.randomUUID();

    public interface Data {
        HubEvent toHubEvent();
    }

    private HubEvent(String str, Object obj) {
        this.name = str;
        this.data = obj;
    }

    public static HubEvent create(Enum r2) {
        Objects.requireNonNull(r2);
        return new HubEvent(r2.toString(), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HubEvent.class != obj.getClass()) {
            return false;
        }
        HubEvent hubEvent = (HubEvent) obj;
        if (O.c.a(this.name, hubEvent.name) && O.c.a(this.data, hubEvent.data)) {
            return O.c.a(this.uuid, hubEvent.uuid);
        }
        return false;
    }

    public Object getData() {
        return this.data;
    }

    public UUID getId() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.data;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        UUID uuid = this.uuid;
        return hashCode2 + (uuid != null ? uuid.hashCode() : 0);
    }

    public String toString() {
        return "HubEvent{name='" + this.name + "', data=" + this.data + ", uuid=" + this.uuid + '}';
    }

    public static HubEvent create(Enum r1, Object obj) {
        Objects.requireNonNull(r1);
        Objects.requireNonNull(obj);
        return new HubEvent(r1.toString(), obj);
    }

    public static HubEvent create(String str) {
        return new HubEvent(str, null);
    }

    public static HubEvent create(String str, Object obj) {
        return new HubEvent(str, obj);
    }
}
