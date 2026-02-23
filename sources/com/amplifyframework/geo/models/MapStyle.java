package com.amplifyframework.geo.models;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class MapStyle {
    private final String mapName;
    private final String style;

    public MapStyle(String str, String str2) {
        Objects.requireNonNull(str);
        this.mapName = str;
        Objects.requireNonNull(str2);
        this.style = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MapStyle.class != obj.getClass()) {
            return false;
        }
        MapStyle mapStyle = (MapStyle) obj;
        return c.a(this.mapName, mapStyle.mapName) && c.a(this.style, mapStyle.style);
    }

    public String getMapName() {
        return this.mapName;
    }

    public String getStyle() {
        return this.style;
    }

    public int hashCode() {
        return c.b(this.mapName, this.style);
    }

    public String toString() {
        return "MapStyle{mapName='" + this.mapName + "', style='" + this.style + "'}";
    }
}
