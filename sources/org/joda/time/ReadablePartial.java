package org.joda.time;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ReadablePartial extends Comparable {
    boolean equals(Object obj);

    int get(DateTimeFieldType dateTimeFieldType);

    Chronology getChronology();

    DateTimeField getField(int i);

    DateTimeFieldType getFieldType(int i);

    int getValue(int i);

    int hashCode();

    boolean isSupported(DateTimeFieldType dateTimeFieldType);

    int size();

    DateTime toDateTime(ReadableInstant readableInstant);

    String toString();
}
