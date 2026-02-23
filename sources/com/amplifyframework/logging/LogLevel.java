package com.amplifyframework.logging;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum LogLevel {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    NONE;

    public boolean above(LogLevel logLevel) {
        return ordinal() > logLevel.ordinal();
    }
}
