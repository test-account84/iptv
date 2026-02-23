package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Days extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380865L;
    public static final Days ZERO = new Days(0);
    public static final Days ONE = new Days(1);
    public static final Days TWO = new Days(2);
    public static final Days THREE = new Days(3);
    public static final Days FOUR = new Days(4);
    public static final Days FIVE = new Days(5);
    public static final Days SIX = new Days(6);
    public static final Days SEVEN = new Days(7);
    public static final Days MAX_VALUE = new Days(Integer.MAX_VALUE);
    public static final Days MIN_VALUE = new Days(Integer.MIN_VALUE);
    private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.days());

    private Days(int i) {
        super(i);
    }

    public static Days days(int i) {
        if (i == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i == Integer.MAX_VALUE) {
            return MAX_VALUE;
        }
        switch (i) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            default:
                return new Days(i);
        }
    }

    public static Days daysBetween(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        return days(BaseSingleFieldPeriod.between(readableInstant, readableInstant2, DurationFieldType.days()));
    }

    public static Days daysIn(ReadableInterval readableInterval) {
        return readableInterval == null ? ZERO : days(BaseSingleFieldPeriod.between(readableInterval.getStart(), readableInterval.getEnd(), DurationFieldType.days()));
    }

    @FromString
    public static Days parseDays(String str) {
        return str == null ? ZERO : days(PARSER.parsePeriod(str).getDays());
    }

    private Object readResolve() {
        return days(getValue());
    }

    public static Days standardDaysIn(ReadablePeriod readablePeriod) {
        return days(BaseSingleFieldPeriod.standardPeriodIn(readablePeriod, 86400000L));
    }

    public Days dividedBy(int i) {
        return i == 1 ? this : days(getValue() / i);
    }

    public int getDays() {
        return getValue();
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.days();
    }

    public PeriodType getPeriodType() {
        return PeriodType.days();
    }

    public boolean isGreaterThan(Days days) {
        return days == null ? getValue() > 0 : getValue() > days.getValue();
    }

    public boolean isLessThan(Days days) {
        return days == null ? getValue() < 0 : getValue() < days.getValue();
    }

    public Days minus(int i) {
        return plus(FieldUtils.safeNegate(i));
    }

    public Days multipliedBy(int i) {
        return days(FieldUtils.safeMultiply(getValue(), i));
    }

    public Days negated() {
        return days(FieldUtils.safeNegate(getValue()));
    }

    public Days plus(int i) {
        return i == 0 ? this : days(FieldUtils.safeAdd(getValue(), i));
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 86400000);
    }

    public Hours toStandardHours() {
        return Hours.hours(FieldUtils.safeMultiply(getValue(), 24));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(FieldUtils.safeMultiply(getValue(), 1440));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 86400));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 7);
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "D";
    }

    public static Days daysBetween(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        return days(((readablePartial instanceof LocalDate) && (readablePartial2 instanceof LocalDate)) ? DateTimeUtils.getChronology(readablePartial.getChronology()).days().getDifference(((LocalDate) readablePartial2).getLocalMillis(), ((LocalDate) readablePartial).getLocalMillis()) : BaseSingleFieldPeriod.between(readablePartial, readablePartial2, ZERO));
    }

    public Days minus(Days days) {
        return days == null ? this : minus(days.getValue());
    }

    public Days plus(Days days) {
        return days == null ? this : plus(days.getValue());
    }
}
