package com.amplifyframework.hub;

import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SubscriptionToken {
    private final UUID uuid;

    private SubscriptionToken(UUID uuid) {
        this.uuid = uuid;
    }

    public static SubscriptionToken create() {
        return new SubscriptionToken(UUID.randomUUID());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SubscriptionToken.class != obj.getClass()) {
            return false;
        }
        return O.c.a(this.uuid, ((SubscriptionToken) obj).uuid);
    }

    public int hashCode() {
        UUID uuid = this.uuid;
        if (uuid != null) {
            return uuid.hashCode();
        }
        return 0;
    }
}
