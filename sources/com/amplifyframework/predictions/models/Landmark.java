package com.amplifyframework.predictions.models;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Landmark {
    private final List points;
    private final LandmarkType type;

    public Landmark(LandmarkType landmarkType, List list) {
        Objects.requireNonNull(landmarkType);
        this.type = landmarkType;
        Objects.requireNonNull(list);
        this.points = list;
    }

    public List getPoints() {
        return Immutable.of(this.points);
    }

    public LandmarkType getType() {
        return this.type;
    }
}
