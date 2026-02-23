package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class GregorianCalendarTransform implements Transform {
    private final DateTransform transform;

    public GregorianCalendarTransform() throws Exception {
        this(Date.class);
    }

    public GregorianCalendarTransform(Class cls) throws Exception {
        this.transform = new DateTransform(cls);
    }

    public GregorianCalendar read(String str) throws Exception {
        return read(this.transform.read(str));
    }

    public String write(GregorianCalendar gregorianCalendar) throws Exception {
        return this.transform.write(gregorianCalendar.getTime());
    }

    private GregorianCalendar read(Date date) throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (date != null) {
            gregorianCalendar.setTime(date);
        }
        return gregorianCalendar;
    }
}
