package com.amplifyframework.geo.models;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SearchArea {
    private final Coordinates biasPosition;
    private final BoundingBox boundingBox;

    private SearchArea(BoundingBox boundingBox, Coordinates coordinates) {
        this.boundingBox = boundingBox;
        this.biasPosition = coordinates;
    }

    public static SearchArea near(Coordinates coordinates) {
        Objects.requireNonNull(coordinates);
        return new SearchArea(null, coordinates);
    }

    public static SearchArea within(BoundingBox boundingBox) {
        Objects.requireNonNull(boundingBox);
        return new SearchArea(boundingBox, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SearchArea.class != obj.getClass()) {
            return false;
        }
        SearchArea searchArea = (SearchArea) obj;
        return c.a(this.boundingBox, searchArea.boundingBox) && c.a(this.biasPosition, searchArea.biasPosition);
    }

    public Coordinates getBiasPosition() {
        return this.biasPosition;
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public int hashCode() {
        return c.b(this.boundingBox, this.biasPosition);
    }

    public String toString() {
        return "SearchArea{boundingBox=" + this.boundingBox + ", biasPosition=" + this.biasPosition + '}';
    }
}
