package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.ImageFeature;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Label extends ImageFeature {
    public static final String FEATURE_TYPE = "Label";
    private final List boxes;
    private final List parentLabels;

    public static final class Builder extends ImageFeature.Builder {
        private List boxes;
        private List parentLabels;

        private Builder() {
            this.parentLabels = new ArrayList();
            this.boxes = new ArrayList();
        }

        public Builder boxes(List list) {
            Objects.requireNonNull(list);
            this.boxes = list;
            return this;
        }

        public List getBoxes() {
            List of = Immutable.of(this.boxes);
            Objects.requireNonNull(of);
            return of;
        }

        public List getParentLabels() {
            List of = Immutable.of(this.parentLabels);
            Objects.requireNonNull(of);
            return of;
        }

        public Builder name(String str) {
            return (Builder) super.value(str);
        }

        public Builder parentLabels(List list) {
            Objects.requireNonNull(list);
            this.parentLabels = list;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }

        public Label build() {
            return new Label(this, null);
        }
    }

    private Label(Builder builder) {
        super(builder);
        this.parentLabels = builder.getParentLabels();
        this.boxes = builder.getBoxes();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public List getBoxes() {
        return this.boxes;
    }

    public String getName() {
        return (String) getValue();
    }

    public List getParentLabels() {
        return this.parentLabels;
    }

    public String getTypeAlias() {
        return FEATURE_TYPE;
    }

    public /* synthetic */ Label(Builder builder, 1 r2) {
        this(builder);
    }
}
