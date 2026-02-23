package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = ae.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class br {
    public static final String UNKNOWN_CONTENT_TYPE = "unknown";

    private static br create(String str, String str2, String str3, int i) {
        return new ae(str, str2, str3, i);
    }

    public static br forError(String str, int i) {
        return create(str, "", "unknown", i);
    }

    public static br forResponse(String str, String str2) {
        return forResponse(str, str2, "unknown");
    }

    public abstract String content();

    public abstract String contentType();

    public abstract int errorCode();

    public abstract String id();

    public static br forResponse(String str, String str2, String str3) {
        return create(str, str2, str3, 0);
    }
}
