package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.TextFeature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Syntax extends TextFeature {

    public static final class Builder extends TextFeature.Builder {
        public Syntax build() {
            return new Syntax(this, null);
        }
    }

    private Syntax(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTypeAlias() {
        return FeatureType.SYNTAX.getAlias();
    }

    public /* synthetic */ Syntax(Builder builder, 1 r2) {
        this(builder);
    }
}
