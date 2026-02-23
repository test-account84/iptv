package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ds {
    private static final Pattern a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long a(String str, String str2) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                cd.b("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        Matcher matcher = a.matcher(str2);
        if (!matcher.matches()) {
            return j;
        }
        try {
            String group = matcher.group(2);
            af.s(group);
            long parseLong = Long.parseLong(group);
            String group2 = matcher.group(1);
            af.s(group2);
            long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
            if (j < 0) {
                return parseLong2;
            }
            if (j == parseLong2) {
                return j;
            }
            cd.e("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j, parseLong2);
        } catch (NumberFormatException unused2) {
            cd.b("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j;
        }
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String group = matcher.group(1);
        af.s(group);
        return Long.parseLong(group);
    }

    public static String c(long j, long j2) {
        if (j == 0) {
            if (j2 == -1) {
                return null;
            }
            j = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j);
        sb.append("-");
        if (j2 != -1) {
            sb.append((j + j2) - 1);
        }
        return sb.toString();
    }
}
