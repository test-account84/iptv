package com.amplifyframework.geo.models;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class MapStyleDescriptor {
    private final String json;

    public MapStyleDescriptor(String str) {
        Objects.requireNonNull(str);
        this.json = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MapStyleDescriptor.class != obj.getClass()) {
            return false;
        }
        return c.a(this.json, ((MapStyleDescriptor) obj).json);
    }

    public String getJson() {
        return this.json;
    }

    public int hashCode() {
        return c.b(this.json);
    }

    public String toString() {
        return "MapStyleDescriptor{json='" + this.json + "'}";
    }
}
