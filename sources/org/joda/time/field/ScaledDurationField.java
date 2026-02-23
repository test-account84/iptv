package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ScaledDurationField extends DecoratedDurationField {
    private static final long serialVersionUID = -3205227092378684157L;
    private final int iScalar;

    public ScaledDurationField(DurationField durationField, DurationFieldType durationFieldType, int i) {
        super(durationField, durationFieldType);
        if (i == 0 || i == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.iScalar = i;
    }

    public long add(long j, int i) {
        return getWrappedField().add(j, i * this.iScalar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledDurationField)) {
            return false;
        }
        ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
        return getWrappedField().equals(scaledDurationField.getWrappedField()) && getType() == scaledDurationField.getType() && this.iScalar == scaledDurationField.iScalar;
    }

    public int getDifference(long j, long j2) {
        return getWrappedField().getDifference(j, j2) / this.iScalar;
    }

    public long getDifferenceAsLong(long j, long j2) {
        return getWrappedField().getDifferenceAsLong(j, j2) / this.iScalar;
    }

    public long getMillis(int i) {
        return getWrappedField().getMillis(i * this.iScalar);
    }

    public int getScalar() {
        return this.iScalar;
    }

    public long getUnitMillis() {
        return getWrappedField().getUnitMillis() * this.iScalar;
    }

    public int getValue(long j) {
        return getWrappedField().getValue(j) / this.iScalar;
    }

    public long getValueAsLong(long j) {
        return getWrappedField().getValueAsLong(j) / this.iScalar;
    }

    public int hashCode() {
        long j = this.iScalar;
        return ((int) (j ^ (j >>> 32))) + getType().hashCode() + getWrappedField().hashCode();
    }

    public long add(long j, long j2) {
        return getWrappedField().add(j, FieldUtils.safeMultiply(j2, this.iScalar));
    }

    public long getMillis(int i, long j) {
        return getWrappedField().getMillis(i * this.iScalar, j);
    }

    public int getValue(long j, long j2) {
        return getWrappedField().getValue(j, j2) / this.iScalar;
    }

    public long getValueAsLong(long j, long j2) {
        return getWrappedField().getValueAsLong(j, j2) / this.iScalar;
    }

    public long getMillis(long j) {
        return getWrappedField().getMillis(FieldUtils.safeMultiply(j, this.iScalar));
    }

    public long getMillis(long j, long j2) {
        return getWrappedField().getMillis(FieldUtils.safeMultiply(j, this.iScalar), j2);
    }
}
