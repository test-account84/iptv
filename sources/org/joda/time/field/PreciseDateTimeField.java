package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PreciseDateTimeField extends PreciseDurationDateTimeField {
    private static final long serialVersionUID = -5586801265774496376L;
    private final int iRange;
    private final DurationField iRangeField;

    public PreciseDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField, DurationField durationField2) {
        super(dateTimeFieldType, durationField);
        if (!durationField2.isPrecise()) {
            throw new IllegalArgumentException("Range duration field must be precise");
        }
        int unitMillis = (int) (durationField2.getUnitMillis() / getUnitMillis());
        this.iRange = unitMillis;
        if (unitMillis < 2) {
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        this.iRangeField = durationField2;
    }

    public long addWrapField(long j, int i) {
        int i2 = get(j);
        return j + ((FieldUtils.getWrappedValue(i2, i, getMinimumValue(), getMaximumValue()) - i2) * getUnitMillis());
    }

    public int get(long j) {
        return j >= 0 ? (int) ((j / getUnitMillis()) % this.iRange) : (this.iRange - 1) + ((int) (((j + 1) / getUnitMillis()) % this.iRange));
    }

    public int getMaximumValue() {
        return this.iRange - 1;
    }

    public int getRange() {
        return this.iRange;
    }

    public DurationField getRangeDurationField() {
        return this.iRangeField;
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds(this, i, getMinimumValue(), getMaximumValue());
        return j + ((i - get(j)) * this.iUnitMillis);
    }
}
