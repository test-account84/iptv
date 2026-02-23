package Y3;

import O2.l1;
import d4.M;
import d4.k0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class i {
    public static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(M m) {
        String s;
        while (true) {
            String s2 = m.s();
            if (s2 == null) {
                return null;
            }
            if (a.matcher(s2).matches()) {
                do {
                    s = m.s();
                    if (s != null) {
                    }
                } while (!s.isEmpty());
            } else {
                Matcher matcher = f.a.matcher(s2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(M m) {
        String s = m.s();
        return s != null && s.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] j1 = k0.j1(str, "\\.");
        long j = 0;
        for (String str2 : k0.i1(j1[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (j1.length == 2) {
            j2 += Long.parseLong(j1[1]);
        }
        return j2 * 1000;
    }

    public static void e(M m) {
        int f = m.f();
        if (b(m)) {
            return;
        }
        m.U(f);
        throw l1.a("Expected WEBVTT. Got " + m.s(), null);
    }
}
