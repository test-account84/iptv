package com.amazonaws.util;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DateUtils {
    public static final String ALTERNATE_ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String COMPRESSED_DATE_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String RFC822_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    private static final TimeZone GMT_TIMEZONE = DesugarTimeZone.getTimeZone("GMT");
    private static final Map SDF_MAP = new HashMap();

    public static class 1 extends ThreadLocal {
        final /* synthetic */ String val$pattern;

        public 1(String str) {
            this.val$pattern = str;
        }

        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.val$pattern, Locale.US);
            simpleDateFormat.setTimeZone(DateUtils.access$000());
            simpleDateFormat.setLenient(false);
            return simpleDateFormat;
        }
    }

    public static /* synthetic */ TimeZone access$000() {
        return GMT_TIMEZONE;
    }

    public static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

    public static String format(String str, Date date) {
        return ((SimpleDateFormat) getSimpleDateFormat(str).get()).format(date);
    }

    public static String formatISO8601Date(Date date) {
        return format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", date);
    }

    public static String formatRFC822Date(Date date) {
        return format("EEE, dd MMM yyyy HH:mm:ss z", date);
    }

    private static ThreadLocal getSimpleDateFormat(String str) {
        Map map = SDF_MAP;
        ThreadLocal threadLocal = (ThreadLocal) map.get(str);
        if (threadLocal == null) {
            synchronized (map) {
                try {
                    threadLocal = (ThreadLocal) map.get(str);
                    if (threadLocal == null) {
                        threadLocal = new 1(str);
                        map.put(str, threadLocal);
                    }
                } finally {
                }
            }
        }
        return threadLocal;
    }

    public static long numberOfDaysSinceEpoch(long j) {
        return TimeUnit.MILLISECONDS.toDays(j);
    }

    public static Date parse(String str, String str2) {
        try {
            return ((SimpleDateFormat) getSimpleDateFormat(str).get()).parse(str2);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Date parseCompressedISO8601Date(String str) {
        return parse("yyyyMMdd'T'HHmmss'Z'", str);
    }

    public static Date parseISO8601Date(String str) {
        try {
            return parse("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", str);
        } catch (IllegalArgumentException unused) {
            return parse("yyyy-MM-dd'T'HH:mm:ss'Z'", str);
        }
    }

    public static Date parseRFC822Date(String str) {
        return parse("EEE, dd MMM yyyy HH:mm:ss z", str);
    }
}
