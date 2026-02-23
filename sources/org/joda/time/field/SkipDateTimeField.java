package org.joda.time.field;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class SkipDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = -8869148464118507846L;
    private final Chronology iChronology;
    private transient int iMinValue;
    private final int iSkip;

    public SkipDateTimeField(Chronology chronology, DateTimeField dateTimeField) {
        this(chronology, dateTimeField, 0);
    }

    private Object readResolve() {
        return getType().getField(this.iChronology);
    }

    public int get(long j) {
        int i = super.get(j);
        return i <= this.iSkip ? i - 1 : i;
    }

    public int getMinimumValue() {
        return this.iMinValue;
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds(this, i, this.iMinValue, getMaximumValue());
        int i2 = this.iSkip;
        if (i <= i2) {
            if (i == i2) {
                throw new IllegalFieldValueException(DateTimeFieldType.year(), (Number) Integer.valueOf(i), (Number) null, (Number) null);
            }
            i++;
        }
        return super.set(j, i);
    }

    public SkipDateTimeField(Chronology chronology, DateTimeField dateTimeField, int i) {
        super(dateTimeField);
        this.iChronology = chronology;
        int minimumValue = super.getMinimumValue();
        if (minimumValue < i) {
            minimumValue--;
        } else if (minimumValue == i) {
            minimumValue = i + 1;
        }
        this.iMinValue = minimumValue;
        this.iSkip = i;
    }
}
