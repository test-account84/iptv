package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lw extends DefaultHandler implements xe {
    private static final Pattern a = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern b = Pattern.compile("CC([1-4])=.*");
    private static final Pattern c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final int[] d = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    private final XmlPullParserFactory e;

    public lw() {
        try {
            this.e = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static final mn A(XmlPullParser xmlPullParser, String str, mn mnVar) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? mn.a(attributeValue) : mnVar;
    }

    private static int B(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        af.w(i == i2);
        return i;
    }

    private static long C(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    private static final long D(List list, long j, long j2, int i, long j3) {
        int o = i >= 0 ? i + 1 : (int) cq.o(j3 - j, j2);
        for (int i2 = 0; i2 < o; i2++) {
            list.add(new mi(j, j2));
            j += j2;
        }
        return j;
    }

    public static float b(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = a.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        float f2 = parseInt;
        return !TextUtils.isEmpty(matcher.group(2)) ? f2 / Integer.parseInt(r2) : f2;
    }

    public static int c(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    public static long d(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j : cq.v(attributeValue);
    }

    public static long e(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    public static lx h(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String m = m(xmlPullParser, "schemeIdUri", "");
        String m2 = m(xmlPullParser, "value", null);
        String m3 = m(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!af.g(xmlPullParser, str));
        return new lx(m, m2, m3);
    }

    public static String m(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static String n(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                p(xmlPullParser);
            }
        } while (!af.g(xmlPullParser, str));
        return str2;
    }

    public static void p(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (af.h(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (af.h(xmlPullParser)) {
                    i++;
                } else if (af.f(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int q(org.xmlpull.v1.XmlPullParser r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lw.q(org.xmlpull.v1.XmlPullParser):int");
    }

    public static final long r(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public static final List s(XmlPullParser xmlPullParser, List list, boolean z) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "serviceLocation");
        String n = n(xmlPullParser, "BaseURL");
        if (af.n(n)) {
            if (attributeValue3 == null) {
                attributeValue3 = n;
            }
            return axo.u(new lt(n, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            lt ltVar = (lt) list.get(i);
            String m = af.m(ltVar.a, n);
            String str = attributeValue3 == null ? m : attributeValue3;
            if (z) {
                parseInt = ltVar.c;
                parseInt2 = ltVar.d;
                str = ltVar.b;
            }
            arrayList.add(new lt(m, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0041  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.util.Pair t(org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lw.t(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public static final int u(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return !"text".equals(attributeValue) ? -1 : 3;
    }

    public static long v(XmlPullParser xmlPullParser, String str) throws as {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return -9223372036854775807L;
        }
        return cq.u(attributeValue);
    }

    public static float w(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return -3.4028235E38f;
        }
        return Float.parseFloat(attributeValue);
    }

    public static final mb x(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
            }
            return new mb(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return new mb(attributeValue, j, j2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int y(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r6.hashCode()
            r2 = 1
            r3 = 8
            r4 = 4
            r5 = 2
            switch(r1) {
                case -2060497896: goto L91;
                case -1724546052: goto L86;
                case -1580883024: goto L7b;
                case -1574842690: goto L71;
                case -1408024454: goto L67;
                case -1396432756: goto L5c;
                case 99825: goto L52;
                case 3343801: goto L48;
                case 3530173: goto L3d;
                case 552573414: goto L33;
                case 899152809: goto L28;
                case 1629013393: goto L1d;
                case 1855372047: goto L12;
                default: goto L10;
            }
        L10:
            goto L9c
        L12:
            java.lang.String r1 = "supplementary"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 2
            goto L9d
        L1d:
            java.lang.String r1 = "emergency"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 5
            goto L9d
        L28:
            java.lang.String r1 = "commentary"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 3
            goto L9d
        L33:
            java.lang.String r1 = "caption"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 6
            goto L9d
        L3d:
            java.lang.String r1 = "sign"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 10
            goto L9d
        L48:
            java.lang.String r1 = "main"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 0
            goto L9d
        L52:
            java.lang.String r1 = "dub"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 4
            goto L9d
        L5c:
            java.lang.String r1 = "forced-subtitle"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 8
            goto L9d
        L67:
            java.lang.String r1 = "alternate"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 1
            goto L9d
        L71:
            java.lang.String r1 = "forced_subtitle"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 7
            goto L9d
        L7b:
            java.lang.String r1 = "enhanced-audio-intelligibility"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 12
            goto L9d
        L86:
            java.lang.String r1 = "description"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 11
            goto L9d
        L91:
            java.lang.String r1 = "subtitle"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L9c
            r6 = 9
            goto L9d
        L9c:
            r6 = -1
        L9d:
            switch(r6) {
                case 0: goto Lb9;
                case 1: goto Lb8;
                case 2: goto Lb7;
                case 3: goto Lb6;
                case 4: goto Lb3;
                case 5: goto Lb0;
                case 6: goto Lad;
                case 7: goto Laa;
                case 8: goto Laa;
                case 9: goto Laa;
                case 10: goto La7;
                case 11: goto La4;
                case 12: goto La1;
                default: goto La0;
            }
        La0:
            return r0
        La1:
            r6 = 2048(0x800, float:2.87E-42)
            return r6
        La4:
            r6 = 512(0x200, float:7.175E-43)
            return r6
        La7:
            r6 = 256(0x100, float:3.59E-43)
            return r6
        Laa:
            r6 = 128(0x80, float:1.794E-43)
            return r6
        Lad:
            r6 = 64
            return r6
        Lb0:
            r6 = 32
            return r6
        Lb3:
            r6 = 16
            return r6
        Lb6:
            return r3
        Lb7:
            return r4
        Lb8:
            return r5
        Lb9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lw.y(java.lang.String):int");
    }

    public static final int z(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (com.google.ads.interactivemedia.v3.impl.data.k.f("http://dashif.org/guidelines/trickmode", ((lx) list.get(i2)).a)) {
                i = 16384;
            }
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0086, code lost:
    
        r5 = "audio/eac3-joc";
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.s f(java.lang.String r17, java.lang.String r18, int r19, int r20, float r21, int r22, int r23, int r24, java.lang.String r25, java.util.List r26, java.util.List r27, java.lang.String r28, java.util.List r29, java.util.List r30) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lw.f(java.lang.String, java.lang.String, int, int, float, int, int, int, java.lang.String, java.util.List, java.util.List, java.lang.String, java.util.List, java.util.List):com.google.ads.interactivemedia.v3.internal.s");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:173:0x11a6 A[LOOP:5: B:164:0x0545->B:173:0x11a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x102a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0e55 A[LOOP:11: B:303:0x0a42->B:312:0x0e55, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0db9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x16a4 A[LOOP:1: B:46:0x015e->B:55:0x16a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x1664 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.lu a(android.net.Uri r166, java.io.InputStream r167) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 5906
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lw.a(android.net.Uri, java.io.InputStream):com.google.ads.interactivemedia.v3.internal.lu");
    }

    public final mb i(XmlPullParser xmlPullParser) {
        return x(xmlPullParser, "sourceURL", "range");
    }

    public final mg j(XmlPullParser xmlPullParser, mg mgVar, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long e = e(xmlPullParser, "timescale", mgVar != null ? mgVar.i : 1L);
        long e2 = e(xmlPullParser, "presentationTimeOffset", mgVar != null ? mgVar.j : 0L);
        long e3 = e(xmlPullParser, "duration", mgVar != null ? mgVar.b : -9223372036854775807L);
        long e4 = e(xmlPullParser, "startNumber", mgVar != null ? mgVar.a : 1L);
        long C = C(j3, j4);
        List list = null;
        List list2 = null;
        mb mbVar = null;
        do {
            xmlPullParser.next();
            if (af.i(xmlPullParser, "Initialization")) {
                mbVar = i(xmlPullParser);
            } else if (af.i(xmlPullParser, "SegmentTimeline")) {
                list = o(xmlPullParser, e, j2);
            } else if (af.i(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(x(xmlPullParser, "media", "mediaRange"));
            } else {
                p(xmlPullParser);
            }
        } while (!af.g(xmlPullParser, "SegmentList"));
        if (mgVar != null) {
            if (mbVar == null) {
                mbVar = mgVar.h;
            }
            if (list == null) {
                list = mgVar.c;
            }
            if (list2 == null) {
                list2 = mgVar.e;
            }
        }
        return new mg(mbVar, e, e2, e4, e3, list, C, list2, cq.t(j5), cq.t(j));
    }

    public final mh k(XmlPullParser xmlPullParser, mh mhVar, List list, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long j6;
        long e = e(xmlPullParser, "timescale", mhVar != null ? mhVar.i : 1L);
        long e2 = e(xmlPullParser, "presentationTimeOffset", mhVar != null ? mhVar.j : 0L);
        long e3 = e(xmlPullParser, "duration", mhVar != null ? mhVar.b : -9223372036854775807L);
        long e4 = e(xmlPullParser, "startNumber", mhVar != null ? mhVar.a : 1L);
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                j6 = -1;
                break;
            }
            lx lxVar = (lx) list.get(i);
            if (com.google.ads.interactivemedia.v3.impl.data.k.f("http://dashif.org/guidelines/last-segment-number", lxVar.a)) {
                j6 = Long.parseLong(lxVar.b);
                break;
            }
            i++;
        }
        long j7 = j6;
        long C = C(j3, j4);
        List list2 = null;
        mn A = A(xmlPullParser, "media", mhVar != null ? mhVar.f : null);
        mn A2 = A(xmlPullParser, "initialization", mhVar != null ? mhVar.e : null);
        mb mbVar = null;
        do {
            xmlPullParser.next();
            if (af.i(xmlPullParser, "Initialization")) {
                mbVar = i(xmlPullParser);
            } else if (af.i(xmlPullParser, "SegmentTimeline")) {
                list2 = o(xmlPullParser, e, j2);
            } else {
                p(xmlPullParser);
            }
        } while (!af.g(xmlPullParser, "SegmentTemplate"));
        if (mhVar != null) {
            if (mbVar == null) {
                mbVar = mhVar.h;
            }
            if (list2 == null) {
                list2 = mhVar.c;
            }
        }
        return new mh(mbVar, e, e2, e4, j7, e3, list2, C, A2, A, cq.t(j5), cq.t(j));
    }

    public final mj l(XmlPullParser xmlPullParser, mj mjVar) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long e = e(xmlPullParser, "timescale", mjVar != null ? mjVar.i : 1L);
        long e2 = e(xmlPullParser, "presentationTimeOffset", mjVar != null ? mjVar.j : 0L);
        long j3 = mjVar != null ? mjVar.a : 0L;
        long j4 = mjVar != null ? mjVar.b : 0L;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j2 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j4;
            j2 = j3;
        }
        mb mbVar = mjVar != null ? mjVar.h : null;
        do {
            xmlPullParser.next();
            if (af.i(xmlPullParser, "Initialization")) {
                mbVar = i(xmlPullParser);
            } else {
                p(xmlPullParser);
            }
        } while (!af.g(xmlPullParser, "SegmentBase"));
        return new mj(mbVar, e, e2, j2, j);
    }

    public final List o(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (af.i(xmlPullParser, "S")) {
                long e = e(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    j3 = D(arrayList, j3, j4, i, e);
                }
                if (e == -9223372036854775807L) {
                    e = j3;
                }
                j4 = e(xmlPullParser, "d", -9223372036854775807L);
                i = c(xmlPullParser, "r", 0);
                j3 = e;
                z = true;
            } else {
                p(xmlPullParser);
            }
        } while (!af.g(xmlPullParser, "SegmentTimeline"));
        if (z) {
            D(arrayList, j3, j4, i, cq.w(j2, j, 1000L));
        }
        return arrayList;
    }
}
