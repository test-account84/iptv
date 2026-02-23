package org.jsoup.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Entities {
    private static final Map base;
    private static final Map baseByVal;
    private static final Map full;
    private static final Map fullByVal;
    private static final Object[][] xhtmlArray;
    private static final Map xhtmlByVal = new HashMap();

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$nodes$Entities$CoreCharset;

        static {
            int[] iArr = new int[CoreCharset.values().length];
            $SwitchMap$org$jsoup$nodes$Entities$CoreCharset = iArr;
            try {
                iArr[CoreCharset.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$nodes$Entities$CoreCharset[CoreCharset.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum CoreCharset {
        ascii,
        utf,
        fallback;

        public static /* synthetic */ CoreCharset access$300(String str) {
            return byName(str);
        }

        private static CoreCharset byName(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    public enum EscapeMode {
        xhtml(Entities.access$000()),
        base(Entities.access$100()),
        extended(Entities.access$200());

        private Map map;

        EscapeMode(Map map) {
            this.map = map;
        }

        public Map getMap() {
            return this.map;
        }
    }

    static {
        Object[][] objArr = {new Object[]{"quot", 34}, new Object[]{"amp", 38}, new Object[]{"lt", 60}, new Object[]{"gt", 62}};
        xhtmlArray = objArr;
        Map loadEntities = loadEntities("entities-base.properties");
        base = loadEntities;
        baseByVal = toCharacterKey(loadEntities);
        Map loadEntities2 = loadEntities("entities-full.properties");
        full = loadEntities2;
        fullByVal = toCharacterKey(loadEntities2);
        for (Object[] objArr2 : objArr) {
            xhtmlByVal.put(Character.valueOf((char) ((Integer) objArr2[1]).intValue()), (String) objArr2[0]);
        }
    }

    private Entities() {
    }

    public static /* synthetic */ Map access$000() {
        return xhtmlByVal;
    }

    public static /* synthetic */ Map access$100() {
        return baseByVal;
    }

    public static /* synthetic */ Map access$200() {
        return fullByVal;
    }

    private static boolean canEncode(CoreCharset coreCharset, char c, CharsetEncoder charsetEncoder) {
        int i = 1.$SwitchMap$org$jsoup$nodes$Entities$CoreCharset[coreCharset.ordinal()];
        if (i == 1) {
            return c < 128;
        }
        if (i != 2) {
            return charsetEncoder.canEncode(c);
        }
        return true;
    }

    public static String escape(String str, Document.OutputSettings outputSettings) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        escape(sb, str, outputSettings, false, false, false);
        return sb.toString();
    }

    public static Character getCharacterByName(String str) {
        return (Character) full.get(str);
    }

    public static boolean isBaseNamedEntity(String str) {
        return base.containsKey(str);
    }

    public static boolean isNamedEntity(String str) {
        return full.containsKey(str);
    }

    private static Map loadEntities(String str) {
        Properties properties = new Properties();
        HashMap hashMap = new HashMap();
        try {
            InputStream resourceAsStream = Entities.class.getResourceAsStream(str);
            properties.load(resourceAsStream);
            resourceAsStream.close();
            for (Map.Entry entry : properties.entrySet()) {
                hashMap.put((String) entry.getKey(), Character.valueOf((char) Integer.parseInt((String) entry.getValue(), 16)));
            }
            return hashMap;
        } catch (IOException e) {
            throw new MissingResourceException("Error loading entities resource: " + e.getMessage(), "Entities", str);
        }
    }

    private static Map toCharacterKey(Map map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Character ch = (Character) entry.getValue();
            String str = (String) entry.getKey();
            if (!hashMap.containsKey(ch) || str.toLowerCase().equals(str)) {
                hashMap.put(ch, str);
            }
        }
        return hashMap;
    }

    public static String unescape(String str) {
        return unescape(str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c1, code lost:
    
        if (r2.canEncode(r6) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void escape(java.lang.StringBuilder r16, java.lang.String r17, org.jsoup.nodes.Document.OutputSettings r18, boolean r19, boolean r20, boolean r21) {
        /*
            r0 = r16
            org.jsoup.nodes.Entities$EscapeMode r1 = r18.escapeMode()
            java.nio.charset.CharsetEncoder r2 = r18.encoder()
            java.nio.charset.Charset r3 = r2.charset()
            java.lang.String r3 = r3.name()
            org.jsoup.nodes.Entities$CoreCharset r3 = org.jsoup.nodes.Entities.CoreCharset.access$300(r3)
            java.util.Map r4 = r1.getMap()
            int r5 = r17.length()
            r7 = 0
            r8 = 0
            r9 = 0
        L21:
            if (r7 >= r5) goto Lcb
            r10 = r17
            int r11 = r10.codePointAt(r7)
            if (r20 == 0) goto L44
            boolean r12 = org.jsoup.helper.StringUtil.isWhitespace(r11)
            r13 = 1
            if (r12 == 0) goto L42
            if (r21 == 0) goto L36
            if (r8 == 0) goto Lc4
        L36:
            if (r9 == 0) goto L3a
            goto Lc4
        L3a:
            r9 = 32
            r0.append(r9)
            r9 = 1
            goto Lc4
        L42:
            r8 = 1
            r9 = 0
        L44:
            r12 = 65536(0x10000, float:9.18355E-41)
            java.lang.String r13 = "&#x"
            r14 = 59
            if (r11 >= r12) goto Lb4
            char r12 = (char) r11
            r15 = 34
            if (r12 == r15) goto Laf
            r15 = 38
            if (r12 == r15) goto Lac
            r6 = 60
            if (r12 == r6) goto La3
            r6 = 62
            if (r12 == r6) goto L9e
            r6 = 160(0xa0, float:2.24E-43)
            if (r12 == r6) goto L91
            boolean r6 = canEncode(r3, r12, r2)
            if (r6 == 0) goto L6b
        L67:
            r0.append(r12)
            goto Lc4
        L6b:
            java.lang.Character r6 = java.lang.Character.valueOf(r12)
            boolean r6 = r4.containsKey(r6)
            if (r6 == 0) goto L89
            r0.append(r15)
            java.lang.Character r6 = java.lang.Character.valueOf(r12)
            java.lang.Object r6 = r4.get(r6)
            java.lang.String r6 = (java.lang.String) r6
        L82:
            r0.append(r6)
            r0.append(r14)
            goto Lc4
        L89:
            r0.append(r13)
            java.lang.String r6 = java.lang.Integer.toHexString(r11)
            goto L82
        L91:
            org.jsoup.nodes.Entities$EscapeMode r6 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r1 == r6) goto L9b
            java.lang.String r6 = "&nbsp;"
        L97:
            r0.append(r6)
            goto Lc4
        L9b:
            java.lang.String r6 = "&#xa0;"
            goto L97
        L9e:
            if (r19 != 0) goto L67
            java.lang.String r6 = "&gt;"
            goto L97
        La3:
            if (r19 == 0) goto La9
            org.jsoup.nodes.Entities$EscapeMode r6 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r1 != r6) goto L67
        La9:
            java.lang.String r6 = "&lt;"
            goto L97
        Lac:
            java.lang.String r6 = "&amp;"
            goto L97
        Laf:
            if (r19 == 0) goto L67
            java.lang.String r6 = "&quot;"
            goto L97
        Lb4:
            java.lang.String r6 = new java.lang.String
            char[] r12 = java.lang.Character.toChars(r11)
            r6.<init>(r12)
            boolean r12 = r2.canEncode(r6)
            if (r12 == 0) goto L89
            goto L97
        Lc4:
            int r6 = java.lang.Character.charCount(r11)
            int r7 = r7 + r6
            goto L21
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.escape(java.lang.StringBuilder, java.lang.String, org.jsoup.nodes.Document$OutputSettings, boolean, boolean, boolean):void");
    }

    public static String unescape(String str, boolean z) {
        return Parser.unescapeEntities(str, z);
    }
}
