package com.amplifyframework.predictions.options;

import com.amplifyframework.predictions.models.VoiceType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class TextToSpeechOptions {
    private final VoiceType voiceType;

    public static final class Builder {
        private VoiceType voiceType;

        public TextToSpeechOptions build() {
            return new TextToSpeechOptions(this, null);
        }

        public VoiceType getVoiceType() {
            return this.voiceType;
        }

        public Builder voiceType(VoiceType voiceType) {
            this.voiceType = voiceType;
            return this;
        }
    }

    private TextToSpeechOptions(Builder builder) {
        this.voiceType = builder.getVoiceType();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static TextToSpeechOptions defaults() {
        return new TextToSpeechOptions(builder());
    }

    public VoiceType getVoiceType() {
        return this.voiceType;
    }

    public /* synthetic */ TextToSpeechOptions(Builder builder, 1 r2) {
        this(builder);
    }
}
