package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface InstantConverter extends Converter {
    Chronology getChronology(Object obj, Chronology chronology);

    Chronology getChronology(Object obj, DateTimeZone dateTimeZone);

    long getInstantMillis(Object obj, Chronology chronology);
}
