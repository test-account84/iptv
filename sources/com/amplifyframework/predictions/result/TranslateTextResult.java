package com.amplifyframework.predictions.result;

import com.amplifyframework.predictions.models.LanguageType;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class TranslateTextResult {
    private final LanguageType targetLanguage;
    private final String translatedText;

    public static final class Builder {
        private LanguageType targetLanguage;
        private String translatedText;

        public TranslateTextResult build() {
            return new TranslateTextResult(this, null);
        }

        public LanguageType getTargetLanguage() {
            LanguageType languageType = this.targetLanguage;
            Objects.requireNonNull(languageType);
            return languageType;
        }

        public String getTranslatedText() {
            String str = this.translatedText;
            Objects.requireNonNull(str);
            return str;
        }

        public Builder targetLanguage(LanguageType languageType) {
            Objects.requireNonNull(languageType);
            this.targetLanguage = languageType;
            return this;
        }

        public Builder translatedText(String str) {
            Objects.requireNonNull(str);
            this.translatedText = str;
            return this;
        }
    }

    private TranslateTextResult(Builder builder) {
        this.translatedText = builder.getTranslatedText();
        this.targetLanguage = builder.getTargetLanguage();
    }

    public static Builder builder() {
        return new Builder();
    }

    public LanguageType getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getTranslatedText() {
        return this.translatedText;
    }

    public /* synthetic */ TranslateTextResult(Builder builder, 1 r2) {
        this(builder);
    }
}
