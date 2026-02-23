package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.Feature;
import com.amplifyframework.predictions.models.Language;
import com.amplifyframework.predictions.models.Sentiment;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class InterpretResult {
    private final List entities;
    private final List features;
    private final List keyPhrases;
    private final Language language;
    private final Sentiment sentiment;
    private final List syntax;

    public static final class Builder {
        private List entities;
        private List features;
        private List keyPhrases;
        private Language language;
        private Sentiment sentiment;
        private List syntax;

        private Builder() {
            this.features = new ArrayList();
        }

        public InterpretResult build() {
            return new InterpretResult(this, null);
        }

        public Builder entities(List list) {
            this.entities = list;
            return this;
        }

        public Builder feature(Feature feature) {
            List list = this.features;
            Objects.requireNonNull(feature);
            list.add(feature);
            return this;
        }

        public Builder features(List list) {
            Objects.requireNonNull(list);
            this.features = list;
            return this;
        }

        public List getEntities() {
            return this.entities;
        }

        public List getFeatures() {
            return this.features;
        }

        public List getKeyPhrases() {
            return this.keyPhrases;
        }

        public Language getLanguage() {
            return this.language;
        }

        public Sentiment getSentiment() {
            return this.sentiment;
        }

        public List getSyntax() {
            return this.syntax;
        }

        public Builder keyPhrases(List list) {
            this.keyPhrases = list;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder sentiment(Sentiment sentiment) {
            this.sentiment = sentiment;
            return this;
        }

        public Builder syntax(List list) {
            this.syntax = list;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private InterpretResult(Builder builder) {
        this.language = builder.getLanguage();
        this.sentiment = builder.getSentiment();
        this.keyPhrases = builder.getKeyPhrases();
        this.entities = builder.getEntities();
        this.syntax = builder.getSyntax();
        this.features = builder.getFeatures();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public List getEntities() {
        return Immutable.of(this.entities);
    }

    public List getFeatures() {
        return Immutable.of(this.features);
    }

    public List getKeyPhrases() {
        return Immutable.of(this.keyPhrases);
    }

    public Language getLanguage() {
        return this.language;
    }

    public Sentiment getSentiment() {
        return this.sentiment;
    }

    public List getSyntax() {
        return Immutable.of(this.syntax);
    }

    public /* synthetic */ InterpretResult(Builder builder, 1 r2) {
        this(builder);
    }
}
