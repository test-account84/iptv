package com.amplifyframework.geo.models;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class BoundingBox {
    private final double latitudeNE;
    private final double latitudeSW;
    private final double longitudeNE;
    private final double longitudeSW;

    public BoundingBox(double d, double d2, double d3, double d4) {
        this.latitudeSW = d;
        this.longitudeSW = d2;
        this.latitudeNE = d3;
        this.longitudeNE = d4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BoundingBox.class != obj.getClass()) {
            return false;
        }
        BoundingBox boundingBox = (BoundingBox) obj;
        return c.a(Double.valueOf(this.latitudeSW), Double.valueOf(boundingBox.latitudeSW)) && c.a(Double.valueOf(this.longitudeSW), Double.valueOf(boundingBox.longitudeSW)) && c.a(Double.valueOf(this.latitudeNE), Double.valueOf(boundingBox.latitudeNE)) && c.a(Double.valueOf(this.longitudeNE), Double.valueOf(boundingBox.longitudeNE));
    }

    public double getLatitudeNE() {
        return this.latitudeNE;
    }

    public double getLatitudeSW() {
        return this.latitudeSW;
    }

    public double getLongitudeNE() {
        return this.longitudeNE;
    }

    public double getLongitudeSW() {
        return this.longitudeSW;
    }

    public int hashCode() {
        return c.b(Double.valueOf(this.latitudeSW), Double.valueOf(this.longitudeSW), Double.valueOf(this.latitudeNE), Double.valueOf(this.longitudeNE));
    }

    public String toString() {
        return "BoundingBox{latitudeSW=" + this.latitudeSW + ", longitudeSW=" + this.longitudeSW + ", latitudeNE=" + this.latitudeNE + ", longitudeNE=" + this.longitudeNE + '}';
    }

    public BoundingBox(Coordinates coordinates, Coordinates coordinates2) {
        this(coordinates.getLatitude(), coordinates.getLongitude(), coordinates2.getLatitude(), coordinates2.getLongitude());
    }
}
