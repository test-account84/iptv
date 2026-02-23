package okhttp3.internal.platform.android;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class AndroidLogKt {
    public static final /* synthetic */ int access$getAndroidLevel$p(LogRecord logRecord) {
        return getAndroidLevel(logRecord);
    }

    private static final int getAndroidLevel(LogRecord logRecord) {
        int intValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (intValue > level.intValue()) {
            return 5;
        }
        return logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
    }
}
