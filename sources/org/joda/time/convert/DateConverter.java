package org.joda.time.convert;

import java.util.Date;
import org.joda.time.Chronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class DateConverter extends AbstractConverter implements InstantConverter, PartialConverter {
    static final DateConverter INSTANCE = new DateConverter();

    public long getInstantMillis(Object obj, Chronology chronology) {
        return ((Date) obj).getTime();
    }

    public Class getSupportedType() {
        return Date.class;
    }
}
