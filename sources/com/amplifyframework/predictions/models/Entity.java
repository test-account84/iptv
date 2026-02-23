package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.TextFeature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Entity extends TextFeature {

    public static final class Builder extends TextFeature.Builder {
        public Entity build() {
            return new Entity(this, null);
        }
    }

    private Entity(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTypeAlias() {
        return FeatureType.ENTITY.getAlias();
    }

    public /* synthetic */ Entity(Builder builder, 1 r2) {
        this(builder);
    }
}
