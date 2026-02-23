package com.onesignal;

import com.onesignal.F1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class O0 implements P0 {
    public void a(String str) {
        F1.a(F1.v.WARN, str);
    }

    public void debug(String str) {
        F1.a(F1.v.DEBUG, str);
    }

    public void error(String str) {
        F1.a(F1.v.ERROR, str);
    }

    public void info(String str) {
        F1.a(F1.v.INFO, str);
    }

    public void verbose(String str) {
        F1.a(F1.v.VERBOSE, str);
    }

    public void error(String str, Throwable th) {
        F1.b(F1.v.ERROR, str, th);
    }
}
