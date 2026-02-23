package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Celebrity extends Feature {

    public static final class Builder extends Feature.Builder {
        public Celebrity build() {
            return new Celebrity(this, null);
        }

        public Builder name(String str) {
            return (Builder) super.value(str);
        }
    }

    private Celebrity(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return (String) getValue();
    }

    public String getTypeAlias() {
        return FeatureType.CELEBRITY.getAlias();
    }

    public /* synthetic */ Celebrity(Builder builder, 1 r2) {
        this(builder);
    }
}
