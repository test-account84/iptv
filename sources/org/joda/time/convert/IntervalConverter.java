package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.ReadWritableInterval;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface IntervalConverter extends Converter {
    boolean isReadableInterval(Object obj, Chronology chronology);

    void setInto(ReadWritableInterval readWritableInterval, Object obj, Chronology chronology);
}
