package org.joda.time.field;

import org.joda.time.DateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class StrictDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = 3154803964207950910L;

    public StrictDateTimeField(DateTimeField dateTimeField) {
        super(dateTimeField);
    }

    public static DateTimeField getInstance(DateTimeField dateTimeField) {
        if (dateTimeField == null) {
            return null;
        }
        if (dateTimeField instanceof LenientDateTimeField) {
            dateTimeField = ((LenientDateTimeField) dateTimeField).getWrappedField();
        }
        return !dateTimeField.isLenient() ? dateTimeField : new StrictDateTimeField(dateTimeField);
    }

    public final boolean isLenient() {
        return false;
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds(this, i, getMinimumValue(j), getMaximumValue(j));
        return super.set(j, i);
    }
}
