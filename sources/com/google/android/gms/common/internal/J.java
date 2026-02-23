package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j {
    public final String a;
    public final String b;

    public j(String str) {
        this(str, null);
    }

    public boolean a(int i) {
        return Log.isLoggable(this.a, i);
    }

    public void b(String str, String str2) {
        if (a(3)) {
            Log.d(str, f(str2));
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, f(str2), th);
        }
    }

    public void d(String str, String str2) {
        if (a(2)) {
            Log.v(str, f(str2));
        }
    }

    public void e(String str, String str2) {
        if (a(5)) {
            Log.w(str, f(str2));
        }
    }

    public final String f(String str) {
        String str2 = this.b;
        return str2 == null ? str : str2.concat(str);
    }

    public j(String str, String str2) {
        r.n(str, "log tag cannot be null");
        r.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        this.b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
