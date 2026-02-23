package org.joda.time;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ReadableInstant extends Comparable {
    boolean equals(Object obj);

    int get(DateTimeFieldType dateTimeFieldType);

    Chronology getChronology();

    long getMillis();

    DateTimeZone getZone();

    int hashCode();

    boolean isAfter(ReadableInstant readableInstant);

    boolean isBefore(ReadableInstant readableInstant);

    boolean isEqual(ReadableInstant readableInstant);

    boolean isSupported(DateTimeFieldType dateTimeFieldType);

    Instant toInstant();

    String toString();
}
