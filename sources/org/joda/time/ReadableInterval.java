package org.joda.time;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ReadableInterval {
    boolean contains(ReadableInstant readableInstant);

    boolean contains(ReadableInterval readableInterval);

    boolean equals(Object obj);

    Chronology getChronology();

    DateTime getEnd();

    long getEndMillis();

    DateTime getStart();

    long getStartMillis();

    int hashCode();

    boolean isAfter(ReadableInstant readableInstant);

    boolean isAfter(ReadableInterval readableInterval);

    boolean isBefore(ReadableInstant readableInstant);

    boolean isBefore(ReadableInterval readableInterval);

    boolean overlaps(ReadableInterval readableInterval);

    Duration toDuration();

    long toDurationMillis();

    Interval toInterval();

    MutableInterval toMutableInterval();

    Period toPeriod();

    Period toPeriod(PeriodType periodType);

    String toString();
}
