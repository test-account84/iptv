package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.RemainderDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ISOChronology extends AssembledChronology {
    private static final ISOChronology INSTANCE_UTC;
    private static final ConcurrentHashMap cCache;
    private static final long serialVersionUID = -6212696554273812441L;

    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6212696554273812441L;
        private transient DateTimeZone iZone;

        public Stub(DateTimeZone dateTimeZone) {
            this.iZone = dateTimeZone;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iZone = (DateTimeZone) objectInputStream.readObject();
        }

        private Object readResolve() {
            return ISOChronology.getInstance(this.iZone);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iZone);
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        cCache = concurrentHashMap;
        ISOChronology iSOChronology = new ISOChronology(GregorianChronology.getInstanceUTC());
        INSTANCE_UTC = iSOChronology;
        concurrentHashMap.put(DateTimeZone.UTC, iSOChronology);
    }

    private ISOChronology(Chronology chronology) {
        super(chronology, null);
    }

    public static ISOChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static ISOChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object writeReplace() {
        return new Stub(getZone());
    }

    public void assemble(AssembledChronology.Fields fields) {
        if (getBase().getZone() == DateTimeZone.UTC) {
            DividedDateTimeField dividedDateTimeField = new DividedDateTimeField(ISOYearOfEraDateTimeField.INSTANCE, DateTimeFieldType.centuryOfEra(), 100);
            fields.centuryOfEra = dividedDateTimeField;
            fields.centuries = dividedDateTimeField.getDurationField();
            fields.yearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, DateTimeFieldType.yearOfCentury());
            fields.weekyearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, fields.weekyears, DateTimeFieldType.weekyearOfCentury());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ISOChronology) {
            return getZone().equals(((ISOChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return 800855 + getZone().hashCode();
    }

    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "ISOChronology";
        }
        return "ISOChronology[" + zone.getID() + ']';
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

    public static ISOChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = cCache;
        ISOChronology iSOChronology = (ISOChronology) concurrentHashMap.get(dateTimeZone);
        if (iSOChronology != null) {
            return iSOChronology;
        }
        ISOChronology iSOChronology2 = new ISOChronology(ZonedChronology.getInstance(INSTANCE_UTC, dateTimeZone));
        ISOChronology iSOChronology3 = (ISOChronology) concurrentHashMap.putIfAbsent(dateTimeZone, iSOChronology2);
        return iSOChronology3 != null ? iSOChronology3 : iSOChronology2;
    }
}
