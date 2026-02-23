package org.joda.time.tz;

import java.util.Set;
import org.joda.time.DateTimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Provider {
    Set getAvailableIDs();

    DateTimeZone getZone(String str);
}
