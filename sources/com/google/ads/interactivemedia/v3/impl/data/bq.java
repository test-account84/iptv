package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = ad.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bq {
    public static bq create(bp bpVar, String str, String str2, String str3, String str4, int i, int i2) {
        return new ad(bpVar, str, str2, str4, str3, i, i2);
    }

    public abstract int connectionTimeoutMs();

    public abstract String content();

    public abstract String id();

    public abstract int readTimeoutMs();

    public abstract bp requestType();

    public abstract String url();

    public abstract String userAgent();
}
