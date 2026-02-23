package com.amplifyframework.devmenu;

import android.annotation.SuppressLint;
import com.amplifyframework.logging.LogLevel;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class PersistentLogger implements Logger {
    private static final int MAX_NUM_LOGS = 500;
    private final List logs;
    private final String namespace;

    public PersistentLogger(String str) {
        Objects.requireNonNull(str);
        this.namespace = str;
        this.logs = new LinkedList();
    }

    private void addToLogs(String str, Throwable th, LogLevel logLevel) {
        if (this.logs.size() == 500) {
            this.logs.remove(0);
        }
        this.logs.add(new LogEntry(new Date(), this.namespace, str, th, logLevel));
    }

    @SuppressLint({"LogConditional"})
    public void debug(String str) {
        addToLogs(str, null, LogLevel.DEBUG);
    }

    public void error(String str) {
        addToLogs(str, null, LogLevel.ERROR);
    }

    public List getLogs() {
        return Immutable.of(this.logs);
    }

    public String getNamespace() {
        return this.namespace;
    }

    public LogLevel getThresholdLevel() {
        return LogLevel.VERBOSE;
    }

    @SuppressLint({"LogConditional"})
    public void info(String str) {
        addToLogs(str, null, LogLevel.INFO);
    }

    @SuppressLint({"LogConditional"})
    public void verbose(String str) {
        addToLogs(str, null, LogLevel.VERBOSE);
    }

    public void warn(String str) {
        addToLogs(str, null, LogLevel.WARN);
    }

    public void error(String str, Throwable th) {
        addToLogs(str, th, LogLevel.ERROR);
    }

    public void warn(String str, Throwable th) {
        addToLogs(str, th, LogLevel.WARN);
    }
}
