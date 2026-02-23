package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import k8.q;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DatesKt {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    public static final long MAX_DATE = 253402300799999L;
    private static final DatesKt$STANDARD_DATE_FORMAT$1 STANDARD_DATE_FORMAT = new DatesKt$STANDARD_DATE_FORMAT$1();

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = strArr;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[strArr.length];
    }

    @Nullable
    public static final Date toHttpDateOrNull(@NotNull String toHttpDateOrNull) {
        l.e(toHttpDateOrNull, "$this$toHttpDateOrNull");
        if (toHttpDateOrNull.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) STANDARD_DATE_FORMAT.get()).parse(toHttpDateOrNull, parsePosition);
        if (parsePosition.getIndex() == toHttpDateOrNull.length()) {
            return parse;
        }
        String[] strArr = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    SimpleDateFormat[] simpleDateFormatArr = BROWSER_COMPATIBLE_DATE_FORMATS;
                    SimpleDateFormat simpleDateFormat = simpleDateFormatArr[i];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                        simpleDateFormat.setTimeZone(Util.UTC);
                        simpleDateFormatArr[i] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = simpleDateFormat.parse(toHttpDateOrNull, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                q qVar = q.a;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NotNull
    public static final String toHttpDateString(@NotNull Date toHttpDateString) {
        l.e(toHttpDateString, "$this$toHttpDateString");
        String format = ((DateFormat) STANDARD_DATE_FORMAT.get()).format(toHttpDateString);
        l.d(format, "STANDARD_DATE_FORMAT.get().format(this)");
        return format;
    }
}
