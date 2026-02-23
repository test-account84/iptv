package com.amplifyframework.geo.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GeoSearchResult {
    private final List places;

    private GeoSearchResult(List list) {
        this.places = list;
    }

    public static GeoSearchResult withPlaces(List list) {
        Objects.requireNonNull(list);
        return new GeoSearchResult(list);
    }

    public List getPlaces() {
        return Immutable.of(this.places);
    }
}
