package org.joda.time.tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class UTCProvider implements Provider {
    private static final Set AVAILABLE_IDS = Collections.singleton("UTC");

    public Set getAvailableIDs() {
        return AVAILABLE_IDS;
    }

    public DateTimeZone getZone(String str) {
        if ("UTC".equalsIgnoreCase(str)) {
            return DateTimeZone.UTC;
        }
        return null;
    }
}
