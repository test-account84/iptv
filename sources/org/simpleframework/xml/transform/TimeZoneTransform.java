package org.simpleframework.xml.transform;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class TimeZoneTransform implements Transform {
    public TimeZone read(String str) {
        return DesugarTimeZone.getTimeZone(str);
    }

    public String write(TimeZone timeZone) {
        return timeZone.getID();
    }
}
