package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class MillisDurationField extends DurationField implements Serializable {
    public static final DurationField INSTANCE = new MillisDurationField();
    private static final long serialVersionUID = 2656707858124633367L;

    private MillisDurationField() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long add(long j, int i) {
        return FieldUtils.safeAdd(j, i);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MillisDurationField) && getUnitMillis() == ((MillisDurationField) obj).getUnitMillis();
    }

    public int getDifference(long j, long j2) {
        return FieldUtils.safeToInt(FieldUtils.safeSubtract(j, j2));
    }

    public long getDifferenceAsLong(long j, long j2) {
        return FieldUtils.safeSubtract(j, j2);
    }

    public long getMillis(int i) {
        return i;
    }

    public String getName() {
        return "millis";
    }

    public DurationFieldType getType() {
        return DurationFieldType.millis();
    }

    public final long getUnitMillis() {
        return 1L;
    }

    public int getValue(long j) {
        return FieldUtils.safeToInt(j);
    }

    public long getValueAsLong(long j) {
        return j;
    }

    public int hashCode() {
        return (int) getUnitMillis();
    }

    public final boolean isPrecise() {
        return true;
    }

    public boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[millis]";
    }

    public long add(long j, long j2) {
        return FieldUtils.safeAdd(j, j2);
    }

    public int compareTo(DurationField durationField) {
        long unitMillis = durationField.getUnitMillis();
        long unitMillis2 = getUnitMillis();
        if (unitMillis2 == unitMillis) {
            return 0;
        }
        return unitMillis2 < unitMillis ? -1 : 1;
    }

    public long getMillis(int i, long j) {
        return i;
    }

    public int getValue(long j, long j2) {
        return FieldUtils.safeToInt(j);
    }

    public long getValueAsLong(long j, long j2) {
        return j;
    }

    public long getMillis(long j) {
        return j;
    }

    public long getMillis(long j, long j2) {
        return j;
    }
}
