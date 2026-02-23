package i3;

import O2.l1;
import d4.B;
import d4.m0;
import i3.b;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e {
    public static final String[] a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    public static final String[] b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static b a(String str) {
        try {
            return b(str);
        } catch (XmlPullParserException | l1 | NumberFormatException unused) {
            B.j("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    public static b b(String str) {
        String str2;
        String str3;
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (!m0.f(newPullParser, "x:xmpmeta")) {
            throw l1.a("Couldn't find xmp metadata", null);
        }
        y z = y.z();
        long j = -9223372036854775807L;
        do {
            newPullParser.next();
            if (!m0.f(newPullParser, "rdf:Description")) {
                if (m0.f(newPullParser, "Container:Directory")) {
                    str2 = "Container";
                    str3 = "Item";
                } else if (m0.f(newPullParser, "GContainer:Directory")) {
                    str2 = "GContainer";
                    str3 = "GContainerItem";
                }
                z = f(newPullParser, str2, str3);
            } else {
                if (!d(newPullParser)) {
                    return null;
                }
                j = e(newPullParser);
                z = c(newPullParser);
            }
        } while (!m0.d(newPullParser, "x:xmpmeta"));
        if (z.isEmpty()) {
            return null;
        }
        return new b(j, z);
    }

    public static y c(XmlPullParser xmlPullParser) {
        for (String str : c) {
            String a2 = m0.a(xmlPullParser, str);
            if (a2 != null) {
                return y.B(new b.a("image/jpeg", "Primary", 0L, 0L), new b.a("video/mp4", "MotionPhoto", Long.parseLong(a2), 0L));
            }
        }
        return y.z();
    }

    public static boolean d(XmlPullParser xmlPullParser) {
        for (String str : a) {
            String a2 = m0.a(xmlPullParser, str);
            if (a2 != null) {
                return Integer.parseInt(a2) == 1;
            }
        }
        return false;
    }

    public static long e(XmlPullParser xmlPullParser) {
        for (String str : b) {
            String a2 = m0.a(xmlPullParser, str);
            if (a2 != null) {
                long parseLong = Long.parseLong(a2);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    public static y f(XmlPullParser xmlPullParser, String str, String str2) {
        y.a p = y.p();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (m0.f(xmlPullParser, str3)) {
                String a2 = m0.a(xmlPullParser, str2 + ":Mime");
                String a3 = m0.a(xmlPullParser, str2 + ":Semantic");
                String a4 = m0.a(xmlPullParser, str2 + ":Length");
                String a5 = m0.a(xmlPullParser, str2 + ":Padding");
                if (a2 == null || a3 == null) {
                    return y.z();
                }
                p.h(new b.a(a2, a3, a4 != null ? Long.parseLong(a4) : 0L, a5 != null ? Long.parseLong(a5) : 0L));
            }
        } while (!m0.d(xmlPullParser, str4));
        return p.k();
    }
}
