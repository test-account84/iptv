package com.google.android.exoplayer2.source.rtsp;

import K3.u;
import K3.v;
import O2.l1;
import android.net.Uri;
import com.google.android.exoplayer2.source.rtsp.e;
import d4.k0;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r5.q;
import s5.c0;
import s5.y;
import s5.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h {
    public static final Pattern a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");
    public static final Pattern b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");
    public static final Pattern c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);
    public static final Pattern d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");
    public static final Pattern e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");
    public static final Pattern f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");
    public static final String g = new String(new byte[]{10});
    public static final String h = new String(new byte[]{13, 10});

    public static final class a {
        public final String a;
        public final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public static final class b {
        public final String a;
        public final long b;

        public b(String str, long j) {
            this.a = str;
            this.b = j;
        }
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw l1.c(str, null);
        }
    }

    public static byte[] b(List list) {
        return r5.g.g(h).d(list).getBytes(g.h);
    }

    public static String c(int i) {
        if (i == 200) {
            return "OK";
        }
        if (i == 461) {
            return "Unsupported Transport";
        }
        if (i == 500) {
            return "Internal Server Error";
        }
        if (i == 505) {
            return "RTSP Version Not Supported";
        }
        if (i == 301) {
            return "Move Permanently";
        }
        if (i == 302) {
            return "Move Temporarily";
        }
        if (i == 400) {
            return "Bad Request";
        }
        if (i == 401) {
            return "Unauthorized";
        }
        if (i == 404) {
            return "Not Found";
        }
        if (i == 405) {
            return "Method Not Allowed";
        }
        switch (i) {
            case 454:
                return "Session Not Found";
            case 455:
                return "Method Not Valid In This State";
            case 456:
                return "Header Field Not Valid";
            case 457:
                return "Invalid Range";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte[] d(String str) {
        return str.getBytes(g.h);
    }

    public static boolean e(List list) {
        return b.matcher((CharSequence) list.get(0)).matches();
    }

    public static boolean f(String str) {
        return a.matcher(str).matches() || b.matcher(str).matches();
    }

    public static long g(String str) {
        try {
            Matcher matcher = c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) d4.a.e(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e2) {
            throw l1.c(str, e2);
        }
    }

    public static int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            throw l1.c(str, e2);
        }
    }

    public static int i(String str) {
        str.hashCode();
        switch (str) {
            case "RECORD":
                return 8;
            case "TEARDOWN":
                return 12;
            case "GET_PARAMETER":
                return 3;
            case "OPTIONS":
                return 4;
            case "PLAY_NOTIFY":
                return 7;
            case "PLAY":
                return 6;
            case "REDIRECT":
                return 9;
            case "SET_PARAMETER":
                return 11;
            case "PAUSE":
                return 5;
            case "SETUP":
                return 10;
            case "ANNOUNCE":
                return 1;
            case "DESCRIBE":
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static y j(String str) {
        if (str == null) {
            return y.z();
        }
        y.a aVar = new y.a();
        for (String str2 : k0.i1(str, ",\\s?")) {
            aVar.a(Integer.valueOf(i(str2)));
        }
        return aVar.k();
    }

    public static u k(List list) {
        Matcher matcher = a.matcher((CharSequence) list.get(0));
        d4.a.a(matcher.matches());
        int i = i((String) d4.a.e(matcher.group(1)));
        Uri parse = Uri.parse((String) d4.a.e(matcher.group(2)));
        int indexOf = list.indexOf("");
        d4.a.a(indexOf > 0);
        return new u(parse, i, new e.b().c(list.subList(1, indexOf)).e(), r5.g.g(h).d(list.subList(indexOf + 1, list.size())));
    }

    public static v l(List list) {
        Matcher matcher = b.matcher((CharSequence) list.get(0));
        d4.a.a(matcher.matches());
        int parseInt = Integer.parseInt((String) d4.a.e(matcher.group(1)));
        int indexOf = list.indexOf("");
        d4.a.a(indexOf > 0);
        return new v(parseInt, new e.b().c(list.subList(1, indexOf)).e(), r5.g.g(h).d(list.subList(indexOf + 1, list.size())));
    }

    public static b m(String str) {
        long parseInt;
        Matcher matcher = d.matcher(str);
        if (!matcher.matches()) {
            throw l1.c(str, null);
        }
        String str2 = (String) d4.a.e(matcher.group(1));
        if (matcher.group(2) != null) {
            try {
                parseInt = Integer.parseInt(r0) * 1000;
            } catch (NumberFormatException e2) {
                throw l1.c(str, e2);
            }
        } else {
            parseInt = 60000;
        }
        return new b(str2, parseInt);
    }

    public static a n(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] j1 = k0.j1(userInfo, ":");
        return new a(j1[0], j1[1]);
    }

    public static c o(String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return new c(2, (String) d4.a.e(matcher.group(1)), (String) d4.a.e(matcher.group(3)), q.d(matcher.group(4)));
        }
        Matcher matcher2 = f.matcher(str);
        if (matcher2.matches()) {
            return new c(1, (String) d4.a.e(matcher2.group(1)), "", "");
        }
        throw l1.c("Invalid WWW-Authenticate header " + str, null);
    }

    public static Uri p(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) d4.a.e(uri.getAuthority());
        d4.a.a(str.contains("@"));
        return uri.buildUpon().encodedAuthority(k0.i1(str, "@")[1]).build();
    }

    public static y q(u uVar) {
        d4.a.a(uVar.c.d("CSeq") != null);
        y.a aVar = new y.a();
        aVar.a(k0.D("%s %s %s", t(uVar.b), uVar.a, "RTSP/1.0"));
        z b2 = uVar.c.b();
        c0 l = b2.keySet().l();
        while (l.hasNext()) {
            String str = (String) l.next();
            y yVar = b2.get(str);
            for (int i = 0; i < yVar.size(); i++) {
                aVar.a(k0.D("%s: %s", str, yVar.get(i)));
            }
        }
        aVar.a("");
        aVar.a(uVar.d);
        return aVar.k();
    }

    public static y r(v vVar) {
        d4.a.a(vVar.b.d("CSeq") != null);
        y.a aVar = new y.a();
        aVar.a(k0.D("%s %s %s", "RTSP/1.0", Integer.valueOf(vVar.a), c(vVar.a)));
        z b2 = vVar.b.b();
        c0 l = b2.keySet().l();
        while (l.hasNext()) {
            String str = (String) l.next();
            y yVar = b2.get(str);
            for (int i = 0; i < yVar.size(); i++) {
                aVar.a(k0.D("%s: %s", str, yVar.get(i)));
            }
        }
        aVar.a("");
        aVar.a(vVar.c);
        return aVar.k();
    }

    public static String[] s(String str) {
        String str2 = h;
        if (!str.contains(str2)) {
            str2 = g;
        }
        return k0.i1(str, str2);
    }

    public static String t(int i) {
        switch (i) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
