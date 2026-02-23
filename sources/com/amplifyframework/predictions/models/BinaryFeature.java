package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class BinaryFeature extends Feature {
    private final String type;

    public static final class Builder extends Feature.Builder {
        private String type;

        public BinaryFeature build() {
            return new BinaryFeature(this, null);
        }

        public String getType() {
            String str = this.type;
            Objects.requireNonNull(str);
            return str;
        }

        public Builder type(String str) {
            Objects.requireNonNull(str);
            this.type = str;
            return this;
        }
    }

    private BinaryFeature(Builder builder) {
        super(builder);
        this.type = builder.getType();
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTypeAlias() {
        return this.type;
    }

    public /* synthetic */ BinaryFeature(Builder builder, 1 r2) {
        this(builder);
    }
}
