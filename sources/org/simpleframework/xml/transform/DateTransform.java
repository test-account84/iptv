package org.simpleframework.xml.transform;

import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DateTransform implements Transform {
    private final DateFactory factory;

    public DateTransform(Class cls) throws Exception {
        this.factory = new DateFactory(cls);
    }

    public synchronized Date read(String str) throws Exception {
        return this.factory.getInstance(Long.valueOf(DateType.getDate(str).getTime()));
    }

    public synchronized String write(Date date) throws Exception {
        return DateType.getText(date);
    }
}
