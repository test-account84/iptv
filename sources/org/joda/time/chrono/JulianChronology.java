package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class JulianChronology extends BasicGJChronology {
    private static final int MAX_YEAR = 292272992;
    private static final long MILLIS_PER_MONTH = 2629800000L;
    private static final long MILLIS_PER_YEAR = 31557600000L;
    private static final int MIN_YEAR = -292269054;
    private static final long serialVersionUID = -8731039522547897247L;
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final JulianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    public JulianChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    public static int adjustYearForSet(int i) {
        if (i > 0) {
            return i;
        }
        if (i != 0) {
            return i + 1;
        }
        throw new IllegalFieldValueException(DateTimeFieldType.year(), (Number) Integer.valueOf(i), (Number) null, (Number) null);
    }

    public static JulianChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static JulianChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        int minimumDaysInFirstWeek = getMinimumDaysInFirstWeek();
        if (minimumDaysInFirstWeek == 0) {
            minimumDaysInFirstWeek = 4;
        }
        return getInstance(base == null ? DateTimeZone.UTC : base.getZone(), minimumDaysInFirstWeek);
    }

    public void assemble(AssembledChronology.Fields fields) {
        if (getBase() == null) {
            super.assemble(fields);
            fields.year = new SkipDateTimeField(this, fields.year);
            fields.weekyear = new SkipDateTimeField(this, fields.weekyear);
        }
    }

    public long calculateFirstDayOfYearMillis(int i) {
        int i2;
        int i3 = i - 1968;
        if (i3 <= 0) {
            i2 = (i - 1965) >> 2;
        } else {
            int i4 = i3 >> 2;
            i2 = !isLeapYear(i) ? i4 + 1 : i4;
        }
        return (((i3 * 365) + i2) * 86400000) - 62035200000L;
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 31083663600000L;
    }

    public long getAverageMillisPerMonth() {
        return 2629800000L;
    }

    public long getAverageMillisPerYear() {
        return 31557600000L;
    }

    public long getAverageMillisPerYearDividedByTwo() {
        return 15778800000L;
    }

    public long getDateMidnightMillis(int i, int i2, int i3) throws IllegalArgumentException {
        return super.getDateMidnightMillis(adjustYearForSet(i), i2, i3);
    }

    public int getMaxYear() {
        return 292272992;
    }

    public int getMinYear() {
        return -292269054;
    }

    public boolean isLeapYear(int i) {
        return (i & 3) == 0;
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

    public static JulianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    public static JulianChronology getInstance(DateTimeZone dateTimeZone, int i) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        JulianChronology[] julianChronologyArr = (JulianChronology[]) concurrentHashMap.get(dateTimeZone);
        if (julianChronologyArr == null) {
            julianChronologyArr = new JulianChronology[7];
            JulianChronology[] julianChronologyArr2 = (JulianChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, julianChronologyArr);
            if (julianChronologyArr2 != null) {
                julianChronologyArr = julianChronologyArr2;
            }
        }
        int i2 = i - 1;
        try {
            JulianChronology julianChronology = julianChronologyArr[i2];
            if (julianChronology == null) {
                synchronized (julianChronologyArr) {
                    try {
                        julianChronology = julianChronologyArr[i2];
                        if (julianChronology == null) {
                            DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                            JulianChronology julianChronology2 = dateTimeZone == dateTimeZone2 ? new JulianChronology(null, null, i) : new JulianChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, i), dateTimeZone), null, i);
                            julianChronologyArr[i2] = julianChronology2;
                            julianChronology = julianChronology2;
                        }
                    } finally {
                    }
                }
            }
            return julianChronology;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }
}
