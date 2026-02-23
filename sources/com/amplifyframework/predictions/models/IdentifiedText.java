package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.ImageFeature;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifiedText extends ImageFeature {
    private final int page;

    public static final class Builder extends ImageFeature.Builder {
        private int page;

        public int getPage() {
            return this.page;
        }

        public Builder page(int i) {
            this.page = i;
            return this;
        }

        public Builder text(String str) {
            Objects.requireNonNull(str);
            return (Builder) super.value(str);
        }

        public IdentifiedText build() {
            return new IdentifiedText(this, null);
        }
    }

    private IdentifiedText(Builder builder) {
        super(builder);
        this.page = builder.getPage();
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getPage() {
        return this.page;
    }

    public String getText() {
        return (String) getValue();
    }

    public String getTypeAlias() {
        return FeatureType.IDENTIFIED_TEXT.getAlias();
    }

    public /* synthetic */ IdentifiedText(Builder builder, 1 r2) {
        this(builder);
    }
}
