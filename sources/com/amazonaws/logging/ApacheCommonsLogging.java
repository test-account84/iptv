package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApacheCommonsLogging implements Log {
    private LogFactory.Level level = null;
    private Log log;
    private Class logClass;
    private String logString;

    public ApacheCommonsLogging(Class cls) {
        this.logClass = cls;
        this.log = LogFactory.getLog(cls);
    }

    private LogFactory.Level getLevel() {
        LogFactory.Level level = this.level;
        return level != null ? level : LogFactory.getLevel();
    }

    public void debug(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            this.log.debug(obj);
        }
    }

    public void error(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            this.log.error(obj);
        }
    }

    public void info(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            this.log.info(obj);
        }
    }

    public boolean isDebugEnabled() {
        return this.log.isDebugEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    public boolean isErrorEnabled() {
        return this.log.isErrorEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    public boolean isInfoEnabled() {
        return this.log.isInfoEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue());
    }

    public boolean isTraceEnabled() {
        return this.log.isTraceEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue());
    }

    public boolean isWarnEnabled() {
        return this.log.isWarnEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue());
    }

    public void setLevel(LogFactory.Level level) {
        this.level = level;
    }

    public void trace(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            this.log.trace(obj);
        }
    }

    public void warn(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            this.log.warn(obj);
        }
    }

    public ApacheCommonsLogging(String str) {
        this.logString = str;
        this.log = LogFactory.getLog(str);
    }

    public void debug(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            this.log.debug(obj, th);
        }
    }

    public void error(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            this.log.error(obj, th);
        }
    }

    public void info(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            this.log.info(obj, th);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            this.log.trace(obj, th);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            this.log.warn(obj, th);
        }
    }
}
