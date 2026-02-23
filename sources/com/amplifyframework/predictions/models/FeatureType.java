package com.amplifyframework.predictions.models;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum FeatureType {
    BOUNDED_KEY_VALUE("BoundedKeyValue"),
    CELEBRITY("Celebrity"),
    CELL("Cell"),
    EMOTION(EmotionType.class.getSimpleName()),
    ENTITY(EntityType.class.getSimpleName()),
    ENTITY_MATCH("EntityMatch"),
    GENDER(GenderBinaryType.class.getSimpleName()),
    IDENTIFIED_TEXT("IdentifiedText"),
    KEY_PHRASE("KeyPhrase"),
    LANGUAGE(LanguageType.class.getSimpleName()),
    SENTIMENT(SentimentType.class.getSimpleName()),
    SYNTAX(SpeechType.class.getSimpleName()),
    TABLE("Table");

    private final String typeAlias;

    FeatureType(String str) {
        this.typeAlias = str;
    }

    public static FeatureType fromAlias(String str) {
        try {
            return valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String getAlias() {
        return this.typeAlias;
    }
}
