package org.joda.time;

import com.google.ads.interactivemedia.v3.internal.z1;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.FormatUtils;
import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.FixedDateTimeZone;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;
import org.joda.time.tz.UTCProvider;
import org.joda.time.tz.ZoneInfoProvider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class DateTimeZone implements Serializable {
    private static final int MAX_MILLIS = 86399999;
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;
    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;
    private static final AtomicReference cProvider = new AtomicReference();
    private static final AtomicReference cNameProvider = new AtomicReference();
    private static final AtomicReference cDefault = new AtomicReference();

    public static final class LazyInit {
        static final Map CONVERSION_MAP = buildMap();
        static final DateTimeFormatter OFFSET_FORMATTER = buildFormatter();

        public static class 1 extends BaseChronology {
            private static final long serialVersionUID = -3128740902654445468L;

            public DateTimeZone getZone() {
                return null;
            }

            public String toString() {
                return getClass().getName();
            }

            public Chronology withUTC() {
                return this;
            }

            public Chronology withZone(DateTimeZone dateTimeZone) {
                return this;
            }
        }

        private static DateTimeFormatter buildFormatter() {
            return new DateTimeFormatterBuilder().appendTimeZoneOffset(null, true, 2, 4).toFormatter().withChronology(new 1());
        }

        private static Map buildMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("GMT", "UTC");
            hashMap.put("WET", "WET");
            hashMap.put("CET", "CET");
            hashMap.put("MET", "CET");
            hashMap.put("ECT", "CET");
            hashMap.put("EET", "EET");
            hashMap.put("MIT", "Pacific/Apia");
            hashMap.put("HST", "Pacific/Honolulu");
            hashMap.put("AST", "America/Anchorage");
            hashMap.put("PST", "America/Los_Angeles");
            hashMap.put("MST", "America/Denver");
            hashMap.put("PNT", "America/Phoenix");
            hashMap.put("CST", "America/Chicago");
            hashMap.put("EST", "America/New_York");
            hashMap.put("IET", "America/Indiana/Indianapolis");
            hashMap.put("PRT", "America/Puerto_Rico");
            hashMap.put("CNT", "America/St_Johns");
            hashMap.put("AGT", "America/Argentina/Buenos_Aires");
            hashMap.put("BET", "America/Sao_Paulo");
            hashMap.put("ART", "Africa/Cairo");
            hashMap.put("CAT", "Africa/Harare");
            hashMap.put("EAT", "Africa/Addis_Ababa");
            hashMap.put("NET", "Asia/Yerevan");
            hashMap.put("PLT", "Asia/Karachi");
            hashMap.put("IST", "Asia/Kolkata");
            hashMap.put("BST", "Asia/Dhaka");
            hashMap.put("VST", "Asia/Ho_Chi_Minh");
            hashMap.put("CTT", "Asia/Shanghai");
            hashMap.put("JST", "Asia/Tokyo");
            hashMap.put("ACT", "Australia/Darwin");
            hashMap.put("AET", "Australia/Sydney");
            hashMap.put("SST", "Pacific/Guadalcanal");
            hashMap.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(hashMap);
        }
    }

    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;
        private transient String iID;

        public Stub(String str) {
            this.iID = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.iID = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.iID);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.iID);
        }
    }

    public DateTimeZone(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        this.iID = str;
    }

    private static DateTimeZone fixedOffsetZone(String str, int i) {
        return i == 0 ? UTC : new FixedDateTimeZone(str, null, i, i);
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals("UTC")) {
            return UTC;
        }
        DateTimeZone zone = getProvider().getZone(str);
        if (zone != null) {
            return zone;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            int parseOffset = parseOffset(str);
            return ((long) parseOffset) == 0 ? UTC : fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
        throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
    }

    public static DateTimeZone forOffsetHours(int i) throws IllegalArgumentException {
        return forOffsetHoursMinutes(i, 0);
    }

    public static DateTimeZone forOffsetHoursMinutes(int i, int i2) throws IllegalArgumentException {
        if (i == 0 && i2 == 0) {
            return UTC;
        }
        if (i < -23 || i > 23) {
            throw new IllegalArgumentException("Hours out of range: " + i);
        }
        if (i2 < -59 || i2 > 59) {
            throw new IllegalArgumentException("Minutes out of range: " + i2);
        }
        if (i <= 0 || i2 >= 0) {
            int i3 = i * 60;
            try {
                return forOffsetMillis(FieldUtils.safeMultiply(i3 < 0 ? i3 - Math.abs(i2) : i3 + i2, 60000));
            } catch (ArithmeticException unused) {
                throw new IllegalArgumentException("Offset is too large");
            }
        }
        throw new IllegalArgumentException("Positive hours must not have negative minutes: " + i2);
    }

    public static DateTimeZone forOffsetMillis(int i) {
        if (i >= -86399999 && i <= 86399999) {
            return fixedOffsetZone(printOffset(i), i);
        }
        throw new IllegalArgumentException("Millis out of range: " + i);
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            return getDefault();
        }
        String id = timeZone.getID();
        if (id == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        }
        if (id.equals("UTC")) {
            return UTC;
        }
        String convertedId = getConvertedId(id);
        Provider provider = getProvider();
        DateTimeZone zone = convertedId != null ? provider.getZone(convertedId) : null;
        if (zone == null) {
            zone = provider.getZone(id);
        }
        if (zone != null) {
            return zone;
        }
        if (convertedId == null && (id.startsWith("GMT+") || id.startsWith("GMT-"))) {
            int parseOffset = parseOffset(id.substring(3));
            return ((long) parseOffset) == 0 ? UTC : fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
        throw new IllegalArgumentException("The datetime zone id '" + id + "' is not recognised");
    }

    public static Set getAvailableIDs() {
        return getProvider().getAvailableIDs();
    }

    private static String getConvertedId(String str) {
        return (String) LazyInit.CONVERSION_MAP.get(str);
    }

    public static DateTimeZone getDefault() {
        DateTimeZone dateTimeZone = (DateTimeZone) cDefault.get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                dateTimeZone = forID(property);
            }
        } catch (RuntimeException unused) {
        }
        if (dateTimeZone == null) {
            try {
                dateTimeZone = forTimeZone(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (dateTimeZone == null) {
            dateTimeZone = UTC;
        }
        AtomicReference atomicReference = cDefault;
        return !z1.a(atomicReference, (Object) null, dateTimeZone) ? (DateTimeZone) atomicReference.get() : dateTimeZone;
    }

    private static NameProvider getDefaultNameProvider() {
        NameProvider nameProvider = null;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property != null) {
                try {
                    nameProvider = (NameProvider) Class.forName(property).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SecurityException unused) {
        }
        return nameProvider == null ? new DefaultNameProvider() : nameProvider;
    }

    private static Provider getDefaultProvider() {
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (property != null) {
                try {
                    return validateProvider((Provider) Class.forName(property).newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SecurityException unused) {
        }
        try {
            String property2 = System.getProperty("org.joda.time.DateTimeZone.Folder");
            if (property2 != null) {
                try {
                    return validateProvider(new ZoneInfoProvider(new File(property2)));
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        } catch (SecurityException unused2) {
        }
        try {
            return validateProvider(new ZoneInfoProvider("org/joda/time/tz/data"));
        } catch (Exception e3) {
            e3.printStackTrace();
            return new UTCProvider();
        }
    }

    public static NameProvider getNameProvider() {
        AtomicReference atomicReference = cNameProvider;
        NameProvider nameProvider = (NameProvider) atomicReference.get();
        if (nameProvider != null) {
            return nameProvider;
        }
        NameProvider defaultNameProvider = getDefaultNameProvider();
        return !z1.a(atomicReference, (Object) null, defaultNameProvider) ? (NameProvider) atomicReference.get() : defaultNameProvider;
    }

    public static Provider getProvider() {
        AtomicReference atomicReference = cProvider;
        Provider provider = (Provider) atomicReference.get();
        if (provider != null) {
            return provider;
        }
        Provider defaultProvider = getDefaultProvider();
        return !z1.a(atomicReference, (Object) null, defaultProvider) ? (Provider) atomicReference.get() : defaultProvider;
    }

    private static int parseOffset(String str) {
        return -((int) LazyInit.OFFSET_FORMATTER.parseMillis(str));
    }

    private static String printOffset(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i = -i;
        }
        int i2 = i / 3600000;
        FormatUtils.appendPaddedInteger(stringBuffer, i2, 2);
        int i3 = i - (i2 * 3600000);
        int i4 = i3 / 60000;
        stringBuffer.append(':');
        FormatUtils.appendPaddedInteger(stringBuffer, i4, 2);
        int i5 = i3 - (i4 * 60000);
        if (i5 == 0) {
            return stringBuffer.toString();
        }
        int i6 = i5 / 1000;
        stringBuffer.append(':');
        FormatUtils.appendPaddedInteger(stringBuffer, i6, 2);
        int i7 = i5 - (i6 * 1000);
        if (i7 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        FormatUtils.appendPaddedInteger(stringBuffer, i7, 3);
        return stringBuffer.toString();
    }

    public static void setDefault(DateTimeZone dateTimeZone) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
        }
        if (dateTimeZone == null) {
            throw new IllegalArgumentException("The datetime zone must not be null");
        }
        cDefault.set(dateTimeZone);
    }

    public static void setNameProvider(NameProvider nameProvider) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
        }
        if (nameProvider == null) {
            nameProvider = getDefaultNameProvider();
        }
        cNameProvider.set(nameProvider);
    }

    public static void setProvider(Provider provider) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
        }
        if (provider == null) {
            provider = getDefaultProvider();
        } else {
            validateProvider(provider);
        }
        cProvider.set(provider);
    }

    private static Provider validateProvider(Provider provider) {
        Set availableIDs = provider.getAvailableIDs();
        if (availableIDs == null || availableIDs.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        }
        if (!availableIDs.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        }
        if (UTC.equals(provider.getZone("UTC"))) {
            return provider;
        }
        throw new IllegalArgumentException("Invalid UTC zone provided");
    }

    public long adjustOffset(long j, boolean z) {
        long j2 = j - 10800000;
        long offset = getOffset(j2);
        long offset2 = getOffset(10800000 + j);
        if (offset <= offset2) {
            return j;
        }
        long j3 = offset - offset2;
        long nextTransition = nextTransition(j2);
        long j4 = nextTransition - j3;
        return (j < j4 || j >= nextTransition + j3) ? j : j - j4 >= j3 ? z ? j : j - j3 : z ? j + j3 : j;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long convertLocalToUTC(long r12, boolean r14) {
        /*
            r11 = this;
            int r0 = r11.getOffset(r12)
            long r1 = (long) r0
            long r1 = r12 - r1
            int r3 = r11.getOffset(r1)
            if (r0 == r3) goto L3d
            if (r14 != 0) goto L11
            if (r0 >= 0) goto L3d
        L11:
            long r4 = r11.nextTransition(r1)
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r8 != 0) goto L1f
            r4 = r6
        L1f:
            long r1 = (long) r3
            long r1 = r12 - r1
            long r8 = r11.nextTransition(r1)
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 != 0) goto L2b
            goto L2c
        L2b:
            r6 = r8
        L2c:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L3d
            if (r14 != 0) goto L33
            goto L3e
        L33:
            org.joda.time.IllegalInstantException r14 = new org.joda.time.IllegalInstantException
            java.lang.String r0 = r11.getID()
            r14.<init>(r12, r0)
            throw r14
        L3d:
            r0 = r3
        L3e:
            long r0 = (long) r0
            long r2 = r12 - r0
            long r4 = r12 ^ r2
            r6 = 0
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L57
            long r12 = r12 ^ r0
            int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r14 < 0) goto L4f
            goto L57
        L4f:
            java.lang.ArithmeticException r12 = new java.lang.ArithmeticException
            java.lang.String r13 = "Subtracting time zone offset caused overflow"
            r12.<init>(r13)
            throw r12
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.convertLocalToUTC(long, boolean):long");
    }

    public long convertUTCToLocal(long j) {
        long offset = getOffset(j);
        long j2 = j + offset;
        if ((j ^ j2) >= 0 || (j ^ offset) < 0) {
            return j2;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public abstract boolean equals(Object obj);

    @ToString
    public final String getID() {
        return this.iID;
    }

    public long getMillisKeepLocal(DateTimeZone dateTimeZone, long j) {
        if (dateTimeZone == null) {
            dateTimeZone = getDefault();
        }
        DateTimeZone dateTimeZone2 = dateTimeZone;
        return dateTimeZone2 == this ? j : dateTimeZone2.convertLocalToUTC(convertUTCToLocal(j), false, j);
    }

    public final String getName(long j) {
        return getName(j, null);
    }

    public abstract String getNameKey(long j);

    public abstract int getOffset(long j);

    public final int getOffset(ReadableInstant readableInstant) {
        return getOffset(readableInstant == null ? DateTimeUtils.currentTimeMillis() : readableInstant.getMillis());
    }

    public int getOffsetFromLocal(long j) {
        int offset = getOffset(j);
        long j2 = j - offset;
        int offset2 = getOffset(j2);
        if (offset != offset2) {
            if (offset - offset2 < 0) {
                long nextTransition = nextTransition(j2);
                if (nextTransition == j2) {
                    nextTransition = Long.MAX_VALUE;
                }
                long j3 = j - offset2;
                long nextTransition2 = nextTransition(j3);
                if (nextTransition != (nextTransition2 != j3 ? nextTransition2 : Long.MAX_VALUE)) {
                    return offset;
                }
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j2);
            if (previousTransition < j2) {
                int offset3 = getOffset(previousTransition);
                if (j2 - previousTransition <= offset3 - offset) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public final String getShortName(long j) {
        return getShortName(j, null);
    }

    public abstract int getStandardOffset(long j);

    public int hashCode() {
        return getID().hashCode() + 57;
    }

    public abstract boolean isFixed();

    public boolean isLocalDateTimeGap(LocalDateTime localDateTime) {
        if (isFixed()) {
            return false;
        }
        try {
            localDateTime.toDateTime(this);
            return false;
        } catch (IllegalInstantException unused) {
            return true;
        }
    }

    public boolean isStandardOffset(long j) {
        return getOffset(j) == getStandardOffset(j);
    }

    public abstract long nextTransition(long j);

    public abstract long previousTransition(long j);

    public String toString() {
        return getID();
    }

    public TimeZone toTimeZone() {
        return DesugarTimeZone.getTimeZone(this.iID);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }

    public long convertLocalToUTC(long j, boolean z, long j2) {
        int offset = getOffset(j2);
        long j3 = j - offset;
        return getOffset(j3) == offset ? j3 : convertLocalToUTC(j, z);
    }

    public String getName(long j, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j);
        if (nameKey == null) {
            return this.iID;
        }
        NameProvider nameProvider = getNameProvider();
        String name = nameProvider instanceof DefaultNameProvider ? ((DefaultNameProvider) nameProvider).getName(locale, this.iID, nameKey, isStandardOffset(j)) : nameProvider.getName(locale, this.iID, nameKey);
        return name != null ? name : printOffset(getOffset(j));
    }

    public String getShortName(long j, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j);
        if (nameKey == null) {
            return this.iID;
        }
        NameProvider nameProvider = getNameProvider();
        String shortName = nameProvider instanceof DefaultNameProvider ? ((DefaultNameProvider) nameProvider).getShortName(locale, this.iID, nameKey, isStandardOffset(j)) : nameProvider.getShortName(locale, this.iID, nameKey);
        return shortName != null ? shortName : printOffset(getOffset(j));
    }
}
