package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.predictions.models.Feature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ImageFeature extends Feature {
    private final RectF box;
    private final Polygon polygon;

    public static abstract class Builder extends Feature.Builder {
        private RectF box;
        private Polygon polygon;

        public Builder box(RectF rectF) {
            this.box = rectF;
            return this;
        }

        public RectF getBox() {
            return this.box;
        }

        public Polygon getPolygon() {
            return this.polygon;
        }

        public Builder polygon(Polygon polygon) {
            this.polygon = polygon;
            return this;
        }
    }

    public ImageFeature(Builder builder) {
        super(builder);
        this.box = builder.getBox();
        this.polygon = builder.getPolygon();
    }

    public RectF getBox() {
        return this.box;
    }

    public Polygon getPolygon() {
        return this.polygon;
    }
}
