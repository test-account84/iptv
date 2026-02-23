package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.ImageFeature;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class EntityMatch extends ImageFeature {

    public static final class Builder extends ImageFeature.Builder {
        public EntityMatch build() {
            return new EntityMatch(this, null);
        }

        public Builder externalImageId(String str) {
            Objects.requireNonNull(str);
            return (Builder) value(str);
        }
    }

    private EntityMatch(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getExternalImageId() {
        return (String) getValue();
    }

    public String getTypeAlias() {
        return FeatureType.ENTITY_MATCH.getAlias();
    }

    public /* synthetic */ EntityMatch(Builder builder, 1 r2) {
        this(builder);
    }
}
