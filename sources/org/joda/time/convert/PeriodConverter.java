package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.PeriodType;
import org.joda.time.ReadWritablePeriod;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface PeriodConverter extends Converter {
    PeriodType getPeriodType(Object obj);

    void setInto(ReadWritablePeriod readWritablePeriod, Object obj, Chronology chronology);
}
