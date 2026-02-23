package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Years extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380868L;
    public static final Years ZERO = new Years(0);
    public static final Years ONE = new Years(1);
    public static final Years TWO = new Years(2);
    public static final Years THREE = new Years(3);
    public static final Years MAX_VALUE = new Years(Integer.MAX_VALUE);
    public static final Years MIN_VALUE = new Years(Integer.MIN_VALUE);
    private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.years());

    private Years(int i) {
        super(i);
    }

    @FromString
    public static Years parseYears(String str) {
        return str == null ? ZERO : years(PARSER.parsePeriod(str).getYears());
    }

    private Object readResolve() {
        return years(getValue());
    }

    public static Years years(int i) {
        return i != Integer.MIN_VALUE ? i != Integer.MAX_VALUE ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? new Years(i) : THREE : TWO : ONE : ZERO : MAX_VALUE : MIN_VALUE;
    }

    public static Years yearsBetween(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        return years(BaseSingleFieldPeriod.between(readableInstant, readableInstant2, DurationFieldType.years()));
    }

    public static Years yearsIn(ReadableInterval readableInterval) {
        return readableInterval == null ? ZERO : years(BaseSingleFieldPeriod.between(readableInterval.getStart(), readableInterval.getEnd(), DurationFieldType.years()));
    }

    public Years dividedBy(int i) {
        return i == 1 ? this : years(getValue() / i);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.years();
    }

    public PeriodType getPeriodType() {
        return PeriodType.years();
    }

    public int getYears() {
        return getValue();
    }

    public boolean isGreaterThan(Years years) {
        return years == null ? getValue() > 0 : getValue() > years.getValue();
    }

    public boolean isLessThan(Years years) {
        return years == null ? getValue() < 0 : getValue() < years.getValue();
    }

    public Years minus(int i) {
        return plus(FieldUtils.safeNegate(i));
    }

    public Years multipliedBy(int i) {
        return years(FieldUtils.safeMultiply(getValue(), i));
    }

    public Years negated() {
        return years(FieldUtils.safeNegate(getValue()));
    }

    public Years plus(int i) {
        return i == 0 ? this : years(FieldUtils.safeAdd(getValue(), i));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "Y";
    }

    public static Years yearsBetween(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        return years(((readablePartial instanceof LocalDate) && (readablePartial2 instanceof LocalDate)) ? DateTimeUtils.getChronology(readablePartial.getChronology()).years().getDifference(((LocalDate) readablePartial2).getLocalMillis(), ((LocalDate) readablePartial).getLocalMillis()) : BaseSingleFieldPeriod.between(readablePartial, readablePartial2, ZERO));
    }

    public Years minus(Years years) {
        return years == null ? this : minus(years.getValue());
    }

    public Years plus(Years years) {
        return years == null ? this : plus(years.getValue());
    }
}
