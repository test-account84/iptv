package org.joda.time.base;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.MutableInterval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadableInterval;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class AbstractInterval implements ReadableInterval {
    public void checkInterval(long j, long j2) {
        if (j2 < j) {
            throw new IllegalArgumentException("The end instant must be greater or equal to the start");
        }
    }

    public boolean contains(long j) {
        return j >= getStartMillis() && j < getEndMillis();
    }

    public boolean containsNow() {
        return contains(DateTimeUtils.currentTimeMillis());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadableInterval)) {
            return false;
        }
        ReadableInterval readableInterval = (ReadableInterval) obj;
        return getStartMillis() == readableInterval.getStartMillis() && getEndMillis() == readableInterval.getEndMillis() && FieldUtils.equals(getChronology(), readableInterval.getChronology());
    }

    public DateTime getEnd() {
        return new DateTime(getEndMillis(), getChronology());
    }

    public DateTime getStart() {
        return new DateTime(getStartMillis(), getChronology());
    }

    public int hashCode() {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        return ((((3007 + ((int) (startMillis ^ (startMillis >>> 32)))) * 31) + ((int) (endMillis ^ (endMillis >>> 32)))) * 31) + getChronology().hashCode();
    }

    public boolean isAfter(long j) {
        return getStartMillis() > j;
    }

    public boolean isAfterNow() {
        return isAfter(DateTimeUtils.currentTimeMillis());
    }

    public boolean isBefore(long j) {
        return getEndMillis() <= j;
    }

    public boolean isBeforeNow() {
        return isBefore(DateTimeUtils.currentTimeMillis());
    }

    public boolean isEqual(ReadableInterval readableInterval) {
        return getStartMillis() == readableInterval.getStartMillis() && getEndMillis() == readableInterval.getEndMillis();
    }

    public boolean overlaps(ReadableInterval readableInterval) {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        if (readableInterval != null) {
            return startMillis < readableInterval.getEndMillis() && readableInterval.getStartMillis() < endMillis;
        }
        long currentTimeMillis = DateTimeUtils.currentTimeMillis();
        return startMillis < currentTimeMillis && currentTimeMillis < endMillis;
    }

    public Duration toDuration() {
        long durationMillis = toDurationMillis();
        return durationMillis == 0 ? Duration.ZERO : new Duration(durationMillis);
    }

    public long toDurationMillis() {
        return FieldUtils.safeAdd(getEndMillis(), -getStartMillis());
    }

    public Interval toInterval() {
        return new Interval(getStartMillis(), getEndMillis(), getChronology());
    }

    public MutableInterval toMutableInterval() {
        return new MutableInterval(getStartMillis(), getEndMillis(), getChronology());
    }

    public Period toPeriod() {
        return new Period(getStartMillis(), getEndMillis(), getChronology());
    }

    public String toString() {
        DateTimeFormatter withChronology = ISODateTimeFormat.dateTime().withChronology(getChronology());
        StringBuffer stringBuffer = new StringBuffer(48);
        withChronology.printTo(stringBuffer, getStartMillis());
        stringBuffer.append('/');
        withChronology.printTo(stringBuffer, getEndMillis());
        return stringBuffer.toString();
    }

    public boolean contains(ReadableInstant readableInstant) {
        return readableInstant == null ? containsNow() : contains(readableInstant.getMillis());
    }

    public boolean isAfter(ReadableInstant readableInstant) {
        return readableInstant == null ? isAfterNow() : isAfter(readableInstant.getMillis());
    }

    public boolean isBefore(ReadableInstant readableInstant) {
        return readableInstant == null ? isBeforeNow() : isBefore(readableInstant.getMillis());
    }

    public Period toPeriod(PeriodType periodType) {
        return new Period(getStartMillis(), getEndMillis(), periodType, getChronology());
    }

    public boolean contains(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return containsNow();
        }
        long startMillis = readableInterval.getStartMillis();
        long endMillis = readableInterval.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        return startMillis2 <= startMillis && startMillis < endMillis2 && endMillis <= endMillis2;
    }

    public boolean isAfter(ReadableInterval readableInterval) {
        return getStartMillis() >= (readableInterval == null ? DateTimeUtils.currentTimeMillis() : readableInterval.getEndMillis());
    }

    public boolean isBefore(ReadableInterval readableInterval) {
        return readableInterval == null ? isBeforeNow() : isBefore(readableInterval.getStartMillis());
    }
}
