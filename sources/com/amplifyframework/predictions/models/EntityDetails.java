package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class EntityDetails {
    private final AgeRange ageRange;
    private final RectF box;
    private final List emotions;
    private final List features;
    private final Gender gender;
    private final List landmarks;
    private final Polygon polygon;
    private final Pose pose;

    public static final class Builder {
        private AgeRange ageRange;
        private RectF box;
        private List emotions;
        private List features;
        private Gender gender;
        private List landmarks;
        private Polygon polygon;
        private Pose pose;

        private Builder() {
            this.landmarks = Collections.emptyList();
            this.emotions = Collections.emptyList();
            this.features = Collections.emptyList();
        }

        public Builder ageRange(AgeRange ageRange) {
            this.ageRange = ageRange;
            return this;
        }

        public Builder box(RectF rectF) {
            this.box = rectF;
            return this;
        }

        public EntityDetails build() {
            return new EntityDetails(this, null);
        }

        public Builder emotions(List list) {
            Objects.requireNonNull(list);
            this.emotions = list;
            return this;
        }

        public Builder features(List list) {
            Objects.requireNonNull(list);
            this.features = list;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public AgeRange getAgeRange() {
            return this.ageRange;
        }

        public RectF getBox() {
            return this.box;
        }

        public List getEmotions() {
            List list = this.emotions;
            Objects.requireNonNull(list);
            return list;
        }

        public Gender getGender() {
            return this.gender;
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

        public List getValues() {
            List list = this.features;
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

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private EntityDetails(Builder builder) {
        this.box = builder.getBox();
        this.polygon = builder.getPolygon();
        this.ageRange = builder.getAgeRange();
        this.pose = builder.getPose();
        this.gender = builder.getGender();
        this.landmarks = builder.getLandmarks();
        this.emotions = builder.getEmotions();
        this.features = builder.getValues();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public AgeRange getAgeRange() {
        return this.ageRange;
    }

    public RectF getBox() {
        return this.box;
    }

    public List getEmotions() {
        return Immutable.of(this.emotions);
    }

    public Gender getGender() {
        return this.gender;
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

    public List getValues() {
        return Immutable.of(this.features);
    }

    public /* synthetic */ EntityDetails(Builder builder, 1 r2) {
        this(builder);
    }
}
