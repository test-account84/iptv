package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class v {
    public static AtomicReference a = new AtomicReference();

    public static long a(long j) {
        Calendar k = k();
        k.setTimeInMillis(j);
        return d(k).getTimeInMillis();
    }

    public static DateFormat b(Locale locale) {
        return c("MMMEd", locale);
    }

    public static DateFormat c(String str, Locale locale) {
        DateFormat a2 = s.a(str, locale);
        t.a(a2, j());
        return a2;
    }

    public static Calendar d(Calendar calendar) {
        Calendar l = l(calendar);
        Calendar k = k();
        k.set(l.get(1), l.get(2), l.get(5));
        return k;
    }

    public static java.text.DateFormat e(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(h());
        return dateInstance;
    }

    public static java.text.DateFormat f(Locale locale) {
        return e(0, locale);
    }

    public static r g() {
        r rVar = (r) a.get();
        return rVar == null ? r.c() : rVar;
    }

    public static TimeZone h() {
        return DesugarTimeZone.getTimeZone("UTC");
    }

    public static Calendar i() {
        Calendar a2 = g().a();
        a2.set(11, 0);
        a2.set(12, 0);
        a2.set(13, 0);
        a2.set(14, 0);
        a2.setTimeZone(h());
        return a2;
    }

    public static android.icu.util.TimeZone j() {
        return u.a("UTC");
    }

    public static Calendar k() {
        return l(null);
    }

    public static Calendar l(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(h());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    public static DateFormat m(Locale locale) {
        return c("yMMMEd", locale);
    }
}
