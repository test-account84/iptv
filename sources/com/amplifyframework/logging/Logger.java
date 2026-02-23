package com.amplifyframework.logging;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface Logger {
    void debug(String str);

    void error(String str);

    void error(String str, Throwable th);

    String getNamespace();

    LogLevel getThresholdLevel();

    void info(String str);

    void verbose(String str);

    void warn(String str);

    void warn(String str, Throwable th);
}
