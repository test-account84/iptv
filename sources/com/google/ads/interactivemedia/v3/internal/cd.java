package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cd {
    private static final boolean b = true;
    private static final Object a = new Object();
    private static final cc c = cc.a;

    public static void a(String str, String str2) {
        synchronized (a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        synchronized (a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        b(str, g(str2, th));
    }

    public static void d(String str, String str2) {
        synchronized (a) {
            Log.i(str, str2);
        }
    }

    public static void e(String str, String str2) {
        synchronized (a) {
            Log.w(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        e(str, g(str2, th));
    }

    private static String g(String str, Throwable th) {
        CharSequence replace;
        synchronized (a) {
            try {
                if (th != null) {
                    Throwable th2 = th;
                    while (true) {
                        if (th2 == null) {
                            replace = Log.getStackTraceString(th).trim().replace("\t", "    ");
                            break;
                        }
                        if (th2 instanceof UnknownHostException) {
                            replace = "UnknownHostException (no network)";
                            break;
                        }
                        th2 = th2.getCause();
                    }
                } else {
                    replace = null;
                }
            } finally {
            }
        }
        if (TextUtils.isEmpty(replace)) {
            return str;
        }
        return str + "\n  " + replace.replace("\n", "\n  ") + "\n";
    }
}
