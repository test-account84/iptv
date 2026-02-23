package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class IslamicChronology extends BasicChronology {
    public static final int AH = 1;
    private static final int CYCLE = 30;
    private static final int LONG_MONTH_LENGTH = 30;
    private static final int MAX_YEAR = 292271022;
    private static final long MILLIS_PER_CYCLE = 918518400000L;
    private static final long MILLIS_PER_LONG_MONTH = 2592000000L;
    private static final long MILLIS_PER_LONG_YEAR = 30672000000L;
    private static final long MILLIS_PER_MONTH = 2551440384L;
    private static final long MILLIS_PER_MONTH_PAIR = 5097600000L;
    private static final long MILLIS_PER_SHORT_YEAR = 30585600000L;
    private static final long MILLIS_PER_YEAR = 30617280288L;
    private static final long MILLIS_YEAR_1 = -42521587200000L;
    private static final int MIN_YEAR = -292269337;
    private static final int MONTH_PAIR_LENGTH = 59;
    private static final int SHORT_MONTH_LENGTH = 29;
    private static final long serialVersionUID = -3663823829888L;
    private final LeapYearPatternType iLeapYears;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("AH");
    public static final LeapYearPatternType LEAP_YEAR_15_BASED = new LeapYearPatternType(0, 623158436);
    public static final LeapYearPatternType LEAP_YEAR_16_BASED = new LeapYearPatternType(1, 623191204);
    public static final LeapYearPatternType LEAP_YEAR_INDIAN = new LeapYearPatternType(2, 690562340);
    public static final LeapYearPatternType LEAP_YEAR_HABASH_AL_HASIB = new LeapYearPatternType(3, 153692453);
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final IslamicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    public static class LeapYearPatternType implements Serializable {
        private static final long serialVersionUID = 26581275372698L;
        final byte index;
        final int pattern;

        public LeapYearPatternType(int i, int i2) {
            this.index = (byte) i;
            this.pattern = i2;
        }

        private Object readResolve() {
            byte b = this.index;
            return b != 0 ? b != 1 ? b != 2 ? b != 3 ? this : IslamicChronology.LEAP_YEAR_HABASH_AL_HASIB : IslamicChronology.LEAP_YEAR_INDIAN : IslamicChronology.LEAP_YEAR_16_BASED : IslamicChronology.LEAP_YEAR_15_BASED;
        }

        public boolean equals(Object obj) {
            return (obj instanceof LeapYearPatternType) && this.index == ((LeapYearPatternType) obj).index;
        }

        public int hashCode() {
            return this.index;
        }

        public boolean isLeapYear(int i) {
            return ((1 << (i % 30)) & this.pattern) > 0;
        }
    }

    public IslamicChronology(Chronology chronology, Object obj, LeapYearPatternType leapYearPatternType) {
        super(chronology, obj, 4);
        this.iLeapYears = leapYearPatternType;
    }

    public static IslamicChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), LEAP_YEAR_16_BASED);
    }

    public static IslamicChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public void assemble(AssembledChronology.Fields fields) {
        if (getBase() == null) {
            super.assemble(fields);
            fields.era = ERA_FIELD;
            BasicMonthOfYearDateTimeField basicMonthOfYearDateTimeField = new BasicMonthOfYearDateTimeField(this, 12);
            fields.monthOfYear = basicMonthOfYearDateTimeField;
            fields.months = basicMonthOfYearDateTimeField.getDurationField();
        }
    }

    public long calculateFirstDayOfYearMillis(int i) {
        if (i > 292271022) {
            throw new ArithmeticException("Year is too large: " + i + " > 292271022");
        }
        if (i < -292269337) {
            throw new ArithmeticException("Year is too small: " + i + " < -292269337");
        }
        long j = ((r6 / 30) * 918518400000L) - 42521587200000L;
        int i2 = ((i - 1) % 30) + 1;
        for (int i3 = 1; i3 < i2; i3++) {
            j += isLeapYear(i3) ? 30672000000L : 30585600000L;
        }
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IslamicChronology) && getLeapYearPatternType().index == ((IslamicChronology) obj).getLeapYearPatternType().index && super.equals(obj);
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 21260793600000L;
    }

    public long getAverageMillisPerMonth() {
        return 2551440384L;
    }

    public long getAverageMillisPerYear() {
        return 30617280288L;
    }

    public long getAverageMillisPerYearDividedByTwo() {
        return 15308640144L;
    }

    public int getDayOfMonth(long j) {
        int dayOfYear = getDayOfYear(j) - 1;
        if (dayOfYear == 354) {
            return 30;
        }
        return ((dayOfYear % 59) % 30) + 1;
    }

    public int getDaysInMonthMax() {
        return 30;
    }

    public int getDaysInYear(int i) {
        return isLeapYear(i) ? 355 : 354;
    }

    public int getDaysInYearMax() {
        return 355;
    }

    public int getDaysInYearMonth(int i, int i2) {
        return ((i2 == 12 && isLeapYear(i)) || (i2 + (-1)) % 2 == 0) ? 30 : 29;
    }

    public LeapYearPatternType getLeapYearPatternType() {
        return this.iLeapYears;
    }

    public int getMaxYear() {
        return 292271022;
    }

    public int getMinYear() {
        return 1;
    }

    public int getMonthOfYear(long j, int i) {
        int yearMillis = (int) ((j - getYearMillis(i)) / 86400000);
        if (yearMillis == 354) {
            return 12;
        }
        return ((yearMillis * 2) / 59) + 1;
    }

    public long getTotalMillisByYearMonth(int i, int i2) {
        int i3 = i2 - 1;
        int i4 = i3 % 2;
        int i5 = i3 / 2;
        return i4 == 1 ? (i5 * 5097600000L) + 2592000000L : i5 * 5097600000L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r6 = 30585600000L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0024, code lost:
    
        if (isLeapYear(r0) != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0026, code lost:
    
        r6 = 30672000000L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (r9 < r6) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        r9 = r9 - r6;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (isLeapYear(r0) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        r6 = 30585600000L;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0034 -> B:3:0x0026). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getYear(long r9) {
        /*
            r8 = this;
            r0 = -42521587200000(0xffffd953abe65000, double:NaN)
            long r9 = r9 - r0
            r0 = 918518400000(0xd5dbf68400, double:4.53808386513E-312)
            long r2 = r9 / r0
            long r9 = r9 % r0
            r0 = 30
            long r2 = r2 * r0
            r0 = 1
            long r2 = r2 + r0
            int r0 = (int) r2
            boolean r1 = r8.isLeapYear(r0)
            r2 = 30585600000(0x71f0b3800, double:1.51112942174E-313)
            r4 = 30672000000(0x724319400, double:1.5153981489E-313)
            if (r1 == 0) goto L28
        L26:
            r6 = r4
            goto L29
        L28:
            r6 = r2
        L29:
            int r1 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r1 < 0) goto L37
            long r9 = r9 - r6
            int r0 = r0 + 1
            boolean r1 = r8.isLeapYear(r0)
            if (r1 == 0) goto L28
            goto L26
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.IslamicChronology.getYear(long):int");
    }

    public long getYearDifference(long j, long j2) {
        int year = getYear(j);
        int year2 = getYear(j2);
        long yearMillis = j - getYearMillis(year);
        int i = year - year2;
        if (yearMillis < j2 - getYearMillis(year2)) {
            i--;
        }
        return i;
    }

    public int hashCode() {
        return (super.hashCode() * 13) + getLeapYearPatternType().hashCode();
    }

    public boolean isLeapYear(int i) {
        return this.iLeapYears.isLeapYear(i);
    }

    public long setYear(long j, int i) {
        int dayOfYear = getDayOfYear(j, getYear(j));
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 354 && !isLeapYear(i)) {
            dayOfYear--;
        }
        return getYearMonthDayMillis(i, 1, dayOfYear) + millisOfDay;
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, LEAP_YEAR_16_BASED);
    }

    public int getDaysInMonthMax(int i) {
        return (i == 12 || (i + (-1)) % 2 == 0) ? 30 : 29;
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone, LeapYearPatternType leapYearPatternType) {
        IslamicChronology islamicChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        IslamicChronology[] islamicChronologyArr = (IslamicChronology[]) concurrentHashMap.get(dateTimeZone);
        if (islamicChronologyArr == null) {
            islamicChronologyArr = new IslamicChronology[4];
            IslamicChronology[] islamicChronologyArr2 = (IslamicChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, islamicChronologyArr);
            if (islamicChronologyArr2 != null) {
                islamicChronologyArr = islamicChronologyArr2;
            }
        }
        IslamicChronology islamicChronology2 = islamicChronologyArr[leapYearPatternType.index];
        if (islamicChronology2 == null) {
            synchronized (islamicChronologyArr) {
                try {
                    islamicChronology2 = islamicChronologyArr[leapYearPatternType.index];
                    if (islamicChronology2 == null) {
                        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                        if (dateTimeZone == dateTimeZone2) {
                            IslamicChronology islamicChronology3 = new IslamicChronology(null, null, leapYearPatternType);
                            islamicChronology = new IslamicChronology(LimitChronology.getInstance(islamicChronology3, new DateTime(1, 1, 1, 0, 0, 0, 0, islamicChronology3), null), null, leapYearPatternType);
                        } else {
                            islamicChronology = new IslamicChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, leapYearPatternType), dateTimeZone), null, leapYearPatternType);
                        }
                        islamicChronologyArr[leapYearPatternType.index] = islamicChronology;
                        islamicChronology2 = islamicChronology;
                    }
                } finally {
                }
            }
        }
        return islamicChronology2;
    }
}
