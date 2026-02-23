package com.google.ads.interactivemedia.v3.internal;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bnx {
    private static final TimeZone a = DesugarTimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:103:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date a(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bnx.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int b(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: ".concat(String.valueOf(str.substring(i, i2))));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: ".concat(String.valueOf(str.substring(i, i2))));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }

    private static boolean c(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }
}
