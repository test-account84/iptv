package org.joda.time.base;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.joda.convert.ToString;
import org.joda.time.DateTimeFieldType;
import org.joda.time.ReadableDateTime;
import org.joda.time.format.DateTimeFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class AbstractDateTime extends AbstractInstant implements ReadableDateTime {
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public int getCenturyOfEra() {
        return getChronology().centuryOfEra().get(getMillis());
    }

    public int getDayOfMonth() {
        return getChronology().dayOfMonth().get(getMillis());
    }

    public int getDayOfWeek() {
        return getChronology().dayOfWeek().get(getMillis());
    }

    public int getDayOfYear() {
        return getChronology().dayOfYear().get(getMillis());
    }

    public int getEra() {
        return getChronology().era().get(getMillis());
    }

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getMillis());
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getMillis());
    }

    public int getMinuteOfDay() {
        return getChronology().minuteOfDay().get(getMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getMillis());
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getMillis());
    }

    public int getSecondOfDay() {
        return getChronology().secondOfDay().get(getMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getMillis());
    }

    public int getWeekOfWeekyear() {
        return getChronology().weekOfWeekyear().get(getMillis());
    }

    public int getWeekyear() {
        return getChronology().weekyear().get(getMillis());
    }

    public int getYear() {
        return getChronology().year().get(getMillis());
    }

    public int getYearOfCentury() {
        return getChronology().yearOfCentury().get(getMillis());
    }

    public int getYearOfEra() {
        return getChronology().yearOfEra().get(getMillis());
    }

    public Calendar toCalendar(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Calendar calendar = Calendar.getInstance(getZone().toTimeZone(), locale);
        calendar.setTime(toDate());
        return calendar;
    }

    public GregorianCalendar toGregorianCalendar() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(getZone().toTimeZone());
        gregorianCalendar.setTime(toDate());
        return gregorianCalendar;
    }

    @ToString
    public String toString() {
        return super.toString();
    }

    public String toString(String str) {
        return str == null ? toString() : DateTimeFormat.forPattern(str).print(this);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        return str == null ? toString() : DateTimeFormat.forPattern(str).withLocale(locale).print(this);
    }
}
