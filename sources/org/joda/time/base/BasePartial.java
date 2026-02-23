package org.joda.time.base;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadablePartial;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class BasePartial extends AbstractPartial implements ReadablePartial, Serializable {
    private static final long serialVersionUID = 2353678632973660L;
    private final Chronology iChronology;
    private final int[] iValues;

    public BasePartial() {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) null);
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public int getValue(int i) {
        return this.iValues[i];
    }

    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public void setValue(int i, int i2) {
        int[] iArr = getField(i).set(this, i, this.iValues, i2);
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public void setValues(int[] iArr) {
        getChronology().validate(this, iArr);
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public String toString(String str) {
        return str == null ? toString() : DateTimeFormat.forPattern(str).print(this);
    }

    public BasePartial(long j) {
        this(j, (Chronology) null);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        return str == null ? toString() : DateTimeFormat.forPattern(str).withLocale(locale).print(this);
    }

    public BasePartial(long j, Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iChronology = chronology2.withUTC();
        this.iValues = chronology2.get(this, j);
    }

    public BasePartial(Object obj, Chronology chronology) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology2 = DateTimeUtils.getChronology(partialConverter.getChronology(obj, chronology));
        this.iChronology = chronology2.withUTC();
        this.iValues = partialConverter.getPartialValues(this, obj, chronology2);
    }

    public BasePartial(Object obj, Chronology chronology, DateTimeFormatter dateTimeFormatter) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology2 = DateTimeUtils.getChronology(partialConverter.getChronology(obj, chronology));
        this.iChronology = chronology2.withUTC();
        this.iValues = partialConverter.getPartialValues(this, obj, chronology2, dateTimeFormatter);
    }

    public BasePartial(Chronology chronology) {
        this(DateTimeUtils.currentTimeMillis(), chronology);
    }

    public BasePartial(BasePartial basePartial, Chronology chronology) {
        this.iChronology = chronology.withUTC();
        this.iValues = basePartial.iValues;
    }

    public BasePartial(BasePartial basePartial, int[] iArr) {
        this.iChronology = basePartial.iChronology;
        this.iValues = iArr;
    }

    public BasePartial(int[] iArr, Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iChronology = chronology2.withUTC();
        chronology2.validate(this, iArr);
        this.iValues = iArr;
    }
}
