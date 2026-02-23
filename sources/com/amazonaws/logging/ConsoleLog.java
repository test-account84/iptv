package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;
import java.io.PrintStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ConsoleLog implements Log {
    private LogFactory.Level level = null;
    private final String tag;

    public ConsoleLog(String str) {
        this.tag = str;
    }

    private LogFactory.Level getLevel() {
        LogFactory.Level level = this.level;
        return level != null ? level : LogFactory.getLevel();
    }

    private void log(LogFactory.Level level, Object obj, Throwable th) {
        PrintStream printStream = System.out;
        printStream.printf("%s/%s: %s\n", new Object[]{this.tag, level.name(), obj});
        if (th != null) {
            printStream.println(th.toString());
        }
    }

    public void debug(Object obj) {
        if (isDebugEnabled()) {
            log(LogFactory.Level.DEBUG, obj, null);
        }
    }

    public void error(Object obj) {
        if (isErrorEnabled()) {
            log(LogFactory.Level.ERROR, obj, null);
        }
    }

    public void info(Object obj) {
        if (isInfoEnabled()) {
            log(LogFactory.Level.INFO, obj, null);
        }
    }

    public boolean isDebugEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue();
    }

    public boolean isErrorEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue();
    }

    public boolean isInfoEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue();
    }

    public boolean isTraceEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue();
    }

    public boolean isWarnEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue();
    }

    public void setLevel(LogFactory.Level level) {
        this.level = level;
    }

    public void trace(Object obj) {
        if (isTraceEnabled()) {
            log(LogFactory.Level.TRACE, obj, null);
        }
    }

    public void warn(Object obj) {
        if (isWarnEnabled()) {
            log(LogFactory.Level.WARN, obj, null);
        }
    }

    public void debug(Object obj, Throwable th) {
        if (isDebugEnabled()) {
            log(LogFactory.Level.DEBUG, obj, th);
        }
    }

    public void error(Object obj, Throwable th) {
        if (isErrorEnabled()) {
            log(LogFactory.Level.ERROR, obj, th);
        }
    }

    public void info(Object obj, Throwable th) {
        if (isInfoEnabled()) {
            log(LogFactory.Level.INFO, obj, th);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (isTraceEnabled()) {
            log(LogFactory.Level.TRACE, obj, th);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (isWarnEnabled()) {
            log(LogFactory.Level.WARN, obj, th);
        }
    }
}
