package com.amplifyframework.predictions.models;

import j$.util.Objects;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class Feature implements Comparable {
    private final float confidence;
    private final String id;
    private final Object value;

    public static abstract class Builder {
        private float confidence;
        private String id = UUID.randomUUID().toString();
        private Object value;

        public abstract Feature build();

        public final Builder confidence(float f) {
            this.confidence = f;
            return this;
        }

        public final float getConfidence() {
            return this.confidence;
        }

        public final String getId() {
            String str = this.id;
            Objects.requireNonNull(str);
            return str;
        }

        public final Object getValue() {
            Object obj = this.value;
            Objects.requireNonNull(obj);
            return obj;
        }

        public final Builder id(String str) {
            Objects.requireNonNull(str);
            this.id = str;
            return this;
        }

        public final Builder value(Object obj) {
            Objects.requireNonNull(obj);
            this.value = obj;
            return this;
        }
    }

    public Feature(Builder builder) {
        this.id = builder.getId();
        this.value = builder.getValue();
        this.confidence = builder.getConfidence();
    }

    public int compareTo(Feature feature) {
        if (feature == null) {
            return -1;
        }
        int compareToIgnoreCase = getTypeAlias().compareToIgnoreCase(feature.getTypeAlias());
        return compareToIgnoreCase != 0 ? compareToIgnoreCase : (int) Math.signum(getConfidence() - feature.getConfidence());
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final String getId() {
        return this.id;
    }

    public abstract String getTypeAlias();

    public final Object getValue() {
        return this.value;
    }
}
