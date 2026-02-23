package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.TextFeature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class KeyPhrase extends TextFeature {

    public static final class Builder extends TextFeature.Builder {
        public KeyPhrase build() {
            return new KeyPhrase(this, null);
        }
    }

    private KeyPhrase(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTypeAlias() {
        return FeatureType.KEY_PHRASE.getAlias();
    }

    public /* synthetic */ KeyPhrase(Builder builder, 1 r2) {
        this(builder);
    }
}
