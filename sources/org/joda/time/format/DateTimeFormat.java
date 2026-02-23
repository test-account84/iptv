package org.joda.time.format;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.scheduling.n;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DateTimeFormat {
    static final int DATE = 0;
    static final int DATETIME = 2;
    static final int FULL = 0;
    static final int LONG = 1;
    static final int MEDIUM = 2;
    static final int NONE = 4;
    private static final int PATTERN_CACHE_SIZE = 500;
    static final int SHORT = 3;
    static final int TIME = 1;
    private static final ConcurrentHashMap cPatternCache = new ConcurrentHashMap();
    private static final AtomicReferenceArray cStyleCache = new AtomicReferenceArray(25);

    public static class StyleFormatter implements InternalPrinter, InternalParser {
        private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
        private final int iDateStyle;
        private final int iTimeStyle;
        private final int iType;

        public StyleFormatter(int i, int i2, int i3) {
            this.iDateStyle = i;
            this.iTimeStyle = i2;
            this.iType = i3;
        }

        private DateTimeFormatter getFormatter(Locale locale) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            StyleFormatterCacheKey styleFormatterCacheKey = new StyleFormatterCacheKey(this.iType, this.iDateStyle, this.iTimeStyle, locale);
            ConcurrentHashMap concurrentHashMap = cCache;
            DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) concurrentHashMap.get(styleFormatterCacheKey);
            if (dateTimeFormatter != null) {
                return dateTimeFormatter;
            }
            DateTimeFormatter forPattern = DateTimeFormat.forPattern(getPattern(locale));
            DateTimeFormatter dateTimeFormatter2 = (DateTimeFormatter) concurrentHashMap.putIfAbsent(styleFormatterCacheKey, forPattern);
            return dateTimeFormatter2 != null ? dateTimeFormatter2 : forPattern;
        }

        public int estimateParsedLength() {
            return 40;
        }

        public int estimatePrintedLength() {
            return 40;
        }

        public String getPattern(Locale locale) {
            int i = this.iType;
            DateFormat dateTimeInstance = i != 0 ? i != 1 ? i != 2 ? null : DateFormat.getDateTimeInstance(this.iDateStyle, this.iTimeStyle, locale) : DateFormat.getTimeInstance(this.iTimeStyle, locale) : DateFormat.getDateInstance(this.iDateStyle, locale);
            if (dateTimeInstance instanceof SimpleDateFormat) {
                return ((SimpleDateFormat) dateTimeInstance).toPattern();
            }
            throw new IllegalArgumentException("No datetime pattern for locale: " + locale);
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            return getFormatter(dateTimeParserBucket.getLocale()).getParser0().parseInto(dateTimeParserBucket, charSequence, i);
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            getFormatter(locale).getPrinter0().printTo(appendable, j, chronology, i, dateTimeZone, locale);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            getFormatter(locale).getPrinter0().printTo(appendable, readablePartial, locale);
        }
    }

    public static class StyleFormatterCacheKey {
        private final int combinedTypeAndStyle;
        private final Locale locale;

        public StyleFormatterCacheKey(int i, int i2, int i3, Locale locale) {
            this.locale = locale;
            this.combinedTypeAndStyle = i + (i2 << 4) + (i3 << 8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof StyleFormatterCacheKey)) {
                return false;
            }
            StyleFormatterCacheKey styleFormatterCacheKey = (StyleFormatterCacheKey) obj;
            if (this.combinedTypeAndStyle != styleFormatterCacheKey.combinedTypeAndStyle) {
                return false;
            }
            Locale locale = this.locale;
            Locale locale2 = styleFormatterCacheKey.locale;
            if (locale == null) {
                if (locale2 != null) {
                    return false;
                }
            } else if (!locale.equals(locale2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = (this.combinedTypeAndStyle + 31) * 31;
            Locale locale = this.locale;
            return i + (locale == null ? 0 : locale.hashCode());
        }
    }

    public static void appendPatternTo(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        parsePatternTo(dateTimeFormatterBuilder, str);
    }

    private static DateTimeFormatter createDateTimeFormatter(int i, int i2) {
        StyleFormatter styleFormatter = new StyleFormatter(i, i2, i == 4 ? 1 : i2 == 4 ? 0 : 2);
        return new DateTimeFormatter(styleFormatter, styleFormatter);
    }

    private static DateTimeFormatter createFormatterForPattern(String str) {
        DateTimeFormatter dateTimeFormatter;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        ConcurrentHashMap concurrentHashMap = cPatternCache;
        DateTimeFormatter dateTimeFormatter2 = (DateTimeFormatter) concurrentHashMap.get(str);
        if (dateTimeFormatter2 != null) {
            return dateTimeFormatter2;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        parsePatternTo(dateTimeFormatterBuilder, str);
        DateTimeFormatter formatter = dateTimeFormatterBuilder.toFormatter();
        return (concurrentHashMap.size() >= 500 || (dateTimeFormatter = (DateTimeFormatter) concurrentHashMap.putIfAbsent(str, formatter)) == null) ? formatter : dateTimeFormatter;
    }

    private static DateTimeFormatter createFormatterForStyle(String str) {
        if (str == null || str.length() != 2) {
            throw new IllegalArgumentException("Invalid style specification: " + str);
        }
        int selectStyle = selectStyle(str.charAt(0));
        int selectStyle2 = selectStyle(str.charAt(1));
        if (selectStyle == 4 && selectStyle2 == 4) {
            throw new IllegalArgumentException("Style '--' is invalid");
        }
        return createFormatterForStyleIndex(selectStyle, selectStyle2);
    }

    private static DateTimeFormatter createFormatterForStyleIndex(int i, int i2) {
        int i3 = (i << 2) + i + i2;
        AtomicReferenceArray atomicReferenceArray = cStyleCache;
        if (i3 >= atomicReferenceArray.length()) {
            return createDateTimeFormatter(i, i2);
        }
        DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) atomicReferenceArray.get(i3);
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatter createDateTimeFormatter = createDateTimeFormatter(i, i2);
        return !n.a(atomicReferenceArray, i3, null, createDateTimeFormatter) ? (DateTimeFormatter) atomicReferenceArray.get(i3) : createDateTimeFormatter;
    }

    public static DateTimeFormatter forPattern(String str) {
        return createFormatterForPattern(str);
    }

    public static DateTimeFormatter forStyle(String str) {
        return createFormatterForStyle(str);
    }

    public static DateTimeFormatter fullDate() {
        return createFormatterForStyleIndex(0, 4);
    }

    public static DateTimeFormatter fullDateTime() {
        return createFormatterForStyleIndex(0, 0);
    }

    public static DateTimeFormatter fullTime() {
        return createFormatterForStyleIndex(4, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isNumericToken(java.lang.String r3) {
        /*
            int r0 = r3.length()
            r1 = 0
            if (r0 <= 0) goto L14
            char r3 = r3.charAt(r1)
            r2 = 1
            switch(r3) {
                case 67: goto L13;
                case 68: goto L13;
                case 70: goto L13;
                case 72: goto L13;
                case 75: goto L13;
                case 77: goto L10;
                case 83: goto L13;
                case 87: goto L13;
                case 89: goto L13;
                case 99: goto L13;
                case 100: goto L13;
                case 101: goto L13;
                case 104: goto L13;
                case 107: goto L13;
                case 109: goto L13;
                case 115: goto L13;
                case 119: goto L13;
                case 120: goto L13;
                case 121: goto L13;
                default: goto Lf;
            }
        Lf:
            goto L14
        L10:
            r3 = 2
            if (r0 > r3) goto L14
        L13:
            return r2
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormat.isNumericToken(java.lang.String):boolean");
    }

    public static DateTimeFormatter longDate() {
        return createFormatterForStyleIndex(1, 4);
    }

    public static DateTimeFormatter longDateTime() {
        return createFormatterForStyleIndex(1, 1);
    }

    public static DateTimeFormatter longTime() {
        return createFormatterForStyleIndex(4, 1);
    }

    public static DateTimeFormatter mediumDate() {
        return createFormatterForStyleIndex(2, 4);
    }

    public static DateTimeFormatter mediumDateTime() {
        return createFormatterForStyleIndex(2, 2);
    }

    public static DateTimeFormatter mediumTime() {
        return createFormatterForStyleIndex(4, 2);
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(Unknown Source:327)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(Unknown Source:85)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:136)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(Unknown Source:137)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:147)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(Unknown Source:312)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(Unknown Source:44)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(Unknown Source:84)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(Unknown Source:6)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:22)
        */
    private static void parsePatternTo(org.joda.time.format.DateTimeFormatterBuilder r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormat.parsePatternTo(org.joda.time.format.DateTimeFormatterBuilder, java.lang.String):void");
    }

    private static String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 != '\'') {
                    if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    sb.append(charAt2);
                } else {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i = i3;
                    }
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    public static String patternForStyle(String str, Locale locale) {
        DateTimeFormatter createFormatterForStyle = createFormatterForStyle(str);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return ((StyleFormatter) createFormatterForStyle.getPrinter0()).getPattern(locale);
    }

    private static int selectStyle(char c) {
        if (c == '-') {
            return 4;
        }
        if (c == 'F') {
            return 0;
        }
        if (c == 'S') {
            return 3;
        }
        if (c == 'L') {
            return 1;
        }
        if (c == 'M') {
            return 2;
        }
        throw new IllegalArgumentException("Invalid style character: " + c);
    }

    public static DateTimeFormatter shortDate() {
        return createFormatterForStyleIndex(3, 4);
    }

    public static DateTimeFormatter shortDateTime() {
        return createFormatterForStyleIndex(3, 3);
    }

    public static DateTimeFormatter shortTime() {
        return createFormatterForStyleIndex(4, 3);
    }
}
