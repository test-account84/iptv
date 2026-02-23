package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CelebrityDetails {
    private final RectF box;
    private final Celebrity celebrity;
    private final List landmarks;
    private final Polygon polygon;
    private final Pose pose;
    private final List urls;

    public static final class Builder {
        private RectF box;
        private Celebrity celebrity;
        private List landmarks;
        private Polygon polygon;
        private Pose pose;
        private List urls;

        private Builder() {
            this.landmarks = Collections.emptyList();
            this.urls = Collections.emptyList();
        }

        public Builder box(RectF rectF) {
            this.box = rectF;
            return this;
        }

        public CelebrityDetails build() {
            return new CelebrityDetails(this, null);
        }

        public Builder celebrity(Celebrity celebrity) {
            Objects.requireNonNull(celebrity);
            this.celebrity = celebrity;
            return this;
        }

        public RectF getBox() {
            return this.box;
        }

        public Celebrity getCelebrity() {
            Celebrity celebrity = this.celebrity;
            Objects.requireNonNull(celebrity);
            return celebrity;
        }

        public List getLandmarks() {
            List list = this.landmarks;
            Objects.requireNonNull(list);
            return list;
        }

        public Polygon getPolygon() {
            return this.polygon;
        }

        public Pose getPose() {
            return this.pose;
        }

        public List getUrls() {
            List list = this.urls;
            Objects.requireNonNull(list);
            return list;
        }

        public Builder landmarks(List list) {
            Objects.requireNonNull(list);
            this.landmarks = list;
            return this;
        }

        public Builder polygon(Polygon polygon) {
            this.polygon = polygon;
            return this;
        }

        public Builder pose(Pose pose) {
            this.pose = pose;
            return this;
        }

        public Builder urls(List list) {
            Objects.requireNonNull(list);
            this.urls = list;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private CelebrityDetails(Builder builder) {
        this.celebrity = builder.getCelebrity();
        this.box = builder.getBox();
        this.polygon = builder.getPolygon();
        this.pose = builder.getPose();
        this.landmarks = builder.getLandmarks();
        this.urls = builder.getUrls();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public RectF getBox() {
        return this.box;
    }

    public Celebrity getCelebrity() {
        return this.celebrity;
    }

    public List getLandmarks() {
        return Immutable.of(this.landmarks);
    }

    public Polygon getPolygon() {
        return this.polygon;
    }

    public Pose getPose() {
        return this.pose;
    }

    public List getUrls() {
        return Immutable.of(this.urls);
    }

    public /* synthetic */ CelebrityDetails(Builder builder, 1 r2) {
        this(builder);
    }
}
