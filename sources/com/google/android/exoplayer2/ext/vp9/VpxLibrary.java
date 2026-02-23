package com.google.android.exoplayer2.ext.vp9;

import O2.w0;
import d4.x;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class VpxLibrary {
    public static final x a;
    public static int b;

    public class a extends x {
        public a(String... strArr) {
            super(strArr);
        }

        public void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        w0.a("goog.exo.vpx");
        a = new a("vpx", "vpxV2JNI");
        b = 1;
    }

    public static String a() {
        if (b()) {
            return vpxGetVersion();
        }
        return null;
    }

    public static boolean b() {
        return a.a();
    }

    public static boolean c(int i) {
        if (i != 0) {
            return i != 1 && i == b;
        }
        return true;
    }

    private static native String vpxGetVersion();

    public static native boolean vpxIsSecureDecodeSupported();
}
