package org.joda.time;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ReadablePeriod {
    boolean equals(Object obj);

    int get(DurationFieldType durationFieldType);

    DurationFieldType getFieldType(int i);

    PeriodType getPeriodType();

    int getValue(int i);

    int hashCode();

    boolean isSupported(DurationFieldType durationFieldType);

    int size();

    MutablePeriod toMutablePeriod();

    Period toPeriod();

    String toString();
}
