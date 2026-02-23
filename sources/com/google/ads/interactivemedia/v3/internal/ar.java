package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ar {
    private static final ArrayList a = new ArrayList();
    private static final Pattern b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = r6.hashCode()
            r1 = 6
            r2 = 5
            r3 = 7
            r4 = 8
            r5 = 0
            switch(r0) {
                case -2123537834: goto L5f;
                case -1095064472: goto L55;
                case -53558318: goto L4b;
                case 187078296: goto L41;
                case 187078297: goto L37;
                case 1504578661: goto L2d;
                case 1504831518: goto L23;
                case 1505942594: goto L19;
                case 1556697186: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L69
        Le:
            java.lang.String r0 = "audio/true-hd"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 8
            goto L6a
        L19:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 7
            goto L6a
        L23:
            java.lang.String r0 = "audio/mpeg"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 0
            goto L6a
        L2d:
            java.lang.String r0 = "audio/eac3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 3
            goto L6a
        L37:
            java.lang.String r0 = "audio/ac4"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 5
            goto L6a
        L41:
            java.lang.String r0 = "audio/ac3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 2
            goto L6a
        L4b:
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 1
            goto L6a
        L55:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 6
            goto L6a
        L5f:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L69
            r6 = 4
            goto L6a
        L69:
            r6 = -1
        L6a:
            switch(r6) {
                case 0: goto L8a;
                case 1: goto L7b;
                case 2: goto L7a;
                case 3: goto L79;
                case 4: goto L76;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L6e;
                default: goto L6d;
            }
        L6d:
            return r5
        L6e:
            r6 = 14
            return r6
        L71:
            return r4
        L72:
            return r3
        L73:
            r6 = 17
            return r6
        L76:
            r6 = 18
            return r6
        L79:
            return r1
        L7a:
            return r2
        L7b:
            if (r7 != 0) goto L7e
            return r5
        L7e:
            com.google.ads.interactivemedia.v3.internal.aq r6 = d(r7)
            if (r6 != 0) goto L85
            return r5
        L85:
            int r6 = r6.a()
            return r6
        L8a:
            r6 = 9
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ar.a(java.lang.String, java.lang.String):int");
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (m(str)) {
            return 1;
        }
        if (q(str)) {
            return 2;
        }
        if (p(str)) {
            return 3;
        }
        if (n(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str2 = ((ap) a.get(i)).a;
            if (str.equals((Object) null)) {
                return 0;
            }
        }
        return -1;
    }

    public static int c(String str) {
        return b(g(str));
    }

    public static aq d(String str) {
        Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        af.s(group);
        String group2 = matcher.group(2);
        try {
            return new aq(Integer.parseInt(group, 16), group2 != null ? Integer.parseInt(group2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : cq.am(str)) {
            String g = g(str2);
            if (g != null && m(g)) {
                return g;
            }
        }
        return null;
    }

    public static String f(String str, String str2) {
        if (str != null && str2 != null) {
            String[] am = cq.am(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : am) {
                if (str2.equals(g(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static String g(String str) {
        aq d;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String d2 = com.google.ads.interactivemedia.v3.impl.data.k.d(str.trim());
        if (d2.startsWith("avc1") || d2.startsWith("avc3")) {
            return "video/avc";
        }
        if (d2.startsWith("hev1") || d2.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (d2.startsWith("dvav") || d2.startsWith("dva1") || d2.startsWith("dvhe") || d2.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (d2.startsWith("av01")) {
            return "video/av01";
        }
        if (d2.startsWith("vp9") || d2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (d2.startsWith("vp8") || d2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (d2.startsWith("mp4a")) {
            if (d2.startsWith("mp4a.") && (d = d(d2)) != null) {
                str2 = h(d.a);
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        }
        if (d2.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (d2.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (d2.startsWith("ac-3") || d2.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (d2.startsWith("ec-3") || d2.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (d2.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (d2.startsWith("ac-4") || d2.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (d2.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (d2.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (d2.startsWith("dtsh") || d2.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (d2.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (d2.startsWith("opus")) {
            return "audio/opus";
        }
        if (d2.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (d2.startsWith("flac")) {
            return "audio/flac";
        }
        if (d2.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (d2.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (d2.contains("cea708")) {
            return "application/cea-708";
        }
        if (d2.contains("eia608") || d2.contains("cea608")) {
            return "application/cea-608";
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str3 = ((ap) a.get(i)).b;
            if (d2.startsWith((String) null)) {
                break;
            }
        }
        return null;
    }

    public static String h(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static String i(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : cq.am(str)) {
            String g = g(str2);
            if (g != null && q(g)) {
                return g;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1007807498(0xffffffffc3ee13f6, float:-476.15594)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = -586683234(0xffffffffdd07ec9e, float:-6.1214856E17)
            if (r0 == r1) goto L20
            r1 = 187090231(0xb26c537, float:3.2118805E-32)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "audio/mp3"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L34
            r0 = 1
            goto L35
        L20:
            java.lang.String r0 = "audio/x-wav"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L34
            r0 = 2
            goto L35
        L2a:
            java.lang.String r0 = "audio/x-flac"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L34
            r0 = 0
            goto L35
        L34:
            r0 = -1
        L35:
            if (r0 == 0) goto L42
            if (r0 == r3) goto L3f
            if (r0 == r2) goto L3c
            return r4
        L3c:
            java.lang.String r4 = "audio/wav"
            return r4
        L3f:
            java.lang.String r4 = "audio/mpeg"
            return r4
        L42:
            java.lang.String r4 = "audio/flac"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ar.j(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean k(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            int r1 = r3.hashCode()
            r2 = 1
            switch(r1) {
                case -2123537834: goto L75;
                case -432837260: goto L6b;
                case -432837259: goto L61;
                case -53558318: goto L56;
                case 187078296: goto L4c;
                case 187094639: goto L42;
                case 1504578661: goto L37;
                case 1504619009: goto L2d;
                case 1504831518: goto L23;
                case 1903231877: goto L19;
                case 1903589369: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L80
        Le:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 5
            goto L81
        L19:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 4
            goto L81
        L23:
            java.lang.String r1 = "audio/mpeg"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 0
            goto L81
        L2d:
            java.lang.String r1 = "audio/flac"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 6
            goto L81
        L37:
            java.lang.String r1 = "audio/eac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 8
            goto L81
        L42:
            java.lang.String r1 = "audio/raw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 3
            goto L81
        L4c:
            java.lang.String r1 = "audio/ac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 7
            goto L81
        L56:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 10
            goto L81
        L61:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 2
            goto L81
        L6b:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 1
            goto L81
        L75:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 9
            goto L81
        L80:
            r3 = -1
        L81:
            switch(r3) {
                case 0: goto L9b;
                case 1: goto L9b;
                case 2: goto L9b;
                case 3: goto L9b;
                case 4: goto L9b;
                case 5: goto L9b;
                case 6: goto L9b;
                case 7: goto L9b;
                case 8: goto L9b;
                case 9: goto L9b;
                case 10: goto L85;
                default: goto L84;
            }
        L84:
            return r0
        L85:
            if (r4 != 0) goto L88
            return r0
        L88:
            com.google.ads.interactivemedia.v3.internal.aq r3 = d(r4)
            if (r3 != 0) goto L8f
            return r0
        L8f:
            int r3 = r3.a()
            if (r3 == 0) goto L9a
            r4 = 16
            if (r3 == r4) goto L9a
            return r2
        L9a:
            return r0
        L9b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ar.k(java.lang.String, java.lang.String):boolean");
    }

    public static boolean l(String str, String str2) {
        return f(str, str2) != null;
    }

    public static boolean m(String str) {
        return "audio".equals(r(str));
    }

    public static boolean n(String str) {
        return "image".equals(r(str));
    }

    public static boolean o(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean p(String str) {
        return "text".equals(r(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean q(String str) {
        return "video".equals(r(str));
    }

    private static String r(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
