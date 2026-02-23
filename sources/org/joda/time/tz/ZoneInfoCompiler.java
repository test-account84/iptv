package org.joda.time.tz;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ZoneInfoCompiler {
    static Chronology cLenientISO;
    static DateTimeOfYear cStartOfYear;
    static ThreadLocal cVerbose = new 1();
    private Map iRuleSets = new HashMap();
    private List iZones = new ArrayList();
    private List iLinks = new ArrayList();

    public static class 1 extends ThreadLocal {
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public static class DateTimeOfYear {
        public final boolean iAdvanceDayOfWeek;
        public final int iDayOfMonth;
        public final int iDayOfWeek;
        public final int iMillisOfDay;
        public final int iMonthOfYear;
        public final char iZoneChar;

        public DateTimeOfYear() {
            this.iMonthOfYear = 1;
            this.iDayOfMonth = 1;
            this.iDayOfWeek = 0;
            this.iAdvanceDayOfWeek = false;
            this.iMillisOfDay = 0;
            this.iZoneChar = 'w';
        }

        public void addCutover(DateTimeZoneBuilder dateTimeZoneBuilder, int i) {
            dateTimeZoneBuilder.addCutover(i, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str, int i, int i2, int i3) {
            dateTimeZoneBuilder.addRecurringSavings(str, i, i2, i3, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public String toString() {
            return "MonthOfYear: " + this.iMonthOfYear + "\nDayOfMonth: " + this.iDayOfMonth + "\nDayOfWeek: " + this.iDayOfWeek + "\nAdvanceDayOfWeek: " + this.iAdvanceDayOfWeek + "\nMillisOfDay: " + this.iMillisOfDay + "\nZoneChar: " + this.iZoneChar + "\n";
        }

        public DateTimeOfYear(StringTokenizer stringTokenizer) {
            int i;
            int i2;
            boolean z;
            int parseDayOfWeek;
            LocalDate localDate;
            LocalDate plusDays;
            int i3 = 1;
            int i4 = 0;
            char c = 'w';
            if (stringTokenizer.hasMoreTokens()) {
                int parseMonth = ZoneInfoCompiler.parseMonth(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.startsWith("last")) {
                        parseDayOfWeek = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(4));
                        i2 = -1;
                    } else {
                        try {
                            i2 = Integer.parseInt(nextToken);
                            parseDayOfWeek = 0;
                        } catch (NumberFormatException unused) {
                            int indexOf = nextToken.indexOf(">=");
                            if (indexOf > 0) {
                                int parseInt = Integer.parseInt(nextToken.substring(indexOf + 2));
                                parseDayOfWeek = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(0, indexOf));
                                i2 = parseInt;
                                z = true;
                            } else {
                                int indexOf2 = nextToken.indexOf("<=");
                                if (indexOf2 <= 0) {
                                    throw new IllegalArgumentException(nextToken);
                                }
                                int parseInt2 = Integer.parseInt(nextToken.substring(indexOf2 + 2));
                                parseDayOfWeek = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(0, indexOf2));
                                i2 = parseInt2;
                            }
                        }
                    }
                    z = false;
                    if (stringTokenizer.hasMoreTokens()) {
                        String nextToken2 = stringTokenizer.nextToken();
                        c = ZoneInfoCompiler.parseZoneChar(nextToken2.charAt(nextToken2.length() - 1));
                        if (nextToken2.equals("24:00")) {
                            if (parseMonth == 12 && i2 == 31) {
                                nextToken2 = "23:59:59.999";
                            } else {
                                if (i2 == -1) {
                                    localDate = new LocalDate(2001, parseMonth, 1);
                                    plusDays = localDate.plusMonths(1);
                                } else {
                                    localDate = new LocalDate(2001, parseMonth, i2);
                                    plusDays = localDate.plusDays(1);
                                }
                                boolean z2 = (i2 == -1 || parseDayOfWeek == 0) ? false : true;
                                int monthOfYear = plusDays.getMonthOfYear();
                                int dayOfMonth = plusDays.getDayOfMonth();
                                z = z2;
                                i3 = monthOfYear;
                                i4 = parseDayOfWeek != 0 ? (parseDayOfWeek % 7) + 1 : parseDayOfWeek;
                                i2 = dayOfMonth;
                            }
                        }
                        i3 = parseMonth;
                        i = ZoneInfoCompiler.parseTime(nextToken2);
                        i4 = parseDayOfWeek;
                    } else {
                        i3 = parseMonth;
                        i4 = parseDayOfWeek;
                    }
                    i = 0;
                } else {
                    i3 = parseMonth;
                    i = 0;
                    i2 = 1;
                    z = false;
                }
            } else {
                i = 0;
                i2 = 1;
                z = false;
            }
            this.iMonthOfYear = i3;
            this.iDayOfMonth = i2;
            this.iDayOfWeek = i4;
            this.iAdvanceDayOfWeek = z;
            this.iMillisOfDay = i;
            this.iZoneChar = c;
        }
    }

    public static class Rule {
        public final DateTimeOfYear iDateTimeOfYear;
        public final int iFromYear;
        public final String iLetterS;
        public final String iName;
        public final int iSaveMillis;
        public final int iToYear;
        public final String iType;

        public Rule(StringTokenizer stringTokenizer) {
            this.iName = stringTokenizer.nextToken().intern();
            int parseYear = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), 0);
            this.iFromYear = parseYear;
            int parseYear2 = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), parseYear);
            this.iToYear = parseYear2;
            if (parseYear2 < parseYear) {
                throw new IllegalArgumentException();
            }
            this.iType = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iDateTimeOfYear = new DateTimeOfYear(stringTokenizer);
            this.iSaveMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iLetterS = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
        }

        private String formatName(String str) {
            String str2;
            int indexOf = str.indexOf(47);
            if (indexOf > 0) {
                return (this.iSaveMillis == 0 ? str.substring(0, indexOf) : str.substring(indexOf + 1)).intern();
            }
            int indexOf2 = str.indexOf("%s");
            if (indexOf2 < 0) {
                return str;
            }
            String substring = str.substring(0, indexOf2);
            String substring2 = str.substring(indexOf2 + 2);
            if (this.iLetterS == null) {
                str2 = substring.concat(substring2);
            } else {
                str2 = substring + this.iLetterS + substring2;
            }
            return str2.intern();
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str) {
            this.iDateTimeOfYear.addRecurring(dateTimeZoneBuilder, formatName(str), this.iSaveMillis, this.iFromYear, this.iToYear);
        }

        public String toString() {
            return "[Rule]\nName: " + this.iName + "\nFromYear: " + this.iFromYear + "\nToYear: " + this.iToYear + "\nType: " + this.iType + "\n" + this.iDateTimeOfYear + "SaveMillis: " + this.iSaveMillis + "\nLetterS: " + this.iLetterS + "\n";
        }
    }

    public static class RuleSet {
        private List iRules;

        public RuleSet(Rule rule) {
            ArrayList arrayList = new ArrayList();
            this.iRules = arrayList;
            arrayList.add(rule);
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str) {
            for (int i = 0; i < this.iRules.size(); i++) {
                ((Rule) this.iRules.get(i)).addRecurring(dateTimeZoneBuilder, str);
            }
        }

        public void addRule(Rule rule) {
            if (!rule.iName.equals(((Rule) this.iRules.get(0)).iName)) {
                throw new IllegalArgumentException("Rule name mismatch");
            }
            this.iRules.add(rule);
        }
    }

    public static class Zone {
        public final String iFormat;
        public final String iName;
        private Zone iNext;
        public final int iOffsetMillis;
        public final String iRules;
        public final DateTimeOfYear iUntilDateTimeOfYear;
        public final int iUntilYear;

        private Zone(String str, StringTokenizer stringTokenizer) {
            int i;
            this.iName = str.intern();
            this.iOffsetMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iRules = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iFormat = stringTokenizer.nextToken().intern();
            DateTimeOfYear startOfYear = ZoneInfoCompiler.getStartOfYear();
            if (stringTokenizer.hasMoreTokens()) {
                i = Integer.parseInt(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    startOfYear = new DateTimeOfYear(stringTokenizer);
                }
            } else {
                i = Integer.MAX_VALUE;
            }
            this.iUntilYear = i;
            this.iUntilDateTimeOfYear = startOfYear;
        }

        public void addToBuilder(DateTimeZoneBuilder dateTimeZoneBuilder, Map map) {
            addToBuilder(this, dateTimeZoneBuilder, map);
        }

        public void chain(StringTokenizer stringTokenizer) {
            Zone zone = this.iNext;
            if (zone != null) {
                zone.chain(stringTokenizer);
            } else {
                this.iNext = new Zone(this.iName, stringTokenizer);
            }
        }

        public String toString() {
            String str = "[Zone]\nName: " + this.iName + "\nOffsetMillis: " + this.iOffsetMillis + "\nRules: " + this.iRules + "\nFormat: " + this.iFormat + "\nUntilYear: " + this.iUntilYear + "\n" + this.iUntilDateTimeOfYear;
            if (this.iNext == null) {
                return str;
            }
            return str + "...\n" + this.iNext.toString();
        }

        public Zone(StringTokenizer stringTokenizer) {
            this(stringTokenizer.nextToken(), stringTokenizer);
        }

        private static void addToBuilder(Zone zone, DateTimeZoneBuilder dateTimeZoneBuilder, Map map) {
            while (zone != null) {
                dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                String str = zone.iRules;
                if (str == null) {
                    dateTimeZoneBuilder.setFixedSavings(zone.iFormat, 0);
                } else {
                    try {
                        dateTimeZoneBuilder.setFixedSavings(zone.iFormat, ZoneInfoCompiler.parseTime(str));
                    } catch (Exception unused) {
                        RuleSet ruleSet = (RuleSet) map.get(zone.iRules);
                        if (ruleSet == null) {
                            throw new IllegalArgumentException("Rules not found: " + zone.iRules);
                        }
                        ruleSet.addRecurring(dateTimeZoneBuilder, zone.iFormat);
                    }
                }
                int i = zone.iUntilYear;
                if (i == Integer.MAX_VALUE) {
                    return;
                }
                zone.iUntilDateTimeOfYear.addCutover(dateTimeZoneBuilder, i);
                zone = zone.iNext;
            }
        }
    }

    public static Chronology getLenientISOChronology() {
        if (cLenientISO == null) {
            cLenientISO = LenientChronology.getInstance(ISOChronology.getInstanceUTC());
        }
        return cLenientISO;
    }

    public static DateTimeOfYear getStartOfYear() {
        if (cStartOfYear == null) {
            cStartOfYear = new DateTimeOfYear();
        }
        return cStartOfYear;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        if ("-?".equals(r9[r3]) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        printUsage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r9) throws java.lang.Exception {
        /*
            int r0 = r9.length
            if (r0 != 0) goto L7
            printUsage()
            return
        L7:
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = 0
            r4 = 0
        Lc:
            int r5 = r9.length
            r6 = 1
            if (r3 >= r5) goto L57
            java.lang.String r5 = "-src"
            r7 = r9[r3]     // Catch: java.lang.IndexOutOfBoundsException -> L53
            boolean r5 = r5.equals(r7)     // Catch: java.lang.IndexOutOfBoundsException -> L53
            if (r5 == 0) goto L24
            java.io.File r0 = new java.io.File     // Catch: java.lang.IndexOutOfBoundsException -> L53
            int r3 = r3 + 1
            r5 = r9[r3]     // Catch: java.lang.IndexOutOfBoundsException -> L53
            r0.<init>(r5)     // Catch: java.lang.IndexOutOfBoundsException -> L53
            goto L43
        L24:
            java.lang.String r5 = "-dst"
            r7 = r9[r3]     // Catch: java.lang.IndexOutOfBoundsException -> L53
            boolean r5 = r5.equals(r7)     // Catch: java.lang.IndexOutOfBoundsException -> L53
            if (r5 == 0) goto L38
            java.io.File r2 = new java.io.File     // Catch: java.lang.IndexOutOfBoundsException -> L53
            int r3 = r3 + 1
            r5 = r9[r3]     // Catch: java.lang.IndexOutOfBoundsException -> L53
            r2.<init>(r5)     // Catch: java.lang.IndexOutOfBoundsException -> L53
            goto L43
        L38:
            java.lang.String r5 = "-verbose"
            r7 = r9[r3]     // Catch: java.lang.IndexOutOfBoundsException -> L53
            boolean r5 = r5.equals(r7)     // Catch: java.lang.IndexOutOfBoundsException -> L53
            if (r5 == 0) goto L45
            r4 = 1
        L43:
            int r3 = r3 + r6
            goto Lc
        L45:
            java.lang.String r5 = "-?"
            r7 = r9[r3]     // Catch: java.lang.IndexOutOfBoundsException -> L53
            boolean r5 = r5.equals(r7)     // Catch: java.lang.IndexOutOfBoundsException -> L53
            if (r5 == 0) goto L57
            printUsage()     // Catch: java.lang.IndexOutOfBoundsException -> L53
            return
        L53:
            printUsage()
            return
        L57:
            int r5 = r9.length
            if (r3 < r5) goto L5e
            printUsage()
            return
        L5e:
            int r5 = r9.length
            int r5 = r5 - r3
            java.io.File[] r5 = new java.io.File[r5]
        L62:
            int r7 = r9.length
            if (r3 >= r7) goto L7a
            java.io.File r7 = new java.io.File
            if (r0 != 0) goto L6f
            r8 = r9[r3]
            r7.<init>(r8)
            goto L74
        L6f:
            r8 = r9[r3]
            r7.<init>(r0, r8)
        L74:
            r5[r1] = r7
            int r3 = r3 + 1
            int r1 = r1 + r6
            goto L62
        L7a:
            java.lang.ThreadLocal r9 = org.joda.time.tz.ZoneInfoCompiler.cVerbose
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r9.set(r0)
            org.joda.time.tz.ZoneInfoCompiler r9 = new org.joda.time.tz.ZoneInfoCompiler
            r9.<init>()
            r9.compile(r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.ZoneInfoCompiler.main(java.lang.String[]):void");
    }

    public static int parseDayOfWeek(String str) {
        DateTimeField dayOfWeek = ISOChronology.getInstanceUTC().dayOfWeek();
        return dayOfWeek.get(dayOfWeek.set(0L, str, Locale.ENGLISH));
    }

    public static int parseMonth(String str) {
        DateTimeField monthOfYear = ISOChronology.getInstanceUTC().monthOfYear();
        return monthOfYear.get(monthOfYear.set(0L, str, Locale.ENGLISH));
    }

    public static String parseOptional(String str) {
        if (str.equals("-")) {
            return null;
        }
        return str;
    }

    public static int parseTime(String str) {
        DateTimeFormatter hourMinuteSecondFraction = ISODateTimeFormat.hourMinuteSecondFraction();
        MutableDateTime mutableDateTime = new MutableDateTime(0L, getLenientISOChronology());
        boolean startsWith = str.startsWith("-");
        if (hourMinuteSecondFraction.parseInto(mutableDateTime, str, startsWith ? 1 : 0) == (~(startsWith ? 1 : 0))) {
            throw new IllegalArgumentException(str);
        }
        int millis = (int) mutableDateTime.getMillis();
        return startsWith ? -millis : millis;
    }

    public static int parseYear(String str, int i) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("minimum") || lowerCase.equals("min")) {
            return Integer.MIN_VALUE;
        }
        if (lowerCase.equals("maximum") || lowerCase.equals("max")) {
            return Integer.MAX_VALUE;
        }
        return lowerCase.equals("only") ? i : Integer.parseInt(lowerCase);
    }

    public static char parseZoneChar(char c) {
        if (c != 'G') {
            if (c != 'S') {
                if (c != 'U' && c != 'Z' && c != 'g') {
                    if (c != 's') {
                        if (c != 'u' && c != 'z') {
                            return 'w';
                        }
                    }
                }
            }
            return 's';
        }
        return 'u';
    }

    private static void printUsage() {
        PrintStream printStream = System.out;
        printStream.println("Usage: java org.joda.time.tz.ZoneInfoCompiler <options> <source files>");
        printStream.println("where possible options include:");
        printStream.println("  -src <directory>    Specify where to read source files");
        printStream.println("  -dst <directory>    Specify where to write generated files");
        printStream.println("  -verbose            Output verbosely (default false)");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a4, code lost:
    
        r1 = java.lang.System.out;
        r3 = new java.lang.StringBuilder();
        r3.append("*s* Error in ");
        r3.append(r18.getID());
        r3.append(" ");
        r3.append(new org.joda.time.DateTime(r13, org.joda.time.chrono.ISOChronology.getInstanceUTC()));
        r3.append(", nameKey=");
        r3.append(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cf, code lost:
    
        r6 = org.joda.time.chrono.ISOChronology.getInstanceUTC().year().set(0, 2050);
        r3 = org.joda.time.chrono.ISOChronology.getInstanceUTC().year().set(0, 1850);
        r1 = r12.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00eb, code lost:
    
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ed, code lost:
    
        if (r1 < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ef, code lost:
    
        r8 = r18.previousTransition(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f5, code lost:
    
        if (r8 == r6) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f9, code lost:
    
        if (r8 >= r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fd, code lost:
    
        r5 = ((java.lang.Long) r12.get(r1)).longValue() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010c, code lost:
    
        if (r5 == r8) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0140, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010e, code lost:
    
        r1 = java.lang.System.out;
        r3 = new java.lang.StringBuilder();
        r3.append("*r* Error in ");
        r3.append(r18.getID());
        r3.append(" ");
        r3.append(new org.joda.time.DateTime(r8, org.joda.time.chrono.ISOChronology.getInstanceUTC()));
        r3.append(" != ");
        r0 = new org.joda.time.DateTime(r5, org.joda.time.chrono.ISOChronology.getInstanceUTC());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fb, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean test(java.lang.String r17, org.joda.time.DateTimeZone r18) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.ZoneInfoCompiler.test(java.lang.String, org.joda.time.DateTimeZone):boolean");
    }

    public static boolean verbose() {
        return ((Boolean) cVerbose.get()).booleanValue();
    }

    public static void writeZoneInfoMap(DataOutputStream dataOutputStream, Map map) throws IOException {
        HashMap hashMap = new HashMap(map.size());
        TreeMap treeMap = new TreeMap();
        short s = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!hashMap.containsKey(str)) {
                Short valueOf = Short.valueOf(s);
                hashMap.put(str, valueOf);
                treeMap.put(valueOf, str);
                s = (short) (s + 1);
                if (s == 0) {
                    throw new InternalError("Too many time zone ids");
                }
            }
            String id = ((DateTimeZone) entry.getValue()).getID();
            if (!hashMap.containsKey(id)) {
                Short valueOf2 = Short.valueOf(s);
                hashMap.put(id, valueOf2);
                treeMap.put(valueOf2, id);
                s = (short) (s + 1);
                if (s == 0) {
                    throw new InternalError("Too many time zone ids");
                }
            }
        }
        dataOutputStream.writeShort(treeMap.size());
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            dataOutputStream.writeUTF((String) it.next());
        }
        dataOutputStream.writeShort(map.size());
        for (Map.Entry entry2 : map.entrySet()) {
            dataOutputStream.writeShort(((Short) hashMap.get((String) entry2.getKey())).shortValue());
            dataOutputStream.writeShort(((Short) hashMap.get(((DateTimeZone) entry2.getValue()).getID())).shortValue());
        }
    }

    public Map compile(File file, File[] fileArr) throws IOException {
        if (fileArr != null) {
            for (File file2 : fileArr) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                parseDataFile(bufferedReader);
                bufferedReader.close();
            }
        }
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("Destination directory doesn't exist and cannot be created: " + file);
            }
            if (!file.isDirectory()) {
                throw new IOException("Destination is not a directory: " + file);
            }
        }
        TreeMap treeMap = new TreeMap();
        System.out.println("Writing zoneinfo files");
        for (int i = 0; i < this.iZones.size(); i++) {
            Zone zone = (Zone) this.iZones.get(i);
            DateTimeZoneBuilder dateTimeZoneBuilder = new DateTimeZoneBuilder();
            zone.addToBuilder(dateTimeZoneBuilder, this.iRuleSets);
            DateTimeZone dateTimeZone = dateTimeZoneBuilder.toDateTimeZone(zone.iName, true);
            if (test(dateTimeZone.getID(), dateTimeZone)) {
                treeMap.put(dateTimeZone.getID(), dateTimeZone);
                if (file == null) {
                    continue;
                } else {
                    if (verbose()) {
                        System.out.println("Writing " + dateTimeZone.getID());
                    }
                    File file3 = new File(file, dateTimeZone.getID());
                    if (!file3.getParentFile().exists()) {
                        file3.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        dateTimeZoneBuilder.writeTo(zone.iName, (OutputStream) fileOutputStream);
                        fileOutputStream.close();
                        FileInputStream fileInputStream = new FileInputStream(file3);
                        DateTimeZone readFrom = DateTimeZoneBuilder.readFrom((InputStream) fileInputStream, dateTimeZone.getID());
                        fileInputStream.close();
                        if (!dateTimeZone.equals(readFrom)) {
                            System.out.println("*e* Error in " + dateTimeZone.getID() + ": Didn't read properly from file");
                        }
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < 2; i2++) {
            for (int i3 = 0; i3 < this.iLinks.size(); i3 += 2) {
                String str = (String) this.iLinks.get(i3);
                String str2 = (String) this.iLinks.get(i3 + 1);
                DateTimeZone dateTimeZone2 = (DateTimeZone) treeMap.get(str);
                if (dateTimeZone2 != null) {
                    treeMap.put(str2, dateTimeZone2);
                } else if (i2 > 0) {
                    System.out.println("Cannot find time zone '" + str + "' to link alias '" + str2 + "' to");
                }
            }
        }
        if (file != null) {
            System.out.println("Writing ZoneInfoMap");
            File file4 = new File(file, "ZoneInfoMap");
            if (!file4.getParentFile().exists()) {
                file4.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file4));
            try {
                TreeMap treeMap2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                treeMap2.putAll(treeMap);
                writeZoneInfoMap(dataOutputStream, treeMap2);
            } finally {
                dataOutputStream.close();
            }
        }
        return treeMap;
    }

    public void parseDataFile(BufferedReader bufferedReader) throws IOException {
        Zone zone;
        loop0: while (true) {
            zone = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                String trim = readLine.trim();
                if (trim.length() != 0 && trim.charAt(0) != '#') {
                    int indexOf = readLine.indexOf(35);
                    if (indexOf >= 0) {
                        readLine = readLine.substring(0, indexOf);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                    if (!Character.isWhitespace(readLine.charAt(0)) || !stringTokenizer.hasMoreTokens()) {
                        if (zone != null) {
                            this.iZones.add(zone);
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            if (nextToken.equalsIgnoreCase("Rule")) {
                                Rule rule = new Rule(stringTokenizer);
                                RuleSet ruleSet = (RuleSet) this.iRuleSets.get(rule.iName);
                                if (ruleSet == null) {
                                    this.iRuleSets.put(rule.iName, new RuleSet(rule));
                                } else {
                                    ruleSet.addRule(rule);
                                }
                            } else if (nextToken.equalsIgnoreCase("Zone")) {
                                zone = new Zone(stringTokenizer);
                            } else if (nextToken.equalsIgnoreCase("Link")) {
                                this.iLinks.add(stringTokenizer.nextToken());
                                this.iLinks.add(stringTokenizer.nextToken());
                            } else {
                                System.out.println("Unknown line: " + readLine);
                            }
                        }
                    } else if (zone != null) {
                        zone.chain(stringTokenizer);
                    }
                }
            }
        }
        if (zone != null) {
            this.iZones.add(zone);
        }
    }
}
