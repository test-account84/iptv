package com.amplifyframework.devmenu;

import android.util.Log;
import com.amplifyframework.logging.LogLevel;
import j$.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LogEntry implements Comparable {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private final Date date;
    private final LogLevel logLevel;
    private final String message;
    private final String namespace;
    private final Throwable throwable;

    public LogEntry(Date date, String str, String str2, Throwable th, LogLevel logLevel) {
        Objects.requireNonNull(date);
        this.date = date;
        Objects.requireNonNull(logLevel);
        this.logLevel = logLevel;
        this.namespace = str;
        this.message = str2;
        this.throwable = th;
    }

    public int compareTo(LogEntry logEntry) {
        return getDate().compareTo(logEntry.getDate());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LogEntry.class != obj.getClass()) {
            return false;
        }
        LogEntry logEntry = (LogEntry) obj;
        return this.date.equals(logEntry.getDate()) && O.c.a(this.namespace, logEntry.getNamespace()) && O.c.a(this.message, logEntry.getMessage()) && this.logLevel == logEntry.getLogLevel() && O.c.a(this.throwable, logEntry.getThrowable());
    }

    public Date getDate() {
        return this.date;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        return (((((((getDate().hashCode() * 31) + (getNamespace() != null ? getNamespace().hashCode() : 0)) * 31) + (getMessage() != null ? getMessage().hashCode() : 0)) * 31) + (getThrowable() != null ? getThrowable().hashCode() : 0)) * 31) + getLogLevel().hashCode();
    }

    public String toString() {
        Locale locale = Locale.US;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale).format(this.date);
        Throwable th = this.throwable;
        String stackTraceString = th == null ? "" : Log.getStackTraceString(th);
        if (!stackTraceString.isEmpty() && !stackTraceString.endsWith("\n")) {
            stackTraceString = stackTraceString + "\n";
        }
        return String.format(locale, "[%s] %s %s: %s\n%s", new Object[]{this.logLevel.name(), format, this.namespace, this.message, stackTraceString});
    }
}
