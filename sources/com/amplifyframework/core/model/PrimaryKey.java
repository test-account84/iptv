package com.amplifyframework.core.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class PrimaryKey {
    private static final String ID = "id";

    private PrimaryKey() {
    }

    public static String fieldName() {
        return "id";
    }

    public static boolean matches(Object obj) {
        return (obj instanceof String) && fieldName().equals(obj);
    }
}
