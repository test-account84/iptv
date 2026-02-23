package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RemainderDateTimeField extends DecoratedDateTimeField {
    private static final long serialVersionUID = 5708241235177666790L;
    final int iDivisor;
    final DurationField iDurationField;
    final DurationField iRangeField;

    public RemainderDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i) {
        super(dateTimeField, dateTimeFieldType);
        if (i < 2) {
            throw new IllegalArgumentException("The divisor must be at least 2");
        }
        DurationField durationField = dateTimeField.getDurationField();
        if (durationField == null) {
            this.iRangeField = null;
        } else {
            this.iRangeField = new ScaledDurationField(durationField, dateTimeFieldType.getRangeDurationType(), i);
        }
        this.iDurationField = dateTimeField.getDurationField();
        this.iDivisor = i;
    }

    private int getDivided(int i) {
        return i >= 0 ? i / this.iDivisor : ((i + 1) / this.iDivisor) - 1;
    }

    public long addWrapField(long j, int i) {
        return set(j, FieldUtils.getWrappedValue(get(j), i, 0, this.iDivisor - 1));
    }

    public int get(long j) {
        int i = getWrappedField().get(j);
        int i2 = this.iDivisor;
        return i >= 0 ? i % i2 : (i2 - 1) + ((i + 1) % i2);
    }

    public int getDivisor() {
        return this.iDivisor;
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public int getMaximumValue() {
        return this.iDivisor - 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return this.iRangeField;
    }

    public long remainder(long j) {
        return getWrappedField().remainder(j);
    }

    public long roundCeiling(long j) {
        return getWrappedField().roundCeiling(j);
    }

    public long roundFloor(long j) {
        return getWrappedField().roundFloor(j);
    }

    public long roundHalfCeiling(long j) {
        return getWrappedField().roundHalfCeiling(j);
    }

    public long roundHalfEven(long j) {
        return getWrappedField().roundHalfEven(j);
    }

    public long roundHalfFloor(long j) {
        return getWrappedField().roundHalfFloor(j);
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds(this, i, 0, this.iDivisor - 1);
        return getWrappedField().set(j, (getDivided(getWrappedField().get(j)) * this.iDivisor) + i);
    }

    public RemainderDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i) {
        super(dateTimeField, dateTimeFieldType);
        if (i < 2) {
            throw new IllegalArgumentException("The divisor must be at least 2");
        }
        this.iRangeField = durationField;
        this.iDurationField = dateTimeField.getDurationField();
        this.iDivisor = i;
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField) {
        this(dividedDateTimeField, dividedDateTimeField.getType());
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField, DateTimeFieldType dateTimeFieldType) {
        this(dividedDateTimeField, dividedDateTimeField.getWrappedField().getDurationField(), dateTimeFieldType);
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        super(dividedDateTimeField.getWrappedField(), dateTimeFieldType);
        this.iDivisor = dividedDateTimeField.iDivisor;
        this.iDurationField = durationField;
        this.iRangeField = dividedDateTimeField.iDurationField;
    }
}
