package com.amplifyframework.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class AndroidLogger implements Logger {
    private final String namespace;
    private final LogLevel threshold;

    public AndroidLogger(String str, LogLevel logLevel) {
        Objects.requireNonNull(logLevel);
        this.threshold = logLevel;
        Objects.requireNonNull(str);
        this.namespace = str;
    }

    @SuppressLint({"LogConditional"})
    public void debug(String str) {
        if (this.threshold.above(LogLevel.DEBUG)) {
            return;
        }
        Log.d(this.namespace, String.valueOf(str));
    }

    public void error(String str) {
        if (this.threshold.above(LogLevel.ERROR)) {
            return;
        }
        Log.e(this.namespace, String.valueOf(str));
    }

    public String getNamespace() {
        return this.namespace;
    }

    public LogLevel getThresholdLevel() {
        return this.threshold;
    }

    @SuppressLint({"LogConditional"})
    public void info(String str) {
        if (this.threshold.above(LogLevel.INFO)) {
            return;
        }
        Log.i(this.namespace, String.valueOf(str));
    }

    @SuppressLint({"LogConditional"})
    public void verbose(String str) {
        if (this.threshold.above(LogLevel.VERBOSE)) {
            return;
        }
        Log.v(this.namespace, String.valueOf(str));
    }

    public void warn(String str) {
        if (this.threshold.above(LogLevel.WARN)) {
            return;
        }
        Log.w(this.namespace, String.valueOf(str));
    }

    public void error(String str, Throwable th) {
        if (this.threshold.above(LogLevel.ERROR)) {
            return;
        }
        Log.e(this.namespace, str, th);
    }

    public void warn(String str, Throwable th) {
        if (this.threshold.above(LogLevel.WARN)) {
            return;
        }
        Log.w(this.namespace, str, th);
    }
}
