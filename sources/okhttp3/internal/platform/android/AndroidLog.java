package okhttp3.internal.platform.android;

import E8.o;
import E8.q;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.l;
import l8.B;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressSignatureCheck
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet configuredLoggers = new CopyOnWriteArraySet();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        l.d(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        l.d(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        l.d(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = B.l(linkedHashMap);
    }

    private AndroidLog() {
    }

    private final void enableLogging(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            l.d(logger, "logger");
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = (String) knownLoggers.get(str);
        return str2 != null ? str2 : q.F0(str, 23);
    }

    public final void androidLog$okhttp(@NotNull String loggerName, int i, @NotNull String message, @Nullable Throwable th) {
        int min;
        l.e(loggerName, "loggerName");
        l.e(message, "message");
        String loggerTag = loggerTag(loggerName);
        if (Log.isLoggable(loggerTag, i)) {
            if (th != null) {
                message = message + "\n" + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i2 = 0;
            while (i2 < length) {
                int Q = o.Q(message, '\n', i2, false, 4, null);
                if (Q == -1) {
                    Q = length;
                }
                while (true) {
                    min = Math.min(Q, i2 + 4000);
                    String substring = message.substring(i2, min);
                    l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, loggerTag, substring);
                    if (min >= Q) {
                        break;
                    } else {
                        i2 = min;
                    }
                }
                i2 = min + 1;
            }
        }
    }

    public final void enable() {
        for (Map.Entry entry : knownLoggers.entrySet()) {
            enableLogging((String) entry.getKey(), (String) entry.getValue());
        }
    }
}
