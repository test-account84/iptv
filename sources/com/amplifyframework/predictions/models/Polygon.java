package com.amplifyframework.predictions.models;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Polygon {
    private static final int MINIMUM_POINTS_REQUIRED = 3;
    private final List points;

    private Polygon(List list) {
        this.points = list;
    }

    public static Polygon fromPoints(List list) {
        Objects.requireNonNull(list);
        if (list.size() >= 3) {
            return new Polygon(list);
        }
        throw new IllegalArgumentException("A polygon must contain at least three points.");
    }

    public List getPoints() {
        return Immutable.of(this.points);
    }
}
