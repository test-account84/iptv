package N3;

import N3.a;
import O2.l1;
import O2.z0;
import V2.m;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import b4.I;
import d4.k0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import l3.l;
import l3.p;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b implements I.a {
    public final XmlPullParserFactory a;

    public static class b extends l1 {
        public b(String str) {
            super("Missing required field: " + str, null, true, 4);
        }
    }

    public static class c extends a {
        public boolean e;
        public UUID f;
        public byte[] g;

        public c(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        public static p[] q(byte[] bArr) {
            return new p[]{new p(true, null, 8, r(bArr), 0, 0, null)};
        }

        public static byte[] r(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i += 2) {
                sb.append((char) bArr[i]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        public static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        public static void t(byte[] bArr, int i, int i2) {
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }

        public Object b() {
            UUID uuid = this.f;
            return new a.a(uuid, l.a(uuid, this.g), q(this.g));
        }

        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = false;
            }
        }

        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = true;
                this.f = UUID.fromString(s(xmlPullParser.getAttributeValue((String) null, "SystemID")));
            }
        }

        public void o(XmlPullParser xmlPullParser) {
            if (this.e) {
                this.g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class d extends a {
        public z0 e;

        public d(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        public static List q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] L = k0.L(str);
                byte[][] j = d4.f.j(L);
                if (j == null) {
                    arrayList.add(L);
                } else {
                    Collections.addAll(arrayList, j);
                }
            }
            return arrayList;
        }

        public static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        public Object b() {
            return this.e;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void n(org.xmlpull.v1.XmlPullParser r9) {
            /*
                r8 = this;
                O2.z0$b r0 = new O2.z0$b
                r0.<init>()
                java.lang.String r1 = "FourCC"
                java.lang.String r1 = r8.m(r9, r1)
                java.lang.String r1 = r(r1)
                java.lang.String r2 = "Type"
                java.lang.Object r2 = r8.c(r2)
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
                r3 = 2
                java.lang.String r4 = "CodecPrivateData"
                r5 = 0
                if (r2 != r3) goto L48
                java.lang.String r2 = r9.getAttributeValue(r5, r4)
                java.util.List r2 = q(r2)
                java.lang.String r3 = "video/mp4"
                O2.z0$b r3 = r0.M(r3)
                java.lang.String r4 = "MaxWidth"
                int r4 = r8.k(r9, r4)
                O2.z0$b r3 = r3.n0(r4)
                java.lang.String r4 = "MaxHeight"
                int r4 = r8.k(r9, r4)
                O2.z0$b r3 = r3.S(r4)
                r3.V(r2)
                goto Lbc
            L48:
                r3 = 1
                if (r2 != r3) goto L8a
                java.lang.String r2 = "audio/mp4a-latm"
                if (r1 != 0) goto L50
                r1 = r2
            L50:
                java.lang.String r3 = "Channels"
                int r3 = r8.k(r9, r3)
                java.lang.String r6 = "SamplingRate"
                int r6 = r8.k(r9, r6)
                java.lang.String r4 = r9.getAttributeValue(r5, r4)
                java.util.List r4 = q(r4)
                boolean r7 = r4.isEmpty()
                if (r7 == 0) goto L78
                boolean r2 = r2.equals(r1)
                if (r2 == 0) goto L78
                byte[] r2 = Q2.a.a(r6, r3)
                java.util.List r4 = java.util.Collections.singletonList(r2)
            L78:
                java.lang.String r2 = "audio/mp4"
                O2.z0$b r2 = r0.M(r2)
                O2.z0$b r2 = r2.J(r3)
                O2.z0$b r2 = r2.h0(r6)
                r2.V(r4)
                goto Lbc
            L8a:
                r3 = 3
                java.lang.String r4 = "application/mp4"
                if (r2 != r3) goto Lb9
                java.lang.String r2 = "Subtype"
                java.lang.Object r2 = r8.c(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto Lb0
                java.lang.String r3 = "CAPT"
                boolean r3 = r2.equals(r3)
                if (r3 != 0) goto Lad
                java.lang.String r3 = "DESC"
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto Laa
                goto Lb0
            Laa:
                r2 = 1024(0x400, float:1.435E-42)
                goto Lb1
            Lad:
                r2 = 64
                goto Lb1
            Lb0:
                r2 = 0
            Lb1:
                O2.z0$b r3 = r0.M(r4)
                r3.e0(r2)
                goto Lbc
            Lb9:
                r0.M(r4)
            Lbc:
                java.lang.String r2 = "Index"
                java.lang.String r2 = r9.getAttributeValue(r5, r2)
                O2.z0$b r0 = r0.U(r2)
                java.lang.String r2 = "Name"
                java.lang.Object r2 = r8.c(r2)
                java.lang.String r2 = (java.lang.String) r2
                O2.z0$b r0 = r0.W(r2)
                O2.z0$b r0 = r0.g0(r1)
                java.lang.String r1 = "Bitrate"
                int r9 = r8.k(r9, r1)
                O2.z0$b r9 = r0.I(r9)
                java.lang.String r0 = "Language"
                java.lang.Object r0 = r8.c(r0)
                java.lang.String r0 = (java.lang.String) r0
                O2.z0$b r9 = r9.X(r0)
                O2.z0 r9 = r9.G()
                r8.e = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N3.b.d.n(org.xmlpull.v1.XmlPullParser):void");
        }
    }

    public static class e extends a {
        public final List e;
        public int f;
        public int g;
        public long h;
        public long i;
        public long j;
        public int k;
        public boolean l;
        public a.a m;

        public e(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.k = -1;
            this.m = null;
            this.e = new LinkedList();
        }

        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.e.add((a.b) obj);
            } else if (obj instanceof a.a) {
                d4.a.g(this.m == null);
                this.m = (a.a) obj;
            }
        }

        public Object b() {
            int size = this.e.size();
            a.b[] bVarArr = new a.b[size];
            this.e.toArray(bVarArr);
            if (this.m != null) {
                a.a aVar = this.m;
                m mVar = new m(new m.b(aVar.a, "video/mp4", aVar.b));
                for (int i = 0; i < size; i++) {
                    a.b bVar = bVarArr[i];
                    int i2 = bVar.a;
                    if (i2 == 2 || i2 == 1) {
                        z0[] z0VarArr = bVar.j;
                        for (int i3 = 0; i3 < z0VarArr.length; i3++) {
                            z0VarArr[i3] = z0VarArr[i3].b().O(mVar).G();
                        }
                    }
                }
            }
            return new N3.a(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, bVarArr);
        }

        public void n(XmlPullParser xmlPullParser) {
            this.f = k(xmlPullParser, "MajorVersion");
            this.g = k(xmlPullParser, "MinorVersion");
            this.h = j(xmlPullParser, "TimeScale", 10000000L);
            this.i = l(xmlPullParser, "Duration");
            this.j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.k = i(xmlPullParser, "LookaheadCount", -1);
            this.l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.h));
        }
    }

    public static class f extends a {
        public final String e;
        public final List f;
        public int g;
        public String h;
        public long i;
        public String j;
        public String k;
        public int l;
        public int m;
        public int n;
        public int o;
        public String p;
        public ArrayList q;
        public long r;

        public f(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.e = str;
            this.f = new LinkedList();
        }

        public void a(Object obj) {
            if (obj instanceof z0) {
                this.f.add((z0) obj);
            }
        }

        public Object b() {
            z0[] z0VarArr = new z0[this.f.size()];
            this.f.toArray(z0VarArr);
            return new a.b(this.e, this.k, this.g, this.h, this.i, this.j, this.l, this.m, this.n, this.o, this.p, z0VarArr, this.q, this.r);
        }

        public boolean d(String str) {
            return "c".equals(str);
        }

        public void n(XmlPullParser xmlPullParser) {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }

        public final void q(XmlPullParser xmlPullParser) {
            int s = s(xmlPullParser);
            this.g = s;
            p("Type", Integer.valueOf(s));
            this.h = this.g == 3 ? m(xmlPullParser, "Subtype") : xmlPullParser.getAttributeValue((String) null, "Subtype");
            p("Subtype", this.h);
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "Name");
            this.j = attributeValue;
            p("Name", attributeValue);
            this.k = m(xmlPullParser, "Url");
            this.l = i(xmlPullParser, "MaxWidth", -1);
            this.m = i(xmlPullParser, "MaxHeight", -1);
            this.n = i(xmlPullParser, "DisplayWidth", -1);
            this.o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "Language");
            this.p = attributeValue2;
            p("Language", attributeValue2);
            long i = i(xmlPullParser, "TimeScale", -1);
            this.i = i;
            if (i == -1) {
                this.i = ((Long) c("TimeScale")).longValue();
            }
            this.q = new ArrayList();
        }

        public final void r(XmlPullParser xmlPullParser) {
            int size = this.q.size();
            long j = j(xmlPullParser, "t", -9223372036854775807L);
            int i = 1;
            if (j == -9223372036854775807L) {
                if (size == 0) {
                    j = 0;
                } else {
                    if (this.r == -1) {
                        throw l1.c("Unable to infer start time", null);
                    }
                    j = ((Long) this.q.get(size - 1)).longValue() + this.r;
                }
            }
            this.q.add(Long.valueOf(j));
            this.r = j(xmlPullParser, "d", -9223372036854775807L);
            long j2 = j(xmlPullParser, "r", 1L);
            if (j2 > 1 && this.r == -9223372036854775807L) {
                throw l1.c("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j3 = i;
                if (j3 >= j2) {
                    return;
                }
                this.q.add(Long.valueOf((this.r * j3) + j));
                i++;
            }
        }

        public final int s(XmlPullParser xmlPullParser) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "Type");
            if (attributeValue == null) {
                throw new b("Type");
            }
            if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            throw l1.c("Invalid key value[" + attributeValue + "]", null);
        }
    }

    public b() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public N3.a a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            return (N3.a) new e(null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e2) {
            throw l1.c(null, e2);
        }
    }

    public static abstract class a {
        public final String a;
        public final String b;
        public final a c;
        public final List d = new LinkedList();

        public a(a aVar, String str, String str2) {
            this.c = aVar;
            this.a = str;
            this.b = str2;
        }

        public abstract Object b();

        public final Object c(String str) {
            for (int i = 0; i < this.d.size(); i++) {
                Pair pair = (Pair) this.d.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        public boolean d(String str) {
            return false;
        }

        public final a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new d(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new c(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new f(aVar, str2);
            }
            return null;
        }

        public final Object f(XmlPullParser xmlPullParser) {
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.b.equals(name)) {
                        n(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e = e(this, name, this.a);
                            if (e == null) {
                                i = 1;
                            } else {
                                a(e.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
        }

        public final int i(XmlPullParser xmlPullParser, String str, int i) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return i;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw l1.c(null, e);
            }
        }

        public final long j(XmlPullParser xmlPullParser, String str, long j) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return j;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw l1.c(null, e);
            }
        }

        public final int k(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                throw new b(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw l1.c(null, e);
            }
        }

        public final long l(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                throw new b(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw l1.c(null, e);
            }
        }

        public final String m(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new b(str);
        }

        public abstract void n(XmlPullParser xmlPullParser);

        public final void p(String str, Object obj) {
            this.d.add(Pair.create(str, obj));
        }

        public void a(Object obj) {
        }

        public void h(XmlPullParser xmlPullParser) {
        }

        public void o(XmlPullParser xmlPullParser) {
        }
    }
}
