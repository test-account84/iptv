package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.VersionInfo;
import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = an.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bx {
    public static bx create(int i, int i2, int i3) {
        return new an(i, i2, i3);
    }

    public abstract int major();

    public abstract int micro();

    public abstract int minor();

    public static bx create(VersionInfo versionInfo) {
        return create(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }
}
