package com.amplifyframework.predictions.models;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum TextFormatType implements IdentifyAction {
    FORM,
    TABLE,
    PLAIN,
    ALL;

    public final IdentifyActionType getType() {
        return IdentifyActionType.DETECT_TEXT;
    }
}
