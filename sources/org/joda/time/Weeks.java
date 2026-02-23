package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Weeks extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380866L;
    public static final Weeks ZERO = new Weeks(0);
    public static final Weeks ONE = new Weeks(1);
    public static final Weeks TWO = new Weeks(2);
    public static final Weeks THREE = new Weeks(3);
    public static final Weeks MAX_VALUE = new Weeks(Integer.MAX_VALUE);
    public static final Weeks MIN_VALUE = new Weeks(Integer.MIN_VALUE);
    private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.weeks());

    private Weeks(int i) {
        super(i);
    }

    @FromString
    public static Weeks parseWeeks(String str) {
        return str == null ? ZERO : weeks(PARSER.parsePeriod(str).getWeeks());
    }

    private Object readResolve() {
        return weeks(getValue());
    }

    public static Weeks standardWeeksIn(ReadablePeriod readablePeriod) {
        return weeks(BaseSingleFieldPeriod.standardPeriodIn(readablePeriod, 604800000L));
    }

    public static Weeks weeks(int i) {
        return i != Integer.MIN_VALUE ? i != Integer.MAX_VALUE ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? new Weeks(i) : THREE : TWO : ONE : ZERO : MAX_VALUE : MIN_VALUE;
    }

    public static Weeks weeksBetween(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        return weeks(BaseSingleFieldPeriod.between(readableInstant, readableInstant2, DurationFieldType.weeks()));
    }

    public static Weeks weeksIn(ReadableInterval readableInterval) {
        return readableInterval == null ? ZERO : weeks(BaseSingleFieldPeriod.between(readableInterval.getStart(), readableInterval.getEnd(), DurationFieldType.weeks()));
    }

    public Weeks dividedBy(int i) {
        return i == 1 ? this : weeks(getValue() / i);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.weeks();
    }

    public PeriodType getPeriodType() {
        return PeriodType.weeks();
    }

    public int getWeeks() {
        return getValue();
    }

    public boolean isGreaterThan(Weeks weeks) {
        return weeks == null ? getValue() > 0 : getValue() > weeks.getValue();
    }

    public boolean isLessThan(Weeks weeks) {
        return weeks == null ? getValue() < 0 : getValue() < weeks.getValue();
    }

    public Weeks minus(int i) {
        return plus(FieldUtils.safeNegate(i));
    }

    public Weeks multipliedBy(int i) {
        return weeks(FieldUtils.safeMultiply(getValue(), i));
    }

    public Weeks negated() {
        return weeks(FieldUtils.safeNegate(getValue()));
    }

    public Weeks plus(int i) {
        return i == 0 ? this : weeks(FieldUtils.safeAdd(getValue(), i));
    }

    public Days toStandardDays() {
        return Days.days(FieldUtils.safeMultiply(getValue(), 7));
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 604800000);
    }

    public Hours toStandardHours() {
        return Hours.hours(FieldUtils.safeMultiply(getValue(), 168));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(FieldUtils.safeMultiply(getValue(), 10080));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 604800));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "W";
    }

    public static Weeks weeksBetween(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        return weeks(((readablePartial instanceof LocalDate) && (readablePartial2 instanceof LocalDate)) ? DateTimeUtils.getChronology(readablePartial.getChronology()).weeks().getDifference(((LocalDate) readablePartial2).getLocalMillis(), ((LocalDate) readablePartial).getLocalMillis()) : BaseSingleFieldPeriod.between(readablePartial, readablePartial2, ZERO));
    }

    public Weeks minus(Weeks weeks) {
        return weeks == null ? this : minus(weeks.getValue());
    }

    public Weeks plus(Weeks weeks) {
        return weeks == null ? this : plus(weeks.getValue());
    }
}
