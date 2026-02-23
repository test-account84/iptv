package com.amplifyframework.geo.models;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Place {
    private final Geometry geometry;

    public Place(Geometry geometry) {
        this.geometry = geometry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.geometry, ((Place) obj).geometry);
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public int hashCode() {
        return c.b(this.geometry);
    }

    public String toString() {
        return "Place{geometry=" + this.geometry + '}';
    }
}
