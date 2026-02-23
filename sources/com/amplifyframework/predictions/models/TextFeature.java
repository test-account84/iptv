package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.Feature;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class TextFeature extends Feature {
    private final int length;
    private final int startIndex;
    private final String targetText;

    public static abstract class Builder extends Feature.Builder {
        private int startIndex;
        private String targetText;

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getTargetText() {
            String str = this.targetText;
            Objects.requireNonNull(str);
            return str;
        }

        public final Builder startIndex(int i) {
            this.startIndex = i;
            return this;
        }

        public final Builder targetText(String str) {
            Objects.requireNonNull(str);
            this.targetText = str;
            return this;
        }
    }

    public TextFeature(Builder builder) {
        super(builder);
        String targetText = builder.getTargetText();
        this.targetText = targetText;
        this.startIndex = builder.getStartIndex();
        this.length = targetText.length();
    }

    public int getLength() {
        return this.length;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public final String getTargetText() {
        return this.targetText;
    }
}
