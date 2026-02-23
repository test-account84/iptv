package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadWritableInterval;
import org.joda.time.ReadWritablePeriod;
import org.joda.time.ReadablePeriod;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class NullConverter extends AbstractConverter implements InstantConverter, PartialConverter, DurationConverter, PeriodConverter, IntervalConverter {
    static final NullConverter INSTANCE = new NullConverter();

    public long getDurationMillis(Object obj) {
        return 0L;
    }

    public Class getSupportedType() {
        return null;
    }

    public void setInto(ReadWritableInterval readWritableInterval, Object obj, Chronology chronology) {
        readWritableInterval.setChronology(chronology);
        long currentTimeMillis = DateTimeUtils.currentTimeMillis();
        readWritableInterval.setInterval(currentTimeMillis, currentTimeMillis);
    }

    public void setInto(ReadWritablePeriod readWritablePeriod, Object obj, Chronology chronology) {
        readWritablePeriod.setPeriod((ReadablePeriod) null);
    }
}
