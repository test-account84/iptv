package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class r {
    public static final r c = new r(null, null);
    public final Long a;
    public final TimeZone b;

    public r(Long l, TimeZone timeZone) {
        this.a = l;
        this.b = timeZone;
    }

    public static r c() {
        return c;
    }

    public Calendar a() {
        return b(this.b);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
