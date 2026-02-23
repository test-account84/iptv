package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class BuddhistChronology extends AssembledChronology {
    public static final int BE = 1;
    private static final int BUDDHIST_OFFSET = 543;
    private static final long serialVersionUID = -3474595157769370126L;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("BE");
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final BuddhistChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    private BuddhistChronology(Chronology chronology, Object obj) {
        super(chronology, obj);
    }

    public static BuddhistChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static BuddhistChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public void assemble(AssembledChronology.Fields fields) {
        if (getParam() == null) {
            fields.eras = UnsupportedDurationField.getInstance(DurationFieldType.eras());
            OffsetDateTimeField offsetDateTimeField = new OffsetDateTimeField(new SkipUndoDateTimeField(this, fields.year), 543);
            fields.year = offsetDateTimeField;
            fields.yearOfEra = new DelegatedDateTimeField(offsetDateTimeField, fields.eras, DateTimeFieldType.yearOfEra());
            fields.weekyear = new OffsetDateTimeField(new SkipUndoDateTimeField(this, fields.weekyear), 543);
            DividedDateTimeField dividedDateTimeField = new DividedDateTimeField(new OffsetDateTimeField(fields.yearOfEra, 99), fields.eras, DateTimeFieldType.centuryOfEra(), 100);
            fields.centuryOfEra = dividedDateTimeField;
            fields.centuries = dividedDateTimeField.getDurationField();
            fields.yearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra), DateTimeFieldType.yearOfCentury(), 1);
            fields.weekyearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField(fields.weekyear, fields.centuries, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
            fields.era = ERA_FIELD;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuddhistChronology) {
            return getZone().equals(((BuddhistChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return 499287079 + getZone().hashCode();
    }

    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "BuddhistChronology";
        }
        return "BuddhistChronology[" + zone.getID() + ']';
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static BuddhistChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        BuddhistChronology buddhistChronology = (BuddhistChronology) concurrentHashMap.get(dateTimeZone);
        if (buddhistChronology != null) {
            return buddhistChronology;
        }
        BuddhistChronology buddhistChronology2 = new BuddhistChronology(GJChronology.getInstance(dateTimeZone, null), null);
        BuddhistChronology buddhistChronology3 = new BuddhistChronology(LimitChronology.getInstance(buddhistChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, buddhistChronology2), null), "");
        BuddhistChronology buddhistChronology4 = (BuddhistChronology) concurrentHashMap.putIfAbsent(dateTimeZone, buddhistChronology3);
        return buddhistChronology4 != null ? buddhistChronology4 : buddhistChronology3;
    }
}
