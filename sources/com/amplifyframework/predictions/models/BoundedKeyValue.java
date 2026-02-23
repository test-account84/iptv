package com.amplifyframework.predictions.models;

import O.d;
import com.amplifyframework.predictions.models.ImageFeature;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class BoundedKeyValue extends ImageFeature {

    public static final class Builder extends ImageFeature.Builder {
        public BoundedKeyValue build() {
            Objects.requireNonNull(getValue());
            Objects.requireNonNull(((d) getValue()).a);
            Objects.requireNonNull(((d) getValue()).b);
            return new BoundedKeyValue(this, null);
        }

        public Builder keyValuePair(String str, String str2) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(str2);
            return (Builder) value(d.a(str, str2));
        }
    }

    private BoundedKeyValue(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getKey() {
        return (String) ((d) getValue()).a;
    }

    public String getKeyValue() {
        return (String) ((d) getValue()).b;
    }

    public String getTypeAlias() {
        return FeatureType.BOUNDED_KEY_VALUE.getAlias();
    }

    public /* synthetic */ BoundedKeyValue(Builder builder, 1 r2) {
        this(builder);
    }
}
