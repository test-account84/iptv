package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.PreciseDateTimeField;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.ZeroIsMaxDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class BasicChronology extends AssembledChronology {
    private static final int CACHE_MASK = 1023;
    private static final int CACHE_SIZE = 1024;
    private static final DateTimeField cClockhourOfDayField;
    private static final DateTimeField cClockhourOfHalfdayField;
    private static final DurationField cDaysField;
    private static final DateTimeField cHalfdayOfDayField;
    private static final DurationField cHalfdaysField;
    private static final DateTimeField cHourOfDayField;
    private static final DateTimeField cHourOfHalfdayField;
    private static final DurationField cHoursField;
    private static final DurationField cMillisField;
    private static final DateTimeField cMillisOfDayField;
    private static final DateTimeField cMillisOfSecondField;
    private static final DateTimeField cMinuteOfDayField;
    private static final DateTimeField cMinuteOfHourField;
    private static final DurationField cMinutesField;
    private static final DateTimeField cSecondOfDayField;
    private static final DateTimeField cSecondOfMinuteField;
    private static final DurationField cSecondsField;
    private static final DurationField cWeeksField;
    private static final long serialVersionUID = 8283225332206808863L;
    private final int iMinDaysInFirstWeek;
    private final transient YearInfo[] iYearInfoCache;

    public static class HalfdayField extends PreciseDateTimeField {
        private static final long serialVersionUID = 581601443656929254L;

        public HalfdayField() {
            super(DateTimeFieldType.halfdayOfDay(), BasicChronology.access$000(), BasicChronology.access$100());
        }

        public String getAsText(int i, Locale locale) {
            return GJLocaleSymbols.forLocale(locale).halfdayValueToText(i);
        }

        public int getMaximumTextLength(Locale locale) {
            return GJLocaleSymbols.forLocale(locale).getHalfdayMaxTextLength();
        }

        public long set(long j, String str, Locale locale) {
            return set(j, GJLocaleSymbols.forLocale(locale).halfdayTextToValue(str));
        }
    }

    public static class YearInfo {
        public final long iFirstDayMillis;
        public final int iYear;

        public YearInfo(int i, long j) {
            this.iYear = i;
            this.iFirstDayMillis = j;
        }
    }

    static {
        DurationField durationField = MillisDurationField.INSTANCE;
        cMillisField = durationField;
        PreciseDurationField preciseDurationField = new PreciseDurationField(DurationFieldType.seconds(), 1000L);
        cSecondsField = preciseDurationField;
        PreciseDurationField preciseDurationField2 = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        cMinutesField = preciseDurationField2;
        PreciseDurationField preciseDurationField3 = new PreciseDurationField(DurationFieldType.hours(), 3600000L);
        cHoursField = preciseDurationField3;
        PreciseDurationField preciseDurationField4 = new PreciseDurationField(DurationFieldType.halfdays(), 43200000L);
        cHalfdaysField = preciseDurationField4;
        PreciseDurationField preciseDurationField5 = new PreciseDurationField(DurationFieldType.days(), 86400000L);
        cDaysField = preciseDurationField5;
        cWeeksField = new PreciseDurationField(DurationFieldType.weeks(), 604800000L);
        cMillisOfSecondField = new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), durationField, preciseDurationField);
        cMillisOfDayField = new PreciseDateTimeField(DateTimeFieldType.millisOfDay(), durationField, preciseDurationField5);
        cSecondOfMinuteField = new PreciseDateTimeField(DateTimeFieldType.secondOfMinute(), preciseDurationField, preciseDurationField2);
        cSecondOfDayField = new PreciseDateTimeField(DateTimeFieldType.secondOfDay(), preciseDurationField, preciseDurationField5);
        cMinuteOfHourField = new PreciseDateTimeField(DateTimeFieldType.minuteOfHour(), preciseDurationField2, preciseDurationField3);
        cMinuteOfDayField = new PreciseDateTimeField(DateTimeFieldType.minuteOfDay(), preciseDurationField2, preciseDurationField5);
        PreciseDateTimeField preciseDateTimeField = new PreciseDateTimeField(DateTimeFieldType.hourOfDay(), preciseDurationField3, preciseDurationField5);
        cHourOfDayField = preciseDateTimeField;
        PreciseDateTimeField preciseDateTimeField2 = new PreciseDateTimeField(DateTimeFieldType.hourOfHalfday(), preciseDurationField3, preciseDurationField4);
        cHourOfHalfdayField = preciseDateTimeField2;
        cClockhourOfDayField = new ZeroIsMaxDateTimeField(preciseDateTimeField, DateTimeFieldType.clockhourOfDay());
        cClockhourOfHalfdayField = new ZeroIsMaxDateTimeField(preciseDateTimeField2, DateTimeFieldType.clockhourOfHalfday());
        cHalfdayOfDayField = new HalfdayField();
    }

    public BasicChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj);
        this.iYearInfoCache = new YearInfo[1024];
        if (i >= 1 && i <= 7) {
            this.iMinDaysInFirstWeek = i;
            return;
        }
        throw new IllegalArgumentException("Invalid min days in first week: " + i);
    }

    public static /* synthetic */ DurationField access$000() {
        return cHalfdaysField;
    }

    public static /* synthetic */ DurationField access$100() {
        return cDaysField;
    }

    private YearInfo getYearInfo(int i) {
        int i2 = i & 1023;
        YearInfo yearInfo = this.iYearInfoCache[i2];
        if (yearInfo != null && yearInfo.iYear == i) {
            return yearInfo;
        }
        YearInfo yearInfo2 = new YearInfo(i, calculateFirstDayOfYearMillis(i));
        this.iYearInfoCache[i2] = yearInfo2;
        return yearInfo2;
    }

    public void assemble(AssembledChronology.Fields fields) {
        fields.millis = cMillisField;
        fields.seconds = cSecondsField;
        fields.minutes = cMinutesField;
        fields.hours = cHoursField;
        fields.halfdays = cHalfdaysField;
        fields.days = cDaysField;
        fields.weeks = cWeeksField;
        fields.millisOfSecond = cMillisOfSecondField;
        fields.millisOfDay = cMillisOfDayField;
        fields.secondOfMinute = cSecondOfMinuteField;
        fields.secondOfDay = cSecondOfDayField;
        fields.minuteOfHour = cMinuteOfHourField;
        fields.minuteOfDay = cMinuteOfDayField;
        fields.hourOfDay = cHourOfDayField;
        fields.hourOfHalfday = cHourOfHalfdayField;
        fields.clockhourOfDay = cClockhourOfDayField;
        fields.clockhourOfHalfday = cClockhourOfHalfdayField;
        fields.halfdayOfDay = cHalfdayOfDayField;
        BasicYearDateTimeField basicYearDateTimeField = new BasicYearDateTimeField(this);
        fields.year = basicYearDateTimeField;
        GJYearOfEraDateTimeField gJYearOfEraDateTimeField = new GJYearOfEraDateTimeField(basicYearDateTimeField, this);
        fields.yearOfEra = gJYearOfEraDateTimeField;
        DividedDateTimeField dividedDateTimeField = new DividedDateTimeField(new OffsetDateTimeField(gJYearOfEraDateTimeField, 99), DateTimeFieldType.centuryOfEra(), 100);
        fields.centuryOfEra = dividedDateTimeField;
        fields.centuries = dividedDateTimeField.getDurationField();
        fields.yearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra), DateTimeFieldType.yearOfCentury(), 1);
        fields.era = new GJEraDateTimeField(this);
        fields.dayOfWeek = new GJDayOfWeekDateTimeField(this, fields.days);
        fields.dayOfMonth = new BasicDayOfMonthDateTimeField(this, fields.days);
        fields.dayOfYear = new BasicDayOfYearDateTimeField(this, fields.days);
        fields.monthOfYear = new GJMonthOfYearDateTimeField(this);
        fields.weekyear = new BasicWeekyearDateTimeField(this);
        fields.weekOfWeekyear = new BasicWeekOfWeekyearDateTimeField(this, fields.weeks);
        fields.weekyearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField(fields.weekyear, fields.centuries, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
        fields.years = fields.year.getDurationField();
        fields.months = fields.monthOfYear.getDurationField();
        fields.weekyears = fields.weekyear.getDurationField();
    }

    public abstract long calculateFirstDayOfYearMillis(int i);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicChronology basicChronology = (BasicChronology) obj;
        return getMinimumDaysInFirstWeek() == basicChronology.getMinimumDaysInFirstWeek() && getZone().equals(basicChronology.getZone());
    }

    public abstract long getApproxMillisAtEpochDividedByTwo();

    public abstract long getAverageMillisPerMonth();

    public abstract long getAverageMillisPerYear();

    public abstract long getAverageMillisPerYearDividedByTwo();

    public long getDateMidnightMillis(int i, int i2, int i3) {
        FieldUtils.verifyValueBounds(DateTimeFieldType.year(), i, getMinYear(), getMaxYear());
        FieldUtils.verifyValueBounds(DateTimeFieldType.monthOfYear(), i2, 1, getMaxMonth(i));
        FieldUtils.verifyValueBounds(DateTimeFieldType.dayOfMonth(), i3, 1, getDaysInYearMonth(i, i2));
        return getYearMonthDayMillis(i, i2, i3);
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i, i2, i3, i4);
        }
        FieldUtils.verifyValueBounds(DateTimeFieldType.millisOfDay(), i4, 0, 86399999);
        return getDateMidnightMillis(i, i2, i3) + i4;
    }

    public int getDayOfMonth(long j) {
        int year = getYear(j);
        return getDayOfMonth(j, year, getMonthOfYear(j, year));
    }

    public int getDayOfWeek(long j) {
        long j2;
        if (j >= 0) {
            j2 = j / 86400000;
        } else {
            j2 = (j - 86399999) / 86400000;
            if (j2 < -3) {
                return ((int) ((j2 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j2 + 3) % 7)) + 1;
    }

    public int getDayOfYear(long j) {
        return getDayOfYear(j, getYear(j));
    }

    public int getDaysInMonthMax() {
        return 31;
    }

    public abstract int getDaysInMonthMax(int i);

    public int getDaysInMonthMaxForSet(long j, int i) {
        return getDaysInMonthMax(j);
    }

    public int getDaysInYear(int i) {
        return isLeapYear(i) ? 366 : 365;
    }

    public int getDaysInYearMax() {
        return 366;
    }

    public abstract int getDaysInYearMonth(int i, int i2);

    public long getFirstWeekOfYearMillis(int i) {
        long yearMillis = getYearMillis(i);
        return getDayOfWeek(yearMillis) > 8 - this.iMinDaysInFirstWeek ? yearMillis + ((8 - r8) * 86400000) : yearMillis - ((r8 - 1) * 86400000);
    }

    public int getMaxMonth() {
        return 12;
    }

    public abstract int getMaxYear();

    public int getMillisOfDay(long j) {
        return j >= 0 ? (int) (j % 86400000) : ((int) ((j + 1) % 86400000)) + 86399999;
    }

    public abstract int getMinYear();

    public int getMinimumDaysInFirstWeek() {
        return this.iMinDaysInFirstWeek;
    }

    public int getMonthOfYear(long j) {
        return getMonthOfYear(j, getYear(j));
    }

    public abstract int getMonthOfYear(long j, int i);

    public abstract long getTotalMillisByYearMonth(int i, int i2);

    public int getWeekOfWeekyear(long j) {
        return getWeekOfWeekyear(j, getYear(j));
    }

    public int getWeeksInYear(int i) {
        return (int) ((getFirstWeekOfYearMillis(i + 1) - getFirstWeekOfYearMillis(i)) / 604800000);
    }

    public int getWeekyear(long j) {
        long j2;
        int year = getYear(j);
        int weekOfWeekyear = getWeekOfWeekyear(j, year);
        if (weekOfWeekyear == 1) {
            j2 = j + 604800000;
        } else {
            if (weekOfWeekyear <= 51) {
                return year;
            }
            j2 = j - 1209600000;
        }
        return getYear(j2);
    }

    public int getYear(long j) {
        long averageMillisPerYearDividedByTwo = getAverageMillisPerYearDividedByTwo();
        long approxMillisAtEpochDividedByTwo = (j >> 1) + getApproxMillisAtEpochDividedByTwo();
        if (approxMillisAtEpochDividedByTwo < 0) {
            approxMillisAtEpochDividedByTwo = (approxMillisAtEpochDividedByTwo - averageMillisPerYearDividedByTwo) + 1;
        }
        int i = (int) (approxMillisAtEpochDividedByTwo / averageMillisPerYearDividedByTwo);
        long yearMillis = getYearMillis(i);
        long j2 = j - yearMillis;
        if (j2 < 0) {
            return i - 1;
        }
        if (j2 >= 31536000000L) {
            return yearMillis + (isLeapYear(i) ? 31622400000L : 31536000000L) <= j ? i + 1 : i;
        }
        return i;
    }

    public abstract long getYearDifference(long j, long j2);

    public long getYearMillis(int i) {
        return getYearInfo(i).iFirstDayMillis;
    }

    public long getYearMonthDayMillis(int i, int i2, int i3) {
        return getYearMillis(i) + getTotalMillisByYearMonth(i, i2) + ((i3 - 1) * 86400000);
    }

    public long getYearMonthMillis(int i, int i2) {
        return getYearMillis(i) + getTotalMillisByYearMonth(i, i2);
    }

    public DateTimeZone getZone() {
        Chronology base = getBase();
        return base != null ? base.getZone() : DateTimeZone.UTC;
    }

    public int hashCode() {
        return (getClass().getName().hashCode() * 11) + getZone().hashCode() + getMinimumDaysInFirstWeek();
    }

    public boolean isLeapDay(long j) {
        return false;
    }

    public abstract boolean isLeapYear(int i);

    public abstract long setYear(long j, int i);

    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb.append(name);
        sb.append('[');
        DateTimeZone zone = getZone();
        if (zone != null) {
            sb.append(zone.getID());
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            sb.append(",mdfw=");
            sb.append(getMinimumDaysInFirstWeek());
        }
        sb.append(']');
        return sb.toString();
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
        }
        FieldUtils.verifyValueBounds(DateTimeFieldType.hourOfDay(), i4, 0, 23);
        FieldUtils.verifyValueBounds(DateTimeFieldType.minuteOfHour(), i5, 0, 59);
        FieldUtils.verifyValueBounds(DateTimeFieldType.secondOfMinute(), i6, 0, 59);
        FieldUtils.verifyValueBounds(DateTimeFieldType.millisOfSecond(), i7, 0, 999);
        return getDateMidnightMillis(i, i2, i3) + (i4 * 3600000) + (i5 * 60000) + (i6 * 1000) + i7;
    }

    public int getDayOfMonth(long j, int i) {
        return getDayOfMonth(j, i, getMonthOfYear(j, i));
    }

    public int getDayOfYear(long j, int i) {
        return ((int) ((j - getYearMillis(i)) / 86400000)) + 1;
    }

    public int getDaysInMonthMax(long j) {
        int year = getYear(j);
        return getDaysInYearMonth(year, getMonthOfYear(j, year));
    }

    public int getMaxMonth(int i) {
        return getMaxMonth();
    }

    public int getWeekOfWeekyear(long j, int i) {
        long firstWeekOfYearMillis = getFirstWeekOfYearMillis(i);
        if (j < firstWeekOfYearMillis) {
            return getWeeksInYear(i - 1);
        }
        if (j >= getFirstWeekOfYearMillis(i + 1)) {
            return 1;
        }
        return ((int) ((j - firstWeekOfYearMillis) / 604800000)) + 1;
    }

    public int getDayOfMonth(long j, int i, int i2) {
        return ((int) ((j - (getYearMillis(i) + getTotalMillisByYearMonth(i, i2))) / 86400000)) + 1;
    }
}
