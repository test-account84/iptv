package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.ReadableDuration;
import org.joda.time.format.FormatUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class AbstractDuration implements ReadableDuration {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReadableDuration) && getMillis() == ((ReadableDuration) obj).getMillis();
    }

    public int hashCode() {
        long millis = getMillis();
        return (int) (millis ^ (millis >>> 32));
    }

    public boolean isEqual(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            readableDuration = Duration.ZERO;
        }
        return compareTo(readableDuration) == 0;
    }

    public boolean isLongerThan(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            readableDuration = Duration.ZERO;
        }
        return compareTo(readableDuration) > 0;
    }

    public boolean isShorterThan(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            readableDuration = Duration.ZERO;
        }
        return compareTo(readableDuration) < 0;
    }

    public Duration toDuration() {
        return new Duration(getMillis());
    }

    public Period toPeriod() {
        return new Period(getMillis());
    }

    @ToString
    public String toString() {
        long millis = getMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PT");
        boolean z = millis < 0;
        FormatUtils.appendUnpaddedInteger(stringBuffer, millis);
        while (true) {
            int i = 3;
            if (stringBuffer.length() >= (z ? 7 : 6)) {
                break;
            }
            if (!z) {
                i = 2;
            }
            stringBuffer.insert(i, "0");
        }
        long j = (millis / 1000) * 1000;
        int length = stringBuffer.length() - 3;
        if (j == millis) {
            stringBuffer.setLength(length);
        } else {
            stringBuffer.insert(length, ".");
        }
        stringBuffer.append('S');
        return stringBuffer.toString();
    }

    public int compareTo(ReadableDuration readableDuration) {
        long millis = getMillis();
        long millis2 = readableDuration.getMillis();
        if (millis < millis2) {
            return -1;
        }
        return millis > millis2 ? 1 : 0;
    }
}
