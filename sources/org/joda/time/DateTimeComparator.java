package org.joda.time;

import java.io.Serializable;
import java.util.Comparator;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DateTimeComparator implements Comparator, Serializable {
    private static final DateTimeComparator ALL_INSTANCE = new DateTimeComparator(null, null);
    private static final DateTimeComparator DATE_INSTANCE = new DateTimeComparator(DateTimeFieldType.dayOfYear(), null);
    private static final DateTimeComparator TIME_INSTANCE = new DateTimeComparator(null, DateTimeFieldType.dayOfYear());
    private static final long serialVersionUID = -6097339773320178364L;
    private final DateTimeFieldType iLowerLimit;
    private final DateTimeFieldType iUpperLimit;

    public DateTimeComparator(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        this.iLowerLimit = dateTimeFieldType;
        this.iUpperLimit = dateTimeFieldType2;
    }

    public static DateTimeComparator getDateOnlyInstance() {
        return DATE_INSTANCE;
    }

    public static DateTimeComparator getInstance() {
        return ALL_INSTANCE;
    }

    public static DateTimeComparator getTimeOnlyInstance() {
        return TIME_INSTANCE;
    }

    private Object readResolve() {
        return getInstance(this.iLowerLimit, this.iUpperLimit);
    }

    public int compare(Object obj, Object obj2) {
        InstantConverter instantConverter = ConverterManager.getInstance().getInstantConverter(obj);
        Chronology chronology = instantConverter.getChronology(obj, (Chronology) null);
        long instantMillis = instantConverter.getInstantMillis(obj, chronology);
        InstantConverter instantConverter2 = ConverterManager.getInstance().getInstantConverter(obj2);
        Chronology chronology2 = instantConverter2.getChronology(obj2, (Chronology) null);
        long instantMillis2 = instantConverter2.getInstantMillis(obj2, chronology2);
        DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
        if (dateTimeFieldType != null) {
            instantMillis = dateTimeFieldType.getField(chronology).roundFloor(instantMillis);
            instantMillis2 = this.iLowerLimit.getField(chronology2).roundFloor(instantMillis2);
        }
        DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
        if (dateTimeFieldType2 != null) {
            instantMillis = dateTimeFieldType2.getField(chronology).remainder(instantMillis);
            instantMillis2 = this.iUpperLimit.getField(chronology2).remainder(instantMillis2);
        }
        if (instantMillis < instantMillis2) {
            return -1;
        }
        return instantMillis > instantMillis2 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        DateTimeFieldType dateTimeFieldType;
        DateTimeFieldType dateTimeFieldType2;
        if (!(obj instanceof DateTimeComparator)) {
            return false;
        }
        DateTimeComparator dateTimeComparator = (DateTimeComparator) obj;
        if (this.iLowerLimit == dateTimeComparator.getLowerLimit() || ((dateTimeFieldType2 = this.iLowerLimit) != null && dateTimeFieldType2.equals(dateTimeComparator.getLowerLimit()))) {
            return this.iUpperLimit == dateTimeComparator.getUpperLimit() || ((dateTimeFieldType = this.iUpperLimit) != null && dateTimeFieldType.equals(dateTimeComparator.getUpperLimit()));
        }
        return false;
    }

    public DateTimeFieldType getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTimeFieldType getUpperLimit() {
        return this.iUpperLimit;
    }

    public int hashCode() {
        DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
        int hashCode = dateTimeFieldType == null ? 0 : dateTimeFieldType.hashCode();
        DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
        return hashCode + ((dateTimeFieldType2 != null ? dateTimeFieldType2.hashCode() : 0) * 123);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0019 A[PHI: r0 r1
      0x0019: PHI (r0v4 java.lang.StringBuilder) = (r0v1 java.lang.StringBuilder), (r0v5 java.lang.StringBuilder) binds: [B:13:0x0044, B:4:0x0016] A[DONT_GENERATE, DONT_INLINE]
      0x0019: PHI (r1v7 org.joda.time.DateTimeFieldType) = (r1v5 org.joda.time.DateTimeFieldType), (r1v8 org.joda.time.DateTimeFieldType) binds: [B:13:0x0044, B:4:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r5 = this;
            org.joda.time.DateTimeFieldType r0 = r5.iLowerLimit
            org.joda.time.DateTimeFieldType r1 = r5.iUpperLimit
            java.lang.String r2 = "]"
            java.lang.String r3 = "DateTimeComparator["
            java.lang.String r4 = ""
            if (r0 != r1) goto L28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            org.joda.time.DateTimeFieldType r1 = r5.iLowerLimit
            if (r1 != 0) goto L19
            goto L1d
        L19:
            java.lang.String r4 = r1.getName()
        L1d:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        L28:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            org.joda.time.DateTimeFieldType r1 = r5.iLowerLimit
            if (r1 != 0) goto L36
            r1 = r4
            goto L3a
        L36:
            java.lang.String r1 = r1.getName()
        L3a:
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            org.joda.time.DateTimeFieldType r1 = r5.iUpperLimit
            if (r1 != 0) goto L19
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeComparator.toString():java.lang.String");
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType) {
        return getInstance(dateTimeFieldType, null);
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        return (dateTimeFieldType == null && dateTimeFieldType2 == null) ? ALL_INSTANCE : (dateTimeFieldType == DateTimeFieldType.dayOfYear() && dateTimeFieldType2 == null) ? DATE_INSTANCE : (dateTimeFieldType == null && dateTimeFieldType2 == DateTimeFieldType.dayOfYear()) ? TIME_INSTANCE : new DateTimeComparator(dateTimeFieldType, dateTimeFieldType2);
    }
}
