package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class qk implements xe {
    private final qg aa;
    private final qd ab;
    private static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern b = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern c = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern d = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern g = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern h = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern l = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern m = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern n = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern o = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern p = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern q = n("CAN-SKIP-DATERANGES");
    private static final Pattern r = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern s = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern t = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern u = n("CAN-BLOCK-RELOAD");
    private static final Pattern v = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern w = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern x = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern y = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern z = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern A = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern B = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern C = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern D = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern E = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern F = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern G = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern H = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern I = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern K = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern L = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern M = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern N = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern O = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern Q = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern R = n("AUTOSELECT");
    private static final Pattern S = n("DEFAULT");
    private static final Pattern T = n("FORCED");
    private static final Pattern U = n("INDEPENDENT");
    private static final Pattern V = n("GAP");
    private static final Pattern W = n("PRECISE");
    private static final Pattern X = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern Y = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern Z = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public qk() {
        qg qgVar = qg.a;
        throw null;
    }

    private static double b(String str, Pattern pattern) throws as {
        return Double.parseDouble(l(str, pattern, Collections.emptyMap()));
    }

    private static int c(String str, Pattern pattern) throws as {
        return Integer.parseInt(l(str, pattern, Collections.emptyMap()));
    }

    private static int d(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !cq.Z(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static n e(String str, String str2, Map map) throws as {
        String k2 = k(str, H, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String l2 = l(str, I, map);
            return new n(i.d, "video/mp4", Base64.decode(l2.substring(l2.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new n(i.d, "hls", cq.ad(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(k2)) {
            return null;
        }
        String l3 = l(str, I, map);
        byte[] decode = Base64.decode(l3.substring(l3.indexOf(44)), 0);
        UUID uuid = i.e;
        return new n(uuid, "video/mp4", acz.d(uuid, decode));
    }

    private static o f(String str, n[] nVarArr) {
        n[] nVarArr2 = new n[nVarArr.length];
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            nVarArr2[i2] = nVarArr[i2].a(null);
        }
        return new o(str, nVarArr2);
    }

    private static qd g(qg qgVar, qd qdVar, qj qjVar, String str) throws IOException {
        Map map;
        py pyVar;
        ArrayList arrayList;
        List list;
        String str2;
        HashMap hashMap;
        boolean z2;
        long j2;
        String str3;
        String str4;
        String str5;
        ArrayList arrayList2;
        List list2;
        String l2;
        String str6;
        long j3;
        long j4;
        Map map2;
        String str7;
        String j5;
        HashMap hashMap2;
        py pyVar2;
        String str8;
        int i2;
        qg qgVar2 = qgVar;
        qd qdVar2 = qdVar;
        boolean z3 = qgVar2.v;
        Map hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        List arrayList6 = new ArrayList();
        qc qcVar = new qc(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        String str9 = "";
        boolean z4 = z3;
        qc qcVar2 = qcVar;
        String str10 = "";
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = -1;
        int i3 = 0;
        String str11 = null;
        boolean z5 = false;
        long j15 = -9223372036854775807L;
        boolean z6 = false;
        int i4 = 0;
        int i5 = 1;
        long j16 = -9223372036854775807L;
        long j17 = -9223372036854775807L;
        boolean z7 = false;
        o oVar = null;
        String str12 = null;
        boolean z8 = false;
        String str13 = null;
        String str14 = null;
        int i6 = 0;
        boolean z9 = false;
        qa qaVar = null;
        ArrayList arrayList7 = arrayList4;
        py pyVar3 = null;
        while (qjVar.b()) {
            String a2 = qjVar.a();
            if (a2.startsWith("#EXT")) {
                arrayList6.add(a2);
            }
            if (a2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String l3 = l(a2, o, hashMap3);
                if ("VOD".equals(l3)) {
                    i3 = 1;
                } else if ("EVENT".equals(l3)) {
                    i3 = 2;
                } else {
                    map = hashMap3;
                    pyVar = pyVar3;
                    arrayList = arrayList7;
                    list = arrayList6;
                    str2 = str13;
                    hashMap = hashMap4;
                    z2 = z5;
                    j2 = j11;
                    str3 = str11;
                    str4 = str14;
                    str5 = str9;
                }
            } else if (a2.equals("#EXT-X-I-FRAMES-ONLY")) {
                z9 = true;
            } else {
                if (a2.startsWith("#EXT-X-START")) {
                    double b2 = b(a2, A);
                    arrayList2 = arrayList7;
                    list2 = arrayList6;
                    z5 = o(a2, W);
                    j15 = (long) (b2 * 1000000.0d);
                } else {
                    arrayList2 = arrayList7;
                    list2 = arrayList6;
                    if (a2.startsWith("#EXT-X-SERVER-CONTROL")) {
                        double p2 = p(a2, p);
                        long j18 = p2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (p2 * 1000000.0d);
                        boolean o2 = o(a2, q);
                        double p3 = p(a2, s);
                        long j19 = p3 == -9.223372036854776E18d ? -9223372036854775807L : (long) (p3 * 1000000.0d);
                        double p4 = p(a2, t);
                        qcVar2 = new qc(j18, o2, j19, p4 == -9.223372036854776E18d ? -9223372036854775807L : (long) (p4 * 1000000.0d), o(a2, u));
                    } else if (a2.startsWith("#EXT-X-PART-INF")) {
                        j17 = (long) (b(a2, m) * 1000000.0d);
                    } else {
                        if (a2.startsWith("#EXT-X-MAP")) {
                            String l4 = l(a2, I, hashMap3);
                            String j20 = j(a2, C, hashMap3);
                            if (j20 != null) {
                                String[] ak = cq.ak(j20, "@");
                                j14 = Long.parseLong(ak[0]);
                                if (ak.length > 1) {
                                    j8 = Long.parseLong(ak[1]);
                                }
                            }
                            if (j14 == -1) {
                                j8 = 0;
                            }
                            String str15 = str13;
                            if (str11 != null && str15 == null) {
                                throw as.c("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                            }
                            qaVar = new qa(l4, j8, j14, str11, str15);
                            if (j14 != -1) {
                                j8 += j14;
                            }
                            str13 = str15;
                            arrayList6 = list2;
                            j14 = -1;
                        } else {
                            str2 = str13;
                            z2 = z5;
                            list = list2;
                            String str16 = str11;
                            if (a2.startsWith("#EXT-X-TARGETDURATION")) {
                                j16 = c(a2, k) * 1000000;
                            } else if (a2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                                j11 = Long.parseLong(l(a2, v, Collections.emptyMap()));
                                z5 = z2;
                                j7 = j11;
                                str11 = str16;
                                arrayList6 = list;
                                str13 = str2;
                            } else if (a2.startsWith("#EXT-X-VERSION")) {
                                i5 = c(a2, n);
                            } else if (a2.startsWith("#EXT-X-DEFINE")) {
                                String j21 = j(a2, Y, hashMap3);
                                if (j21 != null) {
                                    l2 = (String) qgVar2.j.get(j21);
                                    if (l2 != null) {
                                    }
                                    map = hashMap3;
                                    hashMap = hashMap4;
                                    pyVar = pyVar3;
                                    arrayList = arrayList2;
                                    str4 = str14;
                                    j2 = j11;
                                    str3 = str16;
                                    str5 = str9;
                                } else {
                                    j21 = l(a2, N, hashMap3);
                                    l2 = l(a2, X, hashMap3);
                                }
                                hashMap3.put(j21, l2);
                                map = hashMap3;
                                hashMap = hashMap4;
                                pyVar = pyVar3;
                                arrayList = arrayList2;
                                str4 = str14;
                                j2 = j11;
                                str3 = str16;
                                str5 = str9;
                            } else if (a2.startsWith("#EXTINF")) {
                                j13 = new BigDecimal(l(a2, w, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
                                str10 = k(a2, x, str9, hashMap3);
                            } else if (a2.startsWith("#EXT-X-SKIP")) {
                                int c2 = c(a2, r);
                                af.w(qdVar2 != null && arrayList3.isEmpty());
                                int i7 = cq.a;
                                int i8 = (int) (j7 - qdVar2.h);
                                int i9 = c2 + i8;
                                if (i8 < 0 || i9 > qdVar2.o.size()) {
                                    throw new qi();
                                }
                                while (i8 < i9) {
                                    qa qaVar2 = (qa) qdVar2.o.get(i8);
                                    if (j7 != qdVar2.h) {
                                        int i10 = (qdVar2.g - i4) + qaVar2.f;
                                        ArrayList arrayList8 = new ArrayList();
                                        long j22 = j10;
                                        int i11 = 0;
                                        while (i11 < qaVar2.b.size()) {
                                            py pyVar4 = (py) qaVar2.b.get(i11);
                                            arrayList8.add(new py(pyVar4.c, pyVar4.d, pyVar4.e, i10, j22, pyVar4.h, pyVar4.i, pyVar4.j, pyVar4.k, pyVar4.l, pyVar4.m, pyVar4.a, pyVar4.b));
                                            j22 += pyVar4.e;
                                            i11++;
                                            str2 = str2;
                                            i9 = i9;
                                            hashMap4 = hashMap4;
                                            pyVar3 = pyVar3;
                                        }
                                        hashMap2 = hashMap4;
                                        pyVar2 = pyVar3;
                                        str8 = str2;
                                        i2 = i9;
                                        qaVar2 = new qa(qaVar2.c, qaVar2.d, qaVar2.a, qaVar2.e, i10, j10, qaVar2.h, qaVar2.i, qaVar2.j, qaVar2.k, qaVar2.l, qaVar2.m, arrayList8);
                                    } else {
                                        hashMap2 = hashMap4;
                                        pyVar2 = pyVar3;
                                        str8 = str2;
                                        i2 = i9;
                                    }
                                    arrayList3.add(qaVar2);
                                    j10 += qaVar2.e;
                                    long j23 = qaVar2.l;
                                    if (j23 != -1) {
                                        j8 = qaVar2.k + j23;
                                    }
                                    int i12 = qaVar2.f;
                                    qa qaVar3 = qaVar2.d;
                                    String str17 = qaVar2.h;
                                    String str18 = qaVar2.i;
                                    String str19 = qaVar2.j;
                                    str2 = (str19 == null || !str19.equals(Long.toHexString(j11))) ? qaVar2.j : str8;
                                    j11++;
                                    i8++;
                                    i6 = i12;
                                    qaVar = qaVar3;
                                    str12 = str17;
                                    str16 = str18;
                                    i9 = i2;
                                    j9 = j10;
                                    hashMap4 = hashMap2;
                                    pyVar3 = pyVar2;
                                    qdVar2 = qdVar;
                                }
                                String str20 = str2;
                                qgVar2 = qgVar;
                                qdVar2 = qdVar;
                                arrayList7 = arrayList2;
                                z5 = z2;
                                str11 = str16;
                                arrayList6 = list;
                                str13 = str20;
                            } else {
                                HashMap hashMap5 = hashMap4;
                                pyVar = pyVar3;
                                if (a2.startsWith("#EXT-X-KEY")) {
                                    String l5 = l(a2, F, hashMap3);
                                    String k2 = k(a2, G, "identity", hashMap3);
                                    if ("NONE".equals(l5)) {
                                        treeMap.clear();
                                        j5 = null;
                                        str11 = null;
                                    } else {
                                        j5 = j(a2, J, hashMap3);
                                        if ("identity".equals(k2)) {
                                            if ("AES-128".equals(l5)) {
                                                str11 = l(a2, I, hashMap3);
                                            }
                                            qgVar2 = qgVar;
                                            qdVar2 = qdVar;
                                            arrayList7 = arrayList2;
                                            z5 = z2;
                                            arrayList6 = list;
                                            hashMap4 = hashMap5;
                                            str13 = j5;
                                            pyVar3 = pyVar;
                                        } else {
                                            String str21 = str14;
                                            str14 = str21 == null ? i(l5) : str21;
                                            n e2 = e(a2, k2, hashMap3);
                                            if (e2 != null) {
                                                treeMap.put(k2, e2);
                                                str11 = null;
                                            }
                                        }
                                        str11 = null;
                                        qgVar2 = qgVar;
                                        qdVar2 = qdVar;
                                        arrayList7 = arrayList2;
                                        z5 = z2;
                                        arrayList6 = list;
                                        hashMap4 = hashMap5;
                                        str13 = j5;
                                        pyVar3 = pyVar;
                                    }
                                    str12 = str11;
                                    qgVar2 = qgVar;
                                    qdVar2 = qdVar;
                                    arrayList7 = arrayList2;
                                    z5 = z2;
                                    arrayList6 = list;
                                    hashMap4 = hashMap5;
                                    str13 = j5;
                                    pyVar3 = pyVar;
                                } else {
                                    str4 = str14;
                                    if (a2.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] ak2 = cq.ak(l(a2, B, hashMap3), "@");
                                        j14 = Long.parseLong(ak2[0]);
                                        if (ak2.length > 1) {
                                            j8 = Long.parseLong(ak2[1]);
                                        }
                                    } else {
                                        if (a2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                            i4 = Integer.parseInt(a2.substring(a2.indexOf(58) + 1));
                                            qgVar2 = qgVar;
                                            qdVar2 = qdVar;
                                            str14 = str4;
                                            z5 = z2;
                                            str11 = str16;
                                            arrayList6 = list;
                                            hashMap4 = hashMap5;
                                            pyVar3 = pyVar;
                                            z6 = true;
                                        } else if (a2.equals("#EXT-X-DISCONTINUITY")) {
                                            i6++;
                                        } else {
                                            if (a2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                                if (j6 == 0) {
                                                    j6 = cq.t(cq.u(a2.substring(a2.indexOf(58) + 1))) - j10;
                                                }
                                            } else if (a2.equals("#EXT-X-GAP")) {
                                                qgVar2 = qgVar;
                                                qdVar2 = qdVar;
                                                str14 = str4;
                                                z5 = z2;
                                                str11 = str16;
                                                arrayList6 = list;
                                                hashMap4 = hashMap5;
                                                pyVar3 = pyVar;
                                                z8 = true;
                                            } else if (a2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                                qgVar2 = qgVar;
                                                qdVar2 = qdVar;
                                                str14 = str4;
                                                z5 = z2;
                                                str11 = str16;
                                                arrayList6 = list;
                                                hashMap4 = hashMap5;
                                                pyVar3 = pyVar;
                                                z4 = true;
                                            } else if (a2.equals("#EXT-X-ENDLIST")) {
                                                qgVar2 = qgVar;
                                                qdVar2 = qdVar;
                                                str14 = str4;
                                                z5 = z2;
                                                str11 = str16;
                                                arrayList6 = list;
                                                hashMap4 = hashMap5;
                                                pyVar3 = pyVar;
                                                z7 = true;
                                            } else if (a2.startsWith("#EXT-X-RENDITION-REPORT")) {
                                                arrayList5.add(new pz(Uri.parse(af.m(str, l(a2, I, hashMap3))), r(a2, y), q(a2, z)));
                                            } else {
                                                if (!a2.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                    str5 = str9;
                                                    j2 = j11;
                                                    str3 = str16;
                                                    if (a2.startsWith("#EXT-X-PART")) {
                                                        String h2 = h(j2, str3, str2);
                                                        String l6 = l(a2, I, hashMap3);
                                                        long b3 = (long) (b(a2, l) * 1000000.0d);
                                                        boolean o3 = o(a2, U) | (z4 && arrayList2.isEmpty());
                                                        boolean o4 = o(a2, V);
                                                        String j24 = j(a2, C, hashMap3);
                                                        if (j24 != null) {
                                                            String[] ak3 = cq.ak(j24, "@");
                                                            j3 = Long.parseLong(ak3[0]);
                                                            if (ak3.length > 1) {
                                                                j12 = Long.parseLong(ak3[1]);
                                                            }
                                                        } else {
                                                            j3 = -1;
                                                        }
                                                        if (j3 == -1) {
                                                            j12 = 0;
                                                        }
                                                        if (str12 == null && !treeMap.isEmpty()) {
                                                            n[] nVarArr = (n[]) treeMap.values().toArray(new n[0]);
                                                            String oVar2 = new o(str4, nVarArr);
                                                            if (oVar == null) {
                                                                oVar = f(str4, nVarArr);
                                                            }
                                                            str12 = oVar2;
                                                        }
                                                        arrayList = arrayList2;
                                                        arrayList.add(new py(l6, qaVar, b3, i6, j9, str12, str3, h2, j12, j3, o4, o3, false));
                                                        j9 += b3;
                                                        if (j3 != -1) {
                                                            j12 += j3;
                                                        }
                                                        qgVar2 = qgVar;
                                                        qdVar2 = qdVar;
                                                        j11 = j2;
                                                        str9 = str5;
                                                        arrayList6 = list;
                                                        hashMap4 = hashMap5;
                                                        pyVar3 = pyVar;
                                                        str14 = str4;
                                                        str11 = str3;
                                                        z5 = z2;
                                                        str13 = str2;
                                                        arrayList7 = arrayList;
                                                    } else {
                                                        arrayList = arrayList2;
                                                        if (a2.startsWith("#")) {
                                                            map = hashMap3;
                                                        } else {
                                                            String h3 = h(j2, str3, str2);
                                                            j11 = j2 + 1;
                                                            String m2 = m(a2, hashMap3);
                                                            qa qaVar4 = (qa) hashMap5.get(m2);
                                                            if (j14 == -1) {
                                                                j4 = 0;
                                                            } else {
                                                                if (z9 && qaVar == null && qaVar4 == null) {
                                                                    qaVar4 = new qa(m2, 0L, j8, null, null);
                                                                    hashMap5.put(m2, qaVar4);
                                                                }
                                                                j4 = j8;
                                                            }
                                                            if (str12 != null || treeMap.isEmpty()) {
                                                                map2 = hashMap3;
                                                                str7 = str12;
                                                            } else {
                                                                map2 = hashMap3;
                                                                n[] nVarArr2 = (n[]) treeMap.values().toArray(new n[0]);
                                                                str7 = new o(str4, nVarArr2);
                                                                if (oVar == null) {
                                                                    oVar = f(str4, nVarArr2);
                                                                }
                                                            }
                                                            arrayList3.add(new qa(m2, qaVar != null ? qaVar : qaVar4, str10, j13, i6, j10, str7, str3, h3, j4, j14, z8, arrayList));
                                                            j9 = j10 + j13;
                                                            ArrayList arrayList9 = new ArrayList();
                                                            if (j14 != -1) {
                                                                j4 += j14;
                                                            }
                                                            j8 = j4;
                                                            qdVar2 = qdVar;
                                                            hashMap4 = hashMap5;
                                                            str12 = str7;
                                                            j13 = 0;
                                                            j14 = -1;
                                                            j10 = j9;
                                                            hashMap3 = map2;
                                                            str9 = str5;
                                                            str10 = str9;
                                                            arrayList6 = list;
                                                            pyVar3 = pyVar;
                                                            z8 = false;
                                                            str14 = str4;
                                                            str11 = str3;
                                                            z5 = z2;
                                                            str13 = str2;
                                                            arrayList7 = arrayList9;
                                                            qgVar2 = qgVar;
                                                        }
                                                    }
                                                } else if (pyVar == null && "PART".equals(l(a2, L, hashMap3))) {
                                                    String l7 = l(a2, I, hashMap3);
                                                    long r2 = r(a2, D);
                                                    long r3 = r(a2, E);
                                                    long j25 = j11;
                                                    String h4 = h(j25, str16, str2);
                                                    if (str12 != null || treeMap.isEmpty()) {
                                                        str6 = str9;
                                                    } else {
                                                        str6 = str9;
                                                        n[] nVarArr3 = (n[]) treeMap.values().toArray(new n[0]);
                                                        String oVar3 = new o(str4, nVarArr3);
                                                        if (oVar == null) {
                                                            oVar = f(str4, nVarArr3);
                                                        }
                                                        str12 = oVar3;
                                                    }
                                                    qdVar2 = qdVar;
                                                    j11 = j25;
                                                    str9 = str6;
                                                    arrayList6 = list;
                                                    hashMap4 = hashMap5;
                                                    pyVar3 = (r2 == -1 || r3 != -1) ? new py(l7, qaVar, 0L, i6, j9, str12, str16, h4, r2 != -1 ? r2 : 0L, r3, false, false, true) : null;
                                                    str14 = str4;
                                                    str11 = str16;
                                                    z5 = z2;
                                                    qgVar2 = qgVar;
                                                } else {
                                                    str5 = str9;
                                                    j2 = j11;
                                                    str3 = str16;
                                                    map = hashMap3;
                                                    arrayList = arrayList2;
                                                }
                                                hashMap = hashMap5;
                                            }
                                            map = hashMap3;
                                            str5 = str9;
                                            arrayList = arrayList2;
                                            j2 = j11;
                                            str3 = str16;
                                            hashMap = hashMap5;
                                        }
                                        str13 = str2;
                                    }
                                    qgVar2 = qgVar;
                                    qdVar2 = qdVar;
                                    str14 = str4;
                                    z5 = z2;
                                    str11 = str16;
                                    arrayList6 = list;
                                    hashMap4 = hashMap5;
                                    pyVar3 = pyVar;
                                    str13 = str2;
                                }
                            }
                            z5 = z2;
                            str11 = str16;
                            arrayList6 = list;
                            str13 = str2;
                        }
                        arrayList7 = arrayList2;
                    }
                }
                arrayList6 = list2;
                arrayList7 = arrayList2;
            }
            qgVar2 = qgVar;
            qdVar2 = qdVar;
            j11 = j2;
            hashMap4 = hashMap;
            hashMap3 = map;
            str9 = str5;
            arrayList6 = list;
            pyVar3 = pyVar;
            str14 = str4;
            str11 = str3;
            z5 = z2;
            str13 = str2;
            arrayList7 = arrayList;
        }
        py pyVar5 = pyVar3;
        ArrayList arrayList10 = arrayList7;
        List list3 = arrayList6;
        boolean z10 = z5;
        HashMap hashMap6 = new HashMap();
        for (int i13 = 0; i13 < arrayList5.size(); i13++) {
            pz pzVar = (pz) arrayList5.get(i13);
            long j26 = pzVar.b;
            if (j26 == -1) {
                j26 = (j7 + arrayList3.size()) - (arrayList10.isEmpty() ? 1L : 0L);
            }
            int i14 = pzVar.c;
            if (i14 == -1) {
                i14 = j17 != -9223372036854775807L ? (arrayList10.isEmpty() ? ((qa) axo.z(arrayList3)).b : arrayList10).size() - 1 : -1;
            }
            Uri uri = pzVar.a;
            hashMap6.put(uri, new pz(uri, j26, i14));
        }
        if (pyVar5 != null) {
            arrayList10.add(pyVar5);
        }
        return new qd(i3, str, list3, j15, z10, j6, z6, i4, j7, i5, j16, j17, z4, z7, j6 != 0, oVar, arrayList3, arrayList10, qcVar2, hashMap6);
    }

    private static String h(long j2, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    private static String i(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static String j(String str, Pattern pattern, Map map) {
        return k(str, pattern, null, map);
    }

    private static String k(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            af.s(str2);
        }
        return (map.isEmpty() || str2 == null) ? str2 : m(str2, map);
    }

    private static String l(String str, Pattern pattern, Map map) throws as {
        String j2 = j(str, pattern, map);
        if (j2 != null) {
            return j2;
        }
        throw as.c("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    private static String m(String str, Map map) {
        Matcher matcher = Z.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static Pattern n(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    private static boolean o(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return false;
    }

    private static double p(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -9.223372036854776E18d;
        }
        String group = matcher.group(1);
        af.s(group);
        return Double.parseDouble(group);
    }

    private static int q(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        String group = matcher.group(1);
        af.s(group);
        return Integer.parseInt(group);
    }

    private static long r(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1L;
        }
        String group = matcher.group(1);
        af.s(group);
        return Long.parseLong(group);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x012c, code lost:
    
        if (r3.startsWith("#EXT-X-SESSION-KEY") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x012e, code lost:
    
        r1 = e(r3, k(r3, com.google.ads.interactivemedia.v3.internal.qk.G, "identity", r8), r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x013a, code lost:
    
        if (r1 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x013c, code lost:
    
        r42 = r9;
        r0.add(new com.google.ads.interactivemedia.v3.internal.o(i(l(r3, com.google.ads.interactivemedia.v3.internal.qk.F, r8)), r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0157, code lost:
    
        r42 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x015d, code lost:
    
        if (r3.startsWith(r4) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x015f, code lost:
    
        if (r1 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0161, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0174, code lost:
    
        r19 = r19 | r3.contains("CLOSED-CAPTIONS=NONE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x017d, code lost:
    
        if (true == r1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x017f, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0183, code lost:
    
        r9 = c(r3, com.google.ads.interactivemedia.v3.internal.qk.f);
        r32 = r4;
        r4 = q(r3, com.google.ads.interactivemedia.v3.internal.qk.a);
        r33 = r0;
        r0 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.h, r8);
        r34 = r15;
        r15 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.i, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a1, code lost:
    
        if (r15 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01a3, code lost:
    
        r35 = r14;
        r14 = com.google.ads.interactivemedia.v3.internal.cq.ak(r15, "x");
        r15 = java.lang.Integer.parseInt(r14[0]);
        r14 = java.lang.Integer.parseInt(r14[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ba, code lost:
    
        if (r15 <= 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01bc, code lost:
    
        if (r14 > 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01c0, code lost:
    
        r23 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01c2, code lost:
    
        r36 = r13;
        r14 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cd, code lost:
    
        r13 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.j, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01d3, code lost:
    
        if (r13 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01d5, code lost:
    
        r13 = java.lang.Float.parseFloat(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01d9, code lost:
    
        r37 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01df, code lost:
    
        r10 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.b, r8);
        r38 = r6;
        r6 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.c, r8);
        r6 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.d, r8);
        r6 = j(r3, com.google.ads.interactivemedia.v3.internal.qk.e, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01fd, code lost:
    
        if (r1 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01ff, code lost:
    
        r1 = l(r3, com.google.ads.interactivemedia.v3.internal.qk.I, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0205, code lost:
    
        r1 = com.google.ads.interactivemedia.v3.internal.af.l(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0219, code lost:
    
        r3 = new com.google.ads.interactivemedia.v3.internal.r();
        r40 = r7;
        r3.R(r11.size());
        r3.K("application/x-mpegURL");
        r3.I(r0);
        r3.G(r4);
        r3.Z(r9);
        r3.aj(r15);
        r3.Q(r14);
        r3.P(r13);
        r3.ac(r5);
        r11.add(new com.google.ads.interactivemedia.v3.internal.qf(r1, r3.v(), r10, r6, r6, r6));
        r0 = r38;
        r2 = (java.util.ArrayList) r0.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x025f, code lost:
    
        if (r2 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0261, code lost:
    
        r2 = new java.util.ArrayList();
        r0.put(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0269, code lost:
    
        r2.add(new com.google.ads.interactivemedia.v3.internal.pm(r4, r9, r10, r6, r6, r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x020e, code lost:
    
        if (r7.b() == false) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0210, code lost:
    
        r1 = m(r7.a(), r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x029f, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.as.c("#EXT-X-STREAM-INF must be followed by another line", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01dc, code lost:
    
        r13 = -1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01be, code lost:
    
        r15 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01c7, code lost:
    
        r35 = r14;
        r36 = r13;
        r14 = -1;
        r15 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0181, code lost:
    
        r5 = 16384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00ca, code lost:
    
        r9.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00ce, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0035, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02a5, code lost:
    
        r33 = r0;
        r24 = r5;
        r0 = r6;
        r42 = r9;
        r37 = r10;
        r36 = r13;
        r35 = r14;
        r34 = r15;
        r14 = new java.util.ArrayList();
        r1 = new java.util.HashSet();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02c3, code lost:
    
        if (r3 >= r11.size()) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02c5, code lost:
    
        r4 = (com.google.ads.interactivemedia.v3.internal.qf) r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02d1, code lost:
    
        if (r1.add(r4.a) == false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02d7, code lost:
    
        if (r4.b.j != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02d9, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02dc, code lost:
    
        com.google.ads.interactivemedia.v3.internal.af.w(r5);
        r6 = (java.util.ArrayList) r0.get(r4.a);
        com.google.ads.interactivemedia.v3.internal.af.s(r6);
        r6 = new com.google.ads.interactivemedia.v3.internal.ao(new com.google.ads.interactivemedia.v3.internal.pn(null, null, r6));
        r5 = r4.b.b();
        r5.X(r6);
        r14.add(new com.google.ads.interactivemedia.v3.internal.qf(r4.a, r5.v(), r4.c, r4.d, r4.e, r4.f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0326, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02db, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0329, code lost:
    
        r0 = null;
        r1 = null;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0330, code lost:
    
        if (r5 >= r37.size()) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0332, code lost:
    
        r3 = r37;
        r4 = (java.lang.String) r3.get(r5);
        r6 = l(r4, com.google.ads.interactivemedia.v3.internal.qk.O, r8);
        r7 = l(r4, com.google.ads.interactivemedia.v3.internal.qk.N, r8);
        r9 = new com.google.ads.interactivemedia.v3.internal.r();
        r9.S(r6 + ":" + r7);
        r9.U(r7);
        r9.K(r2);
        r10 = o(r4, com.google.ads.interactivemedia.v3.internal.qk.S);
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0374, code lost:
    
        if (o(r4, com.google.ads.interactivemedia.v3.internal.qk.T) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0376, code lost:
    
        r10 = (r10 ? 1 : 0) | 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0378, code lost:
    
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x037e, code lost:
    
        if (o(r4, com.google.ads.interactivemedia.v3.internal.qk.R) == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0380, code lost:
    
        r10 = (r10 == true ? 1 : 0) | 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0382, code lost:
    
        r9.ag(r10);
        r10 = j(r4, com.google.ads.interactivemedia.v3.internal.qk.P, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x038f, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0391, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03c5, code lost:
    
        r9.ac(r13);
        r9.V(j(r4, com.google.ads.interactivemedia.v3.internal.qk.M, r8));
        r10 = j(r4, com.google.ads.interactivemedia.v3.internal.qk.I, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03d7, code lost:
    
        if (r10 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03d9, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03df, code lost:
    
        r25 = r2;
        r37 = r3;
        r13 = new com.google.ads.interactivemedia.v3.internal.ao(new com.google.ads.interactivemedia.v3.internal.pn(r6, r7, java.util.Collections.emptyList()));
        r2 = l(r4, com.google.ads.interactivemedia.v3.internal.qk.K, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0402, code lost:
    
        switch(r2.hashCode()) {
            case -959297733: goto L149;
            case -333210994: goto L146;
            case 62628790: goto L143;
            case 81665115: goto L140;
            default: goto L152;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x040c, code lost:
    
        if (r2.equals("VIDEO") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x040e, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x042f, code lost:
    
        if (r2 == 0) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0432, code lost:
    
        if (r2 == 1) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0435, code lost:
    
        if (r2 == 2) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0437, code lost:
    
        if (r2 == 3) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0439, code lost:
    
        r26 = r1;
        r4 = r34;
        r2 = r35;
        r3 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x05d3, code lost:
    
        r1 = r26;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x05d6, code lost:
    
        r5 = r5 + r9;
        r35 = r2;
        r36 = r3;
        r34 = r4;
        r2 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0444, code lost:
    
        r2 = l(r4, com.google.ads.interactivemedia.v3.internal.qk.Q, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0450, code lost:
    
        if (r2.startsWith("CC") == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0452, code lost:
    
        r3 = "application/cea-608";
        r2 = java.lang.Integer.parseInt(r2.substring(2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x046a, code lost:
    
        if (r1 != null) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x046c, code lost:
    
        r1 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0471, code lost:
    
        r9.ae(r3);
        r9.F(r2);
        r1.add(r9.v());
        r4 = r34;
        r2 = r35;
        r3 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0484, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x045f, code lost:
    
        r3 = "application/cea-708";
        r2 = java.lang.Integer.parseInt(r2.substring(7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0488, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x048e, code lost:
    
        if (r2 >= r11.size()) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0490, code lost:
    
        r3 = (com.google.ads.interactivemedia.v3.internal.qf) r11.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x049c, code lost:
    
        if (r6.equals(r3.e) == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x049f, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04a4, code lost:
    
        if (r3 == null) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04a6, code lost:
    
        r2 = com.google.ads.interactivemedia.v3.internal.cq.K(r3.b.i, 3);
        r9.I(r2);
        r2 = com.google.ads.interactivemedia.v3.internal.ar.g(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x04b9, code lost:
    
        if (r2 != null) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x04bb, code lost:
    
        r2 = "text/vtt";
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x04bc, code lost:
    
        r9.ae(r2);
        r9.X(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x04c2, code lost:
    
        if (r10 == null) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x04c4, code lost:
    
        r3 = r36;
        r3.add(new com.google.ads.interactivemedia.v3.internal.qe(r10, r9.v(), r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x04d2, code lost:
    
        r26 = r1;
        r4 = r34;
        r2 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x04da, code lost:
    
        r3 = r36;
        com.google.ads.interactivemedia.v3.internal.cd.e("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x04b6, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x04a3, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x04e4, code lost:
    
        r3 = r36;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x04eb, code lost:
    
        if (r15 >= r11.size()) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x04ed, code lost:
    
        r2 = (com.google.ads.interactivemedia.v3.internal.qf) r11.get(r15);
        r26 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x04fb, code lost:
    
        if (r6.equals(r2.d) == false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04ff, code lost:
    
        r15 = r15 + 1;
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x04fd, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0507, code lost:
    
        if (r1 == null) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0509, code lost:
    
        r2 = com.google.ads.interactivemedia.v3.internal.cq.K(r1.b.i, 1);
        r9.I(r2);
        r2 = com.google.ads.interactivemedia.v3.internal.ar.g(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x051b, code lost:
    
        r4 = j(r4, com.google.ads.interactivemedia.v3.internal.qk.g, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0521, code lost:
    
        if (r4 == null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0523, code lost:
    
        r9.H(java.lang.Integer.parseInt(com.google.ads.interactivemedia.v3.internal.cq.al(r4, "/")[0]));
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0539, code lost:
    
        if ("audio/eac3".equals(r2) == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0541, code lost:
    
        if (r4.endsWith("/JOC") == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0543, code lost:
    
        r2 = "audio/eac3-joc";
        r9.I("ec+3");
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x054c, code lost:
    
        r9.ae(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x054f, code lost:
    
        if (r10 == null) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0551, code lost:
    
        r9.X(r13);
        r2 = r35;
        r2.add(new com.google.ads.interactivemedia.v3.internal.qe(r10, r9.v(), r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0562, code lost:
    
        r4 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0566, code lost:
    
        r2 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0568, code lost:
    
        if (r1 == null) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x056a, code lost:
    
        r0 = r9.v();
        r1 = r26;
        r4 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.cq.Z(d(r5, false, r7)) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x051a, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0504, code lost:
    
        r26 = r1;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0574, code lost:
    
        r26 = r1;
        r2 = r35;
        r3 = r36;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0580, code lost:
    
        if (r1 >= r11.size()) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0582, code lost:
    
        r4 = (com.google.ads.interactivemedia.v3.internal.qf) r11.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x058e, code lost:
    
        if (r6.equals(r4.c) == false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0592, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r7 = r5.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0590, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0597, code lost:
    
        if (r1 == null) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0599, code lost:
    
        r1 = r1.b;
        r4 = com.google.ads.interactivemedia.v3.internal.cq.K(r1.i, 2);
        r9.I(r4);
        r9.ae(com.google.ads.interactivemedia.v3.internal.ar.g(r4));
        r9.aj(r1.q);
        r9.Q(r1.r);
        r9.P(r1.s);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x05bd, code lost:
    
        if (r10 != null) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x05bf, code lost:
    
        r4 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x05c2, code lost:
    
        r9.X(r13);
        r4 = r34;
        r4.add(new com.google.ads.interactivemedia.v3.internal.qe(r10, r9.v(), r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0596, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r7 == null) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0416, code lost:
    
        if (r2.equals("AUDIO") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0418, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0420, code lost:
    
        if (r2.equals("CLOSED-CAPTIONS") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0422, code lost:
    
        r2 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x042a, code lost:
    
        if (r2.equals("SUBTITLES") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x042c, code lost:
    
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x042e, code lost:
    
        r2 = 65535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x03db, code lost:
    
        r10 = com.google.ads.interactivemedia.v3.internal.af.l(r12, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r7 = r7.trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0393, code lost:
    
        r10 = com.google.ads.interactivemedia.v3.internal.cq.ak(r10, ",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x03a0, code lost:
    
        if (true == com.google.ads.interactivemedia.v3.internal.cq.W(r10, "public.accessibility.describes-video")) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03a2, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x03ac, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.cq.W(r10, "public.accessibility.transcribes-spoken-dialog") == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x03ae, code lost:
    
        r13 = r13 | 4096;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x03b6, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.cq.W(r10, "public.accessibility.describes-music-and-sound") == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x03b8, code lost:
    
        r13 = r13 | 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        if (r7.isEmpty() != false) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x03c0, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.cq.W(r10, "public.easy-to-read") == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x03c2, code lost:
    
        r13 = r13 | 8192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x03a4, code lost:
    
        r13 = 512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x05e1, code lost:
    
        r26 = r1;
        r4 = r34;
        r2 = r35;
        r3 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x05e9, code lost:
    
        if (r19 == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05eb, code lost:
    
        r20 = java.util.Collections.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x05f4, code lost:
    
        r1 = new com.google.ads.interactivemedia.v3.internal.qg(r12, r42, r14, r4, r2, r3, r18, r0, r20, r21, r8, r33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0607, code lost:
    
        com.google.ads.interactivemedia.v3.internal.cq.S(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05f2, code lost:
    
        r20 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x02a0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x02a1, code lost:
    
        r24 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0685, code lost:
    
        com.google.ads.interactivemedia.v3.internal.cq.S(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0690, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.as.c("Failed to parse the playlist, could not identify any tags.", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        if (r7.startsWith(r4) == false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x060f, code lost:
    
        r32 = r4;
        r24 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x061b, code lost:
    
        if (r7.startsWith("#EXT-X-TARGETDURATION") != false) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0623, code lost:
    
        if (r7.startsWith("#EXT-X-MEDIA-SEQUENCE") != false) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x062b, code lost:
    
        if (r7.startsWith("#EXTINF") != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0633, code lost:
    
        if (r7.startsWith("#EXT-X-KEY") != false) goto L292;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x063b, code lost:
    
        if (r7.startsWith("#EXT-X-BYTERANGE") != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0643, code lost:
    
        if (r7.equals("#EXT-X-DISCONTINUITY") != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x064b, code lost:
    
        if (r7.equals("#EXT-X-DISCONTINUITY-SEQUENCE") != false) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0653, code lost:
    
        if (r7.equals("#EXT-X-ENDLIST") == false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0656, code lost:
    
        r6.add(r7);
        r5 = r24;
        r4 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0664, code lost:
    
        r6.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0671, code lost:
    
        r0 = g(r41.aa, r41.ab, new com.google.ads.interactivemedia.v3.internal.qj(r6, r24), r42.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x067c, code lost:
    
        com.google.ads.interactivemedia.v3.internal.cq.S(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x067f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0682, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f9, code lost:
    
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0072, code lost:
    
        r6.add(r7);
        r7 = new com.google.ads.interactivemedia.v3.internal.qj(r6, r5);
        r12 = r42.toString();
        r6 = new java.util.HashMap();
        r8 = new java.util.HashMap();
        r11 = new java.util.ArrayList();
        r15 = new java.util.ArrayList();
        r14 = new java.util.ArrayList();
        r13 = new java.util.ArrayList();
        r18 = new java.util.ArrayList();
        r10 = new java.util.ArrayList();
        r0 = new java.util.ArrayList();
        r9 = new java.util.ArrayList();
        r19 = false;
        r21 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b8, code lost:
    
        r2 = "application/x-mpegURL";
        r23 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00bc, code lost:
    
        if (r7.b() == false) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00be, code lost:
    
        r3 = r7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00c8, code lost:
    
        if (r3.startsWith("#EXT") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00d3, code lost:
    
        r1 = r3.startsWith("#EXT-X-I-FRAME-STREAM-INF");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d9, code lost:
    
        r24 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e1, code lost:
    
        if (r3.startsWith("#EXT-X-DEFINE") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00e3, code lost:
    
        r8.put(l(r3, com.google.ads.interactivemedia.v3.internal.qk.N, r8), l(r3, com.google.ads.interactivemedia.v3.internal.qk.X, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00f2, code lost:
    
        r42 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0163, code lost:
    
        r33 = r0;
        r32 = r4;
        r0 = r6;
        r40 = r7;
        r37 = r10;
        r36 = r13;
        r35 = r14;
        r34 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x027f, code lost:
    
        r9 = r42;
        r6 = r0;
        r5 = r24;
        r4 = r32;
        r0 = r33;
        r15 = r34;
        r14 = r35;
        r13 = r36;
        r10 = r37;
        r7 = r40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0103, code lost:
    
        if (r3.equals("#EXT-X-INDEPENDENT-SEGMENTS") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0105, code lost:
    
        r33 = r0;
        r32 = r4;
        r0 = r6;
        r40 = r7;
        r42 = r9;
        r37 = r10;
        r36 = r13;
        r35 = r14;
        r34 = r15;
        r21 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0120, code lost:
    
        if (r3.startsWith("#EXT-X-MEDIA") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0122, code lost:
    
        r10.add(r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[Catch: all -> 0x0034, TryCatch #3 {all -> 0x0034, blocks: (B:3:0x0017, B:6:0x001f, B:8:0x0027, B:10:0x002f, B:15:0x003c, B:18:0x0044, B:20:0x004c, B:23:0x0052, B:25:0x005c, B:27:0x0062, B:30:0x006c), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052 A[EDGE_INSN: B:22:0x0052->B:23:0x0052 BREAK  A[LOOP:0: B:16:0x0041->B:20:0x004c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ java.lang.Object a(android.net.Uri r42, java.io.InputStream r43) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.qk.a(android.net.Uri, java.io.InputStream):java.lang.Object");
    }

    public qk(qg qgVar, qd qdVar) {
        this.aa = qgVar;
        this.ab = qdVar;
    }
}
