package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.VersionInfo;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = am.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bw {
    public static bw createBy1stPartyData(SecureSignals secureSignals) {
        return new am(null, null, "", secureSignals.getSecureSignal(), Boolean.TRUE);
    }

    public static bw createBy3rdPartyData(VersionInfo versionInfo, VersionInfo versionInfo2, String str, String str2) {
        return createBy3rdPartyData(bx.create(versionInfo), bx.create(versionInfo2), str, str2);
    }

    public abstract bx adapterVersion();

    public abstract Boolean isPublisherCreated();

    public abstract String name();

    public abstract bx sdkVersion();

    public abstract String signals();

    public static bw createBy3rdPartyData(bx bxVar, bx bxVar2, String str, String str2) {
        return new am(bxVar, bxVar2, str, str2, Boolean.FALSE);
    }
}
