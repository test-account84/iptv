package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = aa.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bg {
    public static bg create(String str, String str2, boolean z, String str3, int i) {
        return new aa(str, str2, z, str3, i);
    }

    public abstract String appSetId();

    public abstract int appSetIdScope();

    public abstract String deviceId();

    public abstract String idType();

    public abstract boolean isLimitedAdTracking();
}
