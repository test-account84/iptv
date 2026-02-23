package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class BaseDurationField extends DurationField implements Serializable {
    private static final long serialVersionUID = -2554245107589433218L;
    private final DurationFieldType iType;

    public BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.iType = durationFieldType;
    }

    public int getDifference(long j, long j2) {
        return FieldUtils.safeToInt(getDifferenceAsLong(j, j2));
    }

    public long getMillis(int i) {
        return i * getUnitMillis();
    }

    public final String getName() {
        return this.iType.getName();
    }

    public final DurationFieldType getType() {
        return this.iType;
    }

    public int getValue(long j) {
        return FieldUtils.safeToInt(getValueAsLong(j));
    }

    public long getValueAsLong(long j) {
        return j / getUnitMillis();
    }

    public final boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[" + getName() + ']';
    }

    public int compareTo(DurationField durationField) {
        long unitMillis = durationField.getUnitMillis();
        long unitMillis2 = getUnitMillis();
        if (unitMillis2 == unitMillis) {
            return 0;
        }
        return unitMillis2 < unitMillis ? -1 : 1;
    }

    public long getMillis(long j) {
        return FieldUtils.safeMultiply(j, getUnitMillis());
    }

    public int getValue(long j, long j2) {
        return FieldUtils.safeToInt(getValueAsLong(j, j2));
    }
}
