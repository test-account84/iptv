package org.joda.time.convert;

import org.joda.time.Chronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LongConverter extends AbstractConverter implements InstantConverter, PartialConverter, DurationConverter {
    static final LongConverter INSTANCE = new LongConverter();

    public long getDurationMillis(Object obj) {
        return ((Long) obj).longValue();
    }

    public long getInstantMillis(Object obj, Chronology chronology) {
        return ((Long) obj).longValue();
    }

    public Class getSupportedType() {
        return Long.class;
    }
}
