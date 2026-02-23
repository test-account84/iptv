package com.amazonaws.mobileconnectors.appsync.utils;

import okio.Buffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StringUtils {
    public static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt <= 31 || codePointAt >= 127) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i);
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    if (codePointAt2 > 31 && codePointAt2 < 127) {
                        buffer.writeUtf8CodePoint(codePointAt2);
                    }
                    i += Character.charCount(codePointAt2);
                }
                return buffer.readUtf8();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }
}
