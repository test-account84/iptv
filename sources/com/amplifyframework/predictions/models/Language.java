package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Language extends Feature {

    public static final class Builder extends Feature.Builder {
        public Language build() {
            return new Language(this, null);
        }
    }

    private Language(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTypeAlias() {
        return FeatureType.LANGUAGE.getAlias();
    }

    public /* synthetic */ Language(Builder builder, 1 r2) {
        this(builder);
    }
}
