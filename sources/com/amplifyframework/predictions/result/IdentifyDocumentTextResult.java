package com.amplifyframework.predictions.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifyDocumentTextResult implements IdentifyResult {
    private final String fullText;
    private final List keyValues;
    private final List lines;
    private final List rawLineText;
    private final List selections;
    private final List tables;
    private final List words;

    public static final class Builder {
        private String fullText;
        private List keyValues;
        private List lines;
        private List rawLineText;
        private List selections;
        private List tables;
        private List words;

        private Builder() {
            this.rawLineText = Collections.emptyList();
            this.words = Collections.emptyList();
            this.lines = Collections.emptyList();
            this.selections = Collections.emptyList();
            this.tables = Collections.emptyList();
            this.keyValues = Collections.emptyList();
        }

        public IdentifyDocumentTextResult build() {
            return new IdentifyDocumentTextResult(this, null);
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

        public List getKeyValues() {
            List list = this.keyValues;
            Objects.requireNonNull(list);
            return list;
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

        public List getSelections() {
            List list = this.selections;
            Objects.requireNonNull(list);
            return list;
        }

        public List getTables() {
            List list = this.tables;
            Objects.requireNonNull(list);
            return list;
        }

        public List getWords() {
            List list = this.words;
            Objects.requireNonNull(list);
            return list;
        }

        public Builder keyValues(List list) {
            Objects.requireNonNull(list);
            this.keyValues = list;
            return this;
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

        public Builder selections(List list) {
            Objects.requireNonNull(list);
            this.selections = list;
            return this;
        }

        public Builder tables(List list) {
            Objects.requireNonNull(list);
            this.tables = list;
            return this;
        }

        public Builder words(List list) {
            Objects.requireNonNull(list);
            this.words = list;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private IdentifyDocumentTextResult(Builder builder) {
        this.fullText = builder.getFullText();
        this.rawLineText = builder.getRawLineText();
        this.words = builder.getWords();
        this.lines = builder.getLines();
        this.selections = builder.getSelections();
        this.tables = builder.getTables();
        this.keyValues = builder.getKeyValues();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public String getFullText() {
        return this.fullText;
    }

    public List getKeyValues() {
        return Immutable.of(this.keyValues);
    }

    public List getLines() {
        return Immutable.of(this.lines);
    }

    public List getRawLineText() {
        return Immutable.of(this.rawLineText);
    }

    public List getSelections() {
        return Immutable.of(this.selections);
    }

    public List getTables() {
        return Immutable.of(this.tables);
    }

    public List getWords() {
        return Immutable.of(this.words);
    }

    public /* synthetic */ IdentifyDocumentTextResult(Builder builder, 1 r2) {
        this(builder);
    }
}
