package com.amplifyframework.predictions.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifyTextResult implements IdentifyResult {
    private final String fullText;
    private final List lines;
    private final List rawLineText;
    private final List words;

    public static final class Builder {
        private String fullText;
        private List lines;
        private List rawLineText;
        private List words;

        public IdentifyTextResult build() {
            return new IdentifyTextResult(this, null);
        }

        public Builder fullText(String str) {
            Objects.requireNonNull(str);
            this.fullText = str;
            return this;
        }

        public String getFullText() {
            String str = this.fullText;
            Objects.requireNonNull(str);
            return str;
        }

        public List getLines() {
            List list = this.lines;
            Objects.requireNonNull(list);
            return list;
        }

        public List getRawLineText() {
            List list = this.rawLineText;
            Objects.requireNonNull(list);
            return list;
        }

        public List getWords() {
            List list = this.words;
            Objects.requireNonNull(list);
            return list;
        }

        public Builder lines(List list) {
            Objects.requireNonNull(list);
            this.lines = list;
            return this;
        }

        public Builder rawLineText(List list) {
            Objects.requireNonNull(list);
            this.rawLineText = list;
            return this;
        }

        public Builder words(List list) {
            Objects.requireNonNull(list);
            this.words = list;
            return this;
        }
    }

    private IdentifyTextResult(Builder builder) {
        this.fullText = builder.getFullText();
        this.rawLineText = builder.getRawLineText();
        this.words = builder.getWords();
        this.lines = builder.getLines();
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFullText() {
        return this.fullText;
    }

    public List getLines() {
        return Immutable.of(this.lines);
    }

    public List getRawLineText() {
        return Immutable.of(this.rawLineText);
    }

    public List getWords() {
        return Immutable.of(this.words);
    }

    public /* synthetic */ IdentifyTextResult(Builder builder, 1 r2) {
        this(builder);
    }
}
