package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class BasicYearDateTimeField extends ImpreciseDateTimeField {
    private static final long serialVersionUID = -98628754872287L;
    protected final BasicChronology iChronology;

    public BasicYearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.year(), basicChronology.getAverageMillisPerYear());
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.year();
    }

    public long add(long j, int i) {
        return i == 0 ? j : set(j, FieldUtils.safeAdd(get(j), i));
    }

    public long addWrapField(long j, int i) {
        return i == 0 ? j : set(j, FieldUtils.getWrappedValue(this.iChronology.getYear(j), i, this.iChronology.getMinYear(), this.iChronology.getMaxYear()));
    }

    public int get(long j) {
        return this.iChronology.getYear(j);
    }

    public long getDifferenceAsLong(long j, long j2) {
        return j < j2 ? -this.iChronology.getYearDifference(j2, j) : this.iChronology.getYearDifference(j, j2);
    }

    public int getLeapAmount(long j) {
        return this.iChronology.isLeapYear(get(j)) ? 1 : 0;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.days();
    }

    public int getMaximumValue() {
        return this.iChronology.getMaxYear();
    }

    public int getMinimumValue() {
        return this.iChronology.getMinYear();
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j) {
        return this.iChronology.isLeapYear(get(j));
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    public long roundCeiling(long j) {
        int i = get(j);
        return j != this.iChronology.getYearMillis(i) ? this.iChronology.getYearMillis(i + 1) : j;
    }

    public long roundFloor(long j) {
        return this.iChronology.getYearMillis(get(j));
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds(this, i, this.iChronology.getMinYear(), this.iChronology.getMaxYear());
        return this.iChronology.setYear(j, i);
    }

    public long add(long j, long j2) {
        return add(j, FieldUtils.safeToInt(j2));
    }
}
