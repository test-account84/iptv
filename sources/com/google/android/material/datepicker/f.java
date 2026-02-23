package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static String a(long j) {
        return b(j, Locale.getDefault());
    }

    public static String b(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? e.a(v.b(locale), new Date(j)) : v.f(locale).format(new Date(j));
    }

    public static String c(long j) {
        return DateUtils.formatDateTime((Context) null, j, 8228);
    }

    public static String d(long j) {
        return e(j, Locale.getDefault());
    }

    public static String e(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? e.a(v.m(locale), new Date(j)) : v.f(locale).format(new Date(j));
    }
}
