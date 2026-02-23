package com.google.ads.interactivemedia.v3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adg {
    private static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    public static long a(String str) throws NumberFormatException {
        String[] al = cq.al(str, "\\.");
        long j = 0;
        for (String str2 : cq.ak(al[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (al.length == 2) {
            j2 += Long.parseLong(al[1]);
        }
        return j2 * 1000;
    }

    public static Matcher b(cj cjVar) {
        String r;
        while (true) {
            String r2 = cjVar.r();
            if (r2 == null) {
                return null;
            }
            if (a.matcher(r2).matches()) {
                do {
                    r = cjVar.r();
                    if (r != null) {
                    }
                } while (!r.isEmpty());
            } else {
                Matcher matcher = adf.a.matcher(r2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static void c(cj cjVar) throws as {
        int c = cjVar.c();
        if (d(cjVar)) {
            return;
        }
        cjVar.F(c);
        throw as.a("Expected WEBVTT. Got ".concat(String.valueOf(cjVar.r())), null);
    }

    public static boolean d(cj cjVar) {
        String r = cjVar.r();
        return r != null && r.startsWith("WEBVTT");
    }
}
