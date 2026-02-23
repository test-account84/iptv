package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class EthiopicChronology extends BasicFixedMonthChronology {
    public static final int EE = 1;
    private static final int MAX_YEAR = 292272984;
    private static final int MIN_YEAR = -292269337;
    private static final long serialVersionUID = -5972804258688333942L;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("EE");
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final EthiopicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    public EthiopicChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    public static EthiopicChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static EthiopicChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return getInstance(base == null ? DateTimeZone.UTC : base.getZone(), getMinimumDaysInFirstWeek());
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
        int i3 = i - 1963;
        if (i3 <= 0) {
            i2 = (i - 1960) >> 2;
        } else {
            int i4 = i3 >> 2;
            i2 = !isLeapYear(i) ? i4 + 1 : i4;
        }
        return (((i3 * 365) + i2) * 86400000) + 21859200000L;
    }

    public long getApproxMillisAtEpochDividedByTwo() {
        return 30962844000000L;
    }

    public int getMaxYear() {
        return 292272984;
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

    public static EthiopicChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    public static EthiopicChronology getInstance(DateTimeZone dateTimeZone, int i) {
        EthiopicChronology ethiopicChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        EthiopicChronology[] ethiopicChronologyArr = (EthiopicChronology[]) concurrentHashMap.get(dateTimeZone);
        if (ethiopicChronologyArr == null) {
            ethiopicChronologyArr = new EthiopicChronology[7];
            EthiopicChronology[] ethiopicChronologyArr2 = (EthiopicChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, ethiopicChronologyArr);
            if (ethiopicChronologyArr2 != null) {
                ethiopicChronologyArr = ethiopicChronologyArr2;
            }
        }
        int i2 = i - 1;
        try {
            EthiopicChronology ethiopicChronology2 = ethiopicChronologyArr[i2];
            if (ethiopicChronology2 == null) {
                synchronized (ethiopicChronologyArr) {
                    try {
                        ethiopicChronology2 = ethiopicChronologyArr[i2];
                        if (ethiopicChronology2 == null) {
                            DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                            if (dateTimeZone == dateTimeZone2) {
                                EthiopicChronology ethiopicChronology3 = new EthiopicChronology(null, null, i);
                                ethiopicChronology = new EthiopicChronology(LimitChronology.getInstance(ethiopicChronology3, new DateTime(1, 1, 1, 0, 0, 0, 0, ethiopicChronology3), null), null, i);
                            } else {
                                ethiopicChronology = new EthiopicChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, i), dateTimeZone), null, i);
                            }
                            ethiopicChronologyArr[i2] = ethiopicChronology;
                            ethiopicChronology2 = ethiopicChronology;
                        }
                    } finally {
                    }
                }
            }
            return ethiopicChronology2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }
}
