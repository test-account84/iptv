package org.joda.time.chrono;

import org.joda.time.Chronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class BasicFixedMonthChronology extends BasicChronology {
    static final long MILLIS_PER_MONTH = 2592000000L;
    static final long MILLIS_PER_YEAR = 31557600000L;
    static final int MONTH_LENGTH = 30;
    private static final long serialVersionUID = 261387371998L;

    public BasicFixedMonthChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    public long getAverageMillisPerMonth() {
        return 2592000000L;
    }

    public long getAverageMillisPerYear() {
        return 31557600000L;
    }

    public long getAverageMillisPerYearDividedByTwo() {
        return 15778800000L;
    }

    public int getDayOfMonth(long j) {
        return ((getDayOfYear(j) - 1) % 30) + 1;
    }

    public int getDaysInMonthMax() {
        return 30;
    }

    public int getDaysInYearMonth(int i, int i2) {
        if (i2 != 13) {
            return 30;
        }
        return isLeapYear(i) ? 6 : 5;
    }

    public int getMaxMonth() {
        return 13;
    }

    public int getMonthOfYear(long j) {
        return ((getDayOfYear(j) - 1) / 30) + 1;
    }

    public long getTotalMillisByYearMonth(int i, int i2) {
        return (i2 - 1) * 2592000000L;
    }

    public long getYearDifference(long j, long j2) {
        int year = getYear(j);
        int year2 = getYear(j2);
        long yearMillis = j - getYearMillis(year);
        int i = year - year2;
        if (yearMillis < j2 - getYearMillis(year2)) {
            i--;
        }
        return i;
    }

    public boolean isLeapYear(int i) {
        return (i & 3) == 3;
    }

    public long setYear(long j, int i) {
        int dayOfYear = getDayOfYear(j, getYear(j));
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 365 && !isLeapYear(i)) {
            dayOfYear--;
        }
        return getYearMonthDayMillis(i, 1, dayOfYear) + millisOfDay;
    }

    public int getDaysInMonthMax(int i) {
        return i != 13 ? 30 : 6;
    }

    public int getMonthOfYear(long j, int i) {
        return ((int) ((j - getYearMillis(i)) / 2592000000L)) + 1;
    }
}
