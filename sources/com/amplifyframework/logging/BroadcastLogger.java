package com.amplifyframework.logging;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class BroadcastLogger implements Logger {
    private final List delegates;

    public BroadcastLogger(List list) {
        this.delegates = new ArrayList(list);
    }

    @SuppressLint({"LogConditional"})
    public void debug(String str) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).debug(str);
        }
    }

    public void error(String str) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).error(str);
        }
    }

    public String getNamespace() {
        return this.delegates.isEmpty() ? "" : ((Logger) this.delegates.get(0)).getNamespace();
    }

    public LogLevel getThresholdLevel() {
        if (this.delegates.isEmpty()) {
            throw new IllegalStateException("Cannot get threshold level for BroadcastLogger with no registered loggers.");
        }
        return ((Logger) this.delegates.get(0)).getThresholdLevel();
    }

    @SuppressLint({"LogConditional"})
    public void info(String str) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).info(str);
        }
    }

    @SuppressLint({"LogConditional"})
    public void verbose(String str) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).verbose(str);
        }
    }

    public void warn(String str) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).warn(str);
        }
    }

    public void error(String str, Throwable th) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).error(str, th);
        }
    }

    public void warn(String str, Throwable th) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Logger) it.next()).warn(str, th);
        }
    }
}
