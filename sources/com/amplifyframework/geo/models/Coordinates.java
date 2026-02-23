package com.amplifyframework.geo.models;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Coordinates implements Geometry {
    private double latitude;
    private double longitude;

    public Coordinates() {
        this(0.0d, 0.0d);
    }

    public double centralAngle(Coordinates coordinates) {
        double radians = Math.toRadians(this.latitude - coordinates.latitude);
        double d = radians / 2.0d;
        double radians2 = Math.toRadians(this.longitude - coordinates.longitude) / 2.0d;
        double sin = (Math.sin(d) * Math.sin(d)) + (Math.sin(radians2) * Math.sin(radians2) * Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(coordinates.latitude)));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Coordinates.class != obj.getClass()) {
            return false;
        }
        Coordinates coordinates = (Coordinates) obj;
        return c.a(Double.valueOf(this.latitude), Double.valueOf(coordinates.latitude)) && c.a(Double.valueOf(this.longitude), Double.valueOf(coordinates.longitude));
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return c.b(Double.valueOf(this.latitude), Double.valueOf(this.longitude));
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public String toString() {
        return "Coordinates{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }

    public Coordinates(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }
}
