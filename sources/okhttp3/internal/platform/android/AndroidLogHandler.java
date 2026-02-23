package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(@NotNull LogRecord record) {
        l.e(record, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = record.getLoggerName();
        l.d(loggerName, "record.loggerName");
        int access$getAndroidLevel$p = AndroidLogKt.access$getAndroidLevel$p(record);
        String message = record.getMessage();
        l.d(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, access$getAndroidLevel$p, message, record.getThrown());
    }
}
