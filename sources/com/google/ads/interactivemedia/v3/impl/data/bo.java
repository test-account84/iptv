package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = ac.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bo {
    public static bo create(String str, String str2) {
        return new ac(str, str2);
    }

    public abstract String message();

    public abstract String name();

    public static bo create(Throwable th) {
        return new ac(th.getClass().getName(), th.getMessage());
    }
}
