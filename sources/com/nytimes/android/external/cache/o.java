package com.nytimes.android.external.cache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class o {
    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static void c(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void d(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
