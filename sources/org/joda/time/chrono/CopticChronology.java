package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CopticChronology extends BasicFixedMonthChronology {
    public static final int AM = 1;
    private static final int MAX_YEAR = 292272708;
    private static final int MIN_YEAR = -292269337;
    private static final long serialVersionUID = -5972804258688333942L;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("AM");
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final CopticChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    public CopticChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    public static CopticChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static CopticChronology getInstanceUTC() {
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
            fields.era = ERA_FIELD;
            BasicMonthOfYearDateTimeField basicMonthOfYearDateTimeField = new BasicMonthOfYearDateTimeField(this, 13);
            fields.monthOfYear = basicMonthOfYearDateTimeField;
            fields.months = basicMonthOfYearDateTimeField.getDurationField();
        }
    }

    public long calculateFirstDayOfYearMillis(int i) {
        int i2;
        int i3 = i - 1687;
        if (i3 <= 0) {
            i2 = (i - 1684) >> 2;
        } else {
            int i4 = i3 >> 2;
            i2 = !isLeapYear(i) ? i4 + 1 : i4;
        }
        return (((i3 * 365) + i2) * 86400000) + 21859200000L;
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 26607895200000L;
    }

    public int getMaxYear() {
        return 292272708;
    }

    public int getMinYear() {
        return -292269337;
    }

    public boolean isLeapDay(long j) {
        return dayOfMonth().get(j) == 6 && monthOfYear().isLeap(j);
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

    public static CopticChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    public static CopticChronology getInstance(DateTimeZone dateTimeZone, int i) {
        CopticChronology copticChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        CopticChronology[] copticChronologyArr = (CopticChronology[]) concurrentHashMap.get(dateTimeZone);
        if (copticChronologyArr == null) {
            copticChronologyArr = new CopticChronology[7];
            CopticChronology[] copticChronologyArr2 = (CopticChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, copticChronologyArr);
            if (copticChronologyArr2 != null) {
                copticChronologyArr = copticChronologyArr2;
            }
        }
        int i2 = i - 1;
        try {
            CopticChronology copticChronology2 = copticChronologyArr[i2];
            if (copticChronology2 == null) {
                synchronized (copticChronologyArr) {
                    try {
                        copticChronology2 = copticChronologyArr[i2];
                        if (copticChronology2 == null) {
                            DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                            if (dateTimeZone == dateTimeZone2) {
                                CopticChronology copticChronology3 = new CopticChronology(null, null, i);
                                copticChronology = new CopticChronology(LimitChronology.getInstance(copticChronology3, new DateTime(1, 1, 1, 0, 0, 0, 0, copticChronology3), null), null, i);
                            } else {
                                copticChronology = new CopticChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, i), dateTimeZone), null, i);
                            }
                            copticChronologyArr[i2] = copticChronology;
                            copticChronology2 = copticChronology;
                        }
                    } finally {
                    }
                }
            }
            return copticChronology2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }
}
