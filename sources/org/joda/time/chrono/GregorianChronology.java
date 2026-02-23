package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class GregorianChronology extends BasicGJChronology {
    private static final int DAYS_0000_TO_1970 = 719527;
    private static final int MAX_YEAR = 292278993;
    private static final long MILLIS_PER_MONTH = 2629746000L;
    private static final long MILLIS_PER_YEAR = 31556952000L;
    private static final int MIN_YEAR = -292275054;
    private static final long serialVersionUID = -861407383323710522L;
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final GregorianChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    private GregorianChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    public static GregorianChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static GregorianChronology getInstanceUTC() {
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
        }
    }

    public long calculateFirstDayOfYearMillis(int i) {
        int i2;
        int i3 = i / 100;
        if (i < 0) {
            i2 = ((((i + 3) >> 2) - i3) + ((i3 + 3) >> 2)) - 1;
        } else {
            i2 = ((i >> 2) - i3) + (i3 >> 2);
            if (isLeapYear(i)) {
                i2--;
            }
        }
        return ((i * 365) + (i2 - 719527)) * 86400000;
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 31083597720000L;
    }

    public long getAverageMillisPerMonth() {
        return 2629746000L;
    }

    public long getAverageMillisPerYear() {
        return 31556952000L;
    }

    public long getAverageMillisPerYearDividedByTwo() {
        return 15778476000L;
    }

    public int getMaxYear() {
        return 292278993;
    }

    public int getMinYear() {
        return -292275054;
    }

    public boolean isLeapYear(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
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

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone, int i) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        GregorianChronology[] gregorianChronologyArr = (GregorianChronology[]) concurrentHashMap.get(dateTimeZone);
        if (gregorianChronologyArr == null) {
            gregorianChronologyArr = new GregorianChronology[7];
            GregorianChronology[] gregorianChronologyArr2 = (GregorianChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, gregorianChronologyArr);
            if (gregorianChronologyArr2 != null) {
                gregorianChronologyArr = gregorianChronologyArr2;
            }
        }
        int i2 = i - 1;
        try {
            GregorianChronology gregorianChronology = gregorianChronologyArr[i2];
            if (gregorianChronology == null) {
                synchronized (gregorianChronologyArr) {
                    try {
                        gregorianChronology = gregorianChronologyArr[i2];
                        if (gregorianChronology == null) {
                            DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                            GregorianChronology gregorianChronology2 = dateTimeZone == dateTimeZone2 ? new GregorianChronology(null, null, i) : new GregorianChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, i), dateTimeZone), null, i);
                            gregorianChronologyArr[i2] = gregorianChronology2;
                            gregorianChronology = gregorianChronology2;
                        }
                    } finally {
                    }
                }
            }
            return gregorianChronology;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }
}
