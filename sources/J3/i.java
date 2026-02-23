package J3;

import J3.f;
import J3.g;
import O2.l1;
import O2.o;
import V2.m;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import b4.I;
import d4.b0;
import d4.k0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l3.l;
import s5.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements I.a {
    public final g a;
    public final f c;
    public static final Pattern d = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern e = Pattern.compile("VIDEO=\"(.+?)\"");
    public static final Pattern f = Pattern.compile("AUDIO=\"(.+?)\"");
    public static final Pattern g = Pattern.compile("SUBTITLES=\"(.+?)\"");
    public static final Pattern h = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    public static final Pattern i = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern j = Pattern.compile("CHANNELS=\"(.+?)\"");
    public static final Pattern k = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern l = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern m = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern n = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern o = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    public static final Pattern p = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    public static final Pattern q = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern r = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern s = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    public static final Pattern t = c("CAN-SKIP-DATERANGES");
    public static final Pattern u = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    public static final Pattern v = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern w = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern x = c("CAN-BLOCK-RELOAD");
    public static final Pattern y = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern z = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern A = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern B = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern C = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern D = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern E = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern F = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern G = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern H = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern I = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern J = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern K = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern L = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern M = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern N = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern O = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern P = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern Q = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern S = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern T = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern U = c("AUTOSELECT");
    public static final Pattern V = c("DEFAULT");
    public static final Pattern W = c("FORCED");
    public static final Pattern X = c("INDEPENDENT");
    public static final Pattern Y = c("GAP");
    public static final Pattern Z = c("PRECISE");
    public static final Pattern e0 = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern f0 = Pattern.compile("IMPORT=\"(.+?)\"");
    public static final Pattern g0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class a extends IOException {
    }

    public static class b {
        public final BufferedReader a;
        public final Queue b;
        public String c;

        public b(Queue queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        public boolean a() {
            String trim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = (String) d4.a.e((String) this.b.poll());
                return true;
            }
            do {
                String readLine = this.a.readLine();
                this.c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.c;
            this.c = null;
            return str;
        }
    }

    public i() {
        this(g.n, null);
    }

    public static long A(String str, Pattern pattern) {
        return new BigDecimal(z(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    public static String B(String str, Map map) {
        Matcher matcher = g0.matcher(str);
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

    public static int C(BufferedReader bufferedReader, boolean z2, int i2) {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !k0.E0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    public static boolean b(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int C2 = C(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (C2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            C2 = bufferedReader.read();
        }
        return k0.E0(C(bufferedReader, false, C2));
    }

    public static Pattern c(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    public static m d(String str, m.b[] bVarArr) {
        m.b[] bVarArr2 = new m.b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = bVarArr[i2].c(null);
        }
        return new m(str, bVarArr2);
    }

    public static String e(long j2, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    public static g.b f(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            g.b bVar = (g.b) arrayList.get(i2);
            if (str.equals(bVar.d)) {
                return bVar;
            }
        }
        return null;
    }

    public static g.b g(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            g.b bVar = (g.b) arrayList.get(i2);
            if (str.equals(bVar.e)) {
                return bVar;
            }
        }
        return null;
    }

    public static g.b h(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            g.b bVar = (g.b) arrayList.get(i2);
            if (str.equals(bVar.c)) {
                return bVar;
            }
        }
        return null;
    }

    public static double j(String str, Pattern pattern) {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    public static m.b k(String str, String str2, Map map) {
        String u2 = u(str, K, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String z2 = z(str, L, map);
            return new m.b(o.d, "video/mp4", Base64.decode(z2.substring(z2.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new m.b(o.d, "hls", k0.s0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(u2)) {
            return null;
        }
        String z3 = z(str, L, map);
        byte[] decode = Base64.decode(z3.substring(z3.indexOf(44)), 0);
        UUID uuid = o.e;
        return new m.b(uuid, "video/mp4", l.a(uuid, decode));
    }

    public static String l(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    public static int m(String str, Pattern pattern) {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    public static long n(String str, Pattern pattern) {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    public static f o(g gVar, f fVar, b bVar, String str) {
        String z2;
        ArrayList arrayList;
        List list;
        String str2;
        long j2;
        int i2;
        f.b bVar2;
        int i3;
        String v2;
        long j3;
        long j4;
        m mVar;
        long j5;
        long j6;
        g gVar2 = gVar;
        f fVar2 = fVar;
        boolean z3 = gVar2.c;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        List arrayList5 = new ArrayList();
        f.f fVar3 = new f.f(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        boolean z4 = false;
        String str3 = "";
        boolean z5 = z3;
        f.f fVar4 = fVar3;
        String str4 = str3;
        int i4 = 0;
        m mVar2 = null;
        long j7 = -9223372036854775807L;
        boolean z6 = false;
        long j8 = 0;
        boolean z7 = false;
        int i5 = 0;
        long j9 = 0;
        int i6 = 1;
        long j10 = -9223372036854775807L;
        long j11 = -9223372036854775807L;
        boolean z8 = false;
        m mVar3 = null;
        long j12 = 0;
        m mVar4 = null;
        long j13 = 0;
        boolean z9 = false;
        long j14 = -1;
        String str5 = null;
        String str6 = null;
        int i7 = 0;
        long j15 = 0;
        long j16 = 0;
        boolean z10 = false;
        f.d dVar = null;
        long j17 = 0;
        long j18 = 0;
        ArrayList arrayList6 = arrayList3;
        f.b bVar3 = null;
        while (bVar.a()) {
            String b2 = bVar.b();
            if (b2.startsWith("#EXT")) {
                arrayList5.add(b2);
            }
            if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String z11 = z(b2, r, hashMap);
                if ("VOD".equals(z11)) {
                    i4 = 1;
                } else if ("EVENT".equals(z11)) {
                    i4 = 2;
                }
            } else if (b2.equals("#EXT-X-I-FRAMES-ONLY")) {
                z10 = true;
            } else if (b2.startsWith("#EXT-X-START")) {
                j7 = (long) (j(b2, D) * 1000000.0d);
                z6 = q(b2, Z, z4);
            } else if (b2.startsWith("#EXT-X-SERVER-CONTROL")) {
                fVar4 = y(b2);
            } else if (b2.startsWith("#EXT-X-PART-INF")) {
                j11 = (long) (j(b2, p) * 1000000.0d);
            } else if (b2.startsWith("#EXT-X-MAP")) {
                String z12 = z(b2, L, hashMap);
                String v3 = v(b2, F, hashMap);
                if (v3 != null) {
                    String[] i1 = k0.i1(v3, "@");
                    j14 = Long.parseLong(i1[z4 ? 1 : 0]);
                    if (i1.length > 1) {
                        j12 = Long.parseLong(i1[1]);
                    }
                }
                if (j14 == -1) {
                    j12 = 0;
                }
                String str7 = str5;
                if (mVar2 != null && str7 == null) {
                    throw l1.c("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                dVar = new f.d(z12, j12, j14, mVar2, str7);
                if (j14 != -1) {
                    j12 += j14;
                }
                str5 = str7;
                j14 = -1;
            } else {
                String str8 = str5;
                if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                    j10 = 1000000 * m(b2, n);
                } else {
                    if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        j16 = n(b2, y);
                        str5 = str8;
                        j9 = j16;
                    } else if (b2.startsWith("#EXT-X-VERSION")) {
                        i6 = m(b2, q);
                    } else {
                        if (b2.startsWith("#EXT-X-DEFINE")) {
                            String v4 = v(b2, f0, hashMap);
                            if (v4 != null) {
                                z2 = (String) gVar2.l.get(v4);
                                if (z2 != null) {
                                }
                                arrayList = arrayList6;
                                list = arrayList5;
                                str2 = str6;
                                j2 = j16;
                                i2 = i4;
                            } else {
                                v4 = z(b2, Q, hashMap);
                                z2 = z(b2, e0, hashMap);
                            }
                            hashMap.put(v4, z2);
                            arrayList = arrayList6;
                            list = arrayList5;
                            str2 = str6;
                            j2 = j16;
                            i2 = i4;
                        } else if (b2.startsWith("#EXTINF")) {
                            j17 = A(b2, z);
                            str4 = u(b2, A, str3, hashMap);
                        } else {
                            String str9 = str3;
                            if (b2.startsWith("#EXT-X-SKIP")) {
                                int m2 = m(b2, u);
                                d4.a.g(fVar2 != null && arrayList2.isEmpty());
                                int i8 = (int) (j9 - ((f) k0.j(fVar)).k);
                                int i9 = m2 + i8;
                                if (i8 < 0 || i9 > fVar2.r.size()) {
                                    throw new a();
                                }
                                str3 = str9;
                                String str10 = str8;
                                long j19 = j15;
                                while (i8 < i9) {
                                    f.d dVar2 = (f.d) fVar2.r.get(i8);
                                    ArrayList arrayList7 = arrayList6;
                                    List list2 = arrayList5;
                                    if (j9 != fVar2.k) {
                                        dVar2 = dVar2.b(j19, (fVar2.j - i5) + dVar2.e);
                                    }
                                    arrayList2.add(dVar2);
                                    j19 += dVar2.d;
                                    long j20 = dVar2.k;
                                    if (j20 != -1) {
                                        i3 = i9;
                                        j12 = dVar2.j + j20;
                                    } else {
                                        i3 = i9;
                                    }
                                    int i10 = dVar2.e;
                                    f.d dVar3 = dVar2.c;
                                    m mVar5 = dVar2.g;
                                    m mVar6 = dVar2.h;
                                    String str11 = dVar2.i;
                                    if (str11 == null || !str11.equals(Long.toHexString(j16))) {
                                        str10 = dVar2.i;
                                    }
                                    j16++;
                                    i8++;
                                    fVar2 = fVar;
                                    mVar4 = mVar5;
                                    mVar2 = mVar6;
                                    j13 = j19;
                                    i9 = i3;
                                    i7 = i10;
                                    dVar = dVar3;
                                    arrayList6 = arrayList7;
                                    arrayList5 = list2;
                                }
                                gVar2 = gVar;
                                fVar2 = fVar;
                                j15 = j19;
                                str5 = str10;
                            } else {
                                ArrayList arrayList8 = arrayList6;
                                list = arrayList5;
                                str3 = str9;
                                if (b2.startsWith("#EXT-X-KEY")) {
                                    String z13 = z(b2, I, hashMap);
                                    String u2 = u(b2, J, "identity", hashMap);
                                    if ("NONE".equals(z13)) {
                                        treeMap.clear();
                                        v2 = null;
                                        mVar2 = null;
                                    } else {
                                        v2 = v(b2, M, hashMap);
                                        if ("identity".equals(u2)) {
                                            if ("AES-128".equals(z13)) {
                                                mVar2 = z(b2, L, hashMap);
                                            }
                                            gVar2 = gVar;
                                            fVar2 = fVar;
                                            str5 = v2;
                                        } else {
                                            String str12 = str6;
                                            str6 = str12 == null ? l(z13) : str12;
                                            m.b k2 = k(b2, u2, hashMap);
                                            if (k2 != null) {
                                                treeMap.put(u2, k2);
                                                mVar2 = null;
                                            }
                                        }
                                        mVar2 = null;
                                        gVar2 = gVar;
                                        fVar2 = fVar;
                                        str5 = v2;
                                    }
                                    mVar4 = mVar2;
                                    gVar2 = gVar;
                                    fVar2 = fVar;
                                    str5 = v2;
                                } else {
                                    String str13 = str6;
                                    if (b2.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] i12 = k0.i1(z(b2, E, hashMap), "@");
                                        j14 = Long.parseLong(i12[0]);
                                        if (i12.length > 1) {
                                            j12 = Long.parseLong(i12[1]);
                                        }
                                    } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i5 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                                        gVar2 = gVar;
                                        fVar2 = fVar;
                                        str6 = str13;
                                        str5 = str8;
                                        arrayList6 = arrayList8;
                                        arrayList5 = list;
                                        z4 = false;
                                        z7 = true;
                                    } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                                        i7++;
                                    } else {
                                        if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (j8 == 0) {
                                                j8 = k0.P0(k0.W0(b2.substring(b2.indexOf(58) + 1))) - j15;
                                            } else {
                                                i2 = i4;
                                                str2 = str13;
                                            }
                                        } else if (b2.equals("#EXT-X-GAP")) {
                                            gVar2 = gVar;
                                            fVar2 = fVar;
                                            str6 = str13;
                                            str5 = str8;
                                            arrayList6 = arrayList8;
                                            arrayList5 = list;
                                            z4 = false;
                                            z9 = true;
                                        } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            gVar2 = gVar;
                                            fVar2 = fVar;
                                            str6 = str13;
                                            str5 = str8;
                                            arrayList6 = arrayList8;
                                            arrayList5 = list;
                                            z4 = false;
                                            z5 = true;
                                        } else if (b2.equals("#EXT-X-ENDLIST")) {
                                            gVar2 = gVar;
                                            fVar2 = fVar;
                                            str6 = str13;
                                            str5 = str8;
                                            arrayList6 = arrayList8;
                                            arrayList5 = list;
                                            z4 = false;
                                            z8 = true;
                                        } else if (b2.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i2 = i4;
                                            str2 = str13;
                                            arrayList4.add(new f.c(Uri.parse(b0.d(str, z(b2, L, hashMap))), t(b2, B, -1L), s(b2, C, -1)));
                                        } else {
                                            i2 = i4;
                                            str2 = str13;
                                            if (!b2.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                j2 = j16;
                                                if (b2.startsWith("#EXT-X-PART")) {
                                                    String e2 = e(j2, mVar2, str8);
                                                    String z14 = z(b2, L, hashMap);
                                                    long j21 = (long) (j(b2, o) * 1000000.0d);
                                                    bVar2 = bVar3;
                                                    boolean q2 = q(b2, X, false) | (z5 && arrayList8.isEmpty());
                                                    boolean q3 = q(b2, Y, false);
                                                    String v5 = v(b2, F, hashMap);
                                                    if (v5 != null) {
                                                        String[] i13 = k0.i1(v5, "@");
                                                        j6 = Long.parseLong(i13[0]);
                                                        if (i13.length > 1) {
                                                            j18 = Long.parseLong(i13[1]);
                                                        }
                                                        j5 = -1;
                                                    } else {
                                                        j5 = -1;
                                                        j6 = -1;
                                                    }
                                                    if (j6 == j5) {
                                                        j18 = 0;
                                                    }
                                                    if (mVar4 == null && !treeMap.isEmpty()) {
                                                        m.b[] bVarArr = (m.b[]) treeMap.values().toArray(new m.b[0]);
                                                        m mVar7 = new m(str2, bVarArr);
                                                        if (mVar3 == null) {
                                                            mVar3 = d(str2, bVarArr);
                                                        }
                                                        mVar4 = mVar7;
                                                    }
                                                    arrayList = arrayList8;
                                                    arrayList.add(new f.b(z14, dVar, j21, i7, j13, mVar4, mVar2, e2, j18, j6, q3, q2, false));
                                                    j13 += j21;
                                                    if (j6 != j5) {
                                                        j18 += j6;
                                                    }
                                                } else {
                                                    bVar2 = bVar3;
                                                    arrayList = arrayList8;
                                                    if (!b2.startsWith("#")) {
                                                        String e3 = e(j2, mVar2, str8);
                                                        long j22 = j2 + 1;
                                                        String B2 = B(b2, hashMap);
                                                        f.d dVar4 = (f.d) hashMap2.get(B2);
                                                        if (j14 == -1) {
                                                            j3 = 0;
                                                        } else {
                                                            if (z10 && dVar == null && dVar4 == null) {
                                                                dVar4 = new f.d(B2, 0L, j12, null, null);
                                                                hashMap2.put(B2, dVar4);
                                                            }
                                                            j3 = j12;
                                                        }
                                                        if (mVar4 != null || treeMap.isEmpty()) {
                                                            j4 = j22;
                                                            mVar = mVar4;
                                                        } else {
                                                            j4 = j22;
                                                            m.b[] bVarArr2 = (m.b[]) treeMap.values().toArray(new m.b[0]);
                                                            mVar = new m(str2, bVarArr2);
                                                            if (mVar3 == null) {
                                                                mVar3 = d(str2, bVarArr2);
                                                            }
                                                        }
                                                        arrayList2.add(new f.d(B2, dVar != null ? dVar : dVar4, str4, j17, i7, j15, mVar, mVar2, e3, j3, j14, z9, arrayList));
                                                        j13 = j15 + j17;
                                                        arrayList6 = new ArrayList();
                                                        if (j14 != -1) {
                                                            j3 += j14;
                                                        }
                                                        j12 = j3;
                                                        gVar2 = gVar;
                                                        fVar2 = fVar;
                                                        str5 = str8;
                                                        mVar4 = mVar;
                                                        str4 = str3;
                                                        j15 = j13;
                                                        i4 = i2;
                                                        bVar3 = bVar2;
                                                        arrayList5 = list;
                                                        z9 = false;
                                                        j14 = -1;
                                                        j17 = 0;
                                                        str6 = str2;
                                                        j16 = j4;
                                                    }
                                                }
                                                gVar2 = gVar;
                                                fVar2 = fVar;
                                                str5 = str8;
                                                i4 = i2;
                                                bVar3 = bVar2;
                                                j16 = j2;
                                                str6 = str2;
                                                arrayList6 = arrayList;
                                                arrayList5 = list;
                                            } else if (bVar3 == null && "PART".equals(z(b2, O, hashMap))) {
                                                String z15 = z(b2, L, hashMap);
                                                long t2 = t(b2, G, -1L);
                                                long t3 = t(b2, H, -1L);
                                                long j23 = j16;
                                                String e4 = e(j23, mVar2, str8);
                                                if (mVar4 == null && !treeMap.isEmpty()) {
                                                    m.b[] bVarArr3 = (m.b[]) treeMap.values().toArray(new m.b[0]);
                                                    m mVar8 = new m(str2, bVarArr3);
                                                    if (mVar3 == null) {
                                                        mVar3 = d(str2, bVarArr3);
                                                    }
                                                    mVar4 = mVar8;
                                                }
                                                if (t2 == -1 || t3 != -1) {
                                                    bVar3 = new f.b(z15, dVar, 0L, i7, j13, mVar4, mVar2, e4, t2 != -1 ? t2 : 0L, t3, false, false, true);
                                                }
                                                gVar2 = gVar;
                                                fVar2 = fVar;
                                                j16 = j23;
                                                str5 = str8;
                                                arrayList6 = arrayList8;
                                                i4 = i2;
                                                arrayList5 = list;
                                                str6 = str2;
                                            }
                                        }
                                        arrayList = arrayList8;
                                        j2 = j16;
                                    }
                                    gVar2 = gVar;
                                    fVar2 = fVar;
                                    str6 = str13;
                                    str5 = str8;
                                }
                                arrayList6 = arrayList8;
                                arrayList5 = list;
                            }
                        }
                        bVar2 = bVar3;
                        gVar2 = gVar;
                        fVar2 = fVar;
                        str5 = str8;
                        i4 = i2;
                        bVar3 = bVar2;
                        j16 = j2;
                        str6 = str2;
                        arrayList6 = arrayList;
                        arrayList5 = list;
                    }
                    z4 = false;
                }
                str5 = str8;
                z4 = false;
            }
        }
        int i11 = i4;
        f.b bVar4 = bVar3;
        ArrayList arrayList9 = arrayList6;
        List list3 = arrayList5;
        HashMap hashMap3 = new HashMap();
        for (int i14 = 0; i14 < arrayList4.size(); i14++) {
            f.c cVar = (f.c) arrayList4.get(i14);
            long j24 = cVar.b;
            if (j24 == -1) {
                j24 = (j9 + arrayList2.size()) - (arrayList9.isEmpty() ? 1L : 0L);
            }
            int i15 = cVar.c;
            if (i15 == -1 && j11 != -9223372036854775807L) {
                i15 = (arrayList9.isEmpty() ? ((f.d) D.d(arrayList2)).n : arrayList9).size() - 1;
            }
            Uri uri = cVar.a;
            hashMap3.put(uri, new f.c(uri, j24, i15));
        }
        if (bVar4 != null) {
            arrayList9.add(bVar4);
        }
        return new f(i11, str, list3, j7, z6, j8, z7, i5, j9, i6, j10, j11, z5, z8, j8 != 0, mVar3, arrayList2, arrayList9, fVar4, hashMap3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:86:0x033d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0310  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static J3.g p(J3.i.b r37, java.lang.String r38) {
        /*
            Method dump skipped, instructions count: 1250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.i.p(J3.i$b, java.lang.String):J3.g");
    }

    public static boolean q(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z2;
    }

    public static double r(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) d4.a.e(matcher.group(1))) : d2;
    }

    public static int s(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) d4.a.e(matcher.group(1))) : i2;
    }

    public static long t(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) d4.a.e(matcher.group(1))) : j2;
    }

    public static String u(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) d4.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : B(str2, map);
    }

    public static String v(String str, Pattern pattern, Map map) {
        return u(str, pattern, null, map);
    }

    public static int w(String str, Map map) {
        String v2 = v(str, S, map);
        if (TextUtils.isEmpty(v2)) {
            return 0;
        }
        String[] i1 = k0.i1(v2, ",");
        int i2 = k0.t(i1, "public.accessibility.describes-video") ? 512 : 0;
        if (k0.t(i1, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (k0.t(i1, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return k0.t(i1, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int x(String str) {
        boolean q2 = q(str, V, false);
        ?? r0 = q2;
        if (q(str, W, false)) {
            r0 = (q2 ? 1 : 0) | 2;
        }
        return q(str, U, false) ? r0 | 4 : r0;
    }

    public static f.f y(String str) {
        double r2 = r(str, s, -9.223372036854776E18d);
        long j2 = r2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r2 * 1000000.0d);
        boolean q2 = q(str, t, false);
        double r3 = r(str, v, -9.223372036854776E18d);
        long j3 = r3 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r3 * 1000000.0d);
        double r4 = r(str, w, -9.223372036854776E18d);
        return new f.f(j2, q2, j3, r4 != -9.223372036854776E18d ? (long) (r4 * 1000000.0d) : -9223372036854775807L, q(str, x, false));
    }

    public static String z(String str, Pattern pattern, Map map) {
        String v2 = v(str, pattern, map);
        if (v2 != null) {
            return v2;
        }
        throw l1.c("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public h a(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!b(bufferedReader)) {
                throw l1.c("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    k0.o(bufferedReader);
                    throw l1.c("Failed to parse the playlist, could not identify any tags.", null);
                }
                trim = readLine.trim();
                if (!trim.isEmpty()) {
                    if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                        if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(trim);
                    } else {
                        arrayDeque.add(trim);
                        return p(new b(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(trim);
            return o(this.a, this.c, new b(arrayDeque, bufferedReader), uri.toString());
        } finally {
            k0.o(bufferedReader);
        }
    }

    public i(g gVar, f fVar) {
        this.a = gVar;
        this.c = fVar;
    }
}
